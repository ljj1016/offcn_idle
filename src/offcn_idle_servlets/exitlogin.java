package offcn_idle_servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import offcn_idle_service.loginService;

import javax.servlet.http.HttpServlet;

@WebServlet(urlPatterns="/exitlogin")
public class exitlogin extends HttpServlet {
	loginService service = new loginService ();
@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service.exitLogin(request,response);
	}
}

