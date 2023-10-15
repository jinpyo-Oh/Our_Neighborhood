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
              <img src="../../resources/img/ONlogo-yellow.png" width="200px" height="200px">
              </div>
            <div class="joinForm">

                <div class="joinForm_2">
                  <form action="/action_page.php" method="post">
                    <div class="form-group">
                      <label for="userId">* 아이디:</label>
                      <input type="text" class="form-control" 
                                    id="userId" name="userId">
                    </div>
                    <br>
                    <div class="form-group">
                      <label for="pwd">* 비밀번호:</label>
                      <input type="password" class="form-control" 
                                    id="pwd" name="userPwd">
                    </div>
                    <br>
                    <div class="form-group">
                      <label for="repwd">* 비밀번호 확인:</label>
                      <input type="password" class="form-control" 
                                    id="repwd" name="reuserPwd">
                    </div>
                    <br>
                    <div class="form-group">
                      <label for="name">* 이름:</label>
                      <input type="text" class="form-control" 
                                    id="name" name="name">
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
                                    id="phone" name="phone" placeholder="-없이 입력">
                    </div>
                    <br><br>
                    <div class="form-group">
                          <button type="submit">회원가입</button>
                    </div>
                  </form>
                </div>
                
    
            </div>
    
        </div>
            </form>
          </div><!-- End Contact Form -->

        </div>

      </div>
    </section><!-- End Contact Section -->

  </main><!-- End #main -->


  <!-- 푸터 인클루드-->
  <%@ include file="../common/boardFooter.jsp" %>

</body>

</html>