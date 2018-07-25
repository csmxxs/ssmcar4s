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

import com.zrcx.Dao.IFittingsInorderDao;
import com.zrcx.Dao.IFittingsStockDao;
import com.zrcx.common.Page;
import com.zrcx.entity.FittingsInorder;
import com.zrcx.entity.FittingsStock;
/**
 * 配件进货单控制层
 * */
@Controller
@RequestMapping("fittingsInorder")
public class FittingsInorderServlet {
    
	@Autowired
	private IFittingsInorderDao ifittingsinorderdao;
	@Autowired
	private IFittingsStockDao ifittingsstockdao;
    @RequestMapping("/list.do")
	public ModelAndView list(HttpServletRequest req,FittingsInorder fittingsInorder){
    	
    	Page page=new Page();
    	Map<String, Object> param= new HashMap<String, Object>();
    	 if(fittingsInorder!=null){
    		String currentPage = req.getParameter("page");
    		String rowsPerPage = req.getParameter("rowsPerPage");
    		param.put("fittingsName", fittingsInorder.getFittingsName());
 			param.put("supplierId", fittingsInorder.getSupplierId());
 			param.put("inState", fittingsInorder.getInState());
             if(currentPage != null){
            	 page.setCurrentPage(Integer.valueOf(currentPage));
            	 page.setRowsPerPage(Integer.valueOf(rowsPerPage));
             }
    	 }
    	 param.put("page", page);
		 List<FittingsInorder> list = ifittingsinorderdao.list(param);
		 req.setAttribute("page", page);
		 return new ModelAndView("fittingsInorder/list","list",list);

	}
    @RequestMapping("/add.do")
	public ModelAndView add(HttpServletRequest req,FittingsInorder fittingsInorder){
	    if(fittingsInorder!=null){
			// 计算总价
			int total = fittingsInorder.getCount() * (fittingsInorder.getInPrice());
			fittingsInorder.setTotal(total);
	    	fittingsInorder.setDelFlag(1);
		if (ifittingsinorderdao.add(fittingsInorder) > 0) {
			req.setAttribute("msg", "添加成功!");

		} else {
			req.setAttribute("msg", "添加失败!");
		}
	    }else{
	    	return list(req, null);
	    }
		return list(req, null);
	}

	public ModelAndView delete(HttpServletRequest req){
		String id = req.getParameter("id");
		if(id !=null){
			FittingsInorder fittingsInorder=ifittingsinorderdao.findById(Long.parseLong(id));
			//使该订单失效
			fittingsInorder.setDelFlag(2);
		if (ifittingsinorderdao.update(fittingsInorder) > 0) {
			req.setAttribute("msg", "删除成功!");
		} else {
			req.setAttribute("msg", "删除失败!");
		}
		} 
		return list(req, null);
 	}
    @RequestMapping("/update.do")
	public ModelAndView update(HttpServletRequest req,FittingsInorder fittingsInorder){
		// 根据ID参数，进行查询！
		String id=req.getParameter("fittingsInorderId");
		if (id != null) {//更新页面初始化
			FittingsInorder fsi = ifittingsinorderdao.findById(Long.valueOf(id));
              return new ModelAndView("fittingsInorder/update","fittingsInorder",fsi);
		} else {
			// 开始更新
			// 计算总价
			int total = fittingsInorder.getCount() * (fittingsInorder.getInPrice());
			fittingsInorder.setTotal((Integer) total);
			if (ifittingsinorderdao.update(fittingsInorder) > 0) {
				req.setAttribute("msg", "更新成功!");
			} else {
				req.setAttribute("msg", "更新失败!");
			}
		}
		return list(req, null);
	}
    
    
    //整车订货单入库
   	@RequestMapping("/inState.do")
   	public ModelAndView inState(HttpServletRequest req) {
   		String id = req.getParameter("id");
   		FittingsStock fittingsstock = null;
   		FittingsInorder fittingsinorder = null;
   		if (id != null) {
   			// 先查出订单信息
   			fittingsinorder = ifittingsinorderdao.findById(Long.valueOf(id));
   			// 在查库存信息
   			fittingsstock = ifittingsstockdao.findByfittingsId(Long.valueOf(fittingsinorder.getFittingsId()));
   		} else {
   			req.setAttribute("msg", "订单ID找不到");
   		    return list(req, null);
   		}
   		// 入库请求
   		// 获取库存配件ID，当不存在该ID时则为新配件
   		if (fittingsstock == null) {
   			// 将新的入库对象进行入库
   			fittingsstock = new FittingsStock();
   			fittingsstock.setCount(fittingsinorder.getCount());
   			fittingsstock.setFittingsId(Long.valueOf(fittingsinorder.getFittingsId()));
   			if (ifittingsstockdao.add(fittingsstock) > 0) {
   				//修改入库日期和入库状态
   				fittingsinorder.setInState(2);
   				fittingsinorder.setInDate(new Date());
   			   if(ifittingsinorderdao.update(fittingsinorder)>0){
   				   req.setAttribute("msg", "新配件入库成功!");
   			   }else{
   				   req.setAttribute("msg","修改入库日期或状态时发生错误!");
   			   }	
   				
   			} else {
   				req.setAttribute("msg", "新配件入库失败!");
   			}
   			return list(req, null);
   		}
   		if (fittingsstock != null) {
   			// 得到新的库存量
   			Integer integer = fittingsinorder.getCount() + (fittingsstock.getCount());
   			fittingsstock.setCount(integer);
   			if (ifittingsstockdao.update(fittingsstock) > 0) {
   				//修改入库日期和状态
   				fittingsinorder.setInState(2);
   				fittingsinorder.setInDate(new Date());
   			   if(ifittingsinorderdao.update(fittingsinorder)>0){
   				   req.setAttribute("msg", "原有配件入库成功!");
   			   }else{
   				   req.setAttribute("msg","修改入库日期或状态时发生错误!");
   			   }
   			} else {
   				req.setAttribute("msg", "原有配件入库失败!");
   			}
   		}

   		return list(req, null);
   	}

    
}
