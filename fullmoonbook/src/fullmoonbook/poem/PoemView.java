package fullmoonbook.poem;

import java.util.List;
import java.util.Random;

public class PoemView {
	private static PoemView instance = new PoemView();
	private PoemView() {
	}
	public static PoemView getInstance() {
		return instance;
	}
	public void getPoems() throws Exception {
		PoemDAO dao = new PoemDAO();
		List<PoemVO> poems = dao.getPoems();
		Random random = new Random();
		int randomIndex = random.nextInt(poems.size());
		System.out.println("");
		System.out.println(poems.get(randomIndex));
	}


}
