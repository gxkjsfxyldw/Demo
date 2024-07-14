package consumer_ribbon.dao.mapper;

import consumer_ribbon.dao.pojo.User;

import java.util.List;

/**
 *
 * @author Administrator
 *
 */
public interface UserDao {
	/**
	 * 新增用户
	 * @param user
	 */
	void createUser(User user);
	/**
	 * 查询用户列表
	 * @return
	 */
	List<User> findAllUser();
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
