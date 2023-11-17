package dao.impl;

import java.sql.SQLException;
import java.util.List;

import model.Renwu;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dao.RenwuDao;









public class RenwuDaoImpl extends HibernateDaoSupport implements  RenwuDao{


	public void deleteBean(Renwu Renwu) {
		this.getHibernateTemplate().delete(Renwu);
		
	}

	public void insertBean(Renwu Renwu) {
		this.getHibernateTemplate().save(Renwu);
		
	}

	@SuppressWarnings("unchecked")
	public Renwu selectBean(String where) {
		List<Renwu> list = this.getHibernateTemplate().find("from Renwu " +where);
		if(list.size()==0){
			return null;
		}
		return list.get(0);
	}

	public int selectBeanCount(String where) {
		long count = (Long)this.getHibernateTemplate().find("select count(*) from Renwu "+where).get(0);
		return (int)count;
	}

	@SuppressWarnings("unchecked")
	public List<Renwu> selectBeanList(final int start,final int limit,final String where) {
		return (List<Renwu>)this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(final Session session)throws HibernateException, SQLException {				
				List<Renwu> list = session.createQuery("from Renwu "+where)
				.setFirstResult(start)
				.setMaxResults(limit)
				.list();
				return list;
			}
		});
	}

	public void updateBean(Renwu Renwu) {
		this.getHibernateTemplate().update(Renwu);
		
	}
	
	
}
