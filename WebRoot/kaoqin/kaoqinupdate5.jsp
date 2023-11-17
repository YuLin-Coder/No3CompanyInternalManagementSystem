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

<body>

<br/><br/>
<font size="5">审核考勤</font>


<form action="method!kaoqinupdate6" method="post">
<table cellspacing="1" cellpadding="1" border="0" width="70%" class="ListTbl">

<input type="hidden" name="id" value="${bean.id }"/>

<tr height="20" class="ListTtl">
<td style="font-weight: bold;">
考勤类型
</td>
<td style="font-weight: bold;">
${bean.leixing }
</td>
</tr>
<tr height="20" class="ListTtl">
<td style="font-weight: bold;">
添加时间
</td>
<td style="font-weight: bold;">
${bean.createtime }
</td>
</tr>


<tr height="20" class="ListTtl">
<td style="font-weight: bold;">
考勤备注
</td>
<td style="font-weight: bold;">
<textarea rows="7" cols="50" name="beizhu" readonly="readonly">${bean.beizhu }</textarea>
</td>
</tr>

<tr height="20" class="ListTtl">
<td style="font-weight: bold;">
审核状态
</td>
<td style="font-weight: bold;">
<select name="shenhezhuangtai">
<option value="审核通过">审核通过</option>
<option value="审核不通过">审核不通过</option>
</select>
</td>
</tr>

<tr height="20" class="ListTtl">
<td style="font-weight: bold;">
审核结果
</td>
<td style="font-weight: bold;">
<textarea rows="7" cols="50" name="shenhejieguo" ></textarea>
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
