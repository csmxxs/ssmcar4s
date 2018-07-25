package com.zrcx.Dao;
import java.util.Map;

import com.zrcx.entity.User;

public interface IUserDao extends IBaseDao<User> {
    User findUser(Map<String,Object> map);
}
