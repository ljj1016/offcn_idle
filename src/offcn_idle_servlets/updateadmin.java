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
import offcn_idle_dao.BaseDao;

@WebServlet(urlPatterns="/updateadmin")
public class updateadmin extends HttpServlet {
@Override
protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    int n=new idleservice().updateuser(request, response);
    if(n>0)
    {
    	String account=request.getParameter("account");
    	String sql="SELECT * FROM u_sys_admin WHERE account='"+account+"'";
    	Map<String,Object>map=new BaseDao().executeQuery(sql).get(0);
    	request.getSession().setAttribute("map", map);
    	request.getRequestDispatcher("module_geren/updateinfo.jsp").forward(request, response);
    }
}
}
