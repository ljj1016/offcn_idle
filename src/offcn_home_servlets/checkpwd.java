package offcn_home_servlets;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns="/checkpwd")
public class checkpwd extends HttpServlet {
@Override
protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 response.setContentType("text/html;charset=utf-8");
	 String pwd=request.getParameter("oripwd");
	 Map<String,Object>map=(Map<String,Object>)request.getSession().getAttribute("map_front");
	 String oripwd=map.get("u_password")+"";
	 String msg="";
	 if(pwd.equals(oripwd))
	 {
		 msg="ok";
	 }
	 else
	 {
		 msg="false";
	 }
	 response.getWriter().write(msg);
}
}
