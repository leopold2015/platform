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