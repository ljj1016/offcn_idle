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
@WebServlet(urlPatterns="/xiangqing")
public class xiangqing extends HttpServlet {
@Override
protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String id=request.getParameter("ID");
String sql="SELECT * FROM u_idle_info WHERE id="+id+"";
List<Map<String, Object>>list=new BaseDao().executeQuery(sql);
Map<String,Object>map=list.get(0);
request.setAttribute("map", map);
request.getRequestDispatcher("front/xiangqing.jsp").forward(request, response);
}
}
