/**
 * Created by mgh on 2017/5/7.
 */
//定义全局变量，存储服务器传过来的验证码
var codeNumber;

function checkPhone(phone){
    var flag = false;
    if(phone === ""){
        layer.msg("您输入的手机号码有误，请重新输入");
    }else if(!isPhone(phone)){
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
                }
            },
            error:function(){
                layer.msg("请求中断！");
            }
        });
    }
    return flag;
}

function checkpassword(password){
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
        flag = false;
    }else if (!reg1.test(str)) {
        layer.msg("密码必须包含字母")
        flag = false;
    }else if (!reg.test(str)) {
        layer.msg("密码必须包含数字字母");
        flag = false;
    } else{
        flag = true;
    }
    return flag;
}

function checkpasswordAgain(password,passwordAgain){
    if(password === passwordAgain){
        return true;
    }else{
        layer.msg("前后密码不一致，请重新输入！");
        return false;
    }
}

function checkUserName(userName){
    var flag = false;
    if(userName ===""){
        layer.msg("用户名不能为空!");
        flag = false;
    }else {
        flag = true;
    }
    return flag;
}

//点击获取验证码
function getCode(){

    $(".code-btn").click(function(){
        var phone = $(".user-phone").val();
        if(phone !="" && isPhone(phone)){
            $.ajax({
                url:'/Platform/user/sendCode',
                type:'post',
                async:false,
                data:{
                    user_phone:phone
                },
                success:function(data){
                    var result = eval(data);
                    if(result.success){
                        codeNumber = result.code;

                    }else{
                        layer.msg("验证码发送失败!");
                    }
                }
            });
        }else{
            layer.msg("请输入正确的手机号码！");
        }
    });
}
/*function checkCodeNumber(phone){
    var flag = false;
    layer.msg("请点击按钮获取验证码！");
    return flag;
}*/
function checkCodeNumber(){
    var flag = false;
    if(codeNumber == ""){
        layer.msg("请点击按钮获取验证码！");
        flag = false;
    }else{
        var codetext = $(".user-code").val();
        if(codetext == undefined){
            layer.msg("验证码不能为空!");
            flag = false;
        }else if(codetext != codeNumber){
            layer.msg("验证码不正确,请重新输入验证码!");
            flag = false;
        }else{
            flag = true;
        }
    }
    return flag;
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
        if(checkPhone(phone) && checkpassword(password) && checkpasswordAgain(password,passwordAgain) && checkUserName(userName) && checkCodeNumber(phone)){
            $.ajax({
                url:"/Platform/user/userRegister/"+phone+"/"+password+"/"+userName,
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

    $(".user-phone").blur(function(){
        checkPhone($.trim($(this).val()));
    });

    $(".user-pwd").blur(function(){
        var password = $.trim($(this).val());
        checkpassword(password);
    });

    $(".user-pwd-again").blur(function(){
        var passwordPwdAgain = $.trim($(this).val());
        var password = $.trim($(".user-pwd").val());
        checkpasswordAgain(password,passwordPwdAgain);
    });
    $(".user-name").blur(function(){
        var userName = $(this).val();
        checkUserName(userName);
    });

    $(".user-code").blur(function(){
        var phone = $(".user-phone").val();
        if(phone == ""){
            layer.msg("请输入手机号码！");
        }else{
            checkCodeNumber(phone);
        }
    });

    //点击获取验证码
    getCode();

});

function isPhone(phone){
    if(!(/^1[34578]\d{9}$/.test(phone))){
        return false;
    }else {
        return true;
    }
}