/**
 * File ANES_URN.java
 * Created by DEMANES
 * 
 * This file was created for the DEMANES project 2014.
 * 
 * Copyright 2014 TNO
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package eu.artemis.demanes.datatypes;

import java.io.Serializable;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

/**
 * ANES_URN
 * 
 * @author DEMANES
 * @version 0.1
 * @since 27 nov. 2013
 * 
 */
public class ANES_URN implements Comparable<ANES_URN>, Serializable {

	/**
	 * For serialization purposes.
	 */
	private static final long serialVersionUID = -1928581708496063566L;

	/**
	 * Creates an instance of ANES_URN and throws a runtime exception if its
	 * syntax is not valid.
	 * 
	 * @param text
	 *            The text of the URN
	 * @return The URN created
	 * @throws URISyntaxException
	 *             the exception generated if the syntax is not correct.
	 */
	public static ANES_URN create(final String text) throws URISyntaxException {
		return new ANES_URN(text);
	}

	/**
	 * Is it a valid URN?
	 * 
	 * @param text
	 *            The text to validate
	 * @return Yes of no
	 */
	public static boolean isValid(final String text) {
		return URN.isValid(text);
	}

	/**
	 * The basic information container for this type.
	 */
	private final URN urn;

	/**
	 * Public constructor.
	 * 
	 * @param text
	 *            The text of the URN
	 * @throws URISyntaxException
	 *             If syntax is not correct
	 */
	public ANES_URN(final String text) throws URISyntaxException {
		this.urn = new URN(text);
	}

	/**
	 * Public constructor.
	 * 
	 * @param nid
	 *            The namespace ID
	 * @param nss
	 *            The namespace specific string
	 */
	public ANES_URN(final String nid, final String nss) {
		this.urn = new URN(nid, nss);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int compareTo(final ANES_URN other) {
		return this.urn.compareTo(other.urn);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(final Object obj) {
		return this.urn.equals(obj);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		return this.urn.hashCode();
	}

	/**
	 * Whether this URN has params?
	 * 
	 * @return Has them?
	 */
	public boolean hasParams() {
		return this.urn.hasParams();
	}

	/**
	 * Is this ANES_URN empty?
	 * 
	 * @return true if this ANES_URN is empty, false otherwise.
	 */
	public boolean isEmpty() {
		return this.urn.isEmpty();
	}

	/**
	 * Does it match the pattern?
	 * 
	 * @param pattern
	 *            The pattern to match
	 * @return Yes of no
	 */
	public boolean matches(final String pattern) {
		return this.urn.matches(pattern);
	}

	/**
	 * Get namespace ID.
	 * 
	 * @return Namespace ID
	 */
	public String nid() {
		return this.urn.nid();
	}

	/**
	 * Get namespace specific string.
	 * 
	 * @return Namespace specific string
	 */
	public String nss() {
		return this.urn.nss();
	}

	/**
	 * Get query param by name.
	 * 
	 * @param name
	 *            Name of parameter
	 * @return The value of it
	 */
	public String param(final String name) {
		return this.urn.param(name);
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
		return this.urn.param(name, value);
	}

	/**
	 * Get all params of the ANES_URN.
	 * 
	 * @return The params
	 */
	public Map<String, String> params() {
		return this.urn.params();
	}

	/**
	 * Get just body of URN, without params.
	 * 
	 * @return another ANES_URN with only the body, no parameters.
	 */
	public ANES_URN pure() {
		URN newURN = this.urn.pure();
		try {
			return ANES_URN.create(newURN.toString());
		} catch (URISyntaxException e) {
			e.printStackTrace();
			return this;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return this.urn.toString();
	}

	/**
	 * Convert it to URI.
	 * 
	 * @return The URI
	 */
	public URI toURI() {
		return URI.create(this.urn.toString());
	}

}
