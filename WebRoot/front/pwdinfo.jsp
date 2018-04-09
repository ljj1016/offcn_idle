<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
 <script type="text/javascript" src="<%=basePath %>js/jQuery/jquery.js"></script>
<base href="<%=basePath%>"/>
<html>
<head>
    <meta charset="UTF-8">
    <title>U闲交易平台</title>
	<link rel="stylesheet" type="text/css" href="css1/register.css">
    <link rel="icon" href="images1/icon.ico">
</head>
<body>
    <!-- header -->
    <div class="header">
        <div class="header_main wrap">
            <h1><a href="#"><img src="images1/logo-2.png"></a></h1>
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
        <form id="bdyz" action="">
        
            <div class="tel clearfix">
                <span>原密码</span>
                <input type="text" name="oripwd" onblur="checkOripwd()" id="oripwd">
                <i id="m1"></i>
            </div>
            <div class="tel clearfix">
                <span>新密码</span>
                <input type="text" name="pwd" id="pwd1" readonly="readonly">
                <i id="txt2"></i>
            </div>
              <div class="tel clearfix">
                <span>确认密码</span>
                <input type="text" name="pwd" id="pwd2" onblur="checkSamePwd()" readonly="readonly">
                <i id="txt2"></i>
            </div>
            <div class="tel clearfix">
                <span></span>
                <input type="button" onclick="updatepwd()"value="提交" class="sub" id="sub" disabled="disabled">
            </div>
        </form>
    </div>
    <!-- footer -->
    <div class="footer">
        <ul class="wrap clearfix">
            <li>
                <img src="images1/footer_03.png" alt="">
                <span>卖家实名认证</span>
            </li>
            <li>
                <img src="images1/footer_05.png" alt="">
                <span>支付宝担保交易</span>
            </li>
            <li>
                <img src="images1/footer_07.png" alt="">
                <span>专业团队支撑</span>
            </li>
            <li>
                <img src="images1/footer_09.jpg" alt="">
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
        <a href="#" target="_blank"><img src="images1/ft1.gif"></a>
        <a href="#" target="_blank"><img src="images1/ft_01.jpg"></a>
        <a href="#" target="_blank"><img src="images1/ft_03.jpg"></a>
        <a href="#" target="_blank"><img src="images1/ft_05.jpg"></a>
        <a href="#" target="_blank"><img src="images1/ft_07.jpg"></a>
        <a href="#" target="_blank"><img src="images1/ft_09.jpg"></a>
        <a href="#" target="_blank"><img src="images1/ft_11.jpg"></a>
        <a href="#" target="_blank"><img src="images1/ft_13.jpg"></a>
        <a href="#" target="_blank"><img src="images1/ft_15.jpg"></a>
    </div>
</body>
<script>
	function checkSamePwd()
	{
	var pwd1=$('#pwd1').val();
	var pwd2=$('#pwd2').val();
	if(pwd1==pwd2&&pwd1!=""&&pwd2!="")
	{
	 $('#sub').removeAttr('disabled');
	}
	else
	{
	alert('密码不一致');
	}
	}
</script>
<script>
	function checkOripwd(){
		var oripwd = $('#oripwd').val();
		$.ajax({
			url:'checkpwd',/*发送请求的路径*/
			data:'oripwd='+oripwd+'',/*需要传送的参数*/
			success:function(data){
			if(data=='ok'){
				$('#m1').html("<font color='green'>√</font>");
				$('#pwd1').removeAttr('readonly');
				$('#pwd2').removeAttr('readonly');
				}
				else
				{
				$('#m1').html("<font color='red'>×</font>");
				}
			},/*执行成功执行的代码块*/
			error:function(){
				alert('请求失败')
			}/*执行失败执行的代码块*/
		});
	}
</script>
<script>
function updatepwd()
{
 var pwd=$('#pwd1').val();
 $.ajax({
   url: "updatekehupwd",
   data:'pwd='+pwd+'',
   success: function(m)
   {
   if(m=='ok'){
		parent.location.href="home.jsp";
		}
  else{
		alert("更改失败");
	  }
},
  error:function()
  {
  alert('请求失败');
  }
 });
}
</script>
</html>
</html>
