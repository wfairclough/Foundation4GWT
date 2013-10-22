package com.wfairclough.foundation4gwt.client.ui.constants;

import com.wfairclough.foundation4gwt.client.ui.base.Style;

/**
* Color of a Foundation {@link Widget Widget}.
* 
* @since 1.0.0
* 
* @author Will Fairclough

*/
public enum FoundationColor implements Style {

	DEFAULT(""), SECONDARY("secondary"), ALERT("alert"), SUCCESS("success");
	
	private String className;

	private FoundationColor(String className) {
		this.className = className;
	}

	public String get() {
		return className;
	}

	public String getWithoutPrefix() {
		return className;
	}
}