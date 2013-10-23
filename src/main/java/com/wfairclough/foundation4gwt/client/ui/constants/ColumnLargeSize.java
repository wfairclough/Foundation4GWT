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
* Size of a {@link com.ButtonFnd.gwtbootstrap.client.ui.Button Button.}
* 
* @since 2.0.4.0
* 
* @author Dominik Mayer
* 
* @see <a href="http://twitter.github.com/bootstrap/base-css.html#buttons">Bootstrap documentation</a>
* 
*/
public enum ColumnLargeSize implements Style {

	DEFAULT(""), 
	LARGE_1("large-1"),
	LARGE_2("large-2"),
	LARGE_3("large-3"),
	LARGE_4("large-4"),
	LARGE_5("large-5"),
	LARGE_6("large-6"),
	LARGE_7("large-7"),
	LARGE_8("large-8"),
	LARGE_9("large-9"),
	LARGE_10("large-10"),
	LARGE_11("large-11"),
	LARGE_12("large-12");
	
	private String className;

	private ColumnLargeSize(String className) {
		this.className = className;
	}

	public String get() {
		return className;
	}

	public String getWithoutPrefix() {
		return className;
	}
}