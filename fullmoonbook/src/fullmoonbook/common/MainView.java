package fullmoonbook.common;

import java.util.Scanner;

public class MainView {
    private static MainView instance = new MainView();
    private MainView() {
    }
    public static MainView getInstance() {
        return instance;
    }
    public int init(Scanner scanner) {
        System.out.println("\\t  ₍ᐢ｡ ˬ ｡ᐢ₎\\n\\t보름 한 책");
        System.out.print(HomeMenu.HOME.getMenuString());
        return Integer.parseInt(scanner.nextLine());
    }

    public static String inputData(Scanner scanner) {
        return scanner.nextLine();
    }

}
