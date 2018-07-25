package com.zrcx.servlet;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zrcx.Dao.ICarSellorderDao;
import com.zrcx.Dao.ICarStockDao;
import com.zrcx.common.Page;
import com.zrcx.entity.CarSellorder;
import com.zrcx.entity.CarStock;

/**
 * 整车销售业务处理类
 * 
 * @author jqs
 */
@Controller
@RequestMapping("carsellorder")
public class CarSellorderServlet {

	@Autowired
	private ICarSellorderDao icarsellorderdao;
	@Autowired
	private ICarStockDao icarstockdao;

	// 整车销售单查询
	@RequestMapping("/list.do")
	public ModelAndView list(HttpServletRequest req, CarSellorder carsellorder) {

		Page page = new Page();
		Map<String, Object> param = new HashMap<String, Object>();
		if (carsellorder != null) {
			String currentPage = req.getParameter("page");
			String rowsPerPage = req.getParameter("rowsPerPage");
			param.put("carName", carsellorder.getCarName());
			param.put("outState", carsellorder.getOutState());
			param.put("carSeries", carsellorder.getCarSeries());
			param.put("salesman", carsellorder.getSalesman());
			if (currentPage != null) {
				page.setCurrentPage(Integer.valueOf(currentPage));
				page.setRowsPerPage(Integer.valueOf(rowsPerPage));
			}
		}
		param.put("page", page);
		List<CarSellorder> list = icarsellorderdao.list(param);
		req.setAttribute("page", page);
		return new ModelAndView("carsellorder/list", "list", list);

	}

	// 整车销售单添加
	@RequestMapping("/add.do")
	public ModelAndView add(HttpServletRequest req, CarSellorder carsellorder) {
		// 计算总价
		int total = carsellorder.getCount() * (carsellorder.getSellPrice());
		carsellorder.setTotal(total);
		if (icarsellorderdao.add(carsellorder) > 0) {
			req.setAttribute("msg", "新增成功");
		} else {
			req.setAttribute("msg", "新增失败");
		}
	   return list(req, null);

	}

	// 整车销售单删除
	@RequestMapping("/delete.do")
	public ModelAndView delete(HttpServletRequest req) {
		String id = req.getParameter("id");
		if (id != null) {
;			if (icarsellorderdao.delete(Long.valueOf(id)) > 0) {
				req.setAttribute("msg", "删除成功");
			} else {
				req.setAttribute("msg", "删除失败");
			}

		}
	  return list(req, null);
	}

	// 整车销售单修改
	@RequestMapping("/update.do")
	public ModelAndView update(HttpServletRequest req, CarSellorder carsellorder) {
		String id = req.getParameter("carsellorderId");
		if (id != null) {// 初始化更新页面
			CarSellorder cso = icarsellorderdao.findById(Long.valueOf(id));
			return new ModelAndView("carsellorder/update", "carsellorder", cso);
		} else {// 更新提交
			int total = carsellorder.getCount() * (carsellorder.getSellPrice());
			carsellorder.setTotal(total);
			carsellorder.setOutState(1);
			if (icarsellorderdao.update(carsellorder) > 0) {
				req.setAttribute("msg", "更新成功");
			} else {
				req.setAttribute("msg", "更新失败");
			}
			return list(req, null);
		}
	}

	// 整车销售单提货
	@RequestMapping("/buyCar.do")
	public ModelAndView buyCar(HttpServletRequest req) {
		String id = req.getParameter("id");
		CarSellorder carsellorder = null;
		CarStock carstock = null;
		if (id != null) {
			// 得到该销售订单对象
			carsellorder = icarsellorderdao.findById(Long.valueOf(id));
			// 找出该车型的库存对象
			carstock = icarstockdao.findBycarId(carsellorder.getCarId());
		} else {
			req.setAttribute("msg", "订单ID找不到");
			return this.list(req, null);
		}
		if (0 <= carstock.getCount() - carsellorder.getCount()
				&& carsellorder.getCount() != 0) {
			// 开始修改库存
			Integer integer = carstock.getCount() - (carsellorder.getCount());
			carstock.setCount(integer);
			if (icarstockdao.update(carstock) > 0) {
				//修改订单状态
				carsellorder.setOutDate(new Date());
				carsellorder.setOutState(2);
				if(icarsellorderdao.update(carsellorder)>0){
					
				}else{
					req.setAttribute("msg", "订单状态发生错误!");
				}
				req.setAttribute("msg", "提车成功!");
			}else{
				req.setAttribute("msg","库存修改异常!");
			}
		} else {
			req.setAttribute("msg", "提车失败!");
		}
		return list(req, null);
	}

}
