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

import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.DOM;
import com.wfairclough.foundation4gwt.client.ui.base.BasicAnchor;
import com.wfairclough.foundation4gwt.client.ui.base.ComplexWidget;
import com.wfairclough.foundation4gwt.client.ui.base.ListItem;
import com.wfairclough.foundation4gwt.client.ui.base.TextNode;
import com.wfairclough.foundation4gwt.client.ui.base.UnorderedList;

/**
 * The title of the Navigation TopBar
 * 
 * @author Will Fairclough
 *
 */
public class TopBarTitle extends UnorderedList {

	private static String TITLE_AREA = "title-area";
	private static String NAME_CLASS = "name";
	private static String TOGGLE_TOP_BAR_MENU_ICON = "toggle-topbar menu-icon";
	
	private static String DEFAULT = "";
	private static String MENU = "MENU";
	
	private ListItem nameLi = new ListItem();
	private ListItem toggleTopBarLi = new ListItem();
	private BasicAnchor titleAnchor = new BasicAnchor();
	private ComplexWidget menuAnchor = new ComplexWidget("a");
	private TextNode text = new TextNode();
	
	public TopBarTitle() {
		super();
		setupWithNameMenu(DEFAULT, MENU);
	}
	
	public TopBarTitle(String title, String menu) {
		super();
		setupWithNameMenu(title, menu);
	}
	
	public TopBarTitle(String title) {
		super();
		setupWithNameMenu(title, MENU);
	}
	
	private void setupWithNameMenu(String title, String menu) {
		setStyleName(TITLE_AREA);
		
		setTitleText(title);
		Element h1 = DOM.createElement("h1");
		h1.appendChild(titleAnchor.getElement());
		nameLi.getElement().appendChild(h1);
		
		nameLi.setStyleName(NAME_CLASS);
		add(nameLi, getElement());
		
		setMenuTitle(menu);
		ComplexWidget span = new ComplexWidget("span");
		span.add(text);
		menuAnchor.add(span);
		
		toggleTopBarLi.add(menuAnchor);
		toggleTopBarLi.setStyleName(TOGGLE_TOP_BAR_MENU_ICON);
		add(toggleTopBarLi, getElement());
	}
	
	/**
	 * Set the text for the Small Menu expandable item
	 * 
	 * @param title
	 */
	public void setMenuTitle(String title) {
		text.setText((title != null) ? title : MENU);
	}

	/**
	 * Set the Text for the title of the TopBar
	 */
	public void setTitleText(String title) {
		titleAnchor.setText((title != null) ? title : DEFAULT);
	}
	
	/*
<ul class="title-area">
          <!-- Title Area -->
          <li class="name">
            <h1><a href="#">Clickable Top Bar</a></h1>
          </li>
          <!-- Remove the class "menu-icon" to get rid of menu icon. Take out "Menu" to just have icon alone -->
          <li class="toggle-topbar menu-icon"><a href="#"><span>Menu</span></a></li>
        </ul>
	 */
}
