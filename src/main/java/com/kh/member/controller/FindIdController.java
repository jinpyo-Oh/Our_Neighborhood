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

@WebServlet("/findid.me")
public class FindIdController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public FindIdController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	
    	String memberName = request.getParameter("name");
        String phone = request.getParameter("phone");
        
        Member m = new Member(memberName, phone);
        
        MemberService memberService = new MemberService();
        String foundId = memberService.findId(m);
        
        
        if (foundId !=null) {
            
        	
        	// 아이디를 찾았을 경우 결과를 출력
            
        	request.setAttribute("foundId", foundId);
        	request.getRequestDispatcher("views/member/memberFindIdResultForm.jsp").forward(request, response);
        	
        	
        } else {
            // 아이디를 찾지 못했을 경우 에러 메시지 출력
        	// 에러페이지로 보내보기
        	request.setAttribute("errorMsg", "아이디 찾기에 실패했습니다.");
			
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
