package offcn_idle_servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import offcn_idle_service.idleservice;
import java.util.List;
import java.util.Map;
@WebServlet(urlPatterns="/queryList")
public class queryList extends HttpServlet {
@Override
protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   List<Map<String,Object>> list=new idleservice().queryidleList();
   request.setAttribute("list",list);
	request.getRequestDispatcher("module_idle/table.jsp").forward(request, response);
}
}
