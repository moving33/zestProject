<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
    
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">


<!-- 부트스트랩 CSS -->
<link href="/zest/css/bootstrap.css" rel="stylesheet">
<!-- classDetail css -->
<link href="/zest/css/category/classDetail.css" rel="stylesheet">

<title>수업상세 페이지</title>
</head>
<body>
<!-- 헤더 -->
<div id="header_subn">
	<div class="gnb">
		<div class="leftmenu">
			<ul>			
				<li><a href=""><span>소개</span></a></li>
				<li><a href=""><span>튜터등록</span></a></li>
				<li><a href=""><span>수업검색</span></a></li>
			</ul>
		</div>
		<div class="logo"><a href="/zest/main"><img src="/zest/images/logo2.png" alt="Logo"/></a></div>
            <div class="rightmenu">
            	<ul>
            		<li style="width:180px;"></li>
					<li>
						<a href="#" id="regi" onmousemove="join01.src='/zest/images/join2.png'" onmouseout="join01.src='/zest/images/join1.png'">
						<span><img src="/zest/images/join1.png" name="join01"/></span><span>회원가입</span></a>
					</li>
					<li>
						<a href="#" id="login" onmousemove="join02.src='/zest/images/login2.png'" onmouseout="join02.src='/zest/images/login1.png'">
						<span><img src="/zest/images/login1.png" name="join02"/></span><span>로그인</span></a>
					</li>
            		
            	</ul>
            </div>	
	</div>
</div>
<!-- //헤더 -->


<!-- CONTAINER -->
<div id="container_detail">
	<div class="class_wrap">
		<!-- 수업결제 정보 -->
		<div class="class_price" id ="class_price" style="position:relative;">
			<div class="area_info">
				<div class="area" id="area"><h1>위치</h1>	</div>
				<div class="date" id="date"><h1>요일</h1></div>
				<div class="time" id="time"><h1>날짜<br>시간</h1></div>
				<div class="add" id="add"><h1>장소<br>추가비용 : ${detail.tc_price_detail}</h1></div>
				<div class="tutor_t">
				<dl class="tutor_txt">
					<dt><div class="tutorPro"><img id="tt_img1" src="${pro0 }"></div></dt>
					<dd>${detail.tc_tt_message}<dd>
					
				</dl>
				</div>
				<div class="btn_payment">수업 신청하기</div>
				<div class="price">
					<div class="hp1"><b>￦${talent.talent_price_hour }</b>/시간</div>
					<div class="tp1">￦${talent.talent_total_price } / 총 ${talent.talent_meet_count }회 8시간</div>
				</div>
				<div class="btn_area">
					<a class="btn_qna" onclick="#"><img src="/zest/images/classDetail/icon_btn_qna.png"> 실시간 톡하기</a>
					<a class="btn_wish" onclick="#"><img src="/zest/images/classDetail/icon_btn_wish.png"> 찜하기</a>
				</div>
			</div>
		</div>
		
		
		<!-- 상단이미지 -->
		<div class="class_img">
		
			<div id="carouselExampleIndicators" class="carousel slide my-4" data-ride="carousel">
			<ol class="carousel-indicators">
              <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
              <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
              <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
            </ol>
           
            <div class="carousel-inner" role="listbox">
              <c:forEach var="images" items="${imgPath}" varStatus="status">
              <c:choose>
              <c:when test="${status.index == 0}">
              <div class="carousel-item active">	
                <img class="d-block img-fluid" src="${images}" alt="First slide">
              </div>
              </c:when>
              <c:otherwise>
              <div class="carousel-item">
                <img class="d-block img-fluid" src="${images}" alt="Second slide">
              </div>
              </c:otherwise>
              </c:choose>
             </c:forEach>
            </div>
            
            <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
              <span class="carousel-control-prev-icon" aria-hidden="true"></span>
              <span class="sr-only">Previous</span>
            </a>
            <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
              <span class="carousel-control-next-icon" aria-hidden="true"></span>
              <span class="sr-only">Next</span>
            </a>
		</div>
		</div>
		<div class="class_d_wrqp">
		
		<!-- 상세단락 네비 -->
			<div id="class_navi"class="class_navi">
				<ul>
					<li><a href="#sumary" class="" id="sli">요약</a></li>
					<li><a href="#tutorinfo" class="" id="tli">튜터</a></li>
					<li><a href="#Introduction" class="" id="ili">수업소개</a></li>
					<li><a href="#review" class="" id="rli">리뷰</a></li>
					<li><a href="#qna" class="" id="qli">지도</a></li>
				</ul>
			</div>
			
		<!-- 수업요약 -->
			<div class="class_detail" id="sumary">
				<div class="class_name">
					<div class="tutor_img"><img id="tt_img2" src="${pro0}"></div>

					<div class="name">${tutor.tt_name }</div>
					<div class="nickname">${tutor.tt_nn }</div>
				</div>
				<div class="class_title">
				<div class="title">${detail.tc_subject}</div>
				<div class="info">별점부분</div>
				<div class="info">
					<ul>
						<li class="ar"><div class="icon1"><img src="/zest/images/classDetail/icon_info01.png"></div>강남</li>							
						<li class="hu"><div class="icon2"><img src="/zest/images/classDetail/icon_info02.png"></div><font color="#ff005a">2</font>시간/회</li>
						<li class="gr"><div class="icon3"><img src="/zest/images/classDetail/icon_info03.png"></div>최대인원:<font color="#ff005a">${detail.tc_max_client}</font>명</li>
						<li class="ohu"><div class="icon4"><img src="/zest/images/classDetail/icon_info04.png"></div><font color="#ff005a">￦20,000</font>/시간</li>
					</ul>
				</div>
				</div>
			</div>
			
			<!-- 튜터 소개 -->
			<div class="tutor_in" id="tutorinfo">
			<h1>튜터정보</h1>
			<div class="intro1">${detail.tc_tt_info}</div>
			</div>
			
			<!-- 수업소개 -->
			<div class="class_in" id="Introduction">
			<h1>수업소개</h1>
			<div class="intro2">${detail.tc_class_info}</div>
			</div>
			
			<!-- 수업대상 -->
			<div class="target_in">
			<h1>수업대상</h1>
			<div class="intro6">${detail.tc_class_taget} </div>
			</div>
			
			<!-- 커리큘럽 -->
			<div class="curri_in">
			<h1>커리큘럼</h1>
			<c:forEach items="${cur}" var="cur" varStatus="status">
			<div class="intro3"><br><p style="font-size: 18px; color:red;"><c:out value="${status.count}회차"/><p>${cur}</div><br>
			
			</c:forEach>
			
			</div> 
			  
			<!-- 리뷰 -->
			<div class="review_in" id="review">
			<form action="/zest/reviewPage/3" id="review1" name="review1" method="post">
			<h1>리뷰 <button type="submit"class="btn_st" id="btn-write-revice">리뷰쓰기</button></h1>
			</form>
			<div class="intro4"></div>
			</div>
			
			<!-- 지도 -->
			<div class="map_in" id="qna">
			<h1>위치</h1>
			<div class="intro5"></div>
			</div>
			
			
			
		</div>	
	</div>
	
		

</div>

	<!-- Bootstrap core JavaScript -->
	<script src="/zest/js/jquery.min.js"></script>
	<script src="/zest/js/bootstrap.bundle.min.js"></script>
	<script src="/zest/js/category/classDetail.js"></script>
	<script src="/zest/js/main/mainPage.js"></script>

</body>
</html>