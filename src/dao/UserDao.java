package dao;

import java.util.List;

import model.User;


public interface UserDao  {
	
	
	
	public void insertBean(User User);
	
	public void deleteBean(User User);
	
	public void updateBean(User User);

	public User selectBean(String where);
	
	public List<User> selectBeanList(final int start, final int limit,final String where);
	
	public int selectBeanCount(final String where);
	
	
}
