package fullmoonbook.book;

import java.util.List;

import fullmoonbook.book.BookDAO;
import fullmoonbook.book.BookVO;
import fullmoonbook.common.BookApplication;

public class BookService {
	private static BookService instance = new BookService();

	private BookService() {
	}

	public static BookService getInstance() {
		return instance;
	}

	private BookDAO dao = BookDAO.getInstance();

	public BookVO getNowChallenge(String nowChallengeBookNo) throws Exception {
		return dao.getNowChallenge(nowChallengeBookNo);
	}

	public BookVO getNextChallenge(String nextChallengeBookNo) throws Exception {
		return dao.getNextChallenge(nextChallengeBookNo);
	}
	public List<BookVO> getHistory(String id) throws Exception {
		return dao.getHistory(id);
	}

}
