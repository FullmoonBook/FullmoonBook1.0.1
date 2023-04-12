package fullmoonbook.review;

import java.util.List;

public class ReviewService {
	private static ReviewService instance = new ReviewService();

	private ReviewService() {
	}

	public static ReviewService getInstance() {
		return instance;
	}

	private ReviewDAO dao = ReviewDAO.getInstance();

	public List<ReviewVO> getReviews () throws Exception {
		return dao.getReviews();
	}
	public int insertReview(ReviewVO vo) throws Exception {
		return dao.insertReview(vo);
	}
}
