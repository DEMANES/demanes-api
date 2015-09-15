/**
 * File ServiceException.java
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
 * <h1>
 * ServiceException</h1>
 * 
 * <p>
 * Indicates that a service call failed in some way. The message may contain
 * information about why the service call failed.
 * </p>
 *
 * @author leeuwencjv
 * @version 0.1
 * @since 16 okt. 2014
 *
 */
public class ServiceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6553587852328222580L;

	public ServiceException() {
		super("Error occured while using service");
	}

	public ServiceException(String message) {
		super(message);
	}

	public ServiceException(Throwable cause) {
		super(cause);
	}

	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}
}
