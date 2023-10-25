<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
  <style>
    .content_detail tr, .content_detail td {
      border : 1px dotted black;
    }
    
    .contetn_detail textarea, 
    .contetn_detail input {
      box-sizing: border-box;
    }

    tr, td {
      border : 1px solid black;
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

        <h2>게시글 조회</h2>
        <ol>
          <li><a href="index.html">메인 페이지</a></li>
          <li>통합게시판</li>
          <li>자유게시판</li>
        </ol>

      </div>
    </div><!-- End Breadcrumbs -->

    <!-- ======= Services Section ======= -->
    <section id="services" class="section-bg">
      <div class="container" data-aos="fade-up">

        <div class="outer">

          <br>
          <h2 align="center">게시글 작성하기</h2>
          <br>
    
          <table align="center" style="width : 700px;">
            <tr>
              <td style="text-align: center;"><b>제목</b></td>
              <td><input type="text" name="" id="" style="width : 100%; background-color: #f5f6f7;"></td>
            </tr>
            <tr style="height: 500px;">
              <td style="text-align: center;"><b>내용</b></td>
              <td>
                <textarea name="content" 
                                style="resize : none; width : 100%; height: 700px; background-color: #f5f6f7;" 
                                required></textarea>
              </td>
            </tr>
          </table>
        <br><br>

        <div align="center">
          <button type="submit" class="btn btn-secondary btn-sm">등록하기</button>
          <button type="reset" class="btn btn-warning btn-sm"
                  onclick="history.back();">뒤로가기</button>
          <!-- history.back() : 이전 페이지로 돌아가게 해주는 함수-->
        </div>
      
      </div>
    </div>

      </div>
    </section><!-- End Services Section -->
  </main><!-- End #main -->
  

  <!-- 푸터 인클루드-->
  <%@ include file="../common/boardFooter.jsp" %>

</body>

</html>