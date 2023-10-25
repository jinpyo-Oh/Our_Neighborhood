package com.kh.admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.kh.imageBoard.model.service.ImageBoardService;
import com.kh.imageBoard.model.vo.Board;
import com.kh.imageBoard.model.vo.Image;

/**
 * Servlet implementation class LostController
 */
@WebServlet("/imageDetail.ad")
public class AdminImageBoardDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminImageBoardDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		// 상세조회할 글번호 먼저 뽑기
		int boardNo = Integer.parseInt(request.getParameter("bno"));
		int cgNo = Integer.parseInt(request.getParameter("cgNo"));
		
		// ImageService 객체를 생성해두기
		ImageBoardService bService = new ImageBoardService();
		
		// 우선 조회수 증가용 요청 후 결과 받기
		int result = bService.increaseCount(boardNo);
		
		// 조회수 증가에 성공했다면
		// => 게시글 정보 조회, 첨부파일 정보 조회
		if(result > 0) {
			
			// 조회수 증가에 성공했다면
			// => 게시글 정보 조회, 첨부파일 정보 조회
			
			// 기존의 일반게시판용 selectBoard 쿼리 재활용
			// => 기존의 쿼리문은 내부조인
			// 내부 조인의 경우 일치하는 컬럼값만을 조회하는 구조였는데
			// 사진게시판 같은 경우 카테고리 정보가 null 이기 때문에 조회 안됨
			// 이 상황을 해결하려면 카테고리 컬럼을 기준으로 일치하는 컬럼값도, 일치하지 않는 컬럼값도
			// BOARD 테이블로부터 조회해 오려면 BOARD 테이블을 기준점으로 삼는
			// "외부(포괄)조인" 으로 구문을 바꾸면 됨
			
			// 게시글조회
			Board b = bService.selectBoard(boardNo, cgNo);
			
			// 첨부파일조회
			ArrayList<Image> list = bService.selectImageList(boardNo);
			
			
			// 조회한 데이터들을 응답데이터로 넘기기
			request.setAttribute("b", b);
			request.setAttribute("list", list);
			
			request.getRequestDispatcher("views/admin/adminImageDetailView.jsp").forward(request, response);
			
			
			
		} else {
			
			// 조회수 증가에 실패했다면 에러페이지로 포워딩
			request.setAttribute("errorMsg", "사진게시글 조회 실패");
			
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
			
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
