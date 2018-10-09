/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Beans.Sunyi2.Guoji;

import Beans.Sunyi2.Feiyong;
import Beans.Sunyi2.Mail;
import java.util.HashMap;

/**
 *
 * @author Administrator
 */
public class Guojihangkongfei extends Feiyong{

    String jidajudaima;
    String jidaju;
    double hangkongfei;
 
    
    final static HashMap<String,Guojihangkongfei> guojihangkongfei = new HashMap<String,Guojihangkongfei>(){
        {
            put("AE",new Guojihangkongfei("AE","阿联酋",21.52));
            put("AL",new Guojihangkongfei("AL","阿尔巴尼亚",0.0));
            put("AM",new Guojihangkongfei("AM","亚美尼亚",0.0));
            put("AR",new Guojihangkongfei("AR","阿根廷",67.83));
            put("AT",new Guojihangkongfei("AT","奥地利",29.76));
            put("AU",new Guojihangkongfei("AU","澳大利亚",31.23));
            put("AZ",new Guojihangkongfei("AZ","阿塞拜疆",0.0));
            put("BD",new Guojihangkongfei("BD","孟加拉",13.0));
            put("BE",new Guojihangkongfei("BE","比利时",32.0));
            put("BF",new Guojihangkongfei("BF","布及那法索",45.0));
            put("BG",new Guojihangkongfei("BG","保加利亚",34.11));
            put("BH",new Guojihangkongfei("BH","巴林",27.05));
            put("BR",new Guojihangkongfei("BR","巴西",46.67));
            put("BW",new Guojihangkongfei("BW","博茨瓦纳",47.69));
            put("BY",new Guojihangkongfei("BY","白俄罗斯",41.26));
            put("CA",new Guojihangkongfei("CA","加拿大",38.16));
            put("CD",new Guojihangkongfei("CD","民主刚果",45.0));
            put("CG",new Guojihangkongfei("CG","刚果",45.0));
            put("CH",new Guojihangkongfei("CH","瑞士",31.83));
            put("CI",new Guojihangkongfei("CI","科特迪瓦",45.0));
            put("CO",new Guojihangkongfei("CO","哥伦比亚",70.0));
            put("CR",new Guojihangkongfei("CR","哥斯达黎加",0.0));
            put("CU",new Guojihangkongfei("CU","古巴",70.0));
            put("CY",new Guojihangkongfei("CY","塞浦路斯",32.46));
            put("CZ",new Guojihangkongfei("CZ","捷克",29.76));
            put("DE",new Guojihangkongfei("DE","德国",35.0));
            put("DJ",new Guojihangkongfei("DJ","吉布提",49.77));
            put("DK",new Guojihangkongfei("DK","丹麦",24.87));
            put("DZ",new Guojihangkongfei("DZ","阿尔及利亚",0.0));
            put("EC",new Guojihangkongfei("EC","厄瓜多尔",0.0));
            put("EE",new Guojihangkongfei("EE","爱沙尼亚",40.68));
            put("EG",new Guojihangkongfei("EG","埃及",29.47));
            put("ES",new Guojihangkongfei("ES","西班牙",37.66));
            put("ET",new Guojihangkongfei("ET","埃赛俄比亚",45.0));
            put("FI",new Guojihangkongfei("FI","芬兰",27.04));
            put("FR",new Guojihangkongfei("FR","法国",31.8));
            put("GA",new Guojihangkongfei("GA","加蓬",45.0));
            put("GB",new Guojihangkongfei("GB","英国",34.01));
            put("GH",new Guojihangkongfei("GH","加纳",45.0));
            put("GN",new Guojihangkongfei("GN","几内亚",45.0));
            put("GR",new Guojihangkongfei("GR","希腊",31.4));
            put("GY",new Guojihangkongfei("GY","圭亚纳",0.0));
            put("HK",new Guojihangkongfei("HK","香港",7.12));
            put("HR",new Guojihangkongfei("HR","克罗地亚",31.69));
            put("HU",new Guojihangkongfei("HU","匈牙利",30.73));
            put("ID",new Guojihangkongfei("ID","印度尼西亚",16.0));
            put("IE",new Guojihangkongfei("IE","爱尔兰",32.81));
            put("IL",new Guojihangkongfei("IL","以色列",30.73));
            put("IN",new Guojihangkongfei("IN","印度",15.0));
            put("IR",new Guojihangkongfei("IR","伊朗",28.99));
            put("IT",new Guojihangkongfei("IT","意大利",32.6));
            put("JO",new Guojihangkongfei("JO","约旦",27.05));
            put("JP",new Guojihangkongfei("JP","日本",13.97));
            put("KE",new Guojihangkongfei("KE","肯尼亚",45.0));
            put("KH",new Guojihangkongfei("KH","柬埔寨",15.0));
            put("KP",new Guojihangkongfei("KP","朝鲜",0.0));
            put("KR",new Guojihangkongfei("KR","韩国",15.15));
            put("KW",new Guojihangkongfei("KW","科威特",31.89));
            put("KY",new Guojihangkongfei("KY","开曼群岛",0.0));
            put("KZ",new Guojihangkongfei("KZ","哈萨克斯坦",0.0));
            put("LA",new Guojihangkongfei("LA","老挝",24.05));
            put("LB",new Guojihangkongfei("LB","黎巴嫩",0.0));
            put("LK",new Guojihangkongfei("LK","斯里兰卡",23.0));
            put("LT",new Guojihangkongfei("LT","立陶宛",0.0));
            put("LU",new Guojihangkongfei("LU","卢森堡",34.05));
            put("LV",new Guojihangkongfei("LV","拉脱维亚",29.28));
            put("MA",new Guojihangkongfei("MA","摩洛哥",37.2));
            put("MD",new Guojihangkongfei("MD","摩尔多瓦",0.0));
            put("MG",new Guojihangkongfei("MG","马达加斯加",45.0));
            put("ML",new Guojihangkongfei("ML","马里",45.0));
            put("MM",new Guojihangkongfei("MM","缅甸",0.0));
            put("MN",new Guojihangkongfei("MN","蒙古",9.04));
            put("MO",new Guojihangkongfei("MO","澳门",6.0));
            put("MT",new Guojihangkongfei("MT","马耳他",34.69));
            put("MX",new Guojihangkongfei("MX","墨西哥",35.0));
            put("MY",new Guojihangkongfei("MY","马来西亚",15.0));
            put("MZ",new Guojihangkongfei("MZ","莫桑比克",48.79));
            put("NE",new Guojihangkongfei("NE","尼日尔",49.63));
            put("NG",new Guojihangkongfei("NG","尼日利亚",36.19));
            put("NL",new Guojihangkongfei("NL","荷兰",0.0));
            put("NO",new Guojihangkongfei("NO","挪威",30.07));
            put("NP",new Guojihangkongfei("NP","尼泊尔",19.5));
            put("NZ",new Guojihangkongfei("NZ","新西兰",33.0));
            put("OM",new Guojihangkongfei("OM","阿曼",33.82));
            put("PA",new Guojihangkongfei("PA","巴拿马",70.0));
            put("PE",new Guojihangkongfei("PE","秘鲁",70.0));
            put("PG",new Guojihangkongfei("PG","巴布亚新几内亚",48.34));
            put("PH",new Guojihangkongfei("PH","菲律宾",12.0));
            put("PK",new Guojihangkongfei("PK","巴基斯坦",25.49));
            put("PL",new Guojihangkongfei("PL","波兰",32.0));
            put("PT",new Guojihangkongfei("PT","葡萄牙",32.0));
            put("QA",new Guojihangkongfei("QA","卡塔尔",27.05));
            put("RO",new Guojihangkongfei("RO","罗马尼亚",29.57));
            put("RS",new Guojihangkongfei("RS","塞尔维亚",0.0));
            put("RU",new Guojihangkongfei("RU","俄罗斯",34.94));
            put("RW",new Guojihangkongfei("RW","卢旺达",55.41));
            put("SA",new Guojihangkongfei("SA","沙特阿拉伯",26.09));
            put("SE",new Guojihangkongfei("SE","瑞典",28.5));
            put("SG",new Guojihangkongfei("SG","新加坡",20.45));
            put("SI",new Guojihangkongfei("SI","斯洛文尼亚",0.0));
            put("SL",new Guojihangkongfei("SL","赛拉利昂",0.0));
            put("SN",new Guojihangkongfei("SN","赛内加尔",45.0));
            put("SR",new Guojihangkongfei("SR","苏里南",0.0));
            put("SY",new Guojihangkongfei("SY","叙利亚",0.0));
            put("TD",new Guojihangkongfei("TD","乍得",45.0));
            put("TH",new Guojihangkongfei("TH","泰国",20.34));
            put("TN",new Guojihangkongfei("TN","突尼斯",34.01));
            put("TR",new Guojihangkongfei("TR","土耳其",31.89));
            put("TW",new Guojihangkongfei("TW","中国台湾",5.81));
            put("UA",new Guojihangkongfei("UA","乌克兰",40.68));
            put("UG",new Guojihangkongfei("UG","乌干达",45.0));
            put("US",new Guojihangkongfei("US","美国",35.81));
            put("UY",new Guojihangkongfei("UY","乌拉圭",0.0));
            put("UZ",new Guojihangkongfei("UZ","乌兹别克斯坦",28.99));
            put("VN",new Guojihangkongfei("VN","越南",13.0));
            put("ZA",new Guojihangkongfei("ZA","南非",44.37));
            put("FJ",new Guojihangkongfei("FJ","菲济",0.0));
            put("MU",new Guojihangkongfei("MU","毛里求斯",0.0));
            put("CL",new Guojihangkongfei("CL","智利",0.0));
            put("LR",new Guojihangkongfei("LR","利比里亚",0.0));
            put("YE",new Guojihangkongfei("YE","也门",0.0));
            put("KG",new Guojihangkongfei("KG","吉尔吉斯斯坦",0.0));
            put("TJ",new Guojihangkongfei("TJ","塔吉克斯坦",0.0));
            put("TM",new Guojihangkongfei("TM","土库曼斯坦",0.0));
            put("AF",new Guojihangkongfei("AF","阿富汗",0.0));
            put("AG",new Guojihangkongfei("AG","安提瓜和巴布达",0.0));
            put("AO",new Guojihangkongfei("AO","安哥拉",0.0));
            put("AW",new Guojihangkongfei("AW","阿鲁巴",0.0));
            put("BA",new Guojihangkongfei("BA","波黑",0.0));
            put("BB",new Guojihangkongfei("BB","巴巴多斯",0.0));
            put("BI",new Guojihangkongfei("BI","布隆迪",0.0));
            put("BJ",new Guojihangkongfei("BJ","贝宁",0.0));
            put("BN",new Guojihangkongfei("BN","文莱",0.0));
            put("BO",new Guojihangkongfei("BO","玻利维亚",0.0));
            put("BS",new Guojihangkongfei("BS","巴哈马",0.0));
            put("BT",new Guojihangkongfei("BT","布丹",0.0));
            put("BZ",new Guojihangkongfei("BZ","伯利兹",0.0));
            put("CF",new Guojihangkongfei("CF","中非",0.0));
            put("CM",new Guojihangkongfei("CM","喀麦隆",0.0));
            put("CV",new Guojihangkongfei("CV","佛得角",0.0));
            put("DM",new Guojihangkongfei("DM","多米尼加",0.0));
            put("DO",new Guojihangkongfei("DO","多米尼加(REP)",0.0));
            put("ER",new Guojihangkongfei("ER","厄立特里亚",0.0));
            put("GF",new Guojihangkongfei("GF","法属圭亚那",0.0));
            put("GP",new Guojihangkongfei("GP","瓜德罗普",0.0));
            put("MQ",new Guojihangkongfei("MQ","马其顿",0.0));
            put("NC",new Guojihangkongfei("NC","新喀里多尼亚",0.0));
            put("PF",new Guojihangkongfei("PF","法属波利尼西亚",0.0));
            put("PM",new Guojihangkongfei("PM","圣皮埃尔和密克隆",0.0));
            put("RE",new Guojihangkongfei("RE","留尼旺",0.0));
            put("WF",new Guojihangkongfei("WF","瓦利斯和富图那群岛",0.0));
            put("AI",new Guojihangkongfei("AI","安圭拉",0.0));
            put("BM",new Guojihangkongfei("BM","百慕大",0.0));
            put("FK",new Guojihangkongfei("FK","马尔维纳斯群岛",0.0));
            put("GI",new Guojihangkongfei("GI","直布罗陀",0.0));
            put("MS",new Guojihangkongfei("MS","蒙特塞拉特",0.0));
            put("PN",new Guojihangkongfei("PN","皮特凯恩群岛",0.0));
            put("SH",new Guojihangkongfei("SH","圣赫勒拿",0.0));
            put("TA",new Guojihangkongfei("TA","特里斯坦达库尼亚",0.0));
            put("TC",new Guojihangkongfei("TC","特克斯和凯科斯群岛",0.0));
            put("VG",new Guojihangkongfei("VG","英属维尔京群岛",0.0));
            put("GD",new Guojihangkongfei("GD","格林纳达",0.0));
            put("GE",new Guojihangkongfei("GE","格鲁及亚",0.0));
            put("GM",new Guojihangkongfei("GM","冈比亚",0.0));
            put("GQ",new Guojihangkongfei("GQ","赤道几内亚",0.0));
            put("GT",new Guojihangkongfei("GT","危地马拉",0.0));
            put("GW",new Guojihangkongfei("GW","几内亚比绍",0.0));
            put("HN",new Guojihangkongfei("HN","洪都拉斯",0.0));
            put("HT",new Guojihangkongfei("HT","海地",0.0));
            put("IQ",new Guojihangkongfei("IQ","伊拉克",0.0));
            put("IS",new Guojihangkongfei("IS","冰岛",0.0));
            put("JM",new Guojihangkongfei("JM","牙买加",0.0));
            put("KI",new Guojihangkongfei("KI","基里巴斯",0.0));
            put("KM",new Guojihangkongfei("KM","科摩罗",0.0));
            put("KN",new Guojihangkongfei("KN","圣基茨和尼维斯联邦",0.0));
            put("LC",new Guojihangkongfei("LC","圣卢西亚",0.0));
            put("LS",new Guojihangkongfei("LS","莱索托",0.0));
            put("LY",new Guojihangkongfei("LY","利比亚",0.0));
            put("ME",new Guojihangkongfei("ME","黑山",0.0));
            put("MK",new Guojihangkongfei("MK","马其顿",0.0));
            put("MR",new Guojihangkongfei("MR","毛里塔尼亚",0.0));
            put("MV",new Guojihangkongfei("MV","马尔代夫",0.0));
            put("MW",new Guojihangkongfei("MW","马拉维",0.0));
            put("NA",new Guojihangkongfei("NA","纳米比亚",0.0));
            put("NI",new Guojihangkongfei("NI","尼加拉瓜",0.0));
            put("NR",new Guojihangkongfei("NR","瑙鲁",0.0));
            put("PS",new Guojihangkongfei("PS","巴勒斯坦",0.0));
            put("PY",new Guojihangkongfei("PY","巴拉圭",0.0));
            put("SB",new Guojihangkongfei("SB","所罗门群岛",0.0));
            put("SC",new Guojihangkongfei("SC","塞舌尔",0.0));
            put("SD",new Guojihangkongfei("SD","苏丹",0.0));
            put("SK",new Guojihangkongfei("SK","斯洛伐克",0.0));
            put("SO",new Guojihangkongfei("SO","索马里",0.0));
            put("ST",new Guojihangkongfei("ST","圣多美和普林西比",0.0));
            put("SV",new Guojihangkongfei("SV","萨尔瓦多",0.0));
            put("SZ",new Guojihangkongfei("SZ","斯威士兰",0.0));
            put("TG",new Guojihangkongfei("TG","多哥",0.0));
            put("TL",new Guojihangkongfei("TL","帝力",0.0));
            put("TO",new Guojihangkongfei("TO","汤加",0.0));
            put("TT",new Guojihangkongfei("TT","特立尼达和多巴哥",0.0));
            put("TV",new Guojihangkongfei("TV","图瓦卢",0.0));
            put("TZ",new Guojihangkongfei("TZ","坦桑尼亚",0.0));
            put("VA",new Guojihangkongfei("VA","梵蒂冈",0.0));
            put("VC",new Guojihangkongfei("VC","圣文森特",0.0));
            put("VE",new Guojihangkongfei("VE","委内瑞拉",0.0));
            put("VU",new Guojihangkongfei("VU","瓦奴阿图",0.0));
            put("WS",new Guojihangkongfei("WS","西萨摩亚",0.0));
            put("ZM",new Guojihangkongfei("ZM","赞比亚",0.0));
            put("ZW",new Guojihangkongfei("ZW","津巴布维",0.0));
            put("LI",new Guojihangkongfei("LI","列支敦士登",0.0));
            put("CT",new Guojihangkongfei("CT","未知国家",0.0));
        }

    }; 
    
    public Guojihangkongfei(String jidajudaima,String jidaju,double hangkongfei){
        this.setJidaju(jidaju);
        this.setJidajudaima(jidajudaima);
        this.setHangkongfei(hangkongfei);
    }
    public Guojihangkongfei(Mail mail){
        super(mail);
    }
    void setJidaju(String jidaju){
        this.jidaju = jidaju;
        
    }
    void setJidajudaima(String jidajudaima){
        this.jidajudaima = jidajudaima;
    }
    void setHangkongfei(double hangkongfei){
        this.hangkongfei = hangkongfei;
    }
    public String getJidaju(){
        return jidaju;
    }
    public String getJidajudaima(){
        return jidajudaima;
    }
    public double getHangkongfei(){
        return hangkongfei;
    }
    
    @Override
    public double getFeiyong() {
        double feiyong = 0.0;
        switch(this.getMail().getChanpinfenlei2()){
            case "国际e邮宝":
                //Guojihangkongfei.guojihangkongfei
                if ( null == Guojieybfei.guojieyblist.get(this.getMail().getJidadidaima())){
                    feiyong = 0.0;
                }else{
                    feiyong = Guojieybfei.guojieyblist.get(this.getMail().getJidadidaima()).getHangkongyunfei()*this.getMail().getYoujianzhongliang();
                }
                
                
                break;
            
            
            case "国际中速TNT":
            
            case "国际中速DHL":
            case "国际中速佐川":
                feiyong = 0.0;
                break;
            default:
                if ( null == guojihangkongfei.get(this.getMail().getJidadidaima())){
                    feiyong = 0.0;
                }else{
                    feiyong = guojihangkongfei.get(this.getMail().getJidadidaima()).getHangkongfei()*this.getMail().getYoujianzhongliang();
                }
                
                break;
        }
        return feiyong;
    }
    
}
