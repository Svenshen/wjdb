/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Beans.fengfa;

import Beans.MyLog;
import Beans.genzong.yujing;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class Fengfa {
    public HashMap<String,String> kbifduo=new HashMap<String,String>();  
    public HashMap<String,String> fbikduo=new HashMap<String,String>(); 
    
    public void setkbifduo(HashMap kbifduo){
        this.kbifduo = kbifduo;
    }
    public void setfbikduo(HashMap fbikduo){
        this.fbikduo = fbikduo;
    }
    
    public Fengfa getsuzhouduibi1(String shijian){
        Fengfa al = new Fengfa();
        //Date d=new Date();
        
        
        try{
                SimpleDateFormat df=new SimpleDateFormat("yyyyMMdd");   
                Date d =  df.parse(shijian);
                String shijian2 = df.format(new Date(d.getTime() - 1 * 24 * 60 * 60 * 1000));
                //Class.forName(driver).newInstance();
                Connection conn = MyLog.getConn();
                String sqlfengfa = "select a.mail_num,substring(a.label_strip,21,4) from wujiangfengfa a where a.bag_actn_code = '3' and (a.deal_org_code = '21500000' or a.deal_org_code = '21504300' or a.deal_org_code = '21504500') and  (a.seal_org_code= '21500000' or a.seal_org_code= '21504300' or a.seal_org_code= '21504500') and a.dlv_org_code = '21520000' and ((deal_date = ? and deal_time <= '053000') or (deal_date = ? and deal_time >= '130000')) order by label_strip";
                String sqlkaichai = "select a.mail_num,substring(a.label_strip,21,4)  from wujiangfengfa a where a.bag_actn_code = '2' and a.deal_org_code = '21520000' and a.dlv_org_code = '21520000' and  (a.seal_org_code= '21500000' or a.seal_org_code= '21504300' or a.seal_org_code= '21504500') and (deal_date = ? and deal_time >= '060000' and deal_time <= '100000' ) order by label_strip";
                //String sqlfengfa2 = "select a.mail_num,a.label_strip from wujiangfengfa a where a.bag_actn_code = '3' and a.deal_org_code = '21500000' and  a.seal_org_code= '21500000' and a.dlv_org_code = '21520000' and (deal_date = ? or deal_date = ?)";
                String sqlkaichai2 = "select a.mail_num,substring(a.label_strip,21,4)  from wujiangfengfa a where a.bag_actn_code = '2' and a.deal_org_code = '21520000' and a.dlv_org_code = '21520000'and  (a.seal_org_code= '21500000' or a.seal_org_code= '21504300' or a.seal_org_code= '21504500') and (deal_date = ? or deal_date = ?) order by label_strip";
//String sqlbiaozhun ="select * from wujiangmail";
                PreparedStatement pstmt1 = conn.prepareStatement(sqlfengfa);
                pstmt1.setString(1, shijian);
                pstmt1.setString(2, shijian2);
                //pstmt1.setString(2, jshijian);
                
                ResultSet rs1 =pstmt1.executeQuery();
                HashMap<String,String> r1 = new HashMap<String,String>();
                List li = new ArrayList();
                while(rs1.next()){
                    li.add(rs1.getString(1));
                    r1.put(rs1.getString(1), rs1.getString(2));
                }
                String fengfa[] = new String [li.size()];
                System.arraycopy(li.toArray(), 0, fengfa, 0, fengfa.length);
                //String fengfa[] = (String [])li.toArray();
               
                li.clear();
                rs1.close();
                pstmt1.close();
                
               PreparedStatement pstmt2 = conn.prepareStatement(sqlkaichai);
               pstmt2.setString(1, shijian);
               
                ResultSet rs2 =pstmt2.executeQuery();
                HashMap<String,String> r2 = new HashMap<String,String>();
                while(rs2.next()){
                    li.add(rs2.getString(1));
                    r2.put(rs2.getString(1), rs2.getString(2));
                    //System.out.println(rs2.getString(1));
                }
                String kaichai[] = new String[li.size()];
                System.arraycopy(li.toArray(), 0, kaichai, 0, kaichai.length);
                li.clear();
                rs2.close();
                pstmt2.close();
//                
//                PreparedStatement pstmt3 = conn.prepareStatement(sqlkaichai2);
//               pstmt3.setString(1, shijian);
//               pstmt3.setString(2, shijian2);
//                ResultSet rs3 =pstmt3.executeQuery();
//                //HashMap<String,String> r3 = new HashMap<String,String>();
//                while(rs3.next()){
//                    li.add(rs3.getString(1));
//                    //r3.put(rs3.getString(1), rs3.getString(2));
//                    //System.out.println(rs2.getString(1));
//                }
//                String kaichai2[] = new String[li.size()];
//                System.arraycopy(li.toArray(), 0, kaichai2, 0, kaichai2.length);
//                rs3.close();
//                pstmt3.close();
//                
//                
                MyLog.close(conn);
                
                
                List<String> youkaiwufeng = more(fengfa,kaichai);
                HashMap<String,String> youkaiwufengmap = new HashMap<String,String>();
                for(String mail:youkaiwufeng){
                    youkaiwufengmap.put(mail, r2.get(mail));
                }
               
                al.setkbifduo(youkaiwufengmap);
                
                
                
                
                 List<String> youfengwukai = more(kaichai,fengfa);
                HashMap<String,String> youfengwukaimap = new HashMap<String,String>();
                for(String mail:youfengwukai){
                    youfengwukaimap.put(mail, r1.get(mail));
                }
                al.setfbikduo(youfengwukaimap);
        }catch(SQLException sqle){
            sqle.printStackTrace();
            MyLog.logtooracle("getZhekou", sqle);
        }catch(ClassNotFoundException cnfe){
            cnfe.printStackTrace();
            MyLog.logtooracle("getZhekou", cnfe);
        }catch(InstantiationException ie ){
            ie.printStackTrace();
            MyLog.logtooracle("getZhekou", ie);
        }catch(IllegalAccessException iae){
            iae.printStackTrace();
            MyLog.logtooracle("getZhekou", iae);
        } catch (ParseException ex) {
            Logger.getLogger(Fengfa.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return al;
    }
    
    public Fengfa getsuzhouduibi2(String shijian){
        Fengfa al = new Fengfa();
        //Date d=new Date();
        
        
        try{
                SimpleDateFormat df=new SimpleDateFormat("yyyyMMdd");   
                Date d =  df.parse(shijian);
                //String shijian2 = df.format(new Date(d.getTime() - 1 * 24 * 60 * 60 * 1000));
                String shijian2  = shijian;
                //Class.forName(driver).newInstance();
                Connection conn = MyLog.getConn();
                String sqlfengfa = "select a.mail_num,substring(a.label_strip,21,4) from wujiangfengfa a where a.bag_actn_code = '3' and (a.deal_org_code = '21500000' or a.deal_org_code = '21504300' or a.deal_org_code = '21504500')  and  (a.seal_org_code= '21500000' or a.seal_org_code= '21504300' or a.seal_org_code= '21504500') and a.dlv_org_code = '21520000' and ((deal_date = ? and deal_time > '053000') and (deal_date = ? and deal_time < '130000')) order by label_strip";
                String sqlkaichai = "select a.mail_num,substring(a.label_strip,21,4)  from wujiangfengfa a where a.bag_actn_code = '2' and a.deal_org_code = '21520000' and a.dlv_org_code = '21520000' and  (a.seal_org_code= '21500000' or a.seal_org_code= '21504300' or a.seal_org_code= '21504500') and (deal_date = ? and deal_time >= '120000' and deal_time <= '150000' ) order by label_strip";
                //String sqlfengfa2 = "select a.mail_num,a.label_strip from wujiangfengfa a where a.bag_actn_code = '3' and a.deal_org_code = '21500000' and  a.seal_org_code= '21500000' and a.dlv_org_code = '21520000' and (deal_date = ? or deal_date = ?)";
                String sqlkaichai2 = "select a.mail_num,substring(a.label_strip,21,4)  from wujiangfengfa a where a.bag_actn_code = '2' and a.deal_org_code = '21520000' and a.dlv_org_code = '21520000'and  (a.seal_org_code= '21500000' or a.seal_org_code= '21504300' or a.seal_org_code= '21504500') and (deal_date = ? or deal_date = ?) order by label_strip";
//String sqlbiaozhun ="select * from wujiangmail";
                PreparedStatement pstmt1 = conn.prepareStatement(sqlfengfa);
                pstmt1.setString(1, shijian);
                pstmt1.setString(2, shijian2);
                //pstmt1.setString(2, jshijian);
                
                ResultSet rs1 =pstmt1.executeQuery();
                HashMap<String,String> r1 = new HashMap<String,String>();
                List li = new ArrayList();
                while(rs1.next()){
                    li.add(rs1.getString(1));
                    r1.put(rs1.getString(1), rs1.getString(2));
                }
                String fengfa[] = new String [li.size()];
                System.arraycopy(li.toArray(), 0, fengfa, 0, fengfa.length);
                //String fengfa[] = (String [])li.toArray();
               
                li.clear();
                rs1.close();
                pstmt1.close();
                
               PreparedStatement pstmt2 = conn.prepareStatement(sqlkaichai);
               pstmt2.setString(1, shijian);
               
                ResultSet rs2 =pstmt2.executeQuery();
                HashMap<String,String> r2 = new HashMap<String,String>();
                while(rs2.next()){
                    li.add(rs2.getString(1));
                    r2.put(rs2.getString(1), rs2.getString(2));
                    //System.out.println(rs2.getString(1));
                }
                String kaichai[] = new String[li.size()];
                System.arraycopy(li.toArray(), 0, kaichai, 0, kaichai.length);
                li.clear();
                rs2.close();
                pstmt2.close();
                
//                PreparedStatement pstmt3 = conn.prepareStatement(sqlkaichai2);
//               pstmt3.setString(1, shijian);
//               pstmt3.setString(2, shijian2);
//                ResultSet rs3 =pstmt3.executeQuery();
//                //HashMap<String,String> r3 = new HashMap<String,String>();
//                while(rs3.next()){
//                    li.add(rs3.getString(1));
//                    //r3.put(rs3.getString(1), rs3.getString(2));
//                    //System.out.println(rs2.getString(1));
//                }
//                String kaichai2[] = new String[li.size()];
//                System.arraycopy(li.toArray(), 0, kaichai2, 0, kaichai2.length);
//                rs3.close();
//                pstmt3.close();
                
                
                MyLog.close(conn);
                
                
                List<String> youkaiwufeng = more(fengfa,kaichai);
                HashMap<String,String> youkaiwufengmap = new HashMap<String,String>();
                for(String mail:youkaiwufeng){
                    youkaiwufengmap.put(mail, r2.get(mail));
                }
               
                al.setkbifduo(youkaiwufengmap);
                
                
                
                
                 List<String> youfengwukai = more(kaichai,fengfa);
                HashMap<String,String> youfengwukaimap = new HashMap<String,String>();
                for(String mail:youfengwukai){
                    youfengwukaimap.put(mail, r1.get(mail));
                }
                al.setfbikduo(youfengwukaimap);
        }catch(SQLException sqle){
            sqle.printStackTrace();
            MyLog.logtooracle("getZhekou", sqle);
        }catch(ClassNotFoundException cnfe){
            cnfe.printStackTrace();
            MyLog.logtooracle("getZhekou", cnfe);
        }catch(InstantiationException ie ){
            ie.printStackTrace();
            MyLog.logtooracle("getZhekou", ie);
        }catch(IllegalAccessException iae){
            iae.printStackTrace();
            MyLog.logtooracle("getZhekou", iae);
        } catch (ParseException ex) {
            Logger.getLogger(Fengfa.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return al;
    }
    
    
    
    
    
    
    public  List<String> more(String[] b,String[] a){  
        List<String> temp=new ArrayList<String>();  
        int t=0;  
        String tempString="";  
        boolean exist=false;  
        for(int a1=0;a1<a.length;a1++){  
        for(int b1=0;b1<b.length;b1++){  
        if(a[a1].equals(b[b1])){  
        exist=true;  
        break;  
        }else{  
        exist=false;  
        tempString=a[a1];  
        }  
        }  
        if(!exist){  
        temp.add(t, tempString);  
        t++;  
        }  
        }  
        return temp;  
        }  
    
}
