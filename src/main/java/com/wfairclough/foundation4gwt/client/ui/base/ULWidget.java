package com.wfairclough.foundation4gwt.client.ui.base;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.UListElement;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.ComplexPanel;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;

/**
 * A Simple Unordered List Widget
 * 
 * @author Will Fairclough
 *
 */
public class ULWidget extends ComplexPanel implements HasId, HasStyle {
	
	private UListElement list; 
	
	public ULWidget() {
		list = Document.get().createULElement(); 
        setElement(list); 
	}
	
	/**
	 * Add a new li element with widget to the unordered list
	 * 
	 * @param child add {@link IsWidget} to unordered list
	 */
	@Override
	public void add(IsWidget child) {
		Widget widget = asWidgetOrNull(child);
		Element li = Document.get().createLIElement().cast(); 
        list.appendChild(li); 
        super.add(widget, li); 
	}
	
	
	/**
	 * Add a new li element with widget to the unordered list
	 * 
	 * @param child add {@link IsWidget} to unordered list
	 */
	@Override
	public void add(Widget child) {
		Element li = Document.get().createLIElement().cast(); 
        list.appendChild(li); 
        super.add(child, li); 
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