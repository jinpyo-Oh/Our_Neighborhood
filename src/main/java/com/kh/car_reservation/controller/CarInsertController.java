package com.kh.car_reservation.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.car_reservation.model.service.CarService;
import com.kh.car_reservation.model.vo.Car;
import com.kh.member.model.vo.Member;



/**
 * Servlet implementation class InsertCarController
 */
@WebServlet("/insert.ca")
public class CarInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CarInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String carResNo = request.getParameter("carResNo");
		String carType = request.getParameter("carType");
		String carOwner = request.getParameter("carOwner");
		int memberNo = Integer.parseInt(request.getParameter("memberNo"));
		
		Member m = (Member)request.getSession().getAttribute("loginUser");
		
		// 등록된 차량 조회를 위한 실행문
		ArrayList<Car> list = new CarService().selectCar(m);
		
		Car c = new Car(carResNo, carType, carOwner, memberNo);
		
		if(list.size() < 2) {
			int result = new CarService().insertCar(c);
			if(result > 0 ) {
				

				session.setAttribute("alertMsg", "차량 등록에 성공하였습니다.");
				
				response.sendRedirect(request.getContextPath()+"/list.ca");
			} else {
				request.setAttribute("errorMsg", "차량등록에 실패했습니다.");
				
				request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
			}
		} else {
			
			session.setAttribute("alertMsg", "차량은 2개이상 등록하실 수 없습니다.");
			
			response.sendRedirect(request.getContextPath()+"/list.ca");
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