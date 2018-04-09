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
@WebServlet(urlPatterns="/InitMaiData")
public class InitMaiData extends HttpServlet {
@Override
protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String uid=request.getParameter("uid");
String sql1="SELECT COUNT(1)AS 'chushouzhong' FROM u_idle_info WHERE fk_fisher = "+uid+" AND transfer_state = 'δ����'";
String sql2="SELECT COUNT(1)AS 'chengjiaojilu' FROM u_idle_info WHERE fk_fisher = "+uid+" AND transfer_state = '�ѽ���'";
BaseDao dao=new BaseDao();
List<Map<String, Object>> list_chushouzhong = dao.executeQuery(sql1);
List<Map<String, Object>> list_chengjiaojilu = dao.executeQuery(sql2);

String chushouzhong=list_chushouzhong.get(0).get("chushouzhong")+"";/*��ȡlist�е�Map����Ϊchushouzhong�ļ�¼*/
String chengjiaojilu=list_chengjiaojilu.get(0).get("chengjiaojilu")+"";/*��ȡlist�е�Map����Ϊchengjiaojilu�ļ�¼*/
/*��װ������Map*/
Map<String,String> initMaiMap=new HashMap<String,String>();/*�½�һ��HashMap*/
initMaiMap.put("chushouzhong",chushouzhong);/*��������������*/
initMaiMap.put("chengjiaojilu",chengjiaojilu);/*��������������*/
String str = JSONArray.fromObject(initMaiMap).toString();/*��Mapת��Ϊjson����*/
response.getWriter().write(str);/*����jsonֵ��data*/
}
}
