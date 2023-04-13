package fullmoonbook;

public class FullmoonBookApplication {
	
//	private static MemberVO session = new MemberVO();
	
	public static void main(String[] args) {
		FrontController main = FrontController.getInstance(); //FrontController 호출
			
		main.process(); //FrontController 실행
		
//		/**
//	     * 로그인한 정보를 가져오는 메소드
//	     * @return session 정보 반환
//	     */
//		public static MemberVO getSession() {
//			return session;
//		}
		
	}

}
