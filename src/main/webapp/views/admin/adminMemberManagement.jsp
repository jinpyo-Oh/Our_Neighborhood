<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>


<%@ include file="../common/adminHeader.jsp" %>


<!--
    <div id="layoutSidenav_content">

        관리자 페이지는 무조건 이 태그를 감싸 사용

    </div>
-->

    
    <body class="sb-nav-fixed">
        
            <div id="layoutSidenav_content">
                <main>
                    <div style="height: 20px;"></div>
                    <div class="container-fluid px-4">
                        <h1 class="mt-4">유저 관리</h1>
                        <div style="height: 100px;"></div>
                        
                        <div class="row" align="center" style="height: 200px;" >
                            
                            <div class="col-xl-3 col-md-6" style="margin-left: 300px;">
                                
                                <div class="card bg-primary text-white mb-4" onclick="location.href='<%= contextPath %>/adminMemberList.me'" >
                                    <div class="card-body">회원 전체 조회</div>
                                    <div class="card-footer d-flex align-items-center justify-content-between">
                                        <a class="small text-white stretched-link" href="#">View Details</a>
                                        <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                                    </div>
                                </div>
                                

                            </div>
                            
                            <div class="col-xl-3 col-md-6">
                                <div class="card bg-warning text-white mb-4" onclick="location.href='../admin/adminMemberDetailView.jsp'">
                                    <div class="card-body">회원 상세 조회</div>
                                    <div class="card-footer d-flex align-items-center justify-content-between">
                                        <a class="small text-white stretched-link" href="#">View Details</a>
                                        <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                                    </div>
                                </div>
                            </div>
                            
                        </div>

                        <div class="row" align="center">
                            
                            <div class="col-xl-3 col-md-6" style="margin-left: 300px;">
                                <div class="card bg-success text-white mb-4" onclick="location.href='../admin/adminMemberUpdateForm.jsp'">
                                    <div class="card-body">회원 정보 수정</div>
                                    <div class="card-footer d-flex align-items-center justify-content-between">
                                        <a class="small text-white stretched-link" href="#">View Details</a>
                                        <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-xl-3 col-md-6">
                                <div class="card bg-danger text-white mb-4" onclick="location.href='../admin/adminMemberDeleteForm.jsp'">
                                    <div class="card-body">회원 강제 탈퇴</div>
                                    <div class="card-footer d-flex align-items-center justify-content-between">
                                        <a class="small text-white stretched-link" href="#">View Details</a>
                                        <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                                    </div>
                                </div>
                            </div>
                            
                        </div>

                    </div>
                </main>
                <footer class="py-4 bg-light mt-auto">
                    <div class="container-fluid px-4">
                        <div class="d-flex align-items-center justify-content-between small">
                            <div class="text-muted">Copyright &copy; Your Website 2023</div>
                            <div>
                                <a href="#">Privacy Policy</a>
                                &middot;
                                <a href="#">Terms &amp; Conditions</a>
                            </div>
                        </div>
                    </div>
                </footer>
            </div>
       

        <%@ include file="../common/adminFooter.jsp" %>
    </body>
</html>
