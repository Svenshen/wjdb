/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans.liangshou;

import Beans.MyLog;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class Zhekou {
    
    private String jigou;
    private String jiaoyima;
    private String shishou;
    private String yingshou;
    private String zhekou;
    private String mailcount;
    private int line;
    NumberFormat format = NumberFormat.getPercentInstance();// 获取格式化类实例 

        
    public void setMailcount(String mailcount){
        this.mailcount = mailcount;
    }
    public void setJigou(String jigou){
        this.jigou = jigou;
    }
    public void setJiaoyima(String jiaoyima){
        this.jiaoyima = jiaoyima;
    }
    public void setShishou(String shishou){
        this.shishou = shishou;
    }
    public void setYingshou(String yingshou){
        this.yingshou = yingshou;
    }
    public void setZhekou(String zhekou){
        this.zhekou = zhekou;
    }
    public void setLine(int line){
        this.line = line;
    }
    public String getJigou(){
        return jigou;
    }
    public String getJiaoyima(){
        return jiaoyima;
    }
    public String getShishou(){
        return shishou;
    }
    public String getYingshou(){
        return yingshou;
    }
    public String getZhekou(){
        return zhekou;
    }
    public String getMailcount(){
        return mailcount;
    }
    public int getLine(){
        return line;
    }
    public Zhekou(){
        
    }
    public Zhekou(String jigou,String mailcount,String jiaoyima,String shishou,String yingshou,String zhekou){
        setJigou(jigou);
        setMailcount(mailcount);
        setJiaoyima(jiaoyima);
        setShishou(shishou);
        setYingshou(yingshou);
        setZhekou(zhekou);
    }
        public Zhekou(String jigou,String mailcount,String jiaoyima,String shishou,String yingshou){
        setJigou(jigou);
        setMailcount(mailcount);
        setJiaoyima(jiaoyima);
        setShishou(shishou);
        setYingshou(yingshou);
        //setZhekou(zhekou);
    }
    public ArrayList<Zhekou> getZhekou(String kshijian,String jshijian){
        ArrayList<Zhekou> al = new ArrayList();
        format.setMinimumFractionDigits(2);// 设置小数位 
        try{
//                Class.forName(driver).newInstance();
                Connection conn = MyLog.getConn();
                String sql = "select org_sname as name,JIAOYIMA as jiaoyima,count(mail_num) as mailcount,sum(actual_total_fee) as totalfee,sum(SHOULD_PAY_TOTAL_FEE) as shouldfee from view1 where CLCT_DATE >= ? and CLCT_DATE <= ? GROUP by org_sname,JIAOYIMA order by org_sname";
                String sqlt = "select JIAOYIMA as jiaoyima,count(mail_num) as mailcount,sum(actual_total_fee) as totalfee,sum(SHOULD_PAY_TOTAL_FEE) as shouldfee from view1 where CLCT_DATE >= ? and CLCT_DATE <= ? GROUP by JIAOYIMA";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                //System.out.println(request.getParameter("kshijian").replace("-", ""));
                pstmt.setString(1, kshijian);
                pstmt.setString(2, jshijian);
                ResultSet rs =pstmt.executeQuery();
                
                while(rs.next()){
                    Zhekou z = new Zhekou(rs.getString("name"),rs.getString("mailcount"),rs.getString("jiaoyima"),rs.getString("totalfee"),rs.getString("shouldfee"));
                    if("0".equals(rs.getString("shouldfee"))){
                        z.setZhekou("错误");
                    }else{
                        z.setZhekou(String.valueOf(format.format(rs.getDouble("totalfee")/rs.getDouble("shouldfee"))));
                    }
                    al.add(z);
                    //al.add(t);
                    //out.println("<tr><td>"+rs.getString("name")+"</td>");
                    //out.println("<td>"+rs.getString("mailcount")+"</td>");
                    //out.println("<td>"+rs.getString("fee")+"</td></tr>");
                    //out.println("<tr><td>:</td><td>"+rs.getString(4)+"</td></tr>");
                               }
                rs.close();
                pstmt.close();
                
                pstmt = conn.prepareStatement(sqlt);
                pstmt.setString(1, kshijian);
                pstmt.setString(2, jshijian);
                rs = pstmt.executeQuery();
                while(rs.next()){
                    Zhekou z = new Zhekou("合计",rs.getString("mailcount"),rs.getString("jiaoyima"),rs.getString("totalfee"),rs.getString("shouldfee"));
                    if("0".equals(rs.getString("shouldfee"))){
                        z.setZhekou("错误");
                    }else{
                        z.setZhekou(String.valueOf(format.format(rs.getDouble("totalfee")/rs.getDouble("shouldfee"))));
                    }
                    al.add(z);
                    //out.println("<tr><td>合计</td>");
                    //out.println("<td>"+rs.getString("mailcount")+"</td>");
                    //out.println("<td>"+rs.getString("fee")+"</td></tr>");
                }
                rs.close();
                pstmt.close();
                MyLog.close(conn);
        }catch(SQLException sqle){
            sqle.printStackTrace();
            MyLog.logtooracle(jigou, sqle);
        }catch(ClassNotFoundException cnfe){
            cnfe.printStackTrace();
            MyLog.logtooracle(jigou, cnfe);
        }catch(InstantiationException ie ){
            ie.printStackTrace();
            MyLog.logtooracle(jigou, ie);
        }catch(IllegalAccessException iae){
            iae.printStackTrace();
            MyLog.logtooracle(jigou, iae);
        }
        return al;
    }
}
