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
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class Tongji {
    
    private String jigou;
    private String youjianshu;
    private String shouru;
    public Tongji(String jigou,String youjianshu,String shouru){
        setJigou(jigou);
        setYoujianshu(youjianshu);
        setShouru(shouru);
    }
    public Tongji(){
        
    }
    public void setJigou(String jigou){
        this.jigou = jigou;
    }
    public void setYoujianshu(String youjianshu){
        this.youjianshu = youjianshu;
    }
    public void setShouru(String shouru){
        this.shouru = shouru;
    }
    public String getJigou(){
        return jigou;
    }
    public String getYoujianshu(){
        return youjianshu;
    }
    public String getShouru(){
        return shouru;
    }
    public ArrayList<Tongji> getTongjibydaima(String kshijian,String jshijian,String daima){
        ArrayList<Tongji> al = new ArrayList();
        try{
//                Class.forName(driver).newInstance();
                Connection conn = MyLog.getConn();
                String sql = "select org_sname as name,count(mail_num) as mailcount,sum(actual_total_fee) as fee from WUJIANGMAIL where CLCT_DATE >= ? and CLCT_DATE <= ? and prod_code like ? GROUP by org_sname";
                String sqlt = "select count(mail_num) as mailcount,sum(actual_total_fee) as fee from WUJIANGMAIL where CLCT_DATE >= ? and CLCT_DATE <= ? and prod_code like ?";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                //System.out.println(request.getParameter("kshijian").replace("-", ""));
                pstmt.setString(1, kshijian);
                pstmt.setString(2, jshijian);
                pstmt.setString(3, "%"+daima+"%");
                ResultSet rs =pstmt.executeQuery();

                while(rs.next()){
                    Tongji t = new Tongji(rs.getString("name"),rs.getString("mailcount"),rs.getString("fee"));
                    al.add(t);
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
                pstmt.setString(3, "%"+daima+"%");
                rs = pstmt.executeQuery();
                while(rs.next()){
                    Tongji t = new Tongji("合计",rs.getString("mailcount"),rs.getString("fee"));
                    al.add(t);
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
    public ArrayList<Tongji> getTongjibyjiaoyima(String kshijian,String jshijian,String jiaoyima){
        ArrayList<Tongji> al = new ArrayList();
        try{
//                Class.forName(driver).newInstance();
                Connection conn = MyLog.getConn();
                String sql = "select org_sname as name,count(mail_num) as mailcount,sum(actual_total_fee) as fee from WUJIANGMAIL where CLCT_DATE >= ? and CLCT_DATE <= ? and jiaoyima like ? GROUP by org_sname";
                String sqlt = "select count(mail_num) as mailcount,sum(actual_total_fee) as fee from WUJIANGMAIL where CLCT_DATE >= ? and CLCT_DATE <= ? and jiaoyima like ?";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                //System.out.println(request.getParameter("kshijian").replace("-", ""));
                pstmt.setString(1, kshijian);
                pstmt.setString(2, jshijian);
                pstmt.setString(3, "%"+jiaoyima+"%");
                ResultSet rs =pstmt.executeQuery();

                while(rs.next()){
                    Tongji t = new Tongji(rs.getString("name"),rs.getString("mailcount"),rs.getString("fee"));
                    al.add(t);
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
                pstmt.setString(3, "%"+jiaoyima+"%");
                rs = pstmt.executeQuery();
                while(rs.next()){
                    Tongji t = new Tongji("合计",rs.getString("mailcount"),rs.getString("fee"));
                    al.add(t);
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
    public ArrayList<Tongji> getTongjibydaimashi(String kshijian,String jshijian,String daima){
        ArrayList<Tongji> al = new ArrayList();
        try{
//                Class.forName(driver).newInstance();
                Connection conn = MyLog.getConn();
                String sql = "select shi as name,count(mail_num) as mailcount,sum(actual_total_fee) as fee from WUJIANGMAIL where CLCT_DATE >= ? and CLCT_DATE <= ? and prod_code like ? GROUP by shi";
                String sqlt = "select count(mail_num) as mailcount,sum(actual_total_fee) as fee from WUJIANGMAIL where CLCT_DATE >= ? and CLCT_DATE <= ? and prod_code like ?";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                //System.out.println(request.getParameter("kshijian").replace("-", ""));
                pstmt.setString(1, kshijian);
                pstmt.setString(2, jshijian);
                pstmt.setString(3, "%"+daima+"%");
                ResultSet rs =pstmt.executeQuery();

                while(rs.next()){
                    Tongji t = new Tongji(rs.getString("name"),rs.getString("mailcount"),rs.getString("fee"));
                    al.add(t);
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
                pstmt.setString(3, "%"+daima+"%");
                rs = pstmt.executeQuery();
                while(rs.next()){
                    Tongji t = new Tongji("合计",rs.getString("mailcount"),rs.getString("fee"));
                    al.add(t);
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
    public ArrayList<Tongji> getTongjibyjiaoyimashi(String kshijian,String jshijian,String jiaoyima){
        ArrayList<Tongji> al = new ArrayList();
        try{
//                Class.forName(driver).newInstance();
                Connection conn = MyLog.getConn();
                String sql = "select shi as name,count(mail_num) as mailcount,sum(actual_total_fee) as fee from WUJIANGMAIL where CLCT_DATE >= ? and CLCT_DATE <= ? and jiaoyima like ? GROUP by shi";
                String sqlt = "select count(mail_num) as mailcount,sum(actual_total_fee) as fee from WUJIANGMAIL where CLCT_DATE >= ? and CLCT_DATE <= ? and jiaoyima like ?";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                //System.out.println(request.getParameter("kshijian").replace("-", ""));
                pstmt.setString(1, kshijian);
                pstmt.setString(2, jshijian);
                pstmt.setString(3, "%"+jiaoyima+"%");
                ResultSet rs =pstmt.executeQuery();

                while(rs.next()){
                    Tongji t = new Tongji(rs.getString("name"),rs.getString("mailcount"),rs.getString("fee"));
                    al.add(t);
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
                pstmt.setString(3, "%"+jiaoyima+"%");
                rs = pstmt.executeQuery();
                while(rs.next()){
                    Tongji t = new Tongji("合计",rs.getString("mailcount"),rs.getString("fee"));
                    al.add(t);
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
    public ArrayList<Tongji> getTongji(String kshijian,String jshijian){
        ArrayList<Tongji> al = new ArrayList();
        try{
//                Class.forName(driver).newInstance();
                Connection conn = MyLog.getConn();
                String sql = "select org_sname as name,count(mail_num) as mailcount,sum(actual_total_fee) as fee from WUJIANGMAIL where CLCT_DATE >= ? and CLCT_DATE <= ? GROUP by org_sname";
                String sqlt = "select count(mail_num) as mailcount,sum(actual_total_fee) as fee from WUJIANGMAIL where CLCT_DATE >= ? and CLCT_DATE <= ?";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                //System.out.println(request.getParameter("kshijian").replace("-", ""));
                pstmt.setString(1, kshijian);
                pstmt.setString(2, jshijian);
                ResultSet rs =pstmt.executeQuery();

                while(rs.next()){
                    Tongji t = new Tongji(rs.getString("name"),rs.getString("mailcount"),rs.getString("fee"));
                    al.add(t);
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
                    Tongji t = new Tongji("合计",rs.getString("mailcount"),rs.getString("fee"));
                    al.add(t);
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
