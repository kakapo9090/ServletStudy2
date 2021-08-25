package com.iu.s1.member;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberController {
	
	private MemberService memberService;
	
	public MemberController() {
		memberService = new MemberService();
	}
	
	
	
	
	public void start(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("MemberController 실행");
		String uri = request.getRequestURI();
		int index= uri.lastIndexOf("/");
		
		
		String path= uri.substring(index+1);
		
		
		
		
		if(path.equals("memberLogin.do")) {
			System.out.println("로그인 진행");
			//파라미터 사용 21-08-24
			String value = request.getParameter("id");
			System.out.println(value);
			String pw = request.getParameter("pw");
			System.out.println(pw);
			
			// 인서트문
		}else if(path.equals("memberJoin.do")) {
			System.out.println("회원가입 진행");	
			String method =request.getMethod();
			System.out.println("Method : "+method);
			
			if(method.equals("POST")) {
				int result = memberService.memberJoin(request, response);	
				if(result>0) {
					response.sendRedirect("../");
				}else {
					response.sendRedirect("./memberJoin.do");
				}
				
			}else {
				RequestDispatcher view = request.getRequestDispatcher("../WEB-INF/views/member/memberJoin.jsp");
					view.forward(request, response);
			}
		
			
			
			
			
			
		}else if(path.equals("memberPage.do")) {
			System.out.println("마이페이지 진행");
		}else {
			System.out.println("그 외 나머지");
		}
	}
}
