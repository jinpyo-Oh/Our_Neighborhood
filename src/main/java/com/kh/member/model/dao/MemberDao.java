package com.kh.member.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.board.board_1.model.vo.Board;
import com.kh.common.JDBCTemplate;
import com.kh.common.model.vo.PageInfo;
import com.kh.member.model.vo.Cost;
import com.kh.member.model.vo.Member;

public class MemberDao {

	private Properties prop = new Properties();

	public MemberDao() {
		
		String fileName = MemberDao.class.getResource("/sql/member/member-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Member loginMember(Connection conn, Member m) {
		Member loginUser = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("loginMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, m.getMemberId());
			pstmt.setString(2, m.getMemberPwd());
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				
				loginUser = new Member(rset.getInt("MEMBER_NO"),
									   rset.getString("MEMBER_ID"),
									   rset.getString("MEMBER_PWD"),
									   rset.getString("MEMBER_NAME"),
									   
									   rset.getString("MEMBER_ADDRESS"),
									   rset.getInt("MEMBER_ADDRESS2"),
									   rset.getString("MEMBER_EMAIL"),
									   rset.getString("MEMBER_PHONE"),
									   rset.getString("MEMBER_STATUS"),
									   rset.getDate("MEMBER_ENROLLDATE")
									   );
									   }
			
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return loginUser;
		
	}

	
	
	public int insertMember(Connection conn, Member m) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, m.getMemberId());
			pstmt.setString(2, m.getMemberPwd());
			pstmt.setString(3, m.getMemberName());
			pstmt.setString(4, m.getAddress());
			pstmt.setInt(5, m.getAddress2());
			pstmt.setString(6, m.getEmail());
			pstmt.setString(7, m.getPhone());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			JDBCTemplate.close(pstmt);
		}
			return result;
		}
	
 
	
	public int updateMember(Connection conn, Member m) {
	    int result = 0;
	    PreparedStatement pstmt = null;
	    
	    String sql = prop.getProperty("updateMember");
	    
	    try {
	        pstmt = conn.prepareStatement(sql);

	        pstmt.setString(1, m.getMemberPwd());	        
	        pstmt.setString(2, m.getMemberName());
	        pstmt.setString(3, m.getEmail());
	        pstmt.setString(4, m.getPhone());
	        pstmt.setString(5, m.getMemberId());
	        
	        result = pstmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        JDBCTemplate.close(pstmt);
	    }
	    
	    return result;
	}
	

	
	public int updatePwdMember(Connection conn, String memberId, String memberPwd) {
		  
		int result = 0;
	   
		PreparedStatement pstmt = null;

	    String sql = prop.getProperty("updatePwdMember");

	    try {
	        pstmt = conn.prepareStatement(sql);

	        pstmt.setString(1, memberPwd);
	        pstmt.setString(2, memberId);

	        result = pstmt.executeUpdate();

	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        
	    	JDBCTemplate.close(pstmt);
	    }

	    return result;
	}
	
	

	public Member selectMember(Connection conn, String memberId) {
		
		Member updateMem = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, memberId);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				
				updateMem = new Member();
				updateMem.setMemberNo(rset.getInt("MEMBER_NO"));
				updateMem.setMemberId(rset.getString("MEMBER_ID"));
				updateMem.setMemberPwd(rset.getString("MEMBER_PWD"));
				updateMem.setMemberName(rset.getString("MEMBER_NAME"));
				updateMem.setPhone(rset.getString("MEMBER_PHONE"));
				updateMem.setEmail(rset.getString("MEMBER_EMAIL"));
				updateMem.setAddress(rset.getString("MEMBER_ADDRESS"));
				updateMem.setAddress2(rset.getInt("MEMBER_ADDRESS2"));
				updateMem.setStatus(rset.getString("MEMBER_STATUS"));
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		// Service 로 결과 리턴
		return updateMem;
	}

	
	
	public int deleteMember(Connection conn, Member m) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deleteMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
		
			pstmt.setString(1, m.getMemberId());
			pstmt.setString(2, m.getMemberPwd());
			
			result = pstmt.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}
	
	
	
	
	public int idCheck(Connection conn, String checkId) {
		
		int count = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("idCheck");
		
		try {
			pstmt = conn.prepareStatement(sql);
		
			pstmt.setString(1, checkId);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				
				count = rset.getInt("COUNT(*)");
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return count;
	}
	
	
	
	public String findId(Connection conn, Member m) {
		
		String foundId = "";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("findId");
		
		try {
			
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, m.getMemberName());
			pstmt.setInt(2, m.getAddress2());
			pstmt.setString(3, m.getAddress());
			pstmt.setString(4, m.getPhone());
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				
				foundId = rset.getString("MEMBER_ID");
				
			}
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		
		} finally {
			
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
			
		}
		
		return foundId;
		
	}
	
	
	public String findPwd(Connection conn, Member m) {
		
		String foundPwd = "";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("findPwd");
		
		try {
			
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, m.getMemberId());
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				
				foundPwd = rset.getString("MEMBER_PWD");
				
			}
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		
		} finally {
			
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
			
		}
		
		return foundPwd;
		
	}
	
	public Cost selectCost(Connection conn, String month, int memberNo) {
	
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectCost");
		Cost cost = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,month);
			pstmt.setInt(2, memberNo);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				cost = new Cost(
						rset.getString("COST_DATE"),
						rset.getInt("COMMON_BILL"),
						rset.getInt("ELECTRICITY_BILL"),
						rset.getInt("WATER_BILL"),
						rset.getInt("HEATING_BILL")
						);
				
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return cost;		
	}
	
<<<<<<< HEAD
	public ArrayList<Board> wroteList(Connection conn, int memberNo,PageInfo pi){
=======
	public ArrayList<Board> wroteList(Connection conn, int memberNo){
>>>>>>> 9b89578e342d56ee19ead93eafe361e9ea685d52
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("wroteList");
		ArrayList<Board> list = new ArrayList<>();
		Board b = null;
		
<<<<<<< HEAD
		// 쿼리문 완성
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow  + pi.getBoardLimit() - 1;
			

			pstmt.setInt(1,memberNo);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
=======
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,memberNo);
>>>>>>> 9b89578e342d56ee19ead93eafe361e9ea685d52
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				b = new Board(
						rset.getInt("BOARD_NO"),
						rset.getString("CG_NAME"),
						rset.getString("BOARD_TITLE"),
						rset.getString("MEMBER_ID"),
						rset.getInt("COUNT"),
						rset.getInt("RECOMMEND"),
						rset.getDate("CREATE_DATE")										
						);
				list.add(b);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return list;
				
		
		
	
		
		
	}
	
}	
	


