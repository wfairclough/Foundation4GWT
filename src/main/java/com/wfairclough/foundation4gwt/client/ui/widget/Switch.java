package com.wfairclough.foundation4gwt.client.ui.widget;

import com.wfairclough.foundation4gwt.client.ui.base.ComplexWidget;
import com.wfairclough.foundation4gwt.client.ui.base.DivWidget;
import com.wfairclough.foundation4gwt.client.ui.base.TextNode;
import com.wfairclough.foundation4gwt.client.ui.constants.Constants;

public class Switch extends DivWidget {
	
	private static String SWITCH = "switch";
/*
<div class="switch">
  <input id="x" name="switch-x" type="radio" checked>
  <label for="x" onclick="">Off</label>

  <input id="x1" name="switch-x" type="radio">
  <label for="x1" onclick="">On</label>

  <span></span>
</div>
 */
	private ComplexWidget onInput = new ComplexWidget("input");
	private ComplexWidget offInput = new ComplexWidget("input");
	
	private ComplexWidget onLabel = new ComplexWidget("label");
	private ComplexWidget offLabel = new ComplexWidget("label"); 
	
	private ComplexWidget span = new ComplexWidget("span");
	
	public Switch() {
		super();
		setStyle(SWITCH);
		
		onInput.getElement().setAttribute("type", "radio");
		offInput.getElement().setAttribute("type", "radio");
		
		setValue(false);
		
		setOnText("On");
		setOffText("Off");
		
		add(offInput);
		add(offLabel);
		add(onInput);
		add(onLabel);
		add(span);
	}
	
	
	public void setName(String name) {
		onInput.getElement().setAttribute("name", name);
		offInput.getElement().setAttribute("name", name);
		onInput.setId(name + "On");
		offInput.setId(name + "On");
		onLabel.getElement().setAttribute("for", name + "Off");
		offLabel.getElement().setAttribute("for", name + "Off");
	}
	
	
	/**
	 * Sets the on text for the switch
	 * 
	 * @param text the text to use for the switch
	 */
	public void setOnText(String text) {
		onLabel.add(new TextNode("  " + text));
	}
	
	/**
	 * Sets the off text for the switch
	 * 
	 * @param text the text to use for the switch
	 */
	public void setOffText(String text) {
		offLabel.add(new TextNode("  " + text));
	}
	
	/**
	 * Check if the {@link Switch} is switched on.
	 *  
	 * @return true if enabled
	 */
	public boolean isOn() {
		return onInput.getElement().hasAttribute(Constants.CHECKED);
	}
	
	/**
	 * Set the {@link Switch} value
	 * 
	 * @param enabled true is on false is off
	 */
	public void setValue(boolean enabled) {
		if (enabled) {
			onInput.getElement().setAttribute(Constants.CHECKED, "");
			offInput.getElement().removeAttribute(Constants.CHECKED);
		} else {
			onInput.getElement().removeAttribute(Constants.CHECKED);
			offInput.getElement().setAttribute(Constants.CHECKED, "");
		}
	}
	
}
