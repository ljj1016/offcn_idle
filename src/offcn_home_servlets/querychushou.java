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
@WebServlet(urlPatterns="/querychushou")
public class querychushou extends HttpServlet {
@Override
protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
Map<String,Object>map=(Map<String,Object>)request.getSession().getAttribute("map_front");
String id=map.get("u_id")+"";
String sql="SELECT * FROM u_idle_info WHERE fk_fisher="+id+"";

List<Map<String,Object>>list=new BaseDao().executeQuery(sql);
request.setAttribute("list", list);
request.getRequestDispatcher("front/chushou.jsp").forward(request, response);
}
}
