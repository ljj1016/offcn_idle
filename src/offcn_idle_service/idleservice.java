package offcn_idle_service;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.sun.org.apache.regexp.internal.recompile;

import offcn_idle_dao.BaseDao;
public class idleservice {
	BaseDao dao = new BaseDao();

	public int add(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		String name = request.getParameter("name");
		String presentation = request.getParameter("presentation");
		String location=request.getParameter("location");
		String units = request.getParameter("units");
		String amount=request.getParameter("amount");
		String original_price=request.getParameter("original_price");
		String transfer_price=request.getParameter("transfer_price");
        String transfer_mode=request.getParameter("transfer_mode");
        String percentage=request.getParameter("percentage");
        String fk_idletype=request.getParameter("fk_idletype");
        String purchasing_date=request.getParameter("purchasing_date");
        String idleimg = saveImg(request, response);/*获取文件名*/
        String sql="INSERT INTO u_idle_info(NAME,idleimg,presentation,unit,amount,location,purchasing_date,original_price,transfer_price,transfer_mode,transfer_state,percentage,fk_idletype,fk_fisher,uidle_state,create_date)VALUES('"+name+"','"+idleimg+"','"+presentation +"','"+units+"',"+amount+",'"+location+"','"+purchasing_date+"',"+original_price+","+transfer_price+",'"+transfer_mode+"','未交易','"+percentage+"',"+fk_idletype+",3,'正常',CURRENT_DATE())";
		int n = dao.executeUpdate(sql);
		
		return n;
}
	public List<Map<String,Object>> queryidleList(){
		String sql = "SELECT  * FROM u_idle_info";
		
		List<Map<String, Object>> list = new BaseDao().executeQuery(sql);
	
		return list;
	}
	public int delete(HttpServletRequest request, HttpServletResponse response) {
		String id=request.getParameter("ID");
		String sql="DELETE FROM u_idle_info WHERE ID="+id+"";
		int n=new BaseDao().executeUpdate(sql);
		return n;
	}
	public List<Map<String,Object>> selectbyKeyword(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String keyword=request.getParameter("keyword");
		String sql="SELECT * FROM u_idle_info WHERE NAME LIKE '%"+keyword+"%'";
		List<Map<String,Object>>list=new BaseDao().executeQuery(sql);
		
		return list;
	}
public int updateuser(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		String account = request.getParameter("account");
		
		
		String phonenum=request.getParameter("phonenum");
		String address = request.getParameter("address");
		String mailbox=request.getParameter("mailbox");
        String sql="UPDATE u_sys_admin SET phonenum='"+phonenum+"',address='"+address+"',mailbox='"+mailbox+"'WHERE account='"+account+"'";
		int n = dao.executeUpdate(sql);
		
		return n;
}
public List<Map<String,Object>> selectkehu(HttpServletRequest request, HttpServletResponse response)
{
	String sql="SELECT * FROM u_idle_user";
	List<Map<String,Object>>list=new BaseDao().executeQuery(sql);
	return list;
	
}
public int deleteKehu(HttpServletRequest request, HttpServletResponse response) {
	String id=request.getParameter("ID");
	String sql="DELETE FROM u_idle_user WHERE u_id="+id+"";
	int n=new BaseDao().executeUpdate(sql);
	return n;
}
public List<Map<String,Object>> selectkehubyKeyword(HttpServletRequest request, HttpServletResponse response) {
	try {
		request.setCharacterEncoding("UTF-8");
	} catch (UnsupportedEncodingException e) {
		e.printStackTrace();
	}
	String keyword=request.getParameter("keyword");
	String sql="SELECT * FROM u_idle_user WHERE u_nickname LIKE '%"+keyword+"%' OR u_state LIKE '%"+keyword+"%' OR u_province LIKE'%"+keyword+"%'OR u_city LIKE'%"+keyword+"%'OR u_district LIKE'%"+keyword+"%'";
	List<Map<String,Object>>list=new BaseDao().executeQuery(sql);
	
	return list;
}
public int addKehuinfo(HttpServletRequest request, HttpServletResponse response) {
	
	try {
		request.setCharacterEncoding("UTF-8");
	} catch (UnsupportedEncodingException e) {
		e.printStackTrace();
	}

	String u_nickname = request.getParameter("u_nickname");
	
	String u_phonenum = request.getParameter("u_phonenum");
	String u_account=request.getParameter("u_account");
	String u_passwrod = request.getParameter("u_password");
	String u_birthday=request.getParameter("u_birthday");
	String u_province=request.getParameter("u_province");
	String u_city=request.getParameter("u_city");
    String u_district=request.getParameter("u_district");
    String sql="INSERT INTO u_idle_user(u_nickname,u_phonenum,u_password,u_account,u_birthday,u_reg_datetime,u_state,u_province,u_city,u_district)VALUES('"+u_nickname+"','"+u_phonenum+"','"+u_passwrod+"','"+u_account+"',"+u_birthday+",CURRENT_DATE(),'正常','"+u_province+"','"+u_city+"','"+u_district+"')";
	int n = dao.executeUpdate(sql);
	
	return n;
}
public List<Map<String,Object>>countprovince(HttpServletRequest request, HttpServletResponse response)
{
	String sql="SELECT u_province,COUNT(u_province)AS'amount' FROM u_idle_user GROUP BY u_province";
	List<Map<String,Object>>list=new BaseDao().executeQuery(sql);
    return list;
}
public String saveImg(HttpServletRequest request, HttpServletResponse response){
	Part part = null;
	try {
		//1.获取用户上传图片对应的part对象
		part = request.getPart("idleimg");
	} catch (IOException e) {
		e.printStackTrace();
	} catch (ServletException e) {
		e.printStackTrace();
	}
	
	//2.获取当前时间s
	Date date = new Date();
	SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddhhmmss");
	String str = sf.format(date);
	
	//3.获取用户上传的图片的后缀
	String cd = part.getHeader("Content-Disposition");/*获取文件名*/
	//form-data; name="idleimg"; filename="20171108083623.jpg"
	String houzui = cd.substring(cd.lastIndexOf("."), cd.length()-1);/*获取文件后缀*/
	String fileName = str+houzui;/*文件名（当前时间）+后缀*/
	
	//4.将图片保存,利用生成的文件名
	try {
		//D:\apache-tomcat-9.0.0.M21\webapps\offcn_idle_sys\idleimg
		String realPath = request.getServletContext().getRealPath("/idleimg")+"\\"+fileName;
		part.write(realPath);
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	return fileName;
}
public List<Map<String,Object>>selectorder(HttpServletRequest request, HttpServletResponse response)
{
	String sql="SELECT * FROM u_idle_orders";
	List<Map<String,Object>>list=new BaseDao().executeQuery(sql);
	return list;
	}
}
