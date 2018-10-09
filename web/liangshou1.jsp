<%-- 
    Document   : index
    Created on : 2014-2-17, 9:23:28
    Author     : Administrator
--%>

<%@page import="Beans.liangshou.Sanhu"%>
<%@page import="Beans.liangshou.Zhengqi"%>
<%@page import="Beans.liangshou.jingji10a"%>
<%@page import="Beans.liangshou.Shengji8xian"%>
<%@page import="Beans.liangshou.Biaokuai"%>
<%@page import="Beans.liangshou.Jingkuai"%>
<%@page import="Beans.liangshou.Youhang"%>
<%@page import="Beans.liangshou.Zhekou"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Beans.liangshou.Tongji"%>
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
  function reset(tableid){
      
      var curTbl = document.getElementById(tableid);
      if(curTbl !== null){
        for(i=0;i<curTbl.cells.length;i++){
            curTbl.cells[i].innerHTML="";
            }
        }
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
        String kshijian2 = "";
        String jshijian = "";
        String jshijian2 = "";
        
        if(request.getParameter("do") != null){
                    kshijian = request.getParameter("kshijian");
                    kshijian2 = request.getParameter("kshijian2");
                    jshijian = request.getParameter("jshijian");
                    jshijian2 = request.getParameter("jshijian2");
        }
        
        //out.println(request.getParameter("action"));
    %>
    <div style="text-align:center;clear:both"><br>
    <form action="liangshou1.jsp?act=<%out.print(request.getParameter("act"));%>" name="chaxun" method="post">
        
        <input type="hidden" name="do" value="<%out.print(request.getParameter("act"));%>"/>
        <table align="center">
            <tr>
                <%if("tongji".equals(request.getParameter("act"))){
                    %>
                    <td rowspan="2">交易码:<input type="text" name="jiaoyima" value=""/></td>
                <%}
                if("tongji2".equals(request.getParameter("act"))){
                %>
                    <td rowspan="2">产品代码:<input type="text" name="daima" value=""/></td>
                <%}
                if("changsanjiao".equals(request.getParameter("act"))){
                    
                %><td rowspan="2">交易码:<input type="text" name="jiaoyima" value=""/></td>
                <%}
                if("a10jingji".equals(request.getParameter("act"))||"shengji8xian".equals(request.getParameter("act")) ||"tongji".equals(request.getParameter("act"))||"tongji2".equals(request.getParameter("act"))||"73biaokuai".equals(request.getParameter("act"))){
                %><td rowspan="2">种类:<select name="zhonglei" >
                        <option value="1">按城市</option>
                        <option value="2" selected="selected">按机构</option>
                        <option value="3" selected="selected">按机城</option>
                       </select></td>
                <%}if("zhengqi".equals(request.getParameter("act"))){
                %><td rowspan="2">种类:<select name="zhonglei" >
                        <option value="1">标准</option>
                        <option value="2" selected="selected">全部</option>
                       </select></td>
                <%}
                                //if("shengji8xian".equals(anObject))
                %>
                <td>开始时间：<input class="Wdate" type="text" name="kshijian" onClick="WdatePicker()" size="13" value="<%out.print(kshijian);%>"/></td>
                <td>结束时间：<input class="Wdate" type="text" name="jshijian" onClick="WdatePicker()" size="13" value="<%out.print(jshijian);%>"/></td>
                <td><input type="submit" name = "action" value="查询" /></td>
                <td rowspan="2"><input type="button" id="copy" value="导出到Excel" onclick="copyToExcel('dat')"/></td>
            </tr>
            <tr>
                <td>开始时间：<input class="Wdate" type="text" name="kshijian2" onClick="WdatePicker()" size="13" value="<%out.print(kshijian2);%>"/></td>
                <td>结束时间：<input class="Wdate" type="text" name="jshijian2" onClick="WdatePicker()" size="13" value="<%out.print(jshijian2);%>"/></td>
                <td><input type="submit" name="action" value="比较" /></td>
            </tr>
        </table>
    </form>
        <table border=1 borderColorDark=#000000 borderColorLight=#000000 cellPadding=1 cellSpacing=0 align="center" id="dat">
               
    <%
    //request.setCharacterEncoding("gbk");
    if("tongji".equals(request.getParameter("do")) || "tongji2".equals(request.getParameter("do"))){
           %>
               <tr>
                   <th>
                       机构
                   </th>
                   <th>
                       邮件量
                   </th>
                   <th>
                       实收总费用
                   </th>
               </tr>
    <%
    Tongji t = new Tongji();
    ArrayList<Tongji> al;
    if("tongji".equals(request.getParameter("do")) ){
    if("2".equals(request.getParameter("zhonglei"))){
        al  = t.getTongjibyjiaoyima(request.getParameter("kshijian").replace("-", ""), request.getParameter("jshijian").replace("-", ""),request.getParameter("jiaoyima"));
    }else{
        al  = t.getTongjibyjiaoyimashi(request.getParameter("kshijian").replace("-", ""), request.getParameter("jshijian").replace("-", ""),request.getParameter("jiaoyima"));
    }
    }else{
        if("2".equals(request.getParameter("zhonglei"))){
        al  = t.getTongjibydaima(request.getParameter("kshijian").replace("-", ""), request.getParameter("jshijian").replace("-", ""),request.getParameter("daima"));
        }else{
            al  = t.getTongjibydaimashi(request.getParameter("kshijian").replace("-", ""), request.getParameter("jshijian").replace("-", ""),request.getParameter("daima"));
        }
        }
    for(int i = 0; i < al.size();i ++){
        out.print("<tr>");
        out.print("<td>"+al.get(i).getJigou() +"</td>");
        out.print("<td>"+al.get(i).getYoujianshu()+"</td>");
        out.print("<td>"+al.get(i).getShouru()+"</td>");
        out.print("</tr>");
               }
        %>
           <!--</table>-->
    <%   
       }else if("zhekou".equals(request.getParameter("do"))){
           %>
                      
               <tr>
                   <th>
                       机构
                   </th>
                   <th>
                       交易码
                   </th>
                   <th>
                       邮件量
                   </th>
                   <th>
                       实收总费用
                   </th>
                   <th>
                       应收总费用
                   </th>
                   <th>
                       折扣率
                   </th>
               </tr>
               
    <%
    Zhekou z = new Zhekou();
    ArrayList<Zhekou> al  = z.getZhekou(request.getParameter("kshijian").replace("-", ""), request.getParameter("jshijian").replace("-", ""));
    for(int i = 0; i < al.size();i ++){
               
    }
    for(int i = 0; i < al.size();i ++){
        out.print("<tr>");
        out.print("<td>"+al.get(i).getJigou() +"</td>");
        out.print("<td>"+al.get(i).getJiaoyima()+"</td>");
        out.print("<td>"+al.get(i).getMailcount()+"</td>");
        out.print("<td>"+al.get(i).getShishou()+"</td>");
        out.print("<td>"+al.get(i).getYingshou()+"</td>");
        out.print("<td>"+al.get(i).getZhekou()+"</td>");
        out.print("</tr>");
    }
       }else if("a10jingji".equals(request.getParameter("do"))){
           %>
           
               <tr>
                   <th>
                       机构
                   </th>
                   <th>
                       交易码
                   </th>
                   <th>
                       邮件量
                   </th>
                   <th>
                       实收总费用
                   </th>
                   <th>
                       应收总费用
                   </th>
                   
               </tr>
    <%
    jingji10a y = new jingji10a();
    ArrayList<jingji10a> al  = y.getYouhang(request.getParameter("kshijian").replace("-", ""), request.getParameter("jshijian").replace("-", ""));
    
        for(int i = 0; i < al.size();i ++){
        out.print("<tr>");
        out.print("<td>"+al.get(i).getJigou() +"</td>");
        out.print("<td>"+al.get(i).getJiaoyima()+"</td>");
        out.print("<td>"+al.get(i).getMailcount()+"</td>");
        out.print("<td>"+al.get(i).getShishou()+"</td>");
        out.print("<td>"+al.get(i).getYingshou()+"</td>");
        //out.print("<td>"+al.get(i).getZhekou()+"</td>");
        out.print("</tr>");
    }
    
       }else if("18youhang".equals(request.getParameter("do"))){
           %>
           
               <tr>
                   <th>
                       机构
                   </th>
                   <th>
                       交易码
                   </th>
                   <th>
                       邮件量
                   </th>
                   <th>
                       实收总费用
                   </th>
                   <th>
                       应收总费用
                   </th>
                   
               </tr>
    <%
    Youhang y = new Youhang();
    ArrayList<Youhang> al  = y.getYouhang(request.getParameter("kshijian").replace("-", ""), request.getParameter("jshijian").replace("-", ""));
    
        for(int i = 0; i < al.size();i ++){
        out.print("<tr>");
        out.print("<td>"+al.get(i).getJigou() +"</td>");
        out.print("<td>"+al.get(i).getJiaoyima()+"</td>");
        out.print("<td>"+al.get(i).getMailcount()+"</td>");
        out.print("<td>"+al.get(i).getShishou()+"</td>");
        out.print("<td>"+al.get(i).getYingshou()+"</td>");
        //out.print("<td>"+al.get(i).getZhekou()+"</td>");
        out.print("</tr>");
    }
    
       }else if("68jingji".equals(request.getParameter("do"))){
           %>
           
               <tr>
                   <th>
                       机构
                   </th>
                   <th>
                       交易码
                   </th>
                   <th>
                       邮件量
                   </th>
                   <th>
                       实收总费用
                   </th>
                   <th>
                       应收总费用
                   </th>
                   
               </tr>
    <%
    Jingkuai y = new Jingkuai();
    ArrayList<Jingkuai> al  = y.getJingkuai(request.getParameter("kshijian").replace("-", ""), request.getParameter("jshijian").replace("-", ""));
    
        for(int i = 0; i < al.size();i ++){
        out.print("<tr>");
        out.print("<td>"+al.get(i).getJigou() +"</td>");
        out.print("<td>"+al.get(i).getJiaoyima()+"</td>");
        out.print("<td>"+al.get(i).getMailcount()+"</td>");
        out.print("<td>"+al.get(i).getShishou()+"</td>");
        out.print("<td>"+al.get(i).getYingshou()+"</td>");
        //out.print("<td>"+al.get(i).getZhekou()+"</td>");
        out.print("</tr>");
    }
    
       }else if("73biaokuai".equals(request.getParameter("do"))){
           %>
           
               <tr>
                   <th>
                       机构
                   </th>
                   <th>
                       交易码
                   </th>
                   <th>
                       邮件量
                   </th>
                   <th>
                       实收总费用
                   </th>
                   <th>
                       应收总费用
                   </th>
                   
               </tr>
    <%
           Biaokuai y = new Biaokuai();
           ArrayList<Biaokuai> al = null;
           if("2".equals(request.getParameter("zhonglei"))){
         al  = y.getBiaokuai(request.getParameter("kshijian").replace("-", ""), request.getParameter("jshijian").replace("-", ""));
           }else{
             al  = y.getBiaokuaibyshi(request.getParameter("kshijian").replace("-", ""), request.getParameter("jshijian").replace("-", ""));  
           }
        for(int i = 0; i < al.size();i ++){
        out.print("<tr>");
        out.print("<td>"+al.get(i).getJigou() +"</td>");
        out.print("<td>"+al.get(i).getJiaoyima()+"</td>");
        out.print("<td>"+al.get(i).getMailcount()+"</td>");
        out.print("<td>"+al.get(i).getShishou()+"</td>");
        out.print("<td>"+al.get(i).getYingshou()+"</td>");
        //out.print("<td>"+al.get(i).getZhekou()+"</td>");
        out.print("</tr>");
    }
       }else if("shengji8xian".equals(request.getParameter("do"))){
           if("查询".equals(request.getParameter("action"))){
           %>
               <tr>
                   <th>
                       机构
                   </th>
                   
                   <th>
                       交易码
                   </th>
                   <th>
                       邮件量
                   </th>
                   <th>
                       实收总费用
                   </th>
                   <th>
                       应收总费用
                   </th>
                   
               </tr>
    <%
           }
           
           else{
               %>
                 <tr>
                   <th>
                       机构
                   </th>
                   <th>
                       交易码
                   </th>
                   <th>
                       邮件量
                   </th>
                   <th>
                       实收总费用
                   </th>
                   <th>
                       邮件量
                   </th>
                   <th>
                       实收总费用
                   </th>
                   <th>
                       邮件量比率
                   </th>
                   <th>
                       实收费用比率
                   </th>
               </tr>       
    <%
           }
           if("查询".equals(request.getParameter("action"))){
                Shengji8xian y = new Shengji8xian();
                ArrayList<Shengji8xian> al = null;
                if("2".equals(request.getParameter("zhonglei"))){
              al  = y.getShengji(request.getParameter("kshijian").replace("-", ""), request.getParameter("jshijian").replace("-", ""));
                }else if("3".equals(request.getParameter("zhonglei"))){
                    al = y.getShengjibyjishi(request.getParameter("kshijian").replace("-", ""), request.getParameter("jshijian").replace("-", ""));
                }
                else{
                  al  = y.getShengjibyshi(request.getParameter("kshijian").replace("-", ""), request.getParameter("jshijian").replace("-", ""));  
                }
                
             for(int i = 0; i < al.size();i ++){
             out.print("<tr>");
             out.print("<td>"+al.get(i).getJigou() +"</td>");
             if("3".equals(request.getParameter("zhonglei"))){
                 out.print("<td>"+al.get(i).getJigou2()+"</td>");
             }
             out.print("<td>"+al.get(i).getJiaoyima()+"</td>");
             out.print("<td>"+al.get(i).getMailcount()+"</td>");
             out.print("<td>"+al.get(i).getShishou()+"</td>");
             out.print("<td>"+al.get(i).getYingshou()+"</td>");
             //out.print("<td>"+al.get(i).getZhekou()+"</td>");
             out.print("</tr>");
         }
           }else{
               Shengji8xian y = new Shengji8xian();
                ArrayList<Shengji8xian> al = null;
                if("2".equals(request.getParameter("zhonglei"))){
              al  = y.getShengji(request.getParameter("kshijian").replace("-", ""), request.getParameter("jshijian").replace("-", ""),request.getParameter("kshijian2").replace("-", ""), request.getParameter("jshijian2").replace("-", ""));
                }else{
                  al  = y.getShengjibyshi(request.getParameter("kshijian").replace("-", ""), request.getParameter("jshijian").replace("-", ""),request.getParameter("kshijian2").replace("-", ""), request.getParameter("jshijian2").replace("-", ""));  
                }
             for(int i = 0; i < al.size();i ++){
             out.print("<tr>");
             out.print("<td>"+al.get(i).getJigou() +"</td>");
             out.print("<td>"+al.get(i).getJiaoyima()+"</td>");
             out.print("<td>"+al.get(i).getMailcount()+"</td>");
             out.print("<td>"+al.get(i).getShishou()+"</td>");
             out.print("<td>"+al.get(i).getMailcount1()+"</td>");
             out.print("<td>"+al.get(i).getShishou1()+"</td>");
             out.print("<td>"+al.get(i).getBjmailcount()+"</td>");
             out.print("<td>"+al.get(i).getBjtotalfee()+"</td>");
            //out.print("<td>"+al.get(i).getYingshou()+"</td>");
             //out.print("<td>"+al.get(i).getZhekou()+"</td>");
             out.print("</tr>");
           }
       }
       }else if("zhengqi".equals(request.getParameter("do"))){
           
           %>
           <tr>
                   <th>
                       一级分类
                   </th>
                   <th>
                       二级分类
                   </th>
                   <th>
                       三级分类
                   </th>
                   <th>
                       分公司
                   </th>
                   <th>
                       协议客户名称
                   </th>
                   <th>
                       协议客户代码
                   </th>
                   <th>
                       邮件量
                   </th>
                   <th>
                       实收总费用
                   </th>

                   
               </tr>
           <%
           if("2".equals(request.getParameter("zhonglei"))){
           Zhengqi y = new Zhengqi();
                ArrayList<Zhengqi> al = null;
                al = y.getQuanbu(request.getParameter("kshijian").replace("-", ""), request.getParameter("jshijian").replace("-", ""));
                for(int i = 0; i < al.size();i ++){
             out.print("<tr>");
             out.print("<td>"+al.get(i).getFl1()+"</td>");
             out.print("<td>"+al.get(i).getFl2()+"</td>");
             out.print("<td>"+al.get(i).getFl3()+"</td>");
             out.print("<td>"+al.get(i).getGsm()+"</td>");
             out.print("<td>"+al.get(i).getKehu() +"</td>");
             out.print("<td>"+al.get(i).getKehudaima() +"</td>");
             out.print("<td>"+al.get(i).getYoujianliang()+"</td>");
             out.print("<td>"+al.get(i).getshouru()+"</td>");
             
             //out.print("<td>"+al.get(i).getZhekou()+"</td>");
             out.print("</tr>");
                }
       }else {
               Zhengqi y = new Zhengqi();
                ArrayList<Zhengqi> al = null;
                al = y.getBiaokuai(request.getParameter("kshijian").replace("-", ""), request.getParameter("jshijian").replace("-", ""));
                for(int i = 0; i < al.size();i ++){
             out.print("<tr>");
             out.print("<td>"+al.get(i).getFl1()+"</td>");
             out.print("<td>"+al.get(i).getFl2()+"</td>");
             out.print("<td>"+al.get(i).getFl3()+"</td>");
             out.print("<td>"+al.get(i).getGsm()+"</td>");
             out.print("<td>"+al.get(i).getKehu() +"</td>");
             out.print("<td>"+al.get(i).getKehudaima() +"</td>");
             out.print("<td>"+al.get(i).getYoujianliang()+"</td>");
             out.print("<td>"+al.get(i).getshouru()+"</td>");
             
             //out.print("<td>"+al.get(i).getZhekou()+"</td>");
             out.print("</tr>");
                }
           }
       }else if("sanhu".equals(request.getParameter("do"))){
           %>
            <tr>
                   <th>
                       机构名称
                   </th>
                   <th>
                       揽收员
                   </th>
                   <th>
                       产品
                   </th>
                   <th>
                       大客户代码
                   </th>
                   <th>
                       大客户
                   </th>
                   <th>
                       量
                   </th>
                   <th>
                       收
                   </th>
                   
               </tr>
           
           <%
           
           Sanhu y = new Sanhu();
                ArrayList<Sanhu> al = null;
                al = y.getSanhu(request.getParameter("kshijian").replace("-", ""), request.getParameter("jshijian").replace("-", ""));
                
                for(int i = 0; i < al.size();i ++){
             out.print("<tr>");
             out.print("<td>"+al.get(i).jigou+"</td>");
             out.print("<td>"+al.get(i).lanshouyuan+"</td>");
             out.print("<td>"+al.get(i).chanp+"</td>");
             out.print("<td>"+al.get(i).kehudaima+"</td>");
             out.print("<td>"+al.get(i).dakehu+"</td>");
             out.print("<td>"+al.get(i).liang +"</td>");
             out.print("<td>"+al.get(i).shou +"</td>");
             
             
             //out.print("<td>"+al.get(i).getZhekou()+"</td>");
             out.print("</tr>");
           
       }
       }
    %>
                     </table>
    </div>
</html>
