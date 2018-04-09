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
@WebServlet(urlPatterns="/kehuinfo")
public class kehuinfo extends HttpServlet {
@Override
protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	Map<String,Object> map=(Map<String,Object>)request.getSession().getAttribute("map_front");
	String id=map.get("u_id")+"";
	String sql="SELECT * FROM u_idle_user WHERE u_id="+id+"";
	List<Map<String,Object>>list=new BaseDao().executeQuery(sql);
	Map<String,Object>map2=list.get(0);
	request.setAttribute("map", map2);
	request.getRequestDispatcher("front/gereninfo.jsp").forward(request, response);
}
}
