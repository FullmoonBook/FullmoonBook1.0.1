package fullmoonbook.review;

import java.util.List;
import java.util.Scanner;

import fullmoonbook.join.MemberVO;
import fullmoonbook.poem.PoemView;

public class ReviewView {
	private static ReviewView instance = new ReviewView();
	private ReviewView() {
	}
	public static ReviewView getInstance() {
		return instance;
	}
	
	public int getReviewView(Scanner scanner) throws Exception {
		Scanner scanner1 = new Scanner(System.in);
		System.out.println("전체후기");
		ReviewDAO dao = new ReviewDAO();
		List<ReviewVO> reviews = dao.getReviews();
		for (ReviewVO vo1 : reviews) {
			int count = 0;
			if (count < 10)
				System.out.println(vo1);
			count++;
		}
		System.out.println("1.후기작성 2. 이전페이지");
		return Integer.parseInt(scanner1.nextLine());
	}

	public ReviewVO inputReview(Scanner scanner) {
		System.out.print("평점");
		String content = scanner.nextLine();
		System.out.print("후기내용 ");
		int grade = Integer.parseInt(scanner.nextLine());
		return new ReviewVO(content, grade);
	}
}
