//alert(value);
$(".tab ul li").click(function(){
	order = $(".tab ul li").index(this);
	for(var i = 0;i < $(".tab ul li").length; i++){
		if(i == order){
			$(".tab ul li:eq("+i+")").prop("class","act-state");
		}
		else
			$(".tab ul li:eq("+i+")").prop("class","");
	}
});
//订单时间
$("#timeDrop .select").click(function(){
	var value = $("#timeDrop .select .time-selected span").prop("class");
	if(value == "a1"){
		$("#timeDrop .select .time-selected span").prop("class","a2");
		$(".select .time-list").css("display","block");
	}
	else{
		$("#timeDrop .select .time-selected span").attr("class","a1");
		$(".select .time-list").css("display","none");
	}
});
//订单状态
$("#ztDrop .select").click(function(){
	var value1 = $("#ztDrop .select .zt-selected #selectedStatus").prop("class");
	if(value1 == "a1"){
		$("#ztDrop .zt-selected #selectedStatus").prop("class","a2");
		$(".select .zt-list").css("display","block");
	}
	else{
		$("#ztDrop .zt-selected #selectedStatus").attr("class","a1");
		$(".select .zt-list").css("display","none");
	}
});
//焦点获取
//$("#queryConditionText").click(function(){
//	$(".l.so-box em").css("display","none");
//});
//$(".l.so-box em").click(function(){
//	$(this).css("display","none");
//	$("#queryConditionText").focus();
//});
//$("body").click(function(){
//	if($("#queryConditionText").is(':focus')==false ){
//		$(".l.so-box em").css("display","block");
//	}
//});

$(".li-left .dh2").hover(function(){
	$("#wellcome").css("display","none");
	$("#exit").css("display","block");
},function(){
	$("#wellcome").css("display","block");
	$("#exit").css("display","none");
});

//总金额
var len = $("tbody .food-amount span").length;
var sumPrice = 0.0; 
for(var i = 0; i < len; i++){
	sumPrice = parseFloat($("tbody .food-price span:eq("+i+")").text())*parseFloat($("tbody .goods-number:eq("+i+")").text())
	$("tbody .tr-bd td .food-amount #amount:eq("+i+")").text(sumPrice);
}

var sumPrice1 = 0;
var i = 0;
var j = -1;
$("table tbody tr").each(function(){
	  var self=$(this).prop('className');
	  if(self == "tr-th"){ 
		  $("tbody p .price:eq("+j+")").text(sumPrice1);
		  j++;
		  sumPrice1 = 0;
	  }
	  else{
		  var price = parseFloat($("tbody .food-amount #amount:eq("+i+")").text());
		  sumPrice1 += price;
		  i++;
	  }
});
$("tbody p .price:eq("+j+")").text(sumPrice1);

//价格加法
function numAdd(num1, num2) {
    var baseNum, baseNum1, baseNum2;
    try {
        baseNum1 = num1.toString().split(".")[1].length;
    } catch (e) {
        baseNum1 = 0;
    }
    try {
        baseNum2 = num2.toString().split(".")[1].length;
    } catch (e) {
        baseNum2 = 0;
    }
    baseNum = Math.pow(10, Math.max(baseNum1, baseNum2));
    return (num1 * baseNum + num2 * baseNum) / baseNum;
};
