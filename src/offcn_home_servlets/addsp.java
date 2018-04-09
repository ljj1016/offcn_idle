package offcn_home_servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import offcn_idle_service.idleservice;
@MultipartConfig
@WebServlet(urlPatterns="/addsp")
public class addsp extends HttpServlet {
@Override
protected void service(HttpServletRequest request, HttpServletResponse  response) throws ServletException, IOException {
int n=new idleservice().add(request, response);
if(n>0)
{
	response.sendRedirect("home.jsp");
	}
}
}
