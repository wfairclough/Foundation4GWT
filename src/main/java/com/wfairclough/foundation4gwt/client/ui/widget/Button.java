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

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.dom.client.Style.TextDecoration;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.DomEvent;
import com.google.gwt.user.client.ui.Anchor;
import com.wfairclough.foundation4gwt.client.ui.base.HasFoundationSize;
import com.wfairclough.foundation4gwt.client.ui.base.HasFoundationColor;
import com.wfairclough.foundation4gwt.client.ui.base.HasRadius;
import com.wfairclough.foundation4gwt.client.ui.base.StyleHelper;
import com.wfairclough.foundation4gwt.client.ui.constants.FoundationSize;
import com.wfairclough.foundation4gwt.client.ui.constants.Constants;
import com.wfairclough.foundation4gwt.client.ui.constants.FoundationColor;
import com.wfairclough.foundation4gwt.client.ui.constants.Radius;

/**
 * A Basic Button that can be customized with Foundation styles
 * 
 * @since 1.0.0
 * 
 * @author Will Fairclough
 *
 */
public class Button extends Anchor implements HasFoundationColor, HasFoundationSize, HasRadius {

	private static String BUTTON_STYLE_CLASS = "button";
	
	private FoundationSize size = FoundationSize.DEFAULT;
	private FoundationColor color = FoundationColor.DEFAULT;
	private Radius radius = Radius.DEFAULT;
	
	public Button() {
		StyleHelper.setStyle(this, BUTTON_STYLE_CLASS);
		setTextUnderline(false);
	}
	
	public Button(ClickHandler handler) {
		this();
		addClickHandler(handler);
	}
	
	public Button(String text) {
		this();
		setText(text);
	}
	
	/**
     * Programmatic equivalent of the user clicking the button.
     */
    public void click() {
        NativeEvent event = Document.get().createClickEvent(0, 0, 0, 0, 0, false, false, false, false);
        DomEvent.fireNativeEvent(event, this);
    }
    
    public boolean isEnabled() {
		return !getStyleName().contains(Constants.DISABLED);
	}
    

	/**
	 * Sets whether the Button is enabled or disabled.
	 * <p>
	 * A disabled widget cannot be used.
	 *
	 * @param enabled
	 *            <code>false</code> if the Button should be disabled. Default:
	 *            <code>true</code>
	 */
	public void setEnabled(boolean enabled) {
		if (enabled)
			removeStyleName(Constants.DISABLED);
		else
			addStyleName(Constants.DISABLED);
	}
	

	/**
	 * {@inheritDoc}
	 */
	public void setFoundationSize(FoundationSize size) {
		this.size = size;
        StyleHelper.changeStyle(this, size, FoundationSize.class);
	}
	
	
	/**
	 * {@inheritDoc}
	 */
	public void setFoundationColor(FoundationColor color) {
		this.color = color;
        StyleHelper.changeStyle(this, color, FoundationColor.class);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void setRadius(Radius radius) {
		this.radius = radius;
		StyleHelper.changeStyle(this, radius, Radius.class);
	}

	public FoundationSize getButtonSize() {
		return size;
	}

	public FoundationColor getFoundationColor() {
		return color;
	}

	public Radius getRadius() {
		return radius;
	}
	
	public void setTextUnderline(boolean enabled) {
		if (enabled)
			getElement().getStyle().clearTextDecoration();
		else 
			getElement().getStyle().setTextDecoration(TextDecoration.NONE);
	}
	
	
}
