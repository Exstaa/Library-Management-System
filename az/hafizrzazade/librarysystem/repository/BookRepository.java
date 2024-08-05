package az.hafizrzazade.librarysystem.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import az.hafizrzazade.librarysystem.database.Database;
import az.hafizrzazade.librarysystem.model.Book;

public class BookRepository {
	private final Connection conn = Database.getConn();

	public void addBook(Book b) {
		try {
			String query = "INSERT INTO library_book(title,author,isIssued) VALUES (?,?,?)";
			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, b.getTitle());
			st.setString(2, b.getAuthor());
			st.setBoolean(3, b.isIssued());
			st.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateBook(Book b) {
		try {
			String query = "UPDATE FROM library_book SET title = ?, author = ?, isIssued = ? WHERE id = ?";
			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, b.getTitle());
			st.setString(2, b.getAuthor());
			st.setBoolean(3, b.isIssued());
			st.setString(4, b.getId());
			st.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteBook(String bookId) {
		try {
			String query = "DELETE FROM library_book WHERE id = ?";
			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, bookId);
			st.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Book> getAllBooks() {
		ArrayList<Book> books = new ArrayList();
		String query = "SELECT * FROM library_book";
		try {
			PreparedStatement st = conn.prepareStatement(query);
			ResultSet response = st.executeQuery();
			while (response.next()) {
				Book book = new Book();
				book.setId(response.getString("id"));
				book.setTitle(response.getString("title"));
				book.setAuthor(response.getString("author"));
				book.setIssued(response.getBoolean("is_issued"));
				books.add(book);
			}
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return books;
	}
}
