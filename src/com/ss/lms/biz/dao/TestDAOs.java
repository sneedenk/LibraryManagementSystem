package com.ss.lms.biz.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.ss.lms.biz.entity.Author;
import com.ss.lms.biz.entity.Borrower;
import com.ss.lms.biz.entity.Branch;
import com.ss.lms.biz.entity.Copies;
import com.ss.lms.biz.entity.Genre;
import com.ss.lms.biz.entity.Loans;
import com.ss.lms.biz.entity.Publisher;

public class TestDAOs {
	
	public static String driver = "com.mysql.cj.jdbc.Driver";
	public static String url = "jdbc:mysql://localhost:3306/library?useSSL=false";
	public static String username = "root";
	public static String password = "root";

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//1. Register Driver.
		Class.forName(driver);
		
		//2. Connection
		Connection conn = DriverManager.getConnection(url, username, password);
		
		//3. Statement
//		String query = "select * from tbl_author";
		//PreparedStatement pstmt = conn.prepareStatement("select * from tbl_author");
		
		//ResultSet rs = pstmt.executeQuery();
		//while(rs.next()){
		//	System.out.println("Author Name: " +rs.getString("authorName")
		//			+ " with Author ID: "+rs.getInt("authorId"));
		//}
		
		//AuthorDAO adao = new AuthorDAO(conn);
		//List<Author> authors = adao.readAuthors();
		//System.out.println(authors.toString());
		
		
		
		//pdao update works
//		PublisherDAO pdao = new PublisherDAO(conn);
//		Publisher updatedPublisher = new Publisher(14, new StringBuffer("Nuaka"));
//		updatedPublisher.setAddress(new StringBuffer("681 Swanson Avenue, SI, NY 10303"));
//		updatedPublisher.setPhoneNumber(new StringBuffer("666-555-4444"));
//		pdao.updatePublisher(updatedPublisher);
//		
		//pdao reads work
//		List<Publisher> publishers = pdao.readPublisher();
//		for(Publisher publisher : publishers) {
//			System.out.println(publisher.toStringBuffer().toString());
//		}
//		publishers = pdao.readPublisherByID(14);
//		for(Publisher publisher : publishers) {
//			System.out.println(publisher.toStringBuffer().toString());
//		}
		
		
		//gdao update works
//		GenreDAO gdao = new GenreDAO(conn);
//		Genre updatedGenre = new Genre(20, new StringBuffer("Urban"));
//		gdao.updateGenre(updatedGenre);
//				
//		//gdao reads works
//		List<Genre> genres = gdao.readGenre();
//		for(Genre genre : genres) {
//			System.out.println(genre.toStringBuffer().toString());
//		}
//		genres = gdao.readGenreByID(20);
//		for(Genre genre : genres) {
//			System.out.println(genre.toStringBuffer().toString());
//		}
		
		//brdao update works
//		BranchDAO brdao = new BranchDAO(conn);
//		Branch updatedBranch = new Branch(19, new StringBuffer("Tomorrows Library"), new StringBuffer("Tomorrow Land, CA, USA"));
//		brdao.updateBranch(updatedBranch);
//				
//		//brdao reads works
//		List<Branch> branches = brdao.readBranches();
//		for(Branch branch : branches) {
//			System.out.println(branch.toStringBuffer().toString());
//		}
//		branches = brdao.readBranchesByID(19);
//		for(Branch branch : branches) {
//			System.out.println(branch.toStringBuffer().toString());
//		}
		
		
//		//bordao update works
//		BorrowerDAO bordao = new BorrowerDAO(conn);
//		Borrower updatedBorrower = new Borrower(84555491, new StringBuffer("Kevin Smith"), new StringBuffer("Somewhere In NJ, USA"), new StringBuffer("(908) 971-0404"));
//		bordao.updateBorrower(updatedBorrower);
//				
//		//bordao reads works
//		List<Borrower> borrowers = bordao.readBorrowers();
//		for(Borrower borrower : borrowers) {
//			System.out.println(borrower.toStringBuffer().toString());
//		}
//		borrowers = bordao.readBorrowersByID(84555491);
//		for(Borrower borrower : borrowers) {
//			System.out.println(borrower.toStringBuffer().toString());
//		}
		
		
//		//cdao update works
//		CopiesDAO cdao = new CopiesDAO(conn);
//		Copies updatedCopies = new Copies(18, 11);
//		updatedCopies.setNumberOfCopies(5);
//		cdao.updateCopiesByBook(updatedCopies);
//				
//		//cdao reads works
//		List<Copies> copies = cdao.readCopies();
//		for(Copies copy : copies) {
//			System.out.println(copy.toStringBuffer().toString());
//		}
//		copies = cdao.readCopiesByBook(18);
//		for(Copies copy : copies) {
//			System.out.println(copy.toStringBuffer().toString());
//		}
		
		
		//cdao update works
		LoansDAO ldao = new LoansDAO(conn);
//		Loans updatedLoans = new Loans(18, 11);
//		updatedLoans.setNumberOfCopies(5);
//		ldao.updateLoansByBook(updatedCopies);
				
		//cdao reads works
		List<Loans> loans = ldao.readLoans();
		for(Loans loan : loans) {
			System.out.println(loan.toStringBuffer().toString());
		}
		loans = ldao.readLoansByBook(18);
		for(Loans loan : loans) {
			System.out.println(loan.toStringBuffer().toString());
		}
	}
}
