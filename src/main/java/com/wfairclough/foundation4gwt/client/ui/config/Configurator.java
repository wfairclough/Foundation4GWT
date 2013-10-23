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
package com.wfairclough.foundation4gwt.client.ui.config;

import com.wfairclough.foundation4gwt.client.ui.resources.Resources;


/**
 * <h3>Using custom CSS/JS resources.</h3>
 * 
 * <p>
 * If you need to adapt resources, create your resource package, add your files and implement this interface, then add a
 * <code>replace-with</code> tag and <code>public</code> tag to your module xml. Example:
 * </p>
 * 
 * <p>
 *
 * 1. Create your Resources package and add css,js directory to that (under your module xml package) and add your resources to adove css,
 * js directory. (Bootstarp's css filename should be <code>bootstrap.min.css</code> and Bootstrap's js filename should be <code>bootstrap.min.js</code>)
 * <pre>
 * src/main/java/com/example
 * |-- client
 * |-- resources
 * |   |-- css
 * |   |   `-- bootstrap.min.css < your custom css
 * |   |   `-- bootstrap-responsive.min.css < your custom css
 * |   |-- js
 * |   |   `-- bootstrap.min.js < your custom js
 * |   |-- ExampleConfigurator.java < your custom Configurator class
 * |   `-- ExampleResources.java < your custom Resources interface
 * |-- server
 * |-- shared
 * `-- Example.gwt.xml < your module xml file
 * </pre>
 * 
 * 
 * 2. Create a Resources Interface (extending {@link Resources}) override the
 * getters of the files you want to replace.
 * 
 * <pre>
 * 	public interface MyResources extends Resources {
 * 		{@literal @Source("css/bootstrap.min.css")}
 * 		TextResource bootstrapCss();
 *
 * 		{@literal @Source("css/bootstrap-responsive.min.css")}
 * 		TextResource bootstrapResponsiveCss();
 * 	}
 * </pre>
 * 
 * </p>
 * 
 * <p>
 * 3. Create a <code>Configurator</code>.
 * 
 * <pre>
 * 	public MyConfigurator implements Configurator {
 * 		public Resources getResources() {
 * 			return GWT.create(MyResources.class);
 * 		}
 * 	}
 * </pre>
 * 
 * </p>
 * 
 * <p>
 * 4. Add a <code>replace-with</code> tag, <code>source</code> and <code>public<tag> to your module xml (
 * <code>*.gwt.xml</code>):
 * 
 * <pre>
 * {@literal
 * <source path='resources'/>
 * <replace-with class="com.example.resources.ExampleConfigurator">
 *     <when-type-is class="com.github.gwtbootstrap.client.ui.config.Configurator"/>
 * </replace-with>
 * <public path="resources">
 *     <exclude name="** /*.java"/>
 *     <exclude name="** /*.class"/>
 * </public>
 *
 * }
 * </pre>
 * 
 * </p>
 *
 * <p>A more detailed tutorial and a full working example can be found <a href="http://carlosbecker.com/posts/using-a-custom-bootstrap-theme-in-gwt-bootstrap">here</a>.</p>
 * @since 2.0.4.0
 * 
 * @author Dominik Mayer
 * @author ohashi keisuke
 * @author Carlos A Becker
 * 
 * @see Resources
 * @see DefaultConfigurator
 */
public interface Configurator {

	/**
	 * Get the Bootstrap Resources that should be used for this project.
	 * 
	 * @return the Bootstrap Resources
	 */
	Resources getResources();

}
