package com.kh.board.board_1.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.kh.board.board_1.model.service.BoardService;
import com.kh.board.board_1.model.vo.Board;
import com.kh.board.board_1.model.vo.Image;
import com.kh.common.MyFileRenamePolicy;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class BoardUpdateController
 */
@WebServlet("/update.bo")
public class BoardUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1) 인코딩
		request.setCharacterEncoding("UTF-8");
		
		// enctype 이 mutipart/form-data 로
		// 잘 전송 되었을 경우에만 전반적인 내용이 수행되게끔
		if(ServletFileUpload.isMultipartContent(request)) {
			
			// (HttpServletRequest -> mMultipartRequest)
			
			// 1. MultipartRequest 객체 생성 시 필요한 정보 얻기
			// 1_1. 전송파일 용량 제한
			int maxSize = 10* 1024 * 1024;
			
			// 1_2. 전달된 파일을 저장시킬 서버의 경로 (String savePath)
			// application scope 객체로부터 알아내기
			// 배포되는 webapp 폴더를 기준으로 경로를 제시해서 알아내기
			String savePath = request.getSession().getServletContext().getRealPath("/resources/img/board/board_1_upfiles/");
			
			// 2. MultipartRequest 객체 생성
			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
			
			// 이 시점에서 파일이 서버에 업로드됨
			
			// 3. SQL문 실행시 필요한 데이터들을 VO로 가공하기
			
			// case 0. 기존 첨부파일 x, 새 첨부파일 x
			
			// case 1. 기존 첨부파일 o, 새 첨부파일 o
			
			// case 2. 기존 첨부파일 x, 새 첨부파일 o
			
			// case 3. 기존 o 새 x
			
			// 공통적으로 수행
			int boardNo = Integer.parseInt(multiRequest.getParameter("boardNo"));
			String boardTitle = multiRequest.getParameter("title");
			String boatdContent = multiRequest.getParameter("content");
			String cgNo = multiRequest.getParameter("cg") ;
			
			Board b = new Board();
			b.setBoardNo(boardNo);
			b.setBoardTitle(boardTitle);
			b.setBoardContent(boatdContent);
			b.setCgNo(cgNo);
			
			// 새 첨부파일 o 공통
			Image img = null;
			// 새롭게 첨부파일이 넘어왔을 경우만 객체 생성
			if(multiRequest.getOriginalFileName("upfile") != null) {
				
				img = new Image();
				
				// case 1 일 경우
				// 원본명, 수정명, 경로, 파일번호
				
				// case 2 일 경우
				// 원본명, 수정명, 저장경로
				
				// 공통적인 데이터
				String originName = multiRequest.getOriginalFileName("upfile");
				String changeName = multiRequest.getFilesystemName("upfile");
				String filePath = "resources/img/board/board_1_upfiles/";
				
				img.setOriginalName(originName);
				img.setChangeName(changeName);
				img.setImgPath(filePath);
				System.out.println(filePath);
				if(multiRequest.getParameter("originFileNo") != null) {
					// - case 1 인 경우
					int fileNo = Integer.parseInt(multiRequest.getParameter("originFileNo"));
					img.setImgNo(fileNo);
					
					// 기존 첨부파일을 삭제
					String originFileName = multiRequest.getParameter("originFileName");
					new File(savePath + originFileName).delete();
				} else {
					// - case 2 인 경우
					img.setBoardNo(boardNo);
				}
			}
			// 트랜잭션 처리는 다같이
			int result = new BoardService().updateBoard(b, img);
			
			if(result > 0) {
				
				// 1회성 알람문구
				// 해당 게시글의 상조회 페이지로 재요청
				request.getSession().setAttribute("alertMsg", "게시글이 수정되었습니다.");
				
				response.sendRedirect(request.getContextPath() + "/detail.bo?bno=" + boardNo+"&cg="+cgNo);
			} else {
				
				// 에러문구
				// 에러페이지
				request.getSession().setAttribute("errorMsg", "게시글 수정 실패");
				request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
				
				
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
