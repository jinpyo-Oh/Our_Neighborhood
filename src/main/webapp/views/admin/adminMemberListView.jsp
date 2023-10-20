<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, 
				 com.kh.member.model.vo.Member" %>
<%
	// request 로 부터 응답데이터 뽑기
	ArrayList<Member> list = (ArrayList<Member>)request.getAttribute("list");
	
%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>회원 관리</title>
        
    </head>
    <body class="sb-nav-fixed">
        <%@ include file="/views/common/adminHeader.jsp" %>


<!--<div id="layoutSidenav_content">

        관리자 페이지는 무조건 이 태그를 감싸 사용

    </div>-->

            <div id="layoutSidenav_content">
            
             
            
                <main>
                    <div class="container-fluid px-4">
                        <div style="height: 20px;"></div>
                        <h1 class="mt-4">회원 관리</h1>
                        <ol class="breadcrumb mb-4">
                            <div></div>
                        </ol>
                        <div class="card mb-4">
                            <div class="card-body">
                                KH 아파트 ON 커뮤니티에 현재 가입한 전체 회원의 정보입니다.
                                
                                <br><br>
                                우측 상단 검색창을 통해 특정회원 검색이 가능합니다.
                                <br><br>
                                특정 회원의 정보를 클릭 시 해당 회원의 상세 조회화면으로 넘어가며 <b>수정/탈퇴</b> 시킬 수 있습니다.
                            	
                            </div>
                        </div>

                        <div style="height: 20px;"></div>

                        <div class="card mb-4">
                            <div class="card-header">
                                <i class="fas fa-table me-1"></i>
                                전체 회원 리스트
                            </div>
                            <div class="card-body">
                                
                                <table id="datatablesSimple" class="member-area">
                                    <thead>
                                        <tr>
                                        	<th>회원번호</th>
                                        	<th>가입일자</th>
                                        	<th>아이디</th>
                                            <th>이름</th>
                                            <th>동-호수</th>
                                            <th>단지</th>
                                            <th>e-mail</th>
                                            <th>전화번호</th>
                                        </tr>
                                    </thead>
                                
                                    <tbody>
                                        
                                        <% if(list.isEmpty()) { %>
                                        	
                                        	<tr>
                                        		<td colspan="8">
                                        			조회된 멤버정보가 없습니다.
                                        		</td>
                                        	</tr>
                                        	
                                        	
                                        <% } else { %>

											<% for(Member m : list){ %>
												
												<tr>
													<td><%= m.getMemberNo() %></td>
													<td><%= m.getMemberEnrolldate() %></td>
													<td><%= m.getMemberId() %></td>
													<td><%= m.getMemberName() %></td>
													<td><%= m.getAddress() %></td>
													<td><%= m.getAddress2() %></td>
													<td><%= m.getEmail() %></td>
													<td><%= m.getPhone() %></td>
												</tr>
												
											<% } %>
                                        <% } %>
                                    </tbody>
                                </table>
                                
	                            <script>
	                            	
	                            	$(function(){
	                            		
	                            		$(".member-area>tbody>tr").click(function(){
	                            			
	                            			let mno = $(this).children().eq(0).text();
	                            			
	                            			// console.log(mno);
	                            			
	                            			location.href = "<%= contextPath %>/detail.ad?mno=" + mno;           
	                            			
	                            		});
	                            		 
	                            	});
	                            
	                            </script>
                                
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
