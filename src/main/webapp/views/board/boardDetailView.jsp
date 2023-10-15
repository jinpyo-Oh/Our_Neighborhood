<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
 <meta charset="utf-8">
  <title>boardDetailView</title>

 
  <style>
    .outer {
      border : 1px solid black;
    }
    .content_detail tr, .content_detail td {
      border : 1px solid black;
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
              <tr>
                  <th>내용</th>
                  <td colspan="3">
                      <p>
                        
                      </p>
                  </td>
              </tr>
          </table>
  
          <br><br>
  
          <div style="padding-right: 18%;" align="right">
            <a href="" class="btn btn-sm">목록가기</a>
            <a href="" class="btn btn-sm">수정하기</a>
            <a href="" class="btn btn-sm">삭제하기</a>
            <br><br>
          </div>
        </div>
        <hr>

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
 <%@ include file="../common/boardFooter.jsp" %>  


</body>

</html>