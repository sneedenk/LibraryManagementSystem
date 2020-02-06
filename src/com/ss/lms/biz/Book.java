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
	 * sets the unique Book counter
	 * only intended to be called from LMS.load()
	 * @param numberOfExistingBooks how many books were loaded from Books.txt
	 */
	protected static void setUniqueBookID(Integer numberOfExistingBooks)
	{
		uniqueBookID = numberOfExistingBooks;
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
	public void setPublisherID(Integer publisherID) {
		this.publisherID = publisherID;
	}
	/**
	 * 
	 * @return StringBuffer representation of Book data
	 */
	public StringBuffer toStringBuffer() 
	{
		return new StringBuffer().append(bookID).append('|').append(title).append('|').append(authorID).append('|').append(publisherID);
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((authorID == null) ? 0 : authorID.hashCode());
		result = prime * result + ((bookID == null) ? 0 : bookID.hashCode());
		result = prime * result + ((publisherID == null) ? 0 : publisherID.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (authorID == null) {
			if (other.authorID != null)
				return false;
		} else if (!authorID.equals(other.getAuthorID()))
			return false;
		if (publisherID == null) {
			if (other.publisherID != null)
				return false;
		} else if (!publisherID.equals(other.getPublisherID()))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.toString().equals(other.getTitle().toString()))
			return false;
		return true;
	}
	
}
