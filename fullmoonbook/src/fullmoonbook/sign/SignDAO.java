package fullmoonbook.sign;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import fullmoonbook.join.MemberVO;

public class SignDAO {
	public static void main(String[] args) {
		SignDAO dao = new SignDAO();
		MemberVO vo2 = new MemberVO("60", "60");
	dao.findUser(vo2);
		
		
	}
    private static SignDAO instance = new SignDAO();
    public static SignDAO getInstance() {
        return instance;
    }
    private SignDAO() {}

    public MemberVO findUser(MemberVO vo) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = "jdbc:oracle:thin:@192.168.142.39:1521:XE";
            String user = "pc26_4";
            String password = "java";
            Connection connection = DriverManager.getConnection(url, user, password);
            StringBuilder builder = new StringBuilder();
            builder.append("SELECT");
            builder.append("    id,");
            builder.append("    pw");
            builder.append(" FROM");
            builder.append("    member");
            builder.append(" WHERE");
            builder.append("    id = ? AND pw = ?");
            String sql = builder.toString();
         
            PreparedStatement statement = connection.prepareStatement(sql);
            System.out.println(sql);
            statement.setString(1, vo.getId());
            statement.setString(2, vo.getPw());
            System.out.println(sql+vo);

            ResultSet resultSet = statement.executeQuery();
            

            if (resultSet.next()) {
                MemberVO mem = new MemberVO();
                mem.setId(resultSet.getString("id"));
                mem.setPw(resultSet.getString("pw"));
                return mem;
            } else {
                return null;
            }
        } catch (Exception e) {
            System.out.println("데이터베이스 연결에 실패했습니다. 원인: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}