var index;
$(".sort a").hover(function(){
	index = $(".sort a").index(this);
	$(".sort a:eq("+index+")").css("color","#f40");
	if(index == 1||index == 2)
		$(".sort a:eq("+index+") i").css("background-position","-239px -255px");
},function(){
	$(".sort a:eq("+index+")").css("color","#232321");
	if(index == 1||index == 2)
		$(".sort a:eq("+index+") i").css("background-position","-220px -255px");
	
});
$(".filtrate a.select_frame").hover(function(){
	$(this).css({"border":"1px solid #f40","color":"#f40"});
},function(){
	$(this).css({"border":"1px solid #dcdcdc","color":"#000"});
});


$(".dh2.logged").hover(function(){
	$("#userName").prop("class", "userName1");
	$(".logged div").css("display", "block");
},function(){
	$("#userName").prop("class", "userName");
	$(".logged div").css("display", "none");
});

//价格区间
$(".price-interval .inner input").hover(function(){
	$(".price-interval a").css("display","inline-block");
	$(".price-interval").css({
		"box-shadow": "0 0 6px 0 rgba(0,0,0,0.19)",
		"background": "#fff"
	});
},function(){
	$(".fresh .second-filter .price-interval").mouseleave(function(){
		$(".price-interval a").css("display","none");
		$(".price-interval").css({
			"box-shadow": "none",
			"background": "#F8F8FA"
		});
	});
});

$(".empty").click(function(){
	$(".price-interval .inner input").prop("value","");
});

//公告弹窗
document.getElementById('zhezhao').style.display="none";
function exit(){
	document.getElementById('zhezhao').style.display="block";
	}
function hidder(){
	document.getElementById('zhezhao').style.display="none";
}


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
			 left: 1100, //结束位置（必填） 
			 top: 60, //结束位置（必填） 
			 width:0, //结束时宽度 
			 height: 0 //结束时高度 
		 }, 
		 onEnd: function(){ //结束回调 
          $(".shopcar-count").show().animate({width: '24px'},200); //提示信息 
          this.destory(); //移除dom 
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

//根据类别搜索
$(".s-sort .vbody a").click(function(){
	var index1 = $(".s-sort .vbody a").index(this);
	var sortKey = $(".s-sort .vbody a:eq("+index1+")").text();
	$(".s-sort .vbody a:eq("+index1+")").prop("href","servlet/UserSearchServlet?action=sort&sortKey="+sortKey);
});

//根据原产地搜索
$(".s-origin .vbody a").click(function(){
	var index2 = $(".s-origin .vbody a").index(this);
	var addrKey = $(".s-origin .vbody a:eq("+index2+")").text();
	$(".s-origin .vbody a:eq("+index2+")").prop("href","servlet/UserSearchServlet?action=addr&addrKey="+addrKey);
});

var shopCar = $(".myshopcar").offset().top;
$(window).scroll(function(){//滚动事件获取判断滚动条高度
    var $scroll = $(document).scrollTop();
    if($scroll > shopCar){
    	$(".myshopcar").css("position","fixed")
    				   .css("right","300px");
    }
    if($scroll <= shopCar){
    	$(".myshopcar").css("position","absolute")
    				   .css("right","140px");
    }
});

//根据价格区间查询
$(".price-interval .submit").click(function() {
	var pricedown = $("#pricedown").val();
	var priceup = $("#priceup").val();
	
	if(pricedown==""||priceup==""){
		alert("请填写价格！");
		$(this).prop("href","javascript:;");
	}
	else{
		$(this).prop("href","servlet/UserSearchServlet?action=price&pricedown="+pricedown+"&priceup="+priceup);
	}
});