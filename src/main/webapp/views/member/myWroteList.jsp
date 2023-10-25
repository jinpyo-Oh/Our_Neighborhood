<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.board.board_1.model.vo.Board,com.kh.common.model.vo.PageInfo,
				 java.util.ArrayList"%>
<%
ArrayList<Board> list = (ArrayList<Board>)request.getAttribute("list");	
PageInfo pi = (PageInfo)request.getAttribute("pi");

int currentPage = pi.getCurrentPage();
int startPage = pi.getStartPage();
int endPage = pi.getEndPage();
int maxPage = pi.getMaxPage();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    .wrap {
    width : 1200px;
    height : 800px;
    margin : auto;
}

.eidtForm {
    width : 600px;
    margin : auto;
    margin-top : 100px;
    padding-top : 30px;

}
.eidtForm_1 {
    text-align : left;
}

.eidtForm_2>form {
    width : 350px;
    margin : auto;
    align-self: end;
    
}

.eidtForm_2 table {
    width : 100%;
}

.eidtForm_2 table input,
.eidtForm_2 table button {
    width : 100%;
    height : 40px;
    box-sizing : border-box;
    border-radius : 5px;
}

.eidtForm_2 table input {
    border : 1px solid lightgray;
    padding : 10px;
    font-size : 16px;
}


.eidtForm_2 .etc {
    padding-top : 10px;
    color : gray;
}

.eidtForm_2 .etc>a {
    color : gray;
    text-decoration : none;
}
.breadcrumbs ol li a {
    color: #f4c005;
}
button[type="submit"] {
      border: 0px;
      color: white;
      font-size: 18px;
      font-weight: 700;
      width : 344.8px;
      height : 42px;
      border-radius: 8px;
      background-color: #f4c005;
      }

#login-form, #user-info { float : right; }

#user-info a {
  text-decoration : none;
  color : black;
  font-size : 12px;
}

    .nav-area {
      background-color: #f4c005;
      width: 100%;
    }

    .menu {
      width: 24%;
      height: 98%;
      display : inline-block;
      margin-left: 7px;
      text-align: center;
    }

    .menu a {
      text-decoration : none;
      color : white;
      font-size : 20px;
      font-weight : bold;
      box-sizing: border-box;  
    }

.menu a:hover { background-color : darkgray; }
 table {
  border-collapse: collapse;
  border-spacing: 0;
}
section.notice {
  padding: 80px 0;
}

.page-title {
  margin-bottom: 60px;
}
.page-title h3 {
  font-size: 35px;
  color: #333333;
  font-weight: 400;
  text-align: center;
}

#board-search .search-window {
  padding: 15px 0;
  background-color: #f9f7f9;
}
#board-search .search-window .search-wrap {
  position: relative;
/*   padding-right: 124px; */
  margin: 0 auto;
  width: 80%;
  max-width: 564px;
}
#board-search .search-window .search-wrap input {
  height: 40px;
  width: 100%;
  font-size: 14px;
  padding: 7px 14px;
  border: 1px solid #ccc;
}
#board-search .search-window .search-wrap input:focus {
  border-color: #333;
  outline: 0;
  border-width: 1px;
}
#board-search .search-window .search-wrap .btn {
  position: absolute;
  right: 0;
  top: 0;
  bottom: 0;
  width: 108px;
  padding: 0;
  font-size: 16px;
}

.board-table {
  font-size: 13px;
  width: 100%;
  border-top: 1px solid #ccc;
  border-bottom: 1px solid #ccc;
}

.board-table a {
  color: #333;
  display: inline-block;
  line-height: 1.4;
  word-break: break-all;
  vertical-align: middle;
}
.board-table a:hover {
  text-decoration: underline;
}
.board-table th {
  text-align: center;
}

.board-table .th-num {
  width: 100px;
  text-align: center;
}

.board-table th, .board-table td {
  padding: 14px 0;
}

.board-table tbody td {
  border-top: 1px solid #e7e7e7;
  text-align: center;
}

.board-table tbody th {
  padding-left: 28px;
  padding-right: 14px;
  border-top: 1px solid #e7e7e7;
  text-align: left;
}

.board-table tbody th p{
  display: none;
}

.paging-btn,  .paging-dis {
  display: inline-block;
  padding: 0 15px;
  width : 50px;
  height : 50px;
  font-size: 15px;
  font-weight: 500;
  background: transparent;
  text-align: center;
  white-space: nowrap;
  vertical-align: middle;
  -ms-touch-action: manipulation;
  touch-action: manipulation;
  cursor: pointer;
  -webkit-user-select: none;
  -moz-user-select: none;
  -ms-user-select: none;
  user-select: none;
  border: 1px solid lightgray;
  text-transform: uppercase;
  -webkit-border-radius: 0;
  -moz-border-radius: 0;
  border-radius: 10px;
  -webkit-transition: all 0.3s;
  -moz-transition: all 0.3s;
  -ms-transition: all 0.3s;
  -o-transition: all 0.3s;
  transition: all 0.3s;
}

.paging-arrow {
  border : 0px;
  font-weight : 900;
  font-size:25px;
}

.paging-btn {
  
	color : #F4C005;
}

.paging-dis {
  color: lightgray;
  cursor : auto;
}

/* reset */

* {
  list-style: none;
  text-decoration: none;
  padding: 0;
  margin: 0;
  box-sizing: border-box;
}
.clearfix:after {
  content: '';
  display: block;
  clear: both;
}
.container {
  width: 1100px;
  margin: 0 auto;
}
.blind {
  position: absolute;
  overflow: hidden;
  clip: rect(0 0 0 0);
  margin: -1px;
  width: 1px;
  height: 1px;
}

.th-writer, .th-count, .th-recommend{
	width : 80px;
}

.th-date {
	width : 120px;
}

tbody #table-content:hover{
	background-color : lightgray;
	cursor: pointer;
</style>
</head>
<body>

<%@ include file="/views/common/boardHeader.jsp" %>
  
 <main id="main">

    <!-- ======= Breadcrumbs ======= -->
    <div class="breadcrumbs d-flex align-items-center" style="background-image: url('./resources/img/board/apartmentpic/apartmentpic.jpg');">
      <div class="container position-relative d-flex flex-column align-items-center" data-aos="fade">
        <h2>마이페이지</h2>
        <ol>
            <li><a href="index.jsp">Home</a></li>
        </ol>
        </div>
    </div><!-- End Breadcrumbs -->

    <!-- ======= Contact Section ======= -->
    <section id="contact" class="contact">
        <div class="wrap">
          <div class="nav-area" align="auto">
            <div class="menu"><a href="<%= contextPath %>/views/member/mypageView.jsp">회원정보수정</a></div>
            <div class="menu"><a href="<%= contextPath %>/cost.me">관리비 조회</a></div>
            <div class="menu"><a href="<%= contextPath %>/wrote.me?currentPage=1">내가 작성한 글</a></div>
            <div class="menu"><a href="<%= contextPath %>/deleteForm.me">회원탈퇴</a></div>
          </div>

          <div class="container" data-aos="fade-up" data-aos-delay="100">
            
        
            
             <!-- board list area -->
          <div id="board-list">
          	<br><br><br>
              <div class="container">
                  <table class="board-table">
                      <thead>
                      <tr>
							<% if(loginUser != null && loginUser.getMemberId().equals("admin")){ %>
	               			<% } %>

                          <th scope="col" class="th-num"> 번호</th>
                          <th scope="col" class="th-title">제목</th>
                          <th scope="col" class="th-writer">작성자</th>
                          <th scope="col" class="th-date">등록일</th>
                          <th scope="col" class="th-count">조회수</th>
                          <th scope="col" class="th-recommend">추천</th>
                          <th scope="col" class="th-category">카테고리</th>
                      </tr>
                      </thead>
                      <tbody>
						<% if(list.isEmpty()) { %>
							<tr>
								<td colspan="8">
									조회된 리스트가 없습니다.
								</td>
							</tr>
						<% } else { %>
	                      	<% for(Board b : list) {%>
	                      		<tr id="table-content">
	                      			<td><%= b.getBoardNo() %></td>
	                      			<td style="text-align : left; padding-left : 100px; padding-right : 100px">
	                      				<%= b.getBoardTitle() %> </td>	               
	                      			<td><%= b.getMemberNo() %></td>
	                      			<td><%= b.getCreateDate() %></td>
	                      			<td><%= b.getCount() %></td>
	                      			<td><%= b.getRecommend() %></td>
	                      			<td><%= b.getCgNo() %></td>
	                      		</tr>
	                      	<% } %>
						<% } %>
                      </tbody>
                  </table>
                  <script>
		              $(function() {
		            	  
                    	$(".board-table>tbody>#table-content").click(function() {
                    		 
                    			  console.log("h2");
                    		
		                		  let bno = $(this).children().eq(0).text();
		                		  let cgName = $(this).children().eq(6).text();
		                		  let cgNo = "";
		                		  switch(cgName){
		                		  case "1단지" : cgNo = "1"; break;
		                		  case "2단지" : cgNo = "2"; break;
		                		  case "3단지" : cgNo = "3"; break;
		                		  case "자유" : cgNo = "4"; break;
		                		  case "사진" : cgNo = "5"; break;
		                		  case "중고거래" : cgNo = "6"; break;
		                		  case "건의사항" : cgNo = "7"; break;
		                		  case "홍보" : cgNo = "8"; break;
		                		  case "분실물" : cgNo = "9"; break;
		                		  case "공지사항" : cgNo = "10"; break;	                		  
		                		  }
		                		  
		                		  
		                		  if(cgNo=="5"||cgNo=="6"||cgNo=="8"||cgNo=="9"){
		                			  location.href = "<%= contextPath %>/imageDetail.bo?cg="+cgNo+"&bno="+bno;  
		                		  }else{
		                			  location.href = "<%= contextPath %>/detail.bo?cg="+cgNo+"&bno="+bno;    
		                		  }
		                		  
	                		  
	                		 
	                		  
	                		 
	                	  });
			           });
		              
		            </script>
		            
                  <br><br>
                  
                
                <div class="pageing-area" align="center">
                <% if(currentPage != 1) { %>
                  <button class="paging-btn paging-arrow" onclick="location.href = '<%= contextPath %>/wrote.me?currentPage=<%= currentPage - 1 %>'">&lt;</button>
				<% } %>
                  <% for(int p = startPage; p <= endPage; p++) { %>
                  	<% if(p != currentPage) { %>
                  		<button class="paging-btn" onclick="location.href ='<%= contextPath %>/wrote.me?currentPage=<%= p %>'"></button>
                  	<% } else { %>
                  		<button class="paging-dis" disabled><%= p %></button>
                  	<% } %>
                  <% } %>
                <% if(currentPage != maxPage) { %>  
                  <button class="paging-btn paging-arrow" onclick="location.href = '<%= contextPath %>/wrote.me?currentPage=<%= currentPage + 1 %>';">&gt;</button>
				<% } %>
                </div>
              
             
             
             
             
            </div>
        </div>
      </section><!-- End Contact Section -->

    </main><!-- End #main -->

                 
                 
  <!-- 푸터 인클루드-->
  <%@ include file="/views/common/boardFooter.jsp" %>
                 
</body>
</html>