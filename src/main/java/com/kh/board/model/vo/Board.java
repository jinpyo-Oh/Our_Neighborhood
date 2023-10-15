package com.kh.board.model.vo;

import java.sql.Date;

public class Board {
	// 필드부
	private int boardNo;		// BOARD_NO	NUMBER
	private String boardTitle; 	// BOARD_TITLE	VARCHAR2(60 BYTE)
	private String boardContent;// BOARD_CONTENT	VARCHAR2(3000 BYTE)
	private Date regiDate;		// BOARD_REGI_DATE	DATE
	private int boardViews;		// BOARD_VIEWS	NUMBER
	private String boardStatus; //BOARD_STATUS	CHAR(1 BYTE)
	private int memberNo;		//MEMBER_NO	NUMBER
	private int cgNo;			//CG_NO	NUMBER
	
	// 생성자부
	public Board() {	}

	public Board(int boardNo, String boardTitle, String boardContent, Date regiDate, int boardViews, String boardStatus,
			int memberNo, int cgNo) {
		super();
		this.boardNo = boardNo;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.regiDate = regiDate;
		this.boardViews = boardViews;
		this.boardStatus = boardStatus;
		this.memberNo = memberNo;
		this.cgNo = cgNo;
	}

	// 메소드부
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

	public Date getRegiDate() {
		return regiDate;
	}

	public void setRegiDate(Date regiDate) {
		this.regiDate = regiDate;
	}

	public int getBoardViews() {
		return boardViews;
	}

	public void setBoardViews(int boardViews) {
		this.boardViews = boardViews;
	}

	public String getBoardStatus() {
		return boardStatus;
	}

	public void setBoardStatus(String boardStatus) {
		this.boardStatus = boardStatus;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public int getCgNo() {
		return cgNo;
	}

	public void setCgNo(int cgNo) {
		this.cgNo = cgNo;
	}

	@Override
	public String toString() {
		return "ThumbnailBoard [boardNo=" + boardNo + ", boardTitle=" + boardTitle + ", boardContent=" + boardContent
				+ ", regiDate=" + regiDate + ", boardViews=" + boardViews + ", boardStatus=" + boardStatus
				+ ", memberNo=" + memberNo + ", cgNo=" + cgNo + "]";
	}
}
