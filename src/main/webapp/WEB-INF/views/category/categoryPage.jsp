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

	<!--  category css -->
	<link href="css/category/categoryPage.css" rel="stylesheet">
	
</head>

<body>

	<!-- Navigation -->
	<nav class="navbar navbar-expand-lg navbar-dark bgj-dark fixedj-top">
		<div class="container">
			<a class="navbar-brand" href="/zest/main"> <img alt="Logo" src="images/logo2.png">
			</a>
			<!-- 검색창 -->
			<form class="flyout-search" action="#" name="search">
				<div class="searchdiv" style="border: 2px solid #ff7200">
					<div class="inputlmg">
						<img src="images/돋보기.png" onclick='#' style="margin-left: 5px;">
						<!-- 검색 텍스트 -->
						<input type="text" name="search" placeholder="배우고 싶은 수업 또는 튜터를 검색해보세요!" onclick="#"
							value="" style="border-color: #ffffff00; width: 330px; outline: none; padding-top: 3px;">
					</div>
				</div>
			</form>
			<!-- 토글 -->
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarResponsive" aria-controls="navbarResponsive"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<!-- 최상위 메뉴 -->
				<ul class="navbar-nav ml-auto">
					<li class="nav-item activej"><a class="nav-linkj logo" id="service" href="#">
						<b>서비스소개</b> 
					<span class="sr-only">(current)</span>
					</a></li>
					<li class="nav-item"><a class="nav-linkj" id="insert" href="#" style="font-size: 20px;"><b>튜터 등록</b></a></li>
					<li class="nav-item"><a class="nav-linkj" id="regi" href="#" style="font-size: 20px;"><b>회원 가입</b></a></li>
					<li class="nav-item"><a class="nav-linkj" id="login" href="#" style="font-size: 20px;"><b>로그인</b></a></li>
				</ul>
			</div>
		</div>
	</nav><br>


	<!-- 메뉴바 -->
	<div class="container" align="center">
		<div class="row">
			<div id="hot" class="colj" onmouseover="#">인기수업</div>
			<div id="sports" class="colj" data-toggle="tab" onmouseover="getCategory('main/sports')">스포츠</div>
			<div id="beauty" class="colj" onmouseover="getCategory('main/beauty')">뷰티</div>
			<div id="music" class="colj" onmouseover="getCategory('main/music')">음악</div>
			<div id="food" class="colj" onmouseover="getCategory('main/food')">요리/음식</div>
			<div id="design" class="colj" onmouseover="getCategory('main/design')">디자인</div>
			<div id="business" class="colj" onmouseover="getCategory('main/business')">실무</div>
			<div id="language" class="colj" onmouseover="getCategory('main/language')">외국어</div>
			<div id="progam" class="colj" onmouseover="getCategory('main/program')">프로그래밍</div>
			<div id="life" class="colj" onmouseover="getCategory('main/life')">라이프스타일</div>
		</div>
	</div>
	
	<!-- 카테고리 -->
	<div class="container" align="center" >
		<div class="row subCate" style="background-color: #ffffff;">
		</div>
	</div><hr><br>
	
	 <!-- 페이지 컨텐츠 -->
    <div class="container">
    
      <!-- 페이지 헤딩 -->
      <div class="row">
        <div class="col-lg-4 col-sm-6 portfolio-item">
          <div class="card h-100">
            <a href="#"><img class="card-img-top" src="http://placehold.it/700x400" alt=""></a>
            <div class="card-body">
              <h4 class="card-title">
                <a href="#">Project One</a>
              </h4>
              <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Amet numquam aspernatur eum quasi sapiente nesciunt? Voluptatibus sit, repellat sequi itaque deserunt, dolores in, nesciunt, illum tempora ex quae? Nihil, dolorem!</p>
            </div>
          </div>
        </div>
        <div class="col-lg-4 col-sm-6 portfolio-item">
          <div class="card h-100">
            <a href="#"><img class="card-img-top" src="http://placehold.it/700x400" alt=""></a>
            <div class="card-body">
              <h4 class="card-title">
                <a href="#">Project Two</a>
              </h4>
              <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam viverra euismod odio, gravida pellentesque urna varius vitae.</p>
            </div>
          </div>
        </div>
        <div class="col-lg-4 col-sm-6 portfolio-item">
          <div class="card h-100">
            <a href="#"><img class="card-img-top" src="http://placehold.it/700x400" alt=""></a>
            <div class="card-body">
              <h4 class="card-title">
                <a href="#">Project Three</a>
              </h4>
              <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quos quisquam, error quod sed cumque, odio distinctio velit nostrum temporibus necessitatibus et facere atque iure perspiciatis mollitia recusandae vero vel quam!</p>
            </div>
          </div>
        </div>
        <div class="col-lg-4 col-sm-6 portfolio-item">
          <div class="card h-100">
            <a href="#"><img class="card-img-top" src="http://placehold.it/700x400" alt=""></a>
            <div class="card-body">
              <h4 class="card-title">
                <a href="#">Project Four</a>
              </h4>
              <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam viverra euismod odio, gravida pellentesque urna varius vitae.</p>
            </div>
          </div>
        </div>
        <div class="col-lg-4 col-sm-6 portfolio-item">
          <div class="card h-100">
            <a href="#"><img class="card-img-top" src="http://placehold.it/700x400" alt=""></a>
            <div class="card-body">
              <h4 class="card-title">
                <a href="#">Project Five</a>
              </h4>
              <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam viverra euismod odio, gravida pellentesque urna varius vitae.</p>
            </div>
          </div>
        </div>
        <div class="col-lg-4 col-sm-6 portfolio-item">
          <div class="card h-100">
            <a href="#"><img class="card-img-top" src="http://placehold.it/700x400" alt=""></a>
            <div class="card-body">
              <h4 class="card-title">
                <a href="#">Project Six</a>
              </h4>
              <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Itaque earum nostrum suscipit ducimus nihil provident, perferendis rem illo, voluptate atque, sit eius in voluptates, nemo repellat fugiat excepturi! Nemo, esse.</p>
            </div>
          </div>
        </div>
      </div><br>
     
      <!-- /.row -->

      <!-- 페이징 처리 -->
      <ul class="pagination justify-content-center">
        <li class="page-item">
          <a class="page-link" href="#" aria-label="Previous">
            <span aria-hidden="true">&laquo;</span>
            <span class="sr-only">Previous</span>
          </a>
        </li>
        <li class="page-item">
          <a class="page-link" href="#">1</a>
        </li>
        <li class="page-item">
          <a class="page-link" href="#">2</a>
        </li>
        <li class="page-item">
          <a class="page-link" href="#">3</a>
        </li>
        <li class="page-item">
          <a class="page-link" href="#" aria-label="Next">
            <span aria-hidden="true">&raquo;</span>
            <span class="sr-only">Next</span>
          </a>
        </li>
      </ul>

    </div>
    <!-- /.container -->

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
						<li><img src="images/yellow.png">&nbsp;KAKAO 옐로우ID / @Droowa</li>
						<li>운영시간 / 평일 10:00~19:00</li>
					</ul>
				</div>
			</div>
			<div style="overflow: hidden; padding-top: 79px">
				<div class="bt_info">
					상호 : (주)드루와 | 주소 : 서울시 성동구 무학로2길 54 신방빌딩 4,5층 | 사업자등록번호 :
					123-45-67890 |대표자명 :오재식<br> Copyright ⓒ2018 droowa inc, ltd.
					All rights reserved
				</div>
				<div class="logo_box">
					<a href="#" target="_blank"><img
						src="images/ic_sns_facebook_38_38.png"></a> <a href="#" target="_blank"><img
						src="images/ic_sns_instagram_38_38.png"></a> <a href="#"
						target="_blank"><img src="images/ic_sns_youtube_38_38.png"></a>
				</div>

			</div>
		</div>
	</div>
	<!-- /footer -->


	<!-- Bootstrap core JavaScript -->
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.bundle.min.js"></script>
	<script src="js/category/categoryPage.js"></script>
	<c:if test="${ login == 'success' }">
		<script>
		// 로그인시 창바꾸기 마이페이지와 로그아웃이 생김 (j)
			alert("로그인  중입니다.");		
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
	</c:if>

</body>

</html>