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

.findForm {
    width : 800px;
    margin : auto;
    margin-top : 0px;
    padding-top : 30px;
}

.findForm_1 {
    text-align : center;
}

.findForm_2>form {
    width : 350px;
    height : 200px;
    margin : auto;
}

.findForm_2 table {
    width : 100%;
}

.findForm_2 table input,
.findForm_2 table button {
    width : 100%;
    height : 40px;
    box-sizing : border-box;
    border-radius : 5px;
}

.findForm_2 table input {
    border : 1px solid lightgray;
    padding : 10px;
    font-size : 16px;
}


.findForm_2 .etc {
    padding-top : 10px;
    text-align : center;
    color : gray;
}

.findForm_2 .etc>a {
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
        <h2>아이디 찾기</h2>
        <ol>
            <li><a href="index.jsp">Home</a></li>
        </ol>
        </div>
    </div><!-- End Breadcrumbs -->

    <!-- ======= Contact Section ======= -->
    <section id="contact" class="contact">
      <div class="container" data-aos="fade-up" data-aos-delay="100">

        <div class="wrap">
          <div align="center">
            <img src="../../resources/img/ONlogo-yellow.png" width="200px" height="200px">
            </div>
            <div class="findForm">

                <div class="findForm_2">
                  <form action="<%= contextPath %>/findid.me" method="post">
                    
                    <div class="form-group">
                      <label for="name">* 이름:</label>
                      <input type="text" class="form-control" 
                                    id="name" name="name">
                    </div>
                    <br>
                    
                    <div class="form-group">
                      <label for="phone">* 핸드폰 번호:</label>
                      <input type="text" class="form-control" 
                                    id="phone" name="phone" placeholder="-포함 입력">
                    </div>
                    <br><br>
                    <div class="form-group">
                          <button type="submit">아이디 찾기</button>
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