<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<LINK href="theme/css/0.css" type=text/css rel=stylesheet><link href="images/skin.css" rel="stylesheet" type="text/css" />
<LINK href="theme/css/0.css" type=text/css rel=stylesheet>
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

<body>

<br/><br/>
<font size="5">添加新员工</font>






<form action="method!useradd2" method="post">
<table cellspacing="1" cellpadding="1" border="0" width="70%" class="ListTbl">

<tr height="20" align="center" class="ListTtl">
<td style="font-weight: bold;">
用户名
</td>
<td style="font-weight: bold;" align="left">
<input type="text" name="username" >
</td>
</tr>

<tr height="20" align="center" class="ListTtl">
<td style="font-weight: bold;">
部门
</td>
<td style="font-weight: bold;" align="left">
<c:if test="${user.role==2}">
<select name="bumen">
<c:forEach items="${list2}" var="bean">
<option value="${bean.id }">${bean.bumenming }</option>
</c:forEach>
</select>
</c:if>
<c:if test="${user.role==1}">
${user.bumen.bumenming }
<input type="hidden" name="bumen" value="${user.bumen.id }" >
</c:if>
</td>
</tr>

<tr height="20" align="center" class="ListTtl">
<td style="font-weight: bold;">
真实姓名
</td>
<td style="font-weight: bold;" align="left">
<input type="text" name="truename" >
</td>
</tr>
<tr height="20" align="center" class="ListTtl">
<td style="font-weight: bold;">
性别
</td>
<td style="font-weight: bold;" align="left">
<select name="xingbie">
<option value="男">男</option>
<option value="女">女</option>
</select>
</td>
</tr>
<tr height="20" align="center" class="ListTtl">
<td style="font-weight: bold;">
联系电话
</td>
<td style="font-weight: bold;" align="left">
<input type="text" name="lianxidianhua" >
</td>
</tr>
<tr height="20" align="center" class="ListTtl">
<td style="font-weight: bold;">
身份证
</td>
<td style="font-weight: bold;" align="left">
<input type="text" name="sfz" >
</td>
</tr>
<tr height="20" align="center" class="ListTtl">
<td style="font-weight: bold;">
住址
</td>
<td style="font-weight: bold;" align="left">
<input type="text" name="zhuzhi" >
</td>
</tr>

<tr height="20" align="center" class="ListTtl">
<td style="font-weight: bold;">
入职时间
</td>
<td style="font-weight: bold;" align="left">
<input type="text" name="ruzhishijian" >
</td>
</tr>

<tr height="20" align="center" class="ListTtl">
<td style="font-weight: bold;">
简介
</td>
<td style="font-weight: bold;" align="left">
<textarea rows="7" cols="50" name="jianjie"></textarea>
</td>
</tr>



<tr height="20" align="center" class="ListTtl">
<td style="font-weight: bold;">
操作
</td>
<td style="font-weight: bold;" align="left">
<input type="submit" value="提交" style="width: 60px">
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input  onclick="javascript:history.go(-1);" style="width: 60px" type="button" value="返回" />
</td>
</tr>

</table>
</form>

</body>
