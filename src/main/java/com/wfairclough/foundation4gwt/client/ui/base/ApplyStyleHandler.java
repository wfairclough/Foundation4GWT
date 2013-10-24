package com.wfairclough.foundation4gwt.client.ui.base;

/**
 * Callback interface for applying styles
 * 
 * @author Will Fairclough
 *
 */
public interface ApplyStyleHandler {

	void onAddStyle(Style style);
	
	void onRemoveStyle(Style style);
	
	void onSetStyle(Style style);
	
}
