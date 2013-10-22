package com.wfairclough.foundation4gwt.client.ui.widget;

import com.google.gwt.user.client.ui.FlowPanel;
import com.wfairclough.foundation4gwt.client.ui.base.HasColumnLargeOffset;
import com.wfairclough.foundation4gwt.client.ui.base.HasColumnLargeSize;
import com.wfairclough.foundation4gwt.client.ui.base.HasColumnSmallOffset;
import com.wfairclough.foundation4gwt.client.ui.base.HasColumnSmallSize;
import com.wfairclough.foundation4gwt.client.ui.base.StyleHelper;
import com.wfairclough.foundation4gwt.client.ui.constants.ColumnLargeOffset;
import com.wfairclough.foundation4gwt.client.ui.constants.ColumnLargeSize;
import com.wfairclough.foundation4gwt.client.ui.constants.ColumnSmallOffset;
import com.wfairclough.foundation4gwt.client.ui.constants.ColumnSmallSize;

public class Column extends FlowPanel implements HasColumnLargeSize, HasColumnSmallSize, HasColumnLargeOffset, HasColumnSmallOffset {

	private static String COLUMN_STYLE_CLASS = "columns";
	
	private ColumnSmallSize columnSmallSize = ColumnSmallSize.DEFAULT;
	private ColumnLargeSize columnLargeSize = ColumnLargeSize.DEFAULT;
	private ColumnSmallOffset columnSmallOffset = ColumnSmallOffset.DEFAULT;
	private ColumnLargeOffset columnLargeOffset = ColumnLargeOffset.DEFAULT;
	
	public Column() {
		StyleHelper.setStyle(this, COLUMN_STYLE_CLASS);
	}

	public void setColumnSmallSize(ColumnSmallSize size) {
		columnSmallSize = size;
		StyleHelper.changeStyle(this, size, ColumnSmallSize.class);
	}

	public void setColumnLargeSize(ColumnLargeSize size) {
		columnLargeSize = size;
		StyleHelper.changeStyle(this, size, ColumnLargeSize.class);
	}
	
	public ColumnSmallSize getColumnSmallSize() {
		return columnSmallSize;
	}
	
	public ColumnLargeSize getColumnLargeSize() {
		return columnLargeSize;
	}

	public void setColumnSmallOffset(ColumnSmallOffset offset) {
		columnSmallOffset = offset;
		StyleHelper.changeStyle(this, offset, ColumnSmallOffset.class);
	}

	public void setColumnLargeOffset(ColumnLargeOffset offset) {
		columnLargeOffset = offset;
		StyleHelper.changeStyle(this, offset, ColumnLargeOffset.class);
	}
	
	public ColumnSmallOffset getColumnSmallOffset() {
		return columnSmallOffset;
	}
	
	public ColumnLargeOffset getColumnLargeOffset() {
		return columnLargeOffset;
	}
	
}
