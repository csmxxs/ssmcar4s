package com.zrcx.Dao;

import com.zrcx.entity.Role;

public interface IRoleDao extends IBaseDao<Role>{
   public abstract int addRole2Menu(long roleId,long menuId);
   public abstract int deleteRole2Menu(long roleId,long menuId);
}