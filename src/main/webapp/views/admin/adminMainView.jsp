<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.admin.model.vo.Chart, 
    java.time.LocalDate, com.kh.admin.model.vo.Board, 
    java.util.ArrayList, java.time.format.DateTimeFormatter"%>
<%
	Chart chart = (Chart)request.getAttribute("chart");
	
	LocalDate currentDate = LocalDate.now();
	
	LocalDate fiveMonthsAgo = currentDate.minusMonths(5);
    LocalDate fourMonthsAgo = currentDate.minusMonths(4);
    LocalDate threeMonthsAgo = currentDate.minusMonths(3);
    LocalDate twoMonthsAgo = currentDate.minusMonths(2);
    LocalDate oneMonthAgo = currentDate.minusMonths(1);
    
    DateTimeFormatter monthFormatter = DateTimeFormatter.ofPattern("MM");
    String fiveMonthsAgoMonth = fiveMonthsAgo.format(monthFormatter);
    String fourMonthsAgoMonth = fourMonthsAgo.format(monthFormatter);
    String threeMonthsAgoMonth = threeMonthsAgo.format(monthFormatter);
    String twoMonthsAgoMonth = twoMonthsAgo.format(monthFormatter);
    String oneMonthAgoMonth = oneMonthAgo.format(monthFormatter);
	
	// 현재 월을 가져옴
	int currentMonth = currentDate.getMonthValue();
	
	ArrayList<Board> board = (ArrayList<Board>)request.getAttribute("list");
	
	
	Chart comm = (Chart)request.getAttribute("comm");
%>    
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
<!-- Resources -->
	<script src="https://cdn.amcharts.com/lib/5/index.js"></script>
	<script src="https://cdn.amcharts.com/lib/5/xy.js"></script>
	<script src="https://cdn.amcharts.com/lib/5/themes/Animated.js"></script>
    
<style>
	 #chartdiv {
	  width: 100%;
	  height: 250px;
	} 
</style>

	
</head>
<body>
    

<%@ include file="../common/adminHeader.jsp" %>


<!--<div id="layoutSidenav_content">

        관리자 페이지는 무조건 이 태그를 감싸 사용

    </div>-->


            <div id="layoutSidenav_content">
               
                <div style="height: 20px;"></div>
              
                <main>
               
                    <div class="container-fluid px-4">
                        
                        <h1 class="mt-4">HOME</h1>
                        <div style="height: 50px;"></div>
                      
                        
                        <div class="row">
							<div class="col-xl-6" style="width:100%;">
                                <div class="card mb-4">
                                    <div class="card-header">
                                        <i class="fas fa-chart-bar me-1"></i>
                                        월별 게시글 수(최근 6개월)
                                    </div>
                                    <!-- Chart code -->
                                    <script>
                                    am5.ready(function() {
                                    
                                    // Create root element
                                    // https://www.amcharts.com/docs/v5/getting-started/#Root_element
                                    var root = am5.Root.new("chartdiv");
                                    
                                    
                                    // Set themes
                                    // https://www.amcharts.com/docs/v5/concepts/themes/
                                    root.setThemes([
                                      am5themes_Animated.new(root)
                                    ]);
                                    
                                    
                                    // Create chart
                                    // https://www.amcharts.com/docs/v5/charts/xy-chart/
                                    var chart = root.container.children.push(am5xy.XYChart.new(root, {
                                      panX: true,
                                      panY: true,
                                      wheelX: "panX",
                                      wheelY: "zoomX",
                                      pinchZoomX: true
                                    }));
                                    
                                    // Add cursor
                                    // https://www.amcharts.com/docs/v5/charts/xy-chart/cursor/
                                    var cursor = chart.set("cursor", am5xy.XYCursor.new(root, {}));
                                    cursor.lineY.set("visible", false);
                                    
                                    
                                    // Create axes
                                    // https://www.amcharts.com/docs/v5/charts/xy-chart/axes/
                                    var xRenderer = am5xy.AxisRendererX.new(root, { minGridDistance: 30 });
                                    xRenderer.labels.template.setAll({
                                      rotation: -90,
                                      centerY: am5.p50,
                                      centerX: am5.p100,
                                      paddingRight: 15
                                    });
                                    
                                    xRenderer.grid.template.setAll({
                                      location: 1
                                    })
                                    
                                    var xAxis = chart.xAxes.push(am5xy.CategoryAxis.new(root, {
                                      maxDeviation: 0.3,
                                      categoryField: "country",
                                      renderer: xRenderer,
                                      tooltip: am5.Tooltip.new(root, {})
                                    }));
                                    
                                    var yAxis = chart.yAxes.push(am5xy.ValueAxis.new(root, {
                                      maxDeviation: 0.3,
                                      renderer: am5xy.AxisRendererY.new(root, {
                                        strokeOpacity: 0.1
                                      })
                                    }));
                                    
                                    
                                    // Create series
                                    // https://www.amcharts.com/docs/v5/charts/xy-chart/series/
                                    var series = chart.series.push(am5xy.ColumnSeries.new(root, {
                                      name: "Series 1",
                                      xAxis: xAxis,
                                      yAxis: yAxis,
                                      valueYField: "value",
                                      sequencedInterpolation: true,
                                      categoryXField: "country",
                                      tooltip: am5.Tooltip.new(root, {
                                        labelText: "{valueY}"
                                      })
                                    }));
                                    
                                    series.columns.template.setAll({ cornerRadiusTL: 5, cornerRadiusTR: 5, strokeOpacity: 0 });
                                    series.columns.template.adapters.add("fill", function(fill, target) {
                                      return chart.get("colors").getIndex(series.columns.indexOf(target));
                                    });
                                    
                                    series.columns.template.adapters.add("stroke", function(stroke, target) {
                                      return chart.get("colors").getIndex(series.columns.indexOf(target));
                                    });
                                    
                                    
                                    // Set data
                                    var data = [{
                                      country: <%= fiveMonthsAgoMonth %> + "월",
                                      value: <%= chart.getChart1() %>
                                    }, {
                                      country: <%= fourMonthsAgoMonth %> + "월",
                                      value: <%= chart.getChart2() %>
                                    }, {
                                      country: <%= threeMonthsAgoMonth %> + "월",
                                      value: <%= chart.getChart3() %>
                                    }, {
                                      country: <%= twoMonthsAgoMonth %> + "월",
                                      value: <%= chart.getChart4() %>
                                    }, {
                                      country: <%= oneMonthAgoMonth %> + "월",
                                      value: <%= chart.getChart5() %>
                                    }, {
                                      country: <%= currentMonth %> + "월",
                                      value: <%= chart.getChart6() %>
                                    }];
                                    
                                    xAxis.data.setAll(data);
                                    series.data.setAll(data);
                                    
                                    
                                    // Make stuff animate on load
                                    // https://www.amcharts.com/docs/v5/concepts/animations/
                                    series.appear(1000);
                                    chart.appear(1000, 100);
                                    
                                    }); // end am5.ready()
                                    </script>
        
                                    <div style="height: 30px;"></div>
                                    
                                    <!-- HTML -->
                                    <div id="chartdiv"></div>
            
                                </div>
    
                            </div>

                            <div class="col-xl-6" style="width:100%;">
                                <div class="card mb-4">
                                    <div class="card-header">
                                        <i class="fas fa-chart-bar me-1"></i>
                                        커뮤니티 현황
                                    </div>
                                    <div class="card-body">
                                    	
                                    	<div style="text-align:center;">
                                    		<h3>KH 아파트 입주민 커뮤니티</h3>
                                    	</div>
                                    
                                   		<table align="center" style="text-align:center; height:200px;">
                                   			<tbody>
                                   				<tr>
													<td style="width:160px;">현재 회원 수 : </td>
													<td> <%= comm.getChart1() %>명</td>
                                   				</tr>
                                   				<tr>
                                   					<td colspan="2" style="height:5px;"></td>
                                   				</tr>
                                   				<tr>
													<td style="width:160px;">이번 달 가입회원 수 : </td>
													<td> <%= comm.getChart2() %>명</td>
                                   				</tr>
                                   				<tr>
                                   					<td colspan="2" style="height:5px;"></td>
                                   				</tr>
                                   				<tr>
													<td style="width:160px;">전체 게시글 수 : </td>
													<td> <%= comm.getChart3() %>개</td>
                                   				</tr>
                                   				<tr>
                                   					<td colspan="2" style="height:5px;"></td>
                                   				</tr>
                                   				<tr>
													<td style="width:160px;">이번 달 게시글 수 : </td>
													<td><%= comm.getChart4() %>개</td>
                                   				</tr>
                                   			</tbody>
                                   		</table>
                                    </div>
                                    
                                </div>
    
                            </div>
                           </div> 
                        <div class="card mb-4">
                            <div class="card-header">
                                <i class="fas fa-table me-1"></i>
                                최신 게시글
                            </div>
                            <div class="card-body">
                                <table id="datatablesSimple" class="newest-area">
                                    <thead>
                                        <tr>
                                            <th>작성일</th>
                                            <th>작성자</th>
                                            <th>제목</th>
                                            <th>카테고리</th>
                                            <th>게시글 번호</th>
                                            <th>조회수</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    	
                                    	 
                                    	<% if(board.isEmpty()) { %>
                                    	
                                    		<tr>
                                    			<td colspan="6">
                                    				조회된 게시글이 없습니다.
                                    			</td>
                                    		</tr>
                                    	
                                    	<% } else { %>
            							
            								<% for(Board b : board){ %>                        
		                                        <tr>
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
                                
                                <script>
	                            	
	                            	$(function(){
	                            		
	                            		$(".newest-area>tbody>tr").click(function(){
	                            			
	                            			let bno = $(this).children().eq(4).text();
	                            			let cgNo = $(this).children().eq(3).text();
										                            			
	                            			if(cgNo == 5 ||cgNo == 6 ||cgNo == 8 ||cgNo == 9){
	                            				location.href = "<%= contextPath %>/imageDetail.ad?bno=" + bno + "&cgNo=" + cgNo;
	                            			}else{
	                            				location.href = "<%= contextPath %>/boardDetail.ad?bno=" + bno + "&cgNo=" + cgNo;	
	                            			}
	                            			          
	                            			
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