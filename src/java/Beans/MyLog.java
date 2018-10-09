/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author Administrator
 */
public class MyLog {
     //jdbc:sqlserver://localhost:1433;DatabaseName=你的数据库名
    private static final String url ="jdbc:sqlserver://192.168.10.150:1433;DatabaseName=wjdb";
    //public static final String url ="jdbc:oracle:thin:@localhost:1521:wjdb";
    private static final String user="sa";
    private static final String password="Emswjdb2018";
    private static final String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    public static String logtime;
    public static String logtext;
    private static Connection conn = null;
    public static Connection getConnbyconn() throws ClassNotFoundException, InstantiationException, SQLException, IllegalAccessException{
        
        if(conn == null || conn.isClosed()){
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(MyLog.url, MyLog.user, MyLog.password);
            conn.setAutoCommit(true);
        
        }
        return conn;
    }
    public static Connection getConnbyweb() throws ClassNotFoundException, InstantiationException, SQLException, IllegalAccessException{
        Connection conn = null;
        try{
            conn =getWjdb().getConnection();
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return conn;
    }
    public static Connection getConn() throws ClassNotFoundException, InstantiationException, SQLException, IllegalAccessException{
        //return getConnbyweb();
        return getConnbyconn();
    }
    
    public static void close(Connection conn){
//        try {
//            conn.close();
//            
//        } catch (SQLException ex) {
//            Logger.getLogger(MyLog.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
    public static String getErrotInfoFromException(Exception e){
        String errinfo = "";
        try{
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            errinfo=sw.toString();
        }catch(Exception e2){
            errinfo = "bad geterrorinfofromexception";
        }
        return errinfo;
    }
    public static void logtooracle(String logtitle,String logtext){
        SimpleDateFormat f = new SimpleDateFormat("yyyyMMdd hh:mm:ss");
        
        String sql = "insert into my_log values(to_date(?,'yyyy-mm-dd hh24:mi:ss'),?,?)";
        try {
            Class.forName(driver).newInstance();
            Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, f.format(System.currentTimeMillis()));
            pstmt.setString(2, logtitle);
            pstmt.setString(3, logtext);
            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MyLog.class.getName()).log(Level.SEVERE, null, ex);
        }catch(InstantiationException ie){
            Logger.getLogger(MyLog.class.getName()).log(Level.SEVERE, null, ie);
        }catch(IllegalAccessException iae){
            Logger.getLogger(MyLog.class.getName()).log(Level.SEVERE, null, iae);
        }catch(SQLException sqle){
            Logger.getLogger(MyLog.class.getName()).log(Level.SEVERE, null, sqle);
        }
    }
        public static void logtooracle(String logtitle,Exception e){
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        
        String sql = "insert into my_log values(to_date(?,'yyyy-mm-dd hh24:mi:ss'),?,?)";
        try {
            Class.forName(driver).newInstance();
            Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, f.format(System.currentTimeMillis()));
            pstmt.setString(2, logtitle);
            pstmt.setString(3, getErrotInfoFromException(e));
            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MyLog.class.getName()).log(Level.SEVERE, null, ex);
        }catch(InstantiationException ie){
            Logger.getLogger(MyLog.class.getName()).log(Level.SEVERE, null, ie);
        }catch(IllegalAccessException iae){
            Logger.getLogger(MyLog.class.getName()).log(Level.SEVERE, null, iae);
        }catch(SQLException sqle){
            Logger.getLogger(MyLog.class.getName()).log(Level.SEVERE, null, sqle);
        }
    }

    private static DataSource getWjdb() throws NamingException {
        Context c = new InitialContext();
        return (DataSource) c.lookup("java:comp/env/wjdb");
    }
}
