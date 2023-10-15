package com.kh.bbq_reservation.model.vo;

import java.sql.Date;

public class BbqReservation {
	
		//		RES_NO	NUMBER
		//	RES_PLACE	NUMBER
		//	RES_DATE	DATE
		//	RES_PEOPLE	NUMBER
		//	RES_STATEMENT	CHAR(1 BYTE)
		//	RES_NAME	VARCHAR2(15 BYTE)
		//	RES_MSG	VARCHAR2(120 BYTE)
		//	MEMBER_NO	NUMBER
	
	private int resNo;
	private int resPlace;
	private String resDate;
	private int resPeople;
	private String resStatement;
	private String resName;
	private String resMsg;
	private int resMemberNo;
	
	public BbqReservation() {
		
	}

	public BbqReservation(int resNo, int resPlace, String resDate, int resPeople, String resStatement, String resName,
			String resMsg, int resMemberNo) {
		super();
		this.resNo = resNo;
		this.resPlace = resPlace;
		this.resDate = resDate;
		this.resPeople = resPeople;
		this.resStatement = resStatement;
		this.resName = resName;
		this.resMsg = resMsg;
		this.resMemberNo = resMemberNo;
	}

	public int getResNo() {
		return resNo;
	}

	public void setResNo(int resNo) {
		this.resNo = resNo;
	}

	public int getResPlace() {
		return resPlace;
	}

	public void setResPlace(int resPlace) {
		this.resPlace = resPlace;
	}

	public String getResDate() {
		return resDate;
	}

	public void setResDate(String resDate) {
		this.resDate = resDate;
	}

	public int getResPeople() {
		return resPeople;
	}

	public void setResPeople(int resPeople) {
		this.resPeople = resPeople;
	}

	public String getResStatement() {
		return resStatement;
	}

	public void setResStatement(String resStatement) {
		this.resStatement = resStatement;
	}

	public String getResName() {
		return resName;
	}

	public void setResName(String resName) {
		this.resName = resName;
	}

	public String getResMsg() {
		return resMsg;
	}

	public void setResMsg(String resMsg) {
		this.resMsg = resMsg;
	}

	public int getResMemberNo() {
		return resMemberNo;
	}

	public void setResMemberNo(int resMemberNo) {
		this.resMemberNo = resMemberNo;
	}

	@Override
	public String toString() {
		return "BbqReservation [resNo=" + resNo + ", resPlace=" + resPlace + ", resDate=" + resDate + ", resPeople="
				+ resPeople + ", resStatement=" + resStatement + ", resName=" + resName + ", resMsg=" + resMsg
				+ ", resMemberNo=" + resMemberNo + "]";
	}
	
	
	
	


}