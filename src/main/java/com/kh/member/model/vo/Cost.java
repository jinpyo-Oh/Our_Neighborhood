package com.kh.member.model.vo;

public class Cost {
	
	private int costNo;
	private String costDate;
	private int commonBill;
	private int electricityBill;
	private int waterBill;
	private int heatingBill;
	private int memberNo;
	
	public Cost() {}
		
	public Cost(int costNo, String costDate, int commonBill, int electricityBill, int waterBill, int heatingBill,
			int memberNo) {
		this.costNo = costNo;
		this.costDate = costDate;
		this.commonBill = commonBill;
		this.electricityBill = electricityBill;
		this.waterBill = waterBill;
		this.heatingBill = heatingBill;
		this.memberNo = memberNo;
	}

	
	
	public Cost(String costDate,int commonBill, int electricityBill, int waterBill, int heatingBill) {
		this.costDate = costDate;
		this.commonBill = commonBill;
		this.electricityBill = electricityBill;
		this.waterBill = waterBill;
		this.heatingBill = heatingBill;
	}
	
	public int sum(){
		return commonBill+electricityBill+waterBill+heatingBill;
	}

	public int getCostNo() {
		return costNo;
	}

	public void setCostNo(int costNo) {
		this.costNo = costNo;
	}

	public String getCostDate() {
		return costDate;
	}

	public void setCostDate(String costDate) {
		this.costDate = costDate;
	}

	public int getCommonBill() {
		return commonBill;
	}

	public void setCommonBill(int commonBill) {
		this.commonBill = commonBill;
	}

	public int getElectricityBill() {
		return electricityBill;
	}

	public void setElectricityBill(int electricityBill) {
		this.electricityBill = electricityBill;
	}

	public int getWaterBill() {
		return waterBill;
	}

	public void setWaterBill(int waterBill) {
		this.waterBill = waterBill;
	}

	public int getHeatingBill() {
		return heatingBill;
	}

	public void setHeatingBill(int heatingBill) {
		this.heatingBill = heatingBill;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	@Override
	public String toString() {
		return "Cost [costNo=" + costNo + ", costDate=" + costDate + ", commonBill=" + commonBill + ", electricityBill="
				+ electricityBill + ", waterBill=" + waterBill + ", heatingBill=" + heatingBill + ", memberNo="
				+ memberNo + "]";
	}
	
	
	

}
