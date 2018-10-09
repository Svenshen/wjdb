/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans.tiaozhang;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/**
 *
 * @author Administrator
 */
public class chehui extends HttpServlet {
    public  String decode(String unicodeStr) {  
    if (unicodeStr == null) {  
        return null;  
    }  
    StringBuffer retBuf = new StringBuffer();  
    int maxLoop = unicodeStr.length();  
    for (int i = 0; i < maxLoop; i++) {  
        if (unicodeStr.charAt(i) == '\\') {  
            if ((i < maxLoop - 5)  
                    && ((unicodeStr.charAt(i + 1) == 'u') || (unicodeStr  
                            .charAt(i + 1) == 'U')))  
                try {  
                    retBuf.append((char) Integer.parseInt(  
                            unicodeStr.substring(i + 2, i + 6), 16));  
                    i += 5;  
                } catch (NumberFormatException localNumberFormatException) {  
                    retBuf.append(unicodeStr.charAt(i));  
                }  
            else  
                retBuf.append(unicodeStr.charAt(i));  
        } else {  
            retBuf.append(unicodeStr.charAt(i));  
        }  
    }  
    return retBuf.toString();  
}  
    public String getorgname(String orgcode){
        String orgsname = "机构不存在";
        CloseableHttpAsyncClient httpclient = HttpAsyncClients.createSystem();
        try{
        
           httpclient.start();
           //http://10.1.200.248/sjhz/dwr/plaincall/ajaxservice.getOrgName.dwr
           //http://10.1.200.248/sjhz/dwr/plaincall/ajaxservice.getOrgName.dwr
           HttpPost post1;
           if(flag){
             post1= new HttpPost("http://10.1.200.248/sjhz/dwr/exec/ajaxservice.getOrgName.dwr");
           }else{
               post1 = new HttpPost("http://10.1.200.248/sjhz/dwr/plaincall/ajaxservice.getOrgName.dwr");
           }
//post1.setHeader("Host", "10.1.200.248");
            //post1.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.101 Safari/537.36");
            //post1.setHeader("Referer", "http://10.1.200.248/sjhz/");
            //post1.setHeader("Host", "10.1.200.248");
             List <NameValuePair> nvps1 = new ArrayList <NameValuePair>();
           if(flag){
                nvps1.add(new BasicNameValuePair("callCount", "1"));
                //nvps1.add(new BasicNameValuePair("httpSessionId","0"));
                //nvps1.add(new BasicNameValuePair("scriptSessionId", "0"));
       
               // nvps1.add(new BasicNameValuePair("page","/sjhz/"));
                nvps1.add(new BasicNameValuePair("c0-scriptName", "ajaxservice"));
                nvps1.add(new BasicNameValuePair("c0-methodName", "getOrgName"));
                
                nvps1.add(new BasicNameValuePair("c0-id", "0"));
                nvps1.add(new BasicNameValuePair("c0-param0", "string:"+orgcode));   //参数1
                nvps1.add(new BasicNameValuePair("xml", "true"));
           }else{
               nvps1.add(new BasicNameValuePair("callCount", "1"));
                nvps1.add(new BasicNameValuePair("httpSessionId","0"));
                nvps1.add(new BasicNameValuePair("scriptSessionId", "0"));
       
                nvps1.add(new BasicNameValuePair("page","/sjhz/"));
                nvps1.add(new BasicNameValuePair("c0-scriptName", "ajaxservice"));
                nvps1.add(new BasicNameValuePair("c0-methodName", "getOrgName"));
                
                nvps1.add(new BasicNameValuePair("c0-id", "0"));
                nvps1.add(new BasicNameValuePair("c0-param0", "string:"+orgcode));   //参数1
                //nvps1.add(new BasicNameValuePair("xml", "true"));
           }

           post1.setEntity(new UrlEncodedFormEntity(nvps1, "GBK"));
            Future<HttpResponse> future1 = httpclient.execute(post1, null);
            HttpResponse response1 = future1.get();
            String str = EntityUtils.toString(response1.getEntity());
            System.out.println(str);
            orgsname =  decode(str.split("var s0=\"")[1].split("\"")[0]);
            if("".equals(orgsname)){
                orgsname = "机构不存在";
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try {
                httpclient.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        
            return orgsname;
    }
    public static void main(String[] args) {
        chehui c = new chehui();
        chehuidenglu b = new chehuidenglu();
        System.out.println(c.getorgname("21522303"));
System.out.println(c.getusername("21522303","HS02"));
System.out.println(b.denglu("21522303", "HS04",  "吴江横扇分部", "申保健", "01","hs63399778"));
//System.out.println(c.tiaozhang("sdyglx=1; sduserid=HS04; sdusername=%C9%EA%B1%A3%BD%A8; sdorgcode=21522303; sdorgname=%CE%E2%BD%AD%BA%E1%C9%C8%B7%D6%B2%BF; sdtx=01; cod=1.3.9; csd=11; JSESSIONID=HmQGvp1gNdatWb5aidC7E64Fo7trVRElhKyf9FxyE19j-Y_rOY3D!-52471284", "5070354145002", "-2.8", "21522303", "吴江横扇分部"));
    }
    boolean flag = true;
    public String getusername(String orgcode,String usercode){
        String username = "用户不存在";
        CloseableHttpAsyncClient httpclient = HttpAsyncClients.createSystem();
        try{
            
            httpclient.start();
            //http://10.1.200.248/sjhz/dwr/plaincall/ajaxservice.getUserName.dwr
            HttpPost post1;
            if(flag){
             post1= new HttpPost("http://10.1.200.248/sjhz/dwr/exec/ajaxservice.getUserName.dwr");
            }else{
                post1 = new HttpPost("http://10.1.200.248/sjhz/dwr/plaincall/ajaxservice.getUserName.dwr");
                
            }
            List <NameValuePair> nvps1 = new ArrayList <NameValuePair>();
            if(flag){
                nvps1.add(new BasicNameValuePair("callCount", "1"));
                
                //nvps1.add(new BasicNameValuePair("httpSessionId","0"));
                //nvps1.add(new BasicNameValuePair("scriptSessionId", "0"));
       
                //nvps1.add(new BasicNameValuePair("page","/sjhz/"));
       
                nvps1.add(new BasicNameValuePair("c0-scriptName", "ajaxservice"));
                nvps1.add(new BasicNameValuePair("c0-methodName", "getUserName"));
                //nvps1.add(new BasicNameValuePair("scriptSessionId", "0"));
                nvps1.add(new BasicNameValuePair("c0-id", "0"));
                nvps1.add(new BasicNameValuePair("c0-param0", "string:"+orgcode)); 
                nvps1.add(new BasicNameValuePair("c0-param1", "string:"+usercode));//参数1
                nvps1.add(new BasicNameValuePair("xml", "true"));
            }else{
                nvps1.add(new BasicNameValuePair("callCount", "1"));
                
                nvps1.add(new BasicNameValuePair("httpSessionId","0"));
                nvps1.add(new BasicNameValuePair("scriptSessionId", "0"));
       
                nvps1.add(new BasicNameValuePair("page","/sjhz/"));
       
                nvps1.add(new BasicNameValuePair("c0-scriptName", "ajaxservice"));
                nvps1.add(new BasicNameValuePair("c0-methodName", "getUserName"));
                //nvps1.add(new BasicNameValuePair("scriptSessionId", "0"));
                nvps1.add(new BasicNameValuePair("c0-id", "0"));
                nvps1.add(new BasicNameValuePair("c0-param0", "string:"+orgcode)); 
                nvps1.add(new BasicNameValuePair("c0-param1", "string:"+usercode));//参数1
                //nvps1.add(new BasicNameValuePair("xml", "true"));
            }
            
            
            


           post1.setEntity(new UrlEncodedFormEntity(nvps1, "GBK"));
            Future<HttpResponse> future1 = httpclient.execute(post1, null);
            HttpResponse response1 = future1.get();
            String str = EntityUtils.toString(response1.getEntity());
            System.out.println(decode(str));
            if(flag){
            username =  decode(str.split("var s0=\"")[1].split("\"")[0]);
            }else{
                username = decode(str.split("\"0\",\"")[1].split("\"")[0]);
            }
            //
            if("".equals(username)){
                username = "用户不存在";
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try {
                httpclient.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
            return username;
    }

    public  String tiaozhang(String cookie,String mailno,String jine,String orgcode,String orgname)  {
        // TODO code application logic here
        String retrunmsg = "error";
         CloseableHttpAsyncClient httpclient = HttpAsyncClients.custom().setUserAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/31.0.1650.63 Safari/537.36").build();
        try{
           
            //String cookie = cookie1;
            
           httpclient.start();
           HttpPost post1 = new HttpPost("http://10.1.200.248/ems/yjchsq!query.do");
           post1.setHeader("cookie",cookie);
           List <NameValuePair> nvps1 = new ArrayList <NameValuePair>();
           nvps1.add(new BasicNameValuePair("oprJgbh",orgcode));
           nvps1.add(new BasicNameValuePair("oprJgmc",orgname));
           nvps1.add(new BasicNameValuePair("oprYjtm",""));
           nvps1.add(new BasicNameValuePair("oprYjh",mailno));
           nvps1.add(new BasicNameValuePair("xgyy",""));
           nvps1.add(new BasicNameValuePair("t_yz",""));
           nvps1.add(new BasicNameValuePair("t_bxf",""));
           nvps1.add(new BasicNameValuePair("t_bjf",""));
           nvps1.add(new BasicNameValuePair("t_bgf",""));
           nvps1.add(new BasicNameValuePair("t_dsf",""));
           nvps1.add(new BasicNameValuePair("t_fjf",""));
           nvps1.add(new BasicNameValuePair("t_bzf",""));
           nvps1.add(new BasicNameValuePair("t_hzf",""));
           nvps1.add(new BasicNameValuePair("t_xxf",""));
           nvps1.add(new BasicNameValuePair("t_jcf",""));
           nvps1.add(new BasicNameValuePair("t_qtzf",""));
           nvps1.add(new BasicNameValuePair("t_bjsxzf",""));
           nvps1.add(new BasicNameValuePair("t_zyz",""));
            
           post1.setEntity(new UrlEncodedFormEntity(nvps1, "GBK"));
            Future<HttpResponse> future1 = httpclient.execute(post1, null);
            HttpResponse response1 = future1.get();
            String str = EntityUtils.toString(response1.getEntity());
            String oprYjtm = str.split("name=\"oprYjtm\" value=\"")[1].split("\"")[0];
            //EntityUtils.consume(response1.getEntity());
            
            
            HttpPost post2 = new HttpPost("http://10.1.200.248/ems/yjchsq!doChSq.do");
            post2.setHeader("Cookie",cookie);
            
            List <NameValuePair> nvps2 = new ArrayList <NameValuePair>();
            
            nvps2.add(new BasicNameValuePair("oprJgbh",orgcode));
            nvps2.add(new BasicNameValuePair("oprJgmc",orgname));
            nvps2.add(new BasicNameValuePair("oprYjtm",oprYjtm));
            nvps2.add(new BasicNameValuePair("oprYjh",mailno));
            nvps2.add(new BasicNameValuePair("xgyy",""));
            nvps2.add(new BasicNameValuePair("t_yz",jine));
            nvps2.add(new BasicNameValuePair("t_zyz",jine));
            post2.setEntity(new UrlEncodedFormEntity(nvps2, "GBK"));
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            post2.getEntity().writeTo(os);
            System.out.println(os.toString());
            Future<HttpResponse> future2 = httpclient.execute(post2, null);
            HttpResponse response2 = future2.get();
            String str2 = EntityUtils.toString(response2.getEntity());
            if(str2.contains("邮件撤回申请提交成功")){
                  retrunmsg  = "success";
                //System.out.println(mailno+",成功！");
            }else{
                retrunmsg = "error";
                //System.out.println(mailno+",失败！");
            }
            System.out.println(str2);
            httpclient.close();
        }catch(Exception e){
            retrunmsg = "error";
            e.printStackTrace();
            //System.out.println(mailno+",失败！");
        }finally{
            try {
                httpclient.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return retrunmsg;
    }
    
   
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String cookie = request.getParameter("cookie");
        String mailno = request.getParameter("mailno");
        String jine = request.getParameter("jine");
        String orgcode = request.getParameter("orgcode");
        String orgname = request.getParameter("orgname");
        
        
        
        PrintWriter out = response.getWriter();
        
        
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println(tiaozhang(cookie,mailno,jine,orgcode,orgname));            
        } finally {
            out.close();
        }
    }
    
    
    
        protected void processRequest2(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        String orgcode = request.getParameter("orgcode");
        String usercode = request.getParameter("usercode");
        try {
            /* TODO output your page here. You may use following sample code. */
            String returnstr = "";
            returnstr = getorgname(orgcode);
            if("机构不存在".equals(returnstr)){
                out.println("error");
            }else{
                String returnstr2 = getusername(orgcode,usercode);
                if("用户不存在".equals(returnstr2)){
                    out.println("error");
                }else{
                    returnstr = returnstr+","+returnstr2;
                    out.println(returnstr);
                }
            }
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest2(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
