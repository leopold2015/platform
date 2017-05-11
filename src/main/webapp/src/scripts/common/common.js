/**
 * Created by mgh on 2017/5/11.
 */
$(".footer-content").click(function(){
    var text = $(this).find(".content-text").text();
    if(text=="首页"){
        location.href="/Platform/pages/index.html";
    }else if(text=="交流"){
        location.href="/Platform/pages/topic/commuList.html";
    }else if(text=="我的"){
        location.href="/Platform/pages/mine/mine.html";
    }
});