/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Beans.Sunyi2;

/**
 *
 * @author Administrator
 */
public abstract class Feiyong {
    Mail mail;
    public Feiyong(Mail mail){
        this.mail = mail;
    }
    public Feiyong(){
        
    }
    public Mail getMail(){
        return mail;
    }
    public abstract double getFeiyong();
}
