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

import com.google.gwt.dom.client.Node;
import com.google.gwt.dom.client.Text;
import com.google.gwt.user.client.ui.HasText;
import com.wfairclough.foundation4gwt.client.ui.base.DivWidget;
import com.wfairclough.foundation4gwt.client.ui.base.HasFoundationColor;
import com.wfairclough.foundation4gwt.client.ui.base.HasRadius;
import com.wfairclough.foundation4gwt.client.ui.base.StyleHelper;
import com.wfairclough.foundation4gwt.client.ui.base.TextNode;
import com.wfairclough.foundation4gwt.client.ui.constants.FoundationColor;
import com.wfairclough.foundation4gwt.client.ui.constants.Radius;

public class AlertBox extends DivWidget implements HasRadius, HasFoundationColor, HasText {

	private static String ALERT_BOX_STYLE_CLASS = "alert-box";

	private FoundationColor color = FoundationColor.DEFAULT;
	private Radius radius = Radius.DEFAULT;
	private TextNode text = new TextNode("");
	
	public AlertBox() {
		super();
		StyleHelper.setStyle(this, ALERT_BOX_STYLE_CLASS);
		getElement().setAttribute("data-alert", "");
	}

	/**
	 * {@inheritDoc}
	 */
	public void setRadius(Radius radius) {
		this.radius = radius;
		StyleHelper.changeStyle(this, radius, Radius.class);
	}
	
	public Radius getRadius() {
		return radius;
	}

	/**
	 * {@inheritDoc}
	 */
	public void setFoundationColor(FoundationColor color) {
		this.color = color;
        StyleHelper.changeStyle(this, color, FoundationColor.class);
	}
	
	public FoundationColor getFoundationColor() {
		return color;
	}

	public String getText() {
		return text.getText();
	}

	public void setText(String text) {
		this.text.removeFromParent();
	    this.text = new TextNode(" " + text + " ");
	    this.getElement().appendChild( this.text.getElement() );
//		if ( !this.getElement().isOrHasChild( this.text.getElement() ) ) {
//			Node toRemove = null;
//			for ( int i = 0; i < this.getElement().getChildCount(); i++) {
//				Node n = this.getElement().getChildNodes().getItem( i );
//				if ( n.getNodeType() == 3 /*TEXT_NODE*/ ) {
//					Text t = n.<Text>cast();
//					if ( t.getNodeValue().equals( this.text.getText() ) || t.getNodeValue().equals( text ) ) {
//						toRemove = t;
//					}
//				}
//			}
//			if ( toRemove != null ) {
//				this.getElement().removeChild(toRemove);
//			}
//			this.getElement().appendChild( this.text.getElement() );
//		}
	}
	
}
