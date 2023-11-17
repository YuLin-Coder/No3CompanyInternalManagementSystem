package dao.impl;

import java.sql.SQLException;
import java.util.List;

import model.Bumen;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dao.BumenDao;









public class BumenDaoImpl extends HibernateDaoSupport implements  BumenDao{


	public void deleteBean(Bumen Bumen) {
		this.getHibernateTemplate().delete(Bumen);
		
	}

	public void insertBean(Bumen Bumen) {
		this.getHibernateTemplate().save(Bumen);
		
	}

	@SuppressWarnings("unchecked")
	public Bumen selectBean(String where) {
		List<Bumen> list = this.getHibernateTemplate().find("from Bumen " +where);
		if(list.size()==0){
			return null;
		}
		return list.get(0);
	}

	public int selectBeanCount(String where) {
		long count = (Long)this.getHibernateTemplate().find("select count(*) from Bumen "+where).get(0);
		return (int)count;
	}

	@SuppressWarnings("unchecked")
	public List<Bumen> selectBeanList(final int start,final int limit,final String where) {
		return (List<Bumen>)this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(final Session session)throws HibernateException, SQLException {				
				List<Bumen> list = session.createQuery("from Bumen "+where)
				.setFirstResult(start)
				.setMaxResults(limit)
				.list();
				return list;
			}
		});
	}

	public void updateBean(Bumen Bumen) {
		this.getHibernateTemplate().update(Bumen);
		
	}
	
	
}
