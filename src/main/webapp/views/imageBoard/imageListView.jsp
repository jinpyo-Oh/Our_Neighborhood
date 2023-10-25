<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
    
<%@ page import="java.util.ArrayList, com.kh.imageBoard.model.vo.Board, com.kh.common.model.vo.PageInfo" %> 
<%
	
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
	case "8" : cgName="홍보"; break;
	case "9" : cgName="분실물"; break;
	case "10" : cgName="공지사항"; break;
	}
		
	
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
</head>
<body>

  <!-- boardHeader 인클루드-->

  <%@ include file="/views/common/boardHeader.jsp" %>
  

  <main id="main">

    <!-- ======= Breadcrumbs ======= -->
    <div class="breadcrumbs d-flex align-items-center" style="background-image: url('./resources/img/board/apartmentpic/apartmentpic.jpg');">
      <div class="container position-relative d-flex flex-column align-items-center" data-aos="fade">

        <h2><%=cgName %> 게시판</h2>
        <ol>
          <li><a href="index.jsp">메인페이지</a></li>
          <li><%=cgName %></li>
        </ol>

      </div>
    </div><!-- End Breadcrumbs -->

    <!-- ======= Blog Section ======= -->

    <section id="blog" class="blog">
      <div class="container" data-aos="fade-up" data-aos-delay="100">

        <div class="row gy-4 posts-list">

		<% if(list.isEmpty()) { %>
		등록된 게시글이 없습니다.
		
		<% } else { %>
			<% for(Board b : list) { %>
          <div class="col-xl-4 col-md-6">
            <div class="post-item position-relative h-100 content">
			<input type="hidden" value="<%= b.getBoardNo() %>">
			
              <div class="post-img position-relative overflow-hidden" style="height : 300px;" >
                <img src="<%= b.getTitleImg() %>" class="img-fluid" alt="" style="height: 100%; width: 100%;" >
                <span class="post-date"><%= b.getCreateDate() %></span>
              </div>

              <div class="post-content d-flex flex-column">

                <h3 class="post-title"><%= b.getBoardTitle() %></h3>
                <div align="right">
                
                <p align="left">
                조회수 : <%= b.getCount() %> <br>
                추천수 :  <%= b.getRecommend() %><br>
                
                </p>
                
               </div>
               

              </div>

            </div>
          </div><!-- End post list item -->
		<% } %>
	<% } %>
          

        </div><!-- End blog posts list -->

		<script>
		
		
		$(function() {
					
				$(".content").on("click",function(){
					
					let bno = $(this).children().eq(0).val();
					
					location.href = "<%= contextPath %>/imageDetail.bo?cg=<%=cgNo%>&bno=" + bno;
				});
							
				});
		
		
		
		</script>


<br><br>
<!-- admin일 경우 삭제할 수 있게끔 하는거

 

<button type="delete" style="float:right;" onclick="location.href='<%= contextPath %>/lostdelete.th'">삭제</button>


-->

<% if(loginUser != null) { %>
<!-- 로그인한 회원만 글작성 버튼이 보여지게끔 -->

<button type="submit" style="float:right;" onclick="location.href='<%= contextPath %>/imageEnroll.bo?cg=<%=cgNo%>'">
글작성</button>

<% } %>
        <br><br><br>
        

        
      </div>
      
      
      <!-- 페이징바 -->
        <div class="paging-area" align="center">
        	
        	<% if(currentPage != 1) { %>
        	
        	<button onclick="location.href='<%= contextPath %>/imageList.bo?cg=<%= cgNo %>&currentPage=<%= currentPage - 1 %>'">
        		&lt;
        	</button>
        	
        	<% } %>
        
            <% for(int p = startPage; p <= endPage; p++ ) { %>
            
            	<% if(p != currentPage) { %>
            	
            		<button onclick="location.href='<%= contextPath %>/imageList.bo?cg=<%= cgNo %>&currentPage=<%= p %>'"><%= p %></button>
            	
            	<% } else { %>
            	
            		<!-- 현재 내가 보고있는 페이지일 경우 클릭 안되게끔 -->
            		<button disabled><%= p %></button>
            		
            	<% } %>
            	
            <% } %>
            
            <% if(currentPage != maxPage) { %>
            
            <button onclick="location.href='<%= contextPath %>/imageList.bo?cg=<%= cgNo %>&currentPage=<%= currentPage + 1 %>'">
            	&gt;
            </button>
            
            <% } %>
            
        </div>
      
    </section><!-- End Blog Section -->

  </main><!-- End #main -->

  
  <!-- 푸터 인클루드-->
  <%@ include file="/views/common/boardFooter.jsp" %>
</body>

</html>