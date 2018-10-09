/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Beans.Sunyi2.Web.Sunyi;

import Beans.MyLog;
import Beans.Sunyi2.Web.Sunyi.Guoneishujubyjigou;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */



public class Guonei {
    public String gongzuoid;
    public String kshijian;
    public String jshijian;
    public String zhuangtai;
    String beizhu;
    public Guonei(){
        
    }
    public Guonei(String gongzuoid,String kshijian,String jshijian,String zhuangtai,String beizhu){
        this.gongzuoid = gongzuoid;
        this.kshijian = kshijian;
        this.jshijian = jshijian;
        this.zhuangtai = zhuangtai;
        this.beizhu = beizhu;
    }
    public static void main(String[] args) {
        Guonei   g = new Guonei();
        g.del("1518448947093");
    }
    public void del(String id){
        String sql = "delete from  guoneisunyibiao where gongzuoid = ? 	";
        String sql2 = "delete from guoneisunyigongzuo where gongzuoid = ?";
        //String sql = "select * from wujiangmail where mail_num in (SELECT COLUMN1 FROM TEMP )";
        //Chanpin chanpin = new Chanpin();
        try{
                Connection conn = MyLog.getConn();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, id);
                pstmt.executeUpdate();
                pstmt.close();
                pstmt = conn.prepareStatement(sql2);
                pstmt.setString(1, id);
                pstmt.executeUpdate();
                pstmt.close();
                MyLog.close(conn);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public ArrayList<Guoneishujubyjigou> getmingxibyidjigou(String id,String jigoudaima){
        ArrayList<Guoneishujubyjigou> list = new ArrayList();
        
        String sql = "select * from  guoneisunyibiao where gongzuoid = ? and jigoudaima = ? 	";
        //String sql = "select * from wujiangmail where mail_num in (SELECT COLUMN1 FROM TEMP )";
        //Chanpin chanpin = new Chanpin();
        try{
                Connection conn = MyLog.getConn();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, id);
                pstmt.setString(2, jigoudaima);
                //System.out.println(request.getParameter("kshijian").replace("-", ""));
                
                ResultSet rs =pstmt.executeQuery();
                while(rs.next()){
                    list.add(new Guoneishujubyjigou(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getString(14),rs.getString(15),rs.getString(16),rs.getString(17),rs.getString(18),rs.getString(19),rs.getString(20),rs.getString(21),rs.getString(22),rs.getString(23),rs.getString(24),rs.getString(25),rs.getString(26),rs.getString(27),rs.getString(28)));
                }
                rs.close();
                pstmt.close();
                MyLog.close(conn);
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
    public ArrayList<Guoneishujubyjigou> getmingxibyidjigou(String id){
        ArrayList<Guoneishujubyjigou> list = new ArrayList();
        
        String sql = "select * from  guoneisunyibiao where gongzuoid = ? ";
        //String sql = "select * from wujiangmail where mail_num in (SELECT COLUMN1 FROM TEMP )";
        //Chanpin chanpin = new Chanpin();
        try{
                Connection conn = MyLog.getConn();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, id);
                //pstmt.setString(2, jigoudaima);
                //System.out.println(request.getParameter("kshijian").replace("-", ""));
                
                ResultSet rs =pstmt.executeQuery();
                while(rs.next()){
                    list.add(new Guoneishujubyjigou(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getString(14),rs.getString(15),rs.getString(16),rs.getString(17),rs.getString(18),rs.getString(19),rs.getString(20),rs.getString(21),rs.getString(22),rs.getString(23),rs.getString(24),rs.getString(25),rs.getString(26),rs.getString(27),rs.getString(28)));
                }
                rs.close();
                pstmt.close();
                MyLog.close(conn);
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
    
    public ArrayList<Guoneishujubyjigou> getshujubyjigou(String id){
        ArrayList<Guoneishujubyjigou> list = new ArrayList();
   
        String sql = "select jigoumingcheng,jigoudaima,COUNT(*),SUM(xitongzifei),SUM(dancefei),SUM(quneizhuantangfei),SUM(bendichulizhongxinfei),SUM(erganyunfei),SUM(shengneichulifei),SUM(shengjijingzhuanfei),SUM(yiganyunfei),SUM(jinkoushengshengneijingzhuanfei),SUM(jinkoushengerganfeiyong),SUM(toudifei),SUM(jijiangongzifei),SUM(quanmingzhilurufei) from  guoneisunyibiao where gongzuoid = ?	group by jigoumingcheng,jigoudaima	";
        //String sql = "select * from wujiangmail where mail_num in (SELECT COLUMN1 FROM TEMP )";
        //Chanpin chanpin = new Chanpin();
        try{
                Connection conn = MyLog.getConn();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, id);
                //System.out.println(request.getParameter("kshijian").replace("-", ""));
                
                ResultSet rs =pstmt.executeQuery();
                while(rs.next()){
                    list.add(new Guoneishujubyjigou(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getString(14),rs.getString(15),rs.getString(16)));
                }
                rs.close();
                pstmt.close();
                MyLog.close(conn);
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
    public ArrayList<Guonei> getShujulist(){
        ArrayList<Guonei> guonei = new ArrayList();
        
        int updatei = 0;
        
        String sql = "select * from  guoneisunyigongzuo  ";
        //String sql = "select * from wujiangmail where mail_num in (SELECT COLUMN1 FROM TEMP )";
        //Chanpin chanpin = new Chanpin();
        try{
                Connection conn = MyLog.getConn();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                //System.out.println(request.getParameter("kshijian").replace("-", ""));
                
                ResultSet rs =pstmt.executeQuery();
                while(rs.next()){
                    guonei.add(new Guonei(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)));
                }
                rs.close();
                pstmt.close();
                MyLog.close(conn);
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        return guonei;
    }

    public String getBeizhu() {
        return beizhu;
    }

    public void setBeizhu(String beizhu) {
        this.beizhu = beizhu;
    }

    public String getGongzuoid() {
        return gongzuoid;
    }

    public void setGongzuoid(String gongzuoid) {
        this.gongzuoid = gongzuoid;
    }

    public String getKshijian() {
        return kshijian;
    }

    public void setKshijian(String kshijian) {
        this.kshijian = kshijian;
    }

    public String getJshijian() {
        return jshijian;
    }

    public void setJshijian(String jshijian) {
        this.jshijian = jshijian;
    }

    public String getZhuangtai() {
        return zhuangtai;
    }

    public void setZhuangtai(String zhuangtai) {
        this.zhuangtai = zhuangtai;
    }
    
}
