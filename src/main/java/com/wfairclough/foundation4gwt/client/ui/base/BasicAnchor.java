package com.wfairclough.foundation4gwt.client.ui.base;

import com.google.gwt.user.client.ui.Anchor;

/**
 * A Basic Anchor widget
 * 
 * @author Will Fairclough
 *
 */
public class BasicAnchor extends Anchor implements HasHref {

	public BasicAnchor() {
		super();
	}

	/**
	 * {@inheritDoc}
	 */
	public void setTargetHistoryToken(String targetHistoryToken) {
		setHref("#" + targetHistoryToken);
	}

	/**
	 * {@inheritDoc}
	 */
	public String getTargetHistoryToken() {
		String[] hrefs = getHref().split("#");
		return hrefs[1];
	}
	
}
