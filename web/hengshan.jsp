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
        <title>横扇邮件预警</title>
    </head>
    <body>
        
    </body>

    <div style="text-align:center;clear:both"><br>
        
        <input type="hidden" name="do" value="query"/>
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
  

    
    </div>
</html>
