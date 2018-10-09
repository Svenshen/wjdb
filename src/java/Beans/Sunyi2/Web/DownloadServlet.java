/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Beans.Sunyi2.Web;

import Beans.Sunyi2.Web.Butie.Butie;
import Beans.Sunyi2.Web.Butie.Butieshuju;
import Beans.Sunyi2.Web.Sunyi.Guoji;
import Beans.Sunyi2.Web.Sunyi.Guojishuju;
import Beans.Sunyi2.Web.Sunyi.Guonei;
import Beans.Sunyi2.Web.Sunyi.Guoneishujubyjigou;
import Beans.Sunyi2.Web.Xinchou.Xinchou;
import Beans.Sunyi2.Web.Xinchou.Xinchoushuju;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrator
 */
public class DownloadServlet extends HttpServlet {

    
    public static void main(String[] args) {
            
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
        
        response.setContentType("application/csv;charset=GBK");
        response.setHeader("Content-Disposition", "inline; filename=repost.csv");
        PrintWriter out = response.getWriter();       
        //HttpServletResponse response = ServletActionContext.getResponse();
        
        if("butie".equals(request.getParameter("act"))){
            String str ="邮件号,收寄日期,机构代码,机构名称,客户代码,客户,交易码,寄达省,寄达市,寄达地代码,邮件重量,标准资费,系统资费,公司资费,补贴\r\n";
            Butie butie = new Butie();
            ArrayList<Butieshuju> list = butie.getmingxibyid(request.getParameter("id"));
            
            out.write(str);
            out.flush();
            for(Butieshuju b :list){
                out.write(b.toString());
                out.flush();  
                //System.out.println(b.toString());
            }
        }else if("xinchou".equals(request.getParameter("act"))){
            String str ="邮件号,收寄日期,机构代码,机构名称,客户代码,客户,交易码,寄达省,寄达市,寄达地代码,邮件重量,标准资费,实收资费,公司成本,薪酬\r\n";
            Xinchou butie = new Xinchou();
            ArrayList<Xinchoushuju> list = butie.getmingxibyid(request.getParameter("id"));
            
            out.write(str);
            out.flush();
            for(Xinchoushuju b :list){
                out.write(b.toString());
                out.flush();  
                //System.out.println(b.toString());
            }
        }else if("guoneisunyi".equals(request.getParameter("act"))){
            String str ="邮件号,收寄日期,机构代码,机构名称,客户代码,客户名称,产品,产品分类,是否热敏,邮件重量,系统资费,是否文件,邮件路向,寄达地代码,寄达省,寄达市,单册费,区内转趟,本地处理中心处理费,二干运费,省内处理,省际经转费,一干运费,进口省省内处理费,进口省二干运费,投递费,计件工资,全名址录入费\r\n";
            Guonei butie = new Guonei();
            ArrayList<Guoneishujubyjigou> list = butie.getmingxibyidjigou(request.getParameter("id"));
            
            out.write(str);
            out.flush();
            for(Guoneishujubyjigou b :list){
                out.write(b.toString());
                out.flush();  
                //System.out.println(b.toString());
            }
        }else if("guojisunyi".equals(request.getParameter("act"))){
            String str ="邮件号,收寄日期,机构代码,机构名称,客户代码,客户名称,产品,产品分类,是否热敏,邮件重量,收入,是否文件,寄达地代码,寄达省,寄达市,区内转趟,本地处理中心处理费,互换局处理费,验关费,经转局处理费,一干运费,国际航空费,国际终端费,TNT终端费\r\n";
            Guoji butie = new Guoji();
            ArrayList<Guojishuju> list = butie.getmingxibyid(request.getParameter("id"));
            
            out.write(str);
            out.flush();
            for(Guojishuju b :list){
                out.write(b.toString());
                out.flush();  
                //System.out.println(b.toString());
            }
        }
        
        //out.write(str);
        //out.flush();            
        out.close();
        
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
