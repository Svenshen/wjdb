/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Beans.ftp.GZip;
import Beans.ftp.MyFtpClient;
import Beans.shouji.*;
import Beans.shouji.test;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimerTask;

/**
 *
 * @author Administrator
 */
public class AsyncTask extends TimerTask{
    public static void main2(String[] args) {
        AsyncTask a = new AsyncTask();
        a.run();
        
    }
    public static void temp(){
        new Thread(new Runnable() {

            public void run() {
                for(int i =20140216;i <=20140228;i ++){
                    T03001.working(String.valueOf(i), "/home/ems/ddata/");
                System.out.println("03001-"+i);
                
                }
                for(int i= 20140301;i <= 20140306;i++){
                    T03001.working(String.valueOf(i), "/home/ems/ddata/");
                System.out.println("03001-"+i);
                }
                //T03001.working("20140304", "/home/ems/ddata/");
                //To change body of generated methods, choose Tools | Templates.
            }
        }).start();
        new Thread(new Runnable() {

            public void run() {
                for(int i =20140216;i <=20140228;i ++){
                    T03005.working(String.valueOf(i), "/home/ems/ddata/");
                System.out.println("03005-"+i);
                
                }
                for(int i= 20140301;i <= 20140306;i++){
                    T03005.working(String.valueOf(i), "/home/ems/ddata/");
                System.out.println("03005-"+i);
                }
                //T03001.working("20140304", "/home/ems/ddata/");
                //To change body of generated methods, choose Tools | Templates.
            }
        }).start();
        new Thread(new Runnable() {

            public void run() {
                for(int i =20140216;i <=20140228;i ++){
                    T03006.working(String.valueOf(i), "/home/ems/ddata/");
                System.out.println("03006-"+i);
                
                }
                for(int i= 20140301;i <= 20140306;i++){
                    T03006.working(String.valueOf(i), "/home/ems/ddata/");
                System.out.println("03006-"+i);
                }
                //T03001.working("20140304", "/home/ems/ddata/");
                //To change body of generated methods, choose Tools | Templates.
            }
        }).start();
        new Thread(new Runnable() {

            public void run() {
                for(int i =20140216;i <=20140228;i ++){
                    T03007.working(String.valueOf(i), "/home/ems/ddata/");
                System.out.println("03007-"+i);
                
                }
                for(int i= 20140301;i <= 20140306;i++){
                    T03007.working(String.valueOf(i), "/home/ems/ddata/");
                System.out.println("03007-"+i);
                }
                
                //T03001.working("20140304", "/home/ems/ddata/");
                //To change body of generated methods, choose Tools | Templates.
            }
        }).start();
        new Thread(new Runnable() {

            public void run() {
                for(int i =20140216;i <=20140228;i ++){
                    T03012.working(String.valueOf(i), "/home/ems/ddata/");
                System.out.println("03012-"+i);
                
                }
                for(int i= 20140301;i <= 20140306;i++){
                    T03012.working(String.valueOf(i), "/home/ems/ddata/");
                System.out.println("03012-"+i);
                }
                
                //T03001.working("20140304", "/home/ems/ddata/");
                //To change body of generated methods, choose Tools | Templates.
            }
        }).start();
        new Thread(new Runnable() {

            public void run() {
                for(int i =20140216;i <=20140228;i ++){
                    T04001.working(String.valueOf(i), "/home/ems/ddata/");
                System.out.println("04001-"+i);
                
                }
                for(int i= 20140301;i <= 20140306;i++){
                    T04001.working(String.valueOf(i), "/home/ems/ddata/");
                System.out.println("04001-"+i);
                }
                
                //T03001.working("20140304", "/home/ems/ddata/");
                //To change body of generated methods, choose Tools | Templates.
            }
        }).start();
        
    }
    public static void main(String[] args) {
               
        //Date d = new Date("2014-02-16");
        
        //Calendar cal=Calendar.getInstance();
        //SimpleDateFormat f = new SimpleDateFormat("yyyyMMdd");
        //cal.setTime(null);
        //cal.setTime(d);
        //cal.set(2014, 02, 16);
        //cal.add(Calendar.DATE, -1);
        //int ddate = d20140216d;
        /*
        for(int i = 20140216;i <= 20140228;i++){
            final String date = String.valueOf(i);
        new Thread(new Runnable() {

            public void run() {
                //GZip.unTargzFile("/home/ems/dftp/"+date+".tar.gz", "/home/ems/ddata/"+date);
                //MyFtpClient.main(date,"/home/dems/dftp/"); 
                
//To change body of generated methods, choose Tools | Templates.
            }
        }).start();}*/
        //GZip.unTargzFile("/home/ems/dftp/"+"20140303"+".tar.gz", "/home/ems/ddata/"+"20140303");
        //MyFtpClient.main("20140307","/home/ems/dftp/");
        //GZip.unTargzFile("/home/ems/dftp/"+"20140307"+".tar.gz", "/home/ems/ddata/"+"20140307");
        //MyFtpClient.main("20140308","/home/ems/dftp/");
        //GZip.unTargzFile("/home/ems/dftp/"+"20140308"+".tar.gz", "/home/ems/ddata/"+"20140308");
        //MyFtpClient.main("20140306","/home/ems/dftp/");
        //GZip.unTargzFile("/home/ems/dftp/"+"20140306"+".tar.gz", "/home/ems/ddata/"+"20140306");
//temp();
//AsyncTask a= new AsyncTask();
    //test.main("20140307","/home/ems/ddata/");
        //MyFtpClient.main("20140414","D:\\dftp\\");
        //SimpleDateFormat f = new SimpleDateFormat("yyyyMMdd");
        //int date = Integer.valueOf(f.format(System.currentTimeMillis())) -1;
        //GZip.unTargzFile("D:\\dftp\\"+"20140414"+".tar.gz", "D:\\ddata\\"+"20140414");
        //MyFtpClient.main("20140411","/home/ems/dftp/");
        //SimpleDateFormat f = new SimpleDateFormat("yyyyMMdd");
        //int date = Integer.valueOf(f.format(System.currentTimeMillis())) -1;
        //GZip.unTargzFile("/home/ems/dftp/"+"20140411"+".tar.gz", "/home/ems/ddata/"+"20140323");
    //T03005.working("20140410","D:\\ddata\\");   
    //T03005.working("20140411","D:\\ddata\\"); 
    //T03005.working("20140412","D:\\ddata\\"); 
    //T03005.working("20140413","D:\\ddata\\"); 
    //T03005.working("20140414","D:\\ddata\\"); 
    //T03005.working("20140410","D:\\ddata\\"); 
       new Thread(new Runnable() {

            public void run() {
                //test.main("20140616","D:\\ddata\\");
                //GZip.unTargzFile("D:\\dftp\\"+"20140616"+".tar.gz", "D:\\ddata\\"+"20140616");
                //test.main("20140616","D:\\ddata\\");
                
                 Calendar cal = Calendar.getInstance();
                 //Date d = ;
                 //System.
                 //d.setTime(time);
                 cal.set(2015, 7, 28);
                SimpleDateFormat f = new SimpleDateFormat("yyyyMMdd");
                //cal.setTimeInMillis();
                System.out.println(f.format(cal.getTime()));
                while(!f.format(cal.getTime()).equals("20140721")){
                    System.out.println(f.format(cal.getTime()));
                    //MyFtpClient.main(f.format(cal.getTime()),"D:\\dftp\\");
                    //GZip.unTargzFile("D:\\dftp\\"+f.format(cal.getTime())+".tar.gz", "D:\\ddata\\"+f.format(cal.getTime()));
                test.main(f.format(cal.getTime()),"d:\\ddata\\");
                cal.add(Calendar.DATE, 1);
                
                }
                //MyFtpClient.main("20140527","D:\\dftp\\");
                //GZip.unTargzFile("D:\\dftp\\"+"20140527"+".tar.gz", "D:\\ddata\\"+"20140527");
                //test.main("20140527","D:\\ddata\\");
                //MyFtpClient.main("20140528","D:\\dftp\\");
                //GZip.unTargzFile("D:\\dftp\\"+"20140528"+".tar.gz", "D:\\ddata\\"+"20140528");
                //test.main("20140528","D:\\ddata\\");
                //MyFtpClient.main("20140529","D:\\dftp\\");
                /*GZip.unTargzFile("D:\\dftp\\"+"20140529"+".tar.gz", "D:\\ddata\\"+"20140529");
                test.main("20140529","D:\\ddata\\");
                GZip.unTargzFile("D:\\dftp\\"+"20140530"+".tar.gz", "D:\\ddata\\"+"20140530");
                test.main("20140530","D:\\ddata\\");
                GZip.unTargzFile("D:\\dftp\\"+"20140531"+".tar.gz", "D:\\ddata\\"+"20140531");
                test.main("20140531","D:\\ddata\\");
                 GZip.unTargzFile("D:\\dftp\\"+"20140601"+".tar.gz", "D:\\ddata\\"+"20140601");
                test.main("20140601","D:\\ddata\\");
                 GZip.unTargzFile("D:\\dftp\\"+"20140602"+".tar.gz", "D:\\ddata\\"+"20140602");
                test.main("20140602","D:\\ddata\\");
                GZip.unTargzFile("D:\\dftp\\"+"20140603"+".tar.gz", "D:\\ddata\\"+"20140603");
                test.main("20140603","D:\\ddata\\");
                        */
                //MyFtpClient.main("20140419","D:\\dftp\\");
                //GZip.unTargzFile("D:\\dftp\\"+"20140419"+".tar.gz", "D:\\ddata\\"+"20140419");
                //MyFtpClient.main("20140420","D:\\dftp\\");
                //GZip.unTargzFile("D:\\dftp\\"+"20140420"+".tar.gz", "D:\\ddata\\"+"20140420");
            }
        }).start(); 
        new Thread(new Runnable() {

            public void run() {
                //try{
            //test.main("20140415","D:\\ddata\\");
    
    //test.main("20140417","D:\\ddata\\");
    //test.main("20140418","D:\\ddata\\");
    //test.main("20140419","D:\\ddata\\");
    //test.main("20140420","D:\\ddata\\"); 
    //test.main("20140421","D:\\ddata\\"); 
                //}catch()
            }
        }).start();
    
    //a.run();
    }
    @Override
    public void run() {
        MyLog.logtooracle("AsyncTask", "同步开始");
        Calendar cal=Calendar.getInstance();
        SimpleDateFormat f = new SimpleDateFormat("yyyyMMdd");
        cal.setTimeInMillis(System.currentTimeMillis());
        //cal.setTime(d);
       
        cal.add(Calendar.DATE, -1);
        String date = f.format(cal.getTime());
        MyFtpClient.main(date,"d:\\dftp\\");
        //SimpleDateFormat f = new SimpleDateFormat("yyyyMMdd");
        //int date = Integer.valueOf(f.format(System.currentTimeMillis())) -1;
        GZip.unTargzFile("d:\\dftp\\"+date+".tar.gz", "d:\\ddata\\"+date);
        test.main(date,"d:\\ddata\\");
        MyLog.logtooracle("AsyncTask", "同步结束");
    }
}
