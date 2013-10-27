/*
 *  Copyright 2013 Foundation4GWT
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.wfairclough.foundation4gwt.client.ui.resources;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;

/**
 * Interface that provides the Zurb Foundation resources.
 * 
 * @since 1.0.0
 * 
 * @author Will Fairclough
 */
public interface Resources extends ClientBundle {

	public static Resources RESOURCES = GWT.create(Resources.class);

	/**
	 * Returns the Zurb Foundation CSS file.
	 * <p>
	 * Override this method to use your own CSS file.
	 * 
	 * @return the Zurb Foundation CSS file
	 */
	@Source("css/foundation.min.css")
	TextResource foundationMinCss();
	
	/**
	 * Returns the Zurb Foundation CSS file.
	 * <p>
	 * Override this method to use your own CSS file.
	 * 
	 * @return the Zurb Foundation CSS file
	 */
	@Source("css/foundation.css")
	TextResource foundationCss();
	
	/**
	 * Returns the Foundation4GWT CSS file.
	 * 
	 * @return the Foundation4GWT CSS file
	 */
	@Source("css/foundation4gwt.css")
	TextResource foundation4GwtCss();
	
	/**
	 * 
	 * @return
	 */
	@Source("css/normalize.css")
	TextResource normalizeCss();
	
	/**
	 * 
	 * @return
	 */
	@Source("js/vendor/jquery.js")
	TextResource jquery();
	
	/**
	 * 
	 * @return
	 */
	@Source("js/vendor/zepto.js")
	TextResource zepto();
	
	/**
	 * 
	 * @return
	 */
	@Source("js/vendor/custom.modernizr.js")
	TextResource modernizr();

	/**
	 * The Zurb Foundation JavaScript
	 * 
	 * @return the Zurb Foundation JavaScript
	 */
	@Source("js/foundation/foundation.js")
	TextResource foundationJs();
	
	
	/**
	 * The Zurb Foundation JavaScript
	 * 
	 * @return the Zurb Foundation JavaScript
	 */
	@Source("js/foundation.min.js")
	TextResource foundationMinJs();

}
