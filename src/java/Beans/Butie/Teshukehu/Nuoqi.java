/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Beans.Butie.Teshukehu;

import Beans.Arith;
import Beans.Butie.Butiejine;
import Beans.Butie.Mail;
import Beans.MyLog;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;

/**
 *
 * @author Administrator
 */
public class Nuoqi extends Butiejine{
    public final static String kehudaima = "90000006614298";
    final String jiaoyima = "492";
    double zifei1;//
    double zifei2;
    double xuzhongzifei2;
    double zifei3;
    double xuzhongzifei3;

    public Nuoqi(double zifei1, double zifei2, double xuzhongzifei2, double zifei3, double xuzhongzifei3) {
        this.zifei1 = zifei1;
        this.zifei2 = zifei2;
        this.xuzhongzifei2 = xuzhongzifei2;
        this.zifei3 = zifei3;
        this.xuzhongzifei3 = xuzhongzifei3;
    }


    
    
    final  static HashMap<String,Nuoqi> zifei = new HashMap<String,Nuoqi>(){
        {
            put("安徽省",new Nuoqi(4.8,5.2,1.3,5.6,1.4));//
            put("北京",new Nuoqi(4.8,6,1.5,7.2,1.8));//
            put("福建省",new Nuoqi(4.8,5.6,1.4,7.2,1.8));//
            put("甘肃省",new Nuoqi(5.2,7.5,2.25,10.0,3.0));//
            put("广东省",new Nuoqi(4.8,6.5,1.95,8,2.4));//
            put("广西壮族自治区",new Nuoqi(4.8,7,2.1,10,3));//
            put("贵州省",new Nuoqi(4.8,7,2.1,8,2.4));//
            put("海南省",new Nuoqi(4.8,7,2.1,8,2.4));//
            put("河北省",new Nuoqi(4.8,5.2,1.3,5.6,1.4));//
            put("河南省",new Nuoqi(4.8,5.2,1.3,5.6,1.4));//
            put("黑龙江省",new Nuoqi(5.6,11.2,3.2,11.9,3.4));//
            put("湖北省",new Nuoqi(4.8,5.2,1.3,5.6,1.4));//
            put("湖南省",new Nuoqi(4.8,5.2,1.3,5.6,1.4));//
            put("吉林省",new Nuoqi(4.8,6.5,1.95,8,2.4));//
            put("江苏省",new Nuoqi(3.5,3.9,1.3,4.2,1.4));//
            put("江西省",new Nuoqi(4.8,5.2,1.3,5.6,1.4));//
            put("辽宁省",new Nuoqi(4.8,7.5,2.25,7.0,2.1));//
            put("内蒙古自治区",new Nuoqi(4.8,6.5,1.95,10.0,3.0));//
            put("宁夏回族自治区",new Nuoqi(4.8,6.5,1.95,7.0,2.1));//
            put("青海省",new Nuoqi(12.0,16.0,12.0,16.0,12.0));//
            put("山东省",new Nuoqi(4.8,5.2,1.3,5.6,1.4));//
            put("山西省",new Nuoqi(4.8,6.5,1.95,7.0,2.1));//
            put("陕西省",new Nuoqi(4.8,6.5,1.95,7.0,2.1));//
            put("上海",new Nuoqi(4.8,5.2,1.3,5.6,1.4));//
            put("四川省",new Nuoqi(5.2,7.0,2.1,9.0,2.7));//
            put("天津",new Nuoqi(4.8,5.2,1.3,5.6,1.4));//
            put("西藏自治区",new Nuoqi(12.0,16.0,12.0,16.0,12.0));//
            put("新疆维吾尔自治区",new Nuoqi(12.0,16.0,12.0,16.0,12.0));//
            put("云南省",new Nuoqi(5.6,11.2,3.2,11.9,3.4));//
            put("浙江省",new Nuoqi(4.8,5.2,1.3,5.6,1.4));//
            put("重庆",new Nuoqi(4.8,6.5,1.95,7.0,2.1));//
            put("未知",new Nuoqi(0,0,0,0,0));
        }
    };
    public Nuoqi(Mail mail){
        super(mail);
        
    }
    public static void main(String[] args) {
        
        double shishouzifei = zifei.get("广西壮族自治区").getZifei3()+Math.ceil((12.3-1))*zifei.get("广西壮族自治区").getXuzhongzifei3();
        System.out.println(shishouzifei);
    }

    //设置实收费用
    //设置补贴金额
    @Override
    public void jisuanbutie() {
        Mail mail = this.getMail();
        switch(mail.getJiaoyima()){
            case "492":
                if(mail.getYoujianzhongliang()<= 0.5){
                    this.setShishouzifei(zifei.get(mail.getJidasheng()).getZifei1());
                    
                }else if(mail.getYoujianzhongliang()> 0.5 && mail.getYoujianzhongliang()<= 5.0){
                    //double s =  Arith.roundup(mail.getYoujianzhongliang(), 0);
                    
                    if(mail.getYoujianzhongliang() <= 1.0){
                        this.setShishouzifei(zifei.get(mail.getJidasheng()).getZifei2());
                        //this.setButiejine(Arith.sub(mail.getXitongzifei(), this.getShishouzifei()));
                    }else{
                        double shishouzifei = zifei.get(mail.getJidasheng()).getZifei2()+Math.ceil((getMail().getYoujianzhongliang()-1))*zifei.get(mail.getJidasheng()).getXuzhongzifei2();
                        //this.setShishouzifei(Arith.add(zifei.get(mail.getJidasheng()).getZifei2(),Arith.mul(zifei.get(mail.getJidasheng()).getXuzhongzifei2(),Arith.sub(s, 1.0))));
                        this.setShishouzifei(shishouzifei);
                    }
                }else{
                    //double s =  Arith.roundup(mail.getYoujianzhongliang(), 0);
                    double shishouzifei = zifei.get(mail.getJidasheng()).getZifei3()+Math.ceil((getMail().getYoujianzhongliang()-1))*zifei.get(mail.getJidasheng()).getXuzhongzifei3();
                    System.out.println(mail.getYoujianhao()+","+shishouzifei);
                    //this.setShishouzifei(Arith.add(zifei.get(mail.getJidasheng()).getZifei3(),Arith.mul(zifei.get(mail.getJidasheng()).getXuzhongzifei3(),Arith.sub(s, 1.0))));
                    this.setShishouzifei(shishouzifei);
                }
                this.setButiejine(mail.getXitongzifei()- this.getShishouzifei());
                break;
            default:
                break;
            
            
        }
        
    }
    public double getZifei1() {
        return zifei1;
    }

    public void setZifei1(double zifei1) {
        this.zifei1 = zifei1;
    }

    public double getZifei2() {
        return zifei2;
    }

    public void setZifei2(double zifei2) {
        this.zifei2 = zifei2;
    }

    public double getXuzhongzifei2() {
        return xuzhongzifei2;
    }

    public void setXuzhongzifei2(double xuzhongzifei2) {
        this.xuzhongzifei2 = xuzhongzifei2;
    }

    public double getZifei3() {
        return zifei3;
    }

    public void setZifei3(double zifei3) {
        this.zifei3 = zifei3;
    }

    public double getXuzhongzifei3() {
        return xuzhongzifei3;
    }

    public void setXuzhongzifei3(double xuzhongzifei3) {
        this.xuzhongzifei3 = xuzhongzifei3;
    }
}
