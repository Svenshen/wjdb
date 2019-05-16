/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Beans.Sunyi2.Guonei;

import Beans.MyLog;

import Beans.Sunyi2.Feiyong;
import static Beans.Sunyi2.Guonei.Luxiang.shujuyuan;
import Beans.Sunyi2.Mail;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Administrator
 */
public class Shengneichulijijingzhuanfei extends Feiyong{

    public Shengneichulijijingzhuanfei(Mail mail) {
        super(mail);
    }

    @Override
    public double getFeiyong() {
        double feiyong=0.3;
        if(getMail().getYoujianzhongliang()>3.0){
            feiyong += Math.ceil(getMail().getYoujianzhongliang() - 3.0)*0.15;
        }
//        if("215200".equals(getMail().getJidadidaima())){
////            if(getMail().getJidadidaima().equals( "21529904")){
////            return 0.6;
////            }
//        
//            return 0.0;
//        }
//        
//        double feiyong = 0.0;
//       
//        switch(getMail().getYoujianluxiang()){
//            case "南集":
//                feiyong=0.3;
//                if(getMail().getYoujianzhongliang()>3.0){
//                    feiyong += Math.ceil(getMail().getYoujianzhongliang() - 3.0)*0.15;
//                }
//                break;
//            case "无锡":
//            case "未知":
//                if(this.getMail().getShoujiriqi().startsWith("2018")){
//                        feiyong=0.15;
//                        if(getMail().getYoujianzhongliang()>3.0){
//                            //0.15+6*0.15
//                            feiyong = feiyong+Math.ceil(getMail().getYoujianzhongliang() - 3.0)*0.15;
//                        }
//                }else{
//                    //江浙沪安徽四省经传费，
//                    switch(this.getMail().getJidasheng()){
//                        case "江苏省":
//                        case "浙江省":
//                        case "安徽省":
//                            String sql ="select a.LABEL_STRIP,COUNT(*) as jianshu from TB_EVT_BAG_MAIL_RELA a   where  a.MAIL_NUM = ? and a.BAG_ACTN_CODE = '3'  and a.DEAL_ORG_CODE = '21520000' group by a.LABEL_STRIP";
//                            try{
//
//                                Connection conn = MyLog.getConn();
//
//                                PreparedStatement pstmt = conn.prepareStatement(sql);
//                                //System.out.println(request.getParameter("kshijian").replace("-", ""));
//                                pstmt.setString(1, this.getMail().getMialno());
//                                ResultSet rs =pstmt.executeQuery();
//
//                                if(rs.next()){
//                                    //Luxiang l = new Luxiang();
//                                    double jianshu = rs.getDouble("jianshu");
//    //                                if(jianshu>1){
//    //                                    feiyong = 1.65/jianshu;
//    //                                }else{
//                                        feiyong = 0.3;
//                                        if(this.getMail().getYoujianzhongliang() > 3.0){
//                                            feiyong = 0.3+Math.ceil(getMail().getYoujianzhongliang() - 3.0)*0.15;
//                                        }
//    //                                }
//                                }
//                                rs.close();
//                                pstmt.close();
//                                MyLog.close(conn);
//                            }catch(Exception e){
//                                e.printStackTrace();
//                            }
//                    
//                    default:
//                        feiyong=0.15;
//                        if(getMail().getYoujianzhongliang()>3.0){
//                            //0.15+6*0.15
//                            feiyong = feiyong+Math.ceil(getMail().getYoujianzhongliang() - 3.0)*0.15;
//                        }
//                        break;
//                    }
//                }
//                break;
//            case "直发-":
//                feiyong = 0.0;
//                break;
//            default:
//                feiyong=0.055;
//                break;
//        }
//        if(getMail().getJidasheng().equals("江苏省")){
//            feiyong = feiyong*2;
//        }
        return feiyong;
    }
    
}
