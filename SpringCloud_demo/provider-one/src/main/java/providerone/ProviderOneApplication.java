package providerone;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication //表明他是一个springboot项目
@EnableEurekaClient //说明这是一个Eureka服务
@MapperScan("providerone.dao.mapper") //指定要变成实现类的接口所在的包，然后包下面的所有接口在编译之后都会生成相应的实现类

public class ProviderOneApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProviderOneApplication.class, args);
    }

}
