/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Beans.Sunyi2.Web.Butie;

import Beans.MyLog;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class Anzhekoukehu extends Kehu{
   String bianhao;
   String jiaoyima;
   String sheng;
   String youjianleixing;
   String zhekou;
   final String shixiaoriqi = "99999999";

    public Anzhekoukehu(String kehudaima, String kehumingcheng) {
        super(kehudaima, kehumingcheng);
    }

    public Anzhekoukehu() {
    }

    public Anzhekoukehu(String bianhao, String kehudaima, String jiaoyima, String sheng, String youjianleixing, String zhekou, String kehumingcheng) {
        super(kehudaima, kehumingcheng);
        this.bianhao = bianhao;
        this.jiaoyima = jiaoyima;
        this.sheng = sheng;
        this.youjianleixing = youjianleixing;
        this.zhekou = zhekou;
    }

   
   
   
   
   public boolean addKehu(String kehu){
        boolean flag= false;
        boolean findflag = false;
        
        String sqlfind = "select * from butiezhekou where kehudaima = ?  ";
        String sql = "insert into butiezhekou(kehudaima,shixiaoriqi) values(?,?)";
        try{
                Connection conn = MyLog.getConn();
                PreparedStatement pstmts = conn.prepareStatement(sqlfind);
                pstmts.setString(1,kehu);
                 ResultSet rs = pstmts.executeQuery();
                 while(rs.next()){
                     findflag = true;
                     break;
                    }
                 
                 rs.close();
                 pstmts.close();
                 if(!findflag){
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1,kehu);
                pstmt.setString(2,shixiaoriqi);
                //System.out.println(request.getParameter("kshijian").replace("-", ""));
                
                int i =pstmt.executeUpdate();
                if(i>0){
                    flag = true;
                }
                pstmt.close();
                 }
                MyLog.close(conn);
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return flag;
    }
    
    public boolean addjilu(String kehu,String jiaoyima,String jidasheng,String youjianleixing,String zhekou){
        boolean flag= false;
        //boolean findflag = false;
        String sqld = "delete from butiezhekou where jiaoyima is null and jidasheng is null and  youjianleixing is null and  kehudaima = ?";
        String sql = "insert into butiezhekou(kehudaima,jiaoyima,jidasheng,youjianleixing,zhekou,shixiaoriqi) values(?,?,?,?,?,?)";
        try{
                Connection conn = MyLog.getConn();
                
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1,kehu);
                pstmt.setString(2,jiaoyima);
                pstmt.setString(3,Shengfen.getShengfenlist().get(Integer.valueOf(jidasheng)-1).getSheng());
                pstmt.setString(4,youjianleixing);
                pstmt.setString(5,zhekou);
                pstmt.setString(6,shixiaoriqi);
                //System.out.println(request.getParameter("kshijian").replace("-", ""));
                int i =pstmt.executeUpdate();
                if(i>0){
                    flag = true;
                }
                pstmt.close();
                if(flag){
                    pstmt = conn.prepareStatement(sqld);
                    pstmt.setString(1, kehu);
                    pstmt.executeUpdate();
                    pstmt.close();
                }            
                MyLog.close(conn);
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return flag;
    }
    
    public boolean delshuju(String id){
        boolean flag= false;
        //boolean findflag = false;
        //System.out.println(id);
        String sql = "delete from butiezhekou where bianhao = ?";
        try{
                Connection conn = MyLog.getConn();
                
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1,id);
                
                
                
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
    
    public ArrayList<Anzhekoukehu> getKehu(){
        ArrayList<Anzhekoukehu> list = new ArrayList();
        String sql = "select butiezhekou.kehudaima,kehumingcheng from butiezhekou left join kehuxinxi on butiezhekou.kehudaima =kehuxinxi.kehudaima  group by butiezhekou.kehudaima,kehumingcheng";
        try{
                Connection conn = MyLog.getConn();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                
                ResultSet rs =pstmt.executeQuery();
                while(rs.next()){
                    String jieshu = "";
                    
                    list.add(new Anzhekoukehu(rs.getString(1),rs.getString(2)));
                }
                rs.close();
                pstmt.close();
                MyLog.close(conn);
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
   
    public ArrayList<Anzhekoukehu> getkehupeizhi(String kehu){
        ArrayList<Anzhekoukehu> list = new ArrayList();
        String sql = "select butiezhekou.*,kehumingcheng from butiezhekou left join kehuxinxi on butiezhekou.kehudaima =kehuxinxi.kehudaima where butiezhekou.kehudaima = ?  ";
        
        try{
                Connection conn = MyLog.getConn();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, kehu);
                ResultSet rs =pstmt.executeQuery();
                while(rs.next()){
                    
                    
                    list.add(new Anzhekoukehu(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(8)));
                }
                rs.close();
                pstmt.close();
                MyLog.close(conn);
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
   
   
   
   
   
    public String getBianhao() {
        return bianhao;
    }

    public void setBianhao(String bianhao) {
        this.bianhao = bianhao;
    }

    public String getJiaoyima() {
        return jiaoyima;
    }

    public void setJiaoyima(String jiaoyima) {
        this.jiaoyima = jiaoyima;
    }

    public String getSheng() {
        return sheng;
    }

    public void setSheng(String sheng) {
        this.sheng = sheng;
    }

    public String getYoujianleixing() {
        return youjianleixing;
    }

    public void setYoujianleixing(String youjianleixing) {
        this.youjianleixing = youjianleixing;
    }

    public String getZhekou() {
        return zhekou;
    }

    public void setZhekou(String zhekou) {
        this.zhekou = zhekou;
    }
   
   
}
