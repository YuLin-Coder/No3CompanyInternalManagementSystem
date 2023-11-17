package dao.impl;

import java.sql.SQLException;
import java.util.List;

import model.Tongxunlu;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dao.TongxunluDao;









public class TongxunluDaoImpl extends HibernateDaoSupport implements  TongxunluDao{


	public void deleteBean(Tongxunlu Tongxunlu) {
		this.getHibernateTemplate().delete(Tongxunlu);
		
	}

	public void insertBean(Tongxunlu Tongxunlu) {
		this.getHibernateTemplate().save(Tongxunlu);
		
	}

	@SuppressWarnings("unchecked")
	public Tongxunlu selectBean(String where) {
		List<Tongxunlu> list = this.getHibernateTemplate().find("from Tongxunlu " +where);
		if(list.size()==0){
			return null;
		}
		return list.get(0);
	}

	public int selectBeanCount(String where) {
		long count = (Long)this.getHibernateTemplate().find("select count(*) from Tongxunlu "+where).get(0);
		return (int)count;
	}

	@SuppressWarnings("unchecked")
	public List<Tongxunlu> selectBeanList(final int start,final int limit,final String where) {
		return (List<Tongxunlu>)this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(final Session session)throws HibernateException, SQLException {				
				List<Tongxunlu> list = session.createQuery("from Tongxunlu "+where)
				.setFirstResult(start)
				.setMaxResults(limit)
				.list();
				return list;
			}
		});
	}

	public void updateBean(Tongxunlu Tongxunlu) {
		this.getHibernateTemplate().update(Tongxunlu);
		
	}
	
	
}
