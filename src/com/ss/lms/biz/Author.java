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
