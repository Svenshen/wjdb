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
public class JiangsuKuaibao {
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
            put("北京",90);
            put("福建省",90);
            put("甘肃省",90);
            put("广东省",90);
            put("广西壮族自治区",90);
            put("贵州省",90);
            put("海南省",90);
            put("河北省",90);
            put("河南省",90);
            put("黑龙江省",90);
            put("湖北省",90);
            put("湖南省",90);
            put("吉林省",90);
            put("江苏省",90);
            put("江西省",90);
            put("辽宁省",90);
            put("内蒙古自治区",90);
            put("宁夏回族自治区",90);
            put("青海省",90);
            put("山东省",90);
            put("山西省",90);
            put("陕西省",90);
            put("上海",90);
            put("四川省",90);
            put("天津",90);
            put("西藏自治区",90);
            put("新疆维吾尔自治区",90);
            put("云南省",90);
            put("浙江省",90);
            put("重庆",90);
        }
    };
   //省内经转 3kg 0.3 +续重0.15
    
    
    
    
    
    //省际
    //shengjiyigan*重量
     HashMap<String,Double> shengjiyigan = new HashMap<String,Double>(){
        {
            put("安徽省",0.45);
            put("北京",1.05);
            put("福建省",1.15);
            put("甘肃省",2.35);
            put("广东省",1.6);
            put("广西壮族自治区",2.2);
            put("贵州省",2.0);
            put("海南省",2.45);
            put("河北省",0.95);
            put("河南省",0.75);
            put("黑龙江省",2.4);
            put("湖北省",0.8);
            put("湖南省",1.15);
            put("吉林省",2.1);
            put("江苏省",0.0);
            put("江西省",0.85);
            put("辽宁省",1.7);
            put("内蒙古自治区",1.9);
            put("宁夏回族自治区",2.95);
            put("青海省",2.75);
            put("山东省",0.65);
            put("山西省",1.25);
            put("陕西省",1.5);
            put("上海",0.1);
            put("四川省",2.15);
            put("天津",1.05);
            put("西藏自治区",4.46);
            put("新疆维吾尔自治区",4.15);
            put("云南省",2.65);
            put("浙江省",0.5);
            put("重庆",1.75);
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
    
    
   public JiangsuKuaibao(){
       
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
   //投递费 0-1kg（包含） 2.3
   
   //1kg以上 2.3+0.23*(重量-1）
   public double getToudifei(double zhongliang){
       double toudifei = 0.0;
       if(zhongliang <= 1.0){
           toudifei = 2.3;
       }else{
           toudifei = 2.3+(zhongliang -1.0)*0.23;
       }
       return toudifei;
   }
   
   
   
}
