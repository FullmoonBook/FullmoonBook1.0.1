package fullmoonbook.poem;

import java.util.List;

import fullmoonbook.poem.PoemDAO;
import fullmoonbook.poem.PoemService;
import fullmoonbook.poem.PoemVO;

public class PoemService {
	private static PoemService instance = new PoemService();

	private PoemService() {
	}

	public static PoemService getInstance() {
		return instance;
	}

	private PoemDAO dao = PoemDAO.getInstance();

	public List<PoemVO> getPoems() throws Exception {
		return dao.getPoems();
	
	}
}