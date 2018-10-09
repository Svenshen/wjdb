<%-- 
    Document   : index
    Created on : 2014-2-17, 9:23:28
    Author     : Administrator
--%>

<%@page import="Beans.caiji.Waibao"%>
<%@page import="Beans.liangshou.jingji10a"%>
<%@page import="Beans.liangshou.Shengji8xian"%>
<%@page import="Beans.liangshou.Biaokuai"%>
<%@page import="Beans.liangshou.Jingkuai"%>
<%@page import="Beans.liangshou.Youhang"%>
<%@page import="Beans.liangshou.Zhekou"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Beans.liangshou.Tongji"%>
<%@page import="Beans.MyLog"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script src="jq.js"></script>
<script language="javascript" type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>
<link rel="stylesheet" href="css/jquery-ui.css"/>
<script src="jquery-ui.js"></script>
<script>

  $(function() {
     
    $( "input[type=submit],input[type=button], button" )
      
      .button()
      /*
      .click(function( event ) {
        event.preventDefault();
      });
      */
  });
  function reset(tableid){
      
      var curTbl = document.getElementById(tableid);
      if(curTbl !== null){
        for(i=0;i<curTbl.cells.length;i++){
            curTbl.cells[i].innerHTML="";
            }
        }
  }
    function copyToExcel(tableid) {
    //控制按钮
    var btn = document.getElementById("copy");
   btn.setAttribute("disabled", "true");
    btn.setAttribute("value", "处理中...");

    var curTbl = document.getElementById(tableid);
    try {
        var oXL = new ActiveXObject("Excel.Application");
    }
    catch (e) {//IE安全级别未设置将出现错误 （ Automation 服务器不能创建对象  ）
        /*
        如果是Scripting.FileSystemObject (FSO 文本文件读写)被关闭了，开启FSO功能即可，在“运行”中执行regsvr32 scrrun.dll即可
        */
        alert("无法启动Excel!\n\n如果您确信您的电脑中已经安装了Excel，" + "那么请调整IE的安全级别。\n\n具体操作：\n\n" + "工具 → Internet选项 → 安全 → 自定义级别 → 对没有标记为安全的ActiveX进行初始化和脚本运行 → 启用");
        return false;
    }
    var oWB = oXL.Workbooks.Add();
    var oSheet = oWB.ActiveSheet;
    var sel = document.body.createTextRange();
    sel.moveToElementText(curTbl);
    sel.select();
    sel.execCommand("Copy");
    oSheet.Paste();
    oXL.Visible = true;
    var fname = oXL.Application.GetSaveAsFilename("收寄明细.xls", "Excel Spreadsheets (*.xls), *.xls");
    oWB.SaveAs(fname);
    oWB.Close();
    oXL.Quit();
    //控制按钮
    btn.removeAttribute("disabled");
   btn.setAttribute("value", "导出到Excel");
}
</script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
    </body>
    <%@include file="top.jsp" %>
    <%
        request.setCharacterEncoding("UTF-8");
        
        String kshijian = "";
        String kshijian2 = "";
        String jshijian = "";
        String jshijian2 = "";
        
        if(request.getParameter("do") != null){
                    kshijian = request.getParameter("kshijian");
                    kshijian2 = request.getParameter("kshijian2");
                    jshijian = request.getParameter("jshijian");
                    jshijian2 = request.getParameter("jshijian2");
        }
        
        //out.println(request.getParameter("action"));
    %>
    <div style="text-align:center;clear:both"><br>
    <form action="caiji.jsp?act=<%out.print(request.getParameter("act"));%>" name="waibao" method="post">
        
        <input type="hidden" name="do" value="<%out.print(request.getParameter("act"));%>"/>
        <table align="center">
            <tr>
                <%if("waibao".equals(request.getParameter("act"))){
                    %>
                    <td>邮件号：</td><td><input type="text" name="mailno" value=""/></td><td>必填</td>
                    
                
            </tr>
            <tr>
                <td >录错原因：</td><td><input type="text" name="yuanyin" value=""/></td><td>必填,如到付录成寄付,寄付录成到付</td>
                
            </tr>
            <tr>
                <td >采集员工：</td><td><input type="text" name="yuangong" value=""/></td><td>选填,用于奖励清分</td>
            </tr>
            <tr >
                <td colspan="2" align="center"><input type="submit" name="action" value="提交 " /></td>
            </tr>
            <%}%>
        </table>
    </form>
                    
        
               
    <%
    if("waibao".equals(request.getParameter("do")) ){
        Waibao wb = new Waibao();
        String s = wb.add(request.getParameter("mailno"), request.getParameter("yuanyin"), request.getParameter("yuangong"));
        out.println("<script>alert('"+s+"');</script>");
    }
    
    %>
                    
    </div>
</html>
