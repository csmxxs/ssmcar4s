<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.Random"%>    
<%@ page import="java.io.OutputStream"%>    
<%@ page import="java.awt.Color"%>    
<%@ page import="java.awt.Font"%>    
<%@ page import="java.awt.Graphics"%>    
<%@ page import="java.awt.image.BufferedImage"%>    
<%@ page import="javax.imageio.ImageIO"%> 
<!DOCTYPE>
<html>
<head>
<title>汽车4S店管理系统</title>
<link rel="stylesheet" href="${_css}/bootstrap.css"/>
<style type="text/css">
body{background-image: url("${_cxt}/ui/img/logincar.jpg");}
.tit{ margin:auto; margin-top:170px; text-align:center; width:350px; padding-bottom:20px;color: white;}
.login-wrap{ width:210px; padding:30px 50px 0 330px; height:235px; background:#fff url(${_cxt}/ui/img/20150212154319.jpg) no-repeat 30px 50px; margin:auto; overflow: hidden;}
.login_input{ display:block;width:220px;}
.login_user{background: url(${_cxt}/ui/img/input_icon_1.png) no-repeat 200px center; font-family: "Lucida Sans Unicode", "Lucida Grande", sans-serif}
.login_password{ background: url(${_cxt}/ui/img/input_icon_2.png) no-repeat 200px center; font-family:"Courier New", Courier, monospace}
.btn-login{ background:#40454B; box-shadow:none; text-shadow:none; color:#fff; border:none;height:35px; line-height:26px; font-size:14px; font-family:"microsoft yahei";}
.btn-login:hover{ background:#333; color:#fff;}
.copyright{ margin:auto; margin-top:10px; text-align:center; width:370px; color:#CCC}
@media (max-height: 700px) {.tit{ margin:auto; margin-top:100px; }}
@media (max-height: 500px) {.tit{ margin:auto; margin-top:50px; }}
</style>
<script>
	if(window.top !== window.self) {//如果当前页面不是顶层窗口则设置为顶层窗口
	   window.top.location = window.location;
	}
</script>
</head>
<body>
<%-- 
<%    
    int width = 60;    
    int height = 32;    
    //create the image    
    BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);    
    Graphics g = image.getGraphics();    
    // set the background color    
    g.setColor(new Color(0xDCDCDC));    
    g.fillRect(0, 0, width, height);    
    // draw the border    
    g.setColor(Color.black);    
    g.drawRect(0, 0, width - 1, height - 1);    
    // create a random instance to generate the codes    
    Random rdm = new Random();    
    String hash1 = Integer.toHexString(rdm.nextInt());    
    // make some confusion    
    for (int i = 0; i < 50; i++) {    
        int x = rdm.nextInt(width);    
        int y = rdm.nextInt(height);    
        g.drawOval(x, y, 0, 0);    
    }    
    // generate a random code    
    String capstr = hash1.substring(0, 4);    
    //将生成的验证码存入session    
    session.setAttribute("validateCode", capstr);    
    g.setColor(new Color(0, 100, 0));    
    g.setFont(new Font("Candara", Font.BOLD, 24));    
    g.drawString(capstr, 8, 24);    
    g.dispose();    
    //输出图片    
    response.setContentType("image/jpeg");    
    out.clear();    
    out = pageContext.pushBody();    
    OutputStream strm = response.getOutputStream();    
    ImageIO.write(image, "jpeg", strm);    
    strm.close();    
%>  --%>

<form action="${_cxt}/sys_login.do" method="post">
<div class="tit"><h3>驰骋汽车4S店管理系统</h3></div>
<div style="width: 100%;text-align: center;color: red;">${msg}</div>
<div class="login-wrap">
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td height="25" valign="bottom">用户名：</td>
    </tr>
    <tr>
      <td><input type="text" name="username" class="login_input login_user"/></td>
    </tr>
    <tr>
      <td height="35" valign="bottom">密  码：</td>
    </tr>
    <tr>
      <td><input type="password" name="password"  class="login_input login_password" /></td>
    </tr>
    <tr>
     <td>&nbsp;</td>
    </tr>
    <tr>
      <td height="60" valign="bottom">
	    <input type="submit" value="登录" class="btn btn-block btn-login">
	    <input type="button" value="注册" class="btn btn-block btn-login">
    </tr>  
  </table>
</div>
<div class="copyright">建议使用IE8以上版本或谷歌浏览器</div>
</form>
</body>
</html>
