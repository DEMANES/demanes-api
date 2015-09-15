/**
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

package eu.artemis.demanes.parameterization;

import java.util.Set;

import eu.artemis.demanes.datatypes.ANES_URN;
import eu.artemis.demanes.exceptions.ParameterizationException;

/**
 * Parameterizable
 * 
 * DEMANES interface for parameterizable tasks.
 * 
 * Parameterizable is the standard interface to be implemented by every
 * application that wants to expose parameters within the DEMANES middleware.
 * 
 * @author DEMANES
 * @version 0.1
 * @since 28 feb. 2014
 * 
 */
public interface Parameterizable {

	/**
	 * Retrieves the value of the parameter identified by the given urn.
	 * 
	 * 'urn' can also be an identifier for the getter function of a task
	 * associated with the desired parameter, instead of a direct identifier for
	 * the parameter itself.
	 * 
	 * @param urn
	 *            the identifier of the parameter or parameter getter function.
	 * @return the actual value of the indicated parameter.
	 */
	public Object getParameter(ANES_URN urn) throws ParameterizationException;

	/**
	 * Returns a list of all identifiers available through this interface.
	 * 
	 * Identifiers may represent:
	 * 
	 * - parameters that can be retrieved or modified, or ; - setters and
	 * getters functions that can be invoked to retrieve or modify parameters.
	 * 
	 * @return an array of identifiers in ANES_URN format.
	 * @throws ParameterizationException
	 */
	public Set<ANES_URN> listParameters() throws ParameterizationException;

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
	 *            the new value to be set for the parameter.
	 */
	public void setParameter(ANES_URN urn, Object value)
			throws ParameterizationException;
}
