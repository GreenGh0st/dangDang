var order;
var i;
var thiNum = $(".fresh_fs_nav .tab_head_item").length;
$(".fresh_fs_nav .tab_body .tab_body_item").css("display","none");

$(".fresh_fs_nav .tab_head_item").hover(function(){
	//索引
	order=$('.fresh_fs_nav .tab_head_item').index(this);
	
	//body样式
	$(".fresh_fs_nav .tab_body .tab_body_item:eq("+order+")").css("display","block");
	
	//进入分类body时head的样式设置
	$(".fresh_fs_nav .tab_body .tab_body_item:eq("+order+")").mouseenter(function(){
		$(this).css("display","block");
		var tempIndex = order;
		tempIndex--;
		$(".fresh_fs_nav .tab_head_item:eq("+tempIndex+")").css("background","#fff");
		
		for(i = 0; i < thiNum+1; i++){
			if(i == order-1)
				continue;
			$(".fresh_fs_nav .tab_head_item:eq("+i+")").css("border-right","1px solid #ddd");
		}
		$(".fresh_fs_nav .tab_head_item:eq("+tempIndex+")").css("border-left","1px solid #DDD");
		$(".fresh_fs_nav .tab_head_item:eq("+tempIndex+")").css("border-bottom","1px solid #DDD");
		$(".fresh_fs_nav .tab_head_item:eq("+tempIndex+")").css("border-top","1px solid #DDD");
		$(".fresh_fs_nav .tab_head_item_inner:eq("+tempIndex+")").css("border-top-style","none");
		$(".fresh_fs_nav .tab_head_item_inner:eq("+order+")").css("border-top","1px dotted transparent");
	});
	
	//head样式
	$(this).css("background","#fff");
	$(this).css("border-left","1px solid #DDD");
	$(this).css("border-bottom","1px solid #DDD");
	$(this).css("border-top","1px solid #DDD");
	$(".fresh_fs_nav .tab_head_item_inner:eq("+order+")").css("border-top-style","none");
	var tempIndex = ++order;
	$(".fresh_fs_nav .tab_head_item_inner:eq("+tempIndex+")").css("border-top","1px dotted transparent");
	for(i = 0; i < thiNum+1; i++){
		if(i == order-1)
			continue;
	$(".fresh_fs_nav .tab_head_item:eq("+i+")").css("border-right","1px solid #ddd");
	}
},function(){
	//索引
	order=$('.fresh_fs_nav .tab_head_item').index(this);
	
	//body样式
	$(".fresh_fs_nav .tab_body .tab_body_item:eq("+order+")").css("display","none");
	
	//离开分类body时head的样式设置
	$(".fresh_fs_nav .tab_body .tab_body_item:eq("+order+")").mouseleave(function(){
		$(this).css("display","none");
		for(var i = 0; i < thiNum; i++){
			$(".fresh_fs_nav .tab_head_item:eq("+i+")").css("background","transparent");
		}
		
		for(i = 0; i < thiNum; i++){
			$(".fresh_fs_nav .tab_head_item:eq("+i+")").css("border-right-style","none");	
		}
		var tempIndex = order;
		tempIndex--;
		$(".fresh_fs_nav .tab_head_item:eq("+tempIndex+")").css("border-left","1px solid transparent");
		$(".fresh_fs_nav .tab_head_item:eq("+tempIndex+")").css("border-bottom-style","none");
		$(".fresh_fs_nav .tab_head_item:eq("+tempIndex+")").css("border-top-style","none");
		$(".fresh_fs_nav .tab_head_item_inner:eq("+tempIndex+")").css("border-top","1px dotted #ddd");
		$(".fresh_fs_nav .tab_head_item_inner:eq("+order+")").css("border-top","1px dotted #ddd");
	});

	//head样式
	$(this).css("background","transparent");
	$(this).css("border-left","1px solid transparent");
	$(this).css("border-bottom-style","none");
	$(this).css("border-top-style","none");
	if(order==0)
		$(".fresh_fs_nav .tab_head_item_inner:eq("+order+")").css("border-top","1px dotted transparent");
	else
		$(".fresh_fs_nav .tab_head_item_inner:eq("+order+")").css("border-top","1px dotted #ddd");
	var tempIndex = ++order;
	$(".fresh_fs_nav .tab_head_item_inner:eq("+tempIndex+")").css("border-top","1px dotted #ddd");
	for(i = 0; i < thiNum; i++){
		$(".fresh_fs_nav .tab_head_item:eq("+i+")").css("border-right-style","none");	
	}
});
