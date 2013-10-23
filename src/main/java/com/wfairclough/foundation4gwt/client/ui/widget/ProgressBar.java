package com.wfairclough.foundation4gwt.client.ui.widget;

import java.util.ArrayList;

import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style.TextAlign;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.HasValue;
import com.wfairclough.foundation4gwt.client.ui.base.DivWidget;
import com.wfairclough.foundation4gwt.client.ui.base.HasColumnLargeSize;
import com.wfairclough.foundation4gwt.client.ui.base.HasColumnSmallSize;
import com.wfairclough.foundation4gwt.client.ui.base.HasFoundationColor;
import com.wfairclough.foundation4gwt.client.ui.base.HasRadius;
import com.wfairclough.foundation4gwt.client.ui.base.StyleHelper;
import com.wfairclough.foundation4gwt.client.ui.constants.Constants;
import com.wfairclough.foundation4gwt.client.ui.constants.FoundationColor;
import com.wfairclough.foundation4gwt.client.ui.constants.Radius;

public class ProgressBar extends DivWidget implements HasColumnLargeSize,
		HasColumnSmallSize, HasText, HasValue<Double>, HasRadius, HasFoundationColor {

	public static String SIZE_ERROR_MESSAGE = "The Column size can only be set to 1-12";
	
	private static String PROGRESS_STYLE_CLASS = "progress";

	private Element span = DOM.createElement(Constants.SPAN);
	
	private EventBus bus = new SimpleEventBus();
	
	private int smallSize = 12;
	private int largeSize = 12;
	
	private ArrayList<ValueChangeHandler<Double>> handlers = new ArrayList<ValueChangeHandler<Double>>();
	
	private String text = "";
	private double value = 0.0d; 
	
	private Radius radius = Radius.DEFAULT;
	private FoundationColor color = FoundationColor.DEFAULT;
	
	
	public ProgressBar() {
		StyleHelper.setStyle(this, PROGRESS_STYLE_CLASS);
		span.setClassName(Constants.METER);
		getElement().insertFirst(span);
		setTextColor("white");
		setTextAlign(TextAlign.CENTER);
	}

	/**
	 * Gets the current text
	 */
	public String getText() {
		return text;
	}

	/**
	 * Set the text for the {@link ProgressBar}
	 * 
	 * @param text the text to be used
	 */
	public void setText(String text) {
		this.text = text;
		span.setInnerHTML(this.text);
	}
	
	/**
	 * Set the text color for the {@link ProgressBar}
	 * 
	 * @param color the color of the text
	 */
	public void setTextColor(String color)
	{
		span.getStyle().setColor(color);
	}
	
	/**
	 * Sets the alignment of the text in the {@link ProgressBar}
	 * 
	 * @param align the alignment value
	 */
	public void setTextAlign(TextAlign align)
	{
		span.getStyle().setTextAlign(align);
	}

	/**
	 * {@inheritDoc}
	 */
	public void setSmallSize(int size) {
		if (size < 1)
			throw new IllegalArgumentException(SIZE_ERROR_MESSAGE);
		if (size > 12)
			throw new IllegalArgumentException(SIZE_ERROR_MESSAGE);
		
		smallSize = size;
		addStyleName(Constants.SMALL + "-" + size);
	}

	/**
	 * {@inheritDoc}
	 */
	public void setLargeSize(int size) {
		if (size < 1)
			throw new IllegalArgumentException(SIZE_ERROR_MESSAGE);
		if (size > 12)
			throw new IllegalArgumentException(SIZE_ERROR_MESSAGE);
		
		largeSize = size;
		addStyleName(Constants.LARGE + "-" + size);
	}

	/**
	 * Add a value change handler to this {@link ProgressBar}.
	 * 
	 * @return {@link HandlerRegistration} used to remove the handler.
	 */
	public HandlerRegistration addValueChangeHandler(final ValueChangeHandler<Double> handler) {
		return bus.addHandler(ValueChangeEvent.getType(), handler);
	}

	/**
	 * Get the value of the {@link ProgressBar}.
	 */
	public Double getValue() {
		return value;
	}

	/**
	 * Set the value of the {@link ProgressBar}.
	 */
	public void setValue(Double value) {
		setValue(value, true);
	}
	
	@Override
	public void fireEvent(GwtEvent<?> event) {
	    bus.fireEvent(event);
	}

	/**
	 * Set the value of the {@link ProgressBar} with control of event firing.
	 * 
	 * @param fireEvents true to fire events otherwise false.
	 */
	public void setValue(Double value, boolean fireEvents) {
		if (fireEvents)
			ValueChangeEvent.fire(this, value);
		
		this.value = value;
		if (this.value > 100)
			this.value = 100.0d;
		span.getStyle().setWidth(value, Unit.PCT);
	}

	/**
	 * {@inheritDoc}
	 */
	public void setRadius(Radius radius) {
		this.radius = radius;
		StyleHelper.addStyle(this, radius);
	}

	/**
	 * {@inheritDoc}
	 */
	public void setFoundationColor(FoundationColor color) {
		this.color = color;
		StyleHelper.addStyle(this, color);
	}
	
}
