// 세션
$(document).ready(function(){
   var sessionURL = "/session";
   var list = $('#loginCheck');
   var listHtml = '';
   
   alert("스크립트 세션 틀어왔다");
   
   fetch("/zest/session",{      
      
      method : 'POST',
      //
      credentials: "same-origin"
      }).then(function(response) {
         if (!response.ok) {
            throw Error(response.statusText);
         }
         return response.json();
      }).then((data) => {
         if(data == 1){
            alert(data);
            alert("로그인 성공");
            var listHtml = "<ul class='navbar-nav ml-auto'>" +
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
            list.html(listHtml);
         }
      }).catch((e) => {
         console.log(e);
      });
});