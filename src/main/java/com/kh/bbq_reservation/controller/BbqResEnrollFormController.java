package com.kh.bbq_reservation.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.bbq_reservation.model.service.BbqService;
import com.kh.bbq_reservation.model.vo.BbqReservation;
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class bbqResEnrollFormController
 */
@WebServlet("/resEnrollForm.bq")
public class BbqResEnrollFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public BbqResEnrollFormController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		
		Member loginUser = (Member)request.getSession().getAttribute("loginUser");
		if(loginUser==null) {
			request.getSession().setAttribute("alertMsg", "로그인 후 이용해 주세요.");
			response.sendRedirect(request.getContextPath());
			
		}else {
			int memberNo = loginUser.getMemberNo();
			BbqReservation bbq = new BbqService().bbqSelectOne(memberNo);
			
			int resStatus = 0;
			
			String todayfm = new SimpleDateFormat("yyyy-MM-dd").format(new Date(System.currentTimeMillis()));
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			
			Date today = null;
			Date resDay = null;
			
			try {
				 today = new Date(dateFormat.parse(todayfm).getTime());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			if(bbq!=null) {
			
				try {
					resDay = new Date(dateFormat.parse(bbq.getResDate()).getTime());
				} catch (ParseException e) {
					e.printStackTrace();
				}						
				int compare = today.compareTo(resDay); 
				if(compare<=0) { // 예약날짜가 지나지 않았을때만 bbq 전달
					request.setAttribute("bbq", bbq);
					System.out.println(bbq);
				}
			}
				
			
			request.getRequestDispatcher("views/bbq_reservation/bbqReservation.jsp").forward(request, response);
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
