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
public enum ColumnSmallSize implements Style {

	DEFAULT(""), 
	SMALL_1("small-1"),
	SMALL_2("small-2"),
	SMALL_3("small-3"),
	SMALL_4("small-4"),
	SMALL_5("small-5"),
	SMALL_6("small-6"),
	SMALL_7("small-7"),
	SMALL_8("small-8"),
	SMALL_9("small-9"),
	SMALL_10("small-10"),
	SMALL_11("small-11"),
	SMALL_12("small-12");
	
	private String className;

	private ColumnSmallSize(String className) {
		this.className = className;
	}

	public String get() {
		return className;
	}

	public String getWithoutPrefix() {
		return className;
	}
}