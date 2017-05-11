/**
 * Created by mgh on 2017/5/11.
 */
$(function(){
    $(".add-image").click(function(){
        layer.open({
            content:$(".add-topic-window"),
            type:1,
            icon:1,
            area:['300px','200px'],
            btn:['确定','取消'],
            yes:function(){
                var topic_content = $(".content-text-layer").val();
                $.ajax({
                    url:'/Platform/topic/createTopic',
                    type:'post',
                    data:{
                        topic_content: topic_content
                    },
                    success:function(data){
                        var result = eval(data);
                        if(result.success){
                            layer.msg("添加成功！");
                            location.href="/Platform/pages/topic/commuList.html";
                        }else{
                            layer.msg("添加失败！");
                        }

                    }
                })
            }
        })
    });


    $.ajax({
        url:'/Platform/topic/showAllTopics',
        type:'post',
        success:function(data){
            var result = eval(data);
            if(result.success){
                var contentTemplate = Handlebars.compile($('#content-template').html());
                $('.container').html(contentTemplate(result));
                detail();
            }else{
                alert("出错！");
            }
        },
        error:function(){
            alert("出错！");
        }
    });
});

function detail(){
    $(".topic-list").click(function(){
        location.href="/Platform/pages/topic/topicDetail.html";
    });
}