package com.wfairclough.foundation4gwt.client.ui.widget;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.HasValue;
import com.wfairclough.foundation4gwt.client.ui.base.ComplexWidget;
import com.wfairclough.foundation4gwt.client.ui.base.DivWidget;
import com.wfairclough.foundation4gwt.client.ui.base.HasFoundationSize;
import com.wfairclough.foundation4gwt.client.ui.base.HasRadius;
import com.wfairclough.foundation4gwt.client.ui.base.StyleHelper;
import com.wfairclough.foundation4gwt.client.ui.base.TextNode;
import com.wfairclough.foundation4gwt.client.ui.constants.Constants;
import com.wfairclough.foundation4gwt.client.ui.constants.FoundationSize;
import com.wfairclough.foundation4gwt.client.ui.constants.Radius;

public class Switch extends DivWidget implements HasRadius, HasFoundationSize, HasValue<Boolean>, HasClickHandlers {
	
	private static String SWITCH = "switch";
	private static int SWITCH_COUNT = 0;
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
	
	private Radius radius = Radius.DEFAULT;
	private FoundationSize size = FoundationSize.DEFAULT;
	
	public Switch() {
		super();
		setStyle(SWITCH);
		
		onInput.getElement().setAttribute("type", "radio");
		offInput.getElement().setAttribute("type", "radio");
		
		setValue(false);
		
		setOnText("On");
		setOffText("Off");
		
		setName("switch-" + SWITCH_COUNT++);
		
		onLabel.getElement().getStyle().setPaddingRight(5.0, Unit.PX);
		offLabel.getElement().getStyle().setPaddingLeft(5.0, Unit.PX);
		
		add(offInput);
		add(offLabel);
		add(onInput);
		add(onLabel);
		add(span);
		
		// Add Standard ClickHandler to set the value when clicked
		addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				setValue(!isOn());
			}
		});
	}
	
	
	public void setName(String name) {
		onInput.getElement().setAttribute("name", name);
		offInput.getElement().setAttribute("name", name);
		onInput.setId(name + "On");
		offInput.setId(name + "Off");
		onLabel.getElement().setAttribute("for", name + "On");
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
		setValue(enabled, true);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void setRadius(Radius radius) {
		this.radius = radius;
		StyleHelper.changeStyle(this, radius, Radius.class);
	}
	
	public Radius getRadius() {
		return radius;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void setFoundationSize(FoundationSize size) {
		this.size = size;
        StyleHelper.changeStyle(this, size, FoundationSize.class);
	}

	public FoundationSize getFoundationSize() {
		return size;
	}

	private boolean valueChangeHandlerInitialized = false;

	/**
	 * {@inheritDoc}
	 */
	public HandlerRegistration addValueChangeHandler(ValueChangeHandler<Boolean> handler) {
		if (!valueChangeHandlerInitialized) {
			ensureDomEventHandlers();
			valueChangeHandlerInitialized = true;
		}
		return addHandler(handler, ValueChangeEvent.getType());
	}


	protected void ensureDomEventHandlers() {
		addClickHandler(new ClickHandler() {
		      public void onClick(ClickEvent event) {
		        ValueChangeEvent.fire(Switch.this, getValue());
		      }
		    });
	}


	/**
	 * {@inheritDoc}
	 * 
	 * Also see {@link #isOn()}
	 */
	public Boolean getValue() {
		return isOn();
	}


	/**
	 * {@inheritDoc}
	 */
	public void setValue(Boolean value) {
		setValue(value, true);
	}


	/**
	 * {@inheritDoc}
	 */
	public void setValue(Boolean enabled, boolean fireEvents) {
		if (enabled == null)
			enabled = Boolean.FALSE;
	
		Boolean oldValue = getValue();
		
		if (enabled) {
			onInput.getElement().setAttribute(Constants.CHECKED, "");
			offInput.getElement().removeAttribute(Constants.CHECKED);
		} else {
			onInput.getElement().removeAttribute(Constants.CHECKED);
			offInput.getElement().setAttribute(Constants.CHECKED, "");
		}
		
		if (oldValue.equals(enabled))
			return;
		
		if (fireEvents) {
			ValueChangeEvent.fire(this, enabled);
		}
	}


	/**
	 * {@inheritDoc}
	 */
	public HandlerRegistration addClickHandler(ClickHandler handler) {
		return addDomHandler(handler, ClickEvent.getType());
	}

	
}
