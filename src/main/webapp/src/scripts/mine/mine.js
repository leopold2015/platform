/**
 * Created by mgh on 2017/5/14.
 */
$(function () {
    $.ajax({
        url: '/Platform/user/showUserByUser_id',
        type: 'post',
        async: false,
        success: function (data) {
            var result = eval(data);
            if (result.success) {
                var contentTemplate2 = Handlebars.compile($('#content-template2').html());
                Handlebars.registerHelper("transformat", function (value) {
                    if (value == 1) {
                        return "普通党员";
                    } else if (value == 2) {
                        return "管理员";
                    }
                });
                $('.userInfo').html(contentTemplate2(result.user));

                //显示电话号码
                var contentTemplate1 = Handlebars.compile($('#content-template1').html());
                $(".tel").html(contentTemplate1(result.user));
            }
        }
    });
});