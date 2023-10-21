package com.kh.board.board_1.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.board.board_1.model.vo.Board;
import com.kh.board.board_1.model.vo.Image;
import com.kh.board.board_1.model.vo.Reply;
import com.kh.common.JDBCTemplate;
import com.kh.common.model.vo.PageInfo;

public class BoardDao {
	
	private Properties prop = new Properties();
	
	public BoardDao() {
		
		String fileName = BoardDao.class.getResource("/sql/board/board-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int selectListCount(Connection conn) {
		
		// 변수 셋팅
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		// SQL문
		String sql = prop.getProperty("selectListCount");
		
		try {
			
			// PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, 1);
			
			// SQL 문 실행 후 결과 받기
			rset = pstmt.executeQuery();
			
			// rset 으로부터 조회된 결과를 뽑기
			if(rset.next()) {
				
				listCount = rset.getInt("COUNT");
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			// JDBC 용 자원 반납
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		// 결과 리턴
		return listCount;
		
	}
	
	public ArrayList<Board> selectList(Connection conn, PageInfo pi, String cgNo){
		
		// 변수 생성
		ArrayList<Board> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		// SQL문
		String sql = prop.getProperty("selectList");
		
		// PreparedStatement 객체 생성
		try {
			// PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			
			// 쿼리문 완성
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow  + pi.getBoardLimit() - 1;
			
			pstmt.setString(1, cgNo);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
		
			// SQL 문 실행 후 결과 받기
			rset = pstmt.executeQuery();
			
			// 데이터 뽑아서 VO로 가공후 ArrayList 에 담기
			while(rset.next()) {
				
				list.add(new Board(
						   rset.getInt("BOARD_NO"),
						   String.valueOf(rset.getInt("CG_NO")),
						   rset.getString("BOARD_TITLE"),
						   rset.getString("MEMBER_ID"),
						   rset.getInt("COUNT"),
						   rset.getInt("RECOMMEND"),
						   rset.getDate("CREATE_DATE")					   
						   ));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			// JDBC 자원 반납
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		// 결과 리턴
		return list;
		
	}
	
	public int insertBoard(Connection conn, Board b) {
		
		// 변수 셋팅
		int result = 0;
		PreparedStatement pstmt = null;
		
		// SQL 문
		String sql = prop.getProperty("insertBoard");
		

		try {
			// PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			
			// SQL문 완성시키기
			pstmt.setInt(1, Integer.parseInt(b.getCgNo()));
			pstmt.setString(2, b.getBoardTitle());
			pstmt.setString(3, b.getBoardContent());
			pstmt.setInt(4, (Integer.parseInt(b.getMemberNo())));
			
			// 쿼리문 실행 후 결과 받기
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			// JDBC 용 자원 반납
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}
	
	public int insertImage(Connection conn, Image img) {
		
		// 변수 셋팅
		int result = 0;
		PreparedStatement pstmt = null;
		
		// SQL문 셋팅
		String sql = prop.getProperty("insertImage");
		
		try {
			// PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			
			// 쿼리문 완성시키기
			pstmt.setString(1, img.getOriginalName());
			pstmt.setString(2, img.getChangeName());
			pstmt.setString(3, img.getImgPath());
			
			// 실행 후 결과 받기
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			// JDBC용 자원 반납
			JDBCTemplate.close(pstmt);
		}
		// 결과 리턴
		return result;
	}

	public int increaseCount(Connection conn, int boardNo) {
		
		// 변수 셋팅
		int result = 0;
		PreparedStatement pstmt = null;
		
		// SQL 문 셋팅
		String sql = prop.getProperty("increaseCount");
		
		try {
			// PreparedStatemetn 객체 생성
			pstmt = conn.prepareStatement(sql);
			
			// 쿼리문 완성
			pstmt.setInt(1, boardNo);
			
			// 결과 받기
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			
			// JDBC 용 자원 반납
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}
	
	public Board selectBoard(Connection conn, int boardNo, int cgNo) {
		
		// 변수 셋팅
		Board b = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		// SQL
		String sql = prop.getProperty("selectBoard");
		
		try {
			// PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			
			// 쿼리문 완성
			pstmt.setInt(1, boardNo);
			pstmt.setInt(2, cgNo);
			
			// 쿼리문 실행후 결과받기
			rset = pstmt.executeQuery();
			
			// rset에 담긴 데이터 가공
			if(rset.next()) {
				
				b = new Board(rset.getInt("BOARD_NO"),
							  rset.getString("BOARD_TITLE"),
							  rset.getString("BOARD_CONTENT"),
							  rset.getString("MEMBER_ID"),
							  rset.getInt("COUNT"),
							  rset.getDate("CREATE_DATE"),
							  rset.getInt("RECOMMEND"),
							  String.valueOf(rset.getInt("CG_NO")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			// JDBC용 자원 반납
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		// 리턴
		return b;
	}
	
	public Image selectImage(Connection conn, int boardNo) {
		
		// 변수 셋팅
		Image img = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		// 실행할 SQL문
		String sql = prop.getProperty("selectImage");
		
		try {
			// PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			
			// 쿼리문 완성
			pstmt.setInt(1, boardNo);
			
			// 실행 후 결과 받기
			rset = pstmt.executeQuery();
			
			// rset 에 담긴 데이터 담기
			if(rset.next()) {
				
				img = new Image();
				img.setImgNo(rset.getInt("IMG_NO"));
				img.setOriginalName(rset.getString("ORIGINAL_NAME"));
				img.setChangeName(rset.getString("CHANGE_NAME"));
				img.setImgPath(rset.getString("IMG_PATH"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			//JDBC용 자원 반납
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		// 리턴
		return img;
	}
	
	public ArrayList<Integer> selectRecommend(Connection conn, int boardNo, int memberNo) {
		
		// 변수 셋팅
		ArrayList<Integer> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		// SQL문 셋팅
		String sql = prop.getProperty("selectRecommend");
		
		try {
			
			// PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			
			// 쿼리문 완성
			pstmt.setInt(1, memberNo);
			
			// 결과 받기
			rset = pstmt.executeQuery();
			
			
			while(rset.next()) {
				// list 로 가공
				list.add(rset.getInt("BOARD_NO"));
			}
			
			// 이시점에서 추천게시글이 없으면
			// list == null
				
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			// JDBC용 자원 반납
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return list;
	}
	
	public int increaseRecommend(Connection conn, int boardNo, int memberNo) {
		
		// 변수 셋팅
		int result = 0;
		PreparedStatement pstmt = null;
		
		// SQL문 셋팅
		String sql = prop.getProperty("increaseRecommend");
		
		try {
			
			// PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			
			// 쿼리문 완성
			pstmt.setInt(1, boardNo);
			
			// 결과 받기
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			
		}
		return result;
		
	}
	
	public int insertRecommend(Connection conn, int boardNo, int memberNo) {
		
		// 변수셋팅
		int result = 0;
		PreparedStatement pstmt = null;
		
		// SQL 문 셋팅
		String sql = prop.getProperty("insertRecommend");
		
		try {
			// PreparedStatemetn 객체 생성
			pstmt = conn.prepareStatement(sql);
			
			// 쿼리문 완성
			pstmt.setInt(1, boardNo);
			pstmt.setInt(2, memberNo);
			
			// 결과 받기
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			
			// JDBC 용 자원 반납
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}
	
	public int updateBoard(Connection conn, Board b) {
		
		// 변수 셋팅
		int result = 0;
		PreparedStatement pstmt = null;
		
		// 실행할 쿼리문
		String sql = prop.getProperty("updateBoard");
		

		try {
			// PreparedStatment 객체 생성
			pstmt = conn.prepareStatement(sql);
			
			// 쿼리문 완성
			pstmt.setString(1, b.getBoardTitle());
			pstmt.setString(2, b.getBoardContent());
			pstmt.setInt(3, b.getBoardNo());
			
			// 실행 후 결과 받기
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 자원 반납
			JDBCTemplate.close(pstmt);
			
		}
		// 결과 리턴
		return result;
	}
	
	public int updateImage(Connection conn, Image img) {
		
		// 변수 셋팅
		int result = 0;
		PreparedStatement pstmt = null;
		
		// 실행할 sql 문
		String sql = prop.getProperty("updateImage");
		
		try {
			// PreparedStatemnet 객체 생성
			pstmt = conn.prepareStatement(sql);
			
			// SQL문완성
			pstmt.setString(1, img.getOriginalName());
			pstmt.setString(2, img.getChangeName());
			pstmt.setString(3, img.getImgPath());
			pstmt.setInt(4, img.getImgNo());
			
			// 실행 후 결과받기
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 자원반납
			JDBCTemplate.close(pstmt);
			
		}
		
		// 결과 리턴
		return result;
	}
	
	public int insertNewImage(Connection conn, Image img) {
		
		// 변수 셋팅
		int result = 0;
		PreparedStatement pstmt = null;
		
		// 실행할 sql문
		String sql = prop.getProperty("insertNewImage");
		
		try {
			// Preparedstatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			
			// 쿼리문 완성
			pstmt.setInt(1, img.getBoardNo());
			pstmt.setString(2, img.getOriginalName());
			pstmt.setString(3, img.getChangeName());
			pstmt.setString(4, img.getImgPath());
			
			// 실행후 결과 받기
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 자원 반납
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}
	
	public int deleteBoard(Connection conn, int boardNo) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		// SQL문
		String sql = prop.getProperty("deleteBoard");
		
		try {
			// PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			
			// 미완성 쿼리문 완성시키기
			pstmt.setInt(1, boardNo);
			
			// 실행 후 결과 받기
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			// JDBC 용 자원 반납
			JDBCTemplate.close(pstmt);
		}
		
		// 결과 리턴
		return result;
	}
	
	public ArrayList<Reply> selectReplyList(Connection conn, int boardNo) {
		
		// 변수 셋팅
		ArrayList<Reply> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		// 실핼할 SQL문
		String sql = prop.getProperty("selectReplyList");
		
		try {
			// PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			
			// 쿼리문 완성시키기
			pstmt.setInt(1, boardNo);
			
			// 결과 받기
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				list.add(new Reply(rset.getInt("REPLY_NO")
								 , rset.getString("REPLY_CONTENT")
								 , rset.getString("REPLY_DATE")
								 , rset.getString("MEMBER_NO")
								 , rset.getString("MEMBER_ID")));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			// JDBC용 자원 반납
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		// 결과 리턴
		return list;
		
	}
	
	public int insertReply(Connection conn, Reply r) {
		
		// 변수 셋팅
		int result = 0;
		PreparedStatement pstmt=  null;
		
		// SQL문
		String sql = prop.getProperty("insertReply");
		
		try {
			// PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			
			// 쿼리문 완성시키기
			pstmt.setString(1, r.getReplyContent());
			pstmt.setInt(2, r.getBoardNo());
			pstmt.setInt(3, Integer.parseInt(r.getMemberNo()));
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			// JDBC용 자원 반납
			JDBCTemplate.close(pstmt);
		}
		// 결과 리턴
		return result;
		
	}
	
	public int deleteReply(Connection conn, int rno) {
		
		// 변수 셋팅
		int result = 0;
		PreparedStatement pstmt = null;
		
		// SQL문
		String sql = prop.getProperty("deleteReply_1");
		
		try {
			// PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			
			// 미완성 쿼리문 완성
			pstmt.setInt(1, rno);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}
	
	
}
