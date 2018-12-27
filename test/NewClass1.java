
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrator
 */
public class NewClass1 {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader("c:\\40w.txt"));
        String mailno = br.readLine();
        while(mailno != null){
            if(yanzheng(mailno)){
                //System.out.println(mailno+"true");
            }else{
                System.out.println(mailno+"false");
            }
            mailno = br.readLine();
        }
    }
    public static boolean yanzheng(String mailno){
                        String tou = mailno.substring(0,2);
                            String wei = mailno.substring(11,13);
                            String shuzi = mailno.substring(2, 10);
                            int shu = Integer.valueOf(shuzi);
                            DecimalFormat df = new DecimalFormat("00000000");
                            //List<Integer> shuzu = new ArrayList<Integer>();
                            
                                
                                String zhongjian = df.format(shu);
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
                                if(wanzheng.equals(mailno)){
                                    return true;
                                }else{
                                    return false;
                                }
    }
    
}
