/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Beans.liangshou;

/**
 *
 * @author root
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//package Beans.liangshou;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//package Beans.liangshou;

import Beans.MyLog;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class Biaokuai {
    private String jigou;
    private String jiaoyima;
    private String shishou;
    private String yingshou;
    private String mailcount;
    //private static final String driver=MyLog.driver;
    public void setMailcount(String mailcount){
        this.mailcount = mailcount;
    }
    public void setJigou(String jigou){
        this.jigou = jigou;
    }
    public void setJiaoyima(String jiaoyima){
        this.jiaoyima = jiaoyima;
    }
    public void setShishou(String shishou){
        this.shishou = shishou;
    }
    public void setYingshou(String yingshou){
        this.yingshou = yingshou;
    }

    public String getJigou(){
        return jigou;
    }
    public String getJiaoyima(){
        return jiaoyima;
    }
    public String getShishou(){
        return shishou;
    }
    public String getYingshou(){
        return yingshou;
    }
    public String getMailcount(){
        return mailcount;
    }

    public Biaokuai(){
        
    }
    public Biaokuai(String jigou,String mailcount,String jiaoyima,String shishou,String yingshou){
        setJigou(jigou);
        setMailcount(mailcount);
        setJiaoyima(jiaoyima);
        setShishou(shishou);
        setYingshou(yingshou);
        //setYouhang(zhekou);
    }
    public ArrayList<Biaokuai> getBiaokuai(String kshijian,String jshijian){
        ArrayList<Biaokuai> al = new ArrayList();
        //format.setMinimumFractionDigits(2);// 设置小数位 
        try{
//                Class.forName(driver).newInstance();
                Connection conn = MyLog.getConn();
                //and substr(prod_code,3,1) = '1'
                String sqll = "select org_sname as name,count(mail_num) as mailcount,sum(actual_total_fee) as totalfee,sum(SHOULD_PAY_TOTAL_FEE) as shouldfee from WUJIANGMAIL where CLCT_DATE >= ? and CLCT_DATE <= ? and substr(prod_code,1,1) = '4'  and substr(prod_code,8,1) = '9' and shi in(select city from biaokuai_city) GROUP by org_sname order by org_sname";
                String sqltl = "select count(mail_num) as mailcount,sum(actual_total_fee) as totalfee,sum(SHOULD_PAY_TOTAL_FEE) as shouldfee from WUJIANGMAIL where CLCT_DATE >= ? and CLCT_DATE <= ? and substr(prod_code,1,1) = '4'  and substr(prod_code,8,1) = '9' and shi in(select city from biaokuai_city) ";
                
                String sql ="select org_sname as name,count(mail_num) as mailcount,sum(actual_total_fee) as totalfee,sum(SHOULD_PAY_TOTAL_FEE) as shouldfee from wujiangmail where clct_date>= ? and clct_date <= ? and jiaoyima = '410' and (shi like '%北京%' or shi like '%天津%' or shi like '%石家庄%' or shi like '%唐山%' or shi like '%保定%' or shi like '%廊坊%' or shi like '%沧州%' or shi like '%呼和浩特%' or shi like '%沈阳%' or shi like '%大连%' or shi like '%长春%' or shi like '%上海%' or shi like '%南京%' or shi like '%苏州%' or shi like '%无锡%' or shi like '%常州%' or shi like '%昆山%' or shi like '%南通%' or shi like '%太仓%' or shi like '%扬州%' or shi like '%吴江%' or shi like '%泰州%' or shi like '%常熟%' or shi like '%镇江%' or shi like '%张家港%' or shi like '%杭州%' or shi like '%宁波%' or shi like '%嘉兴%' or shi like '%湖州%' or shi like '%绍兴%' or shi like '%金华%' or shi like '%义乌%' or shi like '%合肥%' or shi like '%芜湖%' or shi like '%福州%' or shi like '%厦门%' or shi like '%莆田%' or shi like '%泉州%' or shi like '%济南%' or shi like '%青岛%' or shi like '%淄博%' or shi like '%烟台%' or shi like '%潍坊%' or shi like '%济宁%' or shi like '%郑州%' or shi like '%武汉%' or shi like '%长沙%' or shi like '%广州%' or shi like '%深圳%' or shi like '%珠海%' or shi like '%东莞%' or shi like '%中山%' or shi like '%江门%' or shi like '%佛山%' or shi like '%成都%' or shi like '%西安%' or shi like '%太原%' or shi like '%南昌%' or shi like '%南宁%' or shi like '%重庆%' or shi like '%昆明%' or shi like '%兰州%')  GROUP by org_sname order by org_sname";
                String sqlt ="select count(mail_num) as mailcount,sum(actual_total_fee) as totalfee,sum(SHOULD_PAY_TOTAL_FEE) as shouldfee from wujiangmail where clct_date>= ? and clct_date <= ? and iaoyima = '410' and (shi like '%北京%' or shi like '%天津%' or shi like '%石家庄%' or shi like '%唐山%' or shi like '%保定%' or shi like '%廊坊%' or shi like '%沧州%' or shi like '%呼和浩特%' or shi like '%沈阳%' or shi like '%大连%' or shi like '%长春%' or shi like '%上海%' or shi like '%南京%' or shi like '%苏州%' or shi like '%无锡%' or shi like '%常州%' or shi like '%昆山%' or shi like '%南通%' or shi like '%太仓%' or shi like '%扬州%' or shi like '%吴江%' or shi like '%泰州%' or shi like '%常熟%' or shi like '%镇江%' or shi like '%张家港%' or shi like '%杭州%' or shi like '%宁波%' or shi like '%嘉兴%' or shi like '%湖州%' or shi like '%绍兴%' or shi like '%金华%' or shi like '%义乌%' or shi like '%合肥%' or shi like '%芜湖%' or shi like '%福州%' or shi like '%厦门%' or shi like '%莆田%' or shi like '%泉州%' or shi like '%济南%' or shi like '%青岛%' or shi like '%淄博%' or shi like '%烟台%' or shi like '%潍坊%' or shi like '%济宁%' or shi like '%郑州%' or shi like '%武汉%' or shi like '%长沙%' or shi like '%广州%' or shi like '%深圳%' or shi like '%珠海%' or shi like '%东莞%' or shi like '%中山%' or shi like '%江门%' or shi like '%佛山%' or shi like '%成都%' or shi like '%西安%' or shi like '%太原%' or shi like '%南昌%' or shi like '%南宁%' or shi like '%重庆%' or shi like '%昆明%' or shi like '%兰州%') ";
                String sql2 = "select shi as name,count(mail_num) as mailcount,sum(actual_total_fee) as totalfee,sum(SHOULD_PAY_TOTAL_FEE) as shouldfee from WUJIANGMAIL where CLCT_DATE >= ? and CLCT_DATE <= ? and substr(prod_code,1,1) = '4'  and substr(prod_code,8,1) = '9' and shi in(select city from biaokuai_city) GROUP by shi ";
                String sqlt2 = "select count(mail_num) as mailcount,sum(actual_total_fee) as totalfee,sum(SHOULD_PAY_TOTAL_FEE) as shouldfee from WUJIANGMAIL where CLCT_DATE >= ? and CLCT_DATE <= ? and substr(prod_code,1,1) = '4' and substr(prod_code,8,1) = '9' and shi in(select city from biaokuai_city) ";
                
                PreparedStatement pstmt = conn.prepareStatement(sql);
                //System.out.println(request.getParameter("kshijian").replace("-", ""));
                pstmt.setString(1, kshijian);
                pstmt.setString(2, jshijian);
                ResultSet rs =pstmt.executeQuery();
                
                while(rs.next()){
                    Biaokuai z = new Biaokuai(rs.getString("name"),rs.getString("mailcount"),"标快",rs.getString("totalfee"),rs.getString("shouldfee"));
                    
                        //z.setYouhang("错误");
                    
                        //z.setYouhang(String.valueOf(format.format(rs.getDouble("totalfee")/rs.getDouble("shouldfee"))));
                    
                    al.add(z);
                    //al.add(t);
                    //out.println("<tr><td>"+rs.getString("name")+"</td>");
                    //out.println("<td>"+rs.getString("mailcount")+"</td>");
                    //out.println("<td>"+rs.getString("fee")+"</td></tr>");
                    //out.println("<tr><td>:</td><td>"+rs.getString(4)+"</td></tr>");
                               }
                rs.close();
                pstmt.close();
                
                pstmt = conn.prepareStatement(sqlt);
                pstmt.setString(1, kshijian);
                pstmt.setString(2, jshijian);
                rs = pstmt.executeQuery();
                while(rs.next()){
                    Biaokuai z = new Biaokuai("合计",rs.getString("mailcount"),"标快",rs.getString("totalfee"),rs.getString("shouldfee"));
                    
                    //if("0".equals(rs.getString("shouldfee"))){
                        //z.setYouhang("错误");
                    //}else{
                        //z.setYouhang(String.valueOf(format.format(rs.getDouble("totalfee")/rs.getDouble("shouldfee"))));
                    //}
                    al.add(z);
                    //out.println("<tr><td>合计</td>");
                    //out.println("<td>"+rs.getString("mailcount")+"</td>");
                    //out.println("<td>"+rs.getString("fee")+"</td></tr>");
                }
                rs.close();
                pstmt.close();
                MyLog.close(conn);
        }catch(SQLException sqle){
            sqle.printStackTrace();
            MyLog.logtooracle(jigou, sqle);
        }catch(ClassNotFoundException cnfe){
            cnfe.printStackTrace();
            MyLog.logtooracle(jigou, cnfe);
        }catch(InstantiationException ie ){
            ie.printStackTrace();
            MyLog.logtooracle(jigou, ie);
        }catch(IllegalAccessException iae){
            iae.printStackTrace();
            MyLog.logtooracle(jigou, iae);
        }
        return al;
    }
    public ArrayList<Biaokuai> getBiaokuaibyshi(String kshijian,String jshijian){
        ArrayList<Biaokuai> al = new ArrayList();
        //format.setMinimumFractionDigits(2);// 设置小数位 
        try{
//                Class.forName(driver).newInstance();
                Connection conn = MyLog.getConn();
                //String sql = "select org_sname as name,count(mail_num) as mailcount,sum(actual_total_fee) as totalfee,sum(SHOULD_PAY_TOTAL_FEE) as shouldfee from WUJIANGMAIL where CLCT_DATE >= ? and CLCT_DATE <= ? and substr(prod_code,1,1) = '4' and substr(prod_code,3,1) = '1' and substr(prod_code,8,1) = '9' and shi in(select city from biaokuai_city) GROUP by org_sname order by org_sname";
                //String sqlt = "select count(mail_num) as mailcount,sum(actual_total_fee) as totalfee,sum(SHOULD_PAY_TOTAL_FEE) as shouldfee from WUJIANGMAIL where CLCT_DATE >= ? and CLCT_DATE <= ? and substr(prod_code,1,1) = '4' and substr(prod_code,3,1) = '1' and substr(prod_code,8,1) = '9' and shi in(select city from biaokuai_city) ";
                //and substr(prod_code,3,1) = '1'
                String sqll = "select shi as name,count(mail_num) as mailcount,sum(actual_total_fee) as totalfee,sum(SHOULD_PAY_TOTAL_FEE) as shouldfee from WUJIANGMAIL where CLCT_DATE >= ? and CLCT_DATE <= ? and substr(prod_code,1,1) = '4'  and substr(prod_code,8,1) = '9' and shi in(select city from biaokuai_city) GROUP by shi ";
                String sqltl = "select count(mail_num) as mailcount,sum(actual_total_fee) as totalfee,sum(SHOULD_PAY_TOTAL_FEE) as shouldfee from WUJIANGMAIL where CLCT_DATE >= ? and CLCT_DATE <= ? and substr(prod_code,1,1) = '4'  and substr(prod_code,8,1) = '9' and shi in(select city from biaokuai_city) ";
                
                
                String sql ="select shi as name,count(mail_num) as mailcount,sum(actual_total_fee) as totalfee,sum(SHOULD_PAY_TOTAL_FEE) as shouldfee from wujiangmail where clct_date>= ? and clct_date <= ? and jiaoyima = '410' and (shi like '%北京%' or shi like '%天津%' or shi like '%石家庄%' or shi like '%唐山%' or shi like '%保定%' or shi like '%廊坊%' or shi like '%沧州%' or shi like '%呼和浩特%' or shi like '%沈阳%' or shi like '%大连%' or shi like '%长春%' or shi like '%上海%' or shi like '%南京%' or shi like '%苏州%' or shi like '%无锡%' or shi like '%常州%' or shi like '%昆山%' or shi like '%南通%' or shi like '%太仓%' or shi like '%扬州%' or shi like '%吴江%' or shi like '%泰州%' or shi like '%常熟%' or shi like '%镇江%' or shi like '%张家港%' or shi like '%杭州%' or shi like '%宁波%' or shi like '%嘉兴%' or shi like '%湖州%' or shi like '%绍兴%' or shi like '%金华%' or shi like '%义乌%' or shi like '%合肥%' or shi like '%芜湖%' or shi like '%福州%' or shi like '%厦门%' or shi like '%莆田%' or shi like '%泉州%' or shi like '%济南%' or shi like '%青岛%' or shi like '%淄博%' or shi like '%烟台%' or shi like '%潍坊%' or shi like '%济宁%' or shi like '%郑州%' or shi like '%武汉%' or shi like '%长沙%' or shi like '%广州%' or shi like '%深圳%' or shi like '%珠海%' or shi like '%东莞%' or shi like '%中山%' or shi like '%江门%' or shi like '%佛山%' or shi like '%成都%' or shi like '%西安%' or shi like '%太原%' or shi like '%南昌%' or shi like '%南宁%' or shi like '%重庆%' or shi like '%昆明%' or shi like '%兰州%')  GROUP by shi";
                String sqlt ="select count(mail_num) as mailcount,sum(actual_total_fee) as totalfee,sum(SHOULD_PAY_TOTAL_FEE) as shouldfee from wujiangmail where clct_date>= ? and clct_date <= ? and jiaoyima = '410' and (shi like '%北京%' or shi like '%天津%' or shi like '%石家庄%' or shi like '%唐山%' or shi like '%保定%' or shi like '%廊坊%' or shi like '%沧州%' or shi like '%呼和浩特%' or shi like '%沈阳%' or shi like '%大连%' or shi like '%长春%' or shi like '%上海%' or shi like '%南京%' or shi like '%苏州%' or shi like '%无锡%' or shi like '%常州%' or shi like '%昆山%' or shi like '%南通%' or shi like '%太仓%' or shi like '%扬州%' or shi like '%吴江%' or shi like '%泰州%' or shi like '%常熟%' or shi like '%镇江%' or shi like '%张家港%' or shi like '%杭州%' or shi like '%宁波%' or shi like '%嘉兴%' or shi like '%湖州%' or shi like '%绍兴%' or shi like '%金华%' or shi like '%义乌%' or shi like '%合肥%' or shi like '%芜湖%' or shi like '%福州%' or shi like '%厦门%' or shi like '%莆田%' or shi like '%泉州%' or shi like '%济南%' or shi like '%青岛%' or shi like '%淄博%' or shi like '%烟台%' or shi like '%潍坊%' or shi like '%济宁%' or shi like '%郑州%' or shi like '%武汉%' or shi like '%长沙%' or shi like '%广州%' or shi like '%深圳%' or shi like '%珠海%' or shi like '%东莞%' or shi like '%中山%' or shi like '%江门%' or shi like '%佛山%' or shi like '%成都%' or shi like '%西安%' or shi like '%太原%' or shi like '%南昌%' or shi like '%南宁%' or shi like '%重庆%' or shi like '%昆明%' or shi like '%兰州%') ";

                PreparedStatement pstmt = conn.prepareStatement(sql);
                //System.out.println(request.getParameter("kshijian").replace("-", ""));
                pstmt.setString(1, kshijian);
                pstmt.setString(2, jshijian);
                ResultSet rs =pstmt.executeQuery();
                
                while(rs.next()){
                    Biaokuai z = new Biaokuai(rs.getString("name"),rs.getString("mailcount"),"标快",rs.getString("totalfee"),rs.getString("shouldfee"));
                    
                        //z.setYouhang("错误");
                    
                        //z.setYouhang(String.valueOf(format.format(rs.getDouble("totalfee")/rs.getDouble("shouldfee"))));
                    
                    al.add(z);
                    //al.add(t);
                    //out.println("<tr><td>"+rs.getString("name")+"</td>");
                    //out.println("<td>"+rs.getString("mailcount")+"</td>");
                    //out.println("<td>"+rs.getString("fee")+"</td></tr>");
                    //out.println("<tr><td>:</td><td>"+rs.getString(4)+"</td></tr>");
                               }
                rs.close();
                pstmt.close();
                
                pstmt = conn.prepareStatement(sqlt);
                pstmt.setString(1, kshijian);
                pstmt.setString(2, jshijian);
                rs = pstmt.executeQuery();
                while(rs.next()){
                    Biaokuai z = new Biaokuai("合计",rs.getString("mailcount"),"标快",rs.getString("totalfee"),rs.getString("shouldfee"));
                    //if("0".equals(rs.getString("shouldfee"))){
                        //z.setYouhang("错误");
                    //}else{
                        //z.setYouhang(String.valueOf(format.format(rs.getDouble("totalfee")/rs.getDouble("shouldfee"))));
                    //}
                    al.add(z);
                    //out.println("<tr><td>合计</td>");
                    //out.println("<td>"+rs.getString("mailcount")+"</td>");
                    //out.println("<td>"+rs.getString("fee")+"</td></tr>");
                }
                rs.close();
                pstmt.close();
                MyLog.close(conn);
        }catch(SQLException sqle){
            sqle.printStackTrace();
            MyLog.logtooracle(jigou, sqle);
        }catch(ClassNotFoundException cnfe){
            cnfe.printStackTrace();
            MyLog.logtooracle(jigou, cnfe);
        }catch(InstantiationException ie ){
            ie.printStackTrace();
            MyLog.logtooracle(jigou, ie);
        }catch(IllegalAccessException iae){
            iae.printStackTrace();
            MyLog.logtooracle(jigou, iae);
        }
        return al;
    }
}
