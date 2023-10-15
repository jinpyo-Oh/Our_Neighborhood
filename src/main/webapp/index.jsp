<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.member.model.vo.Member" %>


<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>UpConstruction Bootstrap Template - Index</title>
  <meta content="" name="description">
  <meta content="" name="keywords">


</head>

<body>


    
    <%@ include file="views/common/boardHeader.jsp" %>
      

  <!-- ======= Hero Section ======= -->
  <section id="hero" class="hero">

    <div class="info d-flex align-items-center">
      <div class="container">
        <div class="row justify-content-center">
          <div class="col-lg-6 text-center">
            <h2 data-aos="fade-down">Our <span>Neighborhood</span></h2>
            <p data-aos="fade-up">아파트 입주민들만을 대상으로 입주민의 스마트 라이프를 위한 생활편의 <br> 서비스와 관리사무소의 안정적인 업무처리를 돕는 스마트 웹페이지</p>
            <a data-aos="fade-up" data-aos-delay="200" href="#features" class="btn-get-started">소개</a>
          </div>
        </div>
      </div>
    </div>

    <div id="hero-carousel" class="carousel slide" data-bs-ride="carousel" data-bs-interval="5000">

      <div class="carousel-item active" style="background-image: url(resources/img/hero-carousel/67829763.1.jpg)"></div>
      <div class="carousel-item" style="background-image: url(resources/img/hero-carousel/365738.jpg)"></div>
      <div class="carousel-item" style="background-image: url(resources/img/hero-carousel/823304_846424_81.jpg)"></div>
      <div class="carousel-item" style="background-image: url(resources/img/hero-carousel/36130_37014_2213.jpg)"></div>
      <div class="carousel-item" style="background-image: url(resources/img/hero-carousel/20210203104910.jpg)"></div>


      <a class="carousel-control-prev" href="#hero-carousel" role="button" data-bs-slide="prev">
        <span class="carousel-control-prev-icon bi bi-chevron-left" aria-hidden="true"></span>
      </a>

      <a class="carousel-control-next" href="#hero-carousel" role="button" data-bs-slide="next">
        <span class="carousel-control-next-icon bi bi-chevron-right" aria-hidden="true"></span>
      </a>

    </div>

  </section><!-- End Hero Section -->

  <main id="main">

    

    <!-- ======= Features Section ======= -->
    <section id="features" class="features section-bg">
      <div class="container" data-aos="fade-up">

        <ul class="nav nav-tabs row  g-2 d-flex">

          <li class="nav-item col-3">
            <a class="nav-link active show" data-bs-toggle="tab" data-bs-target="#tab-1">
              <h4>아파트소개</h4>
            </a>
          </li><!-- End tab nav item -->

          <li class="nav-item col-3">
            <a class="nav-link" data-bs-toggle="tab" data-bs-target="#tab-2">
              <h4>위치</h4>
            </a><!-- End tab nav item -->

          <li class="nav-item col-3">
            <a class="nav-link" data-bs-toggle="tab" data-bs-target="#tab-3">
              <h4>바베큐장</h4>
            </a>
          </li><!-- End tab nav item -->

          <li class="nav-item col-3">
            <a class="nav-link" data-bs-toggle="tab" data-bs-target="#tab-4">
              <h4>이벤트 및 행사</h4>
            </a>
          </li><!-- End tab nav item -->

        </ul>

        <div class="tab-content">

          <div class="tab-pane active show" id="tab-1">
            <div class="row">
              <div class="col-lg-6 order-2 order-lg-1 mt-3 mt-lg-0 d-flex flex-column justify-content-center" data-aos="fade-up" data-aos-delay="100">
                <h3>kh 아파트 소개</h3>
                <p class="fst-italic">
                  
                </p>
                <ul>
                  <li><i class="bi bi-check2-all"></i> 2023년에 완공된 로얄 아파트 </li>
                  <li><i class="bi bi-check2-all"></i> 최신식 바베큐장 소유 </li>
                  <li><i class="bi bi-check2-all"></i> 차량 5000대 까지 주차 가능한 지하 주차장 보유 </li>
                </ul>
              </div>
              <div class="col-lg-6 order-1 order-lg-2 text-center" data-aos="fade-up" data-aos-delay="200">
                <img src="resources/img/board/21905_48917_2247.png" alt="" class="img-fluid">
              </div>
            </div>  
          </div><!-- End tab content item -->

          <div class="tab-pane" id="tab-2">
            <div class="row">
              <div class="col-lg-6 order-2 order-lg-1 mt-3 mt-lg-0 d-flex flex-column justify-content-center">
                <h3>위치</h3>

                <ul>
                  <li><i class="bi bi-check2-all"></i> 양화대교와 국회의사당이 탁 트인 뷰 </li>
                  <li><i class="bi bi-check2-all"></i> 걸어서 5분거리에 위치한 양화한강공원</li>
                </ul>
              </div>
              <div class="col-lg-6 order-1 order-lg-2 text-center">
                <img src="resources/img/board/20190219094042914zzqc.jpg" alt="" class="img-fluid">
              </div>
            </div>
          </div><!-- End tab content item -->

          <div class="tab-pane" id="tab-3">
            <div class="row">
              <div class="col-lg-6 order-2 order-lg-1 mt-3 mt-lg-0 d-flex flex-column justify-content-center">
                <h3>바베큐장</h3>
                <ul>
                  <li><i class="bi bi-check2-all"></i>kh아파트 주민만이 이용할 수 있는 바베큐장</li>
                  <li><i class="bi bi-check2-all"></i> 최대 9가구가 이용가능한 최신 캠핑용 바베큐장</li>
                  <li><i class="bi bi-check2-all"></i> 예약 시 예약메세지에서 요구 할 수 있는 참숯 및 각종 조미료 요청 가능! </li>
                  <li><i class="bi bi-check2-all"></i> <b>선착순</b>으로 예약되는 자유로운 바베큐장 이용 </li>
                </ul>
              </div>
              <div class="col-lg-6 order-1 order-lg-2 text-center">
                <img src="resources/img/board/2635AB4B5771E63434.jpg" alt="" class="img-fluid">
              </div>
            </div>
          </div><!-- End tab content item -->

          <div class="tab-pane" id="tab-4">
            <div class="row">
              <div class="col-lg-6 order-2 order-lg-1 mt-3 mt-lg-0 d-flex flex-column justify-content-center">
                <h3>이벤트 및 행사</h3>
            
                <ul>
                  <li><i class="bi bi-check2-all"></i> 매년 12월에 하는 불꽃놀이 축제</li>
                  <li><i class="bi bi-check2-all"></i> 일주일에 한번 시행하는 토요 장터</li>
                  <li><i class="bi bi-check2-all"></i> 매월 둘째주 일요일 주민센터에서 진행하는 영화상영</li>
                </ul>
              </div>
              <div class="col-lg-6 order-1 order-lg-2 text-center">
                <img src="resources/img/board/festival.jpg" alt="" class="img-fluid">
              </div>
            </div>
          </div><!-- End tab content item -->

        </div>

      </div>
    </section><!-- End Features Section -->

    <section id="contact" class="contact">
      <div class="container" data-aos="fade-up" data-aos-delay="100">

        <div class="row gy-4">
          <div class="col-lg-6">
            <div class="info-item  d-flex flex-column justify-content-center align-items-center">
              <i class="bi bi-map"></i>
              <h3>주소</h3>
              <p>서울특별시 영등포구 선유동2로 57</p>
            </div>
          </div><!-- End Info Item -->

          <div class="col-lg-3 col-md-6">
            <div class="info-item d-flex flex-column justify-content-center align-items-center">
              <i class="bi bi-envelope"></i>
              <h3>이메일</h3>
              <p>khapt@naver.com</p>
            </div>
          </div><!-- End Info Item -->

          <div class="col-lg-3 col-md-6">
            <div class="info-item  d-flex flex-column justify-content-center align-items-center">
              <i class="bi bi-telephone"></i>
              <h3>전화번호</h3>
              <p>02) 9999-9999</p>
            </div>
          </div><!-- End Info Item -->

        </div>

        <div class="row gy-4 mt-1">

          <div class="col-lg-6 ">
            <iframe src="https://www.google.com/maps/embed?pb=!1m14!1m8!1m3!1d12655.606685823843!2d126.8969784!3d37.5338151!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x357c9ec3afcd675b%3A0x1d3b8e50a735e00a!2z7J2066CI67mM65Sp!5e0!3m2!1sko!2skr!4v1695632077484!5m2!1sko!2skr" width="600" height="450" style="border:0; width: 100%; height: 384px;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
          </div><!-- End Google Maps -->

          <div class="col-lg-6">

              
            <div class="info-item  d-flex flex-column justify-content-center align-items-center">
              <i class="bi bi-telephone"></i>
              <h3>버스</h3>
              <p>101번, 102번, 301번</p>
            </div>
            <div class="info-item  d-flex flex-column justify-content-center align-items-center">
              <i class="bi bi-telephone"></i>
              <h3>지하철</h3>
              <p>당산역 13번 출구에서 도보 10분</p>
            </div>

          </div><!-- End Contact Form -->

        </div>

      </div>
    </section>
  </main><!-- End #main -->

 
 <!-- 푸터 인클루드-->
 
            <%@ include file="views/common/boardFooter.jsp" %>
              



</body>


</html>