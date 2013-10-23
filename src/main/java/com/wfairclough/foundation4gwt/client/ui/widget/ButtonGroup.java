package com.wfairclough.foundation4gwt.client.ui.widget;

import javax.servlet.UnavailableException;

import com.wfairclough.foundation4gwt.client.ui.base.HasRadius;
import com.wfairclough.foundation4gwt.client.ui.base.StyleHelper;
import com.wfairclough.foundation4gwt.client.ui.base.ULWidget;
import com.wfairclough.foundation4gwt.client.ui.constants.Radius;

/**
 * A grouping of Buttons.
 * 
 * {@link ButtonGroup} is great when you need to display a group of actions in a bar. 
 * 
 * @author Will Fairclough
 *
 */
public class ButtonGroup extends ULWidget implements HasRadius {

	public static final String BUTTON_GROUP_CLASS_NAME = "button-group";
	
	private Radius radius = Radius.DEFAULT;
	
	public ButtonGroup() {
       getElement().setClassName(BUTTON_GROUP_CLASS_NAME);
    }

    /**
     * Creates a {@link ButtonGroup} containing the provided {@link Button} List.
     * 
     * @param buttons
     *            the widgets to be added to the ButtonGroup
     */
    public ButtonGroup(Button... buttons) {
        this();
        for (Button btn : buttons) {
        	add(btn);
        }
    }
    
	/**
	 * {@inheritDoc}
	 * @throws UnavailableException 
	 */
	public void setRadius(Radius radius) {
		this.radius = radius;
		StyleHelper.changeStyle(this, radius, Radius.class);
	}

	public Radius getRadius() {
		return radius;
	}
	
}
