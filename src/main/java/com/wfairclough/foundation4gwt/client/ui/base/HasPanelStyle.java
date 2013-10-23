package com.wfairclough.foundation4gwt.client.ui.base;

import com.wfairclough.foundation4gwt.client.ui.constants.PanelStyle;

/**
 * Interface for components that have a {@link PanelStyle}
 * 
 * @since 1.0.0
 * 
 * @author Will Fairclough
 * 
 */
public interface HasPanelStyle {

	/**
	 * Replaces the widet's panel style.
	 * 
	 * @param style
	 *            the panel style to apply to the widget
	 */
	void setPanelStyle(PanelStyle style);

}
