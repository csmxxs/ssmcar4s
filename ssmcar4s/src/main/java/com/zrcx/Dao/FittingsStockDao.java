package com.zrcx.Dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.zrcx.common.BaseDao;
import com.zrcx.entity.FittingsStock;

/**
 * 配件信息业务层
 * 
 * @author JQS
 * 
 */
@Repository
public class FittingsStockDao extends BaseDao<FittingsStock> implements IFittingsStockDao {

	@Override
	public FittingsStock findByfittingsId(Long id) {
		FittingsStock fittingsstock=null;
		SqlSession session = this.getSqlSession();
		fittingsstock = ((FittingsStock)session.selectOne(this.getNS("findByfittingsId"),id));
		return fittingsstock;
	}

}