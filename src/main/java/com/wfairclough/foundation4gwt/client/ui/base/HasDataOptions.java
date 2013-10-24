package com.wfairclough.foundation4gwt.client.ui.base;

/**
 * Interface for components that have data-options {@link HasDataOptions}
 * 
 * @author Will Fairclough
 *
 */
public interface HasDataOptions {

	/**
	 * Add a {@link DataOption} to a component.
	 * 
	 * @param dataOption the {@link DataOption} to add 
	 */
	void addDataOption(DataOption dataOption);

	/**
	 * Remove a {@link DataOption} from a component.
	 * 
	 * @param dataOption the {@link DataOption} to remove 
	 */
	void removeDataOption(DataOption dataOption);
	
	/**
	 * Clear all the {@link DataOption DataOptions}
	 */
	void clearDataOptions();
	
	
}
