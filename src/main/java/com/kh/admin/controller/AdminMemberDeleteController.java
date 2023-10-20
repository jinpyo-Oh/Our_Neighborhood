package com.kh.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.admin.model.service.AdminService;



/**
 * Servlet implementation class AdminMemberDeleteController
 */
@WebServlet("/delete.ad")
public class AdminMemberDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminMemberDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 1) POST 방식이므로 인코딩 설정 먼저
		request.setCharacterEncoding("UTF-8");
		
		int originMemberNo = Integer.parseInt(request.getParameter("deleteMem"));
		
		
		int memberNo = Integer.parseInt(request.getParameter("memberNo"));
		
		int result = 0;
		
		HttpSession session = request.getSession();
		
		// System.out.println(request.getParameter("memberNo"));
		
		if(memberNo == originMemberNo) {
			
			result = new AdminService().deleteMember(memberNo);
		}
		
		if(result > 0) {
			
			session.setAttribute("alertMsg", "회원 강제 탈퇴에 성공했습니다.");
			
			response.sendRedirect(request.getContextPath() + "/adminMemberList.ad");
			
		} else {
			
			session.setAttribute("alertMsg", "회원 강제탈퇴에 실패했습니다. 회원번호를 확인해주세요.");
			
			response.sendRedirect(request.getContextPath() + "/detail.ad?mno=" + originMemberNo);
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
