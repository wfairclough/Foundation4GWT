package com.wfairclough.foundation4gwt.client.ui.widget;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.wfairclough.foundation4gwt.client.ui.base.DivWidget;
import com.wfairclough.foundation4gwt.client.ui.base.HasWidgetValues;
import com.wfairclough.foundation4gwt.client.ui.base.WidgetValues;

public class RadioButtonGroup extends DivWidget implements HasWidgetValues<RadioButton> {

	private static String ADD_WIDGET_RADIO_BTN_GROUP = "Trying to add widget to RadioButtonGroup that can only accept RadioButton Widgets"; 
	private static int RADIO_BTN_COUNT = 0;
	
	private static String RADIO_BTN_GROUP_CLASS = "radio-btn-group";
	private static String RADIO_BTN_GROUP_INLINE_CLASS = "inline";
	
	private List<RadioButton> radioButtonList = new ArrayList<RadioButton>();
	
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
			radioButtonList.add(btn);
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
			radioButtonList.add(btn);
			super.add(btn, getElement());
		} else {
			throw new IllegalArgumentException(ADD_WIDGET_RADIO_BTN_GROUP);
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean remove(int index) {
		radioButtonList.remove(index);
		return super.remove(index);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean remove(IsWidget child) {
		Widget widget = asWidgetOrNull(child);
		radioButtonList.remove(widget);
		return super.remove(child);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean remove(Widget w) {
		radioButtonList.remove(w);
		return super.remove(w);
	}
	
	/**
	 * Get the list of {@link RadioButton RadioButtons} that this {@link RadioButtonGroup} owns.
	 * @return
	 */
	protected List<RadioButton> getRadioButtons()
	{
		return radioButtonList;
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


	/**
	 * {@inheritDoc}
	 */
	public <W extends Enum<W> & WidgetValues> List<RadioButton> setWidgetValues(Class<W> widgetValuesEnums) {
		return setWidgetValues(widgetValuesEnums.getEnumConstants());
	}

	/**
	 * {@inheritDoc}
	 */
	public <W extends WidgetValues> List<RadioButton> setWidgetValues(W[] widgetValuesEnums) {
		List<RadioButton> list = new ArrayList<RadioButton>();
		
		for (WidgetValues wv : widgetValuesEnums) {
			RadioButton rb = new RadioButton();
			rb.setText(wv.getValue());
			list.add(rb);
			add(rb);
		}
		
		return list;
	}

	/**
	 * {@inheritDoc}
	 */
	public <W extends Enum<W> & WidgetValues> void setSelectedWidgetValue(W widgetValue) {
		for (RadioButton item : getRadioButtons()) {
			if (item.getText().equals(widgetValue.getValue())) {
				item.setValue(true);
				break;
			}
		}
	}
	
}
