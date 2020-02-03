/**
 * 
 */
package com.ss.lms.biz;


/**
 * @author Kyle Sneeden
 *
 */
public class Author 
{
	private static Integer uniqueAuthorID = 0;
	private Integer authorID;
	private StringBuffer authorName;
	/**
	 * 
	 */
	public Author(StringBuffer authorName) 
	{
		this.authorName = authorName;
		this.authorID = getUniqueAuthorID();
	}
	public Author(Integer authorID, StringBuffer authorName) 
	{
		this.authorID = authorID;
		this.authorName = authorName;
	}
	/**
	 * ask the Author class for a unique id
	 * @return uniqueAuthorID
	 */
	private static Integer getUniqueAuthorID()
	{
		uniqueAuthorID++;
		return uniqueAuthorID;
	}
	/**
	 * @return the authorID
	 */
	public Integer getAuthorID() {
		return authorID;
	}
	/**
	 * @return the authorName
	 */
	public StringBuffer getAuthorName() {
		return authorName;
	}
	/**
	 * @param name the name to set
	 */
	public void setAuthorName(StringBuffer authorName) {
		this.authorName = authorName;
	}

	public StringBuffer toStringBuffer() {
		return new StringBuffer().append(authorID).append('|').append(authorName);
	}
	
}
