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

//튜터 등록 페이지 보여주기
function viewRegiTalentPage(){
	var myHeaders = new Headers();
	myHeaders.append("Content-Type",
			"application/json;Charset=UTF-8");	
	fetch('/zest/tutorPage/regiTalent', {
		method : 'GET',
		credentials : 'same-origin',
		headers : myHeaders
	}).then(function(response) {
		if (!response.ok) {
			throw Error(response.statusText);
		}
		// 텍스트 기반으로 처리
		return response.text();
	}).then(function(text) {
		alert(text)
		//실패시
		if(text == 'fail'){
			alert('튜터 등록이 되어있지 않은 사용자 입니다.');
			return;
		//성공시
		}else{
			//css 변경
			$("#talentRegi").css("display","block");
			$("#tutorPropDiv").css("display","none");		
			$("#li1").attr("class",'');
			$("#li2").attr("class",'on');
			
		}
		
	});
}//튜터 신척확인 보여주기 
function viewPropTalentPage(){
	$("#talentRegi").css("display","none");
	$("#tutorPropDiv").css("display","block");		
	$("#li2").attr("class",'');
	$("#li1").attr("class",'on');
}