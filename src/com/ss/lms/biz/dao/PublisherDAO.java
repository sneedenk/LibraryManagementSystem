/**
 * 
 */
package com.ss.lms.biz.dao;
import com.ss.lms.biz.entity.Author;
import com.ss.lms.biz.entity.Publisher;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author UCI
 *
 */
public class PublisherDAO extends BaseDAO<Publisher> {

	/**
	 * @param conn
	 */
	public PublisherDAO(Connection conn) {
		super(conn);
	}
	
	public void addPublisher(Publisher publisher) throws ClassNotFoundException, SQLException {
		save("insert into tbl_publisher (publisherName, publisherAddress, publisherPhone) values (?, ?, ?)", new Object[] { publisher.getPublisherName(), publisher.getAddress(), publisher.getPhoneNumber()});
	}
	
	public Integer addPublisherReturnPK(Publisher publisher) throws ClassNotFoundException, SQLException {
		return saveReturnPk("insert into tbl_publisher (publisherName, publisherAddress, publisherPhone) values (?, ?, ?)", new Object[] { publisher.getPublisherName(), publisher.getAddress(), publisher.getPhoneNumber()});
	}

	public void updatePublisher(Publisher publisher) throws SQLException, ClassNotFoundException {
		save("update tbl_publisher set publisherName=?, publisherAddress=?, publisherPhone=? where publisherId = ?", new Object[]{publisher.getPublisherName().toString(), publisher.getAddress().toString(), publisher.getPhoneNumber().toString(), publisher.getPublisherID()} );
	}

	public void deletePublisher(Publisher publisher) throws ClassNotFoundException, SQLException {
		save("delete from tbl_publisher where publisherId = ?", new Object[] {publisher.getPublisherID()});
	}
	
	public List<Publisher> readPublisher() throws ClassNotFoundException, SQLException {
		return read("select * from tbl_publisher", null);
	}
	
	public List<Publisher> readPublisherByName(String publisherName) throws ClassNotFoundException, SQLException {
		return read("select * from tbl_publisher where publisherName = ?", new Object[]{publisherName});
	}
	
	public List<Publisher> readPublisherByID(Integer publisherID) throws ClassNotFoundException, SQLException {
		return read("select * from tbl_publisher where publisherId = ?", new Object[]{publisherID});
	}


	@Override
	List<Publisher> extractData(ResultSet rs) throws SQLException, ClassNotFoundException {
		List<Publisher> publishers = new ArrayList<Publisher>();
		while(rs.next()){
			Publisher publisher = new Publisher(new Integer(rs.getInt("publisherId")), new StringBuffer(rs.getString("publisherName")));
			publisher.setAddress(new StringBuffer(rs.getString("publisherAddress")));
			publisher.setPhoneNumber(new StringBuffer(rs.getString("publisherPhone")));
			publishers.add(publisher);
		}
		return publishers;
	}

	@Override
	List<Publisher> extractDataFirstLevel(ResultSet rs) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
