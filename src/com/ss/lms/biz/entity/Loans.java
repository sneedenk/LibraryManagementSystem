/**
 * 
 */
package com.ss.lms.biz.entity;
import java.time.LocalDateTime;

/**
 * @author UCI
 *
 */
public class Loans {

	private Book book;
	private Branch branch;
	private Borrower borrower;
	private LocalDateTime dateOut;
	private LocalDateTime dateIn;
	private LocalDateTime dueDate;
	/**
	 * 
	 */
	public Loans(Book book, Branch branch, Borrower borrower) {
		this.book = book;
		this.branch = branch;
		this.borrower = borrower;

	}
	/**
	 * @return the book
	 */
	public Book getBook() {
		return book;
	}
	/**
	 * @param book the book to set
	 */
	public void setBook(Book book) {
		this.book = book;
	}
	/**
	 * @return the branch
	 */
	public Branch getBranch() {
		return branch;
	}
	/**
	 * @param branch the branch to set
	 */
	public void setBranch(Branch branch) {
		this.branch = branch;
	}
	/**
	 * @return the borrower
	 */
	public Borrower getBorrower() {
		return borrower;
	}
	/**
	 * @param borrower the borrower to set
	 */
	public void setBorrower(Borrower borrower) {
		this.borrower = borrower;
	}
	/**
	 * @return the dateOut
	 */
	public LocalDateTime getDateTimeOut() {
		return dateOut;
	}
	/**
	 * @param dateOut the dateOut to set
	 */
	public void setDateTimeOut(LocalDateTime dateOut) {
		this.dateOut = dateOut;
	}
	/**
	 * @return the dateIn
	 */
	public LocalDateTime getDateTimeIn() {
		return dateIn;
	}
	/**
	 * @param dateIn the dateIn to set
	 */
	public void setDateTimeIn(LocalDateTime dateIn) {
		this.dateIn = dateIn;
	}
	/**
	 * @return the dueDate
	 */
	public LocalDateTime getDueDateTime() {
		return dueDate;
	}
	/**
	 * @param dueDate the dueDate to set
	 */
	public void setDueDateTime(LocalDateTime dueDate) {
		this.dueDate = dueDate;
	}

}
