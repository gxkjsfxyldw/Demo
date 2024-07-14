package consumerhystrix.service.impl;

import consumerhystrix.dao.pojo.User;
import consumerhystrix.service.UserService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
@Component
public class HystricService implements UserService {
    @Override
    public String sayHiFromClientOne(String name) {
        return "服务器开了小差，请休息一会再试！";
    }
    @Override
    public List<User> getUserList(){
        return null;
    }
    @Override
    public String addUser(User user){ return "服务器开了小差，请休息一会再试！";}
    @Override
    public String updateUser(User user){ return "服务器开了小差，请休息一会再试！";}
    @Override
    public String delUser(String id){ return "服务器开了小差，请休息一会再试！";}
}
