/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Beans.Sunyi2.Guonei;

import Beans.Sunyi2.Guonei.Yiganfeiyong;
import Beans.Sunyi2.Guonei.Shengjijingzhuanfei;
import Beans.Sunyi2.Guonei.Dancefei;
import Beans.Sunyi2.Guonei.Quneizhuantangfei;
import Beans.Sunyi2.Guonei.Jinkoushengshengneijingzhuan;
import Beans.Sunyi2.Guonei.Bendichulizhongxinfei;
import Beans.Sunyi2.Guonei.Erganyunfei;
import Beans.Sunyi2.Guonei.Jinkoushengerganfeiyong;
import Beans.Sunyi2.Guonei.Jijiangongzifei;
import Beans.Sunyi2.Guonei.Shengneichulijijingzhuanfei;
import Beans.Sunyi2.Guonei.Quanmingzhifei;
import Beans.Sunyi2.Guonei.Toudifei;
import Beans.MyLog;
import Beans.Sunyi2.Mail;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Administrator
 */
public class Guonei extends Mail{
    
    String id;
    double dancefei;
    double quneizhuantangfei;
    double bendichulizhongxinfei;
    double erganyunfei;
    double shengneichulifei;
    //double shengneijingzhuanfei;
    double shengjijingzhuanfei;
    double yiganyunfei;
    double jinkoushengshengneijingzhuanfei;
    double jinkoushengerganfeiyong;
    double toudifei;
    double jijiangongzifei;
    double quanmingzhilurufei;

    public Guonei(){
        super();
    }
    
    public Guonei(String mailno){
        super.setMailno(mailno);
    }
    
    public Guonei(String id,String mailno, String shoujiriqi, String jigoudaima, String jigoumingcheng, String kehudaima, String kehumingcheng, String chanpin,String chanpinfenlei, double youjianzhongliang, double xitongzifei, String jidadidaima, String jidasheng, String jidashi,String yunshufangshi) {
        //
        //super(mailno, shoujiriqi, jigoudaima, jigoumingcheng, kehudaima, kehumingcheng, chanpin, youjianzhongliang, shishoufeiyong,new Luxiang().getYiganluxiang(mailno, jidashi),  jidadidaima, jidasheng, jidashi);
        super(mailno, shoujiriqi, jigoudaima, jigoumingcheng, kehudaima, kehumingcheng, chanpin,chanpinfenlei, youjianzhongliang, xitongzifei,new Luxiang().getYiganluxiangbyshujuyuan(mailno, chanpinfenlei,jidashi),  jidadidaima, jidasheng, jidashi);
        
        super.setYunshufangshi(yunshufangshi);
        this.id = id;
    }

    void setDancefei(double dancefei){
        this.dancefei = dancefei;
    }
    void setQuneizhuantangfei(double quneizhuantangfei){
        this.quneizhuantangfei = quneizhuantangfei;
    }
    void setBendichulizhongxinfei(double bendichulizhongxinfei){
        this.bendichulizhongxinfei = bendichulizhongxinfei;
    }
    void setErganyunfei(double erganyunfei){
        this.erganyunfei = erganyunfei;
    }
    void setShengneichulifei(double shengneichulifei){
        this.shengneichulifei = shengneichulifei;
    }
    void setShengjijingzhuanfei(double shengjijingzhuanfei){
        this.shengjijingzhuanfei = shengjijingzhuanfei;
    }
    void setYiganyunfei(double yiganyunfei){
        this.yiganyunfei = yiganyunfei;
    }
    void setJinkoushengshengneijingzhuanfei(double jinkousheng){
        this.jinkoushengshengneijingzhuanfei = jinkousheng;
    }
    void setJinkoushengerganfei(double jinkoushengerganfei){
        this.jinkoushengerganfeiyong = jinkoushengerganfei;
    }
    void setToudifei(double toudifei){
        this.toudifei = toudifei;
    }
    void setJijiangongzifei(double jijiangongzifei){
        this.jijiangongzifei = jijiangongzifei;
    }
    void setQuanmingzhifei(double quanmingzhifei){
        this.quanmingzhilurufei = quanmingzhifei;
    }
    
    public double getDancefei(){
        return dancefei;
    }
    public double getQuneizhuantangfei(){
        return quneizhuantangfei ;
    }
    public double getBendichulizhongxinfei(){
        return bendichulizhongxinfei;
    }
    public double getErganyunfei(){
        return erganyunfei ;
    }
    public double getShengneichulifei(){
        return shengneichulifei ;
    }
    public double getShengjijingzhuanfei(){
        return shengjijingzhuanfei;
    }
    public double getYiganyunfei(){
        return yiganyunfei;
    }
    public double getJinkoushengshengneijingzhuanfei(){
        return jinkoushengshengneijingzhuanfei ;
    }
    public double getJinkoushengerganfei(){
        return jinkoushengerganfeiyong ;
    }
    public double getToudifei(){
        return toudifei;
    }
    public double getJijiangongzifei(){
        return jijiangongzifei ;
    }
    public double getQuanmingzhifei(){
        return quanmingzhilurufei ;
    }    
   
    
   
    
    
    
    @Override
    public void update() {
         String sqli = "insert into guoneisunyibiao values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
         String sqls = "select * from guoneisunyibiao where youjianhao = ? and gongzuoid = ?";
         String sqld = "delete from guoneisunyibiao where youjianhao = ? and gongzuoid = ?";
        try{
            
            Connection conn = MyLog.getConn();
            PreparedStatement pstmts = conn.prepareStatement(sqls);
            pstmts.setString(1, this.getMialno());
            pstmts.setString(2,id);
            ResultSet rs = pstmts.executeQuery();
            if(rs.next()){
                PreparedStatement pstmtd = conn.prepareStatement(sqld);
                pstmtd.setString(1, this.getMialno());
                pstmtd.setString(2, id);
                pstmtd.executeUpdate();
                pstmtd.close();
            }
            rs.close();
            pstmts.close();
            PreparedStatement pstmt = conn.prepareStatement(sqli);
            //System.out.println(request.getParameter("kshijian").replace("-", ""));
            pstmt.setString(1, this.getMialno());
            pstmt.setString(2, this.getShoujiriqi());
            pstmt.setString(3, this.getJigoudaima());
            pstmt.setString(4, this.getJigoumingcheng());
            pstmt.setString(5, this.getKehudaima());
            pstmt.setString(6, this.getKehumingcheng());
            pstmt.setString(7, this.getChanpin());
            pstmt.setString(8, this.getChanpinfenlei2());
            pstmt.setString(9, String.valueOf(this.getIsremin()));
            pstmt.setString(10, String.valueOf(this.getYoujianzhongliang()));
            pstmt.setString(11, String.valueOf(this.getXitongzifei()));
            
            pstmt.setString(12, String.valueOf(this.getIswenjian()));
            pstmt.setString(13, this.getYoujianluxiang());
            pstmt.setString(14, this.getJidadidaima());
            pstmt.setString(15, this.getJidasheng());
            pstmt.setString(16, this.getJidashi());
            pstmt.setString(17, String.valueOf(this.dancefei));
            pstmt.setString(18, String.valueOf(this.quneizhuantangfei));
            pstmt.setString(19, String.valueOf(this.bendichulizhongxinfei));
            pstmt.setString(20, String.valueOf(this.erganyunfei));
            pstmt.setString(21, String.valueOf(this.shengneichulifei));
            pstmt.setString(22, String.valueOf(this.shengjijingzhuanfei));
            pstmt.setString(23, String.valueOf(this.yiganyunfei));
            pstmt.setString(24, String.valueOf(this.jinkoushengshengneijingzhuanfei));
            pstmt.setString(25, String.valueOf(this.jinkoushengerganfeiyong));
            pstmt.setString(26, String.valueOf(this.toudifei));
           
            pstmt.setString(27, String.valueOf(this.jijiangongzifei));
            pstmt.setString(28, String.valueOf(this.quanmingzhilurufei));
            pstmt.setString(29,id);
            pstmt.executeUpdate();
            pstmt.close();
            MyLog.close(conn);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void jisuan() {
        Dancefei dcf = new Dancefei(this);
        Quneizhuantangfei qnztf = new Quneizhuantangfei(this);
        Bendichulizhongxinfei bdclzxf = new Bendichulizhongxinfei(this);
        Erganyunfei egyf = new Erganyunfei(this);
        Shengneichulijijingzhuanfei sncljzf = new Shengneichulijijingzhuanfei(this);
        Shengjijingzhuanfei sjjzf = new Shengjijingzhuanfei(this);
        Yiganfeiyong ygfy = new Yiganfeiyong(this);
        Jinkoushengshengneijingzhuan jkssnjz = new Jinkoushengshengneijingzhuan(this);
        Jinkoushengerganfeiyong jksegfy = new Jinkoushengerganfeiyong(this);
        Toudifei tdf = new Toudifei(this);
        Jijiangongzifei jjgzf = new Jijiangongzifei(this);
        Quanmingzhifei qmzf = new Quanmingzhifei(this);
        this.dancefei = dcf.getFeiyong();
        this.quneizhuantangfei = qnztf.getFeiyong();
        this.bendichulizhongxinfei = bdclzxf.getFeiyong();
        this.erganyunfei = egyf.getFeiyong();
        this.shengneichulifei = sncljzf.getFeiyong();
        this.shengjijingzhuanfei = sjjzf.getFeiyong();
        this.yiganyunfei = ygfy.getFeiyong();
        this.jinkoushengshengneijingzhuanfei = jkssnjz.getFeiyong();
        this.jinkoushengerganfeiyong = jksegfy.getFeiyong();
        this.toudifei = tdf.getFeiyong();
        this.jijiangongzifei = jjgzf.getFeiyong();
        this.quanmingzhilurufei = qmzf.getFeiyong();
        
        
        
    }
    
    
    
    
    
}
