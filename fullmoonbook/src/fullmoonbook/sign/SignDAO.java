package fullmoonbook.sign;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import fullmoonbook.challenge.ChallengeVO;
import fullmoonbook.common.BookApplication;
import fullmoonbook.join.MemberVO;

public class SignDAO {
//	public static void main(String[] args) {
//		SignDAO dao = new SignDAO();
//		MemberVO vo2 = new MemberVO("60", "60");
//		try {
//			dao.findUser(vo2);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	private ChallengeVO session = BookApplication.challengeGetSession();

	private static SignDAO instance = new SignDAO();

	public static SignDAO getInstance() {
		return instance;
	}

	private SignDAO() {
	}

	public MemberVO findUser(MemberVO vo) throws Exception {

		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@192.168.142.32:1521:XE";
		String user = "pc24_4";
		String password = "java";
		Connection connection = DriverManager.getConnection(url, user, password);
		StringBuilder builder = new StringBuilder();
		builder.append("SELECT");
		builder.append("    id,");
		builder.append("    pw");
		builder.append(" FROM");
		builder.append("    member");
		builder.append(" WHERE");
//		builder.append("    id = ? AND pw = ?");
		builder.append("    rtrim(id) = ? AND pw = ?");
		String sql = builder.toString();

		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, vo.getId());
		statement.setString(2, vo.getPw());

		ResultSet resultSet = statement.executeQuery();
		MemberVO member = null;
		if (resultSet.next()) {
			String id = resultSet.getString("id");
			String pw = resultSet.getString("pw");
			session.setId(id);
			member = new MemberVO(id, pw);
		}
		
		resultSet.close();
		statement.close();
		connection.close();
		return member;
	}
}