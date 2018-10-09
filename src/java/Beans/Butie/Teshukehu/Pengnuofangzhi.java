/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Beans.Butie.Teshukehu;

import Beans.Butie.Butiejine;
import Beans.Butie.Mail;

/**
 *
 * @author Administrator
 */

//鹏诺纺织



public class Pengnuofangzhi extends Butiejine{
    public final static String kehudaima = "90000009500161";
    public final static double zhekou = 0.33;
    public final static double buzengjine = 4.0;

    public Pengnuofangzhi(Mail mail) {
        super(mail);
    }

    public static void  jisuanbiaozhunzifeix(Mail mail,double buzengjine){
        
        
        if(!"R".equals(mail.getShujulaiyuan())){
                    mail.setBiaozhunzifei( mail.getBiaozhunzifei() - buzengjine);
                }
       
    }
    
    
    @Override
    public void jisuanbutie() {
         Mail mail = getMail();
         
        double shishou = 0.0,butie =0.0;
        
        switch (mail.getJiaoyima()){
            case "420":
                jisuanbiaozhunzifeix(mail,buzengjine);
                shishou = mail.getXitongzifei()*zhekou+buzengjine;
                butie = mail.getXitongzifei()-shishou;
                break;
            default :
                break;
        }
                
        this.setShishouzifei(shishou);
        this.setButiejine(butie);
    }
}
