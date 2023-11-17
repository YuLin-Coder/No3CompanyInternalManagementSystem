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
<body>
<br/><br/>
<font size="5">更新通讯录</font>





<form action="method!tongxunluupdate2" method="post">
<table cellspacing="1" cellpadding="1" border="0" width="70%" class="ListTbl">




<input type="hidden" name="id"   value="${bean.id }" />

<tr height="20" class="ListTtl">
<td style="font-weight: bold;">
真实姓名
</td>
<td style="font-weight: bold;">
<input type="text" name="truename"    value="${bean.truename }"/>
</td>
</tr>


<tr height="20" class="ListTtl">
<td style="font-weight: bold;">
联系方式
</td>
<td style="font-weight: bold;">
<input type="text" name="lianxidianhua"   value="${bean.lianxidianhua }" />
</td>
</tr>

<tr height="20" class="ListTtl">
<td style="font-weight: bold;">
地址
</td>
<td style="font-weight: bold;">
<input type="text" name="zhuzhi"   value="${bean.zhuzhi }" />
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

</body>-->
