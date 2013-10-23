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
package com.wfairclough.foundation4gwt.client.ui.widget;

import com.wfairclough.foundation4gwt.client.ui.base.DivWidget;
import com.wfairclough.foundation4gwt.client.ui.base.StyleHelper;

public class Row extends DivWidget {

	private static String ROW_STYLE_CLASS = "row";
	
	public Row() {
		StyleHelper.setStyle(this, ROW_STYLE_CLASS);
	}
	
	public void setFullWidth(boolean enabled)
	{
		if (enabled)
			getElement().getStyle().setProperty("minWidth", "100%");
		else
			getElement().getStyle().setProperty("minWidth", "0%");
	}
	
}
