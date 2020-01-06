/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.SQLException;
import mantenedor.ManHora;
import modelo.Atencion;

/**
 *
 * @author Felipe
 */
@WebServlet(name = "IngresarHora", urlPatterns = {"/IngresarHora"})
public class IngresarHora extends HttpServlet {

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
            throws ServletException, IOException, ParseException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
         
              String opcion = request.getParameter("btnLogear");
            
            switch(opcion)
           {
               case "PEDIR HORA":
                    
                   String centroMedico = request.getParameter("cbxCen");
                   String rutDoctor = request.getParameter("cbxPro");
                   String espeMedico = request.getParameter("cbxEsp");
                   String prevision = request.getParameter("cbxPre");
                   String horaMedica = request.getParameter("cbxHoras");
                   
                   response.sendRedirect("/Examen/Paciente/vistaHora.jsp?centro="+centroMedico+"&rutDoc="+rutDoctor+"&especialida="+espeMedico+"&hora="+horaMedica+"");
                   
                   break;
                   
                   case "Anular":
                       
                      int NumeroAtencion= Integer.valueOf(request.getParameter("numAtencion"));
                      String Descripcion = request.getParameter("Descripcion");
                      int Costo = Integer.valueOf(request.getParameter("Costo"));
                      int IdAgenda = Integer.valueOf(request.getParameter("IdAgen"));
                      /*Fecha*/
                     /* String Hora = request.getParameter("Hora");
                      SimpleDateFormat ft3 =  new SimpleDateFormat ("yyyy-MM-dd");
                      Date  currentDat = ft3.parse(Hora);
                      /**/
                      String Hora = request.getParameter("Hora");
                      SimpleDateFormat ft3 =  new SimpleDateFormat ("yyyy-MM-dd");
                      Date  currentDat = ft3.parse(Hora);
                      /**/
                      int RutPaciente = Integer.valueOf(request.getParameter("RutPa"));
                      int Espec = Integer.valueOf(request.getParameter("Esp"));
                      int IdBoleta = Integer.valueOf(request.getParameter("IdBole"));
                      int Total = Integer.valueOf(request.getParameter("SumTo"));
                      
                    try
                    {
                       Atencion atn = new Atencion(NumeroAtencion, Descripcion, Costo, IdAgenda, currentDat, RutPaciente, Espec, IdBoleta, Total, "Desactivado");
                      ManHora mh = new ManHora(); 
                     boolean opcionn= mh.modificar(atn);
                     
                        if(opcionn==true)
                        {
                              response.sendRedirect("/Examen/Paciente/index.jsp");
                        }else
                        {
                            ///
                            response.sendRedirect("/Examen/Paciente/Anular.jsp"); 
                        }
                    }catch(Exception ex)
                    {
                        response.sendRedirect("dato.jsp?dato="+ex);
                    }
                      
                      
                    break;
                       
                   case "BUSCAR":
                        int rutB = Integer.parseInt(request.getParameter("txtRut"));
                        response.sendRedirect("/Examen/Secretaria/BuscarPac.jsp?rutPac="+rutB);
                       break;
                       
                   case "AnularPa":
                         int NumeroAtencion1= Integer.valueOf(request.getParameter("numAtencion"));
                        String Descripcion1 = request.getParameter("Descripcion");
                        int Costo1 = Integer.valueOf(request.getParameter("Costo"));
                        int IdAgenda1 = Integer.valueOf(request.getParameter("IdAgen"));
                        /*Fecha*/
                       /* String Hora = request.getParameter("Hora");
                        SimpleDateFormat ft3 =  new SimpleDateFormat ("yyyy-MM-dd");
                        Date  currentDat = ft3.parse(Hora);
                        /**/
                        String Hora1 = request.getParameter("Hora");
                        SimpleDateFormat ft31 =  new SimpleDateFormat ("yyyy-MM-dd");
                        Date  currentDat1 = ft31.parse(Hora1);
                        /**/
                        int RutPaciente1 = Integer.valueOf(request.getParameter("RutPa"));
                        int Espec1 = Integer.valueOf(request.getParameter("Esp"));
                        int IdBoleta1 = Integer.valueOf(request.getParameter("IdBole"));
                        int Total1 = Integer.valueOf(request.getParameter("SumTo"));
                      
                    try
                    {
                       Atencion atn = new Atencion(NumeroAtencion1, Descripcion1, Costo1, IdAgenda1, currentDat1, RutPaciente1, Espec1, IdBoleta1, Total1, "Desactivado");
                      ManHora mh = new ManHora(); 
                     boolean opcionn= mh.modificar(atn);
                     
                        if(opcionn==true)
                        {
                              response.sendRedirect("/Examen/Secretaria/index.jsp");
                        }else
                        {
                            ///
                            response.sendRedirect("/Examen/Secretaria/Anular.jsp"); 
                        }
                    }catch(Exception ex)
                    {
                        response.sendRedirect("dato.jsp?dato="+ex);
                    }
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(IngresarHora.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(IngresarHora.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(IngresarHora.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(IngresarHora.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(IngresarHora.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(IngresarHora.class.getName()).log(Level.SEVERE, null, ex);
        }
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
