package com.wfairclough.foundation4gwt.client.ui.widget;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
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

	public HandlerRegistration addValueChangeHandler(ValueChangeHandler<Boolean> handler) {
		return null;
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
