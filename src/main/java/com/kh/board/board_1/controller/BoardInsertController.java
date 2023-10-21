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
 * Servlet implementation class BoardInsertController
 */
@WebServlet("/insert.bo_1")
public class BoardInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1) Post 방식이므로 인코딩 설정
		request.setCharacterEncoding("UTF-8");
		
		if(ServletFileUpload.isMultipartContent(request)) {
			
			// 1_1. 전송파일 용량 제한
			int maxSize = 10 * 1024 * 1024;
			
			// 1_2. 전달된 파일을 저장할 실제 서버의 경로 알아내기
			String savePath = request.getSession().getServletContext().getRealPath("/resources/img/board/board_1_upfiles/");
			
			// 2. 
			MultipartRequest multiRequest = 
					new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
			
			// 3. DB 에 insert 할 데이터들을 뽑아서 VO 객체에 담기
			String boardWriter = multiRequest.getParameter("userNo");
			String title = multiRequest.getParameter("title");
			String content = multiRequest.getParameter("content");
			// Board VO 로 가공
			Board b = new Board();
			b.setMemberNo(boardWriter);
			b.setBoardTitle(title);
			b.setBoardContent(content);
			
			Image img = null;
			
			if(multiRequest.getOriginalFileName("upfile") != null) {
				// 넘어온 파일이 있을 경우
				
				img = new Image();
				
				// 원본파일명
				String originName = multiRequest.getOriginalFileName("upfile");
				// 수정파일명
				String changeName = multiRequest.getFilesystemName("upfile");
				
				img.setOriginalName(originName);
				img.setChangeName(changeName);
				img.setImgPath("resources/img/board/board_1_upfiles/");
			}
			
			
			// 4. 서비스로 요청 후 결과 받기
			int result = new BoardService().insertBoard(b, img);
			
			// 결과에 따른 응답뷰 지정
			if(result > 0) { // 성공
				
				request.getSession().setAttribute("alertMsg", "게시글 작성에 성공했습니다.");
				
				response.sendRedirect(request.getContextPath() + "/list.bo?currentPage=1");
				
			} else { // 실패
				
				if(img != null) {
					
					new File(savePath + img.getChangeName()).delete();
					
				}
				
				request.setAttribute("errorMsg", "게시글 작성 실패");
				
				request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
			}
		}
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
