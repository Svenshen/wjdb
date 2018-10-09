/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Beans.Sunyi2.Web.Sunyi;

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
    String kehu ="";
    String beizhu;
    int leixing;//1--国内，2--国际
    public static void main(String[] args) {
        Xinjian x = new Xinjian("2018-09-01","2018-09-31",1,"","9月计算1");
        x.tijiao();
    }
    public Xinjian(String kshijian,String jshijian,int leixing,String kehu,String beizhu){
        this.kshijian = kshijian.replaceAll("-", "");
        this.jshijian = jshijian.replaceAll("-", "");
        this.leixing = leixing;
        
        gongzuoid = String.valueOf(System.currentTimeMillis());
        this.kehu = kehu;
        this.beizhu = beizhu;
    }
    public boolean tijiao(){
        if(leixing == 1){
            return tijiaoguonei();
        }else{
            return tijiaoguoji();
        }
    }
    public boolean tijiaoguonei(){
        boolean flag = false;
        int updatei = 0;
        
        String sqli = "insert into guoneisunyigongzuo values (?,?,?,?,?) ";
        //String sql = "select * from wujiangmail where mail_num in (SELECT COLUMN1 FROM TEMP )";
        //Chanpin chanpin = new Chanpin();
        try{
                Connection conn = MyLog.getConn();
                PreparedStatement pstmt = conn.prepareStatement(sqli);
                //System.out.println(request.getParameter("kshijian").replace("-", ""));
                pstmt.setString(1, gongzuoid);
                pstmt.setString(2, kshijian);
                pstmt.setString(3, jshijian);
                pstmt.setString(4, "计算中1");
                pstmt.setString(5, beizhu);
                updatei =pstmt.executeUpdate();
                
                    new Thread(() -> {
                    if(kehu==null||"".equals(kehu)){
                        Beans.Sunyi2.Jisuan.jisuanguonei(kshijian, jshijian, gongzuoid);
                    }else{
                        Beans.Sunyi2.Jisuan.jisuanguoneikehu(kshijian, jshijian, gongzuoid,kehu);
                    }}).start();
                
                
                
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
    public boolean tijiaoguoji(){
        boolean flag = false;
        int updatei = 0;
        
        String sqli = "INSERT INTO guojisunyigongzuo VALUES (?,?,?,?,?) ";
        //String sql = "select * from wujiangmail where mail_num in (SELECT COLUMN1 FROM TEMP )";
        //Chanpin chanpin = new Chanpin();
        try{
                Connection conn = MyLog.getConn();
                PreparedStatement pstmt = conn.prepareStatement(sqli);
                //System.out.println(request.getParameter("kshijian").replace("-", ""));
                pstmt.setString(1, gongzuoid);
                pstmt.setString(2, kshijian);
                pstmt.setString(3, jshijian);
                pstmt.setString(4, "计算中");
                pstmt.setString(5, beizhu);
                updatei =pstmt.executeUpdate();
                new Thread(() -> {
                    if(kehu==null||"".equals(kehu)){
                        Beans.Sunyi2.Jisuan.jisuanguoji(kshijian, jshijian, gongzuoid);
                    }else{
                        Beans.Sunyi2.Jisuan.jisuanguojikehu(kshijian, jshijian, gongzuoid,kehu);
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

    public String getKshijian() {
        return kshijian;
    }

    public void setKshijian(String kshijian) {
        this.kshijian = kshijian;
    }

    public String getJshijian() {
        return jshijian;
    }

    public void setJshijian(String jshijian) {
        this.jshijian = jshijian;
    }

    public String getGongzuoid() {
        return gongzuoid;
    }

    public void setGongzuoid(String gongzuoid) {
        this.gongzuoid = gongzuoid;
    }

    public String getKehu() {
        return kehu;
    }

    public void setKehu(String kehu) {
        this.kehu = kehu;
    }

    public String getBeizhu() {
        return beizhu;
    }

    public void setBeizhu(String beizhu) {
        this.beizhu = beizhu;
    }

    public int getLeixing() {
        return leixing;
    }

    public void setLeixing(int leixing) {
        this.leixing = leixing;
    }
    
    
    
}
