package fullmoonbook.challenge;

public class ChallengeController {
	private static ChallengeController instance = new ChallengeController();
	private ChallengeController() {
	}
	public static ChallengeController getInstance() {
		return instance;
	}
	
	private ChallengeService service = ChallengeService.getInstance();
	
	public ChallengeVO getChallenge(String searchBookNo) throws Exception {
		return service.getChallenge(searchBookNo);		
	} 
}
