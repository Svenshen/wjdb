/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Beans.fengfa;

import Beans.MyLog;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class Tuotoulvmingxi {
    String jigou;
    String youjianhao;
    public Tuotoulvmingxi(String jigou,String youjianhao){
        this.jigou = jigou;
        this.youjianhao = youjianhao;
    }
    public Tuotoulvmingxi(){
    }
    
    
    public String getJigou(){
        return jigou;
    }
    public String getYoujianhao(){
        return youjianhao;
    }
    public ArrayList<Tuotoulvmingxi> getmingxi(String shijian){
        ArrayList<Tuotoulvmingxi> arr = new ArrayList<>();
        String sql2 = "select res_org.ORG_SNAME,mail_num from WUJIANGFENGFA left join res_org on res_org.org_code = dlv_org_code where DEAL_ORG_CODE = '21520000' and DEAL_DATE = ?  and dlv_org_code like '2152%' and dlv_org_code != '21520000' and MAIL_NUM not in(select MAIL_NUM from WUJIANGTOUDI where SEAL_DATE = ?)  ";
        try{
//            Class.forName(driver).newInstance();
            Connection conn = MyLog.getConn();
            
            PreparedStatement pstmt2 = conn.prepareStatement(sql2);
            pstmt2.setString(1, shijian);
            pstmt2.setString(2, shijian);
            
            ResultSet rs2 =pstmt2.executeQuery();
            while(rs2.next()){
                arr.add(new Tuotoulvmingxi(rs2.getString("org_sname"),rs2.getString("mail_num")));
            }
           
           
           
            pstmt2.close();
            
            
            rs2.close();
            MyLog.close(conn);
            //Thread.sleep(1000*60);
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return arr;
    }
    
    public static void main(String[] args) {
        Tuotoulvmingxi mi = new Tuotoulvmingxi();
        ArrayList<Tuotoulvmingxi> al = mi.getmingxi("20170628");
        for(int i = 0;i<al.size();i++){
            System.out.println(al.get(i).getJigou());
        }
        
    }
}
