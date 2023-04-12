package fullmoonbook.join;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JoinDAO {
	public static void main(String[] args) throws Exception {
		JoinDAO dao = new JoinDAO();
		MemberVO vo = new MemberVO("se", "1234", "서주");
		dao.join(vo);
	}
	private static JoinDAO instance = new JoinDAO();

	public static JoinDAO getInstance() {
		return instance;
	}

	private JoinDAO() {

	}

	public int join(MemberVO vo) throws Exception {
		System.out.println(vo);
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@192.168.142.39:1521:XE";
		String user = "pc26_4";
		String password = "java";
		Connection connection = DriverManager.getConnection(url, user, password);
		StringBuilder builder = new StringBuilder();
		builder.append("    INSERT INTO member (");
		builder.append("        id,");
		builder.append("        pw,");
		builder.append("        nick");
		builder.append("    ) VALUES (");
		builder.append("        ?,");
		builder.append("        ?,");
		builder.append("        ?");
		builder.append("    )");
		String sql = builder.toString();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, vo.getId());
		statement.setString(2, vo.getPw());
		statement.setString(3, vo.getNick());
	
		int count = statement.executeUpdate();
		statement.close();
		connection.close();
	
		return count;

	}
}
