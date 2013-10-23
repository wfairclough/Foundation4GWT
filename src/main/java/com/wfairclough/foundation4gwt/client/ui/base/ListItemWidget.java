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

import com.google.gwt.dom.client.Document;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.ComplexPanel;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;

/**
 * A Simple Unordered List Widget
 * 
 * @author Will Fairclough
 *
 */
public class ListItemWidget extends ComplexPanel implements HasId, HasStyle {
	
	private Element li; 
	
	public ListItemWidget() {
		li = Document.get().createLIElement().cast(); 
        setElement(li);
	}
	
	/**
	 * Add a new widget to a li
	 * 
	 * @param child add {@link IsWidget} to li
	 */
	@Override
	public void add(IsWidget child) {
		Widget widget = asWidgetOrNull(child);
        this.li.appendChild(widget.getElement()); 
	}
	
	
	/**
	 * Add a new widget to a li
	 * 
	 * @param child add {@link IsWidget} to li
	 */
	@Override
	public void add(Widget child) {
		this.li.appendChild(child.getElement());
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
    public String getId() {
        return getElement().getId();
    }

    /**
     * {@inheritDoc}
     */
    public void setId(String id) {
        getElement().setId(id);
    }
	
	
}
