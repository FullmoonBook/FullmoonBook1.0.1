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

	public void getReviews(List<ReviewVO> reviews) throws Exception {
		System.out.println("\n─────────────────────────────────────────────────────────────────────────────");
		System.out.println();
		System.out.println("\t\t\t\t📌완독자 후기📌");
		System.out.println();
		System.out.println();
		System.out.println("    작성자     평점  내용");

		int size = reviews.size(); // ArrayList의 크기를 구한다.

		if (size < 5) { // ArrayList의 크기가 5보다 작은 경우
			for (int i = 0; i < size; i++) {
				Object element = reviews.get(i); // ArrayList의 인덱스에 해당하는 객체를 가져온다.
				System.out.println(element); // 해당 객체를 출력한다.
			}
		} else { // ArrayList의 크기가 5 이상인 경우
			for (int i = size - 5; i < size; i++) {
				Object element = reviews.get(i); // ArrayList의 인덱스에 해당하는 객체를 가져온다.
				System.out.println(element); // 해당 객체를 출력한다.
			}
		}
	}

	public ReviewVO inputReview(Scanner scanner) {
		System.out.print("리뷰 내용: ");
		String content = scanner.nextLine();
		System.out.print("평점(5점): ");
		int grade = Integer.parseInt(scanner.nextLine());
		return new ReviewVO(content, grade);
	}

	public void inputResult(int count) {
		if (count > 0) {
			System.out.println("리뷰가 정상적으로 등록되었습니다.");
		} else {
			System.out.println("리뷰가 정상적으로 입력되지 않았습니다.");
		}
	}
}
