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
    height : 1000px;
    margin : auto;
}

.eidtForm {
    width : 600px;
    margin : auto;
    margin-top : 50px;
    padding-top : 30px;

}
.eidtForm_1 {
    text-align : left;
}

.eidtForm_2>form {
    width : 350px;
    margin : auto;
    align-self: end;
    
}

.eidtForm_2 table {
    width : 100%;
}

.eidtForm_2 table input,
.eidtForm_2 table button {
    width : 100%;
    height : 40px;
    box-sizing : border-box;
    border-radius : 5px;
}

.eidtForm_2 table input {
    border : 1px solid lightgray;
    padding : 10px;
    font-size : 16px;
}


.eidtForm_2 .etc {
    padding-top : 10px;
    color : gray;
}

.eidtForm_2 .etc>a {
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

#login-form, #user-info { float : right; }

#user-info a {
  text-decoration : none;
  color : black;
  font-size : 12px;
}

    .nav-area {
      background-color: #f4c005;
      width: 100%;
    }

    .menu {
      width: 24%;
      height: 98%;
      display : inline-block;
      margin-left: 7px;
      text-align: center;
    }

    .menu a {
      text-decoration : none;
      color : white;
      font-size : 20px;
      font-weight : bold;
      box-sizing: border-box;  
    }

}
.menu a:hover { background-color : darkgray; }

</style>
</head>

  


<body>

 <!-- boardHeader 인클루드-->

  <%@ include file="../common/boardHeader.jsp" %>
  
  <%
		String memberId   =  loginUser.getMemberId();
  		String memberPwd  = (loginUser.getMemberPwd() == null)  ? "" : loginUser.getMemberPwd();
		String memberName =  (loginUser.getMemberName() == null)  ? "" : loginUser.getMemberName();
		int address2  = loginUser.getAddress2();
		String address  = loginUser.getAddress();
		String email    = (loginUser.getEmail() == null)    ? "" : loginUser.getEmail();
		String phone    = (loginUser.getPhone() == null)    ? "" : loginUser.getPhone();
		
	%>

  <main id="main">

    <!-- ======= Breadcrumbs ======= -->
    <div class="breadcrumbs d-flex align-items-center" style="background-image: url('./resources/img/board/apartmentpic/apartmentpic.jpg');">
      <div class="container position-relative d-flex flex-column align-items-center" data-aos="fade">
        <h2>마이페이지</h2>
        <ol>
            <li><a href="index.jsp">Home</a></li>
        </ol>
        </div>
    </div><!-- End Breadcrumbs -->

    <!-- ======= Contact Section ======= -->
    <section id="contact" class="contact">
        <div class="wrap">
          <div class="nav-area" align="auto">
            <div class="menu"><a href="<%= contextPath %>/views/member/mypageView.jsp">회원정보수정</a></div>
            <div class="menu"><a href="<%= contextPath %>/cost.me">관리비 조회</a></div>
            <div class="menu"><a href="<%= contextPath %>/wrote.me?currentPage=1">내가 작성한 글</a></div>
            <div class="menu"><a href="<%= contextPath %>/deleteForm.me">회원탈퇴</a></div>
          </div>

          <div class="container" data-aos="fade-up" data-aos-delay="100">
            
          <div class="eidtForm">
            <div class="eidtForm_2">
             <form action="<%= contextPath %>/update.me" method="post">
                    <div class="eidtForm_2">
                      <label for="memberId">* 아이디:</label>
                      <input type="text" class="form-control" 
                             id="memberId" name="memberId" disabled value="<%= memberId %>">
                    <br>
                    </div>
                    <div class="eidtForm_2">
                      <label for="pwd">* 비밀번호:</label>
                      <input type="password" class="form-control" 
                                    id="memberPwd" name="memberPwd" value="<%= memberPwd %>">
                    <br>
                    </div>
                     <div class="eidtForm_2">
                      <label for="address2">* 단지:</label>
                      <input type="text" class="form-control" 
                             id="address2" name="address2" disabled value="<%= address2 %>">
                    </div>
                    <br>
                    <div class="eidtForm_2">
                      <label for="address">* 동-호수:</label>
                      <input type="text" class="form-control" 
                             id="address" name="address" disabled value="<%= address %>">
                    </div>
                    <br>
                    <div class="eidtForm_2">
                      <label for="name">* 이름:</label>
                      <input type="text" class="form-control" 
                                    id="memberName" name="memberName" value="<%= memberName %>">
                    </div>
                    <br>
                    <div class="eidtForm_2">
                      <label for="email">* 이메일:</label>
                      <input type="text" class="form-control" 
                                    id="email" name="email" value="<%= email %>">
                    </div>
                    <br>
                    <div class="eidtForm_2">
                      <label for="phone">* 핸드폰 번호:</label>
                      <input type="text" class="form-control" 
                                    id="phone" name="phone" value="<%= phone %>">
                    </div>
                    <br><br>
                    <div class="eidtForm_2">
                          <button type="submit">수정 완료</button>
                    </div>
              </form>
            </div>
        </div>
      </section><!-- End Contact Section -->

    </main><!-- End #main -->

 

  <!-- 푸터 인클루드-->
  <%@ include file="../common/boardFooter.jsp" %>
  

</body>

</html>