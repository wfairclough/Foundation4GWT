package com.wfairclough.foundation4gwt.client.ui.widget;

import com.google.gwt.user.client.ui.FlowPanel;
import com.wfairclough.foundation4gwt.client.ui.base.StyleHelper;

public class Row extends FlowPanel {

	private static String ROW_STYLE_CLASS = "row";
	
	public Row() {
		StyleHelper.setStyle(this, ROW_STYLE_CLASS);
	}
	
	public void setFullWidthEnabled(boolean enabled)
	{
		if (enabled)
			getElement().getStyle().setProperty("minWidth", "100%");
		else
			getElement().getStyle().setProperty("minWidth", "0%");
	}
	
}
