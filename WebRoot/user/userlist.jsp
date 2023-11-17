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
<br/><br/>
<font size="5">员工管理</font>


<form action="method!userlist" method="post">
<div align="left">
部门名称:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<select name="bumen">
<option value="">所有部门</option>
<c:forEach items="${list2}" var="bean">
<option value="${bean.bumenming }" <c:if test="${bumen==bean.bumenming  }">selected</c:if>  >${bean.bumenming }</option>
</c:forEach>
</select>

员工姓名:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="text" name="truename" value="${truename }">

<input type="submit" value="搜索" class="btn1">
</div>
</form>

<a href="method!useradd"><span style="font-size: 20px;color: blue;">添加新员工</span></a>
<br/>
<table cellspacing="1" cellpadding="1" border="0" width="100%" class="ListTbl">
<tr height="20" align="center" class="ListTtl">
<td style="font-weight: bold;" >
用户名
</td>
<%--
<td style="font-weight: bold;">
密码
 --%>
</td>
<td style="font-weight: bold;">
员工姓名
</td>
<td style="font-weight: bold;">
职位
</td>

<td style="font-weight: bold;">
所属部门
</td>

<td style="font-weight: bold;">
添加时间
</td>
<td style="font-weight: bold;">
操作
</td>

</tr>

<c:forEach var="bean" items="${list}">
<tr onmouseout="cancelColor(this)" onmouseover="setColor(this)" bgcolor="#FFFFFF" height="20px" align="center">
<td>
${bean.username }
</td>
<%--
<td>
${bean.password }
</td>
 --%>
<td>
${bean.truename }
</td>

<td>
<c:if test="${bean.bumen2!=null }">${bean.bumen2.bumenming }部门经理</c:if>
<c:if test="${bean.bumen2==null }">${bean.bumen.bumenming }部门员工</c:if>
</td>

<td>
${bean.bumen.bumenming }
</td>



<td>
${fn:substring(bean.createtime,0, 19)}
</td>

<td>
<a href="method!userupdate3?id=${bean.id }" class="ListTtlLink" style="color: blue;">查看详细信息</a>
&nbsp;&nbsp;&nbsp;&nbsp;
<a href="method!userupdate?id=${bean.id }" class="ListTtlLink" style="color: blue;">更新员工信息</a>
&nbsp;&nbsp;&nbsp;&nbsp;
<a href="method!userdelete?id=${bean.id }" class="ListTtlLink" style="color: blue;">删除员工</a>
&nbsp;&nbsp;&nbsp;&nbsp;
<a href="method!userdelete2?id=${bean.id }" class="ListTtlLink" style="color: blue;">提升为部门经理</a>
</td>

</tr>
</c:forEach>


<tr height="20" align="center" class="ListTtl">
<td colspan="12">
${pagerinfo }
</td>

</tr>
</table>



</body>
