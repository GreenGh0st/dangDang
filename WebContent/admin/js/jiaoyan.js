$(".login_sub").click(function(){
	var user = $(".userName").val();
	var pass = $(".userPwd").val();
	if(user==null||user==""){
		$("#fm4 #loginErro").show().find(".erroTips").html("请输入账号");
		$(this).attr('type','javascript(0)');
	}
	else if(pass==null||pass==""){
		$("#fm4 #loginErro").show().find(".erroTips").html("请输入密码");
		$(this).attr("type","javascript(0)");
	}	
	else{
			$(".loginErro").css("display","none");
			$("#fm4 #loginErro").hide().find(".erroTips").html("");
			$(this).attr("type","submit");
	}
});