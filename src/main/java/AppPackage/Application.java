package AppPackage;

import DatabasePackage.DepartmentEntity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Date;
import java.util.List;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        if(true) {
            DatabaseProvider databaseProvider = new DatabaseProvider();
            databaseProvider.GetCalendar(new Date(2019, 4, 3), new Date(2019, 6, 5));
            List<DepartmentEntity> temp = databaseProvider.GetDepartments();
            System.out.println(temp);
        }
    }
}
