package com.kh.imageBoard.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;


import com.kh.common.MyFileRenamePolicy;
import com.kh.imageBoard.model.service.ImageBoardService;
import com.kh.imageBoard.model.vo.Board;
import com.kh.imageBoard.model.vo.Image;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class LostUpdateController
 */
@WebServlet("/imageUpdate.bo")
public class ImageBoardUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImageBoardUpdateController() {
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1) POST 방식이므로 인코딩 설정 먼저하기
		request.setCharacterEncoding("UTF-8");
		
		// enctype 이 multipart/form-data 로
		// 잘 전송 되었을 경우에만 전반적인 내용이 수행되게끔
		if(ServletFileUpload.isMultipartContent(request)) {
			
			// enctype 이 multipart/form-data 로 요청이 들어왔을 때
			// 기존 request 객체를 MultipartRequest 타입으로 변환
			// (HttpServletReqeust -> MultipartRequest)
			
			// MultipartReqeust multiRequest 
			// = new MultipartReqeust(request, 저장할파일경로, 용량제한, 인코딩, 파일명수정객체);
			
			// 1. MultipartRequest 객체 생성 시 필요한 정보 얻기
			// 1_1. 전송 파일 용량 제한 (int maxSize)
			// 10Mbyte 로 지정 (byte 단위로 세팅)
			int maxSize = 10 * 1024 * 1024;
			
			// 1_2. 전달된 파일을 저장시킬 서버의 경로 (String savePath)
			// application scope 객체로부터 알아내기
			// 배포되는 webapp 폴더를 기준으로 경로를 제시해서 알아내기
			String savePath = request.getSession().getServletContext().getRealPath("/resources//");
			
			// 2. MultipartRequest 객체 생성하기
			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
			
			// 위의 구문 한줄 만으로
			// request 객체가 MultipartRequest 타입으로 이관
			// 전달된 파일명이 수정됨
			// 해당 경로에 전달된 파일이 업로드까지 일어남
			
			// 이 시점 기준으로 새롭게 넘어온 첨부파일이 서버에 업로드 되어있음
			
			// 3. 본격적으로 SQL문 실행 시 필요한 테이터들을 VO 로 가공하기
			
			// CASE 0. 기존 첨부파일 X, 새로운 첨부파일 X
			// => BOARD 테이블 UPDATE 만 하면 끝
			
			// CASE 1. 기존 첨부파일 O, 새로운 첨부파일 O
			// => BOARD 테이블 UPDATE, ATTACHMENT 테이블 UPDATE
			
			// CASE 2. 기존 첨부파일 X, 새로운 첨부파일 O
			// => BOARD 테이블 UPDATE, ATTACHMENT 테이블 INSERT

			// - 공통적으로 수행 : BOARD 테이블에 UPDATE
			// BOARD VO 로 가공하기
			int boardNo = Integer.parseInt(multiRequest.getParameter("boardNo"));
			String boardTitle = multiRequest.getParameter("boardTitle");
			String boardContent = multiRequest.getParameter("boardContent");
			String cgNo = multiRequest.getParameter("cg");
			
			Board b = new Board();
			b.setBoardNo(boardNo);
			b.setBoardTitle(boardTitle);
			b.setBoardContent(boardContent);
			b.setCgNo(cgNo);
			
			
			// - 새로이 첨부파일이 전달되었을 경우
			// (case1, case2 공통)
			
			// 전송 용량 제한 
		
			
			ArrayList<Image> list = new ArrayList<>();
			
			for(int i = 1; i <= 5; i++) {
			
				String key = "file" + i;
				// "file1", "file2", "file3", "file4", "file5"
				
				// 각 키값을 가진 첨부파일이 있는지 확인
				if(multiRequest.getOriginalFileName(key) != null) {
					
				
				
			// 첨부파일이 새롭게 넘어왔을 경우에만 객체 생성
			// multiRequest.getOriginalFileName("키값")
			// 넘어온 파일에 대한 원본파일명을 알 수 있음
			// (넘어온 파일이 없다면 null을 리턴)
				
				Image img = new Image();
				
				
				// case1 일 경우 필요한 데이터
				// 새로 넘어온 파일의 원본명, 수정명, 저장경로
				// 기존 첨부파일의 파일번호가 필요함
				
				// case2 일 경우 필요한 데이터
				// 게시글 번호
				// 새로 넘어온 파일의 원본명, 수정명, 저장경로가 필요함
				
				// - 공통적으로 필요한 데이터 먼저 세팅
				// (새로 넘어온 파일의 원본명, 수정명, 저장경로)
				String originName = multiRequest.getOriginalFileName(key);
				String changeName = multiRequest.getFilesystemName(key);
				String filePath = "resources/upfiles/lost_board_upfiles/";
				
				int fileLevel = 0;
				// file level
				if(i == 1) { // 대표이미지일 경우
					
					fileLevel = 1;
				} else { // 대표이미지가 아닐 경우
					
					fileLevel = 2;
				}
				
				
				img.setOriginalName(originName);
				img.setChangeName(changeName);
				img.setImgPath(filePath);
				img.setImgLevel(fileLevel);
				img.setBoardNo(boardNo);
				
				// list에 차곡차곡 담기
				list.add(img);
				}
				
				
			}
			int result = new ImageBoardService().updateBoard(b, list);
			
			// 결과에 따른 응답뷰 지정
			if(result > 0) { // 성공
				
				// 1회성 알람문구를 담아
				// 해당 게시글의 상세조회 페이지로 url 재요청
				request.getSession().setAttribute("alertMsg", "성공적으로 게시글이 수정되었습니다.");
				response.sendRedirect(request.getContextPath() + "/lost.th?bno=" + boardNo+"&cg=" +cgNo);
			} else { // 실패
				
				// 에러문구를 담아
				// 에러페이지로 포워딩
				request.setAttribute("errorMsg", "게시글 수정 실패");
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
