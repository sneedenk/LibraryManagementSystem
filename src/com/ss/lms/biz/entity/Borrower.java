/**
 * 
 */
package com.ss.lms.biz.entity;

/**
 * @author UCI
 *
 */
public class Borrower {

	private Integer borrowerID;
	private StringBuffer name;
	private StringBuffer address;
	private StringBuffer phoneNumber;
	/**
	 * 
	 */
	public Borrower(Integer borrowerID, StringBuffer name, StringBuffer address, StringBuffer phoneNumber) {
		this.borrowerID = borrowerID;
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}
	/**
	 * @return the borrowerID
	 */
	public Integer getBorrowerID() {
		return borrowerID;
	}
	/**
	 * @param borrowerID the borrowerID to set
	 */
	public void setBorrowerID(Integer borrowerID) {
		this.borrowerID = borrowerID;
	}
	/**
	 * @return the name
	 */
	public StringBuffer getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(StringBuffer name) {
		this.name = name;
	}
	/**
	 * @return the address
	 */
	public StringBuffer getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(StringBuffer address) {
		this.address = address;
	}
	/**
	 * @return the phoneNumber
	 */
	public StringBuffer getPhoneNumber() {
		return phoneNumber;
	}
	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(StringBuffer phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public StringBuffer toStringBuffer() {
		return new StringBuffer().append(borrowerID).append('|').append(name).append('|').append(address).append('|').append(phoneNumber);
	}
}
