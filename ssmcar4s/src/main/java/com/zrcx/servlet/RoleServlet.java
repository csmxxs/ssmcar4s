package com.zrcx.servlet;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.sf.json.JSONArray;

import com.zrcx.Dao.IMenuDao;
import com.zrcx.Dao.IRoleDao;
import com.zrcx.entity.Menu;
import com.zrcx.entity.Role;
/**
 * 角色业务处理类
 * @author jqs
 */
@Controller
@RequestMapping(value="role")
public class RoleServlet{
     @Autowired
     private IRoleDao roleDao;
     @Autowired
     private IMenuDao menuDao;
	//查询列表(业务模型-MVC中的M)
	@RequestMapping(value="/list.do")
	public ModelAndView list(Role role) {
		Map<String,Object> param = new HashMap<String,Object>();
		if(role!=null){
			param.put("name",role.getName());
		}
       return new ModelAndView("role/list","list",roleDao.list(param));
	}
	//查询列表,专门给弹出窗口使用
	@RequestMapping(value="/slist.do")
	public ModelAndView slist() {
		Map<String,Object> param = new HashMap<String,Object>();
		return new ModelAndView("role/slist","list",roleDao.list(param));
	}
	//新增(业务模型-MVC中的M)
	@RequestMapping(value="/add.do")
	public ModelAndView add(Role role,HttpServletRequest req) {
		if(roleDao.add(role)>0){
			req.setAttribute("msg","新增成功");
		}else{
			req.setAttribute("msg","新增失败");
		}
		return list(null);
		
	}
	//删除(业务模型-MVC中的M)
	@RequestMapping(value="/delete.do")
	public ModelAndView delete(HttpServletRequest req){
		String id = req.getParameter("id");
		if(id!=null){
			if(roleDao.delete(Long.parseLong(id))>0){
				req.setAttribute("msg","删除成功");
			}else{
				req.setAttribute("msg","删除失败");
			}
		}
		return list(null);
	}
	//更新(业务模型-MVC中的M)
	@RequestMapping(value="/update.do")
	public ModelAndView update(HttpServletRequest req,Role role){
		String roleId = req.getParameter("roleId");
		if(roleId!=null){
			return new ModelAndView("role/update","role", roleDao.findById(Long.parseLong(roleId)));
		}else{
			if(roleDao.update(role)>0){
				req.setAttribute("msg","更新成功");
				return list(null);
			}else{
				req.setAttribute("msg","更新失败");
				return list(null);
			}
		}
	}

	//弹出窗口为角色分配菜单
	@RequestMapping(value="/menuTree.do")
	public ModelAndView menuTree(HttpServletRequest req){
		// 查询所有菜单
		Map<String, Object> param = new HashMap<String, Object>();
		//查询所有菜单
		List<Menu> list1 = menuDao.list(param);
		//查询角色当前菜单权限
		String roleId = req.getParameter("roleId");
		List<Menu> list2 = menuDao.getMenusByRoleId(Long.parseLong(roleId));
		//临时变量(用于判断哪个菜单当前用色已拥有)
		List<Long> menuIds = new ArrayList<Long>();
		for (Menu m : list2) {
			menuIds.add(m.getId());
		}		
		//在角色拥有的菜单权限上做标记
		for (Menu o : list1) {
			if (menuIds.contains(o.getId())) {
				o.setChecked(true);
			} else {
				o.setChecked(false);
			}
		}
		JSONArray jo2 = JSONArray.fromObject(list1);
		// 把对象集合转化成json格式字符串
		String menuJson = jo2.toString();
		System.out.println("menuJson=" + menuJson);
		// 把集合放到request对象属性中，传送到页面显示
		req.setAttribute("roleId", roleId);
		return new ModelAndView("role/menuTree","json",menuJson);
	}
	/**
	 * 更新角色和菜单关系信息（新增和删除）
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value="/updateRole2Menu.do")
	public void updateRole2Menu(HttpServletRequest req,HttpServletResponse resp) throws Exception{
		//先根据角色ID去数据库查询它拥有的菜单
		String roleId = req.getParameter("roleId");
		List<Menu> list =menuDao.getMenusByRoleId(Long.parseLong(roleId));
		// 临时变量(用于判断哪个菜单当前角色已拥有)
		List<String> menuIds = new ArrayList<String>();
		for (Menu m : list) {
			menuIds.add(m.getId()+"");
		}		
    	int i = 0;
    	try {
    		//新增菜单ID串
    		String ms = req.getParameter("menuIds");
			//新增的菜单选项
			for (String menuId : ms.split(",")) {
				if (!"".equals(menuId) && !menuIds.contains(menuId)) {//
					roleDao.addRole2Menu(Long.parseLong(roleId),Long.parseLong(menuId));
				}
			}
			//删除的菜单选项
			List<String> menuList = Arrays.asList(ms.split(","));
			for (String menuId : menuIds) {
				if (!menuList.contains(menuId)) {
					roleDao.deleteRole2Menu(Long.parseLong(roleId),Long.parseLong(menuId));
				}
			}
			i = 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
    	String json = "";
		if (i > 0) {
			json = "{'result':'权限分配成功'}";
		} else {
			json = "{'result':'权限分配失败'}";
		}
		PrintWriter out = resp.getWriter();
		out.write(json);
		out.flush();
		out.close();
	}
}
