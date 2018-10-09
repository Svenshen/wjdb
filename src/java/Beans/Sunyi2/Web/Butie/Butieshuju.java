/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Beans.Sunyi2.Web.Butie;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author Administrator
 */
public class Butieshuju {
    public String youjianhao;
    public String shoujiriqi;
    public String jigoudaima;
    public String chanpindaima;
    public String jigoumingcheng;
    public String kehudaima;
    public String kehumingcheng;
    public String jiaoyima;
    public String jidasheng;
    public String jidashi;
    public String jidadidaima;
    public String youjianzhongliang;
    public String biaozhunzifei;
    public String xitongzifei;
    public String shishouzifei;
    public String butiejine;
    public String butieleixing;
    public String jianshu;

    @Override
    public String toString() {
        return  youjianhao + "," + shoujiriqi + "," + jigoudaima + "," + jigoumingcheng + ","+ kehudaima + "," + kehumingcheng + "," + jiaoyima + "," + jidasheng + "," + jidashi + "," + jidadidaima + "," + youjianzhongliang + "," + biaozhunzifei + "," + xitongzifei + "," + shishouzifei + "," + butiejine + "\r\n";
    }
    
    
    public Butieshuju(String youjianhao,String shoujiriqi,String jigoudaima,String chanpindaima,String jigoumingcheng,String kehudaima,String kehumingcheng,String jiaoyima,String jidasheng,String jidashi,String jidadidaima,String youjianzhongliang,String biaozhunzifei,String xitongzifei,String shishouzifei,String butiejine){
        this.youjianhao =youjianhao;
        this.shoujiriqi=shoujiriqi;
        this.jigoudaima=jigoudaima;
        this.chanpindaima=chanpindaima;
        this.jigoumingcheng=jigoumingcheng;
        this.kehudaima=kehudaima;
        this.kehumingcheng=kehumingcheng;
        this.jiaoyima=jiaoyima;
        this.jidasheng=jidasheng;
        this.jidashi=jidashi;
        this.jidadidaima=jidadidaima;
        this.youjianzhongliang=youjianzhongliang;
        this.biaozhunzifei=biaozhunzifei;
        this.xitongzifei=xitongzifei;
        this.shishouzifei=shishouzifei;
        this.butiejine=butiejine;
    }
    public Butieshuju(String jigoudaima,String jigoumingcheng,String jianshu,String xitongzifei,String shishouzifei,String butiejine){
        
        this.jigoudaima=jigoudaima;
        
        this.jigoumingcheng=jigoumingcheng;
        this.jianshu = jianshu;
        this.xitongzifei=xitongzifei;
        this.shishouzifei=shishouzifei;
        this.butiejine=butiejine;
        
    }
}

