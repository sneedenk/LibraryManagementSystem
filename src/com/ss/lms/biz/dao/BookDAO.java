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
import com.ss.lms.biz.entity.Publisher;

/**
 * @bookdao Kyle Sneeden
 *
 */
public class BookDAO extends BaseDAO<Book> {

	public BookDAO(Connection conn) {
		super(conn);
	}

	public void addBook(Book book) throws ClassNotFoundException, SQLException {
		save("insert into tbl_book (title, pubId) values (?, ?)", new Object[] { book.getTitle(), book.getPublisher().getPublisherID() });
	}
	
	public Integer addBookReturnPK(Book book) throws ClassNotFoundException, SQLException {
		return saveReturnPk("insert into tbl_book (title, pubId) values (?, ?)", new Object[] { book.getTitle(), book.getPublisher().getPublisherID() });
	}

	public void updateBook(Book book) throws SQLException, ClassNotFoundException {
		save("update tbl_book set title=?, pubId=? WHERE bookId=?", new Object[]{book.getTitle(), book.getPublisher().getPublisherID(), book.getBookID()} );
	}

	public void deleteBook(Book book) throws ClassNotFoundException, SQLException {
		save("delete from tbl_book where bookId = ?", new Object[] {book.getBookID()});
	}
	
	public List<Book> readBooks() throws ClassNotFoundException, SQLException {
		return read("select * from tbl_books", null);
	}
	
	public List<Book> readBooksByTitle(String title) throws ClassNotFoundException, SQLException {
		return read("select * from tbl_books where title = ?", new Object[]{title});
	}
	
	public List<Book> readBooksByAuthor(Author author) throws ClassNotFoundException, SQLException {
		return read("select * from tbl_books where authorId = ?", new Object[]{author.getAuthorID()});
	}
	
	public List<Book> readBooksWithPublisher() throws ClassNotFoundException, SQLException {
		return read("select * from tbl_book INNER JOIN tbl_publisher ON tbl_book.pubId=tbl_publisher.publisherId;", new Object[]{});
	}
	
	public List<Book> readBooksByPublisher(Integer publisherId) throws ClassNotFoundException, SQLException {
		return read("select * from tbl_book INNER JOIN tbl_publisher ON tbl_book.pubId=tbl_publisher.publisherId and tbl_publisher.publisherId=?;", new Object[]{publisherId});
	}
	
	public List<Book> readBooksWithAll() throws ClassNotFoundException, SQLException {
		return read("select * from (((tbl_book "
				+ "INNER JOIN tbl_publisher ON tbl_book.pubId=tbl_publisher.publisherId)"
				+ "INNER JOIN tbl_genre ON tbl_book.bookId=tbl_book_genres.bookId)"
				+ "INNER JOIN tbl_book_genres ON tbl_book_genres.genre_id=tbl_genre.genre_id;", new Object[]{});
	}

	@Override
	public List<Book> extractData(ResultSet rs) throws SQLException, ClassNotFoundException {
		List<Book> books = new ArrayList<>();
		AuthorDAO adao = new AuthorDAO(conn);
		PublisherDAO pdao = new PublisherDAO(conn);
		pdao.read
		Publisher publisher = new Publisher(); //get publisher by its ID
		//genre doa, branch dao
		while(rs.next()){
			Book b = new Book(new Integer(rs.getInt("bookId")), new StringBuffer(rs.getString("title")), new Integer(rs.getInt("pubId"))));
			b.setBookId(rs.getInt("bookId"));
			b.setTitle(rs.getString("title"));
			b.setAuthors(adao.readFirstLevel("select * from tbl_author where authorId IN "
					+ "(select authorId from tbl_book_authors where bookId = ?)", new Object[] {b.getBookId()}));
			//b.setGenres, b.setBranches etc
			books.add(b);
		}
		return books;
	}
	
	@Override
	public List<Book> extractDataFirstLevel(ResultSet rs) throws SQLException, ClassNotFoundException {
		List<Book> books = new ArrayList<>();
		AuthorDAO adao = new AuthorDAO(conn);
		//genre doa, branch dao
		while(rs.next()){
			Book b = new Book();
			b.setBookId(rs.getInt("bookId"));
			b.setTitle(rs.getString("title"));
			books.add(b);
		}
		return books;
	}

}
