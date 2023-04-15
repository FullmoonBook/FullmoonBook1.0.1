package fullmoonbook.sign;

import java.util.Scanner;

import fullmoonbook.common.HomeMenu;
import fullmoonbook.join.MemberVO;

public class SignView {
    private static SignView instance = new SignView();

    private SignView() {
    }
    public static SignView getInstance() {
        return instance;
    }

    public MemberVO inputLoginInfo(Scanner scanner) {
    	System.out.println("\n────────────────────────────────────────────────────");
    	System.out.println();
		System.out.println("\t     /) /)");
		System.out.println("\t    ( ｡･-･)🥕");
		System.out.println("\t 🌕보름 한 책🌕");
    	System.out.println();
    	System.out.println();
    	System.out.println("   아이디와 비밀번호를 입력하세요.");
    	System.out.println();
    	System.out.println("\n────────────────────────────────────────────────────");
        System.out.print("아이디: ");
        String userId = scanner.nextLine();
        System.out.print("패스워드: ");
        String userPw = scanner.nextLine();
        return new MemberVO(userId, userPw);
    }
    
    public MemberVO resultLogin(MemberVO vo) {
        if (vo == null) {
            System.out.println("로그인 정보가 일치하지 않습니다. 아이디와 비밀번호를 확인하세요.");
            return null;
        }
        System.out.print("\n\t" + vo.getId() + "님 로그인되었습니다.");
        return vo;
    }
}

