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
public class Branch {

	private Integer branchID;
	private StringBuffer branchName;
	private StringBuffer branchAddress;
	private List<Copies> copies;
	/**
	 * 
	 */
	public Branch(Integer branchID, StringBuffer branchName, StringBuffer branchAddress) {
		this.branchID = branchID;
		this.branchName = branchName;
		this.branchAddress = branchAddress;
		this.copies = new ArrayList<Copies>();
	}
	/**
	 * @return the branchID
	 */
	public Integer getBranchID() {
		return branchID;
	}
	/**
	 * @param branchID the branchID to set
	 */
	public void setBranchID(Integer branchID) {
		this.branchID = branchID;
	}
	/**
	 * @return the branchName
	 */
	public StringBuffer getBranchName() {
		return branchName;
	}
	/**
	 * @param branchName the branchName to set
	 */
	public void setBranchName(StringBuffer branchName) {
		this.branchName = branchName;
	}
	/**
	 * @return the address
	 */
	public StringBuffer getAddress() {
		return branchAddress;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(StringBuffer branchAddress) {
		this.branchAddress = branchAddress;
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
	public StringBuffer toStringBuffer() {
		return new StringBuffer().append(branchID).append('|').append(branchName).append('|').append(branchAddress);
	}
}
