package com.zrcx.servlet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zrcx.Dao.IMenuDao;
import com.zrcx.common.Page;
import com.zrcx.entity.Menu;

/**
 * 菜单业务处理类
 * 
 * @author jqs
 */
@Controller
@RequestMapping("menu")
public class MenuServlet {
	@Autowired
	private IMenuDao basedao;

	// 充当MVC的C-控制器
	@RequestMapping("/list.do")
	public ModelAndView list(HttpServletRequest req, Menu menu) {
		// 分页对象
		Page page = new Page();
		Map<String, Object> param = new HashMap<String, Object>();
		if (menu != null) {
			String currentPage = req.getParameter("page");
			String rowsPerPage = req.getParameter("rowsPerPage");
			param.put("name", menu.getName());
			param.put("parentId", menu.getParentId());
			param.put("useFlag", menu.getUseFlag());
			param.put("menuLevel", menu.getMenuLevel());
			if (currentPage != null) {
				page.setRowsPerPage(Integer.parseInt(rowsPerPage));
				page.setCurrentPage(Integer.parseInt(currentPage));
			}
		}
		// 把总记录数放进集合
		param.put("page", page);
		List<Menu> list = basedao.list(param);
		if (list.size() <= 0) {
			return new ModelAndView("/menu/list", "msg", "条件不符合,搜索不到您要的记录!");
		}
		req.setAttribute("page", page);
		return new ModelAndView("/menu/list", "list", list);

	}

	@RequestMapping("/add.do")
	public ModelAndView add(HttpServletRequest req, Menu menu) {
		if (basedao.add(menu) > 0) {
			req.setAttribute("msg", "新增成功");
			return list(req, null);
		} else {
			req.setAttribute("msg", "新增失败");
			return list(req, null);
		}
	}

	@RequestMapping("/delete.do")
	public ModelAndView delete(HttpServletRequest req){
		String id = req.getParameter("id");

			if (basedao.delete(Long.parseLong(id)) > 0) {
				req.setAttribute("msg", "删除成功");
				return list(req, null);
			} else {
				req.setAttribute("msg", "删除失败");
				return list(req, null);
		}
	}

	@RequestMapping("/update.do")
	public ModelAndView update(HttpServletRequest req,Menu menu){
		String id = req.getParameter("menuId");
		if (req.getParameter("menuId") != null) {// 初始化更新页面
			menu = basedao.findById(Long.parseLong(id));
			return new ModelAndView("menu/update","menu",menu);
		} else {// 更新提交
			
			if (basedao.update(menu) > 0) {
				req.setAttribute("msg", "更新成功");
				return list(req, null);
			} else {
				req.setAttribute("msg", "更新失败");
				return list(req, null);
			}
		}

	}
}
