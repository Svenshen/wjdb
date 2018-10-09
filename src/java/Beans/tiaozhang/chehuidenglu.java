/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans.tiaozhang;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.nio.client.AbstractHttpAsyncClient;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.nio.client.HttpAsyncClient;
import org.apache.http.nio.conn.ClientAsyncConnectionManager;
import org.apache.http.nio.conn.NHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;

/**
 *
 * @author Administrator
 */
public class chehuidenglu extends HttpServlet {
  
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
        request.setCharacterEncoding("UTF8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            
            String orgcode = request.getParameter("orgcode");
            String usercode = request.getParameter("usercode");
            String orgname = request.getParameter("orgname");
            String username = request.getParameter("username");
            String taixi = request.getParameter("taixi");
            String mima = request.getParameter("mima");
            out.println(denglu(orgcode,usercode,orgname,username,taixi,mima));
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
        //processRequest(request, response);
    }
    public String denglu(String orgcode,String usercode,String orgname,String username,String taixi,String mima){
        String msg = "error";
        BasicCookieStore cookieStore = new BasicCookieStore();
       
                
        CloseableHttpAsyncClient httpclient = HttpAsyncClients.custom()
                .useSystemProperties()
              .setDefaultCookieStore(cookieStore)
               
            .build();
      
        try{
            httpclient.start();
            //System.out.println(java.net.URLEncoder.encode(orgname,"GBK"));
           //http://10.1.200.248/ems/login!login.do
            HttpPost post1 = new HttpPost("http://10.1.200.248/ems/login!login.do");
            //post1.setHeader("cookie", "cod=1.3.9; csd=12; sdyglx=1; sduserid=HS01; sdusername=%C4%DF%CE%C0%B7%E5; sdorgcode=21522303; sdorgname=%CE%E2%BD%AD%BA%E1%C9%C8%B7%D6%B2%BF; sdtx=01; JSESSIONID=GAqgJ4HHII6Q3Q8Dhqx1psuC2PzKC_KoHlnAGEEa4mQWpxe08z1S!-1696901184 ");
          //post1.setHeader("cookie", "JSESSIONID=96eknXen3m_87MjtA5ulwEL2ggQnbWW855Hq1tvpV1tr37NNQWPb!-1696901184; path=/; HttpOnly");
           
          
            List <NameValuePair> nvps1 = new ArrayList <NameValuePair>();
           nvps1.add(new BasicNameValuePair("yglx","1"));
           nvps1.add(new BasicNameValuePair("jgjb","5"));
           nvps1.add(new BasicNameValuePair("orgname",orgname));
           nvps1.add(new BasicNameValuePair("username",username));
           nvps1.add(new BasicNameValuePair("lsJgmc",""));
           nvps1.add(new BasicNameValuePair("lsYmc",""));
           nvps1.add(new BasicNameValuePair("zjgjorgname",""));
           nvps1.add(new BasicNameValuePair("zjgjusername",""));
           nvps1.add(new BasicNameValuePair("orgcode",orgcode));
           nvps1.add(new BasicNameValuePair("userid",usercode));
           nvps1.add(new BasicNameValuePair("password",mima));
           nvps1.add(new BasicNameValuePair("txh",taixi));
           nvps1.add(new BasicNameValuePair("lsJgbh",""));
           nvps1.add(new BasicNameValuePair("lsYgh",""));
           nvps1.add(new BasicNameValuePair("lsMm",""));
           nvps1.add(new BasicNameValuePair("zjgjuserid",""));
           nvps1.add(new BasicNameValuePair("zjgjpassword",""));
           nvps1.add(new BasicNameValuePair("rememberlogin","Y"));
           nvps1.add(new BasicNameValuePair("server_ip","10.1.200.248"));
           post1.setEntity(new UrlEncodedFormEntity(nvps1, "GBK"));
          
          //System.out.println(EntityUtils.toString(post1.getEntity()));
            Future<HttpResponse> future1 = httpclient.execute(post1, null);
            HttpResponse response1 = future1.get();
            String str = EntityUtils.toString(response1.getEntity());
            //System.out.println(str);
            
            EntityUtils.consume(response1.getEntity());
            if(str.contains("综合管理")){
                HttpGet get = new HttpGet("http://10.1.200.248/ems/menu!getMenu.do?menuid=B03");
                Future<HttpResponse> future2 = httpclient.execute(get, null);
                HttpResponse response2 = future2.get();
                String str2 = EntityUtils.toString(response2.getEntity());
                if(str2.contains("邮件撤回申请")){
                   List<Cookie> cookies = cookieStore.getCookies();
                    if (cookies.isEmpty()) {
                        msg="error";
                    } else {
                        msg = "success,";
                    for (int i = 0; i < cookies.size(); i++) {
                        msg = msg +cookies.get(i).getName()+"="+cookies.get(i).getValue()+"; ";
                    }
                    }
                   //CloseableHttpAsyncClient
                    
                }else{
                    msg = "没有权限";
                }
            }else{
                msg = "用户或密码错误";
            }
            
        }catch(Exception e){
            e.printStackTrace();
            msg = "error";
        }finally{
             try {
                httpclient.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return msg;
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
