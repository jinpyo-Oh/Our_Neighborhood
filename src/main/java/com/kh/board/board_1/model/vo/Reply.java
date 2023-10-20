package com.kh.board.board_1.model.vo;

public class Reply {
	// 필드부
	private int replyNo; 			//	REPLY_NO	NUMBER
	private String replyContent;	//	REPLY_CONTENT	VARCHAR2(3000 BYTE)
	private String createDate;		//	CREATE_DATE	DATE
	private String replyStatus; 	//	REPLY_STATUS	CHAR(1 BYTE)
	private int boardNo;			//	BOARD_NO	NUMBER
	private String memberNo;		//	MEMBER_NO	NUMBER
	private String memberId;
	
	// 생성자부
	public Reply() {	}

	public Reply(int replyNo, String replyContent, String createDate, String replyStatus, int boardNo,
			String memberNo) {
		super();
		this.replyNo = replyNo;
		this.replyContent = replyContent;
		this.createDate = createDate;
		this.replyStatus = replyStatus;
		this.boardNo = boardNo;
		this.memberNo = memberNo;
	}
	
	// 댓글 리스트 조회용 생성자
	public Reply(int replyNo, String replyContent, String createDate, String memberNo) {
		super();
		this.replyNo = replyNo;
		this.replyContent = replyContent;
		this.createDate = createDate;
		this.memberNo = memberNo;
	}
	public Reply(int replyNo, String replyContent, String createDate, String memberNo, String memberId) {
		super();
		this.replyNo = replyNo;
		this.replyContent = replyContent;
		this.createDate = createDate;
		this.memberNo = memberNo;
		this.memberId = memberId;
	}

	public int getReplyNo() {
		return replyNo;
	}

	public void setReplyNo(int replyNo) {
		this.replyNo = replyNo;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getReplyStatus() {
		return replyStatus;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public void setReplyStatus(String replyStatus) {
		this.replyStatus = replyStatus;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}

	@Override
	public String toString() {
		return "Reply [replyNo=" + replyNo + ", replyContent=" + replyContent + ", createDate=" + createDate
				+ ", replyStatus=" + replyStatus + ", boardNo=" + boardNo + ", memberNo=" + memberNo + "]";
	}
	
	
}
