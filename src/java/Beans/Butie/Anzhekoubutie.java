/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Beans.Butie;

import Beans.MyLog;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Administrator
 */
public class Anzhekoubutie extends Butiejine{
    public Anzhekoubutie(Mail m){
        super(m);
    }
    @Override
   public void jisuanbutie() {
        String sqls = "select * from butiezhekou where kehudaima = ? and jiaoyima = ? and jidasheng = ? and youjianleixing = ?";
        
         try{
            
            Connection conn = MyLog.getConn();
            PreparedStatement pstmts = conn.prepareStatement(sqls);
            pstmts.setString(1,getMail().getKehudaima());
            pstmts.setString(2,getMail().getJiaoyima());
            pstmts.setString(3,getMail().getJidasheng());
            pstmts.setString(4,getMail().getWenjianwupin());
            ResultSet rs = pstmts.executeQuery();
            if(rs.next()){
                if(getMail().getShoujiriqi() < rs.getInt("shixiaoriqi")){
                    double zhekou = rs.getDouble("zhekou");
                    
                    setShishouzifei(getMail().getBiaozhunzifei()*zhekou);
                    setButiejine(getMail().getXitongzifei()-getMail().getBiaozhunzifei()*zhekou);
                    
                }
            }else{
                setButiejine(0.0);
            }
            rs.close();
            pstmts.close();
            MyLog.close(conn);
         }catch(Exception e){
             e.printStackTrace();
         }
    }
    
}
