<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
<style>
    table {
  border-collapse: collapse;
  border-spacing: 0;
}


.page-title {
  margin-bottom: 60px;
}
.page-title h3 {
  font-size: 35px;
  color: #333333;
  font-weight: 400;
  text-align: center;
}

#board-search .search-window {
  padding: 15px 0;
  background-color: #f9f7f9;
}
#board-search .search-window .search-wrap {
  position: relative;
/*   padding-right: 124px; */
  margin: 0 auto;
  width: 80%;
  max-width: 564px;
}
#board-search .search-window .search-wrap input {
  height: 40px;
  width: 100%;
  font-size: 14px;
  padding: 7px 14px;
  border: 1px solid #ccc;
}
#board-search .search-window .search-wrap input:focus {
  border-color: #333;
  outline: 0;
  border-width: 1px;
}
#board-search .search-window .search-wrap .btn {
  position: absolute;
  right: 0;
  top: 0;
  bottom: 0;
  width: 108px;
  padding: 0;
  font-size: 16px;
}

.board-table {
  font-size: 13px;
  width: 100%;
  border-top: 1px solid #ccc;
  border-bottom: 1px solid #ccc;
}

.board-table a {
  color: #333;
  display: inline-block;
  line-height: 1.4;
  word-break: break-all;
  vertical-align: middle;
}
.board-table a:hover {
  text-decoration: underline;
}
.board-table th {
  text-align: center;
}

.board-table .th-num {
  width: 100px;
  text-align: center;
}



.board-table th, .board-table td {
  padding: 14px 0;
}

.board-table tbody td {
  border-top: 1px solid #e7e7e7;
  text-align: center;
}

.board-table tbody th {
  padding-left: 28px;
  padding-right: 14px;
  border-top: 1px solid #e7e7e7;
  text-align: left;
}

.board-table tbody th p{
  display: none;
}

.btn {
  display: inline-block;
  padding: 0 30px;
  font-size: 15px;
  font-weight: 400;
  background: transparent;
  text-align: center;
  white-space: nowrap;
  vertical-align: middle;
  -ms-touch-action: manipulation;
  touch-action: manipulation;
  cursor: pointer;
  -webkit-user-select: none;
  -moz-user-select: none;
  -ms-user-select: none;
  user-select: none;
  border: 1px solid transparent;
  text-transform: uppercase;
  -webkit-border-radius: 0;
  -moz-border-radius: 0;
  border-radius: 0;
  -webkit-transition: all 0.3s;
  -moz-transition: all 0.3s;
  -ms-transition: all 0.3s;
  -o-transition: all 0.3s;
  transition: all 0.3s;
}

.btn-dark {
  background: #555;
  color: #fff;
}

.btn-dark:hover, .btn-dark:focus {
  background: #F4C005;
  border-color: #F4C005;
  color: #fff;
}

.btn-dark {
  background: #555;
  color: #fff;
}

.btn-dark:hover, .btn-dark:focus {
  background: #F4C005;
  border-color: #F4C005;
  color: #fff;
}

/* reset */

* {
  list-style: none;
  text-decoration: none;
  padding: 0;
  margin: 0;
  box-sizing: border-box;
}
.clearfix:after {
  content: '';
  display: block;
  clear: both;
}
.container {
  width: 1100px;
  margin: 0 auto;
}
.blind {
  position: absolute;
  overflow: hidden;
  clip: rect(0 0 0 0);
  margin: -1px;
  width: 1px;
  height: 1px;
}

.th-writer, .th-count, .th-recommend{
	width : 80px;
}

.th-date {
	width : 120px;
}

  </style>
</head>
<body>
    




<%@ include file="/views/common/adminHeader.jsp" %>


<!--<div id="layoutSidenav_content">

        관리자 페이지는 무조건 이 태그를 감싸 사용

    </div>-->


        <div id="layoutSidenav_content">
            <div style="height: 20px;"></div>
            <main>
                <div class="container-fluid px-4">
                             
                    
                    <h1 class="mt-4">바베큐장 예약</h1>
                    <div style="height: 50px;"></div>
                    
                    <div class="row">
                        <div class="col-xl-6">
                            
                        </div>
                        
                    </div>
                    <div class="card mb-4">
            <div class="card-header">
            <i class="fas fa-table me-1"></i>
                            금일 예약 내역
          </div>
          
          <div  align="left">                  	                
                    	<button class="btn btn-emargency">삭제하기</button>                   
                 </div>
     <div class="card-body">
                                
     <section id="services" class="section-bg">     
      <section class="notice">
        
        
        <!-- board list area -->
          <div id="board-list">
              <div class="container">
                  <table class="board-table">
                      <thead>
                      <tr>							
	                   <th><input type="checkbox"></th>	               		
                          <th scope="col" class="th-num">예약번호</th>
                          <th scope="col" class="th-count">예약 좌석</th>                          
                          <th scope="col" class="th-writer">예약인 성함</th>
                          <th scope="col" class="th-date">등록일</th>
                          <th scope="col" class="th-title">예약 메세지</th>
                          <th scope="col" class="th-recommend">인원</th>
                      </tr>
                      </thead>
                      <tbody>
                 		<tr>
                 			<td><input type="checkbox"></td>                 			
                 			<td>1</td>
                 			<td>2</td>
                 			<td>김인엽</td>
                 			<td>2023-10-16</td>
                 			<td style="text-align : left; padding-left : 100px; padding-right : 100px">하이</td>
                 			<td>2</td>
                 		</tr>	  
                 		<tr>
                 			<td><input type="checkbox"></td>                 			
                 			<td>2</td>
                 			<td>3</td>
                 			<td>김인엽</td>
                 			<td>2023-10-16</td>
                 			<td style="text-align : left; padding-left : 100px; padding-right : 100px">하이</td>
                 			<td>2</td>
                 		</tr>	                     						
                      </tbody>
                  </table>                  
                  <br>                                                  
              </div>
          </div>
      </section>
    </section><!-- End Services Section -->
                                
                                
              
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
        
            
           <%@ include file="/views/common/adminFooter.jsp" %>
       </body>
    </html>