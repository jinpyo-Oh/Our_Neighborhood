package com.kh.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class FindPwdController
 */
@WebServlet("/findpwd.me")
public class FindPwdController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindPwdController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
    	
    	String memberId = request.getParameter("memberId");
        
        Member m = new Member(memberId);
        
        MemberService memberService = new MemberService();
        String foundPwd = memberService.findPwd(m);
        
        
        if (foundPwd !=null) {
            
        	
        	// 비밀번호를 찾았을 경우 결과 출력
            
        	request.setAttribute("foundPwd", foundPwd);
        	request.getRequestDispatcher("views/member/memberFindPwdResultForm.jsp").forward(request, response);
        	
        	
        } else {
            // 비밀번호를 찾지 못했을 경우 에러 메시지 출력
        	// 에러페이지로 보내보기
        	request.setAttribute("errorMsg", "비밀번호 찾기에 실패했습니다.");
			
			RequestDispatcher view = request.getRequestDispatcher("views/common/errorPage.jsp");
			
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
