package fullmoonbook.join;

import java.util.Scanner;

import fullmoonbook.common.HomeMenu;
import fullmoonbook.common.MainView;

public class JoinController {
    private static JoinController instance = new JoinController();
    public static JoinController getInstance() {
        return instance;
    }
    private JoinController() {}

    private JoinService service = JoinService.getInstance();
    private JoinView view = JoinView.getInstance();
    private MainView mainView = MainView.getInstance();


    public void join(Scanner scanner) throws Exception {
        boolean flag = true;
        while (flag) {
            MemberVO vo = view.inputJoinInfo(scanner);
            
            if (vo == null) {
                flag = false;
            } else {
                int result = service.join(vo);
                flag = view.resultJoin(result, scanner);
            }
        }
        
    }

//    public HomeMenu getCustomerInfo() {
//        MemberVO vo = service.findCustomer(BookstoreApplication.getSession().getId());
//        view.printCustomerInfo(vo);
//        return HomeMenu.CUSTOMER;
//    }

//    public HomeMenu modifyInfo(Scanner scanner, HomeMenu menu) {
//        String modifyData = MainView.inputData(scanner);
//        MemberVO vo = new MemberVO();
//        vo.setId(BookstoreApplication.getSession().getId());
//        switch (menu) {
//            case MODIFY_NAME:
//                vo.setNick(modifyData);
//                break;
//        }
//        int result = service.modifyInfo(vo, menu);
//        view.resultModifyInfo(result);
//        return HomeMenu.CUSTOMER;
//    }
//    public HomeMenu modifyPassword(Scanner scanner) {
//        String password = view.changePassword(scanner);
//        MemberVO vo = new MemberVO();
//        vo.setId(BookstoreApplication.getSession().getId());
//        vo.setPw(password);
//        int result = service.modifyPassword(vo);
//        view.resultChangePassword(result);
//        return HomeMenu.CUSTOMER;
//    }
}
