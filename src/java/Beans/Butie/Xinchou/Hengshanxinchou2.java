/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans.Butie.Xinchou;

import Beans.MyLog;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



/**
 *
 * @author Administrator
 */
public class Hengshanxinchou2 extends Xinchoujine{
    
    
    private String shuzhi1;//成本
    final static String idid = "10000";
    Hengshanxinchou2(){
        
    }
    
    Hengshanxinchou2(Mail mail) {
        super(mail);
    }
    Hengshanxinchou2(String kshijian,String jshijian) {
        //super(mail);
        Beans.Sunyi2.Jisuan.jisuanguoneijigou(kshijian, jshijian, idid,"21522303");
    }
    
    public void jisuanbutie() {
        
        String sql = "select * from butiexinchouhengshanbili where kshijian <= ? and jshijian >= ? ";
        String sqls ="select  youjianhao,sum(0.17+dancefei+quneizhuantangfei+bendichulizhongxinfei+erganyunfei+shengneichulifei+shengjijingzhuanfei+yiganyunfei+jinkoushengshengneijingzhuanfei+jinkoushengerganfeiyong+toudifei+quanmingzhilurufei) from guoneisunyibiao  where youjianhao = ? and gongzuoid = ? group by youjianhao";
        //String sqls = "select * from butiexinchouhengshan where jidasheng = ?";
        double bili = 0.0;
        try{
           
            Connection conn = MyLog.getConn();
            PreparedStatement pstmts = conn.prepareStatement(sql);
            pstmts.setInt(1,getMail().getShoujiriqi());
            pstmts.setInt(2,getMail().getShoujiriqi());
            ResultSet rs2 = pstmts.executeQuery();
            if(rs2.next()){
             bili = rs2.getDouble("bili");
            }
            rs2.close();
            pstmts.close();
                if("492".equals(getMail().getJiaoyima())){
                    double chengben = 0.0;
                    pstmts = conn.prepareStatement(sqls);
                    pstmts.setString(1, getMail().getYoujianhao());
                    pstmts.setString(2, idid);
                    rs2 = pstmts.executeQuery();
                    if(rs2.next()){
                        chengben = rs2.getDouble(2);
                        setShishouzifei(chengben);
                        setButiejine(0.1+(((getMail().getXitongzifei()-chengben)/1.06)*bili));//去税
                    }else{
                        setShishouzifei(0);
                        setButiejine(0);
                    }
                    rs2.close();
                    pstmts.close();
                
                }else{
                    
                    setShishouzifei(0);
                    setButiejine(0);
                }
            
            
            
            MyLog.close(conn);
         }catch(Exception e){
             e.printStackTrace();
         }
    }

    public String getShuzhi1() {
        return shuzhi1;
    }

    public void setShuzhi1(String shuzhi1) {
        this.shuzhi1 = shuzhi1;
    }


    
}
