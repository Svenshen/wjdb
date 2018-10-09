<%-- 
    Document   : genzong
    Created on : 2015-9-6, 13:41:09
    Author     : Administrator
--%>

<%@page import="Beans.genzong.mingxi"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Beans.genzong.yujing"%>
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
        if(request.getParameter("do") != null){
                    kshijian = request.getParameter("kshijian");
                    //kshijian2 = request.getParameter("kshijian2");
                    jshijian = request.getParameter("jshijian");
                    //jshijian2 = request.getParameter("jshijian2");
                   
        }
    %>
     <div style="text-align:center;clear:both"><br>
    <form action="genzong.jsp?act=<%out.print(request.getParameter("act"));%>" name="chaxun" method="post">
        <input type="hidden" name="do" value="<%out.print(request.getParameter("act"));%>"/>
    <table align="center">
        <tr>
            <%
         if("yujing".equals(request.getParameter("act")) ){
            %>
            <th>收寄日期</th>
        <td>开始时间：<input class="Wdate" type="text" name="kshijian" onClick="WdatePicker()" size="13" value="<%out.print(kshijian);%>"/></td>
         <td>结束时间：<input class="Wdate" type="text" name="jshijian" onClick="WdatePicker()" size="13" value="<%out.print(jshijian);%>"/></td>
            <td><input type="submit"  value="查询"/></td>
            <%
         }else if("mingxi".equals(request.getParameter("do"))){
         %>
            <td><input type="button" id="copy" value="导出到Excel" onclick="copyToExcel('dat')"/></td>
            <%}%>
        </tr>
        <tr>
            <td></td>
        </tr>
    </table>
   
    </form>
    <table border=1 borderColorDark=#000000 borderColorLight=#000000 cellPadding=1 cellSpacing=0 align="center" id="dat">
               
    <%
    //request.setCharacterEncoding("gbk");
    if("yujing".equals(request.getParameter("do")) ){
           %>
           <tr>
               <th>
                   机构名
               </th>
               <th>
                   机构号
               </th>
               
               <th>
                   标准快递
               </th>
               <th>
                   包裹和经济
               </th>
           </tr>
           <%
       
           yujing yu = new yujing();
           
           ArrayList<yujing> al = yu.getyujing(kshijian.replace("-", ""), jshijian.replace("-", ""));
           for(yujing y : al){
               out.println("<tr>");
               out.println("<td>"+y.getorgname()+"</td>");
               out.println("<td>"+y.getjigouhao()+"</td>");
               out.println("<td><a href = 'genzong.jsp?do=mingxi&kind=biaozhun&jigou="+y.getjigouhao()+"&kshijian="+kshijian+"&jshijian="+jshijian+"'>"+y.getbiaozhunnum()+"</a></td>");
               out.println("<td><a href ='genzong.jsp?do=mingxi&kind=jingji&jigou="+y.getjigouhao()+"&kshijian="+kshijian+"&jshijian="+jshijian+"'>"+y.getjingjinum()+"</a></td>");
               out.println("</tr>");
           }
    }else if ("mingxi".equals(request.getParameter("do"))){
        %>
        <tr>
               <th>
                   客户号
               </th>
               <th>
                   机构名
               </th>
                <th>
                   邮件号
               </th>
               <th>
                   实际时长
               </th>
               <th>
                   标准时长
               </th>
               <th>
                   寄达省
               </th>
           </tr>
        <%
        if("biaozhun".equals(request.getParameter("kind"))){
            mingxi m = new mingxi();
            ArrayList<mingxi> mx = m.getmingxi(kshijian.replace("-", ""), jshijian.replace("-", ""), request.getParameter("jigou"));
            for(mingxi mi:mx){
                out.println("<tr>");
               out.println("<td>"+mi.getdakehu()+"</td>");
               out.println("<td>"+mi.getjigou()+"</td>");
               out.println("<td>"+mi.getmailno()+"</td>");
               out.println("<td>"+mi.getdays()+"</td>");
               out.println("<td>"+mi.getbdays()+"</td>");
               out.println("<td>"+mi.getjidasheng()+"</td>");
               out.println("</tr>");
            }
    }else if ("jingji".equals(request.getParameter("kind"))){
            mingxi m = new mingxi();
            ArrayList<mingxi> mx = m.getmingxijingji(kshijian.replace("-", ""), jshijian.replace("-", ""), request.getParameter("jigou"));
            for(mingxi mi:mx){
                out.println("<tr>");
               out.println("<td>"+mi.getdakehu()+"</td>");
               out.println("<td>"+mi.getjigou()+"</td>");
               out.println("<td>"+mi.getmailno()+"</a></td>");
               out.println("<td>"+mi.getdays()+"</td>");
               out.println("<td>"+mi.getbdays()+"</td>");
               out.println("<td>"+mi.getjidasheng()+"</td>");
               out.println("</tr>");
            }
        }else if("biaozhunciri".equals(request.getParameter("kind"))){
            mingxi m = new mingxi();
            ArrayList<mingxi> mx = m.getmingxijingji(kshijian.replace("-", ""), jshijian.replace("-", ""), request.getParameter("jigou"));
            for(mingxi mi:mx){
                out.println("<tr>");
               out.println("<td>"+mi.getdakehu()+"</td>");
               out.println("<td>"+mi.getjigou()+"</td>");
               out.println("<td>"+mi.getmailno()+"</a></td>");
               out.println("<td>"+mi.getdays()+"</td>");
               out.println("<td>"+mi.getbdays()+"</td>");
               out.println("<td>"+mi.getjidasheng()+"</td>");
               out.println("</tr>");
            }
        }
    }
        %>
    </table>
</html>
