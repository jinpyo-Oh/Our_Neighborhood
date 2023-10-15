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
        <title>공지사항조회</title>
        <style>
                .outer {
      border : 1px solid black;
    }
    .content_detail tr, .content_detail td {
      border : 1px dotted black;
    }

    #services tr, #services td {

    border-bottom : 1px solid orange;
    border-top: 1px solid orange;
    padding-top: 5px;
    padding-bottom: 5px;
    }
    
    #content_table>tbody>tr:hover {
        background-color: lightgray;
        cursor : pointer;
    }
        </style>
    </head>
    <body class="sb-nav-fixed">
        <%@ include file="../common/adminHeader.jsp" %>
           
            <div id="layoutSidenav_content">

            <section id="services" class="section-bg">
                <div class="container" data-aos="fade-up">
                    <div style="height: 40px;"></div>
                    <h1>공지사항</h1>
                    <div style="height: 40px;"></div>
                  <fieldset>
                    <div style="margin-left: 100px;">

                        
                        <br><br>

                    </div>
                      <div class="container">
                        <div class="row justify-content-between gy-4">
                          <div data-aos="fade-up" style="margin:auto">
                            <div class="content">
                              <table style="margin : auto; text-align: center;" id="content_table">
                                <thead>
                                  <tr>
                                      <th width="30"></th>
                                      <th width="400">글제목</th>
                                      <th width="200">작성자</th>
                                      <th width="200">조회수</th>
                                      <th width="200">작성일</th>
                                  </tr>
                                </thead>
                                <tbody>
                                  <tr>
                                    <td style="text-align: center;"><input type="checkbox"></td>
                                    <td>관리사무소에서 안내말씀 드립니다.</td>
                                    <td>관리자</td>
                                    <td>150</td>
                                    <td>2023-12-23</td>
                                  </tr>
                                  <tr>
                                    <td style="text-align: center;"><input type="checkbox"></td>
                                    <td>관리사무소에서 안내말씀 드립니다.</td>
                                    <td>관리자</td>
                                    <td>150</td>
                                    <td>2023-12-23</td>
                                  </tr><tr>
                                    <td style="text-align: center;"><input type="checkbox"></td>
                                    <td>관리사무소에서 안내말씀 드립니다.</td>
                                    <td>관리자</td>
                                    <td>150</td>
                                    <td>2023-12-23</td>
                                  </tr><tr>
                                    <td style="text-align: center;"><input type="checkbox"></td>
                                    <td>관리사무소에서 안내말씀 드립니다.</td>
                                    <td>관리자</td>
                                    <td>150</td>
                                    <td>2023-12-23</td>
                                  </tr><tr>
                                    <td style="text-align: center;"><input type="checkbox"></td>
                                    <td>관리사무소에서 안내말씀 드립니다.</td>
                                    <td>관리자</td>
                                    <td>150</td>
                                    <td>2023-12-23</td>
                                  </tr><tr>
                                    <td style="text-align: center;"><input type="checkbox"></td>
                                    <td>관리사무소에서 안내말씀 드립니다.</td>
                                    <td>관리자</td>
                                    <td>150</td>
                                    <td>2023-12-23</td>
                                  </tr><tr>
                                    <td style="text-align: center;"><input type="checkbox"></td>
                                    <td>관리사무소에서 안내말씀 드립니다.</td>
                                    <td>관리자</td>
                                    <td>150</td>
                                    <td>2023-12-23</td>
                                  </tr><tr>
                                    <td style="text-align: center;"><input type="checkbox"></td>
                                    <td>관리사무소에서 안내말씀 드립니다.</td>
                                    <td>관리자</td>
                                    <td>150</td>
                                    <td>2023-12-23</td>
                                  </tr><tr>
                                    <td style="text-align: center;"><input type="checkbox"></td>
                                    <td>관리사무소에서 안내말씀 드립니다.</td>
                                    <td>관리자</td>
                                    <td>150</td>
                                    <td>2023-12-23</td>
                                  </tr><tr>
                                    <td style="text-align: center;"><input type="checkbox"></td>
                                    <td>관리사무소에서 안내말씀 드립니다.</td>
                                    <td>관리자</td>
                                    <td>150</td>
                                    <td>2023-12-23</td>
                                  </tr><tr>
                                    <td style="text-align: center;"><input type="checkbox"></td>
                                    <td>관리사무소에서 안내말씀 드립니다.</td>
                                    <td>관리자</td>
                                    <td>150</td>
                                    <td>2023-12-23</td>
                                  </tr><tr>
                                    <td style="text-align: center;"><input type="checkbox"></td>
                                    <td>관리사무소에서 안내말씀 드립니다.</td>
                                    <td>관리자</td>
                                    <td>150</td>
                                    <td>2023-12-23</td>
                                  </tr>
                              </tbody>
                              </table>

                              <br>
                              <a class="btn btn-dangerous" href="" style="margin-left: 90%; color: black; background-color: red; stroke: red;" >삭제</a>

                            </div>
                        </div>
                      </div>
                    
                  </fieldset>
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
