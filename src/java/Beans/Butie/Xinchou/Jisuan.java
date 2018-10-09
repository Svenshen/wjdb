 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Beans.Butie.Xinchou;


import Beans.MyLog;
import Beans.Sunyi2.Guonei.Guonei;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class Jisuan {
    public static ArrayList<Mail> getMail(String sql,String kshijian,String jshijian){
        ArrayList<Mail> maillist = new ArrayList<>();
        try{
                //Mail mail;
                
                Connection conn = MyLog.getConn();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                //System.out.println(request.getParameter("kshijian").replace("-", ""));
                pstmt.setString(1, kshijian);
                pstmt.setString(2, jshijian);
                ResultSet rs =pstmt.executeQuery();
                while(rs.next()){
                    //Thread.sleep(40);
                    
                    maillist.add(new Mail(rs.getString(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getDouble(12),rs.getDouble(13),rs.getDouble(14)));
                    
                }
                rs.close();
                pstmt.close();
                MyLog.close(conn);
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return maillist;
    }
  
    public static void wancheng(String id){
        String sqlwancheng = "update butiexinchougongzuo  SET zhuangtai = '完成' where gongzuoid = ?  ";
        try{
                
                Connection conn = MyLog.getConn();
                PreparedStatement pstmt = conn.prepareStatement(sqlwancheng);
                //System.out.println(request.getParameter("kshijian").replace("-", ""));
               
                pstmt = conn.prepareStatement(sqlwancheng);
                pstmt.setString(1, id);
                pstmt.executeUpdate();
                pstmt.close();
                
                MyLog.close(conn);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void wanchengbutie(String id){
        String sqlwancheng = "update butiegongzuo  SET zhuangtai = '完成' where gongzuoid = ?  ";
        try{
                
                Connection conn = MyLog.getConn();
                PreparedStatement pstmt = conn.prepareStatement(sqlwancheng);
                //System.out.println(request.getParameter("kshijian").replace("-", ""));
               
                pstmt = conn.prepareStatement(sqlwancheng);
                pstmt.setString(1, id);
                pstmt.executeUpdate();
                pstmt.close();
                
                MyLog.close(conn);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void hengshan(String kshijian,String jshijian,String id){
        String sqlhengshan = "select MAIL_NUM,CLCT_DATE,CLCT_BUREAU_ORG_CODE,PROD_CODE,ORG_SNAME,SENDER_CUST_CODE,KEHUMINGCHENG,JIAOYIMA,SHENG,SHI,RCV_AREA,BILLING_WEIGHT,SHOULD_PAY_TOTAL_FEE,ACTUAL_TOTAL_FEE from wujiangmail where clct_date >= ? and clct_date <= ? and CLCT_BUREAU_ORG_CODE = '21522303' ";
        
        for(Mail m:getMail(sqlhengshan,kshijian,jshijian)){
                //System.out.println(m.getYoujianhao());
                new Hengshanxinchou(m).jisuanbutie();
                m.updatexinchou("横扇薪酬",id);
            }
        wancheng(id);
    }
    public static void hengshan2018(String kshijian,String jshijian,String id){
        String sqlhengshan = "select MAIL_NUM,CLCT_DATE,CLCT_BUREAU_ORG_CODE,PROD_CODE,ORG_SNAME,SENDER_CUST_CODE,KEHUMINGCHENG,JIAOYIMA,SHENG,SHI,RCV_AREA,BILLING_WEIGHT,SHOULD_PAY_TOTAL_FEE,ACTUAL_TOTAL_FEE from wujiangmail where clct_date >= ? and clct_date <= ? and CLCT_BUREAU_ORG_CODE = '21522303' ";
        new Hengshanxinchou2(kshijian,jshijian);
        for(Mail m:getMail(sqlhengshan,kshijian,jshijian)){
                //System.out.println(m.getYoujianhao());
                new Hengshanxinchou2(m).jisuanbutie();
                m.updatexinchou("横扇薪酬2018",id);
            }
        wancheng(id);
    }
public static void hengshan2018quan(String kshijian,String jshijian,String id){
        String sqlhengshan = "select MAIL_NUM,CLCT_DATE,CLCT_BUREAU_ORG_CODE,PROD_CODE,ORG_SNAME,SENDER_CUST_CODE,KEHUMINGCHENG,JIAOYIMA,SHENG,SHI,RCV_AREA,BILLING_WEIGHT,SHOULD_PAY_TOTAL_FEE,ACTUAL_TOTAL_FEE from wujiangmail where clct_date >= ? and clct_date <= ? and CLCT_BUREAU_ORG_CODE = '21522303' ";
        new Hengshanxinchou2(kshijian,jshijian);
        for(Mail m:getMail(sqlhengshan,kshijian,jshijian)){
                //System.out.println(m.getYoujianhao());
                new Hengshanxinchou3(m).jisuanbutie();
                m.updatexinchou("横扇薪酬2018",id);
            }
        wancheng(id);
    }
    public static void main(String[] args) {
        String kshijian = "20170901";
        String jshijian = "20171231";
        String sqlhengshan = "select MAIL_NUM,CLCT_DATE,CLCT_BUREAU_ORG_CODE,PROD_CODE,ORG_SNAME,SENDER_CUST_CODE,KEHUMINGCHENG,JIAOYIMA,SHENG,SHI,RCV_AREA,BILLING_WEIGHT,SHOULD_PAY_TOTAL_FEE,ACTUAL_TOTAL_FEE from wujiangmail where clct_date >= ? and clct_date <= ? and CLCT_BUREAU_ORG_CODE = '21522303' ";
        String sqlyouban = "select MAIL_NUM,CLCT_DATE,CLCT_BUREAU_ORG_CODE,PROD_CODE,ORG_SNAME,SENDER_CUST_CODE,KEHUMINGCHENG,JIAOYIMA,SHENG,SHI,RCV_AREA,BILLING_WEIGHT,SHOULD_PAY_TOTAL_FEE,ACTUAL_TOTAL_FEE from wujiangmail where clct_date >= ? and clct_date <= ? and sender_cust_code in (select kehudaima from butiexinchouyoubankehu)";
            for(Mail m:getMail(sqlhengshan,kshijian,jshijian)){
                System.out.println(m.getYoujianhao());
                new Hengshanxinchou(m).jisuanbutie();
                m.updatexinchou("横扇薪酬","20180131");
            }
            
            
        
    }
}
