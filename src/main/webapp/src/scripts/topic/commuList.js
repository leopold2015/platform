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
                deleteTopic();
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
    $(".topic-title").click(function(){
        var topic_id = $(this).parent(".topic-list").attr("topic_id");
        $.ajax({
            url:'/Platform/topic/showTopicByTopic_id',
            data:{
                topic_id:topic_id
            },
            type:'post',
        });
        //location.href="/Platform/pages/topic/topicDetail.html";
    });
}

function deleteTopic(){
    $(".delete-img").click(function(){
        var topic_id = $(this).parent(".topic-list").attr("topic_id");
        layer.confirm('您是如何看待前端开发？', {
            btn: ['确定','取消'] //按钮
        }, function(){
            $.ajax({
                url: '/Platform/topic/deleteTopicByTopic_id',
                data: {
                    topic_id:topic_id
                },
                type: 'post',
                success:function(data){
                    var result = eval(data);
                    if(result.success){
                        location.href="/Platform/pages/topic/commuList.html";
                    }else{
                        layer.msg("删除失败！");
                    }
                },
                error:function(){
                    alert("请求中断！");
                }
            });
        }, function(){
            layer.msg('已取消!');
        });
    });
}