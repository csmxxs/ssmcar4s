package com.zrcx.Dao;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

import com.zrcx.common.BaseDao;
import com.zrcx.entity.User;
@Repository
public class UserDao extends BaseDao<User> implements IUserDao{

	@Override
	public User findUser(Map<String,Object> map) {
		
		List<User> user = getSqlSession().selectList(this.getNS("findUser"), map);
		if(user.size()>0){
			return user.get(0);
		}else{
			return null;
		}
	} 
}
