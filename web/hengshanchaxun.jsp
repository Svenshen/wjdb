<%-- 
    Document   : chaxun.jsp
    Created on : 2018-1-5, 8:33:50
    Author     : Administrator
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Beans.hengshan.chaxun"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
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
        <h2 align="center">横扇邮件预警</h2>
    </body>
    
    <%
    
        chaxun c = new chaxun();
        ArrayList<chaxun> shuju = c.getShuju();%>
    
         <table border=1 borderColorDark=#000000 borderColorLight=#000000 cellPadding=1 cellSpacing=0 align="center" id="dat">
            <tr>
                <th>
                    序号
                </th>
                <th>
                    邮件号
                </th>
                <th>
                    收寄日期
                </th>
                <th>
                    寄达省
                </th>
                <th>
                    寄达市
                </th>
                <th>
                    异常原因
                </th>
                <th>
                    最后状态信息
                </th>
            </tr>
    <%
        int i =0;
        for(chaxun s:shuju){
            
            out.println("<tr>");
            out.println("<td>");
            out.println(++i);
            out.println("</td>");
            out.println("<td>");
            out.println(s.getMail());
            out.println("</td>");
            out.println("<td>");
            out.println(s.getShoujiriqi());
            out.println("</td>");
            out.println("<td>");
            out.println(s.getJidasheng());
            out.println("</td>");
            out.println("<td>");
            out.println(s.getJidashi());
            out.println("</td>");
            out.println("<td>");
             out.println(s.getYichangyuanyin());
            out.println("</td>");
            out.println("<td>");
            out.println(s.getZuizhongzhuangtai());
            out.println("</td>");
            out.println("</tr>");
        }
        
        
    %>
    </table>
</html>
