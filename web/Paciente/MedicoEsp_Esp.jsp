

<%@page import="modelo.DetalleEspecialidad"%>
<%@page import="modelo.Especialidad"%>
<%@page import="mantenedor.ManDoctor"%>
<%@page import="modelo.DetalleDoctorSucu"%>
<%@page import="java.util.ArrayList"%>
<%@page import="mantenedor.ManHora"%>
<%
    /**/
    ManHora mh = new ManHora();
    ArrayList<DetalleEspecialidad> Ldd = mh.ListDetEsp();
    /**/
    ManDoctor md = new ManDoctor();
    ArrayList<Especialidad>  Le = md.LisEsp();
    /**/
    String dato = request.getParameter("rutMedico");
    int valor = Integer.valueOf(dato);
%>

<select id="cbxEsp"  name="cbxEsp" class="frm-field required sect">
    <option value="#">Seleccione su opcion</option>
         <%
            for(DetalleEspecialidad tmap:Ldd)
            {
                for(Especialidad tmpe:Le)
                {
                  if(tmap.getDoctorRut()==valor)
                        {
                            if(tmap.getId_Espe()==tmpe.getId_Espe())
                                {
             %>
                     <option value="<%=tmpe.getId_Espe()%>"><%=tmpe.getNombre_Esp()%></option>
             <%
                                 }
                    }
                }
            }
         %>                                                                                                     
</select> 
