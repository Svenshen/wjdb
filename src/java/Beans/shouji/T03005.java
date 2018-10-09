/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans.shouji;

import Beans.MyLog;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class T03005 {
//    public static final String url = MyLog.url;
//    public static final String user=MyLog.user;
//    public static final String password=MyLog.password;
    public static void main(String[] args) {
        working("20140311","/home/ems/ddata/");
    }
    
    public static void working(File file)    {
        
        //SimpleDateFormat f = new SimpleDateFormat("yyyyMMdd");
        //int date = Integer.valueOf(f.format(System.currentTimeMillis())) -1;
        //final String path =path2+date+"/";
        //File file = new File(path);
        //File files [] = file.listFiles();
        String sqli = "insert into TB_EVT_MAIL_CLCT values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        //String sqlu = "update into TB_EVT_MAIL_CLCT values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        String sqls ="select * from TB_EVT_MAIL_CLCT where MAIL_NUM = ? and CLCT_BUREAU_ORG_CODE = ? and CLCT_DATE = ? and CLCT_TIME = ?";
        String sqld = "delete from TB_EVT_MAIL_CLCT where MAIL_NUM = ? and CLCT_BUREAU_ORG_CODE = ? and CLCT_DATE = ? and CLCT_TIME = ?";
        try{
            //Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
            Connection conn = null;
            PreparedStatement pstmt = null;
            ResultSet rs = null;
          //  for(File ff : files){
            //    if(ff.getName().startsWith("03005")){
                    //System.out.println(ff.getName());
                    BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file),"GBK"));
                    String data = "";
                    conn = MyLog.getConn();
                    conn.setAutoCommit(true);
                    do{
                        try{
                        data = br.readLine();
                        //System.out.println(data);
                        //my = br.readLine();
                        if(data!=null){
                            
                        //System.out.println(my.split("\t")[2]);
                            String datas [] = data.split("\t");
                            if(datas[2].startsWith("2152")){
                            if("I".equals(datas[0]) || "U".equals(datas[0])){
                                
                                pstmt = conn.prepareStatement(sqls);
                                for(int i = 1;i <= 4;i ++){
                                    pstmt.setString(i, datas[i]);
                                }
                                rs = pstmt.executeQuery();
                                if(rs.next()){
                                    rs.close();
                                    pstmt.close();
                                    pstmt = conn.prepareStatement(sqld);
                                    for(int i = 1;i <= 4;i ++){
                                        pstmt.setString(i, datas[i]);
                                    }
                                    pstmt.executeUpdate();
                                    pstmt.close();
                                    pstmt = conn.prepareStatement(sqli);
                                    //try{
                                    for(int i = 1;i <= 82;i ++){
                                        pstmt.setString(i, datas[i]);
                                    }
                                    //}catch(ArrayIndexOutOfBoundsException aiobe){
                                        //Logger.getLogger(MyLog.class.getName()).log(Level.SEVERE, null, aiobe);
                                        //aiobe.printStackTrace();
                                    //}
                                    pstmt.executeUpdate();
                                    pstmt.close();
                                }else{
                                    rs.close();
                                    pstmt.close();
                                    pstmt = conn.prepareStatement(sqli);
                                    for(int i = 1;i <= 82;i ++){
                                        pstmt.setString(i, datas[i]);
                                        //System.out.println(i+","+datas[i]);
                                    }
                                    
                                    pstmt.executeUpdate();
                                    pstmt.close();
                                }
                            }else if("D".equals(datas[0]) ){
                                pstmt = conn.prepareStatement(sqld);
                                for(int i = 1;i <= 4;i++ ){
                                    pstmt.setString(i, datas[i]);
                                }
                                pstmt.executeUpdate();
                                pstmt.close();
                            }
                            }   
                        }
                        }catch(SQLException sqle){
            MyLog.logtooracle("SQLException", sqle);
            Logger.getLogger(MyLog.class.getName()).log(Level.SEVERE, null, sqle);
            sqle.printStackTrace();
             }catch(ArrayIndexOutOfBoundsException aiobe){
                 MyLog.logtooracle("ArrayIndexOutOfBoundsException", aiobe);
                Logger.getLogger(MyLog.class.getName()).log(Level.SEVERE, null, aiobe);
                 aiobe.printStackTrace();
                  }
                    }while(data != null);
                    
                    //String brs[] = 
                    MyLog.close(conn);
                    br.close();
                    //System.out.println(brs[0]);
               // }
            //}
        }
        catch(IllegalAccessException iae){
            MyLog.logtooracle("SQLException", iae);
            Logger.getLogger(MyLog.class.getName()).log(Level.SEVERE, null, iae);
            iae.printStackTrace();
        }
        catch(ClassNotFoundException cnfe){
            MyLog.logtooracle("SQLException", cnfe);
            Logger.getLogger(MyLog.class.getName()).log(Level.SEVERE, null, cnfe);
            cnfe.printStackTrace();
        }
        catch(InstantiationException ie){
            MyLog.logtooracle("SQLException", ie);
            Logger.getLogger(MyLog.class.getName()).log(Level.SEVERE, null, ie);
            ie.printStackTrace();
        }catch(IOException ioe){
            MyLog.logtooracle("SQLException", ioe);
            Logger.getLogger(MyLog.class.getName()).log(Level.SEVERE, null, ioe);
            ioe.printStackTrace();
        } catch(SQLException sqle){
            MyLog.logtooracle("SQLException", sqle);
            Logger.getLogger(MyLog.class.getName()).log(Level.SEVERE, null, sqle);
            sqle.printStackTrace();
        }
        //BufferedReader br = new BufferedReader("C:\data\20140216");
    }
    
    public static void working(String date,String path2)    {
        
        //SimpleDateFormat f = new SimpleDateFormat("yyyyMMdd");
        //int date = Integer.valueOf(f.format(System.currentTimeMillis())) -1;
        final String path =path2+date+"/";
        File file = new File(path);
        File files [] = file.listFiles();
        String sqli = "insert into TB_EVT_MAIL_CLCT values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        //String sqlu = "update into TB_EVT_MAIL_CLCT values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        String sqls ="select * from TB_EVT_MAIL_CLCT where MAIL_NUM = ? and CLCT_BUREAU_ORG_CODE = ? and CLCT_DATE = ? and CLCT_TIME = ?";
        String sqld = "delete from TB_EVT_MAIL_CLCT where MAIL_NUM = ? and CLCT_BUREAU_ORG_CODE = ? and CLCT_DATE = ? and CLCT_TIME = ?";
        try{
            //Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
            Connection conn = null;
            PreparedStatement pstmt = null;
            ResultSet rs = null;
            for(File ff : files){
                if(ff.getName().startsWith("03005")){
                    //System.out.println(ff.getName());
                    BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path+ff.getName()),"GBK"));
                    String data = "";
                    conn = MyLog.getConn();
                    conn.setAutoCommit(true);
                    do{
                        try{
                        data = br.readLine();
                        //System.out.println(data);
                        //my = br.readLine();
                        if(data!=null){
                            
                        //System.out.println(my.split("\t")[2]);
                            String datas [] = data.split("\t");
                            if(datas[2].startsWith("2152")){
                            if("I".equals(datas[0]) || "U".equals(datas[0])){
                                
                                pstmt = conn.prepareStatement(sqls);
                                for(int i = 1;i <= 4;i ++){
                                    pstmt.setString(i, datas[i]);
                                }
                                rs = pstmt.executeQuery();
                                if(rs.next()){
                                    rs.close();
                                    pstmt.close();
                                    pstmt = conn.prepareStatement(sqld);
                                    for(int i = 1;i <= 4;i ++){
                                        pstmt.setString(i, datas[i]);
                                    }
                                    pstmt.executeUpdate();
                                    pstmt.close();
                                    pstmt = conn.prepareStatement(sqli);
                                    for(int i = 1;i <= 82;i ++){
                                        pstmt.setString(i, datas[i]);
                                    }
                                    pstmt.executeUpdate();
                                    pstmt.close();
                                }else{
                                    rs.close();
                                    pstmt.close();
                                    pstmt = conn.prepareStatement(sqli);
                                    for(int i = 1;i <= 82;i ++){
                                        pstmt.setString(i, datas[i]);
                                        //System.out.println(i+","+datas[i]);
                                    }
                                    
                                    pstmt.executeUpdate();
                                    pstmt.close();
                                }
                            }else if("D".equals(datas[0]) ){
                                pstmt = conn.prepareStatement(sqld);
                                for(int i = 1;i <= 4;i++ ){
                                    pstmt.setString(i, datas[i]);
                                }
                                pstmt.executeUpdate();
                                pstmt.close();
                            }
                            
                        }
                        }
                        }catch(SQLException sqle){
            MyLog.logtooracle("SQLException", sqle);
            Logger.getLogger(MyLog.class.getName()).log(Level.SEVERE, null, sqle);
            sqle.printStackTrace();
        }catch(ArrayIndexOutOfBoundsException aiobe){
            MyLog.logtooracle("ArrayIndexOutOfBoundsException", aiobe);
                Logger.getLogger(MyLog.class.getName()).log(Level.SEVERE, null, aiobe);
                 aiobe.printStackTrace();
                  }
                    }while(data != null);
                    
                    //String brs[] = 
                    MyLog.close(conn);
                    br.close();
                    //System.out.println(brs[0]);
                }
            }
        }
        catch(IllegalAccessException iae){
            MyLog.logtooracle("SQLException", iae);
            Logger.getLogger(MyLog.class.getName()).log(Level.SEVERE, null, iae);
            iae.printStackTrace();
        }
        catch(ClassNotFoundException cnfe){
            MyLog.logtooracle("SQLException", cnfe);
            Logger.getLogger(MyLog.class.getName()).log(Level.SEVERE, null, cnfe);
            cnfe.printStackTrace();
        }
        catch(InstantiationException ie){
            MyLog.logtooracle("SQLException", ie);
            Logger.getLogger(MyLog.class.getName()).log(Level.SEVERE, null, ie);
            ie.printStackTrace();
        }catch(IOException ioe){
            MyLog.logtooracle("SQLException", ioe);
            Logger.getLogger(MyLog.class.getName()).log(Level.SEVERE, null, ioe);
            ioe.printStackTrace();
        } catch(SQLException sqle){
            MyLog.logtooracle("SQLException", sqle);
            Logger.getLogger(MyLog.class.getName()).log(Level.SEVERE, null, sqle);
            sqle.printStackTrace();
        }
        //BufferedReader br = new BufferedReader("C:\data\20140216");
    }
}
