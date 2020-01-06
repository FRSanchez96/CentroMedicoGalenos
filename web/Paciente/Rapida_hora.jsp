
<%@page import="modelo.Dia"%>
<%@page import="modelo.Sucursal"%>
<%@page import="modelo.HorarioSemanal"%>
<%@page import="modelo.Horas"%>
<%@page import="mantenedor.ManHora"%>
<%@page import="modelo.Doctor"%>
<%@page import="java.util.ArrayList"%>
<%@page import="mantenedor.ManDoctor"%>
<%
    /**/
    ManDoctor md = new ManDoctor();
    ArrayList<Doctor> Ld = md.ListDoctor();
    ArrayList<Sucursal> Ls = md.ListSucursal();
    /**/
    ManHora mh = new ManHora();
    ArrayList<Horas> Lh = mh.ListHoras();
    ArrayList<HorarioSemanal> Lhm = mh.ListHorarioSemanal();
    ArrayList<Dia> Ldi = mh.ListDia();
    /**/
     String dato = request.getParameter("rutMedico");
    int valor = Integer.valueOf(dato);
    
     String dato2 = request.getParameter("NumeroSuc");
    int valor2 = Integer.valueOf(dato2);
    
%>



<select id="cbxPro"  name="cbxPro" class="frm-field required sect">
    <option value="#">Seleccione su opcion</option>
         <%
            for(Doctor tmap:Ld)
            {
                for(Horas tmpe:Lh)
                {
                  for(Dia tmpa:Ldi)
                  {
                    for(HorarioSemanal tmpd:Lhm)
                    {
                        if(tmap.getRutDoctor()==valor)
                        {
                            if(tmap.getId_hora()==tmpd.getIdHoraSema())
                                {
                                    if(tmpd.getIdSucu()==valor2)
                                    {
                                        if(tmpd.getIdDia()==tmpa.getId_Dia())
                                        {
                                           if(tmpd.getHorasiDHora()==tmpe.getId_Hora())
                                           {
                                               if(tmap.getEstado().equalsIgnoreCase("Disponible"))
                                               {
             %>
                                          <option value="<%=tmpa.getNombre()%> - <%=tmpe.getHor_Dia()%>"><%=tmpa.getNombre()%> - <%=tmpe.getHor_Dia()%></option>
             <%                   }
                                               }
                                    
                                        }
                                    }
                                }
                        }
                    }
                  }
                }
            }
         %>                                                                                                     
</select> 
