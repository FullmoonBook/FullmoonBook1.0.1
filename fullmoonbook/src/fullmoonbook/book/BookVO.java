package fullmoonbook.book;

public class BookVO {
	private String bookNo;
	private String bookName;
	private String subtitle;
	private String author;
	private int page;
	private String genre;
	private String publisher;
	private String period;
	private int challenger;

	public BookVO() {
	}

	// 이번 보름 챌린지용
	public BookVO(String bookNo, String bookName, String subtitle, String author, int page, String genre,
			String publisher, String period, int challenger) {
		this.bookNo = bookNo;
		this.bookName = bookName;
		this.subtitle = subtitle;
		this.author = author;
		this.page = page;
		this.genre = genre;
		this.publisher = publisher;
		this.period = period;
		this.challenger = challenger;
	}

	// 다음 보름 챌린지용
	public BookVO(String bookNo, String bookName, String subtitle, String author, int page, String genre,
			String publisher, String period) {
		this.bookNo = bookNo;
		this.bookName = bookName;
		this.subtitle = subtitle;
		this.author = author;
		this.page = page;
		this.genre = genre;
		this.publisher = publisher;
		this.period = period;
	}

	// 챌린지 기록용
	public BookVO(String bookName, String period) {
		this.bookName = bookName;
		this.period = period;
	}

	public String getBookNo() {
		return bookNo;
	}

	public void setBookNo(String bookNo) {
		this.bookNo = bookNo;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
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

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public int getChallenger() {
		return challenger;
	}

	public void setChallenger(int challenger) {
		this.challenger = challenger;
	}

	public String printA() {
		return String.format("%s\n%s", bookName, author);

	}

	public String printBook(boolean flag) {
		if (flag) {
			return String.format("\t    %s\n\n %s\n   %s, %s쪽, %s, %s \n    기간: %s", bookName, subtitle, author, page,
					genre, publisher, period);
		} else {
			return String.format("\t   %s\n\n %s\n%s, %s쪽, %s, %s \n    기간: %s", bookName, subtitle, author, page,
					genre, publisher, period);
		}
	}

	@Override
	public String toString() {
		return String.format("%s - %s", bookName, period);
	}

}
