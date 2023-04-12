package fullmoonbook.review;


public class ReviewVO {
	
//INSERT INTO RIVIEW (ID, BOOK_NO, CONTENT, GRADE) 
	private String id;
	private String nick;
	private String bookNo;
	private String content;
	private int grade;
	public ReviewVO() {
		// TODO Auto-generated constructor stub
	}
	public ReviewVO(String id, String bookNo, String content, int grade) {
		this.id = id;
		this.bookNo = bookNo;
		this.content = content;
		this.grade = grade;
		
	}
	public String getId() {
		return id;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	@Override
	public String toString() {
		return String.format("완독자 리뷰\n\t %s %s 평점:%d/5", id, content, grade);
	}
	
		

}

