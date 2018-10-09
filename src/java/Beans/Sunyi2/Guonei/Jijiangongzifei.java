/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Beans.Sunyi2.Guonei;

import Beans.Sunyi2.Feiyong;
import Beans.Sunyi2.Mail;
import java.util.HashMap;

/**
 *
 * @author Administrator
 */
public class Jijiangongzifei extends Feiyong{
    double biaozhun = 0.0;
    double feibiaozhun = 0.0;
            
        
    final static HashMap<String,Jijiangongzifei> jijiangongzi = new HashMap<String,Jijiangongzifei>(){
        {
            put("21529903",new Jijiangongzifei(1.95,0.5));
            put("21529902",new Jijiangongzifei(1.95,0.5));
            put("21529904",new Jijiangongzifei(1.95,0.5));
            put("21521303",new Jijiangongzifei(1.95,0.5));
            put("21522303",new Jijiangongzifei(1.23,0.25));
            put("21522602",new Jijiangongzifei(1.95,0.5));
            put("21522502",new Jijiangongzifei(1.95,0.5));
            put("21523402",new Jijiangongzifei(1.95,0.5));
            put("21522803",new Jijiangongzifei(1.95,0.5));
            put("21522806",new Jijiangongzifei(1.95,0.5));
            put("21520004",new Jijiangongzifei(1.95,0.5));
            put("21523602",new Jijiangongzifei(1.95,0.5));
            put("21521703",new Jijiangongzifei(1.95,0.5));
            put("21522302",new Jijiangongzifei(1.95,0.5));
            put("21529901",new Jijiangongzifei(1.95,0.5));
            put("21523102",new Jijiangongzifei(1.95,0.5));
            
        }
    };
    
    public Jijiangongzifei(Mail mail,double biaozhun,double feibiaozhun){
        super(mail);
        setBiaozhun(biaozhun);
        setFeibiaozhun(feibiaozhun);
    }
    public Jijiangongzifei(double biaozhun,double feibiaozhun){
        setBiaozhun(biaozhun);
        setFeibiaozhun(feibiaozhun);
    }

    public Jijiangongzifei(Mail mail) {
        super(mail);
    }
    
    
    public void  setBiaozhun(double             biaozhun){
        this.biaozhun = biaozhun;
    }
    public void setFeibiaozhun(double feibiaozhun){
        this.feibiaozhun = feibiaozhun;
    }
    public double getBiaozhun(){
        return biaozhun;
    }
    public double getFeibiaozhun(){
        return feibiaozhun;
    }
    
    @Override
    public double getFeiyong() {
        double feiyong = 0.0;
        if(jijiangongzi.get(getMail().getJigoudaima()) !=null){
            //Chanpin c = new Chanpin();
            //System.out.println(mail.getChanpinfenlei());
            switch(getMail().getChanpinfenlei2()){
                case "标准":
                case "E标准":    
                    feiyong = jijiangongzi.get(getMail().getJigoudaima()).getBiaozhun();
                    
                    break;
                case "快包":
                    feiyong = jijiangongzi.get(getMail().getJigoudaima()).getFeibiaozhun();
                    break;
                default:
                    feiyong =0.0;
                    break;
            }
        }
        
       return feiyong;
    }
    
}
