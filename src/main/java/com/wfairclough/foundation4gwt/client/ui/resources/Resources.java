/*
 *  Copyright 2012 GWT-Bootstrap
 *
 *	Modified for use in Foundation4GWT
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
	 * Returns the Bootstrap CSS file.
	 * <p>
	 * Override this method to use your own CSS file.
	 * 
	 * @return the Bootstrap CSS file
	 */
	// Imported as a TextResource until GWT supports CSS3.
	@Source("css/foundation.min.css")
	TextResource foundationMinCss();
	
	/**
	 * Returns the Bootstrap CSS file.
	 * <p>
	 * Override this method to use your own CSS file.
	 * 
	 * @return the Bootstrap CSS file
	 */
	// Imported as a TextResource until GWT supports CSS3.
	@Source("css/foundation.css")
	TextResource foundationCss();
	
	/**
	 * Returns the Bootstrap CSS file.
	 * <p>
	 * Override this method to use your own CSS file.
	 * 
	 * @return the Bootstrap CSS file
	 */
	// Imported as a TextResource until GWT supports CSS3.
	@Source("css/normalize.css")
	TextResource normalizeCss();
	
	/**
	 * Returns the required jQuery version.
	 * <p>
	 * By default, GWT Bootstrap uses jQuery 1.10.1. Override this method to
	 * provide a different version of jQuery.
	 * 
	 * @return the jQuery JavaScript Library
	 */
	@Source("js/vendor/jquery.js")
	TextResource jquery();
	
	/**
	 * Returns the required jQuery version.
	 * <p>
	 * By default, GWT Bootstrap uses jQuery 1.10.1. Override this method to
	 * provide a different version of jQuery.
	 * 
	 * @return the jQuery JavaScript Library
	 */
	@Source("js/vendor/zepto.js")
	TextResource zepto();
	
	/**
	 * Returns the required jQuery version.
	 * <p>
	 * By default, GWT Bootstrap uses jQuery 1.10.1. Override this method to
	 * provide a different version of jQuery.
	 * 
	 * @return the jQuery JavaScript Library
	 */
	@Source("js/vendor/custom.modernizr.js")
	TextResource modernizr();

	/**
	 * Returns a version of Bootstrap with all plugins included.
	 * <p>
	 * The first three digits in the GWT Bootstrap version number specify the
	 * provided Bootstrap version. (GWT Bootstrap 2.0.4.0 uses Bootstrap 2.0.2.
	 * GWT Bootstrap 2.1.2.3 will use Bootstrap 2.1.2.)
	 * </p>
	 * <p>
	 * 
	 * Override this method to provide a different version of Bootstrap. You
	 * might want to chose a more lightweight implementation without some of the
	 * plugins. <b>This may break some widgets!</b>
	 * 
	 * @return the Bootstrap JavaScript
	 */
	@Source("js/foundation/foundation.js")
	TextResource foundationJs();
	
	
	/**
	 * Returns a version of Bootstrap with all plugins included.
	 * <p>
	 * The first three digits in the GWT Bootstrap version number specify the
	 * provided Bootstrap version. (GWT Bootstrap 2.0.4.0 uses Bootstrap 2.0.2.
	 * GWT Bootstrap 2.1.2.3 will use Bootstrap 2.1.2.)
	 * </p>
	 * <p>
	 * 
	 * Override this method to provide a different version of Bootstrap. You
	 * might want to chose a more lightweight implementation without some of the
	 * plugins. <b>This may break some widgets!</b>
	 * 
	 * @return the Bootstrap JavaScript
	 */
	@Source("js/foundation.min.js")
	TextResource foundationMinJs();

}
