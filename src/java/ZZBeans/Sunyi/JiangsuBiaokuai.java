/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ZZBeans.Sunyi;

import java.util.HashMap;

/**
 *
 * @author Administrator
 */
public class JiangsuBiaokuai {
    //收寄方
    double haocai = 0.2;
    int jijian  = 1;
    double shitangdanjia  = 0.0015;
    
    
    
    
    int shitangxishu = 15;
    //市趟=shitang*shitangxishu
    double neibuchuli = 0.5;
    
    
    //省内 
    //二干 公里数*重量*shengneiergandanjia/1000
    double shengneiergandanjia = 0.775;
    HashMap<String,Integer> shengneiergangonglishu = new HashMap<String,Integer>(){
        {
            put("安徽省",90);
            put("北京",265);
            put("福建省",265);
            put("甘肃省",265);
            put("广东省",265);
            put("广西壮族自治区",265);
            put("贵州省",265);
            put("海南省",265);
            put("河北省",265);
            put("河南省",265);
            put("黑龙江省",265);
            put("湖北省",265);
            put("湖南省",265);
            put("吉林省",265);
            put("江苏省",90);
            put("江西省",265);
            put("辽宁省",265);
            put("内蒙古自治区",265);
            put("宁夏回族自治区",265);
            put("青海省",265);
            put("山东省",265);
            put("山西省",265);
            put("陕西省",265);
            put("上海",90);
            put("四川省",265);
            put("天津",265);
            put("西藏自治区",265);
            put("新疆维吾尔自治区",265);
            put("云南省",265);
            put("浙江省",90);
            put("重庆",265);
        }
    };
   //省内经转 3kg 0.3 +续重0.15
    
    
    
    
    
    //省际
    //shengjiyigan*重量
     HashMap<String,Double> shengjiyigan = new HashMap<String,Double>(){
        {
            put("安徽省",0.0);
            put("北京",5.2);
            put("福建省",4.6);
            put("甘肃省",7.6);
            put("广东省",6.2);
            put("广西壮族自治区",7.3);
            put("贵州省",7.2);
            put("海南省",8.7);
            put("河北省",4.7);
            put("河南省",3.8);
            put("黑龙江省",7.9);
            put("湖北省",3.3);
            put("湖南省",4.5);
            put("吉林省",7.2);
            put("江苏省",0.0);
            put("江西省",3.7);
            put("辽宁省",7.5);
            put("内蒙古自治区",6.2);
            put("宁夏回族自治区",8.4);
            put("青海省",8.2);
            put("山东省",3.6);
            put("山西省",5.2);
            put("陕西省",5.7);
            put("上海",0.0);
            put("四川省",7.5);
            put("天津",5.8);
            put("西藏自治区",16.0);
            put("新疆维吾尔自治区",13.2);
            put("云南省",8.3);
            put("浙江省",0.0);
            put("重庆",6.4);
        }
        
    };
     
     
     //跨省经传
     HashMap<String,Double> shengjikuashengjingzhuan = new HashMap<String,Double>(){
        {
            put("安徽省",0.0);
            put("北京",0.0);
            put("福建省",0.0);
            put("甘肃省",0.0);
            put("广东省",0.0);
            put("广西壮族自治区",0.0);
            put("贵州省",0.0);
            put("海南省",0.1);
            put("河北省",0.0);
            put("河南省",0.0);
            put("黑龙江省",0.0);
            put("湖北省",0.0);
            put("湖南省",0.0);
            put("吉林省",0.0);
            put("江苏省",0.0);
            put("江西省",0.0);
            put("辽宁省",0.0);
            put("内蒙古自治区",0.0);
            put("宁夏回族自治区",0.1);
            put("青海省",0.1);
            put("山东省",0.0);
            put("山西省",0.0);
            put("陕西省",0.0);
            put("上海",0.0);
            put("四川省",0.0);
            put("天津",0.0);
            put("西藏自治区",0.2);
            put("新疆维吾尔自治区",0.1);
            put("云南省",0.1);
            put("浙江省",0.0);
            put("重庆",0.0);
        }
    };
    
    //投递方
     //内部处理 3kg 0.3 +续重0.15
    
    
    
    //投递市趟及二干 0.toudishitangdanjia*公里数
     double toudishitangdanjia = 0.0015;
    HashMap<String,Integer> toudifangshitangergangonglishu = new HashMap<String,Integer>(){
        {
            put("安徽省",220);
            put("北京",80);
            put("福建省",220);
            put("甘肃省",220);
            put("广东省",220);
            put("广西壮族自治区",220);
            put("贵州省",220);
            put("海南省",220);
            put("河北省",220);
            put("河南省",220);
            put("黑龙江省",220);
            put("湖北省",220);
            put("湖南省",220);
            put("吉林省",220);
            put("江苏省",20);
            put("江西省",220);
            put("辽宁省",220);
            put("内蒙古自治区",220);
            put("宁夏回族自治区",220);
            put("青海省",220);
            put("山东省",220);
            put("山西省",220);
            put("陕西省",220);
            put("上海",40);
            put("四川省",220);
            put("天津",50);
            put("西藏自治区",220);
            put("新疆维吾尔自治区",220);
            put("云南省",220);
            put("浙江省",150);
            put("重庆",50);
        }
    };
    
    //投递费
    //3kg内（包含）2.05元，3-5kg（包含)2.05+0.3*超出部分，5kg以上2.05+0.6+超出*0.4
    
    
   public JiangsuBiaokuai(){
       
   }
   
   
   
   public double getHaocai(){
       return haocai;
   }
   
   public int getLantouyuanjijian(){
       return jijian;
   }
   
   
   //shitang 收寄
   //shitang*15  
   public double getShoujiShitang(double zhongliang){
       return shitangdanjia*15*zhongliang;
   }
   
   public double getShoujiNeibuchuli(){
       return neibuchuli;
   }
   
   //二干 公里数*重量*shengneiergandanjia/1000
   public double getShengneiergan(String jidadi,double zhongliang){
       return shengneiergangonglishu.get(jidadi)*zhongliang*shengneiergandanjia/1000;
   }
   
   //省内经传 0-3kg（包含)0.1*重量 大于3 0.3+超出部分向上取整*0.15
   public double getShengneijingzhuan(double zhongliang){
       double shengneijingzhuan = 0.0;
       if(zhongliang <= 3.0){
           shengneijingzhuan = 0.1*zhongliang;
       }else{
           shengneijingzhuan = 0.3+Math.ceil(zhongliang-3.0)*0.15;
       }
       return shengneijingzhuan;
   }
   
   //省际一干*重量
   public double getShengjiyigan(String jidadi,double zhongliang){
       return shengjiyigan.get(jidadi)*zhongliang;
   }
   
   //跨省经传
   public double getKuashengjingzhuan(String jidadi){
       return shengjikuashengjingzhuan.get(jidadi);
   }
   
   //投递内部处理 3kg 0.3 +向上取整(重量-3）*0.15
   public double getToudineibuchuli(double zhongliang){
       double toudineibuchuli = 0.0;
       if(zhongliang <=3.0){
           toudineibuchuli = 0.3;
       }else{
           toudineibuchuli = 0.3+Math.ceil(zhongliang-3.0)*0.15;
       }
       return toudineibuchuli;
   }
   
   //投递食堂和二干
   //投递市趟及二干 toudishitangdanjia*公里数*重量
   public double getToudishitangergan(String jidadi,double zhongliang){
       return toudifangshitangergangonglishu.get(jidadi)*toudishitangdanjia*zhongliang;
   }
   
   //投递费
   //投递费 0-3kg（包含） 2
   //3-5kg（包含）2+（重量-3）*0.3
   //5kg以上 2+0.6+0.4*(重量-5）
   public double getToudifei(double zhongliang){
       double toudifei = 0.0;
       if(zhongliang <= 3.0){
           toudifei = 2;
       }else if(zhongliang >3.0 && zhongliang <=5.0){
           toudifei = 2+(zhongliang -3.0)*0.3;
       }else if(zhongliang > 5){
           toudifei = 2+0.6+(zhongliang -6.0)*0.4;
       }
       return toudifei;
   }
   
   
   
}
