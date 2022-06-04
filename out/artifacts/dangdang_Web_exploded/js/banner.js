var shoucang = document.getElementsByClassName("mytaomenu")[0];
var shoucang1 = document.getElementById("li-right-mytao");
var shoucang3 = document.getElementsByClassName("mytao")[0];
var shoucang4 = document.getElementsByClassName("mytao-li");
var mycar = document.getElementsByClassName("mycar")[0];
var treasure1 = document.getElementsByClassName("treasure-a2")[0];
var treasure2 = document.getElementsByClassName("treasure-a2")[1];
var treasure3 = document.getElementsByClassName("treasure-a2")[2];
var lipurchase = document.getElementsByClassName("li-right-purchase")[0];
var purchase = document.getElementsByClassName("purchase")[0];
var pmi = document.getElementsByClassName("purchase-menu-item");
var pm = document.getElementsByClassName("purchase-menu")[0];
var collmouse = document.getElementById("li-right-collection");
var coll = document.getElementsByClassName("collection1")[0];
var fuwu = document.getElementsByClassName("fuwu")[0];
var fuwuitem = document.getElementsByClassName("fuwu-item")[0];
var daohang = document.getElementsByClassName("daohang")[0];
var daohangbox = document.getElementsByClassName("daohang-box")[0];

//收藏小图标变色
collmouse.onmousemove = function(){
	coll.className = "collection2";
	
}
collmouse.onmouseout = function(){
	coll.className = "collection1";
}

//我的淘四季
shoucang.onmouseover = function(){
	shoucang3.style.display ='block';
	shoucang1.style.background = '#FFFFFF';
	mycar.style.color = "#00C65D";
}
shoucang.onmouseout = function() {
        shoucang3.style.display = "none";
    	shoucang1.style.background = '';
		mycar.style.color = "#000000";
}

for(var i=0;i<shoucang4.length;i++){
	shoucang4[i].onmouseover = function(){
		this.style.background="#f4f4f4";
	}
	shoucang4[i].onmouseout = function(){
		this.style.background="";
	}
}

//生鲜、熟食、店铺
treasure1.onclick = function(){
		this.className = "treasure-a1";
		treasure2.className = "treasure-a2";
		treasure3.className = "treasure-a2";
}
treasure2.onclick = function(){
		this.className = "treasure-a1";
		treasure1.className = "treasure-a2";
		treasure3.className = "treasure-a2";
}
treasure3.onclick = function(){
		this.className = "treasure-a1";
		treasure1.className = "treasure-a2";
		treasure2.className = "treasure-a2";
}
//企业采购
purchase.onmouseover = function(){
	pm.style.display = "block";
	lipurchase.style.background = '#FFFFFF';
}
purchase.onmouseout = function(){
	pm.style.display = "none";
	lipurchase.style.background = '';
}
for(var i = 0;i < pmi.length;i++){
	pmi[i].onmouseover = function(){
		this.style.background="#f4f4f4";
	}
	pmi[i].onmouseout = function(){
		this.style.background="";
	}
}
//客户服务
fuwu.onmouseover = function(){
	fuwuitem.style.display = "block";
	this.style.background = "#ffffff";
}
fuwu.onmouseout = function(){
	fuwuitem.style.display = "none";
	this.style.background = "";
}
//导航栏
daohang.onmouseover = function(){
	daohangbox.style.display = "block";
}
daohang.onmouseout = function(){
	daohangbox.style.display = "none";
}

/*地址修改*/
var adrArry = ['北京','上海','天津','重庆','河北','山西','河南','辽林','黑龙江','内蒙古','江苏','山东','安徽','浙江','福建',	
		'湖北','湖南','广东','广西','江西','四川','海南','贵州','云南','西藏','陕西','甘肃','青海','宁夏','新疆','港澳','台湾'];
var adrsite = document.getElementsByClassName("site");
var region = document.getElementsByClassName("region")[0];
var Twolevelmenu = document.getElementById("Two-level-menu");
var sitemenu = document.getElementsByClassName("site-nav-menu")[0];

var vue1 = new Vue({
	el:".menu",
	data:{
		address:"江苏",
	},
});
var vue2 = new Vue({
	el:".site-ul",
	methods:{
		adrChoose(i){
			vue1.address = adrArry[i-1];
		}
	}
});
for(var i = 0;i < adrsite.length; i++){
	adrsite[i].onmousemove = function(){
		this.style.background="#f4f4f4";
	}
	adrsite[i].onmouseout = function(){
		this.style.background="";
	}
}

//中国大陆
Twolevelmenu.onmouseover = function(){
	sitemenu.style.display ='block';
	this.style.background = '#FFFFFF';
}
Twolevelmenu.onmouseout = function() {
        sitemenu.style.display = "none";
    	this.style.background = '';
}