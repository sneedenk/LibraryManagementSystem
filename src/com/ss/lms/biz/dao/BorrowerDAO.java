/**
 * 
 */
package com.ss.lms.biz.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.lms.biz.entity.Borrower;

/**
 * @author UCI
 *
 */
public class BorrowerDAO extends BaseDAO {

	/**
	 * @param conn
	 */
	public BorrowerDAO(Connection conn) {
		super(conn);
	}
	public void addBorrower(Borrower borrower) throws ClassNotFoundException, SQLException {
		save("insert into tbl_borrower (name, address, phone) values (?, ?, ?)", new Object[] { borrower.getName().toString(), borrower.getAddress().toString(), borrower.getPhoneNumber().toString()});
	}
	
	public Integer addBorrowerReturnPK(Borrower borrower) throws ClassNotFoundException, SQLException {
		return saveReturnPk("insert into tbl_borrower (name, address, phone) values (?, ?, ?)", new Object[] { borrower.getName().toString(), borrower.getAddress().toString(), borrower.getPhoneNumber().toString()});
	}

	public void updateBorrower(Borrower borrower) throws SQLException, ClassNotFoundException {
		save("update tbl_borrower set name=?, address=?, phone=? WHERE cardNo=?", new Object[]{borrower.getName().toString(), borrower.getAddress().toString(), borrower.getPhoneNumber().toString(), borrower.getBorrowerID()});
	}

	public void deleteBorrower(Borrower borrower) throws ClassNotFoundException, SQLException {
		save("delete from tbl_borrower where cardNo = ?", new Object[] {borrower.getBorrowerID()});
	}
	
	public List<Borrower> readBorrowers() throws ClassNotFoundException, SQLException {
		return read("select * from tbl_borrower", null);
	}
	
	public List<Borrower> readBorrowersByName(String borrowerName) throws ClassNotFoundException, SQLException {
		return read("select * from tbl_borrower where name = ?", new Object[]{borrowerName});
	}
	
	public List<Borrower> readBorrowersByID(Integer borrowerID) throws ClassNotFoundException, SQLException {
		return read("select * from tbl_borrower where cardNo = ?", new Object[]{borrowerID});
	}

	@Override
	List<Borrower> extractData(ResultSet rs) throws SQLException, ClassNotFoundException {
		List<Borrower> borrowers = new ArrayList<Borrower>();
		while(rs.next()){
			Borrower borrower = new Borrower(new Integer(rs.getInt("cardNo")), new StringBuffer(rs.getString("name")), 
					new StringBuffer(rs.getString("address")), new StringBuffer(rs.getString("phone")));
			borrowers.add(borrower);
		}
		return borrowers;
	}

	@Override
	List extractDataFirstLevel(ResultSet rs) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
