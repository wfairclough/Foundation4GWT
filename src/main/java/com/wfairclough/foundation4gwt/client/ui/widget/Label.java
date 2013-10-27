package com.wfairclough.foundation4gwt.client.ui.widget;

import com.google.gwt.user.client.ui.HasText;
import com.wfairclough.foundation4gwt.client.ui.base.ComplexWidget;
import com.wfairclough.foundation4gwt.client.ui.base.HasFoundationColor;
import com.wfairclough.foundation4gwt.client.ui.base.StyleHelper;
import com.wfairclough.foundation4gwt.client.ui.base.TextNode;
import com.wfairclough.foundation4gwt.client.ui.constants.FoundationColor;
import com.wfairclough.foundation4gwt.client.ui.constants.Radius;

public class Label extends ComplexWidget implements HasFoundationColor, HasText {

	private FoundationColor color = FoundationColor.DEFAULT;
	private Radius radius = Radius.DEFAULT;
	private TextNode textNode = new TextNode("");
	
	public Label() {
		super("span");
		setStyle("label");
		add(textNode);
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


