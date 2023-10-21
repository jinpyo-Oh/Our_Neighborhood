package com.kh.board.board_1.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.board.board_1.model.service.BoardService;
import com.kh.board.board_1.model.vo.Board;
import com.kh.board.board_1.model.vo.Image;

/**
 * Servlet implementation class BoardDetailController
 */
@WebServlet("/detail.bo")
public class BoardDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 글번호 뽑기
		int boardNo = Integer.parseInt(request.getParameter("bno"));
		int cgNo = Integer.parseInt(request.getParameter("cg"));
		
		// BoardService 객체 생성
		BoardService bService = new BoardService();
		
		// 글 번호로 조회수 증가
		int result = bService.increaseCount(boardNo);
		
		// 조회수가 잘 증가됐다면 => 게시글 조회, 첨부파일 조회
		if(result > 0) {
			
			// 게시글 조회
			Board b = bService.selectBoard(boardNo, cgNo);
			
			// 첨부파일 조회
			Image img = bService.selectImage(boardNo);

			
			// 응답데이터로 각각 넘기고 포워딩
			request.setAttribute("b", b);
			request.setAttribute("img", img);
			
			request.getRequestDispatcher("views/board/boardDetailView.jsp").forward(request, response);
			
		} else {
			
			// 상세조회 실패처리
			
			// 에러문구를 담아서 에러페이지로 포워딩
			request.setAttribute("errorMsg", "게시글 상세조회 실패");
			
			request.getRequestDispatcher("views/commont/errorPage.jsp").forward(request, response);
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
