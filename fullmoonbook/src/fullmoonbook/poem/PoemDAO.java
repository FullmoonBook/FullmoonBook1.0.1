package fullmoonbook.poem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class PoemDAO {
//	public static void main(String[] args) throws Exception {
//		PoemDAO dao = new PoemDAO();
//		List<PoemVO> poems = dao.getPoems();
//		Random random = new Random();
//		int randomIndex = random.nextInt(poems.size());
//		System.out.println(poems.get(randomIndex));
//	}
	private static PoemDAO instance = new PoemDAO();

	public PoemDAO() {
	}

	public static PoemDAO getInstance() {
		return instance;
	}
	
	public List<PoemVO> getPoems() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@192.168.142.32:1521:XE";
		String user = "pc24_4";
		String password = "java";
		Connection connection = DriverManager.getConnection(url, user, password);
		Statement statement = connection.createStatement();
		StringBuilder builder = new StringBuilder();
		builder.append(" SELECT");
		builder.append("     poem_no, ");
		builder.append("     title, ");
		builder.append("     poet, ");
		builder.append("     verse ");
		builder.append(" FROM ");
		builder.append("     poem ");
		String sql = builder.toString();
		ResultSet resultSet = statement.executeQuery(sql);
		List<PoemVO> list = new ArrayList<>();
		while (resultSet.next()) {
			int poemno = resultSet.getInt("poem_no");
			String title = resultSet.getString("title");
			String poet = resultSet.getString("poet");
			String verse = resultSet.getString("verse");
			list.add(new PoemVO(poemno, title, poet, verse));
		}
		resultSet.close();
		statement.close();
		connection.close();
		return list;
	}
}