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




	//============ 게시글 관련 ============

	public ArrayList<Board> selectBoardList(Connection conn){
		
		ArrayList<Board> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectBoardList");
		
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
								   rset.getString("CG_NAME")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		System.out.println(list);
		return list;
		
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





}
