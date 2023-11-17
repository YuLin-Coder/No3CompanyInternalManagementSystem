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
<script language="javascript" type="text/javascript">

function uploadform(){


document.getElementById("filenameid").value= document.getElementById("upload").value;
return true;
}
</script>
<body>
<br/><br/>
<font size="5">添加文档</font>





<form action="method!wendangadd2" method="post" enctype="multipart/form-data" onsubmit="return  uploadform()">
<table cellspacing="1" cellpadding="1" border="0" width="70%" class="ListTbl">



<input type="hidden" name="filename" id="filenameid">


<tr height="20" class="ListTtl">
<td style="font-weight: bold;">
文档接收部门
</td>
<td style="font-weight: bold;">
<c:if test="${user.role==2}">
<select name="bumen">
<option value="0">所有部门</option>
<c:forEach items="${list2}" var="bean">
<option value="${bean.id }">${bean.bumenming }</option>
</c:forEach>
</select>
</c:if>
<c:if test="${user.role!=2}">
${user.bumen.bumenming }
<input type="hidden" name="bumen" value="${user.bumen.id }" >
</c:if>
</td>
</tr>


<tr height="20" class="ListTtl">
<td style="font-weight: bold;">
上传文档
</td>
<td style="font-weight: bold;">
<input  name="uploadfile"  type="file"  id="upload"/>
</td>
</tr>

<tr height="20" class="ListTtl">
<td style="font-weight: bold;">
文档标题
</td>
<td style="font-weight: bold;">
<input type="text" name="title" >
</td>
</tr>

<tr height="20" class="ListTtl">
<td style="font-weight: bold;">
文档备注
</td>
<td style="font-weight: bold;">
<textarea rows="7" cols="50" name="content"></textarea>
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
