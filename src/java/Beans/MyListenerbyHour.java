/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Beans;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
public class MyListenerbyHour implements ServletContextListener{
private Timer timer=null;
SimpleDateFormat ftime = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
    public static void main(String[] args) {
        MyListenerbyHour l = new MyListenerbyHour();
        l.s();
        
    }
    public void s(){
        timer=new Timer();
        try {
            MyLog.logtooracle("MyListenerbyhour", "同步开始");
            SimpleDateFormat f = new SimpleDateFormat("yyyyMMdd");
        //int date = Integer.valueOf(f.format(System.currentTimeMillis())) +1;
            //timer.schedule(new AsyncTask(), ftime.parse(date+" 07:00:00"),86400000);
            timer.scheduleAtFixedRate(new AsyncTaskbyHour(), ftime.parse(f.format(System.currentTimeMillis())+" 00:30:00"), 1000*3600);
           
        } catch (ParseException ex) {
            MyLog.logtooracle("ParseException",ex);
            Logger.getLogger(MyListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
public  void contextInitialized(ServletContextEvent arg0) {
// TODO Auto-generated method stub
        timer=new Timer();
        try {
            MyLog.logtooracle("MyListenerbyhour", "同步开始");
            SimpleDateFormat f = new SimpleDateFormat("yyyyMMdd");
        //int date = Integer.valueOf(f.format(System.currentTimeMillis())) +1;
            //timer.schedule(new AsyncTask(), ftime.parse(date+" 07:00:00"),86400000);
            timer.scheduleAtFixedRate(new AsyncTaskbyHour(), ftime.parse(f.format(System.currentTimeMillis())+" 00:30:00"), 1000*3600);
        } catch (ParseException ex) {
            MyLog.logtooracle("ParseException",ex);
            Logger.getLogger(MyListener.class.getName()).log(Level.SEVERE, null, ex);
        }

}
public void contextDestroyed(ServletContextEvent arg0) {
// TODO Auto-generated method stub
    MyLog.logtooracle("MyListener", "同步结束");
timer.cancel();

}
}
