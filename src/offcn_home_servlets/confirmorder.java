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
@WebServlet(urlPatterns="/confirmorder")
public class confirmorder extends HttpServlet {
@Override
protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String id=request.getParameter("id");
	String sql="SELECT * FROM u_idle_info WHERE id="+id+"";
	List<Map<String,Object>>list=new BaseDao().executeQuery(sql);
	Map<String,Object>imap=list.get(0);
	request.setAttribute("imap", imap);
	request.getRequestDispatcher("front/confirm.jsp").forward(request, response);
}
}
