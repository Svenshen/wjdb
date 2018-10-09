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
public class Youbankehu extends Kehu{

    public Youbankehu(){
        super();
    }
    
    
    public Youbankehu(String kehudaima, String kehumingcheng) {
        super(kehudaima, kehumingcheng);
    }
    public boolean add(String kehu){
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
    public ArrayList<Youbankehu> getKehulist(){
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
    
    public void del(String id){
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
}
