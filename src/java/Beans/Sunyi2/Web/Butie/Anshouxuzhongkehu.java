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
public class Anshouxuzhongkehu extends Kehu{
    private String bianhao;
     String jiaoyima;
    String jidasheng;
    String youjianleixing;
    String shouzhong;
    String shouzhongdanjia;
    String xuzhong;
    String xuzhongdanjia;
    final String shixiaoriqi = "99999999";

    public Anshouxuzhongkehu(String kehudaima, String kehumingcheng) {
        super(kehudaima, kehumingcheng);
    }

    public Anshouxuzhongkehu(String bianhao,String kehudaima,String jiaoyima, String jidasheng, String youjianleixing, String shouzhong, String shouzhongdanjia, String xuzhong, String xuzhongdanjia, String kehumingcheng ) {
        super(kehudaima, kehumingcheng);
        this.bianhao = bianhao;
        this.jiaoyima = jiaoyima;
        this.jidasheng = jidasheng;
        this.youjianleixing = youjianleixing;
        this.shouzhong = shouzhong;
        this.shouzhongdanjia = shouzhongdanjia;
        this.xuzhong = xuzhong;
        this.xuzhongdanjia = xuzhongdanjia;
    }

    Anshouxuzhongkehu() {
        
    }

    public boolean addKehu(String kehu){
        boolean flag= false;
        boolean findflag = false;
        
        String sqlfind = "select * from butieshouxuzhong where kehudaima = ?  ";
        String sql = "insert into butieshouxuzhong(kehudaima,shixiaoriqi) values(?,?)";
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
    
    public boolean addjilu(String kehu,String jiaoyima,String jidasheng,String youjianleixing,String shouzhong,String shouzhongdanjia,String xuzhong,String xuzhongdanjia){
        boolean flag= false;
        //boolean findflag = false;
        String sqld = "delete from butieshouxuzhong where jiaoyima is null and jidasheng is null and  youjianleixing is null and  kehudaima = ?";
        String sql = "insert into butieshouxuzhong(kehudaima,jiaoyima,jidasheng,youjianleixing,shouzhong,shouzhongdanjia,xuzhong,xuzhongdanjia,shixiaoriqi) values(?,?,?,?,?,?,?,?,?)";
        try{
                Connection conn = MyLog.getConn();
                
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1,kehu);
                pstmt.setString(2,jiaoyima);
                pstmt.setString(3,Shengfen.getShengfenlist().get(Integer.valueOf(jidasheng)-1).getSheng());
                pstmt.setString(4,youjianleixing);
                pstmt.setString(5,shouzhong);
                pstmt.setString(6,shouzhongdanjia);
                pstmt.setString(7,xuzhong);
                pstmt.setString(8,xuzhongdanjia);
                pstmt.setString(9,shixiaoriqi);
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
        String sql = "delete from butieshouxuzhong where bianhao = ?";
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
    
    public ArrayList<Anshouxuzhongkehu> getKehu(){
        ArrayList<Anshouxuzhongkehu> list = new ArrayList();
        String sql = "select butieshouxuzhong.kehudaima,kehumingcheng from butieshouxuzhong left join kehuxinxi on butieshouxuzhong.kehudaima =kehuxinxi.kehudaima  group by butieshouxuzhong.kehudaima,kehumingcheng";
        try{
                Connection conn = MyLog.getConn();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                
                ResultSet rs =pstmt.executeQuery();
                while(rs.next()){
                    String jieshu = "";
                    
                    list.add(new Anshouxuzhongkehu(rs.getString(1),rs.getString(2)));
                }
                rs.close();
                pstmt.close();
                MyLog.close(conn);
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
   
    public ArrayList<Anshouxuzhongkehu> getkehupeizhi(String kehu){
        ArrayList<Anshouxuzhongkehu> list = new ArrayList();
        String sql = "select butieshouxuzhong.*,kehumingcheng from butieshouxuzhong left join kehuxinxi on butieshouxuzhong.kehudaima =kehuxinxi.kehudaima where butieshouxuzhong.kehudaima = ?  ";
        
        try{
                Connection conn = MyLog.getConn();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, kehu);
                ResultSet rs =pstmt.executeQuery();
                while(rs.next()){
                    
                    
                    list.add(new Anshouxuzhongkehu(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(11)));
                }
                rs.close();
                pstmt.close();
                MyLog.close(conn);
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
    
    
    
    
    
    
    
    public String getJiaoyima() {
        return jiaoyima;
    }

    public void setJiaoyima(String jiaoyima) {
        this.jiaoyima = jiaoyima;
    }

    public String getJidasheng() {
        return jidasheng;
    }

    public void setJidasheng(String jidasheng) {
        this.jidasheng = jidasheng;
    }

    public String getYoujianleixing() {
        return youjianleixing;
    }

    public void setYoujianleixing(String youjianleixing) {
        this.youjianleixing = youjianleixing;
    }

    public String getShouzhong() {
        return shouzhong;
    }

    public void setShouzhong(String shouzhong) {
        this.shouzhong = shouzhong;
    }

    public String getShouzhongdanjia() {
        return shouzhongdanjia;
    }

    public void setShouzhongdanjia(String shouzhongdanjia) {
        this.shouzhongdanjia = shouzhongdanjia;
    }

    public String getXuzhong() {
        return xuzhong;
    }

    public void setXuzhong(String xuzhong) {
        this.xuzhong = xuzhong;
    }

    public String getXuzhongdanjia() {
        return xuzhongdanjia;
    }

    public void setXuzhongdanjia(String xuzhongdanjia) {
        this.xuzhongdanjia = xuzhongdanjia;
    }

    public String getBianhao() {
        return bianhao;
    }

    public void setBianhao(String bianhao) {
        this.bianhao = bianhao;
    }

    

    
}
