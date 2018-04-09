package offcn_home_servlets;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import offcn_idle_dao.BaseDao;
@WebServlet(urlPatterns="/checkphone")
public class checkphone extends HttpServlet {
@Override
protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	String pnum=request.getParameter("phnum");
String sql="SELECT * FROM u_idle_user WHERE u_phonenum='"+pnum+"'";
List<Map<String,Object>>list=new BaseDao().executeQuery(sql);
String msg="";
if(list!=null&&list.size()>0)
{
	
	 msg="no";
	
}
else
{ 
	msg="ok";}
response.getWriter().write(msg);
}
}

