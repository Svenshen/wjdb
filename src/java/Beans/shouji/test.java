/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans.shouji;

import Beans.ftp.MyFtpClient;
import java.io.File;
import java.util.Date;

/**
 *
 * @author Administrator
 */
public class test {
    public static void mainbyhour(String date,String path,String filename) {
         //path d:\ddata\
         //data.(0,8) or data 
         // filename 
         if(MyFtpClient.getdatabyhour(date,filename,"03001",path)){
             T03001.working(new File(path+date+"\\03001_32_"+filename));
             System.out.println(path+"03001_32_"+filename);
         }
         if(MyFtpClient.getdatabyhour(date,filename,"03005",path)){
             T03005.working(new File(path+date+"\\03005_32_"+filename));
             System.out.println(path+"03005_32_"+filename);
         }
         if(MyFtpClient.getdatabyhour(date,filename,"03006",path)){
             T03006.working(new File(path+date+"\\03006_32_"+filename));
             System.out.println(path+"03006_32_"+filename);
         }
         if(MyFtpClient.getdatabyhour(date,filename,"03007",path)){
             T03007.working(new File(path+date+"\\03007_32_"+filename));
             System.out.println(path+"03007_32_"+filename);
         }
         if(MyFtpClient.getdatabyhour(date,filename,"03012",path)){
             T03012.working(new File(path+date+"\\03012_32_"+filename));
             System.out.println(path+"03012_32_"+filename);
         }
         if(MyFtpClient.getdatabyhour(date,filename,"04001",path)){
             T04001.working(new File(path+date+"\\04001_32_"+filename));
             System.out.println(path+"04001_32_"+filename);
         }
         
        //T03001.working(new File(path+"03001_32_"+date+".dat"));
        /*
        T03005.working(new File(path+"03005_32_"+date+".dat"));
        System.out.println(path+"03005_32_"+date+".dat");
        T03006.working(new File(path+"03006_32_"+date+".dat"));
        System.out.println(path+"03006_32_"+date+".dat");
        T03007.working(new File(path+"03007_32_"+date+".dat"));
        System.out.println(path+"03007_32_"+date+".dat");
        T03012.working(new File(path+"03012_32_"+date+".dat"));
        System.out.println(path+"03012_32_"+date+".dat");
        T04001.working(new File(path+"04001_32_"+date+".dat"));   
        System.out.println(path+"04001_32_"+date+".dat");
                */
    }
     public static void mainbyhour2(String date,String path,String filename) {
         //path d:\ddata\
         //data.(0,8) or data 
         // filename 
         if(MyFtpClient.getdatabyhour(date,filename,"03001",path)){
             T03001.working(new File(path+date+"\\03001_32_"+filename));
             System.out.println(path+"03001_32_"+filename);
         }
         if(MyFtpClient.getdatabyhour(date,filename,"03005",path)){
             T03005.working(new File(path+date+"\\03005_32_"+filename));
             System.out.println(path+"03005_32_"+filename);
         }
         if(MyFtpClient.getdatabyhour(date,filename,"03006",path)){
             T03006.working(new File(path+date+"\\03006_32_"+filename));
             System.out.println(path+"03006_32_"+filename);
         }
         if(MyFtpClient.getdatabyhour(date,filename,"03007",path)){
             T03007.working(new File(path+date+"\\03007_32_"+filename));
             System.out.println(path+"03007_32_"+filename);
         }
         if(MyFtpClient.getdatabyhour(date,filename,"03012",path)){
             T03012.working(new File(path+date+"\\03012_32_"+filename));
             System.out.println(path+"03012_32_"+filename);
         }
         if(MyFtpClient.getdatabyhour(date,filename,"04001",path)){
             T04001.working(new File(path+date+"\\04001_32_"+filename));
             System.out.println(path+"04001_32_"+filename);
         }
         
        //T03001.working(new File(path+"03001_32_"+date+".dat"));
        /*
        T03005.working(new File(path+"03005_32_"+date+".dat"));
        System.out.println(path+"03005_32_"+date+".dat");
        T03006.working(new File(path+"03006_32_"+date+".dat"));
        System.out.println(path+"03006_32_"+date+".dat");
        T03007.working(new File(path+"03007_32_"+date+".dat"));
        System.out.println(path+"03007_32_"+date+".dat");
        T03012.working(new File(path+"03012_32_"+date+".dat"));
        System.out.println(path+"03012_32_"+date+".dat");
        T04001.working(new File(path+"04001_32_"+date+".dat"));   
        System.out.println(path+"04001_32_"+date+".dat");
                */
    }
    public static void main(String date,String path) {
        T03001.working(date,path);
        System.out.println("01ok");
        
        T03005.working(date,path);
        System.out.println("05ok");
        T03006.working(date,path);
        System.out.println("06ok");
        T03007.working(date,path);
        System.out.println("07ok");
        T03012.working(date,path);
        System.out.println("12ok");
        T04001.working(date,path);   
        System.out.println("401ok");
    }
}
