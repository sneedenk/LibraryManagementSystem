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
public class Book implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4349935307192043860L;
	private Integer bookID;
	private StringBuffer title;
	private Publisher publisher;
	private List<Author> authors;
	private List<Genre> genres;
	private List<Loans> loans;
	private List<Copies> copies;
	// copies and loans?
	
	/**
	 * general use constructor
	 * 
	 * @param title
	 * @param author
	 * @param publisher
	 */
	public Book(StringBuffer title, Publisher publisher) {
		this.title = title;
		this.publisher = publisher;
		this.authors = new ArrayList<Author>();
		this.genres = new ArrayList<Genre>();
		this.loans = new ArrayList<Loans>();
		this.copies = new ArrayList<Copies>();
	}

	/**
	 * only intended for use from LMS.load()
	 * 
	 * @param bookID
	 * @param title
	 * @param author
	 * @param publisher
	 */
	public Book(Integer bookID, StringBuffer title, Publisher publisher) {
		this.bookID = bookID;
		this.title = title;
		this.publisher = publisher;
		this.authors = new ArrayList<Author>();
		this.genres = new ArrayList<Genre>();
		this.loans = new ArrayList<Loans>();
		this.copies = new ArrayList<Copies>();
	}

	/**
	 * @return the bookID
	 */
	public Integer getBookID() {
		return bookID;
	}
	

	/**
	 * @param bookID the bookID to set
	 */
	public void setBookID(Integer bookID) {
		this.bookID = bookID;
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
	public List<Author> getAuthors() {
		return authors;
	}

	/**
	 * @param author the author to set
	 */
	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

	/**
	 * @return the publisher
	 */
	public Publisher getPublisher() {
		return publisher;
	}

	/**
	 * @param publisher the publisher to set
	 */
	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	/**
	 * @return the genres
	 */
	public List<Genre> getGenres() {
		return genres;
	}

	/**
	 * @param genres the genres to set
	 */
	public void setGenres(List<Genre> genres) {
		this.genres = genres;
	}

	/**
	 * @return the loans
	 */
	public List<Loans> getLoans() {
		return loans;
	}

	/**
	 * @param loans the loans to set
	 */
	public void setLoans(List<Loans> loans) {
		this.loans = loans;
	}
	

	/**
	 * @return the copies
	 */
	public List<Copies> getCopies() {
		return copies;
	}

	/**
	 * @param copies the copies to set
	 */
	public void setCopies(List<Copies> copies) {
		this.copies = copies;
	}

	/**
	 * 
	 * @return StringBuffer representation of Book data
	 */
	public StringBuffer toStringBuffer() {
		return new StringBuffer().append(bookID).append('|').append(title).append('|').append(authors.toString())
				.append('|').append(publisher);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((authors == null) ? 0 : authors.hashCode());
		result = prime * result + ((bookID == null) ? 0 : bookID.hashCode());
		result = prime * result + ((publisher == null) ? 0 : publisher.hashCode());
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
		if (authors == null) {
			if (other.authors != null)
				return false;
		} else if (!authors.equals(other.getAuthors()))
			return false;
		if (publisher == null) {
			if (other.publisher != null)
				return false;
		} else if (!publisher.equals(other.getPublisher()))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.toString().equals(other.getTitle().toString()))
			return false;
		return true;
	}

}
