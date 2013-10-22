package com.wfairclough.foundation4gwt.client.ui.constants;

import com.wfairclough.foundation4gwt.client.ui.base.Style;

/**
* Style of {@link Button Button} or {@link ButtonGroup ButtonGroup} corner.
* 
* Radius is rounded corners and round is fully rounded
* 
* @since 1.0.0
* 
* @author Will Fairclough
* 
*/
public enum Radius implements Style {

	DEFAULT(""), RADIUS("radius"), ROUND("round");
	
	private String className;

	private Radius(String className) {
		this.className = className;
	}

	public String get() {
		return className;
	}

	public String getWithoutPrefix() {
		return className;
	}
}