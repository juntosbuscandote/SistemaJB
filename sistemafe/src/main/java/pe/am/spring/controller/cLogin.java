package pe.am.spring.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pe.am.spring.entity.TUser;
import pe.am.spring.entity.TUserFilter;

@WebServlet("/cLogin")
public class cLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	  TUserFilter l = new TUserFilter();   
	  TUser s = new TUser();
	    public cLogin() {
	        super();
	    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	l.setUserVuser(request.getParameter("f_user"));	
	s.setUserVpassword(request.getParameter("f_passw"));
	boolean estado = l.equals(l);
		if(estado==true){
			HttpSession sesionOK = request.getSession();
			l.setUserVuser(sesionOK.getId());  
			s.setUserVpassword(request.getParameter("f_user"));
			TUserFilter user= new TUserFilter();
			user = l;
			//VARIABLES EN SESION
			sesionOK.setAttribute("perfil", user.getProfVdescription());
			sesionOK.setAttribute("nombres",user.getNombres() );
			sesionOK.setAttribute("empresa", user.getLegaBusiname());
			sesionOK.setAttribute("estado", user.getEstado());

			//DIRECIONAMOS AL MENU
			response.sendRedirect("../nav");		 				
		}else{
			response.sendRedirect("home.jsp?error=estado");
		}
	}
////id_sesion,usuario,inicio_sesion,ultimo_acceso,ip,host,servername,estado
//	protected void registrarSesion(String idsesion,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
//		s.setId_sesion(idsesion);
//		s.setUsuario(request.getParameter("f_user"));
//		s.setIp(request.getRemoteAddr());
//		s.setHost(request.getRemoteHost());
//		s.setServername(request.getServerName());
//		s.registrarSesion(s);			
//	}
	
}

