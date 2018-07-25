package com.zrcx.servlet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zrcx.Dao.ICarStockDao;
import com.zrcx.Dao.IFittingsStockDao;
import com.zrcx.common.Page;
import com.zrcx.entity.CarStock;
import com.zrcx.entity.FittingsStock;


/**
 * 整车库存信息列表,配件库存信息列表
 * */
@Controller
@RequestMapping("stock")
public class CarStockServlet{
     @Autowired
     private ICarStockDao icarstockdao;
     @Autowired
     private IFittingsStockDao ifittingsdao;
	@RequestMapping("/car_list.do")
	public ModelAndView list(HttpServletRequest req,CarStock cs) {
		Page page=new Page();
		Map<String, Object> param = new HashMap<String, Object>();
		if(cs!=null){
			String currentpage=req.getParameter("page");
			String rowsPerPage=req.getParameter("rowsPerPage");
			param.put("carbrand",cs.getCarbrand());
			param.put("carseries",cs.getCarseries());
			param.put("cartype",cs.getCartype());
			param.put("carvolume",cs.getCarvolume());
			if(currentpage!=null){
				// 为p对象属性赋值(当前是第几页,初始值为1)
				page.setCurrentPage(Integer.parseInt(currentpage));
				page.setRowsPerPage(Integer.parseInt(rowsPerPage));
			}
		}
		param.put("page",page);
		req.setAttribute("page", page);
		List<CarStock> carstock = icarstockdao.list(param);
		return new ModelAndView("stock/car_list","carstock",carstock);

	}
	@RequestMapping("/fittings_list.do")
	public ModelAndView fittingslist(HttpServletRequest req,FittingsStock fs){
		Page page=null;
		Map<String, Object> param = new HashMap<String, Object>();
		if(page==null){
			page=new Page();
		}
		
		if(fs!=null){
			String currentpage=req.getParameter("page");
			String rowsPerPage=req.getParameter("rowsPerPage");
			param.put("carstockname", fs.getCarstockname());
			param.put("carstocktype",fs.getCarstocktype());
			param.put("carstockbrand",fs.getCarstockbrand());
			if(currentpage!=null){
				// 为p对象属性赋值(当前是第几页,初始值为1)
				page.setCurrentPage(Integer.parseInt(currentpage));
				page.setRowsPerPage(Integer.parseInt(rowsPerPage));
				
			}
		}
		param.put("page",page);
		page.setTotalRows(ifittingsdao.list(param).size());
		req.setAttribute("page", page);
		List<FittingsStock> fittingsstock = ifittingsdao.list(param);
		return new ModelAndView("stock/fittings_list","fittingsstock",fittingsstock);
		
	}
}
