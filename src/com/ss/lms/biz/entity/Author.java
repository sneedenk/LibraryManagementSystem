/**
 * 
 */
package com.ss.lms.biz.entity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Kyle Sneeden
 *
 */
public class Author implements Serializable
{

	private static final long serialVersionUID = 6486880787858832463L;
	private static Integer uniqueAuthorID = 0;
	private Integer authorID;
	private StringBuffer authorName;
	private List<Book> books;

	/**
	 * general use constructor
	 * @param authorName
	 */
	public Author(StringBuffer authorName) 
	{
		this.authorName = authorName;
		this.authorID = getUniqueAuthorID();
		this.books = new ArrayList<Book>();
	}
	/**
	 * only intended for use from LMS.load()
	 * @param authorID
	 * @param authorName
	 */
	public Author(Integer authorID, StringBuffer authorName) 
	{
		this.authorID = authorID;
		this.authorName = authorName;
		this.books = new ArrayList<Book>();
	}
	/**
	 * sets the unique Author counter
	 * only intended to be called from LMS.load()
	 * @param numberOfExistingAuthors how many authors were loaded from Authors.txt
	 */
	protected static void setUniqueAuthorID(Integer numberOfExistingAuthors)
	{
		uniqueAuthorID = numberOfExistingAuthors;
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
	 * @param authorID the authorID to set
	 */
	public void setAuthorID(Integer authorID) {
		this.authorID = authorID;
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
	
	/**
	 * add a book by this author
	 * @param book
	 */
	public void addBook(Book book)
	{
		books.add(book);
	}
	
	/**
	 * @return the books
	 */
	public List<Book> getBooks() {
		return books;
	}
	/**
	 * @param books the books to set
	 */
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	/**
	 * 
	 * @return StringBuffer representation of Author data
	 */
	public StringBuffer toStringBuffer() {
		return new StringBuffer().append(authorID).append('|').append(authorName);
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((authorID == null) ? 0 : authorID.hashCode());
		result = prime * result + ((authorName == null) ? 0 : authorName.hashCode());
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
		Author other = (Author) obj;
		if (authorName == null) {
			if (other.authorName != null)
				return false;
		} else if (!authorName.toString().equals(other.getAuthorName().toString()))
			return false;
		return true;
	}
	
}
