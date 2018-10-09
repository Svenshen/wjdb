/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Beans.liangshou;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//package Beans.liangshou;

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
public class Zhengqi {
    
    private String kehu;
    private String youjianliang;
    private String shouru;
    private String fl1;
    private String fl2;
    private String fl3;
    private String gsm;
    private String kehudaima;
    
    
    
    public void setKehu(String kehu){
        this.kehu = kehu;
    }
    public void setYoujianliang(String youjianliang){
        this.youjianliang = youjianliang;
    }
    public void setShouru(String shouru){
        this.shouru = shouru;
    }
    public void setFl1(String fl1){
        this.fl1 = fl1;
    }
    public void setFl2(String fl2){
        this.fl2 = fl2;
    }
    public void setFl3(String fl3){
        this.fl3 = fl3;
    }
    public void setGsm(String gsm){
        this.gsm = gsm;
    }
    public void setKehudaima(String kehudaima){
        this.kehudaima = kehudaima;
    }


    public String getKehu(){
        return kehu;
    }
    public String getYoujianliang(){
        return youjianliang;
    }
    public String getshouru(){
        return shouru;
    }
    public String getFl1(){
        return fl1;
    }
    public String getFl2(){
        return fl2;
    }
    public String getFl3(){
        return fl3;
    }
    public String getGsm(){
        return gsm;
    }
    public String getKehudaima(){
        return kehudaima;
    }
 
    
    public Zhengqi(){
        
    }
    public Zhengqi(String fl1,String fl2,String fl3,String gsm,String kehu,String kehudaima,String youjianliang,String shouru){
        setKehu(kehu);
        setYoujianliang(youjianliang);
        setShouru(shouru);
        setFl1(fl1);
        setFl2(fl2);
        setFl3(fl3);
        setGsm(gsm);
        setKehudaima(kehudaima);
        
    }
    public ArrayList<Zhengqi> getQuanbu(String kshijian,String jshijian){
        ArrayList<Zhengqi> al = new ArrayList();
        //format.setMinimumFractionDigits(2);// 设置小数位 
        try{
//                Class.forName(driver).newInstance();
                Connection conn = MyLog.getConn();
                String sql = "select b.fl1,b.fl2,b.fl3,b.gsm,b.dakehu,b.kehudaima,count(mail_num) as liang,sum(ACTUAL_TOTAL_FEE) as shou from wujiangmail a right join zhengqi b on a.sender_cust_code = b.kehudaima where clct_date >= ? and clct_date <= ? group by b.fl1,b.fl2,b.fl3,b.gsm,b.dakehu,b.kehudaima" ;
                //String sqlt = "select JIAOYIMA as jiaoyima,count(mail_num) as mailcount,sum(actual_total_fee) as totalfee,sum(SHOULD_PAY_TOTAL_FEE) as shouldfee from WUJIANGMAIL where CLCT_DATE >= ? and CLCT_DATE <= ? and jiaoyima ='482'and shi in(select city from jingkuai_city) GROUP by JIAOYIMA";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                //System.out.println(request.getParameter("kshijian").replace("-", ""));
                pstmt.setString(1, kshijian);
                pstmt.setString(2, jshijian);
                ResultSet rs =pstmt.executeQuery();
                
                while(rs.next()){
                    Zhengqi z = new Zhengqi(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8));
                    
                        //z.setYouhang("错误");
                    
                        //z.setYouhang(String.valueOf(format.format(rs.getDouble("totalfee")/rs.getDouble("shouldfee"))));
                    
                    al.add(z);
                    //al.add(t);
                    //out.println("<tr><td>"+rs.getString("name")+"</td>");
                    //out.println("<td>"+rs.getString("mailcount")+"</td>");
                    //out.println("<td>"+rs.getString("fee")+"</td></tr>");
                    //out.println("<tr><td>:</td><td>"+rs.getString(4)+"</td></tr>");
                               }
                rs.close();
                pstmt.close();
                
                
                MyLog.close(conn);
        }catch(SQLException sqle){
            sqle.printStackTrace();
            //MyLog.logtooracle(jigou, sqle);
        }catch(ClassNotFoundException cnfe){
            cnfe.printStackTrace();
            //MyLog.logtooracle(jigou, cnfe);
        }catch(InstantiationException ie ){
            ie.printStackTrace();
            //MyLog.logtooracle(jigou, ie);
        }catch(IllegalAccessException iae){
            iae.printStackTrace();
            //MyLog.logtooracle(jigou, iae);
        }
        return al;
    }
    public ArrayList<Zhengqi> getBiaokuai(String kshijian,String jshijian){
        ArrayList<Zhengqi> al = new ArrayList();
        //format.setMinimumFractionDigits(2);// 设置小数位 
        try{
//                Class.forName(driver).newInstance();
                Connection conn = MyLog.getConn();
                String sql = "select b.fl1,b.fl2,b.fl3,b.gsm,b.dakehu,b.kehudaima,count(mail_num) as liang,sum(ACTUAL_TOTAL_FEE) as shou from wujiangmail a right join zhengqi b on a.sender_cust_code = b.kehudaima where clct_date >= ? and clct_date <= ? and yewulei = '标准' group by b.fl1,b.fl2,b.fl3,b.gsm,b.dakehu,b.kehudaima" ;
                //String sqlt = "select JIAOYIMA as jiaoyima,count(mail_num) as mailcount,sum(actual_total_fee) as totalfee,sum(SHOULD_PAY_TOTAL_FEE) as shouldfee from WUJIANGMAIL where CLCT_DATE >= ? and CLCT_DATE <= ? and jiaoyima ='482'and shi in(select city from jingkuai_city) GROUP by JIAOYIMA";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                //System.out.println(request.getParameter("kshijian").replace("-", ""));
                pstmt.setString(1, kshijian);
                pstmt.setString(2, jshijian);
                ResultSet rs =pstmt.executeQuery();
                
                while(rs.next()){
                    Zhengqi z = new Zhengqi(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8));
                    
                        //z.setYouhang("错误");
                    
                        //z.setYouhang(String.valueOf(format.format(rs.getDouble("totalfee")/rs.getDouble("shouldfee"))));
                    
                    al.add(z);
                    //al.add(t);
                    //out.println("<tr><td>"+rs.getString("name")+"</td>");
                    //out.println("<td>"+rs.getString("mailcount")+"</td>");
                    //out.println("<td>"+rs.getString("fee")+"</td></tr>");
                    //out.println("<tr><td>:</td><td>"+rs.getString(4)+"</td></tr>");
                               }
                rs.close();
                pstmt.close();
                
                
                MyLog.close(conn);
        }catch(SQLException sqle){
            sqle.printStackTrace();
            //MyLog.logtooracle(jigou, sqle);
        }catch(ClassNotFoundException cnfe){
            cnfe.printStackTrace();
            //MyLog.logtooracle(jigou, cnfe);
        }catch(InstantiationException ie ){
            ie.printStackTrace();
            //MyLog.logtooracle(jigou, ie);
        }catch(IllegalAccessException iae){
            iae.printStackTrace();
            //MyLog.logtooracle(jigou, iae);
        }
        return al;
    }
}
