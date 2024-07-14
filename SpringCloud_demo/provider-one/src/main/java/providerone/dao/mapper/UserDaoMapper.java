package providerone.dao.mapper;
import providerone.dao.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

/**
 *
 * @author Administrator
 *
 */
@Mapper
public interface UserDaoMapper {
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
