package fullmoonbook.review;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ReviewDAO {
//	public static void main(String[] args) throws Exception {
//		ReviewDAO dao = new ReviewDAO();
//		ReviewVO vo = new ReviewVO("sujiking", "0001", "ㅋㅋㅋㅋ너무 감동적입니다...", 5);
//		dao.insertReview(vo);
//		
//		List<ReviewVO> reviews = dao.getReviews();
//		for (ReviewVO vo1 : reviews) {
//			System.out.println(vo1);
//		}
//	}

	private static ReviewDAO instance = new ReviewDAO();

	public ReviewDAO() {
	}

	public static ReviewDAO getInstance() {
		return instance;
	}
	
	public int insertReview(ReviewVO vo) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@192.168.142.39:1521:XE";
		String user = "pc26_4";
		String password = "java";
		Connection connection = DriverManager.getConnection(url, user, password);
		StringBuilder builder = new StringBuilder();
		builder.append("    INSERT INTO review (");
		builder.append("        id,");
		builder.append("        book_no,");
		builder.append("        content,");
		builder.append("        grade");
		builder.append("    ) VALUES (");
		builder.append("        ?,");
		builder.append("        ?,");
		builder.append("        ?,");
		builder.append("        ?");
		builder.append("    )");
		String sql = builder.toString();
		PreparedStatement statement = connection.prepareStatement(sql);

		statement.setString(1, vo.getId());
		statement.setString(2, vo.getBookNo());
		statement.setString(3, vo.getContent());
		statement.setInt(4, vo.getGrade());

		int count = statement.executeUpdate();
		statement.close();
		connection.close();
		return count;
	}

	

	public List<ReviewVO> getReviews() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@192.168.142.39:1521/xe";
		String user = "pc26_4";
		String password = "java";
		Connection connection = DriverManager.getConnection(url, user, password);
		Statement statement = connection.createStatement();
		StringBuilder builder = new StringBuilder();
		builder.append("    SELECT ");
		builder.append("        id,");
		builder.append("        book_no,");
		builder.append("        content,");
		builder.append("        grade");
		builder.append("    FROM ");
		builder.append("        review ");
		String sql = builder.toString();
		ResultSet resultSet = statement.executeQuery(sql);
		List<ReviewVO> list = new ArrayList<>();
		while (resultSet.next()) {
			String id = resultSet.getString("id");
			String bookNo = resultSet.getString("book_no");
			String content = resultSet.getString("content");
			int grade = resultSet.getInt("grade");
//			Timestamp registerDate = resultSet.getTimestamp("register_date");
//			Timestamp modifyDate = resultSet.getTimestamp("modify_date");
			list.add(new ReviewVO(id, content, grade));
		}
		resultSet.close();
		statement.close();
		connection.close();
		return list;
	}
}
