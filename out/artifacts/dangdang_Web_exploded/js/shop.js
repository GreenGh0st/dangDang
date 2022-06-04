var shopCar = $(".myshopcar").offset().top;
var tuijian = $(".recommend .rec_title").offset().top;
var xinpin = $(".new_product_title").offset().top;
var cuxiao = $(".promotion_title").offset().top;
$(".navigation-bars .nav_item").click(function(event){
	var order = $(".nav_item").index(this);
	if(order==0)
		$("html,body").animate({scrollTop:tuijian}, 100);//定位到为你推荐
	if(order==1)
		$("html,body").animate({scrollTop:xinpin}, 100);//定位到新品上架
	if(order==2)
		$("html,body").animate({scrollTop:cuxiao}, 100);//定位到促销商品
	if(order==3)
		$("html,body").animate({scrollTop:0},100);
});

$(".myshopcar").css("right","140px");
$(window).scroll(function(){//滚动事件获取//判断滚动条高度
    var $scroll = $(document).scrollTop();
    if($scroll > shopCar){
    	$(".myshopcar").css("position","fixed")
						.css("margin-left","938px")
						.css("right","");
    }
    if($scroll <= shopCar){
    	$(".myshopcar").css("position","absolute")
								.css("margin-left","")
		   						.css("right","140px");
    }
    if($scroll < tuijian){//判断滚动条高度
		$(".navigation-bars").css("display","none");
    }else{
		$(".navigation-bars").css("display","block");
    }
});
$(".dh2.logged").hover(function(){
	$("#userName").prop("class", "userName1");
	$(".logged div").css("display", "block");
},function(){
	$("#userName").prop("class", "userName");
	$(".logged div").css("display", "none");
});
 //公告弹窗
document.getElementById('zhezhao').style.display="none";
function exit(){
	document.getElementById('zhezhao').style.display="block";
	}
function hidder(){
	document.getElementById('zhezhao').style.display="none";
}

var X = $('.shopcar').offset().top;//元素在当前视窗距离顶部的位置
var Y = $('.shopcar').offset().left;
X = X-30;
Y = Y+7;
//点击购物车图标添加商品《不跳转》
$(".cartBtn").click(function(event) {
	var index = $(".recommend-bg .cartBtn").index(this);
	setTimeout(function(){
	    //点击提交按钮时，执行以下Ajax
		$.ajax({
	        type : "post",
	        url : "servlet/AddCarServlet?action=add1&foodID="+$(".recommend-bg #foodID:eq("+index+")").val(),
	        data : $('#addCar').serialize(), //aForm是form表单的id,将form中的数据提交
	        dataType : "text",
	        success : function(shopNumber) {
	        	$(".shopcar-count").text(shopNumber);
	        	window.location.reload();
	        }
	    });
	}, 1000);  
	 var offset = $(".shopcar").offset();
	 var tp = $(".recommend-bg .imgbox img:eq("+index+")");
     var offset=tp.offset();
     var scrollTop = $(document).scrollTop();  
	 var addcar = $(this); 
	 var img = tp.attr('src'); 
	 var flyer = $('<img id="flyer" src="'+img+'">'); 
	 flyer.fly({ 
		 start: { 
			 left: event.clientX-190, //开始位置（必填）#fly元素会被设置成position: fixed 
			 top: event.clientY-190,	 //开始位置（必填） 
		 }, 
		 end: {
			 left: Y, //结束位置（必填） 
			 top: X, //结束位置（必填） 
			 width: 0, //结束时宽度 
			 height: 0 //结束时高度 
		 }, 
		 onEnd: function(){ //结束回调 
            $(".shopcar-count").show().animate({width: '24px'},200); //提示信息 
            this.destory(); //移除dom 
        } 
    });
});

//删除商品
$("#overflow .goodsContent .goodsSale a").click(function() {
	var index1 = $(".goodsSale a").index(this);
	var foodID = $("#overflow .goodsItem .detalis .goodsContent .goodsSale #foodcarId:eq("+index1+")").val();
    //点击提交按钮时，执行以下Ajax
    $.ajax({
        type : "post",
        url : "servlet/AddCarServlet?action=del&foodID="+foodID,
        dataType : "text",
        success : function(shopNumber) {
        	$(".shopcar-count").text(shopNumber);
        	$(".myshopcar .goods").css("display","block");
        	window.location.reload();
        }
    });
});

$(document).ready(function(){
	  $('.cartBtn').on('click',function(){
	    
	    var button = $(this);
	    var cart = $('.myshopcar .shopcar-count');
	    var cartTotal = cart.text();
	    var newCartTotal = parseInt(cartTotal) + 1;
	    
	    button.addClass('addcartBtn');
	    setTimeout(function(){
	      button.removeClass('addcartBtn');
	      $('.myshopcar').addClass('shake');
	      cart.text(newCartTotal);
	      setTimeout(function(){
	      $('.myshopcar').removeClass('shake');
	      },500)
	    },1000)
	 });
});