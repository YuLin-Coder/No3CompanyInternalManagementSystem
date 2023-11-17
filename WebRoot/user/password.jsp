<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<LINK href="theme/css/0.css" type=text/css rel=stylesheet><link href="images/skin.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" /><style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	background-color: #EEF2FB;
}
-->
</style>

<script language="javascript" type="text/javascript">

function checkform()
{
	 
	

	if (document.getElementById('password1id').value=="")
	{
		alert("原密码不能为空");
		return false;
	}
	if (document.getElementById('password2id').value=="")
	{
		alert("新密码不能为空");
		return false;
	}
	
	if (document.getElementById('password2id').value.length<6)
	{
		alert("新密码长度必须大于6位");
		return false;
	}
	if (document.getElementById('password2id').value != document.getElementById('password3id').value)
	{
		alert("新密码与新密码确认不一致");
		return false;
	}	 
	return true;
	
}


</script>

<body>

<br/><br/>
<font size="5">修改密码</font>




<form action="method!changepwd2" method="post" onsubmit="return checkform()">
<table cellspacing="1" cellpadding="1" border="0" width="70%" class="ListTbl">





<tr height="20" class="ListTtl">
<td style="font-weight: bold;">
原密码
</td>
<td style="font-weight: bold;">
<input type="text" name="password1"  id='password1id'>
</td>
</tr>
<tr height="20" class="ListTtl">
<td style="font-weight: bold;">
新密码
</td>
<td style="font-weight: bold;">
<input type="text" name="password2" id='password2id'>
</td>
</tr>
<tr height="20" class="ListTtl">
<td style="font-weight: bold;">
确认新密码
</td>
<td style="font-weight: bold;">
<input type="text" name="password3" id='password3id'>
</td>
</tr>




<tr height="20" class="ListTtl">
<td style="font-weight: bold;">
操作
</td>
<td style="font-weight: bold;">
<input type="submit" value="提交" style="width: 60px">
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input  onclick="javascript:history.go(-1);" style="width: 60px" type="button" value="返回" />
</td>
</tr>

</table>
</form>

</body>
