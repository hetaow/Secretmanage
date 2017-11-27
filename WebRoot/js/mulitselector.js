
/*!
 * jQuery JavaScript Library v 1.0 beta1
 * http://llhdf.javaeye.com
 *
 */

	var ms_html;
	function mulitselector(id,ht) { 
		if(ms_html!=null){return false;}
		var $input = $("#"+id);
		var offset = $input.offset();
		var divtop = 1 + offset.top + document.getElementById(id).offsetHeight + 'px';
		var divleft = offset.left + 'px';
		var html = [];	

		html.push('<div id="mulitSelector" style="display:block; top:'+divtop+';left:'+divleft+'; position: absolute; z-index: 1999;">');
		html.push('    <div id="pslayer"   class="alert_div sech_div ms_width">');
		html.push('				<div class="sech_layb"  style="background:#e4ecf3">  ');
	   html.push('<select name="select" size="5" id="select" style="width:100%;border:0" onmouseout="non();" 		                  ondblclick="ad(this)";multiple="multiple">');
       html.push(' <option selected="selected" value="品冠">品冠&lt;hello@sina.com&gt;</option>');
	   html.push(' <option value="黄磊">黄磊&lt;hello@sina.com&gt;</option>');
	   html.push(' <option value="朱磊">朱磊&lt;hello@sina.com&gt;</option>');
	   html.push(' <option value="KO">KO&lt;hello@sina.com&gt;</option>');
	   html.push(' <option value="KO">KO&lt;hello@sina.com&gt;</option>');
	   html.push('</select>');
		html.push('				</div>');
		html.push('   </div>');
		html.push('</div>');
		
		ms_html = $(html.join("")).appendTo('body');
}

	function non() {
		if(ms_html!=null){
			ms_html.remove();
			ms_html=null;
		}
	}





