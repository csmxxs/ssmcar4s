package com.zrcx.Dao;

import java.util.List;

import com.zrcx.entity.Menu;

public interface IMenuDao extends IBaseDao<Menu> {
	public abstract List<Menu> getMenusByRoleId(Long roleId);
}