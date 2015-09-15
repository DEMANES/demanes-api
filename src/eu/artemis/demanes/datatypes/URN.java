package eu.artemis.demanes.datatypes;

/**
 * Copyright (c) 2012-2013, JCabi.com
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met: 1) Redistributions of source code must retain the above
 * copyright notice, this list of conditions and the following
 * disclaimer. 2) Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following
 * disclaimer in the documentation and/or other materials provided
 * with the distribution. 3) Neither the name of the jcabi.com nor
 * the names of its contributors may be used to endorse or promote
 * products derived from this software without specific prior written
 * permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT
 * NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 * FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL
 * THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT,
 * INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT,
 * STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED
 * OF THE POSSIBILITY OF SUCH DAMAGE.
 */

import java.io.Serializable;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.util.Map;
import java.util.TreeMap;

/**
 * Uniform Resource Name (URN) as in <a
 * href="http://tools.ietf.org/html/rfc2141">RFC 2141</a>.
 * 
 * <p>
 * Usage is similar to {@link java.net.URI} or {@link java.net.URL}:
 * 
 * <pre>
 * URN urn = new URN(&quot;urn:foo:A123,456&quot;);
 * assert urn.nid().equals(&quot;foo&quot;);
 * assert urn.nss().equals(&quot;A123,456&quot;);
 * </pre>
 * 
 * <p>
 * <b>NOTICE:</b> the implementation is not fully compliant with RFC 2141. It
 * will become compliant in one of our future versions. Once it becomes fully
 * compliant this notice will be removed.
 * 
 * <p>
 * The class is immutable and thread-safe.
 * 
 * @author Yegor Bugayenko (yegor@tpc2.com)
 * @version $Id$
 * @since 0.6
 * @see <a href="http://tools.ietf.org/html/rfc2141">RFC 2141</a>
 */
// @SuppressWarnings({ "PMD.TooManyMethods", "PMD.UseConcurrentHashMap" })
public final class URN implements Comparable<URN>, Serializable {

	/**
	 * NID of an empty URN.
	 */
	private static final String EMPTY = "void";

	/**
	 * The leading sequence.
	 */
	private static final String PREFIX = "urn";

	/**
	 * Validating regular expr.
	 */
	private static final String REGEX =
	// @checkstyle LineLength (1 line)
	"^urn:[a-z]{1,31}(:([\\-a-zA-Z0-9/]|%[0-9a-fA-F]{2})*)+(\\?\\w+(=([\\-a-zA-Z0-9/]|%[0-9a-fA-F]{2})*)?(&\\w+(=([\\-a-zA-Z0-9/]|%[0-9a-fA-F]{2})*)?)*)?\\*?$";

	/**
	 * The separator.
	 */
	private static final String SEP = ":";

	/**
	 * Serialization marker.
	 */
	private static final long serialVersionUID = 0xBF46AFCD9612A6DFL;

	/**
	 * The encoding of the URN.
	 */
	private static final String UTF_8 = "UTF-8";

	/**
	 * This char is allowed in URN's NSS part?
	 * 
	 * @param chr
	 *            The character
	 * @return It is allowed?
	 */
	private static boolean allowed(final byte chr) {
		return (chr >= 'A' && chr <= 'Z') || (chr >= '0' && chr <= '9')
				|| (chr >= 'a' && chr <= 'z') || (chr == '/') || (chr == '-');
	}

	/**
	 * Creates an instance of URN and throws a runtime exception if its syntax
	 * is not valid.
	 * 
	 * @param text
	 *            The text of the URN
	 * @return The URN created
	 */
	public static URN create(final String text) {
		if (text == null) {
			throw new IllegalArgumentException("URN text must be non null");
		}
		try {
			return new URN(text);
		} catch (URISyntaxException ex) {
			throw new IllegalArgumentException(ex);
		}
	}

	/**
	 * Decode query part of the URN into Map.
	 * 
	 * @param urn
	 *            The URN to demap
	 * @return The map of values
	 */
	private static Map<String, String> demap(final String urn) {
		final Map<String, String> map = new TreeMap<String, String>();
		final String[] sectors = urn.split("\\?");
		if (sectors.length == 2) {
			final String[] parts = sectors[1].split("&");
			for (String part : parts) {
				final String[] pair = part.split("=");
				String value;
				if (pair.length == 2) {
					try {
						value = URLDecoder.decode(pair[1], URN.UTF_8);
					} catch (java.io.UnsupportedEncodingException ex) {
						throw new IllegalStateException(ex);
					}
				} else {
					value = "";
				}
				map.put(pair[0], value);
			}
		}
		return map;
	}

	/**
	 * Perform proper URL encoding with the text.
	 * 
	 * @param text
	 *            The text to encode
	 * @return The encoded text
	 */
	private static String encode(final String text) {
		final StringBuilder encoded = new StringBuilder();
		byte[] bytes;
		try {
			bytes = text.getBytes(URN.UTF_8);
		} catch (java.io.UnsupportedEncodingException ex) {
			throw new IllegalStateException(ex);
		}
		for (byte chr : bytes) {
			if (URN.allowed(chr)) {
				encoded.append((char) chr);
			} else {
				encoded.append("%").append(String.format("%X", chr));
			}
		}
		return encoded.toString();
	}

	/**
	 * Encode map of params into query part of URN.
	 * 
	 * @param params
	 *            Map of params to convert to query suffix
	 * @return The suffix of URN, starting with "?"
	 */
	private static String enmap(final Map<String, String> params) {
		final StringBuilder query = new StringBuilder();
		if (!params.isEmpty()) {
			query.append("?");
			boolean first = true;
			for (Map.Entry<String, String> param : params.entrySet()) {
				if (!first) {
					query.append("&");
				}
				query.append(param.getKey());
				if (!param.getValue().isEmpty()) {
					query.append("=").append(URN.encode(param.getValue()));
				}
				first = false;
			}
		}
		return query.toString();
	}

	/**
	 * Is it a valid URN?
	 * 
	 * @param text
	 *            The text to validate
	 * @return Yes of no
	 */
	public static boolean isValid(final String text) {
		boolean valid = true;
		try {
			new URN(text);
		} catch (URISyntaxException ex) {
			valid = false;
		}
		return valid;
	}

	/**
	 * The URI.
	 */
	// @SuppressWarnings("PMD.BeanMembersShouldSerialize")
	private final URI uri;

	/**
	 * Public constructor (for JAXB mostly) that creates an "empty" URN.
	 */
	public URN() {
		this(URN.EMPTY, "");
	}

	/**
	 * Public constructor.
	 * 
	 * @param text
	 *            The text of the URN
	 * @throws URISyntaxException
	 *             If syntax is not correct
	 */
	public URN(final String text) throws URISyntaxException {
		if (text == null) {
			throw new URISyntaxException(text, "Invalid format of URN");
		}
		if (!text.matches(URN.REGEX)) {
			throw new URISyntaxException(text, "Invalid format of URN");
		}
		this.uri = new URI(text);
		this.validate();
	}

	/**
	 * Public constructor.
	 * 
	 * @param nid
	 *            The namespace ID
	 * @param nss
	 *            The namespace specific string
	 */
	public URN(final String nid, final String nss) {
		if (nid == null || nss == null) {
			throw new IllegalArgumentException(
					"Namespace ID (nid) and namespace specific string (nss) must be non-null");
		}
		this.uri = URI.create(String.format("%s%s%s%2$s%s", URN.PREFIX,
				URN.SEP, nid, URN.encode(nss)));
		try {
			this.validate();
		} catch (URISyntaxException ex) {
			throw new IllegalArgumentException(ex);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int compareTo(final URN urn) {
		return this.uri.compareTo(urn.uri);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(final Object obj) {
		boolean equals;
		if (obj == this) {
			equals = true;
		} else {
			equals = this.uri.toString().equals(obj.toString());
		}
		return equals;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		return this.uri.hashCode();
	}

	/**
	 * Whether this URN has params?
	 * 
	 * @return Has them?
	 */
	public boolean hasParams() {
		return this.toString().contains("?");
	}

	/**
	 * Is this URN empty?
	 * 
	 * @return true if this URN is empty, false otherwise.
	 */
	public boolean isEmpty() {
		return URN.EMPTY.equals(this.nid());
	}

	/**
	 * Does it match the pattern?
	 * 
	 * @param pattern
	 *            The pattern to match
	 * @return Yes of no
	 */
	public boolean matches(final String pattern) {
		if (pattern == null) {
			throw new IllegalArgumentException("Pattern must be non-null.");
		}
		boolean matches = false;
		if (this.equals(pattern)) {
			matches = true;
		} else if (pattern.endsWith("*")) {
			final String body = pattern.substring(0, pattern.length() - 1);
			matches = this.uri.toString().startsWith(body);
		}
		return matches;
	}

	/**
	 * Get namespace ID.
	 * 
	 * @return Namespace ID
	 */
	public String nid() {
		return this.segment(1);
	}

	/**
	 * Get namespace specific string.
	 * 
	 * @return Namespace specific string
	 */
	public String nss() {
		try {
			return URLDecoder.decode(this.segment(2), URN.UTF_8);
		} catch (java.io.UnsupportedEncodingException ex) {
			throw new IllegalStateException(ex);
		}
	}

	/**
	 * Get query param by name.
	 * 
	 * @param name
	 *            Name of parameter
	 * @return The value of it
	 */
	public String param(final String name) {
		if (name == null) {
			throw new IllegalArgumentException("Parameter name is null.");
		}
		final Map<String, String> params = this.params();
		if (!params.containsKey(name)) {
			throw new IllegalArgumentException(String.format(
					"Param '%s' not found in '%s', among %s", name, this,
					params.keySet()));
		}
		return params.get(name);
	}

	/**
	 * Add (overwrite) a query param and return a new URN.
	 * 
	 * @param name
	 *            Name of parameter
	 * @param value
	 *            The value of parameter
	 * @return New URN
	 */
	public URN param(final String name, final Object value) {
		if (name == null || value == null) {
			throw new IllegalArgumentException(
					"Parameter name and value must be non-null.");
		}
		final Map<String, String> params = this.params();
		params.put(name, value.toString());
		return URN.create(String.format("%s%s",
				this.toString().split("\\?")[0], URN.enmap(params)));
	}

	/**
	 * Get all params.
	 * 
	 * @return The params
	 */
	public Map<String, String> params() {
		return URN.demap(this.toString());
	}

	/**
	 * Get just body of URN, without params.
	 * 
	 * @return Clean version of it
	 */
	public URN pure() {
		String urn = this.toString();
		if (this.hasParams()) {
			urn = urn.substring(0, urn.indexOf('?'));
		}
		return URN.create(urn);
	}

	/**
	 * Get segment by position.
	 * 
	 * @param pos
	 *            Its position
	 * @return The segment
	 */
	private String segment(final int pos) {
		// return StringUtils.splitPreserveAllTokens(this.uri.toString(),
		// URN.SEP, 3)[pos];
		// TODO: I can imagine that this code may break. Before it was
		// implemented with
		// the line above and apache commons (which gives the
		// splitPreserveAllTokens, stuff).
		// Test unit this.
		return this.uri.toString().split(URN.SEP, 3)[pos];
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return this.uri.toString();
	}

	/**
	 * Convert it to URI.
	 * 
	 * @return The URI
	 */
	public URI toURI() {
		return URI.create(this.uri.toString());
	}

	/**
	 * Validate URN.
	 * 
	 * @throws URISyntaxException
	 *             If it's not valid
	 */
	private void validate() throws URISyntaxException {
		if (this.isEmpty() && !this.nss().isEmpty()) {
			throw new URISyntaxException(this.toString(),
					"Empty URN can't have NSS");
		}
		if (!this.nid().matches("^[a-z]{1,31}$")) {
			throw new IllegalArgumentException(String.format(
					"NID '%s' can contain up to 31 low case letters",
					this.nid()));
		}
	}

}
