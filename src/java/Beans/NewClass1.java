/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Beans;

import Beans.index.index;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;

/**
 *
 * @author Administrator
 */
public class NewClass1 {
    public static void main(String[] args) throws Exception {
        DecimalFormat df = new DecimalFormat("00000000");
        String sqlshouji = "select * from wujiangmail where mail_num = ?";
        BufferedReader br = new BufferedReader(new FileReader("f:\\ddd.txt"));
        Connection conn = MyLog.getConn();
        while(true){
            String mailno = br.readLine();
         String tou = mailno.substring(0,2);
                            String wei = mailno.substring(11,13);
                            String shuzi = mailno.substring(2, 10);
                            int shu = Integer.valueOf(shuzi);
                            int yuanshu = shu;
                            //List<Integer> shuzu = new ArrayList<Integer>();
                            for(int i = 0;i <= 12; i ++){
                                
                                String zhongjian = df.format(shu);
                                int yanzheng =11-((Integer.valueOf(zhongjian.substring(0, 1))*8+Integer.valueOf(zhongjian.substring(1, 2))*6+
                                        Integer.valueOf(zhongjian.substring(2, 3))*4+Integer.valueOf(zhongjian.substring(3, 4))*2+
                                        Integer.valueOf(zhongjian.substring(4, 5))*3+Integer.valueOf(zhongjian.substring(5, 6))*5+
                                        Integer.valueOf(zhongjian.substring(6, 7))*9+Integer.valueOf(zhongjian.substring(7, 8))*7)%11);
                                if(yanzheng == 10){
                                    yanzheng = 0;
                                }else if(yanzheng == 11){
                                    yanzheng = 5;
                                }else if(yanzheng < 10){                                
                                }
                                String wanzheng = tou+zhongjian+yanzheng+wei;
                                PreparedStatement pstmt2 = conn.prepareStatement(sqlshouji);
                                pstmt2.setString(1, wanzheng);
                                ResultSet rs2 =pstmt2.executeQuery();
                                //index ii = new  index();
                                //ii.setMailno(wanzheng);
                                if(rs2.next()){
                                    //ii.setOrgsname(rs2.getString("org_sname"));
                                    System.out.println(mailno+","+rs2.getString("org_sname"));
                                    break;
                                }
                                
                                rs2.close();
                                pstmt2.close();
                                shu ++;
                            }
                            
        }
    }
}
