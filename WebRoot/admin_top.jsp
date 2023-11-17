<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>管理页面</title>
<script language=JavaScript>
function logout(){
	if (confirm("您确定要退出系统吗？"))
	top.location = "method!loginout";
	return false;
}
</script>
<script language=JavaScript1.2>
function showsubmenu(sid) {
	var whichEl = eval("submenu" + sid);
	var menuTitle = eval("menuTitle" + sid);
	if (whichEl.style.display == "none"){
		eval("submenu" + sid + ".style.display=\"\";");
	}else{
		eval("submenu" + sid + ".style.display=\"none\";");
	}
}
</script>
<meta http-equiv=Content-Type content=text/html;charset=gb2312>
<meta http-equiv="refresh" content="60">
<script language=JavaScript1.2>
function showsubmenu(sid) {
	var whichEl = eval("submenu" + sid);
	var menuTitle = eval("menuTitle" + sid);
	if (whichEl.style.display == "none"){
		eval("submenu" + sid + ".style.display=\"\";");
	}else{
		eval("submenu" + sid + ".style.display=\"none\";");
	}
}
</script>
<base target="main">
<link href="images/skin.css" rel="stylesheet" type="text/css">
</head>
<body leftmargin="0" topmargin="0">

<table width="100%" border="0" cellSpacing="0" cellPadding="0" background="<%=request.getContextPath()%>/theme/img/ntbg2.gif" height="70">
  <tr>
    <td rowspan="2" width="500" style="color: #ffffff;font-size: 30px"><strong>&nbsp; 公司内部管理系统</strong></td>
    <td align="right" style="padding-top:4px" height="30">
	  <table border="0" cellPadding="0" cellSpacing="0">
	    <tr style="padding-left:3px">
	      <td>${user.username }&nbsp;你好，欢迎登录&nbsp;|&nbsp;</td>
	    </tr>
	  </table>
    </td>
  </tr>
</table>

</body>
</html>
