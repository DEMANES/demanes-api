/**
 * File ServiceProvider.java
 * 
 * This file is part of the eu.artemis.demanes project.
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
package eu.artemis.demanes.lib.services;

import eu.artemis.demanes.datatypes.ANES_URN;

/**
 * <h1>ServiceProvider</h1>
 * 
 * <p>
 * The ServiceProvider is the interface through which services may be obtained.
 * This provider may run on the server to provide any of the services registered
 * on that server, or on the client to get a binding to a remote service.
 * </p>
 *
 * @author leeuwencjv
 * @version 0.1
 * @since 15 okt. 2014
 *
 */
public interface ServiceProvider {

	/**
	 * Get a service with the provided URN. Based on the implementation this
	 * service may be null if it cannot be found, or a dummy service may be
	 * returned which will always throw exeptions. Note that this means that
	 * just because this function returns a service, it does <b>NOT</b> mean
	 * that the service exists on a remote machine.
	 * 
	 * @param identifier
	 * @return A service identified by the provided ANES_URN, but may be a dummy
	 *         Service
	 */
	public RESTService resolve(ANES_URN identifier);

}
