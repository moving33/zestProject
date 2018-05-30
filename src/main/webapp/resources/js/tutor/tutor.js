$(document).ready(function () {
    alert($("#confirmType").val());
    var pageType = $("#confirmType").val();
    //페이지타입이 튜터 페이지 이면
    if(pageType == 'tutor'){
        //#t1,#c1은 페이지를 구분해주는 div
        $("#t1").removeClass("tab");
        $("#t1").addClass("tabon");
        $("#c1").removeClass("tabon");
        $("#c1").addClass("tab");
    }

});