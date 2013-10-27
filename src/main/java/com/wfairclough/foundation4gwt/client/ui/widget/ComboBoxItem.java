package com.wfairclough.foundation4gwt.client.ui.widget;

import com.google.gwt.user.client.ui.HasText;
import com.wfairclough.foundation4gwt.client.ui.base.ListItem;
import com.wfairclough.foundation4gwt.client.ui.base.TextNode;
import com.wfairclough.foundation4gwt.client.ui.constants.Constants;

public class ComboBoxItem extends ListItem implements HasText {

	private ComboBox comboBox = null;
	private TextNode text = new TextNode("");
	
	public ComboBoxItem() {
		super();
	}
	
	public void setEnabled(boolean enabled) {
		if (enabled) 
			removeStyle(Constants.DISABLED);
		else
			setStyle(Constants.DISABLED);
	}
	
	public boolean isEnabled() {
		return !getStyleName().contains(Constants.DISABLED);
	}
	
	public void select() {
		setStyle(Constants.SELECTED);
		if (comboBox != null)
			comboBox.setCurrentText(this.getText());
	}
	
	public boolean isSelected() {
		return getStyleName().contains(Constants.SELECTED);
	}

	public String getText() {
		return text.getText();
	}

	public void setText(String text) {
		this.text.removeFromParent();
		this.text = new TextNode(text);
		add(this.text);
	}
	
	public int getIndex() {
		if (getElement().hasAttribute("value"))
			return Integer.parseInt(getElement().getAttribute("value"));
		return -1;
	}

	public void setParentComboBox(ComboBox comboBox) {
		this.comboBox = comboBox;
	}
	
}
