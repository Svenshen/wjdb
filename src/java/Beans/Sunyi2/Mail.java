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
public abstract class  Mail {
    String mailno;
    String shoujiriqi;
    String jigoudaima;
    String jigoumingcheng;
    String kehudaima;
    String kehumingcheng;
    String chanpin;
    boolean isremin;
    double youjianzhongliang;
    //double shishoufeiyong;
    double xitongzifei;
    boolean iswenjian;
    String youjianluxiang;
    String jidadidaima;
    String jidasheng;
    String jidashi;
    String isguoji;
    String chanpinfenlei;
    int zongbaojianshu = 1;
    public String yunshufangshi = "";
    public Mail(){
        
    }
    public Mail(String mailno,String shoujiriqi,String jigoudaima,String jigoumingcheng,String kehudaima,String kehumingcheng,String chanpin,String chanpinfenlei,double youjianzhongliang,double xitongzifei,String youjianluxiang,String jidadidaima,String jidasheng,String jidashi){
        this.setMailno(mailno);
        this.setShoujiriqi(shoujiriqi);
        this.setJigoudaima(jigoudaima);
        this.setJigoumingcheng(jigoumingcheng);
        this.setKehudaima(kehudaima);
        this.setKehumingcheng(kehumingcheng);
        this.setChanpin(chanpin);
        this.setChanpinfenlei(chanpinfenlei);
        this.setYoujianzhongliang(youjianzhongliang);
        //this.setshishoufeiyong(shishoufeiyong);
        this.setXitongzifei(xitongzifei);
        this.setYoujianluxiang(youjianluxiang);
        this.setJidadidaima(jidadidaima);
        this.setJidasheng(jidasheng);
        this.setJidashi(jidashi);
        
        
    }
    
     public void setMailno(String mailno){
        this.mailno = mailno == null?mailno:mailno.trim();
    }
    public  void setChanpin(String chanpin){
        this.chanpin = chanpin==null?chanpin:chanpin.trim();
    }
    public  void setJidasheng(String jidasheng){
        this.jidasheng = jidasheng==null?"未知":jidasheng.trim();
    }
    public  void setJidashi(String jidashi){
        this.jidashi = jidashi==null?"未知":jidashi.trim();
    }
    public  void setYoujianzhongliang(double zhongliang){
        this.youjianzhongliang = zhongliang;
    }
    public  void setXitongzifei(double xitongzifei){
        this.xitongzifei = xitongzifei;
    }
   public   void setShoujiriqi(String shoujiriqi){
        this.shoujiriqi = shoujiriqi==null?shoujiriqi:shoujiriqi.trim();
    }
   public   void setKehudaima(String kehudaima){
        this.kehudaima = kehudaima==null?kehudaima:kehudaima.trim();
    }
    public  void setKehumingcheng(String kehumingcheng){
        this.kehumingcheng = kehumingcheng==null?kehumingcheng:kehumingcheng.trim();
    }
   public  void setYoujianluxiang(String youjianluxiang){
        this.youjianluxiang = youjianluxiang==null?youjianluxiang:youjianluxiang.trim();
    }
   public   void setJidadidaima(String jidadidaima){
        this.jidadidaima = jidadidaima==null?"未知":jidadidaima.trim();
    }
   public   void setJigoudaima(String jigoudaima){
        this.jigoudaima = jigoudaima==null?jigoudaima:jigoudaima.trim();
    }
    public  void setJigoumingcheng(String jigoumingcheng){
        this.jigoumingcheng = jigoumingcheng==null?jigoumingcheng:jigoumingcheng.trim();
    }
   public   void setIsguoji(String isguoji){
        this.isguoji = isguoji==null?isguoji:isguoji.trim();
    }
   public  void setChanpinfenlei(String chanpinfenlei){
        
         this.chanpinfenlei =  chanpinfenlei==null?"未知产品":chanpinfenlei.trim();
     }
    
    
    public String getShoujiriqi(){
        return shoujiriqi;
    }
    public String getKehudaima(){
        return kehudaima;
    }
    public String getKehumingcheng(){
        return kehumingcheng;
    }
    public String getMialno(){
        return mailno;
    }
    public boolean getIsremin(){
        return mailno.startsWith("11")||mailno.startsWith("97");
    }
    public double getYoujianzhongliang(){
        return youjianzhongliang;
    }
    public double getXitongzifei(){
        return xitongzifei;
    }
    public String getYoujianluxiang(){
        return youjianluxiang;
    }
    public boolean getIswenjian(){
        if(("1".equals(chanpin.substring(1, 2)))||("2".equals(chanpin.substring(1, 2)))){
            return true;
        }else{
            return false;
        }
    }
    public String getJidadidaima(){
        return jidadidaima;
    }
    public String getJidashi(){
        return jidashi;
    }
    public String getJidasheng(){
        return jidasheng;
    }
    public String getJigoudaima(){
        return jigoudaima;
    }
    public String getJigoumingcheng(){
        return jigoumingcheng;
    }
    public String getChanpin(){
        return chanpin;
    }
    public boolean getIsguoji(){
        return "1".equals(isguoji);
    }
    public String getChanpinfenlei2(){
        
        return chanpinfenlei;
    }
    public String getYunshufangshi(){
        return yunshufangshi;
    }
    public void setYunshufangshi(String yunshufangshix){
        if(yunshufangshix == null){
            this.yunshufangshi = "其他";
        }else{
            yunshufangshix = yunshufangshix.trim();
        }
        
        if("3".equals(yunshufangshix) || "0".equals(yunshufangshix)){
            this.yunshufangshi = "陆运";
            
        }else{
            this.yunshufangshi = "其他";
        }
        System.out.println(this.yunshufangshi+"111");
    }
    public abstract void update();
    public abstract void jisuan();
}
