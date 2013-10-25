package com.wfairclough.foundation4gwt.client.ui.widget;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.wfairclough.foundation4gwt.client.ui.base.BasicAnchor;
import com.wfairclough.foundation4gwt.client.ui.base.HasHref;
import com.wfairclough.foundation4gwt.client.ui.base.TopBarItem;
import com.wfairclough.foundation4gwt.client.ui.base.UnorderedList;


public class TopBarDropdown extends TopBarItem implements HasHref, HasClickHandlers {
	private static String HAS_DROPDOWN = "has-dropdown";
	private static String DROPDOWN = "dropdown";
	
	private UnorderedList ulDropdown = new UnorderedList();
	private BasicAnchor anchor = new BasicAnchor();
	
	public TopBarDropdown() {
		super();
		getElement().setClassName(HAS_DROPDOWN);
		ulDropdown.getElement().setClassName(DROPDOWN);
		super.add(anchor);
		super.add(ulDropdown);
	}
	
	
	@Override
	public void add(IsWidget child) {
		ulDropdown.add(child);
	}
	
	@Override
	public void add(Widget child) {
		ulDropdown.add(child);
	}
	
	public String getLinkText() {
		return anchor.getText();
	}

	public void setLinkText(String text) {
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
