/**
 * File TaskManager.java
 * Created by DEMANES
 * 
 * This file was created for the Artemis project DEMANES.
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
package eu.artemis.demanes.lifecycle;

import eu.artemis.demanes.datatypes.ANES_BUNDLE;
import eu.artemis.demanes.datatypes.ANES_URN;
import eu.artemis.demanes.exceptions.TaskManagerException;

/**
 * <p>
 * A TaskManager allows an application developer to activate, deactivate, and
 * inspect the state of tasks. To make use of a TaskManager, tasks must
 * implement (or be wrapped by) the TaskLifeCycle interface.
 * </p>
 * 
 * <p>
 * Tasks must first be registered in the TaskManager. This operation is done
 * only once per task. When registering a task, the user provides system wide
 * unique identifier for this task, that can be used in the future to activate
 * and deactivate the task.
 * </p>
 * 
 * <p>
 * Trying to activate, deactivate, or retrieving the state of a task that is not
 * registered in the TaskManager will produce a TaskManagerException.
 * </p>
 * 
 * 
 * @author DEMANES
 * @version 0.1
 * 
 */
public interface TaskManager {

	/**
	 * <p>
	 * Safely activates (starts) the task associated with the given ID.
	 * </p>
	 * 
	 * <p>
	 * The activationParameters mapping is made available when starting the
	 * task. Such mapping is intended to guide the activation process, like
	 * initialization parameters.
	 * </p>
	 * 
	 * <p>
	 * Task activation will only be carried out if the task is in the INSTALLED
	 * or in the IDLE states. If activate is invoked when the task is in any
	 * other states, an TaskManagerException is produced.
	 * </p>
	 * 
	 * <p>
	 * If the task is in INSTALLED state when the activate method is invoked,
	 * this method must first invoke the TaskActivator method create(). If it is
	 * successful, it must then invoke the TaskActivator method start().
	 * </p>
	 * 
	 * <p>
	 * Providing an unregistered ID will produce a TaskManagerException.
	 * </p>
	 * 
	 * @param id
	 *            id of the task to be activated.
	 * @param activationParameters
	 *            initialization key-value map to guide the task starting
	 *            process.
	 */
	public void activate(ANES_URN id, ANES_BUNDLE activationParameters)
			throws TaskManagerException;

	/**
	 * <p>
	 * Safely deactivates (stops) the task associated with the given ID.
	 * </p>
	 * 
	 * <p>
	 * The deActivationParameters mapping is made available when starting the
	 * task. Such mapping is intended to guide the de-activation process, like
	 * finalization parameters.
	 * </p>
	 * 
	 * <p>
	 * Task activation will only be carried out if the task is in the ACTIVE
	 * state. If it is already in the IDLE state nothing is necessary and the
	 * operation returns as successful.
	 * </p>
	 * 
	 * <p>
	 * Providing an unregistered ID will produce a TaskManagerException.
	 * </p>
	 * 
	 * @param id
	 *            id of the task to be activated.
	 * @param deActivationParameters
	 *            finalization key-value map to guide the task stopping process.
	 * @throws TaskManagerException
	 */
	public void deactivate(ANES_URN id, ANES_BUNDLE deActivationParameters)
			throws TaskManagerException;

	/**
	 * <p>
	 * Retrieves the state of the task associated with the given id.
	 * </p>
	 * 
	 * <p>
	 * A task can be in four possible states:
	 * <ul>
	 * <li><b>IDLE</b> - The task is not running. It is ready for activation.</li>
	 * <li><b>STARTING</b> - The task activation process started but is not yet
	 * completed.</li>
	 * <li><b>ACTIVE</b> - The task is running and ready for operation.</li>
	 * <li><b>STOPPING</b> - the task deactivation process started but is not
	 * yet completed.</li>
	 * </ul>
	 * </p>
	 * 
	 * @param id
	 *            id of the task to be inspected
	 * @return
	 * @throws TaskManagerException
	 */
	public LifeCycleState getTaskState(ANES_URN id) throws TaskManagerException;

	/**
	 * <p>
	 * Registers a task in the task life cycle management system.
	 * </p>
	 * 
	 * <p>
	 * Before using the TaskManager to activate or deactivate tasks, it is
	 * necessary to register the task in the TaskManager.
	 * </p>
	 * 
	 * <p>
	 * During the registration process, a system wide unique ID should be
	 * provided. This ID will be used in future calls to the TaskManager, when
	 * activating a task, deactivating a task, or retrieving a task's state.
	 * </p>
	 * 
	 * <p>
	 * Providing an ID that is already in use will produce a
	 * TaskManagerException.
	 * </p>
	 * 
	 * <p>
	 * After a task is successfully registered, successive calls to the
	 * TaskManager using the given ID should be accepted and trigger the
	 * appropriate methods in the task.
	 * </p>
	 * 
	 * <p>
	 * After registering a task, the task will be considered to be in INSTALLED
	 * state. Thus, only registering a task will not activate (create and run)
	 * it. The method activate must be invoked for that.
	 * </p>
	 * 
	 * @param id
	 *            a system wide unique id for this task.
	 * @param task
	 *            the task to be controlled by this activator.
	 * @param options
	 *            a set of options to be used during the activation of the
	 *            bundle.
	 */
	public void install(ANES_URN id, TaskActivator task, ANES_BUNDLE options)
			throws TaskManagerException;

	/**
	 * <p>
	 * Unregisters a task from the task life cycle management system.
	 * </p>
	 * 
	 * <p>
	 * After a task is successfully unregistered, successive calls to the
	 * TaskManager using the same ID will fail and will not trigger the
	 * appropriate methods in the task.
	 * </p>
	 * 
	 * <p>
	 * Unregistering a task can only be done if the task is in IDLE or in
	 * INSTALLED state. That means that if the task is in any other state, the
	 * user has to first deactivate it before unregistering it.
	 * </p>
	 * 
	 * <p>
	 * If the task is IDLE state, this method should first invoke the destroy()
	 * method of the associated TaskActivator. If this is successful it must
	 * invoke the method uninstall of the associated TaskActivator.
	 * </p>
	 * 
	 * <p>
	 * Providing an existing ID will produce a TaskManagerException.
	 * </p>
	 * 
	 * <p>
	 * Trying to unregister a task that is not IDLE will produce a
	 * TaskManagerException.
	 * </p>
	 * 
	 * @param id
	 *            a system wide unique id for this task.
	 * @param options
	 *            a set of options to be used during the deactivation of the
	 *            bundle.
	 */
	public void uninstall(ANES_URN id, ANES_BUNDLE options)
			throws TaskManagerException;

}

/**
 * 
 * ASSUMPTIONS:
 * 
 * a) Every task can be uniquely identified in the system by using an ANES_URN.
 * 
 * b) Tasks are already installed in the system (this interface is not used for
 * installing software modules).
 * 
 * c) Better to work with exceptions or not ? Compatibitilty with
 * microcontrollers.
 * 
 * 
 **/
