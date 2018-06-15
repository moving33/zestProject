<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<!DOCTYPE html>
<html lang="en">

<head>

<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<!-- 타이틀 -->
<title>Zest</title>

<!-- 부트스트랩 CSS -->
<link href="css/bootstrap.css" rel="stylesheet">
<!-- 부트스트랩 슬라이더 CSS -->
<link href="css/half-slider.css" rel="stylesheet">
<!--  main css -->
<link href="css/main/mainPage.css" rel="stylesheet">
</head>

<body>




	<!-- Navigation -->
	<nav class="navbar navbar-expand-lg navbar-dark bgj-dark fixed-top">
		<div class="container">
			<a class="navbar-brand" href="/zest/main"> <img alt="Logo"
				src="images/logo2.png">
			</a>
			<!-- 검색창 -->
			<form class="flyout-search" action="#" name="search">
				<div class="searchdiv" style="border: 2px solid #ff7200">
					<div class="inputlmg" style="padding-top: 3px;">
						<img src="images/돋보기.png" onclick='#' style="margin-left: 5px;">
						<!-- 검색 텍스트 -->
						<input type="text" name="search"
							placeholder="배우고 싶은 수업 또는 튜터를 검색해보세요!" onclick="#" value=""
							style="border-color: #ffffff00; width: 330px; outline: none; padding-top: 1px;">
					</div>
				</div>
			</form>
			<!-- 토글 -->
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarResponsive" aria-controls="navbarResponsive"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="loginCheck">
				<!-- 최상위 메뉴 -->
				<ul class="navbar-nav ml-auto">
					<li class="nav-item activej"><a class="nav-linkj logo"
						id="service" href="#"> <b>서비스소개</b> <span class="sr-only">(current)</span>
					</a></li>
					<li class="nav-item"><a class="nav-linkj" id="insert" href="#"
						style="font-size: 20px;"><b>튜터 등록</b></a></li>


					<li class="nav-item"><a class="nav-linkj" id="regi" href="#"
						style="font-size: 20px;"><b>회원 가입</b></a></li>
					<li class="nav-item"><a class="nav-linkj" id="login" href="#"
						style="font-size: 20px;"><b>로그인</b></a></li>
				</ul>
			</div>
		</div>
	</nav>

	<!-- 헤더 -->
	<!-- 배너 -->
	<header>
		<div id="carouselExampleIndicators" class="carousel slide"
			data-ride="carousel">
			<ol class="carousel-indicators">
				<li data-target="#carouselExampleIndicators" data-slide-to="0"
					class="active"></li>
				<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
				<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
			</ol>
			<div class="carousel-inner" role="listbox">
				<!-- Slide One -->
				<div class="carousel-item active"
					style="background-image: url('images/main/baner3.png'); cursor: pointer;"
					onclick="location.href='#'"></div>
				<!-- Slide Two -->
				<div class="carousel-item"
					style="background-image: url('images/main/baner2.png'); cursor: pointer;"
					onclick="location.href='#'"></div>
				<!-- Slide Three -->
				<div class="carousel-item"
					style="background-image: url('images/main/baner3.png'); cursor: pointer;"
					onclick="location.href='#'"></div>
			</div>
			<a class="carousel-control-prev" href="#carouselExampleIndicators"
				role="button" data-slide="prev"> <span
				class="carousel-control-prev-icon" aria-hidden="true"></span> <span
				class="sr-only">Previous</span>
			</a> <a class="carousel-control-next" href="#carouselExampleIndicators"
				role="button" data-slide="next"> <span
				class="carousel-control-next-icon" aria-hidden="true"></span> <span
				class="sr-only">Next</span>
			</a>
		</div>
	</header>
	<br>

	<!-- 메뉴바 -->
	<div class="container" align="center">
		<div class="row" style="background-color: #f0f0f0; min-height: 50px;">
			<div id="hot" class="colj" onmouseover="#" style="cursor:pointer">
				<a id="hot" href="#" style="color: #000000;"><b>인기수업</b></a>
			</div>
			<div id="sports" class="colj" onmouseover="fetchPage('main/sports')" style="cursor:pointer" onclick="location.href='/zest/category/sports'">
				<a id="sports" href="/zest/category/sports" style="color: #000000;"><b>스포츠</b></a>
			</div>
			<div id="beauty" class="colj" onmouseover="fetchPage('main/beauty')" style="cursor:pointer" onclick="location.href='/zest/category/beauty'">
				<a id="beauty" href="/zest/category/beauty" style="color: #000000;"><b>뷰티</b></a>
			</div>
			<div id="music" class="colj" onmouseover="fetchPage('main/music')" style="cursor:pointer" onclick="location.href='/zest/category/music'">
				<a id="music" href="/zest/category/music" style="color: #000000;"><b>음악</b></a>
			</div>
			<div id="food" class="colj" onmouseover="fetchPage('main/food')" style="cursor:pointer" onclick="location.href='/zest/category/food'">
				<a id="food" href="/zest/category/food" style="color: #000000;"><b>요리/음식</b></a>
			</div>
			<div id="design" class="colj" onmouseover="fetchPage('main/design')" style="cursor:pointer" onclick="location.href='/zest/category/design'">
				<a id="design" href="/zest/category/design" style="color: #000000;"><b>디자인</b></a>
			</div>
			<div id="business" class="colj"
				onmouseover="fetchPage('main/business')" style="cursor:pointer" onclick="location.href='/zest/category/business'">
				<a id="business" href="/zest/category/business" style="color: #000000;"><b>실무</b></a>
			</div>
			<div id="language" class="colj"
				onmouseover="fetchPage('main/language')" style="cursor:pointer" onclick="location.href='/zest/category/language'">
				<a id="language" href="/zest/category/language" style="color: #000000;"><b>외국어</b></a>
			</div>
			<div id="progam" class="colj" onmouseover="fetchPage('main/program')" style="cursor:pointer" onclick="location.href='/zest/category/program'">
				<a id="progam" href="/zest/category/program" style="color: #000000;"><b>프로그래밍</b></a>
			</div>
			<div id="life" class="colj" onmouseover="fetchPage('main/life')" style="cursor:pointer" onclick="location.href='/zest/category/life'">
				<a id="life" href="/zest/category/life" style="color: #000000;"><b>라이프스타일</b></a>
			</div>
		</div>
	</div>

	<!-- 카테고리 -->
	<section class="py-5">
		<div class="container">
			<div class="row">
				<!-- 카테고리 사이드바  -->
				<div class="col-lg-3 class_cont">
					<h3 class="my-4">카테고리</h3>
					<div class="list-group"
						style="border: 1px solid black; height: 400px; position: relative;">
						<div class="list-group1" style="position: absolute; width: 125px;"></div>
						<div class="list-group2"
							style="position: absolute; right: 6px; width: 125px;"></div>
					</div>
				</div>
				<!--  추천 수업 -->
				<div class="col-lg-9 class_cont">
					<h3 class="my-4">추천수업</h3>
					<div style="border: 1px solid black; height: 400px">
						<!-- 1순위 항목 -->
						<a>
							<div class="main_cont">1순위 내용</div>
						</a>
						<!-- 나머지 항목들 -->
						<div class="sub_cont">
							<a>
								<div class="sub"></div>
							</a> <a>
								<div class="sub"></div>
							</a> <a>
								<div class="sub"></div>
							</a>
						</div>
					</div>
				</div>
			</div>
		</div>

		<!-- 광고 -->
		<div class="ad">
			<img src="images/main/광고.png">
		</div>

		<!-- 인기 원데이 -->
		<div class="container oneday">
			<div class="oneday_head">
				<b style="font-size: x-large;">인기원데이</b> &nbsp;&nbsp;&nbsp; 깔끔하게 딱하루
			</div>

			<div id="onedayIndicators" class="carousel slide"
				style="height: 430px" data-ride="carousel">
				<!-- 화살표 파지네이션 -->
				<ol class="carousel-indicators">
					<li data-target="#onedayIndicators" data-slide-to="0"
						class="active"></li>
					<li data-target="#onedayIndicators" data-slide-to="1"></li>
					<li data-target="#onedayIndicators" data-slide-to="2"></li>
				</ol>

				<!-- 슬라이드 내용 -->
				<div class="carousel-inner">
					<div class="carousel-item active">
						<div class="oneday_cont" style="margin-left: 28px;">
							<div class="image"></div>
						</div>
						<div class="oneday_cont">
							<div class="image"></div>
						</div>
						<div class="oneday_cont">
							<div class="image"></div>
						</div>
					</div>
					<div class="carousel-item">
						<div class="oneday_cont" style="margin-left: 28px;">
							<div class="image"></div>
						</div>
						<div class="oneday_cont">
							<div class="image"></div>
						</div>
						<div class="oneday_cont">
							<div class="image"></div>
						</div>
					</div>
					<div class="carousel-item">
						<div class="oneday_cont" style="margin-left: 28px;">
							<div class="image"></div>
						</div>
						<div class="oneday_cont">
							<div class="image"></div>
						</div>
						<div class="oneday_cont">
							<div class="image"></div>
						</div>
					</div>
				</div>

				<a class="carousel-control-prev" href="#onedayIndicators"
					role="button" data-slide="prev"> <span
					class="carousel-control-prev-icon" aria-hidden="true"></span> <span
					class="sr-only">Previous</span>
				</a> <a class="carousel-control-next" href="#onedayIndicators"
					role="button" data-slide="next"> <span
					class="carousel-control-next-icon" aria-hidden="true"></span> <span
					class="sr-only">Next</span>
				</a>
			</div>
		</div>
	</section>

	<!-- 따끈따끈 리뷰 -->
	<div class="container oneday">
		<div class="oneday_head">
			<b style="font-size: x-large;">따끈따끈 리뷰</b> &nbsp;&nbsp;&nbsp; 검증된 수업을
			들어보세요
		</div>

		<div id="onedayIndicators" class="carousel slide"
			style="height: 430px" data-ride="carousel">
			<!-- 화살표 파지네이션 -->
			<ol class="carousel-indicators">
				<li data-target="#onedayIndicators" data-slide-to="0" class="active"></li>
				<li data-target="#onedayIndicators" data-slide-to="1"></li>
				<li data-target="#onedayIndicators" data-slide-to="2"></li>
			</ol>

			<!-- 슬라이드 내용 -->
			<div class="carousel-inner">
				<div class="carousel-item active">
					<div class="oneday_cont" style="margin-left: 28px;">
						<div class="image"></div>
					</div>
					<div class="oneday_cont">
						<div class="image"></div>
					</div>
					<div class="oneday_cont">
						<div class="image"></div>
					</div>
				</div>
				<div class="carousel-item">
					<div class="oneday_cont" style="margin-left: 28px;">
						<div class="image"></div>
					</div>
					<div class="oneday_cont">
						<div class="image"></div>
					</div>
					<div class="oneday_cont">
						<div class="image"></div>
					</div>
				</div>
				<div class="carousel-item">
					<div class="oneday_cont" style="margin-left: 28px;">
						<div class="image"></div>
					</div>
					<div class="oneday_cont">
						<div class="image"></div>
					</div>
					<div class="oneday_cont">
						<div class="image"></div>
					</div>
				</div>
			</div>

			<a class="carousel-control-prev" href="#onedayIndicators"
				role="button" data-slide="prev"> <span
				class="carousel-control-prev-icon" aria-hidden="true"></span> <span
				class="sr-only">Previous</span>
			</a> <a class="carousel-control-next" href="#onedayIndicators"
				role="button" data-slide="next"> <span
				class="carousel-control-next-icon" aria-hidden="true"></span> <span
				class="sr-only">Next</span>
			</a>
		</div>
	</div>
	</section>
	<br>
	<br>
	<br>

	<!-- Footer
	<footer class="py-5 bg-dark">
		<div class="container">
			<p class="m-0 text-center">Copyright &copy; Your Website 2018</p>
		</div>
		/.container
	</footer> -->

	<!-- footer -->
	<div class="footer">
		<div class="footer_cont">
			<div class="info_box">
				<div class="info">
					<b>COMPANY</b>
					<ul>
						<li><a href="#">서비스 소개</a></li>
						<li><a href="#" target="_blank">블로그</a></li>
						<li><a href="#" target="_blank">언론보도</a></li>
					</ul>
				</div>
				<div class="info">
					<b>POLICIES</b>
					<ul>
						<li><a href="#">이용약관</a></li>
						<li><a href="#">결제서비스약관</a></li>
						<li><a href="#">개인정보취급방침</a></li>
					</ul>
				</div>
				<div class="info">
					<b>SUPPORT</b>
					<ul>
						<li><a href="#">FAQ</a></li>
						<li><a href="#">드루와센터</a></li>
					</ul>
				</div>
			</div>
			<div class="info_box2">
				<div class="info">
					<b>드루와</b>
					<ul>
						<li><img src="images/yellow.png">&nbsp;KAKAO 옐로우ID /
							@Droowa</li>
						<li>운영시간 / 평일 10:00~19:00</li>
					</ul>
				</div>
			</div>
			<div style="overflow: hidden; padding-top: 79px">
				<div class="bt_info">
					상호 : (주)드루와 | 주소 : 서울시 성동구 무학로2길 54 신방빌딩 4,5층 | 사업자등록번호 :
					123-45-67890 |대표자명 : ZEST<br> Copyright ⓒ2018 droowa inc, ltd.
					All rights reserved
				</div>
				<div class="logo_box">
					<a href="#" target="_blank"><img
						src="images/ic_sns_facebook_38_38.png"></a> <a href="#"
						target="_blank"><img src="images/ic_sns_instagram_38_38.png"></a>
					<a href="#" target="_blank"><img
						src="images/ic_sns_youtube_38_38.png"></a>
				</div>

			</div>
		</div>
	</div>
	<!-- /footer -->

	<!-- Bootstrap core JavaScript -->
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.bundle.min.js"></script>
	<script src="js/main/mainPage.js"></script>
	<script src="js/common.js"></script>
	<%-- <c:if test="${ login == 'success' }">
		<script>
		// 로그인시 창바꾸기 마이페이지와 로그아웃이 생김 (j)
			var html = "<ul class='navbar-nav ml-auto'>" +
			"<li class='nav-item activej'>"+
			"<a class='nav-linkj logo'id='service' href='#'><b>서비스소개</b>" +
			"<span class='sr-only'>(current)</span></a></li>" +
			"<li class='nav-item'>"+
			"<a class='nav-linkj' id='insert' href='#' style='font-size: 20px;'><b>튜터 등록</b></a></li>" +
			"<li class='nav-item'>"+
			"<a class='nav-linkj' id='myPage' href='clientPage' style='font-size: 20px;'><b>마이페이지</b></a></li>" +
			"<li class='nav-item'>"+
			"<a class='nav-linkj' id='logout' href='main/logout' style='font-size: 20px;'>"+			
			"<b>로그아웃</b></a></li>" +
			"</ul>";
	$("#navbarResponsive").html(html);
		</script>
	</c:if> --%>
</body>

</html>