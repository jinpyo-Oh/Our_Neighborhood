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

    #services {
      background-color : white;
    }
    
    #car_info input {
      width : 300px;
      border : 1px solid lightgray;
      padding : 10px;
      font-size : 16px;
      margin-bottom: 10px;
      border-radius : 5px;
    }

    #content1 {
      border-top: 1px solid lightgray;
      border-left: 1px solid lightgray;
      border-right: 1px solid lightgray ;
     }
    #content2 {
      border-top: 1px solid white;
      border-left: 1px solid lightgray;
      border-right: 1px solid white;
      border-bottom: 1px solid lightgray;
      height: 400px;
      padding-top: 0px;
      padding-right: 100px;
      padding-left: 200px;
    }
    #content3  {
      border-top : 1px solid white;
      border-right: 1px solid lightgray;
      border-left: 1px solid white;
      border-bottom: 1px solid lightgray;
      height: 400px;
      padding-left: 40px;
      padding-right: 50px;
      padding-top: 20px;
      padding-bottom: 120px;
      margin:50px;
    }

    .wrap {
      border : 1px solid lightgray;
      padding: 20px;
      margin-bottom: 20px;
    }
 
    



  </style>
</head>
<body>


<!-- boardHeader 인클루드-->

<%@ include file="../common/boardHeader.jsp" %>
  

  <main id="main">

    <!-- ======= Breadcrumbs ======= -->
    <div class="breadcrumbs d-flex align-items-center" style="background-image: url('./resources/img/board/apartmentpic/apartmentpic.jpg');">
      <div class="container position-relative d-flex flex-column align-items-center" data-aos="fade">

        <h2>차량</h2>
        <ol>
          <li><a href="index.html">메인 페이지</a></li>
          <li>차량등록</li>
          
        </ol>

      </div>
    </div><!-- End Breadcrumbs -->

    <!-- ======= Services Section ======= -->
    <section id="services" class="section-bg">
      <div class="container" data-aos="fade-up">
        <form action="insert.ca">
          <input type="hidden" name="memberNo" value="<%= loginUser.getMemberNo() %>">
        <div class="outer">

          <table id="content" style="width : 100%;" align="center">
            <tr>
              <td id="content1" colspan="2" style="height : 200px;">
                <h1 align="center">이용안내</h1>
                <br>
                <h5 align="center">* 차량은 각 가구당 최대 2대까지 등록이 가능합니다.</h5>
              </td>
            </tr>
            <tr>
            <td id="content2">
              <h3>차량 등록</h3>
              <br>
              <table id="car_info">
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
              <div align="right" style="padding-right: 45px;">
                <button type="reset" class="btn btn-secondary btn-sm"
                        onclick="history.back();">뒤로가기</button>
                <button type="submit" class="btn btn-warning btn-sm">등록하기</button>
                <!-- history.back() : 이전 페이지로 돌아가게 해주는 함수-->
              </div>
          	</td>
              <td id="content3" style="width : 45%;">
                <h3>등록된 차량</h3>
                <br>
                  
                  <% if(list.isEmpty()) { %>
                    <div>
                  			<h5>등록된 차량이 없습니다.</h5>
                      </div>	
                  <% } else { %>
                  	<% for(Car c : list) { %>
                      
	                    <div class="wrap">
		                    <b>차량번호 </b><%= c.getCarResNo() %>
                        <br>
                        <b>차종 </b><%= c.getCarType() %>
                        <br>
                        <b>세대주 </b><%= c.getCarOwner() %>
                        <br>
                        <b>핸드폰 번호 </b><%= m.getPhone()%>
                        <br>
                        <div><b>동-호수 </b><%= m.getAddress() %></div>
                        <a href="delete.ca?rno=<%= c.getCarResNo() %>" class="btn btn-secondary btn-sm" style="text-align: right;">삭제하기</a>
                      </div>                      
                    
                    <%} %>
                  <% } %>
                
              </td>
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