package com.kh.car_reservation.model.vo;

public class Car {
	// 필드부
	private int carNo;			//	CAR_NO	NUMBER
	private String carResNo;	//	CAR_RES_NO	VARCHAR2(15 BYTE)
	private String carType;		//	CAR_TYPE	VARCHAR2(60 BYTE)
	private String carOwner;	//	CAR_OWNER	VARCHAR2(15 BYTE)
	private int memberNo;		//	MEMBER_NO	NUMBER
	
	// 생성자부
	public Car() {	}

	public Car(int carNo, String carResNo, String carType, String carOwner, int memberNo) {
		super();
		this.carNo = carNo;
		this.carResNo = carResNo;
		this.carType = carType;
		this.carOwner = carOwner;
		this.memberNo = memberNo;
	}
	
	// 차량 조회용 생성자부
	public Car(String carResNo, String carType, String carOwner) {
		super();
		this.carResNo = carResNo;
		this.carType = carType;
		this.carOwner = carOwner;
	}
	
	
	// 입력용 생성자부
	public Car(String carResNo, String carType, String carOwner, int memberNo) {
		super();
		this.carResNo = carResNo;
		this.carType = carType;
		this.carOwner = carOwner;
		this.memberNo = memberNo;
	}

	// 메소드부
	public int getCarNo() {
		return carNo;
	}

	

	public void setCarNo(int carNo) {
		this.carNo = carNo;
	}

	public String getCarResNo() {
		return carResNo;
	}

	public void setCarResNo(String carResNo) {
		this.carResNo = carResNo;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public String getCarOwner() {
		return carOwner;
	}

	public void setCarOwner(String carOwner) {
		this.carOwner = carOwner;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	@Override
	public String toString() {
		return "Car [carNo=" + carNo + ", carResNo=" + carResNo + ", carType=" + carType + ", carOwner=" + carOwner
				+ ", memberNo=" + memberNo + "]";
	}
	
	
	
}
