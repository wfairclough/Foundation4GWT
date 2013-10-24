package com.wfairclough.foundation4gwt.client.ui.constants;

import com.wfairclough.foundation4gwt.client.ui.base.Style;
import com.wfairclough.foundation4gwt.client.ui.widget.TopBarSection;

/**
 * The positions available to the {@link TopBarSection} ul lists
 */
public enum TopBarPostion implements Style {
	LEFT("left"),
	RIGHT("right");

	String position;
	
	TopBarPostion(String pos) {
		position = pos;
	}
	
	public String get() {
		return position;
	}
	
}