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
<script>
//新增
function doAdd(){
	window.location.href="method!bumenadd"
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
<br/>
<form action="method!bumenlist" method="post">
	<div align="left">部门名称:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="text" name="bumenming" value="${bumenming }">
	<input type="submit" value="搜索" class="btn1">&nbsp;&nbsp;&nbsp;&nbsp;
	<input class="btn1" value=" 添加新部门 " name="btnAdd" type="button" onclick="doAdd()">&nbsp;
	</div>
</form>

<br/>
<table cellspacing="1" cellpadding="1" border="0" width="100%" class="ListTbl">
<tr height="20" align="center" class="ListTtl">
<td >部门名称</td>
<td >部门联系电话</td>
<td >操作</td>
</tr>
<c:forEach var="bean" items="${list}">
<tr onmouseout="cancelColor(this)" onmouseover="setColor(this)" bgcolor="#FFFFFF" height="20px" align="center">
<td>
${bean.bumenming }
</td>
<td>
${bean.dianhua }
</td>
<td>
<a href="method!bumenupdate3?id=${bean.id }" class="ListTtlLink" style="color: blue;">查看部门</a>
&nbsp;&nbsp;&nbsp;&nbsp;
<a href="method!bumenupdate?id=${bean.id }" class="ListTtlLink" style="color: blue;">更新部门</a>
&nbsp;&nbsp;&nbsp;&nbsp;
<a href="method!bumendelete?id=${bean.id }" class="ListTtlLink" style="color: blue;">删除部门</a>
</td>
</tr>
</c:forEach>
<tr>
<td colspan="3">
${pagerinfo }
</td>

</tr>
</table>



</body>
