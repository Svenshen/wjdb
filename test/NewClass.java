
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrator
 */
public class NewClass {
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter(new File("c:\\10w.txt"));
                            String tou = "11";
                            String wei = "90";
                            String shuzi = "23050001";
                            int shu = Integer.valueOf(shuzi);
                            //int yuanshu = shu;
                            //List<Integer> shuzu = new ArrayList<Integer>();
                            for(int i = 0;i < 100000; i ++){
                                
                                String zhongjian = String.valueOf(shu);
                                int yanzheng =11-((Integer.valueOf(zhongjian.substring(0, 1))*8+Integer.valueOf(zhongjian.substring(1, 2))*6+
                                        Integer.valueOf(zhongjian.substring(2, 3))*4+Integer.valueOf(zhongjian.substring(3, 4))*2+
                                        Integer.valueOf(zhongjian.substring(4, 5))*3+Integer.valueOf(zhongjian.substring(5, 6))*5+
                                        Integer.valueOf(zhongjian.substring(6, 7))*9+Integer.valueOf(zhongjian.substring(7, 8))*7)%11);
                                if(yanzheng == 10){
                                    yanzheng = 0;
                                }else if(yanzheng == 11){
                                    yanzheng = 5;
                                }else if(yanzheng < 10){                                
                                }
                                String wanzheng = tou+zhongjian+yanzheng+wei;
                                System.out.println(wanzheng);
                                fw.write(wanzheng+"\r\n");
                                shu++;
        }
                            fw.close();
        
    }
}
