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
 * Servlet implementation class BoardUpdateFormController
 */
@WebServlet("/updateForm.bo_1")
public class BoardUpdateFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardUpdateFormController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 게시글 정보 불러오기
		BoardService bService = new BoardService();
		int boardNo = Integer.parseInt(request.getParameter("bno"));
		
		Board b = bService.selectBoard(boardNo);
		// 글번호, 제목, 내용 ,작성자아이디, 작성일
		
		Image img = bService.selectImage(boardNo);
		// 이미지번호, 원본명, 수정명, 경로
		// => 첨부파일이 없으면 null
		
		
		request.setAttribute("b", b);
		request.setAttribute("img", img);
		
		// 포워딩
		request.getRequestDispatcher("views/board/board_1/1-BoardUpdateForm.jsp").forward(request, response);
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
