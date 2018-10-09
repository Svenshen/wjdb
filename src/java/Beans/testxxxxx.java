package Beans;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */




import Beans.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
public class testxxxxx implements ServletContextListener{
    public static void main(String[] args) {
        Timer timer=new Timer();
        try {
            MyLog.logtooracle("MyListenerbyhour", "同步开始");
            SimpleDateFormat f = new SimpleDateFormat("yyyyMMdd");
        int date = Integer.valueOf(f.format(System.currentTimeMillis())) +1;
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");  
        Date startDate = dateFormatter.parse("2010/11/28 01:06:00");
            //timer.schedule(new AsyncTask(), ftime.parse(date+" 07:00:00"),86400000);
            timer.scheduleAtFixedRate(new TimerTask(){
                @Override
                public void run() {
                    System.out.println(System.currentTimeMillis()+","+this.scheduledExecutionTime());
                    try {
                        Thread.sleep(5000);
                        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    } catch (InterruptedException ex) {
                        Logger.getLogger(testxxxxx.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }, startDate, 5*1000);
        } catch (Exception ex) {
            MyLog.logtooracle("ParseException",ex);
            Logger.getLogger(MyListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
private Timer timer=null;
SimpleDateFormat ftime = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
public void contextInitialized(ServletContextEvent arg0) {
// TODO Auto-generated method stub
timer=new Timer();
        try {
            MyLog.logtooracle("MyListenerbyhour", "同步开始");
            SimpleDateFormat f = new SimpleDateFormat("yyyyMMdd");
        int date = Integer.valueOf(f.format(System.currentTimeMillis())) +1;
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");  
        Date startDate = dateFormatter.parse("2010/11/28 01:06:00");
            //timer.schedule(new AsyncTask(), ftime.parse(date+" 07:00:00"),86400000);
            timer.scheduleAtFixedRate(new TimerTask(){
                @Override
                public void run() {
                    System.out.println(this.scheduledExecutionTime());
                    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            }, startDate, 5*1000);
        } catch (Exception ex) {
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
