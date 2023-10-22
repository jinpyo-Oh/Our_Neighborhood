package com.kh.board.board_image.model.vo;

public class Category {

	// 필드부
	private int cgNo;	
	private String cgName;
	
	// 생성자부
	public Category() {}

	public Category(int cgNo, String cgName) {

		this.cgNo = cgNo;
		this.cgName = cgName;
	}

	// 메소드부
	public int getCgNo() {
		return cgNo;
	}

	public void setCgNo(int cgNo) {
		this.cgNo = cgNo;
	}

	public String getCgName() {
		return cgName;
	}

	public void setCgName(String cgName) {
		this.cgName = cgName;
	}

	// toString
	@Override
	public String toString() {
		return "Category [cgNo=" + cgNo + ", cgName=" + cgName + "]";
	}

	

}
