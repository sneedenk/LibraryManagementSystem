/**
 * 
 */
package com.ss.lms.biz.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ss.lms.biz.entity.Branch;
import com.ss.lms.biz.entity.Genre;
import com.ss.lms.biz.entity.Publisher;
/**
 * @author UCI
 *
 */
public class GenreDAO extends BaseDAO<Genre>{

	/**
	 * @param conn
	 */
	public GenreDAO(Connection conn) {
		super(conn);
	}
	
	public void addGenre(Genre genre) throws ClassNotFoundException, SQLException {
		save("insert into tbl_genre (genre_id, genre_name) values (?, ?)", new Object[] { genre.getGenreID(), genre.getGenreName().toString()});
	}
	
	public Integer addGenreReturnPK(Genre genre) throws ClassNotFoundException, SQLException {
		return saveReturnPk("insert into tbl_genre (genre_id, genre_name) values (?, ?)", new Object[] { genre.getGenreID(), genre.getGenreName().toString()});
	}

	public void updateGenre(Genre genre) throws SQLException, ClassNotFoundException {
		save("update tbl_genre set genre_name=? where genre_id = ?", new Object[]{genre.getGenreName().toString(), genre.getGenreID()} );
	}

	public void deleteGenre(Genre genre) throws ClassNotFoundException, SQLException {
		save("delete from tbl_genre where genre_id = ?", new Object[] {genre.getGenreID()});
	}
	
	public List<Genre> readGenre() throws ClassNotFoundException, SQLException {
		return read("select * from tbl_genre", null);
	}
	
	public List<Genre> readGenreByName(String genreName) throws ClassNotFoundException, SQLException {
		return read("select * from tbl_genre where genre_name = ?", new Object[]{genreName});
	}
	
	public List<Genre> readGenreByID(Integer genreID) throws ClassNotFoundException, SQLException {
		return read("select * from tbl_genre where genre_id = ?", new Object[]{genreID});
	}

	@Override
	List<Genre> extractData(ResultSet rs) throws SQLException, ClassNotFoundException {
		List<Genre> genres = new ArrayList<Genre>();
		while(rs.next()){
			Genre genre = new Genre(new Integer(rs.getInt("genre_id")), new StringBuffer(rs.getString("genre_name")));
			genres.add(genre);
		}
		return genres;

	}

	@Override
	List<Genre> extractDataFirstLevel(ResultSet rs) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}


}
