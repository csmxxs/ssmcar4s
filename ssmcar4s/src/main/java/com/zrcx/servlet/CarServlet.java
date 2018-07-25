package com.zrcx.servlet;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.zrcx.Dao.ICarDao;
import com.zrcx.common.Page;
import com.zrcx.entity.Car;

/**
 * 整车信息管理
 * */

@Controller
@RequestMapping(value = "car")
public class CarServlet {
	@Autowired
	private ICarDao icardao;

	@RequestMapping("/list.do")
	public ModelAndView list(HttpServletRequest req, Car car) {
		
		// 创建分页对象
		Page p = new Page();
		Map<String, Object> param = new HashMap<String, Object>();
		if (car != null) {
			String currentPage = req.getParameter("page");
			String rowsPerPage = req.getParameter("rowsPerPage");
			param.put("brand", car.getBrand());
			param.put("series", car.getSeries());
			param.put("type", car.getType());
			param.put("volume", car.getVolume());
			// 为p对象属性赋值(当前是第几页,初始值为1)
			if (currentPage != null) {
				p.setRowsPerPage(Integer.parseInt(rowsPerPage));
				p.setCurrentPage(Integer.parseInt(currentPage));
			}
		}
		// 得到总行数
		param.put("page", p);
		List<Car> list = icardao.list(param);
		req.setAttribute("page", p);
		return new ModelAndView("/car/list", "list", list);

	}

	@RequestMapping("/slist.do")
	public ModelAndView slist(HttpServletRequest req, Car car) {
		Page p = null;
		// 进行页面分页请求
		// 创建分页对象
		if (p == null) {
			p = new Page();
		}
		Map<String, Object> param = new HashMap<String, Object>();

		// 对应页面有个隐藏域,用来判断是否有数据传入,当有数据传入时执行这一步
		if (car != null) {
			String currentPage = req.getParameter("page");
			String rowsPerPage = req.getParameter("rowsPerPage");
			param.put("brand", car.getBrand());
			param.put("series", car.getSeries());
			param.put("type", car.getType());
			param.put("volume", car.getVolume());
			// 为p对象属性赋值(当前是第几页,初始值为1)
			if (currentPage != null) {
				p.setRowsPerPage(Integer.parseInt(rowsPerPage));
				p.setCurrentPage(Integer.parseInt(currentPage));
			}
		}
		// 把得到的p对象放到集合里,传到dao层
		param.put("page", p);
		// 为p对象属性赋值,调用分页方法,得到总行数
		p.setTotalRows(icardao.list(param).size());
		List<Car> list = icardao.list(param);
		req.setAttribute("page", p);
		return new ModelAndView("car/slist", "list", list);

	}

	@RequestMapping("/add.do")
	public ModelAndView add(HttpServletRequest req, Car car, @RequestParam(value="file")MultipartFile file)
			throws Exception {
		// ---------------文件上传处理---------------
		if (!file.isEmpty() && file.getSize() < 10485760000L) {// 文件不为空小于10MB时上传
			// 上传文件路径
			String path = req.getServletContext().getRealPath("/Carimages/");
			// 上传文件名
			String fileName = file.getOriginalFilename();// 获取文件名
			if (fileName.lastIndexOf(".")!=-1) {
				// 得到文件后缀名
				String ext=fileName.substring(fileName.lastIndexOf("."), fileName.length());
				fileName =System.currentTimeMillis() + ext;
				car.setFilePath(fileName);
			}
			File filepath = new File(path, fileName);
			if (!filepath.getParentFile().exists()) {
				// 如果不存在文件路径则创建
				filepath.getParentFile().mkdirs();
			}
			// 将上传文件保存到一个目标文件当中
			file.transferTo(new File(path + File.separator + fileName));
			if (icardao.add(car) > 0) {
				req.setAttribute("msg", "添加成功!");
			} else {
				req.setAttribute("msg", "添加失败!");
			}
			
			return list(req, null);
		} else {
			if (file.getSize() > 10485760000L) {
				req.setAttribute("msg", "上传文件过大!添加失败!");
				return list(req, null);
			} else {
				if (icardao.update(car) > 0) {
					req.setAttribute("msg", "添加成功!");
					return list(req, null);

				} else {
					req.setAttribute("msg", "添加失败!");
					return list(req, null);
				}
			}

		}

	}

	@RequestMapping("/delete.do")
	public ModelAndView delete(HttpServletRequest req) {
		String id = req.getParameter("id");
		Car car=null;
		if (id != null) {
		    car=icardao.findById(Long.valueOf(id));
			if (car!=null) {
				car.setDelFlag(2);
				if(icardao.update(car)>0){
					req.setAttribute("msg", "删除成功!");
				}else{
					req.setAttribute("msg", "删除失败!");
				}
				
				return list(req, null);
			} else {
				req.setAttribute("msg", "找不到该车信息,删除失败!");
				return list(req, null);
			}
		} else {
			req.setAttribute("msg", "ID丢失，删除失败!");
			return list(req, null);
		}

	}

	@RequestMapping("/update.do")
	public ModelAndView update(HttpServletRequest req) {
		// 根据ID参数，进行查询！
		String id = req.getParameter("id");
		if (id != null) {
			Car car = icardao.findById(Long.parseLong(id));
			return new ModelAndView("car/update", "car", car);
		} else {
			req.setAttribute("msg", "ID not found");
			return list(req, null);
		}
	}

	/* 初始化后,修改信息后开始更新 */
	@RequestMapping("/gotoupdate.do")
	public ModelAndView gotoupdate(HttpServletRequest req, Car car,
			@RequestParam(value="file")MultipartFile file) throws Exception {
		
		 car.setDelFlag(1);//默认不允许删除
		// ---------------文件上传处理---------------
		if (!file.isEmpty() && file.getSize() < 10485760000L) {// 文件不为空小于10MB时上传
			// 上传文件路径
			String path = req.getServletContext().getRealPath("/Carimages/");
			System.out.println("上传文件路径:" + path);
			// 得到上传文件名
			String fileName = file.getOriginalFilename();// 获取文件名
			if (fileName.lastIndexOf(".") != -1) {
				// 得到文件后缀名
				String ext = fileName.substring(fileName.lastIndexOf("."),
						fileName.length());
				// 得到新的文件名
				fileName = System.currentTimeMillis() + ext;
				car.setFilePath(fileName);
			
			}
			File filepath = new File(path, fileName);
			if (!filepath.getParentFile().exists()) {
				// 如果不存在文件路径则创建
				filepath.getParentFile().mkdirs();
			}
			// 将上传文件保存到一个目标文件当中
			file.transferTo(new File(path + File.separator + fileName));
			if (icardao.update(car) > 0) {
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
				if (icardao.update(car) > 0) {
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
