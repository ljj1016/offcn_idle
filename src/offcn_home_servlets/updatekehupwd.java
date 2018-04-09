package offcn_home_servlets;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import offcn_idle_dao.BaseDao;
@WebServlet(urlPatterns="/updatekehupwd")
public class updatekehupwd extends HttpServlet {
@Override
protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	Map<String,Object> map=(Map<String,Object>)request.getSession().getAttribute("map_front");
	   String id = map.get("u_id")+"";
	String newpwd=request.getParameter("pwd");
String sql="UPDATE u_idle_user SET u_password='"+newpwd+"'WHERE u_id="+id+"";
int n=new BaseDao().executeUpdate(sql);
if(n>0)
{
	response.getWriter().write("ok");
	}
else
{
	response.getWriter().write("false");
	}

}
}
