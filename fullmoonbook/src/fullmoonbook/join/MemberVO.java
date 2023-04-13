package fullmoonbook.join;

public class MemberVO {
	private String id;
	private String pw;


	public MemberVO() {
	}
	
	public MemberVO(String id, String pw) {
		this.id = id;
		this.pw = pw;
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


	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", pw=" + pw;
	}


	/**
     * 세션에 담긴 데이터를 초기화해주는 메소드
     * 호출시 로그인된 세션 정보 삭제
     */
	public void invalidate() {
		this.id = null;
		this.pw = null;
	}
}
