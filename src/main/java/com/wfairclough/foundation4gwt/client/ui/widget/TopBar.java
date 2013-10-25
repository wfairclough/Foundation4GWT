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

import java.util.HashSet;

import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.wfairclough.foundation4gwt.client.ui.base.DataOption;
import com.wfairclough.foundation4gwt.client.ui.base.HasDataOptions;
import com.wfairclough.foundation4gwt.client.ui.base.NavWidget;
import com.wfairclough.foundation4gwt.client.ui.constants.Constants;

public class TopBar extends NavWidget implements HasDataOptions {

	private static String TOP_BAR_CLASS = "top-bar"; 
	private static String ADD_WIDGET_TOP_BAR = "Trying to add widget to TopBar that can only accept TopBarSection or TopBarTitle Widgets";

	private HashSet<DataOption> dataOptions = new HashSet<DataOption>();

	private TopBarTitle topBarTitle = new TopBarTitle();
	
	/**
	 * Default Constructor to create instance of {@link TopBar}
	 */
	public TopBar() {
		setStyleName(TOP_BAR_CLASS);
		add(topBarTitle);
	}


	/**
	 * Add a {@link TopBarSection} or {@link TopBarTitle} to this {@link TopBar}
	 * 
	 * @param child to add
	 */
	public void add(IsWidget child) {
		Widget widget = asWidgetOrNull(child);
		
		if (widget != null && ((child instanceof TopBarSection) || (child instanceof TopBarTitle)) ) {
			super.add(widget, getElement());
		} else {
			throw new IllegalArgumentException(ADD_WIDGET_TOP_BAR);
		}
	}
	
	
	/**
	 * Add a {@link TopBarSection} or {@link TopBarTitle} to this {@link TopBar}
	 * 
	 * @param child to add
	 */
	public void add(Widget child) {
		if ( (child instanceof TopBarSection) || (child instanceof TopBarTitle) ) {
			super.add(child, getElement());
		} else {
			throw new IllegalArgumentException(ADD_WIDGET_TOP_BAR);
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void addDataOption(DataOption dataOption) {
		dataOptions.add(dataOption);
		setDataOptions(dataOptions);
	}

	/**
	 * {@inheritDoc}
	 */
	public void removeDataOption(DataOption dataOption) {
		dataOptions.remove(dataOption);
		setDataOptions(dataOptions);
	}

	/**
	 * {@inheritDoc}
	 */
	public void clearDataOptions() {
		getElement().removeAttribute(Constants.DATA_OPTIONS);
	}
	
	/**
	 * Create the data-options String value and set the Attribute
	 * 
	 * @param dOpts the set of data-options to set
	 */
	private void setDataOptions(HashSet<DataOption> dOpts) {
		String dataOptionsStr = "";
		
		for (DataOption dataOpt : dataOptions) {
			dataOptionsStr = dataOpt.get() + " ";
		}
		
		getElement().setAttribute(Constants.DATA_OPTIONS, dataOptionsStr);
	}
	
	public void setTitleText(String text)
	{
		topBarTitle.setTitleText(text);
	}
	
}
