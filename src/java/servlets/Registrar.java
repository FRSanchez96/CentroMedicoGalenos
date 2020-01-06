/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mantenedor.ManUsuario;
import modelo.DetalleTipoUsuario;
import modelo.Persona;
import modelo.Sexo;
import modelo.Telefono;

/**
 *
 * @author Felipe
 */
@WebServlet(name = "Registrar", urlPatterns = {"/Registrar"})
public class Registrar extends HttpServlet {

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
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            String op = request.getParameter("btnCrear");
            
            switch(op)
            {
                case "REGISTRAR":
                    int Rut = Integer.parseInt(request.getParameter("txtRut"));
                    String Verificador = request.getParameter("txtVeri");
                    String Nombres = request.getParameter("txtNombres");
                    String ApellPa = request.getParameter("txtApePa");
                    String ApellMa = request.getParameter("txtApeMa");
                    /*Fecha*/
                    String fecha = request.getParameter("txtFech");
                    //Date Fech = Date.valueOf(request.getParameter("txtFech"));
                    SimpleDateFormat ft =  new SimpleDateFormat ("yyyy-MM-dd");
                    java.util.Date  currentDate = ft.parse(fecha);
                    SimpleDateFormat ft2 =  new SimpleDateFormat ("dd-MM-yyyy");
                    String fechaPaso = ft2.format(currentDate);
                    //java.util.Date fechaFormateada = ft2.parse(fechaPaso);
                    /**/
                    /**/
                    String Mail = request.getParameter("txtMail"); 
                    String Dire = request.getParameter("txtDire");
                    int Cel = Integer.parseInt(request.getParameter("txtCel")); 
                    int Cas = Integer.parseInt(request.getParameter("txtCas"));
                    int Sex = Integer.parseInt(request.getParameter("cbxSex"));
                    int Comu = Integer.parseInt(request.getParameter("cbxCom"));
                    int Prev = Integer.parseInt(request.getParameter("cbxPre"));
                    String Contra = request.getParameter("txtCont");
                    
                    
                    
                    try
                    {
                        ManUsuario pers = new ManUsuario();
                        Persona per = new Persona(Rut, Verificador, Nombres, ApellPa, ApellMa, fechaPaso, Sex, Dire, Mail, Comu, Prev, Contra);
                        DetalleTipoUsuario det =new DetalleTipoUsuario (3, Rut);
                        Telefono celu = new Telefono(6, Cel, Nombres+" "+ApellPa+" "+ApellMa, Rut, 3);
                        Telefono casa = new Telefono(7, Cas, Nombres+" "+ApellPa+" "+ApellMa, Rut, 1);
                        boolean opcion=pers.AgregarPer(per);
                        
                        if(opcion==true)
                        {
                             response.sendRedirect("dato.jsp?dato= Problema al crear Cuenta, Favor de contactar al CentroMedico"); 
                        }else
                        {
                            boolean opc = pers.AgregarDetalleTipo(det);
                            boolean opc2 = pers.AgregarTelefono(celu);
                            boolean opc3 = pers.AgregarTelefono(casa);
                            response.sendRedirect("dato.jsp?dato= Cuenta Creada Exitosamente!"); 
                        }
                    }catch(Exception ex)
                    {
                        response.sendRedirect("dato.jsp?dato="+ex);
                    }
                    
                    break;
                case "VER":
                        int Id = Integer.parseInt(request.getParameter("txtId"));
                        String Nombre = request.getParameter("txtNombre");
                        
                        try
                    {
                        ManUsuario pers = new ManUsuario();
                        Sexo se = new Sexo(Id, Nombre);
                        boolean opcion=pers.AgregarSex(se);
                        if(opcion==true)
                        {
                             response.sendRedirect("dato.jsp?dato= Error, Favor contactar a CentroMedico"); 
                        }else
                        {
                            response.sendRedirect("dato.jsp?dato= Realizado Exitosamente !"); 
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
            Logger.getLogger(Registrar.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Registrar.class.getName()).log(Level.SEVERE, null, ex);
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
