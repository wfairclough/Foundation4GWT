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

import com.wfairclough.foundation4gwt.client.ui.base.ComplexWidget;
import com.wfairclough.foundation4gwt.client.ui.base.TextNode;

public class Fieldset extends ComplexWidget {

	private static String LEGEND = "legend";
	
	private ComplexWidget legendTag = new ComplexWidget(LEGEND);
	private String legend = "";
	
	public Fieldset() {
		super("fieldset");
	}
	
	public void setLegend(String text) {
		legend = text;
		legendTag.clear();
		legendTag.add(new TextNode(text));
		legendTag.removeFromParent();
		add(legendTag);
	}
	
	public String getLegend() {
		return legend;
	}

}
