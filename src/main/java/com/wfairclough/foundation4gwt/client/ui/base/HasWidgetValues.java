package com.wfairclough.foundation4gwt.client.ui.base;

import java.util.List;

import com.wfairclough.foundation4gwt.client.ui.widget.ComboBox;

/**
 * Implement on widgets that can have multiple selectable widget values 
 * such as {@link ComboBox}
 * 
 * @since 1.0.0
 * 
 * @author Will Fairclough
 *
 */
public interface HasWidgetValues<T> {

	/**
	 * Set the widget values for widgets that have multiple values 
	 * to select.
	 * 
	 * @param widgetValues an Enum class to use to constants from.
	 * 
	 * @return a list of WidgetItems T
	 */
	public <W extends Enum<W> & WidgetValues> List<T> setWidgetValues(Class<W> widgetValuesEnums);
	
	/**
	 * Set the widgets values by a list of WidgetValues constants values.
	 * 
	 * @param widgetValuesEnums the array of WidgetValues constants.
	 * 
	 * @return a list of WidgetItems T
	 */
	public <W extends WidgetValues> List<T> setWidgetValues(W[] widgetValuesEnums);
}
