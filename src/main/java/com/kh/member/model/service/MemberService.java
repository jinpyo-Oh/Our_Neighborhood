package com.kh.member.model.service;

import java.sql.Connection;

import com.kh.common.JDBCTemplate;
import com.kh.member.model.dao.MemberDao;
import com.kh.member.model.vo.Member;

public class MemberService {

	public Member loginMember(Member m) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		Member loginUser = new MemberDao().loginMember(conn, m);
		
		JDBCTemplate.close(conn);
		
		return loginUser;
	}
	
	
	
	public int insertMember(Member m) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new MemberDao().insertMember(conn, m);
		
		if(result > 0) { // 회원가입 성공
			
			JDBCTemplate.commit(conn);
		
		} else { // 회원가입 실패
			
			JDBCTemplate.rollback(conn);
			
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}
	
	
	
	public Member updateMember(Member m) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new MemberDao().updateMember(conn, m);
		
		Member updateMem = null;
		
		if(result > 0) {
			JDBCTemplate.commit(conn);
			
			updateMem = new MemberDao().selectMember(conn, m.getMemberId());
			
		} else {
			
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return updateMem;
	}
	
	
	
	public int deleteMember(Member m) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new MemberDao().deleteMember(conn, m);
		
		if(result > 0) {
			
			JDBCTemplate.commit(conn);
		
		} else {
			
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	
	}
	
	
	
	public int idCheck(String checkId) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int count = new MemberDao().idCheck(conn, checkId);
		
		JDBCTemplate.close(conn);
		
		return count;
	}
	
	
	public String findId(Member m) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		String foundId = new MemberDao().findId(conn, m);
		
		JDBCTemplate.close(conn);
		
		return foundId;
		
	}
	
	public String findPwd(Member m) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		String foundPwd = new MemberDao().findPwd(conn, m);
		
		JDBCTemplate.close(conn);
		
		return foundPwd;
	}
}
