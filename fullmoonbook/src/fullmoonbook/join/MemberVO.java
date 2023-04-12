package fullmoonbook.join;

public class MemberVO {
	private String id;
	private String pw;
	private String nick;

	public MemberVO() {
	}
	
	public MemberVO(String id, String pw) {
		this.id = id;
		this.pw = pw;
    }
	
	public MemberVO(String id, String pw, String nick) {
		this.id = id;
		this.pw = pw;
		this.nick = nick;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getNick() {
		return nick;
	}

	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", pw=" + pw + ", nick=" + nick + "]";
	}

	public void setNick(String nick) {
		this.nick = nick;
	}
	
	/**
     * 세션에 담긴 데이터를 초기화해주는 메소드
     * 호출시 로그인된 세션 정보 삭제
     */
	public void invalidate() {
		this.id = null;
		this.nick = null;
		this.pw = null;
	}
}
