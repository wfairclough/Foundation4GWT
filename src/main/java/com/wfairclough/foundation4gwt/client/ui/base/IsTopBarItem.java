package com.wfairclough.foundation4gwt.client.ui.base;


/**
 * Interface for all TopBarItems
 * 
 * @author Will Fairclough
 *
 */
public interface IsTopBarItem {

	/**
	 * Get the list of all styles for the list item that encapsulates this item.
	 * 
	 * @param styles apply the set of styles.
	 * 
	 * @return String value of styles
	 */
//	String getListStyles(Set<TopBarItemStyle> styles);
	
	/**
	 * Setup a handler to apply styles
	 * 
	 * @param handler
	 */
	void setApplyStyleHandler(ApplyStyleHandler handler);
	

	/**
	 * Replaces the widet's style with the provided one.
	 * 
	 * @param style
	 *            the style to be applied to the Widget.
	 */
	void setListItemStyle(Style style);

	/**
	 * Adds the provided style to the widget.
	 * 
	 * @param style
	 *            the style to be added to the Widget.
	 */
	void addListItemStyle(Style style);

	/**
	 * Removes the provided style from the widget.
	 * 
	 * @param style
	 *            the style to be removed from the Widget.
	 */
	void removeListItemStyle(Style style);
	
	
	
}
