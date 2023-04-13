package fullmoonbook.common;

import fullmoonbook.book.FrontController;
import fullmoonbook.challenge.ChallengeVO;
import fullmoonbook.join.MemberVO;

public class BookApplication {
    private static MemberVO session = new MemberVO();
    private static ChallengeVO session1 = new ChallengeVO();

    public static void main(String[] args) throws Exception {
        new FrontController().process();
    }

    /**
     * 로그인한 정보를 가져오는 메소드
     * @return session 정보 반환
     */
    public static MemberVO getSession() {
        return session;
    }
    public static ChallengeVO challengeGetSession() {
        return session1;
    }
    
}
