package com.wfairclough.foundation4gwt.client.ui.widget;

import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.wfairclough.foundation4gwt.client.ui.base.DivWidget;

public class RadioButtonGroup extends DivWidget {

	private static String ADD_WIDGET_RADIO_BTN_GROUP = "Trying to add widget to RadioButtonGroup that can only accept RadioButton Widgets"; 
	private static int RADIO_BTN_COUNT = 0;
	
	private static String RADIO_BTN_GROUP_CLASS = "radio-btn-group";
	private static String RADIO_BTN_GROUP_INLINE_CLASS = "inline";
	
	public RadioButtonGroup() {
		super();
		RADIO_BTN_COUNT++; // Increase Radio Button Group count
		setStyle(RADIO_BTN_GROUP_CLASS);
		setInline(false);
	}
	

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void add(IsWidget child) {
		Widget widget = asWidgetOrNull(child);
		
		if (widget != null && (child instanceof RadioButton) ) {
			RadioButton btn = (RadioButton)widget;
			btn.setName(RADIO_BTN_GROUP_CLASS + RADIO_BTN_COUNT);
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
			btn.setName(RADIO_BTN_GROUP_CLASS + RADIO_BTN_COUNT);
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
		for (Widget w : getChildren()) {
			if (w instanceof RadioButton) {
				RadioButton btn = (RadioButton)w;
				btn.setName(name);
			}
		}
	}
	
	
	
	public void setInline(boolean enabled) {
		if (enabled) {
			addStyle(RADIO_BTN_GROUP_INLINE_CLASS);
			if (getChildren().size() > 0) {
				getChildren().get(0).getElement().addClassName("first");
			}
		} else {
			removeStyle(RADIO_BTN_GROUP_INLINE_CLASS);
			for (Widget w : getChildren()) {
				if (w instanceof RadioButton) {
					RadioButton btn = (RadioButton)w;
					btn.removeStyle("first");
				}
			}
		}
	}
	
}
