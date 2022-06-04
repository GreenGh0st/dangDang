<%@ page language="java" import="java.util.*,java.sql.*,entity.*,Dao.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'news_Add.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">	
	<link type="text/css" rel="stylesheet" href="admin/css/style.css" />

	

  </head>
  <script type="text/javascript">
  	function news(){
  		var newsTitle = document.getElementById("newsTitle");
  		var newsContent  = document.getElementById("newsContent");
  		if(newsTitle.value.length<=0){
  			alert("请填写新闻标题！");
  			return false;
  		}else if(newsTitle.value.length>25){
  			alert("新闻标题长度不可超过25！");
  			return false;
  		}
  		if(newsContent.value.length<=0){
  			alert("请填写新闻内容！");
  			return false;
  		}
  		return  true;
  	}
  	</script>
  <body>


  		<form action="servlet/Admin_AddNews" method="post">
     		    <div class="main newsInfo">
				<div class="title">
					<h2>
						<img src="admin/images/ibg1.jpg"/>
						<span>添加新的公告</span>
					</h2>
				</div>
				<table class="user" bgColor="#eeeeee" >
					<tr>
	                <td align="right">标题：</td>
	                <td><input type="text" style="width: 382px;" name="newsTitle" id="newsTitle" /></td>
	              </tr>
	               <tr>
	                <td align="right">公告内容：</td>
	                <td><textarea name="newsContent" id="newsContent" cols="60" rows="10" style="margin: 30"></textarea></td>
	              </tr>
	              <tr>
	              	<td width="200px;"></td>
	              	<td align="left">
	              	  <input type="submit" style="margin-left: 250" class="btnbg" value="确认添加">
	              	  <input type="button" style="margin-left: 300" value="返回" onclick=""/>
	              	
	              	</td>	
	              	              	
	              </tr>
					
								
				</table>
					   
         </div>
		</form>
      </form> 
     
  </body>
</html>
