$(".cartCountBtn.down").click(function(){
	var down = $(".amount");
	down.val(parseInt(down.val())-1); //点击减号输入框数值减1
	    if(down.val()<=0){
	        down.val(parseInt(down.val())+1); //最小值为1
	    }
});
$(".cartCountBtn.up").click(function(){
	var up = $(".amount");
	up.val(parseInt(up.val())+1); //点击减号输入框数值加1
    if(up.val()>=4){
        up.val(parseInt(up.val())-1); //最小值为1
    }
});
$(".amount").keyup(function(){
    var c=$(this);
    if(/[^\d]/.test(c.val())){//替换非数字字符
        var amount=c.val().replace(/[^\d]/g,'');
        $(this).val(amount);
    }
});

$(".detail-tab .detail-ul li").click(function(){
	order = $(".particulars .detail-ul li").index(this);
	var className = $(".detail-tab .detail-ul li:eq("+order+")");
	var className1 = $(".detail-tab .detail-ul li:eq("+0+")"); 
	var className2 = $(".detail-tab .detail-ul li:eq("+1+")"); 

	className.prop("class","active");
	if(order == 0){
		$(".detail-content").css("display","block");
		className2.removeAttr("class");
		$("#comment").css("display","none");
		$(".no-comment").css("display","none");
	}
	if(order == 1){
		$(".detail-content").css("display","none");
		className1.prop("class","");
		$("#comment").css("display","block");
		$(".no-comment").css("display","block");
	}
});

//直接购买
var price = $(".jiage strong").text();
var number = $(".selectAmount .amount.pAmount").val();
var sumPrice = price * number;
$("#sumPrice").val(sumPrice);
$(".operation .addPurchase").click(function(){
	var testform=$(".war");
	testform.prop("action","checkOut.jsp");
	testform.submit();
});


//动态评分
var obj,aMsg = [
	"很不满意|差得太离谱，与卖家描述的严重不符，非常不满",
    "不满意|部分有破损，与卖家描述的不符，不满意",
    "一般|质量一般，没有卖家描述的那么好",
    "满意|质量不错，与卖家描述的基本一致，还是挺满意的",
    "非常满意|质量非常好，与卖家描述的完全一致，非常满意"
];
var icon="";
var icon1="";
var index;
var obj;
$(".compose-sub .tipBox").val("");
//第一行
$(".compose-sub .com_serveQua .grade-content .icon").on({
	"mouseenter":function(){
		index=$(this).index();
		if(index == 0 || index == 1)
			icon = "icon1";
		if(index == 2 || index == 3)
			icon = "icon2";
		if(index == 4)
			icon = "icon3";
		$(".compose-sub .com_serveQua .grade-content .icon").removeClass("icon1 icon2 icon3");
		$(this).addClass(icon).prevAll().addClass(icon);
		//悬浮框
		$(".compose-sub .tip").html("<em>"+(index+1)+"分&nbsp;"+aMsg[index].match(/(.+)\|/)[1]+"</em><p>"+aMsg[index].match(/\|(.+)/)[1]+"</P>").css("top","105px").show();
	},
	"mouseleave":function(){
		$(".compose-sub .com_serveQua .grade-content .icon").removeClass("icon1 icon2 icon3");
		obj && obj.addClass(icon1).prevAll().addClass(icon1);
		$(".tip").hide();
	},
	"click":function(){
		obj=$(this);//记录当前点击的小星星
		var index1=$(this).index();
		if(index1 == 0 || index1 == 1)
			icon1 = "icon1";
		if(index1 == 2 || index1 == 3)
			icon1 = "icon2";
		if(index1 == 4)
			icon1 = "icon3";
		console.log(obj);
		$(this).addClass(icon1).prevAll().addClass(icon1);
		//显示框
		$(".compose-sub .com_serveQua .tipBox").val(aMsg[index].match(/(.+)\|/)[1]);
	}
});
//第二行
$(".compose-sub .com_delivery  .grade-content .icon").on({
	"mouseenter":function(){
		index=$(this).index();
		if(index == 0 || index == 1)
			icon = "icon1";
		if(index == 2 || index == 3)
			icon = "icon2";
		if(index == 4)
			icon = "icon3";
		$(".compose-sub .com_delivery  .grade-content .icon").removeClass("icon1 icon2 icon3");
		$(this).addClass(icon).prevAll().addClass(icon);
		//悬浮框
		$(".compose-sub .tip").html("<em>"+(index+1)+"分&nbsp;"+aMsg[index].match(/(.+)\|/)[1]+"</em><p>"+aMsg[index].match(/\|(.+)/)[1]+"</P>").css("top","62px").show();
	},
	"mouseleave":function(){
		$(".compose-sub .com_delivery  .grade-content .icon").removeClass("icon1 icon2 icon3");
		obj && obj.addClass(icon1).prevAll().addClass(icon1);
		$(".tip").hide();
	},
	"click":function(){
		obj=$(this);//记录当前点击的小星星
		var index1=$(this).index();
		if(index1 == 0 || index1 == 1)
			icon1 = "icon1";
		if(index1 == 2 || index1 == 3)
			icon1 = "icon2";
		if(index1 == 4)
			icon1 = "icon3";
		console.log(obj);
		$(this).addClass(icon1).prevAll().addClass(icon1);
		//显示框
		$(".compose-sub .com_delivery  .tipBox").val(aMsg[index].match(/(.+)\|/)[1]);
	}
});
//第一行
$(".compose-sub .com_fooaQua .grade-content .icon").on({
	"mouseenter":function(){
		index=$(this).index();
		if(index == 0 || index == 1)
			icon = "icon1";
		if(index == 2 || index == 3)
			icon = "icon2";
		if(index == 4)
			icon = "icon3";
		$(".compose-sub .com_fooaQua .grade-content .icon").removeClass("icon1 icon2 icon3");
		$(this).addClass(icon).prevAll().addClass(icon);
		//悬浮框
		$(".compose-sub .tip").val("<em>"+(index+1)+"分&nbsp;"+aMsg[index].match(/(.+)\|/)[1]+"</em><p>"+aMsg[index].match(/\|(.+)/)[1]+"</P>").css("top","22px").show();
	},
	"mouseleave":function(){
		$(".compose-sub .com_fooaQua .grade-content .icon").removeClass("icon1 icon2 icon3");
		obj && obj.addClass(icon1).prevAll().addClass(icon1);
		$(".tip").hide();
	},
	"click":function(){
		obj=$(this);//记录当前点击的小星星
		var index1=$(this).index();
		if(index1 == 0 || index1 == 1)
			icon1 = "icon1";
		if(index1 == 2 || index1 == 3)
			icon1 = "icon2";
		if(index1 == 4)
			icon1 = "icon3";
		console.log(obj);
		$(this).addClass(icon1).prevAll().addClass(icon1);
		//显示框
		$(".compose-sub .com_fooaQua .tipBox").val(aMsg[index].match(/(.+)\|/)[1]);
	}
});

//评论
$(".tijiaoBtn div span").click(function(){
	var testform=$(".war");
	testform.prop("action","servlet/Comment");
	testform.submit();
});

var userName = $(".userName").val();
//匿名评价
$(".anonymity input").click(function(){
	if($(this).is(':checked'))
		$(".userName").val("匿名用户");
	else
		$(".userName").val(userName);
});


$(".paging-num a").click(function() {
	var ord = $(this).index();
	if(ord == 2|| ord == 3){
		if($(".flip input").prop("placeholder")==$(".all em").html()){
			$(this).prop("href","javascript:;");
			alert("当前是最后一页！")
		}
	}
	if(ord == 0 || ord == 1){
		if($(".flip input").prop("placeholder")==1){
			$(this).prop("href","javascript:;");
			alert("当前已是第一页！")
		}
	}
});
//评论页面跳转
$(".paging-num .jump").click(function() {
	var pageNow = $("#pageNow").val();
	var allPage = parseInt($(".all em").html());
	if(pageNow > allPage || pageNow <= 0 || pageNow == ""){
		alert("请正确输入跳转页数！");
		$("#pageNow").val("");
		$("#pageNow").focus();
		return;	
	}
	else{
		window.location.href="details.jsp?pageNow=" + pageNow;
	}
	if($(".flip input").prop("placeholder")==$(".all em").html()){
		$(this).prop("href","javascript:;");
		alert("当前是已最后一页！");
	}
	if($(".flip input").prop("placeholder")==1){
		$(this).prop("href","javascript:;");
		alert("当前已是第一页！");
	}
});

//滚动条重定位
var cookieWord=$.cookie("cookieValue");
if(cookieWord != null){
	$(".detail-content").css("display","none");
	$(".detail-item").css("display","block");
	$("html,body").animate({scrollTop:cookieWord}, 100);
}

var dingwei = $(".detail-ul").offset().top;

$(".paging-num a").click(function(){
	 $.cookie("cookieValue", dingwei);
})