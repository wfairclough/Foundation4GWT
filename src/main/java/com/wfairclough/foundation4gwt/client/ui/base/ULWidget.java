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
import com.google.gwt.dom.client.UListElement;
import com.google.gwt.user.client.ui.ComplexPanel;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;

/**
 * A Simple Unordered List Widget
 * 
 * @author Will Fairclough
 *
 */
public class ULWidget extends ComplexPanel implements HasId, HasStyle {
	
	private static String ADD_LIST_ITEM_ERROR = "Trying to add a widget to a panel that only accepts ListItemWidget.";
	
	private UListElement list; 
	
	/**
	 * Default Constructor to create {@link ULWidget} instance
	 */
	public ULWidget() {
		list = Document.get().createULElement(); 
        setElement(list); 
	}
	
	/**
	 * Create a {@link ULWidget} instance with style
	 * 
	 * @param style to set
	 */
	public ULWidget(Style style) {
		this();
		setStyle(style);
	}

	/**
	 * Add a new li element to the unordered list
	 * 
	 * @param child add {@link ListItemWidget} to unordered list
	 */
	@Override
	public void add(IsWidget child) {
        Widget widget = asWidgetOrNull(child);
		
		if (widget != null && (child instanceof ListItemWidget) ) {
			ListItemWidget li = (ListItemWidget)widget;
			list.appendChild(li.getElement());
		} else {
			throw new IllegalArgumentException(ADD_LIST_ITEM_ERROR);
		}
	}
	
	
	/**
	 * Add a new li element to the unordered list
	 * 
	 * @param child add {@link ListItemWidget} to unordered list
	 */
	@Override
	public void add(Widget child) {
		if ((child instanceof ListItemWidget) ) {
			ListItemWidget li = (ListItemWidget)child;
			list.appendChild(li.getElement());
		} else {
			throw new IllegalArgumentException(ADD_LIST_ITEM_ERROR);
		}
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
