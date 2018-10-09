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
public class Hengshanxinchou extends Xinchoujine{
    
    Hengshanxinchou(){
        
    }
    
    Hengshanxinchou(Mail mail) {
        super(mail);
    }

    
    public void jisuanbutie() {
        String sql = "select * from butiexinchouhengshanbili where kshijian <= ? and jshijian >= ? ";
        String sqls = "select * from butiexinchouhengshan where jidasheng = ?";
        double bili = 0.0;
        try{
           
            Connection conn = MyLog.getConn();
            PreparedStatement pstmts = conn.prepareStatement(sql);
            pstmts.setInt(1,getMail().getShoujiriqi());
            pstmts.setInt(2,getMail().getShoujiriqi());
            ResultSet rs = pstmts.executeQuery();
            if(rs.next()){
             bili = rs.getDouble("bili");
            }
            
            rs.close();
            pstmts.close();
            pstmts = conn.prepareStatement(sqls);
            pstmts.setString(1,getMail().getJidasheng());
            rs = pstmts.executeQuery();
            if(rs.next()){
                if("492".equals(getMail().getJiaoyima())){
                    double chengben = 0.0;
                    switch(getMail().getJidasheng()){
                        case "江苏省":
                        case "浙江省":    
                        case "上海":    
                        case "安徽省":      
                            chengben = rs.getDouble("gudingzifei")+Math.ceil(getMail().getYoujianzhongliang()*10)*rs.getDouble("zhongliangzifei");
                            break;
                        default:
                            if(getMail().getYoujianzhongliang()>3.0){
                                chengben = rs.getDouble("gudingzifei")+Math.ceil(getMail().getYoujianzhongliang()*10)*rs.getDouble("zhongliangzifei");
                            }else{
                                 chengben = (rs.getDouble("gudingzifei")-0.55)+Math.ceil(getMail().getYoujianzhongliang()*10)*rs.getDouble("zhongliangzifei");
                            }
                            break;
                    }
                    
                    
                    
                    setShishouzifei(chengben);
                    setButiejine(0.1+(getMail().getXitongzifei()/1.06-(chengben))*bili);//去税
                
                
                }else{
                    
                    setShishouzifei(0);
                    setButiejine(0);
                }
            }else{
                setShishouzifei(0.0);
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
