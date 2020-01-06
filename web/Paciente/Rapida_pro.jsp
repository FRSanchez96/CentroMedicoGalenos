<%@page import="modelo.DetalleDoctorSucu"%>
<%@page import="mantenedor.ManHora"%>
<%@page import="modelo.Especialidad"%>
<%@page import="modelo.Doctor"%>
<%@page import="modelo.Sucursal"%>
<%@page import="mantenedor.ManDoctor"%>
<%@page import="modelo.Persona"%>
<%@page import="modelo.Prevision"%>
<%@page import="java.util.ArrayList"%>
<%@page import="mantenedor.ManUsuario"%>
<%
        /*Mantenedor Prevision que llama para listar sus datos*/
        ManUsuario listp = new ManUsuario();
        ArrayList<Prevision> Lpre = listp.ListPrevision();
         ArrayList<Persona> Lpers = listp.ListPersona();
        //Mantenedor Doctor que llama para listar sus datos*/
        ManDoctor listd = new ManDoctor();
        ArrayList<Sucursal> Lsu = listd.ListSucursal();
        ArrayList<Doctor> Ldo = listd.ListDoctor();
        ArrayList<Especialidad> Les = listd.LisEsp();
        
        /**/
        ManHora listh = new ManHora();
        ArrayList<DetalleDoctorSucu> LDetSucDoc = listh.ListDetDoctSuc();
        
         /*String dato = request.getParameter("stRespuesta");
         int valor = Integer.valueOf(dato);*/
        String dato = request.getParameter("CentroMedi");
    int valor = Integer.valueOf(dato);
         
 %>                  


 <select id="cbxPro"  name="cbxPro" class="frm-field required sect">
    <option value="#">Seleccione su opcion</option>
         <%
            for(Doctor tmap:Ldo)
            {
                for(Persona tmpe:Lpers)
                {
                    for(DetalleDoctorSucu tmpd:LDetSucDoc)
                    {
                        if(tmpd.getId_Sucu()==valor)
                        {
                            if(tmpd.getDoctor_Rut()==tmpe.getRut())
                                {
             %>
                     <option value="<%=tmpd.getDoctor_Rut()%>"><%=tmpe.getNombres()%> <%=tmpe.getApellidoPaterno()%> <%=tmpe.getApellidoMaterno()%></option>
             <%
                                 }
                        }
                    }
                }
            }
         %>                                                                                                     
</select> 
              