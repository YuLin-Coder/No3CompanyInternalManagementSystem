package dao.impl;

import java.sql.SQLException;
import java.util.List;

import model.Info;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dao.InfoDao;









public class InfoDaoImpl extends HibernateDaoSupport implements  InfoDao{


	public void deleteBean(Info Info) {
		this.getHibernateTemplate().delete(Info);
		
	}

	public void insertBean(Info Info) {
		this.getHibernateTemplate().save(Info);
		
	}

	@SuppressWarnings("unchecked")
	public Info selectBean(String where) {
		List<Info> list = this.getHibernateTemplate().find("from Info " +where);
		if(list.size()==0){
			return null;
		}
		return list.get(0);
	}

	public int selectBeanCount(String where) {
		long count = (Long)this.getHibernateTemplate().find("select count(*) from Info "+where).get(0);
		return (int)count;
	}

	@SuppressWarnings("unchecked")
	public List<Info> selectBeanList(final int start,final int limit,final String where) {
		return (List<Info>)this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(final Session session)throws HibernateException, SQLException {				
				List<Info> list = session.createQuery("from Info "+where)
				.setFirstResult(start)
				.setMaxResults(limit)
				.list();
				return list;
			}
		});
	}

	public void updateBean(Info Info) {
		this.getHibernateTemplate().update(Info);
		
	}
	
	
}
