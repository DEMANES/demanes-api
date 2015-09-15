/**
 * File ParameterizableRegistry.java
 * 
 * This file is part of the eu.artemis.demanes.parameterizationRESTServer project.
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

import eu.artemis.demanes.parameterization.Parameterizable;

/**
 * The ParameterizableRegistry provides an interface for Parameterizable classes
 * to register in order to be accessible from one central point. It
 * 
 * @author coenvl
 * @version 0.1
 * @since May 1, 2014
 * 
 */

public interface ParameterizableRegistry {

	/**
	 * Register the parameterizable object in this Registry. If the
	 * Parameterizable already was registered, nothing changes, otherwise it
	 * will be added to the registry
	 * 
	 * @param p
	 *            an Object implementing the Parameterizable interface
	 */
	public void register(Parameterizable p);

	/**
	 * Unregister the parameterizable object from the Registry. If the
	 * Parameterizable was not registered, nothing changes, otherwise it will be
	 * removed from the registry
	 * 
	 * @param p
	 *            an Object implementing the Parameterizable interface
	 */
	public void unregister(Parameterizable p);
}
