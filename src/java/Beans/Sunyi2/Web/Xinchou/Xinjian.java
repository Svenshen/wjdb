/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Beans.Sunyi2.Web.Xinchou;

import Beans.Sunyi2.Web.Sunyi.*;
import Beans.MyLog;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Administrator
 */
public class Xinjian {
    String kshijian;
    String jshijian;
    String gongzuoid;
    String leixing;//1--横扇，备用
    String beizhu;
    
    
    public static void main(String[] args) {
        //Xinjian x = new Xinjian("2018-01-01","2018-01-31",2,"程序内");
        Xinjian x = new Xinjian("2018-02-01","2018-02-31",2,"程序内");
        x.tijiao();
    }
    public Xinjian(String kshijian,String jshijian,int leixing,String beizhu){
        this.kshijian = kshijian.replaceAll("-", "");
        this.jshijian = jshijian.replaceAll("-", "");
        switch(leixing){
            case 1:
                this.leixing = "横扇薪酬";
                break;
            case 2:
                this.leixing = "横扇薪酬2018";
                break;
            case 3:
                this.leixing = "横扇薪酬2018全";
                break;
        }
        this.beizhu = beizhu;
        gongzuoid = String.valueOf(System.currentTimeMillis());
    }
    public boolean tijiao(){
        return tijiao2();
    }
    public boolean tijiao2(){
        boolean flag = false;
        int updatei = 0;
        
        String sqli = "insert into butiexinchougongzuo values (?,?,?,?,?,?) ";
        //String sql = "select * from wujiangmail where mail_num in (SELECT COLUMN1 FROM TEMP )";
        //Chanpin chanpin = new Chanpin();
        try{
                Connection conn = MyLog.getConn();
                PreparedStatement pstmt = conn.prepareStatement(sqli);
                //System.out.println(request.getParameter("kshijian").replace("-", ""));
                pstmt.setString(1, gongzuoid);
                pstmt.setString(2, kshijian);
                pstmt.setString(3, jshijian);
                pstmt.setString(4, leixing);
                pstmt.setString(5, "计算中1");
                pstmt.setString(6, beizhu);
                updatei =pstmt.executeUpdate();
                
                new Thread(() -> {
                    switch(leixing){
                        case "横扇薪酬":
                            Beans.Butie.Xinchou.Jisuan.hengshan(kshijian, jshijian, gongzuoid);
                            break;
                        case "横扇薪酬2018":
                            Beans.Butie.Xinchou.Jisuan.hengshan2018(kshijian, jshijian, gongzuoid);
                            //Beans.Butie.Xinchou.Jisuan.youban(kshijian, jshijian, gongzuoid);
                            break;
                        case "横扇薪酬2018全":
                            Beans.Butie.Xinchou.Jisuan.hengshan2018quan(kshijian, jshijian, gongzuoid);
                            //Beans.Butie.Xinchou.Jisuan.youban(kshijian, jshijian, gongzuoid);
                            break;
                    }
                }).start();
                
                pstmt.close();
                MyLog.close(conn);
        }catch(Exception e){
            e.printStackTrace();
        }
        if(updatei >0 ){
            flag = true;
        }
        return flag;
    }
}
