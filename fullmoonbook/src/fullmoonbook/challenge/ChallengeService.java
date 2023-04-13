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

	public ChallengeVO insertChallengeStatus(ChallengeVO vo) throws Exception {

		ChallengeVO vo1 = new ChallengeVO();

		

		vo1.setId(BookApplication.getSession().getId());
		vo1.setStatus(BookApplication.challengeGetSession().getStatus());
		return dao.insertChallengeStatus(vo1);
	}

}
