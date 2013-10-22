package com.wfairclough.foundation4gwt.client.ui.widget;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.event.dom.client.DomEvent;
import com.google.gwt.user.client.ui.Anchor;
import com.wfairclough.foundation4gwt.client.ui.base.HasButtonSize;
import com.wfairclough.foundation4gwt.client.ui.base.HasFoundationColor;
import com.wfairclough.foundation4gwt.client.ui.base.HasRadius;
import com.wfairclough.foundation4gwt.client.ui.base.StyleHelper;
import com.wfairclough.foundation4gwt.client.ui.constants.ButtonSize;
import com.wfairclough.foundation4gwt.client.ui.constants.Constants;
import com.wfairclough.foundation4gwt.client.ui.constants.FoundationColor;
import com.wfairclough.foundation4gwt.client.ui.constants.Radius;

public class Button extends Anchor implements HasFoundationColor,HasButtonSize, HasRadius {

	private static String BUTTON_STYLE_CLASS = "button";
	
	private ButtonSize size = ButtonSize.DEFAULT;
	private FoundationColor color = FoundationColor.DEFAULT;
	private Radius radius = Radius.DEFAULT;
	
	
	public Button(String text) {
		setText(text);
		StyleHelper.setStyle(this, BUTTON_STYLE_CLASS);
	}
	
	/**
     * Programmatic equivalent of the user clicking the button.
     */
    public void click() {
        NativeEvent event = Document.get().createClickEvent(0, 0, 0, 0, 0, false, false, false, false);
        DomEvent.fireNativeEvent(event, this);
    }
    
    public boolean isEnabled() {
		return !getStyleName().contains(Constants.DISABLED);
	}
    

	/**
	 * Sets whether the Button is enabled or disabled.
	 * <p>
	 * A disabled widget cannot be used.
	 *
	 * @param enabled
	 *            <code>false</code> if the Button should be disabled. Default:
	 *            <code>true</code>
	 */
	public void setEnabled(boolean enabled) {
		if (enabled)
			removeStyleName(Constants.DISABLED);
		else
			addStyleName(Constants.DISABLED);
	}
	

	/**
	 * {@inheritDoc}
	 */
	public void setButtonSize(ButtonSize size) {
		this.size = size;
        StyleHelper.changeStyle(this, size, ButtonSize.class);
	}
	
	
	/**
	 * {@inheritDoc}
	 */
	public void setFoundationColor(FoundationColor color) {
		this.color = color;
        StyleHelper.changeStyle(this, color, FoundationColor.class);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void setRadius(Radius radius) {
		this.radius = radius;
		StyleHelper.changeStyle(this, radius, Radius.class);
	}

	public ButtonSize getButtonSize() {
		return size;
	}

	public FoundationColor getFoundationColor() {
		return color;
	}

	public Radius getRadius() {
		return radius;
	}
}
