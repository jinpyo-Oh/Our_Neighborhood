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
        <title>회원 상세 조회</title>
        <style>
            .user-search{
                height: 58px;
                margin-bottom: 7px;
            }
        </style>
    </head>
    <body class="sb-nav-fixed">

        
<%@ include file="../common/adminHeader.jsp" %>


<!--<div id="layoutSidenav_content">

        관리자 페이지는 무조건 이 태그를 감싸 사용

    </div>-->
        
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid px-4">
                        <div style="height: 20px;"></div>
                        <h1 class="mt-4">회원 상세 조회</h1>
                        <ol class="breadcrumb mb-4">
                            <div></div>
                        </ol>
                        <div class="card mb-4">
                            <div class="card-body">
                                KH 아파트 ON 커뮤니티에 현재 가입한 회원의 정보를 검색하여 상세 정보를 조회할 수 있습니다.
                                <br><br>
                                검색 가능한 정보 : 동-호수, 이름, 전화번호 
                                <br><br>
                                예시 1 : 101-1201 <br>
                                예시 2 : 홍길동 <br>
                                예시 3 : 010-1234-5678 <br>
                            </div>
                        </div>

                        <div style="height: 30px;"></div>

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
        </div>
        <%@ include file="../common/adminFooter.jsp" %>
    </body>
</html>
