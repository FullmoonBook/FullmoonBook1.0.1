package fullmoonbook.challenge;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import fullmoonbook.common.BookApplication;

public class ChallengeDAO {
	private static ChallengeDAO instance = new ChallengeDAO(); // 싱글톤
	private ChallengeVO session = BookApplication.challengeGetSession();


	public ChallengeDAO() {
	}

	public static ChallengeDAO getInstance() {
		return instance;
	}

	// 챌린지 정보 가져오기
	public ChallengeVO getChallenge(String searchBookNo) throws Exception {
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

	//챌린지 시작 업데이트
	public int insertChallengeStatus(ChallengeVO vo) throws Exception {
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.142.39:1521:xe", "pc26_4", "java");
		StringBuilder builder = new StringBuilder();
		builder.append("INSERT INTO challenge (");
		builder.append("    id,");
		builder.append("    book_no,");
		builder.append("    status,");
		builder.append("    goal");
		builder.append(") VALUES (");
		builder.append("    ?,");
		builder.append("    ?,");
		builder.append("    ?,");
		builder.append("    ?");
		builder.append(")");
		String sql = builder.toString();

		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, vo.getId());
		statement.setString(2, vo.getBookNo());
		statement.setString(3, vo.getStatus());
		statement.setInt(4, vo.getGoal());
		

		int count = statement.executeUpdate();
		statement.close();
		connection.close();
		return count;

	}
    // 달성률 업데이트
	public int updateGoal(ChallengeVO vo) throws Exception {
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.142.39:1521:xe", "pc26_4", "java");
		StringBuilder builder = new StringBuilder();
		builder.append("UPDATE ");
		builder.append("    challenge ");
		builder.append("SET ");
		builder.append("    goal = ? ");
		builder.append("WHERE ");
		builder.append("    id = ? "); 
		builder.append("AND ");
		builder.append(" book_no = ? ");

		String sql = builder.toString();

		PreparedStatement statement = connection.prepareStatement(sql);

		double inputPage = vo.getNowPage();
		double bookPage = vo.getPage();
		double result = (inputPage / bookPage) * 100;

		statement.setInt(1, (int) result);
		statement.setString(2, vo.getId());
		statement.setString(3, vo.getBookNo());
		
		session.setGoal((int)result);

		int count = statement.executeUpdate();
		statement.close();
		connection.close();
		return count;

	}
	
    // 챌린저 수 구하기
	public int getChallenger(String countBookNo) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.142.39:1521:xe", "pc26_4","java");
		StringBuilder builder = new StringBuilder();
		builder.append("SELECT");
		builder.append("    COUNT(*) ");
		builder.append("FROM ");
		builder.append("    challenge ");
		builder.append("WHERE");
		builder.append("        book_no = ? ");
		builder.append("    AND status = ? ");
		String sql = builder.toString();
		PreparedStatement statement = connection.prepareStatement(sql);

		statement.setString(1, countBookNo);
		statement.setString(2, "y");

		ResultSet resultSet = statement.executeQuery();
	    int count = 0;
		if (resultSet.next()) {
			count = resultSet.getInt(1);
		}
		

		resultSet.close();
		statement.close();
		connection.close();
		return count;
	}
	public ChallengeVO getStatus(ChallengeVO vo) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.142.39:1521:xe", "pc26_4","java");
		StringBuilder builder = new StringBuilder();
		builder.append("SELECT");
		builder.append("    status ");
		builder.append("FROM ");
		builder.append("    challenge ");
		builder.append("WHERE");
		builder.append("       id = ? ");
		String sql = builder.toString();
		PreparedStatement statement = connection.prepareStatement(sql);

		statement.setString(1, vo.getId());

		ResultSet resultSet = statement.executeQuery();
		ChallengeVO vo1 = null;

		if (resultSet.next()) {
			String status = resultSet.getString("status");
			vo1 = new ChallengeVO(status);
		}
		resultSet.close();
		statement.close();
		connection.close();
		return vo1;
	}

}