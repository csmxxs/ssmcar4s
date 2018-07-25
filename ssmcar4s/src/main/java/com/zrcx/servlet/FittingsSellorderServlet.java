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

import com.zrcx.Dao.IFittingsSellorderDao;
import com.zrcx.Dao.IFittingsStockDao;
import com.zrcx.common.Page;
import com.zrcx.entity.FittingsSellorder;
import com.zrcx.entity.FittingsStock;

/**
 * 配件销售单控制层
 * */
@Controller
@RequestMapping("fittingssellorder")
public class FittingsSellorderServlet {
	@Autowired
	private IFittingsStockDao ifittingsstockdao;
	@Autowired
	private IFittingsSellorderDao ifittingssellorderdao;

	@RequestMapping("/list.do")
	public ModelAndView list(HttpServletRequest req,
			FittingsSellorder fittingssellorder) {

		Map<String, Object> param = new HashMap<String, Object>();
		Page page = new Page();
		if (fittingssellorder != null) {
			String currentpage = req.getParameter("page");
			String rowsperpage = req.getParameter("rowsPerPage");
			param.put("fittingsname", fittingssellorder.getFittingsname());
			param.put("fittingsbrand", fittingssellorder.getFittingsbrand());
			param.put("outState", fittingssellorder.getOutState());
			param.put("salesman", fittingssellorder.getSalesman());
			if (currentpage != null) {
				page.setCurrentPage(Integer.valueOf(currentpage));
				page.setRowsPerPage(Integer.valueOf(rowsperpage));
			}
		}
		param.put("page", page);
		List<FittingsSellorder> list = ifittingssellorderdao
				.list(param);
		req.setAttribute("page", page);
		return new ModelAndView("fittingssellorder/list", "list",
				list);

	}

	@RequestMapping("/add.do")
	public ModelAndView add(HttpServletRequest req, FittingsSellorder fittingssellorder) {
		// 得到销售订单总价格
		int total = (fittingssellorder.getCount())
				* (fittingssellorder.getSellPrice());
		fittingssellorder.setTotal(total);
		if (ifittingssellorderdao.add(fittingssellorder) > 0) {
			req.setAttribute("msg", "添加成功!");

		} else {
			req.setAttribute("msg", "添加失败!");
		}
		return list(req, null);
	}

	@RequestMapping("/delete.do")
	public ModelAndView delete(HttpServletRequest req) {
		String id = req.getParameter("id");
		if (id != null) {
			if (ifittingssellorderdao.delete(Long.valueOf(id)) > 0) {
				req.setAttribute("msg", "删除成功!");
			} else {
				req.setAttribute("msg", "删除失败!");
			}
		} else {
			req.setAttribute("msg", "订单ID不存在，删除失败!");
		}
		return list(req, null);
	}

	@RequestMapping("/update.do")
	public ModelAndView update(HttpServletRequest req,
			FittingsSellorder fittingssellorder) {
		// 根据ID参数，进行查询！
		String id = req.getParameter("fittingsSellorderId");
		if (id != null) {
			// 更新初始化
			fittingssellorder = ifittingssellorderdao.findById(Long
					.parseLong(id));
			return new ModelAndView("fittingssellorder/update",
					"fittingssellorder", fittingssellorder);
		} else {
			// 开始更新
			// 得到销售订单总价格
			int total = (fittingssellorder.getCount())
					* (fittingssellorder.getSellPrice());
			fittingssellorder.setTotal(total);
			if (ifittingssellorderdao.update(fittingssellorder) > 0) {
				req.setAttribute("msg", "修改成功!");

			} else {
				req.setAttribute("msg", "修改失败!");
			}
			return list(req, null);
		}
	}

	// 开始提货操作
	@RequestMapping("/push.do")
	private ModelAndView push(HttpServletRequest req) {
		String id = req.getParameter("id");
		FittingsSellorder fittingssellorder = null;
		FittingsStock fittingsstock = null;
		if (id != null) {
			// 得到该配件销售订单对象
			fittingssellorder = ifittingssellorderdao
					.findById(Long.valueOf(id));
			// 找出该配件的库存对象
			fittingsstock = ifittingsstockdao.findByfittingsId(Long
					.valueOf(fittingssellorder.getFittingsId()));
		} else {
			req.setAttribute("msg", "订单ID找不到");
			return this.list(req, null);
		}
		if (0 <= fittingsstock.getCount() - fittingssellorder.getCount()
				&& fittingssellorder.getCount() != 0) {
			// 开始修改库存
			Integer integer = fittingsstock.getCount()
					- (fittingssellorder.getCount());
			fittingsstock.setCount(integer);
			if (ifittingsstockdao.update(fittingsstock) > 0) {
				// 修改订单状态
				fittingssellorder.setOutDate(new Date());
				fittingssellorder.setOutState(2L);
				if (ifittingssellorderdao.update(fittingssellorder) > 0) {

				} else {
					req.setAttribute("msg", "订单状态发生错误!");
				}
				req.setAttribute("msg", "提货成功!");
			} else {
				req.setAttribute("msg", "库存修改异常!");
			}
		} else {
			req.setAttribute("msg", "提货失败!");
		}
		return list(req, null);
	}
}
