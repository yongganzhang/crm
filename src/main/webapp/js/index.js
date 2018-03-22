
function  userLogin () {

    var url =ctx + "/user/userLogin";
    // 用户姓名
    var userName =  $("#userName").val();
    // 用户密码
    var userPwd =  $("#userPwd").val();

    if (!isEmpty(userName)) {
        alert("用户名不能为空!");
        return;
    }
    if (!isEmpty(userPwd)) {
        alert("密码不能为空!");
        return;
    }

    var params = {}
    params.userName = userName;
    params.userPwd = userPwd;

    // ajax提交
    $.ajax({
        type: "POST",
        url: url,
        data:params ,
        dataType : "json",
        success: function(data){
            if (data.code == 200) {
                window.location.href = "main/index";
            }else {
                alert(data.msg);
            }
        }
    });
}