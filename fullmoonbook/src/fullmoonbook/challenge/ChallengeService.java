package fullmoonbook.challenge;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import fullmoonbook.common.BookApplication;

public class ChallengeService {

	private static ChallengeService instance = new ChallengeService(); // 싱글톤

	private ChallengeService() {
	}

	public static ChallengeService getInstance() {
		return instance;
	}

	private ChallengeDAO dao = ChallengeDAO.getInstance();

	public ChallengeVO getChallenge(String searchBookNo) throws Exception {
		return dao.getChallenge(searchBookNo);
	}

	public int insertChallengeStatus(ChallengeVO vo) throws Exception {
		ChallengeVO vo1 = new ChallengeVO();
		vo1.setId(BookApplication.getSession().getId());
		vo1.setBookNo("0003");
		vo1.setStatus(BookApplication.challengeGetSession().getStatus());
		vo1.setGoal(0);
		
		System.out.println(vo1 + "service");
		return dao.insertChallengeStatus(vo1);
	}
}
