/**
 * File Triggerable.java
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
package eu.artemis.demanes.reconfiguration;

/**
 * <p>
 * An object implementing the Triggerable interface can be triggered in order to
 * perform it's actions. It allows for it's accessors to have a method that will
 * start the object's main functionality
 * </p>
 * 
 * @see TriggerPolicy
 * 
 * @author DEMANES
 * @version 0.1
 * @since 27 nov. 2013
 * 
 */
public interface Triggerable {

	/**
	 * <p>
	 * The trigger function triggers the object to do it's main purpose. The
	 * trigger function is merely a generic get an object started. It receives
	 * no arguments, it can be seen merely as a button that activates the
	 * Triggerable object.
	 * </p>
	 */
	public void trigger();

}
