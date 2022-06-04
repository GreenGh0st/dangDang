var priceLen = $(".pSubtotal span").length;
var sumPrice;

$('.cartInfo #checked').prop('checked', false); // 多选框不选中
$('.selectAll').prop('checked', false); // 多选框不选中
$(".selectAll").click(function () {
     if($(this).prop("checked")==true)
     	$('.cartInfo #checked').prop('checked', true); // 多选框选中
     if($(this).prop("checked")==false)
     	$('.cartInfo #checked').prop('checked', false); // 多选框选中
});

//设置价格总数
if(priceLen == 0)
	sumPrice = 0.0;
else{
	for(var i = 0; i <= priceLen; i++){
		if(i == 0)
			sumPrice = numAdd($(".pSubtotal span:eq("+i+")").text(),$(".pSubtotal span:eq("+(i+1)+")").text());
		else
			sumPrice = numAdd(sumPrice,$(".pSubtotal span:eq("+(i+1)+")").text());
	}
}
$(".sumPrice").val(sumPrice);

//数量总计
var len = $(".amount.pAmount").length;
var sumNumber = 0;
for(var i = 0; i < len; i++){
	value = Number($(".amount.pAmount:eq("+i+")").val());
	sumNumber += value;
}
$(".sumNumer").val(sumNumber);

//最小数量为1
$(".cartAmount .cartCountBtn.down").click(function(){
	order=$(".cartAmount .cartCountBtn.down").index(this);
	var number = $(".cartAmount .amount:eq("+order+")").val();
	if(number == 1){
		$(".cartAmount .down:eq("+order+")").prop("href","javascript:void(0);");
	}
});

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

//删除部分商品时判断是否有选中复选框
$(".cartButtons .removeSelect").click(function(){
	var n = $(".cartInfo").length;
	for(var i = 0;i < n ;i++){
		var checked = $(".cartBody #checked:eq("+i+")").prop("checked");
		if(checked==true){
			break;
		}
	}
	if(i>=n){
		alert("你还没有选中想要删除的商品！");
	}
	else{
		var testform=document.getElementById("form");
		testform.action="servlet/AddCarServlet?action=partDel";
		testform.submit();
	}
});

//结算
$(".jiesuan").click(function(){
	var testform=$("#form");
	testform.prop("action","checkOut.jsp");
	testform.submit();
});

//导航登陆
$(".dh2.logged").hover(function(){
	$("#userName").prop("class", "userName1");
	$(".logged div").css("display", "block");
},function(){
	$("#userName").prop("class", "userName");
	$(".logged div").css("display", "none");
});


