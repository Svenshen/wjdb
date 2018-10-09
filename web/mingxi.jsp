<%-- 
    Document   : index
    Created on : 2014-2-17, 9:23:28
    Author     : Administrator
--%>

<%@page import="Beans.mingxi.chaxun"%>
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
      //if(curTbl !== null){
        for(i=0;i<curTbl.cells.length;i++){
            curTbl.cells[i].innerHTML="";
            }
        //}
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
        //String kshijian2 = "";
        String jshijian = "";
        //String jshijian2 = "";
        String dakehu = "";
        if(request.getParameter("do") != null){
                    kshijian = request.getParameter("kshijian");
                    //kshijian2 = request.getParameter("kshijian2");
                    jshijian = request.getParameter("jshijian");
                    //jshijian2 = request.getParameter("jshijian2");
                    dakehu = request.getParameter("dakehu");
        }
        
        //out.println(request.getParameter("action"));
    %>
    <div style="text-align:center;clear:both"><br>
    <form action="mingxi.jsp?act=<%out.print(request.getParameter("act"));%>" name="chaxun" method="post">
        
        <input type="hidden" name="do" value="<%out.print(request.getParameter("act"));%>"/>
        <table align="center">
            <tr>
                <%if("dakehu".equals(request.getParameter("act"))){
                    %>
                    <td>大客户代码：<input type="text" name="dakehu" value="<%out.print(dakehu);%>"/></td>
                <%}
                if("jigou".equals(request.getParameter("act"))){
                %>
                <td>机构代码:<input type="text" name="jigou" value=""/></td>
                <%}
                %>
                <td>开始时间：<input class="Wdate" type="text" name="kshijian" onClick="WdatePicker()" size="13" value="<%out.print(kshijian);%>"/></td>
                <td>结束时间：<input class="Wdate" type="text" name="jshijian" onClick="WdatePicker()" size="13" value="<%out.print(jshijian);%>"/></td>
                <td><input type="submit"  value="查询"/></td>
                <td><input type="button" id="copy" value="导出到Excel" onclick="copyToExcel('dat')"/></td>
            </tr>
        </table>
    </form>
        <table border=1 borderColorDark=#000000 borderColorLight=#000000 cellPadding=1 cellSpacing=0 align="center" id="dat">
               
    <%
    //request.setCharacterEncoding("gbk");
    if("dakehu".equals(request.getParameter("do")) || "jigou".equals(request.getParameter("do")) || "ling".equals(request.getParameter("do")) || "anriqibiaozhun".equals(request.getParameter("do"))){
           %>
           
               <tr>
                   <th>
                       邮件号
                   </th>
                   <th>
                       大客户代码
                   </th>
                   <th>
                       寄件人
                   </th>
                   <th>
                       机构
                   </th>
                   <th>
                       收寄时间
                   </th>
                   <th>
                       省
                   </th>
                   <th>
                       市
                   </th>
                   <th>
                       收件人
                   </th>
                   <th>
                       收件地址
                   </th>
                   <th>
                       重量
                   </th>
                   <th>
                       实收费用
                   </th>
                   <th>
                       妥投状态
                   </th>
                   <th>
                       邮件种类
                   </th>
                   
               </tr>
           
    <%
    chaxun t = new chaxun();
    ArrayList<chaxun> al;
    if("dakehu".equals(request.getParameter("do")) ){
        //t.getMingxi(kshijian, jshijian);
        al  = t.getMingxi(request.getParameter("kshijian").replace("-", ""), request.getParameter("jshijian").replace("-", ""),request.getParameter("dakehu"));
    }else if("jigou".equals(request.getParameter("do"))){
       al  = t.getMingxibyjigou(request.getParameter("kshijian").replace("-", ""), request.getParameter("jshijian").replace("-", ""),request.getParameter("jigou"));
    }else if("anriqibiaozhun".equals(request.getParameter("do"))){
        al  = t.getAnriqibiaozhun(request.getParameter("kshijian").replace("-", ""), request.getParameter("jshijian").replace("-", ""));
       }else{
        al  = t.getLing(request.getParameter("kshijian").replace("-", ""), request.getParameter("jshijian").replace("-", ""));
    }
    for(int i = 0; i < al.size();i ++){
        out.print("<tr>");
        out.print("<td>"+al.get(i).getMailno() +"</td>");
        out.print("<td>"+al.get(i).getDakehudaima()+"</td>");
        out.print("<td>"+al.get(i).getSendername()+"</td>");
        out.print("<td>"+al.get(i).getJigou()+"</td>");
         out.print("<td>"+al.get(i).getShoujishijian()+"</td>");
        out.print("<td>"+al.get(i).getSheng()+"</td>");
        out.print("<td>"+al.get(i).getShi() +"</td>");
        out.print("<td>"+al.get(i).getShoujianren()+"</td>");
        out.print("<td>"+al.get(i).getShoujiandizhi()+"</td>");
        out.print("<td>"+al.get(i).getZhongliang() +"</td>");
        out.print("<td>"+al.get(i).getShishou()+"</td>");
        out.print("<td>"+al.get(i).getTuotou()+"</td>");
        out.print("<td>"+al.get(i).getZhonglei()+"</td>");
        
        out.print("</tr>");
               }
    }    
    
    %>

           </table>
   
    </div>
</html>
