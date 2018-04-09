package offcn_idle_servlets;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import offcn_idle_dao.BaseDao;
@WebServlet(urlPatterns="/addKeyword")
public class addKeyword extends HttpServlet {
@Override
protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setCharacterEncoding("utf-8");
	response.setContentType("text/html;charset=utf-8");
	String keyword=request.getParameter("keywords");
	String sql="INSERT INTO u_keywords(keywords,createtime) VALUE('"+keyword+"',Now())";
	int n=new BaseDao().executeUpdate(sql);
	if(n>0)
	{
		String sql2="SELECT * FROM u_keywords";
		List<Map<String,Object>>list=new BaseDao().executeQuery(sql2);
		String str = JSONArray.fromObject(list).toString();
		response.getWriter().write(str);
	}
}
}
