package com.kh.board.board_1.model.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.commit;
import static com.kh.common.JDBCTemplate.getConnection;
import static com.kh.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.board.board_1.model.dao.BoardDao;
import com.kh.board.board_1.model.vo.Board;
import com.kh.board.board_1.model.vo.Image;
import com.kh.board.board_1.model.vo.Reply;
import com.kh.common.model.vo.PageInfo;

public class BoardService {
	
	public int selectListCount() {
		
		// 1) Connection 객체 생성
		Connection conn = getConnection();
		
		// 2) Connection 과 전달값 넘기고 결과받기
		int listCount = new BoardDao().selectListCount(conn);
		
		// 3) 트랜잭션 처리
		
		// 4) Connection 반납
		close(conn);
		
		// 5) Controller 단으로 리턴
		return listCount;
	}
	
	public ArrayList<Board> selectList(PageInfo pi, String cgNo) {
		
		// 1) Connection 객체 생성
		Connection conn = getConnection();
		
		// 2) Connection 객체와 전달값을 넘기면서
		// DAO로 요청 후 결과 받기
		ArrayList<Board> list = new BoardDao().selectList(conn, pi, cgNo);
		
		// 3) 트랜잭션 처리
		
		// 4) Connection 반납
		close(conn);
		
		// 5) 결과 반환
		return list;
		
	}
	
	public int insertBoard(Board b, Image img) {
		
		// 1) Connection 객체 생성
		Connection conn = getConnection();
		
		// 2) Connection과 전달값 넘기고 결과 받기
		// Board insert
		int result1 = new BoardDao().insertBoard(conn, b);
		
		// 2) Connection 과 전달값을 넘기고 결과 받기
		// Attachment insert
		int result2 = 1;
		
		if(img != null) {
			result2 = new BoardDao().insertImage(conn, img);
		}
		
		// 3) 트랜잭션 처리
		// 모든 쿼리문이 성공해야 커밋
		if(result1 > 0 && result2 > 0) {
			
			commit(conn);
		} else {
			
			rollback(conn);
		}
		
		// 4) Connection 반납
		close(conn);
		
		return result1 * result2;
	}
	
	public int increaseCount(int boardNo) {
		
		// 1) Connection 객체 생성
		Connection conn = getConnection();
		
		// 2) Connection 과 전달값 넘기고 결과받기
		int result = new BoardDao().increaseCount(conn, boardNo);
		
		// 3) 트랜잭션 처리
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
	
	public Board selectBoard(int boardNo) {
		
		// 1) Connection 객체 생ㅅ어
		Connection conn = getConnection();
		
		// 2) Connection 과 전달값 넘기고 결과 받기
		Board b = new BoardDao().selectBoard(conn, boardNo);
		
		// 3) 트랜잭션 처리 => 패스
		
		// 4) Connection 밙납
		close(conn);
		// 5) 결과리턴
		return b;
	}
	
	public Image selectImage(int boardNo) {
		
		// 1) Connection 객체 생성
		Connection conn = getConnection();
		
		// 2) Connection 과 전달값 넘기고 결과 받기
		Image img = new BoardDao().selectImage(conn, boardNo);
		
		// 3) 트랜잭션 처리 => 패스
		
		// 4) Connection 객체 반납
		close(conn);
		
		// 5) 결과 리턴
		return img;
	}
	public int increaseRecommend(int boardNo, int memberNo) {
		
		// 1) Connection 객체 생성
		Connection conn = getConnection();
		
		
		
		// 2) Connection 과 전달값 넘기고 결과 받기
		ArrayList<Integer> list = new BoardDao().selectRecommend(conn, boardNo, memberNo);
		
		System.out.println(list);
		
		int num = 0;
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i) == boardNo) {
				num++;
			}
			
		}
		int result1 = 0;
		int result2 = 0;
		if(num == 0) {
			
			result1 = new BoardDao().increaseRecommend(conn, boardNo, memberNo);
			result2 = new BoardDao().insertRecommend(conn, boardNo, memberNo);
			
		}
		// 3) 트랜잭션 처리
		if(result1 * result2 > 0) {
			commit(conn);
		} else {
			
			rollback(conn);
		}
		
		// 4) Connection 객체 반납
		close(conn);
		
		// 5) 결과 리턴
		return result1 * result2;
	}
	
	public int updateBoard(Board b, Image img) {
		
		// 1) Connection 객체 생성
		Connection conn = getConnection();
		
		// 2) Connection 과 전달값을 넘기면서
		// DAO 로 요청 후 결과 받기 - 1
		// case 0
		int result1 = new BoardDao().updateBoard(conn, b);
		
		// 3) Connection 과 전달값을 넘기녓 
		// DAO 로 요청 후 결과 받기
		// case 1, case 2
		int result2 = 1;
		
		if(img != null) {
			if(img.getImgNo() != 0) {
				// case 1
				result2 = new BoardDao().updateImage(conn, img);
				
			} else {
				// case 2
				result2 = new BoardDao().insertNewImage(conn, img);
			}
		}
		// 이 시점 기준으로 성공 실패 여부 검사
		
		// 4) 트랜잭션 처리
		if(result1 > 0 && result2 > 0) {
			
			// 모두 성공 => 커밋
			commit(conn);
		} else {
			
			// 하나라도 실패 => 롤백
			rollback(conn);
		}
		
		// Connection 객체 반납
		close(conn);
		
		// 6) 리턴
		return result1 * result2;
	}
	
	public int deleteBoard(int boardNo) {
		
		// 1) Connection 객체 생성
		Connection conn = getConnection();
		
		// 2) Connection 과 전달값 넘기고 결과 받기
		int result = new BoardDao().deleteBoard(conn, boardNo);
		
		// 3) 트랜잭션 처리
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
	
	public ArrayList<Reply> selectReplyList(int boardNo) {
		
		// 1) Connection 객체 생성
		Connection conn = getConnection();
		
		// 2) Connection 과 전달값을 넘기면서 결과받기
		ArrayList<Reply> list = new BoardDao().selectReplyList(conn, boardNo);
		
		// 3) 트랜잭션 처리 => 패스
		
		// 4) Connection 객체 반납
		close(conn);
		
		// 5) 결과 리턴
		return list;
		
	}
	
	public int insertReply(Reply r) {
		
		// 1) Connection 객체 생성
		Connection conn = getConnection();
		
		// 2) Connection 과 전달값 넘기고 결과받기
		int result = new BoardDao().insertReply(conn, r);
		
		// 3) 트랜잭션 처리
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
	
	public int deleteReply(int rno) {
		
		// 1) 변수 생성
		Connection conn = getConnection();
		
		// 2) Connection 과 전달값 넘기고 결과받기
		int result = new BoardDao().deleteReply(conn, rno);
		
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
