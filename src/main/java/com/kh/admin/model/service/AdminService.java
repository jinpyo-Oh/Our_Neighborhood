package com.kh.admin.model.service;

import static com.kh.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.admin.model.dao.AdminDao;
import com.kh.admin.model.vo.Board;
import com.kh.bbq_reservation.model.vo.BbqReservation;
import com.kh.board.board_1.model.dao.BoardDao;
import com.kh.board.board_1.model.vo.Image;
import com.kh.car_reservation.model.vo.Car;
import com.kh.member.model.vo.Member;

public class AdminService {
	
	// ==========게시글 관련==========

	public ArrayList<Board> selectBoardAllList(){
			
			Connection conn = getConnection();
			
			ArrayList<Board> list = new AdminDao().selectBoardAllList(conn);		
			
			close(conn);
			
			return list;
		}

	public Board selectBoard(int boardNo){
		
		Connection conn = getConnection();
		
		Board b = new AdminDao().selectBoard(conn, boardNo);		
		
		close(conn);
		
		return b;
	}
	
	public ArrayList<Board> selectBoardList(int cgNo){
		
		Connection conn = getConnection();
		
		ArrayList<Board> list = new AdminDao().selectBoardList(conn, cgNo);		
		
		close(conn);
		
		return list;
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
	
	public int BoardCheckDelete(ArrayList<Integer> list) {
		
		Connection conn = getConnection();
		
		int result = 1;
		
		for(int i : list) {
			 result *= new AdminDao().BoardCheckDelete(conn, i);
		}
		
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		return result;
	}
		
	

	// ==========차트 관련==========

	public int selectBoardChart(int chart) {
		
		Connection conn = getConnection();
		
		int c = new AdminDao().selectBoardChart(conn, chart);
		
		close(conn);
		
		return c;
		
	}
	
	// ==========회원 관련==========
	
	public int countMemberAll() {
		
		Connection conn = getConnection();
		
		int result = new AdminDao().countMemberAll(conn);
		
		close(conn);
		
		return result;
	}
	
	public int countMemberMonth() {
		
		Connection conn = getConnection();
		
		int result = new AdminDao().countMemberMonth(conn);
		
		close(conn);
		
		return result;
		
	}
	
	public int countBoardAll() {
		
		Connection conn = getConnection();
		
		int result = new AdminDao().countBoardAll(conn);
		
		close(conn);
		
		return result;
		
	}
	
	public int countBoardMonth() {
		
		Connection conn = getConnection();
		
		int result = new AdminDao().countBoardMonth(conn);
		
		close(conn);
		
		return result;
		
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
	
public ArrayList<Car> selectCarList(){
		
		Connection conn = getConnection();
		
		ArrayList<Car> list = new AdminDao().selectCarList(conn);
		
		close(conn);
		
		return list;
		
	}
	
	public ArrayList<Car> selectCar(int memberNo){
		
		Connection conn = getConnection();
		
		ArrayList<Car> list = new AdminDao().selectCar(conn, memberNo);
		
		close(conn);
		
		return list;
	}
	
	public int CarCheckDelelte(ArrayList<Integer> list) {
		
		Connection conn = getConnection();
		
		int result = 1;
		
		for(int i : list) {
			 result *= new AdminDao().CarCheckDelete(conn, i);
		}
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		return result;
	}
	
	public int insertCar(Car c) {
		
		Connection conn = getConnection();
		
		int result = new AdminDao().insertCar(conn, c);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}
	

}
