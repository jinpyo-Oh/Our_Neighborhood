<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
  <style>
    .wrap {
      width: 1200px;
      height: 800px;
      margin: auto;
      border: 1px solid lightgray;
    }

    .nav-area {
      background-color: #f4c005;
      width: 1200px;
    }

    .menu {
      width: 1200px;
      height:15px;
      display : inline;
      padding-left: 100px;
      padding-right: 50px;
    }

    .menu a {
      text-decoration : none;
      color : white;
      font-size : 20px;
      font-weight : bold;
      width : 100%;    
    }
      
    .menu a:hover { 
      background-color : darkgray; 
    }

    .wrap2 {
      width: 1000px;
      height: 700px;
      margin-top: 35px;
      margin-left: 80px;
      margin-right: 80px;
      border: 1px solid lightgray;
      padding: 15px;
    }

    #table1 th {
      padding: 8px;
      border-top: 2px solid #000;
      border-bottom: 2px solid #000;
      color: #000;
      text-align: center;
    }
    #table1 td {
      padding: 8px;
      border-bottom: 1px solid #ddd;
      text-align: center;
    }

    #table2 { 
      margin-left : 100px; 
      width: 450px;
    }
    #table2 th {
      padding: 8px;
      border-top: 2px solid #000;
      border-bottom: 2px solid #000;
      color: #000;
      text-align: center;
    }
    #table2 td {
      padding: 8px;
      border-bottom: 1px solid #ddd;
      text-align: center;
    }

    #table3 { 
      margin-right : 140px; 
    }
    #table3 th {
      padding: 8px;
      border-top: 2px solid #000;
      border-bottom: 2px solid #000;
      color: #000;
    }
    #table3 td {
      padding: 8px;
      border-bottom: 1px solid #ddd;
    }

    #table4 {
      margin-right : 140px; 
      margin-top: 80px;
      width: 730px;
    }
    #table4 th {
      padding: 8px;
      border-top: 2px solid #000;
      border-bottom: 2px solid #000;
      color: #000;
      text-align: right;
    }

  </style>
</head>
<body>


      <!-- boardHeader 인클루드-->

      <%@ include file="../common/boardHeader.jsp" %>

      <% 
        int address2  = loginUser.getAddress2();
        String address  = loginUser.getAddress();
      %>


  <main id="main">

    <!-- ======= Breadcrumbs ======= -->
    <div class="breadcrumbs d-flex align-items-center" style="background-image: url('<%= contextPath %>/resources/img/chuncheonlakecity_940x350.jpg');">
      <div class="container position-relative d-flex flex-column align-items-center" data-aos="fade">
        <h2>관리비 조회</h2>
        <ol>
            <li><a href="index.html">Home</a></li>
        </ol>
        </div>
    </div><!-- End Breadcrumbs -->

    <!-- ======= Contact Section ======= -->
    <section id="contact" class="contact">
        <div class="wrap">
          <div class="nav-area" align="auto">
            <div class="menu"><a href="<%= contextPath %>/views/member/mypageView.jsp">회원정보수정</a></div>
            <div class="menu"><a href="<%= contextPath %>/views/member/memberCostView.jsp">관리비 조회</a></div>
            <div class="menu"><a href="bbq.html">바베큐 예약/취소</a></div>
            <div class="menu"><a href="<%= contextPath %>/views/member/memberDeleteForm.jsp">회원탈퇴</a></div>
          </div>

          <div class="container" data-aos="fade-up" data-aos-delay="100">
            
          <div class="wrap2">
            <br><br>
            <h5 align="center"><b>월별 관리비 고지서</b></h5>
            <br>

              <table id="table1" align="center">
                <thead>
                  <tr>
                    <th>단지</th>
                    <th>동-호수</th>
                    <th>기준월</th>
                  </tr>
                </thead>
                <tbody>
                  <tr>
                    <td>
                      <input type="text" name="address2" disabled value="<%= address2 %>">
                    </td>
                    <td>
                      <input type="text" name="address" disabled value="<%= address %>">
                    </td>
                    <td>
                      <form>
					  <input type='month' id='currnetMonth'>
					  </form>
					
					  <script>
					  document.getElementById('currnetMonth').value= new Date().toISOString().slice(0, 7);
					  </script>
                    </td>
                  </tr>
                  </tbody>
              </table>
            <br><br>

              <table id="table2" align="left">
                <tbody>
                  <tr>
                    <th>항목</th>
                    <th>금액</th>
                    <th>전월</th>
                    <th>증감</th>
                  </tr>
                  <tr>
                    <td>공동관리비</td>
                    <td>87,640</td>
                    <td>87,200</td>
                    <td style="color:red">▲440</td>
                  </tr>
                  <tr>
                    <td>세대전기료</td>
                    <td>2,000</td>
                    <td>1,800</td>
                    <td style="color:red">▲200</td>
                  </tr>
                  <tr>
                    <td>세대수도료</td>
                    <td>12,600</td>
                    <td>12,300</td>
                    <td style="color:red">▲300</td>
                  </tr>
                  <tr>
                    <td>세대난방비</td>
                    <td>20,900</td>
                    <td>18,560</td>
                    <td style="color:red">▲2,340</td>
                  </tr>
                  <tr>
                    <th></th>
                    <th></th>
                    <th>총 합계</th>
                    <th>112,230</th>
                  </tr>
                  </tbody>
              </table>

              <table id="table3" align="right">
                <tbody>
                  <tr>
                    <th>입금계좌</th>
                  </tr>
                  <tr>
                    <td>농협 110-123-741203</td>
                  </tr>
                  <tr>
                    <td>신한 220-321-369874</td>
                  </tr>
                  <tr>
                    <td>우리 330-654-258741</td>
                  </tr>
                  <tr>
                    <td>기업 440-753-970654</td>
                  </tr>
                  <tr>
                    <th>예금주 OURNEIGHBORHOOD</th>
                  </tr>
                </tbody>
              </table>

              <table id="table4" align="right">
                <tbody>
                  <tr>
                    <th>문의사항 02-789-9430</th>
                  </tr>
                </tbody>
              </table>
    

          </div>

        </div>
    </section><!-- End Contact Section -->

  </main><!-- End #main -->

 

      <!-- 푸터 인클루드-->
      <%@ include file="../common/boardFooter.jsp" %>
</body>