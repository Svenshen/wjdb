/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Beans.Sunyi2.Guonei;


import Beans.MyLog;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Administrator
 */
public class Guoneisunyi extends Guonei{
  
    ArrayList<Guonei> arr = new ArrayList<>(); 
    public Guoneisunyi(String kshijian,String jshijian){
        String sql = "select * from guoneisunyibiao where shoujiriqi >= ? and shoujiriqi <= ?";
        try{
                
                Connection conn = MyLog.getConn();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                //System.out.println(request.getParameter("kshijian").replace("-", ""));
                pstmt.setString(1, kshijian);
                pstmt.setString(2, jshijian);
                ResultSet rs =pstmt.executeQuery();
                while(rs.next()){
                    Guonei guonei = new Guonei();
                    guonei.setMailno(rs.getString("youjianhao"));
                    guonei.setJigoudaima(rs.getString("jigoudaima"));
                    guonei.setJigoumingcheng(rs.getString("jigoumingcheng"));
                    guonei.setKehudaima(rs.getString("kehudaima"));
                    guonei.setKehumingcheng(rs.getString("kehumingcheng"));
                    guonei.setYoujianzhongliang(rs.getDouble("youjianzhongliang"));
                    guonei.setXitongzifei(rs.getDouble("xitongzifei"));
                    guonei.setDancefei(rs.getDouble("dancefei"));
                    guonei.setQuneizhuantangfei(rs.getDouble("quneizhuantangfei"));
                    guonei.setBendichulizhongxinfei(rs.getDouble("bendichulizhongxinfei"));
                    guonei.setErganyunfei(rs.getDouble("erganyunfei"));
                    guonei.setShengneichulifei(rs.getDouble("shengneichulifei"));
                    guonei.setShengjijingzhuanfei(rs.getDouble("shengjijingzhuanfei"));
                    guonei.setYiganyunfei(rs.getDouble("yiganyunfei"));
                    guonei.setJinkoushengshengneijingzhuanfei(rs.getDouble("jinkoushengshengneijingzhuanfei"));
                    guonei.setJinkoushengerganfei(rs.getDouble("jinkoushengerganfeiyong"));
                    guonei.setToudifei(rs.getDouble("toudifei"));
                    guonei.setJijiangongzifei(rs.getDouble("jijiangongzifei"));
                    guonei.setQuanmingzhifei(rs.getDouble("quanmingzhilurufei"));
                    arr.add(guonei);
                }
                rs.close();
                pstmt.close();
                MyLog.close(conn);
                
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
  
   
    
    
    public HashMap<String,Guonei> getGuoneisunyigroupbyjigou(){
        Guonei guonei = new Guonei();
        HashMap<String,Guonei> array = new HashMap<>();
        for(Guonei g:arr){
            guonei.setJigoudaima(getJidadidaima());
            array.put(g.getJidadidaima(), g);
            
        }
        return array;
    }
}
