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
        width : 1200px;
        height : 1200px;
        margin : auto;
        border : 1px solid lightgray;
    }

    .wrap2 {
      border : 1px solid lightgray;
      margin : auto;
      text-align: center;
      width : 700px;
      padding-left: 100px;
    }
    .nav-area { 
        background-color : #f4c005; 
        width : 1200px;
    }
    .menu {
        width: 1200px;
        height:15px;
        display : inline;
        padding-left: 200px;
        padding-right: 30px;
    }
    .menu a {
        text-decoration : none;
        color : white;
        font-size : 20px;
        font-weight : bold;
        width : 100%;
        
    }
    .menu a:hover { background-color : darkgray; }

    table {
        border-collapse: collapse;
        width: 500px;
        margin: 1rem auto;
        margin-left: 15px;
        background-color: white;
    }

    thead{
      box-shadow: 4px 4px 10px rgba(0,0,0,0.1);
    }

    /* 테이블 행 */
    td {
      padding: 8px;
      text-align: left;
      border-top: 1px solid #ddd;
      border-bottom: 1px solid #ddd;
      text-align: center;
    }

    th {
      padding: 8px;
      text-align: left;
      text-align: center;
      border-top: 2px solid #000;
      border-bottom: 2px solid #000;
      color: #000;
    }

    /* 테이블 비율 */
    th:nth-child(1),
    td:nth-child(1) {
      width: 25%;
    }

    th:nth-child(2),
    td:nth-child(2) {
      width: 25%;
    }

    th:nth-child(3),
    td:nth-child(3) {
      width: 25%;
    }

    th:nth-child(3),
    td:nth-child(3) {
      width: 25%;
    }

    th, td {
      border-left: none;
      border-right: none;
    }

    h5{
      margin-right: 30px;
      margin-top: 30px;
    }

    .button {
      margin-left: 1000px;
      margin-bottom: 20px;
    }


            
</style>
</head>
<body>


<!-- boardHeader 인클루드-->

<%@ include file="../common/boardHeader.jsp" %>

  <main id="main">

    <!-- ======= Breadcrumbs ======= -->
    <div class="breadcrumbs d-flex align-items-center" style="background-image: url('assets/img/chuncheonlakecity_940x350.jpg');">
      <div class="container position-relative d-flex flex-column align-items-center" data-aos="fade">
        <h2>관리비 납부</h2>
        <ol>
            <li><a href="index.html">Home</a></li>
        </ol>
        </div>
    </div><!-- End Breadcrumbs -->

    <!-- ======= Contact Section ======= -->
    <section id="contact" class="contact">
        <div class="wrap">
          <div class="nav-area" align="auto">
            <div class="menu"><a href="mypage.html">회원정보수정</a></div>
            <div class="menu"><a href="cost.html">관리비 조회</a></div>
            <div class="menu"><a href="member-delete.html">회원탈퇴</a></div>
          </div>

          <div class="container" data-aos="fade-up" data-aos-delay="100">
            
          <div class="eidtForm">
             <form action="" method="post">
              <br><br>
                  <div class="wrap2" sytle="align-items-center">
                    <h5 align="center"><b>월별 관리비 고지서</b></h5><br>
                    <table align="center">
                      <thead>
                        <tr>
                          <th>기준월</th>
                          <th>동-호수</th>
                        </tr>
                      </thead>
                      <tbody>
                        <tr>
                          <td><input type="month" name="monthIn"></td>
                          <td>103동 101호</td>
                        </tr>
                        </tbody>
                      </div>
                    </table> 
                    <br><br>
                    
                    <table align="center">
                      <tbody>
                        <tr>
                          <th>항목</th>
                          <th>금액</th>
                          <th>전월</th>
                          <th>증감</th>
                        </tr>
                        <tr>
                          <td>일반관리비</td>
                          <td>22,640</td>
                          <td>22,000</td>
                          <td style="color:red">▲640</td>
                        </tr>
                        <tr>
                          <td>청소비</td>
                          <td>7,840</td>
                          <td>7,000</td>
                          <td style="color:red">▲840</td>
                        </tr>
                        <tr>
                          <td>소독비</td>
                          <td>760</td>
                          <td>500</td>
                          <td style="color:red">▲260</td>
                        </tr>
                        <tr>
                          <td>승강기유지비</td>
                          <td>1,870</td>
                          <td>1,870</td>
                          <td>0</td>
                        </tr>
                        <tr>
                          <td>수선유지비</td>
                          <td>3,440</td>
                          <td>3,250</td>
                          <td style="color:red">▲190</td>
                        </tr>
                        <tr>
                          <td>장기수선충당금</td>
                          <td>12,550</td>
                          <td>12,500</td>
                          <td>0</td>
                        </tr>
                        <tr>
                          <td>경비용역비</td>
                          <td>19,630</td>
                          <td>19,630</td>
                          <td>0</td>
                        </tr>
                        <tr>
                          <td>위탁관리수수료</td>
                          <td>970</td>
                          <td>800</td>
                          <td style="color:red">▲170</td>
                        </tr>
                        <tr>
                          <td>화재보험료</td>
                          <td>500</td>
                          <td>500</td>
                          <td>0</td>
                        </tr>
                        <tr>
                          <td>세대전기료</td>
                          <td>3,890</td>
                          <td>2,350</td>
                          <td style="color:red">▲1,540</td>
                        </tr>
                        <tr>
                          <td>공동전기료</td>
                          <td>1,940</td>
                          <td>1,940</td>
                          <td>0</td>
                        </tr>
                        <tr>
                          <td>승강기전기</td>
                          <td>2,500</td>
                          <td>2,500</td>
                          <td>0</td>
                        </tr>
                        <tr>
                          <td>TV수신료</td>
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
                          <td>난방비</td>
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
                  </div>
                </form>
            </div>
        </div>
    </section><!-- End Contact Section -->

    </main><!-- End #main -->

 

   <!-- 푸터 인클루드-->
  <%@ include file="../common/boardFooter.jsp" %>
</body>