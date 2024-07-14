package providerone.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import providerone.dao.mapper.UserDaoMapper;
import providerone.dao.pojo.User;
import providerone.service.IUserService;

import java.util.List;


@Service
@Component
public class UserServiceImpl implements IUserService {
	@Autowired
	public UserDaoMapper userDao;
	@Override
	public void createUser(User user) {
		userDao.createUser(user);
	}
	@Override
	public List<User> findAllUser() {
		return userDao.findAllUser();
	}
	@Override
	public void delUser(String id) { userDao.delUser(id);}
	@Override
	public void updateUser(User user) { userDao.updateUser(user);}
}
