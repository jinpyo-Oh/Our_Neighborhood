package com.kh.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.admin.model.service.AdminService;
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class AdminMemberDetailController
 */
@WebServlet("/detail.ad")
public class AdminMemberDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminMemberDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 회원번호 먼저 뽑기
		int memberNo = Integer.parseInt(request.getParameter("mno"));
		
		Member m = new AdminService().selectMember(memberNo);
		
		// System.out.println(m);
		
		request.setAttribute("m", m);
		
		request.getRequestDispatcher("views/admin/adminMemberDetailView.jsp").forward(request, response);

		// System.out.println(m);
		// 포워딩 테스트
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
