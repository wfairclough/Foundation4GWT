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
