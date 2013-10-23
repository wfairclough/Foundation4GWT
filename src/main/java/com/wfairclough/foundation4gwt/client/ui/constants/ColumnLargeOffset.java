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
package com.wfairclough.foundation4gwt.client.ui.constants;

import com.wfairclough.foundation4gwt.client.ui.base.Style;

/**
* Large Offset sizes for Zurb Foundation Grid
* 
* @since 1.0.0
* 
* @author Will Fairclough
* 
*/
public enum ColumnLargeOffset implements Style {

	DEFAULT(""), 
	LARGE_OFFSET_1("large-offset-1"),
	LARGE_OFFSET_2("large-offset-2"),
	LARGE_OFFSET_3("large-offset-3"),
	LARGE_OFFSET_4("large-offset-4"),
	LARGE_OFFSET_5("large-offset-5"),
	LARGE_OFFSET_6("large-offset-6"),
	LARGE_OFFSET_7("large-offset-7"),
	LARGE_OFFSET_8("large-offset-8"),
	LARGE_OFFSET_9("large-offset-9"),
	LARGE_OFFSET_10("large-offset-10"),
	LARGE_OFFSET_11("large-offset-11"),
	LARGE_OFFSET_12("large-offset-12");
	
	private String className;

	private ColumnLargeOffset(String className) {
		this.className = className;
	}

	public String get() {
		return className;
	}

	public String getWithoutPrefix() {
		return className;
	}
}