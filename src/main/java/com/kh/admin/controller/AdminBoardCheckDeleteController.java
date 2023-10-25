package com.kh.admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.admin.model.service.AdminService;

/**
 * Servlet implementation class AdminBoardCheckDeleteController
 */
@WebServlet("/adminBoardCheckDelete.ad")
public class AdminBoardCheckDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminBoardCheckDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");	
		ArrayList<Integer> list = new ArrayList<>();	
		String[] arr = request.getParameterValues("check");
		int cgNo = Integer.parseInt(request.getParameter("cgNo"));
		for(String str : arr) {
			list.add(Integer.parseInt(str));
		}
		
		int result = new AdminService().BoardCheckDelete(list);
		
		if(result > 0 ) {
			response.sendRedirect(request.getContextPath()+"/boardList.ad?cg=" + cgNo);
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
