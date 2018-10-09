/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Beans.Butie.Teshukehu;

import Beans.Butie.Butiejine;
import Beans.Butie.Mail;
import static Beans.Butie.Teshukehu.Pengnuofangzhi.jisuanbiaozhunzifeix;

/**
 *
 * @author Administrator
 */

//德里卡西



public class Delikaxi extends Butiejine{
    public final static String kehudaima = "90000009500161";
    public final static double zhekou = 0.85;
    public final static double buzengjine = 0;

    public Delikaxi(Mail mail) {
        super(mail);
    }

    
    
    @Override
    public void jisuanbutie() {
         Mail mail = getMail();
        double shishou = 0.0,butie =0.0;
        switch (mail.getJiaoyima()){
            case "481":
                jisuanbiaozhunzifeix(mail,buzengjine);
                shishou = mail.getBiaozhunzifei()*zhekou+buzengjine;
                butie = mail.getXitongzifei()-shishou;
                break;
            default :
                break;
        }
                
        this.setShishouzifei(shishou);
        this.setButiejine(butie);
    }
}
