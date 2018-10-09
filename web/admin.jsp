<%-- 
    Document   : newjsp
    Created on : 2014-2-8, 10:09:00
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="GBK"%>
<!DOCTYPE html>
<html>
<head>
<title>系统登录</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<script src="jq.js"></script>
<style type="text/css">
<!--
table {  font-size: 10.5pt}
body {
	background-color: #FCFCFA;
	margin-top: 50px;
}
-->
</style>
<link href="css/site.css" rel="stylesheet" type="text/css">
<style type="text/css">
<!--
.STYLE1 {
	font-size: 14pt;
	font-weight: bold;
}
-->
</style>
</head>

<body text="#0099FF" leftmargin="0">
 <script type="text/javascript" >
	$(document).ready(function() {
// 使用 jQuery 异步提交表单
$('#login').submit(function() {
jQuery.ajax({
url: 'login.jsp',
data: $('#login').serialize(),
type: "POST",
beforeSend: function()
{  
//showLoader();
//$('#submitButton').hide();
//$('#editRealMsgImg').show();
},
success: function(data)
{
//hideLoader();
if(data.indexOf("false") > -1){
	alert("账户或密码错误");
}else if(data.indexOf("true") > -1){
	location.href="my.jsp";
}else{
	alert("出现未知错误");
}

//$('#editRealMsgImg').hide();
//$('#modifyButton').show();
//$('#realName').attr("disabled","true");
//$('#tel').attr("disabled","true");
}
});
return false;
});
});

  </script>
    
    
<table height="335"  border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td colspan="2"><span class="STYLE1">系统登录</span></td>
  </tr>
  <tr>
    <td width="401" height="155"><table width="293" height="156" border="0" align="center" cellpadding="0" cellspacing="0" background="images/login_03.jpg">
        <tr>
          <td width="350"><form id="login">
  <table width="264" border="0" cellspacing="0" cellpadding="0" align="center" bordercolorlight="#CCCCCC" bordercolordark="#FFFFFF">
    <tr> 
      <td width="80" height="30" align="right"><font color="#000000">用户名：</font></td>
      <td width="184"> <input type="text" name="username"> </td>
    </tr>
    <tr> 
      <td width="80" height="30" align="right"><font color="#000000">密　码：</font></td>
      <td width="184"> <input type="password" name="password"> </td>
    </tr>
    <tr> 
      <td height="25" colspan="2">&nbsp;</td>
    </tr>
  </table> 
    <div align="center">
        <input type="submit" class="input1" value="登陆">
      　<input type="reset" class="input1" value="重填">
    </div>
          </form></td>
        </tr>
    </table></td>
    <td width="282"><img src="images/login_04.jpg" width="282" height="155"></td>
  </tr>
  <tr>
    <td height="45" colspan="2"><img src="images/login_05.jpg" width="683" height="52"></td>
  </tr>
</table>
<p align="center">&nbsp;</p>
</body>
</html>

