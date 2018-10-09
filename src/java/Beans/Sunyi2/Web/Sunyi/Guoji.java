/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Beans.Sunyi2.Web.Sunyi;

import Beans.MyLog;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class Guoji {
    public String gongzuoid;
    public String kshijian;
    public String jshijian;
    public String beizhu;
    public String zhuangtai;
    public Guoji(){
        
    }
    public Guoji(String gongzuoid,String kshijian,String jshijian,String beizhu,String zhuangtai){
        this.gongzuoid = gongzuoid;
        this.kshijian = kshijian;
        this.jshijian = jshijian;
        this.beizhu = beizhu;
                
        this.zhuangtai = zhuangtai;
    }
    public void del(String id){
        String sql = "delete from  guojisunyibiao where gongzuoid = ? 	";
        String sql2 = "delete from guojisunyigongzuo where gongzuoid = ?";
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
    public ArrayList<Guojishuju> getmingxibyidjigou(String id,String jigoudaima){
        ArrayList<Guojishuju> list = new ArrayList();
        
        String sql = "select * from  guojisunyibiao where gongzuoid = ? and jigoudaima = ? 	";
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
                    list.add(new Guojishuju(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getString(14),rs.getString(15),rs.getString(16),rs.getString(17),rs.getString(18),rs.getString(19),rs.getString(20),rs.getString(21),rs.getString(22),rs.getString(23),rs.getString(24)));
                }
                rs.close();
                pstmt.close();
                MyLog.close(conn);
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
    public ArrayList<Guojishuju> getmingxibyid(String id){
        ArrayList<Guojishuju> list = new ArrayList();
        
        String sql = "select * from  guojisunyibiao where gongzuoid = ? ";
        //String sql = "select * from wujiangmail where mail_num in (SELECT COLUMN1 FROM TEMP )";
        //Chanpin chanpin = new Chanpin();
        try{
                Connection conn = MyLog.getConn();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, id);
                //System.out.println(request.getParameter("kshijian").replace("-", ""));
                
                ResultSet rs =pstmt.executeQuery();
                while(rs.next()){
                    list.add(new Guojishuju(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getString(14),rs.getString(15),rs.getString(16),rs.getString(17),rs.getString(18),rs.getString(19),rs.getString(20),rs.getString(21),rs.getString(22),rs.getString(23),rs.getString(24)));
                }
                rs.close();
                pstmt.close();
                MyLog.close(conn);
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
    
    public ArrayList<Guojishuju> getshujubyjigou(String id){
        ArrayList<Guojishuju> list = new ArrayList();
   
        String sql = "select jigoumingcheng,jigoudaima,COUNT(*),SUM(xitongzifei),sum(quneizhuantangfei),sum(bendichulizhongxinchulifei),sum(huhuanjuchulifei),sum(yanguanfei),sum(jingzhuanjuchulifei),sum(yiganfeiyong),sum(guojihangkongfei),sum(guojizhongduanfei),sum(tntzhongduanfei) from  guojisunyibiao where gongzuoid = ?	group by jigoumingcheng,jigoudaima	";
        //String sql = "select * from wujiangmail where mail_num in (SELECT COLUMN1 FROM TEMP )";
        //Chanpin chanpin = new Chanpin();
        try{
                Connection conn = MyLog.getConn();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, id);
                //System.out.println(request.getParameter("kshijian").replace("-", ""));
                
                ResultSet rs =pstmt.executeQuery();
                while(rs.next()){
                    list.add(new Guojishuju(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13)));
                }
                rs.close();
                pstmt.close();
                MyLog.close(conn);
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
    public ArrayList<Guoji> getShujulist(){
        ArrayList<Guoji> guonei = new ArrayList();
        
        int updatei = 0;
        
        String sql = "select * from  guojisunyigongzuo  ";
        //String sql = "select * from wujiangmail where mail_num in (SELECT COLUMN1 FROM TEMP )";
        //Chanpin chanpin = new Chanpin();
        try{
                Connection conn = MyLog.getConn();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                //System.out.println(request.getParameter("kshijian").replace("-", ""));
                
                ResultSet rs =pstmt.executeQuery();
                while(rs.next()){
                    guonei.add(new Guoji(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(5),rs.getString(4)));
                }
                
                pstmt.close();
                MyLog.close(conn);
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        return guonei;
    }
    
}
