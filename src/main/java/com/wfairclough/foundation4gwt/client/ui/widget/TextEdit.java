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

import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.LabelElement;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.HasKeyPressHandlers;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.TextBox;
import com.wfairclough.foundation4gwt.client.ui.base.DivWidget;
import com.wfairclough.foundation4gwt.client.ui.constants.Constants;

public class TextEdit extends DivWidget implements HasText, HasKeyPressHandlers {

	private static String TEXT_EDIT_STYLE_CLASS = "text-edit";
	private static String DATA_ERROR_MESSAGE = "data-error-message";
	private static int widgetCount = 0;
	
	private TextBox textBox = new TextBox();
	private LabelElement label = DOM.createLabel().cast();
	private Element errorMsg = DOM.createElement(Constants.SMALL);;
	
	private String labelText = "";
	private String labelSmallText = "";
	private String errorMsgText = "";
	
	public TextEdit() {
		String id = TEXT_EDIT_STYLE_CLASS + "-" + widgetCount++;
		textBox.getElement().setAttribute("id", id);
		label.setHtmlFor(id);
		errorMsg.setClassName(Constants.ERROR);
		errorMsg.setAttribute(DATA_ERROR_MESSAGE, "");
		errorMsg.getStyle().setDisplay(Display.NONE);
		getElement().appendChild(label);
		getElement().appendChild(textBox.getElement());
		getElement().appendChild(errorMsg);
	}
	
	public TextEdit(String text) {
		this();
		setText(text);
	}
	
	/**
	 * Set the Text for the Label of the {@link TextEdit} field.
	 * 
	 * @param text to use
	 */
	public void setLabelText(String text)
	{
		labelText = text;
		setLabelHTML();
	}
	
	/**
	 * Set the small Text for the Label of the {@link TextEdit} field.
	 * 
	 * @param text to use
	 */
	public void setLabelSmallText(String text)
	{
		labelSmallText = text;
		setLabelHTML();
	}
	
	private void setLabelHTML()
	{
		label.setInnerHTML(labelText + " <small> " + labelSmallText + " </small>");
	}
	
	public void setPlaceholder(String placeholder) {
		textBox.getElement().setAttribute("placeholder", placeholder);
	}
	
	/**
	 * Sets the {@link TextEdit} to the error color
	 * 
	 * @param enabled Error mode if true otherwise normal
	 */
	public void setError(boolean enabled)
	{
		if (enabled) {
			if (!errorMsgText.equals("")) {
				errorMsg.getStyle().setDisplay(Display.BLOCK);
				getElement().getStyle().clearPaddingBottom();
			} else {
				getElement().getStyle().setPaddingBottom(15.0, Unit.PX);
			}
			addStyleName(Constants.ERROR);
		} else {
			getElement().getStyle().clearPaddingBottom();
			errorMsg.getStyle().setDisplay(Display.NONE);
			removeStyleName(Constants.ERROR);
		}
	}
	
	/**
	 * Check if {@link TextEdit} is in error mode
	 * 
	 * @return true if in error mode otherwise false
	 */
	public boolean isError()
	{
		return getStyleName().contains(Constants.ERROR);
	}

	/**
	 * Set the text of the {@link TextEdit}
	 * 
	 */
	public String getText() {
		return textBox.getText();
	}

	/**
	 * Get the text of the {@link TextEdit}
	 * 
	 * @return {@link TextEdit} text value
	 */
	public void setText(String text) {
		textBox.setText(text);
	}
	
	/**
	 * Sets the Error Message Text for {@link TextEdit}
	 * 
	 * @param text for the Error Message
	 */
	public void setErrorMessage(String text) {
		errorMsgText = text;
		errorMsg.setInnerHTML(errorMsgText);
		
		if (isError())
			errorMsg.getStyle().setDisplay(Display.BLOCK);
	}
	
	public void setPassword(boolean enabled) {
		textBox.getElement().setAttribute("type", "password");
	}

	public int getTabIndex() {
		return textBox.getTabIndex();
	}

	public void setAccessKey(char key) {
		textBox.setAccessKey(key);
	}

	public void setFocus(boolean focused) {
		textBox.setFocus(focused);
	}

	public void setTabIndex(int index) {
		textBox.setTabIndex(index);
	}

	public HandlerRegistration addKeyPressHandler(KeyPressHandler handler) {
		return textBox.addKeyPressHandler(handler);
	}
	
	
}
