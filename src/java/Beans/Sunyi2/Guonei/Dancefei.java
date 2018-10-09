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
public class Dancefei extends Feiyong{

    public Dancefei(Mail mail) {
        super(mail);
    }
    
    public double getFeiyong(){
        double feiyong = 0.0;
        if(getMail().getIsremin()){
            feiyong+=0.1;
        }else{
            feiyong+=0.2;
        }
        if(getMail().getIswenjian()){
            feiyong+=0.26;
        }
        return feiyong;
    }
    
}
