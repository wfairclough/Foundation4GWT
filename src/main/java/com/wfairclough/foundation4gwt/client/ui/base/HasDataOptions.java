/*
 *  Copyright 2013 Foundation4GWT
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.wfairclough.foundation4gwt.client.ui.base;

/**
 * Interface for components that have data-options {@link HasDataOptions}
 * 
 * @author Will Fairclough
 *
 */
public interface HasDataOptions {

	/**
	 * Add a {@link DataOption} to a component.
	 * 
	 * @param dataOption the {@link DataOption} to add 
	 */
	void addDataOption(DataOption dataOption);

	/**
	 * Remove a {@link DataOption} from a component.
	 * 
	 * @param dataOption the {@link DataOption} to remove 
	 */
	void removeDataOption(DataOption dataOption);
	
	/**
	 * Clear all the {@link DataOption DataOptions}
	 */
	void clearDataOptions();
	
	
}
