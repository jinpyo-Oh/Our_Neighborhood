package com.kh.bbq_reservation.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.bbq_reservation.model.service.BbqService;
import com.kh.bbq_reservation.model.vo.BbqReservation;
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class bbqReservationController
 */
@WebServlet("/reservation.bq")
public class BbqReservationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BbqReservationController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		HttpSession session =request.getSession();
		Member loginUser = (Member)session.getAttribute("loginUser");
		
		int resPlace = Integer.parseInt(request.getParameter("resPlace"));
		
		String resDate = request.getParameter("resDate");
		
		String resName = request.getParameter("resName");
		
		int resPeople = Integer.parseInt(request.getParameter("resPeople"));
		
		String resMsg = request.getParameter("resMsg");
		
		int resMemberNo = loginUser.getMemberNo();		
		
 		
		BbqReservation bbq = new BbqReservation(resPlace, resDate, resName, resPeople, resMsg, resMemberNo);
		
		int result = new BbqService().bbqResInsert(bbq);
		
		if(result > 0) {
			
			request.getSession().setAttribute("alertMsg", "예약에 성공했습니다.");
			response.sendRedirect(request.getContextPath()+"/resEnrollForm.bq");
		}else {
			System.out.println("fail");
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
