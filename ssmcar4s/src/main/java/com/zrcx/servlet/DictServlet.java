package com.zrcx.servlet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zrcx.Dao.IDictDao;
import com.zrcx.common.Page;
import com.zrcx.entity.Dict;

/**
 * 字典业务处理类
 * 
 * @author jqs
 */
@Controller
@RequestMapping(value = "dict")
public class DictServlet {
	@Autowired
	private IDictDao basedao;

	// 查询列表(业务模型-MVC中的M)
	@RequestMapping("/list.do")
	public ModelAndView list(HttpServletRequest req, Dict dict) {
		
		// 创建分页对象
		Page p = new Page();
		Map<String, Object> param = new HashMap<String, Object>();
		if (dict != null) {
			String currentPage = req.getParameter("page");
			String rowsPerPage = req.getParameter("rowsPerPage");
			param.put("dictName", dict.getDictName());
			param.put("key", dict.getKey());
			param.put("value", dict.getValue());
			param.put("useFlag", dict.getUseFlag());
			// 为p对象属性赋值(当前是第几页,初始值为1)
			if (currentPage != null) {
				p.setRowsPerPage(Integer.parseInt(rowsPerPage));
				p.setCurrentPage(Integer.parseInt(currentPage));
			}
		}
		param.put("page", p);
		param.put("page", p);
		List <Dict> list=basedao.list(param);
		req.setAttribute("page", p);
		return new ModelAndView("dict/list","list",list);
	}

	@RequestMapping("/add.do")
	public ModelAndView add(HttpServletRequest req,Dict dict) {

		if (basedao.add(dict)> 0) {
			req.setAttribute("msg","新增成功!");
			return list(req,null);
		} else {
			req.setAttribute("msg","新增失败!");
			return list(req,null);
		}
	}

	// 删除(业务模型-MVC中的M)
	@RequestMapping("/delete.do")
	public ModelAndView delete(HttpServletRequest req){
		if(req.getParameter("id")!=null){		
		if (basedao.delete(Long.parseLong(req.getParameter("id"))) > 0) {
			req.setAttribute("msg","删除成功!");
			return list(req,null);
		} else {
			req.setAttribute("msg","删除失败!");
			return list(req,null);
		}
		}else{
			req.setAttribute("msg","该信息无法删除,删除标识找不到!");
			return list(req,null);
		}
		
	}
	@RequestMapping("/update.do")
	public ModelAndView update(HttpServletRequest req,Dict dict) {
		if (req.getParameter("dictId")!=null) {// 初始化更新页面
		    dict = basedao.findById(Long.parseLong(req.getParameter("dictId")));
			return new ModelAndView("dict/update","dict",dict);
		} else {
			// 更新提交  
			if (basedao.update(dict) > 0) {
				req.setAttribute("msg","更新成功!");
				return list(req,null);
			} else {
				req.setAttribute("msg","更新失败!");
				return list(req,null);
			}
		}

	}
}
