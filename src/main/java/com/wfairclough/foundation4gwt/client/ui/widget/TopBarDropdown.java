/*
 *  Copyright 2013 Foundation4GWT
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.wfairclough.foundation4gwt.client.ui.widget;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.wfairclough.foundation4gwt.client.ui.base.BasicAnchor;
import com.wfairclough.foundation4gwt.client.ui.base.HasHref;
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
