/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans.liangshou;

import Beans.MyLog;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class Chengben {
    double chengben;
    
    double shouru;
    public static void main(String[] args) {
        Chengben c = new Chengben();
        c.getChengben();
    }
    public void  getChengben(){
        
        //format.setMinimumFractionDigits(2);// 设置小数位 
        try{
//                Class.forName(driver).newInstance();
                Connection conn = MyLog.getConn();
                String sql = "select * from wujiangchengben where clct_date >= '20150101' and clct_date <= '20150131'"  ;
                PreparedStatement pstmt = conn.prepareStatement(sql);
                //System.out.println(request.getParameter("kshijian").replace("-", ""));
                
                ResultSet rs =pstmt.executeQuery();
                while(rs.next()){
                    switch(rs.getString("MWAY_CODE")){
                        case "2321528001":
                        case "2321529003":
                        case "2321529007":
                            
                            break;
                    }
                }
                
                rs.close();
                pstmt.close();
                
                
                MyLog.close(conn);
        }catch(SQLException sqle){
            sqle.printStackTrace();
            
        }catch(ClassNotFoundException cnfe){
            cnfe.printStackTrace();
            
        }catch(InstantiationException ie ){
            ie.printStackTrace();
           
        }catch(IllegalAccessException iae){
            iae.printStackTrace();
           
        }
        
        
    }
    
    
}
