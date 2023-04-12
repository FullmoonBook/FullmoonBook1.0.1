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
	
	//생성자
	public ChallengeVO() {
	}
	public ChallengeVO(String bookName, String author) {
		this.bookName = bookName;
		this.author = author;
	}
	public ChallengeVO(String status) {
		this.status = status; 
	}
	public ChallengeVO(int page) {
		this.page = page; 
	}
	//getter setter
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBook_no() {
		return bookNo;
	}

	public void setBook_no(String book_no) {
		this.bookNo = bookNo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getGoal() {
		return goal;
	}

	public void setGoal(int goal) {
		this.goal = goal;
	}
	
	public String printNA() {
		return String.format("%s - %s", bookName, author);
	}
	public String printN() {
		return String.format("< %s >", bookName);
	}
	public String printP() {
		return String.format("/%d쪽", page);
	}
	public static ChallengeVO getInstance() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
}
