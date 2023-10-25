package com.kh.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login.me")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String memberId = request.getParameter("memberId");
		String memberPwd = request.getParameter("memberPwd");
		
	
		
		// 아이디 저장 기능
		String saveId = request.getParameter("saveId");
		
		if(saveId != null && saveId.equals("y")) {
			
			Cookie cookie = new Cookie("saveId", memberId);
			
			cookie.setMaxAge(24 * 60 * 60 * 1); // 하루동안 보지 않기
			
			response.addCookie(cookie);
		
		} else {
			
			Cookie cookie = new Cookie("saveId", memberId);
			
			cookie.setMaxAge(0);
			
			response.addCookie(cookie);
			}
		
		// Member 타입 VO 객체로 가공
		Member m = new Member();		
		m.setMemberId(memberId);
		m.setMemberPwd(memberPwd);
		
		Member loginUser = new MemberService().loginMember(m);

		
		
		// 사용자가 보게 될 응답뷰
		if(loginUser == null) {//로그인 실패
			
			request.setAttribute("errorMsg", "로그인에 실패했습니다.");
			
			RequestDispatcher view = request.getRequestDispatcher("views/common/errorPage.jsp");
			
			view.forward(request, response);
		
		} else { // 로그인 성공
			
			HttpSession session = request.getSession();
			
			session.setAttribute("loginUser", loginUser);
					
			response.sendRedirect(request.getContextPath());		
			
		}
		
		}
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
