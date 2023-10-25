package com.kh.imageBoard.model.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.commit;
import static com.kh.common.JDBCTemplate.getConnection;
import static com.kh.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.imageBoard.model.vo.Category;
import com.kh.board.board_1.model.vo.Reply;
import com.kh.common.model.vo.PageInfo;
import com.kh.imageBoard.model.dao.ImageBoardDao;
import com.kh.imageBoard.model.vo.Board;
import com.kh.imageBoard.model.vo.Image;

public class ImageBoardService {

	
	
	
	
	/**
	 * 총 게시글 수
	 */
	public int selectListCount() {
		
		// 1) Connection 객체 생성
		Connection conn = getConnection();
		
		// 2) Connection과 전달값을 DAO로 넘기면서 요청 후 결과 받기
		int listCount = new ImageBoardDao().selectListCount(conn);
		
		// 3) 트랜잭션 처리
		
		// 4) Connection 반납
		close(conn);
		
		// 5) Controller 단으로 결과 리턴
		
		return listCount;
	}
	
	/**
	 * 사진게시판 리스트 화면에서 보여질 게시글 리스트
	 */
	public ArrayList<Board> selectList(PageInfo pi, String cgNo) {
		
		// 1) Connection 객체 생성
		Connection conn = getConnection();
		
		// 2) Connection 객체와 전달값을 넘기면서 DAO로 요청 후 결과 받기
		ArrayList<Board> list = new ImageBoardDao().selectList(conn, pi, cgNo);
		
		// 3) 트랜잭션 처리 (select 문이므로 패스)
		
		// 4) Connection 객체 반납
		close(conn);
		
		// 5) Controller 단으로 결과 반환
		return list;
		
	}
	

	/**
	 *	사진 넣기 용
	 */
	public int insertImageBoard(Board b, ArrayList<Image> list, String cgNo) {
		
		// 1) Connection 객체 생성
		Connection conn = getConnection();
		
		// 2) Connection과 전달값을 넘기면서 DAO로 요청 후 결과 받기
		// Board Insert
		int result1 = new ImageBoardDao().insertImageBoard(conn, b, cgNo);
		
		
		// 3) Connection과 전달값을 넘기면서 DAO로 요청 후 결과 받기 -2
		// => 사진게시판은 적어도 1개 이상의 첨부파일이 무조건 넘어오기 때문에 곧바로 요청 날리기
		// Image insert
		int result2 = new ImageBoardDao().insertAttachmentList(conn, list);
		
		
		// 4) 트랜잭션 처리
		if(result1 > 0 && result2 > 0) {
			
			commit(conn);
		} else {
			
			rollback(conn);
		}
		
		// 5) Connection 반납
		close(conn);
		
		// 6) Controller 단으로 결과 반환
		
		
		return result1 * result2;
	}

	/**
	 * 조회수 증가용 요청
	 */
	public int increaseCount(int boardNo) {
		
		// 1) Connection 객체 생성
		Connection conn = getConnection();
		
		// 2) Connection과 전달값을 넘기면서 DAO로 요청 후 결과 받기
		int result = new ImageBoardDao().increaseCount(conn, boardNo);
		
		// 3) 트랜잭션 처리
		if(result > 0) { // 성공 커밋
			commit(conn);
		} else { // 실패 롤백
			rollback(conn);
			
		}
		
		
		
		
		return result;
	}

	/**
	 * 게시글 조회
	 */
	public Board selectBoard(int boardNo, int cgNo) {
		
		// 1) Connection 객체 생성
		Connection conn = getConnection();
		
		// 2) Connection과 전달값을 넘기면서 DAO로 요청 후 결과 받기
		Board b = new ImageBoardDao().selectBoard(conn, boardNo, cgNo);
		
		// 3) 트랜잭션 처리
		// select문이므로 패스
		
		// 4) Connection 객체 반납
		close(conn);
		
		// 5) Controller로 결과 반환
		
		return b;
	}

	/**
	 * 첨부파일 조회
	 */
	public ArrayList<Image> selectImageList(int boardNo) {

		// 1) Connection 객체 생성
		Connection conn = getConnection();
		
		// 2) Connection과 전달값을 넘기면서 DAO로 요청후 결과 받기
		ArrayList<Image> list = new ImageBoardDao().selectImageList(conn, boardNo); 
		
		// 3) 트랜잭션 처리
		// select문이므로 패스
		
		// 4) Connection 객체 반납
		close(conn);
		
		// 5) Controller로 결과 반환
		return list;
	}

	public int increaseRecommend(int boardNo, int memberNo) {
		
		// 1) Connection 객체 생성
		Connection conn = getConnection();
		
		// 2) Connection과 전달값 넘기고 결과 받기
		ArrayList<Integer> list = new ImageBoardDao().selectRecommend(conn, boardNo, memberNo);
		
		int num = 0;
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i) == boardNo) {
				num++;
				
			
				}
				
			}
		int result1 = 0;
		int result2 = 0;
		if(num == 0) {
			
			result1 = new ImageBoardDao().increaseRecommend(conn, boardNo, memberNo);
			result2 = new ImageBoardDao().insertRecommend(conn, boardNo, memberNo);
		}
		
		// 3) 트랜잭션 처리
		if(result1 * result2 > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		// 4) Connection 객체 반납
		close(conn);
		
		return result1 * result2;
	}

	public int updateLost(Board b, Image im) {

		// 1) Connection 객체 생성
		Connection conn = getConnection();
		
		// 2) Connection과 전달값을 넘기면서 DAO로 요청 후 결과 받기
		int result1 = new ImageBoardDao().updateLost(conn, b);
		
		// 3) Connection과 전달값을 넘기면서 DAO로 요청후 결과 받기 -2
		// (case1, cas2인 경우 생각해보기)
		int result2 = 1;
		
		if(im != null) { // 새롭게 첨부된 파일이 있을 경우
			
			if(im.getImgNo() != 0) {
				
				// case1일 경우
				// (기존 첨부파일이 있을 경우)
				// => Image 테이블 update
				result2 = new ImageBoardDao().updateImage(conn, im);
				
			} else {
				
				// case2일 경우
				// (기존 첨부파일이 없을 경우)
				// => Image 테이블 insert
				result2 = new ImageBoardDao().insertNewImage(conn, im);
			}
		}
		
				// 이 시점 기준으로 성공, 실패 여부 검사
				// 4) 트랜잭션 처리
				if(result1 > 0 && result2 > 0) { // 모두 성공 => 커밋
					commit(conn);
				} else { // 하나라도 실패 => 롤백
					rollback(conn);
			
			}
				
				// 5) Connection 객체 반납
				close(conn);
				
				// 6) Controller로 결과 리턴
				return result1 * result2;
				// 혹시 하나라도 실패하여 0이 될 경우
				// 실패값을 전달하기 위해서 곱셈값을 리턴
			
		}

	/**
	 * 카테고리 정보 불러오기
	 */
	public ArrayList<Category> selectCategoryList() {

		// 1) Connection 객체 생성
		Connection conn = getConnection();
		
		// 2) Connection과 전달값을 넘기면서
		// DAO로 요청 후 결과 받기
		ArrayList<Category> list = new ImageBoardDao().selectCategoryList(conn);
		
		// 3) 트랜잭션 처리(select문이므로 패스)
		
		// 4) Connection 반납
		close(conn);
		
		// 5) Controller단으로 결과 리턴
		return list;
	}

	/**
	 * 첨부파일 수정
	 */
	public Image selectAttachment(int boardNo) {
		
		// 1) Connection 객체 생성
		Connection conn = getConnection();
		
		// 2) Connection과 전달값을 넘기면서 DAO로 요청 후 결과 받기
		Image im = new ImageBoardDao().selectAttachment(conn, boardNo);
		
		// 3) 트랜잭션 처리
		// select문이므로 패스
		
		// 4) Connection 객체 반납
		close(conn);
		
		// 5) Controller 결과 반환
		return im;
		
	}

	public int updateBoard(Board b, ArrayList<Image> list) {
		
		// 1) Connection 객체 생성
		Connection conn = getConnection();
		
		// 2) Connection 과 전달값을 넘기면서
		// DAO 로 요청 후 결과 받기 - 1
		// (경우에 따른 공통 쿼리문인 BOARD UPDATE 먼저 요청)
		int result1 = new ImageBoardDao().updateBoard(conn, b);
		
		int result2 = new ImageBoardDao().updatedeleteList(conn, list, b);
			
		int result3 = new ImageBoardDao().updateAttachmentList(conn, list, b);

		// 이 시점 기준으로 성공, 실패 여부 검사
		// 4) 트랜잭션 처리
		
		if(result1 > 0 && result2 > 0 && result3 > 0) { // 모두 성공 => 커밋
		
				commit(conn);	
			
		} else { // 하나라도 실패 => 롤백
			
			rollback(conn);
			
		}
		
		// 5) Connection 객체 반납
		close(conn);
		
		// 6) Controller 로 결과 리턴
		return result1 * result3;
		// 혹시 하나라도 실패하여 0이 될 경우
		// 실패값을 전달하기 위해서 곱셈값을 리턴
	
	}

	public int deleteBoard(int boardNo) {
		
				// 1) Connection 객체 생성
				Connection conn = getConnection();
				
				// 2) Connection 과 전달값을 넘기면서
				// DAO 로 요청 후 결과 받기
				int result = new ImageBoardDao().deleteBoard(conn, boardNo);
				
				// 3) 트랜잭션 처리
				if(result > 0) {
					
					commit(conn);
					
				} else {
					
					rollback(conn);
				}
				
				// 4) Connection 반납
				close(conn);
				
				// 5) Controller 로 결과 리턴
				return result;
			}

	public int insertReply(Reply r) {
		
		// 1) Connection 객체 생성
		Connection conn = getConnection();
		
		// 2) Connection 과 전달값을 넘기면서
		// DAO 로 요청 후 결과 받기
		int result = new ImageBoardDao().insertReply(conn, r);
		
		// 3) 트랜잭션 처리
		if(result > 0) {
			
			commit(conn);
			
		} else {
			
			rollback(conn);
		}
		
		// 4) Connection 반납
		close(conn);
		
		// 5) Controller 단으로 결과 반환
		return result;
	}

	public ArrayList<Reply> selectReplyList(int boardNo) {
		
				// 1) Connection 객체 생성
				Connection conn = getConnection();
				
				// 2) Connection 과 전달값을 넘기면서
				// DAO 로 요청 후 결과 받기
				ArrayList<Reply> list = new ImageBoardDao().selectReplyList(conn, boardNo);
				
				// 3) 트랜잭션 처리
				// select 문이므로 패스
				
				// 4) Connection 반납
				close(conn);
				
				// 5) Controller 단으로 결과 리턴
				return list;
			}
	


	public int deleteReply(int rno) {
		
		// 1) 변수 생성
				Connection conn = getConnection();
				
				// 2) Connection 과 전달값 넘기고 결과받기
				int result = new ImageBoardDao().deleteReply(conn, rno);
				
				// 3) 트랜잭션
				if(result > 0) {
					
					commit(conn);
				} else {
					
					rollback(conn);
				}
				
				// 4) Connection 객체 반납
				close(conn);
				
				// 5) 결과 리턴
				return result;
	
	
	}
	

}
