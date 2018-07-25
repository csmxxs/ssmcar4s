package com.zrcx.servlet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zrcx.Dao.IFeedbackDao;
import com.zrcx.common.Page;
import com.zrcx.entity.Feedback;

/**
 * 客户反馈控制层
 * 
 * */
@Controller
@RequestMapping("feedback")
public class FeedbackServlet {

	@Autowired
	private IFeedbackDao ifeedbackdao;

	@RequestMapping("/list.do")
	public ModelAndView list(HttpServletRequest req, Feedback feedback) {

		Page page = new Page();
		Map<String, Object> param = new HashMap<String, Object>();
		if (feedback != null) {
			String currentPage = req.getParameter("page");
			String rowsPerPage = req.getParameter("rowsPerPage");
			param.put("title", feedback.getTitle());
			param.put("customername", feedback.getCustomername());
			if (currentPage != null) {
				page.setCurrentPage(Integer.valueOf(currentPage));
				page.setRowsPerPage(Integer.valueOf(rowsPerPage));

			}
		}
		param.put("page", page);
		List<Feedback> list = ifeedbackdao.list(param);
		req.setAttribute("page", page);
		return new ModelAndView("feedback/list", "list", list);

	}

	@RequestMapping("/add.do")
	public ModelAndView add(HttpServletRequest req, Feedback feedback) {
		if (feedback != null) {
			if (ifeedbackdao.add(feedback) > 0) {
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
			if (ifeedbackdao.delete(Long.valueOf(id)) > 0) {
				req.setAttribute("msg", "删除成功!");
			} else {
				req.setAttribute("msg", "删除失败!");
			}
		}

		return list(req, null);
	}

	@RequestMapping("/update.do")
	public ModelAndView update(HttpServletRequest req, Feedback feedback) {
		// 根据ID参数，进行查询！
		String id = req.getParameter("feedbackId");
		if (id != null) {
			// 调用方法,更新初始化
			feedback = ifeedbackdao.findById(Long.valueOf(id));
			return new ModelAndView("feedback/update", "feedback", feedback);
		} else {
			// 开始更新
			if (ifeedbackdao.update(feedback) > 0) {
				req.setAttribute("msg", "更新成功!");

			} else {
				req.setAttribute("msg", "更新失败!");
			}
			return list(req, null);
		}
	}
}
