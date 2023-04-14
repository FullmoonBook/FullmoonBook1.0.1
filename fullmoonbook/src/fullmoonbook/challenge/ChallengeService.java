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
		ChallengeVO status = new ChallengeVO();
		status.setId(BookApplication.getSession().getId());
		status.setBookNo("0003");
		status.setStatus(BookApplication.challengeGetSession().getStatus());
		status.setGoal(0);
		return dao.insertChallengeStatus(status);
	}
	public int updateGoal(ChallengeVO vo) throws Exception {
		ChallengeVO goal = new ChallengeVO();
		goal.setId(BookApplication.getSession().getId());
		goal.setBookNo("0003");
		goal.setNowPage(BookApplication.challengeGetSession().getGoal());
		goal.setPage(165);
		return dao.updateGoal(goal);
	}

	
}
