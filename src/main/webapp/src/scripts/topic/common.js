/**
 * Created by mgh on 2017/5/14.
 */
$(function(){
    //请求话题标题

        $.ajax({
            asysc: false,
            url:'/Platform/topic/showTopicByTopic_id',
            type:'post',
            success:function(data){
                var result = eval(data);
                if(result.success){
                    var Template = Handlebars.compile($('#content-template-topic-title').html());
                    $('.header').html(Template(result));
                    backToIndex();
                    //获取对话内容
                    $.ajax({
                        url:'/Platform/communicate/selectCommunicateByTopic_id',
                        type:'post',
                        asysc: false,
                        success:function(data){
                            var result = eval(data);
                            if(result.success){
                                var contentTemplate = Handlebars.compile($('#content-template').html());

                                Handlebars.registerHelper("compare",function(v1,options){
                                    var id = $(".header").find(".content-title").attr("user_id");
                                    if(v1!=id){
                                        //满足添加继续执行
                                        return options.fn(this);
                                    }else{
                                        //不满足条件执行{{else}}部分
                                        return options.inverse(this);
                                    }
                                });

                                $('.main').html(contentTemplate(result));
                            }
                        }
                    });
                }
            }
        });



    //获取对话内容
   /* function aaa() {
        $.ajax({
            url: '/Platform/communicate/selectCommunicateByTopic_id',
            type: 'post',
            asysc: false,
            success: function (data) {
                var result = eval(data);
                if (result.success) {
                    var contentTemplate = Handlebars.compile($('#content-template').html());

                    Handlebars.registerHelper("compare", function (v1, options) {
                        var id = $(".header").find(".content-title").attr("user_id");
                        if (v1 != id) {
                            //满足添加继续执行
                            return options.fn(this);
                        } else {
                            //不满足条件执行{{else}}部分
                            return options.inverse(this);
                        }
                    });

                    $('.main').html(contentTemplate(result));
                }
            }
        });
    }*/
    //定时发送请求
    setInterval(function(){
        $.ajax({
            url: '/Platform/communicate/selectCommunicateByTopic_id',
            type: 'post',
            asysc: false,
            success: function (data) {
                var result = eval(data);
                if (result.success) {
                    var contentTemplate = Handlebars.compile($('#content-template').html());

                    Handlebars.registerHelper("compare", function (v1, options) {
                        var id = $(".header").find(".content-title").attr("user_id");
                        if (v1 != id) {
                            //满足添加继续执行
                            return options.fn(this);
                        } else {
                            //不满足条件执行{{else}}部分
                            return options.inverse(this);
                        }
                    });

                    $('.main').html(contentTemplate(result));
                }
            }
        });
    },1000);
    //back to index
    function backToIndex(){
        $(".left-image").click(function(){
            location.href="/Platform/pages/topic/commuList.html";
        });
    }
});