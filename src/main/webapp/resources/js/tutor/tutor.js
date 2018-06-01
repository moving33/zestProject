$(document).ready(function () {
    var pageType = $("#confirmType").val();
    var tutorCheck = $("#tutorCheck").val();
    //페이지타입이 튜터 페이지 이면
	if( tutorCheck == 'fail'){
		alert("튜터 신청을 하신후에 서비스를 이용하실 수 있습니다.");		
	}    
    
    if(pageType == 'tutor'){
        //#t1,#c1은 페이지를 구분해주는 div
        $("#t1").removeClass("tab");
        $("#t1").addClass("tabon");
        $("#c1").removeClass("tabon");
        $("#c1").addClass("tab");
    }

});