<%-- 
    Document   : sunyijisuan
    Created on : 2018-2-12, 16:18:58
    Author     : Administrator
--%>

<%@page import="Beans.Sunyi2.Web.Sunyi.Guojishuju"%>
<%@page import="Beans.Sunyi2.Web.Sunyi.Guoneishujubyjigou"%>
<%@page import="Beans.Sunyi2.Web.Sunyi.Guoji"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Beans.Sunyi2.Web.Sunyi.Guonei"%>
<%@page import="Beans.Sunyi2.Web.Sunyi.Xinjian"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>损益计算</title>
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
    <form action="sunyijisuan.jsp?act=<%out.print(request.getParameter("act"));%>" name="biaodan" method="post">
        <input type="hidden" name="do" value="<%out.print(request.getParameter("act"));%>"/>
        <%
        if("xinjian".equals(request.getParameter("act"))){
            
                %>
            <table align="center">
                    <tr>
                        <td>类型：<select name="leixing">
                            <option value="1">国内</option>
                            <option value="2">国际</option>
                           
                        </select></td>
                        <td>客户代码：<input  type="text" name="kehu"  size="13" value=""/></td>
                        <td>备注：<input  type="text" name="beizhu"  size="13" value=""/></td>
                        <td>计算开始时间：<input class="Wdate" type="text" name="kshijian" onClick="WdatePicker()" size="13" value=""/></td>
                        <td>计算结束时间：<input class="Wdate" type="text" name="jshijian" onClick="WdatePicker()" size="13" value=""/></td>
                        <td><input type="submit"  value="新建任务"/></td>
                    </tr>
                </table>
        <%
                
        }else if("guonei".equals(request.getParameter("act"))){
            if("chakan".equals(request.getParameter("dongzuo"))){
                %>
                <table border=1 borderColorDark=#000000 borderColorLight=#000000 cellPadding=1 cellSpacing=0 align="center" id="dat">
                    <tr>
                        <th>部门</th>
                        <th>件数</th>
                        <th>收入</th>
                        <th>单册费</th>
                        <th>区内转趟</th>
                        <th>本地处理中心处理费</th>
                        <th>二干运费</th>
                        <th>省内处理</th>
                        <th>省际经转费</th>
                        <th>一干运费</th>
                        <th>进口省省内处理费</th>
                        <th>进口省二干运费</th>
                        <th>投递费</th>
                        <th>计件工资</th>
                        <th>全名址录入费</th>
                        <th>邮件明细</th>
                    </tr>
                    <%
                     Guonei guonei = new Guonei();
                     ArrayList<Guoneishujubyjigou> shuju = guonei.getshujubyjigou(request.getParameter("id"));
                     for(int i=0;i<shuju.size();i++){
                         out.println("<tr>");
                         //out.println("<td><a href='sunyijisuan.jsp?act=guonei&id="+request.getParameter("id")+"&dongzuo=chakanbumen&bumen="+shuju.get(i).jigoudaima+"'>"+shuju.get(i).bumen+"</a></td>");
                         out.println("<td>"+shuju.get(i).bumen+"</td>");
                         out.println("<td>"+shuju.get(i).jianshu+"</td>");
                         out.println("<td>"+shuju.get(i).shouru+"</td>");
                         out.println("<td>"+shuju.get(i).dance+"</td>");
                         out.println("<td>"+shuju.get(i).quneizhuantang+"</td>");
                         out.println("<td>"+shuju.get(i).bendichulizhongxinchulifei+"</td>");
                         out.println("<td>"+shuju.get(i).erganyunfei+"</td>");
                         out.println("<td>"+shuju.get(i).shengneichuli+"</td>");
                         out.println("<td>"+shuju.get(i).shengjijingzhuang+"</td>");
                         out.println("<td>"+shuju.get(i).yigan+"</td>");
                         out.println("<td>"+shuju.get(i).jinkoushengchulifei+"</td>");
                         out.println("<td>"+shuju.get(i).jinkoushengergan+"</td>");
                         out.println("<td>"+shuju.get(i).toudifei+"</td>");
                         out.println("<td>"+shuju.get(i).jijiangongzi+"</td>");
                         out.println("<td>"+shuju.get(i).quanmingzhi+"</td>");
                         out.println("<td><a href='sunyijisuan.jsp?act=guonei&id="+request.getParameter("id")+"&dongzuo=chakanmingxi&bumen="+shuju.get(i).jigoudaima+"'>查看</a></td>");
                         
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
                        <th>客户名称</th>
                        <th>产品</th>
                        <th>产品分类</th>
                        <th>是否热敏</th>
                        <th>邮件重量</th>
                        <th>系统资费</th>
                        <th>是否文件</th>
                        <th>邮件路向</th>
                        <th>寄达地代码</th>
                        <th>寄达省</th>
                        <th>寄达市</th>
                        <th>单册费</th>
                        <th>区内转趟</th>
                        <th>本地处理中心处理费</th>
                        <th>二干运费</th>
                        <th>省内处理</th>
                        <th>省际经转费</th>
                        <th>一干运费</th>
                        <th>进口省省内处理费</th>
                        <th>进口省二干运费</th>
                        <th>投递费</th>
                        <th>计件工资</th>
                        <th>全名址录入费</th>
                        
                    </tr>
                    <%
                Guonei guonei = new Guonei();
                ArrayList<Guoneishujubyjigou> shuju = guonei.getmingxibyidjigou(request.getParameter("id"),request.getParameter("bumen"));    
                for(int i=0;i<shuju.size();i++){
                        out.println("<tr>");
                        out.println("<td>"+shuju.get(i).mailno+"</td>");
                        out.println("<td>"+shuju.get(i).shoujiriqi+"</td>");
                        out.println("<td>"+shuju.get(i).jigoudaima+"</td>");
                        out.println("<td>"+shuju.get(i).jigoumingcheng+"</td>");
                        out.println("<td>"+shuju.get(i).kehudaima+"</td>");
                        out.println("<td>"+shuju.get(i).kehumingcheng+"</td>");
                        out.println("<td>"+shuju.get(i).chanpin+"</td>");
                        out.println("<td>"+shuju.get(i).chanpinfenlei+"</td>");
                        out.println("<td>"+shuju.get(i).isremin+"</td>");
                        out.println("<td>"+shuju.get(i).youjianzhongliang+"</td>");
                        out.println("<td>"+shuju.get(i).shouru+"</td>");
                        out.println("<td>"+shuju.get(i).iswentjian+"</td>");
                        out.println("<td>"+shuju.get(i).youjianluxiang+"</td>");
                        out.println("<td>"+shuju.get(i).jidadidaima+"</td>");
                        out.println("<td>"+shuju.get(i).jidasheng+"</td>");
                        out.println("<td>"+shuju.get(i).jidashi+"</td>");
                        
                         out.println("<td>"+shuju.get(i).dance+"</td>");
                         out.println("<td>"+shuju.get(i).quneizhuantang+"</td>");
                         out.println("<td>"+shuju.get(i).bendichulizhongxinchulifei+"</td>");
                         out.println("<td>"+shuju.get(i).erganyunfei+"</td>");
                         out.println("<td>"+shuju.get(i).shengneichuli+"</td>");
                         out.println("<td>"+shuju.get(i).shengjijingzhuang+"</td>");
                         out.println("<td>"+shuju.get(i).yigan+"</td>");
                         out.println("<td>"+shuju.get(i).jinkoushengchulifei+"</td>");
                         out.println("<td>"+shuju.get(i).jinkoushengergan+"</td>");
                         out.println("<td>"+shuju.get(i).toudifei+"</td>");
                         out.println("<td>"+shuju.get(i).jijiangongzi+"</td>");
                         out.println("<td>"+shuju.get(i).quanmingzhi+"</td>");        
                            
                    out.println("</tr>");
                }    
                    %>
        </table>
        <%
            }else if("del".equals(request.getParameter("dongzuo"))){
                Guonei guonei = new Guonei();
                guonei.del(request.getParameter("id"));
                response.sendRedirect("sunyijisuan.jsp?act=guonei");
            }
            else{
            %>
                <table border=1 borderColorDark=#000000 borderColorLight=#000000 cellPadding=1 cellSpacing=0 align="center" id="dat">
                    <tr>
                        <th>id</th>
                        <th>开始时间</th>
                        <th>结束时间</th>
                        <th>备注</th>
                        <th>状态</th>
                        <th>操作</th>
                        <th colspan="2">数据</th>
                    </tr>
                    
                        <%
                        Guonei guonei = new Guonei();
                        ArrayList<Guonei> g = guonei.getShujulist();
                        for(int i = 0;i < g.size();i++){
                            out.println("<tr>");
                            out.println("<td>");
                            out.println(g.get(i).gongzuoid);
                            out.println("</td>");
                            out.println("<td>");
                            out.println(g.get(i).kshijian);
                            out.println("</td>");
                            out.println("<td>");
                            out.println(g.get(i).jshijian);
                            out.println("</td>");
                            out.println("<td>");
                            out.println(g.get(i).getBeizhu());
                            out.println("</td>");
                            out.println("<td>");
                            out.println(g.get(i).zhuangtai);
                            out.println("</td>");
                            out.println("<td>");
                            out.println("<a href='sunyijisuan.jsp?act=guonei&dongzuo=del&id="+g.get(i).gongzuoid+"'>删除</a>");
                            out.println("</td>");
                            
                            if("完成".equals(g.get(i).zhuangtai)){
                                out.println("<td><a href='sunyijisuan.jsp?act=guonei&id="+g.get(i).gongzuoid+"&dongzuo=chakan'>查看</a></td>");
                                out.println("<td><a href='DownloadServlet?act=guoneisunyi&id="+g.get(i).gongzuoid+"&dongzuo=xiazai'>下载</a></td>");
                            }
                            
                            
                            out.println("<tr>");
                        }
            }
                        %>
                    
                </table>
        <%
        }else if("guoji".equals(request.getParameter("act"))){
            if("chakan".equals(request.getParameter("dongzuo"))){
                %>
                <table border=1 borderColorDark=#000000 borderColorLight=#000000 cellPadding=1 cellSpacing=0 align="center" id="dat">
                    <tr>
                        <th>部门</th>
                        <th>件数</th>
                        <th>收入</th>
                        
                        <th>区内转趟</th>
                        <th>本地处理中心处理费</th>
                        <th>互换局处理费</th>
                        <th>验关费</th>
                        <th>经转局处理费</th>
                        <th>一干运费</th>
                        <th>国际航空费</th>
                        <th>国际终端费</th>
                        <th>tnt终端费</th>
                        <th>明细</th>
                    </tr>
                    <%
                    Guoji guoji = new Guoji();
                     ArrayList<Guojishuju> shuju = guoji.getshujubyjigou(request.getParameter("id"));
                     for(int i=0;i<shuju.size();i++){
                         out.println("<tr>");
                         //out.println("<td><a href='sunyijisuan.jsp?act=guonei&id="+request.getParameter("id")+"&dongzuo=chakanbumen&bumen="+shuju.get(i).jigoudaima+"'>"+shuju.get(i).bumen+"</a></td>");
                         out.println("<td>"+shuju.get(i).jigoumingcheng+"</td>");
                         out.println("<td>"+shuju.get(i).jianshu+"</td>");
                         out.println("<td>"+shuju.get(i).xitongzifei+"</td>");
                         out.println("<td>"+shuju.get(i).quneizhuantangfei+"</td>");
                         out.println("<td>"+shuju.get(i).bendichulifei+"</td>");
                         out.println("<td>"+shuju.get(i).huhuanjuchulifei+"</td>");
                         out.println("<td>"+shuju.get(i).yanguanfei+"</td>");
                         out.println("<td>"+shuju.get(i).jingzhuanjuchulifei+"</td>");
                         out.println("<td>"+shuju.get(i).yiganfei+"</td>");
                         out.println("<td>"+shuju.get(i).guojihangkongfei+"</td>");
                         out.println("<td>"+shuju.get(i).guojizhongduanfei+"</td>");
                         out.println("<td>"+shuju.get(i).tntzhongduanfei+"</td>");
                         out.println("<td><a href='sunyijisuan.jsp?act=guoji&id="+request.getParameter("id")+"&dongzuo=chakanmingxi&bumen="+shuju.get(i).jigoudaima+"'>查看</a></td>");
                         
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
                        <th>客户名称</th>
                        <th>产品</th>
                        <th>产品分类</th>
                        <th>是否热敏</th>
                        <th>邮件重量</th>
                        <th>收入</th>
                        <th>是否文件</th>
                        
                        <th>寄达地代码</th>
                        <th>寄达省</th>
                        <th>寄达市</th>
                        
                        <th>区内转趟</th>
                        <th>本地处理中心处理费</th>
                        <th>互换局处理费</th>
                        <th>验关费</th>
                        <th>经转局处理费</th>
                        <th>一干运费</th>
                        <th>国际航空费</th>
                        <th>国际终端费</th>
                        <th>tnt终端费</th>
                        
                    </tr>
                    <%
                Guoji guonei = new Guoji();
                ArrayList<Guojishuju> shuju = guonei.getmingxibyidjigou(request.getParameter("id"),request.getParameter("bumen"));    
                for(int i=0;i<shuju.size();i++){
                        out.println("<tr>");
                        out.println("<td>"+shuju.get(i).youjianhao+"</td>");
                        out.println("<td>"+shuju.get(i).shoujiriqi+"</td>");
                        out.println("<td>"+shuju.get(i).jigoudaima+"</td>");
                        out.println("<td>"+shuju.get(i).jigoumingcheng+"</td>");
                        out.println("<td>"+shuju.get(i).kehumaida+"</td>");
                        out.println("<td>"+shuju.get(i).kehumingcheng+"</td>");
                        out.println("<td>"+shuju.get(i).chanpin+"</td>");
                        out.println("<td>"+shuju.get(i).chanpinfenlei+"</td>");
                        out.println("<td>"+shuju.get(i).isremin+"</td>");
                        out.println("<td>"+shuju.get(i).youjianzhongliang+"</td>");
                        out.println("<td>"+shuju.get(i).xitongzifei+"</td>");
                        out.println("<td>"+shuju.get(i).iswenjian+"</td>");
                        out.println("<td>"+shuju.get(i).jidadidaima+"</td>");
                        out.println("<td>"+shuju.get(i).jidasheng+"</td>");
                        out.println("<td>"+shuju.get(i).jidashi+"</td>");
                        
                         out.println("<td>"+shuju.get(i).quneizhuantangfei+"</td>");
                         out.println("<td>"+shuju.get(i).bendichulifei+"</td>");
                         out.println("<td>"+shuju.get(i).huhuanjuchulifei+"</td>");
                         out.println("<td>"+shuju.get(i).yanguanfei+"</td>");
                         out.println("<td>"+shuju.get(i).jingzhuanjuchulifei+"</td>");
                         out.println("<td>"+shuju.get(i).yiganfei+"</td>");
                         out.println("<td>"+shuju.get(i).guojihangkongfei+"</td>");
                         out.println("<td>"+shuju.get(i).guojizhongduanfei+"</td>");      
                         out.println("<td>"+shuju.get(i).tntzhongduanfei+"</td>");   
                    out.println("</tr>");
                }
                
            }else if("del".equals(request.getParameter("dongzuo"))){
                Guoji guoji = new Guoji();
                guoji.del(request.getParameter("id"));
                response.sendRedirect("sunyijisuan.jsp?act=guoji");
            }
            
            else{
            %>
            <table border=1 borderColorDark=#000000 borderColorLight=#000000 cellPadding=1 cellSpacing=0 align="center" id="dat">
                    <tr>
                        <th>id</th>
                        <th>开始时间</th>
                        <th>结束时间</th>
                        <th>状态</th>
                        <th>备注</th>
                        <th>操作</th>
                        <th colspan="2">数据</th>
                    </tr>
                    
                        <%
                        Guoji guonei = new Guoji();
                        ArrayList<Guoji> g = guonei.getShujulist();
                        for(int i = 0;i < g.size();i++){
                            out.println("<tr>");
                            out.println("<td>");
                            out.println(g.get(i).gongzuoid);
                            out.println("</td>");
                            out.println("<td>");
                            out.println(g.get(i).kshijian);
                            out.println("</td>");
                            out.println("<td>");
                            out.println(g.get(i).jshijian);
                            out.println("</td>");
                            out.println("<td>");
                            out.println(g.get(i).beizhu);
                            out.println("</td>");
                            out.println("<td>");
                            out.println(g.get(i).zhuangtai);
                            out.println("</td>");
                            out.println("<td>");
                            out.println("<a href='sunyijisuan.jsp?act=guoji&dongzuo=del&id="+g.get(i).gongzuoid+"'>删除</a>");
                            out.println("</td>");
                            
                            if("完成".equals(g.get(i).zhuangtai)){
                                out.println("<td><a href='sunyijisuan.jsp?act=guoji&id="+g.get(i).gongzuoid+"&dongzuo=chakan'>查看</a></td>");
                                out.println("<td><a href='DownloadServlet?act=guojisunyi&id="+g.get(i).gongzuoid+"&dongzuo=xiazai'>下载</a></td>");
                            }
                            
                            
                            out.println("<tr>");
                        }
                        %>
                    
                </table>
        <%
        }
        }
        
                %>
                
    </form>
     </div>
                            <%
        request.setCharacterEncoding("utf8");
        response.setCharacterEncoding("utf8");
        if("xinjian".equals(request.getParameter("do"))){
            
            
                Xinjian xinjian = new Xinjian(request.getParameter("kshijian"),request.getParameter("jshijian"),Integer.valueOf(request.getParameter("leixing")),request.getParameter("kehu"),new String(request.getParameter("beizhu").getBytes("iso-8859-1"),"utf8"));
                
                if(xinjian.tijiao()){
                    out.println("<Script Language=\"JavaScript\"> alert(\"提交成功\");window.history.back(); </Script>");
                }else{
                    out.println("<Script Language=\"JavaScript\"> alert(\"国内错误\");window.history.back(); </Script>");
                }
                
                
                
        }
   
    
    %>
                
</html>
