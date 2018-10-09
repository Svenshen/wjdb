/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Beans.Sunyi2.Guoji;

import Beans.Sunyi2.Feiyong;
import Beans.Sunyi2.Mail;

/**
 *
 * @author Administrator
 */
public class Yiganfeiyong extends Feiyong{
    public Yiganfeiyong(Mail mail){
        super(mail);
    }
    @Override
    public double getFeiyong() {
        double feiyong = 0.0;
        switch(getMail().getChanpinfenlei2()){
            case "国际中速DHL":
            case "国际中速TNT":
            case "国际中速佐川":
            case "国际中速香港快递":
                double danjia = 1400.0/3000.0*0.7;
                feiyong = danjia*getMail().getYoujianzhongliang();
                break;
            default:
                feiyong = 0.775*70*getMail().getYoujianzhongliang()/1000;
                //feiyong = 0.2*getMail().getYoujianzhongliang();
                break;
        }
        
        return feiyong;
    }
    
}
