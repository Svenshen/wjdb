/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Beans.Butie.Xinchou;

/**
 *
 * @author Administrator
 */
public abstract class Xinchoujine {
    
    Mail mail;
    String kehudaima;
    String jiaoyima;
    String jidadi;
    String youjianleixing;
    int shixiaoriqi;
   public Xinchoujine(){
        
    }
//    Butiejine(String kehudaima,String jiaoyima,String jidadi,String youjianleixing,int shixiaoriqi){
//        setKehudaima(kehudaima);
//        setJiaoyima(jiaoyima);
//        setJidadi(jidadi);
//        setYoujianleixing(youjianleixing);
//        
//        setShixiaoriqi(shixiaoriqi);
//    }
   public Xinchoujine(Mail mail){
        this.mail = mail;
    }
    
    public void setKehudaima(String kehudaima){
        this.kehudaima = kehudaima;
    }
    public void setJiaoyima(String jiaoyima){
        this.jiaoyima = jiaoyima;
    }
    public void setJidadi(String jidadi){
        this.jidadi = jidadi;
    }
    public void setYoujianleixing(String youjianleixing){
        this.youjianleixing = youjianleixing;
    }
   
    public void setShixiaoriqi(int shixiaoriqi){
        this.shixiaoriqi = shixiaoriqi;
    }
    public void setButiejine(double butiejine){
        mail.setButiezifei(butiejine);
    }
    public void setShishouzifei(double shishouzifei){
        mail.setShishouzifei(shishouzifei);
    }
    public Mail getMail(){
        return mail;
    }
    public String getKehudaima(){
        return kehudaima;
    }
    public String getJiaoyima(){
        return jiaoyima;
    }
    public String getJidadi(){
        return jidadi;
    }
    public String getYoujianleixing(){
        return youjianleixing;
    }

    public int getShixiaoriqi(){
        return shixiaoriqi;
    }
    public double getButiejine(){
        return mail.getButiezifei();
    }
    public double getShishouzifei(){
        return mail.getShishouzifei();
    }
   public abstract void jisuanbutie();
}
