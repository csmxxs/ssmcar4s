package com.zrcx.common;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
/**
 * 系统启动初始化类
 * @author zhql
 */
//用户注解配置servlet启动时自动加载，必须加value和loadOnStartup属性
//loadOnStartup启动顺序1,2,3数字起小就优先启动
@WebServlet(value="/InitServlet",loadOnStartup=1)
public class InitServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("系统启动初始化...");
		//应用上下文ServletContext,在Jsp就是application
		ServletContext sc = config.getServletContext();
		//上下文路径，就是根路径
		String rootPath = sc.getContextPath();
		System.out.println("项目根路径:"+rootPath);
		sc.setAttribute("_cxt", rootPath);
		sc.setAttribute("_css", rootPath+"/ui/css");
		sc.setAttribute("_img", rootPath+"/ui/img");
		sc.setAttribute("_js", rootPath+"/ui/js");
		sc.setAttribute("_plugins", rootPath+"/ui/plugins");
		sc.setAttribute("_title", "汽车4S店管理系统");
		sc.setAttribute("top_title", "汽车4S店管理系统");
		//数据字典
		DictUtil.rereshDict(sc);
		//菜单字典
		DictUtil.refreshMenu(sc);
		//角色字典
		DictUtil.refreshRole(sc);
		//部门字典
		DictUtil.refreshDept(sc);
	}
}
