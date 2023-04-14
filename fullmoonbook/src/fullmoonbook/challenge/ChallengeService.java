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
	
	public ChallengeVO getStatus(ChallengeVO vo) throws Exception {
		ChallengeVO status = new ChallengeVO();
		status.setId(BookApplication.getSession().getId());
		status.setStatus(BookApplication.challengeGetSession().getStatus());

		return dao.getStatus(vo);
	}

	public int insertChallengeStatus(ChallengeVO vo) throws Exception {
		ChallengeVO iStatus = new ChallengeVO();
		iStatus.setId(BookApplication.getSession().getId());
		iStatus.setBookNo("0003");
		iStatus.setStatus(BookApplication.challengeGetSession().getStatus());
		iStatus.setGoal(BookApplication.challengeGetSession().getGoal());
		return dao.insertChallengeStatus(iStatus);
	}
	public int updateGoal(ChallengeVO vo) throws Exception {
		ChallengeVO goal = new ChallengeVO();
		goal.setId(BookApplication.getSession().getId());
		goal.setBookNo("0003");
		goal.setNowPage(BookApplication.challengeGetSession().getNowPage());
		goal.setPage(165);
		return dao.updateGoal(goal);
	}

	
}
