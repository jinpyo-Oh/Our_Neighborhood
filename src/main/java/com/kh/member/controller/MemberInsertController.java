package com.kh.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class MemberInsertController
 */
@WebServlet("/insert.me")
public class MemberInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberInsertController() {
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
		
		String memberName = request.getParameter("memberName");
		
		String address = request.getParameter("address");
		
		int address2 = Integer.parseInt(request.getParameter("address2"));

		String email = request.getParameter("email");
		
		String phone = request.getParameter("phone");
		
	
		Member m = new Member(memberId, memberPwd, memberName, address, address2,
								email, phone);		
		
		int result = new MemberService().insertMember(m);
		
		if(result > 0) { // 회원가입 성공 

			HttpSession session = request.getSession();
			session.setAttribute("alertMsg", "회원가입에 성공했습니다.");
			
			// url 재요청방식
			response.sendRedirect(request.getContextPath());
			
		} else { // 회원가입 실패 
			request.setAttribute("errorMsg", "회원가입에 실패했습니다.");
			
			RequestDispatcher view 
				= request.getRequestDispatcher("views/common/errorPage.jsp");
			
			view.forward(request, response);
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
