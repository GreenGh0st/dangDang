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
    //切换图片按钮改变圆点样式
	$(".slider_indicators .slider_indicators_btn:eq("+index+")").addClass("slider_indicators_btn_active");
   	for(var tempIndex = 0;tempIndex < numberImg; tempIndex++){
 		if(tempIndex == index)
 			continue;
 		$(".slider_indicators .slider_indicators_btn:eq("+tempIndex+")").removeClass("slider_indicators_btn_active");
 	}
});
$(".fresh_fs_carousel .left").click(function(){
    index--;
    if(index<0)
        index=numberImg-1;
    $(".fresh_fs_carousel .banner .pic").eq(index).stop().fadeIn().siblings().stop().fadeOut();
    //切换图片按钮改变圆点样式
	$(".slider_indicators .slider_indicators_btn:eq("+index+")").addClass("slider_indicators_btn_active");
   	for(var tempIndex = 0;tempIndex < numberImg; tempIndex++){
 		if(tempIndex == index)
 			continue;
 		$(".slider_indicators .slider_indicators_btn:eq("+tempIndex+")").removeClass("slider_indicators_btn_active");
 	}
});

//图片切换按钮隐藏和显示
$(".fresh_fs_carousel").hover(function(){
    $(".fresh_fs_carousel .left").show();
    $(".fresh_fs_carousel .right").show();
},function(){
    $(".fresh_fs_carousel .left").hide();
    $(".fresh_fs_carousel .right").hide();
});

//点击小圆点切换图片
$(".slider_indicators .slider_indicators_btn").click(function(){
index=$('.slider_indicators .slider_indicators_btn').index(this);
$(".slider_indicators .slider_indicators_btn:eq("+index+")").addClass("slider_indicators_btn_active");
$(".fresh_fs_carousel .banner .pic").eq(index).stop().fadeIn().siblings().stop().fadeOut();
for(var i = 0;i < numberImg; i++){
	if(i == index)
		continue;
 	$(".slider_indicators .slider_indicators_btn:eq("+i+")").removeClass("slider_indicators_btn_active");
}
});