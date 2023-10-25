<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    import="java.util.ArrayList, com.kh.car_reservation.model.vo.Car"%>
<%
	ArrayList<Car> list = (ArrayList<Car>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>차량 조회</title>
        
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
                        <h1 class="mt-4">등록된 차량 리스트</h1>
                        <br>
                        <div class="card mb-4">
                            <div class="card-body">
                                KH 아파트 차량 등록 리스트입니다.
                                
                                <br><br>
                                우측 하단 차량 등록 버튼을 통해 차량 등록이 가능합니다.
                                <br>
                            	
                            </div>
                        </div>

                        <div style="height: 20px;"></div>

                        <div class="card mb-4">
                            <div class="card-header">
                                <i class="fas fa-table me-1"></i>
                                전체 등록 차량 리스트
                            </div>
                            <div class="card-body">
                                <form action="<%=contextPath%>/adminCarCheckDelete.ad" method="post">
										                  						
                                <table id="datatablesSimple" class="board-area">
                                    <thead>
                                        <tr>
                                        	<th></th>
                                        	<th>등록 번호</th>
                                        	<th>등록회원 번호</th>
                                        	<th>차량 소유주명</th>
                                            <th>차량 번호</th>
                                            <th>차량 타입</th>
                                        </tr>
                                    </thead>
                                
                                    <tbody>
                                        
                                        <% if(list.isEmpty()) { %>
                                        	
                                        	<tr>
                                        		<td colspan="6">
                                        			조회된 차량 등록정보가 없습니다.
                                        		</td>
                                        	</tr>
                                        	
                                        	
                                        <% } else { %>

											<% for(Car c : list){ %>
												
												<tr>
													<td class="checkbox-area"><input type="checkbox" name="check" class="del_check" value="<%= c.getCarNo() %>"></td>
													<td><%= c.getCarNo() %></td>
													<td><%= c.getMemberNo() %></td>
													<td><%= c.getCarOwner() %></td>
													<td><%= c.getCarResNo() %></td>
													<td><%= c.getCarType() %></td>
												</tr>
												
											<% } %>
                                        <% } %>
                                    </tbody>
                                </table>
                  						<div align="right" style="margin-top:20px;">
                  							<span>
				                   				<a type="button" class="btn btn-secondary btn-sm" data-toggle="modal" data-target="#regiCar">차량 등록</a>
                  							</span>
                  							<span>
                  								<button type="submit" class="btn btn-danger btn-sm" style="align:right">선택 삭제</button>
			                				</span>
			                			</div>
                                </form>
                                
                                <!-- 차량 등록용 모달창 -->
									    <!-- The Modal -->
										<div class="modal" id="regiCar">
										  <div class="modal-dialog">
										    <div class="modal-content">
										
										      <!-- Modal Header -->
										      <div class="modal-header">
										        <h4 class="modal-title">차량 등록</h4>
										        <button type="button" class="close" data-dismiss="modal">&times;</button>
										      </div>
										
										      <!-- Modal body -->
										      <div class="modal-body">
										      
										      	<b>
										      		차량 등록 정보를 입력해주세요. <br> 
										      		<br><br>
										      	</b>
										      	
										        <form action="<%= contextPath %>/adminCarRegi.ad" method="post">
										        	
										        	<!-- 
										        		회원탈퇴 시 : 비밀번호
										        	-->
										        	<table>
										        		<tr>
										        			<td style="width:130px;">회원번호</td>
										        			<td>
										        				<input type="text" name="memberNo" style="width:300px" required>
										        			</td>
										        		</tr>
										        		<tr>
										        			<td style="width:130px;">차량번호</td>
										        			<td>
										        				<input type="text" name="carResNo" style="width:300px" required>
										        			</td>
										        		</tr>
										        		<tr>
										        			<td style="width:130px;">차종</td>
										        			<td>
										        				<input type="text" name="carType" style="width:300px" required>
										        			</td>
										        		</tr>
										        		<tr>
										        			<td style="width:130px;">차주</td>
										        			<td>
										        				<input type="text" name="carOwner" style="width:300px" required>
										        			</td>
										        		</tr>
										        	</table>
										        	
										        	<br>
										        	<div align="right">
											        	<button type="submit" class="btn btn-primary btn-sm">등록하기</button>
										        	</div>
										        
										          </form>
										    	</div>
										    </div>
										</div>
									</div>
                                
	                            <script>
	                            	
	                            	
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
        </div>
        
        
        
        <%@ include file="../common/adminFooter.jsp" %>
    </body>
</html>