package com.zrcx.servlet;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.zrcx.Dao.IUserDao;
import com.zrcx.common.Page;
import com.zrcx.entity.User;

/**
 * 用户的增删改查处理
 * */
@Controller
@RequestMapping(value = "user")
public class UserServlet {

	@Autowired
	private IUserDao basedao;

	/* 用户的查询 */
	@RequestMapping("/list.do")
	public ModelAndView list(HttpServletRequest req, User user) {
		// 分页对象
		Page page = new Page();
		Map<String, Object> param = new HashMap<String, Object>();
		if (user != null) {
			String currentPage = req.getParameter("page");
			String rowsPerPage = req.getParameter("rowsPerPage");
			param.put("username", user.getUsername());
			param.put("name", user.getName());
			param.put("loginFlag", user.getLoginFlag());
			param.put("deptId", user.getDeptId());

			if (currentPage != null) {
				page.setRowsPerPage(Integer.parseInt(rowsPerPage));
				page.setCurrentPage(Integer.parseInt(currentPage));
			}
		}
		param.put("page", page);
		List<User> list = basedao.list(param);
		req.setAttribute("page", page);
		return new ModelAndView("/user/list", "list", list);

	}

	/* 用户的添加 */
	@RequestMapping("/add.do")
	public ModelAndView add(HttpServletRequest req, User user,
			MultipartFile file) // 上传文件会自动绑定到MultipartFile中
			throws Exception {
		// ---------------文件上传处理---------------
		if (!file.isEmpty() && file.getSize() < 10485760000L) {// 文件不为空小于10MB时上传
			// 上传文件路径
			String path = req.getServletContext().getRealPath("/Userimages/");
			System.out.println("上传文件路径:" + path);
			// 得到上传文件名
			String fileName = file.getOriginalFilename();// 获取文件名
			if (fileName.lastIndexOf(".") != -1) {
				// 得到文件后缀名
				String ext = fileName.substring(fileName.lastIndexOf("."),
						fileName.length());
				// 得到新的文件名
				fileName = System.currentTimeMillis() + ext;
			} else {
				System.out.println("没找到后缀名......");
			}
			File filepath = new File(path, fileName);

			if (!filepath.getParentFile().exists()) {
				// 如果不存在文件路径则创建
				filepath.getParentFile().mkdirs();
			}
			// 将上传文件保存到一个目标文件当中
			file.transferTo(new File(path + File.separator + fileName));
			user.setFilePath(fileName);
			if (basedao.add(user) > 0) {
				req.setAttribute("msg", "添加成功!");
				return list(req, null);

			} else {
				req.setAttribute("msg", "添加失败!");
				return list(req, null);
			}
		} else {

			if (file.getSize() > 10485760000L) {
				req.setAttribute("msg", "上传文件过大!添加失败!");
				return list(req, null);
			} else {
				if (basedao.update(user) > 0) {
					req.setAttribute("msg", "添加成功!");
					return list(req, null);

				} else {
					req.setAttribute("msg", "添加失败!");
					return list(req, null);
				}
			}

		}
	}

	/* 用户的删除 */
	@RequestMapping("/delete.do")
	public ModelAndView delete(HttpServletRequest req) {
		String id = req.getParameter("id");
		int i = basedao.delete(Long.parseLong(id));
		if (i > 0) {
			req.setAttribute("msg", "删除成功!");
			return list(req, null);
		} else {
			req.setAttribute("msg", "删除失败!");
			return list(req, null);
		}

	}

	/* 用户更新初始化 */
	@RequestMapping("/update.do")
	public ModelAndView update(HttpServletRequest request) {
		// 根据ID参数，进行查询！
		String id = request.getParameter("id");
		if (id != null) {
			User user = basedao.findById(Long.parseLong(id));
			return new ModelAndView("user/update", "user", user);
		} else {
			request.setAttribute("msg", "用户ID not found");
			return list(request, null);
		}
	}

	/* 用户初始化后,修改信息后开始更新 */
	@RequestMapping("/gotoupdate.do")
	public ModelAndView gotoupdate(HttpServletRequest req, User user,
			MultipartFile file) throws Exception {

		// ---------------文件上传处理---------------
		if (!file.isEmpty() && file.getSize() < 10485760000L) {// 文件不为空小于10MB时上传
			// 上传文件路径
			String path = req.getServletContext().getRealPath("/Userimages/");
			System.out.println("上传文件路径:" + path);
			// 得到上传文件名
			String fileName = file.getOriginalFilename();// 获取文件名
			if (fileName.lastIndexOf(".") != -1) {
				// 得到文件后缀名
				String ext = fileName.substring(fileName.lastIndexOf("."),
						fileName.length());
				// 得到新的文件名
				fileName = System.currentTimeMillis() + ext;
			} else {
				req.setAttribute("msg", "文件格式不正确!");
				return list(req, null);
			}

			File filepath = new File(path, fileName);
			if (!filepath.getParentFile().exists()) {
				// 如果不存在文件路径则创建
				filepath.getParentFile().mkdirs();
			}
			// 将上传文件保存到一个目标文件当中
			file.transferTo(new File(path + File.separator + fileName));
			System.out.println("修改后文件名:" + fileName);
			user.setFilePath(fileName);
			if (basedao.update(user) > 0) {
				req.setAttribute("msg", "修改成功!");
				return list(req, null);

			} else {
				req.setAttribute("msg", "修改失败!");
				return list(req, null);
			}
		} else {
			if (file.getSize() > 10485760000L) {
				req.setAttribute("msg", "上传文件过大!");
				return list(req, null);
			} else {
				if (basedao.update(user) > 0) {
					req.setAttribute("msg", "修改成功!");
					return list(req, null);

				} else {
					req.setAttribute("msg", "修改失败!");
					return list(req, null);
				}
			}

		}
	}
}