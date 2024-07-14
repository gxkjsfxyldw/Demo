package consumerhystrix.service;

import consumerhystrix.dao.pojo.User;
import consumerhystrix.service.impl.HystricService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

/**
 *  添加指定fallback类，在服务熔断的时候返回fallback类中的内容。
 *  name:远程服务名，即spring.application.name配置的名称
 *  此类中的方法和远程服务中contoller中的方法名和参数需保持一致。
 */

//通过@ FeignClient（“服务名”），来指定调用哪个服务，@GetMapping("接口名")，来向接口发送 Get 请求，@RequestParam 是请求参数
//fallback指向熔断实现类HystricService.java，当服务不可用时会执行熔断实现类
@Service
@Primary
@FeignClient(value = "provider-user",fallback = HystricService.class)
public interface  UserService {
    @GetMapping("/user/hi")
    String sayHiFromClientOne(@RequestParam(value = "name") String name); //注意一定要加上value  Maven版本太低导致
    @GetMapping("/user/userList")
    List<User> getUserList();
    @GetMapping("/user/add")
    String addUser(User user);
    @GetMapping("/user/updateUser")
    String updateUser(User user);
    @GetMapping("/user/delUser")
    String delUser(@RequestParam(value = "id") String id);
}
