package com.zrcx.servlet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zrcx.Dao.IMenuDao;
import com.zrcx.Dao.IUserDao;
import com.zrcx.entity.Menu;
import com.zrcx.entity.User;

/**
 * 处理 登录、注册、退出系统
 * */
@Controller
public class SysServlet{

	@Autowired
	private IUserDao ud;
	@Autowired
	private IMenuDao  menuDao;
    @RequestMapping("/sys_login.do")
	public ModelAndView login(HttpServletRequest req) {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		System.out.println("用户名:" + username + "\t密码:" + password);
		if(username==null||"".equals(username.trim())||password==null||"".equals(password.trim())){
			//String msg="{\"msg\":\"登录失败!\"}";			
			return new ModelAndView("common/login","msg","请输入正确的用户名和密码!");
		}
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("username", username);
		param.put("password", password);
		List<User> list = ud.list(param);
		HttpSession session = req.getSession();
		String msg = "";
		if (list.size() > 0) {
			//获取一个会话对象
			User u = list.get(0);
			if (u.getLoginFlag() == 1) {
				// 保存一个会话对象
				session.setAttribute("user", u);
 				//用户菜单
 				List<Menu> ulist = menuDao.getMenusByRoleId(u.getRoleId());
 				//<父菜单对象,父菜单对象下的所有子菜单集合>
 				//对该集合进行排序,对应的实体类要实现排序接口，并复写排序方法
				Map<Menu,List<Menu>> map = new TreeMap<Menu, List<Menu>>();
				//装父菜单的临时map<菜单ID,菜单对象>
				Map<Long,Menu> temp = new HashMap<Long, Menu>();
				// 处理一级菜单
				for (Menu m1 : ulist) {
					if (m1.getMenuLevel() == 1) {
						temp.put(m1.getId(), m1);
						map.put(m1, new ArrayList<Menu>());
					}
				}
				// 处理二级菜单
				for (Menu m2 : ulist) {
					if (m2.getMenuLevel() == 2) {
						// 获得该二级菜单对应父菜单对象
						Menu pm = temp.get(m2.getParentId());
						// 把该二级菜单放到它对应父菜单的子菜单集合
						if (map.get(pm) != null) {
							map.get(pm).add(m2);
						}
					}
				}
				//系统菜单
				req.getSession().setAttribute("menu",map);
				return new ModelAndView("common/index");
				
			} else {
				msg = "用户名已过期!";
			}
		} else {
			msg = "用户名或者密码错误!";
		}
		req.setAttribute("msg", msg);// 通过requst对象传值
		return new ModelAndView("common/login");
	}
    @RequestMapping("/loginout.do")
	public ModelAndView loginout(HttpServletRequest req) {
		// 退出系统时销毁会话信息
		HttpSession session = req.getSession();
		// 销毁会话对象
		session.removeAttribute("user");
		session.invalidate();
		// 为登录页面设置提示信息
		req.setAttribute("msg", "系统退出!");
		return new ModelAndView("common/login");

	}
    @RequestMapping(value="/sys_register")
	public void register(HttpServletRequest req, HttpServletResponse resp) {

	}
}
