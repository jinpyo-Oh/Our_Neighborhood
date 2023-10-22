package com.kh.car_reservation.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.board.board_1.model.dao.BoardDao;
import com.kh.car_reservation.model.vo.Car;
import com.kh.common.JDBCTemplate;
import com.kh.member.model.vo.Member;

public class CarDao {
	
	private Properties prop = new Properties();
	
	public CarDao() {
		
		String fileName = BoardDao.class.getResource("/sql/car/car-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Car> selectCar(Connection conn, Member m) {
		
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
			pstmt.setInt(1, m.getMemberNo());
			
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}
	
	public int deleteCar(Connection conn, String rno) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deleteCar");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, rno);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}
}
