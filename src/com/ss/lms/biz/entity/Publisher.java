/**
 * 
 */
package com.ss.lms.biz.entity;

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
	private StringBuffer phoneNumber;

	/**
	 * general use constructor
	 * @param publisherName
	 * @param address
	 */
	public Publisher(StringBuffer publisherName, StringBuffer address, StringBuffer phoneNumber) 
	{
		this.publisherName = publisherName;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.publisherID = getUniquePublisherID();
	}
	/**
	 * only intended for use from LMS.load()
	 * @param publisherID
	 * @param publisherName
	 * @param address
	 */
	public Publisher(Integer publisherID, StringBuffer publisherName) 
	{
		this.publisherID = publisherID;
		this.publisherName = publisherName;
		this.address = null;
		this.phoneNumber = null;
	}
	
	/**
	 * sets the unique Publisher counter
	 * only intended to be called from LMS.load()
	 * @param numberOfExistingPublishers how many publishers were loaded from Publishers.txt
	 */
	protected static void setUniquePublisherID(Integer numberOfExistingPublishers)
	{
		uniquePublisherID = numberOfExistingPublishers;
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
	/**
	 * 
	 * @return StringBuffer representation of Publisher data
	 */
	public StringBuffer toStringBuffer() {
		return new StringBuffer().append(publisherID).append('|').append(publisherName).append('|').append(address).append('|').append(phoneNumber);
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((publisherID == null) ? 0 : publisherID.hashCode());
		result = prime * result + ((publisherName == null) ? 0 : publisherName.hashCode());
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
		Publisher other = (Publisher) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.toString().equals(other.getAddress().toString()))
			return false;
		if (publisherName == null) {
			if (other.publisherName != null)
				return false;
		} else if (!publisherName.toString().equals(other.getPublisherName().toString()))
			return false;
		return true;
	}
	
}
