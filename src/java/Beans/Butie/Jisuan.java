/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Beans.Butie;

import Beans.MyLog;

import Beans.Sunyi2.Guoji.Guoji;
import Beans.Sunyi2.Guonei.Guonei;
import Beans.Sunyi2.Guonei.Luxiang;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class Jisuan {
    final static String sqlhead = "select MAIL_NUM,CLCT_DATE,CLCT_BUREAU_ORG_CODE,PROD_CODE,ORG_SNAME,SENDER_CUST_CODE,KEHUMINGCHENG,JIAOYIMA,SHENG,SHI,RCV_AREA,BILLING_WEIGHT,SHOULD_PAY_TOTAL_FEE,ACTUAL_TOTAL_FEE,BASIC_FEE,DATA_SRC_SYS  from wujiangmail ";
    
    
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
                    
                    maillist.add(new Mail(rs.getString(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getDouble(12),rs.getDouble(13),rs.getDouble(14),rs.getDouble(15),rs.getString(16)));
                    
                }
                rs.close();
                pstmt.close();
                MyLog.close(conn);
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return maillist;
    }
      public static void youban(String kshijian,String jshijian,String id){
        String sqlyouban = sqlhead+"  where clct_date >= ? and clct_date <= ? and sender_cust_code in (select kehudaima from butiexinchouyoubankehu)";
        for(Mail m:getMail(sqlyouban,kshijian,jshijian)){
                new Youbanxinchou(m).jisuanbutie();
                m.update("邮伴补贴",id);
            }
        wanchengbutie(id);
    }
    public static void fanlibutie(String kshijian,String jshijian,String gongzuoid){
        String sqlfanli = sqlhead+" where clct_date >= ? and clct_date <= ? and sender_cust_code in (select kehudaima from butiefanli)";
        new Fanlibutie(kshijian,jshijian);
            for(Mail m:getMail(sqlfanli,kshijian,jshijian)){
                //System.out.println(m.getYoujianhao());
                new Fanlibutie(m).jisuanbutie();
                m.update("返利补贴",gongzuoid);
                //Thread.sleep(40);
                
            }
            wanchengbutie(gongzuoid);
    }
    public static void zhekoubutie(String kshijian,String jshijian,String gongzuoid){
        String sqlzhekou = sqlhead+" where clct_date >= ? and clct_date <= ? and sender_cust_code in (select kehudaima from butiezhekou)";
        for(Mail m:getMail(sqlzhekou,kshijian,jshijian)){
                new Anzhekoubutie(m).jisuanbutie();
                //Task(Anzhekoubutie.class);
                m.update("按折扣补贴",gongzuoid);
                //Thread.sleep(40);
            }
            wanchengbutie(gongzuoid);
    }
    public static void shouxuzhongbutie(String kshijian,String jshijian,String gongzuoid){
        String sqlanshouxuzhong = sqlhead+" where clct_date >= ? and clct_date <= ? and sender_cust_code in (select kehudaima from butieshouxuzhong)";
        for(Mail m:getMail(sqlanshouxuzhong,kshijian,jshijian)){
                new Anshouxuzhong(m).jisuanbutie();
                m.update("按首续重补贴",gongzuoid);
               // Thread.sleep(40);
            }
            wanchengbutie(gongzuoid);
    }
    public static void anjianbutie(String kshijian,String jshijian,String gongzuoid){
        String sqlanjian = sqlhead+" where clct_date >= ? and clct_date <= ? and sender_cust_code in (select kehudaima from butieanjian)";
        for(Mail m:getMail(sqlanjian,kshijian,jshijian)){
                new Anjianbutie(m).jisuanbutie();
                m.update("按件补贴",gongzuoid);
                //Thread.sleep(40);
            }
            wanchengbutie(gongzuoid);
    }
    public static void teshubutie(String kshijian,String jshijian,String gongzuoid){
        Teshukehubutie.zhulinjiangbutie(kshijian, jshijian, gongzuoid);//朱林江
        Teshukehubutie.nuoqibutie(kshijian, jshijian, gongzuoid);//诺奇
        
        /**
         传资橡塑
        传资橡塑
        传资橡塑
        传资橡塑
        岩亦砚
        世纪龙/胡泽宝
        世纪龙/胡泽宝
        吴永峰
        吴永峰
        德里卡西
        鹏诺纺织
        泰宇
        盈宇
        特嘉纺织

         */
        Teshukehubutie.chuanzibutie(kshijian, jshijian, gongzuoid);
        Teshukehubutie.yanyiyanbutie(kshijian, jshijian, gongzuoid);
        Teshukehubutie.shijilongbutie(kshijian, jshijian, gongzuoid);
        Teshukehubutie.wuyongfengbutie(kshijian, jshijian, gongzuoid);
        Teshukehubutie.delikaxibutie(kshijian, jshijian, gongzuoid);
        Teshukehubutie.pengnuobutie(kshijian, jshijian, gongzuoid);
        Teshukehubutie.qinyubutie(kshijian, jshijian, gongzuoid);
        Teshukehubutie.yingyubutie(kshijian, jshijian, gongzuoid);
        Teshukehubutie.tejiafangzhibutie(kshijian, jshijian, gongzuoid);
        
        
        
        wanchengbutie(gongzuoid);
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
    public static void main(String[] args) {
        teshubutie("20180201","20180228","1520408551870");
    }
    public static void main2(String[] args) throws InterruptedException {
        String kshijian = "20171111";
        String jshijian = "20171120";
        String gongzuoid = "1";
        String sqlanshouxuzhong = sqlhead+" where clct_date >= ? and clct_date <= ? and sender_cust_code in (select kehudaima from butieshouxuzhong)";
        String sqlanjian = sqlhead+" where clct_date >= ? and clct_date <= ? and sender_cust_code in (select kehudaima from butieanjian)";
        String sqlfanli = sqlhead+" where clct_date >= ? and clct_date <= ? and sender_cust_code in (select kehudaima from butiefanli)";
        String sqlzhekou = sqlhead + " where clct_date >= ? and clct_date <= ? and sender_cust_code in (select kehudaima from butiezhekou)";
        String sqlchengnan = sqlhead+" where clct_date >= ? and clct_date <= ? and sender_cust_code in (select kehudaima from butiechengnankehu) ";
        
        //Chanpin chanpin = new Chanpin();
        //Luxiang luxiang = new Luxiang(kshijian,jshijian);
        
            for(Mail m:getMail(sqlzhekou,kshijian,jshijian)){
                new Anzhekoubutie(m).jisuanbutie();
                //Task(Anzhekoubutie.class);
                m.update("按折扣补贴",gongzuoid);
                //Thread.sleep(40);
            }
            for(Mail m:getMail(sqlanshouxuzhong,kshijian,jshijian)){
                new Anshouxuzhong(m).jisuanbutie();
                m.update("按首续重补贴",gongzuoid);
               // Thread.sleep(40);
            }
            for(Mail m:getMail(sqlanjian,kshijian,jshijian)){
                new Anjianbutie(m).jisuanbutie();
                m.update("按件补贴",gongzuoid);
                //Thread.sleep(40);
            }
            new Fanlibutie(kshijian,jshijian);
            for(Mail m:getMail(sqlfanli,kshijian,jshijian)){
                //System.out.println(m.getYoujianhao());
                new Fanlibutie(m).jisuanbutie();
                m.update("按百分比返利",gongzuoid);
                //Thread.sleep(40);
            }
//            for (Mail m:getMail(sqlchengnan,kshijian,jshijian)){
//                new Chengnanbutie(m).jisuanbutie();
//                m.update("城南补贴薪酬");
//            }
//        Beans.Butie.Xinchou.Jisuan.main(args);
        
        
    }
   
}
