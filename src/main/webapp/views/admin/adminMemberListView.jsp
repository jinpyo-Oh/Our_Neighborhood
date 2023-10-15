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
        <title>회원 전체 조회</title>
        
        
        
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
                        <h1 class="mt-4">회원 전체 조회</h1>
                        <ol class="breadcrumb mb-4">
                            <div></div>
                        </ol>
                        <div class="card mb-4">
                            <div class="card-body">
                                KH 아파트 ON 커뮤니티에 현재 가입한 회원 전체 조회 명단입니다.
                                <br><br>
                                기본 보기 : 최신 가입일순 <br>
                            </div>
                        </div>

                        <div style="height: 40px;"></div>

                        <div class="card mb-4">
                            <div class="card-header">
                                <i class="fas fa-table me-1"></i>
                                회원 전체 명단
                            </div>
                            <div class="card-body">
                                <table id="datatablesSimple">
                                    <thead>
                                        <tr>
                                            <th>이름</th>
                                            <th>단지</th>
                                            <th>동-호수</th>
                                            <th>e-mail</th>
                                            <th>가입일자</th>
                                            <th>전화번호</th>
                                        </tr>
                                    </thead>
                                
                                    <tbody>
                                        <tr>
                                            <td>홍길동</td>
                                            <td>2 </td>
                                            <td>201-</td>
                                            <td>abc123@naver.com</td>
                                            <td>2011/04/25</td>
                                            <td>010-1234-5678</td>
                                        </tr>
                                        <tr>
                                            <td>홍길동</td>
                                            <td>2 </td>
                                            <td>201-</td>
                                            <td>abc123@naver.com</td>
                                            <td>2011/04/25</td>
                                            <td>010-1234-5678</td>
                                        </tr>
                                        <tr>
                                            <td>홍길동</td>
                                            <td>2 </td>
                                            <td>201-</td>
                                            <td>abc123@naver.com</td>
                                            <td>2011/04/25</td>
                                            <td>010-1234-5678</td>
                                        </tr>
                                        <tr>
                                            <td>홍길동</td>
                                            <td>2 </td>
                                            <td>201-</td>
                                            <td>abc123@naver.com</td>
                                            <td>2011/04/25</td>
                                            <td>010-1234-5678</td>
                                        </tr>
                                        <tr>
                                            <td>홍길동</td>
                                            <td>2 </td>
                                            <td>201-</td>
                                            <td>abc123@naver.com</td>
                                            <td>2011/04/25</td>
                                            <td>010-1234-5678</td>
                                        </tr>
                                        <tr>
                                            <td>홍길동</td>
                                            <td>2 </td>
                                            <td>201-</td>
                                            <td>abc123@naver.com</td>
                                            <td>2011/04/25</td>
                                            <td>010-1234-5678</td>
                                        </tr>
                                        <tr>
                                            <td>홍길동</td>
                                            <td>2 </td>
                                            <td>201-</td>
                                            <td>abc123@naver.com</td>
                                            <td>2011/04/25</td>
                                            <td>010-1234-5678</td>
                                        </tr>
                                        <tr>
                                            <td>홍길동</td>
                                            <td>2 </td>
                                            <td>201-</td>
                                            <td>abc123@naver.com</td>
                                            <td>2011/04/25</td>
                                            <td>010-1234-5678</td>
                                        </tr>
                                        <tr>
                                            <td>홍길동</td>
                                            <td>2 </td>
                                            <td>201-</td>
                                            <td>abc123@naver.com</td>
                                            <td>2011/04/25</td>
                                            <td>010-1234-5678</td>
                                        </tr>
                                        <tr>
                                            <td>홍길동</td>
                                            <td>2 </td>
                                            <td>201-</td>
                                            <td>abc123@naver.com</td>
                                            <td>2011/04/25</td>
                                            <td>010-1234-5678</td>
                                        </tr>
                                        <tr>
                                            <td>홍길동</td>
                                            <td>2 </td>
                                            <td>201-</td>
                                            <td>abc123@naver.com</td>
                                            <td>2011/04/25</td>
                                            <td>010-1234-5678</td>
                                        </tr>

                                        
                                    </tbody>
                                </table>
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
