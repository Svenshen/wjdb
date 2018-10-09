<%-- 
    Document   : hengshanfankuitongji
    Created on : 2018-1-15, 14:55:50
    Author     : Administrator
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Beans.hengshan.fankuichaxun"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>横扇反馈</title>
    </head>
    <script language="javascript" type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>
    <link rel="stylesheet" href="css/jquery-ui.css"/>
    <script src="jquery-ui.js"></script>
    <table align="center">
            <tr>
                <td>
                    <a href="hengshanchaxun.jsp">邮件数据查询</a>
                </td>
                <td><a href="hengshanyandanfankui.jsp">已开工单反馈</a></td>
                <td><a href="hengshanyichangfankui.jsp">异常反馈</a></td>
                <td><a href="hengshanfankuitongji.jsp">反馈数据统计</a></td>
            </tr>
        </table>
    <body>
        <h1></h1>
    </body>
     <form action="hengshanfankuitongji.jsp?act=tongji" name="chaxun" method="post">
        <table align="center">
            <tr>
                
                <td>开始时间：<input class="Wdate" type="text" name="kshijian" onClick="WdatePicker()" size="13" value=""/></td>
                <td>结束时间：<input class="Wdate" type="text" name="jshijian" onClick="WdatePicker()" size="13" value=""/></td>
                <td><input type="submit"  value="查询"/></td>
                
            </tr>
        </table>
    </form>
     <%if("tongji".equals(request.getParameter("act"))){
          String kshijian = request.getParameter("kshijian");
                    //kshijian2 = request.getParameter("kshijian2");
                    String jshijian = request.getParameter("jshijian");
         %>
          <table border=1 borderColorDark=#000000 borderColorLight=#000000 cellPadding=1 cellSpacing=0 align="center" id="dat">
             <tr>
                 <td>邮件号</td>
                 <td>类型</td>
                 <td>员工</td>
                 <td>时间</td>
             </tr>
             <%
             fankuichaxun fankui = new fankuichaxun();
             ArrayList <fankuichaxun> chaxun  = fankui.getshuju(kshijian, jshijian);
             for(fankuichaxun c:chaxun){
                 out.println("<tr>");
                 out.println("<td>");
                 out.println(c.mailno);
                 out.println("</td>");
                 out.println("<td>");
                 out.println(c.leixing);
                 out.println("</td>");
                 out.println("<td>");
                 out.println(c.yuangong);
                 out.println("</td>");
                 out.println("<td>");
                 out.println(c.shijian);
                 out.println("</td>");
                 out.println("</tr>");
             }
             %>
         </table>
         <%
     }%>
</html>
