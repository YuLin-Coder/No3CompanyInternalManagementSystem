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
 <script src="js/Calendar.js"></script>
 <script>
//新增
function doAdd(){
	window.location.href="method!youjianadd";
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
<body>
<br/><br/>
<font size="5">发件箱</font>

<form action="method!youjianlist" method="post">
<div align="left">





标题:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="text" name="title" value="${title }">
<input type="submit" value="搜索" class="btn1">&nbsp;&nbsp;
<input class="btn1" value=" 发消息 " name="btnAdd" type="button" onclick="doAdd()">&nbsp;
</div>
</form>

<br/>
<table cellspacing="1" cellpadding="1" border="0" width="100%" class="ListTbl">
<tr height="20" align="center" class="ListTtl">
<td style="font-weight: bold;">
阅读状态
</td>
<td style="font-weight: bold;">
消息标题
</td>
<td style="font-weight: bold;">
发送时间
</td>
<td style="font-weight: bold;">
操作
</td>
</tr>
<c:forEach var="bean" items="${list}">
<tr onmouseout="cancelColor(this)" onmouseover="setColor(this)" bgcolor="#FFFFFF" height="20px" align="center">
<td>
${bean.readzhuangtai }
</td>

<td>
${bean.title }
</td>
<td>
${fn:substring(bean.createtime,0, 19)}
</td>


<td>
<a href="method!youjianupdate3?id=${bean.id }" class="ListTtlLink" style="color: blue;">查看消息</a>
&nbsp;&nbsp;&nbsp;&nbsp;
<a href="method!youjiandelete?id=${bean.id }" class="ListTtlLink" style="color: blue;">删除消息</a>
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
