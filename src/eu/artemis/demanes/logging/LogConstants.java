/**
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

package eu.artemis.demanes.logging;

public interface LogConstants {

	public final static String CONFIG_PROPERTIES = "configurations\\config.properties";
	public final static String DEVICE_lOGGER_KEY = "device.logger";
	public final static String RICH_DEVICE_LOGGER = "richLogger";
	public final static String POOR_DEVICE_LOGGER = "poorLogger";

	public final static int LOG_LEVEL_TRACE = 0;
	public final static int LOG_LEVEL_DEBUG = 1;
	public final static int LOG_LEVEL_INFO = 2;
	public final static int LOG_LEVEL_WARN = 3;
	public final static int LOG_LEVEL_ERROR = 4;
	public final static int LOG_LEVEL_FATAL = 5;

}
