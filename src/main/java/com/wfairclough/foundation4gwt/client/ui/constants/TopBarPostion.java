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
import com.wfairclough.foundation4gwt.client.ui.widget.TopBarSection;

/**
 * The positions available to the {@link TopBarSection} ul lists
 */
public enum TopBarPostion implements Style {
	LEFT("left"),
	RIGHT("right");

	String position;
	
	TopBarPostion(String pos) {
		position = pos;
	}
	
	public String get() {
		return position;
	}
	
}