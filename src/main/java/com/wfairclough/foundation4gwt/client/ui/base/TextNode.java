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
package com.wfairclough.foundation4gwt.client.ui.base;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Text;
import com.google.gwt.event.logical.shared.AttachEvent;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;

public class TextNode extends Widget implements HasText {

    private Text baseNode;
    private boolean attached;
    
    public TextNode() {
    }

    public TextNode(String text) {
        setText(text);
    }

    public String getText() {
        
        return baseNode != null ? baseNode.getData() : null;
    }

    public void setText(String text) {
        assert baseNode == null : "TextNode can be set once";
        baseNode = Document.get().createTextNode(text);
        setElement(baseNode.<Element>cast());
    }
    
    @Override
    public boolean isAttached() {
        return attached;
    }
    
    @Override
    protected void onAttach() {
        if(isAttached()) {
            throw new IllegalStateException("already added");
        }
        
        this.attached = true;
        
        onLoad();
        
        AttachEvent.fire(this, attached);
    }
    
    @Override
    protected void onDetach() {
        if(!isAttached()) {
            throw new IllegalStateException("is not attached");
        }
        
        this.attached = false;
        
        AttachEvent.fire(this, attached);
    }
    
    
}
