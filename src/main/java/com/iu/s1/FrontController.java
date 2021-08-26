package com.iu.s1;

import java.io.IOException;
import java.util.StringTokenizer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.iu.s1.bankbook.BankbookController;
import com.iu.s1.member.MemberController;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("/FrontController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	private MemberController memberController;
	private BankbookController bankbookController;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
    	super(); // HttpServlet 생성자 호출
    	memberController = new MemberController();
    	bankbookController = new BankbookController();
        
        
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletConfig sc = getServletConfig();
		HttpSession session = request.getSession();
		ServletContext context = session.getServletContext();
		context = getServletContext();
		
		
		System.out.println("================================================");
		System.out.println("Front Controller 실행");
		String uri = request.getRequestURI();
		//String url = request.getRequestURL().toString();
		System.out.println("스트링버퍼 URL : "+request.getRequestURL());
		System.out.println("uri : " +uri);
		//System.out.println("url : " +url);
		
		String path="";
		//subString
		System.out.println("getContextPath : " + request.getContextPath());
		System.out.println("getContextPath().length() : " + request.getContextPath().length());
		int startIndex = request.getContextPath().toString().length();
		int lastIndex = uri.lastIndexOf("/");
		path = uri.substring(startIndex, lastIndex);
		System.out.println("uri주소에서 컨텍스트 주소 뺀 폴더명 : "+path);
		
		//폴더명이 /member인 경우
		if(path.equals("/member")) {
			try {
				memberController.start(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		//폴더명이 /bankbook인 경우	
		}else if(path.equals("/bankbook")) {
			bankbookController.start(request, response);
			
		}else {
			System.out.println("없는 URL");
		}
		
		
		
		System.out.println("path : "+path); //bankbook, member
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
