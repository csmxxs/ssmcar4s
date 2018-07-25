package com.zrcx.Dao;
import org.springframework.stereotype.Repository;

import com.zrcx.common.BaseDao;
import com.zrcx.entity.Customer;
@Repository
public class CustomerDao extends BaseDao<Customer> implements ICustomerDao{
	
}
