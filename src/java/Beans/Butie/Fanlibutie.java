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
import java.util.HashMap;

/**
 *
 * @author Administrator
 */
public class Fanlibutie extends Butiejine{

    String kehudaima;
    double zongshouru;
    static HashMap<String,Fanlibutie> zongshouruhashmap = new HashMap<String,Fanlibutie>();
    Fanlibutie(String Kehudaima,double zongshouru){
        setKehudaima(Kehudaima);
        setZongshouru(zongshouru);
    }
    Fanlibutie(Mail mail){
        super(mail);

    }
    Fanlibutie(String kshijian,String jshijian){
        
        String sqlzong = "select SENDER_CUST_CODE,SUM(ACTUAL_TOTAL_FEE) from WUJIANGMAIL where SENDER_CUST_CODE in (select kehudaima from butiefanli) and CLCT_DATE >= ? and CLCT_DATE <= ? group by SENDER_CUST_CODE";
        try{
           
            Connection conn = MyLog.getConn();
            PreparedStatement pstmts = conn.prepareStatement(sqlzong);
            pstmts.setString(1,kshijian);
            pstmts.setString(2,jshijian);
            ResultSet rs = pstmts.executeQuery();
            while(rs.next()){
                System.out.println(rs.getString(1));
                zongshouruhashmap.put(rs.getString(1), new Fanlibutie(rs.getString(1),rs.getDouble(2)));
            }
            rs.close();
            pstmts.close();
            MyLog.close(conn);
         }catch(Exception e){
             e.printStackTrace();
         }
    }
    
    void setZongshouru(double zongshouru){
        this.zongshouru = zongshouru;
    }
    
    double getZongshouru(){
        return zongshouru;
    }
    
   public void jisuanbutie() {
         String sqls = "select * from butiefanli where kehudaima = ? and jiaoyima = ? and youjianleixing = ?  ";
         
         try{
            
            Connection conn = MyLog.getConn();
            PreparedStatement pstmts = conn.prepareStatement(sqls);
            pstmts.setString(1,getMail().getKehudaima());
            pstmts.setString(2,getMail().getJiaoyima());
            pstmts.setString(3,getMail().getWenjianwupin());
            
            ResultSet rs = pstmts.executeQuery();
            while(rs.next()){
                
                double zongshourukehu = zongshouruhashmap.get(rs.getString("kehudaima")).getZongshouru();
                if(zongshourukehu >= rs.getDouble("yongyouliang1")){
                    if(zongshourukehu < rs.getDouble("yongyouliang2")){
                        double xitongzifei = getMail().getXitongzifei();
                        double butiezifei = xitongzifei*rs.getDouble("bili");
                        setButiejine(butiezifei);
                        setShishouzifei(xitongzifei- butiezifei);
                        break;
                    }
                }
            }
            rs.close();
            pstmts.close();
            MyLog.close(conn);
         }catch(Exception e){
             e.printStackTrace();
         }
    }
    
}
