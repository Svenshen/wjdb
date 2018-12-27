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
public class Yiganfeiyong extends Feiyong{

   HashMap<String,Double> luyunjijinghang = new HashMap<String,Double>(){
        {
            put("上海",0.2);
            put("安徽省",0.45);
            put("浙江省",0.35);
            put("山东省",0.7);
            put("河南省",1.0);
            put("湖北省",0.9);
            put("江西省",1.0);
            put("河北省",1.0);
            put("天津",1.2);
            put("北京",1.05);
            put("福建省",1.2);
            put("湖南省",1.3);
            put("山西省",1.55);
            put("陕西省",1.5);
            put("广东省",1.6);
            put("辽宁省",1.7);
            put("重庆",2.5);
            put("内蒙古自治区",2.0);
            put("贵州省",2.4);
            put("吉林省",2.35);
            put("四川省",2.3);
            put("广西壮族自治区",2.0);
            put("海南省",2.2);
            put("甘肃省",2.4);
            put("黑龙江省",2.65);
            put("青海省",2.8);
            put("云南省",2.65);
            put("宁夏回族自治区",2.25);
            put("西藏自治区",4.45);
            put("新疆维吾尔自治区",4.15);
            put("江苏省",0.0);
            put("未知",0.0);
        }
    };
    
   HashMap<String,Double> hangkongyunfei = new HashMap<String,Double>(){
        {
            
            put("北京",5.2);
            put("福建省",4.3);
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
            //put("上海",2.3);
            put("上海",0.0);
            put("四川省",7.5);
            put("天津",5.8);
            put("西藏自治区",16.0);
            put("新疆维吾尔自治区",14.6);
            put("云南省",8.3);
            //put("浙江省",2.2);
            put("浙江省",0.0);
            put("重庆",6.4);
            put("安徽省",0.0);
            put("未知",0.0);
        }
    };
   
   
    
    public Yiganfeiyong(Mail mail) {
        super(mail);
    }

    @Override
    public double getFeiyong() {
        double feiyong = 0.0;
        
            switch(getMail().getYoujianluxiang()){
                case "南集":
                    feiyong = hangkongyunfei.get(getMail().getJidasheng())*getMail().getYoujianzhongliang()*0.95;
                    break;
                case "无锡":
                    feiyong = luyunjijinghang.get(getMail().getJidasheng())*getMail().getYoujianzhongliang();
                    break;
                case "经济航空":
                    feiyong = luyunjijinghang.get(getMail().getJidasheng())*getMail().getYoujianzhongliang();
                    break;
                case "民航":
                    feiyong = hangkongyunfei.get(getMail().getJidasheng())*getMail().getYoujianzhongliang()*0.95;
                    break;
                case "上海":
                    feiyong = 0.0;
                    break;
                case "直发-":
                    feiyong = 0.0;
                    break;
                default:

                    switch(getMail().getChanpinfenlei2()){
                        //西藏、海南、青海、贵州、宁夏

                        case "标准":
                            if("陆运".equals(getMail().getYunshufangshi())){
                                feiyong = luyunjijinghang.get(getMail().getJidasheng())*getMail().getYoujianzhongliang();
                            }else{
                                if(getMail().getJidasheng().contains("西藏")||getMail().getJidasheng().contains("海南")||getMail().getJidasheng().contains("青海")||getMail().getJidasheng().contains("贵州")||getMail().getJidasheng().contains("宁夏")){
                                    feiyong = hangkongyunfei.get(getMail().getJidasheng())*getMail().getYoujianzhongliang()*0.95;
                                }else if(getMail().getJidasheng().contains("浙江")||getMail().getJidasheng().contains("上海")||getMail().getJidasheng().contains("安徽")){
                                    feiyong = luyunjijinghang.get(getMail().getJidasheng())*getMail().getYoujianzhongliang();
                                }else{
                                    feiyong = hangkongyunfei.get(getMail().getJidasheng())*getMail().getYoujianzhongliang()*0.95;
                                }
                            }
                            break;
                        case "E标准":
                            if("陆运".equals(getMail().getYunshufangshi())){
                                feiyong = luyunjijinghang.get(getMail().getJidasheng())*getMail().getYoujianzhongliang();
                            }else{
                                if(getMail().getJidasheng().contains("西藏")||getMail().getJidasheng().contains("海南")||getMail().getJidasheng().contains("青海")||getMail().getJidasheng().contains("贵州")||getMail().getJidasheng().contains("宁夏")){
                                    feiyong = hangkongyunfei.get(getMail().getJidasheng())*getMail().getYoujianzhongliang()*0.95;
                                }else if (getMail().getJidasheng().contains("浙江")||getMail().getJidasheng().contains("上海")||getMail().getJidasheng().contains("安徽")){
                                    feiyong = luyunjijinghang.get(getMail().getJidasheng())*getMail().getYoujianzhongliang();
                                }else{
                                    feiyong = hangkongyunfei.get(getMail().getJidasheng())*getMail().getYoujianzhongliang()*0.95;
                                }
                            }
                            break;
                        case "快包":
                            feiyong = luyunjijinghang.get(getMail().getJidasheng())*getMail().getYoujianzhongliang();
                            break;
                        default:
                            feiyong = 0;
                            break;
                    }

                    break;
            }
        
        
        if(Integer.valueOf(getMail().getShoujiriqi()) <= 20181201 ){
            return feiyong;
        }else{
            return feiyong*0.705;
        }
        
    }
    
}
