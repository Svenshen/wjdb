/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Beans.Sunyi2.Guonei;

import Beans.Sunyi2.Feiyong;
import Beans.Sunyi2.Mail;

/**
 *
 * @author Administrator
 */
public class Quanmingzhifei extends Feiyong{

    public Quanmingzhifei(Mail mail) {
        super(mail);
    }
    
    @Override
    public double getFeiyong() {
        if(!getMail().getIsremin()){
            if(Integer.valueOf(getMail().getShoujiriqi()) <= 20180531){
                return 0.1165+0.037;
            }
            return 0.149+0.0368;
            
        }
        return 0.0;
    }
   
}
