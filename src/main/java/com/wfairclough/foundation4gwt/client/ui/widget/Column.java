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

import com.wfairclough.foundation4gwt.client.ui.base.DivWidget;
import com.wfairclough.foundation4gwt.client.ui.base.HasColumnLargeCentered;
import com.wfairclough.foundation4gwt.client.ui.base.HasColumnLargeOffset;
import com.wfairclough.foundation4gwt.client.ui.base.HasColumnLargeSize;
import com.wfairclough.foundation4gwt.client.ui.base.HasColumnSmallCentered;
import com.wfairclough.foundation4gwt.client.ui.base.HasColumnSmallOffset;
import com.wfairclough.foundation4gwt.client.ui.base.HasColumnSmallSize;
import com.wfairclough.foundation4gwt.client.ui.base.StyleHelper;
import com.wfairclough.foundation4gwt.client.ui.constants.Constants;

public class Column extends DivWidget implements HasColumnLargeSize,
		HasColumnSmallSize, HasColumnLargeOffset, HasColumnSmallOffset,
		HasColumnSmallCentered, HasColumnLargeCentered {

	private static String COLUMN_STYLE_CLASS = "columns";
	public static String OFFSET_ERROR_MESSAGE = "The Column offsets can only be set to 1-12";
	public static String SIZE_ERROR_MESSAGE = "The Column size can only be set to 1-12";
	
	private int smallSize = 12;
	private int largeSize = 12;
	private int smallOffset = 0;
	private int largeOffset = 0;
	
	
	public Column() {
		StyleHelper.setStyle(this, COLUMN_STYLE_CLASS);
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
	 * {@inheritDoc}
	 */
	public void setSmallOffset(int offset) {
		if (offset < 1)
			throw new IllegalArgumentException(OFFSET_ERROR_MESSAGE);
		if (offset > 12)
			throw new IllegalArgumentException(OFFSET_ERROR_MESSAGE);
		
		smallOffset = offset;
		addStyleName(Constants.SMALL_OFFSET + "-" + offset);
	}

	/**
	 * {@inheritDoc}
	 */
	public void setLargeOffset(int offset) {
		if (offset < 1)
			throw new IllegalArgumentException(OFFSET_ERROR_MESSAGE);
		if (offset > 12)
			throw new IllegalArgumentException(OFFSET_ERROR_MESSAGE);
		
		largeOffset = offset;
		addStyleName(Constants.LARGE_OFFSET + "-" + offset);
	}
	
	public int getSmallSize() {
		return smallSize;
	}

	public int getLargeSize() {
		return largeSize;
	}

	public int getSmallOffset() {
		return smallOffset;
	}

	public int getLargeOffset() {
		return largeOffset;
	}

	/**
	 * {@inheritDoc}
	 */
	public void setLargeCentered(boolean enabled) {
		if (enabled)
			StyleHelper.addStyle(this, Constants.LARGE_CENTERED);
		else
			StyleHelper.removeStyle(this, Constants.LARGE_CENTERED);
	}

	/**
	 * {@inheritDoc}
	 */
	public void setSmallCentered(boolean enabled) {
		if (enabled)
			StyleHelper.addStyle(this, Constants.SMALL_CENTERED);
		else
			StyleHelper.removeStyle(this, Constants.SMALL_CENTERED);
	}
	
}
