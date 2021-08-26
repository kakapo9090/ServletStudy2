package com.iu.s1.bankbook;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BankbookController {

	private BankbookDAO bankbookDAO;
	public BankbookController() {
		bankbookDAO = new BankbookDAO();
	}
	
	
	public void start(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Bankbook Controller 실행");
		String uri = request.getRequestURI();
		int index = uri.lastIndexOf("/");
		
		
		String path = uri.substring(index+1);
		
		if(path.equals("bankbookList.do")) {
			System.out.println("상품목록");
			ArrayList<BankbookDTO> ar = bankbookDAO.getList();
			//for(초기식;조건식;증감식)
			//for(모은 타입명 변수명:컬렉션참조변수명)
			
			for(BankbookDTO bankbookDTO:ar) {
				System.out.println(bankbookDTO.getBookName());
			}
			
			request.setAttribute("list", ar);
			
			RequestDispatcher view = request.getRequestDispatcher("../WEB-INF/views/bankbook/bankbookList.jsp");
			try {
				view.forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
/** ============================================================  */			
			
			
			//url이 같은 주소를 메서드로 구분
		}else if(path.equals("bankbookInsert.do")) {
			System.out.println("상품등록 진행");
			
			String method =request.getMethod();
			System.out.println("Method : "+method);
			if(method.equals("POST")) {
				//POST방식
				//파라미터값 출력
				System.out.println("Insert 2");
				String bookName= request.getParameter("bookName");
				String bookRate = request.getParameter("bookRate");
				String bookSale = request.getParameter("bookSale");		
				BankbookDTO bankbookDTO = new BankbookDTO();
				bankbookDTO.setBookName(bookName);
				bankbookDTO.setBookRate(Double.parseDouble(bookRate));
				bankbookDTO.setBookSale(Integer.parseInt(bookSale));
			
				int result = bankbookDAO.setInsert(bankbookDTO);
				System.out.println(result);
				//리스트 만들어주기
//				ArrayList<BankbookDTO> ar = bankbookDAO.getList();
//				request.setAttribute("list", ar);
			
				//리다이렉트 방식
				try {
					response.sendRedirect("./bankbookList.do");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
			}else {
				//GET방식
				RequestDispatcher view = request.getRequestDispatcher("../WEB-INF/views/bankbook/bankbookInsert.jsp");
				try {
					view.forward(request, response);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
			
		
			
	
			
/** ============================================================= */
			
			
		}else if(path.equals("bankbookSelect.do")) {
			System.out.println("상품상세조회");
			String num = request.getParameter("bookNumber");
			System.out.println(num);
			//예외처리 필요
			long num2 = Long.parseLong(num);
			BankbookDTO bankbookDTO = new BankbookDTO();
			
			bankbookDTO.setBookNumber(num2);
			bankbookDTO = bankbookDAO.getSelect(bankbookDTO);
			System.out.println(bankbookDTO.getBookName());
			
			request.setAttribute("dto", bankbookDTO);
			request.setAttribute("count", 123);
			request.setAttribute("name", "iu");
			
			HttpSession session = request.getSession();
			session.setAttribute("se", "session");
			request.setAttribute("se", "request");
			
			
			RequestDispatcher view = request.getRequestDispatcher("../WEB-INF/views/bankbook/bankbookSelect.jsp");
			try {
				view.forward(request, response);
			}  catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			System.out.println("그 외 나머지");
		}
		
		
	}
}
