/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Beans.mingxi;

import Beans.MyLog;
import Beans.liangshou.Zhekou;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class chaxun {
    
    private String mailno;
    private String dakehudaima;
    private String jigou;
    private String shoujishijian;
    private String sheng;
    private String shi;
    private String shoujianren;
    private String shoudianhua;
    private String shoujiandizhi;
    private String zhongliang;
    private String shishou;
    private String sendername;
    private String tuotou;
    private String zhonglei;
   
    public void Setzhonglei(String zhonglei){
        this.zhonglei = zhonglei;
    }
    public void SetShoudianhua(String shoudianhua){
        this.shoudianhua =shoudianhua;
    }
    public void SetMailno(String mailno){
        this.mailno =mailno;
    }
    public void SetDakehudaima(String dakehudaima){
        this.dakehudaima =dakehudaima;
    }
    public void SetJigou(String jigou){
        this.jigou = jigou;
    }
    public void SetShoujishijian(String shoujishijian){
        this.shoujishijian =shoujishijian;
    }
    public void SetSheng(String sheng){
        this.sheng =sheng;
    }
    public void SetShi(String shi){
        this.shi =shi;
    }
    public void SetShoujianren(String shoujianren){
        this.shoujianren =shoujianren;
    }
    public void SetShoujiandizhi(String shoujiandizhi){
        this.shoujiandizhi =shoujiandizhi;
    }
    public void SetZhongliang(String zhongliang){
        this.zhongliang =zhongliang;
    }
    public void SetShishou(String shishou){
        this.shishou =shishou;
    }
    public void SetSendername(String sendername){
         this.sendername =sendername;
    }
    public void SetTuotou(String tuotou){
        this.tuotou = tuotou;
    }
    
    public String getShoudianhua(){
        return shoudianhua;
    }
    public String getMailno(){
        return mailno;
    }
    public String getDakehudaima( ){
        return dakehudaima;
    }
    public String getJigou(){
        return jigou;
    }
    public String getShoujishijian( ){
        return shoujishijian;
    }
    public String getSheng( ){
        return sheng;
    }
    public String getShi( ){
        return shi;
    }
    public String getShoujianren( ){
        return shoujianren;
    }
    public String getShoujiandizhi( ){
       return shoujiandizhi;
    }
    public String getZhongliang( ){
        return zhongliang;
    }
    public String getShishou( ){
        return shishou;
    }
    public String getSendername(){
        return sendername;
    }
    public String getTuotou(){
        return tuotou;
    }
    public String getZhonglei(){
        return zhonglei;
    }
    
    public chaxun(){
        
    }
    public chaxun(String mailno,String dakehudaima,String sendername,String jigou,String shoujishijian,String sheng,String shi,String shoujianren,String shoujiandizhi,String zhongliang,String shishou,String tuotou,String zhonglei){
    
        SetMailno(mailno);
    SetDakehudaima(dakehudaima);
    SetSendername(sendername);
    SetJigou(jigou);
    SetShoujishijian(shoujishijian);
    SetSheng( sheng);
      SetShi( shi);
      SetShoujianren( shoujianren);
      SetShoujiandizhi( shoujiandizhi);
      SetZhongliang( zhongliang);
      SetShishou( shishou);
      if("0".equals(tuotou)){
          SetTuotou("未妥投");
      }else{
          SetTuotou("妥投");
      }
      Setzhonglei(zhonglei);
    }
    public ArrayList<chaxun> getAnriqibiaozhun(String kshijian,String jshijian){
        ArrayList<chaxun> al = new ArrayList();
        //format.setMinimumFractionDigits(2);// 设置小数位 
        try{
//                Class.forName(driver).newInstance();
                Connection conn = MyLog.getConn();
                String sql = "select prod_code,main_mail_num,mail_kind_code,feedback_mode_code,mail_num, sender_cust_code,sender_dept_name,org_sname,clct_date,sheng,shi,rcver_name,rcver_addr,actual_weight,actual_total_fee,zhuangtai,yewulei,rcv_area from wujiangmail where clct_date >= ? and clct_date<= ? and (yewulei = '标准' or yewulei = 'E标准' )";
                //String sqlt = "select JIAOYIMA as jiaoyima,count(mail_num) as mailcount,sum(actual_total_fee) as totalfee,sum(SHOULD_PAY_TOTAL_FEE) as shouldfee from view1 where CLCT_DATE >= ? and CLCT_DATE <= ? GROUP by JIAOYIMA";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                //System.out.println(request.getParameter("kshijian").replace("-", ""));
                pstmt.setString(1, kshijian);
                pstmt.setString(2, jshijian);
                ResultSet rs =pstmt.executeQuery();
                
                while(rs.next()){
                    String zhonglei = "";
                    if("8".equals(rs.getString("feedback_mode_code"))){
                        zhonglei = "返单";
                        
                    }else if( "10401".equals(rs.getString("mail_kind_code") )){
                        zhonglei = "邮政公事";
                    }else if((rs.getString("main_mail_num") != null && !rs.getString("main_mail_num").equals("") )  ){
                        zhonglei = "一票多件,主单号:"+rs.getString("main_mail_num");
                    }
                    chaxun c = new chaxun(rs.getString("mail_num"),rs.getString("sender_cust_code"),rs.getString("sender_dept_name"),rs.getString("org_sname"),rs.getString("clct_date"),rs.getString("sheng"),rs.getString("shi"),rs.getString("rcv_area"),rs.getString("rcver_addr"),rs.getString("actual_weight"),rs.getString("actual_total_fee"),rs.getString("zhuangtai"),rs.getString("yewulei"));
                   
                    al.add(c);
                    //al.add(t);
                    //out.println("<tr><td>"+rs.getString("name")+"</td>");
                    //out.println("<td>"+rs.getString("mailcount")+"</td>");
                    //out.println("<td>"+rs.getString("fee")+"</td></tr>");
                    //out.println("<tr><td>:</td><td>"+rs.getString(4)+"</td></tr>");
                               }
                rs.close();
                pstmt.close();
                MyLog.close(conn);
        }catch(SQLException sqle){
            sqle.printStackTrace();
            MyLog.logtooracle("getZhekou", sqle);
        }catch(ClassNotFoundException cnfe){
            cnfe.printStackTrace();
            MyLog.logtooracle("getZhekou", cnfe);
        }catch(InstantiationException ie ){
            ie.printStackTrace();
            MyLog.logtooracle("getZhekou", ie);
        }catch(IllegalAccessException iae){
            iae.printStackTrace();
            MyLog.logtooracle("getZhekou", iae);
        }
        return al;
    }
    public ArrayList<chaxun> getLing(String kshijian,String jshijian){
        ArrayList<chaxun> al = new ArrayList();
        //format.setMinimumFractionDigits(2);// 设置小数位 
        try{
//                Class.forName(driver).newInstance();
                Connection conn = MyLog.getConn();
                String sql = "select prod_code,main_mail_num,mail_kind_code,feedback_mode_code,mail_num, sender_cust_code,sender_dept_name,org_sname,clct_date,sheng,shi,rcver_name,rcver_addr,actual_weight,actual_total_fee,zhuangtai from wujiangmail where clct_date >= ? and clct_date<= ? and (actual_total_fee = '0' or actual_weight = '0' or billing_weight = '0')";
                String sqlt = "select JIAOYIMA as jiaoyima,count(mail_num) as mailcount,sum(actual_total_fee) as totalfee,sum(SHOULD_PAY_TOTAL_FEE) as shouldfee from view1 where CLCT_DATE >= ? and CLCT_DATE <= ? GROUP by JIAOYIMA";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                //System.out.println(request.getParameter("kshijian").replace("-", ""));
                pstmt.setString(1, kshijian);
                pstmt.setString(2, jshijian);
                ResultSet rs =pstmt.executeQuery();
                
                while(rs.next()){
                    String zhonglei = "";
                    if("8".equals(rs.getString("feedback_mode_code"))){
                        zhonglei = "返单";
                        
                    }else if( "10401".equals(rs.getString("mail_kind_code") )){
                        zhonglei = "邮政公事";
                    }else if((rs.getString("main_mail_num") != null && !rs.getString("main_mail_num").equals("") )  ){
                        zhonglei = "一票多件,主单号:"+rs.getString("main_mail_num");
                    }
                    chaxun c = new chaxun(rs.getString("mail_num"),rs.getString("sender_cust_code"),rs.getString("sender_dept_name"),rs.getString("org_sname"),rs.getString("clct_date"),rs.getString("sheng"),rs.getString("shi"),rs.getString("rcver_name"),rs.getString("rcver_addr"),rs.getString("actual_weight"),rs.getString("actual_total_fee"),rs.getString("zhuangtai"),zhonglei);
                   
                    al.add(c);
                    //al.add(t);
                    //out.println("<tr><td>"+rs.getString("name")+"</td>");
                    //out.println("<td>"+rs.getString("mailcount")+"</td>");
                    //out.println("<td>"+rs.getString("fee")+"</td></tr>");
                    //out.println("<tr><td>:</td><td>"+rs.getString(4)+"</td></tr>");
                               }
                rs.close();
                pstmt.close();
                MyLog.close(conn);
        }catch(SQLException sqle){
            sqle.printStackTrace();
            MyLog.logtooracle("getZhekou", sqle);
        }catch(ClassNotFoundException cnfe){
            cnfe.printStackTrace();
            MyLog.logtooracle("getZhekou", cnfe);
        }catch(InstantiationException ie ){
            ie.printStackTrace();
            MyLog.logtooracle("getZhekou", ie);
        }catch(IllegalAccessException iae){
            iae.printStackTrace();
            MyLog.logtooracle("getZhekou", iae);
        }
        return al;
    }
    public ArrayList<chaxun> getMingxi(String kshijian,String jshijian,String dakehu){
        ArrayList<chaxun> al = new ArrayList();
        //format.setMinimumFractionDigits(2);// 设置小数位 
        try{
//                Class.forName(driver).newInstance();
                Connection conn = MyLog.getConn();
                String sql = "select prod_code,main_mail_num,mail_kind_code,billing_weight,feedback_mode_code,mail_num, sender_cust_code,sender_dept_name,org_sname,clct_date,sheng,shi,rcver_name,rcver_addr,actual_weight,actual_total_fee,zhuangtai from wujiangmail where clct_date >= ? and clct_date<= ? and sender_cust_code=?";
                String sqlt = "select JIAOYIMA as jiaoyima,count(mail_num) as mailcount,sum(actual_total_fee) as totalfee,sum(SHOULD_PAY_TOTAL_FEE) as shouldfee from view1 where CLCT_DATE >= ? and CLCT_DATE <= ? GROUP by JIAOYIMA";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                //System.out.println(request.getParameter("kshijian").replace("-", ""));
                pstmt.setString(1, kshijian);
                pstmt.setString(2, jshijian);
                pstmt.setString(3, dakehu);
                ResultSet rs =pstmt.executeQuery();
                
                while(rs.next()){
                    
                    String zhonglei = "";
                    if("8".equals(rs.getString("feedback_mode_code"))){
                        zhonglei = "返单";
                        
                    }else if( "10401".equals(rs.getString("mail_kind_code") )){
                        zhonglei = "邮政公事";
                    }else if((rs.getString("main_mail_num") != null)){
                        zhonglei = "一票多件,主单号:"+rs.getString("main_mail_num");
                    }
                    chaxun c = new chaxun(rs.getString("mail_num"),rs.getString("sender_cust_code"),rs.getString("sender_dept_name"),rs.getString("org_sname"),rs.getString("clct_date"),rs.getString("sheng"),rs.getString("shi"),rs.getString("rcver_name"),rs.getString("rcver_addr"),rs.getString("actual_weight"),rs.getString("actual_total_fee"),rs.getString("zhuangtai"),zhonglei);
                   
                    al.add(c);
                    
                               }
                rs.close();
                pstmt.close();
                MyLog.close(conn);
        }catch(SQLException sqle){
            sqle.printStackTrace();
            MyLog.logtooracle("getZhekou", sqle);
        }catch(ClassNotFoundException cnfe){
            cnfe.printStackTrace();
            MyLog.logtooracle("getZhekou", cnfe);
        }catch(InstantiationException ie ){
            ie.printStackTrace();
            MyLog.logtooracle("getZhekou", ie);
        }catch(IllegalAccessException iae){
            iae.printStackTrace();
            MyLog.logtooracle("getZhekou", iae);
        }
        return al;
    }
    
     public ArrayList<chaxun> getMingxibyjigou(String kshijian,String jshijian,String jigou){
        ArrayList<chaxun> al = new ArrayList();
        //format.setMinimumFractionDigits(2);// 设置小数位 
        try{
//                Class.forName(driver).newInstance();
                Connection conn = MyLog.getConn();
                String sql = "select * from wujiangmail where clct_date >= ? and clct_date<= ? and clct_bureau_org_code = ?";
                //String sqlt = "select JIAOYIMA as jiaoyima,count(mail_num) as mailcount,sum(actual_total_fee) as totalfee,sum(SHOULD_PAY_TOTAL_FEE) as shouldfee from view1 where CLCT_DATE >= ? and CLCT_DATE <= ? GROUP by JIAOYIMA";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                //System.out.println(request.getParameter("kshijian").replace("-", ""));
                pstmt.setString(1, kshijian);
                pstmt.setString(2, jshijian);
                pstmt.setString(3, jigou);
               
                ResultSet rs =pstmt.executeQuery();
                
                
                while(rs.next()){
                    
                    String zhonglei = "";
                    if("8".equals(rs.getString("feedback_mode_code"))){
                        zhonglei = "返单";
                        
                    }else if( "10401".equals(rs.getString("mail_kind_code") )){
                        zhonglei = "邮政公事";
                    }else if((rs.getString("main_mail_num") != null)){
                        zhonglei = "一票多件,主单号:"+rs.getString("main_mail_num");
                    }
                    
                    chaxun c = new chaxun(rs.getString("mail_num"),rs.getString("sender_cust_code"),rs.getString("sender_dept_name"),rs.getString("org_sname"),rs.getString("clct_date"),rs.getString("sheng"),rs.getString("shi"),rs.getString("rcver_name"),rs.getString("rcver_addr"),rs.getString("actual_weight"),rs.getString("actual_total_fee"),rs.getString("zhuangtai"),zhonglei);
                   
                    al.add(c);
                    //al.add(t);
                    //out.println("<tr><td>"+rs.getString("name")+"</td>");
                    //out.println("<td>"+rs.getString("mailcount")+"</td>");
                    //out.println("<td>"+rs.getString("fee")+"</td></tr>");
                    //out.println("<tr><td>:</td><td>"+rs.getString(4)+"</td></tr>");
                               }
                rs.close();
                pstmt.close();
                MyLog.close(conn);
        }catch(SQLException sqle){
            sqle.printStackTrace();
            MyLog.logtooracle("getZhekou", sqle);
        }catch(ClassNotFoundException cnfe){
            cnfe.printStackTrace();
            MyLog.logtooracle("getZhekou", cnfe);
        }catch(InstantiationException ie ){
            ie.printStackTrace();
            MyLog.logtooracle("getZhekou", ie);
        }catch(IllegalAccessException iae){
            iae.printStackTrace();
            MyLog.logtooracle("getZhekou", iae);
        }
        return al;
    }
}
