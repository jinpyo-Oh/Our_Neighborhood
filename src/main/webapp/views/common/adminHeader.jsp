<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	
	String contextPath = request.getContextPath();

%>

<!DOCTYPE html>
<html>


<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>관리자메인페이지</title>
    <link href="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/style.min.css" rel="stylesheet" />
    <link href="<%=contextPath %>/resources/css/styles.css" rel="stylesheet" />
    <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
    
</head>

<nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
    <!-- Navbar Brand-->
    <a class="navbar-brand ps-3" href="1_관리자메인페이지.html">관리자 페이지</a>
    <!-- Navbar Search-->
    <form class="d-none d-md-inline-block form-inline ms-auto me-0 me-md-3 my-2 my-md-0">
        <div class="input-group">
        </div>
    </form>
    <!-- Navbar-->
    <ul class="navbar-nav ms-auto ms-md-0 me-3 me-lg-4">
        <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false"><i class="fas fa-user fa-fw"></i></a>
            <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                <li><a class="dropdown-item" href="#!">Logout</a></li>
            </ul>
        </li>
    </ul>
</nav>
<div id="layoutSidenav">
    
    <div id="layoutSidenav_nav">
    
        <nav class="sb-sidenav accordion sb-sidenav-light" id="sidenavAccordion">
    
            <div class="sb-sidenav-menu">
    
                <div class="nav">
    
                    <div class="sb-sidenav-menu-heading">Dashboard</div>
                    <a class="nav-link" href="1_관리자메인페이지.html">
                        <div class="sb-nav-link-icon"><img src="<%=contextPath %>/resources/img/admin/homeic2.jpg" style="margin-left: 2px;" width="13px" height="13px" style="color: lightgray;"></div>
                        <b style="margin-left: 6px;">HOME</b>
                    </a>

                    <div class="sb-sidenav-menu-heading">USER</div>
                    <a class="nav-link" href="2_유저관리.html">
                        <div class="sb-nav-link-icon"><img src="<%=contextPath %>/resources/img/admin/유저관리2.png" style="margin-bottom: 3px;" width="20px" height="14px" alt=""></i></div>
                            <b>유저 관리</b>
                    </a>

                    <div class="sb-sidenav-menu-heading">Board</div>
                    <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseLayouts" aria-expanded="false" aria-controls="collapseLayouts">
                        <div class="sb-nav-link-icon"><img src="<%=contextPath %>/resources/img/admin/공지사항2.png" width="20px" height="14px" alt=""></i></div>
                            <b>공지사항</b>
                        <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                    </a>
                    <div class="collapse" id="collapseLayouts" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                        <nav class="sb-sidenav-menu-nested nav">
                            <a class="nav-link" href="3_공지사항전체조회.html">공지사항 조회</a>
                            <a class="nav-link" href="4_공지사항작성.html">공지사항 등록</a>
                        </nav>
                    </div>
                    
                    <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapsePages1" aria-expanded="false" aria-controls="collapsePages1">
                        <div class="sb-nav-link-icon"><img src="../../resources/img/admin/통합게시판2.png" width="20px" height="20px" alt=""></div>
                            <b>통합게시판</b>
                        <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                    </a>      
                   
                    <div class="collapse" id="collapsePages1" aria-labelledby="headingTwo" data-bs-parent="#sidenavAccordion">
                        <nav class="sb-sidenav-menu-nested nav accordion" id="sidenavAccordionPages">
                           
                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#share-free" aria-expanded="false" aria-controls="share-free">
                                자유게시판
                            </a>
                        
                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#share-photo" aria-expanded="false" aria-controls="share-photo">
                                사진게시판
                            </a>
                            
                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#share-transaction" aria-expanded="false" aria-controls="share-transaction">
                                중고거래 게시판
                            </a>

                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#share-suggestion" aria-expanded="false" aria-controls="share-suggestion">
                                건의사항 게시판
                            </a>

                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#share-promotion" aria-expanded="false" aria-controls="share-promotion">
                                홍보 게시판
                            </a>

                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#share-lost" aria-expanded="false" aria-controls="share-lost">
                                분실물
                            </a>

                        </nav>
                    </div>


                    <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapsePages2" aria-expanded="false" aria-controls="collapsePages2">
                        <div class="sb-nav-link-icon"><img src="<%=contextPath %>/resources/img/admin/단지게시판2.png" width="20px" height="20px" alt=""></div>
                            <b>단지게시판</b>
                        <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                    </a>
                    <div class="collapse" id="collapsePages2" aria-labelledby="headingTwo" data-bs-parent="#sidenavAccordion">
                        <nav class="sb-sidenav-menu-nested nav accordion" id="sidenavAccordionPages">
                           
                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#pagesCollapseAuth" aria-expanded="false" aria-controls="pagesCollapseAuth">
                                1단지
                            </a>
                           
                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#complex2" aria-expanded="false" aria-controls="complex2">
                                2단지
                            </a>
                            
                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#complex3" aria-expanded="false" aria-controls="complex3">
                                3단지
                            </a>
                        
                        </nav>
                    </div>


                    <div class="sb-sidenav-menu-heading">Registration / Reservation</div>
                    
                    <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#car-park" aria-expanded="false" aria-controls="car-park">
                        <div class="sb-nav-link-icon"><img src="<%=contextPath %>/resources/img/admin/caric3.png" width="20px" height="20px" style="color: lightgray;"></div>
                        <b>차량</b>
                        <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                    </a>
                    
                    <div class="collapse" id="car-park" aria-labelledby="headingTwo" data-bs-parent="#sidenavAccordion">
                        <nav class="sb-sidenav-menu-nested nav accordion" id="sidenavAccordionPages">
                            
                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#pagesCollapseAuth" aria-expanded="false" aria-controls="pagesCollapseAuth">
                                등록
                            </a>
                           
                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#pagesCollapseError" aria-expanded="false" aria-controls="pagesCollapseError">
                                삭제
                            </a>
                            
                        </nav>
                    </div>

                    
                    <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#bbq" aria-expanded="false" aria-controls="bbq">
                        <div class="sb-nav-link-icon"><img src="<%=contextPath %>/resources/img/admin/바베큐장2.png" width="20px" height="20px" alt=""></div>
                            <b>바베큐장</b>
                        <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                    </a>
                    <div class="collapse" id="bbq" aria-labelledby="headingTwo" data-bs-parent="#sidenavAccordion">
                        <nav class="sb-sidenav-menu-nested nav accordion" id="sidenavAccordionPages">
                            
                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#pagesCollapseAuth" aria-expanded="false" aria-controls="pagesCollapseAuth">
                                예약현황
                            </a>
                            
                        </nav>
                    </div>

                </div>
            </div>
            <div class="sb-sidenav-footer">
                <div class="small">Logged in as:</div>
                Admin
            </div>
        </nav>
    </div> 
    
    <!--<div id="layoutSidenav_content">

        관리자 페이지는 무조건 이 태그를 감싸 사용

    </div>-->

</html>