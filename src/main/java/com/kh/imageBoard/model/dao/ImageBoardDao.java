package com.kh.imageBoard.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.imageBoard.model.vo.Category;
import com.kh.board.board_1.model.vo.Reply;
import com.kh.common.JDBCTemplate;
import com.kh.common.model.vo.PageInfo;
import com.kh.imageBoard.model.vo.Board;
import com.kh.imageBoard.model.vo.Image;

public class ImageBoardDao {


	// 쿼리문들을 키 + 밸류 세트로 담는 Properties 객체 생성(전역)
	private Properties prop = new Properties();
	
	// 선행 코드들을 정의해둔 기본생성자

	
	public ImageBoardDao() {
		
		String fileName = ImageBoardDao.class.getResource("/sql/imageBoard/image-board-mapper.xml").getPath();
	
		try {
			prop.loadFromXML(new FileInputStream(fileName));
			
			
		} catch(IOException e) {
			
			e.printStackTrace();
		}
	
	
	
	
	}
	
	
	
public int selectListCount(Connection conn) {
		
		// SELECT문 => ResultSet 객체 => int
		
		// 필요한 변수들 먼저 세팅
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		// 실행할 SQL문
		String sql = prop.getProperty("selectListCount");
		
		try {
			// PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			
			// SQL문 실행 후 결과 받기
			// Select문 : executeQuery 메소드
			rset = pstmt.executeQuery();
			
			// rset으로부터 조회된 결과를 뽑기
			// COUNT라는 그룹함수를 이용했기 때문에
			// 단일행 조회임 (n개 행 -> 1개 행)
			if(rset.next()) {
				
				listCount = rset.getInt("COUNT");
				// 별칭을 제시해서 뽑음
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			// JDBC용 자원 반납(역순)
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		// Service 단으로 결과 리턴
		return listCount;

	}


public ArrayList<Board> selectList(Connection conn, PageInfo pi, String cgNo) {
	
	// SELECT문 => ResultSet 객체
	// => ArrayList<Board>
	
	// 필요한 변수들 먼저 셋팅
	ArrayList<Board> list = new ArrayList<>();
	PreparedStatement pstmt = null;
	ResultSet rset = null;
	
	// 실행할 SQL문
	String sql = prop.getProperty("selectList");
	
	try {
		// PrepareStatement 객체 생성
		pstmt = conn.prepareStatement(sql);
		
		// 미완성된 SQL문 완성시키기
		/*
		 * boardLimit가 10이라고 가정 하에
		 * currentPage = 1 => 시작값 1, 끝값 10
		 * currentPage = 2 => 시작값 11, 끝값 20
		 * currentPage = 3 => 시작값 21, 끝값 30
		 * ...
		 * => 페이징처리의 핵심은 구간별로 끊어서 필요한것만 조회해오는 것
		 * 
 * 시작값 = (currentPage - 1) * boardLimit + 1
		 * 끝값 = 시작값 + boardLimit - 1
		 */
		int startRow = (pi.getCurrentPage() - 1) 
					  * pi.getBoardLimit() + 1;
		int endRow = startRow 
					 + pi.getBoardLimit() - 1;
		
		pstmt.setInt(1, Integer.parseInt(cgNo));
		pstmt.setInt(2, startRow);
		pstmt.setInt(3, endRow);
		
		// SQL문 실행 후 결과 받기
		// select문 : executeQuery 메소드
		rset = pstmt.executeQuery();
		
		// rset 으로부터 조회된 데이터를 뽑아서 
		// VO 로 가공 후 ArrayList 에 차곡차곡 담기
		while(rset.next()) {
			
			list.add(new Board(rset.getInt("BOARD_NO"),
							   rset.getString("BOARD_TITLE"),
							   rset.getInt("COUNT"),
							   rset.getString("TITLEIMG"),
							   rset.getString("CG_NO"),
							   rset.getInt("RECOMMEND"),
							   rset.getDate("CREATE_DATE"),
							   rset.getString("MEMBER_ID")));
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		
		// JDBC용 자원 반납 (역순)
		JDBCTemplate.close(rset);
		JDBCTemplate.close(pstmt);
	}
	
	// Service 단으로 결과 반환
	return list;
}

	
	public int insertImageBoard(Connection conn, Board b, String cgNo) {
		
		// INSERT 문 => 처리된 행의 개수 (int)
		
		// 필요한 변수 먼저 세팅
		int result = 0;
		PreparedStatement pstmt= null;
		
		// 실행할 SQL문
		String sql = prop.getProperty("insertImageBoard");
		
		try {
			// PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			
			// 미완성된 쿼리문 완성하기
					
			pstmt.setString(1, b.getBoardTitle());
			pstmt.setString(2, b.getBoardContent());
			pstmt.setString(3, b.getMemberNo());
			pstmt.setInt(4, Integer.parseInt(cgNo));
			
			// 쿼리문 실행 후 결과 받기
			// insert문 : executeUpdate 메소드
			result = pstmt.executeUpdate();
			
		} catch(SQLException e) {
			
			e.printStackTrace();
			
		} finally {
			
			// JDBC용 자원 반납
			JDBCTemplate.close(pstmt);
		
		}
		return result;
	}

	public int insertAttachmentList(Connection conn, ArrayList<Image> list) {
		
		// INSERT문 여러번 => 각각 처리된 행의 개수 (int)
		
		// 필요한 변수 먼저 세팅
		int result = 1;
		// insert를 반복해서 진행 => 하나라도 실패할 경우 실패처리
		// result를 애초에 1로 세팅해두고 누적 곱을 구할 생각
		PreparedStatement pstmt = null;
		
		// 실행할 SQL문
		String sql = prop.getProperty("insertImageList");
		
		try {
			for(Image ig : list) {
				
				// PreparedStatement 객체 생성
				pstmt = conn.prepareStatement(sql);
				
				// 미완성된 쿼리문 완성하기
				pstmt.setString(1, ig.getOriginalName());
				pstmt.setString(2, ig.getChangeName());
				pstmt.setString(3, ig.getImgPath());
				pstmt.setInt(4, ig.getImgLevel());
				
				// 쿼리문 실행 후 결과 받기
				// insert문 : executeUpdate 메소드
				result *= pstmt.executeUpdate();
				// 누적 곱 구하기
				// 하나라도 insert에 실패하면 result == 0
				
			}
			
			// 이 시점 기준으로 모두 성공했을 경우 result == 1
		
		} catch(SQLException e) {
			
			
		} finally {
			
			// JDBC용 자원 반납
			JDBCTemplate.close(pstmt);
			
		}
		// Service 단으로 결과 리턴
		return result;
	
	}



	/**
	 * 조회수 증가용 요청
	 */
	public int increaseCount(Connection conn, int boardNo) {
	
		// UPDATE문 => 처리된 행의 개수(int)
		
		// 필요한 변수들 세팅
		int result = 0;
		PreparedStatement pstmt = null;
		
		// 실행할 SQL문 세팅
		String sql = prop.getProperty("increaseCount");
		
		try {
			// PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			
			// 미완성된 쿼리문 완성시키기
			pstmt.setInt(1, boardNo);
			
			// 쿼리문 실행 후 결과 받기
			result = pstmt.executeUpdate();
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			
			// JDBC용 자원 반납
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}



	/**
	 * 게시글 조회
	 */
	public Board selectBoard(Connection conn, int boardNo, int cgNo) {
		
		// SELECT문 = > ResultSet 객체
		// 단일행 조회 (Board 객체)
		
		// 필요한 변수 먼저 세팅
		Board b = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		// 실행할 SQL문
		String sql = prop.getProperty("selectBoard");
		
		try {
			// PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			
			// 미완성된 쿼리문 완성시키기
			pstmt.setInt(1, boardNo);
			pstmt.setInt(2, cgNo);
			pstmt.setString(3, "Y");
			
			// 쿼리문 실행 후 결과 받기
			// select문 : executeQuery 메소드
			rset = pstmt.executeQuery();
			
			// rset에 담긴 데이터를 VO로 가공
			if(rset.next()) {
				
				b = new Board(rset.getInt("BOARD_NO")
							, rset.getString("CG_NAME")
							, rset.getString("BOARD_TITLE")
							, rset.getString("BOARD_CONTENT")
							, rset.getInt("COUNT")
							, rset.getInt("RECOMMEND")
							, rset.getString("MEMBER_ID")
							, rset.getString("MEMBER_NO")
							, rset.getDate("CREATE_DATE"));
				
			}
			
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
		
		
		// JDBC 용 자원 반납
		JDBCTemplate.close(rset);
		JDBCTemplate.close(pstmt);
		
		}
		
		return b;
	}



	/**
	 * 첨부파일 조회
	 */
	public ArrayList<Image> selectImageList(Connection conn, int boardNo) {
		
		// SELECT문 => ResultSet 객체
		// => 단일행 조회 (Image 객체)
		
		// 필요한 변수 먼저 세팅
		ArrayList<Image> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		// 실행할 SQL문
		String sql = prop.getProperty("selectImageList");
		
		try {
			// PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			
			// 미완성된 쿼리문 완성
			pstmt.setInt(1, boardNo);
			
			// 쿼리문 실행 후 결과 받기
			// select문 : executeQuery 메소드
			rset = pstmt.executeQuery();
			
			// rset으로부터 조회된 데이터를 뽑아서 VO로 가공 후
			// ArrayList에 차곡차곡 담기
			while(rset.next()) {
				
				list.add(new Image(rset.getInt("IMG_NO")
						, rset.getString("ORIGINAL_NAME")
						, rset.getString("CHANGE_NAME")
						, rset.getInt("IMG_LEVEL")
						, rset.getString("IMG_PATH")));
			}
			
			// 조회된 데이터가 있다면
			// list에는 최소 1개 최대 5개까지 Image 객체가 담겨 있음
			
			
		} catch (SQLException e) {
			
			
			e.printStackTrace();
		} finally {
			
			// JDBC 용 자원 반납
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		// Service단으로 결과 리턴
		
				
		
		return list;
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
			
			// 결과받기
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				// list로 가공
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
			pstmt.setInt(1,  boardNo);
			
			// 결과 받기
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {


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
		
		// SQL문 셋팅
		String sql = prop.getProperty("insertRecommend");
		
		try {
			// PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			
			// 쿼리문 완성
			pstmt.setInt(1, boardNo);
			pstmt.setInt(2, memberNo);
			
			// 결과 받기
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {


			e.printStackTrace();
		} finally {
			
			// JDBC용 자원 반납
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}



	public int updateLost(Connection conn, Board b) {

		// UPDATE문 => 처리된 행의 개수 (int)
		
		// 필요한 변수 먼저 세팅
		int result = 0;
		PreparedStatement pstmt = null;
		
		// 실행할 쿼리문
		String sql = prop.getProperty("updateLost");
		
		try {
			// PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			
			// 미완성된 쿼리문 완성시키기
			pstmt.setString(1, b.getBoardTitle());
			pstmt.setString(2, b.getBoardContent());
			pstmt.setInt(3, b.getBoardNo());
			
			// 쿼리문 실행 후 결과 받기
			// update문 : executeUpdate 메소드
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			
			// JDBC용 자원 반납
			JDBCTemplate.close(pstmt);
		
		}
		
		return result;
	}



	public int updateImage(Connection conn, Image im) {

		// UPDATE문 => 처리된 행의 개수(int)
		
		// 필요한 변수 먼저 세팅
		int result = 0;
		PreparedStatement pstmt = null;
		
		// 실행할 sql문
		String sql = prop.getProperty("updateImage");
		
		try {
			// PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
		
			// 미완성된 쿼리문 완성하기
			pstmt.setString(1, im.getOriginalName());
			pstmt.setString(2, im.getChangeName());
			pstmt.setString(3, im.getImgPath());
			pstmt.setInt(4, im.getImgNo());
			
			// 쿼리문 실행 후 결과 받기
			// update문 : executeUpdate 메소드
			result = pstmt.executeUpdate();
		
		
		
		} catch (SQLException e) {

			
			e.printStackTrace();
		} finally {
			
			// JDBC용 자원 반납
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}



	public int insertNewImage(Connection conn, Image im) {

		// INSERT문 -> 처리된 행의 개수 (int)
		
		// 필요한 변수 먼저 세팅
		int result = 0;
		PreparedStatement pstmt = null;
		
		// 실행할 sql문
		String sql = prop.getProperty("insertNewImage");
		
		try {
			// PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			
			// 미완성된 쿼리문 완성하기
			pstmt.setInt(1, im.getBoardNo());
			pstmt.setString(2, im.getOriginalName());
			pstmt.setString(3, im.getChangeName());
			pstmt.setString(4, im.getImgPath());
			
			// 쿼리문 실행 후 결과 받기
			// insert문 : executeUpdate 메소드
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			// JDBC 용 자원 반납
			JDBCTemplate.close(pstmt);
		}
		
		// Service 단으로 결과 리턴
		return result;
	}



	/**
	 * 카테고리 정보 불러오기
	 */
	public ArrayList<Category> selectCategoryList(Connection conn) {

		// SELECT 문 => ResultSet 객체 => ArrayList<Category> 객체 (여러행)
		
		// 필요한 변수들 먼저 세팅
		ArrayList<Category> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		// 실행할 SQL문
		String sql = prop.getProperty("selectCategoryList");
		
		try {
			// PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			
			// 미완성된 SQL문 완성
			// => 완성된 쿼리문이므로 패스
			
			// SQL문 실행 후 결과 받기
			// select문 :  executeQuery 메소드
			rset = pstmt.executeQuery();
			
			// rset 으로부터 조회된 데이터들을 뽑아서
			// VO 에 차곡차곡 담기
			while(rset.next()) {
					list.add(new Category(rset.getInt("CG_NO"),
							rset.getString("CG_NAME")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			// 다 쓴 JDBC 용 객체 반납(역순)
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		
		// Service 단으로 결과 리턴
		return list;
	}



	/**
	 * 첨부파일 수정
	 */
	public Image selectAttachment(Connection conn, int boardNo) {

		// SELECT 문 => ResultSet 객체
				// => 단일행 조회 (Attachment 객체)
				
				// 필요한 변수 먼저 세팅
				Image im = null;
				PreparedStatement pstmt = null;
				ResultSet rset = null;
				
				// 실행할 SQL 문
				String sql = prop.getProperty("selectAttachment");
				
				try {
					// PreparedStatement 객체 생성
					pstmt = conn.prepareStatement(sql);
					
					// 미완성된 쿼리문 완성
					pstmt.setInt(1, boardNo);
					
					// 쿼리문 실행 후 결과 받기
					// select문 : executeQuery 메소드
					rset = pstmt.executeQuery();
					
					// rset 에 담긴 데이터를 VO 로 담기
					if(rset.next()) {
						
						im = new Image();
						
						im.setImgNo(rset.getInt("IMG_NO"));
						im.setOriginalName(rset.getString("ORIGINAL_NAME"));
						im.setChangeName(rset.getString("CHANGE_NAME"));
						im.setImgPath(rset.getString("IMG_PATH"));
					}
					
					// 이 시점 기준으로
					// 해당 게시글에 딸린 첨부파일이 없었다면
					// im == null
					
					
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					
					// JDBC 용 자원 반납
					JDBCTemplate.close(rset);
					JDBCTemplate.close(pstmt);
				}
				
				// Service 단으로 결과 리턴
				
				return im;
			}



	public int updateBoard(Connection conn, Board b) {
		
	// UPDATE문 => 처리된 행의 개수 (int)
		
		// 필요한 변수 먼저 세팅
		int result = 0;
		PreparedStatement pstmt = null;
		
		// 실행할 쿼리문
		String sql = prop.getProperty("updateBoard");
		
		try {
			// PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			
			// 미완성된 쿼리문 완성시키기

			pstmt.setString(1, b.getBoardTitle());
			pstmt.setString(2, b.getBoardContent());
			pstmt.setInt(3, b.getBoardNo());
			
			// 쿼리문 실행 후 결과 받기
			// update문 : executeUpdate 메소드
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} finally { 
			
			// JDBC 용 자원 반납
			JDBCTemplate.close(pstmt);
		}
		
		// Service 단으로 결과 리턴
		return result;
	}

	public int updatedeleteList(Connection conn, ArrayList<Image> list, Board b) {

		// UPDATE 문 => 처리된 행의 갯수 (int)
		
		// 필요한 변수 먼저 셋팅
		int result = 0;
		PreparedStatement pstmt = null;
		
		// 실행할 SQL문
		String sql = prop.getProperty("updatedeleteList");
		
		try {
			
			// PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			
			// 미완성된 쿼리문 완성시키기
			pstmt.setInt(1, b.getBoardNo());

			// 쿼리문 실행 후 결과 받기
			// update문 : executeUpdate 메소드
			result = pstmt.executeUpdate();
		
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} finally {
			
			// JDBC 용 자원 반납
			JDBCTemplate.close(pstmt);
		}
		
		// Service 단으로 결과 리턴
		return result;
	}


	public int updateAttachmentList(Connection conn, ArrayList<Image> list, Board b) {
	
				// INSERT문 여러번 => 각각 처리된 행의 개수 (int)
		
				// 필요한 변수 먼저 세팅
				int result = 1;
				// insert를 반복해서 진행 => 하나라도 실패할 경우 실패처리
				// result를 애초에 1로 세팅해두고 누적 곱을 구할 생각
				PreparedStatement pstmt = null;
				
				// 실행할 SQL문
				String sql = prop.getProperty("updateAttachmentList");
				
				try {
					for(Image img : list) {
						
						// PreparedStatement 객체 생성
						pstmt = conn.prepareStatement(sql);
						
						// 미완성된 쿼리문 완성하기
						pstmt.setString(2, img.getOriginalName());
						pstmt.setString(3, img.getChangeName());
						pstmt.setString(4, img.getImgPath());
						pstmt.setInt(5, img.getImgLevel());
						pstmt.setInt(1, img.getBoardNo());
						
						// 쿼리문 실행 후 결과 받기
						// insert문 : executeUpdate 메소드
						result *= pstmt.executeUpdate();
						// 누적 곱 구하기
						// 하나라도 insert에 실패하면 result == 0
						
		
			        			
		        		}
						
					
					
					// 이 시점 기준으로 모두 성공했을 경우 result == 1
				
				} catch(SQLException e) {
					
					
				} finally {
					
					// JDBC용 자원 반납
					JDBCTemplate.close(pstmt);
					
				}
				System.out.println(list);
				
				
				// Service 단으로 결과 리턴
				return result;
			
			
	}



	public int deleteBoard(Connection conn, int boardNo) {
		
		// UPDATE 문 => 처리된 행의 갯수 (int)
		
		// 필요한 변수 먼저 셋팅
		int result = 0;
		PreparedStatement pstmt = null;
		
		// 실행할 SQL문
		String sql = prop.getProperty("deleteBoard");
		
		try {
			
			// PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			
			// 미완성된 쿼리문 완성시키기
			pstmt.setInt(1, boardNo);
		
			// 쿼리문 실행 후 결과 받기
			// update문 : executeUpdate 메소드
			result = pstmt.executeUpdate();
		
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} finally {
			
			// JDBC 용 자원 반납
			JDBCTemplate.close(pstmt);
		}
		
		// Service 단으로 결과 리턴
		return result;
	}



	public int insertReply(Connection conn, Reply r) {
		
				// INSERT 문 => 처리된 행의 갯수 (int)
		
				// 필요한 변수들 먼저 셋팅
				int result = 0;
				PreparedStatement pstmt = null;
				
				// 실행할 SQL문
				String sql = prop.getProperty("insertReply");
				
				try {
					
					// PreparedStatement 객체 생성
					pstmt = conn.prepareStatement(sql);
					
					// 미완성된 쿼리문 완성시키기
					pstmt.setString(1, r.getReplyContent());
					pstmt.setInt(2, r.getBoardNo());
					pstmt.setInt(3, Integer.parseInt(r.getMemberNo()));
					
					// 쿼리문 실행 후 결과 받기
					// insert문 : executeUpdate 메소드
					result = pstmt.executeUpdate();
					
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					
					// JDBC 용 자원 반납
					JDBCTemplate.close(pstmt);
				}
				
				// Service 단으로 결과 리턴
				return result;
			}



	public ArrayList<Reply> selectReplyList(Connection conn, int boardNo) {
		
		// SELECT 문 => ResultSet 객체
				// => 여러행 조회 (ArrayList)
				
				// 필요한 변수 먼저 셋팅
				ArrayList<Reply> list = new ArrayList<>();
				PreparedStatement pstmt = null;
				ResultSet rset = null;
				
				// 실행할 쿼리문
				String sql = prop.getProperty("selectReplyList");
				
				try {
					
					// PreparedStatement 객체 생성
					pstmt = conn.prepareStatement(sql);
				
					// 미완성된 SQL문 완성시키기
					pstmt.setInt(1, boardNo);
					
					// 쿼리문 실행 후 결과 받기
					// select문 : executeQuery 메소드
					rset = pstmt.executeQuery();
					
					// rset 으로부터 데이터를 뽑아서 VO 로 가공
					while(rset.next()) {
						
						list.add(new Reply(rset.getInt("REPLY_NO")
								 , rset.getString("REPLY_CONTENT")
								 , rset.getString("MEMBER_ID")
								 , rset.getString("CREATE_DATE")));
					}
					
					// 이 시점 기준으로
					// 조회된 댓글이 단 하나라도 있다면
					// list.isEmpty() == false
				
				} catch (SQLException e) {
					
					e.printStackTrace();
					
				} finally {
					
					// JDBC 용 자원 반납 (역순)
					JDBCTemplate.close(rset);
					JDBCTemplate.close(pstmt);
					
				}
				
				// Service 단으로 결과 리턴
				return list;
			}



	public int deleteReply(Connection conn, int rno) {
		
		
		// 변수 셋팅
		int result = 0;
		PreparedStatement pstmt = null;
		
		// SQL문
		String sql = prop.getProperty("deleteReply_lost");
		
		try {
			// PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			
			// 미완성 쿼리문 완성
			pstmt.setInt(1, rno);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			
			
			e.printStackTrace();
			
		} finally {
			
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}



	



	

}
