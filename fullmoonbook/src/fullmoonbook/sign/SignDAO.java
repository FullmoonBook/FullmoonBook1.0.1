package fullmoonbook.sign;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import fullmoonbook.join.MemberVO;

public class SignDAO {
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
            builder.append("    pw,");
            builder.append("    nick");
            builder.append(" FROM");
            builder.append("    member");
            builder.append(" WHERE");
            builder.append("    id = ? AND pw = ?");
            String sql = builder.toString();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, vo.getId());
            statement.setString(2, vo.getPw());

            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                MemberVO result = new MemberVO();
                result.setId(rs.getString("id"));
                result.setPw(rs.getString("pw"));
                result.setNick(rs.getString("nick"));
                return result;
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