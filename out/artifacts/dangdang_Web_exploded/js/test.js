var index=0;
var numberHead;
var numberImg=$(".fresh_fs_carousel .banner .pic").length;//获取图片序号

//1.自动轮播
function timer(){
    index++;
    if(index>numberImg-1){
        index=0;
    }
    $(".fresh_fs_carousel .banner .pic").eq(index).stop().fadeIn().siblings().stop().fadeOut();
    //自动改变圆点样式
	$(".slider_indicators .slider_indicators_btn:eq("+index+")").addClass("slider_indicators_btn_active");
 	for(var tempIndex = 0;tempIndex < numberImg; tempIndex++){
 		if(tempIndex == index)
 			continue;
 		$(".slider_indicators .slider_indicators_btn:eq("+tempIndex+")").removeClass("slider_indicators_btn_active");
 	}
 	
}
//开启定时器
time = setInterval(function(){
    timer();
},2000);

$(".fresh_fs_carousel .banner").hover(function(){
    clearInterval(time);
},function(){
    time=setInterval(function(){
        timer();
    },2000)
});

//2.点击轮播
$(".fresh_fs_carousel .right").click(function(){
    index++;
    if(index>numberImg-1)
        index=0;
    //停止动画队列:stop()
    $(".fresh_fs_carousel .banner .pic").eq(index).stop().fadeIn().siblings().stop().fadeOut();
});
$(".fresh_fs_carousel .left").click(function(){
    index--;
    if(index<0)
        index=numberImg-1;
    $(".fresh_fs_carousel .banner .pic").eq(index).stop().fadeIn().siblings().stop().fadeOut();
});