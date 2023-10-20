package com.kh.admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.admin.model.service.AdminService;
import com.kh.bbq_reservation.model.vo.BbqReservation;

/**
 * Servlet implementation class AdminBbqResTodaySelectController
 */
@WebServlet("/resSelect.ad")
public class AdminBbqResSelectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminBbqResSelectController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		if(request.getParameter("today")!=null) {
			String today = request.getParameter("today");
			ArrayList<BbqReservation> list = new AdminService().adminBbqResSelect(today);		
			request.setAttribute("list",list);
			request.getRequestDispatcher("views/admin/adminBbqReservation.jsp").forward(request, response);

		}else {
			ArrayList<BbqReservation> list = new AdminService().adminBbqResSelectAll();			
			request.setAttribute("list", list);
			request.getRequestDispatcher("views/admin/adminBbqReservation.jsp").forward(request, response);
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
