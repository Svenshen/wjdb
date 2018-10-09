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
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class Nanji {
    //private static final String driver=MyLog.driver;
    public static void main(String[] args) {
        Nanji n = new Nanji();
        List<Nanji> as = n.getweishouji("20160329");
        for(Nanji s : as){
            System.out.println(s.GetMailno());
        }
    }
    
    private String mailno;
    private String orgname;
    public void SetMailno(String mailno){
       this.mailno = mailno; 
    }
    public void Setorgname(String orgname){
        this.orgname = orgname;
    }
    public String GetMailno(){
        return mailno;
    }
    public String GetOrgname(){
        return orgname;
    }
    
    public List<Nanji> getweishouji(String shijian){
       List<Nanji> n = new ArrayList<Nanji>(); 
       // List<String> m = new ArrayList<String>();
       DecimalFormat df = new DecimalFormat("00000000");
        try{
                //Class.forName(driver).newInstance();
                Connection conn = MyLog.getConn();
                //
                String sqlweishouji = "select mail_num from wujiangfengfa where deal_org_code = '21520000' and bag_actn_code = '3'  and deal_date = ? and dlv_org_code not like '2152%' and mail_num not in(select mail_num from wujiangmail)";
                //String sqlweishouji = "select fengfa.mail_num as mail1 ,shouji.mail_num as mail2 from wujiangfengfa  fengfa left join wujiangmail  shouji on fengfa.mail_num = shouji.mail_num where fengfa.deal_org_code = '21520000' and fengfa.bag_actn_code = '3'  and fengfa.deal_date = ? and dlv_org_code not like '2152%'";
                String sqlshouji = "select * from wujiangmail where mail_num = ?";
                //String sqlfengfajinkou = "select *  from wujiangfengfa  fengfa  where fengfa.deal_org_code = '21520000' and fengfa.bag_actn_code = '3'  and  fengfa.mail_num = ? and dlv_org_code not like '2152%'";
//String sqlbiaozhun ="select * from wujiangmail";
                PreparedStatement pstmt1 = conn.prepareStatement(sqlweishouji);
                
                pstmt1.setString(1, shijian);
                
                //pstmt1.setString(2, jshijian);
                
                ResultSet rs1 =pstmt1.executeQuery();
                
                while(rs1.next()){
                    
                    
                        String mailno = rs1.getString(1);
                        //PreparedStatement pstmt3 = conn.prepareStatement(sqlfengfajinkou);
                        //pstmt3.setString(1, mailno);
                        //ResultSet rs3 =pstmt3.executeQuery();
//                        if(rs3.next()){
//                            rs3.close();
//                            pstmt3.close();
//                            continue;
//                        }
//                        rs3.close();
//                            pstmt3.close();
                            Nanji m = new Nanji();
                        if(mailno.length() == 13){
                            String tou = mailno.substring(0,2);
                            String wei = mailno.substring(11,13);
                            String shuzi = mailno.substring(2, 10);
                            //System.out.println(mailno);
                            int shu = 0;
                            try{
                                 shu = Integer.valueOf(shuzi);
                            }catch(NumberFormatException e){
                                m.Setorgname("null");
                                m.SetMailno(mailno);
                                n.add(m);
                                continue;
                            }
                            //int yuanshu = shu;
                            //List<Integer> shuzu = new ArrayList<Integer>();
                            for(int i = 0;i < 100; i ++){
                                shu --;
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
                                if(rs2.next()){
                                    m.Setorgname(rs2.getString("org_sname"));
                                    rs2.close();
                                    pstmt2.close();
                                    break;
                                }
                                
                                rs2.close();
                                pstmt2.close();
                            }
                        }else{
                            m.Setorgname("null");
                        }
                        //Integer.valueOf(mailno.substring(2, 3))
                        
                        m.SetMailno(mailno);
                        n.add(m);
                    
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
        
        return n;
    }
    
}
