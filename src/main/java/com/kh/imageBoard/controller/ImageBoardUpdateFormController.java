package com.kh.imageBoard.controller;

import java.io.IOException;
import java.util.ArrayList;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.kh.imageBoard.model.service.ImageBoardService;
import com.kh.imageBoard.model.vo.Board;
import com.kh.imageBoard.model.vo.Category;
import com.kh.imageBoard.model.vo.Image;


/**
 * Servlet implementation class LostUpdateFormController
 */
@WebServlet("/imageUpdateForm.bo")
public class ImageBoardUpdateFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImageBoardUpdateFormController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// 게시글 정보 불러오기
		ImageBoardService bService = new ImageBoardService();
		
		int cgNo = Integer.parseInt(request.getParameter("cg"));
		

		
		// 게시글 상세정보, 첨부파일 상세정보 불러오기
		// (글번호 필요함)
		int boardNo = Integer.parseInt(request.getParameter("bno"));
		
		Board b = bService.selectBoard(boardNo,cgNo);
		// 글번호, 카테고리명, 제목, 내용, 작성자아이디, 작성일
		
		Image im = bService.selectAttachment(boardNo);
		System.out.println(im);
		// 첨부파일번호, 원본명, 수정명, 저장경로
		// => 첨부파일이 없는 게시글일 경우 null
		

		request.setAttribute("b", b);
		request.setAttribute("im", im);
		
		// 게시글 수정 페이지 포워딩
		request.getRequestDispatcher("views/imageBoard/imageUpdateForm.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
