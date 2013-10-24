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

import com.wfairclough.foundation4gwt.client.ui.base.DataOption;
import com.wfairclough.foundation4gwt.client.ui.widget.TopBar;

/**
* {@link DataOption} for the {@link TopBar}.
* 
* @since 1.0.0
* 
* @author Will Fairclough

*/
public enum TopBarDataOptions implements DataOption {

	STICKY("stickyClass : 'sticky'"), 
	/* CUSTOM_BACK("custom_back_text: true"), 
	BACK_TEXT("back_text: 'Back'"), TODO implement the Custom Back Text*/ 
	IS_HOVER("is_hover: true"), 
	SCROLLTOP("scrolltop : true");
	
	private String dataOption;

	private TopBarDataOptions(String dataOption) {
		this.dataOption = dataOption;
	}

	/**
	 * {@inheritDoc}
	 */
	public String get() {
		return dataOption;
	}
}