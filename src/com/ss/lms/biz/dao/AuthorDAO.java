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

/**
 * @author Kyle Sneeden
 *
 */
public class AuthorDAO extends BaseDAO<Author> {

	public AuthorDAO(Connection conn) {
		super(conn);
	}

	public void addAuthor(Author author) throws ClassNotFoundException, SQLException {
		save("insert into tbl_author (authorName) values (?)", new Object[] { author.getAuthorName() });
	}
	
	public Integer addAuthorReturnPK(Author author) throws ClassNotFoundException, SQLException {
		return saveReturnPk("insert into tbl_author (authorName) values (?)", new Object[] { author.getAuthorName() });
	}

	public void updateAuthor(Author author) throws SQLException, ClassNotFoundException {
		save("update tbl_author set authorName" + "=? where authorId = ?", new Object[]{author.getAuthorName(),author.getAuthorID()} );
	}

	public void deleteAuthor(Author author) throws ClassNotFoundException, SQLException {
		save("delete from tbl_author where authorId = ?", new Object[] {author.getAuthorID()});
	}
	
	public void insertBookAuthors(Author author, Book book) throws ClassNotFoundException, SQLException{
		save("insert into tbl_book_author values(?, ?)", new Object[] {author.getAuthorID(), book.getBookID()});
	}
	
	public List<Author> readAuthors() throws ClassNotFoundException, SQLException {
		return read("select * from tbl_author", null);
	}
	public List<Author> readAuthorsByName(String authorName) throws ClassNotFoundException, SQLException {
		return read("select * from tbl_author where authorName = ?", new Object[]{authorName});
	}
	public List<Author> readBookAuthors() throws ClassNotFoundException, SQLException
	{
		return read("select * from tbl_book_author", null); //returns a list of authors each containing a list of books
	}
	public List<Author> readBookAuthorsByAuthor(Author author) throws ClassNotFoundException, SQLException
	{
		return read("select * from tbl_book_author where authorId = '?'", new Object[] {author.getAuthorID()});
	}

	@Override
	public List<Author> extractData(ResultSet rs) throws SQLException, ClassNotFoundException {
		List<Author> authors = new ArrayList<>();
		BookDAO bdao = new BookDAO(conn);
		while(rs.next()){
			Author author = new Author(new Integer(rs.getInt("authorId")), new StringBuffer(rs.getString("authorName")));
			author.setBooks(bdao.readFirstLevel("select * from tbl_book where bookId IN "
					+ "(select bookId from tbl_book_authors where authorId = ?)",
					new Object[]{author.getAuthorID()}));
			authors.add(author);
		}
		return authors;
	}
	
	@Override
	public List<Author> extractDataFirstLevel(ResultSet rs) throws SQLException, ClassNotFoundException {
		List<Author> authors = new ArrayList<>();
		BookDAO bdao = new BookDAO(conn);
		
		while(rs.next()){
			Author a = new Author(rs.getInt("authorId"), new StringBuffer(rs.getString("authorName")));
			authors.add(a);
		}
		return authors;
	}

}
