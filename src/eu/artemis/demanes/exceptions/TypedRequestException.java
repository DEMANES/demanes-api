/**
 * File TypedRequestException.java
 *
 * This file is part of the demanesInterface project 2014.
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
package eu.artemis.demanes.exceptions;

/**
 * TypedRequestException
 * 
 * @author leeuwencjv
 * @version 0.1
 * @since 10 apr. 2014
 * 
 */
public class TypedRequestException extends Exception {

	/**
     * 
     */
	private static final long serialVersionUID = -2614277490603022155L;

	public TypedRequestException(Class<?> foundType, Class<?> requestedType) {
		super("Unexpected type " + foundType.getCanonicalName()
				+ " encountered, when type " + requestedType.getCanonicalName()
				+ " was requested.");
	}

	public TypedRequestException(Class<?> requestedType,
			ClassCastException cause) {
		super("Error in casting value to " + requestedType.getCanonicalName(),
				cause);
	}

}
