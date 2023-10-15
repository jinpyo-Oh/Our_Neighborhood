<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>회원 정보 수정</title>
        <style>
            .user-search{
                height: 50px;
                
            }
        </style>
    </head>
    <body class="sb-nav-fixed">
        <%@ include file="../common/adminHeader.jsp" %>


<!--<div id="layoutSidenav_content">

        관리자 페이지는 무조건 이 태그를 감싸 사용

    </div>-->
            <div id="layoutSidenav_content">
               
                    <div class="container-fluid px-4">
                        <div style="height: 20px;"></div>
                        <h1 class="mt-4">회원 정보 수정</h1>
                        <ol class="breadcrumb mb-4">
                            <div></div>
                        </ol>
                        <div class="card mb-4">
                            <div class="card-body">
                                KH 아파트 ON 커뮤니티에 현재 가입한 회원의 정보를 수정할 수 있습니다.
                                <br>
                                수정할 회원의 이름, 동-호수, 이메일, 전화번호를 입력하시면 확인 후
                                정보 수정 페이지로 이동합니다.
                                <br>
                                <hr>
                                <b>수정할 회원의 정보가 정확하지 않다면 하단의 검색창을 통해 검색 후 진행 가능합니다.
                                </b>
                            </div>
                        </div>
                        <hr>
                        <div>
                            <div id="layoutAuthentication">
                                
                                    <main>
                                        <form>
                                            <div class="row mb-3">
                                                <div class="col-md-6" style="margin: auto;">
                                                    <div class="form-floating mb-3 mb-md-0" style="margin-top: 40px;">
                                                        <input class="form-control" id="inputFirstName" type="text" placeholder="Enter your first name" style="margin-bottom: 18px;" align=""/>
                                                        <label for="inputFirstName">이름</label>
                                                        
                                                        <div class="form-floating mb-3">
                                                            <input class="form-control" id="inputEmail" type="email" placeholder="name@example.com" />
                                                            <label for="inputEmail">동 -호수</label>
                                                        </div>
                                                        
                                                        <div class="form-floating mb-3 mb-md-0">
                                                            <input class="form-control" id="inputPassword" type="password" placeholder="Create a password" style="margin-bottom: 18px;"/>
                                                            <label for="inputPassword">이메일</label>
                                                        </div>

                                                        <div class="form-floating mb-3 mb-md-0">
                                                            <input class="form-control" id="inputPasswordConfirm" type="password" placeholder="Confirm password"  style="margin-bottom: 18px;" />
                                                            <label for="inputPasswordConfirm">전화번호</label>
                                                            <div class="d-grid"><a class="btn btn-primary btn-block" href="" style="width: 610px;">해당 회원 조회</a></div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            
                                    </main>
                                <br>
                                <hr>
                                <br>
                                <div class="card mb-4">
                                    <div class="card-header">
                                        <i class="fas fa-table me-1"></i>
                                        회원 검색
                                    </div>
                                    <div>
                                        <form>
                                            <div class="form-floating mb-3" style="display: inline-block;">
                                                <input class="form-control user-search" placeholder="검색할 정보를 입력하세요" style="width: 600px; margin-top: 16px; margin-left: 10px; margin-right: 8px;" />
                                            </div>
                                                <button class="btn btn-primary user-search"><i class="fas fa-search"></i></button>
                                        </form>
                                    </div> 
                                </div>
                            </div>
                        </div>
                    </div>
                
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
        </div>
        <%@ include file="../common/adminFooter.jsp" %>
    </body>
</html>
