package com.wfairclough.foundation4gwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.wfairclough.foundation4gwt.client.ui.resources.ResourceInjector;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Foundation4GWT implements EntryPoint {
  
	
	/**
	 * {@inheritDoc}
	 */
	public void onModuleLoad() {
		ResourceInjector.configure();
	}
	
}
