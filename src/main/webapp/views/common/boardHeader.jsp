<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.member.model.vo.Member" %>
<%
	Member loginUser = (Member)session.getAttribute("loginUser");
	String alertMsg = (String)session.getAttribute("alertMsg");
	String contextPath = request.getContextPath();

%>
<!DOCTYPE html>

<head>
  <meta charset="utf-8">
  <title>header</title>

  <!-- jQuery 라이브러리 연동 : 온라인 방식 -->
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
  <!-- Favicons -->
  <link href="<%=contextPath%>/resources/img/favicon.png" rel="icon">
  <link href="<%=contextPath%>/resources/img/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Google Fonts -->
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,600;1,700&family=Roboto:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,500;1,600;1,700&family=Work+Sans:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,500;1,600;1,700&display=swap" rel="stylesheet">

  <!-- Vendor CSS Files -->
  <link href="<%=contextPath %>/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="<%=contextPath %>/resources/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
  <link href="<%=contextPath %>/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet">
  <link href="<%=contextPath %>/resources/vendor/aos/aos.css" rel="stylesheet">
  <link href="<%=contextPath %>/resources/vendor/glightbox/css/glightbox.min.css" rel="stylesheet">
  <link href="<%=contextPath %>/resources/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">
  
 

  <!-- Template Main CSS File -->
  <link href="<%=contextPath %>/resources/css/main.css" rel="stylesheet">


  <!-- =======================================================
  * Template Name: UpConstruction
  * Updated: Sep 18 2023 with Bootstrap v5.3.2
  * Template URL: https://bootstrapmade.com/upconstruction-bootstrap-construction-website-template/
  * Author: BootstrapMade.com
  * License: https://bootstrapmade.com/license/
  ======================================================== -->
</head>

<body>
<script>
let msg = "<%=alertMsg%>";
if(msg != "null"){
	alert(msg);		
	<% 
		session.removeAttribute("alertMsg");
	%>
}

</script>
  
  <!-- ======= Header ======= -->
  <header id="header" class="header d-flex align-items-center">
    <div class="container-fluid container-xl d-flex align-items-center justify-content-between">

      <a href="index.html" class="logo d-flex align-items-center">
        <!-- Uncomment the line below if you also wish to use an image logo -->
        <!-- <img src="assets/img/logo.png" alt=""> -->
        <img src="../../resources/img/logo.png" width="100px" height="10%">
      </a>

      <i class="mobile-nav-toggle mobile-nav-show bi bi-list"></i>
      <i class="mobile-nav-toggle mobile-nav-hide d-none bi bi-x"></i>
      <nav id="navbar" class="navbar">
        <ul>
          <li><a href="index.jsp">Home</a></li>
          <li><a href="<%=contextPath%>/list.bo?cg=10&currentPage=1">공지사항</a></li>
          <li class="dropdown"><a href="#"><span>통합 게시판</span> <i class="bi bi-chevron-down dropdown-indicator"></i></a>
            <ul>
              <li><a href="<%=contextPath%>/list.bo?cg=4&currentPage=1">자유게시판</a></li>
              <li><a href="<%=contextPath%>/imageList.bo?cg=5&currentPage=1">사진게시판</a></li>
              <li><a href="<%=contextPath%>/imageList.bo?cg=6&currentPage=1">중고거래 게시판</a></li>
              <li><a href="<%=contextPath%>/list.bo?cg=7&currentPage=1">건의사항 게시판</a></li>
              <li><a href="<%=contextPath%>/imageList.bo?cg=8&currentPage=1">홍보 게시판</a></li>
              <li><a href="<%=contextPath%>/imageList.bo?cg=9&currentPage=1">분실물 게시판</a></li>
            </ul>
          </li>
          <li class="dropdown"><a href="#"><span>단지 게시판</span> <i class="bi bi-chevron-down dropdown-indicator"></i></a>
            <ul>
              <li><a href="<%=contextPath%>/list.bo?cg=1&currentPage=1">1단지</a></li>
              <li><a href="<%=contextPath%>/list.bo?cg=2&currentPage=1">2단지</a></li>
              <li><a href="<%=contextPath%>/list.bo?cg=3&currentPage=1">3단지</a></li>
            </ul>
          </li>
          <li class="dropdown"><a href="#"><span>등록/예약</span> <i class="bi bi-chevron-down dropdown-indicator"></i></a>
            <ul>
              <li><a href="<%=contextPath%>/list.ca">차량</a></li>
              <li><a href="<%=contextPath%>/resEnrollForm.bq">바베큐</a></li>
            </ul>
          </li>
          <li><a href="contact.html">오시는길</a></li>

        <% if(loginUser != null ){ %>
          
          	  <% if(loginUser.getMemberNo()==1){ %>
          	  <li class="dropdown"><a href="#"><span><%=loginUser.getMemberName() %>님 환영합니다.</span> <i class="bi bi-chevron-down dropdown-indicator"></i></a>
	            <ul>
	              <li><a href="main.ad">관리자 페이지</a></li>
	              <li><a href="<%=contextPath%>/logout.me">로그아웃</a></li>
	            </ul>
	          </li>    
	          <%}else{ %>
	          <li class="dropdown"><a href="#"><span><%=loginUser.getMemberName() %>님 환영합니다.</span> <i class="bi bi-chevron-down dropdown-indicator"></i></a>
	            <ul>
	              <li><a href="<%= contextPath%>/myPage.me">마이페이지</a></li>
	              <li><a href="<%=contextPath%>/logout.me">로그아웃</a></li>
	            </ul>
	          </li>
	  		 <%} %>
     	<% }else{ %>

          <li class="dropdown"><a href="<%=contextPath%>/loginForm.me"><span>로그인</span></i></a>                       
          </li>
	<% } %>
        </ul>
      </nav><!-- .navbar -->

    </div>
  </header><!-- End Header -->

</body>

