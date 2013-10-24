package com.wfairclough.foundation4gwt.client.ui.base;

import com.google.gwt.user.client.ui.Widget;

/**
 * Simple wrapper for an HTML {@code <li>} tag.
 * 
 * @since 1.0.0
 * 
 * @author Carlos Alexandro Becker
 * @author Will Fairclough
 */
public class ListItem extends ComplexWidget {

	/**
	 * Creates a new ListItem.
	 */
	public ListItem() {
		super("li");
	}

	/**
	 * Creates a new ListItem and adds the given widgets.
	 * 
	 * @param widgets
	 *            widgets to be added.
	 */
	public ListItem(Widget... widgets) {
		this();
		for (Widget w : widgets) {
			add(w);
		}
	}
}
