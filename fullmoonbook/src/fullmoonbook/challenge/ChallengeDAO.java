package fullmoonbook.challenge;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class ChallengeDAO {
//	public static void main(String[] args) throws Exception {
//		ChallengeDAO dao = new ChallengeDAO();
//		ChallengeVO vo = dao.getChallenge("0001");
//
//		System.out.println(vo);//로그
//	}
	
	private static ChallengeDAO instance = new ChallengeDAO(); //싱글톤
	private ChallengeDAO() {
	}
	public static ChallengeDAO getInstance() {
		return instance;
	}
	
	public ChallengeVO getChallenge(String searchBookNo) throws Exception {
		
		//System.out.println(searchBookNo);//로그
	
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.142.39:1521:xe", "pc26_4", "java");
		StringBuilder builder = new StringBuilder();
		builder.append("SELECT");
		builder.append("    book_name,");
		builder.append("    author,");
		builder.append("    page,");
		builder.append("    challenger ");
		builder.append("FROM");
		builder.append("    book ");
		builder.append("WHERE");
		builder.append("    book_no = ?");
		
		String sql = builder.toString();
//		System.out.println(sql + searchBookNo );
		PreparedStatement statement = connection.prepareStatement(sql);
		
		statement.setString(1, searchBookNo);
		System.out.println(sql);

		
		ResultSet resultSet = statement.executeQuery();
		ChallengeVO vo = null;
		if (resultSet.next()) {
			String bookName = resultSet.getString("book_name");
			String author = resultSet.getString("author");
			vo = new ChallengeVO(bookName, author);
		}
		resultSet.close();
		statement.close();
		connection.close();
		return vo;		
		
		
	}
	public ChallengeVO insertChallengeStatus(String status) throws Exception {
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.142.39:1521:xe", "pc26_4", "java");
		StringBuilder builder = new StringBuilder();
		
	}
	
}
