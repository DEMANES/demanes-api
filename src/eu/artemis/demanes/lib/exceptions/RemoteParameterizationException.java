/**
 * File RemoteParameterizationException.java
 * 
 * This file is part of the demanesInterface project.
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
package eu.artemis.demanes.lib.exceptions;

/**
 * RemoteParameterizationException
 * 
 * @author leeuwencjv
 * @version 0.1
 * @since 11 jun. 2014
 * 
 */
public class RemoteParameterizationException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3338980584113975171L;

	/**
	 * @param string
	 */
	public RemoteParameterizationException(String msg) {
		super(msg);
	}

	/**
	 * @param string
	 * @param e
	 */
	public RemoteParameterizationException(String msg, Throwable e) {
		super(msg, e);
	}

}
