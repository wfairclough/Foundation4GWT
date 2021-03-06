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
package com.wfairclough.foundation4gwt.client.ui.base;

import com.google.gwt.user.client.ui.Anchor;

/**
 * A Basic Anchor widget
 * 
 * @author Will Fairclough
 *
 */
public class BasicAnchor extends Anchor implements HasHref, HasStyle {

	public BasicAnchor() {
		super();
		getElement().setClassName("");
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

	/**
	 * {@inheritDoc}
	 */
	public void setStyle(String style) {
		StyleHelper.setStyle(this, style);		
	}

	/**
	 * {@inheritDoc}
	 */
	public void addStyle(String style) {
		StyleHelper.addStyle(this, style);
	}

	/**
	 * {@inheritDoc}
	 */
	public void removeStyle(String style) {
		StyleHelper.removeStyle(this, style);		
	}

	
}
