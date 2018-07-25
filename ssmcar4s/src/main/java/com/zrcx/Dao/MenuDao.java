package com.zrcx.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.zrcx.common.BaseDao;
import com.zrcx.entity.Menu;

/**
 * 菜单操作Dao类
 * @author jqs
 */
@Repository
public class MenuDao extends BaseDao<Menu> implements IMenuDao{

	/**
	 * 根据角色ID查询菜单列表
	 * @param param
	 * @return
	 */
	@Override
	public List<Menu> getMenusByRoleId(Long roleId) {
		List<Menu> list = new ArrayList<Menu>();
		list=this.getSqlSession().selectList(this.getNS("getMenusByRoleId"), roleId);		
		return list;
	}

}
