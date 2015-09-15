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

package eu.artemis.demanes.exceptions;

import eu.artemis.demanes.datatypes.ANES_URN;

/**
 * An ActionInvocationException is thrown to indicate that an error occurred
 * during the invocation of an {@linkplain Action}. The original exception is
 * added as a cause.
 * 
 * @see eu.artemis.demanes.reconfiguration.Action#invoke
 * 
 * @author leeuwencjv
 * @version 0.1
 * @since 9 apr. 2014
 * 
 */
public class ActionInvocationException extends Exception {

	private static final long serialVersionUID = -4022985095456964143L;

	/**
	 * @param urn
	 *            The URN of the Action that threw the exception when invoking
	 * @param e
	 *            The original exception that occurred during invocation
	 */
	public ActionInvocationException(ANES_URN urn, Exception e) {
		super("Error while invokin Action with urn " + urn, e);
	}

}
