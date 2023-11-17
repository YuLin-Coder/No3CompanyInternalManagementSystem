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
<font size="5">考勤审核管理</font>

<form action="method!kaoqinlist2" method="post">
<div align="left">

考勤类型:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<select name="leixing">
<option value="">所有类型</option>
<option value="上班登记"<c:if test="${leixing=='上班登记'  }">selected</c:if>>上班登记</option>
<option value="下班登记"<c:if test="${leixing=='下班登记'  }">selected</c:if>>下班登记</option>
<option value="请假登记"<c:if test="${leixing=='请假登记'  }">selected</c:if>>请假登记</option>
<option value="出差登记"<c:if test="${leixing=='出差登记'  }">selected</c:if>>出差登记</option>
<option value="外出登记"<c:if test="${leixing=='外出登记'  }">selected</c:if>>外出登记</option>

</select>

审核状态:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<select name="shenhezhuangtai">
<option value="">所有状态</option>
<option value="未审核"<c:if test="${shenhezhuangtai=='未审核'  }">selected</c:if>>未审核</option>
<option value="审核通过"<c:if test="${shenhezhuangtai=='审核通过'  }">selected</c:if>>审核通过</option>
<option value="审核不通过"<c:if test="${shenhezhuangtai=='审核不通过'  }">selected</c:if>>审核不通过</option>


</select>


<input type="submit" value="搜索" class="btn1">
</div>
</form>


<br/>
<table cellspacing="1" cellpadding="1" border="0" width="100%" class="ListTbl">
<tr height="20" align="center" class="ListTtl">
<td style="font-weight: bold;">
考勤类型
</td>
<td style="font-weight: bold;">
审核状态
</td>

<td style="font-weight: bold;">
添加用户
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
${bean.leixing }
</td>

<td>
${bean.shenhezhuangtai }
</td>

<td>
${bean.user.truename }
</td>


<td>
${fn:substring(bean.createtime,0, 19)}
</td>
<td>
<a href="method!kaoqinupdate3?id=${bean.id }" class="ListTtlLink" style="color: blue;">查看详细信息</a>
&nbsp;&nbsp;&nbsp;&nbsp;
<c:if test="${bean.shenhezhuangtai=='未审核'}">
<a href="method!kaoqinupdate5?id=${bean.id }" class="ListTtlLink" style="color: blue;">审核考勤</a>
</c:if>

</td>
</tr>
</c:forEach>
<tr height="20" align="center" class="ListTtl">
<td colspan="6">
${pagerinfo }
</td>

</tr>
</table>



</body>
