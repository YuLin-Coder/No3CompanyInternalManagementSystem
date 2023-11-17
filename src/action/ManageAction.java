package action;


import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Bumen;
import model.Gongzuorizhi;
import model.Info;
import model.Kaoqin;
import model.Renwu;
import model.Tongxunlu;
import model.User;
import model.Wendang;
import model.Youjian;

import org.apache.struts2.ServletActionContext;

import util.Pager;
import util.Util;


import com.opensymphony.xwork2.ActionSupport;

import dao.BumenDao;
import dao.GongzuorizhiDao;
import dao.InfoDao;
import dao.KaoqinDao;
import dao.RenwuDao;
import dao.TongxunluDao;
import dao.UserDao;
import dao.WendangDao;
import dao.YoujianDao;

public class ManageAction extends ActionSupport{
	
	
	private static final long serialVersionUID = -4304509122548259589L;
	
	private UserDao userDao;
	
	private String url = "./";
	
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	//程序入口界面
	public String index(){
		HttpServletRequest request = ServletActionContext.getRequest();
		Util.init(request);
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		if(user==null){
			return "success2";
		}else{
			return "success1";
		}
	}
	
	
	//登录操作
	public String login() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String role = request.getParameter("role");
		User user = userDao.selectBean(" where username = '"+username +"' and password= '"+password +"' and userlock=0 and role="+role);
		if (user!=null) {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			this.setUrl("index");
			return "redirect";
		} else {
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("gbk");response.setContentType("text/html; charset=gbk");
			response
					.getWriter()
					.print(
							"<script language=javascript>alert('用户名或者密码错误');window.location.href='login.jsp';</script>");
		}
		return null;
	}
	
	//用户退出操作
	public String loginout() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		session.removeAttribute("user");
		this.setUrl("login.jsp");
		return SUCCESS;
	}
	//跳转到修改密码页面
	public String changepwd() {
		this.setUrl("user/password.jsp");
		return SUCCESS;
	}
	
	//修改密码操作
	public void changepwd2() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		
		HttpSession session = request.getSession();
		User u = (User)session.getAttribute("user");
		String password1 = request.getParameter("password1");
		String password2 = request.getParameter("password2");
		User bean = userDao.selectBean(" where username= '"+u.getUsername()+"' and password= '"+password1+"'");
		if(bean!=null){
			bean.setPassword(password2);
			userDao.updateBean(bean);
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("gbk");response.setContentType("text/html; charset=gbk");
			response
					.getWriter()
					.print(
							"<script language=javascript>alert('success!');</script>");
		}else{
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("gbk");response.setContentType("text/html; charset=gbk");
			response
					.getWriter()
					.print(
							"<script language=javascript>alert('用户名或者密码错误');</script>");
		}
	}
	
	private BumenDao bumenDao;
	
	
	public BumenDao getBumenDao() {
		return bumenDao;
	}

	public void setBumenDao(BumenDao bumenDao) {
		this.bumenDao = bumenDao;
	}
//部门列表
	public String bumenlist()  {
		HttpServletRequest request = ServletActionContext.getRequest();
		String bumenming = request.getParameter("bumenming");
		
		StringBuffer sb = new StringBuffer();
		sb.append(" where ");
		StringBuffer sb2 = new StringBuffer();
		sb2.append(" where ");

		if(bumenming!=null&&!"".equals(bumenming)){
			sb.append("bumenming like '%"+bumenming+"%'");
			sb.append(" and ");
			sb2.append("bumenming like '%"+bumenming+"%'");
			sb2.append(" and ");

			request.setAttribute("bumenming", bumenming);
		}
		sb.append(" bumenlock=0 order by id desc");
		String where = sb.toString();
		sb2.append(" bumenlock=0 ");
		String where2 = sb2.toString();
		int currentpage = 1;
		int pagesize =20;
		if(request.getParameter("pagenum")!=null){
			currentpage = Integer.parseInt(request.getParameter("pagenum"));
		}
		int total = bumenDao.selectBeanCount(where2);
		request.setAttribute("list", bumenDao.selectBeanList((currentpage - 1) * pagesize, pagesize, where));
		request.setAttribute("pagerinfo", Pager.getPagerNormal(total, pagesize,
				currentpage, "method!bumenlist", "共有" + total + "条记录"));
		this.setUrl("bumen/bumenlist.jsp");
		return SUCCESS;
	}

//跳转到添加部门页面
	public String bumenadd() {
		this.setUrl("bumen/bumenadd.jsp");
		return SUCCESS;
	}
//添加部门操作	
	public void bumenadd2() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		String bumenming = request.getParameter("bumenming");
		String jianjie = request.getParameter("jianjie");
		String dianhua = request.getParameter("dianhua");
	
		Bumen bean = new Bumen();
		bean.setBumenming(bumenming);
		bean.setDianhua(dianhua);
		bean.setJianjie(jianjie);
		bumenDao.insertBean(bean);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("gbk");response.setContentType("text/html; charset=gbk");
		response
				.getWriter()
				.print(
						"<script language=javascript>alert('success!');window.location.href='method!bumenlist';</script>");

		
	}
//跳转到更新部门页面	
	public String bumenupdate() {
		HttpServletRequest request = ServletActionContext.getRequest();
		Bumen bean = bumenDao.selectBean(" where id= "+request.getParameter("id"));
		request.setAttribute("bean", bean);
		this.setUrl("bumen/bumenupdate.jsp");
		return SUCCESS;
	}
//更新部门操作
	public void bumenupdate2() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		String bumenming = request.getParameter("bumenming");
		String jianjie = request.getParameter("jianjie");
		String dianhua = request.getParameter("dianhua");
	
		Bumen bean = bumenDao.selectBean(" where id= "+request.getParameter("id"));
		bean.setBumenming(bumenming);
		bean.setDianhua(dianhua);
		bean.setJianjie(jianjie);
		bumenDao.updateBean(bean);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("gbk");response.setContentType("text/html; charset=gbk");
		response
				.getWriter()
				.print(
						"<script language=javascript>alert('success!');window.location.href='method!bumenlist';</script>");
	}
//查看部门操作	

	public String bumenupdate3() {
		HttpServletRequest request = ServletActionContext.getRequest();
		Bumen bean = bumenDao.selectBean(" where id= "+request.getParameter("id"));
		request.setAttribute("bean", bean);
		this.setUrl("bumen/bumenupdate3.jsp");
		return SUCCESS;
	}
//删除部门操作
	public void bumendelete() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		Bumen bean = bumenDao.selectBean(" where id= "+request.getParameter("id"));
		bean.setBumenlock(1);
		bumenDao.updateBean(bean);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("gbk");response.setContentType("text/html; charset=gbk");
		response
				.getWriter()
				.print(
						"<script language=javascript>alert('success!');window.location.href='method!bumenlist';</script>");
	}
	
	
//员工列表	
	public String userlist()  {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("list2", bumenDao.selectBeanList(0, 9999, "  where bumenlock=0 " ));
		
		String truename = request.getParameter("truename");
		String bumen = request.getParameter("bumen");

		
		StringBuffer sb = new StringBuffer();
		sb.append(" where ");
		StringBuffer sb2 = new StringBuffer();
		sb2.append(" where ");

		if(truename!=null&&!"".equals(truename)){
			sb.append("truename like '%"+truename+"%'");
			sb.append(" and ");
			sb2.append("truename like '%"+truename+"%'");
			sb2.append(" and ");
			request.setAttribute("truename", truename);
		}
		
		if(bumen!=null&&!"".equals(bumen)){
			sb.append("bumen.bumenming like '%"+bumen+"%'");
			sb.append(" and ");
			sb2.append("bumen.bumenming like '%"+bumen+"%'");
			sb2.append(" and ");

			request.setAttribute("bumen", bumen);
		}
		sb.append(" userlock=0 and role !=2 order by bumen2 desc");
		String where = sb.toString();
		sb2.append(" userlock=0 and role !=2");
		String where2 = sb2.toString();
		int currentpage = 1;
		int pagesize =20;
		if(request.getParameter("pagenum")!=null){
			currentpage = Integer.parseInt(request.getParameter("pagenum"));
		}
		int total = userDao.selectBeanCount(where2);
		request.setAttribute("list", userDao.selectBeanList((currentpage - 1) * pagesize, pagesize, where));
		request.setAttribute("pagerinfo", Pager.getPagerNormal(total, pagesize,
				currentpage, "method!userlist", "共有" + total + "条记录"));
		this.setUrl("user/userlist.jsp");
		return SUCCESS;
	}

//跳转到添加员工页面
	public String useradd() {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("list2", bumenDao.selectBeanList(0, 9999, "  where bumenlock=0 " ));
		this.setUrl("user/useradd.jsp");
		return SUCCESS;
	}
	//添加员工操作
	public void useradd2() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		String bumen = request.getParameter("bumen");
		String lianxidianhua = request.getParameter("lianxidianhua");
		String jianjie = request.getParameter("jianjie");
		String ruzhishijian = request.getParameter("ruzhishijian");
		String sfz = request.getParameter("sfz");
		String truename = request.getParameter("truename");
		String xingbie = request.getParameter("xingbie");
		String zhuzhi = request.getParameter("zhuzhi");
		String username = request.getParameter("username");
		User bean = userDao.selectBean(" where username='"+username+"' ");
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		if(bean ==null){
			bean = new User();
			bean.setBumen(bumenDao.selectBean(" where id= "+bumen));
			bean.setCreatetime(new Date());
			bean.setJianjie(jianjie);
			bean.setLianxidianhua(lianxidianhua);
			bean.setPassword("111111");
			bean.setRuzhishijian(ruzhishijian);
			bean.setSfz(sfz);
			bean.setTruename(truename);
			bean.setXingbie(xingbie);
			bean.setZhuzhi(zhuzhi);
			bean.setJianjie(jianjie);
			bean.setUsername(username);
			userDao.insertBean(bean);
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("gbk");response.setContentType("text/html; charset=gbk");
			
			if(user.getRole()==2){
				response
				.getWriter()
				.print(
						"<script language=javascript>alert('success!');window.location.href='method!userlist';</script>");
			}else{
				response
				.getWriter()
				.print(
						"<script language=javascript>alert('success!');window.location.href='method!userlist2';</script>");
			}
			
		}else {
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("gbk");response.setContentType("text/html; charset=gbk");
			if(user.getRole()==2){
				response
				.getWriter()
				.print(
						"<script language=javascript>alert('该用户名已经存在，操作失败');window.location.href='method!userlist';</script>");
			}else{
				response
				.getWriter()
				.print(
						"<script language=javascript>alert('该用户名已经存在，操作失败');window.location.href='method!userlist2';</script>");
			}
			
		}
		

		
	}
	//跳转到更新员工页面
	public String userupdate() {
		HttpServletRequest request = ServletActionContext.getRequest();
		User bean = userDao.selectBean(" where id= "+request.getParameter("id"));
		request.setAttribute("bean", bean);
		request.setAttribute("list2", bumenDao.selectBeanList(0, 9999, "  where bumenlock=0 " ));
		this.setUrl("user/userupdate.jsp");
		return SUCCESS;
	}
//更新员工操作
	public void userupdate2() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		String lianxidianhua = request.getParameter("lianxidianhua");
		String jianjie = request.getParameter("jianjie");
		String ruzhishijian = request.getParameter("ruzhishijian");
		String sfz = request.getParameter("sfz");
		String truename = request.getParameter("truename");
		String xingbie = request.getParameter("xingbie");
		String zhuzhi = request.getParameter("zhuzhi");
		
		String bumen = request.getParameter("bumen");
	
		User bean = userDao.selectBean(" where id= "+request.getParameter("id"));
		bean.setBumen(bumenDao.selectBean(" where id= "+bumen));
		bean.setJianjie(jianjie);
		bean.setLianxidianhua(lianxidianhua);
		bean.setRuzhishijian(ruzhishijian);
		bean.setSfz(sfz);
		bean.setTruename(truename);
		bean.setXingbie(xingbie);
		bean.setZhuzhi(zhuzhi);
		bean.setJianjie(jianjie);
		userDao.updateBean(bean);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("gbk");response.setContentType("text/html; charset=gbk");
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		if(user.getRole()==2){
			response
			.getWriter()
			.print(
					"<script language=javascript>alert('success!');window.location.href='method!userlist';</script>");
		}else{
			response
			.getWriter()
			.print(
					"<script language=javascript>alert('success!');window.location.href='method!userlist2';</script>");
		}
		
	}
	
//查看员工信息
	public String userupdate3() {
		HttpServletRequest request = ServletActionContext.getRequest();
		User bean = userDao.selectBean(" where id= "+request.getParameter("id"));
		request.setAttribute("bean", bean);
		this.setUrl("user/userupdate3.jsp");
		return SUCCESS;
	}
//删除员工信息
	public void userdelete() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		User bean = userDao.selectBean(" where id= "+request.getParameter("id"));
		bean.setUserlock(1);
		bean.setUsername(bean.getUsername()+"_delete");
		userDao.updateBean(bean);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("gbk");response.setContentType("text/html; charset=gbk");
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		if(user.getRole()==2){
			response
			.getWriter()
			.print(
					"<script language=javascript>alert('success!');window.location.href='method!userlist';</script>");
		}else{
			response
			.getWriter()
			.print(
					"<script language=javascript>alert('success!');window.location.href='method!userlist2';</script>");
		}
	}
	//提升为部门经理操作
	public void userdelete2() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		User bean = userDao.selectBean(" where id= "+request.getParameter("id"));
		List<User> list = userDao.selectBeanList(0, 9999, " where bumen2.id= "+bean.getBumen().getId());
		for(User user :list){
			user.setRole(0);
			user.setBumen2(null);
			userDao.updateBean(user);
		}
		bean.setRole(1);
		bean.setBumen2(bean.getBumen());
		userDao.updateBean(bean);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("gbk");response.setContentType("text/html; charset=gbk");
		response
				.getWriter()
				.print(
						"<script language=javascript>alert('success!');window.location.href='method!userlist';</script>");
	}
	
	private InfoDao infoDao;
	
	public InfoDao getInfoDao() {
		return infoDao;
	}

	public void setInfoDao(InfoDao infoDao) {
		this.infoDao = infoDao;
	}
//公司信息列表
	public String infolist()  {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("list2", bumenDao.selectBeanList(0, 9999, "  where bumenlock=0 " ));
		
		String title = request.getParameter("title");
		String bumen = request.getParameter("bumen");
		String leixing = request.getParameter("leixing");

		
		StringBuffer sb = new StringBuffer();
		sb.append(" where ");
		StringBuffer sb2 = new StringBuffer();
		sb2.append(" where ");

		if(title!=null&&!"".equals(title)){
			sb.append("title like '%"+title+"%'");
			sb.append(" and ");
			sb2.append("title like '%"+title+"%'");
			sb2.append(" and ");
			request.setAttribute("title", title);
		}
		
		if(leixing!=null&&!"".equals(leixing)){
			sb.append("leixing like '%"+leixing+"%'");
			sb.append(" and ");
			sb2.append("leixing like '%"+leixing+"%'");
			sb2.append(" and ");
			request.setAttribute("leixing", leixing);
		}
		
		if(bumen!=null&&!"".equals(bumen)){
			sb.append("bumen.bumenming like '%"+bumen+"%'");
			sb.append(" and ");
			sb2.append("bumen.bumenming like '%"+bumen+"%'");
			sb2.append(" and ");

			request.setAttribute("bumen", bumen);
		}
		sb.append(" infolock=0 order by id desc");
		String where = sb.toString();
		sb2.append(" infolock=0 ");
		String where2 = sb2.toString();
		int currentpage = 1;
		int pagesize =20;
		if(request.getParameter("pagenum")!=null){
			currentpage = Integer.parseInt(request.getParameter("pagenum"));
		}
		int total = infoDao.selectBeanCount(where2);
		request.setAttribute("list", infoDao.selectBeanList((currentpage - 1) * pagesize, pagesize, where));
		request.setAttribute("pagerinfo", Pager.getPagerNormal(total, pagesize,
				currentpage, "method!infolist", "共有" + total + "条记录"));
		this.setUrl("info/infolist.jsp");
		return SUCCESS;
	}

//跳转到添加信息页面
	public String infoadd() {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("list2", bumenDao.selectBeanList(0, 9999, "  where bumenlock=0 " ));
		this.setUrl("info/infoadd.jsp");
		return SUCCESS;
	}
	//添加信息操作
	public void infoadd2() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		String bumen = request.getParameter("bumen");
		String content = request.getParameter("content");
		String title = request.getParameter("title");
		String leixing = request.getParameter("leixing");
		Info bean = new Info();
		if(!"0".equals(bumen)){
			bean.setBumen(bumenDao.selectBean(" where id= "+bumen));
		}
		bean.setContent(content);
		bean.setCreatetime(new Date());
		bean.setTitle(title);
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		bean.setUser(user);
		bean.setLeixing(leixing);
		infoDao.insertBean(bean);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("gbk");response.setContentType("text/html; charset=gbk");
		if(user.getRole()==2){
			response
			.getWriter()
			.print(
					"<script language=javascript>alert('success!');window.location.href='method!infolist';</script>");
		}else{
			response
			.getWriter()
			.print(
					"<script language=javascript>alert('success!');window.location.href='method!infolist2';</script>");
		}
		
	}
	//跳转到更新信息页面
	public String infoupdate() {
		HttpServletRequest request = ServletActionContext.getRequest();
		Info bean = infoDao.selectBean(" where id= "+request.getParameter("id"));
		request.setAttribute("bean", bean);
		this.setUrl("info/infoupdate.jsp");
		return SUCCESS;
	}
//更新信息操作
	public void infoupdate2() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		String content = request.getParameter("content");
		String title = request.getParameter("title");
		Info bean = infoDao.selectBean(" where id= "+request.getParameter("id"));
		bean.setContent(content);
		bean.setTitle(title);
		infoDao.updateBean(bean);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("gbk");response.setContentType("text/html; charset=gbk");
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		if(user.getRole()==2){
			response
			.getWriter()
			.print(
					"<script language=javascript>alert('success!');window.location.href='method!infolist';</script>");
		}else{
			response
			.getWriter()
			.print(
					"<script language=javascript>alert('success!');window.location.href='method!infolist2';</script>");
		}
	}
	
//查看信息操作
	public String infoupdate3() {
		HttpServletRequest request = ServletActionContext.getRequest();
		Info bean = infoDao.selectBean(" where id= "+request.getParameter("id"));
		request.setAttribute("bean", bean);
		this.setUrl("info/infoupdate3.jsp");
		return SUCCESS;
	}
//删除信息操作
	public void infodelete() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("gbk");response.setContentType("text/html; charset=gbk");
		Info bean = infoDao.selectBean(" where id= "+request.getParameter("id"));
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		if(user.getRole()<bean.getUser().getRole()){
			if(user.getRole()==2){
				response
				.getWriter()
				.print(
						"<script language=javascript>alert('操作失败，权限不够');window.location.href='method!infolist';</script>");
				return;
			}else{
				response
				.getWriter()
				.print(
						"<script language=javascript>alert('操作失败，权限不够');window.location.href='method!infolist2';</script>");
				return;
			}
		}
		bean.setInfolock(1);
		infoDao.updateBean(bean);
		
		
		
		if(user.getRole()==2){
			response
			.getWriter()
			.print(
					"<script language=javascript>alert('success!');window.location.href='method!infolist';</script>");
		}else{
			response
			.getWriter()
			.print(
					"<script language=javascript>alert('success!');window.location.href='method!infolist2';</script>");
		}
	}
	
	private WendangDao wendangDao;


	public WendangDao getWendangDao() {
		return wendangDao;
	}

	public void setWendangDao(WendangDao wendangDao) {
		this.wendangDao = wendangDao;
	}
	
	//文档列表
	public String wendanglist()  {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("list2", bumenDao.selectBeanList(0, 9999, "  where bumenlock=0 " ));
		
		String title = request.getParameter("title");
		String bumen = request.getParameter("bumen");

		
		StringBuffer sb = new StringBuffer();
		sb.append(" where ");
		StringBuffer sb2 = new StringBuffer();
		sb2.append(" where ");

		if(title!=null&&!"".equals(title)){
			sb.append("title like '%"+title+"%'");
			sb.append(" and ");
			sb2.append("title like '%"+title+"%'");
			sb2.append(" and ");
			request.setAttribute("title", title);
		}
		
		
		if(bumen!=null&&!"".equals(bumen)){
			sb.append("bumen.bumenming like '%"+bumen+"%'");
			sb.append(" and ");
			sb2.append("bumen.bumenming like '%"+bumen+"%'");
			sb2.append(" and ");

			request.setAttribute("bumen", bumen);
		}
		sb.append(" wendanglock=0 order by id desc");
		String where = sb.toString();
		sb2.append(" wendanglock=0 ");
		String where2 = sb2.toString();
		int currentpage = 1;
		int pagesize =20;
		if(request.getParameter("pagenum")!=null){
			currentpage = Integer.parseInt(request.getParameter("pagenum"));
		}
		int total = wendangDao.selectBeanCount(where2);
		request.setAttribute("list", wendangDao.selectBeanList((currentpage - 1) * pagesize, pagesize, where));
		request.setAttribute("pagerwendang", Pager.getPagerNormal(total, pagesize,
				currentpage, "method!wendanglist", "共有" + total + "条记录"));
		this.setUrl("wendang/wendanglist.jsp");
		return SUCCESS;
	}

//跳转到添加文档页面
	public String wendangadd() {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("list2", bumenDao.selectBeanList(0, 9999, "  where bumenlock=0 " ));
		this.setUrl("wendang/wendangadd.jsp");
		return SUCCESS;
	}
	
	private File uploadfile;
	
	public File getUploadfile() {
		return uploadfile;
	}

	public void setUploadfile(File uploadfile) {
		this.uploadfile = uploadfile;
	}
	
	private String uploadFileName;

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
//添加文档操作
	public void wendangadd2() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		String bumen = request.getParameter("bumen");
		String content = request.getParameter("content");
		String title = request.getParameter("title");
		String filename = request.getParameter("filename");
		Wendang bean = new Wendang();
		String savaPath = ServletActionContext.getServletContext().getRealPath(
		"/")
		+ "/uploadfile/";

		String time = new java.text.SimpleDateFormat("yyyyMMddHHmmss").format(new Date()).toString();

		String filename2 = filename.substring(filename.lastIndexOf("\\")+1,filename.length());
		String path = time +"_"+filename2;
		File file = new File(savaPath + path);
		Util.copyFile(uploadfile, file);

		String name = time +".zip";
		Util.createZip(path, name, savaPath);
		bean.setPath(name);
		if(!"0".equals(bumen)){
			bean.setBumen(bumenDao.selectBean(" where id= "+bumen));
		}
		bean.setContent(content);
		bean.setCreatetime(new Date());
		bean.setTitle(title);
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		bean.setUser(user);
		wendangDao.insertBean(bean);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("gbk");response.setContentType("text/html; charset=gbk");

		if(user.getRole()==2){
			response
			.getWriter()
			.print(
					"<script language=javascript>alert('success!');window.location.href='method!wendanglist';</script>");
		}else if(user.getRole()==1){
			response
			.getWriter()
			.print(
					"<script language=javascript>alert('success!');window.location.href='method!wendanglist2';</script>");
		}else{
			response
			.getWriter()
			.print(
					"<script language=javascript>alert('success!');window.location.href='method!wendanglist3';</script>");
		}
		
	}
	
	//查看文档操作
	public String wendangupdate3() {
		HttpServletRequest request = ServletActionContext.getRequest();
		Wendang bean = wendangDao.selectBean(" where id= "+request.getParameter("id"));
		request.setAttribute("bean", bean);
		this.setUrl("wendang/wendangupdate3.jsp");
		return SUCCESS;
	}
//删除文档操作
	public void wendangdelete() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("gbk");response.setContentType("text/html; charset=gbk");
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		Wendang bean = wendangDao.selectBean(" where id= "+request.getParameter("id"));
		if(user.getRole()>=bean.getUser().getRole()){
			bean.setWendanglock(1);
			wendangDao.updateBean(bean);
			
			
			if(user.getRole()==2){
				response
				.getWriter()
				.print(
						"<script language=javascript>alert('success!');window.location.href='method!wendanglist';</script>");
			}else{
				response
				.getWriter()
				.print(
						"<script language=javascript>alert('success!');window.location.href='method!wendanglist2';</script>");
			}
		}else{
			if(user.getRole()==2){
				response
				.getWriter()
				.print(
						"<script language=javascript>alert('您没有权限删除该文档');window.location.href='method!wendanglist';</script>");
			}else{
				response
				.getWriter()
				.print(
						"<script language=javascript>alert('您没有权限删除该文档');window.location.href='method!wendanglist2';</script>");
			}
		}
		
		
	}
	
	//员工删除文档操作
	public void wendangdelete2() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("gbk");response.setContentType("text/html; charset=gbk");
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		Wendang bean = wendangDao.selectBean(" where id= "+request.getParameter("id"));
		if(user.getId()==bean.getUser().getId()){
			bean.setWendanglock(1);
			wendangDao.updateBean(bean);
			response
			.getWriter()
			.print(
					"<script language=javascript>alert('success!');window.location.href='method!wendanglist3';</script>");
		}else{
			response
			.getWriter()
			.print(
					"<script language=javascript>alert('只能删除自己上传的文档');window.location.href='method!wendanglist3';</script>");
		}
		
		
	}
	//部门经理员工管理列表
	
	public String userlist2()  {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("list2", bumenDao.selectBeanList(0, 9999, "  where bumenlock=0 " ));
		
		String truename = request.getParameter("truename");
		String bumen = request.getParameter("bumen");

		
		StringBuffer sb = new StringBuffer();
		sb.append(" where ");
		StringBuffer sb2 = new StringBuffer();
		sb2.append(" where ");

		if(truename!=null&&!"".equals(truename)){
			sb.append("truename like '%"+truename+"%'");
			sb.append(" and ");
			sb2.append("truename like '%"+truename+"%'");
			sb2.append(" and ");
			request.setAttribute("truename", truename);
		}
		
		if(bumen!=null&&!"".equals(bumen)){
			sb.append("bumen.bumenming like '%"+bumen+"%'");
			sb.append(" and ");
			sb2.append("bumen.bumenming like '%"+bumen+"%'");
			sb2.append(" and ");

			request.setAttribute("bumen", bumen);
		}
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		sb.append(" userlock=0 and role !=2 and bumen.id="+user.getBumen().getId()+" order by bumen2 desc");
		String where = sb.toString();
		sb2.append(" userlock=0 and role !=2 and bumen.id="+user.getBumen().getId());
		String where2 = sb2.toString();
		int currentpage = 1;
		int pagesize =20;
		if(request.getParameter("pagenum")!=null){
			currentpage = Integer.parseInt(request.getParameter("pagenum"));
		}
		int total = userDao.selectBeanCount(where2);
		request.setAttribute("list", userDao.selectBeanList((currentpage - 1) * pagesize, pagesize, where));
		request.setAttribute("pagerinfo", Pager.getPagerNormal(total, pagesize,
				currentpage, "method!userlist2", "共有" + total + "条记录"));
		this.setUrl("user/userlist2.jsp");
		return SUCCESS;
	}
//部门经理信息管理列表
	public String infolist2()  {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("list2", bumenDao.selectBeanList(0, 9999, "  where bumenlock=0 " ));
		
		String title = request.getParameter("title");
		String bumen = request.getParameter("bumen");
		String leixing = request.getParameter("leixing");

		
		StringBuffer sb = new StringBuffer();
		sb.append(" where ");
		StringBuffer sb2 = new StringBuffer();
		sb2.append(" where ");

		if(title!=null&&!"".equals(title)){
			sb.append("title like '%"+title+"%'");
			sb.append(" and ");
			sb2.append("title like '%"+title+"%'");
			sb2.append(" and ");
			request.setAttribute("title", title);
		}
		
		if(leixing!=null&&!"".equals(leixing)){
			sb.append("leixing like '%"+leixing+"%'");
			sb.append(" and ");
			sb2.append("leixing like '%"+leixing+"%'");
			sb2.append(" and ");
			request.setAttribute("leixing", leixing);
		}
		
		if(bumen!=null&&!"".equals(bumen)){
			sb.append("bumen.bumenming like '%"+bumen+"%'");
			sb.append(" and ");
			sb2.append("bumen.bumenming like '%"+bumen+"%'");
			sb2.append(" and ");

			request.setAttribute("bumen", bumen);
		}
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		sb.append(" infolock=0 and (bumen.id="+user.getBumen().getId()+" or bumen is null) order by id desc");
		String where = sb.toString();
		sb2.append(" infolock=0 and (bumen.id="+user.getBumen().getId()+" or bumen is null) ");
		String where2 = sb2.toString();
		int currentpage = 1;
		int pagesize =20;
		if(request.getParameter("pagenum")!=null){
			currentpage = Integer.parseInt(request.getParameter("pagenum"));
		}
		int total = infoDao.selectBeanCount(where2);
		request.setAttribute("list", infoDao.selectBeanList((currentpage - 1) * pagesize, pagesize, where));
		request.setAttribute("pagerinfo", Pager.getPagerNormal(total, pagesize,
				currentpage, "method!infolist2", "共有" + total + "条记录"));
		this.setUrl("info/infolist2.jsp");
		return SUCCESS;
	}
	
	//部门经理文档管理
	public String wendanglist2()  {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("list2", bumenDao.selectBeanList(0, 9999, "  where bumenlock=0 " ));
		
		String title = request.getParameter("title");
		String bumen = request.getParameter("bumen");

		
		StringBuffer sb = new StringBuffer();
		sb.append(" where ");
		StringBuffer sb2 = new StringBuffer();
		sb2.append(" where ");

		if(title!=null&&!"".equals(title)){
			sb.append("title like '%"+title+"%'");
			sb.append(" and ");
			sb2.append("title like '%"+title+"%'");
			sb2.append(" and ");
			request.setAttribute("title", title);
		}
		
		
		if(bumen!=null&&!"".equals(bumen)){
			sb.append("bumen.bumenming like '%"+bumen+"%'");
			sb.append(" and ");
			sb2.append("bumen.bumenming like '%"+bumen+"%'");
			sb2.append(" and ");

			request.setAttribute("bumen", bumen);
		}
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		sb.append(" wendanglock=0 and (bumen.id="+user.getBumen().getId()+" or bumen is null) order by id desc");
		String where = sb.toString();
		sb2.append(" wendanglock=0 and (bumen.id="+user.getBumen().getId()+" or bumen is null) ");
		String where2 = sb2.toString();
		int currentpage = 1;
		int pagesize =20;
		if(request.getParameter("pagenum")!=null){
			currentpage = Integer.parseInt(request.getParameter("pagenum"));
		}
		int total = wendangDao.selectBeanCount(where2);
		request.setAttribute("list", wendangDao.selectBeanList((currentpage - 1) * pagesize, pagesize, where));
		request.setAttribute("pagerwendang", Pager.getPagerNormal(total, pagesize,
				currentpage, "method!wendanglist2", "共有" + total + "条记录"));
		this.setUrl("wendang/wendanglist2.jsp");
		return SUCCESS;
	}
	
	//员工信息查询
	public String infolist3()  {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("list2", bumenDao.selectBeanList(0, 9999, "  where bumenlock=0 " ));
		
		String title = request.getParameter("title");
		String bumen = request.getParameter("bumen");
		String leixing = request.getParameter("leixing");

		
		StringBuffer sb = new StringBuffer();
		sb.append(" where ");
		StringBuffer sb2 = new StringBuffer();
		sb2.append(" where ");

		if(title!=null&&!"".equals(title)){
			sb.append("title like '%"+title+"%'");
			sb.append(" and ");
			sb2.append("title like '%"+title+"%'");
			sb2.append(" and ");
			request.setAttribute("title", title);
		}
		
		if(leixing!=null&&!"".equals(leixing)){
			sb.append("leixing like '%"+leixing+"%'");
			sb.append(" and ");
			sb2.append("leixing like '%"+leixing+"%'");
			sb2.append(" and ");
			request.setAttribute("leixing", leixing);
		}
		
		if(bumen!=null&&!"".equals(bumen)){
			sb.append("bumen.bumenming like '%"+bumen+"%'");
			sb.append(" and ");
			sb2.append("bumen.bumenming like '%"+bumen+"%'");
			sb2.append(" and ");

			request.setAttribute("bumen", bumen);
		}
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		sb.append(" infolock=0 and (bumen.id="+user.getBumen().getId()+" or bumen is null) order by id desc");
		String where = sb.toString();
		sb2.append(" infolock=0 and (bumen.id="+user.getBumen().getId()+" or bumen is null) ");
		String where2 = sb2.toString();
		int currentpage = 1;
		int pagesize =20;
		if(request.getParameter("pagenum")!=null){
			currentpage = Integer.parseInt(request.getParameter("pagenum"));
		}
		int total = infoDao.selectBeanCount(where2);
		request.setAttribute("list", infoDao.selectBeanList((currentpage - 1) * pagesize, pagesize, where));
		request.setAttribute("pagerinfo", Pager.getPagerNormal(total, pagesize,
				currentpage, "method!infolist3", "共有" + total + "条记录"));
		this.setUrl("info/infolist3.jsp");
		return SUCCESS;
	}
	
	//员工文档管理
	public String wendanglist3()  {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("list2", bumenDao.selectBeanList(0, 9999, "  where bumenlock=0 " ));
		
		String title = request.getParameter("title");
		String bumen = request.getParameter("bumen");

		
		StringBuffer sb = new StringBuffer();
		sb.append(" where ");
		StringBuffer sb2 = new StringBuffer();
		sb2.append(" where ");

		if(title!=null&&!"".equals(title)){
			sb.append("title like '%"+title+"%'");
			sb.append(" and ");
			sb2.append("title like '%"+title+"%'");
			sb2.append(" and ");
			request.setAttribute("title", title);
		}
		
		
		if(bumen!=null&&!"".equals(bumen)){
			sb.append("bumen.bumenming like '%"+bumen+"%'");
			sb.append(" and ");
			sb2.append("bumen.bumenming like '%"+bumen+"%'");
			sb2.append(" and ");

			request.setAttribute("bumen", bumen);
		}
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		sb.append(" wendanglock=0 and (bumen.id="+user.getBumen().getId()+" or bumen is null) order by id desc");
		String where = sb.toString();
		sb2.append(" wendanglock=0 and (bumen.id="+user.getBumen().getId()+" or bumen is null) ");
		String where2 = sb2.toString();
		int currentpage = 1;
		int pagesize =20;
		if(request.getParameter("pagenum")!=null){
			currentpage = Integer.parseInt(request.getParameter("pagenum"));
		}
		int total = wendangDao.selectBeanCount(where2);
		request.setAttribute("list", wendangDao.selectBeanList((currentpage - 1) * pagesize, pagesize, where));
		request.setAttribute("pagerwendang", Pager.getPagerNormal(total, pagesize,
				currentpage, "method!wendanglist3", "共有" + total + "条记录"));
		this.setUrl("wendang/wendanglist3.jsp");
		return SUCCESS;
	}
	
	private KaoqinDao kaoqinDao;


	public KaoqinDao getKaoqinDao() {
		return kaoqinDao;
	}

	public void setKaoqinDao(KaoqinDao kaoqinDao) {
		this.kaoqinDao = kaoqinDao;
	}
	
	//个人考勤列表
	public String kaoqinlist()  {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("list2", bumenDao.selectBeanList(0, 9999, "  where bumenlock=0 " ));
		
		String shenhezhuangtai = request.getParameter("shenhezhuangtai");
		String leixing = request.getParameter("leixing");

		
		StringBuffer sb = new StringBuffer();
		sb.append(" where ");
		StringBuffer sb2 = new StringBuffer();
		sb2.append(" where ");

		if(shenhezhuangtai!=null&&!"".equals(shenhezhuangtai)){
			sb.append("shenhezhuangtai like '%"+shenhezhuangtai+"%'");
			sb.append(" and ");
			sb2.append("shenhezhuangtai like '%"+shenhezhuangtai+"%'");
			sb2.append(" and ");
			request.setAttribute("shenhezhuangtai", shenhezhuangtai);
		}
		
		if(leixing!=null&&!"".equals(leixing)){
			sb.append("leixing like '%"+leixing+"%'");
			sb.append(" and ");
			sb2.append("leixing like '%"+leixing+"%'");
			sb2.append(" and ");
			request.setAttribute("leixing", leixing);
		}
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		
		sb.append(" kaoqinlock=0 and user.id="+user.getId()+" order by id desc");
		String where = sb.toString();
		sb2.append(" kaoqinlock=0 and user.id="+user.getId());
		String where2 = sb2.toString();
		int currentpage = 1;
		int pagesize =20;
		if(request.getParameter("pagenum")!=null){
			currentpage = Integer.parseInt(request.getParameter("pagenum"));
		}
		int total = kaoqinDao.selectBeanCount(where2);
		request.setAttribute("list", kaoqinDao.selectBeanList((currentpage - 1) * pagesize, pagesize, where));
		request.setAttribute("pagerinfo", Pager.getPagerNormal(total, pagesize,
				currentpage, "method!kaoqinlist", "共有" + total + "条记录"));
		this.setUrl("kaoqin/kaoqinlist.jsp");
		return SUCCESS;
	}

//跳转到添加考勤页面
	public String kaoqinadd() {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("createtime", Util.getTime());
		this.setUrl("kaoqin/kaoqinadd.jsp");
		return SUCCESS;
	}
	//添加考勤操作
	public void kaoqinadd2() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		String beizhu = request.getParameter("beizhu");
		String leixing = request.getParameter("leixing");
		String createtime = request.getParameter("createtime");
		Kaoqin bean = new Kaoqin();
		bean.setBeizhu(beizhu);
		bean.setCreatetime(createtime);
		bean.setShenhezhuangtai("未审核");
		bean.setLeixing(leixing);
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		bean.setUser(user);
		kaoqinDao.insertBean(bean);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("gbk");response.setContentType("text/html; charset=gbk");
		response
		.getWriter()
		.print(
				"<script language=javascript>alert('success!');window.location.href='method!kaoqinlist';</script>");
		
		

		
	}
	//跳转到更新考勤信息页面
	public String kaoqinupdate() {
		HttpServletRequest request = ServletActionContext.getRequest();
		Kaoqin bean = kaoqinDao.selectBean(" where id= "+request.getParameter("id"));
		request.setAttribute("bean", bean);
		this.setUrl("kaoqin/kaoqinupdate.jsp");
		return SUCCESS;
	}
//更新考勤信息操作
	public void kaoqinupdate2() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		String beizhu = request.getParameter("beizhu");
	
		Kaoqin bean = kaoqinDao.selectBean(" where id= "+request.getParameter("id"));
		if("未审核".equals(bean.getShenhezhuangtai())){
			bean.setBeizhu(beizhu);
			kaoqinDao.updateBean(bean);
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("gbk");response.setContentType("text/html; charset=gbk");
			response
			.getWriter()
			.print(
					"<script language=javascript>alert('success!');window.location.href='method!kaoqinlist';</script>");
		}else{
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("gbk");response.setContentType("text/html; charset=gbk");
			response
			.getWriter()
			.print(
					"<script language=javascript>alert('已经审核，操作失败');window.location.href='method!kaoqinlist';</script>");
		}

	}
	
//查看考勤信息操作
	public String kaoqinupdate3() {
		HttpServletRequest request = ServletActionContext.getRequest();
		Kaoqin bean = kaoqinDao.selectBean(" where id= "+request.getParameter("id"));
		request.setAttribute("bean", bean);
		this.setUrl("kaoqin/kaoqinupdate3.jsp");
		return SUCCESS;
	}
//删除考勤信息操作
	public void kaoqindelete() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		Kaoqin bean = kaoqinDao.selectBean(" where id= "+request.getParameter("id"));
		if("未审核".equals(bean.getShenhezhuangtai())){
			bean.setKaoqinlock(1);
			kaoqinDao.updateBean(bean);
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("gbk");response.setContentType("text/html; charset=gbk");
			response
			.getWriter()
			.print(
					"<script language=javascript>alert('success!');window.location.href='method!kaoqinlist';</script>");
		}else{
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("gbk");response.setContentType("text/html; charset=gbk");
			response
			.getWriter()
			.print(
					"<script language=javascript>alert('已经审核，操作失败');window.location.href='method!kaoqinlist';</script>");
		}
		
	}
	
	//审核考勤信息列表
	public String kaoqinlist2()  {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("list2", bumenDao.selectBeanList(0, 9999, "  where bumenlock=0 " ));
		
		String shenhezhuangtai = request.getParameter("shenhezhuangtai");
		String leixing = request.getParameter("leixing");

		
		StringBuffer sb = new StringBuffer();
		sb.append(" where ");
		StringBuffer sb2 = new StringBuffer();
		sb2.append(" where ");

		if(shenhezhuangtai!=null&&!"".equals(shenhezhuangtai)){
			sb.append("shenhezhuangtai like '%"+shenhezhuangtai+"%'");
			sb.append(" and ");
			sb2.append("shenhezhuangtai like '%"+shenhezhuangtai+"%'");
			sb2.append(" and ");
			request.setAttribute("shenhezhuangtai", shenhezhuangtai);
		}
		
		if(leixing!=null&&!"".equals(leixing)){
			sb.append("leixing like '%"+leixing+"%'");
			sb.append(" and ");
			sb2.append("leixing like '%"+leixing+"%'");
			sb2.append(" and ");
			request.setAttribute("leixing", leixing);
		}
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		String id= "";
		if(user.getBumen2()!=null){
			id = user.getBumen2().getId()+"";
		}else{
			id = user.getBumen().getId()+"";
		}
		
		sb.append(" kaoqinlock=0 and user.bumen.id="+id+" order by shenhezhuangtai desc");
		String where = sb.toString();
		sb2.append(" kaoqinlock=0 and user.id="+id);
		String where2 = sb2.toString();
		int currentpage = 1;
		int pagesize =20;
		if(request.getParameter("pagenum")!=null){
			currentpage = Integer.parseInt(request.getParameter("pagenum"));
		}
		int total = kaoqinDao.selectBeanCount(where2);
		request.setAttribute("list", kaoqinDao.selectBeanList((currentpage - 1) * pagesize, pagesize, where));
		request.setAttribute("pagerinfo", Pager.getPagerNormal(total, pagesize,
				currentpage, "method!kaoqinlist2", "共有" + total + "条记录"));
		this.setUrl("kaoqin/kaoqinlist2.jsp");
		return SUCCESS;
	}
	
	//跳转到审核考勤信息页面
	public String kaoqinupdate5() {
		HttpServletRequest request = ServletActionContext.getRequest();
		Kaoqin bean = kaoqinDao.selectBean(" where id= "+request.getParameter("id"));
		request.setAttribute("bean", bean);
		this.setUrl("kaoqin/kaoqinupdate5.jsp");
		return SUCCESS;
	}
//审核考勤信息操作
	public void kaoqinupdate6() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		String shenhezhuangtai = request.getParameter("shenhezhuangtai");
		String shenhejieguo = request.getParameter("shenhejieguo");
	
		Kaoqin bean = kaoqinDao.selectBean(" where id= "+request.getParameter("id"));
		if("未审核".equals(bean.getShenhezhuangtai())){
			bean.setShenhejieguo(shenhejieguo);
			bean.setShenhezhuangtai(shenhezhuangtai);
			kaoqinDao.updateBean(bean);
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("gbk");response.setContentType("text/html; charset=gbk");
			response
			.getWriter()
			.print(
					"<script language=javascript>alert('success!');window.location.href='method!kaoqinlist2';</script>");
		}else{
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("gbk");response.setContentType("text/html; charset=gbk");
			response
			.getWriter()
			.print(
					"<script language=javascript>alert('已经审核，操作失败');window.location.href='method!kaoqinlist2';</script>");
		}

	}
	
	private GongzuorizhiDao gongzuorizhiDao;


	public GongzuorizhiDao getGongzuorizhiDao() {
		return gongzuorizhiDao;
	}

	public void setGongzuorizhiDao(GongzuorizhiDao gongzuorizhiDao) {
		this.gongzuorizhiDao = gongzuorizhiDao;
	}

	//工作日志管理
	public String gongzuorizhilist()  {
		HttpServletRequest request = ServletActionContext.getRequest();	
		String time1 = request.getParameter("time1");
		String time2 = request.getParameter("time2");
		
		String title = request.getParameter("title");

		
		StringBuffer sb = new StringBuffer();
		sb.append(" where ");
		StringBuffer sb2 = new StringBuffer();
		sb2.append(" where ");

		if(title!=null&&!"".equals(title)){
			sb.append("title like '%"+title+"%'");
			sb.append(" and ");
			sb2.append("title like '%"+title+"%'");
			sb2.append(" and ");
			request.setAttribute("title", title);
		}
		
		if(time1!=null&&!"".equals(time1)){
			sb.append("shijian >= '"+time1+"'");
			sb.append(" and ");
			sb2.append("shijian >= '"+time1+"'");
			sb2.append(" and ");
			request.setAttribute("time1", time1);
		}
		
		if(time2!=null&&!"".equals(time2)){
			sb.append("shijian <= '"+time2+"'");
			sb.append(" and ");
			sb2.append("shijian <= '"+time2+"'");
			sb2.append(" and ");
			request.setAttribute("time2", time2);
		}
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		
		sb.append(" gongzuorizhilock=0 and user.id="+user.getId()+" order by id desc");
		String where = sb.toString();
		sb2.append(" gongzuorizhilock=0 and user.id="+user.getId());
		String where2 = sb2.toString();
		int currentpage = 1;
		int pagesize =20;
		if(request.getParameter("pagenum")!=null){
			currentpage = Integer.parseInt(request.getParameter("pagenum"));
		}
		int total = gongzuorizhiDao.selectBeanCount(where2);
		request.setAttribute("list", gongzuorizhiDao.selectBeanList((currentpage - 1) * pagesize, pagesize, where));
		request.setAttribute("pagerinfo", Pager.getPagerNormal(total, pagesize,
				currentpage, "method!gongzuorizhilist", "共有" + total + "条记录"));
		this.setUrl("gongzuorizhi/gongzuorizhilist.jsp");
		return SUCCESS;
	}

//跳转到添加工作日志页面
	public String gongzuorizhiadd() {
		this.setUrl("gongzuorizhi/gongzuorizhiadd.jsp");
		return SUCCESS;
	}
//添加工作日志操作	
	public void gongzuorizhiadd2() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		String content = request.getParameter("content");
		String shijian = request.getParameter("shijian");
		String title = request.getParameter("title");
		Gongzuorizhi bean = new Gongzuorizhi();
		bean.setContent(content);
		bean.setShijian(shijian);
		bean.setTitle(title);
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		bean.setUser(user);
		gongzuorizhiDao.insertBean(bean);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("gbk");response.setContentType("text/html; charset=gbk");
		response
		.getWriter()
		.print(
				"<script language=javascript>alert('success!');window.location.href='method!gongzuorizhilist';</script>");
		
		

		
	}
//跳转到更新工作日志页面	
	public String gongzuorizhiupdate() {
		HttpServletRequest request = ServletActionContext.getRequest();
		Gongzuorizhi bean = gongzuorizhiDao.selectBean(" where id= "+request.getParameter("id"));
		request.setAttribute("bean", bean);
		this.setUrl("gongzuorizhi/gongzuorizhiupdate.jsp");
		return SUCCESS;
	}
//更新工作日志操作
	public void gongzuorizhiupdate2() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		String content = request.getParameter("content");
		String shijian = request.getParameter("shijian");
		String title = request.getParameter("title");
		Gongzuorizhi bean = gongzuorizhiDao.selectBean(" where id= "+request.getParameter("id"));
		bean.setContent(content);
		bean.setShijian(shijian);
		bean.setTitle(title);
		gongzuorizhiDao.updateBean(bean);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("gbk");response.setContentType("text/html; charset=gbk");
		response
		.getWriter()
		.print(
				"<script language=javascript>alert('success!');window.location.href='method!gongzuorizhilist';</script>");

	}
	
//查看工作日志
	public String gongzuorizhiupdate3() {
		HttpServletRequest request = ServletActionContext.getRequest();
		Gongzuorizhi bean = gongzuorizhiDao.selectBean(" where id= "+request.getParameter("id"));
		request.setAttribute("bean", bean);
		this.setUrl("gongzuorizhi/gongzuorizhiupdate3.jsp");
		return SUCCESS;
	}
//删除工作日志
	public void gongzuorizhidelete() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		Gongzuorizhi bean = gongzuorizhiDao.selectBean(" where id= "+request.getParameter("id"));
		bean.setGongzuorizhilock(1);
		gongzuorizhiDao.updateBean(bean);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("gbk");response.setContentType("text/html; charset=gbk");
		response
		.getWriter()
		.print(
				"<script language=javascript>alert('success!');window.location.href='method!gongzuorizhilist';</script>");
	}
	
	private RenwuDao renwuDao;


	public RenwuDao getRenwuDao() {
		return renwuDao;
	}

	public void setRenwuDao(RenwuDao renwuDao) {
		this.renwuDao = renwuDao;
	}
	
	//任务管理列表
	public String renwulist()  {
		HttpServletRequest request = ServletActionContext.getRequest();			
		String title = request.getParameter("title");

		
		StringBuffer sb = new StringBuffer();
		sb.append(" where ");
		StringBuffer sb2 = new StringBuffer();
		sb2.append(" where ");

		if(title!=null&&!"".equals(title)){
			sb.append("title like '%"+title+"%'");
			sb.append(" and ");
			sb2.append("title like '%"+title+"%'");
			sb2.append(" and ");
			request.setAttribute("title", title);
		}
		
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		
		sb.append(" renwulock=0 and fromuser.id="+user.getId()+" order by id desc");
		String where = sb.toString();
		sb2.append(" renwulock=0 and fromuser.id="+user.getId());
		String where2 = sb2.toString();
		int currentpage = 1;
		int pagesize =20;
		if(request.getParameter("pagenum")!=null){
			currentpage = Integer.parseInt(request.getParameter("pagenum"));
		}
		int total = renwuDao.selectBeanCount(where2);
		request.setAttribute("list", renwuDao.selectBeanList((currentpage - 1) * pagesize, pagesize, where));
		request.setAttribute("pagerinfo", Pager.getPagerNormal(total, pagesize,
				currentpage, "method!renwulist", "共有" + total + "条记录"));
		this.setUrl("renwu/renwulist.jsp");
		return SUCCESS;
	}

//跳转到添加任务页面
	public String renwuadd() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		request.setAttribute("list2", userDao.selectBeanList(0, 9999, " where userlock=0 and bumen.id=  "+user.getBumen2().getId()));
		this.setUrl("renwu/renwuadd.jsp");
		return SUCCESS;
	}
	//添加任务操作
	public void renwuadd2() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		String content = request.getParameter("content");
		String shijian = request.getParameter("shijian");
		String title = request.getParameter("title");
		String touser = request.getParameter("touser");
		Renwu bean = new Renwu();
		bean.setContent(content);
		bean.setShijian(shijian);
		bean.setTitle(title);
		bean.setWanchengqingkuang("未完成");
		HttpSession session = request.getSession();
		User fromuser = (User)session.getAttribute("user");
		bean.setFromuser(fromuser);
		bean.setTouser(userDao.selectBean(" where id= "+touser));
		renwuDao.insertBean(bean);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("gbk");response.setContentType("text/html; charset=gbk");
		response
		.getWriter()
		.print(
				"<script language=javascript>alert('success!');window.location.href='method!renwulist';</script>");
		
		

		
	}
	//跳转到更新任务页面
	public String renwuupdate() {
		HttpServletRequest request = ServletActionContext.getRequest();
		Renwu bean = renwuDao.selectBean(" where id= "+request.getParameter("id"));
		request.setAttribute("bean", bean);
		this.setUrl("renwu/renwuupdate.jsp");
		return SUCCESS;
	}
//更新任务操作
	public void renwuupdate2() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		String content = request.getParameter("content");
		String shijian = request.getParameter("shijian");
		String title = request.getParameter("title");
		Renwu bean = renwuDao.selectBean(" where id= "+request.getParameter("id"));
		bean.setContent(content);
		bean.setShijian(shijian);
		bean.setTitle(title);
		renwuDao.updateBean(bean);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("gbk");response.setContentType("text/html; charset=gbk");
		response
		.getWriter()
		.print(
				"<script language=javascript>alert('success!');window.location.href='method!renwulist';</script>");

	}
	
//查看任务操作
	public String renwuupdate3() {
		HttpServletRequest request = ServletActionContext.getRequest();
		Renwu bean = renwuDao.selectBean(" where id= "+request.getParameter("id"));
		request.setAttribute("bean", bean);
		this.setUrl("renwu/renwuupdate3.jsp");
		return SUCCESS;
	}
//删除任务操作
	public void renwudelete() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		Renwu bean = renwuDao.selectBean(" where id= "+request.getParameter("id"));
		bean.setRenwulock(1);
		renwuDao.updateBean(bean);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("gbk");response.setContentType("text/html; charset=gbk");
		response
		.getWriter()
		.print(
				"<script language=javascript>alert('success!');window.location.href='method!renwulist';</script>");
	}
	
	//跳转到评估任务页面
	public String renwuupdate5() {
		HttpServletRequest request = ServletActionContext.getRequest();
		Renwu bean = renwuDao.selectBean(" where id= "+request.getParameter("id"));
		request.setAttribute("bean", bean);
		this.setUrl("renwu/renwuupdate5.jsp");
		return SUCCESS;
	}
//评估任务操作
	public void renwuupdate6() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		String wanchengpingggu = request.getParameter("wanchengpingggu");
		Renwu bean = renwuDao.selectBean(" where id= "+request.getParameter("id"));
		bean.setWanchengpingggu(wanchengpingggu);
		renwuDao.updateBean(bean);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("gbk");response.setContentType("text/html; charset=gbk");
		response
		.getWriter()
		.print(
				"<script language=javascript>alert('success!');window.location.href='method!renwulist';</script>");

	}
	
	//普通员工任务管理列表
	public String renwulist2()  {
		HttpServletRequest request = ServletActionContext.getRequest();			
		String title = request.getParameter("title");

		
		StringBuffer sb = new StringBuffer();
		sb.append(" where ");
		StringBuffer sb2 = new StringBuffer();
		sb2.append(" where ");

		if(title!=null&&!"".equals(title)){
			sb.append("title like '%"+title+"%'");
			sb.append(" and ");
			sb2.append("title like '%"+title+"%'");
			sb2.append(" and ");
			request.setAttribute("title", title);
		}
		
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		
		sb.append(" renwulock=0 and touser.id="+user.getId()+" order by id desc");
		String where = sb.toString();
		sb2.append(" renwulock=0 and touser.id="+user.getId());
		String where2 = sb2.toString();
		int currentpage = 1;
		int pagesize =20;
		if(request.getParameter("pagenum")!=null){
			currentpage = Integer.parseInt(request.getParameter("pagenum"));
		}
		int total = renwuDao.selectBeanCount(where2);
		request.setAttribute("list", renwuDao.selectBeanList((currentpage - 1) * pagesize, pagesize, where));
		request.setAttribute("pagerinfo", Pager.getPagerNormal(total, pagesize,
				currentpage, "method!renwulist2", "共有" + total + "条记录"));
		this.setUrl("renwu/renwulist2.jsp");
		return SUCCESS;
	}
	//跳转到汇报任务页面
	public String renwuupdate7() {
		HttpServletRequest request = ServletActionContext.getRequest();
		Renwu bean = renwuDao.selectBean(" where id= "+request.getParameter("id"));
		request.setAttribute("bean", bean);
		this.setUrl("renwu/renwuupdate7.jsp");
		return SUCCESS;
	}
//汇报任务操作
	public void renwuupdate8() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		String wanchengqingkuang = request.getParameter("wanchengqingkuang");
		String wanchenghuibao = request.getParameter("wanchenghuibao");
		Renwu bean = renwuDao.selectBean(" where id= "+request.getParameter("id"));
		bean.setWanchengqingkuang(wanchengqingkuang);
		bean.setWanchenghuibao(wanchenghuibao);
		renwuDao.updateBean(bean);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("gbk");response.setContentType("text/html; charset=gbk");
		response
		.getWriter()
		.print(
				"<script language=javascript>alert('success!');window.location.href='method!renwulist2';</script>");

	}
	
	private YoujianDao youjianDao;


	public YoujianDao getYoujianDao() {
		return youjianDao;
	}

	public void setYoujianDao(YoujianDao youjianDao) {
		this.youjianDao = youjianDao;
	}
	
	
	//发件箱
	public String youjianlist()  {
		HttpServletRequest request = ServletActionContext.getRequest();			
		String title = request.getParameter("title");

		
		StringBuffer sb = new StringBuffer();
		sb.append(" where ");
		StringBuffer sb2 = new StringBuffer();
		sb2.append(" where ");

		if(title!=null&&!"".equals(title)){
			sb.append("title like '%"+title+"%'");
			sb.append(" and ");
			sb2.append("title like '%"+title+"%'");
			sb2.append(" and ");
			request.setAttribute("title", title);
		}
		
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		
		sb.append(" youjianlock=0 and fromuser.id="+user.getId()+" order by id desc");
		String where = sb.toString();
		sb2.append(" youjianlock=0 and fromuser.id="+user.getId());
		String where2 = sb2.toString();
		int currentpage = 1;
		int pagesize =20;
		if(request.getParameter("pagenum")!=null){
			currentpage = Integer.parseInt(request.getParameter("pagenum"));
		}
		int total = youjianDao.selectBeanCount(where2);
		request.setAttribute("list", youjianDao.selectBeanList((currentpage - 1) * pagesize, pagesize, where));
		request.setAttribute("pagerinfo", Pager.getPagerNormal(total, pagesize,
				currentpage, "method!youjianlist", "共有" + total + "条记录"));
		this.setUrl("youjian/youjianlist.jsp");
		return SUCCESS;
	}

//跳转到写信页面
	public String youjianadd() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		request.setAttribute("list2", userDao.selectBeanList(0, 9999, " where userlock=0 and id!="+user.getId()));
		this.setUrl("youjian/youjianadd.jsp");
		return SUCCESS;
	}
	//写信操作
	public void youjianadd2() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		String content = request.getParameter("content");
		String title = request.getParameter("title");
		String touser = request.getParameter("touser");
		Youjian bean = new Youjian();
		bean.setContent(content);
		bean.setCreatetime(new Date());
		bean.setReadzhuangtai("未阅读");
		bean.setTitle(title);
		HttpSession session = request.getSession();
		User fromuser = (User)session.getAttribute("user");
		bean.setFromuser(fromuser);
		bean.setTouser(userDao.selectBean(" where id= "+touser));
		youjianDao.insertBean(bean);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("gbk");response.setContentType("text/html; charset=gbk");
		response
		.getWriter()
		.print(
				"<script language=javascript>alert('success!');window.location.href='method!youjianlist';</script>");
		
		

		
	}
	//查看信件操作
	public String youjianupdate3() {
		HttpServletRequest request = ServletActionContext.getRequest();
		Youjian bean = youjianDao.selectBean(" where id= "+request.getParameter("id"));
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		if(bean.getTouser().getId()==user.getId()){
			bean.setReadzhuangtai("已阅读");
			youjianDao.updateBean(bean);
		}	
		request.setAttribute("bean", bean);
		this.setUrl("youjian/youjianupdate3.jsp");
		return SUCCESS;
	}
//删除信息操作
	public void youjiandelete() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		Youjian bean = youjianDao.selectBean(" where id= "+request.getParameter("id"));
		bean.setYoujianlock(1);
		youjianDao.updateBean(bean);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("gbk");response.setContentType("text/html; charset=gbk");
		response
		.getWriter()
		.print(
				"<script language=javascript>alert('success!');window.location.href='method!youjianlist';</script>");
	}
	
	
	//收件箱
	public String youjianlist2()  {
		HttpServletRequest request = ServletActionContext.getRequest();			
		String title = request.getParameter("title");

		
		StringBuffer sb = new StringBuffer();
		sb.append(" where ");
		StringBuffer sb2 = new StringBuffer();
		sb2.append(" where ");

		if(title!=null&&!"".equals(title)){
			sb.append("title like '%"+title+"%'");
			sb.append(" and ");
			sb2.append("title like '%"+title+"%'");
			sb2.append(" and ");
			request.setAttribute("title", title);
		}
		
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		
		sb.append(" youjianlock=0 and touser.id="+user.getId()+" order by id desc");
		String where = sb.toString();
		sb2.append(" youjianlock=0 and touser.id="+user.getId());
		String where2 = sb2.toString();
		int currentpage = 1;
		int pagesize =20;
		if(request.getParameter("pagenum")!=null){
			currentpage = Integer.parseInt(request.getParameter("pagenum"));
		}
		int total = youjianDao.selectBeanCount(where2);
		request.setAttribute("list", youjianDao.selectBeanList((currentpage - 1) * pagesize, pagesize, where));
		request.setAttribute("pagerinfo", Pager.getPagerNormal(total, pagesize,
				currentpage, "method!youjianlist2", "共有" + total + "条记录"));
		this.setUrl("youjian/youjianlist2.jsp");
		return SUCCESS;
	}
	
	//跳转到回复信件页面
	public String youjianupdate() {
		HttpServletRequest request = ServletActionContext.getRequest();
		Youjian bean = youjianDao.selectBean(" where id= "+request.getParameter("id"));
		request.setAttribute("bean", bean);
		this.setUrl("youjian/youjianupdate.jsp");
		return SUCCESS;
	}
//回复信件操作
	public void youjianupdate2() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		String content = request.getParameter("content");
		String title = request.getParameter("title");
		Youjian youjian = youjianDao.selectBean(" where id= "+request.getParameter("id"));
		youjian.setReadzhuangtai("已回复");
		youjianDao.updateBean(youjian);
		Youjian bean = new Youjian();
		bean.setContent(content);
		bean.setCreatetime(new Date());
		bean.setReadzhuangtai("未阅读");
		bean.setTitle(title);
		bean.setFromuser(youjian.getTouser());
		bean.setTouser(youjian.getFromuser());
		youjianDao.insertBean(bean);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("gbk");response.setContentType("text/html; charset=gbk");
		response
		.getWriter()
		.print(
				"<script language=javascript>alert('success!');window.location.href='method!youjianlist';</script>");

	}
	
	private TongxunluDao tongxunluDao;


	public TongxunluDao getTongxunluDao() {
		return tongxunluDao;
	}

	public void setTongxunluDao(TongxunluDao tongxunluDao) {
		this.tongxunluDao = tongxunluDao;
	}
	/*//通讯录管理
	public String tongxunlulist()  {
		HttpServletRequest request = ServletActionContext.getRequest();			
		String truename = request.getParameter("truename");

		
		StringBuffer sb = new StringBuffer();
		sb.append(" where ");
		StringBuffer sb2 = new StringBuffer();
		sb2.append(" where ");

		if(truename!=null&&!"".equals(truename)){
			sb.append("truename like '%"+truename+"%'");
			sb.append(" and ");
			sb2.append("truename like '%"+truename+"%'");
			sb2.append(" and ");
			request.setAttribute("truename", truename);
		}
		sb.append(" 1=1 order by id desc");
		String where = sb.toString();
		sb2.append(" 1=1 ");
		String where2 = sb2.toString();
		int currentpage = 1;
		int pagesize =20;
		if(request.getParameter("pagenum")!=null){
			currentpage = Integer.parseInt(request.getParameter("pagenum"));
		}
		int total = tongxunluDao.selectBeanCount(where2);
		request.setAttribute("list", tongxunluDao.selectBeanList((currentpage - 1) * pagesize, pagesize, where));
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		String flag = "0";
		List<Tongxunlu> list = tongxunluDao.selectBeanList((currentpage - 1) * pagesize, pagesize, where);
		for(Tongxunlu t:list){
			if(t.getUser()!=null){
				if(t.getUser().getId()==user.getId()){
					flag = "1";
				}
			}
			
		}
		request.setAttribute("flag", flag);
		
		request.setAttribute("pagerinfo", Pager.getPagerNormal(total, pagesize,
				currentpage, "method!tongxunlulist", "共有" + total + "条记录"));
		this.setUrl("tongxunlu/tongxunlulist.jsp");
		return SUCCESS;
	}

//跳转到添加通讯录页面
	public String tongxunluadd() {
		this.setUrl("tongxunlu/tongxunluadd.jsp");
		return SUCCESS;
	}
	//添加通讯录操作
	public void tongxunluadd2() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		String lianxidianhua = request.getParameter("lianxidianhua");
		String truename = request.getParameter("truename");
		String zhuzhi = request.getParameter("zhuzhi");
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		Tongxunlu bean = tongxunluDao.selectBean(" where user.id= "+user.getId());
		if(bean==null){
			bean = new Tongxunlu();
			bean.setLianxidianhua(lianxidianhua);
			bean.setTruename(truename);
			bean.setUser(user);
			bean.setZhuzhi(zhuzhi);
			tongxunluDao.insertBean(bean);
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("gbk");response.setContentType("text/html; charset=gbk");
			response
			.getWriter()
			.print(
					"<script language=javascript>alert('success!');window.location.href='method!tongxunlulist';</script>");
		}else{
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("gbk");response.setContentType("text/html; charset=gbk");
			response
			.getWriter()
			.print(
					"<script language=javascript>alert('已经成功添加通讯录，操作失败');window.location.href='method!tongxunlulist';</script>");
		}
	}
	//跳转到更新通讯录页面
	public String tongxunluupdate() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		Tongxunlu bean = tongxunluDao.selectBean(" where user.id= "+user.getId());
		request.setAttribute("bean", bean);
		this.setUrl("tongxunlu/tongxunluupdate.jsp");
		return SUCCESS;
	}
//更新通讯录操作
	public void tongxunluupdate2() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		String lianxidianhua = request.getParameter("lianxidianhua");
		String truename = request.getParameter("truename");
		String zhuzhi = request.getParameter("zhuzhi");
		Tongxunlu bean = tongxunluDao.selectBean(" where id= "+request.getParameter("id"));
		bean.setLianxidianhua(lianxidianhua);
		bean.setTruename(truename);
		bean.setZhuzhi(zhuzhi);
		tongxunluDao.updateBean(bean);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("gbk");response.setContentType("text/html; charset=gbk");
		response
		.getWriter()
		.print(
				"<script language=javascript>alert('success!');window.location.href='method!tongxunlulist';</script>");

	}
	
//查看通讯录操作
	public String tongxunluupdate3() {
		HttpServletRequest request = ServletActionContext.getRequest();
		Tongxunlu bean = tongxunluDao.selectBean(" where id= "+request.getParameter("id"));
		request.setAttribute("bean", bean);
		this.setUrl("tongxunlu/tongxunluupdate3.jsp");
		return SUCCESS;
	}
//删除通讯录操作
	public void tongxunludelete() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		Tongxunlu bean = tongxunluDao.selectBean(" where user.id= "+user.getId());
		if(bean!=null){
			tongxunluDao.deleteBean(bean);
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("gbk");response.setContentType("text/html; charset=gbk");
			response
			.getWriter()
			.print(
					"<script language=javascript>alert('success!');window.location.href='method!tongxunlulist';</script>");
		}else{
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("gbk");response.setContentType("text/html; charset=gbk");
			response
			.getWriter()
			.print(
					"<script language=javascript>alert('操作失败，该用户没有通讯录');window.location.href='method!tongxunlulist';</script>");
		}
		
	}*/
	
	
}
