/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans.yisidiushi;

import Beans.MyLog;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrator
 */
public class jinkou extends HttpServlet {

    public String mailno;
    public String jigou;
    public String lantoubu;
    public String tuotou;
//    private static final String driver=MyLog.driver;
    public ArrayList<jinkou> istuotou2(String mailno){
        ArrayList<jinkou> jj = new ArrayList<jinkou>();
        String [] mail = mailno.split("\r\n");
        for (String m : mail){
            jinkou j = new jinkou();
           j.mailno = m;
           String [] qq = istuotou(m);
           j.tuotou = qq[1];
           j.jigou = qq[0];
           jj.add(j);
        }
        return jj;
    }
    
    
    public String[] istuotou(String mailno){
        String [] qq = {"未知","未妥投"};
        mailno = mailno.trim();
        try{
//                Class.forName(driver).newInstance();
                Connection conn = MyLog.getConn();
                String sql = "select * from wujiangtoudi2 where mail_num = ? and dlv_sts_code = 'I'";
                
                PreparedStatement pstmt = conn.prepareStatement(sql);
                //System.out.println(request.getParameter("kshijian").replace("-", ""));
                pstmt.setString(1, mailno);
                
                ResultSet rs =pstmt.executeQuery();

                if(rs.next()){
                    qq[0] = rs.getString("org_sname");
                     qq[1] = "已妥投";
                    
                }
                rs.close();
                pstmt.close();
                
                MyLog.close(conn);
        }catch(SQLException sqle){
            sqle.printStackTrace();
            //MyLog.logtooracle(jigou, sqle);
        }catch(ClassNotFoundException cnfe){
            cnfe.printStackTrace();
            //MyLog.logtooracle(jigou, cnfe);
        }catch(InstantiationException ie ){
            ie.printStackTrace();
            //MyLog.logtooracle(jigou, ie);
        }catch(IllegalAccessException iae){
            iae.printStackTrace();
            //MyLog.logtooracle(jigou, iae);
        }
        
        return qq;
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
        
        
        String mailno = request.getParameter("mailno");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet jinkou</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet jinkou at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        processRequest(request, response);
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
