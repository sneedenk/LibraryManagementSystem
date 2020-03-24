/**
 * 
 */
package com.ss.lms.biz.entity;

/**
 * @author UCI
 *
 */
public class Copies {

	private Integer bookID;
	private Integer branchID;
	private Integer numberOfCopies;
	/**
	 * 
	 */
	public Copies(Integer bookID, Integer branchID) {
		this.bookID = bookID;
		this.branchID = branchID;
		this.numberOfCopies = new Integer(0);
	}
	/**
	 * @return the book
	 */
	public Integer getBookID() {
		return bookID;
	}
	/**
	 * @param book the book to set
	 */
	public void setBook(Integer bookID) {
		this.bookID = bookID;
	}
	/**
	 * @return the branch
	 */
	public Integer getBranchID() {
		return branchID;
	}
	/**
	 * @param branch the branch to set
	 */
	public void setBranchID(Integer branchID) {
		this.branchID = branchID;
	}
	/**
	 * @return the numberOfCopies
	 */
	public Integer getNumberOfCopies() {
		return numberOfCopies;
	}
	/**
	 * @param numberOfCopies the numberOfCopies to set
	 */
	public void setNumberOfCopies(Integer numberOfCopies) {
		this.numberOfCopies = numberOfCopies;
	}

	public StringBuffer toStringBuffer()
	{
		return new StringBuffer().append(bookID).append('|').append(branchID).append('|').append(numberOfCopies);
	}
}
