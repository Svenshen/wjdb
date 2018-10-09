/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Beans.Sunyi2;

import Beans.MyLog;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class Zuixinshijianchaxun {
    String shoujishijian = "";
    String fengfashijian = "";
    String fayunshijian ="";
    
    public void setShoujishijian(String shoujishijian){
        this.shoujishijian = shoujishijian;
    }
    public void setFengfashijian(String fengfashijian){
        this.fengfashijian = fengfashijian;
    }
    public void setFayunshijian(String fayunshijian){
        this.fayunshijian = fayunshijian;
    }
    public String getShoujishijian(){
        return shoujishijian;
    }
    public String getFengfashijian(){
        return fengfashijian;
    }
    public String getFayunshijian(){
        return fayunshijian;
    }
    
    public Zuixinshijianchaxun getzuixinshijian(){
        Zuixinshijianchaxun zxsjcx = new Zuixinshijianchaxun();
        try {
            String sqlshouji  = "select top 1 CLCT_DATE from TB_EVT_MAIL_CLCT order by CLCT_DATE desc ";
            String sqlfengfa = "select top 1 DEAL_DATE from TB_EVT_BAG_MAIL_RELA order by DEAL_DATE desc ";
            String sqlfayun = "select top 1 ROUTE_CRT_DATE from TB_EVT_ROUTE_BAG_RELA order by ROUTE_CRT_DATE desc ";
            Connection conn = MyLog.getConn();
            PreparedStatement pstmtsqlshouji = conn.prepareStatement(sqlshouji);
            PreparedStatement pstmtsqlfengfa = conn.prepareStatement(sqlfengfa);
            PreparedStatement pstmtsqlfayun = conn.prepareStatement(sqlfayun);
            ResultSet rssqlshouji =pstmtsqlshouji.executeQuery();
            ResultSet rssqlfengfa =pstmtsqlfengfa.executeQuery();
            ResultSet rsssqlfayun =pstmtsqlfayun.executeQuery();
            if(rssqlshouji.next()){
                zxsjcx.setShoujishijian(rssqlshouji.getString(1));
            }
            if(rssqlfengfa.next()){
                zxsjcx.setFengfashijian(rssqlshouji.getString(1));
            }
            if(rsssqlfayun.next()){
                zxsjcx.setFayunshijian(rssqlshouji.getString(1));
            }
            rssqlshouji.close();
            rssqlfengfa.close();
            rsssqlfayun.close();
            conn.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Zuixinshijianchaxun.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Zuixinshijianchaxun.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Zuixinshijianchaxun.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Zuixinshijianchaxun.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return   zxsjcx;
    }
}
