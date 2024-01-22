package my.utm.ip.ecofootprint.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import my.utm.ip.ecofootprint.Service.ElectricityService;
import my.utm.ip.ecofootprint.Service.UserService;
import my.utm.ip.ecofootprint.Service.WaterService;
import my.utm.ip.ecofootprint.ServiceDatabaseImpl.ElectricityServiceDatabaseImpl;
import my.utm.ip.ecofootprint.ServiceDatabaseImpl.UserServiceDatabaseImpl;
import my.utm.ip.ecofootprint.ServiceDatabaseImpl.WaterServiceDatabaseImpl;
import my.utm.ip.ecofootprint.repository.ElectricityRepository;
import my.utm.ip.ecofootprint.repository.UserRepository;
import my.utm.ip.ecofootprint.repository.WaterRepository;
import my.utm.ip.ecofootprint.repositoryJDBCImpl.ElectricityRepositoryJDBCImpl;
import my.utm.ip.ecofootprint.repositoryJDBCImpl.UserRepositoryJDBCImpl;
import my.utm.ip.ecofootprint.repositoryJDBCImpl.WaterRepositoryJDBCImpl;

@Configuration
public class AppConfig {

    @Bean
    public UserService userService(){
        return new UserServiceDatabaseImpl();
    }

    @Bean 
    UserRepository userRepository(){
        return new UserRepositoryJDBCImpl();
    }
    

   @Bean
    public WaterService waterService(){
        return new WaterServiceDatabaseImpl();
    }

    @Bean 
    WaterRepository waterRepository(){
        return new WaterRepositoryJDBCImpl();
    }

    @Bean
    public ElectricityService electricityServiceDatabaseImpl(){
        return new ElectricityServiceDatabaseImpl();
    }

    @Bean 
    ElectricityRepository electricityRepository(){
        return new ElectricityRepositoryJDBCImpl();
    }


}

