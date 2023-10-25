<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
  <style>
    .outer {
      border : 1px solid black;
    }
    .content_detail tr, .content_detail td {
      border : 1px dotted black;
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

        <div class="content_detail">

          <br>
          <h2 align="center">게시글 상세보기</h2>
          <br>
  
          <table id="detail-area" align="center"  style="width : 700px; table-layout: fixed;">
  
              <tr>
                  <th width="100">제목</th>
                  <td width="700" colspan="3">
                      제목입니다.제목입니다.제목입니다.
                  </td>
              </tr>
              <tr>
                  <th>작성자</th>
                  <td>admin</td>
                  <th>작성일</th>
                  <td>2023-06-23</td>
              </tr>
              <tr>
                  <th>내용</th>
                  <td colspan="3">
                      <p>
                        
                      </p>
                  </td>
              </tr>
          </table>
  
          <br><br>
  
          <div align="center">
            <a href="" class="btn btn-sm">목록가기</a>
            <a href="" class="btn btn-sm">수정하기</a>
            <a href="" class="btn btn-sm">삭제하기</a>
            <br><br>
        </div>
      </div>

      </div>
    </section><!-- End Services Section -->

  </main><!-- End #main -->
  

  <!-- 푸터 인클루드-->
  <%@ include file="../common/boardFooter.jsp" %>
  

</body>

</html>