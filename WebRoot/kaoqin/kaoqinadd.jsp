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
<body>



<br/><br/>
<font size="5">添加考勤</font>




<form action="method!kaoqinadd2" method="post">
<table cellspacing="1" cellpadding="1" border="0" width="70%" class="ListTbl">



<tr height="20" class="ListTtl">
<td style="font-weight: bold;">
考勤类型
</td>
<td style="font-weight: bold;">
<select name="leixing">
<option value="上班登记">上班登记</option>
<option value="下班登记">下班登记</option>
<option value="请假登记">请假登记</option>
<option value="出差登记">出差登记</option>
<option value="外出登记">外出登记</option>
</select>
</td>
</tr>
<tr height="20" class="ListTtl">
<td style="font-weight: bold;">
添加时间
</td>
<td style="font-weight: bold;">
<input type="text" name="createtime" value="${createtime }" readonly="readonly"> 
</td>
</tr>


<tr height="20" class="ListTtl">
<td style="font-weight: bold;">
考勤备注
</td>
<td style="font-weight: bold;">
<textarea rows="7" cols="50" name="beizhu"></textarea>
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
