package com.wfairclough.foundation4gwt.client.ui.constants;

import com.wfairclough.foundation4gwt.client.ui.base.Style;

/**
* Size of a {@link com.ButtonFnd.gwtbootstrap.client.ui.Button Button.}
* 
* @since 2.0.4.0
* 
* @author Dominik Mayer
* 
* @see <a href="http://twitter.github.com/bootstrap/base-css.html#buttons">Bootstrap documentation</a>
* 
*/
public enum ColumnSmallOffset implements Style {

	DEFAULT(""), 
	SMALL_OFFSET_1("small-offset-1"),
	SMALL_OFFSET_2("small-offset-2"),
	SMALL_OFFSET_3("small-offset-3"),
	SMALL_OFFSET_4("small-offset-4"),
	SMALL_OFFSET_5("small-offset-5"),
	SMALL_OFFSET_6("small-offset-6"),
	SMALL_OFFSET_7("small-offset-7"),
	SMALL_OFFSET_8("small-offset-8"),
	SMALL_OFFSET_9("small-offset-9"),
	SMALL_OFFSET_10("small-offset-10"),
	SMALL_OFFSET_11("small-offset-11"),
	SMALL_OFFSET_12("small-offset-12");
	
	private String className;

	private ColumnSmallOffset(String className) {
		this.className = className;
	}

	public String get() {
		return className;
	}

	public String getWithoutPrefix() {
		return className;
	}
}