package fullmoonbook.challenge;

public class ChallengeVO {
	
	//필드
	private String id;
	private String bookNo;
	private String status;
	private int goal;
	private String bookName;
	private String author;
	private int page;
	private int nowPage;
	private int challenger;
	
	//생성자
	public ChallengeVO() {
	}
	public ChallengeVO(String bookName, String author) {
		this.bookName = bookName;
		this.author = author;
	}
	public ChallengeVO(String id, String status, int goal) {
		this.id = id;
		this.status = status; 
		this.goal = goal;
	}
	
	public ChallengeVO(String bookName, String author, int page, int challenger) {
		this.bookName = bookName;
		this.author = author;
		this.page = page; 
		this.challenger = challenger;
	}
	
	//getter setter
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBookNo() {
		return bookNo;
	}
	public void setBookNo(String bookNo) {
		this.bookNo = bookNo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getGoal() {
		return nowPage / page;
	}
	public void setGoal(int goal) {
		this.goal = goal;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getNowPage() {
		return nowPage;
	}
	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}
	public int getChallenger() {
		return challenger;
	}
	public void setChallenger(int challenger) {
		this.challenger = challenger;
	}
	
	//프린트 출력 형식
	public String printNA() {
		return String.format("%s - %s", bookName, author);
	}
	public String printN() {
		return String.format("< %s >", bookName);
	}
	public String printP() {
		return String.format("/%d쪽", page);
	}
	public String printStatus() {
		return String.format("달성률 %d%%", page); //받은 현재페이지에서 나눠야 함.
	}
	public String PringChallenger() {
		return String.format("%d", challenger);
	}

	
	
	
}
