/**
 * File SerializationException.java
 * 
 * This file is part of the demanesInterface project.
 *
 * Copyright 2014 TNO
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package eu.artemis.demanes.lib.exceptions;

/**
 * SerializationException
 * 
 * @author coenvl
 * @version 0.1
 * @since May 8, 2014
 * 
 */
public class SerializationException extends Exception {

	final static String ERRMSG = "Error during serialization";

	/**
	 * 
	 */
	private static final long serialVersionUID = 7800470250737055714L;

	/**
	 * @param msg
	 *            An error message explaining the exception
	 */
	public SerializationException(String msg) {
		super(ERRMSG + ": " + msg);
	}

	/**
	 * @param msg
	 *            An error message explaining the exception
	 * @param e
	 *            the cause of the exception
	 */
	public SerializationException(String msg, Throwable e) {
		super(ERRMSG + ": " + msg, e);
	}

	/**
	 * @param e
	 *            the cause of the exception
	 */
	public SerializationException(Throwable e) {
		super(ERRMSG, e);
	}

}
