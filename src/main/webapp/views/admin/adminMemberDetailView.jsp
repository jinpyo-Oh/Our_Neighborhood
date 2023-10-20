<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.member.model.vo.Member"%>
<%
	Member m = (Member)request.getAttribute("m");
	
%>
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
        	<%
        		int memberNo = m.getMemberNo();
        		String memberId = m.getMemberId();
        		String memberPwd = m.getMemberPwd();
        		String memberPwd2 = m.getMemberPwd();
        		String memberName = m.getMemberName();
        		String memberAddress = m.getAddress();
        		int memberAddress2 = m.getAddress2();
        		String memberEmail = m.getEmail();
        		String memberPhone = m.getPhone();
        	%>
        
        
            <div id="layoutSidenav_content">
               
                    <div class="container-fluid px-4">
                        <div style="height: 20px;"></div>
                        <h1 class="mt-4">회원 상세 조회</h1>
                        <ol class="breadcrumb mb-4">
                            <div></div>
                        </ol>
                        <div class="card mb-4">
                            <div class="card-body">
                                KH 아파트 ON 커뮤니티에 가입한 해당 회원의 상세 정보를 확인할 수 있습니다.
                                <br><br>
                                회원번호, 가입일자를 제외한 회원의 정보를 수정 가능합니다. <br>
                                <hr>
                            </div>
                        </div>
                        <hr>
                        <div>
                            <div id="layoutAuthentication">
                                
								<main>
	                                <div class="row mb-3">
	                                     <div class="col-md-6" style="margin: auto;">
	                                         <div class="form-floating mb-3 mb-md-0" style="margin-top: 40px;">
	                                             <form action="<%= contextPath %>/update.ad" method="post" id="update-form">
	                                                 <div class="form-floating mb-3">
	                                                     <input class="form-control" id="memberNo" name="memberNo" type="text" style="margin-bottom: 18px; background-color: lightgray;" value="<%= memberNo %>" readonly>
	                                                     <label>회원번호 (수정 불가)</label>
	                                                 </div>
	                                                 
	                                                 <div class="form-floating mb-3">
	                                                     <input class="form-control" id="memberEnrolldate" name="memberEnrolldate" type="date" style="margin-bottom: 18px; background-color: lightgray;" value="<%= m.getMemberEnrolldate() %>" readonly>
	                                                     <label>가입일자 (수정 불가)</label>
	                                                 </div>
	                                                 
	                                                 <div class="form-floating mb-3">
	                                                     <input class="form-control" id="inputId" name="memberId"type="text"  style="margin-bottom: 18px;" value="<%= m.getMemberId() %>">
	                                                     <label>아이디</label>
	                                                 </div>
	                                                 
	                                                 <div class="form-floating mb-3">
	                                                     <input class="form-control" id="inputPassword" name="memberPwd" type="text"  value="<%= m.getMemberPwd() %>">
	                                                     <label>비밀번호</label>
	                                                 </div>
	                                                 
	                                                 <div class="form-floating mb-3 mb-md-0">
	                                                     <input class="form-control" id="inputPasswordConfirm" name="memberPwd2" type="text"  style="margin-bottom: 18px;" value="<%= m.getMemberPwd() %>">
	                                                     <label>비밀번호 확인</label>
	                                                 </div>
	                                                 
	                                                 <div class="form-floating mb-3 mb-md-0">
	                                                     <input class="form-control" id="inputPassword" type="text" name="memberName"  style="margin-bottom: 18px;" value="<%= m.getMemberName() %>">
	                                                     <label>이름</label>
	                                                 </div>
	                                                 
	                                                 <div class="form-floating mb-3 mb-md-0">
	                                                     <select class="form-control" type="radio" name="memberAddress2" id="address2" style="margin-bottom: 18px;" >
	                                                         <option value=1>1단지</option>
	                                                         <option value=2>2단지</option>
	                                                         <option value=3>3단지</option>
	                                                     </select>
	                                                     <label for="inputPassword">단지</label>
	                                                 </div>
	                                                 
	                                                 <div class="form-floating mb-3 mb-md-0">
	                                                     <input class="form-control" id="inputPassword" name="memberAddress" type="text"  style="margin-bottom: 18px;" value="<%= m.getAddress() %>">
	                                                     <label>동-호수</label>
	                                                 </div>
	                                                 
	                                                 <div class="form-floating mb-3 mb-md-0">
	                                                     <input class="form-control" id="inputEmail" type="email" name="memberEmail"  style="margin-bottom: 18px;" value="<%= m.getEmail() %>">
	                                                     <label>이메일</label>
	                                                 </div>
	                                                 
	                                                 <div class="form-floating mb-3 mb-md-0">
	                                                     <input class="form-control" id="inputPasswordConfirm" name="memberPhone" type="text" placeholder="Confirm password"  style="margin-bottom: 25px;" value="<%= m.getPhone() %>">
	                                                     <label>전화번호</label>
	                                                 </div>
	                                                 
		                                              <div align="center">
		                                                  <button type="submit" class="btn btn-primary btn-sm">정보 수정</button>
		                                                  <a href="<%= contextPath %>/adminMemberList.ad" class="btn btn-secondary btn-sm">목록 가기</a>
		                                                  <button type="button" class="btn btn-danger btn-sm" data-toggle="modal" data-target="#deleteForm">회원 탈퇴</button>
		                                              </div>
	                                             
												</form>
	                                         </div>
	                                     </div>
	                                 </div>
	                                 
										<!-- 회원탈퇴용 모달창 -->
									    <!-- The Modal -->
										<div class="modal" id="deleteForm">
										  <div class="modal-dialog">
										    <div class="modal-content">
										
										      <!-- Modal Header -->
										      <div class="modal-header">
										        <h4 class="modal-title">회원 강제 탈퇴</h4>
										        <button type="button" class="close" data-dismiss="modal">&times;</button>
										      </div>
										
										      <!-- Modal body -->
										      <div class="modal-body">
										      
										      	<b>
										      		탈퇴 후 복구가 불가능합니다. <br> 
										      		정말로 해당 회원을 강제 탈퇴시키겠습니까? <br><br>
										      	</b>
										      	
										        <form action="<%= contextPath %>/delete.ad" method="post">
										        	
										        	<!-- 
										        		회원탈퇴 시 : 비밀번호
										        	-->
										        	<table>
										        		<tr>
										        			<td style="width:130px;">회원 번호 재확인</td>
										        			<td>
										        				<input type="hidden" name="deleteMem" value=<%=m.getMemberNo() %>>
										        				<input type="text" name="memberNo" style="width:300px" placeholder="탈퇴시키고자 하는 회원의 번호만 입력" required>
										        			</td>
										        		</tr>
										        	</table>
										        	
										        	<br>
										        	
										        	<button type="submit" class="btn btn-secondary btn-sm">탈퇴하기</button>
										        
										          </form>
										    	</div>
										    </div>
										</div>
									</div>
                                            
	                                 <script>
	                                	$(function() {
	                                 	
		                                 	// option 태그들 모두 선택 ([option, option, option]) => 1, 2, 3
		                                 	$("#update-form option").each(function() {
		                                 		
		                                 		if($(this).val() == <%= m.getAddress2() %>) {
		                                 			
		                                 			$(this).attr("selected", true);
		                                 		}
		                                 		
		                                 	});
		                                 	
										});
	                                 </script>
								</main>
                                <br>
                                <hr>
                            	<br>
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
