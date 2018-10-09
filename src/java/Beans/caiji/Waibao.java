/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Beans.caiji;

import Beans.MyLog;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

/**
 *
 * @author Administrator
 */
public class Waibao {
    String mailno;
    String yuanyin;
    String yuangong;
 
    public void Setmailno(String mailno){
        this.mailno = mailno;
    }
    public void Setyuanyin(String yuanyin){
        this.yuanyin = yuanyin;
    }
    public void Setyuangong(String yuangong){
        this.yuangong = yuangong;
    }
    
    public String Getmailno(){
        return mailno;
    }
    public String Getyuanyin(){
        return yuanyin;
    }
    public String Getyuangong(){
        return yuangong;
    }
    public Waibao(){
        
    }
    
    
    public Waibao(String mailno,String yuanyin,String yuangong){
        Setmailno(mailno);
       Setyuanyin(yuanyin);
       Setyuangong(yuangong);
    }
    
    
    
    public String add(String mailno,String yuanyin,String yuangong ){
        try{
                
                Connection conn = MyLog.getConn();
                //and substr(prod_code,3,1) = '1'
                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd"); 
                String date = sdf.format(System.currentTimeMillis());
                String sql = "select * from waibao where mailno = ?";
                String sqli = "insert into waibao values(?,?,?,?) ";
                String sql2 = "select shi as name,count(mail_num) as mailcount,sum(actual_total_fee) as totalfee,sum(SHOULD_PAY_TOTAL_FEE) as shouldfee from WUJIANGMAIL where CLCT_DATE >= ? and CLCT_DATE <= ? and substr(prod_code,1,1) = '4'  and substr(prod_code,8,1) = '9' and shi in(select city from biaokuai_city) GROUP by shi ";
                String sqlt2 = "select count(mail_num) as mailcount,sum(actual_total_fee) as totalfee,sum(SHOULD_PAY_TOTAL_FEE) as shouldfee from WUJIANGMAIL where CLCT_DATE >= ? and CLCT_DATE <= ? and substr(prod_code,1,1) = '4' and substr(prod_code,8,1) = '9' and shi in(select city from biaokuai_city) ";
                
                PreparedStatement pstmt = conn.prepareStatement(sql);
                //System.out.println(request.getParameter("kshijian").replace("-", ""));
                pstmt.setString(1, mailno);
                
                ResultSet rs =pstmt.executeQuery();
                if(rs.next()){
                    rs.close();
                    pstmt.close();
                    MyLog.close(conn);
                    return "邮件号已存在";
                }else{
                    rs.close();
                    pstmt.close();
                    
                    pstmt = conn.prepareStatement(sqli);
                    pstmt.setString(1, mailno);
                    pstmt.setString(2, yuanyin);
                    pstmt.setString(3, yuangong);
                    pstmt.setString(4, date);
                    int rsint = pstmt.executeUpdate();
                    if(rsint == 1){
                        rs.close();
                    pstmt.close();
                    MyLog.close(conn);
                        return "添加成功";
                    }else{
                        rs.close();
                    pstmt.close();
                    MyLog.close(conn);
                        return "错误";
                    }
                }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return "未知错误2";
    }
}
