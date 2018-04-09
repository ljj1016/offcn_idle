package offcn_idle_servlets;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import offcn_idle_service.idleservice;
@WebServlet(urlPatterns="/queryOrder")
public class queryOrder extends HttpServlet {
@Override
protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 List<Map<String,Object>>list=new idleservice().selectbyKeyword(request, response);
 request.setAttribute("list",list);
 request.getRequestDispatcher("module_orders/orderinfo.jsp").forward(request, response);
}
}
