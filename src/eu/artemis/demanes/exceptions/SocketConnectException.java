/**
 * File SocketConnectException.java
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
package eu.artemis.demanes.exceptions;

/**
 * SocketConnectException
 *
 * @author leeuwencjv
 * @version 0.1
 * @since 2 jul. 2014
 *
 */
public class SocketConnectException extends Exception {

	private static final String err_msg = "Error connecting to socket. ";

	/**
	 * @param string
	 */
	public SocketConnectException(String string) {
		super(err_msg + string);
	}

	/**
	 * 
	 */
	public SocketConnectException() {
		super(err_msg);
	}

	/**
	 * 
	 */
	public SocketConnectException(String msg, Throwable cause) {
		super(err_msg + msg, cause);
	}

	/**
	 * @param cause
	 */
	public SocketConnectException(Throwable cause) {
		super(err_msg, cause);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 4327533105515862201L;

}
