<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
</head>
<body>

  <!-- boardHeader 인클루드-->

  <%@ include file="/views/common/boardHeader.jsp" %>
  

  <main id="main">

    <!-- ======= Breadcrumbs ======= -->
    <div class="breadcrumbs d-flex align-items-center" style="background-image: url(배경사진);">
      <div class="container position-relative d-flex flex-column align-items-center" data-aos="fade">

        <h2>##</h2>
        <ol>
          <li><a href="index.html">##</a></li>
          <li>##</li>
        </ol>

      </div>
    </div><!-- End Breadcrumbs -->

    <!-- ======= Blog Section ======= -->
    <section id="blog" class="blog">
      <div class="container" data-aos="fade-up" data-aos-delay="100">

        <div class="row gy-4 posts-list">

          <div class="col-xl-4 col-md-6">
            <div class="post-item position-relative h-100">

              <div class="post-img position-relative overflow-hidden" style="height : 300px;" >
                <img src="https://image.edaily.co.kr/images/photo/files/NP/S/2022/11/PS22112100887.jpg" class="img-fluid" alt="" style="height: 100%; width: 100%;" >
                <span class="post-date">12월 23일</span>
              </div>

              <div class="post-content d-flex flex-column">

                <h3 class="post-title">사진 1</h3>


              </div>

            </div>
          </div><!-- End post list item -->

          <div class="col-xl-4 col-md-6">
            <div class="post-item position-relative h-100">

              <div class="post-img position-relative overflow-hidden" style="height : 300px;">
                <img src="https://cdn.weekly.chosun.com/news/photo/202208/21784_42359_1424.jpg" class="img-fluid" alt="" style="height: 100%; width : 100%;">
                <span class="post-date">9월 25일</span>
              </div>

              <div class="post-content d-flex flex-column">

                <h3 class="post-title">사진 2</h3>



              </div>

            </div>
          </div><!-- End post list item -->

          <div class="col-xl-4 col-md-6">
            <div class="post-item position-relative h-100">

              <div class="post-img position-relative overflow-hidden" style="height : 300px;">
                <img src="https://images.unsplash.com/photo-1677913803919-403245fc9d00?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1974&q=80" class="img-fluid" alt=""
                style="height : 100%; width : 100%;">
                <span class="post-date">7월 30일</span>
              </div>

              <div class="post-content d-flex flex-column">

                <h3 class="post-title">사진 3</h3>


              </div>

            </div>
          </div><!-- End post list item -->

          <div class="col-xl-4 col-md-6">
            <div class="post-item position-relative h-100">

              <div class="post-img position-relative overflow-hidden" style="height : 300px;">
                <img src="https://mugem.co.kr/file_data/mugem/2020/06/19/847db1cd23204e2753122bb06ba73f06.jpg" class="img-fluid" alt="" style="height: 100%; width : 100%;">
                <span class="post-date">8월 5일</span>
              </div>

              <div class="post-content d-flex flex-column">

                <h3 class="post-title">사진 4</h3>


              </div>

            </div>
          </div><!-- End post list item -->

          <div class="col-xl-4 col-md-6">
            <div class="post-item position-relative h-100">

              <div class="post-img position-relative overflow-hidden" style="height : 300px;">
                <img src="https://bpbp.co.kr/web/product/tiny/202309/9a4ddb9d30a2574194df39648d981222.jpg" class="img-fluid" alt="" style="height: 100%; width : 100%;">
                <span class="post-date">3월 17일</span>
              </div>

              <div class="post-content d-flex flex-column">

                <h3 class="post-title">사진 5</h3>


              </div>

            </div>
          </div><!-- End post list item -->

          <div class="col-xl-4 col-md-6">
            <div class="post-item position-relative h-100">

              <div class="post-img position-relative overflow-hidden" style="height : 300px;">
                <img src="https://image.zdnet.co.kr/2022/08/23/6af61f258e854de114817b036f017689.jpg" class="img-fluid" alt="" style="height: 100%; width : 100%;">
                <span class="post-date">12월 13일</span>
              </div>

              <div class="post-content d-flex flex-column">

                <h3 class="post-title">사진 6</h3>


              </div>

            </div>
          </div><!-- End post list item -->

          

        </div><!-- End blog posts list -->

<br><br>

<button style="float:right;">글작성</button>

        <br><br><br>
        
        <div class="blog-pagination">
          <ul class="justify-content-center">
            <li><a href="#">1</a></li>
            <li class="active"><a href="#">2</a></li>
            <li><a href="#">3</a></li>
          </ul>
        </div><!-- End blog pagination -->

        
      </div>
      
    </section><!-- End Blog Section -->

  </main><!-- End #main -->

  
  <!-- 푸터 인클루드-->
  <%@ include file="/views/common/boardFooter.jsp" %>
</body>

</html>