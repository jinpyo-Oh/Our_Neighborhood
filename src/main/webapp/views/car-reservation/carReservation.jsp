<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

        <div class="outer">

          <table id="content" style="width : 100%; height: 500px;" align="center">
            <tr>
              <td id="content1" colspan="2" style="height : 100%;">
                <h1>이용안내</h1>
                <br>
                <h5>차량은 각 가구당 최대 2대까지 등록이 가능하며, 등록 시 지정 구역과 좌석을 알려주는건가요?</h5>
              </td>
            </tr>
            <tr>
              <td id="content2" style="width : 70%;">
                <h3>차량 등록</h1>
                <br>
                <table id="car_info"style="width : 100%; border-bottom : 1px solid black;">
                  <tr>
                    <td>차량번호</td>
                    <td>
                      <input type="text" placeholder="차량번호를 입력해주세요.">
                    </td>
                  </tr>
                  <tr>
                    <td>차종</td>
                    <td>
                      <input type="text" placeholder="차종을 입력해주세요.">
                    </td>
                  </tr>
                  <tr>
                    <td>연락처</td>
                    <td>
                      <input type="text" placeholder="연락처를 입력해주세요 (- 제외)">
                    </td>
                  </tr>
                </table>
                <b>개인정보 수집에 대한 동의</b>
                <br>
                본 아파트에 입주하는 고객님들께서는 ??조 ??항에 관한 법률에 의거하여 이용약관을 지켜주실것에 대한 동의가 필요합니다.
                <br>
                <input type="checkbox"> 동의합니다.
                <br>
                <div align="right">
                  <button type="submit" class="btn btn-secondary btn-sm">등록하기</button>
                  <button type="reset" class="btn btn-warning btn-sm"
                          onclick="history.back();">뒤로가기</button>
                  <!-- history.b  ack() : 이전 페이지로 돌아가게 해주는 함수-->
                </div>
              </td>
              <td id="content3" style="width : 30%;">
                <h3>등록된 차량</h3>
                  <table style="width : 100%;">
                    <tr>
                      <td rowspan="4" style="width : 30%;">사용자이미지</td>
                      <td>
                        차량번호 차종
                      </td>
                    </tr>
                    <tr>
                      <td>이름</td>
                    </tr>
                    <tr>
                      <td>연락처</td>
                    </tr>
                    <tr>
                      <td>
                        <div>102동 1102호</div>
                        <button align="right">삭제하기</button>
                      </td>
                    </tr>
                  </table>
              </td>
            </tr>
          </table>

        
      
      </div>
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