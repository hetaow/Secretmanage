/**
 *	author:朱磊
 *要使用此js文件.必须导入jQuery
**/
var win;
/**
*方法一:打开弹出窗口,弹出窗口会居中
*/
 function openWindow(id,tit,ww,wh){
     //只用传四个参数      id:映射的Div的ID
						//tit:窗口的标题
						//ww:外面window的宽
						//wh:外面Window的高
	var div=$("#"+id);
	context=div.html();
	div.empty();      
	win = new Ext.Window({title:tit,
						width:ww,              
						height:wh,			  
						modal:true,
						plain:true,
						constrain : true ,
						resizable:false,
						autoScroll: true,
						html:context
						});
   win.on("beforeclose",function(){div.html(context);});
   win.show();
}


/**
*方法二:打开弹出窗口,但是窗口会显示在触发openWindow事件的下方.
*
*/
function openWindow2(id,tit,ww,wh,eid){
//七个参数   id:映射的Div的ID
				//tit:窗口的标题
				//ww:外面window的宽
				//wh:外面Window的高
				//eid:弹出层需要接近元素的ID号
  var $input=$("#"+eid);
  var offset = $input.offset();
  var divtop = 1 + offset.top + document.getElementById(eid).offsetHeight;
  var divleft = offset.left ; 
	var div=$("#"+id);
	context=div.html();
	div.empty();        
	win = new Ext.Window({title:tit,
							width:ww,              
							height:wh,			  
							modal:true,
							resizable:false,
							autoScroll: true,
							html:context
							});
    win.setPagePosition(divleft,divtop);//设置Window的显示位置
    win.on("beforeclose",function(){div.html(context);});
	win.show();

}

/**
*关闭方法.
*/
 function closeWindow(){ 
	win.close();
}



