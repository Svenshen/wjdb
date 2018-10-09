/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Beans.Sunyi2.Guoji;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Administrator
 */
public class Guojieybfei {
    private final static double sdrmeiyuan = 6.5;
    private final static double sdrouyuan = 7.8;
    private final static double sdr = 9.35;
    
    
    double meijianjiage;
    double zhonglaingjiage;
    double hangkongyunfei;
    String guojia;
    String guojiaming;
    
    final static HashMap<String,Guojieybfei> guojieyblist = new HashMap<String,Guojieybfei>(){
        {
            put("IE",new Guojieybfei("IE","爱尔兰",28,2.559,1.257,sdr));
            put("AT",new Guojieybfei("AT","奥地利",27,2.56,1.258,sdr));
            put("AU",new Guojieybfei("AU","澳大利亚",29,1.8,1.55,sdr));
            put("BR",new Guojieybfei("BR","巴西",48,2.485,1.089,sdr));
            put("BE",new Guojieybfei("BE","比利时",29,2.56,1.258,sdr));
            put("PL",new Guojieybfei("PL","波兰",29,2.507,1.139,sdr));
            put("DK",new Guojieybfei("DK","丹麦",28,2.529,1.19,sdr));
            put("DE",new Guojieybfei("DE","德国",26.5,2,1.5,sdrouyuan));
            put("RU",new Guojieybfei("RU","俄罗斯",30,1.59,1.97,sdr));
            put("FR",new Guojieybfei("FR","法国",28,2.15,2.12,sdrouyuan));
            put("FI",new Guojieybfei("FI","芬兰",28,2.546,1.228,sdr));
            put("KR",new Guojieybfei("KR","韩国",7.9,2.503,1.13,sdr));
            put("NL",new Guojieybfei("NL","荷兰",25,2.56,1.258,sdr));
            put("CA",new Guojieybfei("CA","加拿大",27,1.85,2,sdr));
            put("LU",new Guojieybfei("LU","卢森堡",27,2.56,1.258,sdr));
            put("MY",new Guojieybfei("MY","马来西亚",17,2.485,1.089,sdr));
            put("US",new Guojieybfei("US","美国",29,0.96,2.6,sdr));
            put("MX",new Guojieybfei("MX","墨西哥",35,2.485,1.089,sdr));
            put("NO",new Guojieybfei("NO","挪威",26,1.75,2,sdr));
            put("PT",new Guojieybfei("PT","葡萄牙",29,1.66,1.26,sdr));
            put("JP",new Guojieybfei("JP","日本",10.5,1.025,1.729,sdr));
            put("SE",new Guojieybfei("SE","瑞典",28,1.85,1.26,sdr));
            put("CH",new Guojieybfei("CH","瑞士",30,2.56,1.258,sdr));
            put("SA",new Guojieybfei("SA","沙特阿拉伯",24,3.5,0,sdrmeiyuan));
            put("TH",new Guojieybfei("TH","泰国",8,1.3,1.55,sdr));
            put("TR",new Guojieybfei("TR","土耳其",39,2.524,1.177,sdr));
            put("UA",new Guojieybfei("UA","乌克兰",34,0.75,4,sdrmeiyuan));
            put("ES",new Guojieybfei("ES","西班牙",20.5,1.5,2.5,sdrouyuan));
            put("GR",new Guojieybfei("GR","希腊",28,2.552,1.24,sdr));
            put("HK",new Guojieybfei("HK","香港",7.5,1.5,1.55,sdr));
            put("SG",new Guojieybfei("SG","新加坡",10.8,2.509,1.143,sdr));
            put("NZ",new Guojieybfei("NZ","新西兰",35,0.8,1.8,sdr));
            put("HU",new Guojieybfei("HU","匈牙利",28,2.541,1.215,sdr));
            put("IL",new Guojieybfei("IL","以色列",30,1.55,2,sdr));
            put("IT",new Guojieybfei("IT","意大利",28.32,2.514,1.156,sdr));
            put("GB",new Guojieybfei("GB","英国",29,1.6,2,sdr));

        }
    };
    
    
    public Guojieybfei(String guojia,String guojiaming,double hangkongyunfei,double meijianjiage, double zhonglaingjiage,double sdrjiage) {
        this.guojia = guojia;
        this.guojiaming = guojiaming;
        this.hangkongyunfei = hangkongyunfei;
        this.meijianjiage = meijianjiage*sdrjiage;
        this.zhonglaingjiage = zhonglaingjiage*sdrjiage;
    }

    public double getMeijianjiage() {
        return meijianjiage;
    }

    public void setMeijianjiage(double meijianjiage) {
        this.meijianjiage = meijianjiage;
    }

    public double getZhonglaingjiage() {
        return zhonglaingjiage;
    }

    public void setZhonglaingjiage(double zhonglaingjiage) {
        this.zhonglaingjiage = zhonglaingjiage;
    }

    public double getHangkongyunfei() {
        return hangkongyunfei;
    }

    public void setHangkongyunfei(double hangkongyunfei) {
        this.hangkongyunfei = hangkongyunfei;
    }

    public String getGuojia() {
        return guojia;
    }

    public void setGuojia(String guojia) {
        this.guojia = guojia;
    }
    
    
    
}
