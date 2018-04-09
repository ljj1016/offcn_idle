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
@WebServlet(urlPatterns="/querymohu")
public class querymohu extends HttpServlet {
@Override
protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String hu=request.getParameter("id");
String sql="SELECT * FROM u_idle_info WHERE NAME LIKE '%"+hu+"%' OR presentation LIKE '%"+hu+"%'";
List<Map<String,Object>>list=new BaseDao().executeQuery(sql);
request.setAttribute("list", list);
request.getRequestDispatcher("front/mohu.jsp").forward(request, response);
}
}
