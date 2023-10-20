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
        height : 500px;
        margin-top : 120px;
        border : 1px solid lightgray;
    }

    .loginForm {
        width : 1000px;
        margin : auto;
        margin-top : 0px;
        padding-top : 30px;
    }

    .loginForm_1 {
        text-align : center;
    }

    .loginForm_2>form {
        width : 350px;
        height : 200px;
        margin : auto;
    }

    .loginForm_2 table {
        width : 100%;
    }

    .loginForm_2 table input,
    .loginForm_2 table button {
        width : 100%;
        height : 40px;
        box-sizing : border-box;
        border-radius : 5px;
    }
    .loginForm_2 table input[type=checkbox] {
      width : 15px;
      height : 15px;
    }
    .loginForm_2 table input[type=checkbox]+label {
      color : gray;
      font-weight : lighter;
      font-size :small;
    }

    .loginForm_2 table input {
        border : 1px solid lightgray;
        padding : 10px;
        font-size : 16px;
    }

    .loginForm_2 table button {
        border : 0px;
        color : white;
        font-size : 18px;
        font-weight : 700;
        margin-top: 20px;
        background-color : #f4c005;
    }

    .loginForm_2 .etc {
        padding-top : 10px;
        text-align : center;
        color : gray;
    }

    .loginForm_2 .etc>a {
        color : gray;
        text-decoration : none;
    }
    .breadcrumbs ol li a {
        color: #f4c005;
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
        <h2>로그인</h2>
        <ol>
            <li><a href="index.html">Home</a></li>
        </ol>
        </div>
    </div><!-- End Breadcrumbs -->

    <!-- ======= Contact Section ======= -->
    <section id="contact" class="contact">
      <div class="container" data-aos="fade-up" data-aos-delay="100">

        <div class="wrap">
          <div align="center">
          <img src="<%= contextPath %>/resources/img/ONlogo-yellow.png" width="200px" height="200px">
          </div>
            <div class="loginForm">
                
                <div class="loginForm_2">
                    <form action="<%= contextPath %>/login.me" method="post">
                        <table>
                            <tr>
                                <td>
                                    <input type="text" 
                                            name="memberId" placeholder="아이디">
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <input type="password"
                                            name="memberPwd" placeholder="비밀번호">
                                </td>
                            </tr>
                            <tr align="left">
                              <th colspan="2">
                              <input type="checkbox"
                                    id="saveId"
                                    name="saveId"
                                    value="y">
                              <label>아이디 저장</label>
                              </th>
                            </tr>
                            <tr>
                                <td>
                                    <button type="submit">로그인</button>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <div class="etc">
                                        <a href="<%= contextPath %>/enrollForm.me">회원가입</a> | <a href="<%= contextPath %>/views/member/memberFindIdForm.jsp">아이디 찾기</a> | <a href="<%= contextPath %>/views/member/memberFindPwdForm.jsp">비밀번호 찾기</a>
                                    </div>
                                </td>
                            </tr>
                        </table>
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