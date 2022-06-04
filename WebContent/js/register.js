//文本框为空时显示警告
$(".tijiao").click(function(){
	var user = $(".accounts").val();
	var pass = $(".userPwd").val();
	var pass1 = $(".userPwd1").val();
	var name = $(".compellation").val();
	var tell = $(".userTel").val();
	var address = $(".userAddr").val();
	var email = $(".userEmail").val();
	
	//账号
	if(user==null||user==""){
		$(".userName .title").css("display","block");
		$(this).attr("type","button");
	}
	//密码
	if(pass==null||pass==""){
		$(".password .title").css("display","block");
		$(this).attr("type","button");
	}
	//确认密码
	if(pass1==null||pass1==""){
		$(".password1 .title").css("display","block");
		$(this).attr("type","button");
	}
	//姓名
	if(name==null||name==""){
		$(".name .title").css("display","block");
		$(this).attr("type","button");
	}
	//电话
	if(tell==null||tell==""){
		$(".tel .title").css("display","block");
		$(this).attr("type","button");
	}
	//地址
	if(address==null||address==""){
		$(".address .title").css("display","block");
		$(this).attr("type","button");
	}
	//邮箱
	if(email==null||email==""){
		$(".email .title").css("display","block");
		$(this).attr("type","button");
	}
	if(pass!=pass1&&pass1!=""&&pass!=""){
		$(".password1 .title").html("密码不一致！");
		$(".password1 .title").css("display","block");
		$(this).attr("type","button");
	}
});

//输入数据即消失警告
$(function(){
    $("input").bind('input propertychange',function(){
    	order = $(".reg-form input").index(this);
        //帐号
        if(order==0){
        	$(".userName .title").css("display","none");
			$(".tijiao").attr("type","submit");
        }
        //密码
        if(order==1){
        	var pwd1=$(".reg-form input:eq("+order+")").val();
        	$(".password .title").css("display","none");
			$(".tijiao").attr("type","submit");
        }
        //确认密码
        if(order==2){
        	var pwd2=$(".reg-form input:eq("+order+")").val();
        	$(".password1 .title").css("display","none");
			$(".tijiao").attr("type","submit");
        }
        //姓名
        if(order==3){
        	$(".name .title").css("display","none");
			$(".tijiao").attr("type","submit");
        }
        //电话
        if(order==4){
        	$(".tel .title").css("display","none");
			$(".tijiao").attr("type","submit");
        }
        //地址
        if(order==5){
        	$(".address .title").css("display","none");
			$(".tijiao").attr("type","submit");
        }
        //邮箱
        if(order==6){
        	$(".email .title").css("display","none");
			$(".tijiao").attr("type","submit");
        }
    });
});

//判断是否选择性别
 $(function(){
        $(".tijiao").click(function(){
            var val=$('input:radio[name="sex"]:checked').val();
            if(val==null){
                $(".tijiao").attr("type","button");
                $(".sex .title").css("display","block");
            }
            else{
                $(".sex .title").css("display","none");
            }       
        });
        $(".selectSex").click(function(){
        	var val=$('input:radio[name="sex"]:checked').val();
        	if(val!=null)
           	 $(".sex .title").css("display","none"); 
     	});
});
 
$(function () {
 //解决Chrome上出现的密码自动补全(propertychange属性兼容IE)
	 $("[flag='password']").bind('input propertychange', function(e) {
	     //取消事件的默认动作
	     e.preventDefault();
	     $(this).attr("type","password");
	 });
});