/**
 * File SocketConnector.java
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
package eu.artemis.demanes.lib;

/**
 * SocketConnector
 * 
 * @author leeuwencjv
 * @version 0.1
 * @since 30 jun. 2014
 * 
 */
public interface SocketConnector {

	/**
	 * For actively sending message via the Socket, this function accepts a byte
	 * array which will be sent through the socket
	 * 
	 * FIXME: Should this not be a ByteBuffer to be more consistent and more
	 * memory safe? Making only the change to byte array when really pushing in
	 * the connection?
	 * 
	 * @param val
	 * @return 
	 */
	public MessageDispatcherRegistry write(byte[] val);

}
