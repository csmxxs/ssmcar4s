package com.zrcx.Dao;

import org.springframework.stereotype.Repository;

import com.zrcx.common.BaseDao;
import com.zrcx.entity.Feedback;
@Repository
public class FeedbackDao extends BaseDao<Feedback> implements IFeedbackDao{
	
	
	
	
	/*public List<Feedback> list(Map<String, Object> param) {

		List<Feedback> list = new ArrayList<Feedback>();
		ResultSet rs = null;
		try{
		
		if (param == null) {
			return list;
		}
		String sql = "select a.*,b.name customername,b.contact_tel customertel "
				+ "from t_4s_feedback a,t_4s_customer b where a.customer_id=b.id ";
		String title = (String) param.get("title");
		if (title != null && !title.equals("")) {
			sql += " and title like '%" + title + "%'";
		}		
		String customername = (String) param.get("customername");
		if (customername != null && !customername.equals("")) {
			sql += " and b.name like '%" + customername + "%'";
		}
		//被删除的信息不进行查询
		sql+=" and del_Flag="+1;
		// 判断是否要分页
		sql = this.getPageSql(sql, (Page) param.get("page"));
		Feedback u = null;
	
		rs = this.query(sql);
			while (rs.next()) {
				u = new Feedback();
				u.setId(rs.getLong("id"));
				u.setTitle(rs.getString("title"));
				u.setInfo(rs.getString("info"));
				u.setCustomer_id(rs.getInt("customer_id"));
				u.setCustomername(rs.getString("customername"));
				u.setCustomertel(rs.getString("customertel"));
				u.setCreate_date(rs.getDate("create_date"));
				list.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close(rs);
		}

		return list;
	}

	public Feedback getObjByID(long id) {
		Feedback u = null;
		String sql = "select a.*,b.name customername,b.contact_tel customertel "
				+ "from t_4s_feedback a,t_4s_customer b where a.customer_id=b.id and a.id=" + id;
		ResultSet rs = null;
		rs = this.query(sql);
		try {
			if (rs.next()) {
				u = new Feedback();
				u.setId(rs.getLong("id"));
				u.setTitle(rs.getString("title"));				
				u.setInfo(rs.getString("info"));
				u.setCustomer_id(rs.getInt("customer_id"));
				u.setCustomername(rs.getString("customername"));
				u.setCustomertel(rs.getString("customertel"));
				u.setCreate_date(rs.getDate("create_date"));
			}
		} catch (SQLException e) {
			System.out.println("根据ID查询出现异常......");
		} finally {
			this.close(rs);
		}
		return u;
	}

	public int delete(Long id) {
		int i = 0;
		String sql = "delete from t_4s_feedback where id=" + id;
		i = this.updatesql(sql);
		return i;
	}

	public int add(Feedback feedback) {
		int i = 0;
		String sql = " insert into t_4s_feedback(title,customer_id,info,create_date) "
				+ "values('"
				+ feedback.getTitle()
				+ "',"
				+ feedback.getCustomer_id()
				+ ",'"
				+ feedback.getInfo()
			    + "',now()) ";
		i = this.updatesql(sql);
		return i;

	}

	public int update(Feedback feedback) {

		int i = 0;
		try {
			if (feedback == null || feedback.getId() == 0) {
			return i;
		}
		String sql = " update t_4s_feedback set id=id ";
		if (feedback.getTitle() != null && !feedback.getTitle().equals("")) {
			sql += " ,title='" + feedback.getTitle() + "'";
		}
		if (feedback.getInfo() != null && !feedback.getInfo().equals("")) {
			sql += " ,info='" + feedback.getInfo() + "'";
		}
		
		if (feedback.getCustomer_id() != 0) {
			sql += " ,customer_id=" + feedback.getCustomer_id();
		}
		sql += " where id=" + feedback.getId();
		i = this.updatesql(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return i;
	}

	

*/
}
