window.onload=function () {

    var login_bottom=document.querySelector("#login_1")
    $("#login_1").click(function(){

    });
    setTimeout(1000);
    $.ajax({
        url: "/admin/login",
        method: "GET",
        // data:{username:"wzf",password:"123456"},
        error: function (xhr, status, error) {
            console.log(status);
        },
        success: function (result, status, xhr) {//xhr   xmlHttpRequest
            console.log(result);
            //操作DOM渲染页面
            if (result.statusCode=="100") {
                console.log("登陆成功");
                $("#register_button").css("visibility","visible");
            }
            // else {
            //     $("#display").text("恭喜").toggleClass("text-success");
            // }


        },
    });




}