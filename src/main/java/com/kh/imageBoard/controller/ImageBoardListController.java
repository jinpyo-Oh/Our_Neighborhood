package com.kh.imageBoard.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.kh.common.model.vo.PageInfo;
import com.kh.imageBoard.model.service.ImageBoardService;
import com.kh.imageBoard.model.vo.Board;
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class LostListController
 */
@WebServlet("/imageList.bo")
public class ImageBoardListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImageBoardListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
				Member m = (Member)request.getSession().getAttribute("loginUser");
				
<<<<<<< HEAD
				if(m!=null) {
					
				
				
=======
>>>>>>> 9b89578e342d56ee19ead93eafe361e9ea685d52
				String cgNo = request.getParameter("cg");
		
				// 페이징 처리
				int listCount; // 현재 총 게시글의 갯수
				int currentPage; // 현재 페이지(즉, 사용자가 요청한 페이지)
				int pageLimit; // 페이지 하단에 보여질 페이징바의 페이지 최대 갯수
				int boardLimit; // 한 페이지에 보여질 게시글의 최대 갯수(몇개 단위씩)
				
				int maxPage; // 가장 마지막 페이지가 몇번 페이지인지(즉, 총 페이지 수)
				int startPage; // 페이지 하단에 보여질 페이징바의 시작수
				int endPage; // 페이지 하단에 보여질 페이징바의 끝수
				
				// 총 게시글 수
				listCount = new ImageBoardService().selectListCount();
				
				// 현재 페이지
				currentPage = Integer.parseInt(request.getParameter("currentPage"));
				
				// 보여질 페이징바의 최대값
				pageLimit = 10;
				
				// 한 페이지당 보여질 게시글의 최대값
				boardLimit = 6;
				
				// 총 페이지 수
				maxPage = (int)Math.ceil((double)listCount / boardLimit);
				
				// 보여지는 페이지의 시작 수
				startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
				
				// 보여지는 페이지의 끝 수
				endPage = startPage + pageLimit - 1;
				
				if(endPage > maxPage) {
					endPage = maxPage;
				}
				
				// 페이지 정보들을 담을 VO클래스를 하나 만들기
				PageInfo pi = new PageInfo(listCount, currentPage, pageLimit, boardLimit, maxPage, startPage, endPage);
				
				// 사진게시판 리스트 화면에서 보여질 게시글 리스트를 조회해옴
				
				// PageInfo 객체를 Service 로 넘기면서 요청 후 결과 받기
				ArrayList<Board> list = new ImageBoardService().selectList(pi,cgNo);
				
				// 응답데이터로 조회한 내용물 보내기
				request.setAttribute("pi", pi);
				request.setAttribute("list", list);
				request.setAttribute("cgNo", cgNo);
				
				// 사진게시판 리스트 화면 포워딩
				request.getRequestDispatcher("views/imageBoard/imageListView.jsp").forward(request, response);
				
<<<<<<< HEAD
				}else{
					response.sendRedirect(request.getContextPath());
					request.getSession().setAttribute("alertMsg", "로그인 후 이용가능합니다.");
				}
=======
>>>>>>> 9b89578e342d56ee19ead93eafe361e9ea685d52
				
				
			}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
