/**
 * 
 */
package com.ss.lms.biz.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author UCI
 *
 */
public class Genre {

	private Integer genreID;
	private StringBuffer genreName;
	private List<Book> books;
	/**
	 * 
	 */
	public Genre(Integer genreID, StringBuffer genreName) {
		this.genreID = genreID;
		this.genreName = genreName;
		books = new ArrayList<Book>();
	}
	/**
	 * @return the genreID
	 */
	public Integer getGenreID() {
		return genreID;
	}
	/**
	 * @param genreID the genreID to set
	 */
	public void setGenreID(Integer genreID) {
		this.genreID = genreID;
	}
	/**
	 * @return the genreName
	 */
	public StringBuffer getGenreName() {
		return genreName;
	}
	/**
	 * @param genreName the genreName to set
	 */
	public void setGenreName(StringBuffer genreName) {
		this.genreName = genreName;
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

	public StringBuffer toStringBuffer()
	{
		StringBuffer sb = new StringBuffer().append(genreID).append('|').append(genreName);
		for(Book book : books)
		{
			sb.append('|').append(book);
		}
		return sb;
	}
}
