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
		int cgNo = Integer.parseInt(request.getParameter("cg"));
		
		
		Member loginUser = (Member)session.getAttribute("loginUser");
		int memberNo = loginUser.getMemberNo();
		
		int result = new BoardService().increaseRecommend(boardNo, memberNo);
		
		
		
		if(cgNo==1||cgNo==2||cgNo==3||cgNo==4||cgNo==7||cgNo==10) { // 일반게시글 용
		
		if(result > 0) {			// 응답데이터로 각각 넘기고 포워딩
			
			request.getSession().setAttribute("alertMsg", "추천되었습니다.");
			response.sendRedirect(request.getContextPath() + "/detail.bo?bno=" + boardNo+"&cg="+cgNo);
			
		} else {
			
			// 상세조회 실패처리
			
			// 에러문구를 담아서 에러페이지로 포워딩
			request.getSession().setAttribute("alertMsg", "이미 추천한 게시글입니다..");
			response.sendRedirect(request.getContextPath() + "/detail.bo?bno=" + boardNo+"&cg="+cgNo);
			
		}
		}else { // 사진 게시글용
			if(result > 0) {			// 응답데이터로 각각 넘기고 포워딩
				
<<<<<<< HEAD
				request.getSession().setAttribute("alertMsg", "추천되었습니다.");
=======
				request.getSession().setAttribute("alertMsg", "추천되었습니다. 다시는 취소할수없습니다. 감사합니다.");
>>>>>>> 9b89578e342d56ee19ead93eafe361e9ea685d52
				response.sendRedirect(request.getContextPath() + "/imageDetail.bo?bno=" + boardNo+"&cg="+cgNo);
				
			} else {
				
				// 상세조회 실패처리
				
				// 에러문구를 담아서 에러페이지로 포워딩
				request.getSession().setAttribute("alertMsg", "이미 추천한 게시글입니다..");
				response.sendRedirect(request.getContextPath() + "/imageDetail.bo?bno=" + boardNo+"&cg="+cgNo);
				
			}
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
