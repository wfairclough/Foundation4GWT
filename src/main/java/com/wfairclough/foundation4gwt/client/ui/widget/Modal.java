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
package com.wfairclough.foundation4gwt.client.ui.widget;

import com.google.gwt.user.client.ui.HasWidgets;
import com.wfairclough.foundation4gwt.client.ui.base.DivWidget;
import com.wfairclough.foundation4gwt.client.ui.base.HasFoundationSize;
import com.wfairclough.foundation4gwt.client.ui.base.StyleHelper;
import com.wfairclough.foundation4gwt.client.ui.constants.FoundationSize;

/**
 * A Modal view to be presented when show action is called.
 * 
 * @since 1.0.0
 * 
 * @author Will Fairclough
 *
 */
public class Modal extends DivWidget implements HasFoundationSize {
	
	private static String REVEAL_MODAL = "reveal-modal";
	private static String CLOSE_REVEAL_MODAL = "close-reveal-modal";
	private static int MODAL_COUNT = 0;
/*
	<div id="myModal" class="reveal-modal">
	  <h2>Awesome. I have it.</h2>
	  <p class="lead">Your couch.  It is mine.</p>
	  <p>Im a cool paragraph that lives inside of an even cooler modal. Wins</p>
	  <a class="close-reveal-modal">&#215;</a>
	</div>
 */
	
	private boolean animate = true;
	private boolean closeOnBackgroundClick = true;
	private FoundationSize size = FoundationSize.DEFAULT;
	
	/**
	 * Default constructor
	 */
	public Modal() {
		super(REVEAL_MODAL);
		setId("f-modal-" + MODAL_COUNT++);
	}
	
	/**
	 * Convenience constructor to add this {@link Modal} to a parent
	 * @param parent
	 */
	public Modal(HasWidgets parent) {
		this();
		parent.add(this);
	}
	
	/**
	 * Factory method to create a Button that closes this modal.
	 * For this button to work it must be added to the Modal
	 * you would like to close;
	 * @return The close {@link Button}
	 */
	public static Button createCloseButton() {
		Button btn = new Button("Close");
		btn.addStyleName(CLOSE_REVEAL_MODAL);
		return btn;
	}
	
	/**
	 * Show the {@link Modal} view
	 */
    public void show()
    {
    	if (animate)
    		nativeShow(getId(), closeOnBackgroundClick);
    	else
    		nativeShowNoAnimation(getId(), closeOnBackgroundClick);
    }
    
    /**
     * Hide the {@link Modal} view
     */
    public void close()
    {
    	nativeClose(getId());
    }
	
    /**
     * Check if the modal will animate when shown
     * @return true if animation is on
     */
    public boolean isAnimate() {
		return animate;
	}

    /**
     * Set whether the modal will animate or not when shown
     * @param animate true to animate
     */
	public void setAnimate(boolean animate) {
		this.animate = animate;
	}
	
	/**
     * Native JavaScript to show the {@link Modal}
     * @param id the modal element id
     */
    private static final native void nativeShow(String id, boolean closeBgClick)
    /*-{
		$wnd.jQuery('#' + id).foundation('reveal', 'open', {
		    closeOnBackgroundClick: closeBgClick
		});
    }-*/; 
    
    
    /**
     * Native JavaScript to show the {@link Modal} with no animation
     * @param id the modal element id
     */
    private static final native void nativeShowNoAnimation(String id, boolean closeBgClick)
    /*-{
    	
		$wnd.jQuery('#' + id).foundation('reveal', 'open', {
		    animation: 'none',
		    closeOnBackgroundClick: closeBgClick
		});
    }-*/; 
    
    
    /**
     * Native JavaScript to hide the {@link Modal}
     * @param id the modal element id
     */
    private static final native void nativeClose(String id)
    /*-{
		$wnd.jQuery('#' + id).foundation('reveal', 'close');
    }-*/; 
    
    
	/**
	 * {@inheritDoc}
	 */
	public void setFoundationSize(FoundationSize size) {
		this.size = size;
        StyleHelper.changeStyle(this, size, FoundationSize.class);
	}

	/**
	 * Check if this modal will close on a background click.
	 * 
	 * @return true if it will close on click
	 */
	public boolean isCloseOnBackgroundClick() {
		return closeOnBackgroundClick;
	}

	/**
	 * Set the modal to close on background click if set to true.
	 * 
	 * @param closeOnBackgroundClick
	 */
	public void setCloseOnBackgroundClick(boolean closeOnBackgroundClick) {
		this.closeOnBackgroundClick = closeOnBackgroundClick;
	}
	
}
