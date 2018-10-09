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

//吴永峰



public class Wuyongfeng extends Butiejine{
    public final static String kehudaima = "80000008621175";

    public Wuyongfeng(Mail mail) {
        super(mail);
    }
    

    @Override
    public void jisuanbutie() {
         Mail mail = getMail();
        double shishou = 0.0,butie =0.0;
        switch (mail.getJiaoyima()){
            case "420":
                jisuanbiaozhunzifeix(mail,4);
                shishou = mail.getBiaozhunzifei()*0.4+4;
                butie = mail.getXitongzifei()-shishou;
                break;
            case "421":
                jisuanbiaozhunzifeix(mail,4);
                shishou = mail.getBiaozhunzifei()*0.4+4;
                butie = mail.getXitongzifei()-shishou;
                break;
          
            default :
                break;
        }
                
        this.setShishouzifei(shishou);
        this.setButiejine(butie);
    }
}
