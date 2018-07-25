package com.zrcx.servlet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zrcx.Dao.IDeptDao;
import com.zrcx.common.Page;
import com.zrcx.entity.Dept;

@Controller
@RequestMapping("dept")
public class DeptServlet {
    @Autowired
     private  IDeptDao ideptdao;
    @RequestMapping("/list.do")
	public ModelAndView list(HttpServletRequest req, Dept dept){
    	
    	Page page=new Page();
		Map<String,Object> param = new HashMap<String,Object>();
    	if(dept!=null){
    		String currentPage=req.getParameter("page");
    		String rowsPerPage=req.getParameter("rowsPerPage");
			param.put("name", dept.getName());
			param.put("charger",dept.getCharger());
			param.put("contactTel",dept.getContactTel());
			if(currentPage!=null){
				//分页
			   page.setCurrentPage(Integer.valueOf(currentPage));
			   page.setRowsPerPage(Integer.valueOf(rowsPerPage));
			}
    	}
		param.put("page",page);
		//把集合带到页面显示
        req.setAttribute("page",page);
        List<Dept> list = ideptdao.list(param);
        //请求转发
        return new ModelAndView("dept/list","list",list);
	}
    @RequestMapping("/add.do")
	public ModelAndView add(HttpServletRequest req,Dept dept){
       if(dept!=null){
    	   
    		if(ideptdao.add(dept)>0){
    			req.setAttribute("msg","新增成功");
    		}else{
    			req.setAttribute("msg","新增失败");
    		}
       }
       return list(req,null);
		
	}
    @RequestMapping("/delete.do")
	public ModelAndView delete(HttpServletRequest req){
    	
		String id = req.getParameter("id");
		if(id != null){
			if(ideptdao.delete(Long.valueOf(id))>0){
				req.setAttribute("msg","删除成功");
			}else{
				req.setAttribute("msg","删除失败");
			}
			
		}
		return  list(req,null);
	}
	//更新(业务模型-MVC中的M)
    @RequestMapping("/update.do")
	public ModelAndView update(HttpServletRequest req,Dept dept){
        String id = req.getParameter("deptId");
		if(id != null){//初始化更新页面
		    dept = ideptdao.findById(Long.valueOf(id));
			return new ModelAndView("dept/update","dept",dept);
		}else{//更新提交

			if(ideptdao.update(dept)>0){
				req.setAttribute("msg","更新成功");
			}else{
				req.setAttribute("msg","更新失败");
			}
			
		}
      return list(req, null);
    }

}
