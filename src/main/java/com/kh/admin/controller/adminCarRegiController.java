package com.kh.admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.admin.model.service.AdminService;
import com.kh.car_reservation.model.vo.Car;

/**
 * Servlet implementation class adminCarRegiController
 */
@WebServlet("/adminCarRegi.ad")
public class adminCarRegiController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminCarRegiController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		
		int memberNo = Integer.parseInt(request.getParameter("memberNo"));
		String carResNo = request.getParameter("carResNo");
		String carType = request.getParameter("carType");
		String carOwner = request.getParameter("carOwner");
		
		Car c = new Car(carResNo, carType, carOwner, memberNo);
		
		ArrayList<Car> list = new AdminService().selectCar(memberNo);
		
		
		if(list.size() < 2) {

			int result = new AdminService().insertCar(c);
		
			if(result > 0) {
				
				session.setAttribute("alertMsg", "차량 등록에 성공하였습니다.");
				response.sendRedirect(request.getContextPath()+"/adminCarList.ad");
				
			} else {
				
				request.setAttribute("alertMsg", "차량등록에 실패했습니다.");
				
				response.sendRedirect(request.getContextPath()+"/adminCarList.ad");
			}
			
		} else {
			
			session.setAttribute("alertMsg", "차량은 세대당 최대 2대까지만 등록 가능합니다.");
			
			response.sendRedirect(request.getContextPath()+"/adminCarList.ad");
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
