/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Beans.Sunyi2.Guoji;

import Beans.MyLog;

import Beans.Sunyi2.Feiyong;
import Beans.Sunyi2.Mail;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;

/**
 *
 * @author Administrator
 */

public class Guojizhongduanfei extends Feiyong{
    
    
    
    
    
    
    final static HashMap<String,Guojizhongduanfei> guojizhongduanfei = new HashMap<String,Guojizhongduanfei>(){
        {
            put("AE",new Guojizhongduanfei("AE","阿联酋",97.0,97.0));
            put("AL",new Guojizhongduanfei("AL","阿尔巴尼亚",0.0,0.0));
            put("AM",new Guojizhongduanfei("AM","亚美尼亚",0.0,0.0));
            put("AR",new Guojizhongduanfei("AR","阿根廷",64.0,64.0));
            put("AT",new Guojizhongduanfei("AT","奥地利",88.0,88.0));
            put("AU",new Guojizhongduanfei("AU","澳大利亚",54.0,54.0));
            put("AZ",new Guojizhongduanfei("AZ","阿塞拜疆",0.0,0.0));
            put("BD",new Guojizhongduanfei("BD","孟加拉",48.0,48.0));
            put("BE",new Guojizhongduanfei("BE","比利时",77.0,77.0));
            put("BF",new Guojizhongduanfei("BF","布及那法索",68.0,68.0));
            put("BG",new Guojizhongduanfei("BG","保加利亚",63.0,63.0));
            put("BH",new Guojizhongduanfei("BH","巴林",70.0,70.0));
            put("BR",new Guojizhongduanfei("BR","巴西",35.0,85.0));
            put("BW",new Guojizhongduanfei("BW","博茨瓦纳",97.0,97.0));
            put("BY",new Guojizhongduanfei("BY","白俄罗斯",73.0,73.0));
            put("CA",new Guojizhongduanfei("CA","加拿大",96.0,96.0));
            put("CD",new Guojizhongduanfei("CD","民主刚果",97.0,97.0));
            put("CG",new Guojizhongduanfei("CG","刚果",48.0,48.0));
            put("CH",new Guojizhongduanfei("CH","瑞士",121.0,121.0));
            put("CI",new Guojizhongduanfei("CI","科特迪瓦",68.0,68.0));
            put("CO",new Guojizhongduanfei("CO","哥伦比亚",64.0,64.0));
            put("CR",new Guojizhongduanfei("CR","哥斯达黎加",0.0,0.0));
            put("CU",new Guojizhongduanfei("CU","古巴",77.0,77.0));
            put("CY",new Guojizhongduanfei("CY","塞浦路斯",87.0,87.0));
            put("CZ",new Guojizhongduanfei("CZ","捷克",68.0,68.0));
            put("DE",new Guojizhongduanfei("DE","德国",98.0,98.0));
            put("DJ",new Guojizhongduanfei("DJ","吉布提",48.0,48.0));
            put("DK",new Guojizhongduanfei("DK","丹麦",110.0,110.0));
            put("DZ",new Guojizhongduanfei("DZ","阿尔及利亚",0.0,0.0));
            put("EC",new Guojizhongduanfei("EC","厄瓜多尔",0.0,0.0));
            put("EE",new Guojizhongduanfei("EE","爱沙尼亚",77.0,77.0));
            put("EG",new Guojizhongduanfei("EG","埃及",83.0,83.0));
            put("ES",new Guojizhongduanfei("ES","西班牙",73.0,73.0));
            put("ET",new Guojizhongduanfei("ET","埃赛俄比亚",109.0,109.0));
            put("FI",new Guojizhongduanfei("FI","芬兰",106.0,106.0));
            put("FR",new Guojizhongduanfei("FR","法国",62.0,89.0));
            put("GA",new Guojizhongduanfei("GA","加蓬",0.0,0.0));
            put("GB",new Guojizhongduanfei("GB","英国",101.0,101.0));
            put("GH",new Guojizhongduanfei("GH","加纳",48.0,68.0));
            put("GN",new Guojizhongduanfei("GN","几内亚",68.0,68.0));
            put("GR",new Guojizhongduanfei("GR","希腊",97.0,97.0));
            put("GY",new Guojizhongduanfei("GY","圭亚纳",0.0,0.0));
            put("HK",new Guojizhongduanfei("HK","香港",24.0,39.0));
            put("HR",new Guojizhongduanfei("HR","克罗地亚",46.0,64.0));
            put("HU",new Guojizhongduanfei("HU","匈牙利",97.0,97.0));
            put("ID",new Guojizhongduanfei("ID","印度尼西亚",55.0,55.0));
            put("IE",new Guojizhongduanfei("IE","爱尔兰",106.0,106.0));
            put("IL",new Guojizhongduanfei("IL","以色列",87.0,87.0));
            put("IN",new Guojizhongduanfei("IN","印度",35.0,59.0));
            put("IR",new Guojizhongduanfei("IR","伊朗",77.0,77.0));
            put("IT",new Guojizhongduanfei("IT","意大利",101.0,101.0));
            put("JO",new Guojizhongduanfei("JO","约旦",97.0,97.0));
            put("JP",new Guojizhongduanfei("JP","日本",48.0,68.0));
            put("KE",new Guojizhongduanfei("KE","肯尼亚",97.0,97.0));
            put("KH",new Guojizhongduanfei("KH","柬埔寨",34.0,48.0));
            put("KP",new Guojizhongduanfei("KP","朝鲜",0.0,0.0));
            put("KR",new Guojizhongduanfei("KR","韩国",34.0,48.0));
            put("KW",new Guojizhongduanfei("KW","科威特",68.0,68.0));
            put("KY",new Guojizhongduanfei("KY","开曼群岛",0.0,0.0));
            put("KZ",new Guojizhongduanfei("KZ","哈萨克斯坦",110.0,110.0));
            put("LA",new Guojizhongduanfei("LA","老挝",34.0,48.0));
            put("LB",new Guojizhongduanfei("LB","黎巴嫩",0.0,0.0));
            put("LK",new Guojizhongduanfei("LK","斯里兰卡",39.0,58.0));
            put("LT",new Guojizhongduanfei("LT","立陶宛",0.0,0.0));
            put("LU",new Guojizhongduanfei("LU","卢森堡",87.0,87.0));
            put("LV",new Guojizhongduanfei("LV","拉脱维亚",68.0,68.0));
            put("MA",new Guojizhongduanfei("MA","摩洛哥",77.0,77.0));
            put("MD",new Guojizhongduanfei("MD","摩尔多瓦",0.0,0.0));
            put("MG",new Guojizhongduanfei("MG","马达加斯加",77.0,77.0));
            put("ML",new Guojizhongduanfei("ML","马里",48.0,48.0));
            put("MM",new Guojizhongduanfei("MM","缅甸",0.0,0.0));
            put("MN",new Guojizhongduanfei("MN","蒙古",68.0,68.0));
            put("MO",new Guojizhongduanfei("MO","澳门",24.0,39.0));
            put("MT",new Guojizhongduanfei("MT","马耳他",88.0,88.0));
            put("MX",new Guojizhongduanfei("MX","墨西哥",83.0,83.0));
            put("MY",new Guojizhongduanfei("MY","马来西亚",0.0,0.0));//单独计算
            put("MZ",new Guojizhongduanfei("MZ","莫桑比克",57.0,57.0));
            put("NE",new Guojizhongduanfei("NE","尼日尔",68.0,68.0));
            put("NG",new Guojizhongduanfei("NG","尼日利亚",85.0,85.0));
            put("NL",new Guojizhongduanfei("NL","荷兰",0.0,0.0));
            put("NO",new Guojizhongduanfei("NO","挪威",142.0,142.0));
            put("NP",new Guojizhongduanfei("NP","尼泊尔",34.0,48.0));
            put("NZ",new Guojizhongduanfei("NZ","新西兰",30.0,30.0));
            put("OM",new Guojizhongduanfei("OM","阿曼",92.0,92.0));
            put("PA",new Guojizhongduanfei("PA","巴拿马",97.0,97.0));
            put("PE",new Guojizhongduanfei("PE","秘鲁",73.0,73.0));
            put("PG",new Guojizhongduanfei("PG","巴布亚新几内亚",55.0,55.0));
            put("PH",new Guojizhongduanfei("PH","菲律宾",34.0,63.0));
            put("PK",new Guojizhongduanfei("PK","巴基斯坦",44.0,55.0));
            put("PL",new Guojizhongduanfei("PL","波兰",77.0,77.0));
            put("PT",new Guojizhongduanfei("PT","葡萄牙",68.0,68.0));
            put("QA",new Guojizhongduanfei("QA","卡塔尔",77.0,77.0));
            put("RO",new Guojizhongduanfei("RO","罗马尼亚",106.0,106.0));
            put("RS",new Guojizhongduanfei("RS","塞尔维亚",0.0,0.0));
            put("RU",new Guojizhongduanfei("RU","俄罗斯",42.0,42.0));
            put("RW",new Guojizhongduanfei("RW","卢旺达",68.0,68.0));
            put("SA",new Guojizhongduanfei("SA","沙特阿拉伯",55.0,55.0));
            put("SE",new Guojizhongduanfei("SE","瑞典",126.0,126.0));
            put("SG",new Guojizhongduanfei("SG","新加坡",29.0,48.0));
            put("SI",new Guojizhongduanfei("SI","斯洛文尼亚",0.0,0.0));
            put("SL",new Guojizhongduanfei("SL","赛拉利昂",0.0,0.0));
            put("SN",new Guojizhongduanfei("SN","赛内加尔",77.0,77.0));
            put("SR",new Guojizhongduanfei("SR","苏里南",0.0,0.0));
            put("SY",new Guojizhongduanfei("SY","叙利亚",0.0,0.0));
            put("TD",new Guojizhongduanfei("TD","乍得",97.0,97.0));
            put("TH",new Guojizhongduanfei("TH","泰国",34.0,55.0));
            put("TN",new Guojizhongduanfei("TN","突尼斯",68.0,68.0));
            put("TR",new Guojizhongduanfei("TR","土耳其",66.0,66.0));
            put("TW",new Guojizhongduanfei("TW","中国台湾",34.0,48.0));
            put("UA",new Guojizhongduanfei("UA","乌克兰",97.0,97.0));
            put("UG",new Guojizhongduanfei("UG","乌干达",97.0,97.0));
            put("US",new Guojizhongduanfei("US","美国",36.0,36.0));
            put("UY",new Guojizhongduanfei("UY","乌拉圭",0.0,0.0));
            put("UZ",new Guojizhongduanfei("UZ","乌兹别克斯坦",0.0,0.0));
            put("VN",new Guojizhongduanfei("VN","越南",25.0,61.0));
            put("ZA",new Guojizhongduanfei("ZA","南非",0.0,0.0));//单独计算
            put("FJ",new Guojizhongduanfei("FJ","菲济",0.0,0.0));
            put("MU",new Guojizhongduanfei("MU","毛里求斯",0.0,0.0));
            put("CL",new Guojizhongduanfei("CL","智利",0.0,0.0));
            put("LR",new Guojizhongduanfei("LR","利比里亚",0.0,0.0));
            put("YE",new Guojizhongduanfei("YE","也门",0.0,0.0));
            put("KG",new Guojizhongduanfei("KG","吉尔吉斯斯坦",0.0,0.0));
            put("TJ",new Guojizhongduanfei("TJ","塔吉克斯坦",0.0,0.0));
            put("TM",new Guojizhongduanfei("TM","土库曼斯坦",0.0,0.0));
            put("AF",new Guojizhongduanfei("AF","阿富汗",0.0,0.0));
            put("AG",new Guojizhongduanfei("AG","安提瓜和巴布达",0.0,0.0));
            put("AO",new Guojizhongduanfei("AO","安哥拉",0.0,0.0));
            put("AW",new Guojizhongduanfei("AW","阿鲁巴",0.0,0.0));
            put("BA",new Guojizhongduanfei("BA","波黑",0.0,0.0));
            put("BB",new Guojizhongduanfei("BB","巴巴多斯",0.0,0.0));
            put("BI",new Guojizhongduanfei("BI","布隆迪",0.0,0.0));
            put("BJ",new Guojizhongduanfei("BJ","贝宁",0.0,0.0));
            put("BN",new Guojizhongduanfei("BN","文莱",0.0,0.0));
            put("BO",new Guojizhongduanfei("BO","玻利维亚",0.0,0.0));
            put("BS",new Guojizhongduanfei("BS","巴哈马",0.0,0.0));
            put("BT",new Guojizhongduanfei("BT","布丹",0.0,0.0));
            put("BZ",new Guojizhongduanfei("BZ","伯利兹",0.0,0.0));
            put("CF",new Guojizhongduanfei("CF","中非",0.0,0.0));
            put("CM",new Guojizhongduanfei("CM","喀麦隆",0.0,0.0));
            put("CV",new Guojizhongduanfei("CV","佛得角",0.0,0.0));
            put("DM",new Guojizhongduanfei("DM","多米尼加",0.0,0.0));
            put("DO",new Guojizhongduanfei("DO","多米尼加(REP)",0.0,0.0));
            put("ER",new Guojizhongduanfei("ER","厄立特里亚",0.0,0.0));
            put("GF",new Guojizhongduanfei("GF","法属圭亚那",0.0,0.0));
            put("GP",new Guojizhongduanfei("GP","瓜德罗普",0.0,0.0));
            put("MQ",new Guojizhongduanfei("MQ","马其顿",0.0,0.0));
            put("NC",new Guojizhongduanfei("NC","新喀里多尼亚",0.0,0.0));
            put("PF",new Guojizhongduanfei("PF","法属波利尼西亚",0.0,0.0));
            put("PM",new Guojizhongduanfei("PM","圣皮埃尔和密克隆",0.0,0.0));
            put("RE",new Guojizhongduanfei("RE","留尼旺",0.0,0.0));
            put("WF",new Guojizhongduanfei("WF","瓦利斯和富图那群岛",0.0,0.0));
            put("AI",new Guojizhongduanfei("AI","安圭拉",0.0,0.0));
            put("BM",new Guojizhongduanfei("BM","百慕大",0.0,0.0));
            put("FK",new Guojizhongduanfei("FK","马尔维纳斯群岛",0.0,0.0));
            put("GI",new Guojizhongduanfei("GI","直布罗陀",0.0,0.0));
            put("MS",new Guojizhongduanfei("MS","蒙特塞拉特",0.0,0.0));
            put("PN",new Guojizhongduanfei("PN","皮特凯恩群岛",0.0,0.0));
            put("SH",new Guojizhongduanfei("SH","圣赫勒拿",0.0,0.0));
            put("TA",new Guojizhongduanfei("TA","特里斯坦达库尼亚",0.0,0.0));
            put("TC",new Guojizhongduanfei("TC","特克斯和凯科斯群岛",0.0,0.0));
            put("VG",new Guojizhongduanfei("VG","英属维尔京群岛",0.0,0.0));
            put("GD",new Guojizhongduanfei("GD","格林纳达",0.0,0.0));
            put("GE",new Guojizhongduanfei("GE","格鲁及亚",0.0,0.0));
            put("GM",new Guojizhongduanfei("GM","冈比亚",0.0,0.0));
            put("GQ",new Guojizhongduanfei("GQ","赤道几内亚",0.0,0.0));
            put("GT",new Guojizhongduanfei("GT","危地马拉",0.0,0.0));
            put("GW",new Guojizhongduanfei("GW","几内亚比绍",0.0,0.0));
            put("HN",new Guojizhongduanfei("HN","洪都拉斯",0.0,0.0));
            put("HT",new Guojizhongduanfei("HT","海地",0.0,0.0));
            put("IQ",new Guojizhongduanfei("IQ","伊拉克",0.0,0.0));
            put("IS",new Guojizhongduanfei("IS","冰岛",0.0,0.0));
            put("JM",new Guojizhongduanfei("JM","牙买加",0.0,0.0));
            put("KI",new Guojizhongduanfei("KI","基里巴斯",0.0,0.0));
            put("KM",new Guojizhongduanfei("KM","科摩罗",0.0,0.0));
            put("KN",new Guojizhongduanfei("KN","圣基茨和尼维斯联邦",0.0,0.0));
            put("LC",new Guojizhongduanfei("LC","圣卢西亚",0.0,0.0));
            put("LS",new Guojizhongduanfei("LS","莱索托",0.0,0.0));
            put("LY",new Guojizhongduanfei("LY","利比亚",0.0,0.0));
            put("ME",new Guojizhongduanfei("ME","黑山",0.0,0.0));
            put("MK",new Guojizhongduanfei("MK","马其顿",0.0,0.0));
            put("MR",new Guojizhongduanfei("MR","毛里塔尼亚",0.0,0.0));
            put("MV",new Guojizhongduanfei("MV","马尔代夫",0.0,0.0));
            put("MW",new Guojizhongduanfei("MW","马拉维",0.0,0.0));
            put("NA",new Guojizhongduanfei("NA","纳米比亚",0.0,0.0));
            put("NI",new Guojizhongduanfei("NI","尼加拉瓜",0.0,0.0));
            put("NR",new Guojizhongduanfei("NR","瑙鲁",0.0,0.0));
            put("PS",new Guojizhongduanfei("PS","巴勒斯坦",0.0,0.0));
            put("PY",new Guojizhongduanfei("PY","巴拉圭",0.0,0.0));
            put("SB",new Guojizhongduanfei("SB","所罗门群岛",0.0,0.0));
            put("SC",new Guojizhongduanfei("SC","塞舌尔",0.0,0.0));
            put("SD",new Guojizhongduanfei("SD","苏丹",0.0,0.0));
            put("SK",new Guojizhongduanfei("SK","斯洛伐克",0.0,0.0));
            put("SO",new Guojizhongduanfei("SO","索马里",0.0,0.0));
            put("ST",new Guojizhongduanfei("ST","圣多美和普林西比",0.0,0.0));
            put("SV",new Guojizhongduanfei("SV","萨尔瓦多",0.0,0.0));
            put("SZ",new Guojizhongduanfei("SZ","斯威士兰",0.0,0.0));
            put("TG",new Guojizhongduanfei("TG","多哥",0.0,0.0));
            put("TL",new Guojizhongduanfei("TL","帝力",0.0,0.0));
            put("TO",new Guojizhongduanfei("TO","汤加",0.0,0.0));
            put("TT",new Guojizhongduanfei("TT","特立尼达和多巴哥",0.0,0.0));
            put("TV",new Guojizhongduanfei("TV","图瓦卢",0.0,0.0));
            put("TZ",new Guojizhongduanfei("TZ","坦桑尼亚",0.0,0.0));
            put("VA",new Guojizhongduanfei("VA","梵蒂冈",0.0,0.0));
            put("VC",new Guojizhongduanfei("VC","圣文森特",0.0,0.0));
            put("VE",new Guojizhongduanfei("VE","委内瑞拉",0.0,0.0));
            put("VU",new Guojizhongduanfei("VU","瓦奴阿图",0.0,0.0));
            put("WS",new Guojizhongduanfei("WS","西萨摩亚",0.0,0.0));
            put("ZM",new Guojizhongduanfei("ZM","赞比亚",0.0,0.0));
            put("ZW",new Guojizhongduanfei("ZW","津巴布维",0.0,0.0));
            put("LI",new Guojizhongduanfei("LI","列支敦士登",0.0,0.0));
            put("CT",new Guojizhongduanfei("CT","未知国家",0.0,0.0));
        }

    }; 
    final static HashMap<String,String> zhongsufenqu = new HashMap<String,String>(){
        {
            put("HK","1");
            put("MO","1");
            put("KR","2");
            put("TW","2");
            put("ID","3");
            put("MY","3");
            put("PH","3");
            put("SG","3");
            put("TH","3");
            put("VN","3");
            put("JP","4");
            put("AU","5");
            put("NZ","5");
            put("CA","6");
            put("US","6");
            put("GB","7");
            put("BE","7");
            put("DE","7");
            put("NL","7");
            put("DK","8");
            put("ES","8");
            put("FI","8");
            put("FR","8");
            put("IE","8");
            put("IT","8");
            put("LU","8");
            put("PT","8");
            put("SE","8");
            put("AT","8");
            put("CH","8");
            put("NO","8");
            put("GR","9");
            put("TR","9");
            put("BG","9");
            put("CZ","9");
            put("EE","9");
            put("HR","9");
            put("HU","9");
            put("LT","9");
            put("LV","9");
            put("PL","9");
            put("RO","9");
            put("SI","9");
            put("SK","9");
            put("BA","10");
            put("CS","10");
            put("RU","10");
            put("AE","11");
            put("BH","11");
            put("IL","11");
            put("SA","11");
            put("ZA","12");
            put("YE","12");
            put("EG","12");
            put("IQ","12");
            put("IR","12");
            put("JO","12");
            put("KW","12");
            put("LB","12");
            put("OM","12");
            put("PS","12");
            put("QA","12");
            put("SY","12");
            put("BD","13");
            put("IN","13");
            put("LK","13");
            put("NP","13");
            put("PK","13");
            put("AR","14");
            put("BR","14");
            put("CL","14");
            put("CO","14");
            put("GL","10");
            put("LI","10");
            put("MC","15");
            put("AD","15");
            put("FO","15");
            put("GI","15");
            put("MT","15");
            put("CY","15");
            put("SM","15");
            put("VA","15");
            put("AL","15");
            put("AM","15");
            put("AZ","15");
            put("BY","15");
            put("GE","15");
            put("IS","15");
            put("MD","15");
            put("MK","15");
            put("UA","15");
            put("BN","15");
            put("KH","15");
            put("LA","15");
            put("FJ","15");
            put("PG","15");
            put("AF","15");
            put("MM","15");
            put("AO","15");
            put("BF","15");
            put("BI","15");
            put("BJ","15");
            put("BT","15");
            put("BW","15");
            put("CD","15");
            put("CF","15");
            put("CG","15");
            put("CI","15");
            put("CM","15");
            put("CV","15");
            put("DJ","15");
            put("DZ","15");
            put("ER","15");
            put("ET","15");
            put("GA","15");
            put("GH","15");
            put("GM","15");
            put("GN","15");
            put("GQ","15");
            put("GW","15");
            put("KE","15");
            put("KM","15");
            put("LR","15");
            put("LS","15");
            put("LY","15");
            put("MA","15");
            put("MG","15");
            put("ML","15");
            put("MR","15");
            put("MU","15");
            put("MW","15");
            put("MZ","15");
            put("NA","15");
            put("NE","15");
            put("NG","15");
            put("RE","15");
            put("RW","15");
            put("SC","15");
            put("SD","15");
            put("SL","15");
            put("SN","15");
            put("SO","15");
            put("ST","15");
            put("SZ","15");
            put("TD","15");
            put("TG","15");
            put("TN","15");
            put("TZ","15");
            put("UG","15");
            put("YT","15");
            put("ZM","15");
            put("ZW","15");
            put("CC","15");
            put("KG","15");
            put("KP","15");
            put("KZ","15");
            put("MN","15");
            put("TJ","15");
            put("TM","15");
            put("UZ","15");
            put("AG","15");
            put("AI","15");
            put("AN","15");
            put("AW","15");
            put("BB","15");
            put("BM","15");
            put("BS","15");
            put("JM","15");
            put("KN","15");
            put("KY","15");
            put("LC","15");
            put("MQ","15");
            put("TC","15");
            put("TT","15");
            put("VC","15");
            put("VG","15");
            put("VI","15");
            put("BZ","15");
            put("CR","15");
            put("CU","15");
            put("DM","15");
            put("DO","15");
            put("GD","15");
            put("GP","15");
            put("GT","15");
            put("HN","15");
            put("HT","15");
            put("MS","15");
            put("MX","15");
            put("NI","15");
            put("PA","15");
            put("PR","15");
            put("SV","15");
            put("YK","15");
            put("YM","10");
            put("MV","15");
            put("CX","15");
            put("PM","15");
            put("AS","15");
            put("CK","15");
            put("FM","15");
            put("GU","15");
            put("KI","15");
            put("MH","15");
            put("MP","15");
            put("NC","15");
            put("NF","15");
            put("NR","15");
            put("PF","15");
            put("PW","15");
            put("SB","15");
            put("TL","15");
            put("TO","15");
            put("TV","15");
            put("VU","15");
            put("WF","15");
            put("WS","15");
            put("BO","15");
            put("EC","15");
            put("GF","15");
            put("GY","15");
            put("PE","15");
            put("PY","15");
            put("SR","15");
            put("UY","15");
            put("VE","15");
        }
    };
   final static HashMap<String,String> zhongsudhlfenqu = new HashMap<String,String>(){
        {
            put("HK","1");
            put("MO","1");
            put("TW","2");
            put("KR","3");
            put("JP","4");
            put("ID","5");
            put("MY","5");
            put("PH","5");
            put("SG","5");
            put("TH","5");
            put("VN","5");
            put("BN","6");
            put("KH","6");
            put("LA","6");
            put("AU","7");
            put("NZ","7");
            put("AS","8");
            put("MP","8");
            put("CK","8");
            put("TL","8");
            put("FJ","8");
            put("GU","8");
            put("KI","8");
            put("KP","8");
            put("MH","8");
            put("FM","8");
            put("NR","8");
            put("NC","8");
            put("NU","8");
            put("PW","8");
            put("PG","8");
            put("WS","8");
            put("SB","8");
            put("PF","8");
            put("TO","8");
            put("TV","8");
            put("VU","8");
            put("IN","9");
            put("BD","10");
            put("BT","10");
            put("MV","10");
            put("MN","10");
            put("MM","10");
            put("NP","10");
            put("PK","10");
            put("LK","10");
            put("US","11");
            put("CA","12");
            put("MX","13");
            put("BR","14");
            put("CL","14");
            put("CO","14");
            put("VE","14");
            put("AI","15");
            put("AG","15");
            put("AR","15");
            put("AW","15");
            put("BS","15");
            put("BB","15");
            put("BZ","15");
            put("BM","15");
            put("BO","15");
            put("XB","15");
            put("KY","15");
            put("CR","15");
            put("CU","15");
            put("XC","15");
            put("DM","15");
            put("DO","15");
            put("EC","15");
            put("SV","15");
            put("GF","15");
            put("GD","15");
            put("GP","15");
            put("GT","15");
            put("GY","15");
            put("HT","15");
            put("HN","15");
            put("JM","15");
            put("MQ","15");
            put("MS","15");
            put("AN","15");
            put("XN","15");
            put("NI","15");
            put("PA","15");
            put("PY","15");
            put("PE","15");
            put("PR","15");
            put("XY","15");
            put("XE","15");
            put("KN","15");
            put("LC","15");
            put("XM","15");
            put("VC","15");
            put("SR","15");
            put("TT","15");
            put("TC","15");
            put("UY","15");
            put("VG","15");
            put("VI","15");
            put("BE","16");
            put("FR","16");
            put("DE","16");
            put("IT","16");
            put("LI","16");
            put("NL","16");
            put("ES","16");
            put("CH","16");
            put("GB","16");
            put("VA","16");
            put("AD","17");
            put("AT","17");
            put("IC","17");
            put("CY","17");
            put("DK","17");
            put("FI","17");
            put("GI","17");
            put("GR","17");
            put("GL","17");
            put("GG","17");
            put("IS","17");
            put("IE","17");
            put("JE","17");
            put("LU","17");
            put("MT","17");
            put("MC","17");
            put("NO","17");
            put("PT","17");
            put("SE","17");
            put("BG","18");
            put("HR","18");
            put("CZ","18");
            put("EE","18");
            put("HU","18");
            put("LV","18");
            put("LT","18");
            put("PL","18");
            put("SK","18");
            put("SI","18");
            put("AL","19");
            put("AM","19");
            put("AZ","19");
            put("BY","19");
            put("BA","19");
            put("FK","19");
            put("FO","19");
            put("GE","19");
            put("KZ","19");
            put("KV","19");
            put("KG","19");
            put("MK","19");
            put("MD","19");
            put("ME","19");
            put("RO","19");
            put("RU","19");
            put("SM","19");
            put("RS","19");
            put("TJ","19");
            put("UA","19");
            put("UZ","19");
            put("IL","20");
            put("SA","20");
            put("AE","20");
            put("AF","21");
            put("BH","21");
            put("EG","21");
            put("JO","21");
            put("KW","21");
            put("LY","21");
            put("OM","21");
            put("QA","21");
            put("TR","21");
            put("DZ","22");
            put("AO","22");
            put("BJ","22");
            put("BW","22");
            put("BF","22");
            put("BI","22");
            put("CM","22");
            put("CV","22");
            put("CF","22");
            put("TD","22");
            put("KM","22");
            put("CG","22");
            put("CD","22");
            put("CI","22");
            put("DJ","22");
            put("ER","22");
            put("ET","22");
            put("GA","22");
            put("GM","22");
            put("GH","22");
            put("GN","22");
            put("GW","22");
            put("GQ","22");
            put("IR","22");
            put("IQ","22");
            put("KE","22");
            put("LB","22");
            put("LS","22");
            put("LR","22");
            put("MG","22");
            put("MW","22");
            put("ML","22");
            put("MR","22");
            put("MU","22");
            put("YT","22");
            put("MA","22");
            put("MZ","22");
            put("NA","22");
            put("NE","22");
            put("NG","22");
            put("RE","22");
            put("RW","22");
            put("ST","22");
            put("SN","22");
            put("SC","22");
            put("SH","22");
            put("SL","22");
            put("SO","22");
            put("XS","22");
            put("ZA","22");
            put("SS","22");
            put("SD","22");
            put("SZ","22");
            put("SY","22");
            put("TZ","22");
            put("TG","22");
            put("TN","22");
            put("UG","22");
            put("YE","22");
            put("ZM","22");
            put("ZW","22");
        }
    };
    
    String jidajudaima;
    String jidaju;
    double wenjian;
    double wupin;
    
    public Guojizhongduanfei(String jidadidaima,String jidadi,double wenjian,double wupin){
        this.setJidajudaima(jidadidaima);
        this.setJidaju(jidadi);
        this.setWenjian(wenjian);
        this.setWupin(wupin);
    }
    public Guojizhongduanfei(Mail mail){
        super(mail);
    }
    void setJidaju(String jidaju){
        this.jidaju = jidaju;
        
    }
    void setJidajudaima(String jidajudaima){
        this.jidajudaima = jidajudaima;
    }
    void setWupin(double wupin){
        this.wupin = wupin;
    }
    void setWenjian(double wenjian){
        this.wenjian = wenjian;
    }
    public String getJidaju(){
        return jidaju;
    }
    public String getJidajudaima(){
        return jidajudaima;
    }
    public double getWenjian(){
        return wenjian;
    }
    public double getWupin(){
        return wupin;
    }
    
    
    
    @Override
    public double getFeiyong() {
        
        double feiyong = 0.0;
        switch (this.getMail().getChanpinfenlei2()){
            case "国际中速TNT":
                try{
                    String sqlzhongsu = "select * from sunyizhongsuchengben where  quyu = ? and zhongliang >= ? and youjianleixing = ? order by zhongliang";
                    Connection conn = MyLog.getConn();
                    PreparedStatement pstmt = conn.prepareStatement(sqlzhongsu);
                    //System.out.println(request.getParameter("kshijian").replace("-", ""));
                    
                    pstmt.setString(1,zhongsufenqu.get(this.getMail().getJidadidaima()));
                    pstmt.setDouble(2, this.getMail().getYoujianzhongliang());
                    pstmt.setString(3, this.getMail().getIswenjian()?"文件":"物品");
                    
                    ResultSet rs =pstmt.executeQuery();
                    if(rs.next()){
                        feiyong = rs.getDouble("jiage");
                    }
                    rs.close();
                    pstmt.close();
                    MyLog.close(conn);
                }catch(Exception e){
                    e.printStackTrace();
                }
                break;
            case "国际e邮宝":
                if(null == Guojieybfei.guojieyblist.get(this.getMail().getJidadidaima())){
                    feiyong = 0.0;
                }else{
                    feiyong =  Guojieybfei.guojieyblist.get(this.getMail().getJidadidaima()).getMeijianjiage()+Guojieybfei.guojieyblist.get(this.getMail().getJidadidaima()).getZhonglaingjiage()*this.getMail().getYoujianzhongliang();
                }
                
                break;
            case "国际中速DHL":        
                double feilv = 1.1175;
                    try{
                    String sqlzhongsu = "select * from sunyidhlchengben where  quyu = ? and zuidazhongliang >= ? and youjianleixing = ? order by zuidazhongliang";
                    Connection conn = MyLog.getConn();
                    PreparedStatement pstmt = conn.prepareStatement(sqlzhongsu);
                    //System.out.println(request.getParameter("kshijian").replace("-", ""));
                    
                    pstmt.setString(1,zhongsudhlfenqu.get(this.getMail().getJidadidaima()));
                    pstmt.setDouble(2, this.getMail().getYoujianzhongliang());
                    pstmt.setString(3, this.getMail().getIswenjian()?"文件":"物品");
                    
                    ResultSet rs =pstmt.executeQuery();
                    if(rs.next()){
                        double shouzhong = rs.getDouble("shouzhong");
                        double xuzhong = rs.getDouble("xuzhong");
                        
                        if(this.getMail().getYoujianzhongliang()>20.0){
                            feiyong = Math.ceil(this.getMail().getYoujianzhongliang())*xuzhong;
                        }else{
                            feiyong = Math.ceil((this.getMail().getYoujianzhongliang()-0.5)/0.5)*xuzhong + shouzhong;
                        }
                    }
                    feiyong = feiyong*feilv;
                    rs.close();
                    pstmt.close();
                    MyLog.close(conn);
                }catch(Exception e){
                    e.printStackTrace();
                }
                break;
            case "国际中速佐川":
                try{
                        
                        String sqlzuochuan = "select * from sunyizuochuanchengben where  zuidazhongliang >= ? and youjianleixing = ? order by zuidazhongliang";
                        Connection conn = MyLog.getConn();
                        PreparedStatement pstmt = conn.prepareStatement(sqlzuochuan);
                        //System.out.println(request.getParameter("kshijian").replace("-", ""));

                        
                        pstmt.setDouble(1, this.getMail().getYoujianzhongliang());
                        pstmt.setString(2, this.getMail().getIswenjian()?"文件":"物品");

                        ResultSet rs =pstmt.executeQuery();
                        if(rs.next()){
                            double shouzhong = rs.getDouble("shouzhong");
                            double xuzhong = rs.getDouble("xuzhong");
                            feiyong = Math.ceil((this.getMail().getYoujianzhongliang()-0.5)/0.5)*xuzhong + shouzhong;
                            
                        }
                        rs.close();
                        pstmt.close();
                        MyLog.close(conn);
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                break;
            default:
                if(null == guojizhongduanfei.get(this.getMail().getJidadidaima())){
                    feiyong = 0.0;
                }else{
                    if("马来西亚".equals(guojizhongduanfei.get(this.getMail().getJidadidaima()))){
                        feiyong = 29+17*this.getMail().getYoujianzhongliang();
                    }else if("南非".equals(guojizhongduanfei.get(this.getMail().getJidadidaima()))){
                        feiyong = 73+18*this.getMail().getYoujianzhongliang();
                    }
                    else{
                        feiyong =  this.getMail().getIswenjian()?guojizhongduanfei.get(this.getMail().getJidadidaima()).getWenjian():guojizhongduanfei.get(this.getMail().getJidadidaima()).getWupin();
                    }
                    
                }
                
                break;
        }
        return feiyong;
        
        //return guojihangkongfei.get(this.getMail().getJigoudaima())*this.getMail().getYoujianzhongliang();
    }
    
}
