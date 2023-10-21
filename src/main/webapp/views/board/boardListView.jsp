<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kh.common.model.vo.PageInfo,
				 com.kh.board.board_1.model.vo.Board,
				 java.util.ArrayList"
%>
<%
	// request 로 부터 응답데이터 뽑기
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	ArrayList<Board> list = (ArrayList<Board>)request.getAttribute("list");	
	String cgNo = (String)request.getAttribute("cgNo");
	String cgName = null;
	switch(cgNo){
	case "1" : cgName="1단지"; break;
	case "2" : cgName="2단지"; break;
	case "3" : cgName="3단지"; break;
	case "4" : cgName="자유"; break;
	case "5" : cgName="사진"; break;
	case "6" : cgName="중고거래"; break;
	case "7" : cgName="건의사항"; break;
	case "8" : cgName="분실물"; break;
	}
	
	
	// 변수 셋팅
	int currentPage = pi.getCurrentPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
	int maxPage = pi.getMaxPage();
%>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
    <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
  <style>
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

tbody tr:hover{
	background-color : lightgray;
	cursor: pointer;
}
  </style>
</head>
<body>
<!-- boardHeader 인클루드-->

<%@ include file="/views/common/boardHeader.jsp" %>
  

  <main id="main">

    <!-- ======= Breadcrumbs ======= -->
    <div class="breadcrumbs d-flex align-items-center" style="background-image: url('assets/img/breadcrumbs-bg.jpg');">
      <div class="container position-relative d-flex flex-column align-items-center" data-aos="fade">

        <h2><%=cgName %> 게시글 조회</h2>
        <ol>
          <li><a href="<%= contextPath %>">메인 페이지</a></li>
          <li><%=cgName %> 게시판</li>
        </ol>

      </div>
    </div><!-- End Breadcrumbs -->

    <!-- ======= Services Section ======= -->
    <section id="services" class="section-bg">
      
      <section class="notice">
        <div class="page-title">
              <div class="container">
                  <h3><%=cgName %> 게시판</h3>
              </div>
          </div>
        
        <!-- board list area -->
          <div id="board-list">
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
                      </tr>
                      </thead>
                      <tbody>
						<% if(list.isEmpty()) { %>
							<tr>
								<td coslpan="7">
									조회된 리스트가 없습니다.
								</td>
							</tr>
						<% } else { %>
	                      	<% for(Board b : list) {%>
	                      		<tr>
	                      			<td><%= b.getBoardNo() %></td>
	                      			<td style="text-align : left; padding-left : 100px; padding-right : 100px">
	                      				<%= b.getBoardTitle() %>
	                      			</td>
	                      			<td><%= b.getMemberNo() %></td>
	                      			<td><%= b.getCreateDate() %></td>
	                      			<td><%= b.getCount() %></td>
	                      			<td><%= b.getRecommend() %></td>
	                      		</tr>
	                      	<% } %>
						<% } %>
                      </tbody>
                  </table>
                  <script>
		              $(function() {
	                	  $(".board-table>tbody>tr").click(function() {
	                		  let bno = $(this).children().eq(0).text();
	                		  console.log(bno);
	                		  location.href = "<%= contextPath %>/detail.bo?bno=" + bno;
	                	  });
			           });
		              
		            </script>
		            
                  <br><br>
                  <div align="right">
                  	<% if(loginUser != null) { %>
                   		<a href="<%= contextPath %>/enrollForm.bo_1">글 작성</a>
                   	<% } %>
                	</div>
                <!-- 페이징바 -->
                <div class="pageing-area" align="center">
                <% if(currentPage != 1) { %>
					<button class="paging-btn paging-arrow" onclick="location.href = '<%= contextPath %>/list.bo?currentPage=<%= currentPage - 1 %>';">&lt;</button>
				<% } %>
                  <% for(int p = startPage; p <= endPage; p++) { %>
                  	<% if(p != currentPage) { %>
                  		<button class="paging-btn" onclick="location.href ='<%= contextPath %>/list.bo?currentPage=<%= p %>'"><%= p %></button>
                  	<% } else { %>
                  		<button class="paging-dis" disabled><%= p %></button>
                  	<% } %>
                  <% } %>
                <% if(currentPage != maxPage) { %>  
					<button class="paging-btn paging-arrow" onclick="location.href = '<%= contextPath %>/list.bo?currentPage=<%= currentPage + 1 %>';">&gt;</button>
				<% } %>
                </div>
              </div>
          </div>

      </section>
    </section><!-- End Services Section -->

    

  </main><!-- End #main -->
  



  <!-- 푸터 인클루드-->
  <%@ include file="/views/common/boardFooter.jsp" %>

</body>

</html>