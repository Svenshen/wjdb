/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ZZBeans.Sunyi;

import Beans.MyLog;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Administrator
 */
public class Sunyijisuan {
    
    
    public static void main(String[] args) {
        String kshijian = "20160801";
        String jshijian = "20160831";
         try{
                Biaokuai bk = new Biaokuai();
                JiangsuBiaokuai jsbk = new JiangsuBiaokuai();
                Kuaibao kb = new Kuaibao();
                JiangsuKuaibao jskb = new JiangsuKuaibao();
                EBiaokuai ebk = new EBiaokuai();
                //Class.forName(driver).newInstance();
                Connection conn = MyLog.getConn();
                //and substr(prod_code,3,1) = '1'
                String sql = "select * from wujiangmail where clct_date >= ? and clct_date <= ?";
                String sqlsunyi = "insert into sunyibiao values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                
                PreparedStatement pstmt = conn.prepareStatement(sql);
                //System.out.println(request.getParameter("kshijian").replace("-", ""));
                pstmt.setString(1, kshijian);
                pstmt.setString(2, jshijian);
                
                ResultSet rs =pstmt.executeQuery();
                while(rs.next()){
                    try{
                    System.out.println(rs.getString("mail_num"));
                    double zhongliang = Double.parseDouble(rs.getString("BILLING_WEIGHT"));
                    String jidadi = rs.getString("sheng");
                    PreparedStatement sunyistmt = conn.prepareStatement(sqlsunyi);
                    if("江苏省".equals(rs.getString("sheng"))){
                                switch (rs.getInt("yewuleidaima")){
                                //标准
                                //E标准
                                case 1:
                                case 2:
                                    sunyistmt.setString(1, rs.getString("mail_num"));
                                    sunyistmt.setString(2, rs.getString("clct_date"));
                                    sunyistmt.setString(3, rs.getString("CLCT_BUREAU_ORG_CODE"));
                                    sunyistmt.setString(4, rs.getString("org_sname"));
                                    sunyistmt.setString(5, rs.getString("CLCT_STAFF_NAME"));
                                    sunyistmt.setString(6, rs.getString("SENDER_CUST_CODE"));
                                    sunyistmt.setString(7, rs.getString("kehumingcheng"));
                                    sunyistmt.setString(8, rs.getString("sheng"));
                                    sunyistmt.setString(9, rs.getString("SHOULD_PAY_TOTAL_FEE"));
                                    sunyistmt.setString(10, rs.getString("ACTUAL_TOTAL_FEE"));
                                    sunyistmt.setString(11, rs.getString("ACTUAL_WEIGHT"));
                                    sunyistmt.setString(12, rs.getString("VOL_WEIGHT"));
                                    sunyistmt.setString(13, rs.getString("BILLING_WEIGHT"));
                                    sunyistmt.setString(14, String.valueOf(jsbk.getHaocai()));
                                    sunyistmt.setString(15, String.valueOf(jsbk.getLantouyuanjijian()));
                                    sunyistmt.setString(16, String.valueOf(jsbk.getShoujiShitang(zhongliang)));
                                    sunyistmt.setString(17, String.valueOf(jsbk.getShoujiNeibuchuli()));
                                    sunyistmt.setString(18, String.valueOf(jsbk.getShengneiergan(jidadi, zhongliang)));
                                    sunyistmt.setString(19, String.valueOf(jsbk.getShengneijingzhuan(zhongliang)));
                                    sunyistmt.setString(20, String.valueOf(jsbk.getShengjiyigan(jidadi, zhongliang)));
                                    sunyistmt.setString(21, String.valueOf(jsbk.getKuashengjingzhuan(jidadi)));
                                    sunyistmt.setString(22, String.valueOf(jsbk.getToudineibuchuli(zhongliang)));
                                    sunyistmt.setString(23, String.valueOf(jsbk.getToudishitangergan(jidadi, zhongliang)));
                                    sunyistmt.setString(24, String.valueOf(jsbk.getToudifei(zhongliang)));
                                    sunyistmt.setString(25, rs.getString("yewulei")+"江苏");
                                    sunyistmt.executeUpdate();
                                    break;
                                    //快包
                                case 3:
                                    sunyistmt.setString(1, rs.getString("mail_num"));
                                    sunyistmt.setString(2, rs.getString("clct_date"));
                                    sunyistmt.setString(3, rs.getString("CLCT_BUREAU_ORG_CODE"));
                                    sunyistmt.setString(4, rs.getString("org_sname"));
                                    sunyistmt.setString(5, rs.getString("CLCT_STAFF_NAME"));
                                    sunyistmt.setString(6, rs.getString("SENDER_CUST_CODE"));
                                    sunyistmt.setString(7, rs.getString("kehumingcheng"));
                                    sunyistmt.setString(8, rs.getString("sheng"));
                                    sunyistmt.setString(9, rs.getString("SHOULD_PAY_TOTAL_FEE"));
                                    sunyistmt.setString(10, rs.getString("ACTUAL_TOTAL_FEE"));
                                    sunyistmt.setString(11, rs.getString("ACTUAL_WEIGHT"));
                                    sunyistmt.setString(12, rs.getString("VOL_WEIGHT"));
                                    sunyistmt.setString(13, rs.getString("BILLING_WEIGHT"));
                                    sunyistmt.setString(14, String.valueOf(jskb.getHaocai()));
                                    sunyistmt.setString(15, String.valueOf(jskb.getLantouyuanjijian()));
                                    sunyistmt.setString(16, String.valueOf(jskb.getShoujiShitang(zhongliang)));
                                    sunyistmt.setString(17, String.valueOf(jskb.getShoujiNeibuchuli()));
                                    sunyistmt.setString(18, String.valueOf(jskb.getShengneiergan(jidadi, zhongliang)));
                                    sunyistmt.setString(19, String.valueOf(jskb.getShengneijingzhuan(zhongliang)));
                                    sunyistmt.setString(20, String.valueOf(jskb.getShengjiyigan(jidadi, zhongliang)));
                                    sunyistmt.setString(21, String.valueOf(jskb.getKuashengjingzhuan(jidadi)));
                                    sunyistmt.setString(22, String.valueOf(jskb.getToudineibuchuli(zhongliang)));
                                    sunyistmt.setString(23, String.valueOf(jskb.getToudishitangergan(jidadi, zhongliang)));
                                    sunyistmt.setString(24, String.valueOf(jskb.getToudifei(zhongliang)));
                                    sunyistmt.setString(25, rs.getString("yewulei")+"江苏");
                                    sunyistmt.executeUpdate();
                                    break;
                                    //E邮宝
                                case 4:
                                    break;
                                default:
                                    sunyistmt.setString(1, rs.getString("mail_num"));
                                    sunyistmt.setString(2, rs.getString("clct_date"));
                                    sunyistmt.setString(3, rs.getString("CLCT_BUREAU_ORG_CODE"));
                                    sunyistmt.setString(4, rs.getString("org_sname"));
                                    sunyistmt.setString(5, rs.getString("CLCT_STAFF_NAME"));
                                    sunyistmt.setString(6, rs.getString("SENDER_CUST_CODE"));
                                    sunyistmt.setString(7, rs.getString("kehumingcheng"));
                                    sunyistmt.setString(8, rs.getString("sheng"));
                                    sunyistmt.setString(9, rs.getString("SHOULD_PAY_TOTAL_FEE"));
                                    sunyistmt.setString(10, rs.getString("ACTUAL_TOTAL_FEE"));
                                    sunyistmt.setString(11, rs.getString("ACTUAL_WEIGHT"));
                                    sunyistmt.setString(12, rs.getString("VOL_WEIGHT"));
                                    sunyistmt.setString(13, rs.getString("BILLING_WEIGHT"));
                                    sunyistmt.setString(14, "0");
                                    sunyistmt.setString(15, "0");
                                    sunyistmt.setString(16, "0");
                                    sunyistmt.setString(17, "0");
                                    sunyistmt.setString(18, "0");
                                    sunyistmt.setString(19, "0");
                                    sunyistmt.setString(20, "0");
                                    sunyistmt.setString(21, "0");
                                    sunyistmt.setString(22, "0");
                                    sunyistmt.setString(23, "0");
                                    sunyistmt.setString(24, "0");
                                    sunyistmt.setString(25, "未匹配");
                                    sunyistmt.executeUpdate();
                                    break;

                            }
                    }else{
                        switch (rs.getInt("yewuleidaima")){
                                //标准
                                case 1:
                                    sunyistmt.setString(1, rs.getString("mail_num"));
                                    sunyistmt.setString(2, rs.getString("clct_date"));
                                    sunyistmt.setString(3, rs.getString("CLCT_BUREAU_ORG_CODE"));
                                    sunyistmt.setString(4, rs.getString("org_sname"));
                                    sunyistmt.setString(5, rs.getString("CLCT_STAFF_NAME"));
                                    sunyistmt.setString(6, rs.getString("SENDER_CUST_CODE"));
                                    sunyistmt.setString(7, rs.getString("kehumingcheng"));
                                    sunyistmt.setString(8, rs.getString("sheng"));
                                    sunyistmt.setString(9, rs.getString("SHOULD_PAY_TOTAL_FEE"));
                                    sunyistmt.setString(10, rs.getString("ACTUAL_TOTAL_FEE"));
                                    sunyistmt.setString(11, rs.getString("ACTUAL_WEIGHT"));
                                    sunyistmt.setString(12, rs.getString("VOL_WEIGHT"));
                                    sunyistmt.setString(13, rs.getString("BILLING_WEIGHT"));
                                    sunyistmt.setString(14, String.valueOf(bk.getHaocai()));
                                    sunyistmt.setString(15, String.valueOf(bk.getLantouyuanjijian()));
                                    sunyistmt.setString(16, String.valueOf(bk.getShoujiShitang(zhongliang)));
                                    sunyistmt.setString(17, String.valueOf(bk.getShoujiNeibuchuli()));
                                    sunyistmt.setString(18, String.valueOf(bk.getShengneiergan(jidadi, zhongliang)));
                                    sunyistmt.setString(19, String.valueOf(bk.getShengneijingzhuan(zhongliang)));
                                    sunyistmt.setString(20, String.valueOf(bk.getShengjiyigan(jidadi, zhongliang)));
                                    sunyistmt.setString(21, String.valueOf(bk.getKuashengjingzhuan(jidadi)));
                                    sunyistmt.setString(22, String.valueOf(bk.getToudineibuchuli(zhongliang)));
                                    sunyistmt.setString(23, String.valueOf(bk.getToudishitangergan(jidadi, zhongliang)));
                                    sunyistmt.setString(24, String.valueOf(bk.getToudifei(zhongliang)));
                                    sunyistmt.setString(25, rs.getString("yewulei"));
                                    sunyistmt.executeUpdate();
                                   break;
                                    //E标准
                                case 2:
                                    sunyistmt.setString(1, rs.getString("mail_num"));
                                    sunyistmt.setString(2, rs.getString("clct_date"));
                                    sunyistmt.setString(3, rs.getString("CLCT_BUREAU_ORG_CODE"));
                                    sunyistmt.setString(4, rs.getString("org_sname"));
                                    sunyistmt.setString(5, rs.getString("CLCT_STAFF_NAME"));
                                    sunyistmt.setString(6, rs.getString("SENDER_CUST_CODE"));
                                    sunyistmt.setString(7, rs.getString("kehumingcheng"));
                                    sunyistmt.setString(8, rs.getString("sheng"));
                                    sunyistmt.setString(9, rs.getString("SHOULD_PAY_TOTAL_FEE"));
                                    sunyistmt.setString(10, rs.getString("ACTUAL_TOTAL_FEE"));
                                    sunyistmt.setString(11, rs.getString("ACTUAL_WEIGHT"));
                                    sunyistmt.setString(12, rs.getString("VOL_WEIGHT"));
                                    sunyistmt.setString(13, rs.getString("BILLING_WEIGHT"));
                                    sunyistmt.setString(14, String.valueOf(ebk.getHaocai()));
                                    sunyistmt.setString(15, String.valueOf(ebk.getLantouyuanjijian()));
                                    sunyistmt.setString(16, String.valueOf(ebk.getShoujiShitang(zhongliang)));
                                    sunyistmt.setString(17, String.valueOf(ebk.getShoujiNeibuchuli()));
                                    sunyistmt.setString(18, String.valueOf(ebk.getShengneiergan(jidadi, zhongliang)));
                                    sunyistmt.setString(19, String.valueOf(ebk.getShengneijingzhuan(zhongliang)));
                                    sunyistmt.setString(20, String.valueOf(ebk.getShengjiyigan(jidadi, zhongliang)));
                                    sunyistmt.setString(21, String.valueOf(ebk.getKuashengjingzhuan(jidadi)));
                                    sunyistmt.setString(22, String.valueOf(ebk.getToudineibuchuli(zhongliang)));
                                    sunyistmt.setString(23, String.valueOf(ebk.getToudishitangergan(jidadi, zhongliang)));
                                    sunyistmt.setString(24, String.valueOf(ebk.getToudifei(zhongliang)));
                                    sunyistmt.setString(25, rs.getString("yewulei"));
                                    sunyistmt.executeUpdate();
                                    break;
                                    //快包
                                case 3:
                                    sunyistmt.setString(1, rs.getString("mail_num"));
                                    sunyistmt.setString(2, rs.getString("clct_date"));
                                    sunyistmt.setString(3, rs.getString("CLCT_BUREAU_ORG_CODE"));
                                    sunyistmt.setString(4, rs.getString("org_sname"));
                                    sunyistmt.setString(5, rs.getString("CLCT_STAFF_NAME"));
                                    sunyistmt.setString(6, rs.getString("SENDER_CUST_CODE"));
                                    sunyistmt.setString(7, rs.getString("kehumingcheng"));
                                    sunyistmt.setString(8, rs.getString("sheng"));
                                    sunyistmt.setString(9, rs.getString("SHOULD_PAY_TOTAL_FEE"));
                                    sunyistmt.setString(10, rs.getString("ACTUAL_TOTAL_FEE"));
                                    sunyistmt.setString(11, rs.getString("ACTUAL_WEIGHT"));
                                    sunyistmt.setString(12, rs.getString("VOL_WEIGHT"));
                                    sunyistmt.setString(13, rs.getString("BILLING_WEIGHT"));
                                    sunyistmt.setString(14, String.valueOf(kb.getHaocai()));
                                    sunyistmt.setString(15, String.valueOf(kb.getLantouyuanjijian()));
                                    sunyistmt.setString(16, String.valueOf(kb.getShoujiShitang(zhongliang)));
                                    sunyistmt.setString(17, String.valueOf(kb.getShoujiNeibuchuli()));
                                    sunyistmt.setString(18, String.valueOf(kb.getShengneiergan(jidadi, zhongliang)));
                                    sunyistmt.setString(19, String.valueOf(kb.getShengneijingzhuan(zhongliang)));
                                    sunyistmt.setString(20, String.valueOf(kb.getShengjiyigan(jidadi, zhongliang)));
                                    sunyistmt.setString(21, String.valueOf(kb.getKuashengjingzhuan(jidadi)));
                                    sunyistmt.setString(22, String.valueOf(kb.getToudineibuchuli(zhongliang)));
                                    sunyistmt.setString(23, String.valueOf(kb.getToudishitangergan(jidadi, zhongliang)));
                                    sunyistmt.setString(24, String.valueOf(kb.getToudifei(zhongliang)));
                                    sunyistmt.setString(25, rs.getString("yewulei"));
                                    sunyistmt.executeUpdate();
                                    break;
                                    //E邮宝
                                case 4:
                                    break;
                                default:
                                    sunyistmt.setString(1, rs.getString("mail_num"));
                                    sunyistmt.setString(2, rs.getString("clct_date"));
                                    sunyistmt.setString(3, rs.getString("CLCT_BUREAU_ORG_CODE"));
                                    sunyistmt.setString(4, rs.getString("org_sname"));
                                    sunyistmt.setString(5, rs.getString("CLCT_STAFF_NAME"));
                                    sunyistmt.setString(6, rs.getString("SENDER_CUST_CODE"));
                                    sunyistmt.setString(7, rs.getString("kehumingcheng"));
                                    sunyistmt.setString(8, rs.getString("sheng"));
                                    sunyistmt.setString(9, rs.getString("SHOULD_PAY_TOTAL_FEE"));
                                    sunyistmt.setString(10, rs.getString("ACTUAL_TOTAL_FEE"));
                                    sunyistmt.setString(11, rs.getString("ACTUAL_WEIGHT"));
                                    sunyistmt.setString(12, rs.getString("VOL_WEIGHT"));
                                    sunyistmt.setString(13, rs.getString("BILLING_WEIGHT"));
                                    sunyistmt.setString(14, "0");
                                    sunyistmt.setString(15, "0");
                                    sunyistmt.setString(16, "0");
                                    sunyistmt.setString(17, "0");
                                    sunyistmt.setString(18, "0");
                                    sunyistmt.setString(19, "0");
                                    sunyistmt.setString(20, "0");
                                    sunyistmt.setString(21, "0");
                                    sunyistmt.setString(22, "0");
                                    sunyistmt.setString(23, "0");
                                    sunyistmt.setString(24, "0");
                                    sunyistmt.setString(25, "未匹配");
                                    sunyistmt.executeUpdate();
                                    break;

                            }
                    }
                    
                    }catch(SQLServerException sqle){
                        sqle.printStackTrace();
                    }
                        
                }
                
        }catch(Exception e){
            e.printStackTrace();
        }
    }
         
}
