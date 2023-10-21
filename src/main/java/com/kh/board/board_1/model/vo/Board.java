package com.kh.board.board_1.model.vo;

import java.sql.Date;

public class Board {
	private int boardNo; 			//	BOARD_NO	NUMBER
	private int boardType;			//	BOARD_TYPE	NUMBER
	private String cgNo; 				//	CG_NO	NUMBER
	
	private String boardTitle; 		//	BOARD_TITLE	VARCHAR2(60 BYTE)
	private String boardContent;  	//	BOARD_CONTENT	VARCHAR2(3000 BYTE)
	private String memberNo;		//	MEMBER_NO	NUMBER

	private int count;				//	COUNT	NUMBER
	private Date createDate;		//	CREATE_DATE	DATE
	private String boardStatus;		//	BOARD_STATUS	CHAR(1 BYTE)
	
	private int recommend;
	
	
	public Board() {	}

	public Board(int boardNo, String boardTitle, String boardContent, Date createDate, int count, String boardStatus,
			int boardType, String memberNo, String cgNo, int recommend) {
		super();
		this.boardNo = boardNo;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.createDate = createDate;
		this.count = count;
		this.boardStatus = boardStatus;
		this.boardType = boardType;
		this.memberNo = memberNo;
		this.cgNo = cgNo;
		this.recommend = recommend;
	}
	
	// 전체 조회용 생성자
	public Board(int boardNo, String cgNo, String boardTitle, String memberNo, int count, int recommend,Date createDate) {
		super();
		this.boardNo = boardNo;
		this.cgNo = cgNo;
		this.boardTitle = boardTitle;
		this.memberNo = memberNo;
		this.count = count;
		this.createDate = createDate;
		this.recommend = recommend;
	}
	
	
	// select board
	public Board(int boardNo, String boardTitle, String boardContent, String memberNo, int count, Date createDate,
			int recommend, String cgNo) {
		super();
		this.boardNo = boardNo;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.memberNo = memberNo;
		this.count = count;
		this.createDate = createDate;
		this.recommend = recommend;
		this.cgNo = cgNo;
	}

	public int getRecommend() {
		return recommend;
	}

	public void setRecommend(int recommend) {
		this.recommend = recommend;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getBoardStatus() {
		return boardStatus;
	}

	public void setBoardStatus(String boardStatus) {
		this.boardStatus = boardStatus;
	}

	public int getBoardType() {
		return boardType;
	}

	public void setBoardType(int boardType) {
		this.boardType = boardType;
	}

	public String getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}

	public String getCgNo() {
		return cgNo;
	}

	public void setCgNo(String cgNo) {
		this.cgNo = cgNo;
	}

	@Override
	public String toString() {
		return "Board [boardNo=" + boardNo + ", boardType=" + boardType + ", cgNo=" + cgNo + ", boardTitle="
				+ boardTitle + ", boardContent=" + boardContent + ", memberNo=" + memberNo + ", count=" + count
				+ ", createDate=" + createDate + ", boardStatus=" + boardStatus + ", recommend=" + recommend + "]";
	}

	
	
}
