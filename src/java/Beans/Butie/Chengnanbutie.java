/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Beans.Butie;

import Beans.MyLog;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Administrator
 */
public class Chengnanbutie extends Butiejine{

    Chengnanbutie(Mail m){
        super(m);
    }
    
    @Override
    public void jisuanbutie() {
        String sqls = "select * from butiechengnanzhekou where jiaoyima = ? and jidasheng = ? and youjianleixing = ?";
        
         try{
            
            Connection conn = MyLog.getConn();
            PreparedStatement pstmts = conn.prepareStatement(sqls);
            
            pstmts.setString(1,getMail().getJiaoyima());
            pstmts.setString(2,getMail().getJidasheng());
            pstmts.setString(3,getMail().getWenjianwupin());
            ResultSet rs = pstmts.executeQuery();
            if(rs.next()){
                if(true){
                    double zhekou = rs.getDouble("zhekou");
                    
                    setShishouzifei(getMail().getBiaozhunzifei()*zhekou);
                    setButiejine(getMail().getXitongzifei()-getMail().getBiaozhunzifei()*zhekou);
                    
                }
            }else{
                if("420".equals(getMail().getJiaoyima())){
                    setShishouzifei(getMail().getBiaozhunzifei()*0.45+4.0);
                    setButiejine(getMail().getXitongzifei()-(getMail().getBiaozhunzifei()*0.45+4.0));
                }else{
                    setButiejine(0.0);
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
