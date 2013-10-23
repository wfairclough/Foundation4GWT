package com.wfairclough.foundation4gwt.client.ui.constants;

import com.wfairclough.foundation4gwt.client.ui.base.Style;

/**
* Color of a Foundation {@link Widget Widget}.
* 
* @since 1.0.0
* 
* @author Will Fairclough

*/
public enum PanelStyle implements Style {

	DEFAULT(""), CALLOUT("callout");
	
	private String className;

	private PanelStyle(String className) {
		this.className = className;
	}

	public String get() {
		return className;
	}

	public String getWithoutPrefix() {
		return className;
	}
}