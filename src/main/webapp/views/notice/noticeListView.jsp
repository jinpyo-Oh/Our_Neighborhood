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

    #services tr, #services td {

    border-bottom : 1px solid orange;
    border-top: 1px solid orange;
    padding-top: 5px;
    padding-bottom: 5px;
    }
    
    #content_table>tbody>tr:hover {
        background-color: lightgray;
        cursor : pointer;
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

        <h2>게시글 조회</h2>
        <ol>
          <li><a href="index.html">메인 페이지</a></li>
          <li>1단지게시판</li>
        </ol>

      </div>
    </div><!-- End Breadcrumbs -->

    <!-- ======= Services Section ======= -->
    <section id="services" class="section-bg">
      <div class="container" data-aos="fade-up">
        <fieldset>
          <div style="margin-left: 100px;">
            <h2>공지사항</h2>
            <br><br>
          </div>
            <div class="container">
              <div class="row justify-content-between gy-4">
                <div data-aos="fade-up" style="margin:auto">
                  <div class="content">
                    <table style="margin : auto;" id="content_table">
                      <thead>
                        <tr>
                            <th width="400">글제목</th>
                            <th width="200">작성자</th>
                            <th width="200">조회수</th>
                            <th width="200">작성일</th>
                        </tr>
                      </thead>
                      <tbody>
                        <tr>
                          <td>관리사무소에서 안내말씀 드립니다.</td>
                          <td>관리자</td>
                          <td>150</td>
                          <td>2023-12-23</td>
                        </tr>
                        <tr>
                          <td>관리사무소에서 안내말씀 드립니다.</td>
                          <td>관리자</td>
                          <td>150</td>
                          <td>2023-12-23</td>
                        </tr>
                        <tr>
                          <td>관리사무소에서 안내말씀 드립니다.</td>
                          <td>관리자</td>
                          <td>150</td>
                          <td>2023-12-23</td>
                        </tr>
                        <tr>
                          <td>관리사무소에서 안내말씀 드립니다.</td>
                          <td>관리자</td>
                          <td>150</td>
                          <td>2023-12-23</td>
                        </tr>
                        <tr>
                          <td>관리사무소에서 안내말씀 드립니다.</td>
                          <td>관리자</td>
                          <td>150</td>
                          <td>2023-12-23</td>
                        </tr>
                        <tr>
                          <td>관리사무소에서 안내말씀 드립니다.</td>
                          <td>관리자</td>
                          <td>150</td>
                          <td>2023-12-23</td>
                        </tr>
                        <tr>
                          <td>관리사무소에서 안내말씀 드립니다.</td>
                          <td>관리자</td>
                          <td>150</td>
                          <td>2023-12-23</td>
                        </tr>
                        <tr>
                          <td>관리사무소에서 안내말씀 드립니다.</td>
                          <td>관리자</td>
                          <td>150</td>
                          <td>2023-12-23</td>
                        </tr>
                        <tr>
                          <td>관리사무소에서 안내말씀 드립니다.</td>
                          <td>관리자</td>
                          <td>150</td>
                          <td>2023-12-23</td>
                        </tr>
                    </tbody>
                    </table>
                  </div>
              </div>
            </div>
          
        </fieldset>
      </div>
      <script>
        $(function() {
          
          $(".list-area>tbody>tr").click(function() {
            // console.log("잘 클릭 됐나?");
            
            // 클릭했을 때 자손요소 탐색
            // 해당 게시글의 공지사항 번호를 추출해서 넘겨야 함
            // => 해당 tr 요소의 자손 중에서 첫번째 td 영역의 내용이 필요
            let nno = $(this).children().eq(0).text();
            
            // console.log(nno);
            
            // 요청할url 주소?키=밸류&키=밸류&..
            // ? 뒤의 내용들을 "쿼리스트링" 이라고 한다.
            // get 방식의 경우 쿼리스트링이 노출되는 방식임!!
            // location.href 속성으로 요청하면 get 방식임!!
            // => 대놓고 쿼리스트링을 직접 입력하는 방식 
            
            // /jsp/detail.no?nno=클릭했을때의글번호
          location.href = "<%= contextPath %>/detail.no?nno=" + nno;
            
          });
        });
        
        
      </script>
    </section><!-- End Services Section -->

    

  </main><!-- End #main -->
  

 
  <!-- 푸터 인클루드-->
  <%@ include file="../common/boardFooter.jsp" %>

</body>

</html>