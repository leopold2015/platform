/**
 * Created by mgh on 2017/5/10.
 */
$(function(){
    $(".btn").click(function(){
        var message = $(".message-text").val();
        if(message !=""){
            $.ajax({
                url:'/Platform/communicate/sendCommunicate',
                data:{
                    communicate_content:message
                },
                type:'post',
                success:function(data){
                    var result = eval(data);
                    if(result.success){
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
                },
                error:function(){
                    console.log("发送失败！");
                }
            });
        }else{
            layer.msg("请输入信息在发送！");
        }

    });
});

//back to index
function backToIndex(){
    $(".left-image").click(function(){
        location.href="/Platform/pages/topic/commuList.html";
    });
}