package com.kh.admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.admin.model.service.AdminService;
import com.kh.admin.model.vo.Board;
import com.kh.admin.model.vo.Chart;


/**
 * Servlet implementation class AdminMainChartController
 */
@WebServlet("/main.ad")
public class AdminMainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminMainController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int c1 = new AdminService().selectBoardChart(5);
		int c2 = new AdminService().selectBoardChart(4);
		int c3 = new AdminService().selectBoardChart(3);
		int c4 = new AdminService().selectBoardChart(2);
		int c5 = new AdminService().selectBoardChart(1);
		int c6 = new AdminService().selectBoardChart(0);
			
		Chart chart = new Chart(c1, c2, c3, c4, c5, c6);
		
		ArrayList<Board> list = new AdminService().selectBoardList();
		
		// int mca = new ChartService().
		
		
		
		request.setAttribute("chart", chart);
		request.setAttribute("list", list);
		
		
		request.getRequestDispatcher("views/admin/adminMainView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
