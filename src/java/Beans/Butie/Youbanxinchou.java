/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Beans.Butie;

import Beans.Butie.Xinchou.*;
import Beans.Butie.Butiejine;
import Beans.MyLog;
import Beans.Butie.Mail;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Administrator
 */
public class Youbanxinchou extends Butiejine{

    public Youbanxinchou(){
        
    }
    public Youbanxinchou(Mail m){
        super(m);
    }
    @Override
    public void jisuanbutie() {
        String sql = "select * from butiexinchouyoubanbili where jiaoyima = ? and jidasheng = ? and youjianleixing = ?";
        //String sqls = "select * from butiexinchouhengshan where jidasheng = ?";
        double bili = 0.0;
        try{
           
            Connection conn = MyLog.getConn();
            PreparedStatement pstmts = conn.prepareStatement(sql);
            pstmts.setString(1,getMail().getJiaoyima());
            pstmts.setString(2,getMail().getJidasheng());
            pstmts.setString(3, getMail().getWenjianwupin());
            ResultSet rs = pstmts.executeQuery();
            if(rs.next()){
             bili = rs.getDouble("bili");
            }
            
            rs.close();
            pstmts.close();
            
            setShishouzifei(getMail().getBiaozhunzifei()*bili);
            setButiejine(getMail().getXitongzifei()-getMail().getBiaozhunzifei()*bili);
            
            rs.close();
            pstmts.close();
            MyLog.close(conn);
         }catch(Exception e){
             e.printStackTrace();
         }
    }
    
}
