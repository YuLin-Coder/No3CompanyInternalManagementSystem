package dao.impl;

import java.sql.SQLException;
import java.util.List;

import model.Kaoqin;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dao.KaoqinDao;









public class KaoqinDaoImpl extends HibernateDaoSupport implements  KaoqinDao{


	public void deleteBean(Kaoqin Kaoqin) {
		this.getHibernateTemplate().delete(Kaoqin);
		
	}

	public void insertBean(Kaoqin Kaoqin) {
		this.getHibernateTemplate().save(Kaoqin);
		
	}

	@SuppressWarnings("unchecked")
	public Kaoqin selectBean(String where) {
		List<Kaoqin> list = this.getHibernateTemplate().find("from Kaoqin " +where);
		if(list.size()==0){
			return null;
		}
		return list.get(0);
	}

	public int selectBeanCount(String where) {
		long count = (Long)this.getHibernateTemplate().find("select count(*) from Kaoqin "+where).get(0);
		return (int)count;
	}

	@SuppressWarnings("unchecked")
	public List<Kaoqin> selectBeanList(final int start,final int limit,final String where) {
		return (List<Kaoqin>)this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(final Session session)throws HibernateException, SQLException {				
				List<Kaoqin> list = session.createQuery("from Kaoqin "+where)
				.setFirstResult(start)
				.setMaxResults(limit)
				.list();
				return list;
			}
		});
	}

	public void updateBean(Kaoqin Kaoqin) {
		this.getHibernateTemplate().update(Kaoqin);
		
	}
	
	
}
