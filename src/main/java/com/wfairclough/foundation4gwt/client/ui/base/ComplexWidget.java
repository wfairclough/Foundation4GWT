package com.wfairclough.foundation4gwt.client.ui.base;

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.ComplexPanel;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

/**
 * A widget that can have several child widgets.
 * <p>
 * Base of a lot of other components :)
 * 
 * @since 1.0.0
 * 
 * @author Carlos Alexandro Becker
 * @author Will Fairclough
 */
public class ComplexWidget extends ComplexPanel implements HasWidgets,
		HasStyle {

	/**
	 * Creates a new widget that is based on the provided html tag.
	 * 
	 * @param tag
	 *            the html tag used for this widget
	 */
	public ComplexWidget(String tag) {
		setElement(DOM.createElement(tag));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void add(Widget w) {
		add(w, getElement());
	}

	/**
	 * Inserts another widget into this one.
	 * 
	 * @param w
	 *            the widget to be inserted
	 * @param beforeIndex
	 *            the index of the position before which it should be set
	 */
	public void insert(Widget w, int beforeIndex) {
		insert(w, getElement(), beforeIndex, true);
	}

	/**
	 * {@inheritDoc}
	 */
	public void setStyle(Style style) {
		StyleHelper.setStyle(this, style);
	}

	/**
	 * {@inheritDoc}
	 */
	public void addStyle(Style style) {
		StyleHelper.addStyle(this, style);
	}

	/**
	 * {@inheritDoc}
	 */
	public void removeStyle(Style style) {
		StyleHelper.removeStyle(this, style);
	}
}
