/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Beans.Sunyi2.Web.Butie;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import Beans.Butie.Anshouxuzhong;
import Beans.MyLog;
import Beans.Sunyi2.Web.Sunyi.Guoneishujubyjigou;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */



public class Butie {
    public String gongzuoid;
    public String kshijian;
    public String jshijian;
    public String zhuangtai;
    String beizhu;
    public String leixing ;
    public Butie(){
        
    }
    public Butie(String gongzuoid,String kshijian,String jshijian,String leixing,String zhuangtai,String beizhu){
        this.gongzuoid = gongzuoid;
        this.kshijian = kshijian;
        this.jshijian = jshijian;
        this.zhuangtai = zhuangtai;
        this.beizhu = beizhu;
        this.leixing = leixing;
    }
    public static void main(String[] args) {
        Butie   g = new Butie();
        //System.out.println("11");
        g.delfanlibi("37");
        
        //g.addfanlibili("32058402415000", "10000.0", "50000.0", "410", "1", "0.2");
    }
    public void delyouban(String id){
        new Youbankehu().del(id);
    }
    public boolean delfanlibi(String id){
        return new Fanlikehu().delbili(id);
    }
    public boolean delanjiankehu(String id){
        return new Anjiankehu().del(id);
    }
    public boolean delzhongliangshuju(String id){
        return new Anshouxuzhongkehu().delshuju(id);
    }
    public boolean delZhekoushuju(String id){
        return new Anzhekoukehu().delshuju(id);
    }
    
    public void del(String id){
        String sql = "delete from  butie where gongzuoid = ? 	";
        String sql2 = "delete from butiegongzuo where gongzuoid = ?";
        //String sql = "select * from wujiangmail where mail_num in (SELECT COLUMN1 FROM TEMP )";
        //Chanpin chanpin = new Chanpin();
        try{
                Connection conn = MyLog.getConn();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, id);
                pstmt.executeUpdate();
                pstmt.close();
                pstmt = conn.prepareStatement(sql2);
                pstmt.setString(1, id);
                pstmt.executeUpdate();
                pstmt.close();
                MyLog.close(conn);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public ArrayList<Butieshuju> getmingxibyidjigou(String id,String jigoudaima){
        ArrayList<Butieshuju> list = new ArrayList();
        
        String sql = "select * from  butie where gongzuoid = ? and jigoudaima = ? 	";
        //String sql = "select * from wujiangmail where mail_num in (SELECT COLUMN1 FROM TEMP )";
        //Chanpin chanpin = new Chanpin();
        try{
                Connection conn = MyLog.getConn();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, id);
                pstmt.setString(2, jigoudaima);
                //System.out.println(request.getParameter("kshijian").replace("-", ""));
                
                ResultSet rs =pstmt.executeQuery();
                while(rs.next()){
                    list.add(new Butieshuju(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getString(14),rs.getString(15),rs.getString(16)));
                }
                rs.close();
                pstmt.close();
                MyLog.close(conn);
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
    
    
    public ArrayList<Butieshuju> getmingxibyid(String id){
        ArrayList<Butieshuju> list = new ArrayList();
        
        String sql = "select * from  butie where gongzuoid = ? 	and youjianhao in (select youjianhao from shoujixinxi ) ";
        //String sql = "select * from wujiangmail where mail_num in (SELECT COLUMN1 FROM TEMP )";
        //Chanpin chanpin = new Chanpin();
        try{
                Connection conn = MyLog.getConn();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, id);
                //System.out.println(request.getParameter("kshijian").replace("-", ""));
                
                ResultSet rs =pstmt.executeQuery();
                while(rs.next()){
                    list.add(new Butieshuju(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getString(14),rs.getString(15),rs.getString(16)));
                }
                rs.close();
                pstmt.close();
                MyLog.close(conn);
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
    //SELECT butiexinchouyoubankehu.kehudaima,kehuxinxi.kehumingcheng  FROM butiexinchouyoubankehu left join kehuxinxi on butiexinchouyoubankehu.kehudaima = kehuxinxi.kehudaima
    
    public ArrayList<Youbankehu> getYoubankehulist(){
        return new Youbankehu().getKehulist();
    }
    
    public ArrayList<Fanlikehu> getFanlikehulist(){
        return new Fanlikehu().getFanlikehulist();
    }
    public ArrayList<Anshouxuzhongkehu> getShouxuzhongkehulist(){
        return new Anshouxuzhongkehu().getKehu();
    }
    public ArrayList<Anshouxuzhongkehu> getshouxuzhongkehupeizhi(String kehu){
        return new Anshouxuzhongkehu().getkehupeizhi(kehu);
    }
    public ArrayList<Anzhekoukehu> getAnzhekoukehulist(){
        return new Anzhekoukehu().getKehu();
    }
    public ArrayList<Anzhekoukehu> getZhekoukehushuju(String kehu){
        return new Anzhekoukehu().getkehupeizhi(kehu);
    }
    public boolean addyoubankehu(String kehu){
        return new Youbankehu().add(kehu);
    }
    public boolean addfanlikehu(String kehu,String shourukaishi,String shourujieshu){
        return new Fanlikehu().addKehu(kehu, shourukaishi, shourujieshu);
    }
    public boolean addanjiankehu(String kehu,String jine){
        return new Anjiankehu().addkehu(kehu, jine);
        
    }
    public boolean addanzhongliangkehu(String kehudu){
        return new Anshouxuzhongkehu().addKehu(kehudu);
    }
    public boolean addZhekoukehu(String kehudu){
        return new Anzhekoukehu().addKehu(kehudu);
    }
    public boolean addZhekoujilu(String kehu,String jiaoyima,String jidasheng,String youjianleixing,String zhekou){
        boolean flag =true;
        if(null != youjianleixing)switch (youjianleixing) {
            case "1":
                //new Anzhekoukehu().addjilu(kehu, jiaoyima, jidasheng, youjianleixing, jidasheng, zhuangtai, leixing, zhuangtai);
                new Anzhekoukehu().addjilu(kehu, jiaoyima, jidasheng,  "物品", zhekou);
                new Anzhekoukehu().addjilu(kehu, jiaoyima, jidasheng,   "文件", zhekou);
                break;
            case "2":
                new Anzhekoukehu().addjilu(kehu, jiaoyima, jidasheng,   "文件", zhekou);
                break;
            case "3":
                new Anzhekoukehu().addjilu(kehu, jiaoyima, jidasheng,  "物品", zhekou);
                break;
        }
        
        return flag;
    }
    
    public boolean addzhongliangjilu(String kehu,String jiaoyima,String jidasheng,String youjianleixing,String shouzhong,String shouzhongdanjia,String xuzhong,String xuzhongdanjia){
        boolean flag =true;
        if(null != youjianleixing)switch (youjianleixing) {
            case "1":
                new Anshouxuzhongkehu().addjilu(kehu, jiaoyima, jidasheng,  "物品", shouzhong,shouzhongdanjia,xuzhong,xuzhongdanjia);
                new Anshouxuzhongkehu().addjilu(kehu, jiaoyima, jidasheng,   "文件", shouzhong,shouzhongdanjia,xuzhong,xuzhongdanjia);
                break;
            case "2":
                new Anshouxuzhongkehu().addjilu(kehu, jiaoyima, jidasheng,   "文件", shouzhong,shouzhongdanjia,xuzhong,xuzhongdanjia);
                break;
            case "3":
                new Anshouxuzhongkehu().addjilu(kehu, jiaoyima, jidasheng,  "物品", shouzhong,shouzhongdanjia,xuzhong,xuzhongdanjia);
                break;
        }
        
        return flag;
    }
    public boolean addfanlibili(String kehu,String shouruqishi,String shourujieshu,String jiaoyima,String youjianleixing,String fanlibili){
        boolean flag =true;
        if(null != youjianleixing)switch (youjianleixing) {
            case "1":
                new Fanlikehu().addbili(kehu, shouruqishi, shourujieshu, jiaoyima, "物品", fanlibili);
                new Fanlikehu().addbili(kehu, shouruqishi, shourujieshu, jiaoyima, "文件", fanlibili);
                break;
            case "2":
                new Fanlikehu().addbili(kehu, shouruqishi, shourujieshu, jiaoyima, "文件", fanlibili);
                break;
            case "3":
                new Fanlikehu().addbili(kehu, shouruqishi, shourujieshu, jiaoyima, "物品", fanlibili);
                break;
        }
        
        return flag;
    }
    
    
    
    public ArrayList<Fanlikehu> getfanlibili(String kehu,String shouruqishi,String shourujieshu){
        return new Fanlikehu().getFanlikehubililist(kehu, shouruqishi, shourujieshu);
    }
    public ArrayList<Anjiankehu> getanjiankehulist(){
        return new Anjiankehu().getkehulist();
    }
    
    public ArrayList<Butieshuju> getshujubyjigou(String id){
        ArrayList<Butieshuju> list = new ArrayList();
   
        String sql = "SELECT jigoudaima,jigoumingcheng,count(*),sum (xitongzifei),sum(shishouzifei),sum(butiejine)   FROM butie where     gongzuoid = ?                 group by jigoudaima,jigoumingcheng";
        //String sql = "select * from wujiangmail where mail_num in (SELECT COLUMN1 FROM TEMP )";
        //Chanpin chanpin = new Chanpin();
        try{
                Connection conn = MyLog.getConn();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, id);
                //System.out.println(request.getParameter("kshijian").replace("-", ""));
                
                ResultSet rs =pstmt.executeQuery();
                while(rs.next()){
                    list.add(new Butieshuju(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)));
                }
                rs.close();
                pstmt.close();
                MyLog.close(conn);
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
    public ArrayList<Butie> getShujulist(){
        ArrayList<Butie> guonei = new ArrayList();
        
        int updatei = 0;
        
        String sql = "select * from  butiegongzuo";
        //String sql = "select * from wujiangmail where mail_num in (SELECT COLUMN1 FROM TEMP )";
        //Chanpin chanpin = new Chanpin();
        try{
                Connection conn = MyLog.getConn();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                
                //System.out.println(request.getParameter("kshijian").replace("-", ""));
                //pstmt.setString(1, leixing);
                ResultSet rs =pstmt.executeQuery();
                while(rs.next()){
                    guonei.add(new Butie(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)));
                }
                rs.close();
                pstmt.close();
                MyLog.close(conn);
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        return guonei;
    }

    public String getGongzuoid() {
        return gongzuoid;
    }

    public void setGongzuoid(String gongzuoid) {
        this.gongzuoid = gongzuoid;
    }

    public String getKshijian() {
        return kshijian;
    }

    public void setKshijian(String kshijian) {
        this.kshijian = kshijian;
    }

    public String getJshijian() {
        return jshijian;
    }

    public void setJshijian(String jshijian) {
        this.jshijian = jshijian;
    }

    public String getZhuangtai() {
        return zhuangtai;
    }

    public void setZhuangtai(String zhuangtai) {
        this.zhuangtai = zhuangtai;
    }

    public String getBeizhu() {
        return beizhu;
    }

    public void setBeizhu(String beizhu) {
        this.beizhu = beizhu;
    }

    public String getLeixing() {
        return leixing;
    }

    public void setLeixing(String leixing) {
        this.leixing = leixing;
    }
    
    
}

