<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        .outer {
            width : 1000px;
            margin : auto;
            margin-top : 50px;
            border : 1px dotted lightgray;
        }
    
        #enroll-form>table { border : 1px solid lightgray; }
        #enroll-form input,
        #enroll-form textarea {
            width : 100%;
            box-sizing : border-box;
        }
     
      </style>
</head>
<body>
    


    <!-- boardHeader 인클루드-->

  <%@ include file="../common/boardHeader.jsp" %>
  


  <main id="main">

    <!-- ======= Breadcrumbs ======= -->
    <div class="breadcrumbs d-flex align-items-center" style="background-image: url('assets/img/breadcrumbs-bg.jpg');">
      <div class="container position-relative d-flex flex-column align-items-center" data-aos="fade">

        <h2>게시글 조회</h2>
        <ol>
          <li><a href="index.html">사진 게시판</a></li>
          <li>수정</li>
        </ol>

      </div>
    </div><!-- End Breadcrumbs -->

    <!-- ======= Services Section ======= -->
    <div class="outer">

      <br>
      <h2 align="center">사진게시판 작성하기</h2>
      <br>

      <form action="<%= contextPath %>/insert.th" id="enroll-form" 
              method="post" enctype="multipart/form-data">
              
          <!-- 작성자의 회원번호 같이 넘기기 -->
          

          <input type="hidden" name="userNo" 
                value="">
     

          <table align="center">

              <tr>
                  <th width="100">제목</th>
                  <td colspan="3">
                      <input type="text" name="title" required>
                  </td>
              </tr>
              <tr>
                  <th>내용</th>
                  <td colspan="3">
                      <textarea name="content" rows="5" 
                              style="resize : none;" required></textarea>
                  </td>
              </tr>
              <tr>
                  <th>대표이미지</th>
                  <td colspan="3" align="center">
                      <!-- 미리보기 영역 -->
                      <img id="titleImg" width="250" height="170">
                  </td>
              </tr>
              <tr>
                  <th>상세이미지</th>
                  <td>
                      <img id="contentImg1" width="150" height="120">
                  </td>
                  <td>
                      <img id="contentImg2" width="150" height="120">
                  </td>
                  <td>
                      <img id="contentImg3" width="150" height="120">
                  </td>
              </tr>

          </table>

          <!-- 
              실제 파일을 입력받을 수 있는 
              input type="file" 태그 배치 

              * 우리는 사진게시글 하나당 첨부파일을 4개씩 올릴 것
              input 태그, 이미지 미리보기용 img 태그 4개씩 배치
              => cos.jar 는 input type="file" 태그 하나당 파일 하나씩밖에 못보냄!!
          -->
          <div id="file-area">
              <input type="file" id="file1" name="file1" onchange="loadImg(this, 1);" required> <!-- 대표이미지용 (필수) -->
              <input type="file" id="file2" name="file2" onchange="loadImg(this, 2);">
              <input type="file" id="file3" name="file3" onchange="loadImg(this, 3);">
              <input type="file" id="file4" name="file4" onchange="loadImg(this, 4);">
              <!--
                  change 이벤트 : input 태그의 내용물이 변경될때마다 발생하는 이벤트
                  이벤트 발생 시 함수의 매개변수로 this 를 전달하면 
                  이벤트를 당한 요소 자체 (target) 이 넘어감!!
              -->
          </div>

          <script>
              $(function() {

                  // 각 이미지 요소를 클릭했을 때
                  // 자리에 맞는 input type="file" 이 클릭되게끔
                  $("#titleImg").click(function() {
                      $("#file1").click();
                      // jQuery 메소드들은 대부분 getter 와 setter 역할을 겸함
                      // click 메소드도 마찬가지
                      // 매개변수로 function 이 있을 경우 : 이벤트 정의 (setter)
                      // 매개변수로 function 이 없을 경우 : 이벤트를 발생시키겠다.
                  });

                  $("#contentImg1").click(function() {
                      $("#file2").click();
                  });

                  $("#contentImg2").click(function() {
                      $("#file3").click();
                  });

                  $("#contentImg3").click(function() {
                      $("#file4").click();
                  });

                  // 하단의 input type="file" 들을 숨김처리
                  $("#file-area").hide();
              });

              function loadImg(inputFile, num) {

                  // console.log("잘 되나?");
                  // console.log(inputFile);
                  // console.log(num);

                  // inputFile : 현재 변화가 생긴 input type="file" 요소 객체
                  // num : 몇번째 input 요소인지 확인 후 
                  //       해당 그 영역에 미리보기 하기 위한 자리값을 나타냄

                  // console.log(inputFile.files.length);
                  // 파일 선택 시 1, 파일 선택 취소 시 0 이 나옴
                  // => 즉, 파일의 존재 유무를 알 수 있다.
                  // files 속성은 업로드된 파일들의 정보를
                  // 배열과 같은 형식으로 여러개 묶어서 반환
                  // files.length 는 배열의 크기를 나타냄

                  if(inputFile.files.length == 1) {
                      // 현재 선택된 파일이 있을 경우
                      // 선택된 파일을 읽어들여서 그 영역에 맞는 곳에 미리보기

                      // 파일을 읽어들일 FileReader 객체 생성
                      let reader = new FileReader();

                      // FileReader 객체에서 제공하는 파일을 읽어들이는 메소드 호출
                      // readAsDataURL(읽어들일파일);
                      // => 해당 파일을 읽어들이는 순간 파일에 고유한 url 주소를 부여해줌
                      reader.readAsDataURL(inputFile.files[0]);

                      // 파일 읽기가 완료되었을 때 (url 주소가 부여된 후)
                      // 실행할 함수를 정의
                      reader.onload = function(e) {

                          // e 의 target.result 에 각 파일의 url 이 담김
                          // e.target == this == reader

                          // 각 영역에 맞춰서 미리보기
                          switch(num) {
                              case 1 : $("#titleImg").attr("src", e.target.result); break;
                              case 2 : $("#contentImg1").attr("src", e.target.result); break;
                              case 3 : $("#contentImg2").attr("src", e.target.result); break;
                              case 4 : $("#contentImg3").attr("src", e.target.result); break;
                          }
                      };

                  } else {
                      // 선택된 파일이 사라졌을 경우
                      // 미리보기 사라지게 하기
                      switch(num) {
                          case 1 : $("#titleImg").attr("src", null); break;
                          case 2 : $("#contentImg1").attr("src", null); break;
                          case 3 : $("#contentImg2").attr("src", null); break;
                          case 4 : $("#contentImg3").attr("src", null); break;
                      }
                  }
              }
          </script>

          <div align="center">
              <button type="submit" class="btn btn-secondary btn-sm">
                  등록하기
              </button>
              <br><br>
          </div>

      </form>

  </div>

    </section><!-- End Services Section -->

    <section id="get-started" class="get-started section-bg" style="background-color: white; padding-left: 50px;">
      
    </section>

  </main><!-- End #main -->


  <!-- 푸터 인클루드-->
  <%@ include file="../common/boardFooter.jsp" %>

</body>

</html>