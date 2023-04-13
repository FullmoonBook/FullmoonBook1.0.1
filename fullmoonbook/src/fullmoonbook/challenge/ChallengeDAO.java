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

	private static ChallengeDAO instance = new ChallengeDAO(); // 싱글톤

	private ChallengeDAO() {
	}

	public static ChallengeDAO getInstance() {
		return instance;
	}

	public ChallengeVO getChallenge(String searchBookNo) throws Exception {

		// System.out.println(searchBookNo);//로그

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.142.39:1521:xe", "pc26_4",
				"java");
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
		PreparedStatement statement = connection.prepareStatement(sql);

		statement.setString(1, searchBookNo);
	
		ResultSet resultSet = statement.executeQuery();
		ChallengeVO vo = null;
		
		if (resultSet.next()) {
			String bookName = resultSet.getString("book_name");
			String author = resultSet.getString("author");
			int page = resultSet.getInt("page");
			int challenger = resultSet.getInt("challenger");
			vo = new ChallengeVO(bookName, author, page, challenger);
		}
		resultSet.close();
		statement.close();
		connection.close();
		return vo;
	}

	public int insertChallengeStatus(String id, String status, int goal) {
		return 0;
	}

	public ChallengeVO insertChallengeStatus(ChallengeVO vo) throws Exception {
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.142.39:1521:xe", "pc26_4",
				"java");
		StringBuilder builder = new StringBuilder();
		builder.append("INSERT INTO challenge (");
		builder.append("    id,");
		builder.append("    book_no,");
		builder.append("    status,");
		builder.append("    goal");
		builder.append(") VALUES (");
		builder.append("    ?,"); // 현재 아이디로 불러와져야 함.
		builder.append("    ?,");// 현재 챌린지 책... (이건 scanner로 못받겠다)
		builder.append("    ?,");
		builder.append("    ?"); // goal은 받는 값이 아니지만 계산해서 넣어야하니까!
		builder.append(")");
		String sql = builder.toString();

		PreparedStatement statement = connection.prepareStatement(sql);
		System.out.println(sql + "dao1");
		System.out.println(sql + vo + "dao2");

		statement.setString(1, vo.getId());
		statement.setString(2, vo.getBookNo());
		statement.setString(3, vo.getStatus());
		statement.setInt(4, vo.getGoal());

		ResultSet resultSet = statement.executeQuery();
		
		ChallengeVO vo1 = null;
		
		if (resultSet.next()) {
			String id = resultSet.getString("id");
			String bookNo = resultSet.getString("book_no");
			String status = resultSet.getString("status");
			int goal = resultSet.getInt("goal");
			vo1 = new ChallengeVO(id, bookNo, status, goal);
		}
		
		resultSet.close();
		statement.close();
		connection.close();
		return vo1;
	}

	public ChallengeVO getChallenger(String searchBookNo) throws Exception {
		// System.out.println(searchBookNo);//로그
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.142.39:1521:xe", "pc26_4",
				"java");
		StringBuilder builder = new StringBuilder();
		builder.append("SELECT");
		builder.append("    COUNT(*)");
		builder.append(" FROM");
		builder.append("    challenge");
		builder.append(" WHERE");
		builder.append("    book_no = ? ");

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

}