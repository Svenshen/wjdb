/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Beans.Sunyi2.Web.Butie;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Beans.MyLog;
import java.sql.Connection;
import java.sql.PreparedStatement;


/**
 *
 * @author Administrator
 */
public class Xinjian {
    String kshijian;
    String jshijian;
    String gongzuoid;
    String leixing;//1--邮伴，备用
    String beizhu;
    
    
    public static void main(String[] args) {
        //Xinjian x = new Xinjian("2018-02-01","2018-02-01",1);
        //x/.tijiao();
    }
    public Xinjian(String kshijian,String jshijian,int leixing,String beizhu){
        this.kshijian = kshijian.replaceAll("-", "");
        this.jshijian = jshijian.replaceAll("-", "");
        switch(leixing){
            case 1:
                this.leixing = "邮伴补贴";
                break;
            case 2:
                this.leixing = "返利补贴";
                break;
            case 3:
                this.leixing = "按折扣补贴";
                break;
            case 4:
                this.leixing = "按首续重补贴";
                break;
            case 5:
                this.leixing = "按件补贴";
                break;
              
            case 9:
                this.leixing = "特殊补贴";
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
        
        String sqli = "insert into butiegongzuo values (?,?,?,?,?,?) ";
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
                        case "邮伴补贴":
                            Beans.Butie.Jisuan.youban(kshijian, jshijian, gongzuoid);
                            break;
                        case "返利补贴":
                            Beans.Butie.Jisuan.fanlibutie(kshijian, jshijian,gongzuoid);
                            break;
                        case "按折扣补贴":
                            Beans.Butie.Jisuan.zhekoubutie(kshijian, jshijian, gongzuoid);
                            break;
                        case "按首续重补贴":
                            Beans.Butie.Jisuan.shouxuzhongbutie(kshijian, jshijian, gongzuoid);
                            break;
                        case "按件补贴":
                            Beans.Butie.Jisuan.anjianbutie(kshijian, jshijian, gongzuoid);
                            break;
                        case "特殊补贴":
                            Beans.Butie.Jisuan.teshubutie(kshijian, jshijian, gongzuoid);
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

