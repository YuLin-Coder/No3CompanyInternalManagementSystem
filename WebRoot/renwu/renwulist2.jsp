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
<script>
//新增
function doAdd(){
	window.location.href="method!bumenadd";
}
function doSearch(){
	document.forms[0].action="<%=request.getContextPath()%>/special/query.do";
	document.forms[0].submit();
}
var rowColor;
function setColor(obj){
   rowColor=obj.style.backgroundColor;
   obj.style.backgroundColor="#C6EBDE";
}
function cancelColor(obj){
   obj.style.backgroundColor=rowColor;
}
</script>
 <script src="js/Calendar.js"></script>
<body>

<br/><br/>
<font size="5">工作任务管理</font>

<form action="method!renwulist2" method="post">
<div align="left">





工作概述:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="text" name="title" value="${title }">


<input type="submit" value="搜索" class="btn1">
</div>
</form>


<br/>
<table cellspacing="1" cellpadding="1" border="0" width="100%" class="ListTbl">
<tr height="20" align="center" class="ListTtl">
<td style="font-weight: bold;">
完成
</td>
<td style="font-weight: bold;">
工作概述
</td>
<td style="font-weight: bold;">
完成情况
</td>


<td style="font-weight: bold;">
操作
</td>
</tr>
<c:forEach var="bean" items="${list}">
<tr onmouseout="cancelColor(this)" onmouseover="setColor(this)" bgcolor="#FFFFFF" height="20px" align="center">
<td>
${bean.shijian }
</td>

<td>
${bean.title }
</td>
<td>
${bean.wanchengqingkuang }
</td>


<td>
<a href="method!renwuupdate3?id=${bean.id }" class="ListTtlLink" style="color: blue;">查看详细信息</a>
&nbsp;&nbsp;&nbsp;&nbsp;
<a href="method!renwuupdate7?id=${bean.id }" class="ListTtlLink" style="color: blue;">工作汇报</a>
&nbsp;&nbsp;&nbsp;&nbsp;

</td>
</tr>
</c:forEach>
<tr height="20" align="center" class="ListTtl">
<td colspan="4">
${pagerinfo }
</td>

</tr>
</table>



</body>
