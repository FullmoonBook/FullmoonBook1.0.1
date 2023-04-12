package fullmoonbook.challenge;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class ChallengeService {
	
	private static ChallengeService instance = new ChallengeService(); //싱글톤
	private ChallengeService() {
	}
	public static ChallengeService getInstance() {
		return instance;
	}
	private ChallengeDAO dao = ChallengeDAO.getInstance();
	
	public ChallengeVO getChallenge(String searchBookNo) throws Exception {
		return dao.getChallenge(searchBookNo);		
	}

}
