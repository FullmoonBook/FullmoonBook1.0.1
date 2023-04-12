package fullmoonbook.common;

import fullmoonbook.book.FrontController;
import fullmoonbook.join.MemberVO;

public class BookstoreApplication {
    private static MemberVO session = new MemberVO();

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
}
