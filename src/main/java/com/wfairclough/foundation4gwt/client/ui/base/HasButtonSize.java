package com.wfairclough.foundation4gwt.client.ui.base;

import com.wfairclough.foundation4gwt.client.ui.constants.ButtonSize;

/**
 * Interface for components that have a {@link ButtonSize}
 * 
 * @since 1.0.0
 * 
 * @author Will Fairclough
 * 
 */
public interface HasButtonSize {

	/**
	 * Replaces the widet's size style.
	 * 
	 * @param size
	 *            the size style to apply to the widget
	 */
	void setButtonSize(ButtonSize size);

}
