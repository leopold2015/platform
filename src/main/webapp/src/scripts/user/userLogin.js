/**
 * Created by mgh on 2017/5/6.
 */
$(function(){

    var password = $.trim($(".user-pwd").val());
    //blur事件判断手机号码
    $(".user-phone").blur(function(){
        var phone = $.trim($(".user-phone").val());
        checkPhone(phone)
    });

});

function checkPhone(phone){
    var flag = false;
    if(phone == ""){
        layer.msg("您输入的手机号码有误，请重新输入");
    }else if(!isPhone(phone)){
        layer.msg("您输入的手机号码有误，请重新输入")
    }else{
        flag = tru;
        $.ajax({
            url:"",
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

function login(phone,password){
    if(checkPhone(phone) && checkPassword(password)){

    }

}

function checkPassword(password) {
    var flag = false;
    if (password == null) {
        layer.msg("请您输入密码！");
    } else if (!(password >=6 && password<=10)){
        layer.msg("您输入的密码格式不正确，请重新输入！");
    } else{
        flag = true;
    }
    return flag;
}

function isPhone(phone){
    if(!(/^1[34578]\d{9}$/.test(phone))){
        return false;
    }
}

