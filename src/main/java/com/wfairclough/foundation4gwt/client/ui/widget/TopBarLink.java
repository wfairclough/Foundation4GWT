package com.wfairclough.foundation4gwt.client.ui.widget;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.HasText;
import com.wfairclough.foundation4gwt.client.ui.base.BasicAnchor;
import com.wfairclough.foundation4gwt.client.ui.base.HasHref;
import com.wfairclough.foundation4gwt.client.ui.base.TopBarItem;

public class TopBarLink extends TopBarItem implements HasText, HasHref, HasClickHandlers {

	private BasicAnchor anchor = new BasicAnchor();
	
	/**
	 * Creates Default TopBarLink
	 */
	public TopBarLink() {
		super();
		setStyleName("");
		add(anchor);
	}

	/**
	 * {@inheritDoc}
	 */
	public String getText() {
		return anchor.getText();
	}

	/**
	 * {@inheritDoc}
	 */
	public void setText(String text) {
		anchor.setText(text);
	}

	/**
	 * {@inheritDoc}
	 */
	public void setHref(String href) {
		anchor.setHref(href);
	}

	/**
	 * {@inheritDoc}
	 */
	public String getHref() {
		return anchor.getHref();
	}

	/**
	 * {@inheritDoc}
	 */
	public void setTargetHistoryToken(String targetHistoryToken) {
		anchor.setTargetHistoryToken(targetHistoryToken);
	}

	/**
	 * {@inheritDoc}
	 */
	public String getTargetHistoryToken() {
		return anchor.getTargetHistoryToken();
	}

	/**
	 * {@inheritDoc}
	 */
	public HandlerRegistration addClickHandler(ClickHandler handler) {
		return anchor.addClickHandler(handler);
	}
	
	

	
}
