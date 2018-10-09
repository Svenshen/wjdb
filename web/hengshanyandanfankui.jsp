<%-- 
    Document   : hengshanyandanfankui
    Created on : 2018-1-15, 9:47:24
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>横扇</title>
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
        
    </body>
    <div style="text-align:center;clear:both"><br>
        已开验单登记
        <form action="yikaiyandan" method="post">
            <table align="center">
                <tr>
                    <td>邮件号</td>
                    <td>
                        <textarea rows="20" cols="30" wrap="hard" name="youjianhao"></textarea>
                    </td>
                    
                </tr>
                 <tr>
                    <td>员工</td>
                    <td><select name="yuangong">
                            <option value="客服">客服</option>
                            <option value="黄建亚">黄建亚</option>
                            <option value="马婷钰">马婷钰</option>
                            <option value="姚敏">姚敏</option>
                            <option value="彭凤娟">彭凤娟</option>
                            <option value="苏情">苏情</option>
                        </select></td>
                </tr>
                <tr>
                    <td><input type="hidden" value="已开工单" name="leixing"></td>
                    <td><input type="submit" value="提交" /></td>
                </tr>
            </table>
        </form>

    
    </div>
</html>
