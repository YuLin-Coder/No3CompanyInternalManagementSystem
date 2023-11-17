package dao.impl;

import java.sql.SQLException;
import java.util.List;

import model.Youjian;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dao.YoujianDao;









public class YoujianDaoImpl extends HibernateDaoSupport implements  YoujianDao{


	public void deleteBean(Youjian Youjian) {
		this.getHibernateTemplate().delete(Youjian);
		
	}

	public void insertBean(Youjian Youjian) {
		this.getHibernateTemplate().save(Youjian);
		
	}

	@SuppressWarnings("unchecked")
	public Youjian selectBean(String where) {
		List<Youjian> list = this.getHibernateTemplate().find("from Youjian " +where);
		if(list.size()==0){
			return null;
		}
		return list.get(0);
	}

	public int selectBeanCount(String where) {
		long count = (Long)this.getHibernateTemplate().find("select count(*) from Youjian "+where).get(0);
		return (int)count;
	}

	@SuppressWarnings("unchecked")
	public List<Youjian> selectBeanList(final int start,final int limit,final String where) {
		return (List<Youjian>)this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(final Session session)throws HibernateException, SQLException {				
				List<Youjian> list = session.createQuery("from Youjian "+where)
				.setFirstResult(start)
				.setMaxResults(limit)
				.list();
				return list;
			}
		});
	}

	public void updateBean(Youjian Youjian) {
		this.getHibernateTemplate().update(Youjian);
		
	}
	
	
}
