<%-- 
    Document   : sunyijisuan
    Created on : 2018-2-12, 16:18:58
    Author     : Administrator
--%>



<%@page import="Beans.Sunyi2.Web.Butie.Anzhekoukehu"%>
<%@page import="Beans.Sunyi2.Web.Butie.Shengfen"%>
<%@page import="Beans.Sunyi2.Web.Butie.Anshouxuzhongkehu"%>
<%@page import="Beans.Butie.Anshouxuzhong"%>
<%@page import="Beans.Sunyi2.Web.Butie.Anjiankehu"%>
<%@page import="Beans.Sunyi2.Web.Butie.Fanlikehu"%>
<%@page import="Beans.Sunyi2.Web.Butie.Xinjian"%>
<%@page import="Beans.Sunyi2.Web.Butie.Youbankehu"%>
<%@page import="Beans.Sunyi2.Web.Butie.Butieshuju"%>
<%@page import="Beans.Sunyi2.Web.Butie.Butie"%>
<%@page import="java.util.ArrayList"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>补贴计算</title>
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
    <form action="xbutiejisuan.jsp?act=<%out.print(request.getParameter("act"));%>" name="biaodan" method="post">
        <input type="hidden" name="do" value="<%out.print(request.getParameter("act"));%>"/>
        <%
        request.setCharacterEncoding("UTF-8");
        //request.
        response.setCharacterEncoding("UTF-8");
        if("xinjian".equals(request.getParameter("act"))){
            
                %>
            <table align="center">
                    <tr>
                        <td>类型：<select name="leixing" >
                            <option value="1">邮伴补贴</option>
                            <option value="2">返利补贴</option>
                            <option value="3">按折扣补贴</option>
                            <option value="4">按首续重补贴</option>
                            <option value="5">按件补贴</option>
                            <option value="9">特殊补贴</option>
                        </select></td>
                         <td>备注：<input  type="text" name="beizhu" size="13" value=""/></td>
                        <td>计算开始时间：<input class="Wdate" type="text" name="kshijian" onClick="WdatePicker()" size="13" value=""/></td>
                        <td>计算结束时间：<input class="Wdate" type="text" name="jshijian" onClick="WdatePicker()" size="13" value=""/></td>
                        <td><input type="submit"  value="新建任务"/></td>
                    </tr>
                </table>
        <%
                
        }
        else if("youban".equals(request.getParameter("act"))){
            if("chakan".equals(request.getParameter("dongzuo"))){
                %>
        <table border=1 borderColorDark=#000000 borderColorLight=#000000 cellPadding=1 cellSpacing=0 align="center" id="dat">
                    <tr>
                        <th>部门</th>
                        <th>件数</th>
                        <th>系统收入</th>
                        <th>公司资费</th>
                        <th>补贴</th>
                        <th>明细</th>
                    </tr>
                    <%
                    Butie xinchou = new Butie();
                    ArrayList<Butieshuju> shuju = xinchou.getshujubyjigou(request.getParameter("id"));
            for(int i=0;i < shuju.size();i++){
                out.println("<tr>");
                         //out.println("<td><a href='sunyijisuan.jsp?act=guonei&id="+request.getParameter("id")+"&dongzuo=chakanbumen&bumen="+shuju.get(i).jigoudaima+"'>"+shuju.get(i).bumen+"</a></td>");
                         out.println("<td>"+shuju.get(i).jigoumingcheng+"</td>");
                         out.println("<td>"+shuju.get(i).jianshu+"</td>");
                         out.println("<td>"+shuju.get(i).xitongzifei+"</td>");
                         out.println("<td>"+shuju.get(i).shishouzifei+"</td>");
                         out.println("<td>"+shuju.get(i).butiejine+"</td>");
                         out.println("<td><a href='xbutiejisuan.jsp?act=youban&id="+request.getParameter("id")+"&bumen="+shuju.get(i).jigoudaima+"&dongzuo=chakanmingxi'>查看</a></td>");
                         
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
                        <th>系统资费</th>
                        <th>公司资费</th>
                        <th>补贴</th>
                        
                    </tr>
                    <%
                    Butie xinchou = new Butie();
                    ArrayList<Butieshuju> shuju = xinchou.getmingxibyidjigou(request.getParameter("id"),request.getParameter("bumen"));
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
                Butie guoji = new Butie();
                guoji.del(request.getParameter("id"));
                response.sendRedirect("xbutiejisuan.jsp?act=youban");
            }
            else{
            %>
        <table border=1 borderColorDark=#000000 borderColorLight=#000000 cellPadding=1 cellSpacing=0 align="center" id="dat">
                    <tr>
                        <th>工作id</th>
                        <th>开始时间</th>
                        <th>结束时间</th>
                        <th>类型</th>
                        <th>备注</th>
                        <th>状态</th>
                        <th>操作</th>
                        <th colspan="2">数据</th>
                    </tr>
                    <%
            Butie xinchou = new Butie();
            ArrayList<Butie> shuju = xinchou.getShujulist();
            for(int i=0;i < shuju.size();i++){
                out.println("<tr>");
                         //out.println("<td><a href='sunyijisuan.jsp?act=guonei&id="+request.getParameter("id")+"&dongzuo=chakanbumen&bumen="+shuju.get(i).jigoudaima+"'>"+shuju.get(i).bumen+"</a></td>");
                         out.println("<td>"+shuju.get(i).gongzuoid+"</td>");
                         out.println("<td>"+shuju.get(i).kshijian+"</td>");
                         out.println("<td>"+shuju.get(i).jshijian+"</td>");
                         out.println("<td>"+shuju.get(i).leixing+"</td>");
                         out.println("<td>"+shuju.get(i).getBeizhu()+"</td>");
                         out.println("<td>"+shuju.get(i).zhuangtai+"</td>");
                         out.println("<td><a href='xbutiejisuan.jsp?act=youban&dongzuo=del&id="+shuju.get(i).gongzuoid+"'>删除</a></td>");
                         if("完成".equals(shuju.get(i).zhuangtai)){
                            out.println("<td><a href='xbutiejisuan.jsp?act=youban&id="+shuju.get(i).gongzuoid+"&dongzuo=chakan'>查看</a></td>");
                            out.println("<td><a href='DownloadServlet?act=butie&id="+shuju.get(i).gongzuoid+"&dongzuo=xiazai'>下载</a></td>");
                         }else{
                             out.println("<td></td>");
                         }
                         out.println("</tr>");
            }
                    %>
        </table>
        <%
                    }
        }else if("youbanweihu".equals(request.getParameter("act"))){
            if("delyouban".equals(request.getParameter("dongzuo"))){
                Butie guoji = new Butie();
                guoji.delyouban(request.getParameter("id"));
                response.sendRedirect("xbutiejisuan.jsp?act=youbanweihu");
            }else{
            %>
        <table align="center">
                    <tr>
                        <input type="hidden" name="youbanweihudo" value="xinjian"/>
                        <td>客户代码：<input type="text" name="kehu"  size="13" value=""/></td>
                        <td><input type="submit"  value="增加"/></td>
                    </tr>
                </table>
         <table border=1 borderColorDark=#000000 borderColorLight=#000000 cellPadding=1 cellSpacing=0 align="center" id="dat">
                    <tr>
                        
                        <th>客户代码</th>
                        <th>客户名称</th>
                        <th>操作</th>
                        
                    </tr>
        
        
        <%
            
            
            
            Butie xinchou = new Butie();
            ArrayList<Youbankehu> shuju = xinchou.getYoubankehulist();
            for(int i=0;i < shuju.size();i++){
                out.println("<tr>");
                         //out.println("<td><a href='sunyijisuan.jsp?act=guonei&id="+request.getParameter("id")+"&dongzuo=chakanbumen&bumen="+shuju.get(i).jigoudaima+"'>"+shuju.get(i).bumen+"</a></td>");
                         
                         out.println("<td>"+shuju.get(i).kehudaima+"</td>");
                         out.println("<td>"+shuju.get(i).kehumingcheng+"</td>");
                         out.println("<td><a href='xbutiejisuan.jsp?act=youbanweihu&dongzuo=delyouban&id="+shuju.get(i).kehudaima+"'>删除</a></td>");
                         out.println("</tr>");
            }
            }
            %></table><%
        }else if("fanliweihu".equals(request.getParameter("act"))){
            if("chakanbili".equals(request.getParameter("dongzuo"))){
                %>
                
        <table align="center">
            
                    <tr>
                        <input type="hidden" name="fanliweihudo" value="xinjianbili"/>
                        <input type="hidden" name="kehu"  size="13" value="<% out.print(request.getParameter("id"));   %>"/>
                        <input type="hidden" name="shouruqishi"  size="13" value="<% out.print(request.getParameter("shouruqishi"));   %>"/>
                        <input type="hidden" name="shourujieshu"  size="13" value="<% out.print(request.getParameter("shourujieshu"));   %>"/>
                        <td>交易码：<input type="text" name="jiaoyima"  size="13" value=""/></td>
                        <td>邮件类型：
                        <select name="youjianleixing">
                            <option value="1">全部</option>
                            <option value="2">文件</option>
                            <option value="3">物品</option>
                        </select>
                        </td>
                        <td>返利比例：<input type="text" name="bili"  size="13" value=""/></td>
                        <td><input type="submit"  value="增加"/></td>
                    </tr>
                </table>
         <table border=1 borderColorDark=#000000 borderColorLight=#000000 cellPadding=1 cellSpacing=0 align="center" id="dat">
                    <tr>
                        <th>客户代码</th>
                        <th>客户名称</th>
                        <th>交易码</th>
                        <th>邮件类型</th>
                        <th>收入起始量</th>
                        <th>收入结束量</th>
                        <th>比例</th>
                        <th colspan="2">操作</th>
                    </tr>
                    <%
                    Butie butie = new Butie();
                    ArrayList<Fanlikehu> list =  butie.getfanlibili(request.getParameter("id"), request.getParameter("shouruqishi"), request.getParameter("shourujieshu"));
                    for(Fanlikehu shuju : list){
                         out.println("<tr>");
                         out.println("<td>"+shuju.getKehudaima()+"</td>");
                         out.println("<td>"+shuju.getKehumingcheng()+"</td>");
                         out.println("<td>"+shuju.getJiaoyima()+"</td>");
                         out.println("<td>"+shuju.getYoujianleixing()+"</td>");
                         out.println("<td>"+shuju.getShouruqishi()+"</td>");
                         out.println("<td>"+shuju.getShourujieshu()+"</td>");
                         out.println("<td>"+shuju.getBili()+"</td>");
                         out.println("<td><a href='xbutiejisuan.jsp?act=fanliweihu&dongzuo=delbili&kehu="+shuju.getKehudaima()+"&shouruqishi="+shuju.getShouruqishi()+"&shourujieshu="+shuju.getShourujieshu()+"&id="+shuju.getBianhao()+"'>删除</a></td>");
                         out.println("</tr>");
                    }
                    %>
                    
         </table>
        <%
            }else if("delbili".equals(request.getParameter("dongzuo"))){
                Butie guoji = new Butie();
                guoji.delfanlibi(request.getParameter("id"));
                response.sendRedirect("xbutiejisuan.jsp?act=fanliweihu&dongzuo=chakanbili&id="+request.getParameter("kehu")+"&shouruqishi="+request.getParameter("shouruqishi")+"&shourujieshu="+request.getParameter("shourujieshu"));
                //out.println("<script>history.back(-1) </script>");
            }
            
            
            
            
            else{
            //补贴返利维护
            %>
        <table align="center">
                    <tr>
                        <input type="hidden" name="fanliweihudo" value="xinjiankehu"/>
                        <td>客户代码：<input type="text" name="kehu"  size="13" value=""/></td>
                        <td>收入起始量：<input type="text" name="qishiliang"  size="13" value=""/></td>
                        <td>收入结束量：<input type="text" name="jieshuliang"  size="13" value=""/></td>
                        <td><input type="submit"  value="增加"/></td>
                    </tr>
                </table>
         <table border=1 borderColorDark=#000000 borderColorLight=#000000 cellPadding=1 cellSpacing=0 align="center" id="dat">
                    <tr>
                        
                        <th>客户代码</th>
                        <th>客户名称</th>
                        <th>收入起始量</th>
                        <th>收入结束量</th>
                        <th colspan="2">操作</th>
                        
                    </tr>
        
        
        <%
            
            
            
            Butie xinchou = new Butie();
            ArrayList<Fanlikehu> shuju = xinchou.getFanlikehulist();
            for(int i=0;i < shuju.size();i++){
                out.println("<tr>");
                         //out.println("<td><a href='sunyijisuan.jsp?act=guonei&id="+request.getParameter("id")+"&dongzuo=chakanbumen&bumen="+shuju.get(i).jigoudaima+"'>"+shuju.get(i).bumen+"</a></td>");
                         
                         out.println("<td>"+shuju.get(i).getKehudaima()+"</td>");
                         out.println("<td>"+shuju.get(i).getKehumingcheng()+"</td>");
                         out.println("<td>"+shuju.get(i).getShouruqishi()+"</td>");
                         out.println("<td>"+shuju.get(i).getShourujieshu()+"</td>");
                         out.println("<td><a href='xbutiejisuan.jsp?act=fanliweihu&dongzuo=chakanbili&id="+shuju.get(i).kehudaima+"&shouruqishi="+shuju.get(i).getShouruqishi()+"&shourujieshu="+shuju.get(i).getShourujieshu()+"'>查看</a></td>");
                         //out.println("<td><a href='xbutiejisuan.jsp?act=fanliweihu&dongzuo=delkehu&id="+shuju.get(i).kehudaima+"&shouruqishi="+shuju.get(i).getShouruqishi()+"&shourujieshu="+shuju.get(i).getShourujieshu()+"'>删除</a></td>");
                         out.println("</tr>");
            }
            %></table><%
            
        }
        }else if("anjianweihu".equals(request.getParameter("act"))){
            if("delkehu".equals(request.getParameter("dongzuo"))){
                System.out.println(request.getParameter("id"));
                Butie butie = new Butie();
                butie.delanjiankehu(request.getParameter("id"));
                response.sendRedirect("xbutiejisuan.jsp?act=anjianweihu");
            }else{
            %>
                
        <table align="center">
                    <tr>
                        <input type="hidden" name="anjianweihudo" value="xinjiankehu"/>
                        <td>客户代码：<input type="text" name="kehu"  size="13" value=""/></td>
                        <td>金额：<input type="text" name="jine"  size="13" value=""/></td>
                        <td><input type="submit"  value="增加"/></td>
                    </tr>
                </table>
         <table border=1 borderColorDark=#000000 borderColorLight=#000000 cellPadding=1 cellSpacing=0 align="center" id="dat">
                    <tr>
                        
                        <th>客户代码</th>
                        <th>客户名称</th>
                        <th>补贴单价</th>
                        <th>操作</th>
                        
                    </tr>
                    <%
                    Butie butie = new Butie();
                    ArrayList<Anjiankehu> list =  butie.getanjiankehulist();
                    for(Anjiankehu shuju : list){
                         out.println("<tr>");
                         out.println("<td>"+shuju.getKehudaima()+"</td>");
                         out.println("<td>"+shuju.getKehumingcheng()+"</td>");
                         out.println("<td>"+shuju.getButiedanjia()+"</td>");
                         out.println("<td><a href='xbutiejisuan.jsp?act=anjianweihu&dongzuo=delkehu&id="+shuju.getKehudaima()+"'>删除</a></td>");
                         out.println("</tr>");
                    }
                    %>
                    
         </table><%
            }
        }else if("anzhongliangweihu".equals(request.getParameter("act"))){
            if("delshuju".equals(request.getParameter("dongzuo"))){
                Butie butie = new Butie();
                butie.delzhongliangshuju(request.getParameter("id"));
                response.sendRedirect("xbutiejisuan.jsp?act=anzhongliangweihu&dongzuo=chakanmingxi&id="+request.getParameter("kehu"));
            }else if("chakanmingxi".equals(request.getParameter("dongzuo"))){
                %>
                
        <table align="center">
                    <tr>
                        <input type="hidden" name="anzhongliangweihudo" value="xinjianjilu"/>
                        <input type="hidden" name="kehu"  size="13" value="<%out.print(request.getParameter("id"));%>"/>
                        <td>交易码：<input type="text" name="jiaoyima"  size="13" value=""/></td>
                        <td>省：<select name="sheng">
                                <%
                                    for(Shengfen sheng :Shengfen.getShengfenlist()){
                                        out.println("<option value='"+sheng.getBianhao()+"'>"+sheng.getSheng()+"</option>");
                                    }
                                %>
                                        
                            </select></td>
                    
                        <td>邮件类型：<select name="youjianleixing">
                            <option value="1">全部</option>
                            <option value="2">文件</option>
                            <option value="3">物品</option>
                        </select></td>
                        </tr><tr>
                        <td>首重重量：<input type="text" name="shouzhong"  size="13" value=""/></td>
                        <td>首重单价：<input type="text" name="shouzhongdanjia"  size="13" value=""/></td>
                        <td>续重重量：<input type="text" name="xuzhong"  size="13" value=""/></td>
                        <td>续重单价：<input type="text" name="xuzhongdanjia"  size="13" value=""/></td>
                        <td><input type="submit"  value="增加"/></td>
                    </tr>
                </table>
         <table border=1 borderColorDark=#000000 borderColorLight=#000000 cellPadding=1 cellSpacing=0 align="center" id="dat">
                    <tr>
                        
                        <th>客户代码</th>
                        <th>客户名称</th>
                        <th>交易码</th>
                        <th>省</th>
                        <th>邮件类型</th>
                        <th>首重重量</th>
                        <th>首重单价</th>
                        <th>续重重量</th>
                        <th>续重单价</th>
                        <th>操作</th>
                    </tr>
                    <%
                    Butie butie = new Butie();
                    ArrayList<Anshouxuzhongkehu> list =  butie.getshouxuzhongkehupeizhi(request.getParameter("id"));
                    for(Anshouxuzhongkehu shuju : list){
                         out.println("<tr>");
                         out.println("<td>"+shuju.getKehudaima()+"</td>");
                         out.println("<td>"+shuju.getKehumingcheng()+"</td>");
                         out.println("<td>"+shuju.getJiaoyima()+"</td>");
                         out.println("<td>"+shuju.getJidasheng()+"</td>");
                         out.println("<td>"+shuju.getYoujianleixing()+"</td>");
                         out.println("<td>"+shuju.getShouzhong()+"</td>");
                         out.println("<td>"+shuju.getShouzhongdanjia()+"</td>");
                         out.println("<td>"+shuju.getXuzhong()+"</td>");
                         out.println("<td>"+shuju.getXuzhongdanjia()+"</td>");
                         out.println("<td><a href='xbutiejisuan.jsp?act=anzhongliangweihu&dongzuo=delshuju&kehu="+shuju.getKehudaima()+"&id="+shuju.getBianhao()+"'>删除</a></td>");
                         out.println("</tr>");
                    }
                    %>
                    
         </table><%
                
            }
            else{
            %>
                
        <table align="center">
                    <tr>
                        <input type="hidden" name="anzhongliangweihudo" value="xinjiankehu"/>
                        <td>客户代码：<input type="text" name="kehu"  size="13" value=""/></td>
                        <td><input type="submit"  value="增加"/></td>
                    </tr>
                </table>
         <table border=1 borderColorDark=#000000 borderColorLight=#000000 cellPadding=1 cellSpacing=0 align="center" id="dat">
                    <tr>
                        
                        <th>客户代码</th>
                        <th>客户名称</th>
                        
                        <th>操作</th>
                        
                    </tr>
                    <%
                    Butie butie = new Butie();
                    ArrayList<Anshouxuzhongkehu> list =  butie.getShouxuzhongkehulist();
                    for(Anshouxuzhongkehu shuju : list){
                         out.println("<tr>");
                         out.println("<td>"+shuju.getKehudaima()+"</td>");
                         out.println("<td>"+shuju.getKehumingcheng()+"</td>");
                         out.println("<td><a href='xbutiejisuan.jsp?act=anzhongliangweihu&dongzuo=chakanmingxi&id="+shuju.getKehudaima()+"'>查看</a></td>");
                         out.println("</tr>");
                    }
                    %>
                    
         </table><%
            }
        }else if("zhekouweihu".equals(request.getParameter("act"))){
            if("delshuju".equals(request.getParameter("dongzuo"))){
                Butie butie = new Butie();
                butie.delZhekoushuju(request.getParameter("id"));
                //System.out.println(request.getParameter("id"));
                response.sendRedirect("xbutiejisuan.jsp?act=zhekouweihu&dongzuo=chakanmingxi&id="+request.getParameter("kehu"));
            }else if("chakanmingxi".equals(request.getParameter("dongzuo"))){
                %>
                
        <table align="center">
                    <tr>
                        <input type="hidden" name="zhekouweihudo" value="xinjianjilu"/>
                        <input type="hidden" name="kehu"  size="13" value="<%out.print(request.getParameter("id"));%>"/>
                        <td>交易码：<input type="text" name="jiaoyima"  size="13" value=""/></td>
                        <td>省：<select name="sheng">
                                <%
                                    for(Shengfen sheng :Shengfen.getShengfenlist()){
                                        out.println("<option value='"+sheng.getBianhao()+"'>"+sheng.getSheng()+"</option>");
                                    }
                                %>
                                        
                            </select></td>
                    
                        <td>邮件类型：<select name="youjianleixing">
                            <option value="1">全部</option>
                            <option value="2">文件</option>
                            <option value="3">物品</option>
                        </select></td>
                        
                        <td>折扣：<input type="text" name="shouzhong"  size="13" value=""/></td>
                        <td><input type="submit"  value="增加"/></td>
                    </tr>
                </table>
         <table border=1 borderColorDark=#000000 borderColorLight=#000000 cellPadding=1 cellSpacing=0 align="center" id="dat">
                    <tr>
                        
                        <th>客户代码</th>
                        <th>客户名称</th>
                        <th>交易码</th>
                        <th>省</th>
                        <th>邮件类型</th>
                        <th>折扣</th>
                        <th>操作</th>
                    </tr>
                    <%
                    Butie butie = new Butie();
                    ArrayList<Anzhekoukehu> list =  butie.getZhekoukehushuju(request.getParameter("id"));
                    for(Anzhekoukehu shuju : list){
                         out.println("<tr>");
                         out.println("<td>"+shuju.getKehudaima()+"</td>");
                         out.println("<td>"+shuju.getKehumingcheng()+"</td>");
                         out.println("<td>"+shuju.getJiaoyima()+"</td>");
                         out.println("<td>"+shuju.getSheng()+"</td>");
                         out.println("<td>"+shuju.getYoujianleixing()+"</td>");
                         out.println("<td>"+shuju.getZhekou()+"</td>");
                         out.println("<td><a href='xbutiejisuan.jsp?act=zhekouweihu&dongzuo=delshuju&kehu="+shuju.getKehudaima()+"&id="+shuju.getBianhao()+"'>删除</a></td>");
                         out.println("</tr>");
                    }
                    %>
                    
         </table><%
                
            }
            else{
            %>
                
        <table align="center">
                    <tr>
                        <input type="hidden" name="zhekouweihudo" value="xinjiankehu"/>
                        <td>客户代码：<input type="text" name="kehu"  size="13" value=""/></td>
                        <td><input type="submit"  value="增加"/></td>
                    </tr>
                </table>
         <table border=1 borderColorDark=#000000 borderColorLight=#000000 cellPadding=1 cellSpacing=0 align="center" id="dat">
                    <tr>
                        
                        <th>客户代码</th>
                        <th>客户名称</th>
                        
                        <th>操作</th>
                        
                    </tr>
                    <%
                    Butie butie = new Butie();
                    ArrayList<Anzhekoukehu> list =  butie.getAnzhekoukehulist();
                    for(Anzhekoukehu shuju : list){
                         out.println("<tr>");
                         out.println("<td>"+shuju.getKehudaima()+"</td>");
                         out.println("<td>"+shuju.getKehumingcheng()+"</td>");
                         out.println("<td><a href='xbutiejisuan.jsp?act=zhekouweihu&dongzuo=chakanmingxi&id="+shuju.getKehudaima()+"'>查看</a></td>");
                         out.println("</tr>");
                    }
                    %>
                    
         </table><%
            }
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
                    out.println("<Script Language=\"JavaScript\"> alert(\"错误\");window.history.back(); </Script>");
                }
                
        }
        if("xinjian".equals(request.getParameter("youbanweihudo"))){
            Butie xinchou = new Butie();
            if(xinchou.addyoubankehu(request.getParameter("kehu"))){
                out.println("<Script Language=\"JavaScript\"> alert(\"提交成功\");window.history.back(); </Script>");
                }else{
                    out.println("<Script Language=\"JavaScript\"> alert(\"错误\");window.history.back(); </Script>");
                }
            
        }
       if("xinjiankehu".equals(request.getParameter("anzhongliangweihudo"))){
            Butie xinchou = new Butie();
           
            if(xinchou.addanzhongliangkehu(request.getParameter("kehu"))){
                out.println("<Script Language=\"JavaScript\"> alert(\"提交成功\");window.history.back(); </Script>");
                }else{
                    out.println("<Script Language=\"JavaScript\"> alert(\"错误\");window.history.back(); </Script>");
                }
       }
        if("xinjianjilu".equals(request.getParameter("anzhongliangweihudo"))){
            Butie xinchou = new Butie();
            if(xinchou.addzhongliangjilu(request.getParameter("kehu"),request.getParameter("jiaoyima"),request.getParameter("sheng"), request.getParameter("youjianleixing"), request.getParameter("shouzhong"), request.getParameter("shouzhongdanjia"), request.getParameter("xuzhong"), request.getParameter("xuzhongdanjia"))){
                
                    //out.println(request.getParameter("kehu")+request.getParameter("bili"));
                    out.println("<Script Language=\"JavaScript\"> alert(\"提交成功\");window.history.back(); </Script>");
                }else{
                    out.println("<Script Language=\"JavaScript\"> alert(\"错误\");window.history.back(); </Script>");
                }
        }
        
        if("xinjiankehu".equals(request.getParameter("zhekouweihudo"))){
            Butie xinchou = new Butie();
           
            if(xinchou.addZhekoukehu(request.getParameter("kehu"))){
                out.println("<Script Language=\"JavaScript\"> alert(\"提交成功折扣\");window.history.back(); </Script>");
                }else{
                    out.println("<Script Language=\"JavaScript\"> alert(\"错误\");window.history.back(); </Script>");
                }
       }
        if("xinjianjilu".equals(request.getParameter("zhekouweihudo"))){
            Butie xinchou = new Butie();
            if(xinchou.addZhekoujilu(request.getParameter("kehu"),request.getParameter("jiaoyima"),request.getParameter("sheng"), request.getParameter("youjianleixing"), request.getParameter("zhekou"))){
                
                    //out.println(request.getParameter("kehu")+request.getParameter("bili"));
                    out.println("<Script Language=\"JavaScript\"> alert(\"提交成功\");window.history.back(); </Script>");
                }else{
                    out.println("<Script Language=\"JavaScript\"> alert(\"错误\");window.history.back(); </Script>");
                }
        }
        
        if("xinjiankehu".equals(request.getParameter("anjianweihudo"))){
            Butie xinchou = new Butie();
            if(xinchou.addanjiankehu(request.getParameter("kehu"),request.getParameter("jine"))){
                out.println("<Script Language=\"JavaScript\"> alert(\"提交成功\");window.history.back(); </Script>");
                }else{
                    out.println("<Script Language=\"JavaScript\"> alert(\"错误返利\");window.history.back(); </Script>");
                }
            
        }
        if("xinjiankehu".equals(request.getParameter("fanliweihudo"))){
            Butie xinchou = new Butie();
            if(xinchou.addfanlikehu(request.getParameter("kehu"),request.getParameter("qishiliang"),request.getParameter("jieshuliang"))){
                out.println("<Script Language=\"JavaScript\"> alert(\"提交成功\");window.history.back(); </Script>");
                }else{
                    out.println("<Script Language=\"JavaScript\"> alert(\"错误返利\");window.history.back(); </Script>");
                }
            
        }
        if("xinjianbili".equals(request.getParameter("fanliweihudo"))){
            Butie xinchou = new Butie();
            if(xinchou.addfanlibili(request.getParameter("kehu"),request.getParameter("shouruqishi"),request.getParameter("shourujieshu"), request.getParameter("jiaoyima"), request.getParameter("youjianleixing"), request.getParameter("bili"))){
                
                    //out.println(request.getParameter("kehu")+request.getParameter("bili"));
                    out.println("<Script Language=\"JavaScript\"> alert(\"提交成功返利\");window.history.back(); </Script>");
                }else{
                    out.println("<Script Language=\"JavaScript\"> alert(\"错误\");window.history.back(); </Script>");
                }
        }
        
    
    %>
                
</html>
