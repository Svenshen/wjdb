/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Beans.liangshou;

import Beans.MyLog;
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
public class Shengji8xian {
    
    private String jigou;
    private String jigou2;
    private String jiaoyima;
    private String shishou;
    private String shishou1;
    private String yingshou;
    private String mailcount;
    private String mailcount1;
    private String bjmailcount;
    private String bjtotalfee;
    
    public void setMailcount(String mailcount){
        this.mailcount = mailcount;
    }
    public void setYingshou(String yingshou){
        this.yingshou = yingshou;
    }
    public void setJigou(String jigou){
        this.jigou = jigou;
    }
    public void setJigou2(String jigou2){
        this.jigou2 = jigou2;
    }
    public void setJiaoyima(String jiaoyima){
        this.jiaoyima = jiaoyima;
    }
    public void setShishou(String shishou){
        this.shishou = shishou;
    }
    public void setMailcount1(String mailcount){
        this.mailcount1 = mailcount;
    }
    public void setShishou1(String shishou){
        this.shishou1 = shishou;
    }
    public void setBjmailcount(String bjmailcount){
        this.bjmailcount = bjmailcount;
    }
    public void setBjtotalfee(String bjtotalfee){
        this.bjtotalfee = bjtotalfee;
    }
    
    public String getJigou(){
        return jigou;
    }
    public String getJigou2(){
        return jigou2;
    }
    public String getJiaoyima(){
        return jiaoyima;
    }
    public String getShishou(){
        return shishou;
    }
    public String getYingshou(){
        return yingshou;
    }
    public String getMailcount(){
        return mailcount;
    }
    public String getMailcount1(){
        return mailcount1;
    }
    public String getShishou1(){
        return shishou1;
    }
    public String getBjmailcount(){
        return bjmailcount;
    }
    public String getBjtotalfee(){
        return bjtotalfee;
    }
    
    public Shengji8xian(){
        
    }
    public Shengji8xian(String jigou,String mailcount,String jiaoyima,String shishou,String yingshou){
        setJigou(jigou);
        setMailcount(mailcount);
        setJiaoyima(jiaoyima);
        setShishou(shishou);
        setYingshou(yingshou);
        /*setMailcount1(mailcount1);
        //setJiaoyima(jiaoyima);
        setShishou1(shishou1);
        setBjmailcount(bjmailcount);
        setBjtotalfee(bjtotalfee);*/
        //setYingshou(yingshou);
        //setYouhang(zhekou);
    }
    public Shengji8xian(String jigou,String jigou2,String mailcount,String jiaoyima,String shishou,String yingshou){
        setJigou(jigou);
        setJigou2(jigou2);
        setMailcount(mailcount);
        setJiaoyima(jiaoyima);
        setShishou(shishou);
        setYingshou(yingshou);
        /*setMailcount1(mailcount1);
        //setJiaoyima(jiaoyima);
        setShishou1(shishou1);
        setBjmailcount(bjmailcount);
        setBjtotalfee(bjtotalfee);*/
        //setYingshou(yingshou);
        //setYouhang(zhekou);
    }
    public Shengji8xian(String jigou,String mailcount,String jiaoyima,String shishou,String mailcount1,String shishou1,String bjmailcount,String bjtotalfee){
        setJigou(jigou);
        setMailcount(mailcount);
        setJiaoyima(jiaoyima);
        setShishou(shishou);
        setMailcount1(mailcount1);
        //setJiaoyima(jiaoyima);
        setShishou1(shishou1);
        setBjmailcount(bjmailcount);
        setBjtotalfee(bjtotalfee);
        //setYingshou(yingshou);
        //setYouhang(zhekou);
    }
     public Shengji8xian(String jigou,String jigou2,String mailcount,String jiaoyima,String shishou,String mailcount1,String shishou1,String bjmailcount,String bjtotalfee){
        setJigou(jigou);
        setJigou2(jigou2);
        setMailcount(mailcount);
        setJiaoyima(jiaoyima);
        setShishou(shishou);
        setMailcount1(mailcount1);
        //setJiaoyima(jiaoyima);
        setShishou1(shishou1);
        setBjmailcount(bjmailcount);
        setBjtotalfee(bjtotalfee);
        //setYingshou(yingshou);
        //setYouhang(zhekou);
    }
    public ArrayList<Shengji8xian> getShengji(String kshijian,String jshijian,String kshijian2,String jshijian2){
        ArrayList<Shengji8xian> al = new ArrayList();
        //format.setMinimumFractionDigits(2);// 设置小数位 
        try{
//                Class.forName(driver).newInstance();
                Connection conn = MyLog.getConn();
                //and substr(prod_code,3,1) = '1'
                //String sql = "select org_sname as name,count(mail_num) as mailcount,sum(actual_total_fee) as totalfee,sum(SHOULD_PAY_TOTAL_FEE) as shouldfee from WUJIANGMAIL where CLCT_DATE >= ? and CLCT_DATE <= ? and substr(prod_code,1,1) = '4'  and substr(prod_code,8,1) = '9' and shi in(select city from shengji_city) GROUP by org_sname order by org_sname";
                String sql ="select nvl(x.name1,y.name2) as name,nvl(x.mailcount1,0) as mailcount1,nvl(x.totalfee1,0) as totalfee1,nvl(y.mailcount2,0) as mailcount2,nvl(y.totalfee2,0) as totalfee2,decode(nvl(y.mailcount2,0),0,0,round((nvl(x.mailcount1,0)-nvl(y.mailcount2,0))/nvl(y.mailcount2,0)*100,2))||'%' as bjmailcount,decode(nvl(y.totalfee2,0),0,0,round((nvl(x.totalfee1,0)-nvl(y.totalfee2,0))/nvl(y.totalfee2,0)*100,2))||'%' as bjtotalfee from " +
"(select org_sname as name1,count(mail_num) as mailcount1,sum(actual_total_fee) as totalfee1  from WUJIANGMAIL where CLCT_DATE >= ? and CLCT_DATE <= ? and substring(prod_code,1,1) = '4'  and substring(prod_code,8,1) = '9' and shi in(select city from shengji_city) GROUP by org_sname) x " +
"full join " +
"(select org_sname as name2,count(mail_num) as mailcount2,sum(actual_total_fee) as totalfee2  from WUJIANGMAIL where CLCT_DATE >= ? and CLCT_DATE <= ? and substring(prod_code,1,1) = '4'  and substring(prod_code,8,1) = '9' and shi in(select city from shengji_city) GROUP by org_sname) y " +
"on x.name1 = y.name2";
                
                String sqlt = "select x.mailcount1,x.totalfee1,y.mailcount2,y.totalfee2,round((x.mailcount1-y.mailcount2)/y.mailcount2*100,2)||'%' as bjmailcount,round((x.totalfee1-y.totalfee2)/y.totalfee2*100,2)||'%' as bjtotalfee from " +
"(select count(mail_num) as mailcount1,sum(actual_total_fee) as totalfee1 from WUJIANGMAIL where CLCT_DATE >= ? and CLCT_DATE <= ? and substring(prod_code,1,1) = '4'  and substring(prod_code,8,1) = '9' and shi in(select city from shengji_city)) x " +
"full join " +
"(select count(mail_num) as mailcount2,sum(actual_total_fee) as totalfee2 from WUJIANGMAIL where CLCT_DATE >= ? and CLCT_DATE <= ? and substring(prod_code,1,1) = '4'  and substring(prod_code,8,1) = '9' and shi in(select city from shengji_city)) y " +
"on 1=1";
                String sql2 = "select shi as name,count(mail_num) as mailcount,sum(actual_total_fee) as totalfee,sum(SHOULD_PAY_TOTAL_FEE) as shouldfee from WUJIANGMAIL where CLCT_DATE >= ? and CLCT_DATE <= ? and substring(prod_code,1,1) = '4'  and substring(prod_code,8,1) = '9' and shi in(select city from shengji_city) GROUP by shi ";
                String sqlt2 = "select count(mail_num) as mailcount,sum(actual_total_fee) as totalfee,sum(SHOULD_PAY_TOTAL_FEE) as shouldfee from WUJIANGMAIL where CLCT_DATE >= ? and CLCT_DATE <= ? and substring(prod_code,1,1) = '4' and substring(prod_code,8,1) = '9' and shi in(select city from shengji_city) ";
                
                PreparedStatement pstmt = conn.prepareStatement(sql);
                //System.out.println(request.getParameter("kshijian").replace("-", ""));
                pstmt.setString(1, kshijian);
                pstmt.setString(2, jshijian);
                pstmt.setString(3, kshijian2);
                pstmt.setString(4, jshijian2);
                ResultSet rs =pstmt.executeQuery();
                
                while(rs.next()){
                    Shengji8xian z = new Shengji8xian(rs.getString("name"),rs.getString("mailcount1"),"标快",rs.getString("totalfee1"),rs.getString("mailcount2"),rs.getString("totalfee2"),rs.getString("bjmailcount"),rs.getString("bjtotalfee"));
                    
                        //z.setYouhang("错误");
                    
                        //z.setYouhang(String.valueOf(format.format(rs.getDouble("totalfee")/rs.getDouble("shouldfee"))));
                    
                    al.add(z);
                    //al.add(t);
                    //out.println("<tr><td>"+rs.getString("name")+"</td>");
                    //out.println("<td>"+rs.getString("mailcount")+"</td>");
                    //out.println("<td>"+rs.getString("fee")+"</td></tr>");
                    //out.println("<tr><td>:</td><td>"+rs.getString(4)+"</td></tr>");
                               }
                rs.close();
                pstmt.close();
                
                pstmt = conn.prepareStatement(sqlt);
                pstmt.setString(1, kshijian);
                pstmt.setString(2, jshijian);
                pstmt.setString(3, kshijian2);
                pstmt.setString(4, jshijian2);
                rs = pstmt.executeQuery();
                while(rs.next()){
                    Shengji8xian z = new Shengji8xian("合计",rs.getString("mailcount1"),"标快",rs.getString("totalfee1"),rs.getString("mailcount2"),rs.getString("totalfee2"),rs.getString("bjmailcount"),rs.getString("bjtotalfee"));
                    //if("0".equals(rs.getString("shouldfee"))){
                        //z.setYouhang("错误");
                    //}else{
                        //z.setYouhang(String.valueOf(format.format(rs.getDouble("totalfee")/rs.getDouble("shouldfee"))));
                    //}
                    al.add(z);
                    //out.println("<tr><td>合计</td>");
                    //out.println("<td>"+rs.getString("mailcount")+"</td>");
                    //out.println("<td>"+rs.getString("fee")+"</td></tr>");
                }
                rs.close();
                pstmt.close();
                MyLog.close(conn);
        }catch(SQLException sqle){
            sqle.printStackTrace();
            MyLog.logtooracle(jigou, sqle);
        }catch(ClassNotFoundException cnfe){
            cnfe.printStackTrace();
            MyLog.logtooracle(jigou, cnfe);
        }catch(InstantiationException ie ){
            ie.printStackTrace();
            MyLog.logtooracle(jigou, ie);
        }catch(IllegalAccessException iae){
            iae.printStackTrace();
            MyLog.logtooracle(jigou, iae);
        }
        return al;
    }
     public ArrayList<Shengji8xian> getShengji(String kshijian,String jshijian){
        ArrayList<Shengji8xian> al = new ArrayList();
        //format.setMinimumFractionDigits(2);// 设置小数位 
        try{
//                Class.forName(driver).newInstance();
                Connection conn = MyLog.getConn();
                //and substr(prod_code,3,1) = '1'
                String sql = "select org_sname as name,count(mail_num) as mailcount,sum(actual_total_fee) as totalfee,sum(SHOULD_PAY_TOTAL_FEE) as shouldfee from WUJIANGMAIL where CLCT_DATE >= ? and CLCT_DATE <= ? and SUBSTRING(prod_code,1,1) = '4'  and SUBSTRING(prod_code,8,1) = '9' and shi in(select city from shengji_city) GROUP by org_sname order by org_sname";
                /*String sql ="select nvl(x.name1,y.name2) as name,nvl(x.mailcount1,0) as mailcount1,nvl(x.totalfee1,0) as totalfeecount1,nvl(y.mailcount2,0) as mailcount2,nvl(y.totalfee2,0) as totalfee2,round((nvl(x.mailcount1,0)-nvl(y.mailcount2,0))/nvl(y.mailcount2,0)*100,2)||'%' as bjmailcount,round((nvl(x.totalfee1,0)-nvl(y.totalfee2,0))/nvl(y.totalfee2,0)*100,2)||'%' as bjtotalfee from " +
"(select org_sname as name1,count(mail_num) as mailcount1,sum(actual_total_fee) as totalfee1  from WUJIANGMAIL where CLCT_DATE >= ? and CLCT_DATE <= ? and substr(prod_code,1,1) = '4'  and substr(prod_code,8,1) = '9' and shi in(select city from shengji_city) GROUP by org_sname) x " +
"full join " +
"(select org_sname as name2,count(mail_num) as mailcount2,sum(actual_total_fee) as totalfee2  from WUJIANGMAIL where CLCT_DATE >= ? and CLCT_DATE <= ? and substr(prod_code,1,1) = '4'  and substr(prod_code,8,1) = '9' and shi in(select city from shengji_city) GROUP by org_sname) y " +
"on x.name1 = y.name2";
                
                String sqlt = "select x.mailcount1,x.totalfee1,y.mailcount2,y.totalfee2,round((x.mailcount1-y.mailcount2)/y.mailcount2*100,2)||'%' as bjmailcount,round((x.totalfee1-y.totalfee2)/y.totalfee2*100,2)||'%' as bjtotalfee from " +
"(select count(mail_num) as mailcount1,sum(actual_total_fee) as totalfee1 from WUJIANGMAIL where CLCT_DATE >= '20140601' and CLCT_DATE <= '20140631' and substr(prod_code,1,1) = '4'  and substr(prod_code,8,1) = '9' and shi in(select city from shengji_city)) x " +
"full join " +
"(select count(mail_num) as mailcount2,sum(actual_total_fee) as totalfee2 from WUJIANGMAIL where CLCT_DATE >= '20140501' and CLCT_DATE <= '20140531' and substr(prod_code,1,1) = '4'  and substr(prod_code,8,1) = '9' and shi in(select city from shengji_city)) y " +
"on 1=1";
                        */
                String sql2 = "select shi as name,count(mail_num) as mailcount,sum(actual_total_fee) as totalfee,sum(SHOULD_PAY_TOTAL_FEE) as shouldfee from WUJIANGMAIL where CLCT_DATE >= ? and CLCT_DATE <= ? and SUBSTRING(prod_code,1,1) = '4'  and SUBSTRING(prod_code,8,1) = '9' and shi in(select city from shengji_city) GROUP by shi ";
                String sqlt = "select count(mail_num) as mailcount,sum(actual_total_fee) as totalfee,sum(SHOULD_PAY_TOTAL_FEE) as shouldfee from WUJIANGMAIL where CLCT_DATE >= ? and CLCT_DATE <= ? and SUBSTRING(prod_code,1,1) = '4' and SUBSTRING(prod_code,8,1) = '9' and shi in(select city from shengji_city) ";
                
                PreparedStatement pstmt = conn.prepareStatement(sql);
                //System.out.println(request.getParameter("kshijian").replace("-", ""));
                pstmt.setString(1, kshijian);
                pstmt.setString(2, jshijian);
                //pstmt.setString(3, kshijian2);
                //pstmt.setString(4, jshijian2);
                ResultSet rs =pstmt.executeQuery();
                
                while(rs.next()){
                    Shengji8xian z = new Shengji8xian(rs.getString("name"),rs.getString("mailcount"),"标快",rs.getString("totalfee"),rs.getString("shouldfee"));
                    
                        //z.setYouhang("错误");
                    
                        //z.setYouhang(String.valueOf(format.format(rs.getDouble("totalfee")/rs.getDouble("shouldfee"))));
                    
                    al.add(z);
                    //al.add(t);
                    //out.println("<tr><td>"+rs.getString("name")+"</td>");
                    //out.println("<td>"+rs.getString("mailcount")+"</td>");
                    //out.println("<td>"+rs.getString("fee")+"</td></tr>");
                    //out.println("<tr><td>:</td><td>"+rs.getString(4)+"</td></tr>");
                               }
                rs.close();
                pstmt.close();
                
                pstmt = conn.prepareStatement(sqlt);
                pstmt.setString(1, kshijian);
                pstmt.setString(2, jshijian);
                //pstmt.setString(3, kshijian2);
                //pstmt.setString(4, jshijian2);
                rs = pstmt.executeQuery();
                while(rs.next()){
                     Shengji8xian z = new Shengji8xian("合计",rs.getString("mailcount"),"标快",rs.getString("totalfee"),rs.getString("shouldfee"));
                    //if("0".equals(rs.getString("shouldfee"))){
                        //z.setYouhang("错误");
                    //}else{
                        //z.setYouhang(String.valueOf(format.format(rs.getDouble("totalfee")/rs.getDouble("shouldfee"))));
                    //}
                    al.add(z);
                    //out.println("<tr><td>合计</td>");
                    //out.println("<td>"+rs.getString("mailcount")+"</td>");
                    //out.println("<td>"+rs.getString("fee")+"</td></tr>");
                }
                rs.close();
                pstmt.close();
                MyLog.close(conn);
        }catch(SQLException sqle){
            sqle.printStackTrace();
            MyLog.logtooracle(jigou, sqle);
        }catch(ClassNotFoundException cnfe){
            cnfe.printStackTrace();
            MyLog.logtooracle(jigou, cnfe);
        }catch(InstantiationException ie ){
            ie.printStackTrace();
            MyLog.logtooracle(jigou, ie);
        }catch(IllegalAccessException iae){
            iae.printStackTrace();
            MyLog.logtooracle(jigou, iae);
        }
        return al;
    }
    public ArrayList<Shengji8xian> getShengjibyshi(String kshijian,String jshijian,String kshijian2,String jshijian2){
        ArrayList<Shengji8xian> al = new ArrayList();
        //format.setMinimumFractionDigits(2);// 设置小数位 
        try{
//                Class.forName(driver).newInstance();
                Connection conn = MyLog.getConn();
                //String sql = "select org_sname as name,count(mail_num) as mailcount,sum(actual_total_fee) as totalfee,sum(SHOULD_PAY_TOTAL_FEE) as shouldfee from WUJIANGMAIL where CLCT_DATE >= ? and CLCT_DATE <= ? and substr(prod_code,1,1) = '4' and substr(prod_code,3,1) = '1' and substr(prod_code,8,1) = '9' and shi in(select city from biaokuai_city) GROUP by org_sname order by org_sname";
                //String sqlt = "select count(mail_num) as mailcount,sum(actual_total_fee) as totalfee,sum(SHOULD_PAY_TOTAL_FEE) as shouldfee from WUJIANGMAIL where CLCT_DATE >= ? and CLCT_DATE <= ? and substr(prod_code,1,1) = '4' and substr(prod_code,3,1) = '1' and substr(prod_code,8,1) = '9' and shi in(select city from biaokuai_city) ";
                //and substr(prod_code,3,1) = '1'
                //String sql = "select shi as name,count(mail_num) as mailcount,sum(actual_total_fee) as totalfee,sum(SHOULD_PAY_TOTAL_FEE) as shouldfee from WUJIANGMAIL where CLCT_DATE >= ? and CLCT_DATE <= ? and substr(prod_code,1,1) = '4'  and substr(prod_code,8,1) = '9' and shi in(select city from shengji_city) GROUP by shi ";
                //String sqlt = "select count(mail_num) as mailcount,sum(actual_total_fee) as totalfee,sum(SHOULD_PAY_TOTAL_FEE) as shouldfee from WUJIANGMAIL where CLCT_DATE >= ? and CLCT_DATE <= ? and substr(prod_code,1,1) = '4'  and substr(prod_code,8,1) = '9' and shi in(select city from shengji_city) ";
                String sql ="select nvl(x.name1,y.name2) as name,nvl(x.mailcount1,0) as mailcount1,nvl(x.totalfee1,0) as totalfee1,nvl(y.mailcount2,0) as mailcount2,nvl(y.totalfee2,0) as totalfee2,decode(nvl(y.mailcount2,0),0,0,round((nvl(x.mailcount1,0)-nvl(y.mailcount2,0))/nvl(y.mailcount2,0)*100,2))||'%' as bjmailcount,decode(nvl(y.totalfee2,0),0,0,round((nvl(x.totalfee1,0)-nvl(y.totalfee2,0))/nvl(y.totalfee2,0)*100,2))||'%' as bjtotalfee from " +
"(select shi as name1,count(mail_num) as mailcount1,sum(actual_total_fee) as totalfee1  from WUJIANGMAIL where CLCT_DATE >= ? and CLCT_DATE <= ? and SUBSTRING(prod_code,1,1) = '4'  and SUBSTRING(prod_code,8,1) = '9' and shi in(select city from shengji_city) GROUP by shi) x " +
"full join " +
"(select shi as name2,count(mail_num) as mailcount2,sum(actual_total_fee) as totalfee2  from WUJIANGMAIL where CLCT_DATE >= ? and CLCT_DATE <= ? and SUBSTRING(prod_code,1,1) = '4'  and SUBSTRING(prod_code,8,1) = '9' and shi in(select city from shengji_city) GROUP by shi) y " +
"on x.name1 = y.name2";
                
                String sqlt = "select x.mailcount1,x.totalfee1,y.mailcount2,y.totalfee2,round((x.mailcount1-y.mailcount2)/y.mailcount2*100,2)||'%' as bjmailcount,round((x.totalfee1-y.totalfee2)/y.totalfee2*100,2)||'%' as bjtotalfee from " +
"(select count(mail_num) as mailcount1,sum(actual_total_fee) as totalfee1 from WUJIANGMAIL where CLCT_DATE >= ? and CLCT_DATE <= ? and substr(prod_code,1,1) = '4'  and substr(prod_code,8,1) = '9' and shi in(select city from shengji_city)) x " +
"full join " +
"(select count(mail_num) as mailcount2,sum(actual_total_fee) as totalfee2 from WUJIANGMAIL where CLCT_DATE >= ? and CLCT_DATE <= ? and substr(prod_code,1,1) = '4'  and substr(prod_code,8,1) = '9' and shi in(select city from shengji_city)) y " +
"on 1=1";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                //System.out.println(request.getParameter("kshijian").replace("-", ""));
                pstmt.setString(1, kshijian);
                pstmt.setString(2, jshijian);
                pstmt.setString(3, kshijian2);
                pstmt.setString(4, jshijian2);
                ResultSet rs =pstmt.executeQuery();
                
                while(rs.next()){
                    Shengji8xian z = new Shengji8xian(rs.getString("name"),rs.getString("mailcount1"),"标快",rs.getString("totalfee1"),rs.getString("mailcount2"),rs.getString("totalfee2"),rs.getString("bjmailcount"),rs.getString("bjtotalfee"));
                    
                        //z.setYouhang("错误");
                    
                        //z.setYouhang(String.valueOf(format.format(rs.getDouble("totalfee")/rs.getDouble("shouldfee"))));
                    
                    al.add(z);
                    //al.add(t);
                    //out.println("<tr><td>"+rs.getString("name")+"</td>");
                    //out.println("<td>"+rs.getString("mailcount")+"</td>");
                    //out.println("<td>"+rs.getString("fee")+"</td></tr>");
                    //out.println("<tr><td>:</td><td>"+rs.getString(4)+"</td></tr>");
                               }
                rs.close();
                pstmt.close();
                
                pstmt = conn.prepareStatement(sqlt);
                pstmt.setString(1, kshijian);
                pstmt.setString(2, jshijian);
                pstmt.setString(3, kshijian2);
                pstmt.setString(4, jshijian2);
                rs = pstmt.executeQuery();
                while(rs.next()){
                    Shengji8xian z = new Shengji8xian("合计",rs.getString("mailcount1"),"标快",rs.getString("totalfee1"),rs.getString("mailcount2"),rs.getString("totalfee2"),rs.getString("bjmailcount"),rs.getString("bjtotalfee"));
                    //if("0".equals(rs.getString("shouldfee"))){
                        //z.setYouhang("错误");
                    //}else{
                        //z.setYouhang(String.valueOf(format.format(rs.getDouble("totalfee")/rs.getDouble("shouldfee"))));
                    //}
                    al.add(z);
                    //out.println("<tr><td>合计</td>");
                    //out.println("<td>"+rs.getString("mailcount")+"</td>");
                    //out.println("<td>"+rs.getString("fee")+"</td></tr>");
                }
                rs.close();
                pstmt.close();
                MyLog.close(conn);
        }catch(SQLException sqle){
            sqle.printStackTrace();
            MyLog.logtooracle(jigou, sqle);
        }catch(ClassNotFoundException cnfe){
            cnfe.printStackTrace();
            MyLog.logtooracle(jigou, cnfe);
        }catch(InstantiationException ie ){
            ie.printStackTrace();
            MyLog.logtooracle(jigou, ie);
        }catch(IllegalAccessException iae){
            iae.printStackTrace();
            MyLog.logtooracle(jigou, iae);
        }
        return al;
    }
    
    //getShengjibyjishi
    
    public ArrayList<Shengji8xian> getShengjibyjishi(String kshijian,String jshijian){
        ArrayList<Shengji8xian> al = new ArrayList();
        //format.setMinimumFractionDigits(2);// 设置小数位 
        try{
//                Class.forName(driver).newInstance();
                Connection conn = MyLog.getConn();
                //String sql = "select org_sname as name,count(mail_num) as mailcount,sum(actual_total_fee) as totalfee,sum(SHOULD_PAY_TOTAL_FEE) as shouldfee from WUJIANGMAIL where CLCT_DATE >= ? and CLCT_DATE <= ? and substr(prod_code,1,1) = '4' and substr(prod_code,3,1) = '1' and substr(prod_code,8,1) = '9' and shi in(select city from biaokuai_city) GROUP by org_sname order by org_sname";
                //String sqlt = "select count(mail_num) as mailcount,sum(actual_total_fee) as totalfee,sum(SHOULD_PAY_TOTAL_FEE) as shouldfee from WUJIANGMAIL where CLCT_DATE >= ? and CLCT_DATE <= ? and substr(prod_code,1,1) = '4' and substr(prod_code,3,1) = '1' and substr(prod_code,8,1) = '9' and shi in(select city from biaokuai_city) ";
                //and substr(prod_code,3,1) = '1'
                String sql = "select shi as name,org_sname as name2,count(mail_num) as mailcount,sum(actual_total_fee) as totalfee,sum(SHOULD_PAY_TOTAL_FEE) as shouldfee from WUJIANGMAIL where CLCT_DATE >= ? and CLCT_DATE <= ? and substring(prod_code,1,1) = '4'  and substring(prod_code,8,1) = '9' and shi in(select city from shengji_city) GROUP by shi,org_sname order by  shi";
                //String sqlt = "select count(mail_num) as mailcount,sum(actual_total_fee) as totalfee,sum(SHOULD_PAY_TOTAL_FEE) as shouldfee from WUJIANGMAIL where CLCT_DATE >= ? and CLCT_DATE <= ? and substring(prod_code,1,1) = '4'  and substring(prod_code,8,1) = '9' and shi in(select city from shengji_city) ";
                /*String sql ="select nvl(x.name1,y.name2) as name,nvl(x.mailcount1,0) as mailcount1,nvl(x.totalfee1,0) as totalfeecount1,nvl(y.mailcount2,0) as mailcount2,nvl(y.totalfee2,0) as totalfee2,round((nvl(x.mailcount1,0)-nvl(y.mailcount2,0))/nvl(y.mailcount2,0)*100,2)||'%' as bjmailcount,round((nvl(x.totalfee1,0)-nvl(y.totalfee2,0))/nvl(y.totalfee2,0)*100,2)||'%' as bjtotalfee from " +
"(select shi as name1,count(mail_num) as mailcount1,sum(actual_total_fee) as totalfee1  from WUJIANGMAIL where CLCT_DATE >= ? and CLCT_DATE <= ? and substr(prod_code,1,1) = '4'  and substr(prod_code,8,1) = '9' and shi in(select city from shengji_city) GROUP by shi) x " +
"full join " +
"(select shi as name2,count(mail_num) as mailcount2,sum(actual_total_fee) as totalfee2  from WUJIANGMAIL where CLCT_DATE >= ? and CLCT_DATE <= ? and substr(prod_code,1,1) = '4'  and substr(prod_code,8,1) = '9' and shi in(select city from shengji_city) GROUP by shi) y " +
"on x.name1 = y.name2";
                
                String sqlt = "select x.mailcount1,x.totalfee1,y.mailcount2,y.totalfee2,round((x.mailcount1-y.mailcount2)/y.mailcount2*100,2)||'%' as bjmailcount,round((x.totalfee1-y.totalfee2)/y.totalfee2*100,2)||'%' as bjtotalfee from " +
"(select count(mail_num) as mailcount1,sum(actual_total_fee) as totalfee1 from WUJIANGMAIL where CLCT_DATE >= '20140601' and CLCT_DATE <= '20140631' and substr(prod_code,1,1) = '4'  and substr(prod_code,8,1) = '9' and shi in(select city from shengji_city)) x " +
"full join " +
"(select count(mail_num) as mailcount2,sum(actual_total_fee) as totalfee2 from WUJIANGMAIL where CLCT_DATE >= '20140501' and CLCT_DATE <= '20140531' and substr(prod_code,1,1) = '4'  and substr(prod_code,8,1) = '9' and shi in(select city from shengji_city)) y " +
"on 1=1";*/
                PreparedStatement pstmt = conn.prepareStatement(sql);
                //System.out.println(request.getParameter("kshijian").replace("-", ""));
                pstmt.setString(1, kshijian);
                pstmt.setString(2, jshijian);
                //pstmt.setString(3, kshijian2);
                //pstmt.setString(4, jshijian2);
                ResultSet rs =pstmt.executeQuery();
                
                while(rs.next()){
                    //Shengji8xian z = new Shengji8xian(rs.getString("name"),rs.getString("mailcount"),"标快",rs.getString("totalfee"),rs.getString("mailcount1"),rs.getString("totalfee1"),rs.getString("bjmailcount"),rs.getString("bjtotalfee"));
                    Shengji8xian z = new Shengji8xian(rs.getString("name"),rs.getString("name2"),rs.getString("mailcount"),"标快",rs.getString("totalfee"),rs.getString("shouldfee"));
                        //z.setYouhang("错误");
                    
                        //z.setYouhang(String.valueOf(format.format(rs.getDouble("totalfee")/rs.getDouble("shouldfee"))));
                    
                    al.add(z);
                    //al.add(t);
                    //out.println("<tr><td>"+rs.getString("name")+"</td>");
                    //out.println("<td>"+rs.getString("mailcount")+"</td>");
                    //out.println("<td>"+rs.getString("fee")+"</td></tr>");
                    //out.println("<tr><td>:</td><td>"+rs.getString(4)+"</td></tr>");
                               }
                rs.close();
                pstmt.close();
                
                //pstmt = conn.prepareStatement(sqlt);
               // pstmt.setString(1, kshijian);
               // pstmt.setString(2, jshijian);
                //pstmt.setString(3, kshijian2);
                //pstmt.setString(4, jshijian2);
               // rs = pstmt.executeQuery();
               // while(rs.next()){
                    //Shengji8xian z = new Shengji8xian("合计",rs.getString("mailcount1"),"标快",rs.getString("totalfee1"),rs.getString("mailcount2"),rs.getString("totalfee2"),rs.getString("bjmailcount"),rs.getString("bjtotalfee"));
                //    Shengji8xian z = new Shengji8xian("合计",rs.getString("mailcount"),"标快",rs.getString("totalfee"),rs.getString("shouldfee"));
//if("0".equals(rs.getString("shouldfee"))){
                        //z.setYouhang("错误");
                    //}else{
                        //z.setYouhang(String.valueOf(format.format(rs.getDouble("totalfee")/rs.getDouble("shouldfee"))));
                    //}
                 //   al.add(z);
                    //out.println("<tr><td>合计</td>");
                    //out.println("<td>"+rs.getString("mailcount")+"</td>");
                    //out.println("<td>"+rs.getString("fee")+"</td></tr>");
               // }
              //  rs.close();
               // pstmt.close();
                MyLog.close(conn);
        }catch(SQLException sqle){
            sqle.printStackTrace();
            MyLog.logtooracle(jigou, sqle);
        }catch(ClassNotFoundException cnfe){
            cnfe.printStackTrace();
            MyLog.logtooracle(jigou, cnfe);
        }catch(InstantiationException ie ){
            ie.printStackTrace();
            MyLog.logtooracle(jigou, ie);
        }catch(IllegalAccessException iae){
            iae.printStackTrace();
            MyLog.logtooracle(jigou, iae);
        }
        return al;
    }
    
    
    
    public ArrayList<Shengji8xian> getShengjibyshi(String kshijian,String jshijian){
        ArrayList<Shengji8xian> al = new ArrayList();
        //format.setMinimumFractionDigits(2);// 设置小数位 
        try{
//                Class.forName(driver).newInstance();
                Connection conn = MyLog.getConn();
                //String sql = "select org_sname as name,count(mail_num) as mailcount,sum(actual_total_fee) as totalfee,sum(SHOULD_PAY_TOTAL_FEE) as shouldfee from WUJIANGMAIL where CLCT_DATE >= ? and CLCT_DATE <= ? and substr(prod_code,1,1) = '4' and substr(prod_code,3,1) = '1' and substr(prod_code,8,1) = '9' and shi in(select city from biaokuai_city) GROUP by org_sname order by org_sname";
                //String sqlt = "select count(mail_num) as mailcount,sum(actual_total_fee) as totalfee,sum(SHOULD_PAY_TOTAL_FEE) as shouldfee from WUJIANGMAIL where CLCT_DATE >= ? and CLCT_DATE <= ? and substr(prod_code,1,1) = '4' and substr(prod_code,3,1) = '1' and substr(prod_code,8,1) = '9' and shi in(select city from biaokuai_city) ";
                //and substr(prod_code,3,1) = '1'
                String sql = "select shi as name,count(mail_num) as mailcount,sum(actual_total_fee) as totalfee,sum(SHOULD_PAY_TOTAL_FEE) as shouldfee from WUJIANGMAIL where CLCT_DATE >= ? and CLCT_DATE <= ? and substring(prod_code,1,1) = '4'  and substring(prod_code,8,1) = '9' and shi in(select city from shengji_city) GROUP by shi ";
                String sqlt = "select count(mail_num) as mailcount,sum(actual_total_fee) as totalfee,sum(SHOULD_PAY_TOTAL_FEE) as shouldfee from WUJIANGMAIL where CLCT_DATE >= ? and CLCT_DATE <= ? and substring(prod_code,1,1) = '4'  and substring(prod_code,8,1) = '9' and shi in(select city from shengji_city) ";
                /*String sql ="select nvl(x.name1,y.name2) as name,nvl(x.mailcount1,0) as mailcount1,nvl(x.totalfee1,0) as totalfeecount1,nvl(y.mailcount2,0) as mailcount2,nvl(y.totalfee2,0) as totalfee2,round((nvl(x.mailcount1,0)-nvl(y.mailcount2,0))/nvl(y.mailcount2,0)*100,2)||'%' as bjmailcount,round((nvl(x.totalfee1,0)-nvl(y.totalfee2,0))/nvl(y.totalfee2,0)*100,2)||'%' as bjtotalfee from " +
"(select shi as name1,count(mail_num) as mailcount1,sum(actual_total_fee) as totalfee1  from WUJIANGMAIL where CLCT_DATE >= ? and CLCT_DATE <= ? and substr(prod_code,1,1) = '4'  and substr(prod_code,8,1) = '9' and shi in(select city from shengji_city) GROUP by shi) x " +
"full join " +
"(select shi as name2,count(mail_num) as mailcount2,sum(actual_total_fee) as totalfee2  from WUJIANGMAIL where CLCT_DATE >= ? and CLCT_DATE <= ? and substr(prod_code,1,1) = '4'  and substr(prod_code,8,1) = '9' and shi in(select city from shengji_city) GROUP by shi) y " +
"on x.name1 = y.name2";
                
                String sqlt = "select x.mailcount1,x.totalfee1,y.mailcount2,y.totalfee2,round((x.mailcount1-y.mailcount2)/y.mailcount2*100,2)||'%' as bjmailcount,round((x.totalfee1-y.totalfee2)/y.totalfee2*100,2)||'%' as bjtotalfee from " +
"(select count(mail_num) as mailcount1,sum(actual_total_fee) as totalfee1 from WUJIANGMAIL where CLCT_DATE >= '20140601' and CLCT_DATE <= '20140631' and substr(prod_code,1,1) = '4'  and substr(prod_code,8,1) = '9' and shi in(select city from shengji_city)) x " +
"full join " +
"(select count(mail_num) as mailcount2,sum(actual_total_fee) as totalfee2 from WUJIANGMAIL where CLCT_DATE >= '20140501' and CLCT_DATE <= '20140531' and substr(prod_code,1,1) = '4'  and substr(prod_code,8,1) = '9' and shi in(select city from shengji_city)) y " +
"on 1=1";*/
                PreparedStatement pstmt = conn.prepareStatement(sql);
                //System.out.println(request.getParameter("kshijian").replace("-", ""));
                pstmt.setString(1, kshijian);
                pstmt.setString(2, jshijian);
                //pstmt.setString(3, kshijian2);
                //pstmt.setString(4, jshijian2);
                ResultSet rs =pstmt.executeQuery();
                
                while(rs.next()){
                    //Shengji8xian z = new Shengji8xian(rs.getString("name"),rs.getString("mailcount"),"标快",rs.getString("totalfee"),rs.getString("mailcount1"),rs.getString("totalfee1"),rs.getString("bjmailcount"),rs.getString("bjtotalfee"));
                    Shengji8xian z = new Shengji8xian(rs.getString("name"),rs.getString("mailcount"),"标快",rs.getString("totalfee"),rs.getString("shouldfee"));
                        //z.setYouhang("错误");
                    
                        //z.setYouhang(String.valueOf(format.format(rs.getDouble("totalfee")/rs.getDouble("shouldfee"))));
                    
                    al.add(z);
                    //al.add(t);
                    //out.println("<tr><td>"+rs.getString("name")+"</td>");
                    //out.println("<td>"+rs.getString("mailcount")+"</td>");
                    //out.println("<td>"+rs.getString("fee")+"</td></tr>");
                    //out.println("<tr><td>:</td><td>"+rs.getString(4)+"</td></tr>");
                               }
                rs.close();
                pstmt.close();
                
                pstmt = conn.prepareStatement(sqlt);
                pstmt.setString(1, kshijian);
                pstmt.setString(2, jshijian);
                //pstmt.setString(3, kshijian2);
                //pstmt.setString(4, jshijian2);
                rs = pstmt.executeQuery();
                while(rs.next()){
                    //Shengji8xian z = new Shengji8xian("合计",rs.getString("mailcount1"),"标快",rs.getString("totalfee1"),rs.getString("mailcount2"),rs.getString("totalfee2"),rs.getString("bjmailcount"),rs.getString("bjtotalfee"));
                    Shengji8xian z = new Shengji8xian("合计",rs.getString("mailcount"),"标快",rs.getString("totalfee"),rs.getString("shouldfee"));
//if("0".equals(rs.getString("shouldfee"))){
                        //z.setYouhang("错误");
                    //}else{
                        //z.setYouhang(String.valueOf(format.format(rs.getDouble("totalfee")/rs.getDouble("shouldfee"))));
                    //}
                    al.add(z);
                    //out.println("<tr><td>合计</td>");
                    //out.println("<td>"+rs.getString("mailcount")+"</td>");
                    //out.println("<td>"+rs.getString("fee")+"</td></tr>");
                }
                rs.close();
                pstmt.close();
                MyLog.close(conn);
        }catch(SQLException sqle){
            sqle.printStackTrace();
            MyLog.logtooracle(jigou, sqle);
        }catch(ClassNotFoundException cnfe){
            cnfe.printStackTrace();
            MyLog.logtooracle(jigou, cnfe);
        }catch(InstantiationException ie ){
            ie.printStackTrace();
            MyLog.logtooracle(jigou, ie);
        }catch(IllegalAccessException iae){
            iae.printStackTrace();
            MyLog.logtooracle(jigou, iae);
        }
        return al;
    }
}
