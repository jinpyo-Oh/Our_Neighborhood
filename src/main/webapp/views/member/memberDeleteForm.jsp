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
            height : 600px;
            margin : auto;
            border : 1px solid lightgray;
        }

        .joinForm {
            width : 600px;
            margin : auto;
            margin-top : 0px;
            padding-top : 30px;

        }
        .joinForm_1 {
            text-align : left;
        }

        .joinForm_2>form {
            width : 350px;
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
        }


        .joinForm_2 .etc {
            padding-top : 10px;
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
              width : 100px;
              height : 35px;
              float: right;
              border-radius: 8px;
              background-color: gray;
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
          padding-left: 100px;
          padding-right: 50px;
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
        <h2>회원 탈퇴</h2>
        <ol>
            <li><a href="index.html">Home</a></li>
        </ol>
        </div>
    </div><!-- End Breadcrumbs -->

    <!-- ======= Contact Section ======= -->
    <section id="contact" class="contact">
      
      
        <div class="wrap">
          <div class="nav-area" align="auto">
            <div class="menu"><a href="<%= contextPath %>/views/member/mypageView.jsp">회원정보수정</a></div>
            <div class="menu"><a href="cost.html">관리비 조회</a></div>
            <div class="menu"><a href="bbq.html">바베큐 예약/취소</a></div>
            <div class="menu"><a href="<%= contextPath %>/views/member/memberDeleteForm.jsp">회원탈퇴</a></div>
          </div>
        <div align="center">
          <img src="<%= contextPath %>/resources/img/ONlogo-yellow.png" width="200px" height="200px">
          </div>
          <div class="container" data-aos="fade-up" data-aos-delay="100">
            
            <div class="joinForm">

                <div class="joinForm_2">
                  <form action="<%= contextPath %>/delete.me" method="post">
                    <div class="joinForm_2">
                      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>탈퇴 후 복구가 불가능합니다.</b><br>
                      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>정말로 탈퇴 하시겠습니까?</b><br><br><br><br>
                      <label for="memberPwd">비밀번호: </label>
                      <input type="password" class="form-control" 
                             id="memberPwd" name="memberPwd">
                    <br>
                   
                    <br><br>
                    <div class="joinForm_2">
                          <button type="submit">회원 탈퇴</button>
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