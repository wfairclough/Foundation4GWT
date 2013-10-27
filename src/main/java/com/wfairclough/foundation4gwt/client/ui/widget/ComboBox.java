package com.wfairclough.foundation4gwt.client.ui.widget;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.wfairclough.foundation4gwt.client.ui.base.BasicAnchor;
import com.wfairclough.foundation4gwt.client.ui.base.DivWidget;
import com.wfairclough.foundation4gwt.client.ui.base.UnorderedList;

public class ComboBox extends DivWidget {

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
	
	// ----------
	private DivWidget visibleSelect = new DivWidget();
	private BasicAnchor selectorAnchor = new BasicAnchor();
	private BasicAnchor currentAnchor = new BasicAnchor();
	private UnorderedList selectList = new UnorderedList();
	
	// ----------
	
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
		} else {
			throw new IllegalArgumentException(ADD_WIDGET_ERROR);
		}
	}
	
	
	/**
	 * Get the list of {@link ComboBoxItem} widgets that the {@link ComboBox} contains
	 * 
	 * @return {@link List} of {@link ComboBoxItem}
	 */
	public List<ComboBoxItem> getItems() {
		List<ComboBoxItem> list = new ArrayList<ComboBoxItem>();
		for (Widget w : getChildren()) {
			list.add((ComboBoxItem)w);
		}
		return list;
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
	
}
