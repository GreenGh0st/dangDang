var flag;
//选择类别
var number;
var order;
$("#addressList .alias-edit").click(function(){
	number = $("#addressList .alias-edit").index(this);
	$(".alias-form:eq("+number+")").show();
})
$(".alias-form ,.alias-edit").click(function(event){
	event.stopPropagation();
});
$(".alias-form").click(function(event){
	event.stopPropagation();
});
$(document).click(function(){
	$(".alias-form").css("display","none");
});

//新增地址
$(".add-btn").click(function(){
	$(".addthickbox").css("display","block");
	flag = 1;
});
$(".thickclose").click(function(){
	$(".addthickbox").css("display","none");
});

//编辑地址
$(".ml10.ftx-05").click(function(){
	var length = $("#addresssDiv .extra .ftx-05").length;
	order = $(".ml10.ftx-05").index(this);
	$(".thickbox").css("display","block");
	for(var i = 0; i <= length; i++){
		if(i != order)
			$(".thickwrap:eq("+i+")").css("display","none");
		if(i == order)
			$(".thickwrap:eq("+i+")").css("display","block");
	}
	flag = 0;
});
$(".thickclose").click(function(){
	$(".thickbox").css("display","none");
});

//编辑地址-类别
$(".addr-alias a").click(function(){
	var index1 = $(this).index();
	var value = $(".addr-alias a:eq("+index1+")").text();
	$(".editAddr .addrType").val(value);
	$(".creatAddr .addrType").val(value);
}).hover(function(){
	$(this).css("color","red").css("border","1px solid red");
},function(){
	$(this).css("color","#333").css("border","1px solid #ddd");
});

//保存地址信息
$("form .save-btn").click(function(){

	if(flag==1){
		var testform=$("#creatform");
		testform.prop("action","servlet/UserAddressServlet?action=add");
		alert(testform.prop("action"));
		
	}
	if(flag==0){
		var testform=$(".thickbox #editform:eq("+order+")");
		var index3 = $(".thickbox #editform .save-btn").index(this);
		var addressId = $(".thickbox #editform #addressId:eq("+index3+")").val();
		testform.prop("action","servlet/UserAddressServlet?action=edit&addressId="+addressId);
	}
	testform.submit();
});
