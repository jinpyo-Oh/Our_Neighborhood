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
import com.kh.board.board_1.model.vo.Image;

/**
 * Servlet implementation class AdminBoardListController
 */
@WebServlet("/boardDetail.ad")
public class AdminBoardDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminBoardDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int cgNo = Integer.parseInt(request.getParameter("cgNo"));
		int boardNo = Integer.parseInt(request.getParameter("bno"));
		
		Board b = new AdminService().selectBoard(boardNo);
		Image img = new AdminService().selectImage(boardNo);
		
		request.setAttribute("cgNo", cgNo);
		request.setAttribute("boardNo", boardNo);
		request.setAttribute("b", b);
		request.setAttribute("img", img);
		
		request.getRequestDispatcher("views/admin/adminBoardDetailView.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
