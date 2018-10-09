/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Beans.Sunyi2.Web.Xinchou;

import Beans.Sunyi2.Web.Butie.Youbankehu;
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



public class Xinchou {
    public String gongzuoid;
    public String kshijian;
    public String jshijian;
    public String zhuangtai;
    String beizhu;
    public String leixing ;
    public Xinchou(){
        
    }
    public Xinchou(String gongzuoid,String kshijian,String jshijian,String leixing,String zhuangtai,String beizhu){
        this.gongzuoid = gongzuoid;
        this.kshijian = kshijian;
        this.jshijian = jshijian;
        this.zhuangtai = zhuangtai;
        this.leixing = leixing;
        this.beizhu = beizhu;
    }
    public static void main(String[] args) {
        Xinchou   g = new Xinchou();
        g.delyouban("1518448947093");
    }
    public void delyouban(String id){
        String sql = "delete from  butiexinchouyoubankehu where kehudaima = ? 	";
        //String sql2 = "delete from butiexinchougongzuo where gongzuoid = ?";
        //String sql = "select * from wujiangmail where mail_num in (SELECT COLUMN1 FROM TEMP )";
        //Chanpin chanpin = new Chanpin();
        try{
                Connection conn = MyLog.getConn();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, id);
                pstmt.executeUpdate();
                pstmt.close();
               // pstmt = conn.prepareStatement(sql2);
               // pstmt.setString(1, id);
                //pstmt.executeUpdate();
               // pstmt.close();
                MyLog.close(conn);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void delhengshanbili(String id){
        String sql = "delete from  butiexinchouhengshanbili where bianhao = ? 	";
        //String sql2 = "delete from butiexinchougongzuo where gongzuoid = ?";
        //String sql = "select * from wujiangmail where mail_num in (SELECT COLUMN1 FROM TEMP )";
        //Chanpin chanpin = new Chanpin();
        try{
                Connection conn = MyLog.getConn();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, id);
                pstmt.executeUpdate();
                pstmt.close();
               // pstmt = conn.prepareStatement(sql2);
               // pstmt.setString(1, id);
                //pstmt.executeUpdate();
               // pstmt.close();
                MyLog.close(conn);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void del(String id){
        String sql = "delete from  butiexinchou where gongzuoid = ? 	";
        String sql2 = "delete from butiexinchougongzuo where gongzuoid = ?";
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
    public ArrayList<Xinchoushuju> getmingxibyidjigou(String id,String jigoudaima){
        ArrayList<Xinchoushuju> list = new ArrayList();
        
        String sql = "select * from  butiexinchou where gongzuoid = ? and jigoudaima = ? 	";
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
                    list.add(new Xinchoushuju(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getString(14),rs.getString(15),rs.getString(16)));
                }
                rs.close();
                pstmt.close();
                MyLog.close(conn);
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
    
    
    public ArrayList<Xinchoushuju> getmingxibyid(String id){
        ArrayList<Xinchoushuju> list = new ArrayList();
        
        String sql = "select * from  butiexinchou where gongzuoid = ? ";
        //String sql = "select * from wujiangmail where mail_num in (SELECT COLUMN1 FROM TEMP )";
        //Chanpin chanpin = new Chanpin();
        try{
                Connection conn = MyLog.getConn();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, id);
                
                //System.out.println(request.getParameter("kshijian").replace("-", ""));
                
                ResultSet rs =pstmt.executeQuery();
                while(rs.next()){
                    list.add(new Xinchoushuju(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getString(14),rs.getString(15),rs.getString(16)));
                }
                rs.close();
                pstmt.close();
                MyLog.close(conn);
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
    //SELECT butiexinchouyoubankehu.kehudaima,kehuxinxi.kehumingcheng  FROM butiexinchouyoubankehu left join kehuxinxi on butiexinchouyoubankehu.kehudaima = kehuxinxi.kehudaima
    
    public ArrayList<Youbankehu> getYoubankehulist(){
        ArrayList<Youbankehu> list = new ArrayList();
        String sql = "SELECT butiexinchouyoubankehu.kehudaima,kehuxinxi.kehumingcheng  FROM butiexinchouyoubankehu left join kehuxinxi on butiexinchouyoubankehu.kehudaima = kehuxinxi.kehudaima";
        try{
                Connection conn = MyLog.getConn();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                
                ResultSet rs =pstmt.executeQuery();
                while(rs.next()){
                    list.add(new Youbankehu(rs.getString(1),rs.getString(2)));
                }
                rs.close();
                pstmt.close();
                MyLog.close(conn);
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
    public boolean addyoubankehu(String kehu){
        boolean flag= false;
        String sql = "insert into butiexinchouyoubankehu values(?)";
        try{
                Connection conn = MyLog.getConn();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1,kehu);
                
                //System.out.println(request.getParameter("kshijian").replace("-", ""));
                
                int i =pstmt.executeUpdate();
                if(i>0){
                    flag = true;
                }
                pstmt.close();
                MyLog.close(conn);
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return flag;
    }
    public boolean addhengshanbili(String kshijian,String jshijian,String bili){
        boolean flag= false;
        String sql = "insert into butiexinchouhengshanbili values(?,?,?)";
        try{
                Connection conn = MyLog.getConn();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, kshijian.replaceAll("-", ""));
                pstmt.setString(2, jshijian.replaceAll("-", ""));
                pstmt.setString(3, bili);
                //System.out.println(request.getParameter("kshijian").replace("-", ""));
                
                int i =pstmt.executeUpdate();
                if(i>0){
                    flag = true;
                }
                pstmt.close();
                MyLog.close(conn);
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return flag;
    }
    public ArrayList<Hengshanbili> gethengshanbili(){
        ArrayList<Hengshanbili> list = new ArrayList();
   
        String sql = "SELECT * FROM butiexinchouhengshanbili";
        //String sql = "select * from wujiangmail where mail_num in (SELECT COLUMN1 FROM TEMP )";
        //Chanpin chanpin = new Chanpin();
        try{
                Connection conn = MyLog.getConn();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                
                //System.out.println(request.getParameter("kshijian").replace("-", ""));
                
                ResultSet rs =pstmt.executeQuery();
                while(rs.next()){
                    list.add(new Hengshanbili(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)));
                    
                }
                rs.close();
                pstmt.close();
                MyLog.close(conn);
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
    
    public ArrayList<Xinchoushuju> getshujubyjigou(String id){
        ArrayList<Xinchoushuju> list = new ArrayList();
   
        String sql = "SELECT jigoudaima,jigoumingcheng,count(*),sum (xitongzifei),sum(shishouzifei),sum(butiejine)   FROM butiexinchou where     gongzuoid = ?                 group by jigoudaima,jigoumingcheng";
        //String sql = "select * from wujiangmail where mail_num in (SELECT COLUMN1 FROM TEMP )";
        //Chanpin chanpin = new Chanpin();
        try{
                Connection conn = MyLog.getConn();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, id);
                //System.out.println(request.getParameter("kshijian").replace("-", ""));
                
                ResultSet rs =pstmt.executeQuery();
                while(rs.next()){
                    list.add(new Xinchoushuju(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)));
                }
                rs.close();
                pstmt.close();
                MyLog.close(conn);
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
    public ArrayList<Xinchou> getYoubanShujulist(){
        ArrayList<Xinchou> guonei = new ArrayList();
        
        int updatei = 0;
        
        String sql = "select * from  butiexinchougongzuo where xinchouleixing = '邮伴补贴' ";
        //String sql = "select * from wujiangmail where mail_num in (SELECT COLUMN1 FROM TEMP )";
        //Chanpin chanpin = new Chanpin();
        try{
                Connection conn = MyLog.getConn();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                //System.out.println(request.getParameter("kshijian").replace("-", ""));
                //pstmt.setString(1, leixing);
                ResultSet rs =pstmt.executeQuery();
                while(rs.next()){
                    guonei.add(new Xinchou(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)));
                }
                rs.close();
                pstmt.close();
                MyLog.close(conn);
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        return guonei;
    }
    public ArrayList<Xinchou> getHengshanShujulist(){
        ArrayList<Xinchou> guonei = new ArrayList();
        
        int updatei = 0;
        
        String sql = "select * from  butiexinchougongzuo  ";
        //String sql = "select * from wujiangmail where mail_num in (SELECT COLUMN1 FROM TEMP )";
        //Chanpin chanpin = new Chanpin();
        try{
                Connection conn = MyLog.getConn();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                //System.out.println(request.getParameter("kshijian").replace("-", ""));
                
                ResultSet rs =pstmt.executeQuery();
                while(rs.next()){
                    guonei.add(new Xinchou(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)));
                }
                rs.close();
                pstmt.close();
                MyLog.close(conn);
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        return guonei;
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

    public String getBeizhu() {
        return beizhu;
    }

    public void setBeizhu(String beizhu) {
        this.beizhu = beizhu;
    }

    public String getLeixing() {
        return leixing;
    }

    public void setLeixing(String leixing) {
        this.leixing = leixing;
    }
    
}
