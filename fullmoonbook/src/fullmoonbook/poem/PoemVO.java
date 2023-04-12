package fullmoonbook.poem;

public class PoemVO {
	private int poemno;
	private String title;
	private String poet;
	private String verse;

	public PoemVO() {
	}

	public PoemVO(int poemno, String title, String poet, String verse) {
		this.poemno = poemno;
		this.title = title;
		this.poet = poet;
		this.verse = verse;
	}

	public int getPoemno() {
		return poemno;
	}

	public void setPoemno(int poemno) {
		this.poemno = poemno;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPoet() {
		return poet;
	}

	public void setPoet(String poet) {
		this.poet = poet;
	}

	public String getVerse() {
		return verse;
	}

	public void setVerse(String verse) {
		this.verse = verse;
	}
	
	public String toString() {
		return String.format("%s\n%s ─ %s", verse, poet, title );
	}
}
