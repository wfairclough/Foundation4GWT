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
package com.wfairclough.foundation4gwt.client.ui.base;

import com.google.gwt.user.client.ui.FlowPanel;

public class DivWidget extends FlowPanel implements HasStyle, HasId {

	
	public DivWidget() {
		super();
	}
	
	public DivWidget(String style) {
		super();
		setStyleName(style);
	}

	/**
	 * {@inheritDoc}
	 */
	public void setStyle(Style style) {
		StyleHelper.setStyle(this, style);
	}

	/**
	 * {@inheritDoc}
	 */
	public void addStyle(Style style) {
		StyleHelper.addStyle(this, style);
	}

	/**
	 * {@inheritDoc}
	 */
	public void removeStyle(Style style) {
		StyleHelper.removeStyle(this, style);
	}


    /**
     * {@inheritDoc}
     */
    public String getId() {
        return getElement().getId();
    }

    /**
     * {@inheritDoc}
     */
    public void setId(String id) {
        getElement().setId(id);
    }
	


}