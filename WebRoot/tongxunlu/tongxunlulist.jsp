<!--<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

</style>
 <script src="js/Calendar.js"></script>
 <script>
//新增
function doAdd(){
	window.location.href="method!tongxunluadd";
}

function doUpdate(){
	window.location.href="method!tongxunluupdate";
}

function doDel(){
	window.location.href="method!tongxunludelete";
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
<font size="5">通讯录</font>


<form action="method!tongxunlulist" method="post">
<div align="left">

真实姓名:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="text" name="truename" value="${truename }">
<input type="submit" value="搜索" class="btn1">
&nbsp;&nbsp;<input class="btn1" value=" 新增通讯录 " name="btnAdd" type="button" onclick="doAdd()">&nbsp;
<c:if test="${flag==1}">
&nbsp;&nbsp;<input class="btn1" value=" 更新通讯录 " name="btnUpdate" type="button" onclick="doUpdate()">&nbsp;
&nbsp;&nbsp;<input class="btn1" value=" 删除通讯录 " name="btnDel" type="button" onclick="doDel()">&nbsp;
</c:if>
</div>

</form>

<table cellspacing="1" cellpadding="1" border="0" width="100%" class="ListTbl">
<tr height="20" align="center" class="ListTtl">
<td style="font-weight: bold;">
真实姓名
</td>
<td style="font-weight: bold;">
联系方式
</td>
<td style="font-weight: bold;">
地址
</td>

</tr>
<c:forEach var="bean" items="${list}">
<tr onmouseout="cancelColor(this)" onmouseover="setColor(this)" bgcolor="#FFFFFF" height="20px" align="center">
<td>
${bean.truename }
</td>

<td>
${bean.lianxidianhua }
</td>
<td>
${bean.zhuzhi }
</td>



</tr>
</c:forEach>
<tr height="20" align="center" class="ListTtl">
<td colspan="4">
${pagerinfo }
</td>

</tr>
</table>



</body>-->
