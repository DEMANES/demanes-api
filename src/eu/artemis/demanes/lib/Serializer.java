/**
 * File Serializer.java
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
package eu.artemis.demanes.lib;

import eu.artemis.demanes.lib.exceptions.SerializationException;

/**
 * The Serializer interface is used to define the serialization process of
 * object to bytes and vice versa. Serializers are used in the DEMANES project
 * for remote method invocation.
 * 
 * @author coenvl
 * @version 0.1
 * @since May 8, 2014
 * 
 */
public interface Serializer {

	/**
	 * Deserializes an array of bytes to an object.
	 * 
	 * @param b
	 *            the bytes to deserialize
	 * @return the object represented by the byte array
	 * @throws SerializationException
	 */
	public Object deserialize(byte[] b) throws SerializationException;

	/**
	 * Serializes an object to an array of bytes.
	 * 
	 * @param obj
	 *            the object to serialize
	 * @return the array of bytes representing the object
	 * @throws SerializationException
	 */
	public byte[] serialize(Object obj) throws SerializationException;

}
