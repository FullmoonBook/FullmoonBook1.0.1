package fullmoonbook.book;

import java.util.List;

import fullmoonbook.common.BookApplication;

public class BookController {
	private static BookController instance = new BookController();

	private BookController() {
	}

	public static BookController getInstance() {
		return instance;
	}

	private BookService service = BookService.getInstance();

	public BookVO getNowChallenge(String nowChallengeBookNo) throws Exception {
		return service.getNowChallenge(nowChallengeBookNo);
	}
	public BookVO getNextChallenge(String nextChallengeBookNo) throws Exception {
		return service.getNextChallenge(nextChallengeBookNo);
	}
	public BookVO getChallenge(String nowChallengeBookNo) throws Exception {
		return service.getNowChallenge(nowChallengeBookNo);
	}
	public List<BookVO> getHistory(String id) throws Exception {
		return service.getHistory(id);
	}

}
