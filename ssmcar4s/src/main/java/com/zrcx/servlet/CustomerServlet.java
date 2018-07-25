package com.zrcx.servlet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zrcx.Dao.ICustomerDao;
import com.zrcx.common.Page;
import com.zrcx.entity.Customer;
@Controller
@RequestMapping(value="customer")
public class CustomerServlet {
	@Autowired
	private ICustomerDao icustomerdao;
	
    @RequestMapping("/list.do")
	public ModelAndView list(HttpServletRequest req,Customer customer){
		
    	 Page page=new Page();
    	Map <String,Object> params= new HashMap<String, Object>();
    	if(customer!=null){
    		String currentPage=req.getParameter("page");
    		String rowsPerPage=req.getParameter("rowsPerPage");
    		params.put("name", customer.getName());
			params.put("sex", customer.getSex());
			params.put("idNo", customer.getIdNo());
			if(currentPage!=null){
				page.setCurrentPage(Integer.parseInt(currentPage));
				page.setRowsPerPage(Integer.parseInt(rowsPerPage));
			
			}

    	}
    	params.put("page", page);
		List<Customer> list=icustomerdao.list(params);
		req.setAttribute("page", page);
		return new ModelAndView("customer/list","list",list);

	}
    @RequestMapping("/slist.do")
	public ModelAndView slist(HttpServletRequest req,Customer customer){
    	
    	Page page=new Page();
    	Map <String,Object> params= new HashMap<String, Object>();
    	if(customer!=null){
    		String currentPage=req.getParameter("page");
    		String rowsPerPage=req.getParameter("rowsPerPage");
    		params.put("name", customer.getName());
			params.put("sex", customer.getSex());
			params.put("idNo", customer.getIdNo());
			if(currentPage!=null){
				page.setCurrentPage(Integer.parseInt(currentPage));
				page.setRowsPerPage(Integer.parseInt(rowsPerPage));
			}

    	}
		params.put("page", page);
		page.setTotalRows(icustomerdao.list(params).size());
		List<Customer> slist=icustomerdao.list(params);
		req.setAttribute("page", page);
		return new ModelAndView("customer/slist","slist",slist);

	}
    @RequestMapping("/add.do")
	public ModelAndView add(HttpServletRequest req,Customer customer) {
		
		if (icustomerdao.add(customer) > 0) {
			req.setAttribute("msg", "添加成功!");

		} else {
			req.setAttribute("msg", "添加失败!");
		}
		return list(req, null);
	}
  @RequestMapping("/delete.do")
	public ModelAndView delete(HttpServletRequest req) {
		String id = req.getParameter("id");
		if(id!=null){
			if (icustomerdao.delete(Long.parseLong(id)) > 0) {
				req.setAttribute("msg", "删除成功!");
			} else {
				req.setAttribute("msg", "删除失败!");
			}	
		}else{
			req.setAttribute("msg","ID丢失，删除失败!");
		}
		
	   return list(req, null);
	}
    @RequestMapping("/update.do")
	public ModelAndView update(HttpServletRequest req,Customer customer){
		// 根据ID参数，进行查询！
		String id = req.getParameter("customerId");
		if (id != null) {
			// 调用方法,更新初始化
		    customer = icustomerdao.findById(Long.parseLong(id));
			return new ModelAndView("customer/update","customer",customer);
		}else{
			// 开始更新
			if (icustomerdao.update(customer) > 0) {
				req.setAttribute("msg", "更新成功!");

			} else {
				req.setAttribute("msg", "更新失败!");
			}
			return list(req, null);
		}
	}

}
