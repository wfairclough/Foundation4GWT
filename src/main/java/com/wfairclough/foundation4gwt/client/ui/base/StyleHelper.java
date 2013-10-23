package com.wfairclough.foundation4gwt.client.ui.base;

import com.google.gwt.user.client.ui.UIObject;

/**
 * The Helper class for {@link HasStyle} interface.
 *
 * @since 1.0.0
 *
 * @see Style
 *
 * @author ohashi keisuke
 * @author Carlos A Becker
 * @author Will Fairclough
 * 
 */
public class StyleHelper {

	/**
	 * Adds the provided style to the widget.
	 *
	 * @param widget
	 *            the widget to be added style.
	 * @param style
	 *            the style to be added to the Widget.
	 */
	public static <T extends UIObject> void addStyle(T widget, Style style) {
	    
	    if(style == null || style.get().isEmpty()) {
	        return;
	    }
	    
	    widget.addStyleName(style.get());
	}

	/**
	 * Replaces the widget's style with the provided one.
	 *
	 * @param widget
	 *            the widget to be applied style.
	 * @param style
	 *            the style to be applied to the Widget.
	 */
	public static <T extends UIObject> void setStyle(T widget, Style style) {
		widget.setStyleName(style.get());
	}
	
	/**
	 * Replaces the widget's style with the provided one.
	 *
	 * @param widget
	 *            the widget to be applied style.
	 * @param style
	 *            the style to be applied to the Widget.
	 */
	public static <T extends UIObject> void setStyle(T widget, String style) {
		widget.setStyleName(style);
	}

	/**
	 * Removes the provided style from the widget.
	 *
	 * @param widget
	 *            the widget to be removed style.
	 * @param style
	 *            the style to be removed from the Widget.
	 */
	public static <T extends UIObject> void removeStyle(T widget, Style style) {
		String styleString = style.get();

		if (!styleString.isEmpty()) {
			widget.removeStyleName(styleString);
		}
	}

	/**
	 * Change the style.
	 * @param widget the widget to be changed style.
	 * @param style the style to be applied to the widget.
	 * @param styleEnums other styles.
	 */
	public static <S extends Enum<S> & Style> void changeStyle(UIObject widget, S style,Class<S> styleEnums) {
		assert styleEnums != null : "styleEnums should not be null.";

		changeStyle(widget, style, styleEnums.getEnumConstants());
	}

	/**
	 * Change the style.
	 * @param widget the widget to be changed style.
	 * @param style the style to be applied to the widget.
	 * @param otherStyles other styles.
	 */
	public static <S extends Style> void changeStyle(UIObject widget,S style,S[] otherStyles) {

		assert widget != null && otherStyles != null : "any args should not be null.";

		for(S s : otherStyles) {
			removeStyle(widget, s);
		}

		addStyle(widget, style);
	}

	/**
	 * Helper method to add a style name.
	 * 
	 * @param widget the widget to add the style frome
	 * @param style the style to add to the widget
	 */
	public static void addStyle(UIObject widget, String style) {
		widget.addStyleName(style);
	}
	
	/**
	 * Helper method to remove a style name.
	 * 
	 * @param widget the widget to remove the style frome
	 * @param style the style to remove to the widget
	 */
	public static void removeStyle(UIObject widget, String style) {
		widget.removeStyleName(style);
	}
	
}
