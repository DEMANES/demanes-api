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

public class TaskManagerException extends Exception {

	public static final String INVALIDACTIVATOR = "Invalid reference to activator.";
	public static final String INVALIDURN = "Invalid urn.";
	public static final String REGISTEREXISTS = "Activator already registered.";
	public static final String REGISTERUNKNOW = "Reference to activator not known in system.";
	/**
	 * For purposes of serialization
	 */
	private static final long serialVersionUID = -4426243674633181680L;
	public static final String STARTFAILED = "Starting the task yields an non-idle task";

	public static final String STATEFAILURE = "Task is not in correct state for this operation.";

	/**
     * 
     */
	public TaskManagerException() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Creates a task manager exception with the given output message string.
	 * 
	 * @param string
	 */
	public TaskManagerException(String string) {
		super(string);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public TaskManagerException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public TaskManagerException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
