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
import java.util.HashMap;

/**
 *
 * @author Administrator
 * 
 */
public class Tuotoulv {
    public String jigouhao;
    public String jigouming;
    public String jinkouliang;
    public String weixiaduanliang;
    public String xiaduanlv;
    public String weituotouliang;
    public String tuotoulv;
    public Tuotoulv(){
        
    }
    public Tuotoulv(String jigouhao,String jigouming,String jinkouliang,String weixiaduanliang,String weituotouliang,String xiaduanlv,String tuotoulv){
        this.jigouhao =jigouhao;
        this.jigouming = jigouming;
        this.jinkouliang = jinkouliang;
        this.weixiaduanliang = weixiaduanliang;
        this.weituotouliang = weituotouliang;
    }
     public Tuotoulv(String jigouhao,String jigouming,String jinkouliang,String weixiaduanliang,String weituotouliang){
        this.jigouhao =jigouhao;
        this.jigouming = jigouming;
        this.jinkouliang = jinkouliang;
        this.weixiaduanliang = weixiaduanliang;
        this.weituotouliang = weituotouliang;
    }
    public void setjinkouliang(String jigouhao,String jigouming,String jinkouliang){
         this.jigouhao =jigouhao;
        this.jigouming = jigouming;
        this.jinkouliang = jinkouliang;
    }
    
    public void setweixiaduanliang(String jigouhao,String weixiaduanliang){
        
    }
     
    
    public HashMap<String, Tuotoulv> getshuju(String shijian){
        HashMap<String, Tuotoulv> map = new HashMap<>();
        String sql1 ="select DLV_ORG_CODE,res_org.ORG_SNAME,COUNT(*) from WUJIANGFENGFA left join res_org on res_org.org_code = dlv_org_code where DEAL_ORG_CODE = '21520000' and DEAL_DATE = ?  and dlv_org_code like '2152%' and dlv_org_code != '21520000'  group by dlv_org_code,res_org.ORG_SNAME";
        String sql2 = "select DLV_ORG_CODE,res_org.ORG_SNAME,COUNT(*) from WUJIANGFENGFA left join res_org on res_org.org_code = dlv_org_code where DEAL_ORG_CODE = '21520000' and DEAL_DATE = ?  and dlv_org_code like '2152%' and dlv_org_code != '21520000' and MAIL_NUM not in(select MAIL_NUM from WUJIANGTOUDI where SEAL_DATE = ?)  group by dlv_org_code,res_org.ORG_SNAME";
        String sql3 = "select DLV_ORG_CODE,res_org.ORG_SNAME,COUNT(*) from WUJIANGFENGFA left join res_org on res_org.org_code = dlv_org_code where DEAL_ORG_CODE = '21520000' and DEAL_DATE = ?  and dlv_org_code like '2152%' and dlv_org_code != '21520000' and MAIL_NUM not in(select MAIL_NUM from WUJIANGTOUDI2 where DLV_DATE = ? and DLV_STS_CODE = 'I')  group by dlv_org_code,res_org.ORG_SNAME";
        
        try{
            //Class.forName(driver).newInstance();
            Connection conn = MyLog.getConn();
            PreparedStatement pstmt1 = conn.prepareStatement(sql1);
            pstmt1.setString(1, shijian);
            PreparedStatement pstmt2 = conn.prepareStatement(sql2);
            pstmt2.setString(1, shijian);
            pstmt2.setString(2, shijian);
            PreparedStatement pstmt3 = conn.prepareStatement(sql3);
            pstmt3.setString(1, shijian);
            pstmt3.setString(2, shijian);
            ResultSet rs1 =pstmt1.executeQuery();
            ResultSet rs2 =pstmt2.executeQuery();
            ResultSet rs3 =pstmt3.executeQuery();
            while(rs1.next()){
                map.put(rs1.getString(1), new Tuotoulv(rs1.getString(1),rs1.getString(2),rs1.getString(3),"0","0"));
            }
            while(rs2.next()){
                map.get(rs2.getString(1)).weixiaduanliang = rs2.getString(3);
            }
            while(rs3.next()){
                map.get(rs3.getString(1)).weituotouliang = rs3.getString(3);
            }
            pstmt1.close();
            pstmt2.close();
            pstmt3.close();
            rs1.close();
            rs2.close();
            rs3.close();
            Thread.sleep(1000*60);
        }catch(Exception e){
            e.printStackTrace();
        }
        return map;
    }
    
}
