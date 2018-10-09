/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Beans.Butie.Xinchou;

import Beans.MyLog;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Administrator
 */
public class Mail {
    private String youjianhao;
    private int shoujiriqi;
    private String jigoudaima;
    private String chanpindaima;
    private String jigoumingcheng;
    private String kehudaima;
    private String kehumingcheng;
    private String jiaoyima;
    private String jidasheng;
    private String jidashi;
    private String jidadidaima;
    private double youjianzhongliang;
    private double biaozhunzifei;
    private double xitongzifei;
    private double shishouzifei;
    private double butiejine = 0.0;
    
    
    Mail(String youjianhao,int shoujiriqi,String jigoudaima,String chanpindaima,String jigoumingcheng,String kehudaima,String kehumingcheng,String jiaoyima,String jidasheng,String jidashi,String jidadidaima,double youjianzhongliang,double biaozhunzifei,double xitongzifei){
        
        setYoujianhao( youjianhao);
        setShoujiriqi( shoujiriqi);
        setJigoudaima(jigoudaima);
        setChanpindaima(chanpindaima);
        setJigoumingcheng(jigoumingcheng);        
        setKehudaima( kehudaima);
        setKehumingcheng( kehumingcheng);
        setJiaoyima( jiaoyima);
        setJidasheng( jidasheng);
        setJidashi( jidashi);
        setJidadidaima( jidadidaima);
        setYoujianzhongliang(youjianzhongliang);
        setBiaozhunzifei( biaozhunzifei);
        setXitongzifei( xitongzifei);
        setShishouzifei( xitongzifei);
    }

    
    
    
    
    
    public void setYoujianhao(String youjianhao){
        youjianhao.trim();
        this.youjianhao = youjianhao;
    }
    public void setShoujiriqi(int shoujiriqi){
        
        this.shoujiriqi = shoujiriqi;
    }
    public void setJigoudaima(String jigoudaima){
        if(jigoudaima == null){
            jigoudaima = "";
        }else{
            jigoudaima.trim();
        }
        
        this.jigoudaima = jigoudaima;
    }
    public void setChanpindaima(String chanpindaima){
        chanpindaima.trim();
        this.chanpindaima = chanpindaima;
    }
    public void setJigoumingcheng(String jigoumingcheng){
        jigoumingcheng.trim();
        this.jigoumingcheng = jigoumingcheng;
    }
    public void setKehudaima(String kehudaima){
        kehudaima.trim();
        this.kehudaima = kehudaima;
    }
    public void setKehumingcheng(String kehumingcheng){
        if(kehumingcheng == null){
            kehumingcheng = "未知客户";
        }else{
            kehumingcheng.trim();
        }
        this.kehumingcheng = kehumingcheng;
    }
    public void setJiaoyima(String jiaoyima){
        if(jiaoyima == null){
            jiaoyima = "4443";
        }else{
        jiaoyima.trim();
        }
        this.jiaoyima = jiaoyima;
    }
    public void setJidasheng(String jidasheng){
        if(jidasheng == null){
            jidasheng = "未知";
        }else{
            jidasheng.trim();
        }
        this.jidasheng = jidasheng;
    }
    public void setJidashi(String jidashi){
        if(jidashi == null){
            jidashi = "未知";
        }else{
            jidashi.trim();
        }
        this.jidashi = jidashi;
    }
    public void setJidadidaima(String jidadidaima){
        jidadidaima.trim();
        this.jidadidaima = jidadidaima;
    }
    public void setYoujianzhongliang(double youjianzhongliang){
        this.youjianzhongliang = youjianzhongliang;
    }
    public void setBiaozhunzifei(double biaozhunzifei){
        this.biaozhunzifei = biaozhunzifei;
    }
    public void setXitongzifei(double xitongzifei){
        this.xitongzifei = xitongzifei;
    }
    public void setShishouzifei(double shishouzifei){
        this.shishouzifei = shishouzifei;
    }
    public void setButiezifei(double butiejine){
        this.butiejine = butiejine;
    }
    
    public String getYoujianhao(){
        return youjianhao;
    }
    public int getShoujiriqi(){
        return shoujiriqi;
    }
    public String getJigoudaima(){
        return jigoudaima;
    }
    public String getChanpindaima(){
        return chanpindaima;
    }
    public String getJigoumingcheng(){
        return jigoumingcheng;
    }
    public String getKehudaima(){
        return kehudaima;
    }
    public String getKehumingcheng(){
        return kehumingcheng;
    }
    public String getJiaoyima(){
        return jiaoyima;
    }
    public String getJidasheng(){
        return jidasheng;
    }
    public String getJidashi(){
        return jidashi;
    }
    public String getJidadidaima(){
        return jidadidaima;
    }
    public double getYoujianzhongliang(){
        return youjianzhongliang;
    }
    public double getBiaozhunzifei(){
        return biaozhunzifei;
    }
    public double getXitongzifei(){
        return xitongzifei;
    }
    public double getShishouzifei(){
        return shishouzifei;
    }
    public double getButiezifei(){
        return butiejine;
    }    
    
    public String getWenjianwupin(){
        if(("1".equals(chanpindaima.substring(1, 2)))||("2".equals(chanpindaima.substring(1, 2)))){
            return "文件";
        }else{
            return "物品";
        }
    }
    
    
    public void update(String butiezhonglei,String gongzuoid) {
         String sqli = "insert into butie values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
         String sqls = "select * from butie where youjianhao = ? and gongzuoid = ?";
         String sqld = "delete from butie where youjianhao = ? and gongzuoid = ?";
        try{
            
            Connection conn = MyLog.getConn();
            PreparedStatement pstmts = conn.prepareStatement(sqls);
            pstmts.setString(1, this.getYoujianhao());
            pstmts.setString(2, gongzuoid);
            ResultSet rs = pstmts.executeQuery();
            if(rs.next()){
                PreparedStatement pstmtd = conn.prepareStatement(sqld);
                pstmtd.setString(1, this.getYoujianhao());
                pstmtd.setString(2, gongzuoid);
                pstmtd.executeUpdate();
                pstmtd.close();
            }
            rs.close();
            pstmts.close();
            PreparedStatement pstmt = conn.prepareStatement(sqli);
            //System.out.println(request.getParameter("kshijian").replace("-", ""));
            pstmt.setString(1, this.getYoujianhao());
            pstmt.setInt(2, this.getShoujiriqi());
            pstmt.setString(3, this.getJigoudaima());
            pstmt.setString(4, this.getChanpindaima());
            pstmt.setString(5, this.getJigoumingcheng());
            pstmt.setString(6, this.getKehudaima());
            pstmt.setString(7, this.getKehumingcheng());
            pstmt.setString(8, this.getJiaoyima());
            pstmt.setString(9, this.getJidasheng());
            pstmt.setString(10, this.getJidashi());
            pstmt.setString(11, this.getJidadidaima());
            pstmt.setDouble(12, this.getYoujianzhongliang());
            
            pstmt.setDouble(13, this.getBiaozhunzifei());
            pstmt.setDouble(14, this.getXitongzifei());
            pstmt.setDouble(15, this.getShishouzifei());
            pstmt.setDouble(16, this.getButiezifei());
            pstmt.setString(17, butiezhonglei);
            pstmt.setString(18, gongzuoid);
            pstmt.executeUpdate();
            pstmt.close();
            MyLog.close(conn);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void updatexinchou(String butiezhonglei,String id) {
         String sqli = "insert into butiexinchou values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
         String sqls = "select * from butiexinchou where youjianhao = ? and gongzuoid = ?";
         String sqld = "delete from butiexinchou where youjianhao = ? and gongzuoid = ?";
        try{
            
            Connection conn = MyLog.getConn();
            PreparedStatement pstmts = conn.prepareStatement(sqls);
            pstmts.setString(1, this.getYoujianhao());
            pstmts.setString(2, id);
            ResultSet rs = pstmts.executeQuery();
            if(rs.next()){
                PreparedStatement pstmtd = conn.prepareStatement(sqld);
                pstmtd.setString(1, this.getYoujianhao());
                pstmtd.setString(2, id);
                pstmtd.executeUpdate();
                pstmtd.close();
            }
            rs.close();
            pstmts.close();
            PreparedStatement pstmt = conn.prepareStatement(sqli);
            //System.out.println(request.getParameter("kshijian").replace("-", ""));
            pstmt.setString(1, this.getYoujianhao());
            pstmt.setInt(2, this.getShoujiriqi());
            pstmt.setString(3, this.getJigoudaima());
            pstmt.setString(4, this.getChanpindaima());
            pstmt.setString(5, this.getJigoumingcheng());
            pstmt.setString(6, this.getKehudaima());
            pstmt.setString(7, this.getKehumingcheng());
            pstmt.setString(8, this.getJiaoyima());
            pstmt.setString(9, this.getJidasheng());
            pstmt.setString(10, this.getJidashi());
            pstmt.setString(11, this.getJidadidaima());
            pstmt.setDouble(12, this.getYoujianzhongliang());
            
            pstmt.setDouble(13, this.getBiaozhunzifei());
            pstmt.setDouble(14, this.getXitongzifei());
            pstmt.setDouble(15, this.getShishouzifei());
            pstmt.setDouble(16, this.getButiezifei());
            pstmt.setString(17, butiezhonglei);
            pstmt.setString(18, id);
            pstmt.executeUpdate();
            pstmt.close();
            MyLog.close(conn);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

