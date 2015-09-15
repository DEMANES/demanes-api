/**
 * File USBServer.java
 * Created on 6 mei 2014 by oliveirafilhojad
 * 
 * This file was created for DEMANES project.
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
package eu.artemis.demanes.lib;

import java.nio.ByteBuffer;

/**
 * MessageDispatcher
 * 
 * @author oliveirafilhojad
 * @version 0.1
 * @since 6 mei 2014
 * 
 */
public interface MessageDispatcher {

	/**
	 * Dispatch the message.
	 * 
	 * This function is called by another object when an incoming message needs
	 * to be processed. The object implementing the MessageDispatcher interface
	 * will know how to process the ByteBuffer correctly. After analyzing the
	 * message, the response to the incoming message may be returned. If no
	 * response is required this function will return null.
	 * 
	 * @param msg
	 *            the received message packed in a buffer of bytes.
	 * @return the response to this message packed in a buffer of bytes. Null if
	 *         no response is to be sent.
	 */
	public ByteBuffer dispatchMessage(ByteBuffer msg);

}
