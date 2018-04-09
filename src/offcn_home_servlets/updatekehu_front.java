package offcn_home_servlets;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import offcn_idle_service.idleservice;
import offcn_idle_dao.BaseDao;

@WebServlet(urlPatterns="/updatekehu_front")
@MultipartConfig
public class updatekehu_front extends HttpServlet {
@Override
protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	try {
		request.setCharacterEncoding("UTF-8");
	} catch (UnsupportedEncodingException e) {
		e.printStackTrace();
	}

	String id=request.getParameter("u_id");
String nickname=request.getParameter("u_nickname");
String phonenum=request.getParameter("u_phonenum");
String birthday=request.getParameter("u_birthday");
String province=request.getParameter("u_province");
String city=request.getParameter("u_city");
String district=request.getParameter("u_district");
String filename = new idleservice().saveImg(request, response);
String sql="UPDATE u_idle_user SET u_nickname='"+nickname+"',u_phonenum='"+phonenum+"',u_birthday='"+birthday+"',u_province='"+province+"',u_city='"+city+"',u_district='"+district+"',u_headimg='"+filename+"' WHERE u_id="+id+"";
int n=new BaseDao().executeUpdate(sql);
if(n>0)
{
	String sql2="SELECT * FROM u_idle_user WHERE u_id="+id+"";
	List<Map<String,Object>>list=new BaseDao().executeQuery(sql2);
	Map<String,Object>map=list.get(0);
	HttpSession session = request.getSession();
	session.invalidate();
	request.getSession().setAttribute("map_front",map);
	request.getRequestDispatcher("kehuinfo").forward(request, response);
}
}
}
