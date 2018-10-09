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
public class Anshouxuzhong extends Butiejine{
    

    Anshouxuzhong(Mail mail){
        super(mail);
    }

    
    @Override
  public  void jisuanbutie() {
        String sqls = "select * from butieshouxuzhong where kehudaima = ? and jiaoyima = ? and jidasheng = ? and youjianleixing = ?";
        
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
                    double shouzhong = rs.getDouble("shouzhong");
                    double shouzhongdanjia = rs.getDouble("shouzhongdanjia");
                    double xuzhong = rs.getDouble("xuzhong");
                    double xuzhongdanjia = rs.getDouble("xuzhongdanjia");
                    if(getMail().getYoujianzhongliang() < shouzhong){
                        setShishouzifei(shouzhongdanjia);
                        setButiejine(getMail().getXitongzifei()-shouzhongdanjia);
                    }else{
                        double shishouzifei = shouzhongdanjia+Math.ceil((getMail().getYoujianzhongliang()-shouzhong)/xuzhong)*xuzhongdanjia;
                        setShishouzifei(shishouzifei);
                        setButiejine(getMail().getXitongzifei()-shishouzifei);
                    }
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
