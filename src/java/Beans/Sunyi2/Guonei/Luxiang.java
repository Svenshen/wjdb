/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Beans.Sunyi2.Guonei;

import Beans.MyLog;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;

/**
 *
 * @author Administrator
 */
public class Luxiang {
    //
    String erganluxiang;
    String yiganluxiang;
    
    
    String youludaima;
    String fengfagekou;
    
    
    static HashMap<String,Luxiang> shujuyuan = new HashMap<String,Luxiang>();
    final static HashMap<String,String> youlu = new HashMap<String,String>(){
        {
            put("1321521915","上海");
            put("2321521085","无锡");//吴江无锡吴邮速③
            put("2321528001","无锡");//吴江无锡吴标速1
            put("2321529001","南京");
            put("2321529003","南京");
            put("2321529007","无锡");
            put("2321529055","无锡");//吴江无锡吴锡速②
            put("2321529065","无锡");
            put("2321529075","无锡");//吴江无锡吴锡速④
            put("2321529085","无锡");//吴江无锡吴锡速③
    
            
            put("3321509040","经济航空");//经济航空
            put("3321509095","苏州");//华扬
            put("3321529002","苏州");
            put("3321529004","苏州");
            put("3321529005","苏州");//国际
            put("2321529005","南京");//民航
            put("1321521105","直发-");
            put("1321526005","直发-");
            put("1321526015","直发-");
            put("1321526025","直发-");
            put("1321526035","直发-");
            put("1321526045","直发-");
            put("1321526055","直发-");
            put("1321526065","直发-");
            put("1321526075","直发-");
            put("1321526085","直发-");
            put("1321526095","直发-");
            
            
            
           // put("4321529999","少件邮路");
        }
    };
    
    public Luxiang(){
        
    }
    
    public Luxiang(String mailno,String youludaima,String fengfagekou){
        this.youludaima = youludaima.trim();
        this.fengfagekou = fengfagekou.trim();
        //System.out.println(this.fengfagekou);
    }
    
    public Luxiang(String kshijian,String jshijian){
        String luxiang = "";
        String  sql = "select * from TB_EVT_BAG_MAIL_RELA a left join TB_EVT_ROUTE_BAG_RELA b on a.LABEL_STRIP = b.LABEL_STRIP where  a.MAIL_NUM in (select mail_num from wujiangmail where clct_date >= ? and clct_date <= ?) and a.BAG_ACTN_CODE = '3'   and b.ROUTE_CRT_ORG_CODE = '21520000' and b.ROUTE_ACTN_CODE = 'S' and b.MWAY_CODE != '4321529999'";
        try{
            
            Connection conn = MyLog.getConn();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            //System.out.println(request.getParameter("kshijian").replace("-", ""));
            pstmt.setString(1, kshijian);
            pstmt.setString(2, jshijian);
            ResultSet rs =pstmt.executeQuery();
            
            while(rs.next()){
                //Luxiang l = new Luxiang();
                if(!shujuyuan.containsKey(rs.getString("mail_num"))){
                    shujuyuan.put(rs.getString("mail_num"),new Luxiang(rs.getString("mail_num"),rs.getString("MWAY_CODE"),rs.getString("dlv_org_code")));
                }
                
                
            }
            rs.close();
            pstmt.close();
            MyLog.close(conn);
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
    }
    
    
    
    
    private void setYiganluxiang(String yiganluxiang){
        this.yiganluxiang = yiganluxiang;
    }
    private void setErganluxiang(String erganluxiang){
        this.erganluxiang = erganluxiang;
    }
    public String getYiganluxiang(){
        return yiganluxiang;
    }
    public String getErganluxiang(){
        return erganluxiang;
    }
    
    
    
    //民航、南集、无锡、上海、经济航空、苏州

    
    public  String getYiganluxiangbyshujuyuan(String mailno,String chanpinfenlei,String shi){
        String luxiang = "";
        if(shujuyuan.get(mailno) != null){
            if("21112100".equals(shujuyuan.get(mailno).fengfagekou)){
                luxiang = "南集";
            }else{
                if(youlu.get(shujuyuan.get(mailno).youludaima) == null){
                    luxiang = "未知";
                }else{
                    switch((youlu.get(shujuyuan.get(mailno).youludaima))){
                            case "苏州":
                                if(shi.contains("苏州")){
                                    luxiang = "苏州";
                                }else{
                                    if("快包".equals(chanpinfenlei)){
                                        luxiang = "经济航空";
                                    }else{
                                        luxiang = "民航";
                                    }
                                }
                                break;
                            case "上海":
                                luxiang = "上海";
                                break;
                            case "经济航空":
                                luxiang = "经济航空";
                                break;
                            case "南京":
                                if("21112100".equals(shujuyuan.get(mailno).fengfagekou)){
                                    luxiang = "南集";
                                }else{
                                    luxiang = "民航";
                                }
                                break;
                            case "无锡":
                                luxiang = "无锡";
                                break;
                            case "直发-":
                                luxiang = "直发-";
                                break;

                            default:
                                luxiang = "未知";
                                break;
                    }
                }
            }
        }else{
            luxiang = "未知";
        }
        
        return luxiang;
    }
        //民航、南集、无锡、上海、经济航空、苏州
    public String getYiganluxiang(String mailno,String shi){
        String luxiang = "";
        String  sql = "select * from TB_EVT_BAG_MAIL_RELA a left join TB_EVT_ROUTE_BAG_RELA b on a.LABEL_STRIP = b.LABEL_STRIP where  a.MAIL_NUM = ? and a.BAG_ACTN_CODE = '3'  and b.ROUTE_CRT_ORG_CODE = '21520000' and b.ROUTE_ACTN_CODE = 'S' and b.MWAY_CODE != '4321529999'";
        try{
            
            Connection conn = MyLog.getConn();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            //System.out.println(request.getParameter("kshijian").replace("-", ""));
            pstmt.setString(1, mailno);
            ResultSet rs =pstmt.executeQuery();
            if(rs.next()){
                switch(youlu.get(rs.getString("MWAY_CODE"))){
                    case "苏州":
                        if(shi.contains("苏州")){
                            luxiang = "苏州";
                        }else{
                            luxiang = "民航";
                        }
                        break;
                    case "上海":
                        luxiang = "上海";
                        break;
                    case "经济航空":
                        luxiang = "经济航空";
                        break;
                    case "南京":
                        if("21112100".equals(rs.getString("dlv_org_code"))){
                            luxiang = "南集";
                        }else{
                            luxiang = "民航";
                        }
                        break;
                    case "无锡":
                        luxiang = "无锡";
                        break;
                    case "直发-":
                        luxiang = "直发-";
                        break;
                    default:
                        luxiang = "未知";
                        break;
                }
            }else{
                luxiang = "未知";
            }
            rs.close();
            pstmt.close();
            MyLog.close(conn);
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return luxiang;
    }
}
