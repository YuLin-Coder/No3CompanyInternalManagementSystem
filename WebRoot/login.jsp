<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<title></title>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
-->
</style>
<script language="JavaScript">
function correctPNG()
{
    var arVersion = navigator.appVersion.split("MSIE")
    var version = parseFloat(arVersion[1])
    if ((version >= 5.5) && (document.body.filters)) 
    {
       for(var j=0; j<document.images.length; j++)
       {
          var img = document.images[j]
          var imgName = img.src.toUpperCase()
          if (imgName.substring(imgName.length-3, imgName.length) == "PNG")
          {
             var imgID = (img.id) ? "id='" + img.id + "' " : ""
             var imgClass = (img.className) ? "class='" + img.className + "' " : ""
             var imgTitle = (img.title) ? "title='" + img.title + "' " : "title='" + img.alt + "' "
             var imgStyle = "display:inline-block;" + img.style.cssText 
             if (img.align == "left") imgStyle = "float:left;" + imgStyle
             if (img.align == "right") imgStyle = "float:right;" + imgStyle
             if (img.parentElement.href) imgStyle = "cursor:hand;" + imgStyle
             var strNewHTML = "<span " + imgID + imgClass + imgTitle
             + " style=\"" + "width:" + img.width + "px; height:" + img.height + "px;" + imgStyle + ";"
             + "filter:progid:DXImageTransform.Microsoft.AlphaImageLoader"
             + "(src=\'" + img.src + "\', sizingMethod='scale');\"></span>" 
             img.outerHTML = strNewHTML
             j = j-1
          }
       }
    }    
}
window.attachEvent("onload", correctPNG);
</script>


<link href="images/skin.css" rel="stylesheet" type="text/css">

  
  <body  marginheight="0" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" text="#666666" bgcolor="#336699">
  <table align="center">
  <br/><br/><br/> <tr>                                 
<td width='30%' height="60" align="center" style="font-size:60px; font-weight: bold;">&nbsp;&nbsp;<font color="#fffffb">公司内部管理系统</font></td> </tr>
   &nbsp;&nbsp;&nbsp; <tr>
    
     &nbsp;&nbsp;&nbsp;&nbsp; <td align="center" height="400" valign="middle">
      <form name="myform" action="method!login" method="post">
      <table  background="images/loginA.jpg" width="500" height="300" border="0" cellspacing="0" cellpadding="0" style="margin-top:90" align="center">
          <tr>
            <th height="70" colspan="2" class="" scope="col"></th>
		  </tr>
          <tr>
            <th width="40%" height="30" align="right" scope="row" class="">用户名:</th>
            <td width="60%" height="30" class="">&nbsp;<input name="username" class="editbox4" value="" size="20"></td>
          </tr>
          <tr>
            <th width="40%" height="30" align="right" scope="row" class="">密&nbsp;&nbsp;码:</th>
            <td height="30" class="">&nbsp;<input class="editbox4" type="password" size="20" name="password"></td>
          </tr>
          <tr>
            <th width="40%" height="30" align="right" scope="row" class="">用户角色: </th>
            <td height="30" class="">&nbsp;
               <select name="role">
                   <option value="0">普通员工</option>
                   <option value="1">部门经理</option>
                   <option value="2">总经理</option>
               </select>
            </td>
          <tr>
            <th height="35" colspan="2" scope="row" class=""><input name="Submit" type="submit" class="button" id="Submit" value="登 录"></th></tr>
        </table>
      </form>
      </td>
    </tr>
  </table>
</body>
