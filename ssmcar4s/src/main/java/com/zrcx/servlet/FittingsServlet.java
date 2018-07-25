package com.zrcx.servlet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zrcx.Dao.FittingsDao;
import com.zrcx.Dao.IFittingsDao;
import com.zrcx.common.Page;
import com.zrcx.entity.Fittings;

/**
 * 配件信息管理
 * */
@Controller
@RequestMapping(value="fittings")
public class FittingsServlet {
	@Autowired
    private IFittingsDao iFittingsDao;
	// 给弹出框使用
	@RequestMapping("/slist.do")
	private ModelAndView slist(HttpServletRequest req,Fittings fittings){
		
		Page page=new Page();
		Map<String, Object> param = new HashMap<String, Object>();
		if(fittings!=null){
			String pagernumber = req.getParameter("page");// 页面设置了初始值为1
			String rowsPerPage = req.getParameter("rowsPerPage");
			param.put("name",fittings.getName());
			param.put("type",fittings.getType());
			param.put("unit",fittings.getUnit());
			// 为p对象属性赋值(当前是第几页,初始值为1)
			if(pagernumber!=null){
			page.setCurrentPage(Integer.parseInt(pagernumber));
			page.setRowsPerPage(Integer.parseInt(rowsPerPage));
		
			}
		}   
		param.put("page", page);
		List<Fittings> list = iFittingsDao.list(param);
		req.setAttribute("page", page);
		return new ModelAndView("fittings/slist","list",list);

	}
	@RequestMapping("/list.do")
	public ModelAndView list(HttpServletRequest req,Fittings fittings) {
		Page page=null;
		Map<String, Object> param = new HashMap<String, Object>();
		if(page==null){
			page=new Page();
		}

		if(fittings!=null){
			String pagernumber = req.getParameter("page");// 页面设置了初始值为1
			String rowsPerPage = req.getParameter("rowsPerPage");
			param.put("name",fittings.getName());
			param.put("type",fittings.getType());
			param.put("unit",fittings.getUnit());
			// 为p对象属性赋值(当前是第几页,初始值为1)
			if(pagernumber!=null){
			page.setCurrentPage(Integer.parseInt(pagernumber));
			page.setRowsPerPage(Integer.parseInt(rowsPerPage));
			}
		}   
		param.put("page", page);
		page.setTotalRows(iFittingsDao.list(param).size());
		List<Fittings> list = iFittingsDao.list(param);
		req.setAttribute("page", page);
		return new ModelAndView("fittings/list","list",list);

	}
	@RequestMapping("/add.do")
	public void add(HttpServletRequest req,Fittings fittings){
		
		if (iFittingsDao.add(fittings) > 0) {
			req.setAttribute("msg", "添加成功!");

		} else {
			req.setAttribute("msg", "添加失败!");
		}
		list(req,null);
	}
	@RequestMapping("/delete.do")
	public void delete(HttpServletRequest req){
	    String fittingsId=req.getParameter("id");
		if(fittingsId != null){
			if (iFittingsDao.delete(Long.parseLong(fittingsId)) > 0) {
				req.setAttribute("msg", "删除成功!");
				list(req,null);
			} else {
				req.setAttribute("msg", "删除失败!");
				list(req,null);
			}
		}
	}
	@RequestMapping("/update.do")
	public ModelAndView update(HttpServletRequest req,Fittings fittings){
		// 根据ID参数，进行查询！
		String fittingsId = req.getParameter("fittingsId");
		FittingsDao ud = new FittingsDao();
		if (fittingsId != null) {
			// 调用方法,更新初始化
		    fittings = iFittingsDao.findById(Long.parseLong(fittingsId));
			// 保存会话对象
			 return new ModelAndView("fittings/update");
		} else {
			// 开始更新
			if (ud.update(fittings) > 0) {
				req.setAttribute("msg", "修改成功!");
              return  list(req,null);
			} else {
				req.setAttribute("msg", "修改失败!");
				return list(req,null);
			}
		}
	}
}
