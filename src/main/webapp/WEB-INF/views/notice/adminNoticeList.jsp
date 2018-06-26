<%@ page contentType="text/html;charset=UTF-8" language="java"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<meta name="viewport" content="width=device-width, initial-scale = 1.0" />
<html>
<head>
<title>$Title$</title>

<link rel="stylesheet" href="/zest/css/style.css" type="text/css">
<link href="/zest/css/admin/zest_admin.css" rel="stylesheet">
<link href="/zest/css/bootstrap.css" rel="stylesheet">

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
						관리자 <b style="color: #ff7200;">${admin.name}</b>님 환영합니다.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="logout" style="float: right;">로그아웃</a>
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
							<li class="nav-label"><a href="/zest/admin/main">ADMIN PAGE</a></li>
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
						<li>
							<a href="/zest/admin/notice/noticeList"> <span
								class="">공지사항</span>
							</a>
						</li>
						<li>
							<a href="#statistics" aria-expanded="true"
								aria-controls="statistics" data-toggle="collapse">
							 	<span class="">통계</span>
							</a>
							<ul class="collapse" id="statistics">
								<li><a href="/zest/admin/statistics">카테고리별 누적 인원 수</a></li>
								<li><a href="/zest/admin/statisticsCate">카테고리별 활동 수</a></li>
								<li><a href="#">Blank</a></li>
							</ul>
						</li>
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
					<h3 class="text-primary" style="color:#000000 !important;">공지사항</h3>
				</div>
			</div>

			<%--content가 들어가는영역!--%>
			<div class="container-fluid" style="background-color: white;">
				<div class="row">
					<%--최대로 맞춤--%>
					<div class="col-12">
						<div class="card-body">
							<%--소제목위치--%>
						</div>
						<button class="btn btn-success"type="button" id="btnWrite" onclick="location.href='/zest/notice/write'">글쓰기</button>
						<%--실제 data가 들어감--%>
						<div class="m-t-40">
							<table data-text-content="true" class="table table-bordered"
								style="width: 100%;">
								<tbody>
									<tr style="text-align: center">
										<th style="width: 10%;">제목</th>
										<th style="width: 10%;">날짜</th>
										<th style="width: 10%;">조회수</th>
										<th style="width: 10%;">기타</th>
									</tr>
									<c:forEach var="list" items="${list}"
										varStatus="status">
									
									<form action="/zest/notice/update">
										<tr style="text-align: center">
											<td><a id="notice_no" name="notice_no" href="/zest/notice/detail?notice_no=${list.notice_no}">${list.notice_title}</a></td>
											<td><fmt:formatDate value="${list.notice_date}"  pattern="yyyy-MM-dd HH:mm:ss" /></td>
											<td>${list.notice_count}</td>
											<td>
												<input onclick="updateNotice(this.form.tno)"class="btn btn-warning" type="button" value="수정">
												<input onclick="deleteNotice(this.form.tno)"class="btn btn-dark" type="button" value="삭제">
											</td>
											<input name="tno" id="tno" type="hidden" value="${list.notice_no}"/>
										</tr>
									</form>
									</c:forEach>
								</tbody>
							</table><br>

							<%--페이징처리--%>
							<div>
								<div class="row" style="padding-left: 22%;">
									<div class="col-8">
										<div class="pagePro"
											style="text-align: center; margin: auto; display: table;">
											<%-- pagination 사용 --%>
											<ul class="pagination">

												<%--이전버튼 --%>
												<c:if test="${bp.isPre()}">
													<li class="page-item">
														<button class="page-link">
															<a
																href="/zest/admin/notice/noticeList?pageNum=${bp.getPage_Start()-bp.p_size}">
																Previous </a>
														</button>
													</li>
												</c:if>

												<%--페이징처리 --%>

												<c:forEach var="counter" begin="${bp.getPage_start()}"
													end="${bp.getPage_end()}">
													<c:if test="${search_text ne ''}">
														<li class="page-item">
															<button class="page-link"
																onclick="window.location='/zest/admin/notice/noticeList?pageNum=${counter}&search_type=${search_type}&search_text=${search_text}'">
																${counter}</button>
														</li>
													</c:if>

													<c:if test="${search_text eq ''}">
														<li class="page-item">
															<button class="page-link"
																onclick="window.location='/zest/admin/notice/noticeList?pageNum=${counter}&search_type=${search_type}&search_text=${search_text}'">
																${counter}</button>
														</li>
													</c:if>
												</c:forEach>


												<%--다음버튼 --%>
												<c:if test="${bp.isNext()}">
													<li class="page-item">
														<button class="page-link">
															<a
																href="/zest/admin/notice/noticeList?pageNum=${bp.getPage_Start()+bp.p_size}">
																Next </a>
														</button>
													</li>
												</c:if>
											</ul>
										</div>
									</div>
								</div>
							</div>
							<!-- end Paging -->

						</div>
					</div>
					<!-- end 테이블 정보 div -->

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
</body>
</html>
