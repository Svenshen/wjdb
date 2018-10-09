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
public class Anjiankehu extends Kehu{
    String  butiedanjia;

    public Anjiankehu( String kehudaima, String kehumingcheng,String butiedanjia) {
        super(kehudaima, kehumingcheng);
        this.butiedanjia = butiedanjia;
    }

    public Anjiankehu() {
    }

    public String getButiedanjia() {
        return butiedanjia;
    }

    public void setButiedanjia(String butiedanjia) {
        this.butiedanjia = butiedanjia;
    }

    boolean addkehu(String kehu,String jine){
        boolean flag= false;
        String sql = "insert into butieanjian values(?,?,'99999999')";
        try{
                Connection conn = MyLog.getConn();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1,kehu);
                pstmt.setString(2,jine);
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
    public boolean del(String id){
        boolean flag =false;
        String sql = "delete from  butieanjian where kehudaima = ? ";
        //String sql2 = "delete from butiexinchougongzuo where gongzuoid = ?";
        //String sql = "select * from wujiangmail where mail_num in (SELECT COLUMN1 FROM TEMP )";
        //Chanpin chanpin = new Chanpin();
        try{
                Connection conn = MyLog.getConn();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, id);
                int i = pstmt.executeUpdate();
                if(i>0){
                    flag = true;
                }
                pstmt.close();
               // pstmt = conn.prepareStatement(sql2);
               // pstmt.setString(1, id);
                //pstmt.executeUpdate();
               // pstmt.close();
                MyLog.close(conn);
        }catch(Exception e){
            e.printStackTrace();
        }
         return flag;       
    }
    
    
    ArrayList<Anjiankehu> getkehulist() {
         ArrayList<Anjiankehu> list = new ArrayList();
        String sql = "SELECT butieanjian.*,kehuxinxi.kehumingcheng  FROM butieanjian left join kehuxinxi on butieanjian.kehudaima = kehuxinxi.kehudaima";
        try{
                Connection conn = MyLog.getConn();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                
                ResultSet rs =pstmt.executeQuery();
                while(rs.next()){
                    list.add(new Anjiankehu(rs.getString(1),rs.getString(4),rs.getString(2)));
                }
                rs.close();
                pstmt.close();
                MyLog.close(conn);
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
    
    
}
