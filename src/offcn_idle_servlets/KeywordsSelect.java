package offcn_idle_servlets;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import offcn_idle_dao.BaseDao;

import net.sf.json.JSONArray;
@WebServlet(urlPatterns="/KeywordsSelect")
public class KeywordsSelect extends HttpServlet {
@Override
protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setCharacterEncoding("utf-8");
	response.setContentType("text/html;charset=utf-8");
	String sql = "SELECT * FROM u_keywords";
	List<Map<String, Object>> list = new BaseDao().executeQuery(sql);
	//将list转换成json数据（需求引用jar包）
	String str = JSONArray.fromObject(list).toString();
	response.getWriter().write(str);
}
}
