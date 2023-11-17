<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>管理页面</title>
<script src="js/prototype.lite.js" type="text/javascript"></script>
<script src="js/moo.fx.js" type="text/javascript"></script>
<script src="js/moo.fx.pack.js" type="text/javascript"></script>
<style>
td {font-size: 9pt;line-height: 1.5;}
body {font-size: 9pt;line-height: 1.5;}
a:link { font-size: 9pt; color: #000000; text-decoration: none }
a:visited{ font-size: 9pt; color: #000000; text-decoration: none }
a:hover {font-size: 9pt;color: red}
.topitem{ cursor: hand; 
    background-image:url(<%=request.getContextPath()%>/theme/img/mtbg1.gif);
    height:24px;
    width:98%;
    border-right: 1px solid #2FA1DB;
    border-left: 1px solid #2FA1DB;
    clear:left
}
.itemsct{
  border-right: 1px solid #2FA1DB;
  border-left: 1px solid #2FA1DB;
  background-color:#EEFAFE;
  margin-bottom:6px;
  width:98%;
}
.topl{ float:left;margin-left:6px;margin-right:3px; }
.topr{ padding-top:3px }
body {
  scrollbar-base-color:#8CC1FE;
  scrollbar-arrow-color:#FFFFFF;
  scrollbar-shadow-color:#6994C2
}
</style>



</head>

<body bgcolor="#86C1FF" >
<table width="93%" height="280" border="0" cellpadding="0" cellspacing="0" bgcolor="">
  <tr>
    <td width="182" valign="top"><div id="container">
      
      <c:if test="${user.role==2}">
      
      
      
<div onClick='showHide("items5")' class='topitem' align='left'> 
	<div class='topl'><img src='<%=request.getContextPath()%>/theme/img/mtimg1.gif' width='21' height='24' border='0'></div>
    <div class='topr'>密码修改</div>
</div>
<div style='clear:both'></div>
<div style='display:block' id='items5' class='itemsct'> 
<table width="100%" border="0" align="center" cellPadding="0" cellSpacing="0">
  <tr height="25">
    <td style="border-bottom: #2FA1DB 1px solid;padding-left:5px;"><img src='<%=request.getContextPath()%>/theme/img/newitem.gif' width='7' height='10' alt=''/></td>
    <td style="border-bottom: #2FA1DB 1px solid"><a href="method!changepwd" target="main">密码修改</A></td>
  </tr>
</table>
</div>         
      
      
      
      
      
      <div onClick='showHide("items0")' class='topitem' align='left'> 
	<div class='topl'><img src='<%=request.getContextPath()%>/theme/img/mtimg1.gif' width='21' height='24' border='0'></div>
    <div class='topr'>部门管理</div>
</div>
<div style='clear:both'></div>
<div style='display:block' id='items0' class='itemsct'> 
<table width="100%" border="0" align="center" cellPadding="0" cellSpacing="0">
  <tr height="25">
    <td style="border-bottom: #2FA1DB 1px solid;padding-left:5px;"><img src='<%=request.getContextPath()%>/theme/img/newitem.gif' width='7' height='10' alt=''/></td>
    <td style="border-bottom: #2FA1DB 1px solid"><a href="method!bumenlist" target="main">部门管理</A></td>
  </tr>
</table>
</div>   
      
      
      
      
      
      
      
      
      
      
      
      
      
      

      
      
<div onClick='showHide("items1")' class='topitem' align='left'> 
	<div class='topl'><img src='<%=request.getContextPath()%>/theme/img/mtimg1.gif' width='21' height='24' border='0'></div>
    <div class='topr'>人事管理</div>
</div>
<div style='clear:both'></div>
<div style='display:block' id='items1' class='itemsct'> 
<table width="100%" border="0" align="center" cellPadding="0" cellSpacing="0">
  <tr height="25">
    <td style="border-bottom: #2FA1DB 1px solid;padding-left:5px;"><img src='<%=request.getContextPath()%>/theme/img/newitem.gif' width='7' height='10' alt=''/></td>
    <td style="border-bottom: #2FA1DB 1px solid"><a href="method!userlist" target="main">人事管理</A></td>
  </tr>
</table>
</div>   
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
 
<div onClick='showHide("items2")' class='topitem' align='left'> 
	<div class='topl'><img src='<%=request.getContextPath()%>/theme/img/mtimg1.gif' width='21' height='24' border='0'></div>
    <div class='topr'>信息发布管理</div>
</div>
<div style='clear:both'></div>
<div style='display:block' id='items2' class='itemsct'> 
<table width="100%" border="0" align="center" cellPadding="0" cellSpacing="0">
  <tr height="25">
    <td style="border-bottom: #2FA1DB 1px solid;padding-left:5px;"><img src='<%=request.getContextPath()%>/theme/img/newitem.gif' width='7' height='10' alt=''/></td>
    <td style="border-bottom: #2FA1DB 1px solid"><a href="method!infolist" target="main">信息发布管理</A></td>
  </tr>
</table>
</div>         
      
      
      
      
      
      
 
      
      
<div onClick='showHide("items3")' class='topitem' align='left'> 
	<div class='topl'><img src='<%=request.getContextPath()%>/theme/img/mtimg1.gif' width='21' height='24' border='0'></div>
    <div class='topr'>共享文档管理</div>
</div>
<div style='clear:both'></div>
<div style='display:block' id='items3' class='itemsct'> 
<table width="100%" border="0" align="center" cellPadding="0" cellSpacing="0">
  <tr height="25">
    <td style="border-bottom: #2FA1DB 1px solid;padding-left:5px;"><img src='<%=request.getContextPath()%>/theme/img/newitem.gif' width='7' height='10' alt=''/></td>
    <td style="border-bottom: #2FA1DB 1px solid"><a href="method!wendanglist" target="main">共享文档管理</A></td>
  </tr>
</table>
</div>        
      
      
      
      
      
 
      
      
<!--  <div onClick='showHide("items4")' class='topitem' align='left'> 
	<div class='topl'><img src='<%=request.getContextPath()%>/theme/img/mtimg1.gif' width='21' height='24' border='0'></div>
    <div class='topr'>通讯录管理</div>
</div>
<div style='clear:both'></div>
<div style='display:block' id='items4' class='itemsct'> 
<table width="100%" border="0" align="center" cellPadding="0" cellSpacing="0">
  <tr height="25">
    <td style="border-bottom: #2FA1DB 1px solid;padding-left:5px;"><img src='<%=request.getContextPath()%>/theme/img/newitem.gif' width='7' height='10' alt=''/></td>
    <td style="border-bottom: #2FA1DB 1px solid"><a href="method!tongxunlulist" target="main">通讯录管理</A></td>
  </tr>
</table>
</div> -->        
      
      
      
      
 
      

      

      
      
<div onClick='showHide("items6")' class='topitem' align='left'> 
	<div class='topl'><img src='<%=request.getContextPath()%>/theme/img/mtimg1.gif' width='21' height='24' border='0'></div>
    <div class='topr'>个人消息管理</div>
</div>
<div style='clear:both'></div>
<div style='display:block' id='items6' class='itemsct'> 
<table width="100%" border="0" align="center" cellPadding="0" cellSpacing="0">
  <tr height="25">
    <td style="border-bottom: #2FA1DB 1px solid;padding-left:5px;"><img src='<%=request.getContextPath()%>/theme/img/newitem.gif' width='7' height='10' alt=''/></td>
    <td style="border-bottom: #2FA1DB 1px solid"><a href="method!youjianlist" target="main">发件箱</A></td>
  </tr>
  <tr height="25">
    <td style="border-bottom: #2FA1DB 1px solid;padding-left:5px;"><img src='<%=request.getContextPath()%>/theme/img/newitem.gif' width='7' height='10' alt=''/></td>
    <td style="border-bottom: #2FA1DB 1px solid"><a href="method!youjianlist2" target="main">收件箱</A></td>
  </tr>  
  
</table>
</div>         
      
      
      
      
      
      
      
      
      
      </c:if>
      
      
      
       <c:if test="${user.role==1}">
       
       
       
       
<div onClick='showHide("items73")' class='topitem' align='left'> 
	<div class='topl'><img src='<%=request.getContextPath()%>/theme/img/mtimg1.gif' width='21' height='24' border='0'></div>
    <div class='topr'>修改密码</div>
</div>
<div style='clear:both'></div>
<div style='display:block' id='items73' class='itemsct'> 
<table width="100%" border="0" align="center" cellPadding="0" cellSpacing="0">
  <tr height="25">
    <td style="border-bottom: #2FA1DB 1px solid;padding-left:5px;"><img src='<%=request.getContextPath()%>/theme/img/newitem.gif' width='7' height='10' alt=''/></td>
    <td style="border-bottom: #2FA1DB 1px solid"><a href="method!changepwd" target="main">修改密码</A></td>
  </tr>
</table>
</div>          
       
       
       
       
       
       
       
       
       
<div onClick='showHide("items13")' class='topitem' align='left'> 
	<div class='topl'><img src='<%=request.getContextPath()%>/theme/img/mtimg1.gif' width='21' height='24' border='0'></div>
    <div class='topr'>工作任务管理</div>
</div>
<div style='clear:both'></div>
<div style='display:block' id='items13' class='itemsct'> 
<table width="100%" border="0" align="center" cellPadding="0" cellSpacing="0">
  <tr height="25">
    <td style="border-bottom: #2FA1DB 1px solid;padding-left:5px;"><img src='<%=request.getContextPath()%>/theme/img/newitem.gif' width='7' height='10' alt=''/></td>
    <td style="border-bottom: #2FA1DB 1px solid"><a href="method!renwulist" target="main">工作任务管理</A></td>
  </tr>
</table>
</div>         
      
      
      
      
      
      
      
      
      
      

      
      
<div onClick='showHide("items23")' class='topitem' align='left'> 
	<div class='topl'><img src='<%=request.getContextPath()%>/theme/img/mtimg1.gif' width='21' height='24' border='0'></div>
    <div class='topr'>部门考勤管理</div>
</div>
<div style='clear:both'></div>
<div style='display:block' id='items3' class='itemsct'> 
<table width="100%" border="0" align="center" cellPadding="0" cellSpacing="0">
  <tr height="25">
    <td style="border-bottom: #2FA1DB 1px solid;padding-left:5px;"><img src='<%=request.getContextPath()%>/theme/img/newitem.gif' width='7' height='10' alt=''/></td>
    <td style="border-bottom: #2FA1DB 1px solid"><a href="method!kaoqinlist2" target="main">部门考勤管理</A></td>
  </tr>
</table>
</div>        











       
       
 
      
      
      
<div onClick='showHide("items23")' class='topitem' align='left'> 
	<div class='topl'><img src='<%=request.getContextPath()%>/theme/img/mtimg1.gif' width='21' height='24' border='0'></div>
    <div class='topr'>部门人事管理</div>
</div>
<div style='clear:both'></div>
<div style='display:block' id='items23' class='itemsct'> 
<table width="100%" border="0" align="center" cellPadding="0" cellSpacing="0">
  <tr height="25">
    <td style="border-bottom: #2FA1DB 1px solid;padding-left:5px;"><img src='<%=request.getContextPath()%>/theme/img/newitem.gif' width='7' height='10' alt=''/></td>
    <td style="border-bottom: #2FA1DB 1px solid"><a href="method!userlist2" target="main">部门人事管理</A></td>
  </tr>
</table>
</div>         
      
      
      
      
      
      
      
      
      
      
      

      
      
<div onClick='showHide("items33")' class='topitem' align='left'> 
	<div class='topl'><img src='<%=request.getContextPath()%>/theme/img/mtimg1.gif' width='21' height='24' border='0'></div>
    <div class='topr'>部门信息发布管理</div>
</div>
<div style='clear:both'></div>
<div style='display:block' id='items33' class='itemsct'> 
<table width="100%" border="0" align="center" cellPadding="0" cellSpacing="0">
  <tr height="25">
    <td style="border-bottom: #2FA1DB 1px solid;padding-left:5px;"><img src='<%=request.getContextPath()%>/theme/img/newitem.gif' width='7' height='10' alt=''/></td>
    <td style="border-bottom: #2FA1DB 1px solid"><a href="method!infolist2" target="main">部门信息发布管理</A></td>
  </tr>
</table>
</div>          
      
      
      
      
      
      
      
      
      
      
  
      
      
<div onClick='showHide("items43")' class='topitem' align='left'> 
	<div class='topl'><img src='<%=request.getContextPath()%>/theme/img/mtimg1.gif' width='21' height='24' border='0'></div>
    <div class='topr'>部门共享文档管理</div>
</div>
<div style='clear:both'></div>
<div style='display:block' id='items43' class='itemsct'> 
<table width="100%" border="0" align="center" cellPadding="0" cellSpacing="0">
  <tr height="25">
    <td style="border-bottom: #2FA1DB 1px solid;padding-left:5px;"><img src='<%=request.getContextPath()%>/theme/img/newitem.gif' width='7' height='10' alt=''/></td>
    <td style="border-bottom: #2FA1DB 1px solid"><a href="method!wendanglist2" target="main">部门共享文档管理</A></td>
  </tr>
</table>
</div>       
      
      
      
      
      
      
      
      
      

      
      
      

      
      
      
      
      
      
      
 
      
<div onClick='showHide("items53")' class='topitem' align='left'> 
	<div class='topl'><img src='<%=request.getContextPath()%>/theme/img/mtimg1.gif' width='21' height='24' border='0'></div>
    <div class='topr'>个人消息管理</div>
</div>
<div style='clear:both'></div>
<div style='display:block' id='items53' class='itemsct'> 
<table width="100%" border="0" align="center" cellPadding="0" cellSpacing="0">
  <tr height="25">
    <td style="border-bottom: #2FA1DB 1px solid;padding-left:5px;"><img src='<%=request.getContextPath()%>/theme/img/newitem.gif' width='7' height='10' alt=''/></td>
    <td style="border-bottom: #2FA1DB 1px solid"><a href="method!youjianlist" target="main">发件箱</A></td>
  </tr>
  <tr height="25">
    <td style="border-bottom: #2FA1DB 1px solid;padding-left:5px;"><img src='<%=request.getContextPath()%>/theme/img/newitem.gif' width='7' height='10' alt=''/></td>
    <td style="border-bottom: #2FA1DB 1px solid"><a href="method!youjianlist2" target="main">收件箱</A></td>
  </tr>  
</table>
</div>          
      
      
      
      

      
      
      
      

       
       
       

       
       
       
       
       
       
       
       
       </c:if>
       
       
       <c:if test="${user.role==0}">
       
       
       
<div onClick='showHide("items83")' class='topitem' align='left'> 
	<div class='topl'><img src='<%=request.getContextPath()%>/theme/img/mtimg1.gif' width='21' height='24' border='0'></div>
    <div class='topr'>修改密码</div>
</div>
<div style='clear:both'></div>
<div style='display:block' id='items83' class='itemsct'> 
<table width="100%" border="0" align="center" cellPadding="0" cellSpacing="0">
  <tr height="25">
    <td style="border-bottom: #2FA1DB 1px solid;padding-left:5px;"><img src='<%=request.getContextPath()%>/theme/img/newitem.gif' width='7' height='10' alt=''/></td>
    <td style="border-bottom: #2FA1DB 1px solid"><a href="method!changepwd" target="main">修改密码</a></td>
  </tr>
</table>
</div>          

      
      
      
      
<div onClick='showHide("items93")' class='topitem' align='left'> 
	<div class='topl'><img src='<%=request.getContextPath()%>/theme/img/mtimg1.gif' width='21' height='24' border='0'></div>
    <div class='topr'>个人考勤管理</div>
</div>
<div style='clear:both'></div>
<div style='display:block' id='items93' class='itemsct'> 
<table width="100%" border="0" align="center" cellPadding="0" cellSpacing="0">
  <tr height="25">
    <td style="border-bottom: #2FA1DB 1px solid;padding-left:5px;"><img src='<%=request.getContextPath()%>/theme/img/newitem.gif' width='7' height='10' alt=''/></td>
    <td style="border-bottom: #2FA1DB 1px solid"><a href="method!kaoqinlist" target="main">个人考勤管理</A></td>
  </tr>
</table>
</div>        
      
      
      
  
  
  
<div onClick='showHide("items103")' class='topitem' align='left'> 
	<div class='topl'><img src='<%=request.getContextPath()%>/theme/img/mtimg1.gif' width='21' height='24' border='0'></div>
    <div class='topr'>部门共享文档</div>
</div>
<div style='clear:both'></div>
<div style='display:block' id='items103' class='itemsct'> 
<table width="100%" border="0" align="center" cellPadding="0" cellSpacing="0">
  <tr height="25">
    <td style="border-bottom: #2FA1DB 1px solid;padding-left:5px;"><img src='<%=request.getContextPath()%>/theme/img/newitem.gif' width='7' height='10' alt=''/></td>
    <td style="border-bottom: #2FA1DB 1px solid"><a href="method!wendanglist3" target="main">部门共享文档</A></td>
  </tr>
</table>
</div>        
        
  
  
  
  
  
  
  
  
  
      
      
      
      
      
<div onClick='showHide("items113")' class='topitem' align='left'> 
	<div class='topl'><img src='<%=request.getContextPath()%>/theme/img/mtimg1.gif' width='21' height='24' border='0'></div>
    <div class='topr'>公司信息查询</div>
</div>
<div style='clear:both'></div>
<div style='display:block' id='items113' class='itemsct'> 
<table width="100%" border="0" align="center" cellPadding="0" cellSpacing="0">
  <tr height="25">
    <td style="border-bottom: #2FA1DB 1px solid;padding-left:5px;"><img src='<%=request.getContextPath()%>/theme/img/newitem.gif' width='7' height='10' alt=''/></td>
    <td style="border-bottom: #2FA1DB 1px solid"><a href="method!infolist3" target="main">公司信息查询</A></td>
  </tr>
</table>
</div>        
      
      
      
      
      
      

      
<div onClick='showHide("items123")' class='topitem' align='left'> 
	<div class='topl'><img src='<%=request.getContextPath()%>/theme/img/mtimg1.gif' width='21' height='24' border='0'></div>
    <div class='topr'>个人办公管理</div>
</div>
<div style='clear:both'></div>
<div style='display:block' id='items123' class='itemsct'> 
<table width="100%" border="0" align="center" cellPadding="0" cellSpacing="0">
  <tr height="25">
    <td style="border-bottom: #2FA1DB 1px solid;padding-left:5px;"><img src='<%=request.getContextPath()%>/theme/img/newitem.gif' width='7' height='10' alt=''/></td>
    <td style="border-bottom: #2FA1DB 1px solid"><a href="method!renwulist2" target="main">工作任务管理</A></td>
  </tr>
  <tr height="25">
    <td style="border-bottom: #2FA1DB 1px solid;padding-left:5px;"><img src='<%=request.getContextPath()%>/theme/img/newitem.gif' width='7' height='10' alt=''/></td>
    <td style="border-bottom: #2FA1DB 1px solid"><a href="method!gongzuorizhilist" target="main">工作日志管理</A></td>
  </tr>  
</table>
</div>        
      
      
      
      
      
      
      

      

      
      
      
      

     
      
      

       
       
             
       

       
       
<div onClick='showHide("items143")' class='topitem' align='left'> 
	<div class='topl'><img src='<%=request.getContextPath()%>/theme/img/mtimg1.gif' width='21' height='24' border='0'></div>
    <div class='topr'>个人消息管理</div>
</div>
<div style='clear:both'></div>
<div style='display:block' id='items143' class='itemsct'> 
<table width="100%" border="0" align="center" cellPadding="0" cellSpacing="0">
  <tr height="25">
    <td style="border-bottom: #2FA1DB 1px solid;padding-left:5px;"><img src='<%=request.getContextPath()%>/theme/img/newitem.gif' width='7' height='10' alt=''/></td>
    <td style="border-bottom: #2FA1DB 1px solid"><a href="method!youjianlist" target="main">发件箱</a></td>
  </tr>
  
  <tr height="25">
    <td style="border-bottom: #2FA1DB 1px solid;padding-left:5px;"><img src='<%=request.getContextPath()%>/theme/img/newitem.gif' width='7' height='10' alt=''/></td>
    <td style="border-bottom: #2FA1DB 1px solid"><a href="method!youjianlist2" target="main">收件箱</a></td>
  </tr>  
</table>
</div>          
       
       
       
       
       
       
       
       
       
       </c:if>
       
       
       
       
<div onClick='showHide("items11")' class='topitem' align='left'> 
	<div class='topl'><img src='<%=request.getContextPath()%>/theme/img/mtimg1.gif' width='21' height='24' border='0'></div>
    <div class='topr'>退出系统</div>
</div>
<div style='clear:both'></div>
<div style='display:block' id='items11' class='itemsct'> 
<table width="100%" border="0" align="center" cellPadding="0" cellSpacing="0">
  <tr height="25">
    <td style="border-bottom: #2FA1DB 1px solid;padding-left:5px;"><img src='<%=request.getContextPath()%>/theme/img/newitem.gif' width='7' height='10' alt=''/></td>
    <td style="border-bottom: #2FA1DB 1px solid"><a href="#" target="_self" onClick="logout();">退出系统</a></td>
  </tr>
</table>
</div>        
       
       
       
       
       
       
       
       
     
      
      </div>
      
      

      
      
      
      
      
 
      
      
<%--      
        <script type="text/javascript">
		var contents = document.getElementsByClassName('content');
		var toggles = document.getElementsByClassName('type');
	
		var myAccordion = new fx.Accordion(
			toggles, contents, {opacity: true, duration: 400}
		);
		myAccordion.showThisHideOpen(contents[0]);
	</script>
 --%>	
<script language="javascript">
function showHide(objname)
{
    var obj = document.getElementById(objname);
    if(obj.style.display == "none") obj.style.display = "block";
    else{ if(document.all) obj.style.display = "none"; }
}
</script>
	
<script language=JavaScript>
function logout(){
	if (confirm("您确定要退出系统吗？"))
	top.location = "method!loginout";
	return false;
}
</script>
</td>
  </tr>
</table>
</body>
</html>
