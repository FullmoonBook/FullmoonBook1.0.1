package fullmoonbook.review;

import java.util.List;


public class ReviewController {
	private static ReviewController instance = new ReviewController();

	private ReviewController() {
	}

	public static ReviewController getInstance() {
		return instance;
	}

	private ReviewService service = ReviewService.getInstance();

	public List<ReviewVO> getReviews() throws Exception  {
		return service.getReviews();
	}
	public int insertReview(ReviewVO vo) throws Exception {
		return service.insertReview(vo);
	}
}
