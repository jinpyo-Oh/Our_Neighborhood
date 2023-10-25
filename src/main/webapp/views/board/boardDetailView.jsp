<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.board.board_1.model.vo.*"%>
<%
	Board b = (Board)request.getAttribute("b");
	Image img  = (Image)request.getAttribute("img");
	Reply r = (Reply)request.getAttribute("r");
	
	int categoryNo =Integer.parseInt(b.getCgNo());
	   
	   String cgName = null;
		switch(categoryNo){
		case 1 : cgName="1단지"; break;
		case 2 : cgName="2단지"; break;
		case 3 : cgName="3단지"; break;
		case 4 : cgName="자유"; break;
		case 5 : cgName="사진"; break;
		case 6 : cgName="중고거래"; break;
		case 7 : cgName="건의사항"; break;
		case 8 : cgName="분실물"; break;
		case 9 : cgName="홍보"; break;
		case 10 : cgName="공지사항"; break;
		}
	
%>
<!DOCTYPE html>
<html lang="en">
<head>
 <meta charset="utf-8">
  <title>boardDetailView</title>

 
  <style>
  body {
  background: #f5f5f5
}

table {
  border: 1px #a39485 solid;
  font-size: .9em;
  box-shadow: 0 2px 5px rgba(0,0,0,.25);
  width: 100%;
  border-collapse: collapse;
  border-radius: 5px;
  overflow: hidden;
}

th {
  text-align: left;
}
  
thead {
  font-weight: bold;
  color: black;
  background: #73685d;
}
thead th {
  color : #fff;
}

thead th, thead td {
  border-bottom: 1px dotted lightgray;
}
  
 td, th {
  padding: 1em .5em;
  vertical-align: middle;
  
}
  
 td {
  border-bottom: 1px solid rgba(0,0,0,.1);
  background: #fff;
}

a {
  color: #73685d;
}
  .like-container{filter: url('#filter');
  position: absolute; 
  left: 50%; 
  top: 50%; 
  transform: translate(50%, -50%);
}
.like-cnt{  
  position: absolute; 
  cursor: pointer;
  left: 50%; 
  top: 100%; 
  transform: translate(50%, -50%);     background: rgba(255,255,255,0.3);     width: 60px; 
  height: 60px;  
  border-radius: 50%;
  text-align: center;
  line-height: 75px;
  z-index: 10;
}
.like-btn{
  color: #fff;
}
 
    
  </style>

</head>



<body>
  <!-- boardHeader 인클루드-->
 <%@ include file="/views/common/boardHeader.jsp" %> 
  
  
  
  <main id="main">

    <!-- ======= Breadcrumbs ======= -->
    <div class="breadcrumbs d-flex align-items-center" style="background-image: url('./resources/img/board/apartmentpic/apartmentpic.jpg');">
      <div class="container position-relative d-flex flex-column align-items-center" data-aos="fade">
        <h2>게시글 조회</h2>
        <ol>
          <li><a href="index.html">메인 페이지</a></li>
          <li><%=cgName%> 게시판</li>
        </ol>

      </div>
    </div><!-- End Breadcrumbs -->

    <!-- ======= Services Section ======= -->
    <section id="services" class="section-bg">
      <div class="container" data-aos="fade-up">
        <div class="content_detail">

          <br>
          <h2 align="center">게시글 상세보기</h2>
          <br>
  
          <table>
            <thead>
            <tr>
                <th>제목</th>
                <td colspan="3"><%= b.getBoardTitle() %></td>
            </tr>

            <tr>
                <th style="width :10%;">작성자</th>
                <td style="width :40%;"><%= b.getMemberNo() %></td>
                <th style="width :10%;">작성일</th>
                <td style="width :40%; text-align: right; padding-right: 50px;"><%= b.getCreateDate() %></td>
            </tr>
          </thead>
          <tbody>
            <tr>
                <td style="background-color: #73685d; color : white;">내용</td>
                <td colspan="3">
                  <%= b.getBoardContent() %>
                </td>
            </tr>
            <tr>
              <td style="background-color: #73685d; color : white;">첨부파일</td>
              <td colspan="3">
              	<% if(img == null) { %>
	              	첨부파일이 없습니다
              	<% } else { %>
              		<a download="<%= img.getOriginalName() %>" href="<%= contextPath %>/<%= img.getImgPath() + img.getChangeName() %>">
              			<%= img.getOriginalName() %>
              		</a>
              	<% } %> 
              </td>
            </tr>
            <tr>
            	<td colspan="4">
	            	<button id="reco" class="btn btn-warning" style="float:right;">추천</button>
				  	<input type="hidden"  name="boardNo" value=<%= b.getBoardNo() %>>
				  	
				  	<script>
				  	
				  	$(function() {
	                	  $("#reco").click(function() {
	                		  
	                		  location.href = "<%= contextPath %>/recommend.bo?bno=<%= b.getBoardNo() %>&cg=<%=b.getCgNo()%>";
	                	  });
			           });
				  	
				  	</script>
				  	
				</td>
            </tr>
            <tr>
              <td colspan="4" style="text-align: right;">
                <span>조회수 : <%= b.getCount() %></span>
                <br>
                <span>추천  : <%= b.getRecommend() %></span>
              </td>
            </tr>
            </tbody>  
        </table>
        
          <br><br>
  
          <div style="padding-right: 7px;" align="right">
            <a href="<%= contextPath %>/list.bo?cg=<%=b.getCgNo() %>&currentPage=1" class="btn btn-sm">목록가기</a>
            <% if((loginUser != null && loginUser.getMemberId().equals(b.getMemberNo())) || (loginUser.getMemberNo() == 1)){%>
	            <!-- 로그인한 사용자가 게시글 작성자일 경우에만 보여지게끔 -->
	            <a href="<%= contextPath %>/updateForm.bo?bno=<%= b.getBoardNo() %>&cg=<%=b.getCgNo() %>" class="btn btn-sm">수정하기</a>
	            <a href="<%= contextPath %>/delete.bo?bno=<%= b.getBoardNo() %>&cg=<%=b.getCgNo() %>" class="btn btn-sm">삭제하기</a>
            <% } %>
            <br><br>
          </div>
        </div>
        <hr>
        
              <div align="center">
          <br><br><br>
      
          <table id="reply-insert-area">
          	<% if(!b.getCgNo().equals("10")) { %>
          	
          		<tr>
	              <th>댓글쓰기</th>
	            </tr>
	            <tr>
	              <td>
	                <textarea id="replyContent"style="resize: none; width : 100%;" placeholder="댓글 내용을 입력해주세요."></textarea>
	              </td>
	            </tr>
	            <tr>
	              <td align="right">
	                <button type="submit" class="btn btn-sm" onclick="insertReply();">
	                	작성하기
	                </button>
	              </td>
	            </tr>
	           
            <%} %>
          </table>

        </div>
        
        <br>
        <table align="center" style="border-bottom: 1px solid black;" id="reply-area">
          
        </table>
        
        <script>
        	$(function() {
        		
        		// 댓글 리스트 조회용 함수 호출
        		selectReplyList();
        		
        		
        	});
        	
        	function insertReply() {
        		
        		$.ajax({
        			url : "rinsert.bo",
        			type : "post",
        			data : {
        				content : $("#replyContent").val(),
        				bno : <%= b.getBoardNo()%>
        			},
        			success : function(result) {
        				if(result > 0) {
							// 갱신된 댓글리스트를 다시 조회
							selectReplyList();
							
							$("#replyContent").val("");
        				}
        			},
        			error : function() {
        				
        				console.log("댓글 작성용 ajax 실행 오류!")
        			}
        		
        		})
        		
        	}
        	
        	function deleteReply(result) {
				$.ajax ({
					url : "rdelete.bo",
					type : "get",
					data : {rno : result},
					success : function(result) {
        				
        			},
					error : function() {
						
						console.log("댓글 삭제 실패")
					}
				
				})        		
				// 갱신된 댓글리스트를 다시 조회
				selectReplyList();
        	}
        	
        	function selectReplyList() {
        		
        		$.ajax({
	       			url : "rlist.bo",
	       			type : "get",
	       			data : {bno : <%= b.getBoardNo() %> },
	       			success : function(list) { // list : 자바스크립트 변수
      					let resultStr = "";
      					
      					for(let i in list) {
      						// i = 0, 1, 2, ...
      						
      						resultStr += "<tr style='border-bottom: 1px dotted lightgray; border-top: 1px solid black;'>"
      								   + "<input type='hidden' name='replyNo' value='"+list[i].replyNo+"'>"
				      			       +     "<td style='width : 150px; height : 25px;'>" + '작성자 : ' + "<b>" +list[i].memberId + "</b>" + "</td>"
				      			       +     "<td>" +'작성일 : ' +list[i].createDate + "</td>"
				      			       +     "<td>"
				      			       +       "<div align='right'>";
				      			       
				      			       // 자바스크립트의 if문
				      			       if((<%= loginUser.getMemberNo() %> == list[i].memberNo) || (<%= loginUser.getMemberNo() %> == 1)) { 
      			    		resultStr +=  "<a onclick='deleteReply("+list[i].replyNo+");' class='btn btn-sm'>삭제하기</a>"
				      			       }
				      			       
				      		resultStr +=       "</div>"
				      			       +     "</td>"
				      			       +   "</tr>"
				      			       +   "<tr>"
				      			       +     "<td colspan='3'>" + list[i].replyContent + "</td>"
				      			       +   "</tr>";
      					}	
      					$("#reply-area").html(resultStr)
      					
        			},
        			error : function() {
        				
        				console.log("댓글리스트 조회용 ajax 통신 실패!");
        			}
        		})
        	}
        </script>
        
  


      </div>
    </section><!-- End Services Section -->

    <section id="get-started" class="get-started section-bg" style="background-color: white; padding-left: 50px;">
      
    </section>

  </main><!-- End #main -->
  

 


  <!-- 푸터 인클루드-->
 <%@ include file="/views/common/boardFooter.jsp" %>  


</body>

</html>