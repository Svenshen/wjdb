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
public class Dancefei extends Feiyong{
    public Dancefei(Mail mail){
        super(mail);
    }
    @Override
    public double getFeiyong() {
        return 0.45;
    }
    
}
