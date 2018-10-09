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
public class Jingzhuanjuchulifei extends Feiyong{
    
    public Jingzhuanjuchulifei(Mail mail){
        super(mail);
    }
    @Override
    public double getFeiyong() {
        double feiyong = 0.2;
        switch(this.getMail().getChanpinfenlei2()){
            case "国际中速DHL":
            case "国际中速TNT":
            case "国际中速佐川":
            case "国际中速香港快递":
            
                feiyong = 0.0; 
                break;
            
            default:
                feiyong = 2.0/30;
                break;
        }
        return feiyong;
    }
    
}
