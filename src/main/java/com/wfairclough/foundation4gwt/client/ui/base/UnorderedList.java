package com.wfairclough.foundation4gwt.client.ui.base;

import com.wfairclough.foundation4gwt.client.ui.constants.Constants;


/**
 * Simple wrapper for an HTML {@code <ul>} tag.
 * 
 * @since 1.0.0
 * 
 * @author Carlos Alexandro Becker
 */
public class UnorderedList extends ComplexWidget {

	/**
	 * Creates an empty list.
	 */
	public UnorderedList() {
		super("ul");
	}

	/**
	 * Creates a list and adds the given widgets.
	 * 
	 * @param widgets
	 *            widgets to be added
	 */
	public UnorderedList(ListItem... widgets) {
		this();
		for (ListItem li : widgets) {
			add(li);
		}
	}
	
	public void setUnstyled(boolean unstyled) {
	    setStyleName(Constants.UNSTYLED, unstyled);
	}
}
