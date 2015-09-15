/**
 * File ParameterizationLinkException.java
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
 * ParameterizationLinkException
 * 
 * @author oliveirafilhojad
 * @version 0.1
 * @since 28 feb. 2014
 * 
 */
public class ParameterizationLinkException extends ParameterizationException {

	/**
	 * Default message to be printed for parameterization Link exceptions.
	 */
	private static final String defaultMessage = "Link to parameterizable object inexistent or broken.";

	/**
	 * For serialization purposes.
	 */
	private static final long serialVersionUID = 5850134865841671442L;

	public ParameterizationLinkException() {
		super(defaultMessage);
	}

	/**
	 * Adds the message to the default message of this exception.
	 * 
	 * @param message
	 *            The message to be appended.
	 */
	public ParameterizationLinkException(String message) {
		super(defaultMessage + "\n" + message);
	}

	/**
	 * Adds the message to the default message of this exception.
	 * 
	 * @param message
	 *            The message to be appended.
	 * @param cause
	 *            The cause of this exception.
	 */
	public ParameterizationLinkException(String message, Throwable cause) {
		super(defaultMessage + "\n" + message, cause);
	}

	/**
	 * Adds a cause for this exception.
	 * 
	 * @param cause
	 */
	public ParameterizationLinkException(Throwable cause) {
		super(defaultMessage, cause);
	}
}
