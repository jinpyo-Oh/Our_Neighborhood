package com.kh.admin.model.dao;

import static com.kh.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.admin.model.vo.Board;
import com.kh.bbq_reservation.model.dao.BbqDao;
import com.kh.bbq_reservation.model.vo.BbqReservation;
import com.kh.car_reservation.model.vo.Car;
import com.kh.common.JDBCTemplate;
import com.kh.member.model.vo.Member;

public class AdminDao {
	
	Properties prop = new Properties();
	
	public AdminDao() {
		String fileName = BbqDao.class.getResource("/sql/admin/admin-mapper.xml").getPath();
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//============차트 관련 ============
	
	public int selectBoardChart(Connection conn, int c){
		
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectBoardChart");
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, c);
			
			rset = pstmt.executeQuery();
			if(rset.next()) {
				
				result = rset.getInt("COUNT(*)");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	//============ 현황 관련 ============

	public int countMemberAll(Connection conn) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("countMemberAll");
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				result = rset.getInt("COUNT(MEMBER_NO)");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int countMemberMonth(Connection conn) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("countMemberMonth");
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				result = rset.getInt("COUNT(MEMBER_NO)");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	public int countBoardAll(Connection conn) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("countBoardAll");
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				result = rset.getInt("COUNT(BOARD_NO)");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	public int countBoardMonth(Connection conn) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("countBoardMonth");
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				result = rset.getInt("COUNT(BOARD_NO)");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
			JDBCTemplate.close(pstmt);
		}
		return result;
	}


	//============ 게시글 관련 ============

	public ArrayList<Board> selectBoardAllList(Connection conn){
		
		ArrayList<Board> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectBoardAllList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				list.add(new Board(rset.getInt("BOARD_NO"),
								   rset.getString("BOARD_TITLE"),
								   rset.getString("BOARD_CONTENT"),
								   rset.getDate("CREATE_DATE"),
								   rset.getInt("COUNT"),
								   rset.getString("MEMBER_NAME"),
								   rset.getInt("CG_NO")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
		
	}
	
	public ArrayList<Board> selectBoardList(Connection conn, int cgNo){
		
		ArrayList<Board> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectBoardList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, cgNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				list.add(new Board(rset.getInt("BOARD_NO"),
								   rset.getString("BOARD_TITLE"),
								   rset.getString("BOARD_CONTENT"),
								   rset.getDate("CREATE_DATE"),
								   rset.getInt("COUNT"),
								   rset.getString("MEMBER_NAME"),
								   rset.getInt("CG_NO")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
		
	}
	
	public Board selectBoard(Connection conn, int boardNo){
		
		Board b = new Board();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectBoard");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, boardNo);
			
			rset = pstmt.executeQuery();

			if(rset.next()) {
				
				b = new Board(rset.getInt("BOARD_NO"),
							  rset.getDate("CREATE_DATE"),
							  rset.getInt("COUNT"),
							  rset.getInt("CG_NO"),
							  rset.getInt("RECOMMEND"),
							  rset.getString("MEMBER_ID"),
							  rset.getString("BOARD_TITLE"),
							  rset.getString("BOARD_CONTENT"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return b;
		
	}
	
	
	public int BoardCheckDelete(Connection conn, int i) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("BoardCheckDelete");
		
		try {
			pstmt = conn.prepareStatement(sql); 
			pstmt.setInt(1,i);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
		
	}

	

	//============ 회원관련 ============

	public ArrayList<Member> selectMemberList(Connection conn){
		
		ArrayList<Member> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectMemberList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			 
			while(rset.next()) {
				
				list.add(new Member(rset.getInt("MEMBER_NO"),
									rset.getString("MEMBER_ID"),
									rset.getString("MEMBER_NAME"),
									rset.getString("MEMBER_ADDRESS"),
									rset.getInt("MEMBER_ADDRESS2"),
									rset.getString("MEMBER_EMAIL"),
									rset.getString("MEMBER_PHONE"),
									rset.getDate("MEMBER_ENROLLDATE")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	public Member selectMember(Connection conn, int memberNo) {
		
		Member m = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, memberNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				
				m = new Member(rset.getInt("MEMBER_NO"),
						rset.getString("MEMBER_ID"),
						rset.getString("MEMBER_PWD"),
						rset.getString("MEMBER_NAME"),
						rset.getString("MEMBER_ADDRESS"),
						rset.getInt("MEMBER_ADDRESS2"),
						rset.getString("MEMBER_EMAIL"),
						rset.getString("MEMBER_PHONE"),
						rset.getDate("MEMBER_ENROLLDATE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return m;
	}
	
	public int updateMember(Connection conn, Member m) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateMember");
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, m.getMemberId());
			pstmt.setString(2, m.getMemberPwd());
			pstmt.setString(3, m.getMemberName());
			pstmt.setString(4, m.getAddress());
			pstmt.setInt(5, m.getAddress2());
			pstmt.setString(6, m.getEmail());
			pstmt.setString(7, m.getPhone());
			pstmt.setInt(8, m.getMemberNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	public int deleteMember(Connection conn, int memberNo) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deleteMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, memberNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}





	//============ bbq관련 ============

	public ArrayList<BbqReservation> adminBbqResSelect(Connection conn, String today){
		
		ArrayList<BbqReservation> list = new ArrayList<>();
		BbqReservation bbq = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("adminBbqResSelect");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, today);
			
			rset=pstmt.executeQuery();
			
			while(rset.next()) {
				bbq = new BbqReservation(
						rset.getInt("RES_NO"),
						rset.getInt("RES_PLACE"),
						rset.getString("RES_DATE"),
						rset.getInt("RES_PEOPLE"),
						rset.getString("RES_NAME"),
						rset.getString("RES_MSG")																		 						
						);
				
				list.add(bbq);
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(rset);
			close(pstmt);
		}
		
		return list;				
	}
	
public ArrayList<BbqReservation> adminBbqResSelectAll(Connection conn){
		
		ArrayList<BbqReservation> list = new ArrayList<>();
		BbqReservation bbq = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("adminBbqResSelectAll");
		
		try {
			pstmt = conn.prepareStatement(sql);						
			rset=pstmt.executeQuery();
			
			while(rset.next()) {
				bbq = new BbqReservation(
						rset.getInt("RES_NO"),
						rset.getInt("RES_PLACE"),
						rset.getString("RES_DATE"),
						rset.getInt("RES_PEOPLE"),
						rset.getString("RES_NAME"),
						rset.getString("RES_MSG")																		 						
						);
				
				list.add(bbq);
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(rset);
			close(pstmt);
		}
		
		return list;				
	}

public int adminBbqResDelete(Connection conn, int i) {
	
	int result = 0;
	PreparedStatement pstmt = null;
	String sql = prop.getProperty("adminBbqResDelete");
	
	try {
		pstmt = conn.prepareStatement(sql); 
		pstmt.setInt(1,i);
		
		result = pstmt.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		close(pstmt);
	}
	return result;
	
}

//========== 차량 관련==========
	public ArrayList<Car> selectCarList(Connection conn){
		

		ArrayList<Car> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectCarList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				list.add(new Car(rset.getInt("CAR_NO"),
								 rset.getString("CAR_RES_NO"),
								 rset.getString("CAR_TYPE"),
								 rset.getString("CAR_OWNER"),
								 rset.getInt("MEMBER_NO")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
		
	}

	public int CarCheckDelete(Connection conn, int i) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("CarCheckDelete");
		
		try {
			pstmt = conn.prepareStatement(sql); 
			pstmt.setInt(1,i);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
		
	}
	
	public int insertCar(Connection conn, Car c) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertCar");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, c.getCarResNo());
			pstmt.setString(2, c.getCarType());
			pstmt.setString(3, c.getCarOwner());
			pstmt.setInt(4, c.getMemberNo());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	public ArrayList<Car> selectCar(Connection conn, int memberNo) {
		
		// 변수 생성
		ArrayList<Car> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		// SQL문
		String sql = prop.getProperty("selectCar");
		
		try {
			// PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			
			// 쿼리문 완성
			pstmt.setInt(1, memberNo);
			
			// 결과 받기
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				list.add(new Car(rset.getString("CAR_RES_NO"),
							  rset.getString("CAR_TYPE"),
							  rset.getString("CAR_OWNER")));
			}
			// 이 시점에서 차가없으면 c == null
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}





}
