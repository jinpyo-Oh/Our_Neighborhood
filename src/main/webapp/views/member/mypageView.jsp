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
    border : 1px solid lightgray;
}

.eidtForm {
    width : 600px;
    margin : auto;
    margin-top : 100px;
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
  background-color : #f4c005; 
  width : 1200px;
}
.menu {
  width: 1200px;
  height:15px;
  display : inline;
  padding-left: 200px;
  padding-right: 30px;
}
.menu a {
  text-decoration : none;
  color : white;
  font-size : 20px;
  font-weight : bold;
  width : 100%;
  
}
.menu a:hover { background-color : darkgray; }

</style>
</head>

  


<body>

 <!-- boardHeader 인클루드-->

  <%@ include file="../common/boardHeader.jsp" %>

  <main id="main">

    <!-- ======= Breadcrumbs ======= -->
    <div class="breadcrumbs d-flex align-items-center" style="background-image: url('assets/img/chuncheonlakecity_940x350.jpg');">
      <div class="container position-relative d-flex flex-column align-items-center" data-aos="fade">
        <h2>마이페이지</h2>
        <ol>
            <li><a href="index.html">Home</a></li>
        </ol>
        </div>
    </div><!-- End Breadcrumbs -->

    <!-- ======= Contact Section ======= -->
    <section id="contact" class="contact">
        <div class="wrap">
          <div class="nav-area" align="auto">
            <div class="menu"><a href="mypage.html">회원정보수정</a></div>
            <div class="menu"><a href="cost.html">관리비 조회</a></div>
            <div class="menu"><a href="member-delete.html">회원탈퇴</a></div>
          </div>

          <div class="container" data-aos="fade-up" data-aos-delay="100">
            
          <div class="eidtForm">
            <div class="eidtForm_2">
             <form action="" method="post">
                    <div class="eidtForm_2">
                      <label for="userId">* 아이디:</label>
                      <input type="text" class="form-control" 
                             id="userId" name="user" placeholder="user01" disabled>
                    <br>
                    </div>
                    <div class="eidtForm_2">
                      <label for="pwd">* 비밀번호:</label>
                      <input type="password" class="form-control" 
                                    id="pwd" name="userPwd" placeholder="*********">
                    <br>
                    </div>
                    <div class="eidtForm_2">
                      <label for="repwd">* 비밀번호 확인:</label>
                      <input type="password" class="form-control" 
                                    id="repwd" name="reuserPwd" placeholder="*********">
                    <br>
                    </div>
                    <div class="eidtForm_2">
                      <label for="name">* 이름:</label>
                      <input type="text" class="form-control" 
                                    id="name" name="name" placeholder="홍길동">
                      <br>
                    </div>
                    <div class="eidtForm_2">
                      <label for="address">* 동-호수:</label>
                      <input type="text" class="form-control" 
                             id="userId" name="user" placeholder="103-101" disabled>
                    </div>
                    <br>
                    <div class="eidtForm_2">
                      <label for="email">* 이메일:</label>
                      <input type="text" class="form-control" 
                                    id="email" name="email" placeholder="user01@gmail.com">
                    </div>
                    <br>
                    <div class="eidtForm_2">
                      <label for="phone">* 핸드폰 번호:</label>
                      <input type="text" class="form-control" 
                                    id="phone" name="phone" placeholder="01099887744">
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