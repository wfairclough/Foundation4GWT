package com.wfairclough.foundation4gwt.client.ui.base;

import com.wfairclough.foundation4gwt.client.ui.constants.FoundationColor;

/**
 * Interface for components that have a {@link FoundationColor}
 * 
 * @since 1.0.0
 * 
 * @author Will Fairclough
 * 
 */
public interface HasFoundationColor {

	/**
	 * Replaces the widet's color style.
	 * 
	 * @param color
	 *            the color style to apply to the widget
	 */
	void setFoundationColor(FoundationColor color);

}
