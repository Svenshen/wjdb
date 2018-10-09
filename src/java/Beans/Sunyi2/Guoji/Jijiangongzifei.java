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
public class Jijiangongzifei extends Feiyong{
    public Jijiangongzifei(Mail mail){
        super(mail);
    }
    @Override
    public double getFeiyong() {
        return 5.0;
    }
    
}
