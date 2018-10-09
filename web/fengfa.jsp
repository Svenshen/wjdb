<%-- 
    Document   : genzong
    Created on : 2015-9-6, 13:41:09
    Author     : Administrator
--%>

<%@page import="Beans.fengfa.Tuotoulvmingxi"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.HashMap"%>
<%@page import="Beans.fengfa.Tuotoulv"%>
<%@page import="Beans.yisidiushi.chukou"%>
<%@page import="Beans.yisidiushi.jinkou"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="Beans.fengfa.Nanji"%>
<%@page import="Beans.fengfa.Fengfa"%>
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
        
        String shijian = "";
        //String kshijian2 = "";
        //String jshijian = "";
        //String jshijian2 = "";
        if(request.getParameter("do") != null){
                    shijian = request.getParameter("shijian");
                    //kshijian2 = request.getParameter("kshijian2");
                    //jshijian = request.getParameter("jshijian");
                    //jshijian2 = request.getParameter("jshijian2");
                   
        }
    %>
     <div style="text-align:center;clear:both"><br>
    <form action="fengfa.jsp?act=<%out.print(request.getParameter("act"));%>" name="chaxun" method="post">
        <input type="hidden" name="do" value="<%out.print(request.getParameter("act"));%>"/>
        
    <table align="center">
        <tr>
            <%
         if("suzhou".equals(request.getParameter("act")) || "nanji".equals(request.getParameter("act")) || "tuotoulv".equals(request.getParameter("act"))){
            %>
            
            <th>日期</th>
        <td><input class="Wdate" type="text" name="shijian" onClick="WdatePicker()" size="13" value="<%out.print(shijian);%>"/></td>
        <%if("suzhou".equals(request.getParameter("act"))){%>
        <th>频次</th>
            <td><input  type="text" name="pinci"  size="13" /></td>
            
            
            <%
         }
        %>
        <td><input type="submit"  value="查询"/></td>
        <%
         }else if("123123".equals(request.getParameter("act"))){
         %>
            <td><input type="button" id="copy" value="导出到Excel" onclick="copyToExcel('dat')"/></td>
            <%} else if("jinkoutuotou".equals(request.getParameter("act")) || "chukoutuotou".equals(request.getParameter("act"))){%>
            <th>邮件号码</th>
            <td><textarea name="mailno" cols=13 rows=10></textarea></td>
        <td><input type="submit"  value="查询"/></td>
            <%}%>
        </tr>
        <tr>
            <td></td>
        </tr>
    </table>
   
    </form>
        <%
        if("jinkoutuotou".equals(request.getParameter("do"))){
        %>
        <table border=1 borderColorDark=#000000 borderColorLight=#000000 cellPadding=1 cellSpacing=0 align="center" id="dat">
            <tr>
            <th>邮件号</th>
            <th>揽投部</th>
            <th>妥投状态</th>
        </tr>
            <%
            jinkou j = new jinkou();
            ArrayList<jinkou> jj = j.istuotou2(request.getParameter("mailno"));
            for(jinkou ji : jj){
                out.println("<tr>");
            out.println("<td>");
            out.println(ji.mailno);
            out.println("</td>");
            out.println("<td>");
            out.println(ji.jigou);
            out.println("</td>");
            out.println("<td>");
            out.println(ji.tuotou);
            out.println("</td>");
            out.println("<tr>");
            }
            %>
        </table>
        <%}
        if("chukoutuotou".equals(request.getParameter("do"))){
        
            %>
    <table border=1 borderColorDark=#000000 borderColorLight=#000000 cellPadding=1 cellSpacing=0 align="center" id="dat">
            <tr>
            <th>邮件号</th>
            <th>运输方式</th>
            <th>机构名</th>
            <th>妥投状态</th>
        </tr>
        
         <%
            chukou j = new chukou();
            ArrayList<chukou> jj = j.istuotou2(request.getParameter("mailno"));
            for(chukou ji : jj){
                out.println("<tr>");
            out.println("<td>");
            out.println(ji.mailno);
            out.println("</td>");
            out.println("<td>");
            out.println(ji.yunshu);
            out.println("</td>");
            out.println("<td>");
            out.println(ji.jigouming);
            out.println("</td>");
            out.println("<td>");
            out.println(ji.istuotou);
            out.println("</td>");
            out.println("<tr>");
            }
            %>
            </table>
        <%
            }
        if("nanji".equals(request.getParameter("do"))){
                %>
    <table border=1 borderColorDark=#000000 borderColorLight=#000000 cellPadding=1 cellSpacing=0 align="center" id="dat">
        <tr>
            <th colspan="2">部分邮件已有揽收信息，具体信息以83为准</th>
        </tr>
        <tr>
            <th>邮件号</th>
            <th>揽投部</th>
        </tr>
        <%
        Nanji n = new Nanji();
        List<Nanji> nn = n.getweishouji(shijian.replace("-", ""));
        
       //out.println(mailno.size());
        for(Nanji m : nn){
            out.println("<tr>");
            out.println("<td>");
            out.println(m.GetMailno());
            out.println("</td>");
            out.println("<td>");
            out.println(m.GetOrgname());
            out.println("</td>");
            out.println("</tr>");
        }
        %>
    </table>
         <%
            }
        %>
        
    <%if("suzhou".equals(request.getParameter("do")) ){%>
        <table  align="center"><tr valign = "top"><td>
    <%
    //request.setCharacterEncoding("gbk");
        Fengfa fa = new Fengfa();
    if("1".equals((request.getParameter("pinci")))){
        //out.print("12312");
           fa =  fa.getsuzhouduibi1(shijian.replace("-", ""));
    }else{
        
           fa =  fa.getsuzhouduibi2(shijian.replace("-", ""));
    }
           %>
           <table border=1 borderColorDark=#000000 borderColorLight=#000000 cellPadding=1 cellSpacing=0 align="center" id="dat">
           <tr>
               <th colspan="2">
                   有开无封
               </th>
               
           </tr>
           <tr>
               <th >
                   邮件号
               </th>
               <th >
                   总包号
               </th>
           </tr>
           <%
           Iterator iter = fa.kbifduo.entrySet().iterator();
           while(iter.hasNext()){
               Map.Entry entry = (Map.Entry) iter.next();
               out.println("<tr>");
               out.println("<td>"+String.valueOf(entry.getKey())+"</td>");   
               out.println("<td>"+String.valueOf(entry.getValue())+"</td>"); 
               out.println("</tr>");
           }
           %>
           </table></td><td>
           <table border=1 borderColorDark=#000000 borderColorLight=#000000 cellPadding=1 cellSpacing=0 align="center" id="da2t">
           <tr>
               <th colspan="2">
                   有封无开
               </th>
               
           </tr>
           
           <tr>
               <th >
                   邮件号
               </th>
               <th >
                   总包号
               </th>
           </tr>
        <%
           Iterator iter2 = fa.fbikduo.entrySet().iterator();
           while(iter2.hasNext()){
               Map.Entry entry = (Map.Entry) iter2.next();
               out.println("<tr>");
               out.println("<td>"+String.valueOf(entry.getKey())+"</td>");   
               out.println("<td>"+String.valueOf(entry.getValue())+"</td>"); 
               out.println("</tr>");
           }
    %>
           </table></td>
    
        
        </tr>
    </table>
        <%}  
    if("tuotoulv".equals(request.getParameter("do")) ){
        %>
        <table border=1 borderColorDark=#000000 borderColorLight=#000000 cellPadding=1 cellSpacing=0 align="center" id="dat">
        <tr>
            
            <th>机构名</th>
            <th>进口量</th>
            <th>未下段量</th>
            <th>下段率</th>
            <th>未妥投量</th>
            <th>妥投率</th>
        </tr>
        
        <%
            Tuotoulv t = new Tuotoulv();
            HashMap<String,Tuotoulv> map = t.getshuju(shijian.replace("-", ""));
            DecimalFormat df = new DecimalFormat("0.00%");  
            Iterator iter = map.entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry entry = (Map.Entry) iter.next();
                Tuotoulv val = (Tuotoulv)entry.getValue();
                out.println("<tr>");
                
                out.println("<td>"+val.jigouming+"</td>");
                out.println("<td>"+val.jinkouliang+"</td>");
                out.println("<td>"+val.weixiaduanliang+"</td>");
                out.println("<td>"+df.format(1.0 - Double.parseDouble(val.weixiaduanliang)/Double.parseDouble(val.jinkouliang))+"</td>");
                out.println("<td>"+val.weituotouliang+"</td>");
                out.println("<td>"+df.format(1.0  - Double.parseDouble(val.weituotouliang)/Double.parseDouble(val.jinkouliang))+"</td>");
                out.println("</tr>");
            }%>
            <tr><td><a href="fengfa.jsp?do=tuotoulvmingxi&shijian=<%out.print(shijian);%>">未下段邮件明细</a></td></tr>
        </table>
        <%
        }
        if("tuotoulvmingxi".equals(request.getParameter("do"))){
            %>
            <table border=1 borderColorDark=#000000 borderColorLight=#000000 cellPadding=1 cellSpacing=0 align="center" id="dat">
        <tr>
            <th>机构名</th>
            <th>邮件号</th>
        </tr>
        <%
            Tuotoulvmingxi t = new Tuotoulvmingxi();
            //out.println(request.getParameter("shijian").replace("-", ""));
            ArrayList<Tuotoulvmingxi> tt = t.getmingxi(request.getParameter("shijian").replace("-", ""));
            //out.println(tt.size());
            for(int i = 0; i<tt.size();i++){
                out.println("<tr>");
                
                out.println("<td>"+tt.get(i).getJigou()+"</td>");
                out.println("<td>"+tt.get(i).getYoujianhao()+"</td>");
                out.println("</tr>");
            }
        }
        %>
        </table>
        
</html>
