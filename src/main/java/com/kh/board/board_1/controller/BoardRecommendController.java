package com.kh.board.board_1.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.kh.board.board_1.model.service.BoardService;
import com.kh.board.board_1.model.vo.Board;
import com.kh.board.board_1.model.vo.Image;
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class BoardRecommendController
 */
@WebServlet("/recommend.bo")
public class BoardRecommendController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardRecommendController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		// 게시글 번호 받기
		int boardNo = Integer.parseInt(request.getParameter("bno"));
		System.out.println(boardNo);
		
		Member loginUser = (Member)session.getAttribute("loginUser");
		int memberNo = loginUser.getMemberNo();
		
		int result = new BoardService().increaseRecommend(boardNo, memberNo);
		
		BoardService bService = new BoardService();
		if(result > 0) {			// 응답데이터로 각각 넘기고 포워딩
			
			request.getSession().setAttribute("alertMsg", "추천되었습니다. 다시는 취소할수없습니다. 감사합니다.");
			response.sendRedirect(request.getContextPath() + "/detail.bo?bno=" + boardNo);
			
		} else {
			
			// 상세조회 실패처리
			
			// 에러문구를 담아서 에러페이지로 포워딩
			request.getSession().setAttribute("alertMsg", "이미 추천한 게시글입니다..");
			response.sendRedirect(request.getContextPath() + "/detail.bo?bno=" + boardNo);
			
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
