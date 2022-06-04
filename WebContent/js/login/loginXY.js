var flag = 0;
var tag = 0;


//点击协议
$("#def_word").click(function(){
	var XYmsg = $(this).prop("class"); //协议
	if(XYmsg!='ok'){
	    $(this).attr("class",'ok');
	    $("#form #loginErro").hide().find(".erroTips").html("");
		$(this).prop("type", "submit");
	}else{
		$(this).prop("type", "button");
	    $(this).attr("class",'err');
	    $("#form #loginErro").show().find(".erroTips").html("请同意《淘四季用户协议》");
	}
	});
	
	if($(".phone_ipt .loginname").val()!=""){
		$("#usernamelogo").css("display","block");
	}
	
	$(".phone_ipt .loginname").on("input propertychange",function(){
	    $("#usernamelogo").css("display","block");
	  });
	$("#usernamelogo").click(function() {
		$(".phone_ipt .loginname").val("");
		$(this).css("display","none");
});
//点击手机验证码登录
var coun = 0;
$(".phone-words.floatleft.ac_loginUsername").click(function() {
	coun++;
	if(coun%2==1){
		$(this).text("密码登录");
		$(".loginname").prop("placeholder","请输入手机号码");
		$(".loginpwd").prop({"placeholder":"请输入手机验证码","type":"number"});
		$(".verificationCode").text("获取验证码");
		flag = 1;
	}
	else{
		$(this).text("手机验证码登录");
		$(".loginname").prop("placeholder","请输入帐号");
		$(".loginpwd").prop({"placeholder":"请输入密码","type":"password"});
		$(".verificationCode").text("忘记密码");
		flag = 0;
	}
});

//短信验证码倒计时
function countdownHandler(){
	var $button = $(".verificationCode");
	var number = 60;
	var countdown = function(){
		if (number == 0) {
			$button.prop("disabled",false);
			$button.html("发送验证码");
            number = 60;
            return;
        } else {
        	$button.prop("disabled",true);
        	$button.html(number + "秒 重新发送");
        	number--;
        }
		setTimeout(countdown,1000);
	}
	setTimeout(countdown,1000);
}

//获取验证码
$(".verificationCode").click(function(){
	var phone = $(".loginname").val();
	if(flag == 1){
		var phone = $(".loginname").val();
		var data = {};
		data.mobile = $.trim(phone);
		var reg = /^1\d{10}$/;
		
		if(phone==null||phone==""){
			$("#form #loginErro").show().find(".erroTips").html("请输入手机号");
			currentAjax.abort();
			if(phone!=""){
				if(!reg.test(data.mobile)){
					$("#form #loginErro").show().find(".erroTips").html("手机号码不合法");
					currentAjax.abort();
				}
			}
		}
		else{
			if(!reg.test(data.mobile)&&(phone!=""||phone!=null)){
				$("#form #loginErro").show().find(".erroTips").html("手机号码不合法");
				currentAjax.abort();
			}
			else{
				$(".loginErro").css("display","none");
				$("#form #loginErro").hide().find(".erroTips").html("");
			}
		}
		currentAjax = $.ajax({
			url: "servlet/SendSmsServlet?phone="+phone,
	        async : true,
	        type: "post",
	        dataType: "text",
	        data: $('#form').serialize(),
	        success: function (data) {
	        	if(data == 'success'){
	        		countdownHandler();
	        	}
	        } 
		
    	});
	}
});
//登录、账号密码框判断
$(".login_btn").click(function(){
	var user = $(".loginname").val();
	var pass = $(".loginpwd").val();
	var XYmsg = $("#def_word").prop("class"); //协议
	
	if(user==null||user==""){
		if(flag==1){
			$("#form #loginErro").show().find(".erroTips").html("请输入手机号");
		}
		else{
			$("#form #loginErro").show().find(".erroTips").html("请输入帐号");
		}
	}
	else if(pass==null||pass==""){
		if(flag==1){
			$("#form #loginErro").show().find(".erroTips").html("请输入验证码");
		}
		else{
			$("#form #loginErro").show().find(".erroTips").html("请输入密码");
		}
	}	
	else if(XYmsg!="ok"){
		$("#form #loginErro").show().find(".erroTips").html("请同意《淘四季用户协议》");
		$("#def_word").prop("class",'err');
	}
	else{
		tag = 1;
		$(".loginErro").css("display","none");
		$("#form #loginErro").hide().find(".erroTips").html("");
		$("#form").prop("onsubmit","return true;");
		}
	//通过ajax登录
	function tijiao(){
		$.ajax({
		      url: "servlet/PhoneLoginServlet",
		      async : true,
		      type: "post",
		      dataType: "text",
		      data: $('#form').serialize(),
		      success: function (data) {
		      	if(data == 'success'){
		      		window.location.href="shop.jsp";
		      	}
		      	else if(data == 'fail'){
		      		alert("当前手机号暂未注册");
		      		window.location.href="register.jsp";
//		      		$("#form #loginErro").show().find(".erroTips").html("当前手机号暂未注册");
		      	}
		      	else{
			      	$("#form #loginErro").show().find(".erroTips").html(data);
		      	}
		      }
		});
	}

	if(flag==1&&tag==1){
		
		tijiao();
	}
	else{
		$("#form").prop("action","servlet/LoginServlet").prop("method","post");
		$("#form").submit();
	}
});


