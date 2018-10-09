<%-- 
    Document   : a
    Created on : 2014-2-8, 12:25:52
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="GBK"%>
<link type="text/css" rel="stylesheet" href="css/NewDefault.css">
<style type="text/css">
body{}
.downMenu ul li a{color:white!important;font-size:14px;height:24px;letter-spacing:4px;border-bottom:1px solid #fff;border-left:none;border-right:none;}
#divDown2 ul li a{background:#EB8932;color:white!important;width:102px;}
#divDown2 ul li a:hover{background:#F6C370;color:#000!important;}
#divDown3 ul li a{background:#91BD41;color:white!important;width:78px;}
#divDown3 ul li a:hover{background:#B8DA6A;color:#000!important;}
#divDown4 ul li a{background:#FEA901;color:white!important;width:114px;}
#divDown4 ul li a:hover{background:#FDE374;color:#000!important;}
#divDown5 ul li a{background:#CA699C;color:white!important;width:115px;}
#divDown5 ul li a:hover{background:#DDA6BD;color:#000!important;}
</style>


<div id="navmaster">
	<ul>
		<li id="ctl01_liIndex" class="M1Common M1">
			<div style="padding-top:27px;"><a title=""  href="index.jsp">单号计算</a></div>
		</li>
		<li id="ctl01_liQCenter" class="M2Common M2">
			<div style="padding-top:44px;"><a title="量收" href="#">量收</a><span class="bordCss bordBottomCssN"></span></div>
		</li>
		<li id="ctl01_liPrice" class="M3Common M3">
			<div style="padding-top:32px;"><a style="padding:9px 0 0px 21px;" >邮件查询</a></span></div>
		</li>
		<li id="ctl01_liUseCase" class="M4Common M4">
			<div style="padding-top:23px;"><a href="#">邮件补贴损益</a><span class="bordCss bordBottomCssN"></span></div>
		</li>
		<li id="ctl01_liCustomer" class="M5Common M5">
			<div style="padding-top:37px;text-align:left;padding-left:14px;"><a style="" href="#">邮件预警</a></div>
		</li>
	</ul>
</div>


    
<!--下拉菜单2开始-->

<div id="divDown2" class="downMenu" pdleft="23" style="display:none;z-index:10999;position:absolute;">
	<ul>
		<li><a title="量收统计" href="liangshou1.jsp?act=tongji" style="border-top:1px solid #fff;">量收交易码</a> </li>
                <li><a title="量收统计" href="liangshou1.jsp?act=tongji2" style="border-top:1px solid #fff;">量收按代码</a> </li>
                <li><a title="73标快城市" href="liangshou1.jsp?act=shengji8xian">省际8线</a> </li>
		<li><a title="73标快城市" href="liangshou1.jsp?act=73biaokuai">62标快城市</a> </li>
		<li><a title="18邮航城市" href="liangshou1.jsp?act=18youhang">18邮航城市</a> </li>
		<li><a title="68经快城市" href="liangshou1.jsp?act=68jingji">68经快城市</a> </li>
                <li><a title="长三角路向" href="liangshou1.jsp?act=changsanjiao">长三角路向</a> </li>
                <li><a title="折扣率" href="liangshou1.jsp?act=zhekou">折扣率</a> </li>
                 <li><a title="经快A类线路" href="liangshou1.jsp?act=a10jingji">经快A类线路</a> </li>
                 <li><a title="成本计算" href="liangshou1.jsp?act=chengbenjisuan">成本计算</a> </li>
                 <li><a title="政企客户" href="liangshou1.jsp?act=zhengqi">政企客户</a> </li>
                 <li><a title="按客户量收汇总" href="liangshou1.jsp?act=sanhu">按揽投员客户量收汇总</a> </li>
	</ul>
</div>
                
<!--下拉菜单2结束--> 
    
<!--下拉菜单3开始-->

<div id="divDown3" class="downMenu" pdleft="23" style="display:none;z-index:10999;position:absolute;">
	<ul>
		<li><a title="大客户码" href="mingxi.jsp?act=dakehu" style="border-top:1px solid #fff;">大客户码</a> </li>
                <li><a title="机构码" href="mingxi.jsp?act=jigou" style="border-top:1px solid #fff;">机构码</a> </li>
                <li><a title="零资费" href="mingxi.jsp?act=ling" style="border-top:1px solid #fff;">零资费</a> </li>
                <li><a title="代投点" href="mingxi.jsp?act=daitoudian" style="border-top:1px solid #fff;">代投点</a> </li>
                <li><a title="按日期" href="mingxi.jsp?act=anriqibiaozhun" style="border-top:1px solid #fff;">按日期标准</a> </li>
		<!--<li><a title="产品新增" href="mingxi.jsp?act=jigou">机构代码</a> </li>
		<!--<li><a title="产品修改" href="#" target="_blank">产品修改</a> </li>
		<!--<li><a title="热门测评" href="#">热门测评</a> </li>-->
                <!---->
	</ul>
</div>
                
<!--下拉菜单3结束--> 
<!--下拉菜单4开始-->
<div id="divDown4" class="downMenu" pdleft="5" style="display:none;z-index:10999;left:933px;position:absolute;top:130px;">
	<ul>
		<!--<li><a title="外包录错明细采集" href="caiji.jsp?act=waibao" >外包录错采集</a> </li>-->
                <li><a title="最新信息查询" href="sunyi.jsp?act=chaxun" >最新信息查询</a> </li>
                <li><a title="国内损益查询" href="sunyi.jsp?act=guoneisunyi" >国内损益查询</a> </li>
                <li><a title="国际损益查询" href="sunyi.jsp?act=guojisunyi" >国际损益查询</a> </li>
                <!--
		<li><a title="报表" href="#">报表1</a></li>
		<li><a title="报表报表" href="#">报表1</a></li>
		<li><a title="报表" href="#">报表1</a></li>
		<li><a title="报表" href="#">报表1</a></li>-->
	</ul>
</div>
<!--下拉菜单4结束--> 
    <!--下拉菜单5开始-->
<div id="divDown5" class="downMenu" pdleft="5" style="display:none;z-index:10999;left:933px;position:absolute;top:130px;">
	<ul>
		<li><a title="预警查询" href="genzong.jsp?act=yujing" >预警查询</a> </li>
                <li><a title="苏州封发开拆对比" href="fengfa.jsp?act=suzhou" >封发开拆对比</a> </li>
                <li><a title="有封发无收寄" href="fengfa.jsp?act=nanji" >有封发无收寄</a> </li>
                <li><a title="进口妥投查询" href="fengfa.jsp?act=jinkoutuotou" >进口妥投查询</a> </li>
                <li><a title="出口妥投查询" href="fengfa.jsp?act=chukoutuotou" >出口妥投查询</a> </li>
                <li><a title="妥投率统计" href="fengfa.jsp?act=tuotoulv" >妥投率统计</a> </li>
                <!--
		<li><a title="报表" href="#">报表1</a></li>
		<li><a title="报表报表" href="#">报表1</a></li>
		<li><a title="报表" href="#">报表1</a></li>
		<li><a title="报表" href="#">报表1</a></li>-->
	</ul>
</div>
<script type="text/javascript">
var navmaster = document.getElementById("navmaster");
var lis = navmaster.getElementsByTagName("li");
var hrefas = navmaster.getElementsByTagName("a");
for (var i = 0; i < lis.length; i++) {
	lis[i].index = i + 1;
	if (lis[i].className.toLowerCase().indexOf("hover") > -1) {
		hoverLi(lis[i]);lis[i].isHover = true;
	}
	lis[i].onmouseover = function () {
		hoverLi(this); sb_setmenunav('divDown' + this.index, true, this);
	}
	lis[i].onmouseout = function () {
		sb_setmenunav('divDown' + this.index, false, this); unHoverLi(this);
	}
	lis[i].onclick = function () {
		var href = this.getElementsByTagName("a")[0].href;
		if (href)
			window.location = href;
	}

}
function getSpanByClassName(ele, className) {
	var spans = ele.getElementsByTagName("span");
	for (var i = 0; i < spans.length; i++) {
		var cName = spans[i].className || "";
		if (cName.toLowerCase() == className.toLowerCase()) {
			return spans[i];
		}
	}
}
function hoverLi(obj) {
	// obj.style.background = 'url(/images/MasterNew/menu_hover_ico' + obj.index + '.png) top left'; obj.style.color = '#fff';
	obj.className = "M" + obj.index + "Common M" + obj.index + "Hover";
	var dda = obj.getElementsByTagName("a")[0];
	//if(!dda.prevColor && dda.style.color!="#ffffff")dda.prevColor = dda.style.color;
	dda.style.color = "#ffffff";
	var span = getSpanByClassName(obj, "bordCss bordBottomCssN") || obj.spanCursor;
	if (span) {
		span.className = "bordCss bordBottomCssNF";
		obj.spanCursor = span;
	}
}
function unHoverLi(obj) {
	if (!obj.isHover) {
		obj.className = "M" + obj.index + "Common M" + obj.index;
		var dda = obj.getElementsByTagName("a")[0];
		dda.style.color = "";
		if (obj.spanCursor) obj.spanCursor.className = "bordCss bordBottomCssN";
	}
}
function openwindowSup(url, name, iWidth, iHeight) {

	var url;                                 //转向网页的地址;
	var name;                           //网页名称，可为空;
	var iWidth;                          //弹出窗口的宽度;
	var iHeight;                        //弹出窗口的高度;
	var iTop = (window.screen.availHeight + 30 - iHeight) / 2;       //获得窗口的垂直位置;
	var iLeft = (window.screen.availWidth + 208 - iWidth) / 2;           //获得窗口的水平位置;
	var param = 'height=' + iHeight + ',width=' + iWidth + ',top=' + iTop + ',left=' + iLeft + ',border=no,toolbar=no,menubar=no,scrollbars=no,resizable=yes,location=no,status=no';
	var o = window.open(url, name, param);
	o.focus();
}

function getCoordsNav(el) {
	var box = el.getBoundingClientRect(),
	doc = el.ownerDocument,
	body = doc.body,
	html = doc.documentElement,
	clientTop = html.clientTop || body.clientTop || 0,
	clientLeft = html.clientLeft || body.clientLeft || 0,
	top = box.top + (self.pageYOffset || html.scrollTop || body.scrollTop) - clientTop,
	left = box.left + (self.pageXOffset || html.scrollLeft || body.scrollLeft) - clientLeft
	return { 'top': top, 'left': left };
};
function sb_setmenunav(name, vis, obj) {
	var d = document.getElementById(name); //要显示隐藏的div
	if (!d) return;
	var padLeft = parseInt(d.getAttribute("pdLeft") || 0);
	if (vis) {
		if (d.timeArray) {
			window.clearTimeout(d.timeArray);
			d.timeArray = 0;
		}
		d.style.display = "block";
		if (!d.onmouseover) {
			d.onmouseover = function () {
				sb_setmenunav(name, true);
			}
			d.onmouseout = function () {
				sb_setmenunav(name, false);
				unHoverLi(obj);
			}
		}
		if (obj) {
			var objp = obj;
			if (objp.parentNode.tagName.toLowerCase() == "li")
				objp = obj.parentNode;
			var xy = getCoordsNav(objp);
			var xias = xy.left;
			//alert(d.offsetWidth);
			var yias = xy.top + objp.offsetHeight;
			padLeft = padLeft || 0;
			d.style.left = xias + padLeft + "px";
			d.style.top = yias + "px"; //;
			
		}
	}
	if (obj && obj.tagName.toLowerCase() == "li") {
		d.needSaveClass = obj;
		d.prevClass = obj.className;

	}
	else if (d.needSaveClass) {
		hoverLi(d.needSaveClass);
	}
	if (!vis) {//延时隐藏，可以移动上去
		if (d.spanCursor) d.spanCursor.className = "bordCss bordBottomCssN";
		d.timeArray = window.setTimeout(function () {
			d.style.display = "none"; d.style.height = "";
		}, 100);
	}
}
</script>

