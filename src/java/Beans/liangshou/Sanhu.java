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
public class Sanhu {
    public String jigou;
    public String lanshouyuan;
    public String chanp;
    public String kehudaima;
    public String dakehu;
    public String liang;
    public String shou;
    public Sanhu(){
        
    }
    public Sanhu(String jigou,String lanshouyuan,String chanpin,String kehudaima,String dakehu,String liang,String shou){
        this.jigou =jigou;
        this.lanshouyuan = lanshouyuan;
        this.chanp = chanpin;
        this.kehudaima = kehudaima;
        this.dakehu = dakehu;
        this.liang  = liang;
        this.shou = shou;
    }
    public ArrayList<Sanhu> getSanhu(String kshijian,String jshijian){
        ArrayList s = new ArrayList<Sanhu>();
        try{
                //Class.forName(driver).newInstance();
                Connection conn = MyLog.getConn();
                String sql = "select ORG_SNAME,CLCT_STAFF_NAME,yewulei,SENDER_CUST_CODE,kehumingcheng,COUNT(*),sum(ACTUAL_TOTAL_FEE) from WUJIANGMAIL where CLCT_DATE >= ? and CLCT_DATE <= ? group by ORG_SNAME,CLCT_STAFF_NAME,yewulei,SENDER_CUST_CODE,kehumingcheng" ;
                //String sqlt = "select JIAOYIMA as jiaoyima,count(mail_num) as mailcount,sum(actual_total_fee) as totalfee,sum(SHOULD_PAY_TOTAL_FEE) as shouldfee from WUJIANGMAIL where CLCT_DATE >= ? and CLCT_DATE <= ? and jiaoyima ='482'and shi in(select city from jingkuai_city) GROUP by JIAOYIMA";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                //System.out.println(request.getParameter("kshijian").replace("-", ""));
                pstmt.setString(1, kshijian);
                pstmt.setString(2, jshijian);
                ResultSet rs =pstmt.executeQuery();
                
                while(rs.next()){
                    Sanhu z = new Sanhu(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
                    
                        //z.setYouhang("错误");
                    
                        //z.setYouhang(String.valueOf(format.format(rs.getDouble("totalfee")/rs.getDouble("shouldfee"))));
                    
                    s.add(z);
                    //al.add(t);
                    //out.println("<tr><td>"+rs.getString("name")+"</td>");
                    //out.println("<td>"+rs.getString("mailcount")+"</td>");
                    //out.println("<td>"+rs.getString("fee")+"</td></tr>");
                    //out.println("<tr><td>:</td><td>"+rs.getString(4)+"</td></tr>");
                               }
                rs.close();
                pstmt.close();
                
                
                MyLog.close(conn);
        }catch(SQLException sqle){
            sqle.printStackTrace();
            //MyLog.logtooracle(jigou, sqle);
        }catch(ClassNotFoundException cnfe){
            cnfe.printStackTrace();
            //MyLog.logtooracle(jigou, cnfe);
        }catch(InstantiationException ie ){
            ie.printStackTrace();
            //MyLog.logtooracle(jigou, ie);
        }catch(IllegalAccessException iae){
            iae.printStackTrace();
            //MyLog.logtooracle(jigou, iae);
        }
        
        
       return s;
    }
}
