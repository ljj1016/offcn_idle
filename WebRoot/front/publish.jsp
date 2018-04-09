<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="<%=basePath %>css1/style.css" rel="stylesheet" type="text/css" />
    <title>U闲交易平台</title>
	<link rel="stylesheet" type="text/css" href="css1/register.css"/>
    <link rel="icon" href="images1/icon.ico"/>
</head>
<body>
    <!-- header -->
    <div class="header">
        <div class="header_main wrap">
            <h1><a href="#"><img src="images1/logo-2.png"/></a></h1>
            <h2>让你的闲置游起来!</h2>
            <ul class="header_menu clearfix">
                <li><a href="index.html" target="_blank">首页</a></li>
                <li><a href="#">手机二手</a></li>
                <li><a href="#">二手车估价</a></li>
                <li><a href="#">降降降</a></li>
                <li><a href="publish" target="_blank">发布闲置</a></li>
                <li class="header_wdxz">
                    <a href="#">我的闲置</a>
                    <ul class="header_xz">  
                        <li><a href="#">出售中：<span>0</span></a></li>  
                        <li><a href="#">交易中：<span>0</span></a></li>  
                        <li><a href="#">新留言：<span>0</span></a></li>
                        <li><a href="#">新会话：<span>0</span></a></li>    
                    </ul> 
                </li>
                <li class="header_mycenter">
                    <a href="#" class="active">个人中心</a>
                    <ul class="header_center">  
                        <li><a href="#">完善个人信息</a></li>  
                        <li><a href="#">修改密码</a></li>  
                        <li><a href="#">我的收藏</a></li>  
                    </ul> 
                </li>
                <li class="quit"><a href="javascript:void(0)">退出</a></li>
            </ul>
        </div>
    </div> 
    
    <!-- 注册 -->
    <div class="register">
        <form id="bdyz" action="addsp" enctype="multipart/form-data" method="post">
            <div class="tel clearfix">
                <span>商品名</span>
                <input type="text" id="text2" name="name"/>
            </div>
            <div class="tutu">
             <span>商品图</span>
            
             <input name="idleimg" type="file"/>
              
               </div>
               <div class="tel clearfix">
                <span>商品描述</span>
                <textarea name="presentation" cols="" rows="" class="textinput"></textarea>
            </div>
               <div class="tel clearfix">
                <span>单位</span>
                <input name="units" type="text" />
            </div>
                <div class="tel clearfix">
                <span>数量</span>
                <input name="amount" type="text" />
            </div>
                <div class="tel clearfix">
                <span>闲置所在地</span>
                <input name="location" type="text" />
            </div>
                <div class="tel clearfix">
                <span>购买时间</span>
                 <input name="purchasing_date" type="text" />
            </div>
                   <div class="tel clearfix">
                <span>购买价格</span>
                 <input name="original_price" type="text" />
            </div>
                    <div class="tel clearfix">
                <span>转让价格</span>
                 <input name="transfer_price" type="text" />
            </div>
                    <div class="tel clearfix">
                <span>交易方式</span>
                 <select name="transfer_mode" >
					<option>线上交易</option>
					<option>线下交易</option>
				</select>
            </div>
                     <div class="tel clearfix">
                <span>成色</span>
						<select name="percentage" >
					<option>全新</option>
					<option>八成新</option>
					<option>半成新</option>
				</select>
            </div>
                         <div class="tel clearfix">
                <span>所属类别</span>
						<select name="fk_idletype">
					<option value="1">闲置数码</option>
					<option value="2">闲置母婴</option>
					<option value="3">家居日用</option>
					<option value="4">影音家电</option>
				</select>
            </div>
            <div class="tel clearfix">
                <span></span>
                <input type="submit" value="提交" class="sub"/>
            </div>
        </form>
    </div>
    <!-- footer -->
    <div class="footer">
        <ul class="wrap clearfix">
            <li>
                <img src="images1/footer_03.png" alt=""/>
                <span>卖家实名认证</span>
            </li>
            <li>
                <img src="images1/footer_05.png" alt=""/>
                <span>支付宝担保交易</span>
            </li>
            <li>
                <img src="images1/footer_07.png" alt=""/>
                <span>专业团队支撑</span>
            </li>
            <li>
                <img src="images1/footer_09.jpg" alt=""/>
                <span>官方微博</span>
            </li>
        </ul>
    </div>
    <!-- 底部一堆 -->
    <div class="footer_1 wrap">
        <a href="#" target="_blank">关于我们</a>
        <a href="#" target="_blank">合作伙伴</a>
        <a href="#" target="_blank">营销中心</a>
        <a href="#" target="_blank">廉正举报</a>
        <a href="#" target="_blank">联系客服</a>
        <a href="#" target="_blank">开放平台</a>
        <a href="#" target="_blank">诚征英才</a>
        <a href="#" target="_blank">联系我们</a>
        <a href="#" target="_blank">网站地图</a>
        <a href="#" target="_blank">法律声明及隐私权政策</a>
        <a href="#" target="_blank">知识产权</a>
        <span>1999-<i id="year"></i> ujiuye.com 版权所有</span>
        <script type="text/javascript">
            var day = new Date();
            var year = day.getFullYear();
            document.getElementById('year').innerHTML=year;
        </script>
    </div>
    <div class="footer_2 wrap">
        <a href="#" target="_blank"><img src="images1/ft1.gif"/></a>
        <a href="#" target="_blank"><img src="images1/ft_01.jpg"/></a>
        <a href="#" target="_blank"><img src="images1/ft_03.jpg"/></a>
        <a href="#" target="_blank"><img src="images1/ft_05.jpg"/></a>
        <a href="#" target="_blank"><img src="images1/ft_07.jpg"/></a>
        <a href="#" target="_blank"><img src="images1/ft_09.jpg"/></a>
        <a href="#" target="_blank"><img src="images1/ft_11.jpg"/></a>
        <a href="#" target="_blank"><img src="images1/ft_13.jpg"/></a>
        <a href="#" target="_blank"><img src="images1/ft_15.jpg"/></a>
    </div>
</body>
</html>
