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

import com.zrcx.Dao.ICarInorderDao;
import com.zrcx.Dao.ICarStockDao;
import com.zrcx.common.Page;
import com.zrcx.entity.CarInorder;
import com.zrcx.entity.CarStock;

/**
 * 整车进货单控制层
 * */
@Controller
@RequestMapping("carInorder")
public class CarInorderServlet {
	@Autowired
	private ICarStockDao icarstockdao;
	@Autowired
	private ICarInorderDao icarinorderdao;
	
	//整车订货单查询
	@RequestMapping("/list.do")
	public ModelAndView list(HttpServletRequest req, CarInorder carinorder) {

		Page page = new Page();
		Map<String, Object> param = new HashMap<String, Object>();
		if (carinorder != null) {
			String currentPage = req.getParameter("page");
			String rowsPerPage = req.getParameter("rowsPerPage");
			param.put("carName", carinorder.getCarName());
			param.put("carSeries", carinorder.getCarSeries());
			param.put("supplierId", carinorder.getSupplierId());
			param.put("inState", carinorder.getInState());
			if (currentPage != null) {
				page.setCurrentPage(Integer.valueOf(currentPage));
				page.setRowsPerPage(Integer.valueOf(rowsPerPage));
			}

		}
		param.put("page", page);
		List<CarInorder> list = icarinorderdao.list(param);
		req.setAttribute("page", page);
		return new ModelAndView("carInorder/list", "list", list);
	}
	//整车订货单添加
	@RequestMapping("/add.do")
	public ModelAndView add(HttpServletRequest req, CarInorder carinorder) {
		// 计算总价
		int total = carinorder.getCount() * (carinorder.getInPrice());
		carinorder.setDelFlag(1);
		carinorder.setTotal(total);
		if (icarinorderdao.add(carinorder) > 0) {
			req.setAttribute("msg", "添加成功!");
		} else {
			req.setAttribute("msg", "添加失败!");
		}
		return this.list(req, null);
	}

	@RequestMapping("/delete.do")
	public void delete(HttpServletRequest req) {
		
		String id = req.getParameter("id");
		if (id != null) {
			CarInorder carinorder=icarinorderdao.findById(Long.valueOf(id));
			//使该订单失效
			carinorder.setDelFlag(2);
			if (icarinorderdao.update(carinorder) > 0) {
				req.setAttribute("msg", "删除成功!");
			} else {
				req.setAttribute("msg", "删除失败!");
			}
			this.list(req, null);
		}
	}
    //整车订货单修改
	@RequestMapping("/update.do")
	public ModelAndView update(HttpServletRequest req, CarInorder carinorder) {
		// 根据ID参数，进行查询！
		String id = req.getParameter("listId");
		if (id != null) {
			// 调用方法,更新初始化
			CarInorder us = icarinorderdao.findById(Long.valueOf(id));
			return new ModelAndView("carInorder/update", "carinorder", us);
		} else {
			// 开始更新
			// 计算总价
			int total = carinorder.getCount() * (carinorder.getInPrice());
			carinorder.setTotal((Integer) total);
			if (icarinorderdao.update(carinorder) > 0) {
				req.setAttribute("msg", "更新成功!");
			} else {
				req.setAttribute("msg", "更新失败!");
			}
			return this.list(req, null);
		}
	}
    //整车订货单入库
	@RequestMapping("/inState.do")
	public ModelAndView inState(HttpServletRequest req) {
		String id = req.getParameter("id");
		CarStock carstock = null;
		CarInorder carinorder = null;
		if (id != null) {
			// 先查出订单信息
			carinorder = icarinorderdao.findById(Long.valueOf(id));
			// 在查库存信息
			carstock = icarstockdao.findBycarId(carinorder.getCarId());
		} else {
			req.setAttribute("msg", "订单ID找不到");
		    return this.list(req, null);
		}
		// 入库请求
		// 获取库存整车ID，当不存在该ID时则为新车型
		if (carstock == null) {
			// 将新的入库对象进行入库
			carstock = new CarStock();
			carstock.setCount(carinorder.getCount());
			carstock.setCarId(carinorder.getCarId());
			if (icarstockdao.add(carstock) > 0) {
				//修改入库日期和入库状态
				carinorder.setInState(2);
				carinorder.setInDate(new Date());
			   if(icarinorderdao.update(carinorder)>0){
				   req.setAttribute("msg", "新车型入库成功!");
			   }else{
				   req.setAttribute("msg","修改入库日期或状态时发生错误!");
			   }	
				
			} else {
				req.setAttribute("msg", "新车型入库失败!");
			}
			return this.list(req, null);
		}
		if (carstock != null) {
			// 得到新的库存量
			Integer integer = carinorder.getCount() + (carstock.getCount());
			carstock.setCount(integer);
			if (icarstockdao.update(carstock) > 0) {
				//修改入库日期和状态
				carinorder.setInState(2);
				carinorder.setInDate(new Date());
			   if(icarinorderdao.update(carinorder)>0){
				   req.setAttribute("msg", "原有车型入库成功!");
			   }else{
				   req.setAttribute("msg","修改入库日期或状态时发生错误!");
			   }
			} else {
				req.setAttribute("msg", "原有车型入库失败!");
			}
		}

		return this.list(req, null);
	}

}
