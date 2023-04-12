
package fullmoonbook.poem;

import java.util.List;

public class PoemController {
	private static PoemController instance = new PoemController();

	private PoemController() {
	}

	public static PoemController getInstance() {
		return instance;
	}

	private PoemService service = PoemService.getInstance();

	public List<PoemVO> getPoems() throws Exception  {
		return service.getPoems();
	}
}

