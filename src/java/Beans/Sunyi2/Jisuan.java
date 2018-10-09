/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Beans.Sunyi2;

import Beans.MyLog;
import Beans.Sunyi2.Guoji.Guoji;
import Beans.Sunyi2.Guonei.Guonei;
import Beans.Sunyi2.Guonei.Luxiang;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Administrator
 */
public class Jisuan {

    
    public static void mainx(String[] args) {
//        String kshijian = "20170301";
//        String jshijian = "20170331";
//        String sql = "select * from wujiangmail where clct_date >= ? and clct_date <= ? and yewulei is null ";
//        try{
//                Class.forName(driver).newInstance();
//                Connection conn = DriverManager.getConnection(MyLog.url, MyLog.user, MyLog.password);
//                PreparedStatement pstmt = conn.prepareStatement(sql);
//                //System.out.println(request.getParameter("kshijian").replace("-", ""));
//                pstmt.setString(1, kshijian);
//                pstmt.setString(2, jshijian);
//                ResultSet rs =pstmt.executeQuery();
//                rs.next();
//                System.out.println(rs.getString("yewulei"));
//                System.out.println(rs.getString("yewulei") == null);
//                System.out.println("null".equals(rs.getString("yewulei")));
//                rs.close();
//                pstmt.close();
//                conn.close();
//        }catch(Exception e){
//            e.printStackTrace();
//        }
    }
    public static void jisuanguoji(String kshijian,String jshijian,String id) {
        
        String sql = "select * from wujiangmail where clct_date >= ? and clct_date <= ? ";
        //String sql = "select * from wujiangmail where mail_num in (SELECT COLUMN1 FROM TEMP )";
        //Chanpin chanpin = new Chanpin();
        String sqli ="UPDATE guojisunyigongzuo SET zhuangtai = '完成' WHERE gongzuoid = ? ";
        Luxiang luxiang = new Luxiang(kshijian,jshijian);
        try{
                
                Connection conn = MyLog.getConn();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                //System.out.println(request.getParameter("kshijian").replace("-", ""));
                pstmt.setString(1, kshijian);
                pstmt.setString(2, jshijian);
                ResultSet rs =pstmt.executeQuery();
                while(rs.next()){
                    //Thread.sleep(40);
                    
                    
                    if(!rs.getString("prod_code").startsWith("5")){
                        
                     }else{
                        System.out.println("国际"+rs.getString("mail_num"));
                        //String mailno, String shoujiriqi, String jigoudaima, String jigoumingcheng, String kehudaima, String kehumingcheng, String chanpin, double youjianzhongliang, double shishoufeiyong, String youjianluxiang, String jidadidaima, String jidasheng, String jidashi
                        Guoji guoji = new Guoji(id,rs.getString("mail_num"),rs.getString("clct_date"),rs.getString("clct_bureau_org_code"),rs.getString("org_sname"),rs.getString("sender_cust_code"),rs.getString("kehumingcheng"),rs.getString("prod_code"),rs.getString("yewulei"),rs.getDouble("billing_weight"),rs.getDouble("actual_total_fee"),rs.getString("rcv_area"),rs.getString("sheng"),rs.getString("shi"));
                        if("国际非邮".equals(guoji.getChanpinfenlei2())||"未知产品".equals(guoji.getChanpinfenlei2())){
                            
                        }else{
                            
                           guoji.jisuan();                             
                        }
                        guoji.update();
                    }
                }
                
                rs.close();
                pstmt.close();
                String sqlup = "update guojisunyibiao  set guojisunyibiao.guojizhongduanfei  = sunyiguojishujudaoru.zhongduanfei ,guojisunyibiao.guojihangkongfei = sunyiguojishujudaoru.hangkongfei from sunyiguojishujudaoru " +
                                "where guojisunyibiao.youjianhao = sunyiguojishujudaoru.youjianhao and sunyiguojishujudaoru.shoujiriqi >= ? and sunyiguojishujudaoru.shoujiriqi <= ? and guojisunyibiao.gongzuoid = ?";
                pstmt = conn.prepareStatement(sqlup);
                pstmt.setString(1, kshijian);
                pstmt.setString(2, jshijian);
                pstmt.setString(3, id);
                pstmt.executeUpdate();
                //System.out.println(pstmt.executeUpdate());
                pstmt.close();
                pstmt = conn.prepareStatement(sqli);
                pstmt.setString(1, id);
                pstmt.executeUpdate();
                pstmt.close();
                
                MyLog.close(conn);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void jisuanguonei(String kshijian,String jshijian,String id) {
        
        
        String sql = "select * from wujiangmail where clct_date >= ? and clct_date <= ? ";
        //String sql = "select * from wujiangmail where mail_num in (SELECT COLUMN1 FROM TEMP )";
        //Chanpin chanpin = new Chanpin();
        String sqli ="UPDATE guoneisunyigongzuo SET zhuangtai = '完成' WHERE gongzuoid = ? ";
        Luxiang luxiang = new Luxiang(kshijian,jshijian);
        try{
                
                Connection conn = MyLog.getConn();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                //System.out.println(request.getParameter("kshijian").replace("-", ""));
                pstmt.setString(1, kshijian);
                pstmt.setString(2, jshijian);
                ResultSet rs =pstmt.executeQuery();
                while(rs.next()){
                    //Thread.sleep(40);
                    
                    
                    if(!rs.getString("prod_code").startsWith("5")){
                        System.out.println("国内"+rs.getString("mail_num"));
                        //String mailno, String shoujiriqi, String jigoudaima, String jigoumingcheng, String kehudaima, String kehumingcheng, String chanpin, double youjianzhongliang, double shishoufeiyong, String youjianluxiang, String jidadidaima, String jidasheng, String jidashi
                        Guonei guonei = new Guonei(id,rs.getString("mail_num"),rs.getString("clct_date"),rs.getString("clct_bureau_org_code"),rs.getString("org_sname"),rs.getString("sender_cust_code"),rs.getString("kehumingcheng"),rs.getString("prod_code"),rs.getString("yewulei"),rs.getDouble("billing_weight"),rs.getDouble("actual_total_fee"),rs.getString("rcv_area"),rs.getString("sheng"),rs.getString("shi"),rs.getString("trans_mode_code"));
                        //Guonei guonei = new Guonei(id,rs.getString("mail_num"),rs.getString("clct_date"),rs.getString("clct_bureau_org_code"),rs.getString("org_sname"),rs.getString("sender_cust_code"),rs.getString("kehumingcheng"),rs.getString("prod_code"),rs.getString("yewulei"),rs.getDouble("billing_weight"),rs.getDouble("actual_total_fee"),rs.getString("rcv_area"),rs.getString("sheng"),rs.getString("shi"),rs.getString("trans_mode_code"));
                        if("国内非邮".equals(guonei.getChanpinfenlei2())||"未知产品".equals(guonei.getChanpinfenlei2())){
                            
                        }
                        else{
                            
                           guonei.jisuan();                             
                        }
                        guonei.update();
                     }else{
                        
                    }
                }
                
                rs.close();
                pstmt.close();
                pstmt = conn.prepareStatement(sqli);
                pstmt.setString(1, id);
                pstmt.executeUpdate();
                pstmt.close();
                
                MyLog.close(conn);
        }catch(Exception e){
            e.printStackTrace();
        }
    
    }
    
    
    public static void jisuanguoneikehu(String kshijian,String jshijian,String id,String kehu) {
        
        
        String sql = "select * from wujiangmail where clct_date >= ? and clct_date <= ? and SENDER_CUST_CODE = ? ";
        //String sql = "select * from wujiangmail where mail_num in (SELECT COLUMN1 FROM TEMP )";
        //Chanpin chanpin = new Chanpin();
        String sqli ="UPDATE guoneisunyigongzuo SET zhuangtai = '完成' WHERE gongzuoid = ? ";
        Luxiang luxiang = new Luxiang(kshijian,jshijian);
        try{
                
                Connection conn = MyLog.getConn();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                //System.out.println(request.getParameter("kshijian").replace("-", ""));
                pstmt.setString(1, kshijian);
                pstmt.setString(2, jshijian);
                pstmt.setString(3, kehu);
                ResultSet rs =pstmt.executeQuery();
                while(rs.next()){
                    //Thread.sleep(40);
                    
                    
                    if(!rs.getString("prod_code").startsWith("5")){
                        System.out.println("国内"+rs.getString("mail_num"));
                        //String mailno, String shoujiriqi, String jigoudaima, String jigoumingcheng, String kehudaima, String kehumingcheng, String chanpin, double youjianzhongliang, double shishoufeiyong, String youjianluxiang, String jidadidaima, String jidasheng, String jidashi
                        Guonei guonei = new Guonei(id,rs.getString("mail_num"),rs.getString("clct_date"),rs.getString("clct_bureau_org_code"),rs.getString("org_sname"),rs.getString("sender_cust_code"),rs.getString("kehumingcheng"),rs.getString("prod_code"),rs.getString("yewulei"),rs.getDouble("billing_weight"),rs.getDouble("actual_total_fee"),rs.getString("rcv_area"),rs.getString("sheng"),rs.getString("shi"),rs.getString("trans_mode_code"));
                        //Guonei guonei = new Guonei(id,rs.getString("mail_num"),rs.getString("clct_date"),rs.getString("clct_bureau_org_code"),rs.getString("org_sname"),rs.getString("sender_cust_code"),rs.getString("kehumingcheng"),rs.getString("prod_code"),rs.getString("yewulei"),rs.getDouble("billing_weight"),rs.getDouble("actual_total_fee"),rs.getString("rcv_area"),rs.getString("sheng"),rs.getString("shi"),"0");
                        if("国内非邮".equals(guonei.getChanpinfenlei2())||"未知产品".equals(guonei.getChanpinfenlei2())){
                            
                        }
                        else{
                            
                           guonei.jisuan();                             
                        }
                        guonei.update();
                     }else{
                        
                    }
                }
                
                rs.close();
                pstmt.close();
                pstmt = conn.prepareStatement(sqli);
                pstmt.setString(1, id);
                pstmt.executeUpdate();
                pstmt.close();
                
                MyLog.close(conn);
        }catch(Exception e){
            e.printStackTrace();
        }
    
    }
    
    public static void jisuanguoneijigou(String kshijian,String jshijian,String id,String jigou) {
        
        
        String sql = "select * from wujiangmail where clct_date >= ? and clct_date <= ? and CLCT_BUREAU_ORG_CODE = ? ";
        //String sql = "select * from wujiangmail where mail_num in (SELECT COLUMN1 FROM TEMP )";
        //Chanpin chanpin = new Chanpin();
        //String sqli ="UPDATE guoneisunyigongzuo SET zhuangtai = '完成' WHERE gongzuoid = ? ";
        Luxiang luxiang = new Luxiang(kshijian,jshijian);
        try{
                
                Connection conn = MyLog.getConn();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                //System.out.println(request.getParameter("kshijian").replace("-", ""));
                pstmt.setString(1, kshijian);
                pstmt.setString(2, jshijian);
                pstmt.setString(3, jigou);
                ResultSet rs =pstmt.executeQuery();
                while(rs.next()){
                    //Thread.sleep(40);
                    
                    
                    if(!rs.getString("prod_code").startsWith("5")){
                        //System.out.println("国内"+rs.getString("mail_num"));
                        //String mailno, String shoujiriqi, String jigoudaima, String jigoumingcheng, String kehudaima, String kehumingcheng, String chanpin, double youjianzhongliang, double shishoufeiyong, String youjianluxiang, String jidadidaima, String jidasheng, String jidashi
                        Guonei guonei = new Guonei(id,rs.getString("mail_num"),rs.getString("clct_date"),rs.getString("clct_bureau_org_code"),rs.getString("org_sname"),rs.getString("sender_cust_code"),rs.getString("kehumingcheng"),rs.getString("prod_code"),rs.getString("yewulei"),rs.getDouble("billing_weight"),rs.getDouble("actual_total_fee"),rs.getString("rcv_area"),rs.getString("sheng"),rs.getString("shi"),rs.getString("trans_mode_code"));
                        //Guonei guonei = new Guonei(id,rs.getString("mail_num"),rs.getString("clct_date"),rs.getString("clct_bureau_org_code"),rs.getString("org_sname"),rs.getString("sender_cust_code"),rs.getString("kehumingcheng"),rs.getString("prod_code"),rs.getString("yewulei"),rs.getDouble("billing_weight"),rs.getDouble("actual_total_fee"),rs.getString("rcv_area"),rs.getString("sheng"),rs.getString("shi"),"0");
                        if("国内非邮".equals(guonei.getChanpinfenlei2())||"未知产品".equals(guonei.getChanpinfenlei2())){
                            
                        }
                        else{
                            
                           guonei.jisuan();                             
                        }
                        guonei.update();
                     }else{
                        
                    }
                }
                
                rs.close();
                pstmt.close();
                
                
                MyLog.close(conn);
        }catch(Exception e){
            e.printStackTrace();
        }
    
    }
    public static void main(String[] args) {
        
        String kshijian = "20180201";
        String jshijian = "20180228";
        //String sql = "select * from wujiangmail where clct_date >= ? and clct_date <= ? and CLCT_BUREAU_ORG_CODE= '21522303'";
        String sql = "select * from wujiangmail where mail_num in ('1115884879552')";
        //Chanpin chanpin = new Chanpin();
        String id = "299999";
        Luxiang luxiang = new Luxiang(kshijian,jshijian);
        try{
                
                Connection conn = MyLog.getConn();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                //System.out.println(request.getParameter("kshijian").replace("-", ""));
                //pstmt.setString(1, kshijian);
                //pstmt.setString(2, jshijian);
                ResultSet rs =pstmt.executeQuery();
                while(rs.next()){
                    //Thread.sleep(40);
                    
                    
                    if(!rs.getString("prod_code").startsWith("5")){
                        System.out.println("国内"+rs.getString("mail_num"));
                        //String mailno, String shoujiriqi, String jigoudaima, String jigoumingcheng, String kehudaima, String kehumingcheng, String chanpin, double youjianzhongliang, double shishoufeiyong, String youjianluxiang, String jidadidaima, String jidasheng, String jidashi
                        //Guonei guonei = new Guonei(id,rs.getString("mail_num"),rs.getString("clct_date"),rs.getString("clct_bureau_org_code"),rs.getString("org_sname"),rs.getString("sender_cust_code"),rs.getString("kehumingcheng"),rs.getString("prod_code"),rs.getString("yewulei"),rs.getDouble("billing_weight"),rs.getDouble("actual_total_fee"),rs.getString("rcv_area"),rs.getString("sheng"),rs.getString("shi"),rs.getString("trans_mode_code"));
                        Guonei guonei = new Guonei(id,rs.getString("mail_num"),rs.getString("clct_date"),rs.getString("clct_bureau_org_code"),rs.getString("org_sname"),rs.getString("sender_cust_code"),rs.getString("kehumingcheng"),rs.getString("prod_code"),rs.getString("yewulei"),rs.getDouble("billing_weight"),rs.getDouble("actual_total_fee"),rs.getString("rcv_area"),rs.getString("sheng"),rs.getString("shi"),rs.getString("trans_mode_code"));
                        if("国内非邮".equals(guonei.getChanpinfenlei2())||"未知产品".equals(guonei.getChanpinfenlei2())){
                            
                        }
                        else{
                            
                           guonei.jisuan();                             
                        }
                        guonei.update();
                     }else{
                        System.out.println("国际"+rs.getString("mail_num"));
                        //String mailno, String shoujiriqi, String jigoudaima, String jigoumingcheng, String kehudaima, String kehumingcheng, String chanpin, double youjianzhongliang, double shishoufeiyong, String youjianluxiang, String jidadidaima, String jidasheng, String jidashi
                        /*Guoji guoji = new Guoji(id,rs.getString("mail_num"),rs.getString("clct_date"),rs.getString("clct_bureau_org_code"),rs.getString("org_sname"),rs.getString("sender_cust_code"),rs.getString("kehumingcheng"),rs.getString("prod_code"),rs.getString("yewulei"),rs.getDouble("billing_weight"),rs.getDouble("actual_total_fee"),rs.getString("rcv_area"),rs.getString("sheng"),rs.getString("shi"));
                        if("国际非邮".equals(guoji.getChanpinfenlei2())||"未知产品".equals(guoji.getChanpinfenlei2())){
                            
                        }else{
                            
                           guoji.jisuan();                             
                        }
                        guoji.update();*/
                    }
                }
                
                rs.close();
                pstmt.close();
                String sqlup = "update guojisunyibiao  set guojisunyibiao.guojizhongduanfei  = sunyiguojishujudaoru.zhongduanfei ,guojisunyibiao.guojihangkongfei = sunyiguojishujudaoru.hangkongfei from sunyiguojishujudaoru " +
                                "where guojisunyibiao.youjianhao = sunyiguojishujudaoru.youjianhao and sunyiguojishujudaoru.shoujiriqi >= ? and sunyiguojishujudaoru.shoujiriqi <= ?";
                pstmt = conn.prepareStatement(sqlup);
                pstmt.setString(1, kshijian);
                pstmt.setString(2, jshijian);
                System.out.println(pstmt.executeUpdate());
                pstmt.close();
                MyLog.close(conn);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void jisuanguojikehu(String kshijian, String jshijian, String id, String kehu) {
        String sql = "select * from wujiangmail where clct_date >= ? and clct_date <= ? and SENDER_CUST_CODE = ?";
        //String sql = "select * from wujiangmail where mail_num in (SELECT COLUMN1 FROM TEMP )";
        //Chanpin chanpin = new Chanpin();
        String sqli ="UPDATE guojisunyigongzuo SET zhuangtai = '完成' WHERE gongzuoid = ? ";
        Luxiang luxiang = new Luxiang(kshijian,jshijian);
        try{
                
                Connection conn = MyLog.getConn();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                //System.out.println(request.getParameter("kshijian").replace("-", ""));
                pstmt.setString(1, kshijian);
                pstmt.setString(2, jshijian);
                pstmt.setString(3, kehu);
                ResultSet rs =pstmt.executeQuery();
                while(rs.next()){
                    //Thread.sleep(40);
                    
                    
                    if(!rs.getString("prod_code").startsWith("5")){
                        
                     }else{
                        System.out.println("国际"+rs.getString("mail_num"));
                        //String mailno, String shoujiriqi, String jigoudaima, String jigoumingcheng, String kehudaima, String kehumingcheng, String chanpin, double youjianzhongliang, double shishoufeiyong, String youjianluxiang, String jidadidaima, String jidasheng, String jidashi
                        Guoji guoji = new Guoji(id,rs.getString("mail_num"),rs.getString("clct_date"),rs.getString("clct_bureau_org_code"),rs.getString("org_sname"),rs.getString("sender_cust_code"),rs.getString("kehumingcheng"),rs.getString("prod_code"),rs.getString("yewulei"),rs.getDouble("billing_weight"),rs.getDouble("actual_total_fee"),rs.getString("rcv_area"),rs.getString("sheng"),rs.getString("shi"));
                        if("国际非邮".equals(guoji.getChanpinfenlei2())||"未知产品".equals(guoji.getChanpinfenlei2())){
                            
                        }else{
                            
                           guoji.jisuan();                             
                        }
                        guoji.update();
                    }
                }
                
                rs.close();
                pstmt.close();
                String sqlup = "update guojisunyibiao  set guojisunyibiao.guojizhongduanfei  = sunyiguojishujudaoru.zhongduanfei ,guojisunyibiao.guojihangkongfei = sunyiguojishujudaoru.hangkongfei from sunyiguojishujudaoru " +
                                "where guojisunyibiao.youjianhao = sunyiguojishujudaoru.youjianhao and sunyiguojishujudaoru.shoujiriqi >= ? and sunyiguojishujudaoru.shoujiriqi <= ?";
                pstmt = conn.prepareStatement(sqlup);
                pstmt.setString(1, kshijian);
                pstmt.setString(2, jshijian);
                //System.out.println(pstmt.executeUpdate());
                pstmt.close();
                pstmt = conn.prepareStatement(sqli);
                pstmt.setString(1, id);
                pstmt.executeUpdate();
                pstmt.close();
                
                MyLog.close(conn);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
