/**
 * File TaskActivator.java
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
import eu.artemis.demanes.exceptions.TaskLifeCycleException;

/**
 * TaskActivator
 * 
 * TODO: Format documentation
 * 
 * Specification of the TaskActivator interface and behavior (contract).
 * 
 * @author DEMANES
 * @version 0.1
 * 
 */
public interface TaskActivator {

	/**
	 * Creates a task (dynamic) object in its IDLE state.
	 * 
	 * The method create should carry out all the necessary steps to create an
	 * dynamic instantiation of the task in the system. Such instance must be in
	 * IDLE state and must not run any code. However it is ready for activation
	 * and all the dependencies for the existency of the task are fullfilled.
	 * 
	 * When create is successful, it must yield a task in the IDLE state. That
	 * means, a request to the method getState() must yield IDLE.
	 * 
	 * The method create will run successfully only if the application is in the
	 * INSTALLED state. Trying to invoke the create method when the application
	 * is in other state than INSTALLED should throw a TaskLifeCycleException.
	 * 
	 * If the create method is not successful, a TaskLifeCycleException should
	 * be thrown. In case of failure, this method should free all resources
	 * allocated or blocked by the create method before returning.
	 * 
	 * @param activationParameters
	 *            options for the creation procedure.
	 * @throws TaskLifeCycleException
	 *             in case of failure.
	 */
	public void create(ANES_BUNDLE activationParameters)
			throws TaskLifeCycleException;

	/**
	 * Destroys a task (dynamic) object.
	 * 
	 * The method destroy should carry out all the necessary steps to remove a
	 * dynamic instantiation of the associated task in the system. Such instance
	 * must be in IDLE state and must not run any code.
	 * 
	 * When destroy is successful, it must yield a task in the INSTALLED state.
	 * That means, a request to the method getState() must yield INSTALLED.
	 * 
	 * The method destroy will run successfully only if the application is in
	 * the IDLE state. Trying to invoke the destroy method when the application
	 * is in other state than IDLE should throw a TaskLifeCycleException.
	 * 
	 * If the destroy method is not successful, a TaskLifeCycleException should
	 * be thrown. In case of failure, this method should free all resources
	 * allocated or blocked by the destroy method before returning.
	 * 
	 * @param activationParameters
	 *            options for the destruction procedure.
	 * @throws TaskLifeCycleException
	 *             in case of failure.
	 */
	public void destroy(ANES_BUNDLE activationParameters)
			throws TaskLifeCycleException;

	/**
	 * Retrieves the life cycle state of the associated task.
	 * 
	 * @return the actual life cycle state of the associated task.
	 */
	public LifeCycleState getState();

	/**
	 * Installs a task in the system
	 * 
	 * The method install should carry out all the necessary steps to install
	 * the associated task in the system.
	 * 
	 * When install is successful, it must yield a task in the INSTALLED state.
	 * That means, a request to the method getState() must yield INSTALLED.
	 * 
	 * If the install method is not successful, a TaskLifeCycleException should
	 * be thrown. In case of failure, this method should free all resources
	 * allocated or blocked by the install method before returning.
	 * 
	 * @param activationParameters
	 *            options for the installation procedure.
	 * @throws TaskLifeCycleException
	 *             in case of failure.
	 */
	public void install(ANES_BUNDLE activationParameters)
			throws TaskLifeCycleException;

	/**
	 * Starts the execution of the task.
	 * 
	 * The method start should carry out all the necessary steps to start up the
	 * associated task. This method must be non blocking -- thus it should not
	 * block while the application runs. The application continues its
	 * operation.
	 * 
	 * From the invocation of the method start and until its return, the task is
	 * considered to be in STARTING state. That means, a request to the method
	 * getState() must yield STARTING. Immediately after the return of this
	 * method, the task is considered to be in ACTIVE state. A request to the
	 * method getState() must yield ACTIVE.
	 * 
	 * The method start will run successfully only if the application is in the
	 * IDLE state. Trying to invoke the start method when the application is in
	 * other state than IDLE should throw a TaskLifeCycleException.
	 * 
	 * If the start method is not successful, a TaskLifeCycleException should be
	 * thrown. In case of failure, this method should free all resources
	 * allocated or blocked by the start method before returning. In case of
	 * failure, the task will be considered to fall back in whatever state it
	 * had before.
	 * 
	 * 
	 * @param activationParameters
	 *            a key-value map with the parameters for the task starting up
	 *            sequence.
	 * @throws TaskLifeCycleException
	 *             in case of failure.
	 */
	public void start(ANES_BUNDLE activationParameters)
			throws TaskLifeCycleException;

	/**
	 * Stops the execution of the task.
	 * 
	 * The method stop should carry out all the necessary steps to stop the
	 * execution of the associated task. This method should return after these
	 * steps are completed. The application does not run anymore after this
	 * method returns, but it can be re-started again by invoking the method
	 * start.
	 * 
	 * From the invocation of the method stop and until its return, the task is
	 * considered to be in STOPPING state. Immediately after the return of this
	 * method, the task is considered to be in IDLE state.
	 * 
	 * The method stop will run successfully only if the application is in the
	 * ACTIVE state. Trying to invoke stop when the task is in other state than
	 * ACTIVE should produce a TaskLifeCycleException.
	 * 
	 * 
	 * @param activationParameters
	 *            a key-value map with the parameters for the task stopping
	 *            sequence.
	 * @throws TaskLifeCycleException
	 */
	public void stop(ANES_BUNDLE deactivationParameters)
			throws TaskLifeCycleException;

	/**
	 * Uninstalls a task from the system
	 * 
	 * The method install should carry out all the necessary steps to uninstall
	 * the associated task from the system.
	 * 
	 * When uninstall is successful, it must yield a task in the UNINSTALLED
	 * state. That means, a request to the method getState() must yield
	 * UNINSTALLED.
	 * 
	 * The method uninstall will run successfully only if the application is in
	 * the INSTALLED state. Trying to invoke the start method when the
	 * application is in other state than INSTALLED should throw a
	 * TaskLifeCycleException.
	 * 
	 * If the uninstall method is not successful, a TaskLifeCycleException
	 * should be thrown. In case of failure, this method should free all
	 * resources allocated or blocked by the uninstall method before returning.
	 * 
	 * @param activationParameters
	 *            options for the uninstallation procedure.
	 * @throws TaskLifeCycleException
	 *             in case of failure.
	 */
	public void uninstall(ANES_BUNDLE activationParameters)
			throws TaskLifeCycleException;

}
