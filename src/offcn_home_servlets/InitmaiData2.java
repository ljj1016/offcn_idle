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
String sql1="SELECT COUNT(1)AS 'dengdaifahuo' FROM u_idle_orders WHERE purchaser_id = "+uid+" AND order_state = '�ȴ�����'";
String sql2="SELECT COUNT(1)AS 'daishouhuo' FROM u_idle_orders WHERE purchaser_id = "+uid+" AND order_state = '���ջ�'";

BaseDao dao=new BaseDao();
List<Map<String, Object>> list_dengdaifahuo = dao.executeQuery(sql1);
List<Map<String, Object>> list_daishouhuo = dao.executeQuery(sql2);

String dengdaifahuo=list_dengdaifahuo.get(0).get("dengdaifahuo")+"";/*��ȡlist�е�Map����Ϊchushouzhong�ļ�¼*/
String daishouhuo=list_daishouhuo.get(0).get("daishouhuo")+"";/*��ȡlist�е�Map����Ϊchengjiaojilu�ļ�¼*/
/*��װ������Map*/
Map<String,String> initMaiMap2=new HashMap<String,String>();/*�½�һ��HashMap*/
initMaiMap2.put("dengdaifahuo",dengdaifahuo);/*��������������*/
initMaiMap2.put("daishouhuo",daishouhuo);/*��������������*/
String str = JSONArray.fromObject(initMaiMap2).toString();/*��Mapת��Ϊjson����*/
response.getWriter().write(str);/*����jsonֵ��data*/
}
}
