package dao.impl;

import java.sql.SQLException;
import java.util.List;

import model.Wendang;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dao.WendangDao;









public class WendangDaoImpl extends HibernateDaoSupport implements  WendangDao{


	public void deleteBean(Wendang Wendang) {
		this.getHibernateTemplate().delete(Wendang);
		
	}

	public void insertBean(Wendang Wendang) {
		this.getHibernateTemplate().save(Wendang);
		
	}

	@SuppressWarnings("unchecked")
	public Wendang selectBean(String where) {
		List<Wendang> list = this.getHibernateTemplate().find("from Wendang " +where);
		if(list.size()==0){
			return null;
		}
		return list.get(0);
	}

	public int selectBeanCount(String where) {
		long count = (Long)this.getHibernateTemplate().find("select count(*) from Wendang "+where).get(0);
		return (int)count;
	}

	@SuppressWarnings("unchecked")
	public List<Wendang> selectBeanList(final int start,final int limit,final String where) {
		return (List<Wendang>)this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(final Session session)throws HibernateException, SQLException {				
				List<Wendang> list = session.createQuery("from Wendang "+where)
				.setFirstResult(start)
				.setMaxResults(limit)
				.list();
				return list;
			}
		});
	}

	public void updateBean(Wendang Wendang) {
		this.getHibernateTemplate().update(Wendang);
		
	}
	
	
}
