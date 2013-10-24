package com.wfairclough.foundation4gwt.client.ui.base;

/**
 * Interface for widgets that can work as a link.
 * 
 * @since 1.0.0
 * 
 * @author Dominik Mayer
 * @author Will Fairclough
 */
public interface HasHref {

	/**
	 * Sets the <code>href</code> property of the anchor tag.
	 * <p>
	 * Use it only to set links to another page. Links on the same page or GWT
	 * tokens should be set with {@code #setTargetHistoryToken(String)}
	 * 
	 * @param href
	 *            the website URL
	 */
	void setHref(String href);

	/**
	 * Gets the URL of the website, the link is pointing to.
	 * 
	 * @return the URL
	 */
	String getHref();

	/**
	 * Sets the <code>href</code> property of the anchor tag to
	 * <code>"#" + targetHistoryToken</code>.
	 * 
	 * @param targetHistoryToken
	 *            the history token
	 */
	void setTargetHistoryToken(String targetHistoryToken);

	/**
	 * Gets the history token this link points to
	 * 
	 * @return the history token
	 */
	String getTargetHistoryToken();

}
