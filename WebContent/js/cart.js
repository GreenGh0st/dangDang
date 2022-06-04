var n = $(".myshopcar .shopcar-count").text();
if(n == 0){
	$(".myshopcar").hover(function(){
		$(".prompt").css("display","block");
	},function(){
		$(".prompt").css("display","none");
	});
}
else{
	$(".myshopcar").hover(function(){
		$(".goods").css("display","block");
	},function(){
		$(".goods").css("display","none");
	});
}
if(n>3){
	$("#overflow").css("height","200px");
	$("#overflow").css("overflow","auto");
	}
