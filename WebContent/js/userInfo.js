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

//输入数据警告消失
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

$(".li-left .dh2").hover(function(){
	$("#wellcome").css("display","none");
	$("#exit").css("display","block");
},function(){
	$("#wellcome").css("display","block");
	$("#exit").css("display","none");
});

//我的账户
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
$("#queryConditionText").click(function(){
	$(".l.so-box em").css("display","none");
});
$(".l.so-box em").click(function(){
	$(this).css("display","none");
	$("#queryConditionText").focus();
});
$("body").click(function(){
      if($("#queryConditionText").is(':focus')==false ){
      	$(".l.so-box em").css("display","block");
      }
    });
