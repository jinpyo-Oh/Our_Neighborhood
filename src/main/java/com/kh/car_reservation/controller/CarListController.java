package com.kh.car_reservation.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.car_reservation.model.service.CarService;
import com.kh.car_reservation.model.vo.Car;
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class selectCarReservation
 */
@WebServlet("/list.ca")
public class CarListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CarListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Member m = (Member)request.getSession().getAttribute("loginUser");
		
		if(m==null) {
			request.getSession().setAttribute("alertMsg", "로그인 후 이용해 주세요.");
			response.sendRedirect(request.getContextPath());
			
		}else {
		
		
		ArrayList<Car> list = new CarService().selectCar(m);
			request.setAttribute("list", list);
			request.setAttribute("m", m);
		
		
			request.getRequestDispatcher("views/car_reservation/carReservation.jsp").forward(request, response);
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
