<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, com.kh.imageBoard.model.vo.* "%>
<%
	
	// 기본 게시물, 기존 첨부파일 정보를 뽑기
	Board b = (Board)request.getAttribute("b");
	
	// 글번호, 카테고리명, 제목, 내용, 작성자 아이디, 작성일
	Image im = (Image)request.getAttribute("im");
	String cgNo = null;
	
	switch(b.getCgNo()){
	case "사진" : cgNo = "5"; break;
	case "중고거래" : cgNo = "6"; break;
	case "홍보" : cgNo = "8"; break;
	case "분실물" : cgNo = "9"; break;
	}

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
    


    <!-- boardHeader 인클루드-->


  <%@ include file="/views/common/boardHeader.jsp" %>
  


  <main id="main">

    <!-- ======= Breadcrumbs ======= -->
    <div class="breadcrumbs d-flex align-items-center" style="background-image: url('./resources/img/board/apartmentpic/apartmentpic.jpg');">
      <div class="container position-relative d-flex flex-column align-items-center" data-aos="fade">

        <h2>게시글 수정</h2>
        <ol>
          <li><a href="index.html">메인페이지</a></li>
          <li>통합게시판</li>
          <li><%=b.getCgNo() %>게시판</li>
        </ol>

      </div>
    </div><!-- End Breadcrumbs -->

    <!-- ======= Services Section ======= -->
    <form action="<%= contextPath %>/imageUpdate.bo?cg=<%=cgNo %>" method="post" enctype="multipart/form-data">
    <input type="hidden" name="memberNo" value="<%=loginUser.getMemberNo() %>">
 			
 		<!--  게시글 번호도 같이 넘기기 -->
 		<input type="hidden" name="boardNo" value="<%= b.getBoardNo() %>">
			<!-- 작성자의 회원 번호도 같이 넘길 것 -->
            <input type="hidden" name="memberNo" value="<%= loginUser.getMemberNo() %>">
            
       <section id="services" class="section-bg">
        <div class="container" data-aos="fade-up">
    		
          <div class="outer">
           <h3>게시글 수정</h3>
       		 <div class="card-write">
       		 
           		<div class="myinfo">
					
           		</div>
				<div class="title-w" align="center" style="padding-right : 5px;">
					<input type="text" name="boardTitle" required value="<%= b.getBoardTitle() %>">										
				</div>

	            <div class="msg" align="center">
	                <!-- 내용을 입력하기 위해 textarea tag를 이용 -->
	                <textarea name="boardContent" required><%= b.getBoardContent() %></textarea>
	            </div>
				
				<table  style="margin: auto;">
					<tr class="addImage">
						
		
					</tr>
				</table>
	            
        		</div>

				
				<div align="center">
				<a id="addFiles" class="btn btn-dark">+</a>
				<a id="removeFile" class="btn btn-dark">-</a>
				</div>
				
				
				<div id="insertFile" >
				
				</div>
				
				
				
				<br><br>
				

				
				
				
				<script>
		
				

						$("#insertFile").hide();
						let index = 0;
						let maxFile = 5;

						$("#addFiles").click(function() {
									
							if (index < maxFile) {
								++index;
								$("#insertFile").append('<input type="file" id="file'+ index + '" class="file" name="file' + index +'" onchange="loadImg(this,'+index+')">');

								$(".addImage").append('<td>'+ '<img class="contentImg" id="contentImg'+index+'" width="150" height="120" >'+ '</td>');
											
								
								}
						});
						
						

						$(document).on('click',"#removeFile",function(){		
							
							if(index>0){
								$("img").remove("#contentImg"+index);
								$("input").remove("#file"+index);
								index--;	
							}											
							
						
						})
						
																																					
						
						
						$(document).on('click','#addFiles',function(){							
							
							console.log(index);
							if((index-1)<maxFile){
								$("#file"+index).click();	
							}
							
												
						})
						
						
						

						
						
						$(document).on('click','.contentImg', function() {
							
									let id = $(this).attr('id');									
									let fileId = "#" + id.replace('contentImg', 'file');
									$(fileId).click();
								});

						   function loadImg(inputFile, num) {

			                   

			                    if(inputFile.files.length == 1) {
			                      
			                        let reader = new FileReader();
		                       		
			                        // FileReader 객체에서 제공하는 파일을 읽어들이는 메소드 호출
			                        reader.readAsDataURL(inputFile.files[0]);
			                        
			                        reader.onload = function(e) {
			                           
			                            switch(num) {
			                            	case 1 : $("#contentImg1").attr("src", e.target.result); break;
			                                case 2 : $("#contentImg2").attr("src", e.target.result); break;
			                                case 3 : $("#contentImg3").attr("src", e.target.result); break;
			                                case 4 : $("#contentImg4").attr("src", e.target.result); break;
			                                case 5 : $("#contentImg5").attr("src", e.target.result); break;
			                            }
			                        };
			                    } else {
			                        
			                        switch(num) {
			                        		case 1 : $("#contentImg1").attr("src", null); break;
			                                case 2 : $("#contentImg2").attr("src", null); break;
			                                case 3 : $("#contentImg3").attr("src", null); break;
			                                case 4 : $("#contentImg4").attr("src", null); break;
			                                case 5 : $("#contentImg5").attr("src", null); break;
			                            }
			                    }
						   }
						   
						  
					
				</script>
				
          		
          		<div align="center">
              		<button type="submit" class="btn btn-secondary btn-sm">수정하기</button>
	              		<button type="reset" class="btn btn-warning btn-sm" onclick="history.back();">
							취소하기
						</button>
              		<!-- history.back() : 이전 페이지로 돌아가게 해주는 함수-->
	            </div>
	          </div>
	        </div>
          </div>
          
        </section><!-- End Services Section -->
       
        </form>
      </main><!-- End #main -->
      <%@ include file="/views/common/boardFooter.jsp" %>
</body>

</html>