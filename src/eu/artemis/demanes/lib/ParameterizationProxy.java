/**
 * File ParameterizationProxy.java
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
package eu.artemis.demanes.lib;

import eu.artemis.demanes.datatypes.ANES_URN;
import eu.artemis.demanes.exceptions.ParameterizationException;

/**
 * The ParameterizationProxy functions as a Proxy for other (remote) instances
 * to communicate with a Parameterizable object. The interface is quite similar,
 * instead it provides a raw interface using byte arrays instead of java
 * Objects.
 * 
 * The goal of the Proxy is to provide a context free interface to another
 * server which has object of the Parameterizable type.
 * 
 * @author coenvl
 * @version 0.1
 * @since May 1, 2014
 * 
 */
public interface ParameterizationProxy {

	/**
	 * Retrieves the value of the parameter identified by the given urn.
	 * 
	 * 'urn' can also be an identifier for the getter function of a task
	 * associated with the desired parameter, instead of a direct identifier for
	 * the parameter itself.
	 * 
	 * @param urn
	 *            the identifier of the parameter or parameter getter function.
	 * @return the byte array representing the indicated parameter.
	 */
	byte[] getParameter(ANES_URN urn) throws ParameterizationException;

	/**
	 * Returns a byte array representing all identifiers available through this
	 * interface.
	 * 
	 * Identifiers may represent:
	 * 
	 * - parameters that can be retrieved or modified, or ; - setters and
	 * getters functions that can be invoked to retrieve or modify parameters.
	 * 
	 * @return a byte array of identifiers.
	 * @throws ParameterizationException
	 */
	byte[] listParameters() throws ParameterizationException;

	/**
	 * Sets the parameter identified by the given urn to the given value.
	 * 
	 * 'urn'can also be an identifier of the setter function of a task
	 * associated with the desired parameter, instead of the urn of the
	 * parameter itself.
	 * 
	 * @param urn
	 *            the identifier of the parameter or parameter setter function.
	 * @param value
	 *            the byte array representing the new value to be set for the
	 *            parameter.
	 */
	void setParameter(ANES_URN urn, byte[] value)
			throws ParameterizationException;

}
