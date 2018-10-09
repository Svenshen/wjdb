<%-- 
    Document   : index
    Created on : 2014-2-17, 9:23:28
    Author     : Administrator
--%>

<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="Beans.index.index"%>
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
</script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
    </body>
    <%@include file="top.jsp" %>
    <div style="text-align:center;clear:both"><br>
        <form action="index.jsp" name="test" method="post" >
        <input type="hidden" name="do" value="query"/>
        <table align="center">
            <tr>
                <td>
                    邮件号:<input type="text" name="mail"/>
                </td>
                <td>向前个数：<input type="text" name="qian" value="10"/></td>
                <td>向后个数: <input type="text" name="hou" value="10"/></td>
                <td>
                    <input type="submit" value="查询" />
                </td>
            </tr>
        </table>
    </form>
    
    <%
    request.setCharacterEncoding("gbk");
    if("query".equals(request.getParameter("do"))){
        %>
         <table border=1 borderColorDark=#000000 borderColorLight=#000000 cellPadding=1 cellSpacing=0 align="center" id="dat">
    <%
           index ii = new index();
           HashMap<String,List> qianhou = ii.getDate(request.getParameter("mail"), request.getParameter("qian"), request.getParameter("hou"));
           out.print("<tr>");
           out.print("<th>");
           out.print("邮件号");
           out.print("</th>");
           out.print("<th>");
           out.print("收寄机构");
           out.print("</th>");
           out.print("<th>");
           out.print("邮件号");
           out.print("</th>");
           out.print("<th>");
           out.print("收寄机构");
           out.print("</th>");
           
           out.print("</tr>");
           List<index> qian = qianhou.get("qian");
           List<index> hou = qianhou.get("hou");
           if(qian.size() > hou.size()){
               for(int i = 0; i < qian.size();i++){
               out.print("<tr>");
               out.print("<td>");
               out.print(qian.get(i).getMailno());
               out.print("</td>");
               out.print("<td>");
               out.print(qian.get(i).getOrgsname());
               out.print("</td>");
               if(i >= hou.size()){
                out.print("<td>");
                out.print("");
                out.print("</td>");
                out.print("<td>");
                out.print("");
                out.print("</td>");
               }else{
                   out.print("<td>");
                    out.print(hou.get(i).getMailno());
                    out.print("</td>");
                    out.print("<td>");
                    out.print(hou.get(i).getOrgsname());
                    out.print("</td>");
               }
               out.print("</tr>");
            }   
           }else{
               for(int i = 0; i < hou.size();i++){
               out.print("<tr>");
               
               if(i >= qian.size()){
                out.print("<td>");
                out.print("");
                out.print("</td>");
                out.print("<td>");
                out.print("");
                out.print("</td>");
               }else{
                   out.print("<td>");
                    out.print(qian.get(i).getMailno());
                    out.print("</td>");
                    out.print("<td>");
                    out.print(qian.get(i).getOrgsname());
                    out.print("</td>");
               }
               out.print("<td>");
               out.print(hou.get(i).getMailno());
               out.print("</td>");
               out.print("<td>");
               out.print(hou.get(i).getOrgsname());
               out.print("</td>");
               out.print("</tr>");
            } 
           }
            
%>
        </table>
    <%               
       }
    %>
    
    </div>
</html>
