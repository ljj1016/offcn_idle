package offcn_home_servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import offcn_idle_dao.BaseDao;
@WebServlet(urlPatterns="/InitmaiData2")
public class InitmaiData2 extends HttpServlet {
@Override
protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String uid=request.getParameter("uid");
String sql1="SELECT COUNT(1)AS 'dengdaifahuo' FROM u_idle_orders WHERE purchaser_id = "+uid+" AND order_state = '等待发货'";
String sql2="SELECT COUNT(1)AS 'daishouhuo' FROM u_idle_orders WHERE purchaser_id = "+uid+" AND order_state = '待收货'";

BaseDao dao=new BaseDao();
List<Map<String, Object>> list_dengdaifahuo = dao.executeQuery(sql1);
List<Map<String, Object>> list_daishouhuo = dao.executeQuery(sql2);

String dengdaifahuo=list_dengdaifahuo.get(0).get("dengdaifahuo")+"";/*获取list中的Map列名为chushouzhong的记录*/
String daishouhuo=list_daishouhuo.get(0).get("daishouhuo")+"";/*获取list中的Map列名为chengjiaojilu的记录*/
/*封装数据入Map*/
Map<String,String> initMaiMap2=new HashMap<String,String>();/*新建一个HashMap*/
initMaiMap2.put("dengdaifahuo",dengdaifahuo);/*往里面填入数据*/
initMaiMap2.put("daishouhuo",daishouhuo);/*往里面填入数据*/
String str = JSONArray.fromObject(initMaiMap2).toString();/*将Map转型为json类型*/
response.getWriter().write(str);/*返回json值到data*/
}
}
