/**
 * Created by mgh on 2017/5/10.
 */
$(function(){
    $(".btn").click(function(){
        $(this).parents("form").submit();
    });
});