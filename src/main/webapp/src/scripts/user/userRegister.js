/**
 * Created by mgh on 2017/5/7.
 */
function checkPhone(phone){
    var flag = false;
    if(phone == ""){
        layer.msg("您输入的手机号码有误，请重新输入");
    }else if(isPhone(phone)){
        layer.msg("您输入的手机号码有误，请重新输入")
    }else{
        flag = true;
        $.ajax({
            url:"/Platform/user/checkUser_phone",
            type:'post',
            data:{
                user_phone:phone
            },
            success:function(data){
                var result = eval(data);
                if(!result.success){
                    layer.msg("手机号码已被注册！");
                }else{
                    layer.msg("手机号码未注册！");
                }
            },
            error:function(){
                alert("请求中断！");
            }
        });
    }
    return flag;
}

function checkpassword(password,passwordAgain){
    //必须为字母加数字且长度不小于8位
    var flag = false;
    var str = password;
    var reg1 = new RegExp(/^[0-9A-Za-z]+$/);
    var reg = new RegExp(/[A-Za-z].*[0-9]|[0-9].*[A-Za-z]/);
    if (str == null) {
        layer.msg("密码不能为空!");
        flag = false;
    }else if(str.length<6){
        layer.msg("密码长度不能小于6位")
    }else if (!reg1.test(str)) {
        layer.msg("密码必须包含字母")
        flag = false;
    }else if (!reg.test(str)) {
        layer.msg("密码必须包含数字字母");
        flag = false;
    } else if(password !== passwordAgain){
        layer.msg("密码前后不一致,请重新输入!");
        flag = false;
    }else{
        flag = true;
    }
    return flag;
}

function checkUserName(userName){
    var flag = false;
    if(userName ===""){
        layer.msg("用户名不能为空!");
        flag = false;
    }else {
        flag = true;
    }
}
function checkCodeNumber(phone){
    var flag = false;
    $(".code-btn").click(function(){
        if(checkPhone(phone)){
            $.ajax({
                url:'/Platform/user/sendCode',
                type:'post',
                data:{
                    user_phone:phone
                },
                success:function(data){
                    var result = eval(data);
                    if(result.success){
                        if(checkCode(success.code)){
                            flag = true;
                        }else {
                            flag = false;
                        }
                    }else{
                        layer.msg("验证码发送失败!");
                    }
                }
            });
        }

    });
    return flag;
}
function checkCode(code){
    $(".user-code").blur(function(){
        var codetext = $(this).val();
        if(codetext ===""){
            layer.msg("验证码不能为空!");
            return false;
        }else if(codetext !== code){
            layer.msg("验证码不正确,请重新输入验证码!");
            return false;
        }else{
            return true;
        }
    });

}

//点击注册按钮
$(function(){
    $(".user-btn-login").click(function(){
        var phone = $(".user-phone").val();
        var password = $(".user-pwd").val();
        var passwordAgain = $(".user-pwd-again").val();
        var userName = $(".user-name").val();
        var date = {
            user_phone:phone,
            user_pwd:password,
            user_name:userName,
        }
        if(checkPhone(phone) && checkpassword(password,passwordAgain) && checkUserName(userName) && checkCodeNumber()){
            $.ajax({
                url:"/Platform/user/userRegister",
                type:'post',
                data:JSON.stringify(date),
                async:false,
                success:function(data){
                    var result = eval(data);
                    if(result.success){
                        location.href = "/Platform/pages/user/userLogin.html";
                    }else{
                        layer.msg("用户注册失败!");
                    }
                },
                error:function(){
                    layer.msg("请求中断!");
                }
            });
        }
    });

});