/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Beans.Mail;

import Beans.MyLog;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author root
 */
public class MailQuery {
    
    private String mailno;
    private String sender_name;
    private String sender_phone;
    private String sender_addr;
    private String rcver_name;
    private String rcver_phone;
    private String rcver_addr;
    private String fee;
    private String mailjpgurl1;
    private String mailjpgurl2;
    private final String url1 = "http://10.130.112.85:8001/Yjcx/MailQuery.aspx?Type=1&Mail_Num=";
    private final String url2 = "http://10.130.112.85:8001/Yjcx/MailQuery.aspx?Type=2&Mail_Num=";
    public void setMailno(String mailno){
        this.mailno = mailno;
    }
    public void setSender_name(String sender_name){
        this.sender_name = sender_name;
    }
    public void setSender_phone(String sender_phone){
        this.sender_phone = sender_phone;
    }
    public void setSender_addr(String sender_addr){
        this.sender_addr = sender_addr;
    }
    public void setRcver_name(String rcver_name){
        this.rcver_name = rcver_name;
    }
    public void setRcver_phone(String rcver_phone){
        this.rcver_phone = rcver_phone;
    }
    public void setRcver_addr(String rcver_addr){
        this.rcver_addr = rcver_addr;
    }
    public void setFee(String fee){
        this.fee = fee;
    }
    public void setMailjpgurl1(String mailjpgurl1){
        this.mailjpgurl1 = mailjpgurl1;
    }public void setMailjpgurl2(String mailjpgurl1){
        this.mailjpgurl1 = mailjpgurl1;
    }
    
    public String getMailno(){
        return mailno;
    }
    public String getSender_name(){
        return sender_name;
    }
    public String getSender_phone(){
        return sender_phone;
    }
    public String getSender_addr(){
        return sender_addr;
    }
    public String getRcver_name(){
        return rcver_name;
    }
    public String getRcver_phone(){
        return rcver_phone;
    }
    public String getRcver_addr(){
        return rcver_addr;
    }
    public String getFee(){
        return fee;
    }
    public String getMailjpgurl1(){
        return mailjpgurl1;
    }public String getMailjpgurl2(){
        return mailjpgurl1;
    }
    
    
    public void getMailinfo(String mailno){
        try{
            //String sql = "";    
            
            Connection conn = MyLog.getConn();
            String sql = "select sender_name,sender_addr,sender_contact_phone,RCVER_NAME,RCVER_ADDR,RCVER_CONTACT_PHONE,ACTUAL_TOTAL_FEE from TB_EVT_MAIL_CLCT where MAIL_NUM = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, mailno);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                
            }
        }catch(Exception e){
            
        }
    }
    
}
