/**
 * File RESTService.java
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

import java.nio.ByteBuffer;

import eu.artemis.demanes.datatypes.ANES_URN;

/**
 * <h1>RESTService</h1>
 * 
 * <p>
 * A RESTService is any object that provides a particular service in a REST way.
 * This means we provide four operations for GET, PUT, POST or DELETE
 * information to a service. This is exactly what the interface provides. The
 * usage of the service is entirely up the implementing service, but this
 * interface makes sure all services can be addressed in a universal way.
 * </p>
 * 
 * </p> A nice video explaining the REST architectural style can be found in <a
 * href=http://www.restapitutorial.com/lessons/whatisrest.html>this video</a>
 * </p>
 *
 * @author leeuwencjv
 * @version 0.1
 * @since 15 okt. 2014
 *
 */
public interface RESTService {

	/**
	 * Get information from the service. This usually means the data requested
	 * comes via the return value, but this is in no way guaranteed. The
	 * function returns either the data that was requested or null otherwise.
	 * 
	 * @param input
	 * @return
	 * @throws ServiceException
	 */
	public ByteBuffer get(ByteBuffer input) throws ServiceException;

	/**
	 * Put information in to the service. This usually means the creation of new
	 * resources in the service, but this is up to the design of the service.
	 * The return value may be null, or some kind of confirmation of the action.
	 * 
	 * @param input
	 * @return
	 * @throws ServiceException
	 */
	public ByteBuffer put(ByteBuffer input) throws ServiceException;

	/**
	 * Post information to the service. This usually means the update of
	 * existing resources in the service, but this is up to the design of the
	 * service. The return value may be null, or some kind of confirmation of
	 * the action.
	 * 
	 * @param input
	 * @return
	 * @throws ServiceException
	 */
	public ByteBuffer post(ByteBuffer input) throws ServiceException;

	/**
	 * Request deletion of information from the service. The return value may be
	 * null, or some kind of confirmation of the deletion.
	 * 
	 * @param input
	 * @return
	 * @throws ServiceException
	 */
	public ByteBuffer delete(ByteBuffer input) throws ServiceException;

	/**
	 * Every service must be identifier by an (ideally unique) ANES_URN. Calling
	 * this function on any particular service should always return the same URN
	 * that will identify this service.
	 * 
	 * @return
	 */
	public ANES_URN identifier();

}
