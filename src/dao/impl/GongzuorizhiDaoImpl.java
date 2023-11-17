package dao.impl;

import java.sql.SQLException;
import java.util.List;

import model.Gongzuorizhi;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dao.GongzuorizhiDao;









public class GongzuorizhiDaoImpl extends HibernateDaoSupport implements  GongzuorizhiDao{


	public void deleteBean(Gongzuorizhi Gongzuorizhi) {
		this.getHibernateTemplate().delete(Gongzuorizhi);
		
	}

	public void insertBean(Gongzuorizhi Gongzuorizhi) {
		this.getHibernateTemplate().save(Gongzuorizhi);
		
	}

	@SuppressWarnings("unchecked")
	public Gongzuorizhi selectBean(String where) {
		List<Gongzuorizhi> list = this.getHibernateTemplate().find("from Gongzuorizhi " +where);
		if(list.size()==0){
			return null;
		}
		return list.get(0);
	}

	public int selectBeanCount(String where) {
		long count = (Long)this.getHibernateTemplate().find("select count(*) from Gongzuorizhi "+where).get(0);
		return (int)count;
	}

	@SuppressWarnings("unchecked")
	public List<Gongzuorizhi> selectBeanList(final int start,final int limit,final String where) {
		return (List<Gongzuorizhi>)this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(final Session session)throws HibernateException, SQLException {				
				List<Gongzuorizhi> list = session.createQuery("from Gongzuorizhi "+where)
				.setFirstResult(start)
				.setMaxResults(limit)
				.list();
				return list;
			}
		});
	}

	public void updateBean(Gongzuorizhi Gongzuorizhi) {
		this.getHibernateTemplate().update(Gongzuorizhi);
		
	}
	
	
}
