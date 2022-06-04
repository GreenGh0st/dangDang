$(".m-right .main").css("display","none");
$('.nav_dot_li h4').click(function(){
	order=$('.nav_dot_li h4').index(this);
	if($(" .list-item:eq("+order+")").css("display")=='none')
		$(".nav_dot_li:eq("+order+") .list-item").css("display","block");
	else
		$(".nav_dot_li:eq("+order+") .list-item").css("display","none");
});

/*$(".nav_dot_li .info").click(function(){
	order1 = $('.nav_dot_li .info').index(this);
		for(var i = 0; i <= $(".m-right .main").length; i++){
			if(i==order1)
				
				$(".m-right .main:eq("+i+")").css("display","block");
		else
			$(".m-right .main:eq("+i+")").css("display","none");
		}
});*/