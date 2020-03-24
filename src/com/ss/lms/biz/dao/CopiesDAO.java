/**
 * 
 */
package com.ss.lms.biz.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.lms.biz.entity.Author;
import com.ss.lms.biz.entity.Book;
import com.ss.lms.biz.entity.Branch;
import com.ss.lms.biz.entity.Copies;

/**
 * @author UCI
 *
 */
public class CopiesDAO extends BaseDAO<Copies> {
	
	public CopiesDAO(Connection conn) {
		super(conn);
	}

	public void addCopies(Copies copies) throws ClassNotFoundException, SQLException {
		save("insert into tbl_book_copies (bookId, branchId, noOfCopies) values (?, ?, ?)", new Object[] { copies.getBookID(), copies.getBranchID(), copies.getNumberOfCopies() });
	}
	
	public Integer addCopiesReturnPK(Copies copies) throws ClassNotFoundException, SQLException {
		return saveReturnPk("insert into tbl_book_copies (bookId, branchId, noOfCopies) values (?, ?, ?)", new Object[] { copies.getBookID(), copies.getBranchID(), copies.getNumberOfCopies() });
	}

	public void updateCopiesByBook(Copies copies) throws SQLException, ClassNotFoundException {
		save("update tbl_book_copies set branchId=?, noOfCopies=? WHERE bookId=?", new Object[]{copies.getBranchID(), copies.getNumberOfCopies(), copies.getBookID()} );
	}
	
	public void updateCopiesByBranch(Copies copies) throws SQLException, ClassNotFoundException {
		save("update tbl_book_copies set bookId=?, noOfCopies=? WHERE branchId=?", new Object[]{copies.getBookID(), copies.getNumberOfCopies(), copies.getBranchID()} );
	}

	public void deleteCopiesByBook(Copies copies) throws ClassNotFoundException, SQLException {
		save("delete from tbl_book_copies where bookId = ?", new Object[] {copies.getBookID()});
	}
	
	public void deleteCopiesByBranch(Copies copies) throws ClassNotFoundException, SQLException {
		save("delete from tbl_book_copies where branchId = ?", new Object[] {copies.getBranchID()});
	}
	
	public List<Copies> readCopies() throws ClassNotFoundException, SQLException {
		return read("select * from tbl_book_copies", null);
	}
	public List<Copies> readCopiesByBook(Integer bookID) throws ClassNotFoundException, SQLException {
		return read("select * from tbl_book_copies where bookId = ?", new Object[]{bookID});
	}
	public List<Copies> readCopiesByBranch(Integer branchID) throws ClassNotFoundException, SQLException {
		return read("select * from tbl_book_copies where branchId = ?", new Object[]{branchID});
	}

	@Override
	List<Copies> extractData(ResultSet rs) throws SQLException, ClassNotFoundException {
		List<Copies> copies = new ArrayList<Copies>();
		//populate copies
		while(rs.next()){
			Copies copy = new Copies(new Integer(rs.getInt("bookId")), new Integer(rs.getInt("branchId")));
			copy.setNumberOfCopies(rs.getInt("noOfCopies"));
			copies.add(copy);
		}
		return copies;
	}

	@Override
	List<Copies> extractDataFirstLevel(ResultSet rs) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
}
