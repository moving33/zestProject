<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link href="css/common/myPage.css" rel="stylesheet">
</head>
<body>

	<div id="wrap">
		<!-- header -->
		<div id="header_subn">


			<div class="gnb">
				<div class="leftmenu">
					<ul>

						<li><a href="#"> <span>튜터등록</span>
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
									style="background-image: url('//taling.me/Content/Uploads/Profile/339ed0e1d12129252e9b7a0df29088ddda7583c4.jpg')">
								</div>
								<div class="right">
									<div class="right01">${client.cl_name}</div>
									<div class="right02">
										<a href="#"> <span>정보수정</span>
										</a>
										<div class="right03">
											<a href="#"> <span>튜터 정보수정</span>
											</a>
										</div>
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
									<div class="middle lgsize">등록된 이메일</div>
									<div class="middle lgsize">학교 정보</div>
									
								</div>								
								
								<div class="right">
									<div class="lgsize">
									<c:if test="${client.cl_hp == 'none'}">미인증
									<a href="#"><span>번호 등록</span></a>
									</c:if>
										<c:if test="${client.cl_hp != 'none'}">client.cl_hp
										<a href="#"><span>번호 수정</span></a>
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
	</div>
	<!-- 컨테이너 -->
	<div id="container_my">
		<br> <br> <br>
		<div class="box">
			<div class="cont01">
				<div class="box">
					<a href="#">
						<div class="tabon font">수강생 (0)</div>
					</a> <a href="#">
						<div class="tab font">튜터 (0)</div>
					</a>
				</div>
			</div>
			<div class="cont04">
				<div class="topmenu">
					<ul>
						<li class="on"><a href="#">수업신청서<span>(0)</span></a></li>
						<li><a href="#">수강목록</a></li>
						<li><a href="#">위시리스트</a></li>
					</ul>
				</div>
			</div>
			<div class="cont12">
				<ul>
					<li>수강 중인 재능이 없습니다</li>
				</ul>
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
						target="_blank"><img
						src="images/common/ic_sns_instagram_38_38.png"></a> <a href="#"
						target="_blank"><img
						src="images/common/ic_sns_youtube_38_38.png"></a>
				</div>

			</div>
		</div>
	</div>
</body>
</html>