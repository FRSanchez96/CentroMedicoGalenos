<%@page import="modelo.Sucursal"%>
<%@page import="mantenedor.ManDoctor"%>
<%@page import="modelo.DetalleDoctorSucu"%>
<%@page import="java.util.ArrayList"%>
<%@page import="mantenedor.ManHora"%>
<%
    /**/
    ManHora mh = new ManHora();
    ArrayList<DetalleDoctorSucu> Ldd = mh.ListDetDoctSuc();
    /**/
    ManDoctor md = new ManDoctor();
    ArrayList<Sucursal>  Le = md.ListSucursal();
    String dato = request.getParameter("rutMedico");
    int valor = Integer.valueOf(dato);
%>

<select id="cbxCen"  name="cbxCen" class="frm-field required sect">
    <option value="#">Seleccione su opcion</option>
         <%
            for(DetalleDoctorSucu XX:Ldd)
            {
                for(Sucursal XXX:Le)
                {
                  if(XX.getDoctor_Rut()==valor)
                        {
                            if(XX.getId_Sucu()==XXX.getId_Sucursal())
                                {
             %>
                                     <option value="<%=XXX.getId_Sucursal()%>"><%=XXX.getNom_Sucursal()%></option>
             <%
                                 }
                        }
                }
            }
         %>                                                                                                     
</select> 
