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