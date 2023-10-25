package com.kh.member.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

<<<<<<< HEAD
import com.kh.board.board_1.model.service.BoardService;
import com.kh.board.board_1.model.vo.Board;
import com.kh.common.model.vo.PageInfo;
=======
import com.kh.board.board_1.model.vo.Board;
>>>>>>> 9b89578e342d56ee19ead93eafe361e9ea685d52
import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class MemberWroteListController
 */
@WebServlet("/wrote.me")
public class MemberWroteListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberWroteListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
<<<<<<< HEAD
		
		int listCount;	 // 현재 총 게시글의 갯수
		int currentPage; // 현재 페이지 (즉, 사용자가 요청한 페이지)
		int pageLimit;	 // 페이지 하단에 보여질 페이징바의 페이지 최대 갯수
		int boardLimit;	 // 한 페이지에 보여질 게시글의 최대 갯수 (몇개 단위씩)
		
		int maxPage;	 // 가장 마지막 페이지가 몇번 페이지인지 (즉, 총 페이지 수)
		int startPage;	 // 페이지 하단에 보여질 페이징바의 시작수
		int endPage;	 // 페이지 하단에 보여질 페이징바의 끝수
		
		// 총 게시글 수
		listCount = new BoardService().selectListCount(); 
		
		// 현재 페이지
		currentPage = Integer.parseInt(request.getParameter("currentPage"));
		
		// 보여질 페이징바의 최대값
		pageLimit = 10;
		
		// 한 페이지당 보여질 게시글의 최대값
		boardLimit = 10;
		
		// 총 페이지 수
		maxPage = (int)Math.ceil((double)listCount / boardLimit);
		
		// 보여지는 페이지의 시작 수
		startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
		
		// 보여지는 페이지의 끝 수
		endPage = startPage + pageLimit - 1;
		
		if(endPage > maxPage) {
			
			endPage = maxPage;
		}
		
		// 페이지 정보들을 담을 VO 클래스를 하나 만들기
		PageInfo pi = new PageInfo(listCount, currentPage, pageLimit, boardLimit, maxPage, startPage, endPage);
		
		
		
		int memberNo = ((Member)request.getSession().getAttribute("loginUser")).getMemberNo();
	
		ArrayList<Board> list = new MemberService().wroteList(memberNo,pi);
		request.setAttribute("list", list);
		request.setAttribute("pi", pi);
=======
		int memberNo = ((Member)request.getSession().getAttribute("loginUser")).getMemberNo();
		ArrayList<Board> list = new MemberService().wroteList(memberNo);
		request.setAttribute("list", list);
		
>>>>>>> 9b89578e342d56ee19ead93eafe361e9ea685d52
		request.getRequestDispatcher("/views/member/myWroteList.jsp").forward(request, response);
		
		
		
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
