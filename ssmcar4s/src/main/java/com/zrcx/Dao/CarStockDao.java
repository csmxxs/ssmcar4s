package com.zrcx.Dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.zrcx.common.BaseDao;
import com.zrcx.entity.CarStock;
 
/**
 * 整车信息业务层
 * @author JQS
 *
 */

@Repository
public class CarStockDao extends BaseDao<CarStock> implements ICarStockDao{
	@Override
	public CarStock findBycarId(Long id) {
		CarStock carstock=null;
		SqlSession session=this.getSqlSession();
		carstock=((CarStock)session.selectOne(this.getNS("findBycarId"),id));
		return carstock;
	}
}
