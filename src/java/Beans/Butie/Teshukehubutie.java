/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Beans.Butie;

import static Beans.Butie.Jisuan.getMail;
import static Beans.Butie.Jisuan.sqlhead;
import Beans.Butie.Teshukehu.Chuanzixiangsu;
import Beans.Butie.Teshukehu.Delikaxi;
import Beans.Butie.Teshukehu.Nuoqi;
import Beans.Butie.Teshukehu.Pengnuofangzhi;
import Beans.Butie.Teshukehu.Qinyu;
import Beans.Butie.Teshukehu.Shijilong;
import Beans.Butie.Teshukehu.Tejiafangzhi;
import Beans.Butie.Teshukehu.Wuyongfeng;
import Beans.Butie.Teshukehu.Yanyiyan;
import Beans.Butie.Teshukehu.Yingyu;
import Beans.Butie.Teshukehu.Zhulinjiang;

/**
 *
 * @author Administrator
 */
public class Teshukehubutie {

   
    public static void main(String[] args) {
        
    }
    
    public static void zhulinjiangbutie(String kshijian,String jshijian,String gongzuoid){
        String sqlanjian = sqlhead+" where clct_date >= ? and clct_date <= ? and sender_cust_code in ('"+Zhulinjiang.kehudaima+"')";
        for(Mail m:getMail(sqlanjian,kshijian,jshijian)){
                new Zhulinjiang(m).jisuanbutie();
                m.update("特殊补贴",gongzuoid);
                //Thread.sleep(40);
            }
    }
    
    public static void nuoqibutie(String kshijian,String jshijian,String gongzuoid){
        String sqlanjian = sqlhead+" where clct_date >= ? and clct_date <= ? and sender_cust_code in ('"+Nuoqi.kehudaima+"')";
        for(Mail m:getMail(sqlanjian,kshijian,jshijian)){
                new Nuoqi(m).jisuanbutie();
                m.update("特殊补贴",gongzuoid);
                //Thread.sleep(40);
            }
    }
    
    
    public static void chuanzibutie(String kshijian,String jshijian,String gongzuoid){
        String kehudaima = Chuanzixiangsu.kehudaima;
        String sqlanjian = sqlhead+" where clct_date >= ? and clct_date <= ? and sender_cust_code in ('"+kehudaima+"')";
        for(Mail m:getMail(sqlanjian,kshijian,jshijian)){
                new Chuanzixiangsu(m).jisuanbutie();
                m.update("特殊补贴",gongzuoid);
                //Thread.sleep(40);
            }
    }
    
        public static void yanyiyanbutie(String kshijian,String jshijian,String gongzuoid){
        String kehudaima = Yanyiyan.kehudaima;
        String sqlanjian = sqlhead+" where clct_date >= ? and clct_date <= ? and sender_cust_code in ('"+kehudaima+"')";
        for(Mail m:getMail(sqlanjian,kshijian,jshijian)){
                new Yanyiyan(m).jisuanbutie();
                m.update("特殊补贴",gongzuoid);
                //Thread.sleep(40);
            }
    }
    public static void shijilongbutie(String kshijian,String jshijian,String gongzuoid){
        String kehudaima = Shijilong.kehudaima;
        String sqlanjian = sqlhead+" where clct_date >= ? and clct_date <= ? and sender_cust_code in ('"+kehudaima+"')";
        for(Mail m:getMail(sqlanjian,kshijian,jshijian)){
                new Shijilong(m).jisuanbutie();
                m.update("特殊补贴",gongzuoid);
                //Thread.sleep(40);
            }
    }
    
    
    public static void wuyongfengbutie(String kshijian,String jshijian,String gongzuoid){
        String kehudaima = Wuyongfeng.kehudaima;
        String sqlanjian = sqlhead+" where clct_date >= ? and clct_date <= ? and sender_cust_code in ('"+kehudaima+"')";
        for(Mail m:getMail(sqlanjian,kshijian,jshijian)){
                new Wuyongfeng(m).jisuanbutie();
                m.update("特殊补贴",gongzuoid);
                //Thread.sleep(40);
            }
    }
    
    public static void delikaxibutie(String kshijian,String jshijian,String gongzuoid){
        String kehudaima = Delikaxi.kehudaima;
        String sqlanjian = sqlhead+" where clct_date >= ? and clct_date <= ? and sender_cust_code in ('"+kehudaima+"')";
        for(Mail m:getMail(sqlanjian,kshijian,jshijian)){
                new Delikaxi(m).jisuanbutie();
                m.update("特殊补贴",gongzuoid);
                //Thread.sleep(40);
            }
    }
    
    public static void pengnuobutie(String kshijian,String jshijian,String gongzuoid){
        String kehudaima = Pengnuofangzhi.kehudaima;
        String sqlanjian = sqlhead+" where clct_date >= ? and clct_date <= ? and sender_cust_code in ('"+kehudaima+"')";
        for(Mail m:getMail(sqlanjian,kshijian,jshijian)){
                new Pengnuofangzhi(m).jisuanbutie();
                m.update("特殊补贴",gongzuoid);
                //Thread.sleep(40);
            }
    }
    
    public static void qinyubutie(String kshijian,String jshijian,String gongzuoid){
        String kehudaima = Qinyu.kehudaima;
        String sqlanjian = sqlhead+" where clct_date >= ? and clct_date <= ? and sender_cust_code in ('"+kehudaima+"')";
        for(Mail m:getMail(sqlanjian,kshijian,jshijian)){
                new Qinyu(m).jisuanbutie();
                m.update("特殊补贴",gongzuoid);
                //Thread.sleep(40);
            }
    }
    
    public static void yingyubutie(String kshijian,String jshijian,String gongzuoid){
        String kehudaima = Yingyu.kehudaima;
        String sqlanjian = sqlhead+" where clct_date >= ? and clct_date <= ? and sender_cust_code in ('"+kehudaima+"')";
        for(Mail m:getMail(sqlanjian,kshijian,jshijian)){
                new Yingyu(m).jisuanbutie();
                m.update("特殊补贴",gongzuoid);
                //Thread.sleep(40);
            }
    }
    
    public static void tejiafangzhibutie(String kshijian,String jshijian,String gongzuoid){
        String kehudaima = Tejiafangzhi.kehudaima;
        String sqlanjian = sqlhead+" where clct_date >= ? and clct_date <= ? and sender_cust_code in ('"+kehudaima+"')";
        for(Mail m:getMail(sqlanjian,kshijian,jshijian)){
                new Tejiafangzhi(m).jisuanbutie();
                m.update("特殊补贴",gongzuoid);
                //Thread.sleep(40);
            }
    }
    
}
