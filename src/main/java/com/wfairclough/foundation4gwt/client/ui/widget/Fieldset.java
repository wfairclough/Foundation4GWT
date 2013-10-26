package com.wfairclough.foundation4gwt.client.ui.widget;

import com.wfairclough.foundation4gwt.client.ui.base.ComplexWidget;
import com.wfairclough.foundation4gwt.client.ui.base.TextNode;

public class Fieldset extends ComplexWidget {

	private static String LEGEND = "legend";
	
	private ComplexWidget legendTag = new ComplexWidget(LEGEND);
	private String legend = "";
	
	public Fieldset() {
		super("fieldset");
	}
	
	public void setLegend(String text) {
		legend = text;
		legendTag.clear();
		legendTag.add(new TextNode(text));
		legendTag.removeFromParent();
		add(legendTag);
	}
	
	public String getLegend() {
		return legend;
	}

}
