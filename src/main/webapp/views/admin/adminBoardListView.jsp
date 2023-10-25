<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, 
				 com.kh.admin.model.vo.Board" %>
<%
	// request 로 부터 응답데이터 뽑기
	ArrayList<Board> list = (ArrayList<Board>)request.getAttribute("list");
	
	int categoryNo = (int)request.getAttribute("cgNo");

	String cgName = null;
	
	switch(categoryNo){
	case 1 : cgName="1단지"; break;
	case 2 : cgName="2단지"; break;
	case 3 : cgName="3단지"; break;
	case 4 : cgName="자유"; break;
	case 5 : cgName="사진"; break;
	case 6 : cgName="중고거래"; break;
	case 7 : cgName="건의사항"; break;
	case 8 : cgName="홍보"; break;
	case 9 : cgName="분실물"; break;
	case 10 : cgName="공지사항"; break;
	}
	
%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>게시판</title>
        
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
                        <h1 class="mt-4"><%= cgName %> 게시판</h1>
                        <br>
                        <div class="card mb-4">
                            <div class="card-body">
                                KH 아파트 ON 커뮤니티 [ <%= cgName %> 게시판 ] 입니다.
                                
                                <br><br>
                                우측 하단 글 작성 버튼을 통해 글 작성이 가능합니다.
                                <br><br>
                                ※ 게시글을 클릭 시 해당 게시글을 상세하게 볼 수 있으며 모든 게시글과 댓글은 관리자의 권한으로 <b>삭제</b> 시킬 수 있습니다. ※
                            	
                            </div>
                        </div>

                        <div style="height: 20px;"></div>

                        <div class="card mb-4">
                            <div class="card-header">
                                <i class="fas fa-table me-1"></i>
                                <%= cgName %> 게시글 리스트
                            </div>
                            <div class="card-body">
                                <form action="<%=contextPath%>/adminBoardCheckDelete.ad" method="post">
                  					<input type="hidden" name="cgNo" value="<%= categoryNo %>">		
										                  						
                                <table id="datatablesSimple" class="board-area">
                                    <thead>
                                        <tr>
                                        	<th></th>
                                        	<th>작성일</th>
                                        	<th>작성자</th>
                                        	<th>제목</th>
                                            <th>카테고리</th>
                                            <th>게시글번호</th>
                                            <th>조회수</th>
                                        </tr>
                                    </thead>
                                
                                    <tbody>
                                        
                                        <% if(list != null) { %>
                                        	
											<% for(Board b : list){ %>
												
												<tr>
													<td class="checkbox-area"><input type="checkbox" name="check" class="del_check" value="<%= b.getBoardNo() %>"></td>
													<td><%= b.getCreateDate() %></td>
													<td><%= b.getMemberName() %></td>
													<td><%= b.getBoardTitle() %></td>
													<td><%= b.getCgNo() %></td>
													<td><%= b.getBoardNo() %></td>
													<td><%= b.getCount() %></td>
												</tr>
												
											<% } %>
                                        <% } %>
                                    </tbody>
                                </table> 
                  						<div align="right" style="margin-top:20px;">
			                					<%if(categoryNo == 5 || categoryNo == 6 ||categoryNo == 8 || categoryNo == 9) {%>
				                   			<span>
				                   				<a type="button" class="btn btn-secondary btn-sm" href="<%= contextPath %>/adminImageBoardEnroll.ad?cg=<%= categoryNo %>">글 작성</a>
			                				</span>
			                				<%}else{ %>
				                   			<span>
			                					<a type="button" class="btn btn-secondary btn-sm" href="<%= contextPath %>/adminBoardEnroll.ad?cg=<%= categoryNo %>">글 작성</a>
			                				</span>
			                				<%} %>
                  							<button type="submit" class="btn btn-danger btn-sm" style="align:right">선택 삭제</button>
			                			</div>
                                </form>
	                            <script>
	                            	
	                            	$(function(){
	                            		

	                            		$(".del_check").click(function() {
	                            			
	                            			event.stopPropagation(); // 이벤트 버블링 (부모요소인 tr 도 같이 클릭되는거 막기)
	                            			
	                            			// console.log("잘되나?")
	                            		});
	                            		
	                            		$(".board-area>tbody>tr").click(function(){
	                            			
	                            			console.log("tr클릭")
	                            			
	                            			let bno = $(this).children().eq(5).text();
	                            			let cgNo = $(this).children().eq(4).text();
	                            			
	                            			if(cgNo==5||cgNo==6||cgNo==8||cgNo==9){
	                            				location.href = "<%= contextPath %>/imageDetail.ad?bno=" + bno + "&cgNo=" + cgNo;
	                            			}else{
	                            				
	                            				location.href = "<%= contextPath %>/boardDetail.ad?bno=" + bno + "&cgNo=" + cgNo;
	                            			}	                            													                            				                            			       
	                            		});
	                            	});
	                            	
	                            	$(function(){

	                                    // <---- checkbox 관련---->
	                                    $("#datatablesSimple th").eq(0).empty();
	                                    $("#datatablesSimple th").eq(0).html("<input type='checkbox' name='selectall'>");

	                            
	                                    $("input[name='selectall']").change(function () {
	                                            $("input[class='del_check']").prop('checked', $("input[name='selectall']").is(":checked"));
	                                    });

	                                    $("input[class='del_check']").change(function () {
	                                        $("input[name='selectall']").prop('checked', false);
	                                 });

	                                     $(".datatable-selector").attr('name','pageLength');
	                                                                        
	                                });
	                           
	                            </script>
                                <br> <br>
                              
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
