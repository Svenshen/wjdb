/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Beans.hengshan;

import Beans.MyLog;
import Beans.liangshou.Jingkuai;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class chaxun {
    String mail;
    String shoujiriqi;
    String jidasheng;
    String jidashi;
    String zuihouzhuangtai;
    String yichangyuanyin;
    public String getMail(){
        return mail;
    }
    public String getShoujiriqi(){
        return shoujiriqi;
    }
    public String getJidasheng(){
        return jidasheng;
    }
    public String getJidashi(){
        return jidashi;
    }
    public String getZuizhongzhuangtai(){
        return zuihouzhuangtai;
    }
    public String getYichangyuanyin(){
        return yichangyuanyin;
    }
    public void setYichangyuanyin(String yichang){
        switch (yichang){
            case "1":
                this.yichangyuanyin = "运输超36小时";
                break;
            case "2":
                this.yichangyuanyin = "投递超20小时";
                break;
            case "3":
                this.yichangyuanyin = yichang;
                break;
            default:
                 this.yichangyuanyin = yichang;
                break;
        }
        
        
    }
    public ArrayList<chaxun> getShuju(){
        ArrayList<chaxun> al = new ArrayList();
        //format.setMinimumFractionDigits(2);// 设置小数位 
        try{
//                Class.forName(driver).newInstance();
                Connection conn = MyLog.getConn();
                String sql = "select * from wujiangmail left join mailzuihouzhuangtai on wujiangmail.mail_num = mailzuihouzhuangtai.mailno  where (zhuangtai <= '4') and clct_date >= '20180129' and (jiaoyima = '410' or jiaoyima = '417') and CLCT_BUREAU_ORG_CODE= '21522303' and sheng not like '%江苏%'";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                //System.out.println(request.getParameter("kshijian").replace("-", ""));
                
                ResultSet rs =pstmt.executeQuery();
                
                while(rs.next()){
//                    chaxun z = new chaxun();
//                    z.setMail(rs.getString(1));
                        //z.setYouhang("错误");
                    
                        //z.setYouhang(String.valueOf(format.format(rs.getDouble("totalfee")/rs.getDouble("shouldfee"))));
                    chaxun c = new chaxun();
                    c.mail = rs.getString("mail_num");
                    c.shoujiriqi = rs.getString("clct_date");
                    c.jidasheng = rs.getString("sheng");
                    c.jidashi = rs.getString("shi");
                    c.setYichangyuanyin(rs.getString("zhuangtai"));
                    c.zuihouzhuangtai = rs.getString("zuihouzhuangtai");
                    al.add(c);
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
            ///MyLog.logtooracle(jigou, ie);
        }catch(IllegalAccessException iae){
            iae.printStackTrace();
            //MyLog.logtooracle(jigou, iae);
        }
        return al;
    }
}
