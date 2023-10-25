package com.kh.imageBoard.model.vo;

import java.sql.Date;

public class Image {

	// 필드부
	private int imgNo;
	private String originalName;
	private String changeName;
	private String imgStatus;
	private String imgPath;
	private Date uploadDate;
	private int imgLevel;
	private int boardNo;
	
	// 생성자부
	public Image() {}

	public Image(int imgNo, String originalName, String changeName, String imgStatus, String imgPath, Date uploadDate,
			int imgLevel, int boardNo) {
		
		this.imgNo = imgNo;
		this.originalName = originalName;
		this.changeName = changeName;
		this.imgStatus = imgStatus;
		this.imgPath = imgPath;
		this.uploadDate = uploadDate;
		this.imgLevel = imgLevel;
		this.boardNo = boardNo;
	}
	
	

	public Image(int imgNo, String originalName, String changeName, int imgLevel, String imgPath) {
	
		this.imgNo = imgNo;
		this.originalName = originalName;
		this.changeName = changeName;
		this.imgLevel = imgLevel;
		this.imgPath = imgPath;
	}

	// 메소드부
	public int getImgNo() {
		return imgNo;
	}

	public void setImgNo(int imgNo) {
		this.imgNo = imgNo;
	}

	public String getOriginalName() {
		return originalName;
	}

	public void setOriginalName(String originalName) {
		this.originalName = originalName;
	}

	public String getChangeName() {
		return changeName;
	}

	public void setChangeName(String changeName) {
		this.changeName = changeName;
	}

	public String getImgStatus() {
		return imgStatus;
	}

	public void setImgStatus(String imgStatus) {
		this.imgStatus = imgStatus;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public Date getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

	public int getImgLevel() {
		return imgLevel;
	}

	public void setImgLevel(int imgLevel) {
		this.imgLevel = imgLevel;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	// toString
	@Override
	public String toString() {
		return "Image [imgNo=" + imgNo + ", originalName=" + originalName + ", changeName=" + changeName
				+ ", imgStatus=" + imgStatus + ", imgPath=" + imgPath + ", uploadDate=" + uploadDate + ", imgLevel="
				+ imgLevel + ", boardNo=" + boardNo + "]";
	}

	
	
	
	
	
	
	
}
