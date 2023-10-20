<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
  <style>
    .wrap {
    width : 1200px;
    height : 1100px;
    margin : auto;
    border : 1px solid lightgray;
}

.joinForm {
    width : 800px;
    margin : auto;
    margin-top : 0px;
    padding-top : 30px;
}

.joinForm_1 {
    text-align : center;
}

.joinForm_2>form {
    width : 350px;
    height : 200px;
    margin : auto;
}

.joinForm_2 table {
    width : 100%;
}

.joinForm_2 table input,
.joinForm_2 table button {
    width : 100%;
    height : 40px;
    box-sizing : border-box;
    border-radius : 5px;
}

.joinForm_2 table input {
    border : 1px solid lightgray;
    padding : 10px;
    font-size : 16px;
    margin-bottom: 10px;
}


.joinForm_2 .etc {
    padding-top : 10px;
    text-align : center;
    color : gray;
}

.joinForm_2 .etc>a {
    color : gray;
    text-decoration : none;
}
.breadcrumbs ol li a {
    color: #f4c005;
}
button[type="submit"] {
      border: 0px;
      color: white;
      font-size: 18px;
      font-weight: 700;
      width : 344.8px;
      height : 42px;
      border-radius: 8px;
      background-color: #f4c005;
      }

button[type="button"] {
       border: 0px;
       color: white;
       font-size: 18px;
       font-weight: 500;
       width : 100px;
       height : 35px;
       float: right;
       border-radius: 8px;
       background-color: gray;
       }

.input-button-container {
	  display: flex; 
	  align-items: center;
}

.input-button-container input {
  	  flex: 1;
}

.input-button-container button {
 	  margin-left: 10px;
}
</style>
</head>
<body>

 <!-- boardHeader 인클루드-->

 <%@ include file="../common/boardHeader.jsp" %>

  <main id="main">

    <!-- ======= Breadcrumbs ======= -->
    <div class="breadcrumbs d-flex align-items-center" style="background-image: url('assets/img/chuncheonlakecity_940x350.jpg');">
      <div class="container position-relative d-flex flex-column align-items-center" data-aos="fade">
        <h2>회원가입</h2>
        <ol>
            <li><a href="index.html">Home</a></li>
        </ol>
        </div>
    </div><!-- End Breadcrumbs -->

    <!-- ======= Contact Section ======= -->
    <section id="contact" class="contact">
      <div class="container" data-aos="fade-up" data-aos-delay="100">

        <div class="wrap"
             aria-colspan="3">
             <div align="center">
              <img src="<%= contextPath %>/resources/img/ONlogo-yellow.png" width="200px" height="200px">
              </div>
            <div class="joinForm">

                <div class="joinForm_2">
                  <form id="enroll-form" action="<%= contextPath %>/insert.me" method="post">
					  <div class="form-group">
					  <label for="memberId">* 아이디:</label>
					  <div class="input-button-container">
					    <input type="text" class="form-control" id="memberId" name="memberId">
					    <button type="button" onclick="idCheck();">중복확인</button>
					  </div>
					</div>
                    <br>
                    <div class="form-group">
                      <label for="memberpwd">* 비밀번호:</label>
                      <input type="password" class="form-control" 
                                    id="memberpwd" name="memberPwd">
                    </div>
                    <br>
                    <div class="form-group">
                      <label for="rememberpwd">* 비밀번호 확인:</label>
                      <input type="password" class="form-control" 
                                    id="rememberpwd" name="rememberPwd">
                    </div>
                    <br>
                    <div class="form-group">
                      <label for="membername">* 이름:</label>
                      <input type="text" class="form-control" 
                                    id="membername" name="memberName">
                    </div>
                    <br>
                    <div class="form-group">
                      <label for="address2">* 단지:</label>
                      <select class="form-control" name="address2" id="address2">
                        <option value=1>1단지</option>
                        <option value=2>2단지</option>
                        <option value=3>3단지</option>
                      </select>
                    </div>
                     <br>
                    <div class="form-group">
                      <label for="address">* 동-호수:</label>
                      <input type="text" class="form-control" 
                                   id="address" name="address" placeholder="-포함 입력">
                    </div>
                    <br>
                    <div class="form-group">
                      <label for="email">* 이메일:</label>
                      <input type="text" class="form-control" 
                                    id="email" name="email">
                    </div>
                    <br>
                    <div class="form-group">
                      <label for="phone">* 핸드폰 번호:</label>
                      <input type="text" class="form-control" 
                                    id="phone" name="phone" placeholder="-포함 입력">
                    </div>
                    <br><br>
                    <div class="form-group">
                          <button type="submit" disabled>회원가입</button>
                    </div>
                  </form>
                  <script>
                  function idCheck() {
                	    let $memberId = $("#enroll-form input[name=memberId]");
                	    
                	    console.log($memberId.val())

                	    $.ajax({
                	      url: "idCheck.me",
                	      type: "get",
                	      data: { checkId: $memberId.val() },
                	      success: function (result) {
                	       
                	    	  if (result == "NNNNN") { // 사용 불가
                	          
                	    		  alert("이미 존재하거나 탈퇴한 회원의 아이디입니다.");
                	          
                	    	  $memberId.focus(); // 재입력 유도
                	        
                	    	  } else { // 사용 가능
                	          
                	    		  if (confirm("사용 가능한 아이디입니다. 사용하시겠습니까?")) {
                	            
                	    			  $("#enroll-form button[type=submit]").prop("disabled", false);
                	            
                	    			  $memberId.prop("readonly", true); 
                	          
                	    		  } else { // 재입력 유도
                	            
                	    			  $memberId.focus();
                	          }
                	        }
                	      },
                	      error: function () {
                	        console.log("아이디 중복체크용 ajax 통신 실패!");
                	      }
                	    });
                	  }
                  </script>
                </div>
		          
            </div>
    
        </div>
          </div><!-- End Contact Form -->

    </section><!-- End Contact Section -->

  </main><!-- End #main -->


  <!-- 푸터 인클루드-->
  <%@ include file="../common/boardFooter.jsp" %>

</body>

</html>