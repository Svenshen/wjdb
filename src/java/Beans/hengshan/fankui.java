/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Beans.hengshan;

import Beans.MyLog;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

/**
 *
 * @author Administrator
 */
public class fankui {
    public String mailno;
    public String leixing;
    public String yuangong;
    public fankui(String mailno,String leixing,String yuangong){
        if(mailno !=null){
            mailno = mailno.trim();
        }
        this.mailno = mailno;
        this.leixing = leixing;
        this.yuangong = yuangong;
    }
    public void update(String zhuangtai){
        try{
                
                Connection conn = MyLog.getConn();
                //and substr(prod_code,3,1) = '1'
                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd"); 
                String date = sdf.format(System.currentTimeMillis());
                
                String sqlu = "update tb_evt_mail_clct set zhuangtai = ?  where mail_num = ?";
                PreparedStatement pstmt = conn.prepareStatement(sqlu);
                pstmt.setString(1, zhuangtai);
                pstmt.setString(2, mailno);
                pstmt.executeUpdate();
                pstmt.close();
                MyLog.close(conn);
                
                
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void  add(){
         try{
                
                Connection conn = MyLog.getConn();
                //and substr(prod_code,3,1) = '1'
                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd"); 
                String date = sdf.format(System.currentTimeMillis());
                String sql = "select * from hengshandengji where mailno = ?";
                String sqli = "insert into hengshandengji values(?,?,?,?) ";
                String sqlu = "update hengshandengji set leixing = ? ,yuangong = ?,shijian = ? where mailno = ?";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                //System.out.println(request.getParameter("kshijian").replace("-", ""));
                pstmt.setString(1, mailno);
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String dateString = formatter.format(System.currentTimeMillis());
                
                ResultSet rs =pstmt.executeQuery();
                if(rs.next()){
                    rs.close();
                    pstmt.close();
                    pstmt =conn.prepareStatement(sqlu);
                    pstmt.setString(1,leixing);
                    pstmt.setString(2,yuangong);
                    pstmt.setString(3, dateString);
                    pstmt.setString(4,mailno);
                    
                    pstmt.executeUpdate();
                    
                    pstmt.close();
                    MyLog.close(conn);
                    //return "邮件号已存在";
                }else{
                    rs.close();
                    pstmt.close();
                    
                    pstmt = conn.prepareStatement(sqli);
                    pstmt.setString(1, mailno);
                    pstmt.setString(2, leixing);
                    pstmt.setString(3, yuangong);
                    pstmt.setString(4, dateString);
                    int rsint = pstmt.executeUpdate();
                    if(rsint == 1){
                        rs.close();
                    pstmt.close();
                    MyLog.close(conn);
                        //return "添加成功";
                    }else{
                        rs.close();
                    pstmt.close();
                    MyLog.close(conn);
                        //return "错误";
                    }
                }
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
}
