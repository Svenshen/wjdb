/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Beans.index;

import Beans.MyLog;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class index {
    private String mailno;
    private String orgsname;
//    private static final String driver=MyLog.driver;
    public void setMailno(String mailno){
        this.mailno = mailno;
    }
    public void setOrgsname(String orgsname){
        this.orgsname = orgsname;
    }
    public String getMailno(){
        return mailno;
    }
    public String getOrgsname(){
        return orgsname;
    }
    
    public HashMap<String,List> getDate(String mailno,String qian,String hou){
        int qiani = Integer.valueOf(qian);
        int houi = Integer.valueOf(hou);
        HashMap<String,List> al = new  HashMap<String,List>();
        //List<index> yuanl = new ArrayList<index>();
        List<index> qianl = new ArrayList<index>();
        List<index> houl = new ArrayList<index>();
        String sqlshouji = "select * from wujiangmail where mail_num = ?";
        DecimalFormat df = new DecimalFormat("00000000");
        try{
//                Class.forName(driver).newInstance();
                Connection conn = MyLog.getConn();
            if(mailno.length() == 13){
                
                            String tou = mailno.substring(0,2);
                            String wei = mailno.substring(11,13);
                            String shuzi = mailno.substring(2, 10);
                            int shu = Integer.valueOf(shuzi);
                            int yuanshu = shu;
                            //List<Integer> shuzu = new ArrayList<Integer>();
                            for(int i = 0;i <= qiani; i ++){
                                
                                String zhongjian = df.format(shu);
                                int yanzheng =11-((Integer.valueOf(zhongjian.substring(0, 1))*8+Integer.valueOf(zhongjian.substring(1, 2))*6+
                                        Integer.valueOf(zhongjian.substring(2, 3))*4+Integer.valueOf(zhongjian.substring(3, 4))*2+
                                        Integer.valueOf(zhongjian.substring(4, 5))*3+Integer.valueOf(zhongjian.substring(5, 6))*5+
                                        Integer.valueOf(zhongjian.substring(6, 7))*9+Integer.valueOf(zhongjian.substring(7, 8))*7)%11);
                                if(yanzheng == 10){
                                    yanzheng = 0;
                                }else if(yanzheng == 11){
                                    yanzheng = 5;
                                }else if(yanzheng < 10){                                
                                }
                                String wanzheng = tou+zhongjian+yanzheng+wei;
                            
                             PreparedStatement pstmt2 = conn.prepareStatement(sqlshouji);
                                pstmt2.setString(1, wanzheng);
                                ResultSet rs2 =pstmt2.executeQuery();
                                index ii = new  index();
                                ii.setMailno(wanzheng);
                                if(rs2.next()){
                                    ii.setOrgsname(rs2.getString("org_sname"));
                                }else{
                                    ii.setOrgsname(" ");
                                }
                                qianl.add(ii);
                                rs2.close();
                                pstmt2.close();
                                shu --;
                            }
                            shu = yuanshu;
                            for(int i = 0;i <= houi; i ++){
                                
                                String zhongjian = df.format(shu);
                                int yanzheng =11-((Integer.valueOf(zhongjian.substring(0, 1))*8+Integer.valueOf(zhongjian.substring(1, 2))*6+
                                        Integer.valueOf(zhongjian.substring(2, 3))*4+Integer.valueOf(zhongjian.substring(3, 4))*2+
                                        Integer.valueOf(zhongjian.substring(4, 5))*3+Integer.valueOf(zhongjian.substring(5, 6))*5+
                                        Integer.valueOf(zhongjian.substring(6, 7))*9+Integer.valueOf(zhongjian.substring(7, 8))*7)%11);
                                if(yanzheng == 10){
                                    yanzheng = 0;
                                }else if(yanzheng == 11){
                                    yanzheng = 5;
                                }else if(yanzheng < 10){                                
                                }
                                String wanzheng = tou+zhongjian+yanzheng+wei;
                            
                             PreparedStatement pstmt2 = conn.prepareStatement(sqlshouji);
                                pstmt2.setString(1, wanzheng);
                                ResultSet rs2 =pstmt2.executeQuery();
                                index ii = new  index();
                                ii.setMailno(wanzheng);
                                if(rs2.next()){
                                    ii.setOrgsname(rs2.getString("org_sname"));
                                }else{
                                    ii.setOrgsname(" ");
                                }
                                houl.add(ii);
                                rs2.close();
                                pstmt2.close();
                                shu ++;
                            }
                            
                                
            }
        
        }catch(Exception e){
                    e.printStackTrace();
                    }
        al.put("qian", qianl);
        al.put("hou", houl);
        return al;
    }
}
