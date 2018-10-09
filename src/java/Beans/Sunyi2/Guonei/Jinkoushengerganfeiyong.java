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
public class Jinkoushengerganfeiyong extends Feiyong{

    
final  static HashMap<String,Double> jinkoushengergangongli = new HashMap<String,Double>(){
        {
            put("安徽省",170.0);
            put("北京",50.0);
            put("福建省",210.0);
            put("甘肃省",320.0);
            put("广东省",170.0);
            put("广西壮族自治区",240.0);
            put("贵州省",190.0);
            put("海南省",190.0);
            put("河北省",280.0);
            put("河南省",180.0);
            put("黑龙江省",280.0);
            put("湖北省",210.0);
            put("湖南省",210.0);
            put("吉林省",180.0);
            put("江苏省",0.0);
            put("江西省",290.0);
            put("辽宁省",230.0);
            put("内蒙古自治区",690.0);
            put("宁夏回族自治区",310.0);
            put("青海省",160.0);
            put("山东省",210.0);
            put("山西省",200.0);
            put("陕西省",160.0);
            put("上海",50.0);
            put("四川省",200.0);
            put("天津",50.0);
            put("西藏自治区",450.0);
            put("新疆维吾尔自治区",450.0);
            put("云南省",280.0);
            put("浙江省",190.0);
            put("重庆",80.0);
            put("未知",0.0);
        }
    };
    
    public Jinkoushengerganfeiyong(Mail mail) {
        super(mail);
    }

    @Override
    public double getFeiyong() {
        double feiyong =0.0;
        feiyong = 0.775*jinkoushengergangongli.get(getMail().getJidasheng())*getMail().getYoujianzhongliang()/1000.0;
        
        return feiyong;
    }
    
}
