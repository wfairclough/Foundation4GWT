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
import com.wfairclough.foundation4gwt.client.ui.base.HasPanelStyle;
import com.wfairclough.foundation4gwt.client.ui.base.HasRadius;
import com.wfairclough.foundation4gwt.client.ui.base.StyleHelper;
import com.wfairclough.foundation4gwt.client.ui.constants.PanelStyle;
import com.wfairclough.foundation4gwt.client.ui.constants.Radius;

public class FoundationPanel extends DivWidget implements HasRadius, HasPanelStyle {

	private static String PANEL_STYLE_CLASS = "panel";
	
	Radius radius = Radius.DEFAULT;
	PanelStyle panelStyle = PanelStyle.DEFAULT;
	
	public FoundationPanel() {
		super();
		StyleHelper.setStyle(this, PANEL_STYLE_CLASS);
	}
	
	public void setRadius(Radius radius) {
		this.radius = radius;
		StyleHelper.changeStyle(this, radius, Radius.class);
	}

	public void setPanelStyle(PanelStyle style) {
		this.panelStyle = style;
		StyleHelper.changeStyle(this, style, PanelStyle.class);
	}

}
