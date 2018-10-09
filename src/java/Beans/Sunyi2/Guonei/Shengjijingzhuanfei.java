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
public class Shengjijingzhuanfei extends Feiyong{

 final static HashMap<String,Boolean> shengjijingzhuan = new HashMap<String,Boolean>(){
        {
            put("未知",false);
            put("安徽省",false);
            put("北京",false);
            put("福建省",false);
            put("甘肃省",false);
            put("广东省",false);
            put("广西壮族自治区",false);
            put("贵州省",false);
            put("海南省",true);
            put("河北省",false);
            put("河南省",false);
            put("黑龙江省",false);
            put("湖北省",false);
            put("湖南省",false);
            put("吉林省",false);
            put("江苏省",false);
            put("江西省",false);
            put("辽宁省",false);
            put("内蒙古自治区",false);
            put("宁夏回族自治区",true);
            put("青海省",true);
            put("山东省",false);
            put("山西省",false);
            put("陕西省",false);
            put("上海",false);
            put("四川省",false);
            put("天津",false);
            put("西藏自治区",true);
            put("新疆维吾尔自治区",true);
            put("云南省",true);
            put("浙江省",false);
            put("重庆",false);
        }
    };
    
    public Shengjijingzhuanfei(Mail mail) {
        super(mail);
    }

    @Override
    public double getFeiyong() {
      
        double feiyong = 0.0;
        if(shengjijingzhuan.get(getMail().getJidasheng())){
            feiyong=0.3;
            if(getMail().getYoujianzhongliang()>3.0){
                feiyong = feiyong + Math.ceil(getMail().getYoujianzhongliang() - 3.0)*0.15;
            }
        }
        return feiyong;
    }
    
}
