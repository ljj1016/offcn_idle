package offcn_idle_servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import offcn_idle_dao.BaseDao;
@WebServlet(urlPatterns="/updateKehustate")
public class updateKehustate extends HttpServlet {
@Override
protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String uid=request.getParameter("ID");
String sql="UPDATE u_idle_user SET  u_state=IF(u_state='正常','锁定','正常') WHERE u_id="+uid+"";
int n=new BaseDao().executeUpdate(sql);
if(n>0)
{
	request.getRequestDispatcher("queryKehu").forward(request, response);
	}

}
}
