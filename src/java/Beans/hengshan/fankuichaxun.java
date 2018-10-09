/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Beans.hengshan;

import Beans.MyLog;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class fankuichaxun {
    public String mailno;
    public String leixing;
    public String yuangong;
    public String shijian;
    public fankuichaxun(){
        
    }
    fankuichaxun(String mailno,String leixing,String yuangong,String shijian){
        this.mailno = mailno;
        this.leixing = leixing;
        this.yuangong = yuangong;
        this.shijian = shijian;
    }
    public ArrayList<fankuichaxun> getshuju(String kshijian,String jshijian){
        ArrayList<fankuichaxun> shuju = new ArrayList<>();
        try{
                
                Connection conn = MyLog.getConn();
                //and substr(prod_code,3,1) = '1'
                String sqlu = "select * from hengshandengji where time >= ? and time <= ?";
                PreparedStatement pstmt = conn.prepareStatement(sqlu);
                pstmt.setString(1, kshijian);
                pstmt.setString(2, jshijian);
                ResultSet rs = pstmt.executeQuery();
                while(rs.next()){
                    shuju.add(new fankuichaxun(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)));
                }
                rs.close();
                pstmt.close();
                MyLog.close(conn);
                
                
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return shuju;
    }
    
}
