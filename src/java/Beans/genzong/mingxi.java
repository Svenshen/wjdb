/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Beans.genzong;

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
public class mingxi {
    public String orgsname;
    public String mailno;
    public String days;
    public String bdays;
    public String dakehu;
    public String jidasheng;
//    private static final String driver=MyLog.driver;
    public mingxi(){
        
    }
    public mingxi (String dakehu,String orgsname,String mailno,String days,String bdays,String jidasheng){
        setorgsname(orgsname);
        setdakehu(dakehu);
        setmailno(mailno);
        setdays(days);
        setbdays(bdays);
        setjidasheng(jidasheng);
    }
    public void setjidasheng(String jidasheng){
        this.jidasheng = jidasheng;
    }
    public void setdakehu(String dakehu){
        this.dakehu = dakehu;
    }
    public void setorgsname(String orgsname){
        this.orgsname = orgsname;
    }
    public void setmailno(String mailno){
        this.mailno = mailno;
    }
    public void setdays(String days){
        this.days = days;
    }
    public void setbdays(String bdays){
        this.bdays = bdays;
    }
    public String getmailno(){
        return mailno;
    }
    public String getdays(){
        return days;
    }
    public String getbdays(){
        return bdays;
    }
    public String getdakehu(){
        return dakehu;
    }
    public String getjigou(){
        return orgsname;
    }
    public String getjidasheng(){
        return jidasheng;
    }
    public ArrayList<mingxi> getmingxi(String kshijian,String jshijian,String jigouhao){
        System.out.println(jigouhao);
        ArrayList<mingxi> al = new ArrayList();
        try{
                //Class.forName(driver).newInstance();
                Connection conn = MyLog.getConn();
                String sqlbiaozhun = "select org_sname,sender_cust_code,mail_num,days+1,biaozhun_days,sheng from wujiangmail where clct_date >= '20150901' and clct_date >= ? and clct_date <= ? and clct_bureau_org_code = ? and zhuangtai != '9' and (days+1) > biaozhun_days and mail_num like '1%' ";
                
                //String sqlbiaozhun ="select * from wujiangmail";
                PreparedStatement pstmt1 = conn.prepareStatement(sqlbiaozhun);
                pstmt1.setString(1, kshijian);
                pstmt1.setString(2, jshijian);
                pstmt1.setString(3, jigouhao);
                ResultSet rs1 = pstmt1.executeQuery();
                while(rs1.next()){
                    mingxi m = new mingxi(rs1.getString("sender_cust_code"),rs1.getString("org_sname"),rs1.getString("mail_num"),rs1.getString("days+1"),rs1.getString("biaozhun_days"),rs1.getString("sheng"));
                    al.add(m);
                }
                rs1.close();
                pstmt1.close();
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
        public ArrayList<mingxi> getmingxijingji(String kshijian,String jshijian,String jigouhao){
        //System.out.println(jigouhao);
        ArrayList<mingxi> al = new ArrayList();
        try{
//                Class.forName(driver).newInstance();
                Connection conn = MyLog.getConn();
                String sqlbiaozhun = "select org_sname,sender_cust_code,mail_num,days+1,jingji_days,sheng from wujiangmail where clct_date >= '20150901' and clct_date >= ? and clct_date <= ? and clct_bureau_org_code = ? and zhuangtai != '9' and (days+1) > jingji_days and (mail_num like '5%' or mail_num like '9%')";
                
                //String sqlbiaozhun ="select * from wujiangmail";
                PreparedStatement pstmt1 = conn.prepareStatement(sqlbiaozhun);
                pstmt1.setString(1, kshijian);
                pstmt1.setString(2, jshijian);
                pstmt1.setString(3, jigouhao);
                ResultSet rs1 = pstmt1.executeQuery();
                while(rs1.next()){
                    mingxi m = new mingxi(rs1.getString("sender_cust_code"),rs1.getString("org_sname"),rs1.getString("mail_num"),rs1.getString("days+1"),rs1.getString("jingji_days"),rs1.getString("sheng"));
                    al.add(m);
                }
                rs1.close();
                pstmt1.close();
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
