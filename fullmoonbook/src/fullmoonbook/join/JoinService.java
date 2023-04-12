package fullmoonbook.join;

public class JoinService {
    private static JoinService instance = new JoinService();
    public static JoinService getInstance() {
        return instance;
    }
    private JoinService() {}

    private JoinDAO dao = JoinDAO.getInstance();

//    public MemberVO findCustomer(String id) {
//        return dao.findCustomer(id);
//    }

    public int join(MemberVO vo) throws Exception {
        return dao.join(vo);
    }
    

//    public int modifyInfo(MemberVO vo, HomeMenu menu) {
//        int result = 0;
//        switch (menu) {
//            case MODIFY_NAME:
//                result = dao.modifyName(vo);
//                break;
//        }
//        return result;
//    }
//
//    public int modifyPassword(MemberVO vo) {
//        return dao.modifyPassword(vo);
//    }
}
