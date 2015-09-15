/**
 * File ParameterizationException.java
 * Created on 28 feb. 2014 by oliveirafilhojad
 * 
 * This file was created for DEMANES project.
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
package eu.artemis.demanes.exceptions;

/**
 * ParameterizationException
 * 
 * @author DEMANES
 * @version 0.1
 * @since 28 feb. 2014
 * 
 */
public class ParameterizationException extends Exception {

	/**
	 * For serialization purposes
	 */
	private static final long serialVersionUID = 4321653727001497693L;

	/**
     * 
     */
	protected ParameterizationException() {
		super();
	}

	/**
	 * Creates a parameterization exception with the given message.
	 * 
	 * @param message
	 *            The message associated to this exception.
	 */
	protected ParameterizationException(String message) {
		super(message);
	}

	/**
	 * Creates a parameterization exception with the given message and cause.
	 * 
	 * @param message
	 *            The message associated to this exception.
	 * @param cause
	 *            The deeper cause of this exception.
	 */
	protected ParameterizationException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Creates a parameterization exception and associates with the cause.
	 * 
	 * @param cause
	 *            The cause associated to this exception.
	 */
	protected ParameterizationException(Throwable cause) {
		super(cause);
	}

}
