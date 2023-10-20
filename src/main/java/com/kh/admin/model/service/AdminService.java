package com.kh.admin.model.service;

import static com.kh.common.JDBCTemplate.*;
import static com.kh.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.admin.model.dao.AdminDao;
import com.kh.admin.model.vo.Board;
import com.kh.bbq_reservation.model.vo.BbqReservation;
import com.kh.member.model.vo.Member;

public class AdminService {
	
	// ==========게시글 관련==========

	public ArrayList<Board> selectBoardList(){
			
			Connection conn = getConnection();
			
			ArrayList<Board> list = new AdminDao().selectBoardList(conn);		
			
			close(conn);
			
			return list;
		}

	// ==========차트 관련==========

	public int selectBoardChart(int chart) {
		
		Connection conn = getConnection();
		
		int c = new AdminDao().selectBoardChart(conn, chart);
		
		close(conn);
		
		return c;
		
	}

	// ==========회원 관련==========

	public ArrayList<Member> selectMemberList(){
		
		Connection conn = getConnection();
		
		ArrayList<Member> list = new AdminDao().selectMemberList(conn);
		
		close(conn);
		
		return list;
	}
	
	public Member selectMember(int memberNo) {
		
		Connection conn = getConnection();
		
		Member m  = new AdminDao().selectMember(conn, memberNo);
		
		close(conn);
		
		return m;
	}
	
	public Member updateMember(Member m) {
		
		Connection conn = getConnection();
		
		int result = new AdminDao().updateMember(conn, m);
		
		Member updateMem = null;
		
		if(result > 0) {
			
			commit(conn);
			
			updateMem = new AdminDao().selectMember(conn, m.getMemberNo());
			
		} else {
			
			rollback(conn);
		}
		
		close(conn);
		
		return updateMem;
	}
	
	public int deleteMember(int memberNo) {
		
		Connection conn = getConnection();
		
		int result = new AdminDao().deleteMember(conn, memberNo);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return memberNo;
	}


	// ==========bbq 관련==========

	public ArrayList<BbqReservation> adminBbqResSelect(String today){
		Connection conn = getConnection();
		
		ArrayList<BbqReservation> list = new AdminDao().adminBbqResSelect(conn,today);
		
		close(conn);
		return list;
				
				
	}
	
	public ArrayList<BbqReservation> adminBbqResSelectAll(){
		Connection conn = getConnection();
		
		ArrayList<BbqReservation> list = new AdminDao().adminBbqResSelectAll(conn);
		
		close(conn);
		return list;
				
				
	}
	
	
	
	public int adminBbqResDelete(ArrayList<Integer> list) {
		
		System.out.println(list);
		Connection conn = getConnection();
		int result = 1;
		
		for(int i : list) {
			 result *= new AdminDao().adminBbqResDelete(conn, i);
		}
		
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		return result;
	}
	

}
