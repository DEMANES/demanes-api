/**
 * File ServiceRegistry.java
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

/**
 * ServiceRegistry
 * 
 * Used on the server side to register services to provide for other users to
 * get. Only provides the interface by which a service can register or
 * unregister itself. Whenever a future request comes at the server, the service
 * identifier is used to resolve the registered service.
 *
 * @author leeuwencjv
 * @version 0.1
 * @since 15 okt. 2014
 *
 */
public interface ServiceRegistry {

	/**
	 * Register the service at this ServiceRegistry. If it (or service with a
	 * clashing identifier) already was registered, nothing happens.
	 * 
	 * @param s
	 */
	public void registerService(RESTService s);

	/**
	 * Unregister the service (or service with a clashing identifier) at this
	 * ServiceRegistry. If it was not yet registered, nothing happens.
	 * 
	 * @param s
	 */
	public void unregisterService(RESTService s);

}
