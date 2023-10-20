package com.kh.board.board_1.model.vo;

import java.sql.Date;

public class Image{
	
	// 필드부
	private int imgNo; 				//	IMG_NO	NUMBER
	private String originalName; 	//	ORIGINAL_NAME	VARCHAR2(300 BYTE)
	private String changeName; 		//	CHANGE_NAME	VARCHAR2(300 BYTE)
	private String imgStatus; 		//	IMG_STATUS	CHAR(1 BYTE)
	private String imgPath;	 		//	IMG_PATH	VARCHAR2(1000 BYTE)
	private Date uploadDate; 		//	UPLOAD_DATE	DATE
	private int imgLevel; 			//	IMG_LEVEL	NUMBER
	private int boardNo;			//	BOARD_NO	NUMBER
	
	//생성자부
	public Image() {	}

	public Image(int imaNo, String originalName, String changeName, String imgStatus, String imgPath, Date uploadDate,
			int imgLevel, int boardNo) {
		super();
		this.imgNo = imaNo;
		this.originalName = originalName;
		this.changeName = changeName;
		this.imgStatus = imgStatus;
		this.imgPath = imgPath;
		this.uploadDate = uploadDate;
		this.imgLevel = imgLevel;
		this.boardNo = boardNo;
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

	@Override
	public String toString() {
		return "Image [imgNo=" + imgNo + ", originalName=" + originalName + ", changeName=" + changeName
				+ ", imgStatus=" + imgStatus + ", imgPath=" + imgPath + ", uploadDate=" + uploadDate + ", imgLevel="
				+ imgLevel + ", boardNo=" + boardNo + "]";
	}
	
	
	
}
