/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Beans.Sunyi2.Guoji;

import Beans.MyLog;

import Beans.Sunyi2.Guonei.Luxiang;
import Beans.Sunyi2.Mail;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Administrator
 */
public class Guoji extends Mail{

    double quneizhuantangfei;
    double bendichulizhongxinfei;
    double huhuanjuchulifei;
    double yanguanfei;
    double jingzhuanjuchulifei;
    double yiganfeiyong;
    double guojihangkongfei;
    double guojizhongduanfei;
    double tntzhongduanfei;
    String id;
    public Guoji(){
        super();
    }
    
    public Guoji(String mailno){
        super.setMailno(mailno);
    }
    
    public Guoji(String id,String mailno, String shoujiriqi, String jigoudaima, String jigoumingcheng, String kehudaima, String kehumingcheng, String chanpin,String chanpinfenlei, double youjianzhongliang, double xitongzifei, String jidadidaima, String jidasheng, String jidashi) {
        //
        //super(mailno, shoujiriqi, jigoudaima, jigoumingcheng, kehudaima, kehumingcheng, chanpin, youjianzhongliang, shishoufeiyong,new Luxiang().getYiganluxiang(mailno, jidashi),  jidadidaima, jidasheng, jidashi);
       super(mailno, shoujiriqi, jigoudaima, jigoumingcheng, kehudaima, kehumingcheng, chanpin,chanpinfenlei, youjianzhongliang, xitongzifei,"",  jidadidaima, jidasheng, jidashi);
       this.id = id;
    }
    
    @Override
    public void update() {
         String sqli = "insert into guojisunyibiao values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
         String sqls = "select * from guojisunyibiao where youjianhao = ? and gongzuoid = ?";
         String sqld = "delete from guojisunyibiao where youjianhao = ? and gongzuoid = ?";
        try{
            
            Connection conn = MyLog.getConn();
            PreparedStatement pstmts = conn.prepareStatement(sqls);
            pstmts.setString(1, this.getMialno());
            pstmts.setString(2, id);
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
            //pstmt.setString(12, "0");
            pstmt.setString(12, String.valueOf(this.getIswenjian()));
            
            pstmt.setString(13, this.getJidadidaima());
            pstmt.setString(14, this.getJidasheng());
            pstmt.setString(15, this.getJidashi());
            pstmt.setString(16, String.valueOf(this.quneizhuantangfei));
            pstmt.setString(17, String.valueOf(this.bendichulizhongxinfei));
            pstmt.setString(18, String.valueOf(this.huhuanjuchulifei));
            pstmt.setString(19, String.valueOf(this.yanguanfei));
            pstmt.setString(20, String.valueOf(this.jingzhuanjuchulifei));
            pstmt.setString(21, String.valueOf(this.yiganfeiyong));
            pstmt.setString(22, String.valueOf(this.guojihangkongfei));
            pstmt.setString(23, String.valueOf(this.guojizhongduanfei));
            pstmt.setString(24, String.valueOf(this.tntzhongduanfei));
            pstmt.setString(25, id);
            pstmt.executeUpdate();
            pstmt.close();
            MyLog.close(conn);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void jisuan() {
        Quneizhuantangfei qunei = new Quneizhuantangfei(this);
        Bendichulifei bendi = new Bendichulifei(this);
        Huhuanjuchulifei huhuanju = new Huhuanjuchulifei(this);
        Yanguanfei yanguan = new Yanguanfei(this);
        Jingzhuanjuchulifei jingzhuanchulifei = new Jingzhuanjuchulifei(this);
        Yiganfeiyong yigan = new Yiganfeiyong(this);
        Guojihangkongfei guojihangkong = new Guojihangkongfei(this);
        Guojizhongduanfei guojizhongduan = new Guojizhongduanfei(this);
        this.quneizhuantangfei = qunei.getFeiyong();
        this.bendichulizhongxinfei = bendi.getFeiyong();
        this.huhuanjuchulifei = huhuanju.getFeiyong();
        this.yanguanfei= yanguan.getFeiyong();
        this.jingzhuanjuchulifei = jingzhuanchulifei.getFeiyong();
        this.yiganfeiyong = yigan.getFeiyong();
        this.guojihangkongfei = guojihangkong.getFeiyong();
        switch(this.getChanpinfenlei2()){
            case "国际中速TNT":
            case "国际中速DHL":   
            case "国际中速佐川":
                this.tntzhongduanfei = guojizhongduan.getFeiyong();
                this.guojizhongduanfei = 0.0;
                break;
            default:
                this.guojizhongduanfei = guojizhongduan.getFeiyong();
                this.tntzhongduanfei = 0.0;
                break;
        }
        
    }
    
}
