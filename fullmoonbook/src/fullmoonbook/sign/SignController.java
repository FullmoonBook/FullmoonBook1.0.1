package fullmoonbook.sign;

import java.util.Scanner;

import fullmoonbook.common.BookApplication;
import fullmoonbook.common.HomeMenu;
import fullmoonbook.join.MemberVO;

public class SignController {
    private static SignController instance = new SignController();
    public static SignController getInstance() {
        return instance;
    }
    private SignController() {}

    private SignService service = SignService.getInstance();
    private SignView view = SignView.getInstance();
    private MemberVO session = BookApplication.getSession();

    public MemberVO signIn(Scanner scanner) throws Exception {
    	MemberVO vo = view.inputLoginInfo(scanner);
    	System.out.println(vo + "sign");
    	MemberVO member = service.findUser(vo);
        if (member != null) {
            session.setId(member.getId());
            System.out.println(member);
            session.setPw(member.getPw());
        }
        return view.resultLogin(member);
    }
    public HomeMenu signOut() {
        // 세션 초기화
        session.invalidate();
        return HomeMenu.HOME;
        
    }
}
