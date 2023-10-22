package com.kh.car_reservation.model.service;

import static com.kh.common.JDBCTemplate.*;
import static com.kh.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.car_reservation.model.dao.CarDao;
import com.kh.car_reservation.model.vo.Car;
import com.kh.member.model.vo.Member;


public class CarService {
	
	public ArrayList<Car> selectCar(Member m) {
		
		// 1) Connection 객체 생성
		Connection conn = getConnection();
		
		// 2) Connection 과 전달값을 넘기고 결과받기
		ArrayList<Car> list = new CarDao().selectCar(conn, m);
		
		// 3) 트랜잭션 처리
		
		// 4) Connection 반납
		close(conn);
		
		// 5) 결과 반환
		return list;
	}
	
	public int insertCar(Car c) {
		
		Connection conn = getConnection();
		
		int result = new CarDao().insertCar(conn, c);
		
		if(result > 0) {
			
			commit(conn);
		} else {
			
			rollback(conn);
		}
		
		close(conn);
		
		return result;
		
	}
	
	public int deleteCar(String rno) {
		
		Connection conn = getConnection();
		
		int result = new CarDao().deleteCar(conn, rno);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
}
