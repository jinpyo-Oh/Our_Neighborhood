
package com.kh.admin.controller;
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
 * Servlet implementation class LostInsertController
 */
@WebServlet("/imageInsert.ad")
public class AdminImageBoardInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminImageBoardInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
				// 1) POST 방식이므로 인코딩 설정 먼저
				request.setCharacterEncoding("UTF-8");
				
				// 2) 이 요청이 multipart/form-data 형식인지
				// 검사 후 해당 요청일 경우에만 코드가 수행이 되게끔 처리
				if(ServletFileUpload.isMultipartContent(request)) {
					
					// 3) 기존의 HttpServletRequest 타입을
					// MultipartRequest 타입으로 이관하기
					// => MultipartRequest 객체 생성 시 필요한 데이터
					// : 전송용량제한 (maxSize), 저장경로 (savePath)
					
					// 3) 기존의 HttpServletRequest 타입을 
					// MultipartRequest 타입으로 이관하기
					// => MultipartRequest 객체 생성 시 필요한 데이터
					// : 전송용량제한 (maxSize), 저장경로 (savePath)
					
					// 3_1) 필요한 변수 먼저 세팅
					// - 전송 용량 제한 (byte 단위)
					int maxSize = 10 * 1024 * 1024;
					
					// - 저장경로(application scope 객체로부터 webapp 폴더로부터 시작하는 경로 제시)	
					String savePath = request.getServletContext().getRealPath("/resources/img/board/imageBoard_upfiles/");

					// 3_2) MultipartRequest 객체 생성 (생성자구문)
					// MultipartRequest 타입으로 이관, 파일명 수정, 파일 업로드가 동시에 일어나게됨
					MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
					
					// 이 시점 기준으로 파일 업로드는 완료된 상황임
					
					// 4) MultiRequest로 부터 요청 시 전달값 뽑기
					// 변수 및 객체에 기록
					// - BOARD 테이블에 INSERT
					String boardWriter = multiRequest.getParameter("memberNo");
					String boardTitle = multiRequest.getParameter("boardTitle");
					String boardContent = multiRequest.getParameter("boardContent");
					String cgNo = multiRequest.getParameter("cgNo");
					
					Board b = new Board();
					b.setMemberNo(boardWriter);
					b.setBoardTitle(boardTitle);
					b.setBoardContent(boardContent);
					
					// - 넘어온 첨부파일의 개수만큼 ATTACHMENT 테이블에 INSERT
					// 첨부파일 뽑아내기
					// 단, 여러개의 첨부파일이 있을 예정이기 때문에 (1~4)
					// Attachment 1개 == 첨부파일 1개
					// Attachment 들을 ArrayList에 담아둘 것
					ArrayList<Image> list = new ArrayList<>();
					
					for(int i = 1; i <= 5; i++) {
						String key = "file" + i;
						// "file1", "file2", "file3", "file4", "file5"
						// 각 키값을 가진 첨부파일이 있는지 확인
						if(multiRequest.getOriginalFileName(key) != null) {
							// 해당 키값에 대한 첨부파일이 있을 경우
							// Image 객체 생성
							Image im = new Image();
							
							// insert시 필요한 필드값 가공
							// => 원본파일명, 수정파일명, 파일경로, 파일레벨
							String originName = multiRequest.getOriginalFileName(key);
							String changeName = multiRequest.getFilesystemName(key);
							String filePath = "resources/img/board/imageBoard_upfiles/";
							int fileLevel = 0;
							// file level
							if(i == 1) { // 대표이미지일 경우
								
								fileLevel = 1;
							} else { // 대표이미지가 아닐 경우
								
								fileLevel = 2;
							}
							
							im.setOriginalName(originName);
							im.setChangeName(changeName);
							im.setImgPath(filePath);
							im.setImgLevel(fileLevel);
							
							// list에 차곡차곡 담기
							list.add(im);
							
							
						}
					
					}
					// 이 시점 기준으로 넘어온 첨부파일의 개수 만큼
					// list에 im이 담겨 있을 것
					
					// 5) Service로 게시글 등록 요청 후 결과 받기
					int result = new ImageBoardService().insertImageBoard(b, list, cgNo);
							
					
					// 6) 결과에 따른 응답뷰 지정
					if(result > 0) { //성공
						
						// 1회성 알람 문구를 담아
						// 사진게시판 리스트로 url 재요청 (list.th)
						//System.out.println("여기까진 잘 갔나?");
						request.getSession().setAttribute("alertMsg", "성공적으로 사진게시글이 등록되었습니다.");
						response.sendRedirect(request.getContextPath()+ "/boardList.ad?cg="+cgNo);
					
						
					} else { // 실패
						
						// 에러문구를 담아 에러페이지로 포워딩
						request.getSession().setAttribute("errorMsg", "사진게시글 업로드 실패");

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
