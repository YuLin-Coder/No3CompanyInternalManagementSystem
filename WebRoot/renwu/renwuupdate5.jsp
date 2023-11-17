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
<body>

<br/><br/>
<font size="5">更新任务</font>




<form action="method!renwuupdate6" method="post">
<table cellspacing="1" cellpadding="1" border="0" width="70%" class="ListTbl">

<input type="hidden" name="id"    value="${bean.id }"/>

<tr height="20" class="ListTtl">
<td style="font-weight: bold;">
工作任务接收人
</td>
<td style="font-weight: bold;">
${bean.touser.truename }

</td>
</tr>

<tr height="20" class="ListTtl">
<td style="font-weight: bold;">
完成时间
</td>
<td style="font-weight: bold;">
<input type="text" name="shijian"  onfocus='setDayHM(this);'  value="${bean.shijian }"/>
</td>
</tr>

<tr height="20" class="ListTtl">
<td style="font-weight: bold;">
工作完成情况
</td>
<td style="font-weight: bold;">
${bean.wanchengqingkuang }
</td>
</tr>

<tr height="20" class="ListTtl">
<td style="font-weight: bold;">
工作完成汇报
</td>
<td style="font-weight: bold;">
<textarea rows="7" cols="50" name="wanchenghuibao" readonly="readonly">${bean.wanchenghuibao }</textarea>
</td>
</tr>

<tr height="20" class="ListTtl">
<td style="font-weight: bold;">
工作评估
</td>
<td style="font-weight: bold;">
<textarea rows="7" cols="50" name="wanchengpingggu" >${bean.wanchengpingggu }</textarea>
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
