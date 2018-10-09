/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Beans.Sunyi2.Web.Butie;

import Beans.MyLog;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class Fanlikehu extends Kehu{
    String bianhao;
    //String kehudaima;
    String jiaoyima;
    String youjianleixing;
    String shouruqishi;
    String shourujieshu;
    String bili;

   
    public Fanlikehu() {
    }

    public Fanlikehu(String bianhao, String kehudaima, String jiaoyima, String youjianleixing, String shouruqishi, String shourujieshu,String bili, String kehumingcheng) {
        super(kehudaima, kehumingcheng);
        this.bianhao = bianhao;
        this.jiaoyima = jiaoyima;
        this.youjianleixing = youjianleixing;
        this.shouruqishi = shouruqishi;
        this.shourujieshu = shourujieshu;
        this.bili = bili;
    }

    
    public Fanlikehu(String kehudaima, String kehumingcheng, String shouruqishi, String shourujieshu) {
        super(kehudaima, kehumingcheng);
        this.shouruqishi = shouruqishi;
        this.shourujieshu = shourujieshu;
    }

    public boolean addKehu(String kehu,String shouruqishi,String shourujieshu){
        boolean flag= false;
        boolean findflag = false;
        if("".equals(shourujieshu)||shourujieshu == null){
            shourujieshu = "999999999";
        }
        if("".equals(shouruqishi)||shouruqishi == null){
            shouruqishi = "0";
        }
        String sqlfind = "select * from butiefanli where kehudaima = ?  ";
        
        
        String sql = "insert into butiefanli(kehudaima,yongyouliang1,yongyouliang2,shixiaoriqi) values(?,?,?,'99999999')";
        try{
                Connection conn = MyLog.getConn();
                PreparedStatement pstmts = conn.prepareStatement(sqlfind);
                pstmts.setString(1,kehu);
                 ResultSet rs = pstmts.executeQuery();
                 while(rs.next()){
                if(Double.valueOf(shourujieshu) >= rs.getDouble("yongyouliang1")){
                    if(Double.valueOf(shourujieshu) < rs.getDouble("yongyouliang2") ||("999999999".equals(shourujieshu) && rs.getDouble("yongyouliang2") == 999999999.00 )){
                        findflag =true;
                        break;
                    }
                    }
                if(Double.valueOf(shouruqishi) >= rs.getDouble("yongyouliang1")){
                    if(Double.valueOf(shouruqishi) < rs.getDouble("yongyouliang2") ){
                        findflag =true;
                        break;
                    }
                    }
                 }
                 rs.close();
                 pstmts.close();
                 if(!findflag){
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1,kehu);
                pstmt.setString(2,shouruqishi);
                pstmt.setString(3,shourujieshu);
                //System.out.println(request.getParameter("kshijian").replace("-", ""));
                
                int i =pstmt.executeUpdate();
                if(i>0){
                    flag = true;
                }
                pstmt.close();
                 }
                MyLog.close(conn);
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return flag;
    }
    
    public boolean addbili(String kehu,String shouruqishi,String shourujieshu,String jiaoyima,String youjianleixing,String fanlibili){
        boolean flag= false;
        //boolean findflag = false;
        if("max".equals(shourujieshu)){
            shourujieshu = "999999999";
        }
        String sqld = "delete from butiefanli where jiaoyima is null and youjianleixing is null and yongyouliang1 = ? and yongyouliang2 = ? and kehudaima = ?";
        String sql = "insert into butiefanli(kehudaima,jiaoyima,youjianleixing,yongyouliang1,yongyouliang2,bili,shixiaoriqi) values(?,?,?,?,?,?,'99999999')";
        try{
                Connection conn = MyLog.getConn();
                
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1,kehu);
                pstmt.setString(2,jiaoyima);
                pstmt.setString(3,youjianleixing);
                pstmt.setString(4,shouruqishi);
                pstmt.setString(5,shourujieshu);
                pstmt.setString(6,fanlibili);
                //System.out.println(request.getParameter("kshijian").replace("-", ""));
                
                int i =pstmt.executeUpdate();
                if(i>0){
                    flag = true;
                }
                pstmt.close();
                if(flag){
                    pstmt = conn.prepareStatement(sqld);
                    pstmt.setString(1, shouruqishi);
                    pstmt.setString(2, shourujieshu);
                    pstmt.setString(3, kehu);
                    pstmt.executeUpdate();
                    pstmt.close();
                }            
                MyLog.close(conn);
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return flag;
    }
    
    public boolean delbili(String id){
        boolean flag= false;
        //boolean findflag = false;
        System.out.println(id);
        
        String sql = "delete from butiefanli where bianhao = ?";
        try{
                Connection conn = MyLog.getConn();
                
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1,id);
                
                
                
                int i =pstmt.executeUpdate();
                if(i>0){
                    flag = true;
                }
                pstmt.close();
                            
                MyLog.close(conn);
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return flag;
    }
    
    public ArrayList<Fanlikehu> getFanlikehulist(){
        ArrayList<Fanlikehu> list = new ArrayList();
        String sql = "select butiefanli.kehudaima,kehumingcheng,yongyouliang1,yongyouliang2 from butiefanli left join kehuxinxi on butiefanli.kehudaima =kehuxinxi.kehudaima  group by butiefanli.kehudaima,kehumingcheng,yongyouliang1,yongyouliang2";
        try{
                Connection conn = MyLog.getConn();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                
                ResultSet rs =pstmt.executeQuery();
                while(rs.next()){
                    String jieshu = "";
                    if(rs.getFloat(4)==999999999){
                        jieshu = "max";
                    }else{
                        jieshu = String.valueOf(rs.getFloat(4));
                    }
                    list.add(new Fanlikehu(rs.getString(1),rs.getString(2),String.valueOf(rs.getFloat(3)),jieshu));
                }
                rs.close();
                pstmt.close();
                MyLog.close(conn);
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
   
    public ArrayList<Fanlikehu> getFanlikehubililist(String kehu,String shouruqishi,String shourujieshu){
        ArrayList<Fanlikehu> list = new ArrayList();
        String sql = "select butiefanli.*,kehuxinxi.kehumingcheng from butiefanli left join kehuxinxi on butiefanli.kehudaima =kehuxinxi.kehudaima where butiefanli.kehudaima = ? and yongyouliang1 = ? and yongyouliang2 = ?  ";
        if("max".equals(shourujieshu)){
            shourujieshu = "999999999";
        }
        try{
                Connection conn = MyLog.getConn();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, kehu);
                 pstmt.setString(2, shouruqishi);
                  pstmt.setString(3, shourujieshu);
                ResultSet rs =pstmt.executeQuery();
                while(rs.next()){
                    String jieshu = "";
                    if(rs.getFloat(6)==999999999){
                        jieshu = "max";
                    }else{
                        jieshu = String.valueOf(rs.getFloat(6));
                    }
                    list.add(new Fanlikehu(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),jieshu,rs.getString(7),rs.getString(9)));
                }
                rs.close();
                pstmt.close();
                MyLog.close(conn);
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
    
    
    public String getBianhao() {
        return bianhao;
    }

    public void setBianhao(String bianhao) {
        this.bianhao = bianhao;
    }

    public String getJiaoyima() {
        return jiaoyima;
    }

    public void setJiaoyima(String jiaoyima) {
        this.jiaoyima = jiaoyima;
    }

    public String getYoujianleixing() {
        return youjianleixing;
    }

    public void setYoujianleixing(String youjianleixing) {
        this.youjianleixing = youjianleixing;
    }

    public String getShouruqishi() {
        return shouruqishi;
    }

    public void setShouruqishi(String shouruqishi) {
        this.shouruqishi = shouruqishi;
    }

    public String getShourujieshu() {
        return shourujieshu;
    }

    public void setShourujieshu(String shourujieshu) {
        this.shourujieshu = shourujieshu;
    }
     public String getBili() {
        return bili;
    }

    public void setBili(String bili) {
        this.bili = bili;
    }
    
  
    
}
