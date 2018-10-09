/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans.ftp;

import Beans.MyLog;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;


/**
 *
 * @author Administrator
 */
public class MyFtpClient {
    public static boolean getdatabyhour(String date,String filename,String name2,String path){
        boolean flag =false;
        FTPClient ftp = new FTPClient();
        try{
            FileOutputStream fos = null;
            ftp.connect("10.3.10.40");
            ftp.login("jiangsu", "password");
            ftp.setBufferSize(1024);
            ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
            FTPFile files [] = ftp.listFiles(date);
            for(FTPFile file : files){
                //System.out.println(path+date+"\\"+file.getName()+"????");
                if(file.getName().endsWith(filename) && file.getName().startsWith(name2)){
                    File uploadFilePath = new File(path+date+"\\");  
                    if(uploadFilePath.exists() == false) {  
                        uploadFilePath.mkdirs();  
                    }
                    System.out.println(path+date+"\\"+file.getName()+"!!!!!");
                    fos = new FileOutputStream(path+date+"\\"+file.getName());
                    
                    ftp.retrieveFile(date+"/"+file.getName(), fos);
                }
            }
            if(fos!=null){
                flag = true;
            fos.flush();
            fos.close();
            }
            
            ftp.disconnect();
        }catch(IOException ioe){
            MyLog.logtooracle("MyFtpClientbyhour", ioe);
        }   
        return flag;
    }
    public static void main(String date,String path)  {
        //FtpClient ftp = new FtpClient();
        /* Calendar cal=Calendar.getInstance();
        SimpleDateFormat f = new SimpleDateFormat("yyyyMMdd");
        cal.setTimeInMillis(System.currentTimeMillis());
        //cal.setTime(d);
       
        cal.add(Calendar.DATE, -1);
        String date = f.format(cal.getTime());
        */
        boolean flag = false;
        while(!flag){
        FTPClient ftp = new FTPClient();
        
        try{
            FileOutputStream fos = null;
            
            ftp.connect("10.3.10.40");
            ftp.login("jiangsu", "password");
            ftp.setBufferSize(1024);
            ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
            
           
            FTPFile files [] = ftp.listFiles(date);
            //System.out.println();
            for(FTPFile file : files){
                System.out.println(file.getName());
                if(file.getName().endsWith(".ctr")){
                    flag = true;
                }
            }
            if(flag){
                fos = new FileOutputStream(path+date+".tar.gz");
                ftp.retrieveFile(date+"/"+date+".tar.gz", fos);
            }else{
                Thread.sleep(10*60*1000);
            }
           fos.flush();
            fos.close();
            ftp.disconnect();
        }catch(IOException ioe){
            MyLog.logtooracle("MyFtpClient", ioe);
        }   catch (InterruptedException ex) {
                //Logger.getLogger(MyFtpClient.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
            try {
                ftp.disconnect();
            } catch (IOException ex) {
                //Logger.getLogger(FTP.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        }
    }
}
