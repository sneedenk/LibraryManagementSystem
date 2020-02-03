/**
 * 
 */
package com.ss.lms.biz;

/**
 * @author Kyle Sneeden
 *
 */
public class Publisher 
{
	private static Integer uniquePublisherID = 0;
	private Integer publisherID;
	private StringBuffer publisherName;
	private StringBuffer address;
	/**
	 * 
	 */
	public Publisher(StringBuffer publisherName, StringBuffer address) 
	{
		this.publisherName = publisherName;
		this.address = address;
		this.publisherID = getUniquePublisherID();
	}
	public Publisher(Integer publisherID, StringBuffer publisherName, StringBuffer address) 
	{
		this.publisherID = publisherID;
		this.publisherName = publisherName;
		this.address = address;
	}
	/**
	 * ask the Publisher class for a unique id
	 * @return uniquePublisherID
	 */
	private static Integer getUniquePublisherID()
	{
		uniquePublisherID++;
		return uniquePublisherID;
	}
	/**
	 * @return the publisherID
	 */
	public Integer getPublisherID() {
		return publisherID;
	}
	/**
	 * @return the publisherName
	 */
	public StringBuffer getPublisherName() {
		return publisherName;
	}
	/**
	 * @param publisherName the publisherName to set
	 */
	public void setPublisherName(StringBuffer publisherName) {
		this.publisherName = publisherName;
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
	 * 
	 * @return StringBuffer with Publisher class data
	 */
	public StringBuffer toStringBuffer() {
		return new StringBuffer().append(publisherID).append('|').append(publisherName).append('|').append(address);
	}
	
}
