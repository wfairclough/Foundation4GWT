package com.wfairclough.foundation4gwt.client.ui.widget;

import com.google.gwt.user.client.ui.HasText;
import com.wfairclough.foundation4gwt.client.ui.base.ListItem;
import com.wfairclough.foundation4gwt.client.ui.base.TextNode;
import com.wfairclough.foundation4gwt.client.ui.constants.Constants;

public class ComboBoxItem extends ListItem implements HasText {

	private ComboBox comboBox = null;
	private TextNode text = new TextNode("");
	
	/**
	 * Default Constructor
	 */
	public ComboBoxItem() {
		super();
	}
	
	/**
	 * Convince constructor to set the items text.
	 * @param text
	 */
	public ComboBoxItem(String text) {
		this();
		setText(text);
	}
	
	/**
	 * Set the {@link ComboBoxItem} item enabled/disabled
	 * 
	 * @param enabled if true disabled if false
	 */
	public void setEnabled(boolean enabled) {
		if (enabled) 
			removeStyle(Constants.DISABLED);
		else
			setStyle(Constants.DISABLED);
	}
	
	/**
	 * Check if {@link ComboBoxItem} is enabled
	 * @return
	 */
	public boolean isEnabled() {
		return !getStyleName().contains(Constants.DISABLED);
	}
	
	/**
	 * Programically select the {@link ComboBoxItem}
	 */
	public void select() {
		setStyle(Constants.SELECTED);
		if (comboBox != null)
			comboBox.setCurrentText(this.getText());
	}
	
	/**
	 * Check if a {@link ComboBoxItem} if selected
	 * 
	 * @return true if selected otherwise false
	 */
	public boolean isSelected() {
		return getStyleName().contains(Constants.SELECTED);
	}

	/**
	 * {@inheritDoc}
	 */
	public String getText() {
		return text.getText();
	}

	/**
	 * {@inheritDoc}
	 */
	public void setText(String text) {
		this.text.removeFromParent();
		this.text = new TextNode(text);
		add(this.text);
	}
	
	/**
	 * Get the index value of the {@link ComboBoxItem}
	 * @return
	 */
	public int getIndex() {
		if (getElement().hasAttribute("value"))
			return Integer.parseInt(getElement().getAttribute("value"));
		return -1;
	}

	/**
	 * Sets the parent {@link ComboBox} value.
	 * 
	 * @param comboBox to set as parent
	 */
	protected void setParentComboBox(ComboBox comboBox) {
		this.comboBox = comboBox;
	}
	
}
