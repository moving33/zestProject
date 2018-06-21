<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link href="css/common/myPage.css" rel="stylesheet">
<link href="css/bootstrap.css" rel="stylesheet">
</head>
<body>

	<div id="wrap">
		<!-- header -->
		<div id="header_subn">


			<div class="gnb">
				<div class="leftmenu">
					<ul>

						<li><a href="tutorRegiPage"> <span>튜터등록</span>
						</a></li>
						<li><a href="#"> <span>수업검색</span>
						</a></li>
					</ul>
				</div>
				<div class="logo">
					<a href="main"><img src="images/logo.png" alt="제스트"></a>
				</div>
				<div class="rightmenu">
					<ul>
						<li><a href="#"> <span> <img
									src="images/common/icon_ttalk.png"><br>
							</span> <span>실시간톡</span>
						</a></li>
						<li><a href="#"> <span> <img
									src="images/common/icon_tlist.png">
							</span> <span>수업신청서</span>
						</a>
						<li><a href="#"> <span> <img
									src="images/common/icon_sjoin.png">
							</span> <span>마이페이지</span>
						</a></li>
						<li><a href="#"> <span> <img
									src="images/common/icon_slogout.png">
							</span> <span>로그아웃</span>
						</a></li>
					</ul>
				</div>
				<!-- 마이메뉴 -->
				<div class="submy">
					<div class="area">
						<div class="sec01">
							<div class="box">
								<div class="left"
									style="background-image: url(/${client.cl_im_path})">
								</div>
								<div class="right">
									<div class="right01">${client.cl_name} 님</div>
									<div class="right02">${client.cl_nn} </div>
										<div class="right03">
											<a href="clientModifyPage"> <span>정보수정</span></a>
											<a href="#"> <span>튜터 정보수정</span>
											</a>
										</div>
								</div>
							</div>
						</div>

						<div class="sec02">
							<div class="box">
								<div class="box1">
									<img src="images/common/icon_my_menu01.png">
									<div class="middle">받은수업신청서</div>
									<div class="bottom">0건</div>
								</div>

								<div class="box2">
									<img src="images/common/icon_my_menu02.png">
									<div class="middle">신청한수업</div>
									<div class="bottom">0건</div>

								</div>
								<div class="box3">
									<img src="images/common/icon_my_menu03.png">
									<div class="middle">위시리스트</div>
									<div class="bottom">0건</div>
								</div>

							</div>
						</div>
						<div class="sec03">
							<div class="box">
								<div class="left">
									<div class="lgsize">핸드폰 번호</div>
									<div class="middle lgsize" style="font-size: 15px">등록된 이메일</div>
									<div class="middle lgsize">학교 정보</div>

								</div>

								<div class="right">
									<div class="lgsize">
										<c:if test="${client.cl_hp == 'none'}">미인증
                                        <a href="#"><span>번호
													등록</span></a>
										</c:if>
										<c:if test="${client.cl_hp != 'none'}">${client.cl_hp}
										</c:if>
									</div>
									<div class="middle lgsize">${client.cl_email}</div>
									<div class="middle lgsize">인증여부</div>

								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- 컨테이너 -->
	<%--수강생페이지인지 튜터 페이지 인지 확인--%>
	<input id="confirmType" value="${pageType}" type="hidden">
	<!-- 튜터 신청 내역이 있는지 없는지 확인 -->
	<input id="tutorCheck" value="${tutorData}" type="hidden">
	${tutorData}
	<div id="container_my">
		<br> <br> <br>
		<div class="box">
			<div class="cont01">
				<div class="box">
					<a href="/zest/clientPage">
						<div class="tabon font" id="c1">수강생 (0)</div>
					</a> <a href="/zest/tutorPage">
						<div class="tab font" id="t1">튜터 (0)</div>
					</a>
				</div>
			</div>
			<div class="cont04">
				<%--튜터와 수강생 구분 페이지처리--%>
				<div class="topmenu">
					<c:if test="${pageType == null}">
						<ul>
							<li class="on"><a href="#">수업신청서<span>(0)</span></a></li>
							<li><a href="#">수강목록</a></li>
							<li><a href="#">위시리스트</a></li>
						</ul>
					</c:if>

					<c:if test="${pageType == 'tutor'}">
						<ul>
							<li class="on"><a href="#">튜터신청확인</a></li>
							<li><a href="#">...</a></li>
							<li><a href="#">...</a></li>
						</ul>
					</c:if>


				</div>
			</div>
			<div class="cont12">
				<c:if test="${pageType == 'tutor'}">
					<!-- 승인된 사용자 -->
					<c:if test="${tt_prop.tp_message eq null and tt_prop.tp_status != 0}">
						<div class="alert alert-primary" role="alert"
							style="width: 80%; margin: auto;">
							축하드립니다, 튜터로 선정되셨습니다. 자유롭게 자신의 재능을 나누어주세요! <br>
							<span style="font-size: large;"><b> ${client.cl_name} </b></span>님 께서 수업신청시 채택가능성이 높은 분야는 
								<span style="font-size: large;"><b> ${tt_prop.tp_category_id} </b></span>항목 입니다.
						</div>
					</c:if>
					<!--  대기중인 사용자  -->
					<c:if test="${ tt_prop.tp_status eq 0}">
						<div class="alert alert-primary" role="alert"
							style="width: 80%; margin: auto;">
							<span style="font-size: large;"><b> ${client.cl_name} </b></span>
							님 께서 신청하신 항목을 검토 중에 있습니다, 신청하신 날짜 1~2일 안에 처리 될 예정입니다. 
						</div>
					</c:if>
					<!--  거부 처리된 사용자  -->
					<c:if test="${ tt_prop.tp_status eq 1 and tt_prop.tp_message eq 0}">
						<div class="alert alert-danger" role="alert"
							style="width: 80%; margin: auto;">
							<span style="font-size: large;"><b> ${client.cl_name} </b></span>
							님 의 튜터 신청 처리가  
							<span style="font-size: large; color:black;"><b> 신분증 인증 항목과 프로필 사진 인증 </b></span>
							이  양식에 맞지 않아 취소 되었습니다 .						
						</div>
					</c:if>
						<c:if test="${ tt_prop.tp_status eq 1 and tt_prop.tp_message eq 1}">
						<div class="alert alert-danger" role="alert"
							style="width: 80%; margin: auto;">
							<span style="font-size: large;"><b> ${client.cl_name} </b></span>
							님 의 튜터 신청 처리가  
							<span style="font-size: large; color:black;"><b> 프로필 사진 </b></span>
							이  양식에 맞지 않아 취소 되었습니다 .						
						</div>
					</c:if>
						<c:if test="${ tt_prop.tp_status eq 1 and tt_prop.tp_message eq 2}">
						<div class="alert alert-danger" role="alert"
							style="width: 80%; margin: auto;">
							<span style="font-size: large;"><b> ${client.cl_name} </b></span>
							님 의 튜터 신청 처리가  
							<span style="font-size: large; color:black;"><b> 신분증 인증 항목 </b></span>
							이  양식에 맞지 않아 취소 되었습니다 .						
						</div>
					</c:if>
					<ul>
						<li>&nbsp;</li>
					</ul>
				</c:if>
			</div>
		</div>
		<br> <br> <br>


	</div>
	<!-- /컨테이너 -->
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
						<li><img src="images/common/yellow.png">&nbsp;KAKAO
							옐로우ID / @Droowa</li>
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
						src="images/common/ic_sns_facebook_38_38.png"></a> <a href="#"
						target="_blank"> <img
						src="images/common/ic_sns_instagram_38_38.png"></a> <a href="#"
						target="_blank"><img
						src="images/common/ic_sns_youtube_38_38.png"></a>
				</div>

			</div>
		</div>
	</div>
	<script src="/zest/js/jquery.min.js"></script>
	<script src="/zest/js/tutor/tutor.js"></script>
	<script src="/zest/js/bootstrap.bundle.min.js"></script>
</body>
</html>