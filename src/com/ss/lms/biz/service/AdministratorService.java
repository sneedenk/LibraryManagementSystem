/**
 * 
 */
package com.ss.lms.biz.service;

import java.sql.Connection;
import java.sql.SQLException;
import com.ss.lms.biz.dao.*;
import com.ss.lms.biz.dao.AuthorDAO;
import com.ss.lms.biz.entity.Author;
import com.ss.lms.biz.entity.Book;

/**
 * @author Kyle Sneeden
 *
 */
public class AdministratorService {
	
	public ConnectionUtil connUtil = new ConnectionUtil();
	
	public void saveAuthor(Author author) throws SQLException{
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			AuthorDAO adao = new AuthorDAO(conn);
			Integer authorId = adao.addAuthorReturnPK(author);// save new author.
			author.setAuthorID(authorId);
			//add to book_authors table, authorid & bookid.h
			//bookid is provided by user. 
			for(Book b: author.getBooks()){
				adao.insertBookAuthors(author, b);
			}
			conn.commit();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			conn.rollback();
			System.out.println("Something failed with add Author");
		} finally {
			conn.close();
		}
	}

}
