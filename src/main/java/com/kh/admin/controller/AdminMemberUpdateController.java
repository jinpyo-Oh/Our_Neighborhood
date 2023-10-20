package com.kh.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.admin.model.service.AdminService;
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class AdminMemberUpdateController
 */
@WebServlet("/update.ad")
public class AdminMemberUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminMemberUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 1) POST 방식이므로 인코딩 설정 먼저
		request.setCharacterEncoding("UTF-8");
		
		// 2) 요청 시 전달값들을 뽑아 변수 및 객체에 담기
		// 회원번호, 아이디, 비밀번호, 비밀번호2, 이름, 주소, 주소2, 이메일, 전화번호
		// memberNo, memberId, memberPwd, memberPwd2, memberName, 
		// memberAddress, memberAddress2, memberEmail, memberPhone
		int memberNo = Integer.parseInt(request.getParameter("memberNo"));
		
		// System.out.println(request.getParameter("memberNo"));
		// System.out.println(request.getParameter("memberId"));
		
		String memberId = request.getParameter("memberId");
		String memberPwd = request.getParameter("memberPwd");
		String memberPwd2 = request.getParameter("memberPwd2");
		String memberName = request.getParameter("memberName");
		String memberAddress = request.getParameter("memberAddress");
		int memberAddress2 = Integer.parseInt(request.getParameter("memberAddress2"));
		String memberEmail = request.getParameter("memberEmail");
		String memberPhone = request.getParameter("memberPhone");
		
		if(memberPwd.equals(memberPwd2)) {
			
			Member m = new Member(memberNo, memberId, memberPwd, memberName, memberAddress, memberAddress2, memberEmail, memberPhone);
			
			// System.out.println(m);
			
			// 3) Service 단으로 요청 후 결과 받기
			// 처리된 행의 개수만 받아 성공, 실패 여부 판단이 아닌 갱신된 회원의 정보를 받을것임!!!
			Member updateMem = new AdminService().updateMember(m);
			
			if(updateMem == null) {
				
				request.getSession().setAttribute("alertMsg", "동-호수를 확인해주세요.");

				response.sendRedirect(request.getContextPath() + "/detail.ad?mno=" + memberNo);;
		
			} else {
				
				HttpSession session = request.getSession();
				
				session.setAttribute("alertMsg", "회원정보 변경에 성공했습니다.");
			
				session.setAttribute("m", updateMem);
				
				response.sendRedirect(request.getContextPath() + "/detail.ad?mno=" + memberNo);
			}
			
		} else {
			
			request.getSession().setAttribute("alertMsg", "비밀번호를 확인해주세요.");

			response.sendRedirect(request.getContextPath() + "/detail.ad?mno=" + memberNo);
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
