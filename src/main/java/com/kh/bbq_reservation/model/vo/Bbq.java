package com.kh.bbq_reservation.model.vo;

public class Bbq {
	
	private int bbqNo;
	private String bbqPlace;
	
	public Bbq() {}

	public Bbq(int bbqNo, String bbqPlace) {
		this.bbqNo = bbqNo;
		this.bbqPlace = bbqPlace;
	}

	public int getBbqNo() {
		return bbqNo;
	}

	public void setBbqNo(int bbqNo) {
		this.bbqNo = bbqNo;
	}

	public String getBbqPlace() {
		return bbqPlace;
	}

	public void setBbqPlace(String bbqPlace) {
		this.bbqPlace = bbqPlace;
	}

	@Override
	public String toString() {
		return "bbq [bbqNo=" + bbqNo + ", bbqPlace=" + bbqPlace + "]";
	}
	
	
	

}
