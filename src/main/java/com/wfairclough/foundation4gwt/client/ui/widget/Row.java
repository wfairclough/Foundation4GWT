package com.wfairclough.foundation4gwt.client.ui.widget;

import com.wfairclough.foundation4gwt.client.ui.base.DivWidget;
import com.wfairclough.foundation4gwt.client.ui.base.StyleHelper;

public class Row extends DivWidget {

	private static String ROW_STYLE_CLASS = "row";
	
	public Row() {
		StyleHelper.setStyle(this, ROW_STYLE_CLASS);
	}
	
	public void setFullWidth(boolean enabled)
	{
		if (enabled)
			getElement().getStyle().setProperty("minWidth", "100%");
		else
			getElement().getStyle().setProperty("minWidth", "0%");
	}
	
}
