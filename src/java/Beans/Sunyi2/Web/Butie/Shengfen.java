/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Beans.Sunyi2.Web.Butie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Administrator
 */
public class Shengfen {
    int bianhao;
    String sheng;
    static ArrayList<Shengfen> shengfenlist = new ArrayList(){
        {
            
            add(new Shengfen(1,"安徽省"));
            add(new Shengfen(2,"北京"));
            add(new Shengfen(3,"福建省"));
            add(new Shengfen(4,"甘肃省"));
            add(new Shengfen(5,"广东省"));
            add(new Shengfen(6,"广西壮族自治区"));
            add(new Shengfen(7,"贵州省"));
            add(new Shengfen(8,"海南省"));
            add(new Shengfen(9,"河北省"));
            add(new Shengfen(10,"河南省"));
            add(new Shengfen(11,"黑龙江省"));
            add(new Shengfen(12,"湖北省"));
            add(new Shengfen(13,"湖南省"));
            add(new Shengfen(14,"吉林省"));
            add(new Shengfen(15,"江苏省"));
            add(new Shengfen(16,"江西省"));
            add(new Shengfen(17,"辽宁省"));
            add(new Shengfen(18,"内蒙古自治区"));
            add(new Shengfen(19,"宁夏回族自治区"));
            add(new Shengfen(20,"青海省"));
            add(new Shengfen(21,"山东省"));
            add(new Shengfen(22,"山西省"));
            add(new Shengfen(23,"陕西省"));
            add(new Shengfen(24,"上海"));
            add(new Shengfen(25,"四川省"));
            add(new Shengfen(26,"天津"));
            add(new Shengfen(27,"西藏自治区"));
            add(new Shengfen(28,"新疆维吾尔自治区"));
            add(new Shengfen(29,"云南省"));
            add(new Shengfen(30,"浙江省"));
            add(new Shengfen(31,"重庆"));
        }
    };

    public static  ArrayList<Shengfen> getShengfenlist() {
        return shengfenlist;
        
        
    }

    public Shengfen(int bianhao, String sheng) {
        this.bianhao = bianhao;
        this.sheng = sheng;
    }

    
            
    
    
    
    public int getBianhao() {
        return bianhao;
    }

    public void setBianhao(int bianhao) {
        this.bianhao = bianhao;
    }

    public String getSheng() {
        return sheng;
    }

    public void setSheng(String sheng) {
        this.sheng = sheng;
    }
    
}
