/**
 * File ParameterizationAccessorException.java
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
 * ParameterizationAccessorException
 * 
 * @author oliveirafilhojad
 * @version 0.1
 * @since 28 feb. 2014
 * 
 */
public class ParameterizationAccessorException extends
		ParameterizationException {

	/**
	 * Default message
	 */
	private static final String defaultMessage = "Error when accessing parameter.";

	/**
	 * For serialization purposes.
	 */
	private static final long serialVersionUID = -1442800348601814642L;

	public ParameterizationAccessorException() {
		super(defaultMessage);
	}

	/**
	 * Adds the message to the default message of this exception.
	 * 
	 * @param message
	 *            The message to be appended.
	 */
	public ParameterizationAccessorException(String message) {
		super(defaultMessage + "/n" + message);
	}

	/**
	 * Adds the message to the default message of this exception.
	 * 
	 * @param message
	 *            The message to be appended.
	 * @param cause
	 *            The cause of this exception.
	 */
	public ParameterizationAccessorException(String message, Throwable cause) {
		super(defaultMessage + "/n" + message, cause);
	}

	/**
	 * Adds a cause for this exception.
	 * 
	 * @param cause
	 */
	public ParameterizationAccessorException(Throwable cause) {
		super(defaultMessage, cause);
	}

}
