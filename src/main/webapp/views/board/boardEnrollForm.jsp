<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String cgNo = (String)request.getAttribute("cgNo");
%>
    <!DOCTYPE html>
    <html lang="en">
    <head>
      <meta charset="UTF-8">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <title>Document</title>
      <style>
        .content_detail tr, .content_detail td {
          border : 1px dotted black;
        }
        
        .contetn_detail textarea, 
        .contetn_detail input {
          box-sizing: border-box;
        }
    
        tr, td {
          border : 1px solid black;
        }
    	
    	 .card-header1 h1 {
		    font-size: 30px;
		    font-weight: 600;
    
		}
		
		.card-write {
		    padding: 20px;
		}
		
		.card-write input, textarea{
		    margin-left: 10px;
		    padding: 10px;
		    border: 1px solid #999;
		    border-radius: 10px;
		    box-shadow: 3px 3px 10px #e6e6e6;
		}
		
		.card-write .title-w input[type="text"] {
		    margin-top: 20px;
		    margin-bottom: 20px;
		    width: 50%;
		}
		
		.card-write .msg textarea {
		    min-width: 50%;
		    max-width: 85.5%;
		    min-height: 200px;
		    max-height: 200px;
		    box-shadow: inset 3px 3px 10px #e6e6e6;
			resize: none;
		    /* vertical-align: 텍스트를 수직, 수평 정렬 할 수 있다. */
		    vertical-align: top;
		}
		
		.card-write input[type="file"] {
		    border: none;
		    box-shadow: none;
		    padding: 10px;
		    margin-left: 40px;
		}
		
		.btn-w {
		    position: absolute;
		    right: 0;
		    margin: 10px 300px 20px 10px;
		    padding: 10px;
		}
		
		.btn-w a {
		    background-color: tomato;
		    padding: 10px;
		    color: #fff;
		    border-radius: 10px;
		}
		
		h3{
		  font-size: 35px;
		  color: #333333;
		  font-weight: 400;
		  text-align: center;
		}
      	
      	#submit {
      		padding-right : 200px;
      	}
		#insertFile>input{
			display: block;
		}

		#insertFile {
			margin-left: 26%;
		}
      </style>
    </head>
    
      
    
    <body>
    
      <%@ include file="/views/common/boardHeader.jsp" %> 
      <main id="main">
    
        <!-- ======= Breadcrumbs ======= -->
        <div class="breadcrumbs d-flex align-items-center" style="background-image: url('./resources/img/board/apartmentpic/apartmentpic.jpg');">
          <div class="container position-relative d-flex flex-column align-items-center" data-aos="fade">
    
            <h2>게시글 작성</h2>
            <ol>
              <li><a href="index.html">메인 페이지</a></li>
              <li>단지게시판</li>
              <li>1단지게시판</li>
            </ol>
    
          </div>
        </div><!-- End Breadcrumbs -->
    
        <!-- ======= Services Section ======= -->
        <form action="<%= contextPath %>/insert.bo" method="post" id="enroll-Form" enctype="multipart/form-data">
        	<section id="services" class="section-bg">
	        <div class="container" data-aos="fade-up">
	          <div class="outer">
	          <!-- 작성자의 회원번호도 같이 넘길 것 -->
	    	  <input type="hidden" name="userNo" value="<%= loginUser.getMemberNo() %>">
	    	  <input type="hidden" name="cgNo" value="<%=cgNo %>">
	           <h3>게시글 작성</h3>
	       		 <div class="card-write">
	           		<div class="myinfo">
	           		</div>
					<div class="title-w" align="center" style="padding-right : 5px;">
						<input name="title" type="text" placeholder="제목을 입력하세요.">
					</div>
	
		            <div class="msg" align="center">
		                <!-- 내용을 입력하기 위해 textarea tag를 이용 -->
		                <textarea name="content" placeholder="내용을 입력하세요."></textarea>
		            </div>
	        		</div>
					<div id="insertFile">
					<a id="addFiles" class="btn btn-dark">+</a>
					<a id="removeFile" class="btn btn-dark">-</a>
					</div>
					<br><br>
					<script>
	
						$(function(){
							let maxFile = 1;
							$("#addFiles").on("click", function() {
								if($("#insertFile>input").length<maxFile){
									$("#insertFile").append('<input type="file" name="upfile">');
								}													
							})
							$("#removeFile").on("click", function() {
								let files = $("#insertFile>input")
								$("#insertFile>input").eq(files.length-1).remove();
	
	
								
							})
	
							
						})
					</script>
					
	          		<div align="center">
	              		<button type="submit" class="btn btn-secondary btn-sm">등록하기</button>
	              		<button type="reset" class="btn btn-warning btn-sm" onclick="history.back();">
							뒤로가기
						</button>
	              		<!-- history.back() : 이전 페이지로 돌아가게 해주는 함수-->
		            </div>
		          </div>
		        </div>
	          </div>
	        </section>
        </form><!-- End Services Section -->
      </main><!-- End #main -->
      <%@ include file="/views/common/boardFooter.jsp" %> 
    </body>
    
    </html>