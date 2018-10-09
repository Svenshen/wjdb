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
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class yujing {
    public String orgname;
    public String jingjinum = "0";
    public String biaozhunnum = "0";
    public String biaozhuncirinum = "0";
    public String jigouhao;
    public String jidasheng;
   // private static final String driver=MyLog.driver;
    public void setorgname(String orgname){
        this.orgname = orgname;
    }
    public void setjigouhao(String jigouhao){
        this.jigouhao = jigouhao;
    }
    public void setjingjinum(String jingjinum){
        this.jingjinum = jingjinum;
    }
    public void setbiaozhunnum(String biaozhunnum){
        this.biaozhunnum = biaozhunnum;
    }
    public void setbiaozhuncirinum(String biaozhucirinum){
        this.biaozhuncirinum = biaozhucirinum;
    }
    public void setjidasheng(String jidasheng){
        this.jidasheng = jidasheng;
    }
    public String getorgname(){
        return orgname;
    }
    public String getjingjinum(){
        return jingjinum;
    }
    public String getbiaozhunnum(){
        return biaozhunnum;
    }
    public String getjigouhao(){
        return jigouhao;
    }
    public String getbiaozhunciri(){
        return biaozhuncirinum;
    }
    public String getjidasheng(){
        return jidasheng;
    }
    public yujing(String orgname,String jingjinum,String biaozhunum,String jigouhao,String biaozhuncirinum){
        setorgname(orgname);
        setjingjinum(jingjinum);
        setbiaozhunnum(biaozhunum);
        setjigouhao(jigouhao);
        setbiaozhuncirinum(biaozhuncirinum);
        
    }
        public yujing(){
    }
    
    public ArrayList<yujing> getyujing(String kshijian,String jshijian){
         ArrayList<yujing> al = new ArrayList();
         //System.out.println(kshijian);
         try{
//                Class.forName(driver).newInstance();
                Connection conn = MyLog.getConn();
                String sqlbiaozhun = "select org_sname,clct_bureau_org_code,count(*) from wujiangmail where clct_date >= '20150901' and clct_date >= ? and clct_date <= ? and zhuangtai != '9' and (days+1) > biaozhun_days and mail_num like '1%' group by org_sname,clct_bureau_org_code";
                //String sqlbiaozhun ="select * from wujiangmail";
                PreparedStatement pstmt1 = conn.prepareStatement(sqlbiaozhun);
                pstmt1.setString(1, kshijian);
                pstmt1.setString(2, jshijian);
                
                ResultSet rs1 =pstmt1.executeQuery();
                while(rs1.next()){
                    yujing yj = new yujing();
                    yj.setorgname(rs1.getString("org_sname"));
                    yj.setjigouhao(rs1.getString("clct_bureau_org_code"));
                    yj.setbiaozhunnum(rs1.getString("count(*)"));
                    al.add(yj);
                }
                rs1.close();
                pstmt1.close();
                String sqljingji = "select org_sname,clct_bureau_org_code,count(*) from wujiangmail where clct_date >= '20150901' and clct_date >= ? and clct_date <= ? "+
                        "and zhuangtai != '9' and (days+1) > jingji_days "
                        +" and (mail_num like '5%' or mail_num like '9%')group by org_sname,clct_bureau_org_code";
               PreparedStatement pstmt2 = conn.prepareStatement(sqljingji);
               pstmt2.setString(1, kshijian);
                pstmt2.setString(2, jshijian);
                ResultSet rs2 =pstmt2.executeQuery();
                while(rs2.next()){
                    boolean flag = false;
                    for(int i = 0;i < al.size();i ++){
                        yujing y = al.get(i);
                        if(y.getorgname().equals(rs2.getString("org_sname"))){
                            y.setjingjinum(rs2.getString("count(*)"));
                            al.set(i, y);
                            flag = true;
                        }
                    }
                    if(!flag){
                            yujing y2 = new yujing();
                            y2.setorgname(rs2.getString("org_sname"));
                            y2.setjigouhao(rs2.getString("clct_bureau_org_code"));
                            y2.setjingjinum(rs2.getString("count(*)"));
                            al.add(y2);
                        }
                }
                
                rs2.close();
                pstmt2.close();
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
        return al;
    }
    
}
