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

//世纪龙/胡泽宝



public class Shijilong extends Butiejine{
    public final static String kehudaima = "32108401344000";

    public Shijilong(Mail mail) {
        super(mail);
    }
    

    @Override
    public void jisuanbutie() {
         Mail mail = getMail();
        double shishou = 0.0,butie =0.0;
        switch (mail.getJiaoyima()){
            case "420":
                jisuanbiaozhunzifeix(mail,4);
                shishou = mail.getBiaozhunzifei()*0.45+4;
                butie = mail.getXitongzifei()-shishou;
                break;
            case "421":
                jisuanbiaozhunzifeix(mail,4);
                shishou = mail.getBiaozhunzifei()*0.45+4;
                butie = mail.getXitongzifei()-shishou;
                break;
          
            default :
                break;
        }
                
        this.setShishouzifei(shishou);
        this.setButiejine(butie);
    }
}
