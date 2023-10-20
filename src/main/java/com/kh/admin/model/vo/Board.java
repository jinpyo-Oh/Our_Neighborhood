package com.kh.admin.model.vo;

import java.sql.Date;

public class Board {
	
		// 필드부
		private int boardNo;		// BOARD_NO	NUMBER
		
		private Date createDate;		// BOARD_REGI_DATE	DATE
		private int count;		// BOARD_VIEWS	NUMBER
		private String boardStatus; //BOARD_STATUS	CHAR(1 BYTE)
		private String boardType;
		private String memberNo;		//MEMBER_NO	NUMBER
		private int cgNo;			//CG_NO	NUMBER
		
		
		private String cgName;
		private String memberName;
		
		// 사진게시판 리스트 조회 시 필요한 썸네일 파일명을 담을 수 있는 필드 하나 추가
		private String titleImg;
		private int recommend;
		private String memberId;
		
		// 게시글 작성 시 "1" / 게시글 조회 시 "admin
		private String boardTitle; 	// BOARD_TITLE	VARCHAR2(60 BYTE)
		private String boardContent;// BOARD_CONTENT	VARCHAR2(3000 BYTE)
		
		// 생성자부
		public Board() {}

		public Board(int boardNo, Date createDate, int count, String boardStatus, String boardType, String memberNo,
				int cgNo, String titleImg, int recommend, String memberId, String boardTitle, String boardContent) {
			super();
			this.boardNo = boardNo;
			this.createDate = createDate;
			this.count = count;
			this.boardStatus = boardStatus;
			this.boardType = boardType;
			this.memberNo = memberNo;
			this.cgNo = cgNo;
			this.titleImg = titleImg;
			this.recommend = recommend;
			this.memberId = memberId;
			this.boardTitle = boardTitle;
			this.boardContent = boardContent;
		}
		
		public Board(int boardNo, String boardTitle, String boardContent, Date createDate, int count, String memberName, String cgName) {
			
			this.boardNo = boardNo;
			this.boardTitle = boardTitle;
			this.boardContent = boardContent;
			this.createDate = createDate;
			this.count = count;
			this.memberName = memberName;
			this.cgName = cgName;
		}
	     
		
		
		public String getCgName() {
			return cgName;
		}

		public void setCgName(String cgName) {
			this.cgName = cgName;
		}

		public String getMemberName() {
			return memberName;
		}
		
		public void setMemberName(String memberName) {
			this.memberName = memberName;
		}
		
		public int getBoardNo() {
			return boardNo;
		}

		public void setBoardNo(int boardNo) {
			this.boardNo = boardNo;
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

		public String getBoardType() {
			return boardType;
		}

		public void setBoardType(String boardType) {
			this.boardType = boardType;
		}

		public String getMemberNo() {
			return memberNo;
		}

		public void setMemberNo(String memberNo) {
			this.memberNo = memberNo;
		}

		public int getCgNo() {
			return cgNo;
		}

		public void setCgNo(int cgNo) {
			this.cgNo = cgNo;
		}

		public String getTitleImg() {
			return titleImg;
		}

		public void setTitleImg(String titleImg) {
			this.titleImg = titleImg;
		}

		public int getRecommend() {
			return recommend;
		}

		public void setRecommend(int recommend) {
			this.recommend = recommend;
		}

		public String getMemberId() {
			return memberId;
		}

		public void setMemberId(String memberId) {
			this.memberId = memberId;
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

		@Override
		public String toString() {
			return "Board [boardNo=" + boardNo + ", createDate=" + createDate + ", count=" + count + ", boardStatus="
					+ boardStatus + ", boardType=" + boardType + ", memberNo=" + memberNo + ", cgNo=" + cgNo
					+ ", titleImg=" + titleImg + ", recommend=" + recommend + ", memberId=" + memberId + ", boardTitle="
					+ boardTitle + ", boardContent=" + boardContent + ", memberName=" + memberName + ", cgName=" + cgName +"]";
		}
		
		
}
