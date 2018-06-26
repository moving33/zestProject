<%--
  Created by IntelliJ IDEA.
  User: J
  Date: 2018-05-31
  Time: 오후 9:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<meta name="viewport" content="width=device-width, initial-scale = 1.0" />
<html>
<head>
<title>$Title$</title>

<!-- 세션 검사 -->

<link href="/zest/css/admin/zest_admin.css" rel="stylesheet">
<link href="/zest/css/bootstrap.css" rel="stylesheet">

</head>
<body class="fix-header fix-sidebar">
	<%--전체--%>
	<div id="main-wrapper">
		<%--Header header--%>
		<div class="header">
			<div class="header is_J"
				style="position: fixed; top: 0px; width: 1500px;">
				<nav class="navbar top-navbar navbar-expend-md navbar-light">
					<%--Logo--%>
					<div class="navbar-header">
						<%--헤더로고 넣기--%>
						<a></a>
					</div>
					<%--로그 오른쪽부분 --%>
					<div class="navbar-collapse" style="font-size: 18px;">
						관리자 <b style="color: #ff7200;">${admin.name}</b>님 환영합니다.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="/zest/admin/logout" style="float: right;">로그아웃</a>
					</div>
				</nav>
			</div>
		</div>
		<div
			style="position: relative; width: 1663px; height: 60px; display: block; vertical-align: baseline; float: none;"></div>

		<%--leftsidebar navigation--%>
		<div class="left-sidebar">
			<div class="slimScrollDiv"
				style="position: relative; overflow: hidden; width: auto; height: 100%; margin-top: 100px">
				<div class="scroll-sidebar"
					style="overflow: hidden; width: auto; height: 100%;">
					<%--sidebar nav--%>
					<nav class="sidebar-nav">
						<ul>
							<li class="nav-devider"></li>
							<li class="nav-label"><a href="/zest/admin/main">ADMIN
									PAGE</a></li>
						</ul>
						<li><a href="#tutorManger" aria-expanded="true"
							aria-controls="tutorManger" data-toggle="collapse"> <span
								class="">TutorManager</span>
						</a>
							<ul class="collapse" id="tutorManger">
								<li><a href="/zest/admin/tutorManager/prop">튜터 신청 관리</a></li>
								<li><a href="#">Blank</a></li>
								<li><a href="#">Blank</a></li>
							</ul></li>
						<li></li>
					</nav>
				</div>
			</div>
		</div>
		<%--end left sidebar--%>
		<div class="page-wrapper" style="min-height: 824px;">
			<%--low title--%>
			<div class="row page-titles" style="margin: 0">
				<div class="col-md-5 align-self-center">
					<%--타이틀이 들어가는 영역--%>
					<h3 class="text-primary">TITLE</h3>
				</div>
			</div>


			<%--content가 들어가는영역!--%>
			<div class="container-fluid" style="background-color: white;">
				<div class="row">
					<%--최대로 맞춤--%>
					<div class="col-12">
						<div class="card-body">
							<%--소제목위치--%>
							<h4 class="card-title">소제목 위치</h4>
							<%--요약설명--%>
							<h6 class="card-subtitle">해당 소제목의 상세설명</h6>
						</div>

						<%--실제 data가 들어감--%>
						<div class="m-t-40">실제 데이터가 들어가는 영역</div>
					</div>
				</div>
				<!-- end row -->
			</div>
			<!--  end content -->
			<!-- end 전체 영역 -->
		</div>
		<script src="/zest/js/jquery.min.js"></script>
		<script src="/zest/js/bootstrap.bundle.min.js"></script>
		<script src="/zest/js/popper.js"></script>
</body>
</html>
