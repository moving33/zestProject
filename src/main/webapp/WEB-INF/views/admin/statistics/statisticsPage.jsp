<%@ page contentType="text/html;charset=UTF-8" language="java"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<meta name="viewport" content="width=device-width, initial-scale = 1.0" />
<html>
<head>
<title>$Title$</title>


<link href="/zest/css/admin/zest_admin.css" rel="stylesheet">
<link href="/zest/css/bootstrap.css" rel="stylesheet">

<!-- 차트 -->
<link rel="stylesheet" href="/zest/css/style.css" type="text/css">
<script src="/zest/js/chart/amcharts.js" type="text/javascript"></script>
<script src="/zest/js/chart/pie.js" type="text/javascript"></script>


<!-- 차트 끝 -->

</head>
<body class="fix-header fix-sidebar" style="font-size:18px;">
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
						관리자 <b style="color: #ff7200;">${admin.name}</b>님
						환영합니다.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href="logout"
							style="float: right;">로그아웃</a>
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
						<li><a href="/zest/admin/notice/noticeList"> <span
								class="">공지사항</span>
						</a></li>
						<li><a href="#statistics" aria-expanded="true"
							aria-controls="statistics" data-toggle="collapse"> <span
								class="">통계</span>
						</a>
							<ul class="collapse" id="statistics">
								<li><a href="/zest/admin/statistics">카테고리별 누적 인원 수</a></li>
								<li><a href="/zest/admin/statisticsCate">카테고리별 활동 수</a></li>
								<li><a href="#">Blank</a></li>
							</ul></li>
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
					<h3 class="text-primary" style="color:#000000 !important;">통계</h3>
				</div>
			</div>
			<br>

			<div>
				<h5>카테고리별 누적 인원 수</h5>
				<br>
				<!-- 차트 -->
				<div id="chartdiv" style="width: 800px; height: 500px; float: left;"></div>
				<!-- 차트 끝 -->
				<div style="float: left; width: 300px;">
					<table class="table">
						<tr>
							<td>카테고리</td>
							<td>누적 인원 수</td>
						</tr>
						<tr>
							<td>뷰티</td>
							<td>
								<p id="td0">${model.count0}</p>
							</td>
						</tr>
						<tr>
							<td>실무</td>
							<td>
								<p id="td1">${model.count1}</p>
							</td>
						</tr>
						<tr>
							<td>디자인</td>
							<td>
								<p id="td2">${model.count2}</p>
							</td>
						</tr>
						<tr>
							<td>요리/음식</td>
							<td>
								<p id="td3">${model.count3}</p>
							</td>
						</tr>
						<tr>
							<td>외국어</td>
							<td>
								<p id="td4">${model.count4}</p>
							</td>
						</tr>
						<tr>
							<td>라이프스타일</td>
							<td>
								<p id="td5">${model.count5}</p>
							</td>
						</tr>
						<tr>
							<td>뮤직</td>
							<td>
								<p id="td6">${model.count6}</p>
							</td>
						</tr>
						<tr>
							<td>프로그래밍</td>
							<td>
								<p id="td7">${model.count7}</p>
							</td>
						</tr>
						<tr>
							<td>스포츠</td>
							<td>
								<p id="td8">${model.count8}</p>
							</td>
						</tr>
						<tr>
							<td>총</td>
							<td>${model.sum } 명</td>
						</tr>
					</table>
				</div>
			</div>

		</div>
	</div>


	<script src="/zest/js/jquery.min.js"></script>
	<script src="/zest/js/bootstrap.bundle.min.js"></script>
	<script src="/zest/js/popper.js"></script>
	<script src="/zest/js/admin/tutorPropPage.js"></script>

	<script>
				function deleteNotice(tno){
					alert("삭제");
					var tno = $('#tno').val();
					 alert(tno);
					location.href = "/zest/notice/delete?notice_no="+tno;
				}
				
				function updateNotice(tno){
					alert("수정");
					var tno = $('#tno').val();
					 alert(tno);
					location.href = "/zest/admin/notice/modify?notice_no="+tno;
				}
		</script>
	<script>
		
		
		
	var chart;

	var chartData = [ {
		"country" : "뷰티",
		"visits" : $("#td0").html()
	}, {
		"country" : "실무",
		"visits" : $("#td1").html()
	}, {
		"country" : "디자인",
		"visits" : $("#td2").html()
	}, {
		"country" : "요리/음식",
		"visits" : $("#td3").html()
	}, {
		"country" : "외국어",
		"visits" : $("#td4").html()
	}, {
		"country" : "라이프스타일",
		"visits" : $("#td5").html()
	}, {
		"country" : "뮤직",
		"visits" : $("#td6").html()
	}, {
		"country" : "프로그래밍",
		"visits" : $("#td7").html()
	}, {
		"country" : "스포츠",
		"visits" : $("#td8").html()
	} ];

	AmCharts
			.ready(function() {
				// PIE CHART
				chart = new AmCharts.AmPieChart();

				// title of the chart
				chart.addTitle("Visitors countries", 16);

				chart.dataProvider = chartData;
				chart.titleField = "country";
				chart.valueField = "visits";
				chart.sequencedAnimation = true;
				chart.startEffect = "elastic";
				chart.innerRadius = "30%";
				chart.startDuration = 2;
				chart.labelRadius = 15;
				chart.balloonText = "[[title]]<br><span style='font-size:14px'><b>[[value]]</b> ([[percents]]%)</span>";
				// the following two lines makes the chart 3D
				chart.depth3D = 10;
				chart.angle = 15;

				// WRITE
				chart.write("chartdiv");
			});
</script>
</body>
</html>
