package fullmoonbook.book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
	public static void main(String[] args) {
		try {
			BookDAO dao = new BookDAO();
			BookVO book1 = dao.getNowChallenge("0003");
			BookVO book2 = dao.getNextChallenge("0004");

			System.out.println(book1.printA());



		} catch (Exception e) {
			System.err.println("에러" + e.getMessage());
		}

	}

	private static BookDAO instance = new BookDAO();

	BookDAO() {
	}

	public static BookDAO getInstance() {
		return instance;
	}

	public BookVO getNowChallenge(String nowChallengeBookNo) throws Exception {
		//System.out.println(nowChallengeBookNo);
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@192.168.142.39:1521:XE";
		String user = "pc26_4";
		String password = "java";
		Connection connection = DriverManager.getConnection(url, user, password);
		StringBuilder builder = new StringBuilder();

		builder.append("SELECT ");
		builder.append("  book_no, ");
		builder.append("  book_name, ");
		builder.append("  subtitle, ");
		builder.append("  author, ");
		builder.append("  page, ");
		builder.append("  genre, ");
		builder.append("  publisher, ");
		builder.append("  period, ");
		builder.append("  challenger ");
		builder.append("FROM ");
		builder.append("  book ");
		builder.append("WHERE ");
		builder.append("  book_no = ? ");
		String sql = builder.toString();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, nowChallengeBookNo);
		ResultSet resultSet = statement.executeQuery();

		BookVO vo = null;
		if (resultSet.next()) {
			String bookNo = resultSet.getString("book_no");
			String bookName = resultSet.getString("book_name");
			String subtitle = resultSet.getString("subtitle");
			String author = resultSet.getString("author");
			int page = resultSet.getInt("page");
			String genre = resultSet.getString("genre");
			String publisher = resultSet.getString("publisher");
			String period = resultSet.getString("period");
			int challenger = resultSet.getInt("challenger");
			vo = new BookVO(bookNo, bookName, subtitle, author, page, genre, publisher, period, challenger);
		}
		resultSet.close();
		statement.close();
		connection.close();
		return vo;
	}

	public BookVO getNextChallenge(String nextChallengeBookNo) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@192.168.142.39:1521:XE";
		String user = "pc26_4";
		String password = "java";
		Connection connection = DriverManager.getConnection(url, user, password);
		StringBuilder builder = new StringBuilder();

		builder.append("SELECT ");
		builder.append("  book_no, ");
		builder.append("  book_name, ");
		builder.append("  subtitle, ");
		builder.append("  author, ");
		builder.append("  page, ");
		builder.append("  genre, ");
		builder.append("  publisher, ");
		builder.append("  period, ");
		builder.append("  challenger ");
		builder.append("FROM ");
		builder.append("  book ");
		builder.append("WHERE ");
		builder.append("  book_no = ? ");
		String sql = builder.toString();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, nextChallengeBookNo);
		ResultSet resultSet = statement.executeQuery();

		BookVO vo = null;
		if (resultSet.next()) {
			String bookNo = resultSet.getString("book_no");
			String bookName = resultSet.getString("book_name");
			String subtitle = resultSet.getString("subtitle");
			String author = resultSet.getString("author");
			int page = resultSet.getInt("page");
			String genre = resultSet.getString("genre");
			String publisher = resultSet.getString("publisher");
			String period = resultSet.getString("period");
			int challenger = resultSet.getInt("challenger");
			vo = new BookVO(bookNo, bookName, subtitle, author, page, genre, publisher, period, challenger);
		}
		resultSet.close();
		statement.close();
		connection.close();
		return vo;
	}
}
