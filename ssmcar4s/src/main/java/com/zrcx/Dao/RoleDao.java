package com.zrcx.Dao;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.zrcx.common.BaseDao;
import com.zrcx.entity.Role;
/**
 * 角色业务层
 * @author jqs
 *
 */
@Repository
public class RoleDao extends BaseDao<Role> implements IRoleDao {
	//增加角色和菜单关系
	@Override
	public int addRole2Menu(long roleId, long menuId) {
	    Map<String,Object>param=new HashMap<String,Object>();
	    param.put("roleId", roleId);
	    param.put("menuId", menuId);
		return this.getSqlSession().insert(this.getNS("addRole2Menu"), param);
	}

	@Override
	public int deleteRole2Menu(long roleId, long menuId) {
	    Map<String,Object>param=new HashMap<String,Object>();
	    param.put("roleId", roleId);
	    param.put("menuId", menuId);
	    return this.getSqlSession().insert(this.getNS("deleteRole2Menu"), param);
	}
}
