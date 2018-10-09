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
public class Toudifei extends Feiyong{

    double ebiao;
    double kuaibao;
    double qita;
    
    public Toudifei(Mail mail) {
        super(mail);
    }
    private Toudifei(double ebiao,double kuaibao,double qita){
        this.setEbiao(ebiao);
        this.setKuaibao(kuaibao);
        this.setQita(qita);
    }
    
     final static HashMap<String,Toudifei> toudifei = new HashMap<String,Toudifei>(){
        {
            put("安徽省",new Toudifei(1.5,1.5,2.05) );
            put("北京",new Toudifei(2.05,2.05,2.05));
            put("福建省",new Toudifei(2.05,2.05,2.05));
            put("甘肃省",new Toudifei(2.05,2.05,2.05));
            put("广东省",new Toudifei(2.05,2.05,2.05));
            put("广西壮族自治区",new Toudifei(2.05,2.05,2.05));
            put("贵州省",new Toudifei(2.05,2.05,2.05));
            put("海南省",new Toudifei(2.05,2.05,2.05));
            put("河北省",new Toudifei(2.05,2.05,2.05));
            put("河南省",new Toudifei(2.05,2.05,2.05));
            put("黑龙江省",new Toudifei(2.05,2.05,2.05));
            put("湖北省",new Toudifei(2.05,2.05,2.05));
            put("湖南省",new Toudifei(2.05,2.05,2.05));
            put("吉林省",new Toudifei(2.05,2.05,2.05));
            put("江苏省",new Toudifei(1.5,1.5,2.3));
            put("江西省",new Toudifei(2.05,2.05,2.05));
            put("辽宁省",new Toudifei(2.05,2.05,2.05));
            put("内蒙古自治区",new Toudifei(2.05,2.05,2.05));
            put("宁夏回族自治区",new Toudifei(2.05,2.05,2.05));
            put("青海省",new Toudifei(2.05,2.05,2.05));
            put("山东省",new Toudifei(2.05,2.05,2.05));
            put("山西省",new Toudifei(2.05,2.05,2.05));
            put("陕西省",new Toudifei(2.05,2.05,2.05));
            put("上海",new Toudifei(1.5,1.5,2.05));
            put("四川省",new Toudifei(2.05,2.05,2.05));
            put("天津",new Toudifei(2.05,2.05,2.05));
            put("西藏自治区",new Toudifei(2.05,2.05,2.05));
            put("新疆维吾尔自治区",new Toudifei(2.05,2.05,2.05));
            put("云南省",new Toudifei(2.05,2.05,2.05));
            put("浙江省",new Toudifei(1.5,1.5,2.05));
            put("重庆",new Toudifei(2.05,2.05,2.05));
            put("未知",new Toudifei(2.05,2.05,2.05));
        }
    };
     
     private void setEbiao(double ebiao){
         this.ebiao = ebiao;
     }
     private void setKuaibao(double kuaibao){
         this.kuaibao = kuaibao;
         
     }
     private void setQita(double qita){
         this.qita = qita;
     }
     private double getEbiao(){
         return ebiao;
     }
     private double getKuaibao(){
         return kuaibao;
     }
     private double getQita(){
         return qita;
     }
     
    @Override
    public double getFeiyong() {
            double feiyong = 0.0;
        
        switch(getMail().getChanpinfenlei2()){
            case "快包":
                feiyong = toudifei.get(getMail().getJidasheng()).getKuaibao();
                break;
            case "E标准":
                feiyong = toudifei.get(getMail().getJidasheng()).getEbiao();
                break;
            default:
                feiyong = toudifei.get(getMail().getJidasheng()).getQita();
                break;
                
    }
        if(getMail().getYoujianzhongliang() >3 && getMail().getYoujianzhongliang() <=5){
            feiyong= feiyong + Math.ceil((getMail().getYoujianzhongliang() - 3.0))*0.3;
            }else if(getMail().getYoujianzhongliang() >5){
                feiyong= feiyong + 2*0.3+Math.ceil((getMail().getYoujianzhongliang() - 5.0))*0.4;
            }
        return feiyong;
    }
    
}
