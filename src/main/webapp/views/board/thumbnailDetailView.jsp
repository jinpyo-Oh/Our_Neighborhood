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
      border : 1px solid black;
    }
    
    .section input[id*="slide"] {
      display:none;
    }
    .section .slidewrap {
      max-width : 800px;
      margin:0 auto;
      overflow:hidden;
    }
    .section .slidelist {
      white-space:nowrap;
      font-size:0;
    }
    .section .slidelist > li {
      display:inline-block;
      vertical-align:middle;
      width:100%;
      transition:all .5s; 
    }
    .section .slidelist > li > a {
      display:block;
      position:relative;
    }
    .section .slidelist > li > a img {
      width : 100%;
    }
    .section .slidelist label {
      position:absolute;
      z-index : 10;
      top : 50%;
      transform : translateY(-50%);
      padding: 50px;
      padding-top: 100%;
      cursor:pointer;
    }
    .section .slidelist .left{
      left: 30px;
      background:url('./img/left.png') center center / 100% no-repeat;
    }
    .section .slidelist .right{
      right:30px;
      background:url('./img/right.png') center center 
    }

    .section [id="slide01"]:checked ~ .slidewrap .slidelist > li {transform:translateX(0%);}
    .section [id="slide02"]:checked ~ .slidewrap .slidelist > li {transform:translateX(-100%);}
    .section [id="slide03"]:checked ~ .slidewrap .slidelist > li {transform:translateX(-200%)}
    
    .section .slide-control [class*="control"] {display:none;}
    .section [id="slide01"]:checked ~ .slidewrap .control01 {display:block;}
    .section [id="slide02"]:checked ~ .slidewrap .control02 {display:block;}
    .section [id="slide03"]:checked ~ .slidewrap .control03 {display:block;}
    ul {
      white-space:nowrap;
    }
    li {
      display : inline-block;
    }
  </style>
</head>

<body>

<!-- boardHeader 인클루드-->

<%@ include file="/views/common/boardHeader.jsp" %>
  
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
                  <td>김말똥</td>
                  <th>작성일</th>
                  <td>2023-06-23</td>
              </tr>
          </table>

          
          
          <br>
          <div style="padding-right: 18%;" align="right">
            <a href="" class="btn btn-sm">수정하기</a>
            <a href="" class="btn btn-sm">삭제하기</a>
            <hr>
            <br>
          </div>
          
         
        
        
          <div class="section">
            <input type="radio" name="slide" id="slide01" checked>
            <input type="radio" name="slide" id="slide02">
            <input type="radio" name="slide" id="slide03">
          
            <div class="slidewrap">
              <ul class="slidelist" style="padding-left: 0px;">
                <li>
                  <a>
                    <label for="slide03" class="left"></label>
                    <img src="assets/img/365706.jpg" width = "400px;" height="400px">
                    <label for="slide02" class="right"></label>
                  </a>
                </li>
                <li>
                  <a>
                    <label for="slide01" class="left"></label>
                    <img src="assets/img/365738.jpg" width = "400px;" height="400px">
                    <label for="slide03" class="right"></label>
                  </a>
                </li>
                <li>
                  <a>
                    <label for="slide02" class="left"></label>
                    <img src="assets/img/DBW1682920361359-850.jpg" width = "400px;" height="400px">
                    <label for="slide01" class="right"></label>
                  </a>
                </li>
              </ul>
            </div>
          </div>
                    <br>
          
          <table align="center"  style="width : 700px; table-layout: fixed;">
  
            <p style="padding-left : 170px;">
              asdassads
            </p>
            <div style= "text-align : center;">
              <a href="" class="btn btn-sm">목록가기</a>
            </div>
        </table>
         
        <hr>

        
     

        <br><br>
        <table align="center" style="border-bottom: 1px solid black;">
          <tr style="border-bottom: 1px dotted lightgray; border-top: 1px solid black;">
            <td style="width : 150px;">닉네임</td>
            <td>작성일</td>
            <td>
              <div align="right">
                <a href="" class="btn btn-sm">수정하기</a>
                <a href="" class="btn btn-sm">삭제하기</a>
              </div>
            </td>
          </tr>
          <tr>
            <td colspan="3">댓글내용댓글내용댓글내용댓글내용댓글내용댓글내용댓글내용댓글내용댓글내용댓글내용댓글내용댓글내용댓글내용</td>
          </tr>
          <tr style="border-bottom: 1px dotted lightgray; border-top: 1px solid black;">
            <td style="width : 150px;">닉네임</td>
            <td>작성일</td>
            <td>
              <div align="right">
                <a href="" class="btn btn-sm">수정하기</a>
                <a href="" class="btn btn-sm">삭제하기</a>
              </div>
            </td>
          </tr>
          <tr>
            <td colspan="3">댓글내용댓글내용댓글내용댓글내용댓글내용댓글내용댓글내용댓글내용댓글내용댓글내용댓글내용댓글내용댓글내용</td>
          </tr>
        </table>
        
        <div align="center">
          <br><br><br>
          <table>
            <tr>
              <td>댓글쓰기</td>
            </tr>
            <tr>
              <td>
                <textarea style="resize: none; width : 800px;" ></textarea>
              </td>
            </tr>
            <tr>
              <td>
                <button type="submit">작성하기</button>
              </td>
            </tr>
          </table>

        </div>


      </div>
    </section><!-- End Services Section -->

    <section id="get-started" class="get-started section-bg" style="background-color: white; padding-left: 50px;">
      
    </section>

  </main><!-- End #main -->
  
  

  <!-- 푸터 인클루드-->
  <%@ include file="/views/common/boardFooter.jsp" %>

</body>

</html>