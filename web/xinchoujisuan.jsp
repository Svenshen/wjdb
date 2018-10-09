<%-- 
    Document   : sunyijisuan
    Created on : 2018-2-12, 16:18:58
    Author     : Administrator
--%>


<%@page import="Beans.Sunyi2.Web.Xinchou.Hengshanbili"%>
<%@page import="Beans.Sunyi2.Web.Xinchou.Xinchoushuju"%>
<%@page import="Beans.Sunyi2.Web.Xinchou.Xinchou"%>
<%@page import="Beans.Sunyi2.Web.Xinchou.Xinjian"%>
<%@page import="java.util.ArrayList"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>薪酬计算</title>
    </head>
    <body>
        <script src="jq.js"></script>
        <script language="javascript" type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>
        <link rel="stylesheet" href="css/jquery-ui.css"/>
        <script src="jquery-ui.js"></script>
        <script src="myjs.js"></script>

    </body>
    

    <%@include file="top_1.jsp" %>
     <div style="text-align:center;clear:both"><br>
    <form action="xinchoujisuan.jsp?act=<%out.print(request.getParameter("act"));%>" name="biaodan" method="post">
        <input type="hidden" name="do" value="<%out.print(request.getParameter("act"));%>"/>
        <%
        request.setCharacterEncoding("utf8"); 
        response.setCharacterEncoding("utf8");
        if("xinjian".equals(request.getParameter("act"))){
            
                %>
            <table align="center">
                    <tr>
                        <td>类型：<select name="leixing" >
                            <option value="1">横扇薪酬</option>
                            <option value="2">横扇薪酬2018</option>
                            <option value="3">横扇薪酬2018全</option>
                        </select></td>
                        <td>备注：<input  type="text" name="beizhu" size="13" value=""/></td>
                        <td>计算开始时间：<input class="Wdate" type="text" name="kshijian" onClick="WdatePicker()" size="13" value=""/></td>
                        <td>计算结束时间：<input class="Wdate" type="text" name="jshijian" onClick="WdatePicker()" size="13" value=""/></td>
                        <td><input type="submit"  value="新建任务"/></td>
                    </tr>
                    <tr>
                        <td colspan="4">注意不要同时跑同一时间段数据，即使算法不同，这仍可能会造成错误</td>
                    </tr>
                </table>
        <%
                
        }
        else if("hengshan".equals(request.getParameter("act"))){
            if("chakan".equals(request.getParameter("dongzuo"))){
                %>
        <table border=1 borderColorDark=#000000 borderColorLight=#000000 cellPadding=1 cellSpacing=0 align="center" id="dat">
                    <tr>
                        <th>部门</th>
                        <th>件数</th>
                        <th>收入</th>
                        <th>成本</th>
                        <th>薪酬</th>
                        <th>明细</th>
                    </tr>
                    <%
                    Xinchou xinchou = new Xinchou();
                    ArrayList<Xinchoushuju> shuju = xinchou.getshujubyjigou(request.getParameter("id"));
            for(int i=0;i < shuju.size();i++){
                out.println("<tr>");
                         //out.println("<td><a href='sunyijisuan.jsp?act=guonei&id="+request.getParameter("id")+"&dongzuo=chakanbumen&bumen="+shuju.get(i).jigoudaima+"'>"+shuju.get(i).bumen+"</a></td>");
                         out.println("<td>"+shuju.get(i).jigoumingcheng+"</td>");
                         out.println("<td>"+shuju.get(i).jianshu+"</td>");
                         out.println("<td>"+shuju.get(i).xitongzifei+"</td>");
                         out.println("<td>"+shuju.get(i).shishouzifei+"</td>");
                         out.println("<td>"+shuju.get(i).butiejine+"</td>");
                         out.println("<td><a href='xinchoujisuan.jsp?act=hengshan&id="+request.getParameter("id")+"&bumen="+shuju.get(i).jigoudaima+"&dongzuo=chakanmingxi'>查看</a></td>");
                         
                         out.println("</tr>");
            }
                    %>
        </table>
        <%
            }else if("chakanmingxi".equals(request.getParameter("dongzuo"))){
                %>
        <table border=1 borderColorDark=#000000 borderColorLight=#000000 cellPadding=1 cellSpacing=0 align="center" id="dat">
                    <tr>
                        <th>邮件号</th>
                        <th>收寄日期</th>
                        <th>机构代码</th>
                        <th>机构名称</th>
                        <th>客户代码</th>
                        <th>客户</th>
                        <th>交易码</th>
                        <th>寄达省</th>
                        <th>寄达市</th>
                        <th>寄达地代码</th>
                        <th>邮件重量</th>
                        <th>标准资费</th>
                        <th>实收资费</th>
                        <th>公司成本</th>
                        <th>薪酬</th>
                        
                    </tr>
                    <%
                    Xinchou xinchou = new Xinchou();
                    ArrayList<Xinchoushuju> shuju = xinchou.getmingxibyidjigou(request.getParameter("id"),request.getParameter("bumen"));
            for(int i=0;i < shuju.size();i++){
                out.println("<tr>");
                         //out.println("<td><a href='sunyijisuan.jsp?act=guonei&id="+request.getParameter("id")+"&dongzuo=chakanbumen&bumen="+shuju.get(i).jigoudaima+"'>"+shuju.get(i).bumen+"</a></td>");
                         out.println("<td>"+shuju.get(i).youjianhao+"</td>");
                         out.println("<td>"+shuju.get(i).shoujiriqi+"</td>");
                         out.println("<td>"+shuju.get(i).jigoudaima+"</td>");
                         out.println("<td>"+shuju.get(i).jigoumingcheng+"</td>");
                         out.println("<td>"+shuju.get(i).kehudaima+"</td>");
                         out.println("<td>"+shuju.get(i).kehumingcheng+"</td>");
                         out.println("<td>"+shuju.get(i).jiaoyima+"</td>");
                         out.println("<td>"+shuju.get(i).jidasheng+"</td>");
                         out.println("<td>"+shuju.get(i).jidashi+"</td>");
                         out.println("<td>"+shuju.get(i).jidadidaima+"</td>");
                         out.println("<td>"+shuju.get(i).youjianzhongliang+"</td>");
                         out.println("<td>"+shuju.get(i).biaozhunzifei+"</td>");
                         out.println("<td>"+shuju.get(i).xitongzifei+"</td>");
                         out.println("<td>"+shuju.get(i).shishouzifei+"</td>");
                         out.println("<td>"+shuju.get(i).butiejine+"</td>");
                         
                         out.println("</tr>");
            }
                    %>
        </table>
        <%
            }else if("del".equals(request.getParameter("dongzuo"))){
                Xinchou guoji = new Xinchou();
                guoji.del(request.getParameter("id"));
                response.sendRedirect("xinchoujisuan.jsp?act=hengshan");
            }else if("delbili".equals(request.getParameter("dongzuo"))){
                Xinchou guoji = new Xinchou();
                guoji.delhengshanbili(request.getParameter("id"));
                response.sendRedirect("xinchoujisuan.jsp?act=hengshanweihu");
            }
            else{
            %>
        <table border=1 borderColorDark=#000000 borderColorLight=#000000 cellPadding=1 cellSpacing=0 align="center" id="dat">
                    <tr>
                        <th>工作id</th>
                        <th>开始时间</th>
                        <th>结束时间</th>
                        <th>类型</th>
                        <th>状态</th>
                        <th>备注</th>
                        <th>操作</th>
                        <th colspan="2">数据</th>
                    </tr>
                    <%
            Xinchou xinchou = new Xinchou();
            ArrayList<Xinchou> shuju = xinchou.getHengshanShujulist();
            for(int i=0;i < shuju.size();i++){
                out.println("<tr>");
                         //out.println("<td><a href='sunyijisuan.jsp?act=guonei&id="+request.getParameter("id")+"&dongzuo=chakanbumen&bumen="+shuju.get(i).jigoudaima+"'>"+shuju.get(i).bumen+"</a></td>");
                         out.println("<td>"+shuju.get(i).gongzuoid+"</td>");
                         out.println("<td>"+shuju.get(i).kshijian+"</td>");
                         out.println("<td>"+shuju.get(i).jshijian+"</td>");
                         out.println("<td>"+shuju.get(i).leixing+"</td>");
                         out.println("<td>"+shuju.get(i).zhuangtai+"</td>");
                         out.println("<td>"+shuju.get(i).getBeizhu()+"</td>");
                         out.println("<td><a href='xinchoujisuan.jsp?act=hengshan&dongzuo=del&id="+shuju.get(i).gongzuoid+"'>删除</a></td>");
                         if("完成".equals(shuju.get(i).zhuangtai)){
                            out.println("<td><a href='xinchoujisuan.jsp?act=hengshan&id="+shuju.get(i).gongzuoid+"&dongzuo=chakan'>查看</a></td>");
                            out.println("<td><a href='DownloadServlet?act=xinchou&id="+shuju.get(i).gongzuoid+"&dongzuo=xiazai'>下载</a></td>");
                            
                         }else{
                             out.println("<td></td>");
                         }
                         out.println("</tr>");
            }
                    %>
        </table>
        <%
                    }
        }else if("hengshanweihu".equals(request.getParameter("act"))){
            %>
        <table align="center">
                    <tr>
                        <input type="hidden" name="hengshanweihudo" value="xinjian"/>
                        <td>开始时间：<input class="Wdate" type="text" name="kshijian" onClick="WdatePicker()" size="13" value=""/></td>
                        <td>结束时间：<input class="Wdate" type="text" name="jshijian" onClick="WdatePicker()" size="13" value=""/></td>
                        <td>薪酬比例：<input  type="text" name="bili" size="13" value=""/></td>
                        <td><input type="submit"  value="新建"/></td>
                    </tr>
                </table>
         <table border=1 borderColorDark=#000000 borderColorLight=#000000 cellPadding=1 cellSpacing=0 align="center" id="dat">
                    <tr>
                        
                        <th>开始时间</th>
                        <th>结束时间</th>
                        <th>薪酬比例</th>
                        <th>操作</th>
                    </tr>
        
        
        <%
            
            
            
            Xinchou xinchou = new Xinchou();
            ArrayList<Hengshanbili> shuju = xinchou.gethengshanbili();
            for(int i=0;i < shuju.size();i++){
                out.println("<tr>");
                         //out.println("<td><a href='sunyijisuan.jsp?act=guonei&id="+request.getParameter("id")+"&dongzuo=chakanbumen&bumen="+shuju.get(i).jigoudaima+"'>"+shuju.get(i).bumen+"</a></td>");
                         
                         out.println("<td>"+shuju.get(i).kshijian+"</td>");
                         out.println("<td>"+shuju.get(i).jshijian+"</td>");
                         out.println("<td>"+shuju.get(i).bili+"</td>");
                         out.println("<td><a href='xinchoujisuan.jsp?act=hengshan&dongzuo=delbili&id="+shuju.get(i).id+"'>删除</a></td>");
                         out.println("</tr>");
            }
            %></table><%
        }
          %>          
               
        
                
    </form>
     </div>
                            <%
        
        if("xinjian".equals(request.getParameter("do"))){
                
                Xinjian xinjian = new Xinjian(request.getParameter("kshijian"),request.getParameter("jshijian"),Integer.valueOf(request.getParameter("leixing")),new String(request.getParameter("beizhu").getBytes("iso-8859-1"),"utf8"));
                if(xinjian.tijiao()){
                    out.println("<Script Language=\"JavaScript\"> alert(\"提交成功\");window.history.back(); </Script>");
                }else{
                    out.println("<Script Language=\"JavaScript\"> alert(\"国内错误\");window.history.back(); </Script>");
                }
                
                
                
        }
        if("xinjian".equals(request.getParameter("hengshanweihudo"))){
            Xinchou xinchou = new Xinchou();
            if(xinchou.addhengshanbili(request.getParameter("kshijian"),request.getParameter("jshijian"),request.getParameter("bili"))){
                out.println("<Script Language=\"JavaScript\"> alert(\"提交成功\");window.history.back(); </Script>");
                }else{
                    out.println("<Script Language=\"JavaScript\"> alert(\"错误\");window.history.back(); </Script>");
                }
            
        }
   
    
    %>
                
</html>
