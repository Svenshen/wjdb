/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Beans.Sunyi2.Guonei;

import Beans.Sunyi2.Feiyong;
import Beans.Sunyi2.Mail;

/**
 *
 * @author Administrator
 */
public class Erganyunfei extends Feiyong{
    
    
    public Erganyunfei(Mail mail) {
        super(mail);
    }
    
    public double getFeiyong(){
        if("215200".equals(getMail().getJidadidaima())){
//            if(getMail().getJidadidaima().equals("21529904")){
//                return 0.775*getMail().getYoujianzhongliang()*100/1000;
//            }
            return 0.0;
        }
        double feiyong = 0.0;
        switch(getMail().getYoujianluxiang()){
            case "南集":
                feiyong = 0.775*getMail().getYoujianzhongliang()*280/1000;
                break;
            case "无锡":
                feiyong = 0.775*getMail().getYoujianzhongliang()*100/1000;
                break;
            case "经济航空":
                feiyong =  0.775*getMail().getYoujianzhongliang()*50/1000;
                break;
            case "民航":
                feiyong =  0.775*getMail().getYoujianzhongliang()*280/1000;
                break;
            case "上海":
                feiyong = 0.775*getMail().getYoujianzhongliang()*150/1000;
                break;
            default:
                 switch(getMail().getChanpinfenlei2()){
                        //西藏、海南、青海、贵州、宁夏
                        case "标准":
                            
                            if(getMail().getJidasheng().contains("上海")){
                                feiyong = 0.775*getMail().getYoujianzhongliang()*150/1000;
                            }else if(getMail().getJidasheng().contains("江苏")||getMail().getJidasheng().contains("浙江")||getMail().getJidasheng().contains("上海")||getMail().getJidasheng().contains("安徽")){
                                feiyong = 0.775*getMail().getYoujianzhongliang()*100/1000;
                            }else{
                                if("陆运".equals(getMail().getYunshufangshi())){
                                    feiyong = 0.775*getMail().getYoujianzhongliang()*100/1000;
                                }else{
                                    feiyong = 0.775*getMail().getYoujianzhongliang()*280/1000;
                                }
                            }

                            break;
                        case "E标准":
                            if(getMail().getJidasheng().contains("上海")){
                                feiyong = 0.775*getMail().getYoujianzhongliang()*150/1000;
                            }else if(getMail().getJidasheng().contains("江苏")||getMail().getJidasheng().contains("浙江")||getMail().getJidasheng().contains("上海")||getMail().getJidasheng().contains("安徽")){
                                feiyong = 0.775*getMail().getYoujianzhongliang()*100/1000;
                            }else{
                               if("陆运".equals(getMail().getYunshufangshi())){
                                    feiyong = 0.775*getMail().getYoujianzhongliang()*100/1000;
                                }else{
                                    feiyong = 0.775*getMail().getYoujianzhongliang()*280/1000;
                                }
                            }
                            break;
                        case "快包":
                            feiyong = 0.775*getMail().getYoujianzhongliang()*100/1000;
                            break;
                        default:
                            feiyong = 0;
                            break;
                    }
                
                break;
        }
                
        
        return feiyong;
    }
}
