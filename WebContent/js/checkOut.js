var n = 0;

$(".moreAddr").click(function(){
	n++;
	if(n%2==1){
		$(".hidden").show();
		$(".moreAddr p").css("backgroundImage","url(http://localhost:8080/shop/img/moreU.png)");
		$(".moreAddr .text").text("收起地址");
	}
	if(n%2==0){
		$(".hidden").hide();
		$(".moreAddr p").css("backgroundImage","url(http://localhost:8080/shop/img/moreD.png)");
		$(".moreAddr .text").text("更多地址");
	}
});

//选地址
$(".address-info").hover(function(){
	$(this).css("background","#fff3f3");
},function(){
	$(this).css("background","#fff");
});

$(".hidden").click(function(){
	var testform=$("#creatform");
	var addressId = $("#creatform #addressId").val();
	var userId = $("#creatform #userId").val();
	testform.prop("action","servlet/SelectAddressServlet?action=selAddr&addressId="+addressId+"&userId="+userId);
	testform.submit();
});

//编辑
var index;
$(".address-info .edit").click(function(event){
	event.stopPropagation();
}).click(function(){
	index = $(".address-info .edit").index(this);
	$(".edit-address .thickbox").css("display","block");
	$(".thickbox #editform:eq("+index+")").css("display","block");
});
$(".thickclose").click(function(){
	$(".edit-address .thickbox").css("display","none");
	$(".thickbox #editform:eq("+index+")").css("display","none");
});

//提交编辑信息
$(".save-btn").click(function(){
//	alert("index"+index);
	var testform=$(".thickbox #editform:eq("+index+")");
	var addressId = $(".thickbox #addressID:eq("+index+")").val();
	testform.prop("action","servlet/SelectAddressServlet?action=edit&addressId="+addressId);
	testform.submit();
});

//地址类别
$(".addr-alias a").click(function(){
	var index1 = $(this).index();
	var value = $(".addr-alias a:eq("+index1+")").text();
	$(".editAddr .addrType").val(value);
}).hover(function(){
	$(this).css("color","red").css("border","1px solid red");
},function(){
	$(this).css("color","#333").css("border","1px solid #ddd");
});

$(".pay-info span").click(function(){
	var index2 = $(this).index();
	var len = $(".pay-info span").length;
	for(i = 0 ; i < len ; i++){
		if(i==index2)
			$(".pay-info span:eq("+i+")").css("border","2px solid red");
		else
			$(".pay-info span:eq("+i+")").css("border","2px solid #ccc");	
	}
});

//生成订单号
var vNow = new Date();
var sNow = "";
sNow += String(vNow.getFullYear());
sNow += String(vNow.getMonth() + 1);
sNow += String(vNow.getDate());
sNow += String(vNow.getHours());
sNow += String(vNow.getMinutes());
sNow += String(vNow.getSeconds());
sNow += String(vNow.getMilliseconds());
$("#orderID").val(sNow);