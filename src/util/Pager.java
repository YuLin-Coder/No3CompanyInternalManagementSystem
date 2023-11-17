package util;

/**
 * Title: Pager
 * Description: 分页工具
 */
public class Pager {
	
	//标准列表分页，用于后台
	public static String getPagerNormal(int total, int pagesize, int pagenum,String pageurl,String info) {
		int count = total / pagesize;
		if (total % pagesize > 0) {
			count++;
		}
		if(pageurl.indexOf("?")>-1){
			pageurl = pageurl + "&";
		}else{
			pageurl = pageurl + "?";
		}
		StringBuffer buf = new StringBuffer();
		buf.append(info+"&nbsp;&nbsp;");
		buf.append(pagenum+"/"+ count +"&nbsp;&nbsp;");
		if (pagenum == 1) {
			buf.append("<SPAN style='color:#CCCCCC'>【首页】</SPAN><SPAN style='color:#CCCCCC'>【上一页】</SPAN>&nbsp;&nbsp;");
		} else {
			buf.append("【<a href='" + pageurl + "pagenum=1'>首页</a>】【<a href='" + pageurl + "pagenum=" + (pagenum - 1)
					+ "' >上一页</a>】");
		}
		int bound1 = ((pagenum - 2) <= 0) ? 1 : (pagenum - 2);
		int bound2 = ((pagenum + 2) >= count) ? count : (pagenum + 2);
		for (int i = bound1; i <= bound2; i++) {
			if (i == pagenum) {
				buf.append("<SPAN style='color:#FF0000'>" + i
						+ "</SPAN>&nbsp;&nbsp;");
			} else {
				buf.append("<a href='" + pageurl + "pagenum=" + i + "'>" + i
						+ "</a>&nbsp;&nbsp;");
			}
		}
		if (bound2 < count) {
			buf.append("<SPAN>...</SPAN>");
		}
		if (pagenum == count||count==0) {
			buf.append("<SPAN style='color:#CCCCCC'>【下一页】</SPAN><SPAN style='color:#CCCCCC'>【尾页】</SPAN>");
		} else {
			buf.append("【<a href='" + pageurl + "pagenum=" + (pagenum + 1)
					+ "'>下一页</a>】【<a href='" + pageurl + "pagenum=" + count
					+ "'>尾页</a>】");
		}
		return buf.toString();
	}
}
