package com.kh.member.model.vo;

public class Member {

		// 필드부
		private int memberNo;		//	MEMBER_NO	NUMBER
		private String memberId;	//	MEMBER_ID	VARCHAR2(25 BYTE)
		private String memberPwd;	//	MEMBER_PWD	VARCHAR2(40 BYTE)
		private String memberName;	//	MEMBER_NAME	VARCHAR2(15 BYTE)
		private String address;		//	MEMBER_ADDRESS	VARCHAR2(10 BYTE)
		private String email;		//	MEMBER_EMAIL	VARCHAR2(40 BYTE)
		private String phone;		//	MEMBER_PHONE	VARCHAR2(13 BYTE)
		private String status;		//	MEMBER_STATUS	CHAR(1 BYTE)
		
		// 생성자부
		public Member(){ }

		public Member(int memberNo, String memberId, String memberPwd, String memberName, String address, String email,
				String phone, String status) {
			super();
			this.memberNo = memberNo;
			this.memberId = memberId;
			this.memberPwd = memberPwd;
			this.memberName = memberName;
			this.address = address;
			this.email = email;
			this.phone = phone;
			this.status = status;
		}
		
		// 회원 가입용 생성자
		public Member(String memberId, String memberPwd, String memberName, String address, String email, String phone) {
			super();
			this.memberId = memberId;
			this.memberPwd = memberPwd;
			this.memberName = memberName;
			this.address = address;
			this.email = email;
			this.phone = phone;
		}
		
		// 회원 정보 수정용 생성자
		public Member(String memberPwd, String memberName, String email, String phone) {
			super();
			this.memberPwd = memberPwd;
			this.memberName = memberName;
			this.email = email;
			this.phone = phone;
		}

		// 메소드부
		public int getMemberNo() {
			return memberNo;
		}

		public void setMemberNo(int memberNo) {
			this.memberNo = memberNo;
		}

		public String getMemberId() {
			return memberId;
		}

		public void setMemberId(String memberId) {
			this.memberId = memberId;
		}

		public String getMemberPwd() {
			return memberPwd;
		}

		public void setMemberPwd(String memberPwd) {
			this.memberPwd = memberPwd;
		}

		public String getMemberName() {
			return memberName;
		}

		public void setMemberName(String memberName) {
			this.memberName = memberName;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		@Override
		public String toString() {
			return "Member [memberNo=" + memberNo + ", memberId=" + memberId + ", memberPwd=" + memberPwd + ", memberName="
					+ memberName + ", address=" + address + ", email=" + email + ", phone=" + phone + ", status=" + status
					+ "]";
		}	
	}




















	
