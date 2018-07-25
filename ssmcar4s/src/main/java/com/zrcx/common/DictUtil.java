package com.zrcx.common;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.zrcx.Dao.IDeptDao;
import com.zrcx.Dao.IDictDao;
import com.zrcx.Dao.IMenuDao;
import com.zrcx.Dao.IRoleDao;
import com.zrcx.entity.Dept;
import com.zrcx.entity.Dict;
import com.zrcx.entity.Menu;
import com.zrcx.entity.Role;

/**
 * 系统字典处理工具类
 * 
 * @author JQS
 */
public class DictUtil {
	public static void rereshDict(ServletContext sc) {
		System.out.println("刷新系统字典数据...");
		// 获取web应用中的spring容器
		ApplicationContext ac = WebApplicationContextUtils
				.getWebApplicationContext(sc);
		IDictDao basedao = (IDictDao) ac.getBean("dictDao");
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("useFlag", 1);
		List<Dict> list = basedao.list(param);
		// <字典名称,<字典key,字典value>>
		Map<String, Map<String, String>> allMap = new HashMap<String, Map<String, String>>();
		// 循环字典列表，按照字典名称对所有字典进行分类
		for (Dict d : list) {
			String dictName = d.getDictName();
			Map<String, String> m = allMap.get(dictName);
			if (m != null) {
				m.put(d.getKey(), d.getValue());
			} else {
				// 有顺序的map
				m = new LinkedHashMap<String, String>();
				m.put(d.getKey(), d.getValue());
				allMap.put(dictName, m);
			}
		}
		// 循环字典并把按字典名称放到应用上下文
		for (String dn : allMap.keySet()) {
			System.out.println(dn + " :" + allMap.get(dn));
			sc.setAttribute(dn, allMap.get(dn));
		}
	}

	/**
	 * 把角色数据加载放到上下文中
	 * 
	 * @param sc
	 */
	public static void refreshRole(ServletContext sc) {
		System.out.println("加载系统角色数据...");
		Map<String, Object> param = new HashMap<String, Object>();
		// 获取web应用中的spring容器
		ApplicationContext ac = WebApplicationContextUtils
				.getWebApplicationContext(sc);
		IRoleDao basedao = (IRoleDao) ac.getBean("roleDao");
		List<Role> list = basedao.list(param);
		// Map<roleId,roleName>
		Map<String, String> roleMap = new HashMap<String, String>();
		for (Role r : list) {
			roleMap.put(r.getId() + "", r.getName());
		}
		sc.setAttribute("roleMap", roleMap);
	}

	/**
	 * 把父菜单数据加载放到上下文中
	 * 
	 * @param sc
	 */
	public static void refreshMenu(ServletContext sc) {
		System.out.println("加载系统一级菜单数据...");
		// 获取web应用中的spring容器
		ApplicationContext ac = WebApplicationContextUtils
				.getWebApplicationContext(sc);
		IMenuDao basedao = (IMenuDao) ac.getBean("menuDao");
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("menuLevel", 1);
		List<Menu> list = basedao.list(param);
		Map<String, String> pmenuMap = new HashMap<String, String>();
		for (Menu r : list) {
			pmenuMap.put(r.getId() + "", r.getName());
		}
		sc.setAttribute("pmenuMap", pmenuMap);
	}

	/**
	 * 把部门数据加载放到上下文中
	 * 
	 * @param sc
	 */
	public static void refreshDept(ServletContext sc) {
		System.out.println("加载系统部门数据...");
		Map<String, Object> param = new HashMap<String, Object>();
		ApplicationContext ac=WebApplicationContextUtils.getWebApplicationContext(sc);
		IDeptDao  ideptdao=(IDeptDao)ac.getBean("deptDao");
		List<Dept> list = ideptdao.list(param);
		// Map<deptId,deptName>
		Map<String, String> deptMap = new HashMap<String, String>();
		for (Dept r : list) {
			deptMap.put(r.getId() + "", r.getName());
		}
		sc.setAttribute("deptMap", deptMap);
	}
}
