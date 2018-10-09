/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans.yisidiushi;

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
public class chukou {
    public String mailno;
    //private static final String driver=MyLog.driver;
    public String istuotou;
    public String yunshu;
    public String jigouming;
       public ArrayList<chukou> istuotou2(String mailno){
        ArrayList<chukou> jj = new ArrayList<chukou>();
        String [] mail = mailno.split("\r\n");
        for (String m : mail){
            chukou j = new chukou();
           j.mailno = m;
           if(istuotou(m) == 1){
               j.istuotou = "已妥投";
           }else{
               j.istuotou = "未妥投";
           }
           
           String [] yunshu = getyunshu(m);
           j.yunshu =yunshu[0] ;
           j.jigouming = yunshu[1] ;
           jj.add(j);
        }
        return jj;
    }
    
       public String[] getyunshu(String mailno){
           String yunshu[] = new String []{"无此邮件",""};
           
        mailno = mailno.trim();
        try{
               // Class.forName(driver).newInstance();
                Connection conn = MyLog.getConn();
                String sql = "select * from wujiangmail where MAIL_num = ?";
                
                PreparedStatement pstmt = conn.prepareStatement(sql);
                //System.out.println(request.getParameter("kshijian").replace("-", ""));
                pstmt.setString(1, mailno);
                
                ResultSet rs =pstmt.executeQuery();
                if(rs.next()){
                yunshu[0] = rs.getString("TRANS_MODE_CODE");
                yunshu[1] = rs.getString("org_sname");
                }
                rs.close();
                pstmt.close();
                
                MyLog.close(conn);
        }catch(SQLException sqle){
            sqle.printStackTrace();
            //MyLog.logtooracle(jigou, sqle);
        }catch(ClassNotFoundException cnfe){
            cnfe.printStackTrace();
            //MyLog.logtooracle(jigou, cnfe);
        }catch(InstantiationException ie ){
            ie.printStackTrace();
            //MyLog.logtooracle(jigou, ie);
        }catch(IllegalAccessException iae){
            iae.printStackTrace();
            //MyLog.logtooracle(jigou, iae);
        }
        
        return yunshu;
       }
    
    public int istuotou(String mailno){
        int istuotou = 0;
        mailno = mailno.trim();
        try{
                //Class.forName(driver).newInstance();
                Connection conn = MyLog.getConn();
                String sql = "select * from wujiangmail where mail_num = ? and zhuangtai = '9'";
                
                PreparedStatement pstmt = conn.prepareStatement(sql);
                //System.out.println(request.getParameter("kshijian").replace("-", ""));
                pstmt.setString(1, mailno);
                
                ResultSet rs =pstmt.executeQuery();

                if(rs.next()){
                    istuotou = 1;
                }
                rs.close();
                pstmt.close();
                
                MyLog.close(conn);
        }catch(SQLException sqle){
            sqle.printStackTrace();
            //MyLog.logtooracle(jigou, sqle);
        }catch(ClassNotFoundException cnfe){
            cnfe.printStackTrace();
            //MyLog.logtooracle(jigou, cnfe);
        }catch(InstantiationException ie ){
            ie.printStackTrace();
            //MyLog.logtooracle(jigou, ie);
        }catch(IllegalAccessException iae){
            iae.printStackTrace();
            //MyLog.logtooracle(jigou, iae);
        }
        
        return istuotou;
    }
}
