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
public class Anjianbutie extends Butiejine{
   
    Anjianbutie(Mail mail){
        super(mail);
    }
    @Override
    public void jisuanbutie() {
        String sqls = "select * from butieanjian where kehudaima = ? ";
        
         try{
            
            Connection conn = MyLog.getConn();
            PreparedStatement pstmts = conn.prepareStatement(sqls);
            pstmts.setString(1,getMail().getKehudaima());
            ResultSet rs = pstmts.executeQuery();
            if(rs.next()){
                if(getMail().getShoujiriqi() < rs.getInt("shixiaoriqi")){
                    double butiedanjia = rs.getDouble("butiedanjia");
                    setShishouzifei(getMail().getXitongzifei() - butiedanjia);
                    setButiejine(butiedanjia);
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
