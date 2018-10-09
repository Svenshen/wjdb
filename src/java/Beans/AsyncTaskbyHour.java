/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import Beans.ftp.GZip;
import Beans.ftp.MyFtpClient;
import Beans.shouji.*;
import Beans.shouji.test;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimerTask;

/**
 *
 * @author Administrator
 */
public class AsyncTaskbyHour extends TimerTask{
    public static void main(String[] args) {
        AsyncTaskbyHour a = new AsyncTaskbyHour();
        a.run();
    }
    
    @Override
    public void run() {
        MyLog.logtooracle("AsyncTask", "同步开始");
        Calendar cal=Calendar.getInstance();
        SimpleDateFormat f = new SimpleDateFormat("yyyyMMddHH");
        cal.setTimeInMillis(this.scheduledExecutionTime());
        //cal.setTime(d);
        System.out.println(this.scheduledExecutionTime());
        //cal.add(Calendar.DATE, -1);
        String date = f.format(cal.getTime());
        if(date.endsWith("00")){
            cal.add(Calendar.DATE, -1);
            String date2 = f.format(cal.getTime());
            //if(MyFtpClient.getdatabyhour(date2.substring(0, 8),date2.substring(0, 8)+".dat","d:\\ddata\\")){
                test.mainbyhour(date2.substring(0, 8),"d:\\ddata\\",date2.substring(0, 8)+".dat");
            //}
            MyLog.logtooracle("AsyncTask", "同步结束"+date2.substring(0, 8));
        }
        //if(MyFtpClient.getdatabyhour(date.substring(0, 8),date+".dat","d:\\ddata\\")){
        //date.su
        //SimpleDateFormat f = new SimpleDateFormat("yyyyMMdd");
        //int date = Integer.valueOf(f.format(System.currentTimeMillis())) -1;
        //GZip.unTargzFile("d:\\dftp\\"+date+".tar.gz", "d:\\ddata\\"+date);
            test.mainbyhour(date.substring(0, 8),"d:\\ddata\\",date+".dat");
        //}
        MyLog.logtooracle("AsyncTask", "同步结束"+date);
    }
}
