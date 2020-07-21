/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mantenedor.ManUsuario;

/**
 *
 * @author Felipe
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            
           String opcion = request.getParameter("btnLogear");
           
           switch(opcion)
           {
               case "Entrar":
                        int Rut = Integer.parseInt(request.getParameter("txtRut"));
                        String Dig = request.getParameter("txtDig");
                        String pass = request.getParameter("txtPass");
                        
                    try
                    {
                        
                        ManUsuario usu = new ManUsuario();
                       
                        int resu = usu.logear(Rut, Dig, pass);
                        
                        if(resu==4)
                        {
                            String rutt = String.valueOf(Rut);
                            request.getSession().setAttribute("usu", rutt);
                            response.sendRedirect("Medico/index.jsp");                         
                        }
                        else if(resu==2)
                        {
                            String rutt = String.valueOf(Rut);
                            request.getSession().setAttribute("usu", rutt);
                            response.sendRedirect("Secretaria/index.jsp");                         
                        }
                        else if(resu==3)
                        {
                            String rutt = String.valueOf(Rut);
                            request.getSession().setAttribute("usu", rutt);
                            response.sendRedirect("Paciente/index.jsp");                         
                        }
                        else if(resu==1)
                        {
                            String rutt = String.valueOf(Rut);
                            request.getSession().setAttribute("usu", rutt);
                            response.sendRedirect("/Examen/faces/Administrador/index.xhtml");                         
                        }
                        else
                        {
                            response.sendRedirect("index.jsp");
                        } 
                        
                            
                     }catch(Exception ex)
                    {
                        response.sendRedirect("dato.jsp?dato="+ex);
                    }
                   break;
                   case "cerrar":
                        request.getSession().setAttribute("usu", "");
                        response.sendRedirect("../index.jsp");
                    break;
            
        }
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
