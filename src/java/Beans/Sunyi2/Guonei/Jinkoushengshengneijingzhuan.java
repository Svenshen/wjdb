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
public class Jinkoushengshengneijingzhuan extends Feiyong{
   final static      HashMap<String,Boolean> jinkoushengneijingzhuan = new HashMap<String,Boolean>(){
        {
            put("安徽省",true);
            put("北京",true);
            put("福建省",true);
            put("甘肃省",true);
            put("广东省",true);
            put("广西壮族自治区",true);
            put("贵州省",true);
            put("海南省",true);
            put("河北省",true);
            put("河南省",true);
            put("黑龙江省",true);
            put("湖北省",true);
            put("湖南省",true);
            put("吉林省",true);
            put("江苏省",true);
            put("江西省",true);
            put("辽宁省",true);
            put("内蒙古自治区",true);
            put("宁夏回族自治区",true);
            put("青海省",true);
            put("山东省",true);
            put("山西省",true);
            put("陕西省",true);
            put("上海",true);
            put("四川省",true);
            put("天津",true);
            put("西藏自治区",true);
            put("新疆维吾尔自治区",true);
            put("云南省",true);
            put("浙江省",true);
            put("重庆",true);
            put("未知",false);
        }
    };
    public Jinkoushengshengneijingzhuan(Mail mail) {
        super(mail);
    }

    @Override
    public double getFeiyong() {
        double feiyong = 0.0;
        if(jinkoushengneijingzhuan.get(getMail().getJidasheng())){
            feiyong = 0.3;
            if(getMail().getYoujianzhongliang() > 3.0){
                feiyong+=Math.ceil(getMail().getYoujianzhongliang()-3.0)*0.15;
            }
        }
        return feiyong;
    }
    
}
