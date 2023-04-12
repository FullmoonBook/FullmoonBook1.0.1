package fullmoonbook.sign;

import fullmoonbook.join.MemberVO;

public class SignService {
    private static SignService instance = new SignService();
    public static SignService getInstance() {
        return instance;
    }
    private SignService() {}

    private SignDAO dao = SignDAO.getInstance();

    public MemberVO findUser(MemberVO vo) throws Exception {
      return vo;
    }
}