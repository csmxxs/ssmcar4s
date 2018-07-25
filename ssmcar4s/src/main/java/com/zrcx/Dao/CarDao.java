package com.zrcx.Dao;

import org.springframework.stereotype.Repository;

import com.zrcx.common.BaseDao;
import com.zrcx.entity.Car;

/**
 * 汽车dao层
 * @author JQS
 *
 */
@Repository
public class CarDao extends BaseDao<Car> implements ICarDao {
	
}
