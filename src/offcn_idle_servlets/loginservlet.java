package offcn_idle_servlets;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import offcn_idle_service.loginService;
@WebServlet(urlPatterns="/loginservlet")
public class loginservlet extends HttpServlet {
@Override
protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	Map<String, Object> map =new loginService().login(request, response);
	if(map!=null){
		
		request.getSession().setAttribute("map",map);
		
		request.getRequestDispatcher("index/index.jsp").forward(request, response);
	}else{
		response.sendRedirect("login.jsp");
	}

}

}
