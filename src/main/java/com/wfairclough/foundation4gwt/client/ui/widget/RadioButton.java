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
import com.google.gwt.dom.client.EventTarget;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.HasValue;
import com.wfairclough.foundation4gwt.client.ui.base.ComplexWidget;
import com.wfairclough.foundation4gwt.client.ui.base.TextNode;
import com.wfairclough.foundation4gwt.client.ui.constants.Constants;

public class RadioButton extends ComplexWidget implements HasText, HasValue<Boolean>, HasClickHandlers {

	private static int RADIO_BTN_COUNT = 0;
	
	private String name = "";
	private ComplexWidget radioInput = new ComplexWidget("input");
	private ComplexWidget radioSpan = new ComplexWidget("span");
	private TextNode text = new TextNode("");
	
	private boolean valueChangeHandlerInitialized = false;
	boolean oldValue;
	
	public RadioButton() {
		this("radio-btn-" + RADIO_BTN_COUNT++);
	}
	
	public RadioButton(String name) {
		super("label");
		setName(name);
		
		radioInput.setClassName("hidden-field");
		radioInput.getElement().setAttribute("required", "");
		radioInput.getElement().setAttribute("type", "radio");
		radioSpan.setClassName("radio custom");
		
		super.add(radioInput);
		super.add(radioSpan);
		super.add(text);
	}

	public String getText() {
		return text.getText();
	}

	public void setText(String text) {
		this.text.removeFromParent();
		this.text = new TextNode(" " + text);
		getElement().appendChild(this.text.getElement());
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		getElement().setAttribute("for", name);
		radioInput.getElement().setAttribute("name", name);
		radioInput.setId(name);
	}

	
	/**
	 * {@inheritDoc}
	 */
	public HandlerRegistration addValueChangeHandler(ValueChangeHandler<Boolean> handler) {
	    if (!valueChangeHandlerInitialized) {
	        ensureDomEventHandlers();
	        valueChangeHandlerInitialized = true;
	      }
	      return addHandler(handler, ValueChangeEvent.getType());
	}
	
	/**
	 * No-op. CheckBox's click handler is no good for radio button, so don't use
	 * it. Our event handling is all done in {@link #onBrowserEvent}
	 */
	protected void ensureDomEventHandlers() {
	}
	

	/**
	 * Overridden to send ValueChangeEvents only when appropriate.
	 */
	@Override
	public void onBrowserEvent(Event event) {
		switch (DOM.eventGetType(event)) {
			case Event.ONMOUSEUP:
			case Event.ONBLUR:
			case Event.ONKEYDOWN:
				// Note the old value for onValueChange purposes (in ONCLICK case)
				oldValue = getValue();
				break;

			case Event.ONCLICK:
				EventTarget target = event.getEventTarget();
				if (Element.is(target) && radioInput.getElement().isOrHasChild(Element.as(target))) {

					// They clicked the label. Note our pre-click value, and
					// short circuit event routing so that other click handlers
					// don't hear about it
					oldValue = getValue();
					return;
				}

				// It's not the label. Let our handlers hear about the
				// click...
				super.onBrowserEvent(event);
				// ...and now maybe tell them about the change
				ValueChangeEvent.fireIfNotEqual(RadioButton.this, oldValue, getValue());
				return;
		}

		super.onBrowserEvent(event);
	}
	

	/**
	 * {@inheritDoc}
	 */
	public Boolean getValue() {
		return radioSpan.getStyleName().contains(Constants.CHECKED);
	}

	/**
	 * {@inheritDoc}
	 */
	public void setValue(Boolean value) {
		setValue(value, true);
	}

	/**
	 * {@inheritDoc}
	 */
	public void setValue(Boolean enabled, boolean fireEvents) {
		if (enabled == null)
			enabled = Boolean.FALSE;
	
		Boolean oldValue = getValue();
		
		if (oldValue.equals(enabled))
			return;
		
		if (enabled) {
			radioSpan.getElement().addClassName(Constants.CHECKED);
		} else {
			radioSpan.getElement().removeClassName(Constants.CHECKED);
		}
		
		
		if (fireEvents) {
			ValueChangeEvent.fire(this, enabled);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public HandlerRegistration addClickHandler(ClickHandler handler) {
		return addDomHandler(handler, ClickEvent.getType());
	}


}
