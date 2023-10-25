package com.kh.bbq_reservation.model.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.commit;
import static com.kh.common.JDBCTemplate.getConnection;
import static com.kh.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.bbq_reservation.model.dao.BbqDao;
import com.kh.bbq_reservation.model.vo.BbqReservation;


public class BbqService {
	
	public ArrayList<String> bbqResSelect(String resDate){
		
		Connection conn = getConnection();
		
		ArrayList<String> list = new BbqDao().bbqResSelect(conn, resDate);
		
		close(conn);
		
		return list;
	}
	
	public int bbqResInsert(BbqReservation bbq) {
		Connection conn = getConnection();
		
		int result = new BbqDao().bbqResInsert(conn, bbq);
		
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
	public BbqReservation bbqSelectOne(int memberNo) {
		Connection conn = getConnection();
		
		BbqReservation bbq = new BbqDao().bbqSelectOne(conn, memberNo);
		
		close(conn);
		
		return bbq;
	}
	
	public int bbqDelete(int resNo) {
		Connection conn = getConnection();
		
		int result = new BbqDao().bbqDelete(conn, resNo);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
	
	

}
