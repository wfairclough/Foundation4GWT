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

import com.google.gwt.user.client.ui.HasText;
import com.wfairclough.foundation4gwt.client.ui.base.ComplexWidget;
import com.wfairclough.foundation4gwt.client.ui.base.TextNode;

/**
 * A Simple {@code <p>} widget with text.
 * 
 * @since 1.0.0
 * 
 * @author Will Fairclough
 *
 */
public class ParagraphWidget extends ComplexWidget implements HasText {

	private TextNode textNode = new TextNode("");
	
	/**
	 * Creates a simple {@code <p>} element with text
	 */
	public ParagraphWidget() {
		super("p");
		add(textNode);
	}
	
	public ParagraphWidget(String text) {
		this();
		setText(text);
	}

	/**
	 * {@inheritDoc}
	 */
	public String getText() {
		return textNode.getText();
	}

	/**
	 * {@inheritDoc}
	 */
	public void setText(String text) {
		textNode.removeFromParent();
		textNode = new TextNode(text);
		add(textNode);
	}
	
}
