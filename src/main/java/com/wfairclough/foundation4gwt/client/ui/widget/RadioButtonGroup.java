package com.wfairclough.foundation4gwt.client.ui.widget;

import java.util.HashSet;

import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.wfairclough.foundation4gwt.client.ui.base.DivWidget;

public class RadioButtonGroup extends DivWidget {

	private static String ADD_WIDGET_RADIO_BTN_GROUP = "Trying to add widget to RadioButtonGroup that can only accept RadioButton Widgets"; 
	
	private HashSet<RadioButton> radioButtons = new HashSet<RadioButton>();
	
	public RadioButtonGroup() {
		super();
	}
	

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void add(IsWidget child) {
		Widget widget = asWidgetOrNull(child);
		
		if (widget != null && (child instanceof RadioButton) ) {
			RadioButton btn = (RadioButton)widget;
			radioButtons.add(btn);
			super.add(btn, getElement());
		} else {
			throw new IllegalArgumentException(ADD_WIDGET_RADIO_BTN_GROUP);
		}
	}
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void add(Widget child) {
		if (child instanceof RadioButton) {
			RadioButton btn = (RadioButton)child;
			radioButtons.add(btn);
			super.add(btn, getElement());
		} else {
			throw new IllegalArgumentException(ADD_WIDGET_RADIO_BTN_GROUP);
		}
	}
	
	/**
	 * Set the name of all the RadioButtons in the group.
	 * 
	 * @param name
	 */
	public void setName(String name) {
		for (RadioButton btn : radioButtons) {
			btn.setName(name);
		}
	}
	
}
