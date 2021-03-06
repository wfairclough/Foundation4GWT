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

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.EventTarget;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasChangeHandlers;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.wfairclough.foundation4gwt.client.ui.base.BasicAnchor;
import com.wfairclough.foundation4gwt.client.ui.base.DivWidget;
import com.wfairclough.foundation4gwt.client.ui.base.HasWidgetValues;
import com.wfairclough.foundation4gwt.client.ui.base.UnorderedList;
import com.wfairclough.foundation4gwt.client.ui.base.WidgetValues;

public class ComboBox extends DivWidget implements HasValue<String>, HasClickHandlers, HasWidgetValues<ComboBoxItem>, HasChangeHandlers {

	/*

	
	<div class="large-4 columns">
      <label for="customDropdown1">Medium Example</label>
      <select id="customDropdown1" class="medium">
        <option DISABLED>This is a dropdown</option>
        <option>This is another option</option>
        <option>This is another option too</option>
        <option>Look, a third option</option>
      </select>
    </div>
	


	<div class="large-4 columns">
      <label for="customDropdown1">Medium Example</label>
      <select id="customDropdown1" class="medium hidden-field" data-id="1382832745167-mvEVc">
        <option disabled="">This is a dropdown</option>
        <option>This is another option</option>
        <option>This is another option too</option>
        <option>Look, a third option</option>
      </select>
    </div>
	<div class="custom dropdown medium" data-id="1382832745167-mvEVc">
		<a href="#" class="current">This is another option</a>
		<a href="#" class="selector"></a>
		<ul>
			<li class="disabled">This is a dropdown</li>
			<li class="selected">This is another option</li>
			<li class="">This is another option too</li>
			<li class="">Look, a third option</li>
		</ul>
	</div>
	
	
	 */
	
	private static String ADD_WIDGET_ERROR = "ComboBox can only accept children of ComboBoxItem widgets.";
	
	private DivWidget visibleSelect = new DivWidget();
	private BasicAnchor selectorAnchor = new BasicAnchor();
	private BasicAnchor currentAnchor = new BasicAnchor();
	private UnorderedList selectList = new UnorderedList();
	
	private boolean valueChangeHandlerInitialized = false;
	private boolean changeHandlerInitialized = false;
	
	private List<ComboBoxItem> itemsList = new ArrayList<ComboBoxItem>();
	
	private int itemCount = 0;
	
	public ComboBox() {
		super();
		
		currentAnchor.setStyle("current");
		selectorAnchor.setStyle("selector");
		visibleSelect.setStyle("custom dropdown");
		
		visibleSelect.add(currentAnchor);
		visibleSelect.add(selectorAnchor);
		visibleSelect.add(selectList);
		
		super.add(visibleSelect);
	}
	
	
	/**
	 * Add {@link ComboBoxItem} widgets to the {@link ComboBox}
	 */
	@Override
	public void add(IsWidget child) {
		Widget widget = asWidgetOrNull(child);
		
		if ( (widget != null) && (widget instanceof ComboBoxItem)) {
			ComboBoxItem cbi = (ComboBoxItem)widget;
			cbi.setParentComboBox(this);
			if (itemCount == 0) cbi.select(); // Select Item if first
			cbi.getElement().setAttribute("value", "" + itemCount++);
			selectList.add(cbi);
			itemsList.add(cbi);
		} else {
			throw new IllegalArgumentException(ADD_WIDGET_ERROR);
		}
	}
	
	/**
	 * Add {@link ComboBoxItem} widgets to the {@link ComboBox}
	 */
	@Override
	public void add(Widget widget) {
		if ( (widget != null) && (widget instanceof ComboBoxItem)) {
			ComboBoxItem cbi = (ComboBoxItem)widget;
			cbi.setParentComboBox(this);
			if (itemCount == 0) cbi.select(); // Select Item if first
			cbi.getElement().setAttribute("value", "" + itemCount++);
			selectList.add(cbi);
			itemsList.add(cbi);
		} else {
			throw new IllegalArgumentException(ADD_WIDGET_ERROR);
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean remove(int index) {
		itemsList.remove(index);
		return super.remove(index);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean remove(Widget w) {
		itemsList.remove(w);
		return super.remove(w);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean remove(IsWidget child) {
		Widget widget = asWidgetOrNull(child);
		itemsList.remove(widget);
		return super.remove(child);
	}
	
	
	/**
	 * Get the list of {@link ComboBoxItem} widgets that the {@link ComboBox} contains
	 * 
	 * @return {@link List} of {@link ComboBoxItem}
	 */
	public List<ComboBoxItem> getItems() {
		return itemsList;
	}
	
	/**
	 * Gets the {@link ComboBoxItem} for the selected item
	 * 
	 * @return {@link ComboBoxItem} for the selected item
	 */
	public ComboBoxItem getSelectedItem() {
		for (ComboBoxItem cbi : getItems()) {
			if (cbi.isSelected())
				return cbi;
		}
		
		return null;
	}
	
	/**
	 * Gets the index for the selected item
	 * 
	 * @return index for the selected item
	 */
	public int getSelectedIndex() {
		if (getSelectedItem() == null)
			return -1;
		return getSelectedItem().getIndex();
	}
	
	/**
	 * Gets the text for the selected item
	 * 
	 * @return text for the selected item
	 */
	public String getSelectedItemText() {
		if (getSelectedItem() == null)
			return null;
		return getSelectedItem().getText();
	}


	/**
	 * Set the current text on the {@link ComboBox}. 
	 * Usually the text of the selected {@link ComboBoxItem}.
	 * 
	 * @param text the text to set
	 */
	protected void setCurrentText(String text) {
		currentAnchor.setText(text);
	}


	/**
	 * {@inheritDoc}
	 */
	public String getValue() {
		return getSelectedItemText();
	}


	/**
	 * {@inheritDoc}
	 */
	public void setValue(String value) {
		setValue(value, true);
	}


	/**
	 * {@inheritDoc}
	 */
	public void setValue(String value, boolean fireEvents) {
		String oldValue = getValue();
		
		for (ComboBoxItem item : getItems()) {
			if (item.getText().equals(value)) {
				item.select();
				break;
			}
		}
		
		// Don't fire events if value didnt change
		if (oldValue.equals(getValue()))
			return;
		
		if (fireEvents) {
			ValueChangeEvent.fire(this, value);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public HandlerRegistration addChangeHandler(ChangeHandler handler) {
		if (!changeHandlerInitialized) {
			ensureDomEventHandlers();
			changeHandlerInitialized = true;
		}
		return addHandler(handler, ChangeEvent.getType());
	}
	
	/**
	 * {@inheritDoc}
	 */
	public HandlerRegistration addValueChangeHandler(ValueChangeHandler<String> handler) {
		if (!valueChangeHandlerInitialized) {
			addChangeHandler(new ChangeHandler() {
				public void onChange(ChangeEvent event) {
					ValueChangeEvent.fire(ComboBox.this, getValue());
				}
			});
			valueChangeHandlerInitialized = true;
		}
		return addHandler(handler, ValueChangeEvent.getType());
	}


	/**
	 * No-op. CheckBox's click handler is no good for radio button, so don't use
	 * it. Our event handling is all done in {@link #onBrowserEvent}
	 */
	protected void ensureDomEventHandlers() {
		addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
//				ValueChangeEvent.fire(ComboBox.this, getValue());
			}
		});
	}
	
	
	private String oldValue;
	
	/**
	 * Overridden to send ValueChangeEvents only when appropriate.
	 */
	@Override
	public void onBrowserEvent(Event event) {
		switch (DOM.eventGetType(event)) {
			case Event.ONMOUSEUP:
			case Event.ONBLUR:
			case Event.ONKEYDOWN:
				// Note the old value for onValueChange purposes (in ONCLICK case)
				oldValue = getValue();
				break;

			case Event.ONCLICK:
				EventTarget target = event.getEventTarget();
				// TODO May need to add more isTarget checks
				if (Element.is(target) && currentAnchor.getElement().isOrHasChild(Element.as(target))) {

					// They clicked the label. Note our pre-click value, and
					// short circuit event routing so that other click handlers
					// don't hear about it
					oldValue = getValue();
					
					return;
				}
				
				for (ComboBoxItem item : getItems()) {
					if(Element.is(target) && item.getElement().isOrHasChild(Element.as(target))) {
						item.select();
						break;
					}
				}

				// It's not the label. Let our handlers hear about the
				// click...
				super.onBrowserEvent(event);
				// ...and now maybe tell them about the change
				ValueChangeEvent.fireIfNotEqual(ComboBox.this, oldValue, getValue());
//				ValueChangeEvent.fire(ComboBox.this, getValue());
				return;
		}

		super.onBrowserEvent(event);
	}
	
	
	
	/**
	 * {@inheritDoc}
	 */
	public HandlerRegistration addClickHandler(ClickHandler handler) {
		return addDomHandler(handler, ClickEvent.getType());
	}


	/**
	 * {@inheritDoc}
	 */
	public <W extends Enum<W> & WidgetValues> List<ComboBoxItem> setWidgetValues(Class<W> widgetValuesEnums) {
		return setWidgetValues(widgetValuesEnums.getEnumConstants());
	}
	
	/**
	 * {@inheritDoc}
	 */
	public <W extends WidgetValues> List<ComboBoxItem> setWidgetValues(W[] widgetValuesEnums) {
		List<ComboBoxItem> list = new ArrayList<ComboBoxItem>();
		
		for (WidgetValues wv : widgetValuesEnums) {
			ComboBoxItem item = new ComboBoxItem(wv);
			list.add(item);
			add(item);
		}
		
		return list;
	}


	/**
	 * {@inheritDoc}
	 */
	public <W extends Enum<W> & WidgetValues> void setSelectedWidgetValue(W widgetValue) {
		for (ComboBoxItem item : getItems()) {
			if (item.getText().equals(widgetValue.getValue())) {
				item.select();
				break;
			}
		}
	}

}
