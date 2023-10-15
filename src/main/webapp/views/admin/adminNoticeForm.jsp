<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>공지사항작성</title>
        <style>
   
    .content_detail tr, .content_detail td {
      border : 1px dotted black;
    }

    #services tr, #services td {

    border-bottom : 1px solid black;
    border-top: 1px solid black;
    padding-top: 5px;
    padding-bottom: 5px;
    }
    
    #content_table>tbody>tr:hover {
        background-color: lightgray;
        cursor : pointer;
    }

   
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


        </style>
    </head>
    <body class="sb-nav-fixed">
        
        <%@ include file="../common/adminHeader.jsp" %>
           
            <div id="layoutSidenav_content">

                <section id="services" class="section-bg">
                    
                    <div class="container" data-aos="fade-up">
              
                      <div class="outer">
              
                        <div style="height: 40px;"></div>
                        <h1>공지사항 등록</h1>
                        <div style="height: 40px;"></div>

                  
                        <table align="center" style="width : 700px;">
                          <tr>
                            <td style="text-align: center;"><b>제목</b></td>
                            <td><input type="text" name="" id="" style="width : 100%; background-color: #f5f6f7;"></td>
                          </tr>
                          <tr style="height: 500px;">
                            <td style="text-align: center;"><b>내용</b></td>
                            <td>
                              <textarea name="content" 
                                              style="resize : none; width : 100%; height: 700px; background-color: #f5f6f7;" 
                                              required></textarea>
                            </td>
                          </tr>
                          <tr>
                            <td colspan="2">
                              <button>+</button>
                            </td>
                          </tr>
                        </table>
                      <br><br>
              
                      <div align="center">
                        <button type="submit" class="btn btn-secondary btn-sm">등록하기</button>
                        <button type="reset" class="btn btn-warning btn-sm"
                                onclick="history.back();">뒤로가기</button>
                        <!-- history.back() : 이전 페이지로 돌아가게 해주는 함수-->
                      </div>
                    
                    </div>
                  </div>
              
                    </div>
                  </section>
                </div>
                <script>
                  $(function() {
                    
                    $(".list-area>tbody>tr").click(function() {
                      // console.log("잘 클릭 됐나?");
                      
                      // 클릭했을 때 자손요소 탐색
                      // 해당 게시글의 공지사항 번호를 추출해서 넘겨야 함
                      // => 해당 tr 요소의 자손 중에서 첫번째 td 영역의 내용이 필요
                      let nno = $(this).children().eq(0).text();
                      
                      // console.log(nno);
                      
                      // 요청할url 주소?키=밸류&키=밸류&..
                      // ? 뒤의 내용들을 "쿼리스트링" 이라고 한다.
                      // get 방식의 경우 쿼리스트링이 노출되는 방식임!!
                      // location.href 속성으로 요청하면 get 방식임!!
                      // => 대놓고 쿼리스트링을 직접 입력하는 방식 
                      
                      // /jsp/detail.no?nno=클릭했을때의글번호
                    location.href = "<%= contextPath %>/detail.no?nno=" + nno;
                      
                    });
                  });
                  
                  
                </script>
                </div>
            </div>
        </div>
        <%@ include file="../common/adminFooter.jsp" %>
    </body>
</html>
