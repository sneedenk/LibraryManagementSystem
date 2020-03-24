/**
 * 
 */
package com.ss.lms.biz.dao;
import com.ss.lms.biz.entity.Loans;
import com.ss.lms.biz.entity.Publisher;
import com.ss.lms.biz.entity.Loans;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author UCI
 *
 */
public class LoansDAO extends BaseDAO<Loans> {

	/**
	 * @param conn
	 */
	public LoansDAO(Connection conn) {
		super(conn);
	}
	
	public void addLoans(Loans loan) throws ClassNotFoundException, SQLException {
		save("insert into tbl_book_loans (bookId, branchId, cardNo, dateOut, dueDate, dateIn) values (?, ?, ?, ?, ?, ?)", new Object[] { loan.getBook().getBookID(), loan.getBranch().getBranchID(), loan.getBorrower().getBorrowerID(), loan.getDateTimeOut(), loan.getDueDateTime(), loan.getDateTimeIn()});
	}
	
	public Integer addLoansReturnPK(Loans loan) throws ClassNotFoundException, SQLException {
		return saveReturnPk("insert into tbl_book_loans (bookId, branchId, cardNo, dateOut, dueDate, dateIn) values (?, ?, ?, ?, ?, ?)", new Object[] { loan.getBook().getBookID(), loan.getBranch().getBranchID(), loan.getBorrower().getBorrowerID(), loan.getDateTimeOut(), loan.getDueDateTime(), loan.getDateTimeIn()});
	}

	public void updateLoans(Loans loan) throws SQLException, ClassNotFoundException {
		save("update tbl_book_loans set dateOut=?, dueDate=?, dateIn=? WHERE bookId=?, branchId=?, cardNo=?", new Object[]{loan.getDateTimeOut(), loan.getDueDateTime(), loan.getDateTimeIn(), loan.getBook().getBookID(), loan.getBranch().getBranchID(), loan.getBorrower().getBorrowerID()} );
	}

	public void deleteLoans(Loans loan) throws ClassNotFoundException, SQLException {
		save("delete from tbl_book_loans where bookId=?, branchId=?, cardNo=?", new Object[] {loan.getBook().getBookID(), loan.getBranch().getBranchID(), loan.getBorrower().getBorrowerID()});
	}
	
	public List<Loans> readLoans() throws ClassNotFoundException, SQLException {
		return read("select * from tbl_book_loans", null);
	}
	
	//going to need to read by composite key
	public List<Loans> readLoansByLoan(Loans loan) throws ClassNotFoundException, SQLException {
		return read("select * from tbl_book_loans where bookId=? and branchId=? and cardNo=?", new Object[]{loan.getBook().getBookID(), loan.getBranch().getBranchID(), loan.getBorrower().getBorrowerID()});
	}

	

	@Override
	List<Loans> extractData(ResultSet rs) throws SQLException, ClassNotFoundException {
		List<Loans> loans = new ArrayList<Loans>();
		while(rs.next()){
			Loans loan = new Loans(new Integer(rs.getInt("bookId")), new Integer(rs.getInt("branchId")), new Integer(rs.getInt("cardNo"));
			loan.setAddress(new StringBuffer(rs.getString("publisherAddress")));
			loan.setPhoneNumber(new StringBuffer(rs.getString("publisherPhone")));
			loans.add(loan);
		}
		return loans;
	}

	@Override
	List extractDataFirstLevel(ResultSet rs) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
