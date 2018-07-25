package com.zrcx.servlet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zrcx.Dao.ISupplierDao;
import com.zrcx.common.Page;
import com.zrcx.entity.Supplier;

/**
 * 供应商信息表
 * */
@Controller
@RequestMapping("supplier")
public class SupplierServlet {

	@Autowired
	private ISupplierDao isupplierdao;

	@RequestMapping("/list.do")
	public ModelAndView list(HttpServletRequest req, Supplier supplier) {

		Page page = new Page();
		Map<String, Object> param = new HashMap<String, Object>();
		if (supplier != null) {
			String currentPage = req.getParameter("page");
			String rowsPerPage = req.getParameter("rowsPerPage");
			param.put("contacts", supplier.getContacts());
			param.put("name", supplier.getName());
			param.put("bankName", supplier.getBankName());
			if (currentPage != null) {
				// 分页
				page.setCurrentPage(Integer.valueOf(currentPage));
				page.setRowsPerPage(Integer.valueOf(rowsPerPage));
			}
		}
		param.put("page", page);
		List<Supplier> list = isupplierdao.list(param);
		req.setAttribute("page", page);
		return new ModelAndView("supplier/list", "list", list);

	}
     
	@RequestMapping("/slist.do")
	public ModelAndView slist(HttpServletRequest req, Supplier supplier) {

		Page page = new Page();
		Map<String, Object> param = new HashMap<String, Object>();
		if (supplier != null) {
			String currentPage = req.getParameter("page");
			String rowsPerPage = req.getParameter("rowsPerPage");
			param.put("contacts", supplier.getContacts());
			param.put("name", supplier.getName());
			param.put("bankName", supplier.getBankName());
			if (currentPage != null) {
				// 分页
				page.setCurrentPage(Integer.valueOf(currentPage));
				page.setRowsPerPage(Integer.valueOf(rowsPerPage));
			}
		}
		param.put("page", page);
		List<Supplier> list = isupplierdao.list(param);
		req.setAttribute("page", page);
		return new ModelAndView("supplier/slist", "list", list);

	}

	@RequestMapping("/add.do")
	public ModelAndView add(HttpServletRequest req, Supplier supplier) {

		if (supplier != null) {
			if (isupplierdao.add(supplier) > 0) {
				req.setAttribute("msg", "添加成功!");
			} else {
				req.setAttribute("msg", "添加失败!");
			}
		}
		return list(req, null);
	}

	@RequestMapping("/delete.do")
	public ModelAndView delete(HttpServletRequest req) {
		String id = req.getParameter("id");
		if (id != null) {
			Supplier supplier = isupplierdao.findById(Long.valueOf(id));
			supplier.setDelFlag(2);
			if (isupplierdao.update(supplier) > 0) {
				req.setAttribute("msg", "删除成功!");
			} else {
				req.setAttribute("msg", "删除失败!");
			}

		}
		return list(req, null);
	}

	@RequestMapping("/update.do")
	public ModelAndView update(HttpServletRequest req, Supplier supplier) {
		// 根据ID参数，进行查询！
		String id = req.getParameter("supplierId");
		if (id != null) {
			// 调用方法,更新初始化
			Supplier s = isupplierdao.findById(Long.parseLong(id));
			return new ModelAndView("supplier/update", "supplier", s);
		} else {
			// 开始更新
			if (isupplierdao.update(supplier) > 0) {
				req.setAttribute("msg", "修改成功!");

			} else {
				req.setAttribute("msg", "修改失败!");
			}

		}
		return list(req, null);
	}
}
