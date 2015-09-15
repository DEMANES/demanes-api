/**
 * File LifeCycleState.java
 * Created by DEMANES
 * 
 * This file was created for the DEMANES project 2013.
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

/**
 * LifeCycleState
 * 
 * TODO: Format documentation
 * 
 * The LifeCycleState is a enumeration that describes the possible states of a
 * task during its life cycle.
 * 
 * The following states are defined:
 * 
 * UNINSTALLED - when the task is removed from the system. No way to create or
 * run it before performing an installaton. Examples are applications removed
 * from the harddisk, servlets not yet registered in the webserver, etc.
 * 
 * INSTALLED - the task exists in static (source code) format in the system.
 * Active, dynamic instances of the task may be created from this installed
 * version. Examples are applications installed in the hard disk of a computer
 * (but not invoked), dynamic libraries ready to be linked, servlets installed
 * in a webserver but not active.
 * 
 * IDLE - the task exists as a dynamic object in the system but does not execute
 * code. It is an instance that can be activated.
 * 
 * STARTING - a transient state that indicates that the task is in its
 * initialization phase before running.
 * 
 * ACTIVE - the task is running code, kicking and biting.
 * 
 * STOPPING - a transient state that indicates that a task is stopping its
 * activity and falling into the IDLE state.
 * 
 * @author DEMANES
 * @version 0.1
 * 
 */
public enum LifeCycleState {
	ACTIVE, IDLE, INSTALLED, STARTING, STOPPING, UNINSTALLED;
}
