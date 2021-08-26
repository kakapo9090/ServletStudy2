package com.iu.s1.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberService {

	private MemberDAO memberDAO;
	
	public MemberService() {
		memberDAO = new MemberDAO();
	}
	
	//컨트롤러와 DAO 사이에서 중개해주는 메서드 => 양식에서 받은 값들을 DTO에 담는 역할
	public int memberJoin(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId(request.getParameter("id"));
		memberDTO.setPw(request.getParameter("pw"));
		memberDTO.setName(request.getParameter("name"));
		memberDTO.setPhone(request.getParameter("phone"));
		memberDTO.setEmail(request.getParameter("email"));
		//int result = memberDAO.memberJoin(memberDTO);
		//return result;
		return memberDAO.memberJoin(memberDTO);
	}
	
}
