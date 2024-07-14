package providerone.service;

import providerone.dao.pojo.User;

import java.util.List;



public interface IUserService {
	/**
	 * 新增用户
	 * @param user
	 */
	public void createUser(User user);
	/**
	 * 查询用户列表
	 * @return
	 */
	public List<User> findAllUser();
	/**
	 * 删除用户
	 * @return
	 */
	void delUser(String id);
	/**
	 * 修改用户
	 * @return
	 */
	void updateUser(User user);
}
