/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans.genzong;

import Beans.MyLog;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

/**
 *
 * @author Administrator
 */
public class yisidiushi {
    String mailnl;
   // private static final String driver=MyLog.driver;
    public HashMap<String,String> yisidiushi(String kshijian,String jshijian){
        HashMap<String,String> map = new HashMap();
        try{
//                Class.forName(driver).newInstance();
                Connection conn = MyLog.getConn();
                String sqlbiaozhun = "select mail_num from wujiangfengfa a where a.deal_date >= ? and a.deal_date <= ?" +
"((a.DLV_ORG_CODE IN ('21520004','21523102','21520015','21521102','21521303','21521703','21522302','21522303','21522502','21522602','21522803','21522805','21523402','21523602','21526200','21529901','21529902','21529903','21529904','21529905','21522806')  " +
" and a.BAG_ACTN_CODE = '3')or (a.DLV_ORG_CODE = '21520000' and a.BAG_ACTN_CODE = '2')) " +
"and a.MAIL_NUM not in (select MAIL_NUM from wujiangtoudi2 b where (b.DLV_STS_CODE = 'I' or UNDLV_NEXT_ATUN_CODE = 'E')) ";
                //String sqlbiaozhun ="select * from wujiangmail";
                PreparedStatement pstmt1 = conn.prepareStatement(sqlbiaozhun);
                pstmt1.setString(1, kshijian);
                pstmt1.setString(2, jshijian);
                
                ResultSet rs1 =pstmt1.executeQuery();
                while(rs1.next()){
                    map.put(rs1.getString(1), rs1.getString(1));
                }
                rs1.close();
                pstmt1.close();
                
                MyLog.close(conn);
        }catch(SQLException sqle){
            sqle.printStackTrace();
            MyLog.logtooracle("getZhekou", sqle);
        }catch(ClassNotFoundException cnfe){
            cnfe.printStackTrace();
            MyLog.logtooracle("getZhekou", cnfe);
        }catch(InstantiationException ie ){
            ie.printStackTrace();
            MyLog.logtooracle("getZhekou", ie);
        }catch(IllegalAccessException iae){
            iae.printStackTrace();
            MyLog.logtooracle("getZhekou", iae);
        }
        
        
        return map;
    }
}
