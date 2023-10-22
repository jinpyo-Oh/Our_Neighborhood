<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kh.car_reservation.model.vo.Car
			   , java.util.ArrayList
			   , com.kh.member.model.vo.Member" 
%>
<%
	Member m = (Member)request.getAttribute("m");
	ArrayList<Car> list = (ArrayList<Car>)request.getAttribute("list");
%>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>

  <style>
    
    .contetn_detail textarea, 
    .contetn_detail input {
      box-sizing: border-box;
    }

    
    #car_info input {
      width : 100%;
    }

    #content1,
    #content2,
    #content3  {
      border : 1px solid black
    }

  </style>
</head>
<body>


<!-- boardHeader 인클루드-->

<%@ include file="../common/boardHeader.jsp" %>
  

  <main id="main">

    <!-- ======= Breadcrumbs ======= -->
    <div class="breadcrumbs d-flex align-items-center" style="background-image: url('assets/img/breadcrumbs-bg.jpg');">
      <div class="container position-relative d-flex flex-column align-items-center" data-aos="fade">

        <h2>게시글 작성</h2>
        <ol>
          <li><a href="index.html">메인 페이지</a></li>
          <li>~~게시판</li>
          
        </ol>

      </div>
    </div><!-- End Breadcrumbs -->

    <!-- ======= Services Section ======= -->
    <section id="services" class="section-bg">
      <div class="container" data-aos="fade-up">
        <form action="insert.ca">
          <input type="hidden" name="memberNo" value="<%= loginUser.getMemberNo() %>">
        <div class="outer">

          <table id="content" style="width : 100%; height: 500px;" align="center">
            <tr>
              <td id="content1" colspan="2" style="height : 100%;">
                <h1>이용안내</h1>
                <br>
                <h5>차량은 각 가구당 최대 2대까지 등록이 가능합니다.</h5>
              </td>
            </tr>
            <tr>
            <td id="content2" style="width : 70%;">
              <h3>차량 등록</h3>
              <br>
              <table id="car_info"style="width : 100%; border-bottom : 1px solid black;">
                <tr>
                  <td>차량번호</td>
                  <td>
                    <input type="text" placeholder="차량번호를 입력해주세요." name="carResNo">
                  </td>
                </tr>
                <tr>
                  <td>차종</td>
                  <td>
                  	<input type="text" placeholder="차종을 입력해주세요." name="carType">
                  </td>
                </tr>
                <tr>
	               	<td>세대주</td>
	               	<td>
	               		<input type="text" placeholder="성함을 입력해주세요." name="carOwner">
	               	</td>
                </tr>
              </table>
              <div align="right">
                <button type="submit" class="btn btn-secondary btn-sm">등록하기</button>
                <button type="reset" class="btn btn-warning btn-sm"
                        onclick="history.back();">뒤로가기</button>
                <!-- history.back() : 이전 페이지로 돌아가게 해주는 함수-->
              </div>
          	</td>
              <td id="content3" style="width : 30%;">
                <h3>등록된 차량</h3>
                  <table style="width : 100%;">
                  <% if(list.isEmpty()) { %>
                  	<tr>
                  		<td>
                  			<h5>등록된 차량이 없습니다.</h5>
                  		</td>
                  	</tr> 	
                  <% } else { %>
                  	<% for(Car c : list) { %>
	                    <tr>
		                    <td><%= c.getCarResNo() %></td>
		                    <td><%= c.getCarType() %></td>
	                    </tr>
	                    <tr>
	                      <td colspan="2"><%= c.getCarOwner() %></td>
	                    </tr>
	                    <tr>
	                      <td colspan="2"><%= m.getPhone()%></td>
	                    </tr>
	                    <tr>
	                      <td><div><%= m.getAddress() %></div>
	                      <td><a href="delete.ca?rno=<%= c.getCarResNo() %>"class="btn btn-danger" align="right">삭제하기</a></td>
	                    </tr>
                    <%} %>
                  <% } %>
                  </table>
              </td>
            </tr>
          </table>

        
      
      </div>
    </form>
    </div>

      </div>
    </section><!-- End Services Section -->
    

    <div class="container-fluid container-xl d-flex align-items-center justify-content-between">
      
    </div>

    
    

  </main><!-- End #main -->
  
  <!-- 푸터 인클루드-->
  <%@ include file="../common/boardFooter.jsp" %>
  
</body>

</html>