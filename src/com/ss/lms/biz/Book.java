/**
 * 
 */
package com.ss.lms.biz;
/**
 * @author Kyle Sneeden
 *
 */
public class Book 
{
	private static Integer uniqueBookID = 0;
	private Integer bookID;
	private StringBuffer title;
	private Integer authorID;
	private Integer publisherID;
	/**
	 * 
	 */
	public Book(StringBuffer title, Integer author, Integer publisher) 
	{
		this.title = title;
		this.authorID = author;
		this.publisherID = publisher;
		this.bookID = getUniqueBookID();
	}
	public Book(Integer bookID, StringBuffer title, Integer author, Integer publisher) 
	{
		this.bookID = bookID;
		this.title = title;
		this.authorID = author;
		this.publisherID = publisher;
	}
	
	/**
	 * ask the Book class for a unique id
	 * @return uniqueBookID
	 */
	private static Integer getUniqueBookID()
	{
		uniqueBookID++;
		return uniqueBookID;
	}
	
	/**
	 * @return the bookID
	 */
	public Integer getBookID() {
		return bookID;
	}
	/**
	 * @return the title
	 */
	public StringBuffer getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(StringBuffer title) {
		this.title = title;
	}
	/**
	 * @return the author
	 */
	public Integer getAuthorID() {
		return authorID;
	}
	/**
	 * @param author the author to set
	 */
	public void setAuthorID(Integer authorID) {
		this.authorID = authorID;
	}
	/**
	 * @return the publisher
	 */
	public Integer getPublisherID() {
		return publisherID;
	}
	/**
	 * @param publisher the publisher to set
	 */
	public void setPublisher(Integer publisherID) {
		this.publisherID = publisherID;
	}

	public StringBuffer toStringBuffer() 
	{
		return new StringBuffer().append(bookID).append('|').append(title).append('|').append(authorID).append('|').append(publisherID);
	}

}
