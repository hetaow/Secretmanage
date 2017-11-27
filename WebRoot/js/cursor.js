/*
 * 聚光标
 */

var  highlightcolor='#E6FFFA';
//此处clickcolor只能用win系统颜色代码才能成功,如果用#xxxxxx的代码就不行,还没搞清楚为什么:(
var  clickcolor='#51b2f6';
function  changeto(){
source=event.srcElement;
if  (source.tagName=="TR"||source.tagName=="TABLE")
return;
while(source.tagName!="TD")
source=source.parentElement;
source=source.parentElement;
cs  =  source.children;
//alert(cs.length);
if  (cs[1].style.backgroundColor!=highlightcolor&&source.id!="nc"&&cs[1].style.backgroundColor!=clickcolor)
for(i=0;i<cs.length;i++){
	cs[i].style.backgroundColor=highlightcolor;
}
}

function  changeback(){
if  (event.fromElement.contains(event.toElement)||source.contains(event.toElement)||source.id=="nc")
return
if  (event.toElement!=source&&cs[1].style.backgroundColor!=clickcolor)
//source.style.backgroundColor=originalcolor
for(i=0;i<cs.length;i++){
	cs[i].style.backgroundColor="";
}
}

function  clickto(){
source=event.srcElement;
if  (source.tagName=="TR"||source.tagName=="TABLE")
return;
while(source.tagName!="TD")
source=source.parentElement;
source=source.parentElement;
cs  =  source.children;
//alert(cs.length);
if  (cs[1].style.backgroundColor!=clickcolor&&source.id!="nc")
for(i=0;i<cs.length;i++){
	cs[i].style.backgroundColor=clickcolor;
}
else
for(i=0;i<cs.length;i++){
	cs[i].style.backgroundColor="";
}
}

function allSelect(){
	var input = $("table input");
	for(i=0;i<input.length;i++){
		alert(input[i]);
	}
	
}


//全选
function allCheck(){
	var oCheck=document.getElementById("myForm").liuyan1;
	var oCheck1=document.getElementById("myForm").chbox;
	for(i=0;i<oCheck.length;i++){
		if(oCheck1.checked){
			oCheck[i].checked=true;
		}else{
			oCheck[i].checked=false;
		}
	}

}

// 双击某一行。则行前面对应的复选框选中或取消  author:朱磊
function sel(id){
	var i =$("#"+id);
	if(i.attr('checked')==undefined){
		i.attr('checked',true);
	}else{
		i.removeAttr('checked');
	}

}
//检查当前有没有复选框是选中的,有选中的则返回true   author:朱磊
function checkSel(){
	if($("input[checked]").length>0){
		return true;
	}else{
		return false;
	}
}
